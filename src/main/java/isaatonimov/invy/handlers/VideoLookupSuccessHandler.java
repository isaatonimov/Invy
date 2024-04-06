package isaatonimov.invy.handlers;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.core.invidious.VideoResult;
import isaatonimov.invy.ui.services.VideoLookupService;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class VideoLookupSuccessHandler implements EventHandler
{
	private InvidiousInstance invidiousInstance;

	public VideoLookupSuccessHandler(InvidiousInstance source)
	{
		invidiousInstance = source;
	}
	/*
		Currently just fetches the first video url then passes it to fetchVideoStream which currently downloads the video
		then converts it into an .mp3
	 */
	@Override
	public void handle(Event event)
	{
		ArrayList<VideoResult> videoResults = (ArrayList<VideoResult>) ((VideoLookupService)event.getSource()).getValue();

		System.out.println("Source:" + event.getSource().toString());
		System.out.println("Video Results: " + videoResults.toString());

//		String firstViedoStreamURL =
//				invidiousInstance.fetchVideoStreamURLS(((ArrayList<VideoResult>)((VideoLookupService)(event.getSource())).getValue()).
//				getFirst()).getFirst();

//		invidiousInstance.fetchVideoStream(firstViedoStreamURL);
	}
}
