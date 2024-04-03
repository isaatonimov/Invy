package isaatonimov.invy.service;

import isaatonimov.invy.musicbrainz.MusicBrainzHelper;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class RecordingLookupService extends Service
{
	private String searchTerm;
	public RecordingLookupService(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public void updateSearchTerm(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	@Override
	protected Task createTask()
	{
		List<String> response = null;


		response = MusicBrainzHelper.searchForSongs(searchTerm);

		List<String> finalResponse = response;
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
