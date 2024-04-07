package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.musicbrainz.MusicBrainzHelper;
import isaatonimov.invy.models.musicbrainz.Artist;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class RecordingLookupService extends LookupService<LinkedList<Recording>>
{
	private SimpleStringProperty 	searchTerm 	= new SimpleStringProperty		(this, "searchTerm");
	private SimpleListProperty<String> recordsToSeach = new SimpleListProperty<String>	(this, "recordsToSearch");

	public RecordingLookupService()
	{
	}

	public void SetTextFieldToBind(TextField searchField)
	{
		searchField.textProperty().bindBidirectional(searchTerm);
	}

	@Override
	protected Task createTask()
	{
		return new Task()
		{
			@Override
			protected LinkedList<Recording> call() throws Exception
			{
				System.out.println("Recording Lookup Service Starting....");

				LinkedList<Recording> recordings = new LinkedList<>();
				LinkedList<Artist> 	artists = MusicBrainzHelper.searchForArtis(searchTerm.get());

				for(var artist : artists)
				{
					recordings.addAll(MusicBrainzHelper.searchForSongs(artist));
				}

				for(var record : recordings)
					System.out.println("Titles looked up: " + record.getTitle());

				return recordings;
			}
		};
	}
}
