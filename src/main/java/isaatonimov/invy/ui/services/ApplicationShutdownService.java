package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ApplicationShutdownService extends Service
{
	private Controller controller;
	public ApplicationShutdownService(Controller controller)
	{
		this.controller = controller;
	}
	@Override
	protected Task createTask()
	{
		//TODO Research why i cant put this inside the task
		Platform.exit();
		controller.getMusicPlayer().shutdown();

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
