package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
//Validate the entire checkout process, including address selection, 
//payment method selection, and order review.

public class TestCase11_trial extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void CheckOutProcess() throws EncryptedDocumentException, IOException
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
				//  ------------------- Search and select product - and click buy now
				hmPg.searchProd_shoe();
				Product_ListPage prod_list = new Product_ListPage(driver);
				prod_list.select_1st_Prod();
				Set<String> prodList = driver.getWindowHandles();
				Iterator<String> i1 = prodList.iterator();
				String P_ID = i1.next();
				String C_ID = i1.next();
				driver.switchTo().window(C_ID);
				
				ProductPage prodPg= new ProductPage(driver);
				prodPg.Buy_Now_Click();
				
				CheckOut_Page chOutPg = new CheckOut_Page(driver);
				chOutPg.changeAddress();
				chOutPg.selectAddress();
				chOutPg.UseThisAddress(driver);
				// change payment mode
				chOutPg.changePaymentMode(driver);
				
//				 select - NetBanking mode ---- click on Use THis Payment btn
				
				try
				{
					chOutPg.PayMentMode_NetBanking();
					chOutPg.SelectBank_NetBanking();
				}
				catch(NoSuchElementException ex)
				{
					chOutPg.changePaymentMode(driver);
					chOutPg.PayMentMode_NetBanking();
					chOutPg.SelectBank_NetBanking();
				}
				finally
				{
					chOutPg.useThisPayment(driver);
				}
				// -------------- if prime msg occures handle this ----------
				try
				{
					WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					w1.until(ExpectedConditions.elementToBeClickable(chOutPg.prime_msg_dismiss));
					chOutPg.dismiss_PrimeMsg();
				}
				catch(NoSuchElementException ex1)
				{
					System.out.println("NoSuchElementException-- prime msg not displayed");
				}
				catch(TimeoutException p)
				{
					System.out.println("NoSuchElementException-- prime msg not displayed");
				}
				finally
				{
		//  ------------------ check product review block is displayed ---
				Assert.assertEquals(chOutPg.Review_items.isDisplayed(), true, "TestCase 11 - Failed");
				}
			}
}
