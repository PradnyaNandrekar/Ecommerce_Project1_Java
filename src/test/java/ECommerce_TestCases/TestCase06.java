package ECommerce_TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ECommerce_Source.DDT_Class;
import ECommerce_Source.HomePage;
import ECommerce_Source.Product_ListPage;

//Verify that searching with filters (e.g., category, price range) yields accurate results.

public class TestCase06 extends Browser_Launch_Quit
{
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=false)
	public void searching_Wt_Price() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		// -------------------- Search Product 
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		//--------------------- select price range by using price slider 
		Product_ListPage prodList = new Product_ListPage(driver);
		prodList.slider_PriceRange_Set();  // not working.. No Such Element 
		
//		prodList.price_Slider_Go();
//		System.out.println(prodList.upper_Price_range.getText());
		
	}
	
	@Test(retryAnalyzer=ECommerce_TestCases.retryLogic.class, enabled=true)
	public void searching_Wt_Filters() throws EncryptedDocumentException, IOException, InterruptedException
	{
		DDT_Class ddt = new DDT_Class();
		ddt.SerachProduct();
		// -------------------- Search Product 
		HomePage hmPg = new HomePage(driver);
		hmPg.searchProd_shoe();
		//--------------------- select Get it by Tomorrow option 
		Product_ListPage prodList = new Product_ListPage(driver);
//		prodList.Fltr_By_DeliveryDay_Shoe();   // think how to apply assert
		//--------------------- select Brand option 
		prodList.Fltr_By_Brand_Shoe();    // works only for shoe... for pen need to get description
		Assert.assertEquals(prodList.ShoeBrand.equalsIgnoreCase(prodList.BrandName), true);
		Reporter.log("----------- Filter By Brand Test Pass -----------");
		//--------------------- select Discount option 
		prodList.Fltr_By_Disocunt_Shoes();  // works for pen, Shoe
		Assert.assertEquals(prodList.wrongDiscountedProd_Count, 0, "filtered product list has wrong discount product");
	}
	
	
	
	/*{
deliveryRefinements
p_n_size_browse-vebin/2022058031
brandsRefinements
priceRefinements
p_n_size_two_browse-vebin/2022042031
departments
reviewsRefinements
p_n_feature_nineteen_browse-bin/11301362031
p_n_pct-off-with-tax/2665398031
p_n_feature_twenty_browse-bin/49265298031
p_n_feature_fourteen_browse-bin/29603785031
p_n_feature_sixteen_browse-bin/38069012031
p_n_intended_use_browse-bin/2022062031
p_n_is_cod_eligible/4931670031
p_n_date_first_available_absolute/1318486031
p_n_feature_seventeen_browse-bin/41595444031
p_6/1318474031
p_n_feature_twenty-one_browse-bin/60620651031
p_n_feature_twelve_browse-bin/29593843031
p_n_feature_two_browse-bin/2022069031
p_n_feature_eleven_browse-bin/2022034031
p_n_feature_six_browse-bin/28095657031
p_n_availability/1318483031

}*/
}
