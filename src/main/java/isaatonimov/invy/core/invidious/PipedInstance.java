package isaatonimov.invy.core.invidious;

import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.piped.AudioStream;
import isaatonimov.invy.models.piped.PipedSearchResponse;
import isaatonimov.invy.models.piped.StreamResponse;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PipedInstance
{
	private URL pipedInstanceURI;
	public PipedInstance(URL pipedInstanceURI)
	{
		this.pipedInstanceURI = pipedInstanceURI;
	}

	/*
		Returns a list of ids vor a specific search of a recording
	 */
	public List<String> search(Recording recording) throws IOException
	{
		Unirest.config().defaultBaseUrl(pipedInstanceURI.toString());
		Unirest.config().cacheResponses(true);

		HttpResponse response = Unirest.get("/search/").queryString("q", recording.toSearchTerm()).queryString("filter", "videos").asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "PipedSearchResponse");

		ObjectMapper objectMapper = new ObjectMapper();
		PipedSearchResponse searchResponse = objectMapper.readValue(response.getBody().toString(), PipedSearchResponse.class);

		List<String> ids = new ArrayList<>();

		for (var item : searchResponse.getItems())
			ids.add(item.getUrl().replace("/watch?v=", ""));

		System.out.println("First ID Found -> " + ids.getFirst());

		return ids;
	}

	public List<AudioStream> getAudioStreamsByVideoID(String videoID) throws IOException
	{
		Unirest.config().defaultBaseUrl(pipedInstanceURI.toString());
		Unirest.config().cacheResponses(true);
		//Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		HttpResponse response = Unirest.get("/streams/"+videoID).asString();

		ObjectMapper objectMapper = new ObjectMapper();
		StreamResponse streamResponse = objectMapper.readValue(response.getBody().toString(), StreamResponse.class);

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "StreamResponse");
		return streamResponse.getAudioStreams();
	}
}
