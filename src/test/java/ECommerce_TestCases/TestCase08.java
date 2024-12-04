package ECommerce_TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;

//Check if products can be sorted by relevance, price, rating, etc.

public class TestCase08 extends Browser_Launch_Quit
{
//	retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true
	@Test(enabled=false)
	public void Sorting_Product_ByPrice_LtoH() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
			//---------------------------------- search product
			HomePage hmPg = new HomePage(driver);
			hmPg.searchProd_shoe();
			Product_ListPage prodList = new Product_ListPage(driver);
			//--------------------------------- Get list of price
			prodList.price_List();
//			driver.navigate().refresh();
			System.out.println("Default List of Price - "+ prodList.l1);
			//--------------------------------- sort list
			Collections.sort(prodList.l1);
			//------- add manually sorted values in "manuallySorted_l1_low_Hgh" list
			List<Integer> manuallySorted_l1_low_Hgh = new ArrayList<Integer>();
			manuallySorted_l1_low_Hgh.addAll(prodList.l1);
			System.out.println("Manually sorted (Low-High) PriceList"+manuallySorted_l1_low_Hgh);
			//---------------------------------  Select - select by - "Price Low to High"
			prodList.sort_Price_LowTHigh();
			driver.navigate().refresh();
		
			//---------------------------------  get list of price 
			prodList.price_List();
			System.out.println("system_Sorted (Low-High) PriceList - "+prodList.l1);
			//---------------------------------  compare After sorting list1 and list2 
			
			Assert.assertEquals(prodList.l1, manuallySorted_l1_low_Hgh, "Sort By- price Low-High Failed..");
			
	}

	@Test(enabled=true)
	public void Sorting_Product_ByPrice_HtoL() throws InterruptedException, EncryptedDocumentException, IOException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
			//---------------------------------- search product
			HomePage hmPg = new HomePage(driver);
			hmPg.searchProd_shoe();
			Product_ListPage prodList = new Product_ListPage(driver);
			//--------------------------------- Get list of price
			prodList.price_List();
//			driver.navigate().refresh();
			System.out.println("Default List of Price - "+ prodList.l1);
			//--------------------------------- sort list
			Collections.sort(prodList.l1);
			//------- add manually sorted values in "manuallySorted_l1_low_Hgh" list
			List<Integer> manuallySorted_l1_low_Hgh = new ArrayList<Integer>();
			manuallySorted_l1_low_Hgh.addAll(prodList.l1);
			System.out.println("Manually sorted (Low-High) PriceList"+manuallySorted_l1_low_Hgh);
			//---------------------------------  Sort list manually reversed order
			List<Integer> manuallySorted_l1_Hgh_Low = new ArrayList<Integer>();
			for(int i=0, j=manuallySorted_l1_low_Hgh.size()-1; i<manuallySorted_l1_low_Hgh.size(); i++, j--)
			{
				manuallySorted_l1_Hgh_Low.add(i, manuallySorted_l1_low_Hgh.get(j));
			}
			System.out.println("Manually sorted (High-Low) PriceList"+manuallySorted_l1_Hgh_Low);
			//---------------------------------  Select - select by - "Price High to l"
			prodList.sort_Price_HighTLow();
			driver.navigate().refresh();
			Thread.sleep(3000);
			prodList.price_List();
			System.out.println("system_Sorted (High-Low) PriceList - "+prodList.l1); // Getting same list as before sort. not getting refreshed list sorted H-L
			Assert.assertEquals(prodList.l1, manuallySorted_l1_Hgh_Low, "Sort By- price High-Low Failed..");
			
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
