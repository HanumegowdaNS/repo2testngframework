package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementGateCompliance {

	InsightsPage insightsPage= new InsightsPage();
	ReleasePage releasePage = new ReleasePage();
	
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementGateCompliance_01() throws InterruptedException, ParseException  {
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"ERelease_Automation");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "PRelease_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation");
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,1,"Releases_StakeholderButton");
		releasePage.addCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Criteria_Test_Automation_Id","Criteria_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", "ERelease_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ERelease_Automation")+ " - Searched release successfully");
		
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectReleaseMatrixShowIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	//	insightsPage.verifyText("Insights_OverdueActivities_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
	//	insightsPage.verifyText("Insights_ActivitiesDueThisWeek_Count","1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.validateElementDisplayed("Insights_ActivitiesSummaryAndProgress", PlutoraConfiguration.insightsData);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "PRelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "ERelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		
		insightsPage.sleep(2000);
		
		insightsPage.clickOnCriteria(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Criteria_Test_Automation_Name");
		releasePage.updateCriteriaStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Completed","-1","Criteria_Test_Automation_Id");
		
		insightsPage.verifyText("Insights_Completed_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Completed"),"COMPLETED");
		
		releasePage.updateCriteriaStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Completed","1","Criteria_Test_Automation_Id");
		insightsPage.verifyText("Insights_Completed_Count", "1", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Completed"),"COMPLETED");
		
		releasePage.updateCriteriaStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"In Progress","0","Criteria_Test_Automation_Id");
		insightsPage.verifyText("Insights_Completed_Count", "0", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Overdue"),"OVERDUE");
		
		releasePage.updateCriteriaStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Not started","1","Criteria_Test_Automation_Id");
		insightsPage.verifyText("Insights_Completed_Count", "0", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Due soon"),"DUE SOON");
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
	}

	
}
