package isaatonimov.invy.handlers;

import isaatonimov.invy.controller.Controller;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.services.background.ArtistLookupService;
import isaatonimov.invy.services.background.RecordingLookupService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.List;

public class SmartSearchBoxHandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private ArtistLookupService 	artistLookupService;
	private RecordingLookupService   recordingLookupService;
	private TextField 			textField;
	private ListView				recommendationsView;
	private ObservableList<Artist>	artistsSuggestionList;
	private ObservableList<String>	messagesList = FXCollections.observableArrayList(Arrays.asList("No Results found..."));
	private Controller 			controller;
	public SmartSearchBoxHandler(Controller controller)
	{
		this.controller 			= controller;
		this.recommendationsView 	= controller.RecommendationsProperty.get();
		this.textField 			= controller.SearchFieldProperty.get();
		this.artistLookupService 	= controller.ArtistLookupServiceProperty.get();
		this.recordingLookupService	= controller.RecordLookupServiceProperty.get();

		artistLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			if(artistLookupService.ResultValueProperty.get() != null)
				artistsSuggestionList 	= FXCollections.observableArrayList((List<Artist>) artistLookupService.ResultValueProperty.get());

			Platform.runLater(() ->
			{
				if(artistLookupService.ResultValueProperty.get() == null)
				{
					recommendationsView.setItems(messagesList);
					controller.showRecommendationMessage();
				}

				else
					if(artistsSuggestionList.size() > 0)
					{
						recommendationsView.setItems(artistsSuggestionList);
						controller.showRecommendations();
					}
					else
						controller.hideRecommendations();
			});
		});
	}

	@Override
	public void handle(KeyEvent event)
	{
		if(textField == null)
			textField = controller.SearchFieldProperty.get();

		if(textField.getText() != null && textField.getText().length() == 0)
			controller.hideRecommendations();

		if(event.getCode() == KeyCode.ESCAPE)
			controller.hideSearchBar();

		if(textField.getText() != null && textField.getText().length() > 2)
		{
			artistLookupService.QueryProperty.set(textField.getText());
			artistLookupService.startWorking();
		}

		if(event.getCode() == KeyCode.ENTER)
		{
			//recordingLookupService.updateArtist(controller.get);
			//recordingLookupService.restart();
		}

	}
}
