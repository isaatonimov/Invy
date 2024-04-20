package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;

public class PreferencesService extends UIHelperService
{
	@Override
	protected Object ServiceSpecificDo()
	{
		ControllerProperty.get().ShowPreferencesWindow();
		return true;
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
