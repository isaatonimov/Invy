package isaatonimov.invy.controller;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.core.invidious.PipedInstance;
import isaatonimov.invy.exceptions.NoVideoResultsFoundException;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.ui.services.ArtistLookupService;
import isaatonimov.invy.ui.services.AudioStreamLookupService;
import isaatonimov.invy.ui.services.RecordingLookupService;
import isaatonimov.invy.ui.services.ToggleViewService;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	//UI
	private Stage stage;
	private FXTrayIcon trayIcon;

	//Menu Item References
	private MenuItem menuItemShowHide;
	private MenuItem menuItemSong;
	private MenuItem menuItemTogglePlay;

	//Core
	private InvidiousInstance 		invidiousInstance;
	private PipedInstance 			pipedInstance;
	private MusicPlayer 			musicPlayer;

	//Services - UI
	private ToggleViewService 		toggleViewService;

	//Services - Background / Other
	private AudioStreamLookupService audioStreamLookupService;
	private RecordingLookupService 	recordingLookupService;
	private ArtistLookupService		artistLookupService;

	private Robot robot;

	//FXML References
	@FXML
	private TextField artistSearchTextField;
	@FXML
	private ListView recommendationsView;



	//GETTERS
	public ListView getRecommendationsView()
	{
		return recommendationsView;
	}
	//GETTERS

	public TextField getArtistSearchTextField()
	{
		return artistSearchTextField;
	}

	//SETTERS
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	public void setInvidiouseInstance(InvidiousInstance invidiousInstance)
	{
		this.invidiousInstance = invidiousInstance;
	}
	public void setPipedInstance(PipedInstance pipedInstance)
	{
		this.pipedInstance = pipedInstance;
	}
	public void setMusicPlayer(MusicPlayer musicPlayer)
	{
		this.musicPlayer = musicPlayer;
	}
	public void setTrayIcon(FXTrayIcon invyTrayIcon)
	{
		trayIcon = invyTrayIcon;
	}
	public void setVideoLookupService(AudioStreamLookupService audioStreamLookupService)
	{
		this.audioStreamLookupService = audioStreamLookupService;
	}
	public void setRecordingLookupService(RecordingLookupService recordingLookupService)
	{
		this.recordingLookupService = recordingLookupService;
	}

	public void hideRecommendations()
	{
		recommendationsView.setVisible(false);
		stage.setHeight(95);
	}

	public void showRecommendations()
	{
		recommendationsView.setVisible(true);
		stage.setHeight(300);
	}

	public void setArtistLookupService(ArtistLookupService artistLookupService)
	{
		this.artistLookupService = artistLookupService;
	}
	public void setToggleViewService(ToggleViewService toggleViewService)
	{
		this.toggleViewService = toggleViewService;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{

	}


	public ArtistLookupService getArtisLookupService()
	{
		return artistLookupService;
	}

	public void hideMainWindow()
	{
		this.stage.hide();
	}

	public void showMainWindow()
	{
		this.stage.show();
	}

	public void updateShowHideMenuItem(boolean hidden)
	{
		if(hidden)
			menuItemShowHide.setText("Show Search");
		else
			menuItemShowHide.setText("Hide Search");
	}

	public void updateCurrentlyPlayingSongMenuItem(Recording record)
	{
		menuItemSong.setText(record.getArtist().getName() + ": " + record.getTitle());
	}

	public void startMusicPlayerWithPlaylist(LinkedList<Recording> initialPlaylist)
	{
		try
		{
			musicPlayer.AddToQueue(initialPlaylist);
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		catch (NoVideoResultsFoundException e)
		{
			throw new RuntimeException(e);
		}

	}

	public RecordingLookupService getRecordingLookupService()
	{
		return recordingLookupService;
	}

	public Artist getSelectedRecommendation()
	{
		SelectionModel<Artist> selectionModel = recommendationsView.getSelectionModel();

		return selectionModel.getSelectedItem();
	}

	public Robot getRobot()
	{
		return robot;
	}

	public void setRobot(Robot iRobot)
	{
		this.robot = iRobot;
	}

	public void searchAndPlay(Artist selectedItem)
	{
		recordingLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, event ->
		{
			if(recordingLookupService.getValue() != null)
				startMusicPlayerWithPlaylist((LinkedList<Recording>) recordingLookupService.getValue());
		});

		recordingLookupService.updateArtist(selectedItem);
		recordingLookupService.restart();
	}

	public void setMenuItemShowHide(MenuItem showHide)
	{
		this.menuItemShowHide = showHide;
	}

	public void setMenuItemSong(MenuItem song)
	{
		this.menuItemSong = song;
	}

	public void setMenuItemTogglePlay(MenuItem togglePlay)
	{
		this.menuItemTogglePlay = togglePlay;
	}

	public InvidiousInstance getInvidiousInstance()
	{
		return invidiousInstance;
	}

	public MusicPlayer getMusicPlayer()
	{
		return musicPlayer;
	}

	public void toggleMainView()
	{
		if(stage.isShowing())
			hideMainWindow();
		else
			showMainWindow();
	}

	public void playWarningSound()
	{
		System.out.println("Todo: Implement Warning Sound...");
	}

	public Stage getStage()
	{
		return stage;
	}

	public PipedInstance getPipedInstance()
	{
		return this.pipedInstance;
	}

	public AudioStreamLookupService getAudioStreamLookupService()
	{
		return audioStreamLookupService;
	}
}