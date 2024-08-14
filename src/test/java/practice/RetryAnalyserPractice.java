package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
	{
	@Test (retryAnalyzer = GenericUtilities.RetryAnalyserImplentation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Hi");
	}
	public void sample1()
	{
		System.out.println("Hello");
	}
	}
