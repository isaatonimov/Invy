package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class SongPlayPrevService extends Service<Recording>
{
	private Controller controller;
	private MusicPlayer musicPlayer;
	public SongPlayPrevService(Controller controller)
	{
		this.controller = controller;
		this.musicPlayer = controller.getMusicPlayer();
	}

	@Override
	protected Task<Recording> createTask()
	{
		if(musicPlayer == null)
			musicPlayer = controller.getMusicPlayer();

		if(musicPlayer != null && musicPlayer.currentlyPlaying.get() != null)
		{
			musicPlayer.PlayPrevious();
		}
		else
		{
			controller.playWarningSound();
		}

		return new Task<Recording>()
		{
			@Override
			protected Recording call() throws Exception
			{
				return musicPlayer.currentlyPlaying.get();
			}
		};
	}
}
