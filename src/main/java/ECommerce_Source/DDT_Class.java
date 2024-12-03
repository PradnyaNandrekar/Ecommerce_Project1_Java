package ECommerce_Source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DDT_Class 
{
	public static String mobileNum1, password1, mobileNum1_invald, password1_invld, SearchProd_Shoe, SearchProd_Pen, mobileNum_Ymn, password_Ymn;
	public void UserName() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
			mobileNum1 = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(1).getCell(0).getNumericCellValue()));
			 password1 = wb1.getSheet("LoginDetails").getRow(1).getCell(1).getStringCellValue();
			 mobileNum1_invald = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(2).getCell(0).getNumericCellValue()));
			 password1_invld = wb1.getSheet("LoginDetails").getRow(2).getCell(1).getStringCellValue();
			 mobileNum_Ymn = NumberToTextConverter.toText((wb1.getSheet("LoginDetails").getRow(3).getCell(0).getNumericCellValue()));
			 password_Ymn = NumberToTextConverter.toText(wb1.getSheet("LoginDetails").getRow(3).getCell(1).getNumericCellValue());
			 	
	}	
	
	public void SerachProduct() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\nandr\\eclipse-workspace\\ExcelDataSheet\\AmazonLoginData.xlsx");
		Workbook wb1 = WorkbookFactory.create(f1);
		SearchProd_Shoe = wb1.getSheet("SearchProducts_List").getRow(1).getCell(0).getStringCellValue();
		SearchProd_Pen = wb1.getSheet("SearchProducts_List").getRow(2).getCell(0).getStringCellValue();
		 
	}	
	
}
