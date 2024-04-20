package isaatonimov.invy.core.metadatasources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.App;
import isaatonimov.invy.core.base.AudioMetadataSource;
import isaatonimov.invy.exceptions.NoArtistFoundException;
import isaatonimov.invy.models.musicbrainz.*;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MusicBrainz extends AudioMetadataSource
{

	public static LinkedList<Artist> searchForFirstXArtists(String query, int numberOfResults) throws NoArtistFoundException
	{
		//Set Base URL
		String baseURL = "https://musicbrainz.org/ws/2/";

		//Set Unirest Parameters
		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().cacheResponses(true);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		//Get JSON for given Artist (ID)
		try
		{
			var response = Unirest.get("artist").queryString("query", query).queryString("fmt", "json").asString();

			//Generate JSON Model Class from JSON - enabled just in development
			//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "ArtistModel");

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			ArtistResponse musicBrainzArtistResponse = null;

			try
			{
				musicBrainzArtistResponse = objectMapper.readValue(response.getBody(), ArtistResponse.class);

				LinkedList<Artist> xResults = new LinkedList<>();

				if(musicBrainzArtistResponse.getArtists().size() == 0)
					throw new NoArtistFoundException();
				else
				{
					for(int i = 0; i < numberOfResults; i++)
						xResults.add(musicBrainzArtistResponse.getArtists().get(i));

					return xResults;
				}
			}
			catch (JsonProcessingException e)
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String searchForCoverArt(Release release) throws IOException, InterruptedException, URISyntaxException
	{
		String baseURL = "https://coverartarchive.org/";

		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		TimeUnit.MILLISECONDS.sleep(30);


		try
		{
			HttpResponse<String> response = Unirest.get("release/"+release.getId()).asString();

			ObjectMapper objectMapper = new ObjectMapper();
			CoverArtResponse coverArtResponse = objectMapper.readValue(response.getBody(), CoverArtResponse.class);

			System.out.println("Cover Art for Release -> " + release.getDisambiguation() + " -> " + coverArtResponse.getImages().getFirst().getImage());
			System.out.println(response.getStatus());

			if(coverArtResponse.getImages() != null)
				return coverArtResponse.getImages().getFirst().getThumbnails().getSmall();
			else if(App.class.getResource("/images/logo.png") != null)
				return Objects.requireNonNull(App.class.getResource("/images/logo.png")).getPath();
			else
				return "";
		}
		catch (Exception e)
		{
			return "";
		}

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "CoverArtResponse");
	}

	public static List<Release> searchForReleases(Artist artist) throws IOException, InterruptedException
	{
		String baseURL = "https://musicbrainz.org/ws/2/";

		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().cacheResponses(true);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		TimeUnit.MILLISECONDS.sleep(50);

		HttpResponse<String> response = Unirest.get("release?artist="+artist.getId()).queryString("limit", 50).queryString("fmt", "json").asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "ReleaseResponse");

		ObjectMapper objectMapper = new ObjectMapper();
		ReleaseResponse releaseResponse = objectMapper.readValue(response.getBody(), ReleaseResponse.class);

		List<Release> releases = new ArrayList<>();

		for(var release : releaseResponse.getReleases())
		{
			release.setArtist(artist);
			releases.add(release);
		}

		return releases;
	}

	public static List<Recording> getTrackList(Release release) throws IOException, InterruptedException
	{
		String baseURL = "https://musicbrainz.org/ws/2/";

		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().cacheResponses(true);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		TimeUnit.MILLISECONDS.sleep(50);

		HttpResponse<String> response = Unirest.get("recording?release="+release.getId()).queryString("limit", 50).queryString("fmt", "json").asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "TracklistReleaseResponse");

		ObjectMapper objectMapper = new ObjectMapper();
		TracklistReleaseResponse tracklistReleaseResponse = objectMapper.readValue(response.getBody(), TracklistReleaseResponse.class);

		for(var track : tracklistReleaseResponse.getRecordings())
		{
			track.setRelease(release);
		}

		return tracklistReleaseResponse.getRecordings();
	}

	/*
		@Credits to: https://stackoverflow.com/users/1571871/samyonnou
	 */
	static void removeDuplicateRecords(List<Recording> array) {
		for (int i = 0; i < array.size(); i++) {
			Recording next = array.get(i);

			for (int j = 0; j < i; j++) {
				if (next.equals(array.get(j))) {
					array.remove(i);
					i--;
					break;
				}
			}
		}
	}

	/*
		First Draft of search Function, not that nice
	 */
	public static List<Recording> searchForSongs(Artist artist) throws IOException, InterruptedException
	{
		LinkedList<Recording> allRecordings = new LinkedList<>();

		List<Release> releases = searchForReleases(artist);

		for (var release : releases)
		{
			allRecordings.addAll(getTrackList(release));
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Returning the following Releases found by MusicBrainz:");


		removeDuplicateRecords(allRecordings);

		for(var record : allRecordings)
		{
			record.setArtist(artist);
			System.out.println("Song from Release -> " + record.getRelease().getTitle() + " = " + record.getTitle());
		}

		System.out.println("-------------------------------------------------------------------------------");

		return allRecordings;
	}
}
