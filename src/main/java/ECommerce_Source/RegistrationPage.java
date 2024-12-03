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
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends DDT_Class
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
	
	@FindBy(xpath="(//div[@class='a-box-inner a-alert-container']/div)[1]")
	public WebElement oldUser_Alert;
	
	public void YourName() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String name = wb1.getSheet("LoginDetails").getRow(1).getCell(2).getStringCellValue();
	
		YourName_Elmnt.sendKeys(name);
	}
	public void CountryCode()
	{
		Select slctCode = new Select(dropDown_Elmnt);
		slctCode.selectByValue("IN");
	}
	
	public void EnterMobNum() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String mobileNum = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(1).getCell(0).getNumericCellValue()));
		MobileNum_Elmnt.sendKeys(mobileNum);
//		MobileNum_Elmnt.sendKeys(getMobileNum1());
		
	}
	
	public void EnterPassword() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String password = wb1.getSheet("LoginDetails").getRow(1).getCell(1).getStringCellValue();
		Password_Elmnt.sendKeys(password);
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
