package com.plutora.testplan;

import java.text.ParseException;
import org.testng.annotations.Test;

import com.plutora.pagerepo.InsightsPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class InsightsManagementOverdueItems {

	InsightsPage insightsPage= new InsightsPage();
	
	@Test (description="Data appearance, immediate data update")
	public void insightsManagementOverdueItems_01() throws InterruptedException, ParseException  {
		insightsPage.gotoInsightsManagementPage(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData);
		insightsPage.clickOnInsightsDropdown(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		insightsPage.searchForRelease(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise");
		insightsPage.clickOnApplyButton(PlutoraConfiguration.insightsData, PlutoraConfiguration.objectData);
		
		insightsPage.searchReleaseFromViewMetric(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Insights_View_Metrics_First_Option", "ERelease_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"ERelease_Automation" )+ " - Searched release successfully");
		
		insightsPage.clickOnSettingIcon(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		insightsPage.selectSettingOption(PlutoraConfiguration.insightsData,PlutoraConfiguration.objectData, "Insights_ReleaseMatrix_Show_Icon");
		insightsPage.sleep(1000);
		
		insightsPage.sleep(2000);
		insightsPage.clickElementUsingJavaScript("Insights_ActivitiesSummaryAndProgress",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
		insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Title");
		new ReleasePage().updateDueDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"-1");
		
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Overdue"),"OVERDUE");
	
		insightsPage.clickOnActivity(PlutoraConfiguration.insightsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Title");
		new ReleasePage().updateDueDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"1");
		insightsPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.insightsData, "Insights_Status_Text").replace("TEXT", "Due soon"),"DUE SOON");
		
		insightsPage.click("Insights_Progress_Close_Icon",PlutoraConfiguration.insightsData);
		insightsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		insightsPage.sleep(1000);
		
	}
	
}
