package ECommerce_Source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_PasswordPage extends DDT_Class
{
	@FindBy(id="ap_password")
	public WebElement Password_Elmnt;
	
	@FindBy(id="signInSubmit")
	WebElement SignIn_Submit_Elmnt;
	
	@FindBy(id="auth-error-message-box")
	public static WebElement Error_MsgBox_Elmnt;
	
	@FindBy(id="auth-password-missing-alert")
	public static WebElement PW_MissingAlert_Elmnt;
	
	public void Enter_Password() throws EncryptedDocumentException, IOException
	{
		Password_Elmnt.sendKeys(password1);
	}
	public void Enter_Password_Ymn() throws EncryptedDocumentException, IOException
	{
		Password_Elmnt.sendKeys(password_Ymn);
	}
	public void Enter_Invalid_Password() throws EncryptedDocumentException, IOException
	{
		Password_Elmnt.sendKeys(password1_invld);
	}
	public void SignIn_Submit()
	{
		SignIn_Submit_Elmnt.click();
	}
	
	
	public SignIn_PasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
