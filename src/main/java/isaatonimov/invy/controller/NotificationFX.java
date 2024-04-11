package isaatonimov.invy.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class NotificationFX
{
	@FXML
	private Label 		titleLabel;
	@FXML
	private Label 		subtitleLabel;
	@FXML
	private Label 		messageLabel;
	@FXML
	private ImageView 	imageView;

	public SimpleStringProperty title = new SimpleStringProperty(this, "title");
	public SimpleStringProperty subtitle = new SimpleStringProperty(this, "subtitle");
	public SimpleStringProperty message = new SimpleStringProperty(this, "message");
	public SimpleObjectProperty<Image> image = new SimpleObjectProperty<>(this, "image");

	private Scene notifactionScene;
	private Stage notificationStage;

	public void setScene(Scene notifactionScene)
	{
		this.notifactionScene = notifactionScene;

		System.out.println("Notification initialised..");

		titleLabel.textProperty().bindBidirectional(title);
		subtitleLabel.textProperty().bindBidirectional(subtitle);
		messageLabel.textProperty().bindBidirectional(message);
		imageView.imageProperty().bindBidirectional(image);

		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

		notificationStage = new Stage();
		notificationStage.setWidth(240);
		notificationStage.setHeight(90);
		notificationStage.setScene(notifactionScene);
		notificationStage.initStyle(StageStyle.UNDECORATED);

		notificationStage.setAlwaysOnTop(true);
		notificationStage.setY(screenBounds.getMinY() + 20);
		notificationStage.setX(screenBounds.getWidth() - notificationStage.getWidth() - 20);


		//On Click -> Hide
		notificationStage.getScene().setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				notificationStage.hide();
			}
		});
	}

	public void show()
	{
		notificationStage.initStyle(StageStyle.TRANSPARENT);
		notifactionScene.setFill(Color.TRANSPARENT);
		notificationStage.show();
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(4000),
				new KeyValue(notificationStage.getScene().getRoot().opacityProperty(), 1));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> this.hide());
		timeline.play();
		notifactionScene.setFill(Color.WHITE);
	}

	public void hide()
	{
		this.notificationStage.getScene().getRoot().setOpacity(1);
		notifactionScene.setFill(Color.WHITE);
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(2000),
				new KeyValue(notificationStage.getScene().getRoot().opacityProperty(), 0));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> this.notificationStage.hide());
		timeline.play();
		notifactionScene.setFill(Color.TRANSPARENT);
	}
}
