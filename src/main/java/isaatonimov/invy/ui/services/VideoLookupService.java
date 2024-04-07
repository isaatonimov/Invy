package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.models.invidious.SearchResponse;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.concurrent.Task;

import java.io.IOException;
import java.util.List;

public class VideoLookupService extends LookupService<SearchResponse>
{
	private InvidiousInstance 	targetInstance;
	private Recording 		toLookUp;

	public VideoLookupService(InvidiousInstance targetInstance)
	{
		this.targetInstance 	= targetInstance;
		this.toLookUp		= toLookUp;
	}

	public void AddToLookUp(Recording record)
	{
		this.toLookUp = record;
	}
	@Override
	protected Task createTask()
	{
		List<SearchResponse> response = null;

		try
		{
			response = targetInstance.search(toLookUp);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		List<SearchResponse> finalResponse = response;
		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{
				return finalResponse;
			}
		};
	}
}
