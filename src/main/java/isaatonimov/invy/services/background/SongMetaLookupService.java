package isaatonimov.invy.services.background;

import com.sun.codemodel.JForEach;
import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.exceptions.NoArtistFoundException;
import isaatonimov.invy.exceptions.NoRecordingsFoundException;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.base.BackgroundHelperService;
import isaatonimov.invy.services.base.Interruptable;
import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;

public class SongMetaLookupService extends BackgroundHelperService implements Interruptable
{
	public SimpleStringProperty QueryProperty = new SimpleStringProperty("");

	@Override
	protected Object ServiceSpecificDo()
	{
		System.out.println("Search query for Song: " + QueryProperty.get());

		LinkedList<Recording> top = null;

		try
		{
			top = MusicBrainz.searchForFirstXRecordings(QueryProperty.get(), 10);
		}
		catch (NoRecordingsFoundException e)
		{

		} catch (InterruptedException e)
		{

		}

		return top;
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
