package isaatonimov.invy.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AppUtils
{
	private static Path tempBase = Paths.get("/private/tmp/invyMusicPlayer");

	public static URI getMainInvidiousInstanceURL() throws URISyntaxException
	{
		//TODO -> Replace with dynamic List by Region -> auto-pick
		return new URI("https://iv.nboeck.de");
	}
	public static Path getTempDirectory() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		return tempBase;
	}

	public static void clearTempFolder() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		List<File> files = Arrays.stream(new File(tempBase.toString()).listFiles()).toList();
		for(var file : files)
			file.delete();
	}
}
