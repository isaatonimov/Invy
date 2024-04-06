package isaatonimov.invy.ui.runnables;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import javafx.scene.control.MenuItem;

import java.awt.*;

public class SetMenuItemShortcut implements Runnable
{
	private FXTrayIcon 	icon;
	private MenuItem 	menuItem;
	private MenuShortcut  menuShortcut;
	public SetMenuItemShortcut(FXTrayIcon icon, MenuItem menuItem, MenuShortcut menuShortcut)
	{
		this.icon 		= icon;
		this.menuItem 	= menuItem;
		this.menuShortcut = menuShortcut;
	}
	@Override
	public void run()
	{
		for (int i = 0; i < icon.getMenuItemCount(); i++)
		{
			if(icon.getMenuItem(i).getLabel() == menuItem.getText())
				icon.getMenuItem(i).setShortcut(menuShortcut);
		}
	}
}
