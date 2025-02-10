package ECommerce_Source;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut_Page extends DDT_Class

{
	@FindBy(xpath="//span[.=' Another payment method']")
	public WebElement anothr_Pyment_method;

	@FindBy(xpath="//div[@id='checkout-deliveryAddressPanel']/div/div[2]/span")
	public WebElement change_Addr_Elmnt;
//	"//a[@id='addressChangeLinkId']"
//	partialLinkText="Change"
	
	@FindBy(xpath="//a[@id='payChangeButtonId']")
	public WebElement change_paymentMode_Elmnt;
//	//a[@aria-label='Change payment method']
//	//a[@id='payChangeButtonId']
	
	@FindBy(xpath="//div[@class='a-box-inner']/fieldset/div[2]")
	public WebElement rdo_Btn_Addr_Elmnt;
//	"(//input[@name='submissionURL'])[2]"
//	"((//div[@class='a-box-inner'])[1]/fieldset/div)[2]"
//	"//div[@class='a-box-inner']/fieldset/div[2]"
	//"//div[@id='shipping-address-selection-panel']/fieldset/div[2]/div[2]/span/div/label/i"
//	(//div[@class='a-radio a-radio-fancy']/label/i)[2]
	
	@FindBy(xpath="(//div[@class='a-radio a-radio-fancy']/label/i)[2]")
	public WebElement rdo_Btn_Addr_Elmnt1;
	
	@FindBy(xpath="//span[@id='shipToThisAddressButton']")
	public WebElement Use_This_Address_btn;
	
	@FindBy(xpath="(//span[contains(text(), 'Deliver to this address')])[2]")
	public WebElement Use_This_Address_btn1;
	
//	"(//input[@class='a-button-input'])[2]"
//	"//span[@id='shipToThisAddressButton']"
//	(//span[contains(text(), 'Deliver to this address')])[2]
//	(//span[contains(text(),'Use this address')])[1]
	
	
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
	
	@FindBy(xpath="((//div[@class='a-fixed-left-grid-col a-col-left'])/div/label/input)[1]")
	WebElement Other_UPI_Apps_Elmnt;
//	"((//div[@class='a-fixed-left-grid-col a-col-left'])/div/label/input)[1]"
//	"((//div[@class='a-radio']))[3]"
	
	@FindBy(xpath="((//div[@class='a-fixed-left-grid-col a-col-left'])/div/label/input)[2]")
	public WebElement cashOnDlvry_Elmnt;

//	"(//input[@name='ppw-instrumentRowSelection'])[5]"
	
	@FindBy(name="ppw-bankSelection_dropdown")
	WebElement SelectBankDropDown_Options;
	
	@FindBy(xpath="(//span/span[.='Use this payment method'])[3]")
	public WebElement UseThisPayment_Btn_Elmnt;
	// "(//span/span[.='Use this payment method'])[3]"
	
	@FindBy(xpath="(//span[contains(text(),'Use this payment method')])[2]")
	public WebElement UseThisPayment_Btn2_Elmnt;
	//"//span[@id='checkout-primary-continue-button-id']/span"
//	(//span[contains(text(),'Use this payment method')])[2]
	
	@FindBy(xpath="//span[@id='submitOrderButtonId-announce']")
	public WebElement place_Ur_order_btn;
//	"//span[@id='submitOrderButtonId-announce']"
//	"(//input[@name='placeYourOrder1'])[1]"
	@FindBy(xpath="//div[@id='checkout-item-block-0']")
	public WebElement Review_items;
//	  "//div[@id='checkout-item-block-0']"
//	"//div[@ID='spc-orders']"
	
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
	
	@FindBy(xpath="//a[contains(text(),'No Thanks')]")
	public WebElement prime_msg_dismiss;
	
	@FindBy(xpath="//DIV[@ID='checkout-item-block-panel']")
	public WebElement reviewProd;
//	
	
	public void changeAddress(WebDriver driver)
	{
		try
		{
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
			w1.until(ExpectedConditions.visibilityOf(change_Addr_Elmnt));
			change_Addr_Elmnt.click();
		}
		catch(TimeoutException ex)
		{
			
		}
		
	}
	public void UseThisAddress(WebDriver driver)
	{
		try
		{
			Use_This_Address_btn.click();
		}
		catch(ElementClickInterceptedException e)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Use_This_Address_btn);
		}
		catch(NoSuchElementException e1)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Use_This_Address_btn1);
		}
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
	
	public void useThisPayment(WebDriver driver)
	{
		try
		{
			UseThisPayment_Btn_Elmnt.click();
		}
		catch(ElementClickInterceptedException ex2)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", UseThisPayment_Btn_Elmnt);
//			UseThisPayment_Btn_Elmnt.click();
		}
		catch(NoSuchElementException ex3)
		{
			try
			{
			UseThisPayment_Btn2_Elmnt.click();
			}
			catch(ElementClickInterceptedException e)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", UseThisPayment_Btn2_Elmnt);
			}
		}
	}
	
	public void changePaymentMode(WebDriver driver)
	{
		try
		{
			change_paymentMode_Elmnt.click();
		}
		catch(ElementClickInterceptedException e)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", change_paymentMode_Elmnt);
		}
		catch(NoSuchElementException e2)
		{
			System.out.println("NoSuchElementException handled");
		}
		
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
			debt_Crd_num.sendKeys(CardNumber);
			Select slct1 = new Select(debt_Crd_ExpMnth);
			slct1.selectByValue("12");
			Select slct2 = new Select(debt_Crd_ExpYear);
			slct2.selectByValue("2025");
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
				debt_Crd_CVV_TextBox.sendKeys(cvv);
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
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", prime_msg_dismiss);

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
		try
		{
			rdo_Btn_Addr_Elmnt.click();
		}
		catch(NoSuchElementException et)
		{
			rdo_Btn_Addr_Elmnt1.click();
		}
		
	}
	
	public void CashOnDelivery() 
	{
		try
		{
			cashOnDlvry_Elmnt.click();
		}
		catch(ElementClickInterceptedException ex)
		{
			cashOnDlvry_Elmnt.click();
			System.out.println("ElementClickInterceptedException ------- handled");
		}
	}
	
	public CheckOut_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
}
