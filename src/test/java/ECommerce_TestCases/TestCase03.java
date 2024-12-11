package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

//Login With In_Valid Data
public class TestCase03 extends Browser_Launch_Quit
{

	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void SignIn_Invalid_UN() throws EncryptedDocumentException, IOException
	{
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		// ----- Hover Over ac and List , select SingIn
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		// ---- Enter Wrong UserName
		SnInPg.InValid_UserName();
		SnInPg.Continue_Click();

		Reporter.log(SignIn_EmailPage.Error_MsgBox_Elmnt.getText());	
		Assert.assertEquals(SnInPg.UserName_Elmnt.isDisplayed(), true, "TestCase 03 - Failed"); 
		
	}
	
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void SignIn_Invalid_Password() throws EncryptedDocumentException, IOException
	{
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		// ----- Hover Over ac and List , select SingIn
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		// Check with Correct UserName and Wrong Password
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Invalid_Password();
		SnInPw.SignIn_Submit();
		try // if blank pw entered then it will give NoSuchElementException
		{
			if (SnInPw.Password_Elmnt.isDisplayed()) //if wrong pw entered this block will execute
			{
				Reporter.log(SignIn_PasswordPage.Error_MsgBox_Elmnt.getText());	
			}
		}
		catch(NoSuchElementException e1)
		{
			if(SignIn_PasswordPage.PW_MissingAlert_Elmnt.isDisplayed()) //if No pw entered this block will execute
			{
				Reporter.log(SignIn_PasswordPage.PW_MissingAlert_Elmnt.getText());	
			}
		}
		finally
		{
			Assert.assertEquals(SnInPw.Password_Elmnt.isDisplayed(), true, "TestCase 03 - Failed");
		}
		
		
	}
}
