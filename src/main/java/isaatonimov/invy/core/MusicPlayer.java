package isaatonimov.invy.core;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.ui.services.AudioStreamLookupService;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
	The music player:
	-> what it does
	>
	>
	>
	>
 */
public class MusicPlayer
{
	private AudioStreamLookupService 		audioStreamLookupService;
	private Recording					currentlyPlaying;
	private boolean						shufflePlay = true;
	private Controller					controller;


	public MusicPlayer(Controller controller)
	{
		this.controller = controller;
		this.audioStreamLookupService = controller.getAudioStreamLookupService();
	}

	public void AddToQueue(LinkedList<Recording> recordings) throws URISyntaxException, IOException, InterruptedException, NoVideoResultsFoundException
	{
		//Clears all songs before a a new Queue is submitted
		//thats all i need for now

		LinkedList<Recording> shuffledRecordsLink = new LinkedList<Recording>();
		List<Recording> shuffledRecords = new ArrayList<>();

		for(var record : recordings)
			shuffledRecords.add(record);

		Collections.shuffle(shuffledRecords);

		for(var record : shuffledRecords)
			shuffledRecordsLink.add(record);

		recordings = shuffledRecordsLink;

		for(int i = 0; i < recordings.size(); i++)

		//PreloadMediaForRecord(recordings.getFirst());

		Play(recordings.getFirst());

	}

	public void RemoveRecordGracefully(Recording record)
	{

	}


	/*

	 */
	public void Play(Recording recording) throws URISyntaxException, IOException, InterruptedException, NoVideoResultsFoundException
	{
		URL fetchedURL;

		audioStreamLookupService.updateQuery(recording);
		audioStreamLookupService.restart();

		audioStreamLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				URL fetchedURL = (URL) audioStreamLookupService.getValue();

				MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
				MediaPlayer mediaPlayer1 = mediaPlayerFactory.mediaPlayers().newMediaPlayer();
				mediaPlayer1.media().play(fetchedURL.toString(), ":no-video");
				mediaPlayer1.

				try
				{
					Thread.currentThread().join();
				} catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
			}
		});
	}

	public Recording getCurrentlyPlayingRecord()
	{
		return currentlyPlaying;
	}

	public void shutdown()
	{

	}
}
