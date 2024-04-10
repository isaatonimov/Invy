package isaatonimov.invy.handlers;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.ui.services.ArtistLookupService;
import isaatonimov.invy.ui.services.RecordingLookupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class SmartSearchBoxHandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private ArtistLookupService 	artistLookupService;
	private RecordingLookupService 	recordingLookupService;
	private TextField 			textField;
	private ListView				recommendationsView;
	private ObservableList<Artist>	artistsSuggestionList;
	private Controller 			controller;
	public SmartSearchBoxHandler(Controller controller)
	{
		this.controller 			= controller;
		this.recommendationsView 	= controller.getRecommendationsView();
		this.textField 			= controller.getArtistSearchTextField();
		this.artistLookupService 	= controller.getArtisLookupService();
		this.recordingLookupService	= controller.getRecordingLookupService();

		artistLookupService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				artistsSuggestionList = FXCollections.observableArrayList((List<Artist>)artistLookupService.getValue());

				if(artistsSuggestionList.size() > 0)
				{
					recommendationsView.setItems(artistsSuggestionList);
					controller.showRecommendations();
				}
				else
					controller.hideRecommendations();
			}
		});
	}

	@Override
	public void handle(KeyEvent event)
	{
		if(textField == null)
			textField = controller.getArtistSearchTextField();

		if(textField.getText() != null && textField.getText().length() == 0)
			controller.hideRecommendations();

		if(event.getCode() == KeyCode.ESCAPE)
			controller.hideMainWindow();

		if(textField.getText() != null && textField.getText().length() > 2)
		{
			artistLookupService.updateQuery(textField.getText());
			artistLookupService.restart();

			System.out.println("Key Pressed - current String: " + textField.getText());
		}

		if(event.getCode() == KeyCode.ENTER)
		{
			//recordingLookupService.updateArtist(controller.get);
			//recordingLookupService.restart();
		}

	}
}
