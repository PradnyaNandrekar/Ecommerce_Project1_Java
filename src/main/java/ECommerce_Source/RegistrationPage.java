package ECommerce_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage 
{
	WebDriver driver;
	@FindBy(name="customerName")
	WebElement YourName_Elmnt;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement MobileNum_Elmnt;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement Password_Elmnt;
	
	@FindBy(name="countryCode")
	WebElement dropDown_Elmnt;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement Verify_Mob_Elmnt;
	
	public void YourName()
	{
		YourName_Elmnt.sendKeys("Pradnya");
	}
	public void CountryCode()
	{
		Select slctCode = new Select(dropDown_Elmnt);
		slctCode.selectByValue("IN");
	}
	
	public void EnterMobNum()
	{
		MobileNum_Elmnt.sendKeys("8605119718");
	}
	
	public void EnterPassword()
	{
		Password_Elmnt.sendKeys("abcdefg");
	}
	public void Verify_Mob_Click()
	{
		Verify_Mob_Elmnt.click();
	}
	
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
