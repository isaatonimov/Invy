package isaatonimov.invy.ui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.controlsfx.glyphfont.FontAwesome;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageFX extends SimpleFX implements Initializable
{
	@FXML
	private Label 		titleLabel;
	@FXML
	private Label 		messageLabel;
	@FXML
	private Button 		okButton;
	@FXML
	private Button 		yesButton;
	@FXML
	private Button 		noButton;
	@FXML
	private Pane 		imageWrapper;

	private FontAwesome fontAwesome;
	private Node 		messageImage;

	public SimpleStringProperty 		TitleProperty 		= new SimpleStringProperty();
	public SimpleStringProperty 		MessageProperty 	= new SimpleStringProperty();
	public SimpleObjectProperty<Button>	OkButtonProperty	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Button>	YesButtonProperty	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Button>	NoButtonProperty	= new SimpleObjectProperty<>();


	public void Show(String message, MessageFXType type)
	{
		if(MessageFXType.ERROR == type)
		{
			ShowOkButton();
			messageImage = fontAwesome.create(FontAwesome.Glyph.BOMB.getChar());
		}

		if(MessageFXType.YES_NO == type)
		{
			ShowYesButton();
			ShowNoButton();
			messageImage = fontAwesome.create(FontAwesome.Glyph.QUESTION.getChar());
		}

		if(MessageFXType.NOTIFICATION == type)
		{
			ShowOkButton();
			messageImage = fontAwesome.create(FontAwesome.Glyph.INFO.getChar());
		}

		MessageProperty.set(message);
		imageWrapper.getChildren().add(messageImage);
		Show();
	}

	public void ShowOkButton()
	{
		okButton.visibleProperty().set(true);
	}

	public void ShowYesButton()
	{
		yesButton.visibleProperty().set(true);
	}

	public void ShowNoButton()
	{
		noButton.visibleProperty().set(true);
	}

	public void HideOkButton()
	{
		okButton.visibleProperty().set(false);
	}

	public void HideYesButton()
	{
		yesButton.visibleProperty().set(false);
	}

	public void HideNoButton()
	{
		noButton.visibleProperty().set(false);
	}

	@Override
	protected String FXMLResourceLocation()
	{
		return "/isaatonimov/invy/views/message.fxml";
	}

	@Override
	protected void FXSpecificShowActions()
	{

	}

	@Override
	protected void FXSpecificHideActions()
	{
		HideOkButton();
		HideYesButton();
		HideNoButton();

		TitleProperty.set("");
		MessageProperty.set("");
		imageWrapper.getChildren().remove(messageImage);
	}

	@Override
	protected void FXSpecificSettings()
	{
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		TitleProperty.		bindBidirectional(titleLabel.textProperty());
		MessageProperty.		bindBidirectional(messageLabel.textProperty());
		OkButtonProperty.	set(okButton);
		YesButtonProperty	.set(yesButton);
		NoButtonProperty.	set(noButton);

		fontAwesome = new FontAwesome();
	}
}
