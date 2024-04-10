package isaatonimov.invy.handlers;

import isaatonimov.invy.core.invidious.InvidiousInstance;
import javafx.event.Event;
import javafx.event.EventHandler;

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
		System.out.println("Source:" + event.getSource().toString());
//		String firstViedoStreamURL =
//				invidiousInstance.fetchVideoStreamURLS(((ArrayList<VideoResult>)((AudioStreamLookupService)(event.getSource())).getValue()).
//				getFirst()).getFirst();

//		invidiousInstance.fetchVideoStream(firstViedoStreamURL);
	}
}
