package isaatonimov.invy.core.invidious;

public class VideoResult
{
	public VideoResult(String title, String id, int lengthInSeconds)
	{
		this.title = title;
		this.id = id;
		this.lengthInSeconds = lengthInSeconds;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	private String title;
	private String id;
	private int lengthInSeconds;

	public String getVideoID()
	{
		return id;
	}

	public void setVideoID(String videoID)
	{
		this.id = videoID;
	}

	public int getLengthInSeconds()
	{
		return lengthInSeconds;
	}

	public void setLengthInSeconds(int lengthInSeconds)
	{
		this.lengthInSeconds = lengthInSeconds;
	}


	@Override
	public String toString()
	{
		return title + "\n";
	}

}
