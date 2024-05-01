package isaatonimov.invy.core.base;

import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class MusicPlayer
{

	private SimpleObjectProperty<Recording>						PreparedRecord				= new SimpleObjectProperty<>();
	public SimpleIntegerProperty									URLSPrefetched				= new SimpleIntegerProperty(0);
	public SimpleIntegerProperty									URLSToPreload				= new SimpleIntegerProperty(2);
	public SimpleObjectProperty<Recording> 						CurrentlyPlayingRecord 		= new SimpleObjectProperty<>(null);
	public SimpleObjectProperty<MusicPlayerState> 					CurrentState 				= new SimpleObjectProperty<>(MusicPlayerState.NOT_INITIALIZED);
	private SimpleObjectProperty<LinkedList<Recording>> 				FullRecordList = new SimpleObjectProperty<>();
	public SimpleObjectProperty<LinkedHashMap<Recording, String>> 		SongQueue 				= new SimpleObjectProperty<>(new LinkedHashMap<>());
	public SimpleObjectProperty<AudioStreamSource>					CurrentAudioStreamSource		= new SimpleObjectProperty<>();
	public MusicPlayer()
	{
		Init();
		InitPlayerSpecificHandlers();

		CurrentState.addListener((observable, oldValue, newValue) ->
		{
			CurrentlyPlayingRecord.set(PreparedRecord.get());
		});
	}

	public void AddToSongQueue(LinkedList<Recording> records, boolean andPlayFirstSong)
	{
		//First Call of AddToSongQueue from Outside Probably -> assign full record list for later
		if(FullRecordList.get() == null)
			FullRecordList.set(records);

		List<String> urlsToAppend = new ArrayList<>();

		Thread queueingThread = new Thread(() ->
		{
			for(int i = 0; i < URLSToPreload.get(); i++)
			{
				AudioStreamLookupService audioStreamLookupService = new AudioStreamLookupService();
				audioStreamLookupService.StreamSourceProperty.set(CurrentAudioStreamSource.get());
				audioStreamLookupService.TargetRecordingProperty.set(records.get(i));
				audioStreamLookupService.startWorking();

				audioStreamLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
				{
					URLSPrefetched.set(URLSPrefetched.get() + 1);
					SongQueue.get().put(audioStreamLookupService.TargetRecordingProperty.get(), (String) newValue);

					urlsToAppend.add((String) newValue);

					if(andPlayFirstSong && URLSPrefetched.get() == URLSToPreload.get())
					{
						System.out.println("Prefetched audio urls for now...");
						PlayerSpecificInitPostSongQueueLoaded();
						Play(records.getFirst());
					}
					else if(andPlayFirstSong == false)
					{
						PlayerSpecificAppendToSongQueue(urlsToAppend);
					}
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
		});

		queueingThread.start();
	}

	public void Play(Recording recording)
	{
		PlayerSpecificPlay(SongQueue.get().get(recording));
		PreparedRecord.set(recording);
	}

	public void PlayNext()
	{
		List<Recording> SongQueueList = new ArrayList<>(SongQueue.get().keySet());
		if(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) + 1 <= SongQueueList.size()-1)
			Play(SongQueueList.get(SongQueueList.indexOf(CurrentlyPlayingRecord.get()) + 1));

		LinkedList<Recording> recordingsToFetchNext = new LinkedList<>();

		for(int i = URLSPrefetched.get(); i < URLSPrefetched.get() + URLSToPreload.get() ; i++)
		{
			recordingsToFetchNext.add(FullRecordList.get().get(i));
		}

		AddToSongQueue(recordingsToFetchNext, false);
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
