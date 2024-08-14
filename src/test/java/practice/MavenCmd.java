package practice;

import org.testng.annotations.Test;

public class MavenCmd 
	{
	@Test
	public void read()
	{
		String UN = System.getProperty("UserName");
		System.out.println(UN);
		
		String PWD = System.getProperty("Password");
		System.out.println(PWD);
	}
	}
