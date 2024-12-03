package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;
import ECommerce_Source.YourOrdersPage;

public class TestCase14  extends Browser_Launch_Quit 
{

	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void WriteReviews() throws EncryptedDocumentException, IOException, InterruptedException
	{
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		// ----------------- Launch amazon, Hover ovr Ac and List,  Click On Sign In ----------
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		// ----------------- Login  
		SignIn_EmailPage Sng_Eml = new SignIn_EmailPage(driver);
		Sng_Eml.UserName_Ymn();
		Sng_Eml.Continue_Click();
		SignIn_PasswordPage Sng_PW = new SignIn_PasswordPage(driver);
		Sng_PW.Enter_Password_Ymn();
		Sng_PW.SignIn_Submit();
		
		// ----------------- Hover ovr Ac and List,  Click On Your Order---------
		hmPg.acAndList(driver);
		hmPg.yourOrder_Click();
		
		// ------- apply filter - select option "2024" from dropdown -----------------
		YourOrdersPage ordrPg = new YourOrdersPage(driver);
		ordrPg.Select_Time_Filter();	
		
		// -------------- Click on "Write prod review btn for 1st Prod (i.e. Last ordered) -- 
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOf(ordrPg.Wrt_Prod_Review_btn));
		ordrPg.Wrt_Prod_review();
		
		//-------------- Clear already given ratings -------- click on 5th Star - 
		Thread.sleep(2000);
		if(ordrPg.clear_Review_Btn.isDisplayed())
		{
			ordrPg.Clear_Review();
		}
		ordrPg.Apply_fiveStar();
		// ----------------- check if "Submitted" alert displayed -----------
		Assert.assertEquals(ordrPg.Review_Submission_Alert.isDisplayed(), true);
		
	}
}
