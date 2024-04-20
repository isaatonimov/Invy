package isaatonimov.invy.core.mediaplayers;

import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.enums.MusicPlayerState;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URISyntaxException;

public class JMF extends MusicPlayer
{
	private Media 		currentMedia;
	private MediaPlayer 	jmfMediaPlayer;

	public JMF() throws IOException, URISyntaxException
	{

	}
	private void handlers()
	{
		jmfMediaPlayer.setOnEndOfMedia(() 	-> PlayNext());
		jmfMediaPlayer.setOnPlaying(() 		-> CurrentState.set(MusicPlayerState.PLAYING));
		jmfMediaPlayer.setOnPaused(() 		-> CurrentState.set(MusicPlayerState.PAUSED));
		jmfMediaPlayer.setOnError(() 		-> System.out.println("JMF Error: " + jmfMediaPlayer.getError()));
	}

	@Override
	protected void PlayerSpecificPlay()
	{
		currentMedia = new Media(BufferFile.get().toURI().toString());
		jmfMediaPlayer.dispose();
		jmfMediaPlayer = new MediaPlayer(currentMedia);
		handlers();
		jmfMediaPlayer.play();
	}

	@Override
	protected void PlayerSpecificResume()
	{
		jmfMediaPlayer.play();
	}

	@Override
	protected void PlayerSpecificPause()
	{
		jmfMediaPlayer.pause();
	}

	@Override
	protected void PlayerSpecificInit()
	{
		currentMedia 	= new Media(BufferFile.get().toURI().toString());
		jmfMediaPlayer 	= new MediaPlayer(currentMedia);
	}

	@Override
	protected void InitPlayerSpecificHandlers()
	{
		handlers();
	}

	@Override
	protected void PlayerSpecificShutDown()
	{
		jmfMediaPlayer.dispose();
	}

	@Override
	protected boolean RequireLocallyStoredBuffer()
	{
		return true;
	}
}
