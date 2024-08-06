package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class PassengerInfoPage extends ProjectSpecificationMethods {
	
	//Constructor
	public PassengerInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Element locators
	@FindBy(xpath= "//div[text()='I am flying as the primary passenger']") WebElement primaryPassenger;
	@FindBy(xpath = "(//div[contains(@class,'r-1777fci r-6ity3w')])[2]") WebElement continueButton1;
	
	//Methods
	public PassengerInfoPage clickprimaryPassenger()
	{
		primaryPassenger.click();
		return this;
	}
	
	public AddOnsPage clickContinueButton1()
	{
		continueButton1.click();
		return new AddOnsPage(driver);
	}
}
