package isaatonimov.invy.ui;

import isaatonimov.invy.App;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class SimpleFX implements Initializable
{
	public 		SimpleObjectProperty<Scene> 				SceneProperty 			= new SimpleObjectProperty<>();
	public 		SimpleObjectProperty<Stage>				StageProperty			= new SimpleObjectProperty<>();
	public		SimpleObjectProperty<Window>				ParentProperty			= new SimpleObjectProperty<>();
	public 		SimpleStringProperty						StylesheetResourceProperty 	= new SimpleStringProperty();

	public static  <T extends SimpleFX> T Create(SimpleFX instanceOf, Window parent)
	{
		instanceOf.ParentProperty.set(parent);
		return Create(instanceOf);
	}

	public static  <T extends SimpleFX> T Create(SimpleFX instance)
	{
		FXMLLoader loader = new FXMLLoader(App.class.getResource(instance.FXMLResourceLocation()));
		System.out.println("Controller Instance initiated for: " + instance.getClass().getName() + "for Location -> ");

		loader.setController(instance);


		try
		{
			instance.StageProperty.set(new Stage());
			instance.SceneProperty.set(new Scene(loader.load()));
			instance.StageProperty.get().setScene(instance.SceneProperty.get());

			instance.StageProperty.get().initStyle(StageStyle.TRANSPARENT);
			instance.StageProperty.get().setAlwaysOnTop(true);

			instance.StylesheetResourceProperty.addListener((observable, oldValue, newValue) -> instance.SceneProperty.get().setUserAgentStylesheet((String)newValue));

			System.out.println("Initialized " + instance.getClass().getName() + " and stored in Instance Bank.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(instance.getClass().getName() + " could not be initialized...");
		}

		return (T) instance;
	}

	public void Show(SimpleFX toShow)
	{
		if(toShow.ParentProperty.get() != null)
			toShow.ParentProperty.get().getScene().getRoot().setDisable(true);

		toShow.FXSpecificShowActions();

		Platform.runLater(() ->
		{
			toShow.StageProperty.get().show();
		});
	}

	public void Hide(SimpleFX toShow)
	{
		if(toShow.ParentProperty.get() != null)
			toShow.ParentProperty.get().getScene().getRoot().setDisable(false);

		Platform.runLater(() ->
		{
			toShow.StageProperty.get().hide();
		});

		toShow.FXSpecificHideActions();
	}

	public void AnimatedHide(SimpleFX toHide)
	{
		toHide.SceneProperty.get().getRoot().setOpacity(1);
		toHide.SceneProperty.get().setFill(Color.WHITE);
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(2000),
				new KeyValue(toHide.SceneProperty.get().getRoot().opacityProperty(), 0));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> AnimatedHide(toHide));
		toHide.SceneProperty.get().setFill(Color.TRANSPARENT);

		toHide.FXSpecificHideActions();
	}

	public void AnimatedShow(SimpleFX toShow)
	{
		toShow.SceneProperty.get().getRoot().setOpacity(1);
		toShow.SceneProperty.get().setFill(Color.TRANSPARENT);
		toShow.StageProperty.get().show();
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(4000),
				new KeyValue(toShow.SceneProperty.get().getRoot().opacityProperty(), 1));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> AnimatedHide(toShow));
		timeline.play();
		toShow.SceneProperty.get().setFill(Color.TRANSPARENT);

		toShow.FXSpecificShowActions();
	}

	public abstract String 	FXMLResourceLocation();
	public abstract void		FXSpecificShowActions();
	public abstract void		FXSpecificHideActions();
	public abstract void 		FXSpecificSceneSettings();
	public abstract void initialize(URL location, ResourceBundle resources);
}
