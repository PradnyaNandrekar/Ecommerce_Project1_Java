package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.LoginAndSecurity_Page;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;
import ECommerce_Source.yourAccount_Page;

//Check if a user can successfully edit their profile information.

public class TestCase04  extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void Edit_info_from_LoginSecurity() throws EncryptedDocumentException, IOException
	{
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
	
		//----------------- hover over ac and list
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		// -----------------click on Your account and select Login and security
		hmPg.yourAccount_Click();
		yourAccount_Page UrAc= new yourAccount_Page(driver);
		UrAc.Login_Security();
		//----------------- Login ------
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();
		//----------------- edit name --------------
		LoginAndSecurity_Page l_Security = new LoginAndSecurity_Page(driver);
		l_Security.EditBtn_Name();
		l_Security.Enter_Name();
		
		String NameEditSuccess = l_Security.successAlert.getText();
		Assert.assertEquals(NameEditSuccess.contains("Name updated"), true);
		
		// -------- Click on Edit Password -  
		l_Security.EditBtn_Password();
		// Enter Old Password
		l_Security.Enter_Old_Password();
		// Enter New Password
		l_Security.Enter_New_Password();
		// ReEnter new password
		l_Security.Re_Enter_New_Password();
		// Click on save changes
		l_Security.SaveChanges();
		// check if "Password updated" alert message displayed
		//----------------- edit Password
		String PasswordEditSuccess = l_Security.successAlert.getText();
		Assert.assertEquals(PasswordEditSuccess.contains("Password updated"), true);
		
	}
	
}
