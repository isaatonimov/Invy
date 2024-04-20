package isaatonimov.invy.ui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


	@Override
	protected String FXMLResourceLocation()
	{
		return "/isaatonimov/invy/views/notification.fxml";
	}

	@Override
	protected void FXSpecificShowActions()
	{

	}

	@Override
	protected void FXSpecificHideActions()
	{

	}

	@Override
	protected void FXSpecificSettings()
	{
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

	}
}
