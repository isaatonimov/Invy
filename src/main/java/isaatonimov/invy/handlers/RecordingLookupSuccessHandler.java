package isaatonimov.invy.handlers;

import isaatonimov.invy.ui.services.LookupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.ListView;

public class RecordingLookupSuccessHandler implements javafx.event.EventHandler
{
	private ListView 			toUpdate;
	private LookupService 		toStart;
	private ObservableList<String> 	listItems;

	public RecordingLookupSuccessHandler() throws InterruptedException
	{
		listItems 		= FXCollections.observableArrayList();

		this.toUpdate 	= toUpdate;
		this.toStart		= toStart;
	}

	@Override
	public void handle(Event event)
	{

	}
}
