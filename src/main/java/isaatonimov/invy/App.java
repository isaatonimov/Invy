package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
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
	private AudioStreamLookupService audioStreamLookupService;
	private RecordingLookupService 		recordingLookupService;
	private ArtistLookupService			artistLookupService;

	//UI Services
	private ToggleViewService 			toggleViewService;
	private SongInfoService			showSongInfoService;
	private ApplicationShutdownService 	applicationShutdownService;

	//Automation
	private java.awt.Robot 	iRobot;

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

		//Uses dynamic Instances of Piped and Invidious
		audioStreamLookupService = new AudioStreamLookupService(controller);
	}

	private void initUIHelperServices(Controller controller)
	{
		toggleViewService		= new ToggleViewService			(controller);
		showSongInfoService		= new SongInfoService			(controller);
		applicationShutdownService 	= new ApplicationShutdownService	(controller);
	}

	private void initAccessibilityServices(MenuShortcut showHideShortcut)
	{
		try
		{
			iRobot 				= new Robot();

			//Native Hook -> Shortcut Listener
			//GlobalScreen.registerNativeHook();

			ShortcutKeyListener mainShortcutKeyListener = new ShortcutKeyListener();
			mainShortcutKeyListener.addShortcutToListenFor(showHideShortcut, toggleViewService);

			//GlobalScreen.addNativeKeyListener(mainShortcutKeyListener);
		}
		catch (InterruptedException | AWTException e)
		{
			System.out.println("Enable Accessabilty Features to use Menu Shortcut.");
		}
	}

    @Override
    public void start(Stage stage) throws IOException
    {
		initCore();
		initUI(stage);

		//Initialises Background Services that do not interact directly with the ui
		initBackgroundServices();
		//Sets all Stage settings
		setStageSettings();

		initUIHelperServices(controller);

		//Configurations concerning TrayIcon and its Menu items
		//TODO Extend -> add more MenuItems
		MenuItem showHide 	= new MenuItem("Show Search");
		MenuItem song		= new MenuItem("No song yet...");
		MenuItem togglePlay	= new MenuItem("Play");
		MenuItem nextSong	= new MenuItem("Next");
		MenuItem quit		= new MenuItem("Quit Invy");

		invyTrayIcon.addMenuItem(showHide);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(song);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(togglePlay);
		invyTrayIcon.addMenuItem(nextSong);
		invyTrayIcon.addSeparator();
		invyTrayIcon.addMenuItem(quit);

		controller.setMenuItemShowHide(showHide);
		controller.setMenuItemSong(song);
		controller.setMenuItemTogglePlay(togglePlay);

		//Initialise all UI Helper Services

		//Menu Shortcut for Show / Hide -> MAC OS -> SHIFT + COMMAND + SPACE
		MenuShortcut showHideShortcut = new MenuShortcut(KeyEvent.VK_SPACE, true);
		//Menu Shortcut for opening current song info in default browser
		MenuShortcut showSongInfoShortcut = new MenuShortcut(KeyEvent.VK_TAB, true);

		//Custom Event for Menu Item Show / HIde
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, showHide, showHideShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, showHide, toggleViewService));
		//Custom Event for Menu Item Quit
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, quit, applicationShutdownService));
		//Custom Event for Menu Item Show Song Info
		EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, song, showSongInfoShortcut));
		EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, song, showSongInfoService));

		//View Manager -> set fields
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
		initAccessibilityServices(showHideShortcut);
		controller.setRobot(iRobot);

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

		//music Player instance an link
		mainMusicPlayer 	= new MusicPlayer(controller);
		controller.setMusicPlayer(mainMusicPlayer);

		//TESTING -> API Piped

		//show the main icon
		invyTrayIcon.show();
	}

	@Override
	public void stop()
	{
		System.out.println("Stage is closing");
		//invyTrayIcon.hide();
		//System.exit(0);
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