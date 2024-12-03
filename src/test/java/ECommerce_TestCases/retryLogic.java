package ECommerce_TestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryLogic implements IRetryAnalyzer
{
	int InitialCount = 0;
	int RetryCount = 1;

	@Override
	public boolean retry(ITestResult result) 
	{

		if(InitialCount<RetryCount)
		{
			InitialCount++;
			return true;
		}
		return false;
	}

}
