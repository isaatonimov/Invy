package isaatonimov.invy.invidious;

import isaatonimov.invy.App;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import kong.unirest.Unirest;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class InvidiousInstance
{
	private URI instanceURL;
	/**
	 * Constuctor for static instance by instance URL
	 */
	public InvidiousInstance(URI instanceURL)
	{
		this.instanceURL = instanceURL;
	}

	/**
	 * Constructor for automatic instance selection by region
	 */
	public InvidiousInstance(String region)
	{

	}

	public List<VideoResult> search(String searchTerm) throws IOException
	{
		//currently fixed value
		String searchType = "video";
		Unirest.config().defaultBaseUrl(instanceURL.toString());

		var response = Unirest.get("/api/v1/search").queryString("q", searchTerm).queryString("type", searchType).asString();

		return ResultBuilder.buildVideoResultFromJSON(response.getBody().toString());
	}

	public List<String> fetchVideoStreamURLS(VideoResult videoResult)
	{
		Unirest.config().defaultBaseUrl(instanceURL.toString());

		var response = Unirest.get("/api/v1/videos/" + videoResult.getVideoID()).asString();

		return ResultBuilder.getVideoStreamsFromJson(response.getBody().toString());
	}

	public String fetchVideoStream(String videoURL)
	{
		//File result = Unirest.get(videoURL).asFile("/private/tmp/output_video/output.1").getBody();
		FFmpeg ffmpeg;
		FFprobe fFprobe;
		try
		{
			ffmpeg = new FFmpeg(App.class.getResource("ffmpeg").getPath());
			fFprobe = new FFprobe(App.class.getResource("ffprobe").getPath());

		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		FFmpegBuilder builder = new FFmpegBuilder().
				setInput("/private/tmp/output_video/output.1").
				addOutput("/private/tmp/output_video/output.mp3").done();

		FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, fFprobe);

		executor.createJob(builder).run();

		System.out.println("Finished downloading and converting video.");
		System.out.println("Playing Video");

		Media sound = new Media(new File("/private/tmp/output_video/output.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();

		return "";
	}

	public void fetchVideoStream()
	{

	}
}
