package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;
import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.core.invidious.PipedInstance;
import isaatonimov.invy.handlers.*;
import isaatonimov.invy.helpers.AppUtils;
import isaatonimov.invy.misc.ShortcutKeyListener;
import isaatonimov.invy.ui.runnables.SetMenuItemAction;
import isaatonimov.invy.ui.runnables.SetMenuItemShortcut;
import isaatonimov.invy.ui.services.*;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/*
	TODO: Better Error Handling
	Is this realy MVC?
 */
public class App extends Application
{
	//Core
	private InvidiousInstance 	invidiousInstance;
	private PipedInstance 		pipedInstance;
	private MusicPlayer	 	mainMusicPlayer;

	//Background Services
	private AudioStreamLookupService 	audioStreamLookupService;
	private RecordingLookupService 		recordingLookupService;
	private ArtistLookupService			artistLookupService;

	//UI Services
	private ToggleViewService 			toggleViewService;
	private SongInfoService			showSongInfoService;
	private SongTogglePlayService		songTogglePlayService;
	private SongPlayNextService			songPlayNextService;
	private SongPlayPrevService			songPlayPrevService;
	private ApplicationShutdownService 	applicationShutdownService;

	//Automation
	private java.awt.Robot 	iRobot;
	private boolean 			isMouseOutsideMainWindow;

	private FXMLLoader		mainLoader;
	private Scene			mainScene;
	private Stage			mainStage;
	private Controller 		controller;
	private FXTrayIcon		invyTrayIcon;


