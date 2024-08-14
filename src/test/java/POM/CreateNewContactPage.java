package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Declaration
		@FindBy(xpath="//input[@name='lastname']")
		private WebElement lastName;
		@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
		private WebElement savebtn;
		@FindBy(xpath="(//img[@title='Select'])[1]")
		private WebElement orgLookUpImg;
		@FindBy(id="search_txt")
		private WebElement OrgsearchEdit;
		@FindBy(name="search")
		private WebElement orgSearchbtn;
	//Initialization
		public CreateNewContactPage(WebDriver driver)
		{      
			PageFactory.initElements(driver, this);
		}
	//Utilization
		public WebElement getLastName() {
			return lastName;
		}
		public WebElement getSavebtn() {
			return savebtn;
		}
		public WebElement getOrgLookUpImg() {
			return orgLookUpImg;
		}
		public WebElement getOrgsearchEdit() {
			return OrgsearchEdit;
		}
		public WebElement getOrgSearchbtn() {
			return orgSearchbtn;
		}
	//Business Library
	//This method will create contact with mandatory field
		public void CreateNewContact(String LASTNAME)
		{
			lastName.sendKeys(LASTNAME);
			savebtn.click();
		}
	//This method will create contact with org name
		/**
		 * This method will create contact by choosing the organization
		 * @param driver
		 * @param ORGNAME
		 * @param LASTNAME
		 * @throws InterruptedException 
		 */
		public void CreateNewContact(WebDriver driver,String ORGNAME, String LASTNAME) throws InterruptedException
		{
			lastName.sendKeys(LASTNAME);
			orgLookUpImg.click();
			switchTowindow(driver, "Accounts");
			OrgsearchEdit.sendKeys(ORGNAME);
			orgSearchbtn.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); // runtime data
			switchTowindow(driver, "Contacts");
			savebtn.click();
		}
}
