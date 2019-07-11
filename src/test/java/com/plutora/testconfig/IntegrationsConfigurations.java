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

public class IntegrationsConfigurations {
	public static String userDir = System.getProperty("user.dir");
	public static final String PATH_SEPARATOR = File.separator;
	public Hashtable<String, String> table = null;
	public static boolean flagger = false;
	public static int randomValue = new Random().nextInt(1000) + 1;
	public static List<String> propertyList = new ArrayList<String>();
	public static String baseUrl,randomString,browserName,testData,objectData, releaseData,changeData, tecrData, tebrData, jiraData, customizationData, chromePath,hubIPUrl,jiraURL, snowURL;

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "url", "loginFile", "objectMapFile", "releasesFile", "changesFile", "testDataFile", "tecrFile",
			"tebrFile", "jiraFile", "customizationFile", "pageLoadTimeOutInSec", "implicitWaitInSec", "hubUrl" ,"platform","chromedriverPath","domain","jiraurl","snowurl"})
	public void preClass(String browser, String url, String loginMapFile, String objectMapFile, String releasesMapFile,
			String changesMapFile, String testDataFile, String tecrFile, String tebrFile, String jiraFile, String customizationFile,
			String pageLoadTimeOutInSec, String implicitWaitInSec, String hubUrl,String platform,String chromedriverPath,String domain,String jiraurl,String snowurl)
			throws MalformedURLException {

		propertyList.add(testDataFile);
		propertyList.add(objectMapFile);
		propertyList.add(loginMapFile);
		propertyList.add(releasesMapFile);
		propertyList.add(changesMapFile);
		propertyList.add(tecrFile);
		propertyList.add(tebrFile);
		propertyList.add(jiraFile);
		propertyList.add(customizationFile);

		browserName=browser;
		testData=testDataFile;
		objectData=objectMapFile;
		releaseData=releasesMapFile;
		changeData=changesMapFile;
		tecrData=tecrFile;
		tebrData=tebrFile;
		jiraData=jiraFile;
		customizationData=customizationFile;
		chromePath=chromedriverPath;
		hubIPUrl=hubUrl;
		baseUrl=url;
		jiraURL = jiraurl;
		snowURL = snowurl;
		
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