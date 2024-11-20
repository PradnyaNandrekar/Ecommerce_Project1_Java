package ECommerce_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;

//Reach till cart page without login in amazon application

public class TestCase15 extends Browser_Launch_Quit 
{
	@Test
	public void Reach_To_Cart_Test()
	{
		HomePage hmPg = new HomePage(driver);
		hmPg.ClickCart();
		String titleCart= driver.getTitle();
		String Actual_Cart_Title = "Amazon.in Shopping Cart";
		Assert.assertEquals(titleCart, Actual_Cart_Title);
		
		
	}
}
