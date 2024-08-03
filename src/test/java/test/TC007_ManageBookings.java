package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC007_ManageBookings extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 4;
	}
	
	@Test(dataProvider ="DataSpiceJet")
	public void ManageBookingsTest(String mobileNum, String password, String type)
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin();
		obj.enterMobileNumber(mobileNum);
		obj.enterPassword(password);
		obj.LoginValidation(type);
		obj.clickManageBookings();
	}
	
	@Test(dataProvider ="DataSpiceJet")
	public void AddToItenaryTest(String mobileNum, String password, String type) throws InterruptedException
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin();
		obj.enterMobileNumber(mobileNum);
		obj.enterPassword(password);
		obj.LoginValidation(type);
		obj.clickManageBookings();
		Thread.sleep(5000);
		obj.clickAddYourItenary();
		obj.clickViewUpcomingTrips();
	}

}
