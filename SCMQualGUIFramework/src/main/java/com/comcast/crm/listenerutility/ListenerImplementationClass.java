package com.comcast.crm.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genric.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass extends BaseClass implements ITestListener, ISuiteListener  {
	
	
	
	public ExtentReports report;
	
	public static ExtentTest test;


	public void onStart(ISuite suite) {
		System.out.println("Repor configuration");
		
		// spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+jlib.date()+".html");
		spark.config().setDocumentTitle("CRM Test Suite");
		spark.config().setReportName("Results");
		spark.config().setTheme(Theme.DARK);
		
		//Add env information and create Test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "Chrome-128");
	}

	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("Repor backUP");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("=====>=====>" + result.getMethod().getMethodName() + "=====>START====>");
		String testName = result.getMethod().getMethodName();
		test=report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<===");


	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=====>=====>" + result.getMethod().getMethodName() + "=====>END====>");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>COMPLETED<===");

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
//		jlib=new JavaUtility();
//		TakesScreenshot ts=(TakesScreenshot) UtilityClassObject.getDriver();
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		String ds="./ScreenShots/"+testName+"+"+jlib.date()+".png";
//		File dst=new File(ds);
//		try {
//			FileHandler.copy(src, dst);
//			String path = ts.getScreenshotAs(OutputType.BASE64);
//			test.addScreenCaptureFromBase64String(path,testName+"_"+jlib.date());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			String dst = wlib.getScreenShot(session_driver, testName);
			test.addScreenCaptureFromBase64String(dst,testName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===>FAILED<===");


	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
