package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import POM.ContactInfoPage;
import POM.ContactPage;
import POM.CreateNewContactPage;
import POM.CreateNeworganizationPage;
import POM.HomePage;
import POM.OrganizationInfoPage;
import POM.OrganizationPage;

public class CreateContactWithOrgForBaseClass extends BaseClass
	{
	@Test(groups = "RegressionSuite")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException
	{
	//Test Data file
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.Rnum();
	//Navigate to Org link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
	//Click on org.lookup img
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnCreateOrgLookUpImg();
	//Create New Org
		CreateNeworganizationPage cnop = new CreateNeworganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
	//Validate for Org
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(ORGNAME);
			System.out.println(orgHeader);
			System.out.println("Org. created");
	//Navigate to Contact link
		hp.clickOnContactsLink();
	//Click on Create contact look up img
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImage();
	//Create contact with org
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(driver, ORGNAME, LASTNAME);
	//Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
			System.out.println(contactHeader);
			System.out.println("pass");
		}
	}
