package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;

public class SongTogglePlayService extends UIHelperService
{

	@Override
	protected Object ServiceSpecificDo()
	{
		if(ControllerProperty.get().MusicPlayerProperty.get() != null && ControllerProperty.get().MusicPlayerProperty.get().CurrentlyPlayingRecord.get() != null)
		{
			ControllerProperty.get().MusicPlayerProperty.get().TogglePlay();
			return true;
		}
		else
		{
			ControllerProperty.get().ShowNotification("Can't Toggle Song, because no Song is currently playing.");
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
