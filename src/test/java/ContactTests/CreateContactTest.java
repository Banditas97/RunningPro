package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import POM.ContactInfoPage;
import POM.ContactPage;
import POM.CreateNewContactPage;
import POM.HomePage;

@Listeners(GenericUtilities.ListenersImplimentation.class)
public class CreateContactTest extends BaseClass
{
	@Test (priority =1) //(groups={"SmokeSuite" , "RegressionSuite"})//groups is only used for group execution
	public void createContact() throws EncryptedDocumentException, IOException
	{
	//Test Data file
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
	//Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
	//Click on create contact look up image
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImage();
	//create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
	//Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("Pass");
		}
		else {
			System.out.println("fail");
		}
	}
	@Test(priority =2)
	public void demo()
	{
		Assert.fail();
		System.out.println("jiji");
	}
}
