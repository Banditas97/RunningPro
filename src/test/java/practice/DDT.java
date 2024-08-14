package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DDT {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Read all the required data(common data file)
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(file);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");	
		
		//Test Data file
		FileInputStream file1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook ws = WorkbookFactory.create(file1);
		String LASTNAME = ws.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		String ORG = ws.getSheet("Contacts").getRow(4).getCell(3).getStringCellValue();
		
		WebDriver driver = null;
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		//Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
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
		Actions action =new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		System.out.println("Logout is successfull");
}
}