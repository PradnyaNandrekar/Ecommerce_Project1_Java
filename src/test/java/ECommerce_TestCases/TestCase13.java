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

//Check if user is able to apply for coupon code while ordering the product

public class TestCase13  extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void CheckOutProcess_Enter_PromoCode() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// ---------------- login
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
		//--------------- Search and select product - and click buy now
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
		
		// ------------ Enter Promo Code 
		CheckOut_Page chkOutPg= new CheckOut_Page(driver);
		chkOutPg.Enter_Promo_Code();
		
		// ------------ Check if error code displayed contains required text msg
		String errorPromoCode = chkOutPg.Promo_Code_Error.getText();
		Assert.assertEquals(errorPromoCode.contains("code you entered is not valid"), true);
	}
}
