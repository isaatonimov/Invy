package isaatonimov.invy.services.base;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

public abstract class HelperService extends Service
{
	public 	SimpleObjectProperty<Object> 	ResultValueProperty 	= new SimpleObjectProperty<>();
	private 	Thread backgroundThread;
	private	Task   customHelperTask;
	private 	Task						ReturnResultTask		= new Task()
	{
		@Override
		protected Object call() throws Exception
		{
			return ResultValueProperty.get();
		}
	};

	public HelperService()
	{
		ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			ServiceSpecificOnValuePropertyChanged();
		});

		this.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, 	event -> OnSuccessDo());
		this.addEventHandler(WorkerStateEvent.WORKER_STATE_FAILED, 		event -> ServiceSpecificOnFailureDo());
		this.addEventHandler(WorkerStateEvent.WORKER_STATE_CANCELLED, 	event -> ServiceSpecificOnInterruptionDo());
		this.addEventHandler(WorkerStateEvent.WORKER_STATE_RUNNING, 		event -> ServerSpecificOnRunningDo());
	}

	public void startWorking()
	{
		System.out.println("Service " + this.getClass().getName() + " started....");

		if(this.stateProperty().get() != State.RUNNING)
		{
			this.reset();

			if(customHelperTask != null)
				this.executeTask(customHelperTask);
			else
				this.executeTask(customHelperServiceTask());
		}
	}

	public void OnSuccessDo()
	{
		System.out.println("Service " + this.getClass().getName() + " finished succesfully.");
		if(backgroundThread != null)
			backgroundThread.interrupt();

		this.reset();
		ServiceSpecificOnSuccessDo();
	}

	private Task customHelperServiceTask()
	{
		if(this instanceof BackgroundHelperService)
		{
			System.out.println("Background Service detected -> Running in its own Thread");
			backgroundThread = new Thread(() ->
			{
				Platform.runLater(() -> ResultValueProperty.set(ServiceSpecificDo()));
			});

			backgroundThread.start();
		}
		else if(this instanceof UIHelperService)
		{
			System.out.println("UI Helper Service detected -> Running in FX Thread");
			Platform.runLater(() -> ResultValueProperty.set(ServiceSpecificDo()));
		}

		return ReturnResultTask;
	}

	@Override
	protected Task createTask()
	{
		customHelperTask = customHelperServiceTask();

		customHelperTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, 	event -> OnSuccessDo());
		customHelperTask.addEventHandler(WorkerStateEvent.WORKER_STATE_FAILED, 		event -> ServiceSpecificOnFailureDo());
		customHelperTask.addEventHandler(WorkerStateEvent.WORKER_STATE_CANCELLED, 	event -> ServiceSpecificOnInterruptionDo());
		customHelperTask.addEventHandler(WorkerStateEvent.WORKER_STATE_RUNNING, 	event -> ServerSpecificOnRunningDo());

		return customHelperTask;
	}

	protected abstract Object  ServiceSpecificDo();
	protected abstract boolean 	ServiceSpecificOnSuccessDo();
	protected abstract boolean 	ServiceSpecificOnFailureDo();
	protected abstract boolean 	ServiceSpecificOnInterruptionDo();
	protected abstract boolean 	ServerSpecificOnRunningDo();
	protected abstract void 	ServiceSpecificOnValuePropertyChanged();
}
