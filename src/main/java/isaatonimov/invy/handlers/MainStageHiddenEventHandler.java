package isaatonimov.invy.handlers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;

public class MainStageHiddenEventHandler implements EventHandler<WindowEvent>
{
	private Robot robot;
	public MainStageHiddenEventHandler() throws AWTException
	{
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
				((Window)(windowEvent.getSource())).getScene().setCursor(Cursor.DEFAULT);

				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
		});

		delay.play();
	}
}
