package isaatonimov.invy.ui.services;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SongInfoService extends Service<Recording>
{
	private Controller controller;
	public SongInfoService(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	protected Task<Recording> createTask()
	{
		if(controller.getMusicPlayer().currentlyPlaying.get() != null)
		{
			String targetURL = "https://musicbrainz.org/recording/" + controller.getMusicPlayer().currentlyPlaying.get().getId();

			System.out.println("Clicked on Song Info:" + targetURL);

			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
			{
				try
				{
					Desktop.getDesktop().browse(new URI(targetURL));
				}
				catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				catch (URISyntaxException e)
				{
					throw new RuntimeException(e);
				}
			}
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
				return controller.getMusicPlayer().currentlyPlaying.get();
			}
		};
	}
}
