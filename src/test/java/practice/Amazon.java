package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Amazon 
{

	public static void main(String[] args) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String Price = driver.findElement(By.xpath("(//span[.='50,499'])[1]")).getText();
		System.out.println(Price);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\test\\resources\\Image/error1.png");
		FileHandler.copy(temp, dest);
		File temp1 = driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\test\\resources\\Image/error2.png");
		FileHandler.copy(temp1, dest1);
		driver.findElement(By.xpath("(//span[.='50,499'])[1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		String mainID = driver.getWindowHandle();
		System.out.println("main window Id is "+mainID);
		
		for(String win: windows)
		{
			if(!win.equals(mainID))
			{
				System.out.println("This is the child ID - "+win);
				driver.switchTo().window(win);
				break;
			}
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		
		driver.findElement(By.id("attach-accessory-proceed-to-checkout-text")).click();
		}}
