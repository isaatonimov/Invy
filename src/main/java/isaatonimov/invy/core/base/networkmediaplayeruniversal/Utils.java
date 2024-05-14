package isaatonimov.invy.core.base.networkmediaplayeruniversal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Utils
{
	private static final Path tempBase = Path.of(System.getProperty("java.io.tmpdir") + "/networkMediaPlayerUniversal");

	public static Path getTempDirectoryPath() throws IOException
	{
		if (Files.notExists(tempBase)) Files.createDirectory(tempBase);

		return tempBase;
	}

	public static void clearTempFolder() throws IOException
	{
		if (Files.notExists(tempBase)) Files.createDirectory(tempBase);

		List<File> files = Arrays.stream(Objects.requireNonNull(new File(tempBase.toString()).listFiles())).toList();
		for (var file : files)
			file.delete();
	}
}
