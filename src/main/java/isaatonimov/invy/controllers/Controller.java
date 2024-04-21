package isaatonimov.invy.controllers;

import com.dlsc.preferencesfx.PreferencesFx;
import com.dustinredmond.fxtrayicon.FXTrayIcon;
import isaatonimov.invy.App;
import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.enums.InvyTrayMenuItems;
import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.services.background.ArtistLookupService;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import isaatonimov.invy.services.background.RecordingLookupService;
import isaatonimov.invy.services.ui.PlayTrayAnimationService;
import isaatonimov.invy.services.ui.PreferencesService;
import isaatonimov.invy.services.ui.ToggleSearchWindowService;
import isaatonimov.invy.ui.AudioNotificationFX;
import isaatonimov.invy.ui.MessageFX;
import isaatonimov.invy.enums.MessageFXType;
import isaatonimov.invy.utils.InvyUtils;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	private Random randomGenerator = new Random();
	//UI
	public SimpleObjectProperty<Stage> 					SearchBarStageProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<FXTrayIcon> 				TrayProperty 				= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PreferencesFx> 				PreferencesProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty<AudioNotificationFX>			NotificationProperty	  		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MessageFX>				MessageProperty		  		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MusicPlayer> 				MusicPlayerProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty <AudioStreamLookupService>		AudioStreamLookupServiceProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<RecordingLookupService>		RecordLookupServiceProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<ArtistLookupService>			ArtistLookupServiceProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<ToggleSearchWindowService> 	ToggleViewServiceProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PlayTrayAnimationService> 		PlayTrayAnimationServiceProperty = new SimpleObjectProperty<>();

	public SimpleListProperty							TryThisProperty				= new SimpleListProperty();

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
		ShowNotificationDefaults();
		MessageProperty.get().Show(message, MessageFXType.ERROR);
	}

	public void ShowNotification(String message)
	{
		ShowNotificationDefaults();
		MessageProperty.get().Show(message, MessageFXType.NOTIFICATION);
	}
	public void ShowNotification(String message, FontAwesome.Glyph icon)
	{
		ShowNotificationDefaults();
		MessageProperty.get().Show(message, MessageFXType.NOTIFICATION, icon);
	}
	public void ShowNotificationDefaults()
	{
		Toolkit.getDefaultToolkit().beep();
		MessageProperty.get().OkButtonProperty.get().setOnMouseClicked(event -> MessageProperty.get().Hide(MessageProperty.get()));
	}
	public void ShowYesNoDialog(String question, Runnable yesRunThis, Runnable noRunThis)
	{
		ShowNotificationDefaults();
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
	}
	public void HideRecommendations()
	{
		recommendationsView.setVisible(false);
		SearchBarStageProperty.get().setHeight(95);
	}
	public void ShowRecommendations()
	{
		recommendationsView.setVisible(true);
		SearchBarStageProperty.get().setHeight(300);
	}
	public void ShowRecommendationMessage()
	{
		recommendationsView.setVisible(true);
		SearchBarStageProperty.get().setHeight(123);
	}

	public void ToggleSearchBar()
	{
		System.out.println("Trying to toggle Search Bar Window...");

		if(SearchBarStageProperty.get().isShowing())
			HideSearchBar();
		else
			ShowSearchBar();
	}

	public void HideSearchBar()
	{
		SearchBarStageProperty.get().hide();
		SearchFieldProperty.get().setText("");
		HideRecommendations();
	}

	public void ShowSearchBar()
	{
		int index = randomGenerator.nextInt(TryThisProperty.get().size());
		SearchFieldProperty.get().setPromptText((String) TryThisProperty.get().get(index));
		SearchBarStageProperty.get().show();
	}

	public void TestAudioNotification() throws IOException, URISyntaxException, InterruptedException
	{
		NotificationProperty.get().Show("Test Title", "Subtitle", "Message", null);
	}

	public void UpdateCurrentlyPlayingSongMenuItem()
	{
		Recording record = MusicPlayerProperty.get().CurrentlyPlayingRecord.get();
		MenuItem menuItem = TrayProperty.get().getMenuItem(InvyTrayMenuItems.CURRENTLY_PLAYING);
		menuItem.setLabel(record.getArtist().getName() + ": " + record.getTitle());
	}

	public void UpdateToggleMenutItem(MusicPlayerState playerState)
	{
		MenuItem playPause = TrayProperty.get().getMenuItem(InvyTrayMenuItems.TOGGLE_PLAY);

		if(playerState == MusicPlayerState.PLAYING)
		{
			playPause.setLabel("Pause");
		}
		else if(playerState == MusicPlayerState.PAUSED)
		{
			playPause.setLabel("Play");
		}
	}

	public void UpdateSearchBarToggleMenu(boolean searchBarShown)
	{
		MenuItem searchToggle = TrayProperty.get().getMenuItem(InvyTrayMenuItems.SHOW_SEARCHBAR);

		if(searchBarShown == true)
		{
			searchToggle.setLabel("Hide Search");
		}
		else if(searchBarShown == false)
		{
			searchToggle.setLabel("Show Search");
		}
	}

	public void SearchAndPlay(Artist selectedItem)
	{
		TrayProperty.get().play();

		RecordLookupServiceProperty.get().ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			if(((LinkedList<Recording>) newValue).size() > 0)
				MusicPlayerProperty.get().AddToSongQueue((LinkedList<Recording>) newValue);
			else
				ShowErrorMessage("There was a Problem fetching the song information. Maybe try again later....");
		});

		RecordLookupServiceProperty.get().CurrentTargetArtistProperty.set(selectedItem);
		RecordLookupServiceProperty.get().startWorking();
	}

	public void ShowAudioNotification(Recording recording)
	{
		System.out.println("Triggered Controller Method Show Audio Notification");

		Image coverArtImage = null;
		String coverAartURL = "";

		try
		{
			coverAartURL = MusicBrainz.searchForCoverArt(recording.getRelease());

			if(coverAartURL != "")
				coverArtImage = new Image(coverAartURL);
		}
		catch (IOException e)
		{
		}
		catch (InterruptedException e)
		{
		}
		catch (URISyntaxException e)
		{
		}

		NotificationProperty.get().Show("Now Playing", recording.getArtist().getName(), recording.getTitle(), coverArtImage);
	}

	public void ResetTrayIcon()
	{
		TrayProperty.get().stop();
		TrayProperty.get().setGraphic(new Image(App.class.getResource("/isaatonimov/invy/images/logo/logo.0001.png").toString()));
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
			ClosePreferencesWindow();
			Desktop.getDesktop().open(InvyUtils.getTempDirectoryFile());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void ShowSongInfo()
	{
		if (MusicPlayerProperty.get().CurrentlyPlayingRecord.get() != null)
		{
			String targetURL = InvyUtils.getMusicBrainzRecordingInformationBaseURL() + MusicPlayerProperty.get().CurrentlyPlayingRecord.get().getId();

			try
			{
				Desktop.getDesktop().browse(new URI(targetURL));
			} catch (IOException e)
			{
				throw new RuntimeException(e);
			} catch (URISyntaxException e)
			{
				throw new RuntimeException(e);
			}
		} else ShowNotification("No Song is currently Playing, so no song information is available...");
	}
}