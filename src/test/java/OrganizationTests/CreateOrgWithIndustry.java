package OrganizationTests;

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
import POM.CreateNeworganizationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInfoPage;
import POM.OrganizationPage;

public class CreateOrgWithIndustry 
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
		String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.Rnum();
		String INDUSTRYNAME = eUtil.readDataFromExcel("Organization", 4, 3);
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
		System.out.println(ORGNAME);
		System.out.println(INDUSTRYNAME);
	//Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	//Navigate to Org Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
	//Click On Create org. lookup img
		OrganizationPage op=new OrganizationPage(driver);
		op.ClickOnCreateOrgLookUpImg();
	//Create new Org with industry
		CreateNeworganizationPage cnop = new CreateNeworganizationPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRYNAME);
	//Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		if (OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	//Logout
		hp.logoutOfApp(driver);
	//Close the browser
		driver.quit();
}
}
