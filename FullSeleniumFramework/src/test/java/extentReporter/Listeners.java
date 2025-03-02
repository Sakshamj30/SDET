package extentReporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import UtilityTest.Based;

public class Listeners extends Based implements ITestListener {

	ExtentTest test;
	ExtentReports extent = Reporter.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReports extent = Reporter.getReportObject();
		test = extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Pass");
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(filePath,result.getMethod().getMethodName());
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(filePath,result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
		extent.flush();
	}

}
