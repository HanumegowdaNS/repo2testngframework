package com.integrations.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class CustomizationPage extends TestGenericUtilLib {

	public void getCustomizationDetailsPage(String customizationData,
			String testData, String objectData) throws InterruptedException {
		// TODO Auto-generated method stub
		waitForLoadingIconDisappear(800,"Loading_Gif", objectData);
		sleep(1000);
		mouseHover("SettingsDropdown", "CustomizationDropdown",customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickOnJiraIntegrationOption(String customizationData,
			String objectData) {
		// TODO Auto-generated method stub
		scrollToElement("Customization_JiraIntegrations_Option",customizationData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_JiraIntegrations_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void clickViewLogsButton(String customizationData, String objectData) {
		// TODO Auto-generated method stub
		sleep(1000);
		click("Jira_Integration_Viewlog_Button", customizationData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		click("Jira_Integration_Log_Refresh_Button", customizationData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
	}
	
}