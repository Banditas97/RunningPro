package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderText;
	//Initialization
	public ContactInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	
	}
	//Utilization
	public WebElement getContactHeaderText() 
	{
		return contactHeaderText;
	}
	//Business Library
	public String getContactHeader()
	{
		return contactHeaderText.getText();	
	}

	}
