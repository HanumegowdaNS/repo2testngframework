package com.plutora.testplan;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementTECR {

	InsightsPage insightsPage= new InsightsPage();
	TECRPage tecrPage = new TECRPage();
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementTECR_01() throws InterruptedException, ParseException  {
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","PRelease_Automation","");
		
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", "PRelease_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"PRelease_Automation" )+ " - Searched release successfully");
		
		insightsPage.clickOnTECRDueToday(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.updateInsightsTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.verifyText("Insights_TECR_Details","TECR_Test_Automation_Id",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_TECR_Details","TECR_Type",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_TECR_Details","TECR_Status",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_TECR_Details","TECR_AssignedTo",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		String date = new SimpleDateFormat("dd MMMM yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_StartDate")));
		insightsPage.verifyTextContains("Insights_TECR_Details",date,PlutoraConfiguration.insightsData);
		date = new SimpleDateFormat("dd MMMM yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_EndDate")));
		insightsPage.verifyTextContains("Insights_TECR_Details",date,PlutoraConfiguration.insightsData);
		
	
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	}

	
}
