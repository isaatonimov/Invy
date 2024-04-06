package isaatonimov.invy.ui.services;

import isaatonimov.invy.core.musicbrainz.MusicBrainzHelper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class RecordingLookupService extends LookupService
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
		List<String> response = null;

		try
		{
			//response = MusicBrainzHelper.searchForSongs();

			MusicBrainzHelper.searchForArtis(searchTerm.get());
		}
		catch (IOException e)
		{
			//Handle -> TODO
			throw new RuntimeException(e);
		}

		List<String> finalResponse = response;
		return new Task()
		{
			@Override
			protected Object call() throws Exception
			{
				return finalResponse;
			}
		};
	}
}
