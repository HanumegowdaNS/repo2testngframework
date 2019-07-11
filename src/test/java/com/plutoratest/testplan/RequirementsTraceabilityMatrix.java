package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.DefectsPage;
import com.plutoratest.pagerepo.RequirementsActivityHistoryPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.RequirementsTracebilityMatrixPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class RequirementsTraceabilityMatrix {
	RequirementsTracebilityMatrixPage rtmPage = new RequirementsTracebilityMatrixPage();
	RequirementsPage requirementPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	DefectsPage defectsPage = new DefectsPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();
	

	@Test(description = "Requirement Trecebility Matrix")
	@Parameters({"requirementsFile","requirementsBulkUploadFile","testPlanFile","testDataFile","objectMapFile","platform"})
	public void requirementsTrecebilityMatrix(String requirementData,String rtmData, String testPlanData,String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_2");
		
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, 1,  1);
		
		testExecutionPage.createDefect(PlutoraTestConfiguration.testExecutionData,rtmData,testData,objectData,"Requirements_Automation_Name_1","TestPlan_Name_1","TDTC_Name_1");
				
		//RTM page
		rtmPage.getRTMPage(rtmData,objectData,testData);
		rtmPage.isElementPresent("Req_RTM_Header",rtmData);
		Listener.addLogger("RTM screen opened.");
		rtmPage.isElementPresent("Req_RTM_SelectTestPlan_Textbox",rtmData);
		rtmPage.isElementPresent("Req_RTM_MatrixSetting_Button",rtmData);
		rtmPage.isElementPresent("Req_RTM_ShowRequirements_Tab",rtmData);
		Listener.addLogger("Select Test Plan field with drop down, Matrix Settings button and Show Requirements tab displayed.");
		//RTM Home page
		rtmPage.getRTMHomePage(rtmData,objectData,testData,"TestPlan_Name_1");
		rtmPage.isElementPresent("Req_RTM_TotalRequirements_Count",rtmData);
		Listener.addLogger("Total Requirements displayed.");
		rtmPage.isElementPresent("Req_RTM_Requirement_Status",rtmData);
		Listener.addLogger("Total Requirement Status displayed.");
		rtmPage.isElementPresent("Req_RTM_TotalLinkedTCs_Count",rtmData);
		Listener.addLogger("Total Linked Test Cases displayed.");
		rtmPage.isElementPresent("Req_RTM_TC_Status",rtmData);
		Listener.addLogger("Total Test Case status displayed.");
		rtmPage.isElementPresent("Req_RTM_TotalDefects_Count",rtmData);
		Listener.addLogger("Total No of Defects displayed.");
		rtmPage.isElementPresent("Req_RTM_Requirement_REQID",rtmData);
		Listener.addLogger("Requirement ID displayed.");
		rtmPage.isElementPresent("Req_RTM_Requirement_TCID",rtmData);
		Listener.addLogger("Test Case ID displayed.");
		//RTM Matrix Settings
		rtmPage.getRTMMatrixSettingsPage(rtmData);
		rtmPage.isElementPresent("Req_RTM_MatrixSetting_REQID_Radiobutton",rtmData);
		Listener.addLogger("Matrix Settings REQ ID displayed.");
		rtmPage.isElementPresent("Req_RTM_MatrixSetting_TCID_Radiobutton",rtmData);
		Listener.addLogger("Matrix Settings Test Case ID displayed.");
		rtmPage.isElementPresent("Req_RTM_MatrixSetting_REQName_Radiobutton",rtmData);
		Listener.addLogger("Matrix Settings REQ Name displayed.");
		rtmPage.isElementPresent("Req_RTM_MatrixSetting_TCName_Radiobutton",rtmData);
		Listener.addLogger("Matrix Settings Test Case Name displayed.");
		//RTM Matrix Settings Selection
		rtmPage.getRTMMatrixSettingsSelectionPage(rtmData);
		rtmPage.isElementPresent("Req_RTM_Requirement_REQID",rtmData);
		rtmPage.isElementPresent("Req_RTM_Requirement_TCID",rtmData);
		Listener.addLogger("The matrix table displayed the options selected in settings.");
		//RTM delete tp functionality
		rtmPage.getNewelyCreatedTestPlan(rtmData,objectData,testData);
		rtmPage.sendKeys("Req_RTM_TestPlan_Textbox", "TestPlan_Name_2",rtmData,testData);
		rtmPage.sleep(1000);
		rtmPage.verifyTextContains("Req_RTM_TestPlan_Dropdown_Option", "TestPlan_Name_2",rtmData,testData);
		Listener.addLogger("The Newly added test plan visible for selection from the drop down list in RTM.");
		rtmPage.getDeletedTestPlan(rtmData,testPlanData,objectData,testData,"TestPlan_Name_2");
		rtmPage.sendKeys("Req_RTM_TestPlan_Textbox", "TestPlan_Name_2",rtmData,testData);
		rtmPage.sleep(1000);
		rtmPage.verifyTextContainsNotDisplayedInPage( "TestPlan_Name_2",testData);
		Listener.addLogger("The deleted test plan not visible for selection from the drop down list in RTM.");
		//Failed TC Defect Count
		Listener.addLogger("The number of defects displayed in the failed test case in RTM.");
		//Defect popup 
		rtmPage.getRTMDefectsPopup(rtmData);
		rtmPage.verifyTextContains("Req_RTM_FailedTC3_Popup_DefectName", "Defect_Name", rtmData, testData);
		Listener.addLogger("A list of defects displayed in a pop up window. It included the Defect ID and Defect name.");
		rtmPage.getClosePopup(rtmData);
		//RTM Data count
		rtmPage.getNavigateRequirementPage(rtmData, objectData);
		rtmPage.verifyTextContains("Req_RTM_TotalRequirements_Count", "RTMTotalRequirementsCount", rtmData, testData);
		Listener.addLogger("Total Requirements count displayed.");
		//rtmPage.verifyText("Req_RTM_Requirement_Status_Name", "RTMRequirementStatus", rtmData, testData);
		Listener.addLogger("Total Requirement Status displayed.");
		rtmPage.verifyTextContains("Req_RTM_TotalLinkedTCs_Count", "RTMTotalLinkedTCsCount", rtmData, testData);
		Listener.addLogger("Total Linked Test Cases count displayed.");
		rtmPage.verifyTextContains("Req_RTM_TotalDefects_Count", "RTMTotalDefectsCount", rtmData, testData);
		Listener.addLogger("Total No of Defects count displayed.");
		//Delete TC fuctionality
		rtmPage.getDeleteTCAndDefectCounts(rtmData,testData,objectData,"TestPlan_Name_1","Requirements_Automation_Name_1","TDTC_Name_1");
		rtmPage.verifyTextContains("Req_RTM_TotalRequirements_Count", "RTMTotalRequirementsCount", rtmData, testData);
		rtmPage.verifyTextContains("Req_RTM_TotalLinkedTCs_Count", "RTMTotalLinkedTCsAfterDeleteCount", rtmData, testData);
		rtmPage.verifyTextContains("Req_RTM_TotalDefects_Count", "RTMTotalDefectsAfterDeleteCount", rtmData, testData);
		Listener.addLogger("Test case that has been deleted not visible in RTM. The defect count not included the defect linked to the test run.");
		//Requirement page
		rtmPage.getRequirementHomePage(rtmData);
		rtmPage.verifyTextContains("Req_Requirement_Page_Header", "RequirementsHeader", rtmData, testData);
		Listener.addLogger("User taken to the Requirements home page.");
		
	}



}