package ECommerce_Source;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement Ac_And_List_Elmnt;
	
	@FindBy(xpath="(//a[.='Start here.'])[1]")
	WebElement startHere_Elmnt;
	
	@FindBy(xpath="(//a[.='Sign in'])[1]")
	WebElement Sign_In_Elmnt;
	
	@FindBy(id="nav-cart-count-container")
	WebElement cart_Elmnt;
	
	@FindBy(id="nav-cart-count")
	WebElement cart_Count_Elmnt;
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement SearchBox_Elmnt;

	public void acAndList(WebDriver driver)
	{
		Actions a1 = new Actions(driver);
		a1.moveToElement(Ac_And_List_Elmnt).perform();
	}
	public void startHere_Click()
	{
		startHere_Elmnt.click();
	}
	public void Sign_In()
	{
		Sign_In_Elmnt.click();
	}
	
	public void searchProd()
	{
		SearchBox_Elmnt.sendKeys("Pen"+ Keys.ENTER);
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
