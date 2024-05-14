package isaatonimov.invy.handlers;

import isaatonimov.invy.controllers.Controller;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.MusicMetadata;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ReccomendationViewHanderl implements EventHandler<Event>
{
	private final Controller controller;
	private ListView 			recommendationView;
	private SelectionModel<MusicMetadata>	artistSelectionModel;
	public ReccomendationViewHanderl(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void handle(Event event)
	{
		if(recommendationView == null)
			recommendationView = (ListView<MusicMetadata>) event.getSource();

		if(artistSelectionModel == null)
			artistSelectionModel = recommendationView.getSelectionModel();

		if(event instanceof KeyEvent keyEvent)
		{

			if(keyEvent.getCode() == KeyCode.ENTER)
				controller.SearchAndPlay(artistSelectionModel.getSelectedItem());
		}

		if(event instanceof MouseEvent)
		{
			String toSet = artistSelectionModel.getSelectedItem().toString();
			controller.SearchFieldProperty.get().setText(toSet);
			controller.HideSearchBar();
			controller.SearchAndPlay(artistSelectionModel.getSelectedItem());
		}
	}
}
