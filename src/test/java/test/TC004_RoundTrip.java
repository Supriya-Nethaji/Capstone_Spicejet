package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.PaymentDetailsPage;


public class TC004_RoundTrip extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setUp()
	{
		sheetnum = 2;
	}
	
	@Test(dataProvider = "DataSpiceJet")
	public void RoundTripTest(String mobileNum, String password, String type,String CardNumber,String CardName,String ExpMonth,String ExpYear,String CVV,String typePayment) throws InterruptedException
	{
		HomePage obj = new HomePage(driver);
		
		obj.clickLogin();
		obj.enterMobileNumber(mobileNum);
		obj.enterPassword(password);
		obj.LoginValidation(type);
		obj.clickRoundTripRadioButton();
		obj.selectFromLocation();
		obj.selectToLocation();
		obj.clickDepartDate();
		obj.selectReturnDate();
		obj.clickSearchFlight()
		.clickContinueButton()
		.clickprimaryPassenger()
		.clickContinueButton1()
		.clickContinueButton2()
		.clickAdClose();
		
		PaymentDetailsPage obj1 = new PaymentDetailsPage(driver);
		obj1.enterCardNumber(CardNumber);
		Thread.sleep(3000);
		obj1.enterCardName(CardName);
		Thread.sleep(3000);
		obj1.enterExpMonth(ExpMonth);
		obj1.enterExpYear(ExpYear);
		obj1.enterSecurityCode(CVV);
		obj1.clickRoundTripPayButton(typePayment);
	}

}
