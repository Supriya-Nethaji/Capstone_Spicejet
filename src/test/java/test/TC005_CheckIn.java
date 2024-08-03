package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC005_CheckIn extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 3;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void CheckInTest(String mobileNum, String password, String type,String ticketNum,String email,String checkinType) throws InterruptedException
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin();
		obj.enterMobileNumber(mobileNum);
		obj.enterPassword(password);
		obj.LoginValidation(type);
		obj.clickCheckIn();
		obj.enterEmail(email);
		obj.enterTicketNumber(ticketNum);
		Thread.sleep(3000);
		obj.clickSearchBooking(checkinType);
	}

}
