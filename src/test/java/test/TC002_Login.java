package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC002_Login extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 1;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void Logintest(String mobileNum, String password, String type)
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin()
		.enterMobileNumber(mobileNum)
		.enterPassword(password)
		.LoginValidation(type);
		
	}

}
