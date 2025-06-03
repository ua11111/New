package TestingApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseTest.Base;
import pageObjects.ExtentReportNG;

public class Listeners extends Base implements ITestListener{

ExtentReports extent1=	ExtentReportNG.getReportObject();
ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test=	extent1.createTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Case Passed");
		 Base base = (Base) result.getInstance();
			
			try {
				String path=getScreenshot(result.getMethod().getMethodName(),base.driver);
				test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
	}
		
	

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=	extent1.createTest(result.getMethod().getMethodName());
		test.fail(result.getThrowable());
		 Base base = (Base) result.getInstance();
		try {
			String path=getScreenshot(result.getMethod().getMethodName(),base.driver);
			test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent1.flush();
		
	}

}
