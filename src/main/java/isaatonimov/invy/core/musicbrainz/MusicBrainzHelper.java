package isaatonimov.invy.core.musicbrainz;

import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.jsonmodels.Artist;
import isaatonimov.invy.jsonmodels.ArtistResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.List;

public class MusicBrainzHelper
{
	public static List<Artist> searchForArtis(String query)
	{
		//Set Base URL
		String baseURL = "https://musicbrainz.org/ws/2/";

		//Set Unirest Parrameters
		Unirest.config().defaultBaseUrl(baseURL);
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
	public static List<String> searchForSongs(String query) throws IOException
	{

	}
}
