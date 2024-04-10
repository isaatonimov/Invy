package isaatonimov.invy.handlers;

import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.ui.services.RecordingLookupService;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SongViewSearchhandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private MusicPlayer mainMusicPlayer;
	private List<Service> toStart;

	/*
		Starts all services that where given to handler
		default behaviour for now -> wait for service to finish before attempting
		to start next service
	 */
	public SongViewSearchhandler(MusicPlayer musicPlayer, Service... toStart)
	{
		this.mainMusicPlayer = musicPlayer;
		this.toStart = Arrays.stream(toStart).toList();
	}

	private boolean startServicesSequential()
	{
		EventType<WorkerStateEvent> ifSuccess = WorkerStateEvent.WORKER_STATE_SUCCEEDED;

		//Domino tick
		toStart.getFirst().start();

		if(toStart.getFirst() instanceof RecordingLookupService)
			toStart.getFirst().addEventHandler(ifSuccess, event ->
			{
				try
				{
					mainMusicPlayer.AddToQueue((LinkedList<Recording>) toStart.getFirst().getValue());
				}
				catch (URISyntaxException e)
				{
					throw new RuntimeException(e);
				}
				catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
				catch (NoVideoResultsFoundException e)
				{
					throw new RuntimeException(e);
				}
			});

//		final boolean[] serviceChainSuccessful = {false};
//		for(var service : toStart)
//		{
//			service.addEventFilter(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
//			{
//				@Override
//				public void handle(Event event)
//				{
//					if(!toStart.getFirst().isRunning())
//					{
//						if(toStart.isEmpty())
//							serviceChainSuccessful[0] = true;
//						else
//						{
//							//Start service
//							toStart.getFirst().restart();
//							//Remove Service from queue
//							toStart.remove(service);
//						}
//					}
//				}
//			});
//		}
//
//		return serviceChainSuccessful[0];

		return true;
	}

	@Override
	public void handle(KeyEvent event)
	{
		if(event.getCode() == KeyCode.ENTER)
		{
			boolean success = startServicesSequential();

			if(success)
				((TextField)(event.getSource())).getScene().getWindow().hide();
		}
	}
}
