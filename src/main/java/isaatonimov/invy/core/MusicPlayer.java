package isaatonimov.invy.core;

import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.helpers.AppUtils;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.ui.services.AudioStreamLookupService;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import kong.unirest.Unirest;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
	public SimpleObjectProperty<Recording> 	currentlyPlaying 		= new SimpleObjectProperty<>(this, "currentlyPlaying");
	public SimpleBooleanProperty 			currentlyPlayingState 	= new SimpleBooleanProperty(this, "currentlyPlayingState");
	private MediaPlayerFactory 				mediaPlayerFactory;
	private MediaPlayer 					mediaPlayerVLC;
	private javafx.scene.media.MediaPlayer		mediaPlayerFx;
	private LinkedList<Recording>			queue;

	public  BooleanProperty 				UseVLCBackend 		= new SimpleBooleanProperty();

	private Media						currentMediaFX      = null;
	private boolean						fxCurrentlyPlaying	= false;

	public MusicPlayer(AudioStreamLookupService audioStreamLookupService)
	{
		queue = new LinkedList<Recording>();
		this.audioStreamLookupService = audioStreamLookupService;

	}

	public void initMusicPlayerVLC()
	{
		if(UseVLCBackend.get())
		{
			mediaPlayerFactory = new MediaPlayerFactory("--no-metadata-network-access");
			mediaPlayerVLC = mediaPlayerFactory.mediaPlayers().newMediaPlayer();

			mediaPlayerVLC.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter(){
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
				File toPlay = new File(AppUtils.getTempDirectoryFile(), "temp_audio.mp4");


				if(UseVLCBackend.get())
				{
					System.out.println("Playing with VLC Media Player:" + fetchedURL.toString());

					if(mediaPlayerVLC == null)
						initMusicPlayerVLC();

					mediaPlayerVLC.media().play(fetchedURL.toString(), ":no-video");
				}
				else
				{
					Thread bufferingThread = new Thread(() ->
					{
						//TODO Implement Unirest Progress
						try
						{
							Unirest.get(fetchedURL.toString()).asFile(AppUtils.getTempDirectoryPath().toString() + "/temp_audio.mp4").getBody();
						}
						catch (IOException e)
						{
							throw new RuntimeException(e);
						}

					});

					bufferingThread.start();

					System.out.println("Playing with Java FX Media Player the shady way:" + fetchedURL.toString());

					//TEST

					Platform.runLater(() ->
					{
						new Thread(new Runnable()
						{
							@Override
							public void run()
							{
								try
								{
									//Buffering Time?
									TimeUnit.SECONDS.sleep(10);
								}
								catch (InterruptedException e)
								{
									throw new RuntimeException(e);
								}

								currentMediaFX = new Media(toPlay.toURI().toString());
								mediaPlayerFx = new javafx.scene.media.MediaPlayer(currentMediaFX);
								mediaPlayerFx.setOnError(() -> System.out.println("Current error: "+mediaPlayerFx.getError()));

								mediaPlayerFx.setOnEndOfMedia(() ->
								{
									bufferingThread.interrupt();
									PlayNext();
								});

								mediaPlayerFx.play();
							}
						}).start();

					});

				}
			}
		});
	}

	public boolean isCurrentlySomethingPlaying()
	{

		if(UseVLCBackend.get())
		{
			if(mediaPlayerVLC == null)
				initMusicPlayerVLC();

			return mediaPlayerVLC.status().isPlaying();
		}
		else
			return fxCurrentlyPlaying;
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
		if(UseVLCBackend.get())
		{
			if(mediaPlayerVLC.status().isPlaying())
			{
				currentlyPlayingState.set(false);
				mediaPlayerVLC.controls().pause();
			}
			else
			{
				currentlyPlayingState.set(true);
				mediaPlayerVLC.controls().play();
			}

			return mediaPlayerVLC.status().isPlaying();
		}
		else
		{
			if(fxCurrentlyPlaying)
			{
				currentlyPlayingState.set(false);
				mediaPlayerFx.pause();
			}
			else
			{
				currentlyPlayingState.set(true);
				mediaPlayerFx.play();
			}
			return fxCurrentlyPlaying;
		}
	}

	public void shutdown()
	{
		if(UseVLCBackend.get())
			mediaPlayerVLC.controls().stop();
		else if(mediaPlayerFx != null)
			mediaPlayerFx.dispose();
	}

	public AudioStreamLookupService getAudioStreamLookupService()
	{
		return audioStreamLookupService;
	}

	public javafx.scene.media.MediaPlayer getMediaPlayerFX()
	{
		return this.mediaPlayerFx;
	}
}
