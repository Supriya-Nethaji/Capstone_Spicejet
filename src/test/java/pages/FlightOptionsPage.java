package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class FlightOptionsPage extends ProjectSpecificationMethods {
	
	//Constructor
	public FlightOptionsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Element locators
	@FindBy(xpath = "//div[contains(@class,' r-1777fci r-1w50u8q r-ah5dr5')]") WebElement continueButton;
	
	
	//Methods
	public PassengerInfoPage clickContinueButton()
	{
		continueButton.click();
		return new PassengerInfoPage(driver);
	}
	
	

}
