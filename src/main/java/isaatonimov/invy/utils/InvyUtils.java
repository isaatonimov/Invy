package isaatonimov.invy.utils;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.core.base.MusicPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class InvyUtils
{
	private static final Path tempBase = Path.of(System.getProperty("java.io.tmpdir") + "/invyMusicPlayer/");

	public static Path 		getTempDirectoryPath() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		return tempBase;
	}
	public static File 		getTempDirectoryFile()
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
	public static void 		clearTempFolder() throws IOException
	{
		if(Files.notExists(tempBase))
			Files.createDirectory(tempBase);

		List<File> files = Arrays.stream(Objects.requireNonNull(new File(tempBase.toString()).listFiles())).toList();
		for(var file : files)
			file.delete();
	}
	public static List<String> 	getAvailableMediaPlayersAsList() throws IOException
	{
		String pkg = "isaatonimov.invy.core.mediaplayers";

		List<String> mediaPlayers = new ArrayList<>();
		try (ScanResult scanResult = new ClassGraph().enableClassInfo().acceptPackages(pkg).scan())
		{
			for (var cl : scanResult.getAllClasses())
			{
				if(cl.extendsSuperclass(MusicPlayer.class))
					mediaPlayers.add(cl.getSimpleName());
			}
		}

		return mediaPlayers;
	}
	public static Class 		getMusicPlayerClassFromName(String className)
	{
		String pkg = "isaatonimov.invy.core.mediaplayers";
		Class firstFound = null;

		try (ScanResult scanResult = new ClassGraph().enableClassInfo().acceptPackages(pkg).scan())
		{
			for (var cl : scanResult.getAllClasses())
			{
				if(cl.extendsSuperclass(MusicPlayer.class))
				{
					if (firstFound == null)
						firstFound = cl.getClass();

					if(cl.getSimpleName().contains(className))
						return cl.getClass().getClass();
				}

			}
		}

		return firstFound;
	}
	public static Class 		getAudioSourcerClassFromClassName(String className)
	{
		String pkg = "iaatonimov.invy.core.audiosources";
		Class firsFound = null;

		try (ScanResult scanResult = new ClassGraph().enableClassInfo().acceptPackages(pkg).scan())
		{
			for (var cl : scanResult.getAllClasses())
			{
				if(firsFound == null)
					firsFound = cl.getClass();

				if(cl.extendsSuperclass(AudioStreamSource.class))
					if(cl.getSimpleName() == className)
						return cl.getClass();
			}
		}

		return firsFound;
	}
	public static List<String> 	getAvailableAudioSourcesAsList()
	{
		String pkg = "isaatonimov.invy.core.audiosources";

		List<String> audioSources = new ArrayList<>();
		try (ScanResult scanResult = new ClassGraph().enableClassInfo().acceptPackages(pkg).scan())
		{
			for (var cl : scanResult.getAllClasses())
			{
				if(cl.extendsSuperclass(AudioStreamSource.class))
					audioSources.add(cl.getSimpleName());
			}
		}

		return audioSources;
	}
	public static List<String> 	getAllAvailableThemesAsList() throws IOException
	{
		List<String> resourcePaths;

		try (ScanResult scanResult = new ClassGraph().acceptPaths("/isaatonimov/invy/themes").scan())
		{
			resourcePaths = scanResult.getAllResources().getPaths();
		}

		for(var resource : resourcePaths)
			resource = resource.substring(resource.lastIndexOf('-') + 1);

		return resourcePaths;
	}
	public static String themeNameToCss(String themeName)
	{
		return "";
	}
	public static String getUserAgentString()
	{
		return "InvyMediaPlayer/0.0.1";
	}
	public static String getFallBackPipedInstance()
	{
		return "https://pipedapi.kavin.rocks";
	}
	public static String getFallBackInvidiousInstance()
	{
		return "https://yewtu.be/";
	}
	public static String getMusicBrainzRecordingInformationBaseURL()
	{
		return "https://musicbrainz.org/recording/";
	}
}
