package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario4
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
				driver.findElement(By.name("accountname")).sendKeys("Wipro");
				//Select "Chemicals" in the industry drop down
				WebElement ele = driver.findElement(By.name("industry"));
				Select dropdown = new Select(ele);
				dropdown.selectByValue("Energy");
				//Select "Customer" in the Type drop down
				WebElement Type = driver.findElement(By.name("accounttype"));
				Select dropdown2 = new Select(Type);
				dropdown2.selectByValue("Customer");
				//Save
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				//Validate or Verify
				String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (Header.contains("Wipro"))
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
				WebElement ele1 = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
				action.moveToElement(ele1).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();
			}
	}


