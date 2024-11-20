package ECommerce_TestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryLogic implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result) 
	{
		int InitialCount = 1;
		int RetryCount = 2;
		if(InitialCount<RetryCount)
		{
			InitialCount++;
			return true;
		}
		return false;
	}

}
