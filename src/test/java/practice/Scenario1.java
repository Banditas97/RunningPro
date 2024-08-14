package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario1 
{
	public static void main(String[] args) throws InterruptedException 
	{
	//Launch Browser
		//Not mandatory (WebDriverManager.chromedriver().setup();)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	//Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
	//Click on Create contact look Up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//Create Contact with Mandatory fields
		WebElement dp = driver.findElement(By.name("salutationtype"));
		Select list=new Select(dp);
		list.selectByValue("Ms.");
		driver.findElement(By.name("firstname")).sendKeys("Bandita");
		driver.findElement(By.name("lastname")).sendKeys("swain");
	//save
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	//verify
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains("Bandita"))
		{
			System.out.println("successfully done");
		}
		else
		{
			System.out.println("someting error occurs");
		}
	//logout of Application
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
