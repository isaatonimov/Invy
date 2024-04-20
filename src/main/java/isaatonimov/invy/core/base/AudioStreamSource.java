package isaatonimov.invy.core.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.models.JsonModelClassGenerator;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.utils.InvyUtils;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AudioStreamSource
{
	public SimpleBooleanProperty 			HasMultipleInstances 	= new SimpleBooleanProperty(false);
	public SimpleBooleanProperty 			CacheResponses   	= new SimpleBooleanProperty(true);
	public SimpleStringProperty 			CurrentTargetURL 	= new SimpleStringProperty("");
	public SimpleListProperty<String> 		AllAvailableTargets 	= new SimpleListProperty<>(FXCollections.observableArrayList());
	public SimpleObjectProperty<HttpRequest>	CurrentRequest		= new SimpleObjectProperty<>(Unirest.get(""));
	public SimpleBooleanProperty			SpeedTestInProgress	= new SimpleBooleanProperty(false);
	public SimpleObjectProperty<ObjectMapper>	ObjectMapper		= new SimpleObjectProperty<>(new ObjectMapper());

	/*
		Default Constructor with Listener that sets the UnirestConfig when the InstanceURL changes
	 */
	public AudioStreamSource() throws Exception
	{
		CurrentTargetURL.addListener((observable, oldValue, newValue) ->
		{
			Unirest.config().defaultBaseUrl(CurrentTargetURL.get());
		});

		CurrentTargetURL.set(ServiceSpecificDefaultURL());
		SetUnirestDefaults();
	}

	/*
		Sets Unirest Default Config, when an InstanceURL is set - it will be set via an event
	 */
	private void SetUnirestDefaults()
	{
		Unirest.config().cacheResponses(CacheResponses.get());
		Unirest.config().setDefaultHeader("User-Agent", InvyUtils.getUserAgentString());
	}

	/*
		Executes the APISpecificSearch Method... nothing more yet
	 */
	public List<String> Search(Recording record) throws Exception
	{
		SetUnirestDefaults();
		Unirest.config().defaultBaseUrl(ServiceSpecificDefaultURL());

		System.out.println("Searching with Audio Stream Source: " + getClass().getName());
		return ServiceSpecificSearch(record);
	}

	public List<String> SearchByID(String id) throws Exception
	{
		SetUnirestDefaults();
		Unirest.config().defaultBaseUrl(ServiceSpecificDefaultURL());

		System.out.println("Starting search by id of " + getClass().getName() + " Audio Stream Service.");
		return ServiceSpecificSearchByID(id);
	}

	public boolean HasMultipleInstances()
	{
		boolean hasMultiple = ServiceSpecificHasMultipleInstances();
		HasMultipleInstances.set(hasMultiple);
		return hasMultiple;
	}

	public String GetDefaultURL() throws Exception
	{
		String defaultURl = ServiceSpecificDefaultURL();
		CurrentTargetURL.set(defaultURl);
		return defaultURl;
	}

	public ObservableList<String> LookupInstances() throws Exception
	{
		ObservableList<String> instances = ServiceSpecificInstanceLookup();
		AllAvailableTargets.set(instances);

		return instances;
	}

	/*
		Issues a simple HTTP Request
		CurrentTargetURL must be set
		CurrentModelToMap must be set
	 */
	public HttpResponse Pow(HttpRequest customRequest)
	{
		HttpResponse response = customRequest.asString();

		//System.out.println("Reveiced HTTP Response from " + CurrentTargetURL.get() + " -> \n" +
				//response.getBody().toString());
		//System.out.println("Request was the following -> \n " +
				//customRequest.asString().getBody().toString());

		return response;
	}

	public HttpResponse Pow()
	{
		return Unirest.get("").asString();
	}

	public void DoSpeedTestAndSetAppropriately()
	{
		String targetURL = SimpleSpeedTest();
		CurrentTargetURL.set(targetURL);
	}

	/*
		Returns an URL-String of the nearest Instance in Milliseconds
		Must be given a List of URL-Strings to check, if they are not valid an exception will be thrown
	 */
	public static String SimpleSpeedTest(List<String> InstanceURLsToCheck)
	{
		Map<String, Long> connectionResults = new HashMap<>();
		System.out.println("Starting Piped Connection Test:");

		for(var instanceURL : InstanceURLsToCheck)
		{
			Unirest.config().defaultBaseUrl(instanceURL);
			long start = System.currentTimeMillis();
			HttpResponse response = Unirest.get("").asString();
			long end = System.currentTimeMillis();
			connectionResults.put(instanceURL, end-start);
		}

		LinkedHashMap<String, Long> testResultSorted = connectionResults.entrySet().
				stream().
				sorted(Map.Entry.comparingByValue()).
				collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return testResultSorted.firstEntry().getKey();
	}

	/*
		Same Method but non-static - uses AllAvailableInstances Property
	 */
	public String SimpleSpeedTest()
	{
		SpeedTestInProgress.set(true);
		List<String> InstanceURLsToCheck = AllAvailableTargets.get();
		SpeedTestInProgress.set(false);
		return SimpleSpeedTest(InstanceURLsToCheck);
	}

	/*
	Helper Function to test out APIs that return Audio Sources. Generates Java Classes
	and puts them somewhere into the classpath. Should just be used in development or when you are a
	reflection wizard.
 */
	public static void GenerateModelsFromJSON(HttpRequest httpRequestThatLeadsToJson, String ModelName) throws IOException
	{
		HttpResponse response = httpRequestThatLeadsToJson.asString();
		JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), ModelName);
	}

	protected abstract boolean					ServiceSpecificHasMultipleInstances();
	protected abstract List<String> 				ServiceSpecificSearch(Recording record) throws Exception;
	protected abstract List<String> 				ServiceSpecificSearchByID(String id) throws Exception;
	protected abstract String 					ServiceSpecificDefaultURL() throws Exception;
	protected abstract ObservableList<String> 		ServiceSpecificInstanceLookup() throws Exception;
}
