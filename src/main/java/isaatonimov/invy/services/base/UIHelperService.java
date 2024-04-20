package isaatonimov.invy.services.base;

import isaatonimov.invy.controller.Controller;
import javafx.beans.property.SimpleObjectProperty;

public class UIHelperService extends HelperService
{
	public 	SimpleObjectProperty<Controller> 	ControllerProperty = new SimpleObjectProperty<>();
	public static void BindServicePropertiesToController(Controller controllerToBind, SimpleObjectProperty<? extends UIHelperService>... servicePropertiesToBindTo)
	{
		for(var serviceProperty : servicePropertiesToBindTo)
			serviceProperty.get().ControllerProperty.set(controllerToBind);
	}

	@Override
	protected boolean IsBackgroundService()
	{
		return false;
	}

	@Override
	protected Object ServiceSpecificDo()
	{
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
