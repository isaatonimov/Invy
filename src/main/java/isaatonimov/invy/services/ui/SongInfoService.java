package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;

public class SongInfoService extends UIHelperService
{
	@Override
	protected Object ServiceSpecificDo()
	{
		ControllerProperty.get().ShowSongInfo();
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
