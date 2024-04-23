package isaatonimov.invy.services.base;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;

public abstract class HelperService
{
	public	SimpleObjectProperty<Service>	ServiceProperty		= new SimpleObjectProperty<>();
	public 	SimpleObjectProperty<Thread>	ThreadProperty		= new SimpleObjectProperty<>();
	public 	SimpleObjectProperty<Object> 	ResultValueProperty 	= new SimpleObjectProperty<>(null);
	private 	Runnable					MainTask 			= () -> ResultValueProperty.set(ServiceSpecificDo());

	public HelperService()
	{
		ResultValueProperty.addListener((observable, oldValue, newValue) -> OnSuccessDo());

		if(IsBackgroundService())
		{
			System.out.println("Creating Background Thread for " + getClass().getName() + " Service...");

			ThreadProperty.set(new Thread(() -> MainTask.run()));
		}
		else
		{
			System.out.println("Creating UI Service for " + getClass().getName() + " Service...");

			ServiceProperty.set(new Service()
			{
				@Override
				protected Task createTask()
				{
					Platform.runLater(() -> ResultValueProperty.set(ServiceSpecificDo()));

					return new Task()
					{
						@Override
						protected Object call() throws Exception
						{
							return "null";
						}
					};
				}
			});
		}
	}

	public void startWorking()
	{
		if (IsBackgroundService())
		{
			try
			{
				ThreadProperty.get().interrupt();
				ThreadProperty.get().join();
				ThreadProperty.set(new Thread(() -> MainTask.run()));
				ThreadProperty.get().start();
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
		else
		{
			Platform.runLater(() ->
			{
				if(this.ServiceProperty.get().stateProperty().get() != Worker.State.RUNNING)
				{
					this.ServiceProperty.get().restart();
				}
			});
		}
	}

	public void OnSuccessDo()
	{
		ServiceSpecificOnSuccessDo();

		System.out.println("Service " + this.getClass().getName() + " finished succesfully and was reset.");
	}

	protected abstract boolean IsBackgroundService();
	protected abstract Object  ServiceSpecificDo();
	protected abstract boolean 	ServiceSpecificOnSuccessDo();
	protected abstract boolean 	ServiceSpecificOnFailureDo();
	protected abstract boolean 	ServiceSpecificOnInterruptionDo();
	protected abstract boolean 	ServerSpecificOnRunningDo();
	protected abstract void 	ServiceSpecificOnValuePropertyChanged();
}
