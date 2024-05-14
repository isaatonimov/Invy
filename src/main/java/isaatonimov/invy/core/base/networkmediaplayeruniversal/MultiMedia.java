package isaatonimov.invy.core.base.networkmediaplayeruniversal;

import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MultiMedia
{
	public SimpleObjectProperty<URL> videoURLProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<URL> audioURLProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<File> videoFileProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<File> audioFileProperty = new SimpleObjectProperty<>();

	public MultiMedia(String videoURL, String audioURL)
	{
		try
		{
			if (videoURL != null) videoURLProperty.set(new URL(videoURL));

			if (audioURL != null) audioURLProperty.set(new URL(audioURL));
		} catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
