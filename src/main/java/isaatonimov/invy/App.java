package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.invidious.InvidiousInstance;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class App extends Application {

    private InvidiousInstance mainInstance;
	private MusicPlayer musicPlayer;

    @Override
    public void start(Stage stage) throws IOException
    {
		try
		{
			mainInstance = new InvidiousInstance(new URI("https://invidious.lunar.icu"));
		}
        catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		}

		musicPlayer = new MusicPlayer();

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setUserAgentStylesheet(App.class.getResource("primer-dark.css").toString());

        stage.setTitle("Invy");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
		controller.setMusicPlayer(musicPlayer);

        FXTrayIcon trayIcon = new FXTrayIcon(stage, App.class.getResource("logo.png"));
        trayIcon.setTooltip("Invy - Music Player running");
		trayIcon.addMenuItem(new MenuItem(""));
        trayIcon.show();

        controller.setTrayIcon(trayIcon);
        controller.setInvidiouseInstance(mainInstance);

		//Hack -> so that the Window starts centered below the Menu Bar Icon
		stage.show();
		stage.hide();
	}

    public static void main(String[] args) {
        launch();
    }
}