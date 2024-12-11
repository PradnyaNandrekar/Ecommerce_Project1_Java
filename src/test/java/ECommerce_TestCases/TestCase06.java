package ECommerce_TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;

//Verify that searching with filters (e.g., category, price range) yields accurate results.

public class TestCase06 extends Browser_Launch_Quit
{
//	retryAnalyzer=ECommerce_TestCases.retryLogic.class,
	@Test( enabled=false)
	public void searching_Wt_Price() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		// -------------------- Search Product 
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		//--------------------- select price range by using price slider 
		Product_ListPage prodList = new Product_ListPage(driver);
		prodList.slider_PriceRange_Set();  // not working.. No Such Element 
		
//		prodList.price_Slider_Go();
//		System.out.println(prodList.upper_Price_range.getText());
		
	}
	
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void searching_Wt_Filters() throws EncryptedDocumentException, IOException, InterruptedException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		// -------------------- Search Product 
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		//--------------------- select Get it by Tomorrow option 
		Product_ListPage prodList = new Product_ListPage(driver);
//		prodList.Fltr_By_DeliveryDay_Shoe();   // think how to apply assert
		//--------------------- select Discount option 
		prodList.Fltr_By_Disocunt_Shoes();  // works for pen, Shoe
		SoftAssert a1 = new  SoftAssert();
		a1.assertEquals(prodList.wrongDiscountedProd_Count, 0,"TestCase 06 - Filter by discount Failed");
//		Assert.assertEquals(prodList.wrongDiscountedProd_Count, 0, "filtered product list has wrong discount product");

		//--------------------- select Brand option 
		prodList.Fltr_By_Brand_Shoe();    // works only for shoe... for pen need to get description
		a1.assertEquals(prodList.ShoeBrand.equalsIgnoreCase(prodList.BrandName), true, "TestCase 06 - Filter by brand Failed");
//		Assert.assertEquals(prodList.ShoeBrand.equalsIgnoreCase(prodList.BrandName), true);
		Reporter.log("----------- Filter By Brand Test Pass -----------");
		a1.assertAll();
	}
	
}
