package ECommerce_TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import ECommerce_Source.Listeners_Logic;

@Listeners(ECommerce_Source.Listeners_Logic.class)
public class Browser_Launch_Quit extends Listeners_Logic
{
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod()
	public void Launch_Amazon(String Browser_Name)
	{
		if(Browser_Name.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(Browser_Name.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		if(Browser_Name.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
//	@AfterMethod()
	public void Quit_Amazon() throws InterruptedException
	{
		driver.quit();
	}
	
	

}
