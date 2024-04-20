package isaatonimov.invy.services.background;

import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.base.BackgroundHelperService;
import javafx.beans.property.SimpleObjectProperty;

import java.io.IOException;
import java.util.LinkedList;

public class RecordingLookupService extends BackgroundHelperService
{
	public SimpleObjectProperty<Artist> CurrentTargetArtistProperty = new SimpleObjectProperty<>();

	@Override
	protected Object ServiceSpecificDo()
	{
		System.out.println("Recording Lookup Service Starting....");

		LinkedList<Recording> recordings 	= new LinkedList<>();
		try
		{
			recordings.addAll(MusicBrainz.searchForSongs(CurrentTargetArtistProperty.get()));
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		return recordings;
	}

	@Override
	protected boolean ServiceSpecificOnSuccessDo()
	{
		System.out.println("Recording Lookup Service Finished Successfully....");
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnFailureDo()
	{
		System.out.println("Recording Lookup Service Finished Failed....");
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
