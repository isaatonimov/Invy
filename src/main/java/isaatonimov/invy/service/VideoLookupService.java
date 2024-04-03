package isaatonimov.invy.service;

import isaatonimov.invy.invidious.InvidiousInstance;
import isaatonimov.invy.invidious.VideoResult;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.util.List;

public class VideoLookupService extends Service
{
	private InvidiousInstance targetInstance;
	private String searchTerm;
	public VideoLookupService(InvidiousInstance targetInstance, String searchTerm)
	{
		this.targetInstance = targetInstance;
		this.searchTerm = searchTerm;
	}

	public void updateSearchTerm(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	@Override
	protected Task createTask()
	{
		List<VideoResult> response = null;

		try
		{
			response = targetInstance.search(searchTerm);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		List<VideoResult> finalResponse = response;
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
