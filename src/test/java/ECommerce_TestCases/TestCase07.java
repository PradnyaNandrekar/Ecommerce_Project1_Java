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

//Ensure that the product detail page displays all necessary information (price, reviews, description).

public class TestCase07 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void product_Info() throws EncryptedDocumentException, IOException
	{
		DDT_Class dt = new DDT_Class();
		dt.SerachProduct();
		// ---------- search product
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		// ------------ select product		
		Product_ListPage prod_list = new Product_ListPage(driver);
		prod_list.select_1st_Prod();
		
		Set<String> prodList = driver.getWindowHandles();
		Iterator<String> i1 = prodList.iterator();
		String P_ID = i1.next();
		String C_ID = i1.next();
		driver.switchTo().window(C_ID);
		
		// check if all fields are present
		// check description is present?
		ProductPage prodPg = new ProductPage(driver);
	
		// ---------------  check description is present?
		boolean prod_Des = prodPg.prod_Description_Elmnt.isDisplayed();
		// ---------------  check price is present?
		boolean prod_Price = prodPg.prod_Price_Elmnt.isDisplayed();
		// ---------------  check reviews is present?
		boolean prod_Reviews = prodPg.prod_Reviews_Elmnt.isDisplayed();
//		boolean prod_Reviews = false;    // Use To test Fail condition
		boolean allFields_Present = prod_Des && prod_Price && prod_Reviews;
		Assert.assertEquals(allFields_Present, true, "One of the Product Details Field is not Present");
		Reporter.log("All Product Details are present");
		
		
		
	}

}
