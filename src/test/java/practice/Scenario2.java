package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch Browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//Login to application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
		//Navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
		//Click on create organization lookup image
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//Create organization with mandatory field
				driver.findElement(By.name("accountname")).sendKeys("infosys");
		//Save
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//Validate or verify
				String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (Header.contains("infosys"))
				{
					System.out.println(Header);
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
		//Logout
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				WebElement ele = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
				action.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
	}

}
