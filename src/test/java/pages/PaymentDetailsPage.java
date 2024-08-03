package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethods;

public class PaymentDetailsPage extends ProjectSpecificationMethods{
	
	SoftAssert sassert = new SoftAssert();
	
	public PaymentDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "card_number_iframe") WebElement cardNumFrame;
	@FindBy(className = "name_on_card_iframe") WebElement cardNameFrame;
	@FindBy(className = "card_exp_month_iframe") WebElement expMonthFrame;
	@FindBy(className = "card_exp_year_iframe") WebElement expYearFrame;
	@FindBy(className = "security_code_iframe") WebElement cvvFrame;
	@FindBy(id = "card_number") WebElement cardNumber;
	@FindBy(id = "name_on_card") WebElement cardName; 
	@FindBy(id = "card_exp_month") WebElement expMonth;
	@FindBy(id = "card_exp_year") WebElement expYear;
	@FindBy(id = "security_code") WebElement cvv;
	@FindBy(xpath = "//div[text()='Proceed to pay']") WebElement PayButton;
	@FindBy(xpath = "//div[text()='Payment Failure']") WebElement PaymentConfirmMessage;
	@FindBy(id = "payment_form_card_number_error") WebElement CardErrorMessage;
	@FindBy(id = "payment_form_card_name_error") WebElement nameErrorMessage;
	@FindBy(id = "payment_form_card_expiry_error") WebElement expiryErrorMessage;
	
	
	public PaymentDetailsPage enterCardNumber(String cardNum)
	{
		driver.switchTo().frame(cardNumFrame);
		cardNumber.sendKeys(cardNum);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public PaymentDetailsPage enterCardName(String name)
	{
		driver.switchTo().frame(cardNameFrame);
		cardName.sendKeys(name);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public PaymentDetailsPage enterExpMonth(String month)
	{
		driver.switchTo().frame(expMonthFrame);
		expMonth.sendKeys(month);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public PaymentDetailsPage enterExpYear(String year)
	{
		driver.switchTo().frame(expYearFrame);
		expYear.sendKeys(year);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public PaymentDetailsPage enterSecurityCode(String code)
	{
		driver.switchTo().frame(cvvFrame);
		cvv.sendKeys(code);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public PaymentDetailsPage ClickPayButton(String type)
	{
		Actions act = new Actions(driver);
		act.moveToElement(PayButton).click().perform();
		
		if(type.equalsIgnoreCase("valid"))
		{
			String expected = "Payment Failure";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(PaymentConfirmMessage));
			String actual = PaymentConfirmMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidCard"))
		{
			String expected = "Please enter a valid card";
			String actual = CardErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidName"))
		{
			String expected = "Please enter name";
			String actual = nameErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidYear"))
		{
			String expected = "Invalid expiry";
			String actual = expiryErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		} 
		return this;
	}
	
	public PaymentDetailsPage clickRoundTripPayButton(String type)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", PayButton);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(PayButton));
		
		Actions act = new Actions(driver);
		act.moveToElement(PayButton).click().perform();
		
		if(type.equalsIgnoreCase("valid"))
		{
			String expected = "Payment Failure";
			wait.until(ExpectedConditions.visibilityOf(PaymentConfirmMessage));
			String actual = PaymentConfirmMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidCard"))
		{
			String expected = "Please enter a valid card";
			String actual = CardErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidName"))
		{
			String expected = "Please enter name";
			String actual = nameErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalidYear"))
		{
			String expected = "Invalid expiry";
			String actual = expiryErrorMessage.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		} 
		return this;
	}
	

}
