package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

// Login With Valid Data
public class TestCase02 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void SignIn() throws EncryptedDocumentException, IOException
	{
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();
		
		Assert.assertEquals(HomePage.SearchBox_Elmnt.isDisplayed(), true);
		Reporter.log("Logged In Successfully");
	}
}
