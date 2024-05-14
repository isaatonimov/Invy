package isaatonimov.invy.core.base;

import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.Duration;
import java.util.*;

public abstract class MusicPlayer
{

	private final SimpleObjectProperty<Recording>						PreparedRecord				= new SimpleObjectProperty<>();
	public SimpleIntegerProperty									URLSPrefetched				= new SimpleIntegerProperty(0);
	public SimpleIntegerProperty									URLSToPreload				= new SimpleIntegerProperty(2);
	public SimpleObjectProperty<Recording> 						CurrentlyPlayingRecord 		= new SimpleObjectProperty<>(null);
	public SimpleObjectProperty<MusicPlayerState> 					CurrentState 				= new SimpleObjectProperty<>(MusicPlayerState.NOT_INITIALIZED);
	private final SimpleObjectProperty<LinkedList<Recording>> 				FullRecordList 				= new SimpleObjectProperty<>(null);
	public SimpleObjectProperty<LinkedHashMap<Recording, String>> 		SongQueue 				= new SimpleObjectProperty<>(new LinkedHashMap<>());
	public SimpleObjectProperty<AudioStreamSource>					CurrentAudioStreamSource		= new SimpleObjectProperty<>();
	public MusicPlayer()
	{
		Init();
		InitPlayerSpecificHandlers();
	}

	public void ShuffleQueue()
	{
		List<Map.Entry<Recording, String>> SongQueueListEntries  = new ArrayList<>(SongQueue.get().entrySet());
		Collections.shuffle(SongQueueListEntries);

		SongQueue.get().clear();

		for(var entry : SongQueueListEntries)
		{
			SongQueue.get().put(entry.getKey(), entry.getValue());
		}
	}

	public void FetchNextXSongs(int songAmountToFetchNext)
	{
		Thread queueingThread = new Thread(() ->
		{
			int counter = 0;

			for(var entry : SongQueue.get().entrySet())
			{
				if(entry.getValue() == null && counter < songAmountToFetchNext)
				{
					counter++;

					List<String> urlsToAppend = new ArrayList<>();


					List<Recording> SongQueueList = new ArrayList<>(SongQueue.get().keySet());

					AudioStreamLookupService audioStreamLookupService = new AudioStreamLookupService();
					audioStreamLookupService.StreamSourceProperty.set(CurrentAudioStreamSource.get());
					audioStreamLookupService.TargetRecordingProperty.set(entry.getKey());
					audioStreamLookupService.startWorking();

					audioStreamLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
					{
						URLSPrefetched.set(URLSPrefetched.get() + 1);
						SongQueue.get().put(audioStreamLookupService.TargetRecordingProperty.get(), (String) newValue);

						urlsToAppend.add((String) newValue);
						PlayerSpecificAppendToSongQueue(urlsToAppend);
					});

					try
					{
						Thread.sleep(Duration.ofSeconds(2));
					}
					catch (InterruptedException e)
					{
						throw new RuntimeException(e);
					}
				}
			}
		});

		queueingThread.start();

		try
		{
			queueingThread.join();
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void AddToSongQueue(LinkedList<Recording> records, boolean andPlayFirstSong)
	{
		SongQueue.get().clear();

		for(var record : records)
		{
			SongQueue.get().put(record, null);
		}

		ShuffleQueue();

		FetchNextXSongs(URLSToPreload.get());

		if(andPlayFirstSong)
			Play(SongQueue.get().firstEntry().getKey());
	}

	public void Play(Recording recording)
	{
		CurrentlyPlayingRecord.set(recording);
		PlayerSpecificPlay(SongQueue.get().get(recording));
	}

	public void PlayNext()
	{
		List<Recording> SongQueueList = new ArrayList<>(SongQueue.get().keySet());

		if(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) + 1 <= SongQueueList.size()-1)
			Play(SongQueueList.get(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) + 1));

		LinkedList<Recording> recordingsToFetchNext = new LinkedList<>();

		FetchNextXSongs(URLSToPreload.get());
	}

	public void PlayPrevious()
	{
		List<Recording> SongQueueList = new ArrayList<>(SongQueue.get().keySet());
		if(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) -1 >= 0)
			Play(SongQueueList.get(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) - 1));
		else
			Play(SongQueueList.getFirst());
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

		PlayerSpecificInitPreSongQueueLoaded();
		CurrentState.set(MusicPlayerState.INITIALIZED);
	}

	public void Shutdown()
	{
		PlayerSpecificShutDown();
		CurrentState.set(MusicPlayerState.NOT_INITIALIZED);
		CurrentlyPlayingRecord.set(null);
	}

	protected abstract void PlayerSpecificAppendToSongQueue(List<String> audioURLs);
	protected abstract void PlayerSpecificPlay(String streamURL);
	protected abstract void PlayerSpecificResume();
	protected abstract void PlayerSpecificPause();
	protected abstract void PlayerSpecificInitPreSongQueueLoaded();
	protected abstract void PlayerSpecificInitPostSongQueueLoaded();
	protected abstract void InitPlayerSpecificHandlers();
	protected abstract void PlayerSpecificShutDown();

	protected abstract String PlayerSpecificDescription();
}
