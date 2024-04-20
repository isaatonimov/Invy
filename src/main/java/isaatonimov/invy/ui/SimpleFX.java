package isaatonimov.invy.ui;

import isaatonimov.invy.App;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public abstract class SimpleFX implements Initializable
{
	public 		static SimpleObjectProperty<Scene> 				SceneProperty 			= new SimpleObjectProperty<>();
	public 		static SimpleObjectProperty<Stage>				StageProperty			= new SimpleObjectProperty<>();
	public 		static SimpleObjectProperty<FXMLLoader> 			LoaderProperty 			= new SimpleObjectProperty<>();
	public		static SimpleObjectProperty<Stage>				ParentProperty			= new SimpleObjectProperty<>();
	public 		static SimpleStringProperty						StylesheetResourceProperty 	= new SimpleStringProperty();
	public 		static SimpleObjectProperty<? extends SimpleFX>		Instance				= new SimpleObjectProperty<>();


	public static  <T extends SimpleFX> T Create(SimpleFX instance)
	{
		LoaderProperty.set(new FXMLLoader(App.class.getResource(instance.FXMLResourceLocation())));
		System.out.println("Controller Instance: " + instance.getClass().getName());

		try
		{
			SceneProperty.set(new Scene(LoaderProperty.get().load()));
			instance.FXSpecificSettings();
			StageProperty.set(new Stage());
			StageProperty.get().setScene(SceneProperty.get());
			StylesheetResourceProperty.addListener((observable, oldValue, newValue) -> SceneProperty.get().setUserAgentStylesheet((String)newValue));
		}
		catch (IOException e)
		{
			System.out.println(instance.getClass().getName() + " FX could not be initialized...");
		}

		setSettings();
		System.out.println("Initialized " + instance.getClass().getName());

		return (T) LoaderProperty.get().getController();
	}

	private static void setSettings()
	{
		StageProperty.get().initStyle(StageStyle.TRANSPARENT);
	}

	public void Show()
	{
		StageProperty.get().show();
		FXSpecificShowActions();
	}

	public void Hide()
	{
		StageProperty.get().hide();
		FXSpecificHideActions();
	}

	public void AnimatedHide()
	{
		SceneProperty.get().getRoot().setOpacity(1);
		SceneProperty.get().setFill(Color.WHITE);
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(2000),
				new KeyValue(SceneProperty.get().getRoot().opacityProperty(), 0));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> AnimatedHide());
		SceneProperty.get().setFill(Color.TRANSPARENT);

		FXSpecificHideActions();
	}

	public void AnimatedShow()
	{
		SceneProperty.get().getRoot().setOpacity(1);
		SceneProperty.get().setFill(Color.TRANSPARENT);
		StageProperty.get().show();
		Timeline timeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(4000),
				new KeyValue(SceneProperty.get().getRoot().opacityProperty(), 1));
		timeline.getKeyFrames().add(key);
		timeline.setOnFinished((ae) -> AnimatedHide());
		timeline.play();
		SceneProperty.get().setFill(Color.TRANSPARENT);

		FXSpecificShowActions();
	}

	protected abstract String 	FXMLResourceLocation();
	protected abstract void	FXSpecificShowActions();
	protected abstract void	FXSpecificHideActions();
	protected abstract void    FXSpecificSettings();
}
