package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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

public class HomePage extends ProjectSpecificationMethods {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	SoftAssert sassert = new SoftAssert();
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Signup']") WebElement SignUp;
	@FindBy(xpath = "//div[text()='Login']") WebElement Login;
	@FindBy(xpath = "(//input[@type='number'])[1]") WebElement LoginMobileNumber;
	@FindBy(xpath = "//input[@type='password']") WebElement LoginPassword;
	@FindBy(xpath = "//div[@data-testid='login-cta']") WebElement LoginButton;
	@FindBy(xpath= "//div[text()='Please enter a valid mobile number']") WebElement mobileError;
	@FindBy(xpath = "//div[text()='Invalid Username/Password']") WebElement InvalidUser;
	@FindBy(xpath = "//div[text()='S']") WebElement AfterLoginIcon;
	@FindBy(xpath = "//div[text()='From']") WebElement FromLocation;
	@FindBy(xpath = "//div[text()='Delhi']") WebElement Delhi;
	@FindBy(xpath = "//div[text()='Goa']") WebElement Goa;
	@FindBy(xpath = "//div[contains(@class,'r-homxoj r-adyw6z')]") WebElement ActualMonth;
	@FindBy(xpath = "(//div[contains(@class,'r-1v2oles r-1otgn73 r-16zfatd')])[1]") WebElement Next;
	@FindBy(xpath = "(//div[text()='5'])[2]") WebElement expectedDateElement;
	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']") WebElement SearchFlightButton;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]") WebElement RoundTripRadioButton;
	@FindBy(xpath = "(//div[text()='20'])[3]") WebElement RoundTripReturnDate;
	@FindBy(xpath = "//div[text()='check-in']") WebElement checkIn;
	@FindBy(xpath = "(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]") WebElement TicketNumber;
	@FindBy(xpath = "(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[2]") WebElement Email;
	@FindBy(xpath = "//div[contains(@class,'r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q')]") WebElement SearchBooking;
	@FindBy(xpath = "(//div[contains(@class,'css-76zvg2 css-cens5h')])[6]")WebElement CheckinMesssage;
	@FindBy(xpath = "//div[text()='Invalid PNR or Ticket Number']") WebElement InvalidTicketMsg;
	@FindBy(xpath = "//div[text()='Invalid Email']") WebElement InvalidEmailMsg;
	@FindBy(xpath = "//div[text()='flight status']") WebElement FlightStatus;
	@FindBy(xpath = "//div[contains(@class,' r-1loqt21 r-18u37iz r-1777fci r-1w50u8q')]") WebElement FlightStatusSearchFlight;
	@FindBy(xpath = "//div[@data-testid='manage booking-horizontal-nav-tabs']") WebElement ManageBookings;
	@FindBy(xpath = "//div[text()='You don’t have any upcoming trips']") WebElement NoTripMsg;
	@FindBy(xpath = "//div[contains(@class,'r-rs99b7 r-1loqt21 r-18u37iz r-1777fci r-15d164r')]") WebElement AddYourItenary;
	@FindBy(xpath = "//div[contains(@class,'r-rs99b7 r-1loqt21 r-18u37iz r-1777fci')]") WebElement ViewUpcomingTrips;
	@FindBy(xpath = "(//div[contains(@class,'r-1loqt21 r-18u37iz r-1777fci r-1w50u8q')])[2]") WebElement ViewChangeAssist;
	
	
	public SignUpPage clickSignUp()
	{
		SignUp.click();
		return new SignUpPage(driver);
	}
	
	public HomePage clickLogin()
	{
		wait.until(ExpectedConditions.visibilityOf(Login));
		Login.click();
		return this;
	}
	
	public HomePage enterMobileNumber(String mobNum)
	{
		LoginMobileNumber.sendKeys(mobNum);
		return this;
	}
	
	public HomePage enterPassword(String pwd)
	{
		LoginPassword.sendKeys(pwd);
		return this;
	}
	
	public HomePage LoginValidation(String type)
	{
		LoginButton.click();
		if(type.equalsIgnoreCase("valid"))
		{
			String expected = "S";
			String actual = AfterLoginIcon.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("invalid"))
		{
			String expected = "Invalid Username/Password";
			String actual = InvalidUser.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("InvalidMobile"))
		{
			String expected = "Please enter a valid mobile number";
			String actual = mobileError.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("InvalidPwd"))
		{
			String expected = "Invalid Username/Password";
			String actual = InvalidUser.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("BlankMob"))
		{
			String expected = "Please enter a valid mobile number";
			String actual = mobileError.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}
		return this;
	}
	
