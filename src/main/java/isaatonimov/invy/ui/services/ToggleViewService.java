package isaatonimov.invy.ui.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class ToggleViewService extends Service
{
	public Stage viewStage;

	public ToggleViewService(Stage viewStage)
	{
		this.viewStage = viewStage;
	}
	@Override
	protected Task createTask()
	{
		if(viewStage.isShowing())
		{
			viewStage.hide();
		}
		else
		{
			viewStage.show();
			viewStage.requestFocus();
		}
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
