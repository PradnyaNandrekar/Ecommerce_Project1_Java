package ECommerce_Source;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Product_ListPage 
{
	WebDriver driver = new ChromeDriver();
	
	public List<Integer> l1 = new ArrayList<Integer>();
	@FindBy(xpath="//span[@class='rush-component']/a/div")
	public List<WebElement> prod_List_Elmnt;
	
	@FindBy(xpath="(//span[@class='rush-component']/a/div)[3]")
	WebElement prod_1st_Elmnt;
	
	@FindBy(id="a-autoid-3-announce")
	WebElement AddToCart_1st_Elmnt;
	
	@FindBy(xpath="(//button[.='Add to cart'])[3]")
	WebElement AddToCart_3rd_Elmnt_FromPg;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	public List<WebElement> all_Prod_price_Elmnt;
	
	@FindBy(xpath="//a[@class='a-popover-trigger a-declarative']/i/span")
	public List<WebElement> all_Prod_rating_Elmnt;
	
//	@FindBy(xpath="//span[@class='a-button-text a-declarative']")
//	WebElement sort_dropdown_click;
	
	@FindBy(xpath="(//span[.='Price'])")
	WebElement priceTag_Elmnt;
	
	@FindBy(id="s-result-sort-select")
	WebElement sort_dropdown;
	
	@FindBy(xpath="//div[@class='a-row puis-atcb-remove-group']")
	public WebElement addedCart_tag;
	
	@FindBy(id="p_36/range-slider_slider-item_lower-bound-slider")
	WebElement price_Slider_Elmnt;
	
	@FindBy(xpath="//div[@class='a-section sf-submit-range-button']")
	WebElement priceSlider_Go_btn;
	
	@FindBy(xpath="(//span[@class='a-size-base a-color-base a-text-bold'])[3]")
	public WebElement upper_Price_range;
	
//	@FindBy(xpath="//div[@id='s-refinements']/div/div")
//	List<WebElement> Categories_List;
	
	@FindBy(xpath="//div[@id='s-refinements']/div/div[@id='deliveryRefinements']/ul/span/span")
	List<WebElement> Category_By_DeliveryDay;
	
	@FindBy(xpath="//div[@id='s-refinements']/div/div[@id='brandsRefinements']/ul/span/span/li/span/a")
	List<WebElement> Category_By_Brand;
	
	@FindBy(xpath="//div[@id='s-refinements']/div/div[@id='brandsRefinements']/ul/span/span/li/span/a/span")
	List<WebElement> Category_Brand_names;

	@FindBy(xpath="//h2[@class='a-size-mini s-line-clamp-1']/span")
	List<WebElement> List_Brand_shoe;

	
	@FindBy(xpath="//div[@id='s-refinements']/div/div[@id='p_n_pct-off-with-tax/2665398031']/ul/span/span/li/span/a/span")
	List<WebElement> Category_By_Discount;
		
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> ProductDescription_shoes;
	
	@FindBy(xpath="//div[@class='a-row a-size-base a-color-base']/div/span[2]")
	List<WebElement> ProductDescription_Discount_shoes;

	@FindBy(xpath="(//h2[@id='acr-popover-title']/span)[9]")
	WebElement each_Prod_rating;
	
	
	public void select_1st_Prod()
	{
		prod_1st_Elmnt.click();
		
	}
	/*public void all_CategoryList()
	{
		System.out.println("Total categories present are -> "+Categories_List.size());
		for(int i=0; i<Categories_List.size(); i++)
		{
			WebElement subCatList = Categories_List.get(i);
			String categories = subCatList.getAttribute("id");
			System.out.println(subCatList);
			System.out.println(categories);
			
			System.out.println(subCatList+"[@id='"+categories+"']");
			
		}
	}
	*/
	
	public void Fltr_By_DeliveryDay_Shoe() throws InterruptedException
	{
		Category_By_DeliveryDay.size();
		int i = 1;
//		for(int i=0; i<Category_By_DeliveryDay.size();i++)
//		{
		Category_By_DeliveryDay.get(i).click();
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOfAllElements(Category_By_DeliveryDay));
//		}

	}
	public String BrandName, ShoeBrand;
	public void Fltr_By_Brand_Shoe() throws InterruptedException
	{
		Category_By_Brand.size();
		int i = 2; // select 3rd brand
//		for(int i=0; i<Category_By_Brand.size();i++)
//		{
			Category_By_Brand.get(i).click();
			BrandName = Category_Brand_names.get(0).getText();    // get text of filtered brand it comes 1st always
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w1.until(ExpectedConditions.visibilityOfAllElements(Category_By_Brand));
//		}
			System.out.println("Selected brand - '"+ BrandName + "' product count is "+ List_Brand_shoe.size());
			for(int s=0; s<List_Brand_shoe.size();s++)
			{
				WebElement elmnt = List_Brand_shoe.get(s);
				ShoeBrand = elmnt.getText();
				if(!(ShoeBrand.equalsIgnoreCase(BrandName)))
				{
					System.out.println("Other brands also got filtered--> "+ShoeBrand);
				}
			}
	}

	public int wrongDiscountedProd_Count;
	public void Fltr_By_Disocunt_Shoes() throws InterruptedException
	{
		Category_By_Discount.size();
		int i = 2;
//		for(int i=0; i<Category_By_Discount.size();i++)
//		{
		try
		{
			Category_By_Discount.get(i).click();
			String disctCateGory = Category_By_Discount.get(i).getText();
			System.out.println("Discount category selected is - "+disctCateGory);
//			System.out.println(disctCateGory.substring(0, disctCateGory.length()-13));
			int disct_Selected = Integer.parseInt(disctCateGory.substring(0, disctCateGory.length()-13));
			System.out.println(disct_Selected);
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w1.until(ExpectedConditions.visibilityOfAllElements(Category_By_Discount));
//		}
			wrongDiscountedProd_Count = 0;
			for(int t=0; t<ProductDescription_Discount_shoes.size();t++)
			{
				String prodDicount = ProductDescription_Discount_shoes.get(t).getText();
				System.out.println(prodDicount);
//				System.out.println(prodDicount.substring(1, prodDicount.length()-6));
				try
				{
					int eachProdDiscount = Integer.parseInt(prodDicount.substring(1, prodDicount.length()-6));
					if(!(eachProdDiscount>=disct_Selected))
					{
						System.out.println("Filter with Discount failed for "+prodDicount);
						wrongDiscountedProd_Count += 1;
					}
					
				}
				catch(StringIndexOutOfBoundsException ex) // Range [1, -6) out of bounds for length 0
				{
					System.out.println("this product is not having discount"+disctCateGory);
				}
				
			}
		}
		catch(IndexOutOfBoundsException ex)
		{
			Reporter.log("This product is not having selected discount available. Please try with different filter.");
			System.out.println("This product is not having selected discount available. Please try with different filter.");
		}
	}
	
	public void price_Slider_Go()
	{
		priceSlider_Go_btn.click();
	}
	
	public void slider_PriceRange_Set() throws AWTException, InterruptedException
	{
		Point CustReviewLoc = priceTag_Elmnt.getLocation();
		int CustRvwlocX = CustReviewLoc.getX();
		int CustRvwlocY = CustReviewLoc.getY();
		
		JavascriptExecutor js_CustRvw = (JavascriptExecutor) driver;
		js_CustRvw.executeScript("window.scrollBy(0,"+CustRvwlocY+")");
		
		Actions a1 = new Actions(driver);
//		a1.dragAndDropBy(price_Slider_Elmnt, -40, 0).perform();
		a1.doubleClick(price_Slider_Elmnt).perform();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		r1.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(500);
//		r1.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(500);
//		int i = 1;
//		while(i==1)
//		{
//			r1.keyPress(KeyEvent.VK_LEFT);
//			Thread.sleep(500);
//			if (upper_Price_range.getText()=="₹1,000")
//			{
//				break;
//				i=0;
//			}
//			
//		}
				
	}
	
	public void addCart_FromList()
	{
		AddToCart_3rd_Elmnt_FromPg.click();
	}
	
	public void price_List()
	{
		System.out.println("Size of list-> "+ all_Prod_price_Elmnt.size());
		for (int i=0; i < all_Prod_price_Elmnt.size(); i++)
		{
				WebElement list_elmnt = all_Prod_price_Elmnt.get(i);
				String price1 = list_elmnt.getText();
				String price2 = price1.replaceAll(" ", "");
				try
				{
					if(!(price2.contains(",")))
					{
						int f_price = Integer.parseInt(price2);
						l1.add(f_price);
					}
					else
					{
						int f_price = Integer.parseInt(price2.replace(",", ""));
						l1.add(f_price);
					}
		
				}
				catch(NullPointerException e1)
				{
					System.out.println("Price not present handled exception");
				}
				catch(NumberFormatException ex)
				{
					System.out.println("NumberFormatException handled");
				}
				
		}
		System.out.println("Default List of Price - "+ l1);
	}
	
//	public void sort_DropDwn_click_mthd()
//	{
//		sort_dropdown_click.click();
//	}	
	public void sort_Price_LowTHigh()
	{
		Select s1 = new Select(sort_dropdown);
		s1.selectByVisibleText("Price: Low to High");
	}
	public void sort_Price_HighTLow()
	{
		Select s1 = new Select(sort_dropdown);
		s1.selectByVisibleText("Price: High to Low");
	}
	public void ratings_list() throws InterruptedException
	{
		Actions a1 = new Actions(driver);
		
		System.out.println("Size of ratings List -> "+ all_Prod_rating_Elmnt.size());
		for(int i=0; i<all_Prod_rating_Elmnt.size(); i++)
		{
			all_Prod_rating_Elmnt.get(i).click();
			each_Prod_rating.click();
//			WebElement rating_elmnt = all_Prod_rating_Elmnt.get(i);
			String rating = each_Prod_rating.getText();
			System.out.println("rating = "+rating);
			Thread.sleep(5000);
		}
	}
	
		
	
	public Product_ListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
