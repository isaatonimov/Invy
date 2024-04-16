package isaatonimov.invy.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class AppUtils
{
	private static Path tempBase = Path.of(System.getProperty("java.io.tmpdir") + "/invyMusicPlayer/");

	public static Path getTempDirectoryPath() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		return tempBase;
	}

	public static File getTempDirectoryFile()
	{
		File tmpDir = null;

		try
		{
			tmpDir = new File(getTempDirectoryPath().toString());
		}
		catch (IOException e)
		{
			//TODO Handle
			throw new RuntimeException(e);
		}

		return tmpDir;
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
