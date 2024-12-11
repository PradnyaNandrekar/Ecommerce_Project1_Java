package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;
import ECommerce_Source.RegistrationPage;

//Test if a new user can successfully register.

public class TestCase01 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void User_Registration_Test() throws EncryptedDocumentException, IOException
	{
		// ------------ Launch amazon -----------
		HomePage hmPg = new HomePage(driver);
		// ------------ Hover over Ac and List,  select Start Here -----------
		hmPg.acAndList(driver);
		hmPg.startHere_Click();
		
		// ------------ Enter UN, Select Cntry Code, Enter Mob No. , Enter PW, and Verify -----------
		RegistrationPage RgPg = new RegistrationPage(driver);
		RgPg.YourName();
		RgPg.CountryCode();
		RgPg.EnterMobNum();
		RgPg.EnterPassword();
		RgPg.Verify_Mob_Click();
		// ---------- Check if alertBox contains "account already exists" text
		if(driver.getTitle().contains("Authentication required"))
		{
			Assert.assertEquals(driver.getTitle().contains("Authentication required"), true, "TestCase 01 - Failed");
		}
		else
		{
			Assert.assertEquals(RgPg.oldUser_Alert.getText().contains("account already exists"), true, "TestCase 01 - Failed");
		}
		
	}
}
