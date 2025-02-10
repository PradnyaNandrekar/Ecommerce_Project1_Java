package ECommerce_Source;


import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends DDT_Class
{
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement Ac_And_List_Elmnt;
	
	@FindBy(xpath="(//a[.='Start here.'])[1]")
	WebElement startHere_Elmnt;
	
	@FindBy(xpath="(//a[.='Sign in'])[1]")
	WebElement Sign_In_Elmnt;
	
	@FindBy(xpath="//a[@id='nav-item-signout']")
	WebElement Sign_Out_Elmnt;
	
	@FindBy(id="nav-cart-count-container")
	WebElement cart_Elmnt;
	
	@FindBy(id="nav-cart-count")
	WebElement cart_Count_Elmnt;
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement SearchBox_Elmnt;
	
	@FindBy(xpath="(//span[@id='selectProfileModalId']/div/div/div)[2]")
	WebElement mng_Profile_Elmnt;
	
	@FindBy(xpath="//div[@class='sc-hmdomO qqYTW']/a[.='View']")
	public WebElement View_btn;
	
	@FindBy(xpath="//div[@id='a-popover-2']")
	public WebElement profile_Alert;
	
	@FindBy(xpath="//span[.='Your Account']")
	WebElement yourAccount_Elmnt;
//	
//	(//div[@id='nav-al-your-account']/a/span)[1]
	
	@FindBy(xpath="//a[.='Your Orders']")
	WebElement yourOrder_Elmnt;

	public void acAndList(WebDriver driver)
	{
		
		Actions a1 = new Actions(driver);
		a1.moveToElement(Ac_And_List_Elmnt).perform();
	}
	public void startHere_Click(WebDriver driver)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOf(startHere_Elmnt));
		startHere_Elmnt.click();
	}
	public void yourAccount_Click()
	{
		yourAccount_Elmnt.click();
	}
	public void yourOrder_Click()
	{
		yourOrder_Elmnt.click();
	}
	public void manageProfile()
	{
		mng_Profile_Elmnt.click();
	}
	public void Sign_In()
	{
		try
		{
			Sign_In_Elmnt.click();
		}
		catch(ElementClickInterceptedException e)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Sign_In_Elmnt);
		}
	}
	
	public void Sign_Out()
	{
		Sign_Out_Elmnt.click();
	}
	
	public void View_mngProfile()
	{
//		Actions a1 = new Actions(driver);
//		a1.doubleClick(View_btn).perform();
		View_btn.click();
	}
	
	public void searchProd_shoe()
	{
		SearchBox_Elmnt.sendKeys(SearchProd_Shoe+ Keys.ENTER);
	}
	
	public void searchProd_pen()
	{
		SearchBox_Elmnt.sendKeys(SearchProd_Pen+ Keys.ENTER);
	}
	
	public void ClickCart()
	{
		cart_Elmnt.click();
	}
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
