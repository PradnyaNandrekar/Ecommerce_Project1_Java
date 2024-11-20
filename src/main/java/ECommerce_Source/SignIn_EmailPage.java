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
	@FindBy(id="ap_email")
	public static WebElement UserName_Elmnt;
	
	@FindBy(id="continue")
	WebElement Continue_Btn_Elmnt;
	
	@FindBy(id="auth-error-message-box")
	public static WebElement Error_MsgBox_Elmnt;
	
	public void UserName() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String mobileNum = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(1).getCell(0).getNumericCellValue()));
//		SignIn_EmailPage dt = new SignIn_EmailPage(driver);
//		System.out.println(getMobileNum1());
		UserName_Elmnt.sendKeys(mobileNum);
	}
	public void InValid_UserName() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String mobileNum = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(2).getCell(0).getNumericCellValue()));
		UserName_Elmnt.sendKeys(mobileNum);
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
