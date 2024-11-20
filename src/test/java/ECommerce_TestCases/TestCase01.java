package ECommerce_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ECommerce_Source.HomePage;
import ECommerce_Source.RegistrationPage;

//@Listeners(ECommerce_TestCases.Listerners_Logic.class)
public class TestCase01 extends Browser_Launch_Quit
{
	@Test
	public void User_Registration_Test()
	{
		
		HomePage hmPg = new HomePage(driver);
		hmPg.acAndList(driver);
		hmPg.startHere_Click();
		
		RegistrationPage RgPg = new RegistrationPage(driver);
		RgPg.YourName();
		RgPg.CountryCode();
		RgPg.EnterMobNum();
		RgPg.EnterPassword();
		RgPg.Verify_Mob_Click();
		
	}
}
