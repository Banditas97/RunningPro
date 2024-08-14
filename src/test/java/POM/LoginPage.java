package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1 :- creating separate POM Class
public class LoginPage 
{
	//Rule 2 :- Declaration
		@FindBy(name = "user_name")
		private WebElement userNameEdit;
		@FindBy(name = "user_password")
		private WebElement passwordEdit;
		@FindBy(id = "submitButton")
		private WebElement loginbtn;

	//Rule 3:- Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
	//Rule 4:- Utilization

		public WebElement getUserNameEdit() {
			return userNameEdit;
		}

		public WebElement getPasswordEdit() {
			return passwordEdit;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
	//Rule 5:- Utilization of Business Library
	//Business Library :->Generic method using the web elements in current POM class.
		/**
		 * This method will login to application.
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginToApp(String USERNAME , String PASSWORD)
		{
			userNameEdit.sendKeys(USERNAME);
			passwordEdit.sendKeys(PASSWORD);
			loginbtn.click();
		}
		
}
