package com.plutora.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class DashboardPage extends TestGenericUtilLib {

	public void gotoDashboardManagerPage(String dashboardData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		mouseHover("Dashboard_Manager_Header_Dropdown", "Dashboard_Manager_Dropdown_Option",dashboardData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
	}

	public void enableDashboardPanel(String dashboardData,String objectData) {
	//	switchToFrameByElement("Dashboard_Manager_Frame", dashboardData);
//		click("Dashboard_Manager_ReleaseDashboard_Tab", dashboardData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		
		clickOnButton(dashboardData, "Dashboard_Manager_RIOT_Setting_Icon", objectData);
		clickOnButton(dashboardData, "Dashboard_Manager_RIOT_AddPanel_Option", objectData);
		
		scrollToElement("Dashboard_Manager_RIOT_Panel_Add_Button",dashboardData);
		clickOnButton(dashboardData, "Dashboard_Manager_RIOT_Panel_Add_Button", objectData);
		
		dragAndDropByOffset("Dashboard_Manager_Panel_Popup", dashboardData,"128","400");
		windowScrollDown("800");
		/*scrollToElement("Dashboard_Manager_RIOT_Panel_Done_Button",dashboardData);
		clickOnButton(dashboardData, "Dashboard_Manager_RIOT_Panel_Done_Button", objectData);
		*/
		clickOnButton(dashboardData, "Dashboard_Manager_RIOT_Panel_Close_Button", objectData);
		clickOnButton(dashboardData, "Dashboard_Manager_Reset_Button", objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		
	}
	public void removeDashboard(String dashboardData,String objectData,String settingIcon,String removeButton) {
		
		click("Dashboard_Manager_RIOT_Dashboard_Settings_Icon", dashboardData);
		waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		sleep(1000);
		
		click("Dashboard_Manager_RIOT_Dashboard_Remove_Option", dashboardData);
		acceptAlert();
		sleep(2000);
	}
}
