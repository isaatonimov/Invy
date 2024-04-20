package isaatonimov.invy.handlers;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.models.musicbrainz.Artist;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ReccomendationViewHanderl implements EventHandler<Event>
{
	private Controller controller;
	private ListView 			recommendationView;
	private SelectionModel<Artist>	artistSelectionModel;
	public ReccomendationViewHanderl(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void handle(Event event)
	{
		if(recommendationView == null)
			recommendationView = (ListView<Artist>) event.getSource();

		if(artistSelectionModel == null)
			artistSelectionModel = recommendationView.getSelectionModel();

		if(event instanceof KeyEvent)
		{
			KeyEvent keyEvent = (KeyEvent) event;

			if(keyEvent.getCode() == KeyCode.ENTER)
				controller.searchAndPlay(artistSelectionModel.getSelectedItem());
		}

		if(event instanceof MouseEvent)
		{
			String toSet = artistSelectionModel.getSelectedItem().toString();
			controller.SearchFieldProperty.get().setText(toSet);
			controller.hideSearchBar();
			controller.searchAndPlay(artistSelectionModel.getSelectedItem());
		}
	}
}
