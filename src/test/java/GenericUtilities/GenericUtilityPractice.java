package GenericUtilities;

import java.io.IOException;

public class GenericUtilityPractice 
{

	public static void main(String[] args) throws IOException 
	{
		//test script
//		PropertyFileUtility Pfu = new PropertyFileUtility();
//		String value = Pfu.readDataFromPropertyFile("browser");
//		String value1 = Pfu.readDataFromPropertyFile("url");
//		String value2 = Pfu.readDataFromPropertyFile("username");
//		String value3 = Pfu.readDataFromPropertyFile("password");
//		System.out.println(value);
//		System.out.println(value1);
//		System.out.println(value2);
//		System.out.println(value3);
		
		JavaUtility j = new JavaUtility();
		String date = j.currentDateAndTime();
		System.out.println(date);
		
		int rnumber = j.Rnum();
		System.out.println(rnumber);
		
		ExcelFileUtility ef = new ExcelFileUtility();
		String oname = ef.readDataFromExcel("Organization", 1, 2);
		System.out.println(oname);
		System.out.println(oname + rnumber);
		//or
		String ranwithOrg = oname + rnumber;
		System.out.println(ranwithOrg);
		
	}

}
