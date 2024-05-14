package isaatonimov.invy.handlers;

import isaatonimov.invy.controllers.Controller;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;

public class MainStageShownEventHandler implements EventHandler<WindowEvent>
{
	private final Controller controller;
	private Robot robot;
	private final javafx.scene.robot.Robot robotFX;
	private Node whereToMove;
	public MainStageShownEventHandler(Controller controller)
	{
		this.controller = controller;
		this.robotFX = new javafx.scene.robot.Robot();
		//this.robot = controller.getRobot();
		//this.whereToMove = controller.getArtistSearchTextField();
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

		if(robot != null)
			robot.mouseMove((int)destinationX, (int)destinationY);

		PauseTransition delay = new PauseTransition(Duration.millis(10));
		delay.setOnFinished(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent actionEvent)
			{
				//Accessibility Features turned off?
				if(robot != null)
				{
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					robotFX.mouseMove(destinationX, destinationY -50);
				}

				//((Window)(windowEvent.getSource())).getScene().setCursor(Cursor.NONE);
			}
		});

		delay.play();

		//controller.updateShowHideMenuItem(false);
	}
}
