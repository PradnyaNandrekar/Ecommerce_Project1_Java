package ECommerce_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;


public class TestCase05 extends Browser_Launch_Quit
{
	@Test
	public void SearchProduct_Test()
	{
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd();
		Product_ListPage prodList = new Product_ListPage(driver);
//		System.out.println(prodList.prod_List_Elmnt.size());
		Assert.assertEquals((prodList.prod_List_Elmnt.size()>1), true);
		
	}
	
}
