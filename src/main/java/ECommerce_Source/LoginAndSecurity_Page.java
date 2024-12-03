package ECommerce_Source;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndSecurity_Page extends DDT_Class
{
	@FindBy(id="NAME_BUTTON")
	WebElement nameEdit_Elmnt;
	
	@FindBy(id="PASSWORD_BUTTON")
	WebElement PasswordEdit_Elmnt;
	
	@FindBy(id="ap_password")
	WebElement Current_Password;
	
	@FindBy(id="ap_password_new")
	WebElement New_Password;
	
	@FindBy(id="ap_password_new_check")
	WebElement ReenterNew_Password;
	
	@FindBy(xpath="//input[@id='cnep_1D_submit_button']")
	WebElement SaveChanges_password;
	
	@FindBy(id="ap_customer_name")
	WebElement Custmr_Name_Elmnt;
	
	@FindBy(xpath="//div[@id='SUCCESS_MESSAGES']")
	public WebElement successAlert;
	
	public void EditBtn_Name()
	{
		nameEdit_Elmnt.click();
	}
	public void SaveChanges()
	{
		SaveChanges_password.click();
	}
	
	public void EditBtn_Password()
	{
		PasswordEdit_Elmnt.click();
	}
	public void Enter_Old_Password()
	{
		Current_Password.sendKeys(password1);
	}
	
	public void Enter_New_Password()
	{
		New_Password.sendKeys(password1);
	}
	public void Re_Enter_New_Password()
	{
		ReenterNew_Password.sendKeys(password1);
	}
	public void Enter_Name()
	{
		Custmr_Name_Elmnt.clear();
		Custmr_Name_Elmnt.sendKeys("Pradnya Nandrekar"+Keys.ENTER);
	}
	
	
	public LoginAndSecurity_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
