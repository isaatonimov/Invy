package isaatonimov.invy.ui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.net.URL;
import java.util.ResourceBundle;

public class AudioNotificationFX extends SimpleFX
{
	@FXML
	private Label 		titleLabel;
	@FXML
	private Label 		subtitleLabel;
	@FXML
	private Label 		messageLabel;
	@FXML
	private ImageView 	imageView;

	public SimpleStringProperty 		TitleProperty 			= new SimpleStringProperty(this, "title");
	public SimpleStringProperty 		SubtitleProperty 		= new SimpleStringProperty(this, "subtitle");
	public SimpleStringProperty 		MessageProperty 		= new SimpleStringProperty(this, "message");
	public SimpleObjectProperty<Image> 	CoverProperty 			= new SimpleObjectProperty<>(this, "image");

	public void Show(String title, String subtitle, String message, Image coverArtImage)
	{
		TitleProperty.set(title);
		SubtitleProperty.set(subtitle);
		MessageProperty.set(message);
		CoverProperty.set(coverArtImage);

		Show(this);
	}

	@Override
	public String FXMLResourceLocation()
	{
		return "/isaatonimov/invy/views/notification.fxml";
	}

	@Override
	public void FXSpecificShowActions()
	{

	}

	@Override
	public void FXSpecificHideActions()
	{

	}

	@Override
	public void FXSpecificSceneSettings()
	{
		SceneProperty.get().setFill(Color.TRANSPARENT);
		SceneProperty.get().setOnMouseClicked(event -> ((SimpleFX)(event.getSource())).Hide((SimpleFX) event.getSource()));
	}


	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		titleLabel.textProperty().bindBidirectional(TitleProperty);
		subtitleLabel.textProperty().bindBidirectional(SubtitleProperty);
		messageLabel.textProperty().bindBidirectional(MessageProperty);
		imageView.imageProperty().bindBidirectional(CoverProperty);

		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

		StageProperty.get().setWidth(300);
		StageProperty.get().setHeight(90);

		StageProperty.get().setY(screenBounds.getMinY() + 20);
		StageProperty.get().setX(screenBounds.getWidth() - StageProperty.get().getWidth() - 20);

		//On Click -> Hide
	}
}
