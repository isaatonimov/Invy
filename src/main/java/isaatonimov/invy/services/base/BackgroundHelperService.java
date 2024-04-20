package isaatonimov.invy.services.base;

public class BackgroundHelperService extends HelperService
{

	@Override
	protected boolean IsBackgroundService()
	{
		return true;
	}

	@Override
	protected Object ServiceSpecificDo()
	{
		return null;
	}

	@Override
	protected boolean ServiceSpecificOnSuccessDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnFailureDo()
	{
		return false;
	}

	@Override
	protected boolean ServiceSpecificOnInterruptionDo()
	{
		return false;
	}

	@Override
	protected boolean ServerSpecificOnRunningDo()
	{
		return false;
	}

	@Override
	protected void ServiceSpecificOnValuePropertyChanged()
	{

	}
}
