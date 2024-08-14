package practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import POM.LoginPage;

public class Scenario1WithDDTAndGenericUtilities {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
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
				//lp.getUserNameEdit().sendKeys(USERNAME);
				//lp.getPasswordEdit().sendKeys(PASSWORD);
				lp.loginToApp(USERNAME , PASSWORD);
				lp.getLoginbtn().click();
//				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
				//Navigate to contact link
				driver.findElement(By.linkText("Contacts")).click();
				//Click on create contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//Create contact with mandatory field
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				//Save
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				//validate
				String CH = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (CH.contains(LASTNAME))
				{
					System.out.println(CH);
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				//Logout
				Thread.sleep(5000);
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.partialLinkText("Sign Out")).click();
				System.out.println("Logout is successfull");
	}

}
