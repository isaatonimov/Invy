package isaatonimov.invy.core.base;

import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import isaatonimov.invy.utils.InvyUtils;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import kong.unirest.Unirest;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class MusicPlayer
{
	public SimpleObjectProperty<Recording> CurrentlyPlayingRecord = new SimpleObjectProperty<>(null);
	public SimpleObjectProperty<MusicPlayerState> CurrentState 	= new SimpleObjectProperty<>(MusicPlayerState.NOT_INITIALIZED);
	public SimpleObjectProperty<LinkedList<Recording>> SongQueue = new SimpleObjectProperty<>(new LinkedList<>());
	public SimpleObjectProperty<AudioStreamLookupService>	AudioStreamLookupServiceProperty = new SimpleObjectProperty<>();
	public SimpleStringProperty CurrentTargetAudioSourceURL 	= new SimpleStringProperty("");
	public SimpleBooleanProperty BufferFileRequired 			= new SimpleBooleanProperty(false);
	public SimpleObjectProperty<File> BufferFile	  			= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Duration>	BufferingTime 		= new SimpleObjectProperty<>(Duration.ofSeconds(0));
	private SimpleObjectProperty<Thread> FetchThread			= new SimpleObjectProperty<>();

	public MusicPlayer() throws IOException, URISyntaxException
	{
		if(RequireLocallyStoredBuffer() == true)
			CreateBufferFile();

		Init();
		InitPlayerSpecificHandlers();
	}

	public void ShuffleSongQueue()
	{
		List<Recording> shuffledRecords = new ArrayList<>();

		for(var record : SongQueue.get())
			shuffledRecords.add(record);

		Collections.shuffle(shuffledRecords);

		SongQueue.get().clear();

		for(var record : shuffledRecords)
			SongQueue.get().add(record);
	}

	public void AddToSongQueue(LinkedList<Recording> records)
	{
		PlayerSpecificPause();

		SongQueue.get().		clear();
		SongQueue.get().		addAll(records);
		ShuffleSongQueue();
		Play(SongQueue.get().	getFirst());
	}

	public void Play(Recording toPlay)
	{
		System.out.println("Trying to Play Track " + toPlay.getTitle() + " with " + this.getClass().getName());

		AudioStreamLookupServiceProperty.get().TargetRecordingProperty.set(toPlay);
		AudioStreamLookupServiceProperty.get().startWorking();

		AudioStreamLookupServiceProperty.get().ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			CurrentTargetAudioSourceURL.set((String) AudioStreamLookupServiceProperty.get().ResultValueProperty.get());

			if(RequireLocallyStoredBuffer() && BufferFile != null)
			{
				FetchAudioStreamAndStoreInBuffer();

				Buffer(BufferingTime.get(), () ->
				{
					try
					{
						TimeUnit.MILLISECONDS.sleep(BufferingTime.get().toMillis());
					}
					catch (InterruptedException e)
					{
						throw new RuntimeException(e);
					}

					PlayerSpecificPlay();
					CurrentState.				set(MusicPlayerState.PLAYING);
				});
			}
			else
				PlayerSpecificPlay();

			CurrentlyPlayingRecord.		set(toPlay);
			CurrentState.				set(MusicPlayerState.PLAYING);
		});
	}

	public void PlayNext()
	{
		if(SongQueue.get().indexOf(CurrentlyPlayingRecord.get()) + 1 <= SongQueue.get().size()-1)
			Play(SongQueue.get().get(SongQueue.get().indexOf(CurrentlyPlayingRecord.get()) + 1));
		else
		{
			ShuffleSongQueue();
			Play(SongQueue.get().getFirst());
		}
	}

	public void PlayPrevious()
	{
		if(SongQueue.get().indexOf(CurrentlyPlayingRecord.get()) -1 >= 0)
			Play(SongQueue.get().get(SongQueue.get().indexOf(CurrentlyPlayingRecord.get()) - 1));
		else
			Play(SongQueue.get().getFirst());
	}

	public void TogglePlay()
	{
		if(CurrentState.get() == MusicPlayerState.PLAYING)
		{
			PlayerSpecificPause();
			CurrentState.set(MusicPlayerState.PAUSED);
		}
		else if(CurrentState.get() == MusicPlayerState.PAUSED)
		{
			PlayerSpecificResume();
			CurrentState.set(MusicPlayerState.PLAYING);
		}
	}

	public void Init()
	{
		System.out.println("Initialized Player: " + getClass().getName());

		PlayerSpecificInit();
		CurrentState.set(MusicPlayerState.INITIALIZED);
	}

	public void Shutdown()
	{
		PlayerSpecificShutDown();
		CurrentState.set(MusicPlayerState.NOT_INITIALIZED);
		CurrentlyPlayingRecord.set(null);
	}
	private void CreateBufferFile() throws IOException, URISyntaxException
	{
		InputStream inputStream = getClass().getResourceAsStream("/isaatonimov/invy/media/dummy.mp3");

		File dummyFile = new File(InvyUtils.getTempDirectoryPath().toString(), "dummy.mp3");

		try(OutputStream outputStream = new FileOutputStream(dummyFile)){
			IOUtils.copy(inputStream, outputStream);
		} catch (FileNotFoundException e)
		{
			// handle exception here
		} catch (IOException e)
		{
			// handle exception here
		}

		BufferFile.set(dummyFile);
	}

	private void FetchAudioStreamAndStoreInBuffer()
	{
		Thread fetch = new Thread(() ->
		{
			try
			{
				BufferFile.set(new File(InvyUtils.getTempDirectoryPath().toString(), CurrentlyPlayingRecord.hashCode() + ".mp4"));
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}

			Unirest.get(CurrentTargetAudioSourceURL.get()).asFile(BufferFile.get().getPath()).getBody();
		});

		FetchThread.set(fetch);

		FetchThread.get().start();
	}

	private void Buffer(Duration bufferingTime, Runnable runnable)
	{
		Thread BufferThread = new Thread(runnable);
		BufferThread.start();
	}

	protected abstract void PlayerSpecificPlay();
	protected abstract void PlayerSpecificResume();
	protected abstract void PlayerSpecificPause();
	protected abstract void PlayerSpecificInit();
	protected abstract void InitPlayerSpecificHandlers();
	protected abstract void PlayerSpecificShutDown();
	protected abstract boolean RequireLocallyStoredBuffer();
}
