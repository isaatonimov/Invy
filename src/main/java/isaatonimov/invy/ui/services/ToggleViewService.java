package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ToggleViewService extends Service
{
	private Controller 	controller;

	public ToggleViewService(Controller controller)
	{
		this.controller = controller;
	}
	@Override
	protected Task createTask()
	{
		controller.toggleMainView();

		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{

				return null;
			}
		};
	}
}
