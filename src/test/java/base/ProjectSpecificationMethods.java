package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void LaunchBrowser(String browser, String url) throws Exception
	{
		browserLaunch(browser, url);
	}
	
	@DataProvider(name = "DataSpiceJet")
	public String[][] getData() throws Exception
	{
		String [] [] data = ReadExcel(sheetnum);
		return data;
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);		
		driver.quit();
	}
}
