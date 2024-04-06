package isaatonimov.invy.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppUtils
{
	private static Path tempBase = Paths.get("/private/tmp/invyMusicPlayer");
	public static Path getTempDirectory() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		return tempBase;
	}
}
