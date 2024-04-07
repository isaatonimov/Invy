package isaatonimov.invy.controller;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.ui.services.RecordingLookupService;
import isaatonimov.invy.ui.services.ToggleViewService;
import isaatonimov.invy.ui.services.VideoLookupService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	//UI
	private Stage stage;
	private FXTrayIcon trayIcon;

	//Core
	private InvidiousInstance 		invidiousInstance;
	private MusicPlayer 			musicPlayer;

	//Services - UI
	private ToggleViewService 		toggleViewService;

	//Services - Background / Other
	private VideoLookupService 		videoLookupService;
	private RecordingLookupService 	recordingLookupService;

	//FXML References
	@FXML
	private TextField musicSearchTextField;
	@FXML
	private ListView songView;

	//GETTERS
	public ListView getSongView()
	{
		return songView;
	}
	//GETTERS

	public TextField getMusicSearchTextField()
	{
		return musicSearchTextField;
	}

	//SETTERS
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
	public void setTrayIcon(FXTrayIcon invyTrayIcon)
	{
		trayIcon = invyTrayIcon;
	}
	public void setVideoLookupService(VideoLookupService videoLookupService)
	{
		this.videoLookupService = videoLookupService;
	}
	public void setRecordingLookupService(RecordingLookupService recordingLookupService)
	{
		this.recordingLookupService = recordingLookupService;
		recordingLookupService.SetTextFieldToBind(musicSearchTextField);
	}
	public void setToggleViewService(ToggleViewService toggleViewService)
	{
		this.toggleViewService = toggleViewService;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{

	}
}