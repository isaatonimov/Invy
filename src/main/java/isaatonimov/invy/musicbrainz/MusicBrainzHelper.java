package isaatonimov.invy.musicbrainz;

import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MusicBrainzHelper
{
	/*
		First Draft of search Function, not that nice
	 */
	public static List<String> searchForSongs(String query)
	{
		String baseURL = "https://musicbrainz.org/ws/2/";

		Unirest.config().defaultBaseUrl(baseURL);
		Unirest.config().setDefaultHeader("User-Agent", "InvyMediaPlayer/0.0.1 ( isaatonimov@proton.me )");

		var response = Unirest.get("artist").queryString("query", query).queryString("fmt", "json").asString();

		JSONObject jsonResponse = new JSONObject(response.getBody().toString());

		JSONArray artists = new JSONArray(jsonResponse.get("artists").toString());

		List<String> top3 = new ArrayList<>();

		for(int i = 0; i < 3; i++)
		{
			var id = ((JSONObject) artists.get(i)).get("id");
			var name = ((JSONObject) artists.get(i)).get("name");

			System.out.println("Artist Name:" + name);
			System.out.println("Artist ID: " + id);

			top3.add((String)id);
		}

		List<String> allSongs = new ArrayList<>();

		for(var artist : top3)
		{
			try
			{
				Thread.sleep(Duration.ofSeconds(1).toMillis());
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}

			response = Unirest.get("recording?artist="+artist).queryString("fmt", "json").asString();

			JSONObject tracksResult = new JSONObject(response.getBody().toString());
			JSONArray tracks = new JSONArray(tracksResult.get("recordings").toString());

			for (var track : tracks)
			{
				var title = ((JSONObject)track).get("title");

				String titleToAdd = query + "Band" + title;

				allSongs.add(titleToAdd);
			}
		}

		return allSongs;
	}
}
