package isaatonimov.invy.services.ui;

import isaatonimov.invy.utils.InvyUtils;
import isaatonimov.invy.services.base.UIHelperService;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SongInfoService extends UIHelperService
{
	@Override
	protected Object ServiceSpecificDo()
	{
		if(ControllerProperty.get().MusicPlayerProperty.get().CurrentlyPlayingRecord != null)
		{
			String targetURL = InvyUtils.getMusicBrainzRecordingURL() + ControllerProperty.get().MusicPlayerProperty.get().CurrentlyPlayingRecord.get().getId();

			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
			{
				try
				{
					Desktop.getDesktop().browse(new URI(targetURL));
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				} catch (URISyntaxException e)
				{
					throw new RuntimeException(e);
				}

				return true;
			} else
				return false;
		}
		else return false;
	}

	@Override
	protected boolean ServiceSpecificOnSuccessDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnFailureDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnInterruptionDo()
	{
		return false;
	}

	@Override
	protected boolean ServerSpecificOnRunningDo()
	{
		return false;
	}

	@Override
	protected void ServiceSpecificOnValuePropertyChanged()
	{

	}
}
