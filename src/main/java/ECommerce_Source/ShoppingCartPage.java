package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage 
{
	@FindBy(id="sc-subtotal-label-activecart")
	public WebElement Subtotal_Elmnt;
	
	@FindBy(xpath="(//div[@class='a-declarative'])[2]")
	WebElement cnt_elmnt;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-add']")
	WebElement increse_Qty_Btn;
	
	@FindBy(xpath="(//button[@class='a-declarative']/span)[1]")
	
	WebElement decrease_Qty_Btn;
	@FindBy(xpath="(//span[@class='a-declarative']/input)[1]")
	public WebElement delete_btn;

	@FindBy(xpath="//div[@class='a-row sc-cart-header']/div/h2")
	public WebElement emptyCartTxt;
	/*
		public void GetSubTotal()
	{
//		String subTotalText = Subtotal_Elmnt.getText(); //Subtotal (2 items):
//		String SubTotal_Count = subTotalText.substring(10, (subTotalText.length()-8));		
//		int ItemsCount = Integer.parseInt(SubTotal_Count);
//		System.out.println(SubTotal_Count);
	
		int int_cnt = Integer.parseInt(cnt_elmnt.getText());
		System.out.println(int_cnt);
		if(int_cnt==1)
		{
			System.out.println("Pass");
		}
		
	}
	*/
	public void addQty()
	{
		increse_Qty_Btn.click();
	}
	
	public void removeQty()
	{
		decrease_Qty_Btn.click();
	}
	
	public void deleteProd()
	{
		delete_btn.click();
	}
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
