package isaatonimov.invy.core.metadatasources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import isaatonimov.invy.App;
import isaatonimov.invy.core.base.AudioMetadataSource;
import isaatonimov.invy.models.musicbrainz.*;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MusicBrainz extends AudioMetadataSource
{

	public static LinkedList<Artist> searchForFirstXArtists(String query, int numberOfResults)
	{
		//Set Base URL
		String baseURL = "https://musicbrainz.org/ws/2/";

		//Set Unirest Parameters
		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().cacheResponses(true);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		//Get JSON for given Artist (ID)
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

			for(int i = 0; i < numberOfResults; i++)
				xResults.add(musicBrainzArtistResponse.getArtists().get(i));

			return xResults;
		}
		catch (JsonProcessingException e)
		{
			LinkedList<Artist> nothingFound = new LinkedList<>();
			Artist dummyArtist = new Artist();
			dummyArtist.setName("Search did not complete successfully... do you have an internet Connection?");
			nothingFound.add(dummyArtist);
			return nothingFound;
		}


	}

	public static String searchForCoverArt(Release release) throws IOException, InterruptedException, URISyntaxException
	{
		String baseURL = "https://coverartarchive.org/";

		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		TimeUnit.MILLISECONDS.sleep(30);

		HttpResponse<String> response = Unirest.get("release/"+release.getId()).asString();

		//Generate JSON Model Class from JSON - enabled just in development
		//JsonModelClassGenerator.generateJSONModelClassFromJSONString(response.getBody().toString(), "CoverArtResponse");

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

		for(var record : allRecordings)
		{
			record.setArtist(artist);
			System.out.println("Song from Release -> " + record.getRelease().getTitle() + " = " + record.getTitle());
		}

		return allRecordings.stream().distinct().collect(Collectors.toList());
	}
}
