package isaatonimov.invy.core.audiosources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.piped.PipedInstanceInformation;
import isaatonimov.invy.models.piped.PipedSearchResponse;
import isaatonimov.invy.models.piped.StreamResponse;
import isaatonimov.invy.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class Piped extends AudioStreamSource
{
	public Piped() throws Exception
	{
	}

	@Override
	protected boolean ServiceSpecificHasMultipleInstances()
	{
		return true;
	}

	@Override
	protected List<String> ServiceSpecificSearch(Recording record) throws JsonProcessingException
	{
		HttpResponse response = Pow(Unirest.get("/search/").queryString("q", record.toSearchTerm()).queryString("filter", "videos"));
		PipedSearchResponse searchResponse =  ObjectMapper.get().readValue(response.getBody().toString(), PipedSearchResponse.class);

		List<String> ids = new ArrayList<>();

		for (var item : searchResponse.getItems())
			ids.add(item.getUrl().replace("/watch?v=", ""));

		return ids;
	}

	@Override
	protected List<String> ServiceSpecificSearchByID(String id) throws Exception
	{
		CurrentTargetURL.set(ServiceSpecificDefaultURL());
		HttpResponse response = Pow(Unirest.get("/streams/"+id));
		StreamResponse streamResponse = ObjectMapper.get().readValue(response.getBody().toString(), StreamResponse.class);
		List<String> responsesAsString = new ArrayList<>();

		for(var stream : streamResponse.getAudioStreams())
			responsesAsString.add(stream.getUrl());

		return responsesAsString;
	}

	@Override
	protected String ServiceSpecificDefaultURL()
	{
		return Utils.getFallBackPipedInstance();
	}

	@Override
	protected ObservableList<String> ServiceSpecificInstanceLookup() throws JsonProcessingException
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
