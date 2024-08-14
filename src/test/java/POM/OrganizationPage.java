package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createOrgLookupImg;

public OrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrgLookupImg() {
	return createOrgLookupImg;
}
public void ClickOnCreateOrgLookUpImg()
{
	createOrgLookupImg.click();
}

}
