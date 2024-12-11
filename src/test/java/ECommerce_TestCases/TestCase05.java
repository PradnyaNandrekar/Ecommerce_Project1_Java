package ECommerce_TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;

//Test searching for products using its name like shoe

public class TestCase05 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class)
	public void SearchProduct_Test() throws EncryptedDocumentException, IOException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		// ----------- Search product 
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		Product_ListPage prodList = new Product_ListPage(driver);
//		System.out.println(prodList.prod_List_Elmnt.size());
		// ----------- check if products search count is > 10
		Assert.assertEquals((prodList.prod_List_Elmnt.size()>10), true, "TestCase 05 - Failed");
		
	}
	
}
