package isaatonimov.invy.handlers;

import javafx.concurrent.Service;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SongViewSearchhandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private Service toStart;

	public SongViewSearchhandler(Service toStart)
	{
		this.toStart = toStart;
	}
	@Override
	public void handle(KeyEvent event)
	{
		if(event.getCode() == KeyCode.ENTER)
		{
			if(!toStart.isRunning())
			{
				((TextField)(event.getSource())).getScene().getWindow().hide();
				toStart.restart();
			}
		}
	}
}
