package isaatonimov.invy.core;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

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
	private MediaPlayer 					mediaPlayer;
	private LinkedHashMap<Recording, Media>	songQueue;
	private Recording					currentlyPlaying;
	private boolean						shufflePlay = true;
	private InvidiousInstance				invidiousInstance;

	public MusicPlayer(InvidiousInstance invidiousInstance)
	{
		this.invidiousInstance = invidiousInstance;

		songQueue 	= new LinkedHashMap<Recording, Media>();
	}

	public void AddToQueue(LinkedList<Recording> recordings) throws URISyntaxException, IOException, InterruptedException
	{
		LinkedList<Recording> shuffledRecordsLink = new LinkedList<Recording>();
		List<Recording> shuffledRecords = new ArrayList<>();

		for(var record : recordings)
			shuffledRecords.add(record);

		Collections.shuffle(shuffledRecords);

		for(var record : shuffledRecords)
			shuffledRecordsLink.add(record);

		recordings = shuffledRecordsLink;

		for(int i = 0; i < recordings.size(); i++)
			songQueue.put(recordings.get(i), null);

		PreloadMediaForRecord(recordings.getFirst());
		Play(recordings.getFirst());
	}


	/*

	 */
	public void Play(Recording recording) throws URISyntaxException, IOException, InterruptedException
	{
		currentlyPlaying = recording;
		mediaPlayer = new MediaPlayer(songQueue.get(recording));
		mediaPlayer.play();
		setOnTrackFinishedEvent(mediaPlayer);
		songQueue.remove(recording);
		PreloadMediaForRecord(songQueue.pollFirstEntry().getKey());
	}

	private void setOnTrackFinishedEvent(MediaPlayer mediaPlayer)
	{
		mediaPlayer.setOnEndOfMedia(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Play(songQueue.firstEntry().getKey());
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
			}
		});
	}

	private void PreloadMediaForRecord(Recording recording) throws IOException
	{
		System.out.println("Invoked Preload Media...");
		String fetchedURL 	= invidiousInstance.SearchAndFetchFirstVideoStream(recording);
		System.out.println("Preloading: " + fetchedURL);
		Media toPreload = new Media(fetchedURL);
		songQueue.put(recording, toPreload);
	}
}
