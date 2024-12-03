package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.CheckOut_Page;
import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.ProductPage;
import ECommerce_Source.Product_ListPage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;


// Validate the entire checkout process, including address selection, payment method selection, and order review.

public class TestCase11 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=false)
	public void CheckOutProcess_NetBanking_Method() throws EncryptedDocumentException, IOException
	{
		// login
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		dtCl.SerachProduct();
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();		
		// Search and select product - and click buy now
		hmPg.searchProd_pen();
		Product_ListPage prod_list = new Product_ListPage(driver);
		prod_list.select_1st_Prod();
		
		Set<String> prodList = driver.getWindowHandles();
		Iterator<String> i1 = prodList.iterator();
		String P_ID = i1.next();
		String C_ID = i1.next();
		driver.switchTo().window(C_ID);
		
		ProductPage prodPg= new ProductPage(driver);
		prodPg.Buy_Now_Click();
		// change address - select other address
		CheckOut_Page chkOutPg= new CheckOut_Page(driver);
		
		if(chkOutPg.change_Addr_Elmnt.isDisplayed())
		{
			chkOutPg.changeAddress();
			chkOutPg.selectAddress();
		}
//		if(chkOutPg.dlvrThisAddr_Btn_Elmnt.isDisplayed())
//		{
//			chkOutPg.DlvrToThisAddress();
//		}
		
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOf(chkOutPg.dlvrThisAddr_Btn_Elmnt));
		chkOutPg.DlvrToThisAddress();
			
		// select payment method
//		if(chkOutPg.change_paymentMode_Elmnt.isDisplayed()==true)
//		{
//			chkOutPg.changePaymentMode();
//		}
		// select - NetBanking mode ----
		chkOutPg.PayMentMode_NetBanking();
		chkOutPg.SelectBank_NetBanking();
		chkOutPg.useThisPayment();
//		WebElement e1 = driver.findElement(By.xpath("//input[@id='spc-gcpromoinput']"));
//		e1.sendKeys("12345"+Keys.ENTER);
		chkOutPg.dismiss_PrimeMsg();
		// Make Payment 
		// check product review
		Assert.assertEquals(chkOutPg.Review_items.isDisplayed(), true);
	}
	
	@Test(enabled=true)
	public void CheckOutProcess_CashOnDelivery_Method() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// ----------------- login
		DDT_Class dtCl = new DDT_Class();
		dtCl.UserName();
		dtCl.SerachProduct();
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();		
		// Search and select product - and click buy now
		hmPg.searchProd_pen();
		Product_ListPage prod_list = new Product_ListPage(driver);
		prod_list.select_1st_Prod();
		
		Set<String> prodList = driver.getWindowHandles();
		Iterator<String> i1 = prodList.iterator();
		String P_ID = i1.next();
		String C_ID = i1.next();
		driver.switchTo().window(C_ID);
		
		ProductPage prodPg= new ProductPage(driver);
		prodPg.Buy_Now_Click();
		// ---------------- change address - select other address
		CheckOut_Page chkOutPg= new CheckOut_Page(driver);
		
		if(chkOutPg.change_Addr_Elmnt.isDisplayed())
		{
			chkOutPg.changeAddress();
			try
			{
				chkOutPg.selectAddress();
				WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				w1.until(ExpectedConditions.visibilityOf(chkOutPg.Use_This_Address_btn));
				chkOutPg.UseThisAddress();
			}
			catch(NoSuchElementException ex)
			{
				System.out.println("NoSuchElementException ----------- handled");
				WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				w1.until(ExpectedConditions.visibilityOf(chkOutPg.dlvrThisAddr_Btn_Elmnt));
				chkOutPg.DlvrToThisAddress();
			}
			
		}
		else
		{
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w1.until(ExpectedConditions.visibilityOf(chkOutPg.dlvrThisAddr_Btn_Elmnt));
			chkOutPg.DlvrToThisAddress();
		}

		// -------------------- change Payment method 
		try {
			if(chkOutPg.change_paymentMode_Elmnt.isDisplayed())
			{
				chkOutPg.changePaymentMode();
			}
		} 
		catch(ElementClickInterceptedException es)
		{
			// select - cash on delivery mode ---- click on Use THis Payment btn
			WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w2.until(ExpectedConditions.visibilityOf(chkOutPg.anothr_Pyment_method));
				if(chkOutPg.cashOnDlvry_Elmnt.isDisplayed() && chkOutPg.cashOnDlvry_Elmnt.isEnabled() )
				{
					chkOutPg.CashOnDelivery();
				}
				else
				{
					System.out.println("Cash On Delivery is not available for this product.Selecting UPI method....");
					chkOutPg.OtherUPIApps_Payment();
				}
		}
		
		chkOutPg.useThisPayment();

		//  ------------------ check product review block is displayed ---
		Assert.assertEquals(chkOutPg.Review_items.isDisplayed(), true);
	}
	

}
