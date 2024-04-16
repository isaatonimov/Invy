package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class PreferencesService extends Service
{
	private Controller controller;
	public PreferencesService(Controller controller)
	{
		this.controller = controller;
	}
	@Override
	protected Task createTask()
	{
		//TODO Research why i cant put this inside the task

		controller.showPreferencesWindow();

		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{
				//TODO Gracefully shutdown Music Player

				return null;
			}
		};
	}
}
