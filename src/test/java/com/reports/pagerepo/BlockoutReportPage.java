package com.reports.pagerepo;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class BlockoutReportPage extends TestGenericUtilLib{
	
	public static String blockoutName, blockoutType, blockoutOrgName, blockoutStartDate, blockoutEndDate, blockoutStartYear;
	BlockoutPage bp = new BlockoutPage();
	
	public void gotoBlockoutReportsPage(String objectData, String testData, String blockoutData) {
		clickElement("Tableau_Shared_Workbook_Link", objectData);
		sleep(1000);
		clickElement("Tableau_Automation_Workbook_Link", objectData);
		sleep(1000);
		clickElement("Tableau_Blockout_Automation_Workbook", blockoutData);
	}

	public void getDataFromReport(String objectData, String testData, String blockoutData) {
		PropertiesCache.setProperty(testData, "Tableau_Blockout_Name",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Name")).getText());
		PropertiesCache.setProperty(testData, "Tableau_Blockout_Type",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Type")).getText());
		PropertiesCache.setProperty(testData, "Tableau_Blockout_Org_Name",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Organization_Name")).getText());
		PropertiesCache.setProperty(testData, "Tableau_Blockout_StartDate",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_StartDate")).getText());
		PropertiesCache.setProperty(testData, "Tableau_Blockout_EndDate",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_EndDate_Local")).getText());
		PropertiesCache.setProperty(testData, "Tableau_Blockout_Start_Year",webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Start_Year")).getText());
		/*blockoutName = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Name")).getText();
		blockoutType = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Type")).getText();
		blockoutOrgName = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Organization_Name")).getText();
		blockoutStartDate = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_StartDate")).getText();
		blockoutEndDate = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_EndDate_Local")).getText();
		blockoutStartYear = webElementIdentifier(PropertiesCache.getProperty(blockoutData, "Tableau_Blockout_Start_Year")).getText();*/
	}
	
	public void closeDataPopup (String testData) {
		closeWindowTab();
		driver.switchTo().window(PropertiesCache.getProperty(testData,"Tableau_Window"));
	}
	
	public void gotoBlockoutInPlutora(String testData, String objectData, String blockoutData) throws InterruptedException {
		driver.switchTo().window(PropertiesCache.getProperty(testData,"Plutora_Window"));
		sleep(2000);
		bp.blockoutPage(blockoutData, testData, objectData);
		bp.readBlockout(blockoutData, testData, objectData, PropertiesCache.getProperty(testData,"Tableau_Blockout_Start_Year"));
		//bp.clickOnBlockoutPeriod(blockoutData, testData, objectData, blockoutName);
	}
}