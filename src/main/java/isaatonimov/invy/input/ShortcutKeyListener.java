package isaatonimov.invy.input;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Worker;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortcutKeyListener implements NativeKeyListener
{
	private List<Integer> 					keyEventQueue 			= new ArrayList<>();
	private HashMap<MenuShortcut, Service>	shortcutActionMap 		= new HashMap<>();
	private HashMap<Service, Worker.State>	serviceStates 			= new HashMap<>();
	private HashMap<Integer, Service>		simpleShortcutActionMap 	= new HashMap<>();

	public ShortcutKeyListener() throws InterruptedException
	{
		new Thread(() ->
		{
//			try
//			{
////				while(true)
////				{
////					Thread.sleep(200);
////					resetIfSucceeded();
////					updateWorkerStateMap();
////				}
//			}
//			catch (InterruptedException e)
//			{
//				throw new RuntimeException(e);
//			}
		}).start();
	}

	public void addShortcutToListenFor(MenuShortcut shortcut, Service toStart)
	{
		shortcutActionMap.put(shortcut, toStart);
		updateWorkerStateMap();
	}

	public void addSimpleShortcutToListenFor(int keyCode, Service toStart)
	{
		System.out.println("Adding: " + keyCode + " -> " + toStart.toString());
		simpleShortcutActionMap.put(keyCode, toStart);
	}

	private void updateWorkerStateMap()
	{
		Platform.runLater(() ->
		{
			serviceStates.clear();

			for(var entry : shortcutActionMap.entrySet())
			{
				//System.out.println("Updated Service State Map: " + entry.getValue().toString() + " -> " + entry.getValue().getState().toString());
				serviceStates.put(entry.getValue(), entry.getValue().getState());
			}
		});
	}

	private void resetIfSucceeded()
	{
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				for(var entry : serviceStates.entrySet())
				{
					if(entry.getValue() == Worker.State.SUCCEEDED)
						entry.getKey().reset();
				}
			}
		});
	}

	private List<Integer> translateMenuShortcutToKeyCodes(MenuShortcut menuShortcut)
	{
		List<Integer> keyCodes = new ArrayList<>();

		// To be added -  hard coded for now

		return keyCodes;
	}

	public void StartServiceInCorrectThread(Service toStart)
	{
		Platform.runLater(() -> toStart.restart());
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent nativeEvent)
	{
		if(keyEventQueue.size() >= 3)
			keyEventQueue.clear();

		for(var entry : serviceStates.entrySet())
		{
			if(entry.getValue().equals(Worker.State.READY))
			{
				keyEventQueue.add(nativeEvent.getKeyCode());
			}
		}
	}
	@Override
	public void nativeKeyReleased(NativeKeyEvent nativeEvent)
	{
		System.out.println("Keycode: " + nativeEvent.getKeyCode());

		for(var entry : simpleShortcutActionMap.entrySet())
		{
			if(nativeEvent.getKeyCode() == entry.getKey())
				StartServiceInCorrectThread(entry.getValue());
		}

		if(nativeEvent.getKeyCode() == 57)
		{
			for(var entry : serviceStates.entrySet())
			{
				if(entry.getValue().equals(Worker.State.READY))
				{
					if (keyEventQueue.contains(42) && keyEventQueue.contains(3675) && keyEventQueue.contains(57))
					{
						//System.out.println("Combination alrighty -> Service Start");
						StartServiceInCorrectThread(entry.getKey());
					}
					else
					{
						keyEventQueue.clear();
					}
				}
			}
		}
	}
}