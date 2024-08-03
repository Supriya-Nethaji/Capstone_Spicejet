package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC006_FlightStatus extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 4;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void FlightStatusTest(String mobileNum, String password, String type)
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin();
		obj.enterMobileNumber(mobileNum);
		obj.enterPassword(password);
		obj.LoginValidation(type);
		obj.clickFlightStatus();
		obj.selectFromLocation();
		obj.selectToLocation();
		obj.clickFlightStatusSearchFlight();
	}

}
