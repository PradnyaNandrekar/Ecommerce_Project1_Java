package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

//Login With In_Valid Data
public class TestCase03 extends Browser_Launch_Quit
{
	@Test
	public void SignIn_Invalid_UN() throws EncryptedDocumentException, IOException
	{
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
	/*	// Check with Wrong UserName
		SnInPg.InValid_UserName();
		SnInPg.Continue_Click();
		// Assert true if Login Fails after wrong UserName and display error msg coming on page
		Reporter.log(SignIn_EmailPage.Error_MsgBox_Elmnt.getText());	
		Assert.assertEquals(SignIn_EmailPage.UserName_Elmnt.isDisplayed(), true); 
	*/
		// Check with Correct UserName and Wrong Password
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Invalid_Password();
		SnInPw.SignIn_Submit();
		// Assert true if Login Fails after Correct UserName but wrong password and display error msg coming on page
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
		Assert.assertEquals(SnInPw.Password_Elmnt.isDisplayed(), true);
		
	}
}
