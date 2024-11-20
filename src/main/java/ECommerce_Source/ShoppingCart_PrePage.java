package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_PrePage 
{
	@FindBy(xpath="//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/h1")
	public WebElement AddCart_success_Elmnt;
	
	@FindBy(xpath="//span[@id='sw-gtc']")
	WebElement Go_ToCart_btn_Elmnt;
	
	public void GoToCart()
	{
		Go_ToCart_btn_Elmnt.click();
	}
	
	public ShoppingCart_PrePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
