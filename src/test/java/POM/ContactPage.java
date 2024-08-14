package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	//Declaration
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement CreateContactLookUpImage;
		
		//Initialization
		public ContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public WebElement getCreateContactLookUpImage() {
			return CreateContactLookUpImage;
		}
		
		//Business library
		/**
		 * This method will click on create contact look up image (/**--enter it will create comment)
		 */
		public void clickOnCreateContactLookUpImage()
		{
			CreateContactLookUpImage.click();
		}
		

}
