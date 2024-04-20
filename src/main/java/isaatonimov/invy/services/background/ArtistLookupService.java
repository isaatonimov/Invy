package isaatonimov.invy.services.background;

import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.services.base.BackgroundHelperService;
import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;

public class ArtistLookupService extends BackgroundHelperService
{
	public SimpleStringProperty QueryProperty = new SimpleStringProperty("");

	@Override
	protected Object ServiceSpecificDo()
	{
		System.out.println("Search query: " + QueryProperty.get());
		LinkedList<Artist> top5 = MusicBrainz.searchForFirstXArtists(QueryProperty.get(), 5);

		return top5;
	}

	@Override
	protected boolean ServiceSpecificOnSuccessDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnFailureDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnInterruptionDo()
	{
		return false;
	}

	@Override
	protected boolean ServerSpecificOnRunningDo()
	{
		return false;
	}

	@Override
	protected void ServiceSpecificOnValuePropertyChanged()
	{

	}
}
