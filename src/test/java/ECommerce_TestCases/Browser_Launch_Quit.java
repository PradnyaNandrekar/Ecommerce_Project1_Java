package ECommerce_TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//@Listeners(ECommerce_Source.Listeners_Logic.class)
public class Browser_Launch_Quit 
{
	WebDriver driver;
	
	@BeforeMethod()
	public void Launch_Amazon()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod()
	public void Quit_Amazon() throws InterruptedException
	{
		driver.quit();
	}
	
	

}
