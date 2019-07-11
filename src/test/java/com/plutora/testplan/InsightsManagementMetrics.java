package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementMetrics {

	InsightsPage insightsPage= new InsightsPage();
	ReleasePage releasePage = new ReleasePage();
	String[] searchReleaseList = {"Enterprise","Project","Independent","Portfolio Association"};
	String[] releaseList = {"ERelease_Automation","PRelease_Automation","IRelease_Automation","PRelease_Automation"};
	
	/*@Test(description = "Filter panel - Search for Release/s by (Org filter will show only Project/Independent releases)")
	public void insightsManagementMetrics_01() throws InterruptedException {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);

		for (int i = 0; i < searchReleaseList.length; i++) {
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, searchReleaseList[i]);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			Listener.addLogger("Selected " + searchReleaseList[i] + " release type successfully");
			
			insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[i]);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Searched release successfully");
			
			insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[i],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Insights View Metric option is available in the grid successfully");
		
			insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[i], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " -  Release Id displayed in the insights grid successfully");
		}
	}
	
	@Test (description="Filter panel - Select Release Type/s (Optional)")
	public void insightsManagementMetrics_02() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		for (int i = 0; i < searchReleaseList.length; i++) {
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.selectReleaseType(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,searchReleaseList[i],i);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			
			if (searchReleaseList[i].equals("Portfolio Association")) {
				insightsPage.verifyText("Insights_ReleaseType_Text", "Release_Organization",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
				Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization")+ " -  Release Type displayed successfully");
			} else {
				insightsPage.verifyText("Insights_ReleaseType_Text", "Release_Type",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
				Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+ " -  Release Type displayed successfully");
			}
			insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[i]);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Searched release successfully");
			
			insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[i],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Insights View Metric option is available in the grid successfully");
		
			insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[i], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " -  Release Id displayed in the insights grid successfully");
		}
	}
	@Test (description="Filter panel - Implementation Date Range (Optional)")
	public void insightsManagementMetrics_03() throws InterruptedException, ParseException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		for (int i = 0; i < searchReleaseList.length; i++) {
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.selectImplementationDate(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,searchReleaseList[i],i);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			
			insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[i]);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Searched release successfully");
			
			insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[i],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Insights View Metric option is available in the grid successfully");
		
			insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[i], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " -  Release Id displayed in the insights grid successfully");
		}
	}
	
	@Test (description="Select Release/s to view metrics (live search field)")
	public void insightsManagementMetrics_04() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
	
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		Listener.addLogger("Selected Enterprise release successfully");
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" - Searched release successfully");
		
		insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", "Insights_ViewMetric_FirstRelease",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" - Insights View Metric option is available in the grid successfully");
		
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text","Insights_ViewMetric_FirstRelease",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" -  Release Id displayed in the insights grid successfully");
	}
	
	@Test (description="Button 'Clear Search'")
	public void insightsManagementMetrics_05() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		Listener.addLogger("Selected Enterprise release successfully");
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" - Searched release successfully");
		
		insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", "Insights_ViewMetric_FirstRelease",PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" - Insights View Metric option is available in the grid successfully");
		
		insightsPage.clickOnClearInsightsButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.setProperty(PlutoraConfiguration.insightsData, "Insights_ViewMetric_FirstRelease"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" -  Insights View Metric option is not available in the grid successfully");
		
	}
	@Test (description="Settings - Release Metrics (data appearance, immediate data update)")
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
		insightsPage.selectReleaseMatrixShowIcon(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
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
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectSettingOption(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData, "Insights_ReleaseMatrix_Show_Icon");
		insightsPage.sleep(2000);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "PRelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", "ERelease_Automation", PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		insightsPage.sleep(2000);
		insightsPage.verifyText("Insights_OverdueActivities_Count", "2", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.verifyText("Insights_ActivitiesDueThisWeek_Count", "2", PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		insightsPage.validateElementDisplayed("Insights_ActivitiesSummaryAndProgress_Disabled", PlutoraConfiguration.insightsData);
		
	}
	
	@Test (description="Settings - Widgets (reordering, data appearance, immediate data update)")
	public void insightsManagementMetrics_07() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		Listener.addLogger("Selected Enterprise release type successfully");
		insightsPage.validateElementDisplayed("Insights_OverdueActivites_Widget", PlutoraConfiguration.insightsData);
		insightsPage.validateElementDisplayed("Insights_ActivitesDueThisWeek_Widget", PlutoraConfiguration.insightsData);
		insightsPage.validateElementDisplayed("Insights_GateCompliance_Widget", PlutoraConfiguration.insightsData);
		insightsPage.validateElementDisplayed("Insights_DefectDensity_Widget", PlutoraConfiguration.insightsData);
		
		insightsPage.selectSettingOption(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData, "Insights_Widgets_Show_Icon");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Insights_ViewMetric_FirstRelease")+" -  Insights View Metric option is not available in the grid successfully");
		
	}
	@Test (description="Settings - 'I'm Stakeholder for' (affected releases list and widgets)")
	public void insightsManagementMetrics_08() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		for (int i = 0; i < searchReleaseList.length; i++) {
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, searchReleaseList[i]);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			insightsPage.validateElementDisplayed("Insights_StakeholderIcon_Enabled", PlutoraConfiguration.insightsData);
		}
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[1]);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[1])+ " - Searched release successfully");
		insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[1],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[1])+ " - Insights View Metric option is available in the grid successfully");
	
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[1], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[1])+ " -  Release Id displayed in the insights grid successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ERelease_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"ERelease_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.updateStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnReleaseSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, searchReleaseList[0]);
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectStakeholderShowIcon(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[0]);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[0])+ " - Searched release successfully");
		insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[0],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[0])+ " - Insights View Metric option is available in the grid successfully");
	
		insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[1], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[0])+ " -  Release Id displayed in the insights grid successfully");
		
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, searchReleaseList[3]);
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[2]);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[2])+ " - Searched release successfully");
		insightsPage.validateElementNotDisplayed("Insights_Grid_ReleaseId_Text", releaseList[2], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[2])+ " -  Release Id not displayed in the insights grid successfully");
	}
	
	@Test (description="Settings - 'Manage Widgets' button")
	public void insightsManagementMetrics_09() throws InterruptedException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		insightsPage.clickElementUsingJavaScript("Insights_Manage_Widgets_Button",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.validateElementDisplayed("Insights_New_Widget_Section", PlutoraConfiguration.insightsData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "New_Widget",insightsPage.getTextData("Insights_New_Widget_Text", PlutoraConfiguration.insightsData));
		
		insightsPage.clickElementUsingJavaScript("Insights_New_Widget_Section",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.validateElementDisplayed("Insights_Disabled_Widget_Icon", PlutoraConfiguration.insightsData);
		insightsPage.click("Insights_Widget_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.click("Insights_Save_Button",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "New_Widget"));
		
	}*/
	@Test (description="Settings - Completed Releases toggle button")
	public void insightsManagementMetrics_10() throws InterruptedException  {
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IRelease_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData,"Independent_Tab");
		releasePage.updateReleaseStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed","AddRelease_Status_Dropdown_FirstOption");
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectCompletedShowIcon(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		
		for (int i = 1; i < 3; i++) {
			insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, searchReleaseList[i]);
			insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
			Listener.addLogger("Selected " + searchReleaseList[i] + " release type successfully");
			
			insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", releaseList[i]);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Searched release successfully");
			
			insightsPage.validateElementDisplayed("Insights_View_Metrics_Text", releaseList[i],PlutoraConfiguration.insightsData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " - Insights View Metric option is available in the grid successfully");
		
			insightsPage.verifyText("Insights_Grid_ReleaseId_Text", releaseList[i], PlutoraConfiguration.insightsData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseList[i])+ " -  Release Id displayed in the insights grid successfully");
		}
	}
	
}
