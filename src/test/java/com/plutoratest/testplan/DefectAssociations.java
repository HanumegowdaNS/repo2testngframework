package com.plutoratest.testplan;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.DefectsPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class DefectAssociations {
	DefectsPage defectsPage = new DefectsPage();
	RequirementsPage requirementsPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();

	
	@Test(description = "Associating Defect to a Requirement")
	public void associateDefectToRequirement() throws InterruptedException, IOException, AWTException {

		// Creating Requirement
		requirementsPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementsPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName, CommonConstants.imageFileName,
				PlutoraTestConfiguration.objectData, 1);
		Listener.addLogger("Requirement : "
				+ PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_" + 1)
				+ " created successfully");

		// Creating Defect
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 1);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"),
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1")
				+ " New Defect created successfully ");

		defectsPage.openDefect(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"));

		// Canceling the requirement association and verifying
		defectsPage.cancelAssociation("Defect_Associations_Requirements_Tab", "Defect_Add_Requirements_Tab",
				"Defect_Requirements_Search_Textbox", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.objectData,
				PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_Requirements_Tab", "Requirements (0)",
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger("Canceled requirement is not displaying under association section");

		// Associating requirement to defect and verifying
		defectsPage.addAssociation("Defect_Associations_Requirements_Tab", "Defect_Add_Requirements_Tab",
				"Defect_Requirements_Search_Textbox", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.objectData,
				PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_Requirements_Tab", "Requirements (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Associations_Requirements_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Association_Requirment_Item", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("Added requirement is displaying under association section");

		// Click on added requirement and verify relevant requirement page displaying
		defectsPage.click("Defect_Association_Requirment_Item_Id_Link", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Requirement_Description_textarea", "Requirements_Automation_Description",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("User is taken to the Relevant Requirement page");
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
	}
	
	//==============================================================================================================
	  
	@Test(description = "Associating Defect to a Test Plan")
	public void associateDefectToTestPlan() throws InterruptedException, IOException, AWTException {

		// Creating testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.addLogger("Test Plan: "
				+ PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TestPlan_Automation_Name")
				+ " created successfully");

		// Creating Defect
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 1);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"),
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1")
				+ " New Defect created successfully ");

		defectsPage.openDefect(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"));

		// Canceling the test plan association and verifying
		defectsPage.cancelAssociation("Defect_Associations_TestPlans_Tab", "Defect_Add_TestPlan_Tab",
				"Defect_TestPlan_Search_Textbox", "TestPlan_Automation_Name", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_TestPlans_Tab", "Test Plans (0)",
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger("Canceled test plan is not displaying under association section");

		// Associating test plan to defect and verifying
		defectsPage.addAssociation("Defect_Associations_TestPlans_Tab", "Defect_Add_TestPlan_Tab",
				"Defect_TestPlan_Search_Textbox", "TestPlan_Automation_Name", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_TestPlans_Tab", "Test Plans (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Associations_TestPlans_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Association_TestPlan_Item", "TestPlan_Automation_Name",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("Added test plan is displaying under association section");

		// Click on added test plan and verify relevent test plan info page displaying
		defectsPage.click("Defect_Association_TestPlan_Item_Id_Link", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_TestPlan_Info_tab", "Test Plan Info", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_TestPlan_Description_textarea", "TestPlan_Automation_Description",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("User is taken to the Relevant test plan info page");
		defectsPage.clickUsingAction("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
	}
	
	//===================================================================================================================
	 
	
	@Test(description = "Associating Defect to a Test Case")
	public void associateDefectToTestCase() throws InterruptedException, IOException, AWTException {

		// Creating Requirement
		requirementsPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementsPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName, CommonConstants.imageFileName,
				PlutoraTestConfiguration.objectData, 1);
		Listener.addLogger("Requirement : "
				+ PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_" + 1)
				+ " created successfully");

		// Creating Test Plan
		System.out.println(
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1"));
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, "TestPlan_Automation_Name");
		Listener.addLogger("Test Plan : "
				+ PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TestPlan_Automation_Name")
				+ " created successfully");

		// Creating New Test Case
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, "TestPlan_Automation_Name");
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, 1);
		Listener.addLogger("Test Case : " + PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name")
				+ " created successfully");

		// Test Case Execution/Run
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, "TestPlan_Automation_Name");
		testExecutionPage.verifyText("TestExecution_TestPlanName", "TestPlan_Automation_Name",
				PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
		testExecutionPage.clickElementUsingJavaScript("TestExecution_TestPlanName", "TestPlan_Automation_Name",
				PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		testExecutionPage.verifyText("TestExecution_RequirementName", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
		testExecutionPage.clickElementUsingJavaScript("TestExecution_RequirementName",
				"Requirements_Automation_Name_" + 1, PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		testExecutionPage.verifyText("TestExecution_TestcaseName", "TDTC_Name",
				PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
		testExecutionPage.mouseHover("Req_TestExecution_RunNewTest_Button", "Req_TestExecution_RunNewTestWraper_Button",
				"TDTC_Name", "TDTC_Name", PlutoraTestConfiguration.requirementsBulkUploadData,
				PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		testExecutionPage.click("TestExecution_Play_Image", PlutoraTestConfiguration.testExecutionData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		testExecutionPage.click("TestExecution_PauseAndClose_Button", PlutoraTestConfiguration.testExecutionData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		testExecutionPage.click("TestExecution_PauseAndClose_Button", PlutoraTestConfiguration.testExecutionData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

		// Creating Defect
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 1);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"),
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1")
				+ " New Defect created successfully ");

		defectsPage.openDefect(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"));

		// Associating test runs to defect and verifying
		defectsPage.addAssociation("Defect_Associations_TestRuns_Tab", "Defect_Add_Association_TestRuns_LeftTab",
				"Defect_TestRun_Search_Textbox", "TDTC_Name", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_TestRuns_Tab", "Test Runs (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Associations_TestRuns_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyTestRunStatusUnderDefectAssociationsSection(
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name"), "In-Progress");
		Listener.addLogger("Added test run is displaying under association section");

		// Click on added test run and verify User will be taken to the relevant Test
		// Run History in a new tab
		String tc = "//a[text()='" + PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name")
				+ "']$xpath";
		defectsPage.click(tc);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		assertTrue(defectsPage.isElement_Present("//div[text()[contains(.,'"
				+ PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name") + "')]]$xpath"));
		assertTrue(
				defectsPage.isElement_Present("Defect_ExecutionSummary_label", PlutoraTestConfiguration.defectsData));
		defectsPage.click("Defect_Close_Button_Left", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("Clicked on test run and user successfully navigated to respective test run summary page");

		// Check Requirement is indirectly associated to defect
		defectsPage.click("Defect_Associations_Requirements_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_Requirements_Tab", "Requirements (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Association_Requirment_Item", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("Indirect requirement association is displaying under association section");

		// Click on associated Requirement and verify relevant requirement page
		// displaying
		defectsPage.click("Defect_Association_Requirment_Item_Id_Link", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Requirement_Description_textarea", "Requirements_Automation_Description",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("User is taken to the Relevant Requirement page");
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

		// Verify indirect association tooltip message
		String loc = PropertiesCache.getProperty(PlutoraTestConfiguration.defectsData,
				"Defect_IndirectAssociation_Icon_Requirements");
		defectsPage.mouseOver(defectsPage.getElement(loc));
		defectsPage.verifyTextAttributeValue("Defect_IndirectAssociation_Icon_Requirements",
				"IndirectAssociationCannnotRemoveToolTip", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.testData, "uib-tooltip");
		Listener.addLogger("Indirect association tool tip message is displaying for requirement");

		// Click on associated test plan and verify User will be taken to the relevant
		// Test plan page
		defectsPage.click("Defect_Associations_TestPlans_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_TestPlans_Tab", "Test Plans (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Association_TestPlan_Item", "TestPlan_Automation_Name",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("Indirect association of test plan is displaying under association section");

		// Click on added test plan and verify relevant test plan info page displaying
		defectsPage.click("Defect_Association_TestPlan_Item_Id_Link", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_TestPlan_Info_tab", "Test Plan Info", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_TestPlan_Description_textarea", "TestPlan_Automation_Description",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("User is taken to the Relevant test plan info page");
		defectsPage.actionClick("Defect_Close_Button", "Progress_Bar", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

		// Verify indirect association tooltip message
		String loc1 = PropertiesCache.getProperty(PlutoraTestConfiguration.defectsData,
				"Defect_IndirectAssociation_Icon_Testplan");
		defectsPage.mouseOver(defectsPage.getElement(loc1));
		defectsPage.verifyTextAttributeValue("Defect_IndirectAssociation_Icon_Testplan",
				"IndirectAssociationCannnotRemoveToolTip", PlutoraTestConfiguration.defectsData,
				PlutoraTestConfiguration.testData, "uib-tooltip");
		Listener.addLogger("Indirect association tool tip message is displaying for Test plan");

		// Cancel removing of test run and check it is not removed and check indirect
		// associations also not removed
		defectsPage.click("Defect_Associations_TestRuns_Tab", PlutoraTestConfiguration.defectsData);
		String loc2 = PropertiesCache.getProperty(PlutoraTestConfiguration.defectsData,
				"Defect_Remove_TestRunAssociation_Icon");
		defectsPage.mouseOver(defectsPage.getElement(loc2));
		defectsPage.click("Defect_Remove_TestRunAssociation_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyRemoveAssociationConfirmationPopUp();
		defectsPage.clickOnCancelInRemoveAssociationConfirmationPopUp();
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_Associations_TestRuns_Tab", "Test Runs (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_Requirements_Tab", "Requirements (1)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_TestPlans_Tab", "Test Plans (1)",
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger("Associations are not removed when we cancel the remove association action");

		// Remove direct association and check it is removed, and also check indirect
		// associations also removed
		defectsPage.click("Defect_Associations_TestRuns_Tab", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.mouseOver(defectsPage.getElement(loc2));
		defectsPage.click("Defect_Remove_TestRunAssociation_Icon", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyRemoveAssociationConfirmationPopUp();
		defectsPage.clickOnOkInRemoveAssociationConfirmationPopUp();
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_Associations_TestRuns_Tab", "Test Runs (0)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_Requirements_Tab", "Requirements (0)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.verifyText("Defect_Associations_TestPlans_Tab", "Test Plans (0)",
				PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("Both direct and indirect association successfully removed");

		// Deselect the project and try to add association to defect and verify user
		// will get 'A message will display "Please select a Project/Release' error
		// message
		defectsPage.click("Close_Selected_ProjectOrRelease_InSearch", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.closeToastMessages("ToastMsg_List", "ToastMsg_CloseIcon", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defects_MenuTab", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("NewDefect_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_Associations_TestRuns_Tab", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_Association_Add_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		assertTrue(defectsPage.isElement_Present("Defect_PleaseSelect_Project_ErrorMessage",
				PlutoraTestConfiguration.defectsData));
		Listener.addLogger("User successfully getting 'Please select a Project/Release' error message");
		defectsPage.click("Defect_Attention_Window_Close_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.closeToastMessages("ToastMsg_List", "ToastMsg_CloseIcon", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_CreateNewDefect_Close_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);			
		defectsPage.refresh(PlutoraTestConfiguration.objectData,"","Progress_Bar");
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.sendKeys("Login_Search", "TestAutomation", PlutoraTestConfiguration.loginData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.clickElementUsingJavaScript("Login_ProjectName", "Project_Name", PlutoraTestConfiguration.loginData,
				PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
	}
	
	// ===============================================***********============================================
	
	@Test(description = "Associating Defect to a Other Defect")
	public void associateDefectToOtherDefect() throws InterruptedException, IOException, AWTException {

		// Creating first Defect
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 1);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"),
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1")
				+ " New Defect created successfully ");
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_Clear_Defect_Search_Filter", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.sendKeysWithEnter("Defect_Searched_Name_Textbox", "", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

		// Creating second Defect
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 2);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name2"),
				PlutoraTestConfiguration.defectsData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name2")
				+ " New Defect created successfully ");

		defectsPage.openDefect(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name2"));

		// Associating defect to a other defect and verifying
		defectsPage.addDefectAssociation("Defect_Associations_Defects_Tab", "Defect_Add_Association_Defects_LeftTab",
				"Defect_SelectType_Dropdown", "Defect_Defects_Search_Textbox", "Defect_Name1", "New",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.objectData,
				PlutoraTestConfiguration.testData);
		defectsPage.verifyText("Defect_Associations_Defects_Tab", "Defects (1)", PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Associations_Defects_Tab", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyDefectUnderDefectAssociationsSection("RELATED TO (1)",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"), "New");
		Listener.addLogger("Added defect is displaying under association section");

		// Click on added defect and verify relevant requirement page displaying
		defectsPage.click("Defect_Association_Defect_Item_Id_Link", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.sleep(2000);
		defectsPage.verifyText("Defect_Description_textarea", "Defect_Description1",
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("User is taken to the Relevant Requirement page");
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);

		// Cancel removing of associated defect and check it is not removed
		defectsPage.click("Defect_Associations_Defects_Tab", PlutoraTestConfiguration.defectsData);
		String loc2 = PropertiesCache.getProperty(PlutoraTestConfiguration.defectsData,
				"Defect_Remove_DefectAssociation_Icon");
		defectsPage.mouseOver(defectsPage.getElement(loc2));
		defectsPage.click("Defect_Remove_DefectAssociation_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyRemoveAssociationConfirmationPopUp();
		defectsPage.clickOnCancelInRemoveAssociationConfirmationPopUp();
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_Associations_Defects_Tab", "Defects (1)", PlutoraTestConfiguration.defectsData);
		Listener.addLogger("Associated defect not removed when we cancel the remove association action");

		// Remove associated defect and check it is removed
		defectsPage.click("Defect_Associations_Defects_Tab", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.mouseOver(defectsPage.getElement(loc2));
		defectsPage.click("Defect_Remove_DefectAssociation_Icon", PlutoraTestConfiguration.defectsData);
		defectsPage.verifyRemoveAssociationConfirmationPopUp();
		defectsPage.clickOnOkInRemoveAssociationConfirmationPopUp();
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.verifyText("Defect_Associations_Defects_Tab", "Defects (0)", PlutoraTestConfiguration.defectsData);
		defectsPage.click("Defect_Close_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("Both direct and indirect association successfully removed");

		// Deselect the project and try to add association to defect and verify user
		// will get 'A message will display "Please select a Project/Release' error
		// message
		defectsPage.click("Close_Selected_ProjectOrRelease_InSearch", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.closeToastMessages("ToastMsg_List", "ToastMsg_CloseIcon", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defects_MenuTab", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("NewDefect_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_Associations_Defects_Tab", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_Association_Add_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		assertTrue(defectsPage.isElement_Present("Defect_PleaseSelect_Project_ErrorMessage",
				PlutoraTestConfiguration.defectsData));
		Listener.addLogger("User successfully getting 'Please select a Project/Release' error message");
		defectsPage.click("Defect_Attention_Window_Close_Button", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.closeToastMessages("ToastMsg_List", "ToastMsg_CloseIcon", PlutoraTestConfiguration.objectData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.click("Defect_CreateNewDefect_Close_Icon", PlutoraTestConfiguration.defectsData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.refresh(PlutoraTestConfiguration.objectData, "", "Progress_Bar");
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.sendKeys("Login_Search", "TestAutomation", PlutoraTestConfiguration.loginData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		defectsPage.clickElementUsingJavaScript("Login_ProjectName", "Project_Name", PlutoraTestConfiguration.loginData,
				PlutoraTestConfiguration.testData);
		testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

	}
}
