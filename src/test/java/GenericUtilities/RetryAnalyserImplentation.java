package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is a Implementation class for IRetryAnalyser interface of testNG.
 */

public class RetryAnalyserImplentation implements IRetryAnalyzer
	{
	int count = 0;
	int retrycount = 3;
	@Override
	public boolean retry(ITestResult result)
	{
		// TODO Auto-generated method stub
		// 0<3 , 1<3 , 2<3 
		while(count<retrycount)
		{
			count++; // 1 , 2 , 3
			return true; // Retrying Retrying Retrying
		}
		return false; // Stop retrying
	}
	
	}
