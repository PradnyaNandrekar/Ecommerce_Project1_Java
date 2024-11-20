package ECommerce_Source;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_ListPage 
{
	WebDriver driver = new ChromeDriver();
	@FindBy(xpath="//span[@class='rush-component']/a/div")
	public List<WebElement> prod_List_Elmnt;
	
	@FindBy(xpath="(//span[@class='rush-component']/a/div)[1]")
	WebElement prod_1st_Elmnt;
	
	@FindBy(id="a-autoid-3-announce")
	WebElement AddToCart_1st_Elmnt;
	
	public void select_1st_Prod()
	{
		prod_1st_Elmnt.click();
	}
	
	/*public void addCart_FromList()
	{
		AddToCart_1st_Elmnt.click();
	}*/
	
	public Product_ListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
