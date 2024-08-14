package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNeworganizationPage extends WebDriverUtility
{
	@FindBy(name = "accountname")
	private WebElement OrgNameedt;
	@FindBy(name = "industry")
	private WebElement IndustryDropdown;
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public CreateNeworganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameedt() {
		return OrgNameedt;
	}

	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * This method will create org with mandatory field.
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME)
	{
		OrgNameedt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * This method will create org with industry drop down.
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrg(String ORGNAME , String INDUSTRYNAME)
	{
		OrgNameedt.sendKeys(ORGNAME);
		handelDropdown(IndustryDropdown, INDUSTRYNAME);
		saveBtn.click();
		
	}
	
}
