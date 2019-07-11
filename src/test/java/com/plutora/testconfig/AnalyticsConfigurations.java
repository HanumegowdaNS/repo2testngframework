package com.plutora.testconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class AnalyticsConfigurations {
	public static String userDir = System.getProperty("user.dir");
	public static final String PATH_SEPARATOR = File.separator;
	public Hashtable<String, String> table = null;
	public static boolean flagger = false;
	public static int randomValue = new Random().nextInt(1000) + 1;
	public static List<String> propertyList = new ArrayList<String>();
	public static String baseUrl,randomString;
	public static String browserName,chromePath,hubIPUrl,applicationURL,username,password;
	public static String loginData,testData,objectData,platformName,blockoutData;

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "url", "loginFile", "objectMapFile", "blockoutFile", "testDataFile", 
		"pageLoadTimeOutInSec", "implicitWaitInSec", "hubUrl" ,"platform","chromedriverPath","domain","username","password"})
	public void preClass(String browser, String url, String loginMapFile, String objectMapFile, 
			String blockoutMapFile,String testDataFile, String pageLoadTimeOutInSec, String implicitWaitInSec, String hubUrl,String platform,String chromedriverPath,
			String domain,String loginUsername,String loginPassword) {
		propertyList.add(testDataFile);
		propertyList.add(objectMapFile);
		propertyList.add(loginMapFile);
		propertyList.add(blockoutMapFile);
		
		browserName=browser;
		chromePath=chromedriverPath;
		hubIPUrl=hubUrl;
		applicationURL=url;
		username=loginUsername;
		password=loginPassword;
	
		testData=testDataFile;
		loginData=loginMapFile;
		objectData=objectMapFile;
		platformName=platform;		
		blockoutData=blockoutMapFile;
				
		new PropertiesCache(propertyList,domain);
		WebGenericUtilLib.getBrowser(browser, hubUrl,chromedriverPath,platform);
		WebGenericUtilLib.setTimeOuts(Integer.parseInt(pageLoadTimeOutInSec), Integer.parseInt(implicitWaitInSec));
		WebGenericUtilLib.launchUrl(url);
	}

	@AfterSuite(alwaysRun = true)
	public void postSuite() {
		WebGenericUtilLib.driver.quit();
		FolderManagementUtilLib.screenShotZipFile(userDir);
	}
}