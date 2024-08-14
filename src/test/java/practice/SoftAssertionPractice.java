package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionPractice 
	{
	@Test
	public void practice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		sa.assertEquals(false, true);
		
		System.out.println("Step 3");
		sa.assertAll();
	}
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		sa.assertEquals(1, 2);
		sa.assertAll();
		System.out.println("Step 2");
		System.out.println("Step 3");
	}
}
