package isaatonimov.invy.runnables;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.services.base.UIHelperService;
import javafx.scene.control.MenuItem;

public class SetMenuItemAction implements Runnable
{
	private final MenuItem 	menuItem;
	private final FXTrayIcon 	trayIcon;
	private UIHelperService toStart;
	private Runnable		 toRun;

	public SetMenuItemAction(FXTrayIcon trayIcon, MenuItem menuItem, UIHelperService toStart)
	{
		this.trayIcon	= trayIcon;
		this.menuItem 	= menuItem;
		this.toStart 	= toStart;
	}

	public SetMenuItemAction(FXTrayIcon trayIcon, MenuItem menuItem, Runnable runnable)
	{
		this.trayIcon	= trayIcon;
		this.menuItem 	= menuItem;
		this.toRun 		= toRun;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < trayIcon.getMenuItemCount(); i++)
		{
			if(trayIcon.getMenuItem(i).getLabel() == menuItem.getText())
			{
				trayIcon.getMenuItem(i).addActionListener(e -> toStart.startWorking());
			}
		}
	}
}
