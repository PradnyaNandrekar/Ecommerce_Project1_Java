package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YourOrdersPage 
{
	WebDriver driver;
	@FindBy(id="time-filter")
	WebElement oders_Time_Filter;
	
	@FindBy(xpath="(//a[contains(text(),'Write a product review')])[1]")
	public WebElement Wrt_Prod_Review_btn;

	@FindBy(xpath="(//div[@class='a-section a-spacing-top-micro']/button)[5]")
	public WebElement Fith_Star_Elmnt;
	
	@FindBy(xpath="(//span[.='Submitted'])[2]")
	public WebElement Review_Submission_Alert;
	
	@FindBy(xpath="(//span[.='Clear'])[2]")
	public WebElement clear_Review_Btn;
	
	
	public void Select_Time_Filter()
	{
		Select s1 = new Select(oders_Time_Filter);
		s1.selectByValue("year-2024");
	}
	
	public void Wrt_Prod_review()
	{
		Wrt_Prod_Review_btn.click();
	}
	
	public void Apply_fiveStar()
	{
		Fith_Star_Elmnt.click();
	}
	
	public void Clear_Review()
	{
		clear_Review_Btn.click();
	}
	
	public YourOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
