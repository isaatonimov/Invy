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

	public HelperService()
	{
		ResultValueProperty.addListener((observable, oldValue, newValue) -> OnSuccessDo());

		if(IsBackgroundService())
		{
			System.out.println("Creating Background Thread for " + getClass().getName() + " Service...");

			ThreadProperty.set(new Thread(() ->
			{
				ResultValueProperty.set(ServiceSpecificDo());
			}));
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
		System.out.println("Service " + this.getClass().getName() + " started....");

		if (IsBackgroundService())
		{
			if(ThreadProperty.get() != null)
				ThreadProperty.get().interrupt();

			ThreadProperty.set(new Thread(() -> ResultValueProperty.set(ServiceSpecificDo())));

			ThreadProperty.get().start();
		}
		else if (this instanceof UIHelperService)
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
