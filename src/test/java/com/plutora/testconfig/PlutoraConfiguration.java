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

public class PlutoraConfiguration {

	public static String userDir = System.getProperty("user.dir");
	public static final String PATH_SEPARATOR = File.separator;
	public Hashtable<String, String> table = null;
	public static boolean flagger = false;
	public static int randomValue = new Random().nextInt(1000) + 1;
	public static List<String> propertyList = new ArrayList<String>();
	public static String baseUrl,randomString;
	public static String browserName,chromePath,hubIPUrl,applicationURL,username,password;
	public static String releasesData,loginData,testData,objectData,platformName,systemsData,environmentData,changesData,customizationData,userManagementData,tebrData,tecrData,deploymentPlanData,insightsData,pirData,blockoutData,systemsImpactMatrixData,environmentImpactMatrixData,organizationStructureData,mainMenuData,dashboardData,initiativeData,reacttebrData;

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "url", "loginFile", "objectMapFile", "releasesFile", "environmentFile",
			"deploymentFile", "newUserFile", "blockoutFile", "changesFile", "testDataFile", "tecrFile",
			"tebrFile", "systemsFile", "pirFile", "pageLoadTimeOutInSec", "implicitWaitInSec", "hubUrl" ,"platform","chromedriverPath","customizationFile","domain","insightsFile","systemsImpactMatrixFile","environmentImpactMatrixFile","organizationStructureFile","mainMenuFile","username","password","dashboardFile","initiativeFile","reacttebrFile"})
	public void preClass(String browser, String url, String loginMapFile, String objectMapFile, String releasesMapFile,
			String environmentMapFile, String deploymentMapFile, String newUserMapFile, String blockoutMapFile,
			String changesMapFile, String testDataFile, String tecrFile, String tebrFile, String systemsFile,
			String pirFile, String pageLoadTimeOutInSec, String implicitWaitInSec, String hubUrl,String platform,String chromedriverPath,String customizationFile,String domain,String insightsFile,String systemsImpactMatrixFile,String environmentImpactMatrixFile,String organizationStructureFile,String mainMenuFile,String loginUsername,String loginPassword,String dashboardFile,String initiativeFile, String reacttebrFile) {
		propertyList.add(testDataFile);
		propertyList.add(objectMapFile);
		propertyList.add(loginMapFile);
		propertyList.add(releasesMapFile);
		propertyList.add(environmentMapFile);
		propertyList.add(deploymentMapFile);
		propertyList.add(newUserMapFile);
		propertyList.add(blockoutMapFile);
		propertyList.add(changesMapFile);
		propertyList.add(tecrFile);
		propertyList.add(tebrFile);
		propertyList.add(systemsFile);
		propertyList.add(pirFile);
		propertyList.add(customizationFile);
		propertyList.add(insightsFile);
		propertyList.add(systemsImpactMatrixFile);
		propertyList.add(environmentImpactMatrixFile);
		propertyList.add(organizationStructureFile);
		propertyList.add(mainMenuFile);
		propertyList.add(dashboardFile);
		propertyList.add(initiativeFile);
		propertyList.add(reacttebrFile);
		
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
		releasesData=releasesMapFile;
		systemsData=systemsFile;
		environmentData=environmentMapFile;
		changesData=changesMapFile;
		customizationData=customizationFile;
		userManagementData=newUserMapFile;
		deploymentPlanData=deploymentMapFile;
		tebrData=tebrFile;
		tecrData=tecrFile;
		insightsData=insightsFile;
		pirData=pirFile;
		blockoutData=blockoutMapFile;
		systemsImpactMatrixData=systemsImpactMatrixFile;
		environmentImpactMatrixData=environmentImpactMatrixFile;
		organizationStructureData=organizationStructureFile;
		mainMenuData=mainMenuFile;
		dashboardData=dashboardFile;
		initiativeData=initiativeFile;
		reacttebrData=reacttebrFile;
		
		
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

