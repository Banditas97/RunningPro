package POMPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginnPage 
	{
	@FindBy(name = "user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEdit;
	
	@FindBy(id="submitButton")
	private WebElement submitBUttonEdit;
	
	public LoginnPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getUserpasswordEdit() {
		return userpasswordEdit;
	}

	public WebElement getSubmitBUttonEdit() {
		return submitBUttonEdit;
	}
	
	public void LoginToApplication(String USERNAME, String PASSWORD)
	{
		usernameEdit.sendKeys(USERNAME);
		userpasswordEdit.sendKeys(PASSWORD);
		submitBUttonEdit.click();
	}
	}
