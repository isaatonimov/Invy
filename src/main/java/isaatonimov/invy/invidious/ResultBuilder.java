package isaatonimov.invy.invidious;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultBuilder
{

	public static List<String> getVideoStreamsFromJson(String source)
	{
		List<String> streams = new ArrayList<>();

		JSONObject videoObject = new JSONObject(source);

		for(var streamURL : (JSONArray) videoObject.get("formatStreams"))
		{
			streams.add((String)((JSONObject)streamURL).get("url"));
		}

		return streams;
	}

	/*
		Returns a List of VideResults from a result json
		TODO: https://github.com/joelittlejohn/jsonschema2pojo
	 */
	public static List<VideoResult> buildVideoResultFromJSON(String source)
	{
		List<VideoResult> results = new ArrayList<>();
		JSONArray result = new JSONArray(source);

		VideoResult videoResult;

		for (var entry : result)
		{
			String title = (String)((JSONObject) entry).get("title");
			String id = (String)((JSONObject) entry).get("videoId");
			int lengthInSeconds = (int)((JSONObject) entry).get("lengthSeconds");

			videoResult = new VideoResult(title, id, lengthInSeconds);
			System.out.println(videoResult.toString());

			results.add(videoResult);
		}

		return  results;
	}
}
