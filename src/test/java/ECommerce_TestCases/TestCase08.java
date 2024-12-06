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
			List<Integer> List2_Man_Sort = new ArrayList<Integer>();
			List2_Man_Sort.addAll(prodList.l1);
			Collections.sort(List2_Man_Sort);
			System.out.println("Manually sorted (Low-High) PriceList"+List2_Man_Sort);
			//---------------------------------  Select - select by - "Price Low to High"
			System.out.println("bEFORE system_Sorted (Low-High) PriceList - " + prodList.l1);
			prodList.sort_Price_LowTHigh();
//			driver.navigate().refresh();
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w1.until(ExpectedConditions.visibilityOfAllElements(prodList.all_Prod_price_Elmnt));
			//---------------------------------  get list of price 
			prodList.price_List();
			System.out.println("system_Sorted (Low-High) PriceList - " + prodList.l1);
			//---------------------------------  compare After sorting list1 and list2 
			Assert.assertEquals(prodList.l1, List2_Man_Sort, "Sort By- price Low-High Failed..");
			
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
	//		driver.navigate().refresh();
			System.out.println("Default List of Price - "+ prodList.l1);
			//--------------------------------- sort list
			List<Integer> List2_Man_Sort = new ArrayList<Integer>();
			List2_Man_Sort.addAll(prodList.l1);
			Collections.sort(List2_Man_Sort);
			System.out.println("Manually sorted (Low-High) PriceList"+List2_Man_Sort);
			//--------------------------------- Reverse manual sorted list 
			List<Integer> List3_Man_Sort_Hgh_Low = new ArrayList<Integer>();
			for(int i=0, j=List2_Man_Sort.size()-1; i<List2_Man_Sort.size(); i++, j--)
			{
				List3_Man_Sort_Hgh_Low.add(i, List2_Man_Sort.get(j));
			}
			System.out.println("Manually sorted (High-Low) PriceList"+List3_Man_Sort_Hgh_Low);
			//---------------------------------  Select - select by - "Price High to l"
			System.out.println("Before system_Sorted (High-Low) PriceList - "+prodList.l1); // Getting same list as before sort. not getting refreshed list sorted H-L
			prodList.sort_Price_HighTLow();
			driver.navigate().refresh();
			Thread.sleep(3000);
			prodList.price_List();
			System.out.println("system_Sorted (High-Low) PriceList - "+prodList.l1); // Getting same list as before sort. not getting refreshed list sorted H-L
			Assert.assertEquals(prodList.l1, List3_Man_Sort_Hgh_Low, "Sort By- price High-Low Failed..");
			
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
