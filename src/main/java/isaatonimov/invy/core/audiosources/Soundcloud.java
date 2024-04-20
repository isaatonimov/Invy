package isaatonimov.invy.core.audiosources;

import isaatonimov.invy.core.base.AudioStreamSource;
import isaatonimov.invy.models.musicbrainz.Recording;
import javafx.collections.ObservableList;

import java.util.List;

public class Soundcloud extends AudioStreamSource
{

	public Soundcloud() throws Exception
	{
	}

	@Override
	protected boolean ServiceSpecificHasMultipleInstances()
	{
		return false;
	}

	@Override
	protected List<String> ServiceSpecificSearch(Recording record) throws Exception
	{
		return null;
	}

	@Override
	protected List<String> ServiceSpecificSearchByID(String id) throws Exception
	{
		return null;
	}

	@Override
	protected String ServiceSpecificDefaultURL() throws Exception
	{
		return null;
	}

	@Override
	protected ObservableList<String> ServiceSpecificInstanceLookup() throws Exception
	{
		return null;
	}
}
