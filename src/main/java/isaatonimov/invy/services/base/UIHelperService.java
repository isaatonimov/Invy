package isaatonimov.invy.services.base;

import isaatonimov.invy.controller.Controller;
import javafx.beans.property.SimpleObjectProperty;

public abstract class UIHelperService extends HelperService
{
	public 	SimpleObjectProperty<Controller> 	ControllerProperty = new SimpleObjectProperty<>();
	public static void BindServicePropertiesToController(Controller controllerToBind, SimpleObjectProperty<? extends UIHelperService>... servicePropertiesToBindTo)
	{
		for(var serviceProperty : servicePropertiesToBindTo)
			serviceProperty.get().ControllerProperty.set(controllerToBind);
	}
}
