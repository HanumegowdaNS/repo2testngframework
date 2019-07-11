package com.reports.testplan;

import java.text.ParseException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.reports.pagerepo.BlockoutReportPage;

public class BlockoutReport {
	BlockoutReportPage brp = new BlockoutReportPage();
	
	@Test(description="Blockout Automation Report")
	@Parameters({"objectMapFile", "testDataFile","blockoutFile"})
	public void blockoutreport_01(String objectData, String testData, String blockoutData) throws InterruptedException, ParseException {
		brp.gotoBlockoutReportsPage(objectData, testData, blockoutData);
		brp.click("Tableau_Blockout_Sheet", "Tableau_Blockout_Report_Name", blockoutData, testData);
		brp.sleep(2000);
		brp.downloadTableauReport(objectData);
		brp.getDataFromReport(objectData, testData, blockoutData);
		Listener.addLogger("Copied all the required information Successfully !");
		brp.closeDataPopup(testData);
		Listener.addLogger("Closed the Data pop-up !");
		brp.gotoBlockoutInPlutora(testData, objectData, blockoutData);
		brp.verifyText("Blockout_Name", "Tableau_Blockout_Name", blockoutData, testData);
		brp.verifyText("Blockout_Type", "Tableau_Blockout_Name", blockoutData, testData, PropertiesCache.getProperty(testData, "Tableau_Blockout_Type"));
		brp.verifyText("Blockout_Portfolio_Association", "Tableau_Blockout_Name", blockoutData, testData, PropertiesCache.getProperty(testData, "Tableau_Blockout_Org_Name"));
		String blockoutStartDate = brp.convertDateString(PropertiesCache.getProperty(testData, "Tableau_Blockout_StartDate"), "MM/dd/yyyy hh:mm:ss aaa", "MM/dd/yyyy kk:mm");
		brp.verifyText("Blockout_StartDate", "Tableau_Blockout_Name", blockoutData, testData, blockoutStartDate);
		String blockoutEndDate = brp.convertDateString(PropertiesCache.getProperty(testData, "Tableau_Blockout_EndDate"), "MM/dd/yyyy hh:mm:ss aaa", "MM/dd/yyyy kk:mm");
		brp.verifyText("Blockout_EndDate", "Tableau_Blockout_Name", blockoutData, testData, blockoutEndDate);
		Listener.addLogger("Verified Blockout details in Plutora vs Tableau !");
	}
	
}