package isaatonimov.invy.runnables;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.services.base.UIHelperService;
import javafx.scene.control.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetMenuItemAction implements Runnable
{
	private MenuItem 	menuItem;
	private FXTrayIcon 	trayIcon;
	private UIHelperService toStart;

	public SetMenuItemAction(FXTrayIcon trayIcon, MenuItem menuItem, UIHelperService toStart)
	{
		this.trayIcon	= trayIcon;
		this.menuItem 	= menuItem;
		this.toStart 	= toStart;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < trayIcon.getMenuItemCount(); i++)
		{
			if(trayIcon.getMenuItem(i).getLabel() == menuItem.getText())
			{
				trayIcon.getMenuItem(i).addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						toStart.startWorking();
					}
				});
			}
		}
	}
}