	private void initUI(Stage mainStage)
	{
		//UI
		mainLoader 	= new FXMLLoader(getClass().getResource("/isaatonimov/invy/views/main.fxml"));
		try
		{
			mainScene 	= new Scene(mainLoader.load());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		controller 		= mainLoader.getController();
		invyTrayIcon 	= new FXTrayIcon(mainStage, Objects.requireNonNull(getClass().getResource("/isaatonimov/invy/images/logo.png")));
		this.mainStage 	= mainStage;

		controller.setStage(mainStage);

		//On Startup Recommendations are hidden -> so that the view in scenebuilder can stay maximized
		controller.hideRecommendations();
	}

	private void initCore()
	{
		try
		{
			invidiousInstance = new InvidiousInstance(AppUtils.getMainInvidiousInstanceURL());
			pipedInstance	= new PipedInstance(new URL("https://pipedapi.kavin.rocks"));
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
		catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
	}

	private void setStageSettings()
	{
		//set app icon
		mainStage.getIcons().add(new Image(App.class.getResource("/isaatonimov/invy/images/invy.icns").toString()));

		//set
		mainStage.setTitle("Invy");
		mainStage.initStyle(StageStyle.UNDECORATED);
		mainStage.setScene(mainScene);
		mainStage.setAlwaysOnTop(true);

		//Styling -> currently redundant -> also in fxml for preview in sceneBuilder
		//TODO -> change before deploying
		mainScene.setUserAgentStylesheet(Objects.requireNonNull(getClass().getResource("/isaatonimov/invy/themes/primer-dark.css")).toString());
	}

	private void initBackgroundServices()
	{
		//Uses static MusicBrainz Class Methods - because there is just one MusicBrainz Instance
		recordingLookupService		= new RecordingLookupService	();
		artistLookupService		= new ArtistLookupService		();

		//Uses dynamic Instances of Piped
		audioStreamLookupService = new AudioStreamLookupService(pipedInstance);
	}

	private void initUIHelperServices(Controller controller)
	{
		toggleViewService		= new ToggleViewService			(controller);
		showSongInfoService		= new SongInfoService			(controller);
		applicationShutdownService 	= new ApplicationShutdownService	(controller);
		songTogglePlayService		= new SongTogglePlayService		(controller);
		songPlayNextService		= new SongPlayNextService			(controller);
		songPlayPrevService		= new SongPlayPrevService			(controller);
	}

	private void initAccessibilityServices(MenuShortcut showHideShortcut, MenuShortcut songToggleShortcut, MenuShortcut playNextShortcut, MenuShortcut playPrevShortcut)
	{
		try
		{
			iRobot 				= new Robot();

			//Native Hook -> Shortcut Listener
			GlobalScreen.registerNativeHook();

			ShortcutKeyListener mainShortcutKeyListener = new ShortcutKeyListener();
			mainShortcutKeyListener.addShortcutToListenFor		(showHideShortcut, 	toggleViewService);
			mainShortcutKeyListener.addSimpleShortcutToListenFor	(65, 		songPlayPrevService);
			mainShortcutKeyListener.addSimpleShortcutToListenFor	(66, 		songTogglePlayService);
			mainShortcutKeyListener.addSimpleShortcutToListenFor	(67, 		songPlayNextService);

			NativeMouseListener mouseListener = new NativeMouseListener()
			{
				@Override
				public void nativeMouseClicked(NativeMouseEvent nativeEvent)
				{
					if(isMouseOutsideMainWindow)
					{
						controller.hideMainWindow();
						isMouseOutsideMainWindow = false;
					}
				}
			};

			GlobalScreen.addNativeKeyListener(mainShortcutKeyListener);
			GlobalScreen.addNativeMouseListener(mouseListener);

			controller.setRobot(iRobot);
		}
		catch (InterruptedException | AWTException e)
		{
			System.out.println("Enable Accessabilty Features to use Menu Shortcut.");
		} catch (NativeHookException e)
		{
			throw new RuntimeException(e);
		}
	}

    @Override
    public void start(Stage stage) throws IOException
    {
		initCore();
		initUI(stage);

		//Initialises Background Services that do not interact directly with the ui
		initBackgroundServices();

		//music Player instance after background services are started
		mainMusicPlayer 	= new MusicPlayer(audioStreamLookupService);

		//Sets all Stage settings
		setStageSettings();

		initUIHelperServices(controller);

		//Configurations concerning TrayIcon and its Menu items
		//TODO Extend -> add more MenuItems
		MenuItem showHide 	= new MenuItem("Show Search");
		MenuItem song		= new MenuItem("No song yet...");
		MenuItem togglePlay	= new MenuItem("Play");
		MenuItem prevSong	= new MenuItem("Previous");
		MenuItem nextSong	= new MenuItem("Next");
		MenuItem quit		= new MenuItem("Quit Invy");

		FXTrayIcon trayIconTest = new FXTrayIcon(this.mainStage);


		invyTrayIcon.addMenuItem(showHide);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(song);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(togglePlay);
		invyTrayIcon.addMenuItem(prevSong);
		invyTrayIcon.addMenuItem(nextSong);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(quit);

		controller.setMenuItemShowHide(showHide);
		controller.setMenuItemSong(song);
		controller.setMenuItemTogglePlay(togglePlay);

		//Initialise all UI Helper Services

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
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, showHide, toggleViewService));
		//Custom Event for Menu Item Quit
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, quit, applicationShutdownService));
		//Custom Event for Menu Item Show Song Info
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, song, showSongInfoShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, song, showSongInfoService));
		//Custom Event for Play / Pause Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, togglePlay, songTogglePlayShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, togglePlay, songTogglePlayService));
		//Custom Event for Play Next Song Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, nextSong, songTogglePlayNext));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, nextSong, songPlayNextService));
		//Custom Event for Play Previous Song Shortcut
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, prevSong, songTogglePlayPrev));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, prevSong, songPlayPrevService));

		//Controller -> set fields
		controller.setTrayIcon				(invyTrayIcon);
		controller.setInvidiouseInstance		(invidiousInstance);
		controller.setPipedInstance			(pipedInstance);
		controller.setMusicPlayer			(mainMusicPlayer);

		//Background
		controller.setVideoLookupService		(audioStreamLookupService);
		controller.setRecordingLookupService	(recordingLookupService);
		controller.setArtistLookupService		(artistLookupService);
		controller.setRobot				(iRobot);

		//UI
		controller.setToggleViewService		(toggleViewService);

		//
		initAccessibilityServices(showHideShortcut, songTogglePlayShortcut, songTogglePlayNext, songTogglePlayPrev);

		//Main Stage Event Handler -> Again very hacky
		mainStage.setOnShown(new MainStageShownEventHandler(controller));

		try
		{
			mainStage.setOnHidden(new MainStageHiddenEventHandler(controller));
		}
		catch (AWTException e)
		{
			throw new RuntimeException(e);
		}

		//Service Event Handler - Success Only
		EventType<WorkerStateEvent> 		successEvent = WorkerStateEvent.WORKER_STATE_SUCCEEDED;
		toggleViewService.addEventHandler		(successEvent, 	new ToggleViewSuccessHandler());

		//Handler for Search Init
		SmartSearchBoxHandler smartSearchBoxHandler = new SmartSearchBoxHandler(controller);

		//Handler for Artist Selection
		ReccomendationViewHanderl recommendationViewHandler = new ReccomendationViewHanderl(controller);

		//Handler for Search Completion
		controller.getArtistSearchTextField().setOnKeyReleased(smartSearchBoxHandler);
		controller.getRecommendationsView().setOnMouseClicked(recommendationViewHandler);

		//Handler for MainPane TODO: Make better
		controller.getRootPane().setOnMouseExited(event -> isMouseOutsideMainWindow = true);
		controller.getRootPane().setOnMouseEntered(event -> isMouseOutsideMainWindow = false);

		controller.setMusicPlayer(mainMusicPlayer);

		//show the main icon
		invyTrayIcon.show();
	}

	@Override
	public void stop()
	{
		System.out.println("Stage is closing");
		mainMusicPlayer.shutdown();
		invyTrayIcon.hide();
		System.exit(0);
	}

    public static void main(String[] args)
	{
		//Clear Temp Folder on startup
		try
		{
			AppUtils.clearTempFolder();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		launch();

    }
}