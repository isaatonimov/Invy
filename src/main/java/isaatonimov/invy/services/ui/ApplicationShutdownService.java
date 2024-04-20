package isaatonimov.invy.services.ui;

import isaatonimov.invy.services.base.UIHelperService;
import javafx.application.Platform;

public class ApplicationShutdownService extends UIHelperService
{
	@Override
	protected Object ServiceSpecificDo()
	{
		Platform.exit();
		ControllerProperty.get().MusicPlayerProperty.get().Shutdown();
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
