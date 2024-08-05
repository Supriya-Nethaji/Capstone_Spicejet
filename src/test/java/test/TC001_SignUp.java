package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SignUpPage;

public class TC001_SignUp extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 0;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void SignUpTest(String fname,String lname,String mobile,String email,String pwd,String cPwd,String type) throws InterruptedException
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickSignUp();
		
		SignUpPage obj1 = new SignUpPage(driver);
		obj1.switchWindow();
		obj1.selectTitle();
		obj1.enterFirstName(fname);
		obj1.enterLastName(lname);
		obj1.selectDOB();
		obj1.selectCountry();
		obj1.enterMobileNumber(mobile);
		//obj1.enterEmail(email);
		obj1.enterPassword(pwd);
		obj1.enterConfirmPassword(cPwd);
		obj1.selectCheckBox();
		obj1.clickSubmitButton();		
	}

}
