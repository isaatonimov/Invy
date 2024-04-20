package isaatonimov.invy.controller;

import com.dlsc.preferencesfx.PreferencesFx;
import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.App;
import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.ArtistLookupService;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import isaatonimov.invy.services.background.RecordingLookupService;
import isaatonimov.invy.services.ui.PreferencesService;
import isaatonimov.invy.services.ui.ToggleSearchWindowService;
import isaatonimov.invy.ui.AudioNotificationFX;
import isaatonimov.invy.ui.MessageFX;
import isaatonimov.invy.ui.MessageFXType;
import isaatonimov.invy.utils.InvyUtils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	//UI
	public SimpleObjectProperty<Stage> SearchBarStageProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<FXTrayIcon> 				TrayProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PreferencesFx> 				PreferencesProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<AudioNotificationFX>				NotificationProperty	  	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MessageFX>				MessageProperty		  	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MusicPlayer> 				MusicPlayerProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty <AudioStreamLookupService>		AudioStreamLookupServiceProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<RecordingLookupService>		RecordLookupServiceProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<ArtistLookupService>			ArtistLookupServiceProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<ToggleSearchWindowService> 	ToggleViewServiceProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PreferencesService>			PreferencesServiceProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<javafx.scene.robot.Robot>  		FXRobotProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty<java.awt.Robot>  	    	AWTRobotProperty 			= new SimpleObjectProperty<>();

	//FXML References
	@FXML
	private TextField 	artistSearchTextField;
	@FXML
	private ListView 	recommendationsView;
	@FXML
	private Node 		rootPane;

	public SimpleObjectProperty<TextField>				SearchFieldProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<ListView>				RecommendationsProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<Node>				ViewProperty = new SimpleObjectProperty<>();

	public void ClearTempFolder()
	{
		try
		{
			InvyUtils.clearTempFolder();
		}
		catch (IOException e)
		{
			ShowErrorMessage("Temp Folder could not be cleared. \n " +
						 "Try checking your set Temp Folder in Preferences");
		}
	}

	public void ShowErrorMessage(String message)
	{
		Toolkit.getDefaultToolkit().beep();

		MessageProperty.get().Show(message, MessageFXType.ERROR);
		MessageProperty.get().OkButtonProperty.get().setOnMouseClicked(event -> MessageProperty.get().Hide());
	}

	public void ShowNotification(String message)
	{
		Toolkit.getDefaultToolkit().beep();

		MessageProperty.get().Show(message, MessageFXType.NOTIFICATION);
		MessageProperty.get().OkButtonProperty.get().setOnMouseClicked(event -> MessageProperty.get().Hide());
	}

	public void ShowYesNoDialog(String question, Runnable yesRunThis, Runnable noRunThis)
	{
		Toolkit.getDefaultToolkit().beep();

		MessageProperty.get().Show(question, MessageFXType.YES_NO);
		MessageProperty.get().YesButtonProperty.get().setOnMouseClicked(event ->
		{
			yesRunThis.run();
		});

		MessageProperty.get().NoButtonProperty.get().setOnMouseClicked(event ->
		{
			noRunThis.run();
		});
	}

	//No Idea where this should really go -> MVC
	public void handlers()
	{
		RecordLookupServiceProperty.addListener((observable, oldValue, newValue) ->
		{
			//When Record was found start playing
			RecordLookupServiceProperty.get().addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, event ->
			{
				if(RecordLookupServiceProperty.get().getValue() != null)
				{
					startMusicPlayerWithPlaylist((LinkedList<Recording>) RecordLookupServiceProperty.get().getValue());
				}
			});

			RecordLookupServiceProperty.get().addEventHandler(WorkerStateEvent.WORKER_STATE_FAILED, event ->
			{
				//Handle Error
			});
		});
	}

	private void properties()
	{
		SearchFieldProperty.		set(artistSearchTextField);
		RecommendationsProperty.	set(recommendationsView);
		ViewProperty.			set(rootPane);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		properties();
		handlers();
	}

	public void hideRecommendations()
	{
		recommendationsView.setVisible(false);
		SearchBarStageProperty.get().setHeight(95);
	}

	public void showRecommendations()
	{
		recommendationsView.setVisible(true);
		SearchBarStageProperty.get().setHeight(300);
	}

	public void ToggleSearchBar()
	{
		System.out.println("Trying to toggle Search Bar Window...");

		if(SearchBarStageProperty.get().isShowing())
			hideSearchBar();
		else
			showSearchBar();
	}

	public void hideSearchBar()
	{
		SearchBarStageProperty.get().hide();
	}

	public void showSearchBar()
	{
		SearchBarStageProperty.get().show();
	}

	public java.awt.MenuItem searchMenuItem(String toMatch)
	{
		for (int i = 0; i < TrayProperty.get().getMenuItemCount(); i++)
		{
			if(TrayProperty.get().getMenuItem(i).getLabel().contains(toMatch))
				return TrayProperty.get().getMenuItem(i);
		}

		return null;
	}

	public void updateCurrentlyPlayingSongMenuItem()
	{
		Recording record = MusicPlayerProperty.get().CurrentlyPlayingRecord.get();
		searchMenuItem("Current").setLabel(record.getArtist().getName() + ": " + record.getTitle());
	}

	public void startMusicPlayerWithPlaylist(LinkedList<Recording> initialPlaylist)
	{
		MusicPlayerProperty.get().AddToSongQueue(initialPlaylist);
	}

	public void searchAndPlay(Artist selectedItem)
	{
		RecordLookupServiceProperty.get().ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			MusicPlayerProperty.get().AddToSongQueue((LinkedList<Recording>) newValue);
		});

		RecordLookupServiceProperty.get().CurrentTargetArtistProperty.set(selectedItem);
		RecordLookupServiceProperty.get().startWorking();
	}

	public void showNowPlaying()
	{
		//new Image(String.valueOf(MusicBrainz.searchForCoverArt(recording.getRelease())));
	}

	public void ShowPreferencesWindow()
	{
		PreferencesProperty.get().getView().autosize();
		PreferencesProperty.get().show();
	}

	public void SetAppTheme(String theme)
	{
		System.out.println		("Trying to set theme: " + theme);
		String resourceString 		= App.class.getResource("/" + theme).toString();

		PreferencesProperty.		get().getStylesheets().clear();
		PreferencesProperty.		get().getStylesheets().add(resourceString);

		SearchBarStageProperty.	get().getScene().setUserAgentStylesheet(resourceString);
		NotificationProperty.		get().StylesheetResourceProperty.set(resourceString);
		MessageProperty.			get().StylesheetResourceProperty.set(resourceString);
	}

	public void ClosePreferencesWindow()
	{
		PreferencesProperty.get().saveSettings();
		PreferencesProperty.get().getView().getScene().getWindow().hide();
	}

	public void OpenTempFolder()
	{
		try
		{
			Desktop.getDesktop().open(InvyUtils.getTempDirectoryFile());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}