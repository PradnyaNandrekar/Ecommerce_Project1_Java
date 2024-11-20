package ECommerce_Source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DDT_Class 
{
	private String mobileNum1, password1;
	public void UserName() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		String mobileNum = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(1).getCell(0).getNumericCellValue()));
		String password = wb1.getSheet("LoginDetails").getRow(1).getCell(1).getStringCellValue();
		
		this.mobileNum1 = mobileNum;
		this.password1=password;
	}
	public String getMobileNum1() 
	{
		return mobileNum1 ;
	}
	public String getPassword1() 
	{
		return password1;
	}
	
	
	
	
	
	
}
