package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;

public class SongPlayPrevService extends UIHelperService
{

	@Override
	protected Object ServiceSpecificDo()
	{
		if(ControllerProperty.get().MusicPlayerProperty.get() != null && ControllerProperty.get().MusicPlayerProperty.get().CurrentlyPlayingRecord.get() != null)
		{
			//ControllerProperty.get().TrayProperty.get().play();
			ControllerProperty.get().MusicPlayerProperty.get().PlayPrevious();
			return true;
		}
		else
		{
			ControllerProperty.get().ShowNotification("Can't play previous song, because no Songs are in Playlist.");
			return false;
		}
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
