package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.musicbrainz.MusicBrainzInstance;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.concurrent.Task;

import java.util.LinkedList;

public class RecordingLookupService extends LookupService<LinkedList<Recording>>
{
	Artist artist;
	public RecordingLookupService()
	{
	}

	public void updateArtist(Artist artist)
	{
		this.artist = artist;
	}

	@Override
	protected Task createTask()
	{
		return new Task()
		{
			@Override
			protected LinkedList<Recording> call() throws Exception
			{
				System.out.println("Recording Lookup Service Starting....");

				LinkedList<Recording> recordings 	= new LinkedList<>();
				recordings.addAll(MusicBrainzInstance.searchForSongs(artist));

				return recordings;
			}
		};
	}
}
