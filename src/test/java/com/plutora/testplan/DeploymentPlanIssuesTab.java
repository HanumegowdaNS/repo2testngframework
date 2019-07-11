package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanIssuesTab {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Issues - general workflow")
	public void deploymentPlanIssuesTab_01() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
		
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation","Deployment_Automation","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan created successfully");
		
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.setupQuestion(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan setup question created successfully");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan is moved from draft to execution successfully");
	
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.createIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan create issue is created successfully");
		
		for(int i=0;i<deploymentPlanPage.dataTypeStatus.length;i++) {
		deploymentPlanPage.validateElementDisplayed("Deployment_Master_Issue_Questions", "Deployment_Issue_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue_Question_"+(i+1))+" - Master Deployment Plan questions is verified successfully");
		}
		for(int i=0;i<2;i++) {
		deploymentPlanPage.click("Deployment_Master_Issue_Questions_Dropdown","Deployment_Issue_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.click("Deployment_Master_Issue_Questions_Dropdown_Option","Deployment_Issue_Answer_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.validateElementDisplayed("Deployment_Master_Issue_Name", "Deployment_Issue_Answer_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue_Answer_"+(i+1))+" - Master Deployment Plan answers is verified successfully");
		}
		deploymentPlanPage.click("Deployment_Master_Issue_Questions_Dropdown","Deployment_Issue_Question_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_Issue_Answer_Checkbox","Deployment_Issue_Answer_3",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.validateElementDisplayed("Deployment_Master_Issue_Answer_Name", "Deployment_Issue_Answer_3",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
	
		//deploymentPlanPage.sendKeys("Deployment_Master_Issue_Answer_Textbox", "Deployment_Issue_Question_4",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.gotoCommandCenterPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectMasterDeploymentPlanFromCommandCenter(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_Issue_Count_Value", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_Issue_Count_Percent", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_Issue_Count_Name", "Deployment_Issue_Status",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger("Master Deployment Plan validated all elements from command center page successfully");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Master_Issue_Name","Deployment_Issue",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Status_Textbox", "Deployment_Issue_Status",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue_Status")+" - Master Deployment Plan status is verified successfully");
		
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Master_Issue_Type_Textbox", "Deployment_Issue_Type",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue_Type")+" - Master Deployment Plan type is verified successfully");
		
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Master_Issue_Assignee_Textbox", "Deployment_Issue_Assignee",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue_Assignee")+" - Master Deployment Plan assignee is verified successfully");
		
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Master_Issue_SourceDeploymentPlan_Textbox", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Master Deployment Plan source deployment plan is verified successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Add/Remove Impacted DPs (only Execution mode)")
	public void deploymentPlanIssuesTab_02() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.removeDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Child deployment plan is removed successfully");
		deploymentPlanPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Reason_For_Removal"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Child deployment plan is verified after removal successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Delete Issue (only Execution mode)")
	public void deploymentPlanIssuesTab_03() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment plan issue is deleted successfully");
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment plan issue is verified after deletion successfully");
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment plan issue is deleted successfully");
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment plan is deleted successfully");
	}
	
	@Test (description="Sub-area: DP issues tab -> View All Issues")
	public void deploymentPlanIssuesTab_04() throws InterruptedException  {
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.createIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.createIssueWithStatus(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Master_Issue_Dropdown_submittedOption");
		deploymentPlanPage.createIssueWithStatus(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Master_Issue_Dropdown_rejectedOption");
		deploymentPlanPage.createIssueWithStatus(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Master_Issue_Dropdown_openOption");
		deploymentPlanPage.createIssueWithStatus(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Master_Issue_Dropdown_closedOption");
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name", "Deployment_Issue",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue")
				+ " - Presence verified successfully");
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name",
				"Deployment_IssueDeployment_Master_Issue_Dropdown_submittedOption",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
				"Deployment_IssueDeployment_Master_Issue_Dropdown_submittedOption")
				+ " - Presence verified successfully");
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name",
				"Deployment_IssueDeployment_Master_Issue_Dropdown_rejectedOption",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
				"Deployment_IssueDeployment_Master_Issue_Dropdown_rejectedOption")
				+ " - Presence verified successfully");
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name",
				"Deployment_IssueDeployment_Master_Issue_Dropdown_openOption", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
				"Deployment_IssueDeployment_Master_Issue_Dropdown_openOption") + " - Presence verified successfully");
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name",
				"Deployment_IssueDeployment_Master_Issue_Dropdown_closedOption",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
				"Deployment_IssueDeployment_Master_Issue_Dropdown_closedOption") + " - Presence verified successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area: View Issues Impacting This Plan")
	public void deploymentPlanIssuesTab_05() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.createIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_Issue_Impacting_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyText("Deployment_Master_Issue_Name", "Deployment_Issue",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue")
				+ " - Deployment Issue verified under 'Issue Impacting this Plan'");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
	}
	
	@Test (description="Correctness of Raised On value (only Execution mode)")
	public void deploymentPlanIssuesTab_06() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Login_FullName_Link", PlutoraConfiguration.objectData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Logged_In_User",
				deploymentPlanPage.getTextData("User_FullName_Label", PlutoraConfiguration.objectData));
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.createIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_Issue_Name", "Deployment_Issue",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_Master_IssueRaisedBy_Label", "Logged_In_User",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContains("Deployment_Master_IssueRaisedOn_Label",
				deploymentPlanPage.getTodayDate("0","dd/MM/yyyy" ), PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
	}
	@Test (description="Correctness of Raised On value (only Execution mode)")
	public void deploymentPlanIssuesTab_07() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Login_FullName_Link", PlutoraConfiguration.objectData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Logged_In_User",
				deploymentPlanPage.getTextData("User_FullName_Label", PlutoraConfiguration.objectData));
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.createIssue(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterIssuesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_Issue_Name", "Deployment_Issue",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.setIssueStatus(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Issue_Dropdown_closedOption");
		deploymentPlanPage.verifyText("Deployment_Master_IssueClosedBy_Label", "Logged_In_User",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContains("Deployment_Master_IssueClosedOn_Label",
				deploymentPlanPage.getTodayDate("0","dd/MM/yyyy" ), PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

	}
}