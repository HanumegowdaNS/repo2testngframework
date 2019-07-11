package com.plutora.testplan;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementActivitySummaryAndProgress {

	InsightsPage insightsPage= new InsightsPage();
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementActivitySummaryAndProgress_01() throws InterruptedException, ParseException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option","ERelease_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"ERelease_Automation")+ " - Searched release successfully");
		
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectReleaseMatrixShowIcon(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.sleep(2000);
		insightsPage.clickElementUsingJavaScript("Insights_ActivitiesSummaryAndProgress",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.verifyText("Insights_TotalActivities_Count", "1", PlutoraConfiguration.insightsData);
		insightsPage.verifyText("Insights_Completed_Count", "0", PlutoraConfiguration.insightsData);
		insightsPage.verifyText("Insights_Remaining_Activities_Count","1", PlutoraConfiguration.insightsData);
		insightsPage.verifyText("Insights_DUESOON_Count","1", PlutoraConfiguration.insightsData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Activity_Title",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Progress_Release_Id","PRelease_Automation",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		
		insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Title");
		new ReleasePage().updateInsightActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Project_Release_Activity",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedTo",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedToPhase",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		String date = new SimpleDateFormat("dd MMMM yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")));
		insightsPage.verifyTextContains("Insights_DueDate_Text",date,PlutoraConfiguration.insightsData);
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	}

	
}
