package com.plutora.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.plutora.constants.CommonConstants;
import com.plutora.utils.FolderManagementUtilLib;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class APIListener extends TestListenerAdapter implements ITestListener, ISuiteListener,IInvokedMethodListener {

	public static ExtentReports reports;
	public static ExtentTest test, test1;
	public static ExtentHtmlReporter htmlReporter;
	public static Logger logger = Logger.getLogger("");

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// APIListener.addLogger("on test start");
		test1 = test.createNode(result.getMethod().getMethodName());
		//test1.log(Status.INFO, result.getMethod().getMethodName() + " test is started");
		addLogger(result.getMethod().getMethodName() + " Test case is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// APIListener.addLogger("on test success");
		test1.log(Status.PASS, result.getMethod().getMethodName() + " test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			test1.log(Status.FAIL, result.getMethod().getMethodName() + "<br>" + result.getThrowable().getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// APIListener.addLogger("on test skipped");
		test1.log(Status.SKIP, result.getMethod().getMethodName() +" test is skipped"+"<br>"+ result.getThrowable().getMessage());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// APIListener.addLogger("on test sucess within percentage");

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// APIListener.addLogger("on start");
		XmlSuite xmlSuite = context.getSuite().getXmlSuite();
		Map<String, String> allParameters = xmlSuite.getAllParameters();

		for (Map.Entry<String, String> e : allParameters.entrySet()) {
			context.setAttribute(e.getKey(), e.getValue());
		}
		test = reports.createTest(context.getName()+" - "+context.getAttribute("domain"));
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// APIListener.addLogger("on finish");

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		FolderManagementUtilLib.deleteFilesFromFolder(System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + "Screenshots");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator );
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + "reports_"
						+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + ".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		PropertyConfigurator.configure(CommonConstants.log4jsPropertiesPath);

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
	    IRetryAnalyzer retry = result.getMethod().getRetryAnalyzer();
	    if (retry == null) {
	        return;
	    }
	    result.getTestContext().getFailedTests().removeResult(result.getMethod());
	    result.getTestContext().getSkippedTests().removeResult(result.getMethod());
	}
	
	public static void addLogger(String message) {
		APIListener.logger.info(message);
		APIListener.test1.log(Status.INFO,message);
	}
	public static void addLogger(int message) {
		APIListener.logger.info(message);
		APIListener.test1.log(Status.INFO,message+"");
	}
	
}
