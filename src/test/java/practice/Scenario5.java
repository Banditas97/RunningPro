package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 
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
			//Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();
			//Click on Create contact look Up Image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			//Create Contact with Mandatory fields
				driver.findElement(By.name("lastname")).sendKeys("swain");	
			//Select the Organization from organization lookup image
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				String Parent = driver.getWindowHandle();
				//System.out.println(Parent);
				Set<String> All = driver.getWindowHandles();
				for(String Wid:All)
				{
					driver.switchTo().window(Wid);
					System.out.println(Wid);
					String url = driver.getCurrentUrl();
					System.out.println(url);
					if(url.contains("Accounts"))
					{
						break;
					}
				}
				driver.findElement(By.xpath("//a[.='Wipro']")).click();
				driver.switchTo().window(Parent);
				//Save
				driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
				//Verify or Validate
				String CName = driver.findElement(By.className("dvHeaderText")).getText();
				System.out.println(CName);
				if (CName.contains("swain"))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				//Logout
				Thread.sleep(2000);
				Actions act = new Actions(driver);
				WebElement ele = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
				act.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
	}

}
