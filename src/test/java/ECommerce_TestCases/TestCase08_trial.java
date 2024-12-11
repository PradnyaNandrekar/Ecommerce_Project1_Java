package ECommerce_TestCases;

//Check if products can be sorted by relevance, price, rating, etc.


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;

public class TestCase08_trial extends Browser_Launch_Quit
{
//	retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true
	@Test(enabled=true)
	public void Sorting_Product_ByPrice_LtoH() throws EncryptedDocumentException, IOException 
	{
			DDT_Class ddt = new DDT_Class();
			ddt.SerachProduct();
			//---------------------------------- search product
			HomePage hmPg = new HomePage(driver);
			hmPg.searchProd_shoe();
			Product_ListPage prodList = new Product_ListPage(driver);
			//--------------------------------click on - Sort Low to High
			prodList.sort_Price_LowTHigh();
			driver.navigate().refresh();
			
			//--------------------------------- Get list of price
			prodList.price_List();
			System.out.println("Price_List---" + prodList.l1);
			int wrongPriceCnt=0;
			for(int i=0; i<prodList.l1.size()-1;i++)
			{
				if(prodList.l1.get(i) > prodList.l1.get(i+1))
				{
					wrongPriceCnt++;
//					System.out.println("WrongPrice_LtoH found is" + prodList.l1.get(i));
				}
				
			}
			System.out.println("wrongPriceCnt_LtoH---" + wrongPriceCnt);
			Assert.assertEquals(wrongPriceCnt, 0, "TestCase 08 - Failed - Price Sorting L to H failed");
						
	}
	
	
	@Test(enabled=true)
	public void Sorting_Product_ByPrice_HtoL() throws EncryptedDocumentException, IOException 
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		//---------------------------------- search product
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		Product_ListPage prodList = new Product_ListPage(driver);
		//--------------------------------- Sort High to Low
		prodList.sort_Price_HighTLow();
		driver.navigate().refresh();
		//--------------------------------- Get list of price
		prodList.price_List();
		System.out.println("Price_List---" + prodList.l1);
		int wrongPriceCnt1=0;
		for(int i=0; i<prodList.l1.size()-1;i++)
		{
			if(prodList.l1.get(i) < prodList.l1.get(i+1))
			{
				wrongPriceCnt1++;
				System.out.println("WrongPrice_HtoL found is" + prodList.l1.get(i));
			}
			
		}
		System.out.println("wrongPriceCnt_HtoL---" + wrongPriceCnt1);
		Assert.assertEquals(wrongPriceCnt1, 0, "TestCase 08 - Failed- Price Sorting H to L failed");
	
	}
	
	@Test(enabled=false)
	public void Sorting_Product_rating() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
			//---------------------------------  search product
			HomePage hmPg = new HomePage(driver);
			hmPg.searchProd_shoe();
			Product_ListPage prodList = new Product_ListPage(driver);
			prodList.ratings_list();
	}
	
}
