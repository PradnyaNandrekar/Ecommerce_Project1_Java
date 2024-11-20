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

public class SignIn_PasswordPage 
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
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String password = wb1.getSheet("LoginDetails").getRow(1).getCell(1).getStringCellValue();
			
		Password_Elmnt.sendKeys(password);
	}
	public void Enter_Invalid_Password() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String password = wb1.getSheet("LoginDetails").getRow(2).getCell(1).getStringCellValue();
			
		Password_Elmnt.sendKeys(password);
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
