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
	@Test
	public void cartUpdateTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
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
				hmPg.searchProd();
				// ----------Select Product -----------------
				Product_ListPage Prod_ListPg = new Product_ListPage(driver);
				Prod_ListPg.select_1st_Prod();
				//----------Add to cart ---------------------
				Set<String> prodList = driver.getWindowHandles();
				Iterator<String> i1 = prodList.iterator();
				String P_ID = i1.next();
				String C_ID = i1.next();
				driver.switchTo().window(C_ID);
				ProductPage ProdPg = new ProductPage(driver);
				ProdPg.addTo_Cart();
				ShoppingCart_PrePage CartPrePg = new ShoppingCart_PrePage(driver);
				Assert.assertEquals(CartPrePg.AddCart_success_Elmnt.getText(), "Added to cart");
				// ---------------- Go to Cart -----------------
				CartPrePg.GoToCart();
				// Check Qty 
				ShoppingCartPage ShpCartPg = new ShoppingCartPage(driver);
//				int qty = Integer.parseInt(ShpCartPg.Subtotal_Elmnt.getText());
//				System.out.println("Initial Qty -" +qty);
				//--------------- Add Qty 1 -------------------
				ShpCartPg.addQty();
				driver.navigate().refresh();
				Thread.sleep(10);
//				int qty1 = Integer.parseInt(ShpCartPg.Subtotal_Elmnt.getText());
//				System.out.println("After Add-"+qty1);
				
				
				// Check subtotal item should be 2
//				Assert.assertEquals(qty1, qty1>qty, "Test Failed - Qty Not Updated");
				
				
				//---------------Remove qty 1------------------
				ShpCartPg.removeQty();
				
				// Check subtotal item should be 1
				driver.navigate().refresh();
				Thread.sleep(10);
//				int qty2 = Integer.parseInt(ShpCartPg.Subtotal_Elmnt.getText());
//				System.out.println("After remove-"+qty2);
				
//				Assert.assertEquals(qty2, qty2<qty1, "Test Failed - Qty Not Updated");
				
				//---------------Delete from Cart --------------
				WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				w1.until(ExpectedConditions.visibilityOf(ShpCartPg.delete_btn));
				ShpCartPg.deleteProd();
				String CartMsg= ShpCartPg.emptyCartTxt.getText();
				System.out.println(ShpCartPg.emptyCartTxt.getText());
				Assert.assertEquals(CartMsg.contains("Cart is empty"), true, "Delete Failed-Cart is not empty" );
				
		
	}

}
