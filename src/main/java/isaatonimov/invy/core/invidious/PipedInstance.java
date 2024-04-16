package isaatonimov.invy.core.invidious;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.piped.AudioStream;
import isaatonimov.invy.models.piped.InstancesResponse;
import isaatonimov.invy.models.piped.PipedSearchResponse;
import isaatonimov.invy.models.piped.StreamResponse;
import javafx.beans.property.SimpleStringProperty;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PipedInstance
{
	public SimpleStringProperty InstanceURLProperty = new SimpleStringProperty();

	public PipedInstance(String instanceURL)
	{
		this.setInstanceURL(instanceURL);
	}

	public PipedInstance()
	{

	}

	private void setInstanceURL(String instanceURL)
	{
		this.InstanceURLProperty.set(instanceURL);
	}

	private String getInstanceURL()
	{
		return this.InstanceURLProperty.get();
	}


	/*
		Returns a list of ids vor a specific search of a recording
	 */
	public List<String> search(Recording recording) throws IOException
	{
		Unirest.config().defaultBaseUrl(getInstanceURL());
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
		Unirest.config().defaultBaseUrl(getInstanceURL());
		Unirest.config().cacheResponses(true);
		//Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		HttpResponse response = Unirest.get("/streams/"+videoID).asString();

		ObjectMapper objectMapper = new ObjectMapper();
		StreamResponse streamResponse = objectMapper.readValue(response.getBody().toString(), StreamResponse.class);

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "StreamResponse");
		return streamResponse.getAudioStreams();
	}

	public static List<InstancesResponse> getPipedInstances() throws JsonProcessingException
	{
		//https://piped-instances.kavin.rocks/

		Unirest.config().defaultBaseUrl("https://piped-instances.kavin.rocks/");
		HttpResponse response = Unirest.get("").asString();

		ObjectMapper objectMapper = new ObjectMapper();
		List<InstancesResponse> instancesResponse = objectMapper.readValue(response.getBody().toString(), new TypeReference<List<InstancesResponse>>(){});

		return instancesResponse;
	}

	public static String getNearestPipedInstanceRelativeToHost(List<InstancesResponse> pipedInstances) throws JsonProcessingException
	{
		if(pipedInstances == null)
			pipedInstances = getPipedInstances();

		Map<InstancesResponse, Long> 	connectionResults = new HashMap<>();
		System.out.println("Starting Piped Connection Test:");

		for(var instance : pipedInstances)
		{
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Testing - " + instance.getApiUrl());
			Unirest.config().defaultBaseUrl(instance.getApiUrl());
			long start = System.currentTimeMillis();
			HttpResponse response = Unirest.get("").asString();
			System.out.println("Response Status Code " + response.getStatus());
			long end = System.currentTimeMillis();
			System.out.println("Response Time was "+(end-start)+" ms.");
			System.out.println("------------------------------------------------------------------------------");

			connectionResults.put(instance, end-start);
		}

		LinkedHashMap<InstancesResponse, Long> testResultSorted = connectionResults.entrySet().
		stream().
		sorted(Map.Entry.comparingByValue()).
		collect(Collectors.toMap(
		Map.Entry::getKey,
		Map.Entry::getValue,
		(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println("Last" + testResultSorted.lastEntry().getKey().getApiUrl());
		System.out.println("Location" + testResultSorted.lastEntry().getKey().getLocations());
		System.out.println("With time" + testResultSorted.lastEntry().getValue() + "ms");

		System.out.println("First" + testResultSorted.firstEntry().getKey().getApiUrl());
		System.out.println("Location" + testResultSorted.firstEntry().getKey().getLocations());
		System.out.println("With time" + testResultSorted.firstEntry().getValue() + "ms");

		return testResultSorted.firstEntry().getKey().getApiUrl();
	}
}
