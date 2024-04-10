package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.core.invidious.PipedInstance;
import isaatonimov.invy.exceptions.SearchQueryEmptyException;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.piped.AudioStream;
import javafx.concurrent.Task;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AudioStreamLookupService extends LookupService<URL>
{
	private Controller		controller;
	private InvidiousInstance 	invidiousInstance;
	private PipedInstance		pipedInstance;
	private Recording		query;

	public AudioStreamLookupService(Controller controller)
	{
		this.controller		= controller;
		this.invidiousInstance 	= controller.getInvidiousInstance();
		this.pipedInstance		= controller.getPipedInstance();
	}

	public void updateQuery(Recording query)
	{
		//Fallback
		if(query == null)
			controller.getRecommendationsView().getSelectionModel().getSelectedItem();

		this.query = query;
	}

	@Override
	protected Task createTask()
	{
		if(pipedInstance == null)
			pipedInstance = controller.getPipedInstance();
		if(invidiousInstance == null)
			invidiousInstance = controller.getInvidiousInstance();

		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{
				URL response = null;

				try
				{
					if(query != null)
					{
						System.out.println("Searching for IDs with piped -> " + query.getTitle());
						List<String> IDs = pipedInstance.search(query);

						//currently just picks first id then picks stream
						List<AudioStream> streams = pipedInstance.getAudioStreamsByVideoID(IDs.getFirst());
						//Does the same for streams, does not prioritize high quality for example



						response = new URL(streams.getFirst().getUrl());
					}
					else
						throw new SearchQueryEmptyException();
				}
				catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				catch (SearchQueryEmptyException e)
				{
					throw new RuntimeException(e);
				}

				return response;
			}
		};
	}
}
