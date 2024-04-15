package isaatonimov.invy.core;

import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.ui.services.AudioStreamLookupService;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

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
	public SimpleObjectProperty<Recording> 	currentlyPlaying = new SimpleObjectProperty<>(this, "currentlyPlaying");
	public SimpleBooleanProperty 			currentlyPlayingState = new SimpleBooleanProperty(this, "currentlyPlayingState");
	private MediaPlayerFactory 				mediaPlayerFactory;
	private MediaPlayer 					mediaPlayer;
	private LinkedList<Recording>			queue;

	public MusicPlayer(AudioStreamLookupService audioStreamLookupService)
	{
		queue = new LinkedList<Recording>();
		this.audioStreamLookupService = audioStreamLookupService;

		mediaPlayerFactory = new MediaPlayerFactory("--no-metadata-network-access");
		mediaPlayer = mediaPlayerFactory.mediaPlayers().newMediaPlayer();

		mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter(){
			@Override
			public void finished(MediaPlayer mediaPlayer)
			{

				System.out.println("Media finished, trying to play next song in queue");

				Platform.runLater(new Runnable()
				{
					@Override
					public void run()
					{
						PlayNext();
					}
				});
			}
		});
	}

	public void ShuffleQueue()
	{
		List<Recording> shuffledRecords = new ArrayList<>();

		for(var record : queue)
			shuffledRecords.add(record);

		Collections.shuffle(shuffledRecords);

		queue.clear();

		for(var record : shuffledRecords)
			queue.add(record);
	}

	public void AddToQueue(LinkedList<Recording> recordings) throws URISyntaxException, IOException, InterruptedException, NoVideoResultsFoundException
	{
		//Clears all songs before a a new Queue is submitted
		//thats all i need for now
		queue.clear();
		queue.addAll(recordings);
		//Then Shuffles it
		ShuffleQueue();;
		Play(queue.getFirst());

		System.out.println("Queue Size: " + queue.size());

	}


	/*

	 */
	public void Play(Recording recording) throws URISyntaxException, IOException, InterruptedException, NoVideoResultsFoundException
	{
		currentlyPlaying.set(recording);
		URL fetchedURL;

		audioStreamLookupService.updateQuery(recording);
		audioStreamLookupService.restart();

		audioStreamLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				URL fetchedURL = (URL) audioStreamLookupService.getValue();
				System.out.println("Playing:" + fetchedURL);
				mediaPlayer.media().play(fetchedURL.toString(), ":no-video");
			}
		});
	}

	public boolean isCurrentlySomethingPlaying()
	{
		return mediaPlayer.status().isPlaying();
	}


	public void PlayNext()
	{
		try
		{
			if(queue.indexOf(currentlyPlaying.get()) + 1 <= queue.size()-1)
				Play(queue.get(queue.indexOf(currentlyPlaying.get()) + 1));
			else
			{
				ShuffleQueue();
				Play(queue.getFirst());
			}
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		} catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		} catch (NoVideoResultsFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void PlayPrevious()
	{
		try
		{
			if(queue.indexOf(currentlyPlaying.get()) -1 >= 0)
				Play(queue.get(queue.indexOf(currentlyPlaying.get()) - 1));
			else
			{
				//Play again this title
				Play(queue.getFirst());

				//ShuffleQueue();
				//Play(queue.getFirst());
			}
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		} catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		} catch (NoVideoResultsFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	public boolean TogglePausePlay()
	{
		if(mediaPlayer.status().isPlaying())
		{
			currentlyPlayingState.set(false);
			mediaPlayer.controls().pause();
		}
		else
		{
			currentlyPlayingState.set(true);
			mediaPlayer.controls().play();
		}

		return mediaPlayer.status().isPlaying();
	}

	public void shutdown()
	{
		mediaPlayer.controls().stop();
	}

	public AudioStreamLookupService getAudioStreamLookupService()
	{
		return audioStreamLookupService;
	}
}
