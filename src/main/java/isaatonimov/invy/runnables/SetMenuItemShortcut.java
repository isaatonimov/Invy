package isaatonimov.invy.runnables;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import javafx.scene.control.MenuItem;

import java.awt.*;

public class SetMenuItemShortcut implements Runnable
{
	private final FXTrayIcon 	icon;
	private final MenuItem 	menuItem;
	private final MenuShortcut  menuShortcut;
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
