package isaatonimov.invy.ui;

import isaatonimov.invy.enums.MessageFXType;
import isaatonimov.invy.ui.base.SimpleFX;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.controlsfx.glyphfont.FontAwesome;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageFX extends SimpleFX
{
	@FXML
	private Label 			messageLabel;
	@FXML
	private Button 			okButton;
	@FXML
	private Button 			yesButton;
	@FXML
	private Button 			noButton;
	@FXML
	private Pane 			imageWrapper;
	@FXML
	private HBox			buttonBar;

	private FontAwesome 		fontAwesome;
	private Node 			messageImage;
	private FontAwesome.Glyph selectedGlyph;
	private FontAwesome.Glyph promptedGlyph;

	public SimpleStringProperty 		MessageProperty 	= new SimpleStringProperty();
	public SimpleObjectProperty<Button>	OkButtonProperty	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Button>	YesButtonProperty	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<Button>	NoButtonProperty	= new SimpleObjectProperty<>();

	public void Show(String message, MessageFXType messageFXType, FontAwesome.Glyph icon)
	{
		promptedGlyph = icon;
		Show(message, messageFXType);
	}

	public void Show(String message, MessageFXType type)
	{
		if(MessageFXType.ERROR == type)
		{
			ShowOkButton();
			selectedGlyph = FontAwesome.Glyph.BOMB;
		}

		if(MessageFXType.YES_NO == type)
		{
			ShowYesButton();
			ShowNoButton();
			selectedGlyph = FontAwesome.Glyph.QUESTION;
		}

		if(MessageFXType.NOTIFICATION == type)
		{
			ShowOkButton();
			selectedGlyph = FontAwesome.Glyph.INFO;
		}

		if(promptedGlyph != null)
			selectedGlyph = promptedGlyph;

		messageImage = fontAwesome.create(selectedGlyph.getChar());
		messageImage.scaleXProperty().set(2);
		messageImage.scaleYProperty().set(2);

		MessageProperty.set(message);
		imageWrapper.getChildren().add(messageImage);
		Show(this);
	}

	public void ShowOkButton()
	{
		buttonBar.getChildren().add(OkButtonProperty.get());
	}

	public void ShowYesButton()
	{
		buttonBar.getChildren().add(YesButtonProperty.get());
	}

	public void ShowNoButton()
	{
		buttonBar.getChildren().add(NoButtonProperty.get());
	}

	public void HideOkButton()
	{
		buttonBar.getChildren().remove(OkButtonProperty.get());
	}

	public void HideYesButton()
	{
		buttonBar.getChildren().remove(YesButtonProperty.get());	}

	public void HideNoButton()
	{
		buttonBar.getChildren().remove(NoButtonProperty.get());	}

	@Override
	public String FXMLResourceLocation()
	{
		return "/isaatonimov/invy/views/message.fxml";
	}

	@Override
	public void FXSpecificShowActions()
	{

	}

	@Override
	public void FXSpecificHideActions()
	{
		HideOkButton();
		HideYesButton();
		HideNoButton();

		MessageProperty.set("");
		imageWrapper.getChildren().remove(messageImage);
		promptedGlyph = null;
	}

	@Override
	public void FXSpecificSceneSettings()
	{

	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		MessageProperty.		bindBidirectional(messageLabel.textProperty());
		OkButtonProperty.	set(okButton);
		YesButtonProperty	.set(yesButton);
		NoButtonProperty.	set(noButton);

		fontAwesome = new FontAwesome();

		HideYesButton();
		HideNoButton();
		HideOkButton();
	}
}
