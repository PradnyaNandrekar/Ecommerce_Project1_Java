package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{

	@FindBy(id="add-to-cart-button")
	public WebElement addCart_Btn_Elmnt;
	
	@FindBy(xpath="//div[@id='titleSection']")
	public WebElement prod_Description_Elmnt;
	
	@FindBy(xpath="//div[@id='apex_desktop']")
	public WebElement prod_Price_Elmnt;
	
	@FindBy(xpath="(//div[@id='averageCustomerReviews'])[1]")
	public WebElement prod_Reviews_Elmnt;
	
	@FindBy(name="submit.buy-now")
	WebElement BuyNow_Btn_Elmnt;
	
	@FindBy(xpath="//button[@id='gestalt-popover-button-announce']")
	public WebElement customise_now_btn;
	
	
	public void addTo_Cart()
	{
		addCart_Btn_Elmnt.click();
	}
	
		
	public void customiseNowClick()
	{
		customise_now_btn.click();
	}
	
	public void Buy_Now_Click()
	{
		BuyNow_Btn_Elmnt.click();
	}
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
