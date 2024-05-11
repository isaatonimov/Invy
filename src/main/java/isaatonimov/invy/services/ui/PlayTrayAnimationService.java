package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;

public class PlayTrayAnimationService extends UIHelperService
{
	@Override
	protected Object ServiceSpecificDo()
	{
		System.out.println("Trying to play Tray Animation...");
		//ControllerProperty.get().TrayProperty.get().play();
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
