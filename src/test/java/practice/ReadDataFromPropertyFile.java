package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile 
{
	public static void main(String[] args) throws IOException 
	{
	//Open the doc. in java readable format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	//Create an object properties class from java.util
	Properties p = new Properties();
	//Load the input stream into properties
	p.load(fis);
	//Provide the keys to read the values
	String value = p.getProperty("username");
	System.out.println(value);
}
}