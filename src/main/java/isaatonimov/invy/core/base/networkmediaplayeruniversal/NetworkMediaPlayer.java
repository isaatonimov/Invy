package isaatonimov.invy.core.base.networkmediaplayeruniversal;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.apache.commons.io.FileUtils;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.LinkedList;

public class NetworkMediaPlayer
{
	private final SimpleBooleanProperty isMutedProperty = new SimpleBooleanProperty(false);
	private final SimpleObjectProperty<MediaPlayer> videoPlayerProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<MediaPlayer> audioPlayerProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<Thread> audioDownloadThreadProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<Thread> videoDownloadThreadProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<String> audioBufferFileSuffix = new SimpleObjectProperty<>("_audio");
	private final SimpleObjectProperty<String> videoBufferFileSuffix = new SimpleObjectProperty<>("_video");
	private final SimpleIntegerProperty positionInDownloadQueueProperty = new SimpleIntegerProperty();
	private final SimpleObjectProperty<Thread> playBackThreadProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<String> playNextProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<LinkedList<MultiMedia>> mediaDownloadQueueProperty = new SimpleObjectProperty<>(new LinkedList<>());
	public SimpleObjectProperty<LinkedList<MultiMedia>> mediaQueueProperty = new SimpleObjectProperty<>(new LinkedList<>());
	public SimpleObjectProperty<MediaView> audioViewProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<MediaView> videoViewProperty = new SimpleObjectProperty<>();
	public SimpleBooleanProperty isPlayingProperty = new SimpleBooleanProperty();

	public SimpleObjectProperty<Runnable> runOnEndOfMedia = new SimpleObjectProperty<>();

