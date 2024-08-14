package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	/**
	 * This class consist of generic methods related to java
	 * @param args
	 */

	public String currentDateAndTime() 
	{
		/**
		 * This method will return the current system date and time in specified format 
		 */
		Date d = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String currentDate = dt.format(d);
		return currentDate;
	}
	/**
	 * This method will return a random number 
	 */
	public int Rnum() 
	{
		Random r = new Random();
		int num = r.nextInt(100);
		return num;
}
}
