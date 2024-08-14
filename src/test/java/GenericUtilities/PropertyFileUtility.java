package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of re-usability method related to property file
 * @author bandi
 * 
 */
	public class PropertyFileUtility 
		{
	/**
	 * This method will read data from property file for the key provided by caller and return the value to the caller
	 * @param Key
	 * @returnvalue
	 * @throws IOException
	 */
		public String readDataFromPropertyFile(String key) throws IOException
			{
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p = new Properties();
				p.load(fis);
				String value = p.getProperty(key);
				return value;
			}
}
