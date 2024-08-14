package practice;

import java.io.IOException;

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

public class Scenario5withDDT 
{
	public static void main(String[] args) throws IOException 
	{
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
			//Login to Application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			//Navigate to Organization
			driver.findElement(By.partialLinkText("Organizations")).click();
			//Click on create organization. lookup image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			//Create organization with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			//save
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			//validate
			String Header = driver.findElement(By.className("dvHeaderText")).getText();
			if(Header.contains(ORGNAME))
			{
				System.out.println(ORGNAME);
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			//Navigate to contact list
			driver.findElement(By.partialLinkText("Contacts")).click();
			//Click on create contact lookup image
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			//Create contact with mandatory fields
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			//Click on create organization lookup image
			driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			//Switch the control to child window
			wUtil.switchTowindow(driver, "Accounts");
			//Search the organization name
			driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
			/**
			 * Or we can do like this
			 * driver.findElement(By.linkText(ORGNAME)).click();
			 */
			//Switch the control to parent window
			wUtil.switchTowindow(driver, "Contacts");
			//save
			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			//Validate
			String Cheader = driver.findElement(By.className("dvHeaderText")).getText();
			if(Cheader.contains(LASTNAME))
			{
				System.out.println(Cheader);
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			//Logout
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, ele);
			driver.findElement(By.partialLinkText("Sign Out")).click();			
			System.out.println("Logout is successfull");
}}
