package isaatonimov.invy.core.mediaplayers;

import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.enums.MusicPlayerState;
import javafx.application.Platform;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

import java.io.IOException;
import java.net.URISyntaxException;

public class VLC extends MusicPlayer
{
	private MediaPlayerFactory 	vlcMediaPlayerFactory;
	private MediaPlayer 		vlcMediaPlayer;

	public VLC() throws IOException, URISyntaxException
	{
	}

	@Override
	protected void PlayerSpecificPlay()
	{
		vlcMediaPlayer.media().play(CurrentTargetAudioSourceURL.get(), ":no-video");
	}

	@Override
	protected void PlayerSpecificResume()
	{
		vlcMediaPlayer.controls().play();
	}

	@Override
	protected void PlayerSpecificPause()
	{
		vlcMediaPlayer.controls().pause();
	}

	@Override
	protected void PlayerSpecificInit()
	{
		BufferFileRequired.set(false);

		vlcMediaPlayerFactory 	= new MediaPlayerFactory("--no-metadata-network-access");
		vlcMediaPlayer 			= vlcMediaPlayerFactory.mediaPlayers().newMediaPlayer();
	}

	@Override
	protected void InitPlayerSpecificHandlers()
	{
		vlcMediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter()
		{
			@Override
			public void finished(MediaPlayer mediaPlayer)
			{
				Platform.runLater(() -> PlayNext());
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
	protected boolean RequireLocallyStoredBuffer()
	{
		return false;
	}
}
