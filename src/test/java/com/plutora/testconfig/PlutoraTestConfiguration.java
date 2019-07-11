package com.plutora.testconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class PlutoraTestConfiguration {

	public static String userDir = System.getProperty("user.dir");
	public static final String PATH_SEPARATOR = File.separator;
	public static boolean flagger = false;
	public static int randomValue = new Random().nextInt(1000) + 1;
	public static List<String> propertyList = new ArrayList<String>();
	public static String baseUrl, randomString;
	public static String requirementsData,testPlanData,testDesignerData,testExecutionData,loginData,testData,objectData,platformName,defectsData,userManagementData,requirementsBulkUploadData,settingsData,username,password;

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "url", "loginFile", "objectMapFile", "requirementsFile", "testPlanFile",
			"testDesignerFile", "testExecutionFile", "defectsFile", "userManagementFile", "testDataFile",
			"pageLoadTimeOutInSec", "implicitWaitInSec", "hubUrl", "platform", "chromedriverPath", "domain","requirementsBulkUploadFile","settingsFile" ,"username","password"})
	public void preClass(String browser, String url, String loginMapFile, String objectMapFile,
			String requirementsMapFile, String testPlanMapFile, String testDesignerMapFile, String testExecutionMapFile,
			String defectsMapFile, String userManagementMapFile, String testDataFile, String pageLoadTimeOutInSec,
			String implicitWaitInSec, String hubUrl, String platform, String chromedriverPath, String domain,String requirementsBulkUploadMapFile,String settingsFile,String loginUsername,String loginPassword )
			throws MalformedURLException {

		propertyList.add(testDataFile);
		propertyList.add(objectMapFile);
		propertyList.add(loginMapFile);
		propertyList.add(requirementsMapFile);
		propertyList.add(testPlanMapFile);
		propertyList.add(testDesignerMapFile);
		propertyList.add(testExecutionMapFile);
		propertyList.add(defectsMapFile);
		propertyList.add(userManagementMapFile);
		propertyList.add(requirementsBulkUploadMapFile);
		propertyList.add(settingsFile);
		
		testData=testDataFile;
		loginData=loginMapFile;
		objectData=objectMapFile;
		platformName=platform;
		requirementsData=requirementsMapFile;
		testPlanData=testPlanMapFile;
		testDesignerData=testDesignerMapFile;
		testExecutionData=testExecutionMapFile;
		defectsData=defectsMapFile;
		userManagementData= userManagementMapFile;
		requirementsBulkUploadData=requirementsBulkUploadMapFile;
		settingsData=settingsFile;
		baseUrl=url;
		username=loginUsername;
		password=loginPassword;
		
		new PropertiesCache(propertyList, domain);
		WebGenericUtilLib.getBrowser(browser, hubUrl, chromedriverPath,platform);
		WebGenericUtilLib.setTimeOuts(Integer.parseInt(pageLoadTimeOutInSec), Integer.parseInt(implicitWaitInSec));
		WebGenericUtilLib.launchUrl(url);
	}

	@AfterSuite(alwaysRun = true)
	public void postSuite() {
		WebGenericUtilLib.driver.quit();
		FolderManagementUtilLib.screenShotZipFile(userDir);
	}

}
