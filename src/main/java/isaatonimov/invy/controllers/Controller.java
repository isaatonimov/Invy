package isaatonimov.invy.controllers;

import com.dlsc.preferencesfx.PreferencesFx;
import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.fasterxml.jackson.core.JsonProcessingException;
import isaatonimov.invy.App;
import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.core.metadatasources.MusicBrainz;
import isaatonimov.invy.enums.InvyTrayMenuItems;
import isaatonimov.invy.enums.MusicPlayerState;
import isaatonimov.invy.enums.SearchCategory;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.MusicMetadata;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.musicbrainz.Release;
import isaatonimov.invy.services.background.*;
import isaatonimov.invy.services.ui.PlayTrayAnimationService;
import isaatonimov.invy.services.ui.PreferencesService;
import isaatonimov.invy.services.ui.ToggleSearchWindowService;
import isaatonimov.invy.ui.AudioNotificationFX;
import isaatonimov.invy.ui.MessageFX;
import isaatonimov.invy.enums.MessageFXType;
import isaatonimov.invy.ui.base.SimpleFX;
import isaatonimov.invy.utils.Utils;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
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
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	private final Random randomGenerator = new Random();

	//UI
	public SimpleObjectProperty<Stage> 					SearchBarStageProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<FXTrayIcon> 				TrayProperty 				= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PreferencesFx> 				PreferencesProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty<AudioNotificationFX>			NotificationProperty	  		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MessageFX>				MessageProperty		  		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<MusicPlayer> 				MusicPlayerProperty 			= new SimpleObjectProperty<>();
	public SimpleObjectProperty <AudioStreamLookupService>		AudioStreamLookupServiceProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<RecordingLookupService>		RecordLookupServiceProperty 	= new SimpleObjectProperty<>();
	public SimpleObjectProperty<ArtistMetaLookupService> 		ArtistMetaLookupServiceProperty  = new SimpleObjectProperty<>();
	public SimpleObjectProperty<SongMetaLookupService>		SongMetaLookupServiceProperty   = new SimpleObjectProperty<>();
	public SimpleObjectProperty<AlbumMetaLookupService> 		AlbumMetaLookupService 		= new SimpleObjectProperty<>();

	public SimpleObjectProperty<ToggleSearchWindowService> 	ToggleViewServiceProperty 		= new SimpleObjectProperty<>();
	public SimpleObjectProperty<PlayTrayAnimationService> 		PlayTrayAnimationServiceProperty = new SimpleObjectProperty<>();

	public SimpleBooleanProperty						ApplicationLockProperty		= new SimpleBooleanProperty();
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
	private Node 				rootPane;
	@FXML
	private javafx.scene.control.Label 	categoryLabel;
	@FXML
	private ProgressIndicator searchProgressIndicator;

	public SimpleObjectProperty<ProgressIndicator>		SearchProgressIndicatorProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<javafx.scene.control.Label>	CategoryLabelProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<TextField>				SearchFieldProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<ListView>				RecommendationsProperty = new SimpleObjectProperty<>();
	public SimpleObjectProperty<Node>				ViewProperty = new SimpleObjectProperty<>();

	public void ClearTempFolder()
	{
		try
		{
			Utils.clearTempFolder();
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
		MessageProperty.get().OkButtonProperty.get().setOnMouseClicked(event ->
		{
			MessageProperty.get();
			SimpleFX.Hide(MessageProperty.get());
		});
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
		SearchProgressIndicatorProperty.	set(searchProgressIndicator);
		CategoryLabelProperty.			set(categoryLabel);
		SearchFieldProperty.			set(artistSearchTextField);
		RecommendationsProperty.		set(recommendationsView);
		ViewProperty.				set(rootPane);

		searchProgressIndicator.setVisible(false);
	}
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		properties();
	}
	public void HideRecommendations()
	{
		SearchProgressIndicatorProperty.get().setVisible(false);
		recommendationsView.setVisible(false);
		SearchBarStageProperty.get().setHeight(95);
	}
	public void ShowRecommendations()
	{
		SearchProgressIndicatorProperty.get().setVisible(true);
		recommendationsView.setVisible(true);
		SearchBarStageProperty.get().setHeight(300);
	}
	public void ShowRecommendationMessage()
	{
		SearchProgressIndicatorProperty.get().setVisible(false);
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

	public SearchCategory GetCurrentSearchCategory()
	{
		if(categoryLabel.getText().contains("Song"))
			return SearchCategory.SONG;
		else if(categoryLabel.getText().contains("Album"))
			return SearchCategory.ALBUM;

		return SearchCategory.ARTIST;
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

		if(record.getArtist() != null)
			menuItem.setLabel(record.getArtist().getName() + ": " + record.getTitle());
		else
			menuItem.setLabel(record.getTitle());
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

		if(searchBarShown)
		{
			searchToggle.setLabel("Hide Search");
		}
		else if(!searchBarShown)
		{
			searchToggle.setLabel("Show Search");
		}
	}


	public void SearchAndPlay(MusicMetadata selectedItem)
	{
		if(!ApplicationLockProperty.get())
		{
			//TrayProperty.get().play();

			if(selectedItem instanceof Artist)
			{
				RecordLookupServiceProperty.get().ResultValueProperty.addListener((observable, oldValue, newValue) ->
				{
					if(((LinkedList<Recording>) newValue).size() > 0)
						MusicPlayerProperty.get().AddToSongQueue((LinkedList<Recording>) newValue, true);
					else
						ShowErrorMessage("There was a Problem fetching the song information. Maybe try again later....");
				});

				RecordLookupServiceProperty.get().CurrentTargetProperty.set((Artist) selectedItem);
				RecordLookupServiceProperty.get().startWorking();
			}
			else if(selectedItem instanceof Recording recording)
			{
				LinkedList<Recording> recordings = new LinkedList<>();

				recordings.add((Recording) selectedItem);
				recordings.add((Recording) selectedItem);

				MusicPlayerProperty.get().AddToSongQueue(recordings, true);
			}
			else if(selectedItem instanceof Release release)
			{
				LinkedList<Recording> recordings = new LinkedList<>();

				Thread trackFetchThread = new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						List<Recording> recordingList = null;
						try
						{
							recordingList = MusicBrainz.getTrackList(release);
						} catch (IOException e)
						{
							throw new RuntimeException(e);
						} catch (InterruptedException e)
						{
							throw new RuntimeException(e);
						}
						for(Recording recording : recordingList)
							recordings.add(recording);
					}
				});

				trackFetchThread.start();

				Thread joinThread = new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							trackFetchThread.join();
						} catch (InterruptedException e)
						{

						}

						MusicPlayerProperty.get().AddToSongQueue(recordings, true);
					}
				});

				joinThread.start();

			}


		}
		else
		{
			ShowNotification("Application is currently locked. Is Instance Lookup in Progress?");
		}
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
		//TrayProperty.get().stop();
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
			Desktop.getDesktop().open(Utils.getTempDirectoryFile());
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
			String targetURL = Utils.getMusicBrainzRecordingInformationBaseURL() + MusicPlayerProperty.get().CurrentlyPlayingRecord.get().getId();

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

	public void SwitchToNextSearchCategory()
	{
		if(GetCurrentSearchCategory() == SearchCategory.ARTIST)
		{
			categoryLabel.setText("Search Song");
			return;
		}


		if(GetCurrentSearchCategory() == SearchCategory.SONG)
		{
			categoryLabel.setText("Search Album");
			return;
		}


		if(GetCurrentSearchCategory() == SearchCategory.ALBUM)
			categoryLabel.setText("Search Artist");

	}
}