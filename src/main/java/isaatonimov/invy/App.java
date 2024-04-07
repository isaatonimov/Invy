package isaatonimov.invy;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import isaatonimov.invy.controller.ViewManager;
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
	private VideoLookupService videoLookupService;
	private RecordingLookupService recordingLookupService;

	//UI Services
	private ToggleViewService toggleViewService;

	//Automation
	private java.awt.Robot 	iRobot;

	private FXMLLoader		mainLoader;
	private Scene			mainScene;
	private Stage			mainStage;
	private ViewManager viewManager;
	private FXTrayIcon		invyTrayIcon;


	private void initUI(Stage mainStage) throws IOException, URISyntaxException
	{
		//UI
		mainLoader 	= new FXMLLoader(getClass().getResource("/isaatonimov/invy/views/main.fxml"));
		mainScene 	= new Scene(mainLoader.load());
		viewManager = mainLoader.getController();

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
		videoLookupService 	= new VideoLookupService		(mainInstance, null);
		recordingLookupService	= new RecordingLookupService	();
	}

	private void initUIHelperServices()
	{
		toggleViewService	= new ToggleViewService(mainStage);
	}

	private void initAccessibilityServices() throws AWTException
	{
		iRobot = new Robot();
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

			viewManager.setStage(mainStage);

			//Configurations concerning TrayIcon and its Menu items
			//TODO Extend -> add more MenuItems
			MenuItem showHide = new MenuItem("Show / Hide");
			invyTrayIcon.addMenuItem(showHide);
			invyTrayIcon.addExitItem("Quit Invy");

			//Menu Shortcut for Show / Hide -> MAC OS -> SHIFT + COMMAND + SPACE
			MenuShortcut showHideShortcut = new MenuShortcut(KeyEvent.VK_SPACE, true);

			//Custom Event for Menu Item Show / HIde
			EventQueue.invokeLater(new SetMenuItemShortcut(invyTrayIcon, showHide, showHideShortcut));
			EventQueue.invokeLater(new SetMenuItemAction(invyTrayIcon, showHide, toggleViewService));

			//View Manager -> set fields
			viewManager.setTrayIcon(invyTrayIcon);
			//viewManager.setInvidiouseInstance(mainInvidiousInstance);
			//viewManager.setMusicPlayer(musicPlayer);
			//Background
			viewManager.setVideoLookupService(videoLookupService);
			viewManager.setRecordingLookupService(recordingLookupService);
			//UI
			viewManager.setToggleViewService(toggleViewService);

			//View Manager Listener
			viewManager.getMusicSearchTextField().setOnKeyReleased(new SongViewSearchhandler(recordingLookupService));

			//Native Hook -> Shortcut Listener
			GlobalScreen.registerNativeHook();

			ShortcutKeyListener mainShortcutKeyListener = new ShortcutKeyListener();
			mainShortcutKeyListener.addShortcutToListenFor(showHideShortcut, toggleViewService);

			GlobalScreen.addNativeKeyListener(mainShortcutKeyListener);

			//Main Stage Event Handler -> Again very hacky
			mainStage.setOnShown(new MainStageShownEventHandler(iRobot, viewManager.getMusicSearchTextField()));
			mainStage.setOnHidden(new MainStageHiddenEventHandler());

			//Service Event Handler - Success Only
			EventType<WorkerStateEvent> successEvent = WorkerStateEvent.WORKER_STATE_SUCCEEDED;
			//recordingLookupService.addEventHandler	(successEvent, 	new RecordingLookupSuccessHandler(viewManager.getSongView(), videoLookupService));
			//videoLookupService.addEventHandler	(successEvent, 	new VideoLookupSuccessHandler(mainInvidiousInstance));
			toggleViewService.addEventHandler		(successEvent, 	new ToggleViewSuccessHandler());

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
			//Prompt -> Accessibility Features
			throw new RuntimeException(e);
		}
		catch (AWTException | InterruptedException e)
		{
			//Prompt -> ?
			throw new RuntimeException(e);
		}
	}

    public static void main(String[] args)
	{
		//Clear Temp Folder on startup
		AppUtils.clearTempFolder();

        launch();
    }
}