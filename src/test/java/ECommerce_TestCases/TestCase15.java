package ECommerce_TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.ProductPage;
import ECommerce_Source.Product_ListPage;
import ECommerce_Source.ShoppingCartPage;
import ECommerce_Source.ShoppingCart_PrePage;
import ECommerce_Source.SignIn_EmailPage;

//Reach till cart page without login in amazon application

public class TestCase15 extends Browser_Launch_Quit 
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void Reach_To_Cart_Test() throws EncryptedDocumentException, IOException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		
		//------------ Search and select product
		Product_ListPage prod_listPg = new Product_ListPage(driver);
		prod_listPg.select_1st_Prod();
		
		Set<String> prodList = driver.getWindowHandles();
		Iterator<String> i1 = prodList.iterator();
		String P_ID = i1.next();
		String C_ID = i1.next();
		driver.switchTo().window(C_ID);
		
		//--------- add product to cart
		ProductPage prodPg = new ProductPage(driver);
		try
		{
			prodPg.addTo_Cart();
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Add to cart button not found");
			if(prodPg.customise_now_btn.isDisplayed())
			{
			System.out.println("Product Need customisation");
			}
		}
			
		//------------- go to cart
		
		ShoppingCart_PrePage shp_pCartPg= new ShoppingCart_PrePage(driver);
		shp_pCartPg.GoToCart();
		
		//--------------- click on proceed to buy button
		ShoppingCartPage shpCartPg= new ShoppingCartPage(driver);
		shpCartPg.Procd_To_Buy();
		
		SignIn_EmailPage sgEmailPg = new SignIn_EmailPage(driver);
		
		//---------------- check if sign in page - user name text box displayed
		Assert.assertEquals(sgEmailPg.UserName_Elmnt.isDisplayed(), true, "TestCase 15 - Failed");
		
		
	}
}
