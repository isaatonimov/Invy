package isaatonimov.invy;

import com.dlsc.preferencesfx.PreferencesFx;
import com.dlsc.preferencesfx.model.Category;
import com.dlsc.preferencesfx.model.Setting;
import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import isaatonimov.invy.controllers.Controller;
import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.core.base.MusicPlayer;
import isaatonimov.invy.handlers.ReccomendationViewHanderl;
import isaatonimov.invy.handlers.SmartSearchBoxHandler;
import isaatonimov.invy.input.ShortcutKeyListener;
import isaatonimov.invy.runnables.SetMenuItemAction;
import isaatonimov.invy.runnables.SetMenuItemShortcut;
import isaatonimov.invy.services.background.ArtistLookupService;
import isaatonimov.invy.services.background.AudioStreamLookupService;
import isaatonimov.invy.services.background.RecordingLookupService;
import isaatonimov.invy.services.base.UIHelperService;
import isaatonimov.invy.services.ui.*;
import isaatonimov.invy.ui.AudioNotificationFX;
import isaatonimov.invy.ui.MessageFX;
import isaatonimov.invy.ui.base.SimpleFX;
import isaatonimov.invy.utils.InvyUtils;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.glyphfont.FontAwesome;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class App extends Application
{
	BooleanProperty 	autoLocateOptimalInstanceOnStartup 	= new SimpleBooleanProperty(false);
	BooleanProperty 	autoShuffleResultsActive 			= new SimpleBooleanProperty(true);
	ListProperty 		themeToUseItems;
	ObjectProperty 		themeToUseSelection;
	Button 			openTempFolderButton 		= new Button("Open Temp Folder");
	Label 			placeHolderNode				= new Label("           ");
	ObjectProperty  	defaultLogLocation			= new SimpleObjectProperty(InvyUtils.getTempDirectoryFile());
	BooleanProperty 	accessibilityFeaturesActive 		= new SimpleBooleanProperty(true);
	ListProperty		recommendationsToUse			= new SimpleListProperty(FXCollections.observableArrayList(Arrays.asList("Chopin", "Pink Floyd", "Bob Marley", "Frank Sinatra", "Gorillaz", "Bob Marley", "David Bowie", "The Beatles")));
	ObjectProperty		recommendationToUseSelection	= new SimpleObjectProperty("Chopin");
	ListProperty 		playbackBackendToUse;
	ObjectProperty 		playbackBackendToUseSelelction 	= new SimpleObjectProperty<>();

	ListProperty 		audioStreamSourceToUse		= new SimpleListProperty();
	ObjectProperty 		audioStreamSourceToUseSelection  = new SimpleObjectProperty();

	LinkedList<Image>	animationImageList;

	private SimpleObjectProperty<Class>					MusicPlayerToLoad			= new SimpleObjectProperty<>();
	private SimpleObjectProperty<MusicPlayer> 				MainMusicPlayerProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<Class>					AudioSourceToLoad			= new SimpleObjectProperty<>();
	private SimpleObjectProperty<AudioStreamSource>			MainAudioStreamSourceProperty 	= new SimpleObjectProperty<>();
	private SimpleObjectProperty<AudioStreamLookupService> 	AudioStreamLookupServiceProperty = new SimpleObjectProperty<>();
	private SimpleObjectProperty<RecordingLookupService>		RecordingLookupServiceProperty 	= new SimpleObjectProperty<>();
	private SimpleObjectProperty<ArtistLookupService>			ArtistLookupServiceProperty 	= new SimpleObjectProperty<>();

	//UI Services
	private SimpleObjectProperty<ToggleSearchWindowService> 	ToggleSearchViewServiceProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<SongInfoService>			ShowSongInfoServiceProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<SongTogglePlayService>		SongTogglePlayServiceProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<SongPlayNextService>		SongPlayNextServiceProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<SongPlayPrevService>			SongPlayPreviousServiceProperty 		= new SimpleObjectProperty<>();
	private SimpleObjectProperty<PreferencesService>			PreferencesServiceProperty 			= new SimpleObjectProperty<>();
	private SimpleObjectProperty<PlayTrayAnimationService>		PlayTrayAnimationServiceProperty 	= new SimpleObjectProperty<>();

	private SimpleObjectProperty<ApplicationShutdownService> 	ApplicationShutdownServiceProperty 	= new SimpleObjectProperty<>();
	private SimpleObjectProperty<javafx.scene.robot.Robot> 		FXRobotProperty 				= new SimpleObjectProperty<>();
	private SimpleObjectProperty<java.awt.Robot> 			AWTRobotProperty 				= new SimpleObjectProperty<>();
	private SimpleObjectProperty<FXTrayIcon>				TrayIconProperty 				= new SimpleObjectProperty<>();
	private SimpleObjectProperty<PreferencesFx>				PreferencesProperty  				= new SimpleObjectProperty<>();
	private SimpleObjectProperty<Stage>					StageProperty 					= new SimpleObjectProperty<>();
	private SimpleObjectProperty<Controller>				ControllerProperty    			= new SimpleObjectProperty<>();
	private SimpleObjectProperty<AudioNotificationFX>			AudioNotificationProperty			= new SimpleObjectProperty<>();
	private SimpleObjectProperty<MessageFX>				MessageProperty					= new SimpleObjectProperty<>();

	private Controller 			loadMainScene(Stage mainStage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/isaatonimov/invy/views/main.fxml"));
		mainStage.setScene(new Scene(loader.load()));

		return loader.getController();
	}
	private void 				setStageSettings(Stage mainStage)
	{
		mainStage.setTitle("Invy");
		mainStage.initStyle(StageStyle.TRANSPARENT);

		mainStage.getScene().setFill(Color.TRANSPARENT);
		mainStage.setAlwaysOnTop(true);
	}
	private FXTrayIcon 			initTrayIcon(Stage mainStage)
	{
		return new FXTrayIcon(mainStage, Objects.requireNonNull(getClass().getResource("/isaatonimov/invy/images/logo/logo.0001.png")));
	}
	private void 				initTrayAnimationCreation(FXTrayIcon trayIcon) throws MalformedURLException
	{
		List<URL> resourcePaths;
		try (ScanResult scanResult = new ClassGraph().acceptPaths("/isaatonimov/invy/images/logo").scan())
		{
			resourcePaths = scanResult.getAllResources().getURLs();
		}

		animationImageList = new LinkedList<>();

		for(var resource : resourcePaths)
			animationImageList.add(new Image(resource.toString()));

		trayIcon.setIconSize(150, 150);
		trayIcon.newAnimation(animationImageList, 30);
	}

	private AudioNotificationFX 		initAudioNotificationFX()
	{
		return SimpleFX.Create(new AudioNotificationFX());
	}
	private MessageFX 			initMessageFX()
	{
		return SimpleFX.Create(new MessageFX());
	}
	private void 				initBackgroundServices()
	{
		RecordingLookupServiceProperty.		setValue(new RecordingLookupService());
		ArtistLookupServiceProperty.			setValue(new ArtistLookupService());
		AudioStreamLookupServiceProperty.	setValue(new AudioStreamLookupService());
	}
	private void 				initUIHelperServices(Controller controller)
	{
		ToggleSearchViewServiceProperty.		set(new ToggleSearchWindowService());
		ShowSongInfoServiceProperty.		set(new SongInfoService());
		SongTogglePlayServiceProperty.		set(new SongTogglePlayService());
		SongPlayNextServiceProperty.		set(new SongPlayNextService());
		SongPlayPreviousServiceProperty.		set(new SongPlayPrevService());
		PreferencesServiceProperty.			set(new PreferencesService());
		ApplicationShutdownServiceProperty.	set(new ApplicationShutdownService());
		PlayTrayAnimationServiceProperty.		set(new PlayTrayAnimationService());

		UIHelperService.BindServicePropertiesToController(controller, ToggleSearchViewServiceProperty, ShowSongInfoServiceProperty, SongTogglePlayServiceProperty,
				SongPlayNextServiceProperty, SongPlayPreviousServiceProperty, PreferencesServiceProperty, ApplicationShutdownServiceProperty, PlayTrayAnimationServiceProperty);
	}
	private void 				initAccessibilityServicesIfActive()
	{
		if(accessibilityFeaturesActive.get() == true)
		{
			try
			{
				AWTRobotProperty.	set(new java.awt.Robot());
				FXRobotProperty.	set(new javafx.scene.robot.Robot());

				//Native Hook -> Shortcut Listener

				GlobalScreen.registerNativeHook();

				ShortcutKeyListener mainShortcutKeyListener = 		new ShortcutKeyListener();

				mainShortcutKeyListener.addShortcutCombinationToListenFor(ToggleSearchViewServiceProperty.get(), 57, 42, 3675);
				mainShortcutKeyListener.addSimpleShortcutToListenFor	(65, 		SongPlayPreviousServiceProperty.get());
				mainShortcutKeyListener.addSimpleShortcutToListenFor	(66, 		SongTogglePlayServiceProperty.get());
				mainShortcutKeyListener.addSimpleShortcutToListenFor	(67, 		SongPlayNextServiceProperty.get());

				GlobalScreen.addNativeKeyListener(mainShortcutKeyListener);

			}
			catch (AWTException e)
			{
				ControllerProperty.get().ShowNotification("Robot could not be initialized. Beep. Boop.", FontAwesome.Glyph.ANDROID);
			}
			catch (NativeHookException e)
			{
				ControllerProperty.get().ShowNotification("Enable Accessabilty Features to use Menu Shortcuts without having to go to the Tray Menu first.", FontAwesome.Glyph.AMBULANCE);
			}
			catch (InterruptedException e)
			{
				ControllerProperty.get().ShowNotification("Some Thread crashed. Please restart the application.", FontAwesome.Glyph.BOMB);
			}
		}
	}
	private void 				initMusicPlayer() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException
	{
		System.out.println("Trying to load Music Player " + playbackBackendToUseSelelction.get());
		MusicPlayerToLoad.set(Class.forName("isaatonimov.invy.core.mediaplayers." + playbackBackendToUseSelelction.get()));
		MusicPlayer musicPlayer = (MusicPlayer) MusicPlayerToLoad.get().getDeclaredConstructor().newInstance();
		MainMusicPlayerProperty.set(musicPlayer);
		System.out.println("Finished to load Audio Source " + playbackBackendToUseSelelction.get());

		MainMusicPlayerProperty.get().AudioStreamLookupServiceProperty.bindBidirectional(AudioStreamLookupServiceProperty);
	}
	private void 				initAudioSourceProvider() throws Exception
	{
		System.out.println("Trying to load Audio Source " + audioStreamSourceToUseSelection.get());
		AudioSourceToLoad.set(Class.forName("isaatonimov.invy.core.audiosources." + audioStreamSourceToUseSelection.get()));
		AudioStreamSource audioSourceProvider = (AudioStreamSource) AudioSourceToLoad.get().getDeclaredConstructor().newInstance();
		MainAudioStreamSourceProperty.set(audioSourceProvider);
		System.out.println("Finished loading Audio Source " + audioStreamSourceToUseSelection.get());

		if(autoLocateOptimalInstanceOnStartup.get() == true)
			MainAudioStreamSourceProperty.get().DoSpeedTestAndSetAppropriately();

		AudioStreamLookupServiceProperty.get().StreamSourceProperty.bindBidirectional(MainAudioStreamSourceProperty);
	}
	private void 				setCustomPreferenceDialogSettings(PreferencesFx mainPreferencesDialog)
	{
		//Temp Folder Button Styling and Event Handler
		openTempFolderButton.setStyle("-fx-margin: 15px;");
		openTempFolderButton.setOnMouseClicked(event ->
		{
			ControllerProperty.get().OpenTempFolder();
		});

		mainPreferencesDialog.buttonsVisibility(false);

		//Set undecorated - so styling is uniform
		Stage prefStage = ((Stage) mainPreferencesDialog.getView().getScene().getWindow());
		prefStage.initStyle(StageStyle.UNDECORATED);
		prefStage.setAlwaysOnTop(true);

		prefStage.setWidth(850);
		prefStage.setHeight(350);

		Button closePreferences 	= new Button("Close");
		VBox buttonWrapper 		= new VBox(closePreferences);
		buttonWrapper.setAlignment(Pos.BOTTOM_RIGHT);
		buttonWrapper.setStyle("-fx-padding: 15px;");
		mainPreferencesDialog.getView().setBottom(buttonWrapper);

		//Custom Title Label
		Label title = new Label("Invy Preferences");
		HBox titleWrapper = new HBox(title);
		titleWrapper.setAlignment(Pos.CENTER);
		mainPreferencesDialog.getView().setTop(titleWrapper);

		//Remove default button bar
		((DialogPane) mainPreferencesDialog.getView().getParent()).getChildren().remove(2);

		//Add Mouse Listener for custom Button
		closePreferences.setOnMouseClicked(event ->
		{
			ControllerProperty.get().ClosePreferencesWindow();
		});
	}
	private void 				setTrayMenuSettings(FXTrayIcon invyTrayIcon)
	{
		MenuItem showHide 	= new MenuItem("Show Search");
		MenuItem song		= new MenuItem("No song yet...");
		MenuItem togglePlay	= new MenuItem("Play");
		MenuItem prevSong	= new MenuItem("Previous");
		MenuItem nextSong	= new MenuItem("Next");
		MenuItem preferences = new MenuItem("Preferences");
		MenuItem quit		= new MenuItem("Quit Invy");

		invyTrayIcon.addMenuItem(showHide);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(song);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(togglePlay);
		invyTrayIcon.addMenuItem(prevSong);
		invyTrayIcon.addMenuItem(nextSong);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(preferences);
		invyTrayIcon.addMenuItem(quit);

		//Menu Shortcut for Show / Hide -> MAC OS -> SHIFT + COMMAND + SPACE
		MenuShortcut showHideShortcut 		= new MenuShortcut(KeyEvent.VK_SPACE, true);
		//Menu Shortcut for opening current song info in default browser
		MenuShortcut showSongInfoShortcut 	= new MenuShortcut(KeyEvent.VK_TAB, true);
		//Menu Shortcut for toggling play/pause of current song
		MenuShortcut songTogglePlayShortcut 	= new MenuShortcut(KeyEvent.VK_F8, false);
		MenuShortcut songTogglePlayNext 	= new MenuShortcut(KeyEvent.VK_F9, false);
		MenuShortcut songTogglePlayPrev 	= new MenuShortcut(KeyEvent.VK_F7, false);

		//Custom Event for Menu Item Show / HIde
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, showHide, showHideShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, showHide, 	ToggleSearchViewServiceProperty.get()));
		//Custom Event for Menu Item Quit
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, quit, 		ApplicationShutdownServiceProperty.get()));
		//Custom Event for Menu Item Show Song Info
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, song, showSongInfoShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, song, 		ShowSongInfoServiceProperty.get()));
		//Custom Event for Play / Pause Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, togglePlay, songTogglePlayShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, togglePlay, 	SongTogglePlayServiceProperty.get()));
		//Custom Event for Play Next Song Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, nextSong, songTogglePlayNext));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, nextSong, 	SongPlayNextServiceProperty.get()));
		//Custom Event for Play Previous Song Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, prevSong, songTogglePlayPrev));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, prevSong, 	SongPlayPreviousServiceProperty.get()));

		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, preferences, PreferencesServiceProperty.get()));
	}
	private PreferencesFx 		initPreferencesPropertiesAndDialog() throws IOException
	{
		List<String> availableMediaPlayers 		= InvyUtils.getAvailableMediaPlayersAsList();

		//Playback Type
		playbackBackendToUse 				= new SimpleListProperty<>(FXCollections.observableArrayList(availableMediaPlayers));
		playbackBackendToUseSelelction 			= new SimpleObjectProperty(availableMediaPlayers.getFirst());

		List<String> availableAudioStreamSources = InvyUtils.getAvailableAudioSourcesAsList();
		audioStreamSourceToUse				= new SimpleListProperty<>(FXCollections.observableArrayList(availableAudioStreamSources));
		audioStreamSourceToUseSelection			= new SimpleObjectProperty(availableAudioStreamSources.getFirst());

		//Instance - Auto Locate
		//		if(autoLocateOptimalInstanceOnStartup.get() == true)
		//			currentPipedInstanceSelection = new SimpleObjectProperty(Piped.getNearestPipedInstanceRelativeToHost(pipedInstances));
		//		else
		//			currentPipedInstanceSelection = new SimpleObjectProperty();


		//Themes
		themeToUseItems = new SimpleListProperty<>(FXCollections.observableArrayList(InvyUtils.getAllAvailableThemesAsList()));
		themeToUseSelection = new SimpleObjectProperty(InvyUtils.getAllAvailableThemesAsList().getFirst());

		//Dialog Initialization
		return PreferencesFx.of(App.class,
				Category.of("Audio Source",
						Setting.of("Audio Source Provider", audioStreamSourceToUse, audioStreamSourceToUseSelection),
						Setting.of("Auto detect nearest (in ms) Instance Location on startup", autoLocateOptimalInstanceOnStartup)),

				Category.of("Music Player",
						Setting.of("Auto Shuffle Results", autoShuffleResultsActive),
						Setting.of("Media Playback Backend", playbackBackendToUse, playbackBackendToUseSelelction)),
				Category.of("Misc",
						Setting.of("App Theme", themeToUseItems, themeToUseSelection),
						Setting.of("Accesibility Features", accessibilityFeaturesActive),
						Setting.of("Temp Folder Location", defaultLogLocation, true),
						Setting.of(placeHolderNode),
						Setting.of(openTempFolderButton)));
	}
	private void 				initPreferencesHandlers()
	{
		playbackBackendToUseSelelction.addListener((observable, oldValue, newValue) ->
		{
			try
			{
				initMusicPlayer();
			} catch (InstantiationException e)
			{
				throw new RuntimeException(e);
			} catch (IllegalAccessException e)
			{
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e)
			{
				throw new RuntimeException(e);
			} catch (InvocationTargetException e)
			{
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e)
			{
				throw new RuntimeException(e);
			}
		});

		audioStreamSourceToUseSelection.addListener((observable, oldValue, newValue) ->
		{
			try
			{
				initAudioSourceProvider();
			}
			catch (InstantiationException e)
			{
				throw new RuntimeException(e);
			}
			catch (IllegalAccessException e)
			{
				throw new RuntimeException(e);
			}
			catch (NoSuchMethodException e)
			{
				throw new RuntimeException(e);
			} catch (InvocationTargetException e)
			{
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e)
			{
				throw new RuntimeException(e);
			} catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		});

		themeToUseSelection.addListener((observable, oldValue, newValue) ->
		{
			ControllerProperty.get().SetAppTheme((String) newValue);
		});

		accessibilityFeaturesActive.addListener((observable, oldValue, newValue) ->
		{
			if(newValue == true)
				ControllerProperty.get().ShowNotification("Accessabilty activated. Please restart the application.");
			else
				ControllerProperty.get().ShowNotification("Accessabilty deactivated. Please restart the application.");
		});
	}
	private void				initMusicPlayerHandlers()
	{
		MainMusicPlayerProperty.get().CurrentState.addListener((observable, oldValue, newValue) ->
		{
			ControllerProperty.get().	UpdateToggleMenutItem(newValue);
		});

		MainMusicPlayerProperty.get().CurrentlyPlayingRecord.addListener((observable, oldValue, newValue) ->
		{
			ControllerProperty.get().UpdateCurrentlyPlayingSongMenuItem();

			ControllerProperty.get().	ShowAudioNotification(MainMusicPlayerProperty.get().CurrentlyPlayingRecord.get());
			ControllerProperty.get().    ResetTrayIcon();
		});
	}
	private void				initRecordLookupServiceHandler()
	{
	}
	private void				initArtistLookupServiceHandlers()
	{
	}
	private void 				initSearchBarHandlers(Controller controller)
	{
		//Handler for Search Init
		SmartSearchBoxHandler smartSearchBoxHandler 		= new SmartSearchBoxHandler(controller);
		//Handler for Artist Selection
		ReccomendationViewHanderl recommendationViewHandler 	= new ReccomendationViewHanderl(controller);
		//Handler for Search Completion
		controller.SearchFieldProperty.get().					setOnKeyReleased(smartSearchBoxHandler);
		controller.RecommendationsProperty.get().				setOnMouseClicked(recommendationViewHandler);

		StageProperty.get().setOnShown(event ->
		{
			controller.UpdateSearchBarToggleMenu(true);
		});

		StageProperty.get().setOnHidden(event ->
		{
			controller.UpdateSearchBarToggleMenu(false);
		});
	}
	private Controller 			bindToController(Controller controller)
	{
		//Music Player to control
		controller.MusicPlayerProperty.			bindBidirectional(MainMusicPlayerProperty);
		controller.SearchBarStageProperty.			bindBidirectional(StageProperty);
		controller.PreferencesProperty.			bindBidirectional(PreferencesProperty);
		controller.MessageProperty.				bindBidirectional(MessageProperty);
		controller.NotificationProperty.			bindBidirectional(AudioNotificationProperty);

		controller.TryThisProperty.				bindBidirectional(recommendationsToUse);

		//Services To control
		controller.ArtistLookupServiceProperty.		bindBidirectional(ArtistLookupServiceProperty);
		controller.RecordLookupServiceProperty.		bindBidirectional(RecordingLookupServiceProperty);
		controller.AudioStreamLookupServiceProperty.	bindBidirectional(AudioStreamLookupServiceProperty);

		//Robot to control
		controller.FXRobotProperty.				bindBidirectional(FXRobotProperty);
		controller.AWTRobotProperty.			bindBidirectional(AWTRobotProperty);

		//Views to control (?)
		controller.ToggleViewServiceProperty.		bindBidirectional(ToggleSearchViewServiceProperty);
		controller.PlayTrayAnimationServiceProperty.	bindBidirectional(PlayTrayAnimationServiceProperty);
		controller.TrayProperty.				bindBidirectional(TrayIconProperty);

		return controller;
	}
    @Override
    public void 				start(Stage stage) throws Exception
	{
		StageProperty.		set(stage);
		PreferencesProperty	.set(initPreferencesPropertiesAndDialog());

		initBackgroundServices();
		initPreferencesHandlers();

		ControllerProperty.		set(loadMainScene(stage));
		TrayIconProperty.		set(initTrayIcon(stage));
		AudioNotificationProperty.	set(initAudioNotificationFX());
		MessageProperty.			set(initMessageFX());

		initUIHelperServices(ControllerProperty.get());
		setStageSettings(stage);
		setCustomPreferenceDialogSettings(PreferencesProperty.get());
		initAudioSourceProvider();
		initMusicPlayer();
		bindToController		(ControllerProperty.get());
		initSearchBarHandlers	(ControllerProperty.get());
		setTrayMenuSettings	(TrayIconProperty.get());
		initTrayAnimationCreation(TrayIconProperty.get());

		initAccessibilityServicesIfActive();

		initMusicPlayerHandlers();
		initRecordLookupServiceHandler();
		initArtistLookupServiceHandlers();

		ControllerProperty.get().HideRecommendations();
		ControllerProperty.get().SetAppTheme((String)themeToUseSelection.get());

		TrayIconProperty.get().show();
	}

	@Override
	public void 				stop()
	{
		System.out.println("Invy is shutting down...");

		MainMusicPlayerProperty.get().Shutdown();
		TrayIconProperty.get().hide();
		//System.exit(0);
	}

    public static void 			main(String[] args) throws IOException
	{
		InvyUtils.clearTempFolder();
		launch();
    }
}