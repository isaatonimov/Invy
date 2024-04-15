package isaatonimov.invy.ui.services;

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
	private PipedInstance		pipedInstance;
	private Recording		query;

	public AudioStreamLookupService(PipedInstance pipedInstance)
	{
		this.pipedInstance		= pipedInstance;
	}

	public void updateQuery(Recording query)
	{
		this.query = query;
	}

	@Override
	protected Task createTask()
	{
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
						//Does the same for streams, does not prioritize high quality

						for(var stream : streams)
						{
							System.out.println("Stream Quality:" + stream.getQuality() + "for -> " + stream.getUrl());
						}

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
