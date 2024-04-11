package isaatonimov.invy;

import java.awt.*;

/**
 * Credits to https://stackoverflow.com/users/1990216/cai
 - This class is intended to start application as AWT application before initializing
 - JavaFX application. JavaFX does not support dock-icon-less application so we are
 - creating JavaFX application from AWT application so that we can achieve the desired
 - functionality.
 - */

public class AWTMain {

	public static void main(String[] args)
	{

		// This is awt property which enables dock-icon-less
		// applications
		System.setProperty("apple.awt.UIElement", "true");
		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();

		// This is a call to JavaFX application main method.
		// From now on we are transferring control to FX application.
		App.main(args);
	}
}
