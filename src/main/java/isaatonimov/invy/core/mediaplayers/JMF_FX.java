package isaatonimov.invy.core.mediaplayers;

import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.networkmediaplayeruniversal.MultiMedia;
import isaatonimov.networkmediaplayeruniversal.NetworkMediaPlayer;

import java.util.List;

public class JMF_FX extends MusicPlayer
{
	private NetworkMediaPlayer 	networkMediaPlayer;

	@Override
	protected void PlayerSpecificAppendToSongQueue(List<String> audioURLs)
	{
		boolean first = true;
		MultiMedia multiMedia;

		for(var url : audioURLs)
		{
			multiMedia = new MultiMedia(null, url);
			networkMediaPlayer.AddToMediaQueue(multiMedia);

			if(first)
			{
				networkMediaPlayer.DownloadMediaInBackground(multiMedia);
				first = false;
			}

		}
	}

	@Override
	protected void PlayerSpecificPlay(String urlToPlay)
	{
		CurrentState.set(MusicPlayerState.PLAYING);
		for(var multiMedia : networkMediaPlayer.mediaQueueProperty.get())
		{
			if(multiMedia.audioURLProperty.get().toString().equals(urlToPlay))
			{
				try
				{
					networkMediaPlayer.Play(multiMedia);
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	protected void PlayerSpecificResume()
	{
		CurrentState.set(MusicPlayerState.PLAYING);
		networkMediaPlayer.Resume();
	}

	@Override
	protected void PlayerSpecificPause()
	{
		CurrentState.set(MusicPlayerState.PAUSED);
		networkMediaPlayer.Pause();
	}

	@Override
	protected void PlayerSpecificInitPreSongQueueLoaded()
	{
		networkMediaPlayer = new NetworkMediaPlayer();
	}

	@Override
	protected void PlayerSpecificInitPostSongQueueLoaded()
	{
		boolean first = true;
		MultiMedia multiMedia = null;
		for(var url : SongQueue.get().values())
		{
			multiMedia = new MultiMedia(null, url);
			networkMediaPlayer.AddToMediaQueue(multiMedia);

			if(first)
			{
				networkMediaPlayer.DownloadMediaInBackground(multiMedia);
				first = false;
			}
		}
	}

	@Override
	protected void InitPlayerSpecificHandlers()
	{
		networkMediaPlayer.isPlayingProperty.addListener((observable, oldValue, newValue) ->
		{
			if(newValue)
				CurrentState.set(MusicPlayerState.PLAYING);
			else if(!newValue)
				CurrentState.set(MusicPlayerState.PAUSED);
		});

		networkMediaPlayer.runOnEndOfMedia.set(() ->
		{
			PlayNext();
		});
	}

	@Override
	protected void PlayerSpecificShutDown()
	{
		networkMediaPlayer.Shutdown();
	}

	@Override
	protected String PlayerSpecificDescription()
	{
		return "Media Player that should be supported by every operating system. /n" +
			 "Does not require anything special to be installed. /n" +
			 "Relies on mpeg format. /n" +
			 "Does not support streaming currently. /n";
	}
}
