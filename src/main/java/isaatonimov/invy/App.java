package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.core.MusicPlayer;
import isaatonimov.invy.core.invidious.InvidiousInstance;
import isaatonimov.invy.handlers.MainStageHiddenEventHandler;
import isaatonimov.invy.handlers.MainStageShownEventHandler;
import isaatonimov.invy.handlers.SongViewSearchhandler;
import isaatonimov.invy.handlers.ToggleViewSuccessHandler;
import isaatonimov.invy.helpers.AppUtils;
import isaatonimov.invy.misc.ShortcutKeyListener;
import isaatonimov.invy.ui.runnables.SetMenuItemAction;
import isaatonimov.invy.ui.runnables.SetMenuItemShortcut;
import isaatonimov.invy.ui.services.ApplicationShutdownService;
import isaatonimov.invy.ui.services.RecordingLookupService;
import isaatonimov.invy.ui.services.ToggleViewService;
import isaatonimov.invy.ui.services.VideoLookupService;
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
import java.net.URISyntaxException;
import java.util.Objects;

public class App extends Application
{
	//Core
	private InvidiousInstance mainInstance;
	private MusicPlayer	 mainMusicPlayer;

	//Background Services
	private VideoLookupService 			videoLookupService;
	private RecordingLookupService 		recordingLookupService;

	//UI Services
	private ToggleViewService 			toggleViewService;
	private ApplicationShutdownService 	applicationShutdownService;

	//Automation
	private java.awt.Robot 	iRobot;

	private FXMLLoader		mainLoader;
	private Scene			mainScene;
	private Stage			mainStage;
	private Controller controller;
	private FXTrayIcon		invyTrayIcon;


	private void initUI(Stage mainStage) throws IOException, URISyntaxException
	{
		//UI
		mainLoader 	= new FXMLLoader(getClass().getResource("/isaatonimov/invy/views/main.fxml"));
		mainScene 	= new Scene(mainLoader.load());
		controller = mainLoader.getController();

		invyTrayIcon 	= new FXTrayIcon(mainStage, Objects.requireNonNull(getClass().getResource("/isaatonimov/invy/images/logo.png")));

		this.mainStage = mainStage;
	}

	private void initCore() throws URISyntaxException
	{
		mainInstance 		= new InvidiousInstance(AppUtils.getMainInvidiousInstanceURL());
		mainMusicPlayer 	= new MusicPlayer(mainInstance);
	}

	private void setStageSettings()
	{
		mainStage.setTitle("Invy");
		mainStage.initStyle(StageStyle.UNDECORATED);
		mainStage.setScene(mainScene);
		mainStage.setAlwaysOnTop(true);
	}

	private void initBackgroundServices()
	{
		videoLookupService 		= new VideoLookupService		(mainInstance);
		recordingLookupService		= new RecordingLookupService	();
	}

	private void initUIHelperServices()
	{
		toggleViewService		= new ToggleViewService(mainStage);
		applicationShutdownService 	= new ApplicationShutdownService();
	}

	private void initAccessibilityServices() throws AWTException
	{
		iRobot 				= new Robot();
	}

    @Override
    public void start(Stage stage) throws IOException
    {
		try
		{
			initCore();
			//Initialises everything UI
			initUI(stage);

			//Initialises Background Services that interact / work with UI
			initBackgroundServices();
			initUIHelperServices();
			initAccessibilityServices();

			//Styling -> currently redundant -> also in fxml for preview in sceneBuilder
			//TODO -> change before deploying
			mainScene.setUserAgentStylesheet(Objects.requireNonNull(getClass().getResource("/isaatonimov/invy/themes/primer-dark.css")).toString());

			//Sets all Stage settings
			setStageSettings();

			controller.setStage(mainStage);

			//Configurations concerning TrayIcon and its Menu items
			//TODO Extend -> add more MenuItems
			MenuItem showHide 	= new MenuItem("Show / Hide");
			MenuItem quit		= new MenuItem("Quit Invy");
			invyTrayIcon.addMenuItem(showHide);
			invyTrayIcon.addMenuItem(quit);
			//Menu Shortcut for Show / Hide -> MAC OS -> SHIFT + COMMAND + SPACE
			MenuShortcut showHideShortcut = new MenuShortcut(KeyEvent.VK_SPACE, true);

			//Custom Event for Menu Item Show / HIde
			EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, showHide, showHideShortcut));
			EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, showHide, toggleViewService));
			EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, quit, applicationShutdownService));

			//View Manager -> set fields
			controller.setTrayIcon				(invyTrayIcon);
			controller.setInvidiouseInstance		(mainInstance);
			controller.setMusicPlayer			(mainMusicPlayer);

			//Background
			controller.setVideoLookupService		(videoLookupService);
			controller.setRecordingLookupService	(recordingLookupService);

			//UI
			controller.setToggleViewService		(toggleViewService);

			//Native Hook -> Shortcut Listener
			GlobalScreen.registerNativeHook();

			ShortcutKeyListener mainShortcutKeyListener = new ShortcutKeyListener();
			mainShortcutKeyListener.addShortcutToListenFor(showHideShortcut, toggleViewService);

			GlobalScreen.addNativeKeyListener(mainShortcutKeyListener);

			//Main Stage Event Handler -> Again very hacky
			mainStage.setOnShown(new MainStageShownEventHandler(iRobot, controller.getMusicSearchTextField()));
			mainStage.setOnHidden(new MainStageHiddenEventHandler());

			//Service Event Handler - Success Only
			EventType<WorkerStateEvent> 		successEvent = WorkerStateEvent.WORKER_STATE_SUCCEEDED;
			toggleViewService.addEventHandler		(successEvent, 	new ToggleViewSuccessHandler());

			SongViewSearchhandler songSearchHandler = new SongViewSearchhandler(mainMusicPlayer, recordingLookupService);
			controller.getMusicSearchTextField().setOnKeyReleased(songSearchHandler);

			//Show UI / triggers
			invyTrayIcon.show();
		}
        catch (URISyntaxException e)
		{
			//Prompt -> Invidious Instance URL Error
			throw new RuntimeException(e);
		}
		catch (NativeHookException e)
		{
			System.out.println("Enable Accessabilty Features to use Menu Shortcut.");
		}
		catch (AWTException | InterruptedException e)
		{
			//Prompt -> ?
			throw new RuntimeException(e);
		}
	}
	@Override
	public void stop()
	{
		System.out.println("Stage is closing");
		invyTrayIcon.hide();
		System.exit(0);
	}

    public static void main(String[] args)
	{
		//Clear Temp Folder on startup
		AppUtils.clearTempFolder();

        launch();
    }
}