package ContactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import POM.ContactInfoPage;
import POM.ContactPage;
import POM.CreateNewContactPage;
import POM.HomePage;
import POM.LoginPage;

public class CreateContact 
{
	public static void main(String[] args) throws IOException, InterruptedException 
		{	
		//Create object of all utilities
		ExcelFileUtility eUtil= new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;
		//Read all the required data(common data file)
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");		
		//Test Data file
			String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		//Launch the Browser
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if (BROWSER.equalsIgnoreCase("Edge"))
			{
				driver = new EdgeDriver();
			}
			else {
				System.out.println("Invalid browser");
			}
			wUtil.maxWindow(driver);
			wUtil.waitForPageLoad(driver);
			driver.get(URL);
		//Login to Application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
		//Navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactsLink();
		//Click on create contact look up image
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactLookUpImage();
		//create new contact
			CreateNewContactPage cncp = new CreateNewContactPage(driver);
			cncp.CreateNewContact(LASTNAME);
		//Validate
			ContactInfoPage cip = new ContactInfoPage(driver);
			String contactHeader = cip.getContactHeader();
			if (contactHeader.contains(LASTNAME))
			{
				System.out.println(contactHeader);
				System.out.println("Pass");
			}
			else {
				System.out.println("fail");
			}
		//Logout
			hp.logoutOfApp(driver);
		//Close the browser
			driver.quit();
		}
}
