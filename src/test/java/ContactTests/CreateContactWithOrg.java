package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import POM.CreateNeworganizationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInfoPage;
import POM.OrganizationPage;

public class CreateContactWithOrg 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
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
			String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
			String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.Rnum();
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
		//Login
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
		//Navigate to Org link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
		//Click on org.lookup img
			OrganizationPage op = new OrganizationPage(driver);
			op.ClickOnCreateOrgLookUpImg();
		//Create New Org
			CreateNeworganizationPage cnop = new CreateNeworganizationPage(driver);
			cnop.createNewOrg(ORGNAME);
		//Validate for Org
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String orgHeader = oip.getOrgHeader();
			if(orgHeader.contains(ORGNAME))
			{
				System.out.println(ORGNAME);
				System.out.println(orgHeader);
				System.out.println("Org. created");
			}
		//Navigate to Contact link
			hp.clickOnContactsLink();
		//Click on Create contact look up img
			ContactPage cp = new ContactPage(driver);
			cp.clickOnCreateContactLookUpImage();
		//Create contact with org
			CreateNewContactPage cncp = new CreateNewContactPage(driver);
			cncp.CreateNewContact(driver, ORGNAME, LASTNAME);
		//Validate
			ContactInfoPage cip = new ContactInfoPage(driver);
			String contactHeader = cip.getContactHeader();
			if(contactHeader.contains(LASTNAME))
			{
				System.out.println(contactHeader);
				System.out.println("pass");
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
