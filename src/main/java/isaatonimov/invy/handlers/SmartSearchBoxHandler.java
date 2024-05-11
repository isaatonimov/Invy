package isaatonimov.invy.handlers;

import isaatonimov.invy.controllers.Controller;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.MusicMetadata;
import isaatonimov.invy.models.musicbrainz.Recording;
import isaatonimov.invy.models.musicbrainz.Release;
import isaatonimov.invy.services.background.AlbumMetaLookupService;
import isaatonimov.invy.services.background.ArtistMetaLookupService;
import isaatonimov.invy.services.background.SongMetaLookupService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

public class SmartSearchBoxHandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>
{
	private ArtistMetaLookupService 		artistMetaLookupService;
	private SongMetaLookupService   	songMetaLookupService;
	private AlbumMetaLookupService 		albumMetaLookupService;
	private TextField 				textField;
	private ListView					recommendationsView;
	private ObservableList<MusicMetadata> 	suggestionList;
	private ObservableList<String>		messagesList = FXCollections.observableArrayList(Arrays.asList("No Results found..."));
	private Controller 				controller;

	public SmartSearchBoxHandler(Controller controller)
	{
		this.controller 			= controller;
		this.recommendationsView 	= controller.RecommendationsProperty.get();
		this.textField 			= controller.SearchFieldProperty.get();
		this.artistMetaLookupService = controller.ArtistMetaLookupServiceProperty.get();
		this.albumMetaLookupService = controller.AlbumMetaLookupService.get();
		this.songMetaLookupService = controller.SongMetaLookupServiceProperty.get();


		artistMetaLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			if(artistMetaLookupService.ResultValueProperty.get() != null)
				suggestionList = FXCollections.observableArrayList((List<Artist>) artistMetaLookupService.ResultValueProperty.get());

			updateSuggestionBox();
		});

		albumMetaLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			if(albumMetaLookupService.ResultValueProperty.get() != null)
				suggestionList = FXCollections.observableArrayList((List<Release>) albumMetaLookupService.ResultValueProperty.get());

			updateSuggestionBox();
		});

		songMetaLookupService.ResultValueProperty.addListener((observable, oldValue, newValue) ->
		{
			if(songMetaLookupService.ResultValueProperty.get() != null)
				suggestionList = FXCollections.observableArrayList((List<Recording>) songMetaLookupService.ResultValueProperty.get());

			updateSuggestionBox();
		});
	}

	private void updateSuggestionBox()
	{
		Platform.runLater(() ->
		{
			recommendationsView.setItems(messagesList);
			controller.ShowRecommendationMessage();

			controller.SearchProgressIndicatorProperty.get().setVisible(false);

			if(suggestionList.size() > 0)
			{
				recommendationsView.setItems(suggestionList);
				controller.ShowRecommendations();

				controller.SearchProgressIndicatorProperty.get().setVisible(false);
			}
			else
				controller.HideRecommendations();
		});
	}

	@Override
	public void handle(KeyEvent event)
	{
		if(textField == null)
			textField = controller.SearchFieldProperty.get();

		if(textField.getText() != null && textField.getText().length() == 0)
		{
			controller.HideRecommendations();
		}


		if(event.getCode() == KeyCode.TAB)
		{
			controller.SwitchToNextSearchCategory();
		}

		if(event.getCode() == KeyCode.ESCAPE)
			controller.HideSearchBar();

		Search();
	}

	private void Search()
	{
		if(textField.getText() != null && textField.getText().length() > 2)
		{
			switch (controller.GetCurrentSearchCategory())
			{
				case ARTIST -> {
					controller.SearchProgressIndicatorProperty.get().setVisible(true);
					artistMetaLookupService.QueryProperty.set(textField.getText());
					artistMetaLookupService.startWorking();;
				}

				case SONG -> {
					controller.SearchProgressIndicatorProperty.get().setVisible(true);
					songMetaLookupService.QueryProperty.set(textField.getText());
					songMetaLookupService.startWorking();;
				}

				case ALBUM -> {
					controller.SearchProgressIndicatorProperty.get().setVisible(true);
					albumMetaLookupService.QueryProperty.set(textField.getText());
					albumMetaLookupService.startWorking();;
				}
			}
		}
	}
}
