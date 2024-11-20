package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{

	@FindBy(id="add-to-cart-button")
	WebElement addCart_Btn_Elmnt;
	
		
	public void addTo_Cart()
	{
		addCart_Btn_Elmnt.click();
	}
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
