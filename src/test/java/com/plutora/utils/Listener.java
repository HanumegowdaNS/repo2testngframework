package com.plutora.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.AnalyticsConfigurations;
import com.plutora.testconfig.IntegrationsConfigurations;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.testconfig.PlutoraTestConfiguration;

public class Listener implements ITestListener, ISuiteListener,IInvokedMethodListener {

	public static ExtentReports reports;
	public static ExtentTest test, test1;
	public static ExtentHtmlReporter htmlReporter;
	static String suiteName, domain;
	public static Logger logger = Logger.getLogger("");

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// System.out.println("on test start");
		test1 = test.createNode(result.getMethod().getMethodName()+" - "+result.getMethod().getDescription());
		addLogger(result.getMethod().getMethodName() + " Test case is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// System.out.println("on test success");
		test1.log(Status.PASS, result.getMethod().getMethodName() + " Test case is passed");
		test1.assignCategory(suiteName.split("-")[0]);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebGenericUtilLib.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			File destFile = new File("." + File.separator + "ExtentReports" + File.separator + "Screenshots" + File.separator
					+ result.getMethod().getMethodName() +"_fail"+ ".png");
			FileUtils.copyFile(src, destFile);
			test1.log(Status.FAIL, result.getMethod().getMethodName() + "<br>" + result.getThrowable()
					+ test1.addScreenCaptureFromPath("../ExtentReports/Screenshots/" + destFile.getName()));
			test1.assignCategory(suiteName.split("-")[0]);
			WebGenericUtilLib.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebGenericUtilLib.driver.navigate().refresh();

			if (domain.contains("PlutoraTest")) {
				WebGenericUtilLib.driver.get(PlutoraTestConfiguration.baseUrl);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Progress_Bar",PlutoraTestConfiguration.objectData);
			} else if (domain.contains("Integrations")) {
				WebGenericUtilLib.driver.get(IntegrationsConfigurations.baseUrl);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",IntegrationsConfigurations.objectData);
			} else if(domain.contains("Analytics")) {
				WebGenericUtilLib.driver.get(AnalyticsConfigurations.applicationURL);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",AnalyticsConfigurations.objectData);
			} else {
				WebGenericUtilLib.driver.get(PlutoraConfiguration.applicationURL);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",PlutoraConfiguration.objectData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			File destFile = new File("." + File.separator + "ExtentReports" + File.separator + "Screenshots" + File.separator
					+ result.getMethod().getMethodName()+"_skip" + ".png");
			FileUtils.copyFile(src, destFile);
			test1.log(Status.SKIP, result.getMethod().getMethodName() + "<br>" + result.getThrowable()
					+ test1.addScreenCaptureFromPath("../ExtentReports/Screenshots/" + destFile.getName())+"<br>"+" Test case is skipped");
			WebGenericUtilLib.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            
			WebGenericUtilLib.driver.navigate().refresh();

			if (domain.contains("PlutoraTest")) {
				WebGenericUtilLib.driver.get(PlutoraTestConfiguration.baseUrl);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Progress_Bar",PlutoraTestConfiguration.objectData);
			} else if (domain.contains("Integrations")) {
				WebGenericUtilLib.driver.get(IntegrationsConfigurations.baseUrl);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",IntegrationsConfigurations.objectData);
			} else if(domain.contains("Analytics")) {
				WebGenericUtilLib.driver.get(AnalyticsConfigurations.applicationURL);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",AnalyticsConfigurations.objectData);
			} else {
				WebGenericUtilLib.driver.get(PlutoraConfiguration.applicationURL);	
				new WebGenericUtilLib().waitForLoadingIconDisappear(100, "Loading_Gif",PlutoraConfiguration.objectData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//test1.log(Status.SKIP, result.getMethod().getMethodName() + " Test case is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// System.out.println("on test sucess within percentage");

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// System.out.println("on start");
		test = reports.createTest(context.getName());
		suiteName=context.getName();
		// reports = new
		// ExtentReports(System.getProperty("user.dir")+"/"+"Results"+"/"+"reports_"+new
		// SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+".html");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// System.out.println("on finish");

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		XmlSuite xmlSuite = suite.getXmlSuite();
		Map<String, String> allParameters = xmlSuite.getAllParameters();

		for (Map.Entry<String, String> e : allParameters.entrySet()) {
			suite.setAttribute(e.getKey(), e.getValue());
		}
		FolderManagementUtilLib.deleteFilesFromFolder(System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + "Screenshots");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		
		String directoryName=System.getProperty("user.dir") + File.separator + "ExtentReports";
		File drName = new File(directoryName);
		if(!drName.exists()){
			drName.mkdirs();
		}
		htmlReporter = new ExtentHtmlReporter(
				drName.getAbsolutePath()+ File.separator + "reports_"
						+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + ".html");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		PropertyConfigurator.configure(CommonConstants.log4jsPropertiesPath);
		File downloadFile = new File(CommonConstants.downloadFolderPath);
		if(!downloadFile.exists()){
			downloadFile.mkdirs();
		}

		for (Map.Entry<String, String> e : allParameters.entrySet()) {
			suite.setAttribute(e.getKey(), e.getValue());
		}

		domain = (String) suite.getAttribute("domain");
		reports.setSystemInfo("Domain", (String) suite.getAttribute("domain"));
		reports.setSystemInfo("URL", (String) suite.getAttribute("url"));
		reports.setSystemInfo("Platform", (String) suite.getAttribute("platform"));
		reports.setSystemInfo("Browser", (String) suite.getAttribute("browser"));
		reports.setSystemInfo("Username", (String) suite.getAttribute("username"));
		
	}

	@Override
	public void onFinish(ISuite suite) {// TODO Auto-generated method stub
		reports.flush();
		try {
			FolderManagementUtilLib.createZipFile(System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator, 
					System.getProperty("user.dir") + File.separator + "ExtentReports_Archive" + File.separator);
		} catch (Exception e1) {// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		Listener.logger.info(message);
		Listener.test1.log(Status.INFO,message);
	}
}
