package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of all generic methods related to webDriver actions
 * 
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maxWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for 20 second for the web page to get loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	/**
	 * This method will wait for 20 second for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitToBeVisible(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for 20 second for the element to be Clickable.
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handel dropdown by index
	 * @param element
	 * @param index
	 */
	public void handelDropdown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handel dropdown by value
	 * @param element
	 * @param value
	 */
	public void handelDropdown(WebElement element , String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);		
	}
	/**
	 * This method will handel dropdown by visibletext
	 * @param element
	 * @param value1
	 */
	public void handelDropdown(String text,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hover action in the selected element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform doble click action in the selected element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform right click action in the selected element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will drag and drop the source element to target element
	 * @param driver
	 * @param srcEle
	 * @param destEle
	 */
	public void dragAndDrop(WebDriver driver , WebElement srcEle , WebElement destEle )
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, destEle).perform();
	}
	/**
	 * This method will click and hold on a perticular element.
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();	
	}
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll up for 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500)", "");
	}
	/**
	 * This method will scroll right for 500 units
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(500,0)", "");
	}
	/**
	 * This method will scroll left for 500 units
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(-500,0)", "");
	}
	/**
	 * This method will accept the alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert pop-up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture the alert text and return to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchtoframe(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame based on name or Id
	 * @param driver
	 * @param nameOrID
	 */
	public void switchtoframe(WebDriver driver , String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method will switch to frame based on WebElement
	 * @param driver
	 * @param element
	 */
	public void switchtoframe(WebDriver driver , WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch the windows based on partial Window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchTowindow(WebDriver driver , String partialWinTitle)
	{
		//Step 1 : capture all the window ids
		Set<String> allWindowIds = driver.getWindowHandles(); // main , all child
		//Step 2 : Navigate to each window id
		for(String windowId:allWindowIds)
		{
		//Step 3 : Switch to each window & capture the Title
			String actualTitle = driver.switchTo().window(windowId).getTitle();
		//Step 4 : Compare the actual title with expected partial window title
			if(actualTitle.contains(partialWinTitle))
			{
			break;
			}
		}
	}
	/**
	 * This method will take SS and store it in required folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
		public String captureScreenshot(WebDriver driver , String screenshotName) throws IOException
		{
		TakesScreenshot	ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath(); // complete path of ss - extent reports
		}	
}





