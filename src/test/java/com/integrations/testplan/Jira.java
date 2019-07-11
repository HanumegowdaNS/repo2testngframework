package com.integrations.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.integrations.pagerepo.JiraPage;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.testconfig.IntegrationsConfigurations;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class Jira {
	
	JiraPage jp = new JiraPage();
	
	@Test (description = "Login to Jira")
	@Parameters ({"jiraurl", "jiraUserName", "jiraPassword"})
	public void jira_01(String jiraURL, String jiraUserName, String jiraPassword) {
		//Marking the current browser as temporary browser
		WebGenericUtilLib.tempDriver=WebGenericUtilLib.driver;
		//Opening a new browser
		WebGenericUtilLib.getNewBrowser(IntegrationsConfigurations.browserName, IntegrationsConfigurations.hubIPUrl, IntegrationsConfigurations.chromePath);
		//Making the New browser as current browser
		WebGenericUtilLib.driver=WebGenericUtilLib.newDriver;
		//Navigating to Jira
		WebGenericUtilLib.launchUrl(jiraURL);
		//Logging to JIra
		jp.jiraLogin(IntegrationsConfigurations.jiraData, jiraUserName, jiraPassword);
		jp.verifyText("Jira_Welcome_Page", "Jira_Welcome_Page_Message", IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		//Switching to Plutora  
		//WebGenericUtilLib.driver= WebGenericUtilLib.tempDriver;
		//Closing the JIRA browser
		//WebGenericUtilLib.newDriver.close();
	}
	
	@Test (description = "Verify the release created in Plutora is pushed to JIRA")
	public void jira_02() {
		jp.projectsPage(IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		jp.sleep(2000);
		jp.verifyText("Jira_Projects_Search_Result", "Jira_Test_Project", IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		jp.openProject(IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		jp.verifyText("Jira_Issue_Link", "Release_Test_Automation_Name", IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		//Switching back to Plutora
		WebGenericUtilLib.driver= WebGenericUtilLib.tempDriver;
		//WebGenericUtilLib.newDriver.close();
	}
	
	@Test (description="Create a defect in Jira")
	public void jira_03() {
		//Navigating back to Jira
		WebGenericUtilLib.driver=WebGenericUtilLib.newDriver;
		jp.createDefect(IntegrationsConfigurations.jiraData, IntegrationsConfigurations.testData);
		//Switching back to Plutora
		WebGenericUtilLib.driver= WebGenericUtilLib.tempDriver;
		
	}
}