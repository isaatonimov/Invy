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

	public RecordingLookupSuccessHandler(ListView toUpdate, LookupService toStart) throws InterruptedException
	{
		listItems 		= FXCollections.observableArrayList();

		this.toUpdate 	= toUpdate;
		this.toStart		= toStart;
	}

	@Override
	public void handle(Event event)
	{
//		listItems.clear();
//
//		for(var vr : (List<String>) ((RecordingLookupService)event.getSource()).getValue())
//			listItems.add(vr);
//
//		toUpdate.setItems(listItems);
//
//		toStart.lookupSearchTerm.set(((LookupService)event.getSource()).lookupSearchTerm.get());
//		toStart.start();
	}
}
