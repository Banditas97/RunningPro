package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement OrgHeaderText;

public OrganizationInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrgHeaderText() {
	return OrgHeaderText;
}

/**
 * This method will capture the header text and return into caller
 * @return
 */
public String getOrgHeader()
{
	return OrgHeaderText.getText();
}

}
