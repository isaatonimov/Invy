package isaatonimov.invy.ui.runnables;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.scene.control.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetMenuItemAction implements Runnable
{
	private MenuItem 	menuItem;
	private FXTrayIcon 	trayIcon;
	private Service toStart;

	public SetMenuItemAction(FXTrayIcon trayIcon, MenuItem menuItem, Service toStart)
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
						Platform.runLater(new Runnable()
						{
							@Override
							public void run()
							{
								toStart.restart();
							}
						});
					}
				});
			}
		}
	}
}
