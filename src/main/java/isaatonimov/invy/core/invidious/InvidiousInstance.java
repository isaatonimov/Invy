package isaatonimov.invy.core.invidious;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.models.invidious.FormatStream;
import isaatonimov.invy.models.invidious.SearchResponse;
import isaatonimov.invy.models.invidious.VideoResponse;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.beans.property.SimpleStringProperty;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class InvidiousInstance
{
	public SimpleStringProperty InstanceURLProperty = new SimpleStringProperty();

	/**
	 * Constuctor for static instance by instance URL
	 */
	public InvidiousInstance(String instanceURL)
	{
		this.setInstanceURL(instanceURL);
	}

	public InvidiousInstance()
	{

	}

	private String getInstanceURL()
	{
		return this.InstanceURLProperty.get();
	}

	private void setInstanceURL(String instanceURL)
	{
		this.InstanceURLProperty.set(instanceURL);
	}


	public String searchAndGetFirstVideoID(Recording recording) throws NoVideoResultsFoundException, IOException
	{
		List<SearchResponse> searchResponses = search(recording);

		return searchResponses.getFirst().getVideoId();
	}

	public List<SearchResponse> search(Recording recording) throws IOException, NoVideoResultsFoundException
	{
		//currently fixed value
		String searchType = "video";
		Unirest.config().defaultBaseUrl(getInstanceURL());
		//Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		var response = Unirest.get("/api/v1/search").queryString("q", recording.toSearchTerm()).queryString("type", searchType).asString();
		System.out.println("Searched for: " + recording.toSearchTerm());

		ObjectMapper objectMapper = new ObjectMapper();
		List<SearchResponse> searchResponse = objectMapper.readValue(response.getBody().toString(), new TypeReference<List<SearchResponse>>(){});

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "SearchResponse");

		if(searchResponse.size() == 0)
			throw new NoVideoResultsFoundException();
		else
			return searchResponse;
	}

	/*
		Used to be the method of choice to get video streams
		piped offers direct access to audio streams and is more privacy friendly
	 */
	@Deprecated
	public List<FormatStream> fetchFormatStreams(SearchResponse searchResponse) throws IOException
	{
		Unirest.config().defaultBaseUrl(getInstanceURL());
		//Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		HttpResponse<String> response = Unirest.get("/api/v1/videos/" + searchResponse.getVideoId()).asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "VideoResponse");

		ObjectMapper objectMapper = new ObjectMapper();
		VideoResponse videoResponse = objectMapper.readValue(response.getBody().toString(), VideoResponse.class);

		System.out.println("Prinitng Video Stream Format Info");
		for(var formatStream : videoResponse.getFormatStreams())
		{
			System.out.println("Encoding: " + formatStream.getEncoding());
			System.out.println("Quality: " + formatStream.getQuality());
		}

		return videoResponse.getFormatStreams();
	}

	@Deprecated
	public URL SearchAndFetchFirstVideoURL(Recording recording) throws IOException, NoVideoResultsFoundException
	{
		SearchResponse firstSearchResponse = search(recording).getFirst();
		FormatStream firstFormatStream = fetchFormatStreams(firstSearchResponse).getFirst();

		return new URL(firstFormatStream.getUrl());
	}
}
