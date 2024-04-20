package isaatonimov.invy.handlers;

import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.RecordingLookupService;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SongViewSearchhandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private MusicPlayer 	mainMusicPlayer;
	private List<Service> 	toStart;

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

		toStart.getFirst().start();

		if(toStart.getFirst() instanceof RecordingLookupService)
			toStart.getFirst().addEventHandler(ifSuccess, event ->
			{
				mainMusicPlayer.AddToSongQueue((LinkedList<Recording>) toStart.getFirst().getValue());
			});

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