	public HomePage selectFromLocation()
	{
		FromLocation.click();
		Delhi.click();
		return this;
	}
	
	public HomePage selectToLocation()
	{
		Goa.click();
		return this;
	}
	
	public void clickDepartDate()
	{
		expectedDateElement.click();

		/*Define the desired date
		    String expectedDate = "25";
		    String expectedMonth = "October 2024";
	    // Navigate to the correct month and year
	    while(true){
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.visibilityOf(ActualMonth));
			String actualMonth=ActualMonth.getText();
			System.out.println(actualMonth);
			if(expectedMonth.equalsIgnoreCase(actualMonth)) {
			break;
			}else {
				Next.click();
			}
			expectedDateElement.click();
		}*/

	  }
	public FlightOptionsPage clickSearchFlight()
	 {
		wait.until(ExpectedConditions.invisibilityOf(expectedDateElement));
		SearchFlightButton.click();
		return new FlightOptionsPage(driver);
	 }
	
	public void clickRoundTripRadioButton()
	{
		RoundTripRadioButton.click();
	}
	
	public void selectReturnDate()
	{
		RoundTripReturnDate.click();
	/*Define the desired date
	    String expectedDate = "25";
	    String expectedMonth = "October 2024";
	    
    // Navigate to the correct month and year
    while(true){
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(ActualMonth));
		String actualMonth=ActualMonth.getText();
		System.out.println(actualMonth);
		if(expectedMonth.equalsIgnoreCase(actualMonth)) {
		break;
		}else {
			Next.click();
		}
		RoundTripReturnDate.click();
	}*/
	}
	
	public HomePage clickCheckIn()
	{
		checkIn.click();
		return this;
	}
	
	public HomePage enterTicketNumber(String ticketNum)
	{
		TicketNumber.sendKeys(ticketNum);
		return this;
	}
	
	public HomePage enterEmail(String email)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Email));
		Email.sendKeys(email);
		return this;
	}
	
	public void clickSearchBooking(String type)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(SearchBooking));
		SearchBooking.click();
		if(type.equalsIgnoreCase("valid"))
		{
			String expected = "Unable to fetch your booking. Please check the inputs \n"
					+ " you have provided and try again.";
			String actual = CheckinMesssage.getText();
			System.out.println(CheckinMesssage.getText());
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("blankTicket")||(type.equalsIgnoreCase("invalid")))
		{
			String expected = "Invalid PNR or Ticket Number";
			String actual = InvalidTicketMsg.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}else if(type.equalsIgnoreCase("blankEmail"))
		{
			String expected = "Invalid Email";
			String actual = InvalidEmailMsg.getText();
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
		}
	}
	
	public void clickFlightStatus()
	{
		FlightStatus.click();
	}
	
	public void clickFlightStatusSearchFlight()
	{
		FlightStatusSearchFlight.click();
		String expected = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		String actual = driver.getTitle();
		sassert.assertEquals(actual, expected);
		sassert.assertAll();
	}
	
	public void clickManageBookings()
	{
		ManageBookings.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NoTripMsg));
		String actual = NoTripMsg.getText();
		String expected = "You don’t have any upcoming trips";
		sassert.assertEquals(actual, expected);
		sassert.assertAll();
	}
	
	public void clickAddYourItenary()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(AddYourItenary));
		AddYourItenary.click();
	}
	
	public void clickViewUpcomingTrips()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ViewUpcomingTrips));
		ViewUpcomingTrips.click();
		wait.until(ExpectedConditions.visibilityOf(NoTripMsg));
		String actual = NoTripMsg.getText();
		String expected = "You don’t have any upcoming trips";
		sassert.assertEquals(actual, expected);
		sassert.assertAll();
	}
	
	public void clickViewChangeAssist() throws InterruptedException
	{
		ViewChangeAssist.click();
		Thread.sleep(5000);
			driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles(); 
			List<String> list = new ArrayList<>(handles);
			driver.switchTo().window(list.get(1));
			String actual = driver.getTitle();
			String expected = "Domestic Airlines in India, Cheap Air Tickets India, International Air Tickets Booking | SpiceJet Airlines";
			sassert.assertEquals(actual, expected);
			sassert.assertAll();
	}
}
