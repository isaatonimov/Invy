package isaatonimov.invy.ui.services;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ApplicationShutdownService extends Service
{
	public ApplicationShutdownService()
	{
	}
	@Override
	protected Task createTask()
	{
		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{
				Platform.exit();
				return null;
			}
		};
	}
}
