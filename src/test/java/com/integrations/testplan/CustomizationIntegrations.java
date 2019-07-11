package com.integrations.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.testconfig.IntegrationsConfigurations;
import com.plutora.utils.WebGenericUtilLib;
import com.integrations.pagerepo.CustomizationPage;

public class CustomizationIntegrations extends CustomizationPage {
	
	@Test (description="Verifying Release has been pushed to JIRA in integration logs")
	public void customizationIntegrations_01() throws InterruptedException {
		getCustomizationDetailsPage(IntegrationsConfigurations.customizationData, IntegrationsConfigurations.testData, IntegrationsConfigurations.objectData);
		clickOnJiraIntegrationOption(IntegrationsConfigurations.customizationData, IntegrationsConfigurations.objectData);
		clickViewLogsButton(IntegrationsConfigurations.customizationData, IntegrationsConfigurations.objectData);
		verifyText("Jira_Integration_Log_FirstRecord_ReleaseID", "Release_Test_Automation_Id", IntegrationsConfigurations.customizationData, IntegrationsConfigurations.testData);
		click("Jira_Integration_Logs_Close_Icon", IntegrationsConfigurations.customizationData);
	}
}