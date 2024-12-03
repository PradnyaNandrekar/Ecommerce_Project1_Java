package ECommerce_Source;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut_Page 

{
	@FindBy(xpath="//span[.=' Another payment method']")
	public WebElement anothr_Pyment_method;

	@FindBy(partialLinkText="Change")
	public WebElement change_Addr_Elmnt;
	
	@FindBy(xpath="//a[@id='payChangeButtonId']")
	public WebElement change_paymentMode_Elmnt;
	
	@FindBy(xpath="(//input[@name='submissionURL'])[2]")
	public WebElement rdo_Btn_Addr_Elmnt;
//	"(//input[@name='submissionURL'])[2]"
//	"((//div[@class='a-box-inner'])[1]/fieldset/div)[2]"
	
	@FindBy(xpath="(//input[@class='a-button-input'])[2]")
	public WebElement Use_This_Address_btn;
//	"(//input[@class='a-button-input'])[2]"
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id-announce']")
	public WebElement dlvrThisAddr_Btn_Elmnt;
//	"//span[@id='checkout-primary-continue-button-id-announce']"
//	"//span[@id='shipToThisAddressButton']"
	@FindBy(xpath="//span[@class='a-expander-prompt']")
	public WebElement Promo_Expander;
	
	@FindBy(xpath="//input[@value='SelectableAddCreditCard']")
	WebElement CreditDebitCard_Elmnt;
	
	@FindBy(xpath="(//div[@class='a-radio a-spacing-top-mini'])")
	WebElement NetBanking_Elmnt;
	
	@FindBy(xpath="((//div[@class='a-radio']))[3]")
	WebElement Other_UPI_Apps_Elmnt;
		
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[5]")
	public WebElement cashOnDlvry_Elmnt;
	
	@FindBy(name="ppw-bankSelection_dropdown")
	WebElement SelectBankDropDown_Options;
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id']/span")
	public WebElement UseThisPayment_Btn_Elmnt;
	
	@FindBy(xpath="(//input[@name='placeYourOrder1'])[1]")
	public WebElement place_Ur_order_btn;
	
	
	@FindBy(xpath="//div[@ID='spc-orders']")
	public WebElement Review_items;
	
	@FindBy(xpath="//input[@name='ppw-claimCode']")
	public WebElement Promotion_code_Elmnt;
	
	@FindBy(xpath="(//div[@class='a-alert-content']/p)[2]")
	public WebElement Promo_Code_Error;
	
	@FindBy(xpath="//div[@class='a-popover-wrapper']")
	public WebElement PopOverWrapUp;
	
	@FindBy(xpath="//span[@class='a-declarative']/div/a")
	WebElement entr_CardDetails_link;
	
	@FindBy(xpath="//iFrame[@name='ApxSecureIframe']")
	WebElement debt_Crdt_Card_iFrame1;
	
	@FindBy(xpath="//iframe[@name='apx-secure-field-addCreditCardVerificationNumber']")
	WebElement debt_Crdt_Card_iFrame2;
	
	@FindBy(xpath="//div[@class='securefield']/input[@class='card-cvv']")
	WebElement debt_Crdt_Card_CVV;
	
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement debt_Crd_num;
	
	@FindBy(name="ppw-expirationDate_month")
	WebElement debt_Crd_ExpMnth;
	
	@FindBy(name="ppw-expirationDate_year")
	WebElement debt_Crd_ExpYear;
	
	@FindBy(name="ppw-widgetEvent:AddCreditCardEvent")
	WebElement debt_Crd_EntrBtn;
	
	@FindBy(xpath="//div[@class='securefield']/input[@class='card-cvv']")
	WebElement debt_Crd_CVV_TextBox;
	
	@FindBy(xpath="//input[@class='a-input-text a-form-normal no-prefetch-on-change']")
	WebElement UPI_ID_txtBox;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")
	WebElement verify_UPI;
		
	@FindBy(xpath="(//input[@name='placeYourOrder1'])[1]")
	public WebElement place_Ur_Order_Btn;
	
	@FindBy(xpath="//span[@id='prime-interstitial-nothanks-button']")
	public WebElement prime_msg_dismiss;
	
	public void changeAddress()
	{
		change_Addr_Elmnt.click();
	}
	public void UseThisAddress()
	{
		Use_This_Address_btn.click();
	}
	
	public void Click_PopOverWrapUp()
	{
		PopOverWrapUp.click();
	}
	
	public void Promo_Expand()
	{
		Promo_Expander.click();
	} 
	public void Enter_Promo_Code()
	{
		Promotion_code_Elmnt.sendKeys("12345"+Keys.ENTER);
	}
	
	public void useThisPayment()
	{
		UseThisPayment_Btn_Elmnt.click();
	}
	
	public void changePaymentMode()
	{
		change_paymentMode_Elmnt.click();
	} 
	
	public void DlvrToThisAddress()
	{
		dlvrThisAddr_Btn_Elmnt.click();
	}
	public void PayMentMode_NetBanking()
	{
		NetBanking_Elmnt.click();
	}
	
	public void PayMentMode_CreditDebitCard()
	{
		CreditDebitCard_Elmnt.click();
	}
	public void Enter_DebitCardDetails_And_CVV(WebDriver driver)
	{
		entr_CardDetails_link.click();
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(debt_Crdt_Card_iFrame1));
		try
		{
			debt_Crd_num.sendKeys("4160211505305772");
			Select slct1 = new Select(debt_Crd_ExpMnth);
			slct1.selectByValue("12");
			Select slct2 = new Select(debt_Crd_ExpYear);
			slct2.selectByValue("2024");
			debt_Crd_EntrBtn.click();
		}
		
		finally
		{
			driver.switchTo().defaultContent();
			// Enter CVV
			WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			w2.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(debt_Crdt_Card_iFrame2));
			try
			{
				debt_Crd_CVV_TextBox.sendKeys("250");
			}
			catch (NoSuchElementException ex)
			{
				System.out.println("CVV text Box not found");
			}
			finally
			{
				driver.switchTo().defaultContent();
			}
		}
	}
	
	
	public void SelectBank_NetBanking()
	{
		Select slctBank = new Select(SelectBankDropDown_Options);
		slctBank.selectByVisibleText("ICICI Bank");
	}
	
	public void dismiss_PrimeMsg()
	{
		prime_msg_dismiss.click();
	}
	
	public void OtherUPIApps_Payment()
	{
		Other_UPI_Apps_Elmnt.click();
		UPI_ID_txtBox.sendKeys("chougule.pradnya76@okicici");
		verify_UPI.click();
	}
	
	public void selectAddress()
	{
			rdo_Btn_Addr_Elmnt.click();
	}
	
	public void CashOnDelivery() 
	{
		cashOnDlvry_Elmnt.click();
	}
	
	public CheckOut_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
}
