package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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

public class TestCase11_trial extends Browser_Launch_Quit
{
	@Test
	public void CheckOutProcess_CashOnDelivery_Method() throws EncryptedDocumentException, IOException
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
				chOutPg.UseThisAddress();
//				 select - cash on delivery mode ---- click on Use THis Payment btn
				if(chOutPg.cashOnDlvry_Elmnt.isDisplayed() && chOutPg.cashOnDlvry_Elmnt.isEnabled() )
					{
						chOutPg.CashOnDelivery();
						chOutPg.useThisPayment();
					}
					else
					{
						System.out.println("Cash On Delivery is not available for this product.Selecting UPI method....");
						chOutPg.OtherUPIApps_Payment();
					}
//					WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//					w1.until(ExpectedConditions.visibilityOf(chOutPg.UseThisPayment_Btn_Elmnt));
					chOutPg.useThisPayment();
					//  ------------------ check product review block is displayed ---
					Assert.assertEquals(chOutPg.Review_items.isDisplayed(), true);
	}
}
