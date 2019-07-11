package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DashboardPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class CustomizationDashboardsAndReports {
	CustomizationPage customizationPage = new CustomizationPage();
	DashboardPage dashboardPage = new DashboardPage();

	@Test (description="Sub-area: Dashboards and Reports")
	public void customizationDashboardsAndReports_01() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Enable dashboards and reports
		customizationPage.enableOrDisableDashboardsAndReports(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Customization_DashboardsAndReports_ReleaseImplementationOverTime_Checked","Customization_DashboardsAndReports_ReleaseImplementationOverTime_NotChecked");
	  
		//Verify dashboards and Reports
		dashboardPage.gotoDashboardManagerPage(PlutoraConfiguration.dashboardData, PlutoraConfiguration.objectData);
		dashboardPage.switchToFrameByElement("Dashboard_Manager_Frame", PlutoraConfiguration.dashboardData);
		dashboardPage.click("Dashboard_Manager_Reset_Button", PlutoraConfiguration.dashboardData);
		dashboardPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		dashboardPage.sleep(2000);
		dashboardPage.click("Dashboard_Manager_ReleaseDashboard_Tab", PlutoraConfiguration.dashboardData);
		dashboardPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		dashboardPage.validateElementDisplayed("Dashboard_Manager_RIOT_Label", PlutoraConfiguration.dashboardData);
		Listener.addLogger("Release Implememtation Over time displayed successfully !");
		
		dashboardPage.validateElementDisplayed("Dashboard_Manager_RIOT_Dashboard", PlutoraConfiguration.dashboardData);
		Listener.addLogger("Release Implememtation Over time dashboard displayed successfully !");
		//remove dashboard
		dashboardPage.removeDashboard(PlutoraConfiguration.dashboardData, PlutoraConfiguration.objectData, "Dashboard_Manager_RIOT_Dashboard_Settings_Icon", "Dashboard_Manager_RIOT_Dashboard_Remove_Option");
		dashboardPage.enableDashboardPanel(PlutoraConfiguration.dashboardData, PlutoraConfiguration.objectData);
		
		//Verify dashboards and Reports
		dashboardPage.validateElementDisplayed("Dashboard_Manager_RIOT_Label", PlutoraConfiguration.dashboardData);
		Listener.addLogger("Release Implememtation Over time displayed successfully !");
		
		dashboardPage.validateElementDisplayed("Dashboard_Manager_RIOT_Dashboard", PlutoraConfiguration.dashboardData);
		Listener.addLogger("Release Implememtation Over time dashboard displayed successfully !");
		
		dashboardPage.switchToDefaultContent();
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Disable dashboards and reports
		customizationPage.enableOrDisableDashboardsAndReports(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Customization_DashboardsAndReports_ReleaseImplementationOverTime_NotChecked","Customization_DashboardsAndReports_ReleaseImplementationOverTime_Checked");
	
	}
}
