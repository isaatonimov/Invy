package isaatonimov.invy.core.musicbrainz;

import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.ArtistResponse;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.musicbrainz.RecordingResponse;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class MusicBrainzHelper
{
	public static LinkedList<Artist> searchForArtis(String query) throws IOException, URISyntaxException
	{
		//Set Base URL
		String baseURL = "https://musicbrainz.org/ws/2/";

		//Set Unirest Parrameters
		Unirest.config().defaultBaseUrl(baseURL);
		//TODO Implement caching with guave
		//Unirest.config().cacheResponses()
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		//Get JSON for given Artist (ID)
		var response = Unirest.get("artist").queryString("query", query).queryString("fmt", "json").asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "ArtistModel");

		ObjectMapper objectMapper = new ObjectMapper();

		ArtistResponse musicBrainzArtistResponse = objectMapper.readValue(response.getBody().toString(), ArtistResponse.class);

		return musicBrainzArtistResponse.getArtists();
	}

	/*
		First Draft of search Function, not that nice
	 */
	public static LinkedList<Recording> searchForSongs(Artist artist) throws IOException, URISyntaxException
	{
		//Set Base URL
		String baseURL = "https://musicbrainz.org/ws/2/";
		//Set Unirest Parrameters
		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		HttpResponse response = Unirest.get("recording?artist="+artist.getId()).queryString("fmt", "json").asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "RecordingResponse");

		ObjectMapper objectMapper = new ObjectMapper();
		RecordingResponse recordingResponse = objectMapper.readValue(response.getBody().toString(), RecordingResponse.class);

		//Set Artist Manually
		for(var recording : recordingResponse.getRecordings())
			recording.setArtist(artist);

		return recordingResponse.getRecordings();
	}
}
