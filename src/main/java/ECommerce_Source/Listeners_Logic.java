package ECommerce_Source;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners_Logic implements ITestListener
{
	public static WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		Reporter.log("Test Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Passed successfuly");
			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);	
		Reporter.log("TestCase Failed");
		Date d1 = new Date();	// epoch time format
		Date p_Date = new Date(d1.getTime());
		String saveDate = p_Date.toString();
		String get_CurrentDateTime = saveDate.substring(saveDate.length()-4).concat("_").concat(saveDate.substring(4, 19));
		String CurrentDateTime_1 = get_CurrentDateTime.replace(":", "");
		String FinalDateTime = CurrentDateTime_1.replace(" ", "_"); ////2024_Oct_14_211438
				
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\nandr\\eclipse-workspace\\Ecommerce\\ScreenShots_Project1\\Fail_"+result.getMethod().getMethodName()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
}

