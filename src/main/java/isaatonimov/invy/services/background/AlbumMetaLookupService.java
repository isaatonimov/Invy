package isaatonimov.invy.services.background;

import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.exceptions.NoReleasesFoundException;
import isaatonimov.invy.models.musicbrainz.Release;
import isaatonimov.invy.services.base.BackgroundHelperService;
import isaatonimov.invy.services.base.Interruptable;
import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;

public class AlbumMetaLookupService extends BackgroundHelperService implements Interruptable
{
	public SimpleStringProperty QueryProperty = new SimpleStringProperty("");

	@Override
	protected Object ServiceSpecificDo()
	{
		System.out.println("Search query for Album: " + QueryProperty.get());

		LinkedList<Release> top5 = null;

		try
		{
			top5 = MusicBrainz.searchForFirstXReleases(QueryProperty.get(), 10);
		} catch (NoReleasesFoundException e)
		{

		} catch (InterruptedException e)
		{

		}

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
