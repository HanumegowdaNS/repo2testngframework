package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementEscapingDefects {

	InsightsPage insightsPage= new InsightsPage();
	ReleasePage releasePage = new ReleasePage();
	String[] searchReleaseList = {"Enterprise","Project","Independent","Portfolio Association"};
	String[] releaseList = {"ERelease_Automation","PRelease_Automation","IRelease_Automation","PRelease_Automation"};
	
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementMetrics_06() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		for (int i = 0; i < searchReleaseList.length; i++) {
			
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, searchReleaseList[i]);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			if(searchReleaseList[i].equals("Enterprise")) {
				insightsPage.validateElementDisplayed("Insights_ReleaseMatrixIcon_Enabled", PlutoraConfiguration.insightsData);
			}else {
				insightsPage.validateElementDisplayed("Insights_ReleaseMatrixIcon_Disabled", PlutoraConfiguration.insightsData);
			}
		}
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,searchReleaseList[0]);
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[0]);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[0])+ " - Searched release successfully");
		
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectSettingOption(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData, "Insights_ReleaseMatrix_Show_Icon");
		insightsPage.sleep(1000);
		insightsPage.verifyText("Insights_OverdueActivities_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_ActivitiesDueThisWeek_Count","1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.validateElementDisplayed("Insights_ActivitiesSummaryAndProgress", PlutoraConfiguration.insightsData);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "PRelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "ERelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		
		insightsPage.sleep(2000);
		insightsPage.clickElementUsingJavaScript("Insights_ActivitiesSummaryAndProgress",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.verifyText("Insights_TotalActivities_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Completed_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Remaining_Activities_Count","1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_DUESOON_Count","1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Project_Release_Activity",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Progress_Release_Id","PRelease_Automation",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		
		//insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new ReleasePage().updateInsightActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.verifyText("Insights_Progress_Activity_Name","Project_Release_Activity",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedTo",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_AssignedTo_Text","Activity_AssignedToPhase",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	}

	
}
