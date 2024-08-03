package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_SignUp extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 0;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void SignUpTest(String fname,String lname,String mobile,String email,String pwd,String cPwd,String type)
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickSignUp()
		.switchWindow()
		.selectTitle()
		.enterFirstName(fname)
		.enterLastName(lname)
		.selectCountry()
		.selectDOB()
		.enterMobileNumber(mobile);
		/*.enterEmail(email)
		.enterPassword(pwd)
		.enterConfirmPassword(cPwd)
		.selectCheckBox()
		.clickSubmitButton();*/
				
	}

}
