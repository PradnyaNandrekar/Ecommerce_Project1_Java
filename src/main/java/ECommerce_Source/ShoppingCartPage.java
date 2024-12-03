package ECommerce_Source;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage 
{
	@FindBy(id="sc-subtotal-label-activecart")
	public WebElement Subtotal_Elmnt;
	
	@FindBy(xpath="(//div[@class='a-declarative'])[2]")
	public	WebElement cnt_elmnt;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-add']")
	WebElement increse_Qty_Btn;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-remove']")
	WebElement decrease_Qty_Btn;
	
	@FindBy(xpath="(//span[@class='a-declarative']/input)[1]")
	public WebElement delete_btn;
	
	@FindBy(xpath="//span[@class='sc-quantity-stepper']")
	public List<WebElement> Qty_Stepper_Elmnt;

	@FindBy(xpath="//div[@class='a-row sc-cart-header']/div/h2")
	public WebElement emptyCartTxt;
	
	@FindBy(name="proceedToRetailCheckout")
	WebElement procd_Buy_Btn;

/*		public void GetSubTotal()
	{
		String subTotalText = Subtotal_Elmnt.getText(); //Subtotal (2 items):
		String SubTotal_Count = subTotalText.substring(10, (subTotalText.length()-8));		
		int ItemsCount = Integer.parseInt(SubTotal_Count);
		System.out.println(SubTotal_Count);
	
		int int_cnt = Integer.parseInt(cnt_elmnt.getText());
		System.out.println(int_cnt);
		if(int_cnt==1)
		{
			System.out.println("Pass");
		}
		
	}
*/

	public void addQty(WebDriver driver) throws InterruptedException
	{
		for(int i=0; i<3; i++)
		{
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w1.until(ExpectedConditions.visibilityOf(cnt_elmnt));
			increse_Qty_Btn.click();
			Thread.sleep(1000);
		}
	}
	
	public void removeQty() throws InterruptedException
	{
		for(int i=0; i<2; i++)
		{
			decrease_Qty_Btn.click();
			Thread.sleep(1000);
		}
	}
	
	public void deleteProd()
	{
		delete_btn.click();
	}
	
	public void Check_Qty_Stepper()
	{
		System.out.println(Qty_Stepper_Elmnt.size());
	} 
	public void Procd_To_Buy()
	{
		procd_Buy_Btn.click();
	}
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
