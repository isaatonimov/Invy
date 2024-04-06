package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.core.invidious.VideoResult;
import javafx.concurrent.Task;

import java.io.IOException;
import java.util.List;

public class VideoLookupService extends LookupService
{
	private InvidiousInstance targetInstance;
	public VideoLookupService(InvidiousInstance targetInstance)
	{
		this.targetInstance = targetInstance;
	}
	@Override
	protected Task createTask()
	{
		List<VideoResult> response = null;

		try
		{
			response = targetInstance.search(super.lookupSearchTerm.get());
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
