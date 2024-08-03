package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethods;

public class Listener extends ProjectSpecificationMethods implements ITestListener {
	
	private ExtentTest test;
    private final ExtentReports ext = ExtentDemo.getReport();
    private static int screenshotIndex = 0;
    private final String UNDERSCORE = "_";

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test instance in ExtentReports
        test = ext.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success and attach screenshot
        test.log(Status.PASS, "Test Passed");
        attachScreenshot(result.getMethod().getMethodName() + UNDERSCORE +screenshotIndex++);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure and attach screenshot
        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getThrowable());
        attachScreenshot(result.getMethod().getMethodName()+ UNDERSCORE +screenshotIndex++);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped
        test.log(Status.SKIP, "Test Skipped");
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report to save the results
        ext.flush();
    }

    private void attachScreenshot(String screenshotName) {
        try {
            String screenshotPath = TakeScreenshot(screenshotName);
            test.pass("Screenshot below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            // Log exception to console or reporting system
            e.printStackTrace();
            test.fail("Failed to capture screenshot: " + e.getMessage());
        }
    }

}
