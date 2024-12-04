package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
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


//Check if user is able to select each payment method

public class TestCase12 extends Browser_Launch_Quit 
{
//	retryAnalyzer=ECommerce_TestCases.retryLogic.class
	@Test()
	public void PaymentMethod_Selection() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// ------------------ Login
				DDT_Class dtCl = new DDT_Class();
				dtCl.UserName();
				dtCl.SerachProduct();
				dtCl.CreditCardDetails();
				HomePage hmPg = new HomePage(driver);
				hmPg.acAndList(driver);
				hmPg.Sign_In();
				SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
				SnInPg.UserName();
				SnInPg.Continue_Click();
				SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
				SnInPw.Enter_Password();
				SnInPw.SignIn_Submit();		
		// ------------------ Select product and click on buy Now
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
	
		// ------------------ select - Credit or debit card 
				CheckOut_Page chkOut_Pg = new CheckOut_Page(driver);
				chkOut_Pg.PayMentMode_CreditDebitCard();
				// Enter card Details
				chkOut_Pg.Enter_DebitCardDetails_And_CVV(driver);
				Assert.assertEquals(chkOut_Pg.UseThisPayment_Btn_Elmnt.isEnabled(), true);
				
		// ------------------ select - Net Banking
				chkOut_Pg.PayMentMode_NetBanking();
				chkOut_Pg.SelectBank_NetBanking();
				WebElement e1 = driver.findElement(By.xpath("(//div[@class='a-box-inner a-padding-small'])[3]"));
				e1.click();
				Assert.assertEquals(chkOut_Pg.UseThisPayment_Btn_Elmnt.isEnabled(), true);
			// observation -- after selecting the option - dropdown not minimizing
		
		// ------------------ select - Other UPI Apps
				chkOut_Pg.OtherUPIApps_Payment();
				Assert.assertEquals(chkOut_Pg.UseThisPayment_Btn_Elmnt.isEnabled(), true);
		// ------------------ select - Cash on Delivery/Pay on Delivery
				Thread.sleep(1000);
				chkOut_Pg.CashOnDelivery();
				chkOut_Pg.useThisPayment();
//				WebDriverWait wx = new WebDriverWait(driver, Duration.ofSeconds(15));
//				wx.until(ExpectedConditions.visibilityOf(chkOut_Pg.place_Ur_order_btn));
				Assert.assertEquals(chkOut_Pg.place_Ur_order_btn.isDisplayed(), true);
				
	}

}
