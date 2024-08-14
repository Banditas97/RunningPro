package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsPractice
	{
	@Test
	public void practice()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(1, 1);
		Assert.assertEquals(1, 2);
		System.out.println("Step 3");
	}
	@Test
	public void practice1()
	{
		String a = "abc";
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertTrue(a.contains("d"));
		System.out.println("Step 3");
	}
	}
