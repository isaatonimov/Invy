package isaatonimov.invy.services.background;

import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.base.BackgroundHelperService;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;
import java.util.Objects;

public class AudioStreamLookupService extends BackgroundHelperService
{
	public SimpleObjectProperty<AudioStreamSource> 	StreamSourceProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Recording>	   		TargetRecordingProperty 			= new SimpleObjectProperty<>();
	@Override
	protected Object ServiceSpecificDo()
	{
			System.out.println("Searching for IDs -> " + TargetRecordingProperty.get().getTitle());

			List<String> IDs = null;

			try
			{
				IDs = StreamSourceProperty.get().Search(TargetRecordingProperty.get());
			}
			catch (Exception e)
			{

			}

			//currently just picks first id then picks stream
			List<String> streams = null;

			try
			{
				streams = StreamSourceProperty.get().SearchByID(Objects.requireNonNull(IDs).getFirst());
			}
			catch (Exception e)
			{
				System.out.println("Error with Search by ID");
			}

			//Does the same for streams, does not prioritize high quality
		if (streams != null)
			{
				System.out.println(streams.getFirst());
				return streams.getFirst();
			}
			else
				return null;
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
