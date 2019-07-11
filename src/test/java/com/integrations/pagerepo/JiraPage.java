package com.integrations.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plutora.constants.CommonConstants;
import com.plutora.utils.PropertiesCache;

public class JiraPage extends TestGenericUtilLib {

	public void jiraLogin(String jiraData,String jiraUserName, String jiraPassword) {
		// TODO Auto-generated method stub
		sendKeysWithEnter("Jira_Login_Email_Textfield", jiraUserName, jiraData);
		sleep(1000);
		sendKeys("Jira_Password_Textfield", jiraPassword, jiraData);
		sleep(1000);
		click("Jira_Login_Submit_Button", jiraData);
	}

	public void projectsPage(String jiraData, String testData) {
		// TODO Auto-generated method stub
		sleep(1000);
		click("Jira_Projects_Link", jiraData);
		sendKeysWithEnter("Jira_Projects_Search_Textfield", "Jira_Test_Project", jiraData, testData);
	}

	public void openProject(String jiraData, String testData) {
		// TODO Auto-generated method stub
		sleep(1000);
		click("Jira_Projects_Search_Result", "Jira_Test_Project", jiraData, testData);
		sleep(1000);
		click("Jira_All_Issues_Link", jiraData);
		//sendKeysWithEnter("Jira_Issues_Search_Textfield", "Release_Test_Automation_Name", jiraData, testData);
	}

	public void createDefect(String jiraData, String testData) {
		// TODO Auto-generated method stub
		sleep(1000);
		click("Jira_Create_Defect_Button", jiraData);
		//waitForLoadingIconDisappear("Jira_Loading_Image", jiraData);
		sleep(2000);
		sendKeysWithEnter("Jira_Defect_Project_Textfield", "Jira_Test_Project", jiraData, testData);
		//verifyText("Jira_Defect_Project_Textfield", "Jira_Test_Project", jiraData, testData);
		sleep(500);
		sendKeysWithEnter("Jira_Defect_IssueType_Textfield", "Bug", jiraData);
		//verifyText("Jira_Defect_IssueType_Textfield", "Bug", jiraData);
		sleep(500);
		sendKeys("Jira_Defect_Summary_Textfield", PropertiesCache.setProperty(testData, "Jira_Defect_Summary"), jiraData);
		
		click("Jira_Defect_Create_Button", jiraData);
	}
	
}