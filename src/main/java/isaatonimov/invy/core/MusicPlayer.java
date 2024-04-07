package isaatonimov.invy.core;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
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
	private MediaPlayer 				mediaPlayer;
	private List<Recording>			songQueue;
	private HashMap<Recording, Media>	preloadQueue;
	private Recording				currentlyPlaying;
	private boolean					shufflePlay;
	private InvidiousInstance			invidiousInstance;

	public MusicPlayer(InvidiousInstance invidiousInstance)
	{
		this.invidiousInstance = invidiousInstance;
		//add Event -> on End of Song -> play next song in Queue
		mediaPlayer.setOnEndOfMedia(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Play(songQueue.getFirst());
				}
				//TODO -> HANDLE
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
			}
		});
	}

	public void AddToQueue(List<Recording> recordings) throws URISyntaxException, IOException, InterruptedException
	{
		for(var record : recordings)
		{
			songQueue.add(record);
		}

		Play(recordings.getFirst());
	}

	public void RemoveFromQueue(Recording recording)
	{
		songQueue.remove(recording);
		preloadQueue.remove(recording);
	}

	/*

	 */
	public void Play(Recording recording) throws URISyntaxException, IOException, InterruptedException
	{
		RemoveFromQueue(recording);
		mediaPlayer = new MediaPlayer(preloadQueue.get(recording));
		PreloadMedia(3);
	}

	private void PreloadMedia(int preloadNext) throws URISyntaxException, IOException, InterruptedException
	{
		int preloaded = 0;
		for(var entry : preloadQueue.entrySet())
		{
			if(preloaded == 3)
				return;

			Thread.sleep(100);

			Recording toFetch 	= entry.getKey();
			String fetchedURL 	= invidiousInstance.SearchAndFetchFirstVideoStream(toFetch);
			entry.setValue(new Media(fetchedURL));

			preloaded++;
		}
	}
}