	public NetworkMediaPlayer()
	{
		try
		{
			Utils.clearTempFolder();
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		SimpleObjectProperty<String> downloadNextProperty = new SimpleObjectProperty<>();
		downloadNextProperty.addListener((observableValue, aBoolean, t1) -> DownloadNext());
	}

	public void AddToMediaQueue(MultiMedia multiMedia)
	{
		mediaQueueProperty.get().add(multiMedia);
		mediaDownloadQueueProperty.get().add(multiMedia);
	}

	public void DownloadMediaInBackground(MultiMedia multiMedia)
	{
		if (multiMedia.audioURLProperty.get() != null)
		{
			audioDownloadThreadProperty.set(new Thread(() ->
			{
				try
				{
					Path currentBufferAudioFilePath = Paths.get(Utils.getTempDirectoryPath().toString(), Math.abs(multiMedia.hashCode()) + audioBufferFileSuffix.get());
					FileUtils.copyURLToFile(multiMedia.audioURLProperty.get(), currentBufferAudioFilePath.toFile(), 100000, 100000);
					File fileToAdd = currentBufferAudioFilePath.toFile();
					File converted = convertToQuickTimeAudio(fileToAdd);
					multiMedia.audioFileProperty.set(converted);

					if (!mediaDownloadQueueProperty.get().isEmpty()) DownloadNext();
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
			}));

			audioDownloadThreadProperty.get().start();
		}

		if (multiMedia.videoURLProperty.get() != null)
		{
			videoDownloadThreadProperty.set(new Thread(() ->
			{
				try
				{
					Path currentBufferVideoFilePath = Paths.get(Utils.getTempDirectoryPath().toString(), Math.abs(multiMedia.hashCode()) + videoBufferFileSuffix.get());
					FileUtils.copyURLToFile(multiMedia.videoURLProperty.get(), currentBufferVideoFilePath.toFile(), 100000, 100000);
					File fileToAdd = currentBufferVideoFilePath.toFile();
					File converted = convertToQuickTimeVideo(fileToAdd);
					multiMedia.videoFileProperty.set(converted);

					if (!mediaDownloadQueueProperty.get().isEmpty()) DownloadNext();
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
			}));

			videoDownloadThreadProperty.get().start();
		}
	}

	public void Pause()
	{
		if (videoPlayerProperty.get() != null && isPlayingProperty.get()) videoPlayerProperty.get().pause();

		if (audioPlayerProperty.get() != null && isPlayingProperty.get()) audioPlayerProperty.get().pause();
	}

	public void Resume()
	{
		if (videoPlayerProperty.get() != null && !isPlayingProperty.get()) videoPlayerProperty.get().play();

		if (audioPlayerProperty.get() != null && !isPlayingProperty.get()) audioPlayerProperty.get().play();
	}

	public void Play(MultiMedia combinedMedia) throws InterruptedException
	{
		isPlayingProperty.set(false);

		playBackThreadProperty.set(new Thread(() ->
		{
			if (videoPlayerProperty.get() != null) videoPlayerProperty.get().stop();

			if (audioPlayerProperty.get() != null) audioPlayerProperty.get().stop();

			while ((combinedMedia.audioURLProperty.get() != null && mediaDownloadQueueProperty.get().get(mediaDownloadQueueProperty.get().indexOf(combinedMedia)).audioFileProperty.get() == null) || (combinedMedia.videoURLProperty.get() != null && mediaDownloadQueueProperty.get().get(mediaDownloadQueueProperty.get().indexOf(combinedMedia)).videoFileProperty.get() == null))
			{
				try
				{
					System.out.println("Cannot Play Media, because it is still downloading, waiting 5 Seconds...");
					Thread.sleep(Duration.ofSeconds(5));
				} catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
			}

			if (combinedMedia.videoURLProperty.get() != null)
			{
				videoPlayerProperty.set(new MediaPlayer(new Media(mediaDownloadQueueProperty.get().get(mediaDownloadQueueProperty.get().indexOf(combinedMedia)).videoFileProperty.get().toURI().toString())));

				videoPlayerProperty.get().setOnError(() -> System.out.println("Media playback Error: " + videoPlayerProperty.get().getError().getMessage()));

				videoPlayerProperty.get().setOnEndOfMedia(() ->
				{
					if (runOnEndOfMedia.get() != null) runOnEndOfMedia.get().run();
				});

				if (videoViewProperty.get() != null) videoViewProperty.get().setMediaPlayer(videoPlayerProperty.get());
			}

			if (combinedMedia.audioURLProperty.get() != null)
			{
				audioPlayerProperty.set(new MediaPlayer(new Media(mediaDownloadQueueProperty.get().get(mediaDownloadQueueProperty.get().indexOf(combinedMedia)).audioFileProperty.get().toURI().toString())));

				audioPlayerProperty.get().setOnError(() -> System.out.println("Media playback Error: " + audioPlayerProperty.get().getError().getMessage()));

				audioPlayerProperty.get().setOnEndOfMedia(() ->
				{
					System.out.println("Media finished, Duration equals to video length or greater. Playing next.");
					playNextProperty.set(combinedMedia.hashCode() + "");
				});

				if (audioViewProperty.get() != null) audioViewProperty.get().setMediaPlayer(audioPlayerProperty.get());

				if (isMutedProperty.get()) audioPlayerProperty.get().muteProperty().set(true);
			}

			if (videoPlayerProperty.get() != null)
			{
				videoPlayerProperty.get().play();
				isPlayingProperty.set(true);
			}


			if (audioPlayerProperty.get() != null)
			{
				audioPlayerProperty.get().play();
				isPlayingProperty.set(true);
			}
		}));

		playBackThreadProperty.get().start();
	}

	private File convertToQuickTimeAudio(File source)
	{
		try
		{
			System.out.println("Trying to convert audio to mp3..");
			File target = new File(source.toPath() + ".aac");

			//Audio Attributes
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("aac");
			audio.setBitRate(192000);
			audio.setChannels(2);

			//Encoding attributes
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setOutputFormat("mp4");
			attrs.setAudioAttributes(audio);

			//Encode
			Encoder encoder = new Encoder();

			encoder.encode(new MultimediaObject(source), target, attrs);
			source.delete();

			return target;

		} catch (Exception ex)
		{
			ex.printStackTrace();

			return null;
		}
	}

	private File convertToQuickTimeVideo(File source)
	{
		try
		{
			File target = new File(source.toPath() + ".mp4");
			VideoAttributes video = new VideoAttributes();
			video.setCodec("mpeg4");
			video.setBitRate(4000000);

			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setOutputFormat("mp4");
			attrs.setVideoAttributes(video);

			Encoder encoder = new Encoder();
			encoder.encode(new MultimediaObject(source), target, attrs);

			source.delete();

			return target;
		} catch (EncoderException e)
		{
			e.printStackTrace();

			return null;
		}
	}

	public void DownloadNext()
	{
		if (positionInDownloadQueueProperty.get() + 1 > mediaDownloadQueueProperty.get().size() - 1)
			System.out.println("Downloaded all Media Files... Waiting for new Items in Media Queue");
		else
		{
			positionInDownloadQueueProperty.set(positionInDownloadQueueProperty.get() + 1);
			DownloadMediaInBackground(mediaDownloadQueueProperty.get().get(positionInDownloadQueueProperty.get()));
		}


	}

	public void ToggleMute()
	{
		isMutedProperty.set(!isMutedProperty.get());

		audioPlayerProperty.get().muteProperty().set(isMutedProperty.get());
	}

	public void Shutdown()
	{
		try
		{
			Utils.clearTempFolder();
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		if (videoPlayerProperty.get() != null) videoPlayerProperty.get().dispose();

		if (audioPlayerProperty.get() != null) audioPlayerProperty.get().dispose();
	}
}
