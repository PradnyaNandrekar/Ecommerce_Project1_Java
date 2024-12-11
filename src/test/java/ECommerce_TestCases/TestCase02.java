package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

// Login With Valid Data
public class TestCase02 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void SignIn() throws EncryptedDocumentException, IOException
	{
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		// ----------------- Launch amazon, Hover ovr Ac and List,  Click On Sign In ----------
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		// ----------------- Enter Correct UN and PW ----------
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();
		// ----------- Check if Search Text box is displayed or not -------------
		Assert.assertEquals(HomePage.SearchBox_Elmnt.isDisplayed(), true, "TestCase 02 - Failed");
		Reporter.log("Logged In Successfully");
	}
}
