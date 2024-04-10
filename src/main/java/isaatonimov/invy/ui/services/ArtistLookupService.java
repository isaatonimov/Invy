package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.musicbrainz.MusicBrainzInstance;
import isaatonimov.invy.models.musicbrainz.Artist;
import javafx.concurrent.Task;

import java.util.LinkedList;

public class ArtistLookupService extends LookupService<LinkedList<Artist>>
{
	private String query;
	public ArtistLookupService()
	{
		this.query = "";
	}

	public void updateQuery(String query)
	{
		this.query = query;
	}

	@Override
	protected Task createTask()
	{
		return new Task()
		{
			@Override
			protected LinkedList<Artist> call() throws Exception
			{
				System.out.println(">Artist Lookup Service Starting....");
				System.out.println(">Search query: " + query);
				LinkedList<Artist> top5 = MusicBrainzInstance.searchForFirstXArtists(query, 5);

				return top5;
			}
		};
	}
}
