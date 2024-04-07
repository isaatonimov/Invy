package isaatonimov.invy.handlers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.event.EventHandler;

public class LookupServiceSuccessHandler implements EventHandler
{
	public SimpleBooleanProperty triggered = new SimpleBooleanProperty(this, "triggered", false);
	@Override
	public void handle(Event event)
	{
		triggered.set(true);
	}
}
