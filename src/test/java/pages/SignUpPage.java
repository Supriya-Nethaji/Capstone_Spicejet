package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods {
	
	Actions act = new Actions(driver);
	
	//Constructor
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Element locators
	@FindBy(id="first_name") WebElement firstname;
	@FindBy(xpath = "(//select[contains(@class,'form-control')])[1]") WebElement Title;
	@FindBy(id = "last_name") WebElement lastname;
	@FindBy(xpath = "(//select[contains(@class,'form-control')])[2]") WebElement country;
	@FindBy(xpath = "//input[@type='tel']") WebElement mobileNumber;
	@FindBy(id = "email_id") WebElement emailId;
	@FindBy(id = "new-password") WebElement password;
	@FindBy(id = "c-password") WebElement confirmPassword;
	@FindBy(id = "dobDate") WebElement DOB;
	@FindBy(className = "react-datepicker__month-select") WebElement month;
	@FindBy(className = "react-datepicker__year-select") WebElement year;
	@FindBy(xpath = "(//div[text()='28'])[2]") WebElement date;
	@FindBy(id = "defaultCheck1") WebElement checkBox;
	@FindBy(xpath ="//button[text()='Submit']") WebElement SubmitButton;
	
	//Methods
	public SignUpPage switchWindow()
	{
		driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles(); 
		List<String> list = new ArrayList<>(handles);
		driver.switchTo().window(list.get(1));
		return this;
	}
	
	public SignUpPage selectTitle()
	{
		Select dropdown =new Select(Title);
		dropdown.selectByVisibleText("Mr");
		return this;
	}
	
	public SignUpPage enterFirstName(String fname)
	{
		firstname.sendKeys(fname);
		return this;
	}
	
	public SignUpPage enterLastName(String lname)
	{
		lastname.sendKeys(lname);
		return this;
	}
	
	public SignUpPage selectCountry()
	{
		Select dropdown =new Select(country);
		dropdown.selectByVisibleText("Iceland");
		System.out.println("Country selected");
		return this;
	}
	
	public SignUpPage enterMobileNumber(String MobNum)
	{
		Actions act = new Actions(driver);
		act.moveToElement(mobileNumber).sendKeys(MobNum).perform();
		return this;
	}
	
	public SignUpPage enterEmail(String email) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",emailId);
		emailId.sendKeys(email);
		return this;
	}
	
	public SignUpPage enterPassword(String pwd)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",password);
		password.sendKeys(pwd);
		return this;
	}
	
	public SignUpPage enterConfirmPassword(String confirmPwd)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",confirmPassword);
		confirmPassword.sendKeys(confirmPwd);
		return this;
	}
	
	public SignUpPage selectDOB()
	{
		DOB.click();
		
		Select dropdown =new Select(month);
		dropdown.selectByVisibleText("July");
		
		Select dropdown1 =new Select(year);
		dropdown1.selectByVisibleText("1995");
		
		String expectedDate="28";
		String expectedMonth="July";
		
		while(true){
			
			String actualMonth=month.getText();
			if(expectedMonth.equals(actualMonth)) {
			break;
			}else 
			{
				date.click();
			}
		}
		return this;
	}
	
	public SignUpPage selectCheckBox()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",checkBox);
		checkBox.click();
		return this;
	}
	
	public void clickSubmitButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",SubmitButton);
		SubmitButton.click();
	}
	
	
	
	
	
	
	

}
