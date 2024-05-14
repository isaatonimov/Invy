package isaatonimov.invy.core.audiosources;

import com.fasterxml.jackson.core.type.TypeReference;
import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.models.generator.JsonModelClassGenerator;
import isaatonimov.invy.models.invidious.SearchResponse;
import isaatonimov.invy.models.invidious.VideoResponse;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.piped.PipedInstanceInformation;
import isaatonimov.invy.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Invidious extends AudioStreamSource
{
	public Invidious() throws Exception
	{
	}

	@Override
	protected boolean ServiceSpecificHasMultipleInstances()
	{
		//TODO implement api for instances fetching like piped
		return false;
	}

	@Override
	protected List<String> ServiceSpecificSearch(Recording record) throws Exception
	{
		String searchType = "video";

		HttpResponse response = Pow(Unirest.get("/api/v1/search").queryString("q", record.toSearchTerm()).queryString("type", searchType));
		List<SearchResponse> searchResponses = ObjectMapper.get().readValue(response.getBody().toString(), new TypeReference<List<SearchResponse>>(){});
		List<String> searchResponsesAsString = new ArrayList<>();

		for(var searchresponse : searchResponses)
		{
			searchResponsesAsString.add(searchresponse.getVideoId());
		}

		return searchResponsesAsString;
	}

	@Override
	protected List<String> ServiceSpecificSearchByID(String id) throws Exception
	{
		HttpResponse response = Pow(Unirest.get("/api/v1/videos/" + id));
		VideoResponse videoResponse = ObjectMapper.get().readValue(response.getBody().toString(), VideoResponse.class);
		List<String>   videoResponseAsString = new ArrayList<>();

		for(var stream : videoResponse.getFormatStreams())
			videoResponseAsString.add(stream.getUrl());

		return videoResponseAsString;
	}

	@Override
	protected String ServiceSpecificDefaultURL() throws Exception
	{
		return Utils.getFallBackInvidiousInstance();
	}

	@Override
	protected ObservableList<String> ServiceSpecificInstanceLookup() throws Exception
	{
		System.out.println("Trying to resolve Piped Instances...");
		CurrentTargetURL.set("https://piped-instances.kavin.rocks/");
		HttpResponse response = Pow();

		List<PipedInstanceInformation> pipedInstanceInfos = ObjectMapper.get().readValue(response.getBody().toString(), new TypeReference<List<PipedInstanceInformation>>(){});
		List<String> instanceInfoAsString = new ArrayList<>();

		for(var infoObject : pipedInstanceInfos)
			instanceInfoAsString.add(infoObject.getApiUrl());

		return FXCollections.observableArrayList(instanceInfoAsString);
	}
}
