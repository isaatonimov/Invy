package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.invidious.InvidiousInstance;
import isaatonimov.invy.invidious.VideoResult;
import isaatonimov.invy.service.RecordingLookupService;
import isaatonimov.invy.service.VideoLookupService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.robot.Robot;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	private FXTrayIcon trayIcon;
	private Rectangle2D screenBounds;
	private Stage stage;
	private Robot robot;
	private InvidiousInstance invidiousInstance;
	private MusicPlayer musicPlayer;

	//Services
	private VideoLookupService videoLookupService;
	private RecordingLookupService recordingLookupService;

	@FXML
	private BorderPane rootPane;
	@FXML
	private TextField musicSearch;
	@FXML
	private ListView songView;


	public void setStage(Stage stage)
	{
		this.stage = stage;
	}

	public void setInvidiouseInstance(InvidiousInstance mainInstance)
	{
		invidiousInstance = mainInstance;
	}


	public void setMusicPlayer(MusicPlayer musicPlayer)
	{
		this.musicPlayer = musicPlayer;
	}

	public void setTrayIcon(FXTrayIcon trayIcon)
	{
		this.trayIcon = trayIcon;

		trayIcon.clear();
		trayIcon.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				stage.setX(robot.getMouseX() - (stage.getWidth() / 2));
				stage.setY(screenBounds.getMinY());
				stage.requestFocus();
				stage.setAlwaysOnTop(true);

				if(stage.isShowing())
					stage.hide();
				else
					stage.show();
			}
		});
	}

	public void searchAndPlay(String searchTerm)
	{
		if(videoLookupService == null)
			videoLookupService = new VideoLookupService(invidiousInstance, searchTerm);
		else
			videoLookupService.updateSearchTerm(searchTerm);

		if(recordingLookupService == null)
			recordingLookupService = new RecordingLookupService(searchTerm);
		else
			recordingLookupService.updateSearchTerm(searchTerm);

		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				recordingLookupService.start();
			}
		});

		recordingLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				ObservableList<String> listItems = FXCollections.observableArrayList();

				for(var vr : (List<String>) recordingLookupService.getValue())
				{
					listItems.add(vr);
				}

				songView.setItems(listItems);

				try
				{
					Thread.sleep(Duration.ofMillis(10).toMillis());
					videoLookupService.start();
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
			}
		});

		videoLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				String firstViedoStreamURL = invidiousInstance.fetchVideoStreamURLS(((ArrayList<VideoResult>)videoLookupService.getValue()).
												getFirst()).getFirst();

				invidiousInstance.fetchVideoStream(firstViedoStreamURL);
			}
		});
	}

	private void makeMenuItems()
	{
		for(var child : rootPane.getCenter().lookupAll("HBox"))
		{
			if(child instanceof HBox)
			{
				child.setOnMouseEntered(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						child.setStyle("-fx-background-color: black");
					}
				});
				child.setOnMouseExited(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						child.setStyle("");
					}
				});
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		robot = new Robot();
		screenBounds = Screen.getPrimary().getVisualBounds();

		//set Menu Item Hover Effect
		makeMenuItems();

		//Action Listener -> Enter -> Search and play
		musicSearch.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent event)
			{
				if(event.getCode().equals(KeyCode.ENTER))
				{
					searchAndPlay(musicSearch.getText());
				}
			}
		});
	}
}