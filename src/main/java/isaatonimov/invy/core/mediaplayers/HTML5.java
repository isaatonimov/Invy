package isaatonimov.invy.core.mediaplayers;

import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.enums.MusicPlayerState;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

import java.util.List;

public class HTML5 extends MusicPlayer
{
	private MediaPlayerFactory vlcMediaPlayerFactory;
	private MediaPlayer vlcMediaPlayer;

	public HTML5()
	{
	}

	@Override
	protected void PlayerSpecificAppendToSongQueue(List<String> audioURLs)
	{

	}

	@Override
	protected void PlayerSpecificPlay(String URL)
	{
		CurrentState.set(MusicPlayerState.PLAYING);
		vlcMediaPlayer.submit(() -> vlcMediaPlayer.controls().stop());
		vlcMediaPlayer.submit(() -> vlcMediaPlayer.media().play(URL, ":no-video"));
	}

	@Override
	protected void PlayerSpecificResume()
	{
		CurrentState.set(MusicPlayerState.PLAYING);
		vlcMediaPlayer.submit(() -> vlcMediaPlayer.controls().play());
	}

	@Override
	protected void PlayerSpecificPause()
	{
		CurrentState.set(MusicPlayerState.PAUSED);
		vlcMediaPlayer.submit(() -> vlcMediaPlayer.controls().pause());
	}

	@Override
	protected void PlayerSpecificInitPreSongQueueLoaded()
	{
		vlcMediaPlayerFactory = new MediaPlayerFactory("--no-metadata-network-access");
		vlcMediaPlayer = vlcMediaPlayerFactory.mediaPlayers().newMediaPlayer();
	}

	@Override
	protected void PlayerSpecificInitPostSongQueueLoaded()
	{

	}


	@Override
	protected void InitPlayerSpecificHandlers()
	{
		vlcMediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter()
		{
			@Override
			public void finished(final MediaPlayer mediaPlayer)
			{
				mediaPlayer.submit(() -> PlayNext());
			}

			@Override
			public void paused(MediaPlayer mediaPlayer)
			{
				CurrentState.set(MusicPlayerState.PAUSED);
			}

			@Override
			public void playing(MediaPlayer mediaPlayer)
			{
				CurrentState.set(MusicPlayerState.PLAYING);
			}
		});


	}

	@Override
	protected void PlayerSpecificShutDown()
	{
		vlcMediaPlayer.controls().stop();
	}

	@Override
	protected String PlayerSpecificDescription()
	{
		return "Requires the VLC Player to be installed - supports streaming and is very fast.";
	}

}
