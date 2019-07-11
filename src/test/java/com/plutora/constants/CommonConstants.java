package com.plutora.constants;


import com.plutora.testconfig.IntegrationsConfigurations;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.testconfig.PlutoraTestConfiguration;

public class CommonConstants {

	public final static String xlsPath = PlutoraConfiguration.userDir + PlutoraConfiguration.PATH_SEPARATOR + "src"
			+ PlutoraConfiguration.PATH_SEPARATOR + "test" + PlutoraConfiguration.PATH_SEPARATOR + "java"
			+ PlutoraConfiguration.PATH_SEPARATOR + "com" + PlutoraConfiguration.PATH_SEPARATOR + "plutora"
			+ PlutoraConfiguration.PATH_SEPARATOR + "dataobjects" + PlutoraConfiguration.PATH_SEPARATOR + "TestData.xlsx";

	public final static String extentReportPath = PlutoraConfiguration.userDir + PlutoraConfiguration.PATH_SEPARATOR
			+ "ExtentReports" + PlutoraConfiguration.PATH_SEPARATOR;

	public final static String projectPath = PlutoraConfiguration.userDir + PlutoraConfiguration.PATH_SEPARATOR;

	public final static String extentReportHtmlPath = PlutoraConfiguration.userDir + PlutoraConfiguration.PATH_SEPARATOR
			+ "ExtentReports" + PlutoraConfiguration.PATH_SEPARATOR + "ExtentReport.html";

	public final static String dataSheetName = "DataProvider";

	public final static String compressedZipPath = projectPath + "CompressedExtentReports" + "_";


	public final static String propertyPath = "com"
			+ PlutoraConfiguration.PATH_SEPARATOR + "plutora" + PlutoraConfiguration.PATH_SEPARATOR + "locator"
			+ PlutoraConfiguration.PATH_SEPARATOR + "properties" + PlutoraConfiguration.PATH_SEPARATOR;
	
	public static String imageFileName = PlutoraConfiguration.userDir+PlutoraConfiguration.PATH_SEPARATOR+"UploadFiles"+PlutoraConfiguration.PATH_SEPARATOR;
	//public static String imageFileNameUrl = "/Users/compass/Desktop/Images/";

	public static String imageFileNameUrl = "D://Learning/plutora/testautomation/UploadFiles/";

	public final static String scriptFileName = PlutoraConfiguration.userDir+PlutoraConfiguration.PATH_SEPARATOR+"UploadFiles"+PlutoraConfiguration.PATH_SEPARATOR+"HealthCheckStatus.js";
	
	public static String downloadFolderPath = PlutoraConfiguration.userDir+PlutoraConfiguration.PATH_SEPARATOR+"DownloadFiles"+PlutoraConfiguration.PATH_SEPARATOR;
	
	public static String log4jsPropertiesPath=PlutoraConfiguration.userDir + PlutoraConfiguration.PATH_SEPARATOR + "src" + 
			PlutoraConfiguration.PATH_SEPARATOR + "test" + PlutoraConfiguration.PATH_SEPARATOR + "java" + PlutoraConfiguration.PATH_SEPARATOR + "com" + PlutoraConfiguration.PATH_SEPARATOR + "plutora" + PlutoraConfiguration.PATH_SEPARATOR + "constants"+
			PlutoraConfiguration.PATH_SEPARATOR + "log4js.properties";
	
	public static String tebrFormDescription="Instructions\n" + 
			"	•	Upon submission of this form, a resource from the Environments team will review the request and notify you if approved or further information is required. \n" + 
			"	•	This request can be viewed in the View All Requests page. \n" + 
			"	•	To perform any changes (for e.g. DB Refresh, Infrastructure config), you will need to raise an Environment Change Request.\n" + 
			"	•	";

	
	public final static String plutoratestPropertyPath = "com"
			+ PlutoraTestConfiguration.PATH_SEPARATOR + "plutoratest" + PlutoraTestConfiguration.PATH_SEPARATOR + "locator"
			+ PlutoraTestConfiguration.PATH_SEPARATOR + "properties" + PlutoraTestConfiguration.PATH_SEPARATOR;
	
	public final static String plutoraapiPropertyPath = "com"
			+ PlutoraTestConfiguration.PATH_SEPARATOR + "plutoraapi" + PlutoraTestConfiguration.PATH_SEPARATOR + "locator"
			+ PlutoraTestConfiguration.PATH_SEPARATOR + "properties" + PlutoraTestConfiguration.PATH_SEPARATOR;
	
	public final static String integrationsPropertyPath = "com"
			+ IntegrationsConfigurations.PATH_SEPARATOR + "integrations" + IntegrationsConfigurations.PATH_SEPARATOR + "locator"
			+ IntegrationsConfigurations.PATH_SEPARATOR + "properties" + IntegrationsConfigurations.PATH_SEPARATOR;
}
