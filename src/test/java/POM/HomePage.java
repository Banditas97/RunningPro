package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration - webelements - dropdown , windows, alerts , frames etc..
		@FindBy(linkText="Organizations")
		private WebElement orgLink;
		
		@FindBy(linkText="Contacts")
		private WebElement contactLink;
		
		@FindBy(linkText="Products")
		private WebElement ProductLink;

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdminImg;

		@FindBy(linkText="Sign Out")
		private WebElement logoutLink;
		
	//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Utilization
		public WebElement getOrgLink() {
			return orgLink;
		}

		public WebElement getContactLink() {
			return contactLink;
		}

		public WebElement getProductLink() {
			return ProductLink;
		}

		public WebElement getAdminImg() {
			return AdminImg;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}
	//Business Library
	//This method will click on organization link
		public void clickOnOrgLink()
		{
			orgLink.click();
		}
	//This method will click on contacts link
		public void clickOnContactsLink()
		{
			contactLink.click();
		}
	//This method will click on Sign out link
		public void logoutOfApp(WebDriver driver) throws InterruptedException
		{
			mouseHoverAction(driver, AdminImg);
			Thread.sleep(2000);
			logoutLink.click();
		}
}
