package ECommerce_Source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_EmailPage extends DDT_Class
{
	WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	public WebElement UserName_Elmnt;
	
	@FindBy(id="continue")
	WebElement Continue_Btn_Elmnt;
	
	@FindBy(id="auth-error-message-box")
	public static WebElement Error_MsgBox_Elmnt;
	
	@FindBy(id="auth-email-invalid-claim-alert")
	public WebElement Email_Wrong_Alert;
	
	
	public void UserName() throws EncryptedDocumentException, IOException
	{
		UserName_Elmnt.sendKeys(mobileNum1);
	}
	public void UserName_Ymn() throws EncryptedDocumentException, IOException
	{
		UserName_Elmnt.sendKeys(mobileNum_Ymn);
	}
	public void InValid_UserName() throws EncryptedDocumentException, IOException
	{
		UserName_Elmnt.sendKeys(mobileNum1_invald);
	}
	
	public void Continue_Click()
	{
		Continue_Btn_Elmnt.click();
	}
	
	public SignIn_EmailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
