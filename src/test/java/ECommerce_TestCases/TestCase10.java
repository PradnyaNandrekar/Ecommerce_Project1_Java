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

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.ProductPage;
import ECommerce_Source.Product_ListPage;
import ECommerce_Source.ShoppingCartPage;
import ECommerce_Source.ShoppingCart_PrePage;
import ECommerce_Source.SignIn_EmailPage;
import ECommerce_Source.SignIn_PasswordPage;

//Test updating item quantities and removing items from the cart.

public class TestCase10 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void cartUpdateTest() throws EncryptedDocumentException, IOException, InterruptedException
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
				//-------------Search and Select Product----------------
				hmPg.searchProd_shoe();
				Product_ListPage Prod_ListPg = new Product_ListPage(driver);
				Prod_ListPg.select_1st_Prod();
				//---------- Add product to cart ---------------------
				Set<String> prodList = driver.getWindowHandles();
				Iterator<String> i1 = prodList.iterator();
				String P_ID = i1.next();
				String C_ID = i1.next();
				driver.switchTo().window(C_ID);
				ProductPage ProdPg = new ProductPage(driver);
				ProdPg.addTo_Cart();
				ShoppingCart_PrePage CartPrePg = new ShoppingCart_PrePage(driver);
				Assert.assertEquals(CartPrePg.AddCart_success_Elmnt.getText(), "Added to cart");
				// ---------------- Go to Cart -Check initial Qty-----------------
				CartPrePg.GoToCart();
				ShoppingCartPage ShpCartPg = new ShoppingCartPage(driver);
				WebDriverWait wx = new WebDriverWait(driver, Duration.ofSeconds(10));
				wx.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ShpCartPg.cnt_elmnt)));
				
				int qty = Integer.parseInt(ShpCartPg.cnt_elmnt.getText());
				System.out.println("Initial Qty -" +qty);
				//--------------- Add Qty 1 in cart-------------------
				ShpCartPg.addQty(driver);
				driver.navigate().refresh();
//				WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//				w1.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ShpCartPg.cnt_elmnt)));
				//--------------- Chk Qty After add-------------------
				int qty1 = Integer.parseInt(ShpCartPg.cnt_elmnt.getText());
				System.out.println("After Add-"+qty1);
		
				// -------------- Check Initial Qty > Qty after add
				Assert.assertEquals(qty1>qty, true, "TestCase 10 - Failed - Adding product failed");
					
				//---------------Remove qty 1 from cart------------------
				
				ShpCartPg.removeQty();
				
				// ------------ Qty after remove should be < Qty after add
				driver.navigate().refresh();

//				WebDriverWait w3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//				w3.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ShpCartPg.cnt_elmnt)));

				int qty2 = Integer.parseInt(ShpCartPg.cnt_elmnt.getText());
				System.out.println("After remove-"+qty2);
				
				Assert.assertEquals(qty2<qty1, true, "TestCase 10 - Failed - Removing product failed");
				
				//---------------Delete 1 product from Cart --------------
//				Thread.sleep(5000);
				int befrDelt = ShpCartPg.Qty_Stepper_Elmnt.size();
				System.out.println("Items in Cart before delete -> "+befrDelt);
				WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				w2.until(ExpectedConditions.visibilityOf(ShpCartPg.delete_btn));
				ShpCartPg.deleteProd();
				Thread.sleep(5000);
				int aftrDelt = ShpCartPg.Qty_Stepper_Elmnt.size();
				System.out.println("Items in Cart after delete -> "+aftrDelt);
				// ---Check No of items in cart after delete should be less than before delete
				Assert.assertEquals(aftrDelt<befrDelt, true, "TestCase 10 - Failed - Deleting product Failed");
	}

}
