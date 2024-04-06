package isaatonimov.invy.handlers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;

public class MainStageShownEventHandler implements EventHandler<WindowEvent>
{
	private Robot robot;
	private javafx.scene.robot.Robot robotFX;
	private Node whereToMove;
	public MainStageShownEventHandler(java.awt.Robot robot, Node whereToMove)
	{
		this.robotFX = new javafx.scene.robot.Robot();
		this.robot = robot;
		this.whereToMove = whereToMove;
	}
	@Override
	public void handle(WindowEvent windowEvent)
	{
		var destinationBeforeX 	= robotFX.getMouseX();
		var destinationBeforeY 	= robotFX.getMouseY();

		var width = whereToMove.getBoundsInParent().getWidth();
		var height = whereToMove.getBoundsInParent().getHeight();

		var destinationX = whereToMove.localToScreen(0.0, 0.0).getX() + width / 2;
		var destinationY = whereToMove.localToScreen(0.0, 0.0).getY() + height / 2;

		robot.mouseMove((int)destinationX, (int)destinationY);

		PauseTransition delay = new PauseTransition(Duration.millis(10));
		delay.setOnFinished(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent actionEvent)
			{
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);

				robotFX.mouseMove(destinationX, destinationY -50);

				((Window)(windowEvent.getSource())).getScene().setCursor(Cursor.NONE);
			}
		});

		delay.play();
	}
}