package isaatonimov.invy.handlers;

import isaatonimov.invy.controllers.Controller;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;

public class MainStageHiddenEventHandler implements EventHandler<WindowEvent>
{
	private final Controller controller;
	private final Robot robot;
	public MainStageHiddenEventHandler(Controller controller) throws AWTException
	{
		this.controller = controller;
		this.robot = new Robot();
	}
	@Override
	public void handle(WindowEvent windowEvent)
	{
		PauseTransition delay = new PauseTransition(Duration.millis(10));
		delay.setOnFinished(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent actionEvent)
			{
				//((Window)(windowEvent.getSource())).getScene().setCursor(Cursor.DEFAULT);

				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
		});

		delay.play();
		//controller.updateShowHideMenuItem(true);
	}
}
