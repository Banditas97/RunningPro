package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandelcalenderForAnyDateinDOM
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.makemytrip.com/");
		Actions act = new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		Thread.sleep(2000);
		act.moveByOffset(10, 20).click().perform();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		while(true)
		{
			try
			{
				driver.findElement(By.xpath("//div[.='December 2023']/..//p[.='1']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.findElement(By.xpath("//button[.='OKAY, GOT IT!']")).click();
		driver.findElement(By.xpath("(//span[@class='customArrow arrowDown'])[1]")).click();
		driver.findElement(By.xpath("(//button[.='Book Now'])[1]")).click();
	}

}
