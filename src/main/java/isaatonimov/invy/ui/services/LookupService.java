package isaatonimov.invy.ui.services;

import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LookupService extends Service
{
	public SimpleStringProperty lookupSearchTerm = new SimpleStringProperty(this, "lookupSearchTerm");
	@Override
	protected Task createTask()
	{
		return null;
	}
}
