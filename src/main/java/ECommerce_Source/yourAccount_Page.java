package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class yourAccount_Page 
{
	@FindBy(xpath="(//h2[@class='a-spacing-none ya-card__heading--rich a-text-normal'])[2]")
	WebElement Login_Security_Elmnt;
	
	
	public void Login_Security()
	{
		Login_Security_Elmnt.click();
	}
	public yourAccount_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
