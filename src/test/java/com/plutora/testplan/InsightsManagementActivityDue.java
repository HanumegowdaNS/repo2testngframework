package com.plutora.testplan;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementActivityDue {

	InsightsPage insightsPage= new InsightsPage();
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementActivityDue_01() throws InterruptedException, ParseException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", "ERelease_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"ERelease_Automation" )+ " - Searched release successfully");
		
		insightsPage.clickOnActivityDueCount(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData,"Insights_OverdueActivities_Count");
		insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Release_Activity");
		new ReleasePage().updateInsightActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Activity_Title",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedTo",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedToPhase",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		String date = new SimpleDateFormat("dd MMMM yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")));
		insightsPage.verifyTextContains("Insights_DueDate_Text",date,PlutoraConfiguration.insightsData);
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.clickOnActivityDueCount(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData,"Insights_ActivitiesDueThisWeek_Count");
		insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Release_Activity");
		new ReleasePage().updateInsightActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Project_Release_Activity",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedTo",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedToPhase",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		date = new SimpleDateFormat("dd MMMM yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")));
		insightsPage.verifyTextContains("Insights_DueDate_Text",date,PlutoraConfiguration.insightsData);
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	}

	
}
