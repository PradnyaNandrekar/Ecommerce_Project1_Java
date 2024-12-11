package ECommerce_TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.ProductPage;
import ECommerce_Source.Product_ListPage;
import ECommerce_Source.ShoppingCart_PrePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

//Verify that items can be added to the shopping cart from product pages.

public class TestCase09 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void AddToCartTest_ProdctDeatils_Pg() throws EncryptedDocumentException, IOException
	{
		DDT_Class dt = new DDT_Class();
		dt.UserName();
		dt.SerachProduct();
		// -------------------Login ---------------
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();
		//-------------Search Product----------------
		hmPg.searchProd_shoe();
		// ----------Select 1st Product -----------------
		Product_ListPage Prod_ListPg = new Product_ListPage(driver);
		Prod_ListPg.select_1st_Prod();
		//----------Add to cart ---------------------
		Set<String> prodList = driver.getWindowHandles();
		Iterator<String> i1 = prodList.iterator();
		String P_ID = i1.next();
		String C_ID = i1.next();
		driver.switchTo().window(C_ID);
		ProductPage ProdPg = new ProductPage(driver);
		// ----------------- add to cart -------------
		ProdPg.addTo_Cart();
		ShoppingCart_PrePage CartPrePg = new ShoppingCart_PrePage(driver);
		// ----------- Check if "Added to cart" message displayed
		Assert.assertEquals(CartPrePg.AddCart_success_Elmnt.getText(), "Added to cart", "TestCase 09 - Failed");
		
	}
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=false)
	// tried to add from homePage product list - works only for pen
	public void AddToCartTest_ProdctList_Pg() throws EncryptedDocumentException, IOException
	{
		DDT_Class dt = new DDT_Class();
		dt.UserName();
		dt.SerachProduct();
		//-------------login----------------
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.Sign_In();
		SignIn_EmailPage SnInPg = new SignIn_EmailPage(driver);
		SnInPg.UserName();
		SnInPg.Continue_Click();
		SignIn_PasswordPage SnInPw= new SignIn_PasswordPage(driver);
		SnInPw.Enter_Password();
		SnInPw.SignIn_Submit();
		//-------------Search Product----------------
		hmPg.searchProd_pen();
		// ----------Select Product -------Add to cart ------------------
		Product_ListPage Prod_ListPg = new Product_ListPage(driver);
		Prod_ListPg.addCart_FromList();
		//-----------------------Check if "1 in cart-Remove"-- element is displyed or not
		Assert.assertEquals(Prod_ListPg.addedCart_tag.isDisplayed(), true);
	}

}
