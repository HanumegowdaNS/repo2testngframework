package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class RequirementsTracebilityMatrixPage extends TestGenericUtilLib {
	public static String requirementGeneratedId=null;

	public void getRTMPage(String rtmData,String objectData,String testData) {
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_ItemTab", rtmData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_Button", rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRTMHomePage(String rtmData,String objectData,String testData,String testPlanName) {
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_ShowRequirementsCaret_Button", rtmData);
		sleep(2000);
		sendKeys("Req_RTM_TestPlan_Textbox", testPlanName,rtmData,testData);
		sleep(1000);
		clickElementUsingJavaScript("Req_RTM_ShowRequirements_Dropdown_Option", testPlanName, rtmData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
	}

	public void getRTMMatrixSettingsPage(String rtmData) {
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_MatrixSetting_Button", rtmData);
		sleep(2000);
	}

	public void getRTMMatrixSettingsSelectionPage(String rtmData) {
		clickElementUsingJavaScript("Req_RTM_MatrixSetting_REQName_Radiobutton", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_MatrixSetting_TCName_Radiobutton", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_MatrixSetting_SaveClose_Button", rtmData);
		sleep(2000);
	}

	public void getRTMDefectsPopup(String rtmData) {
		clickElementUsingJavaScript("Req_RTM_FailedTC3_Defects_RedButton", rtmData);
		sleep(2000);
	}

	public void getClosePopup(String rtmData) {
		clickElementUsingJavaScript("Req_RTM_FailedTC3_PopupClose_Button", rtmData);
		sleep(2000);
	}

	public void getRequirementHomePage(String rtmData) {
		clickElementUsingJavaScript("Req_RTM_ShowRequirements_Tab", rtmData);
		sleep(2000);
	}

	public void getNavigateRequirementPage(String rtmData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_ItemTab", rtmData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_RTM_Button", rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getNewAddedTCAndDefectCounts(String rtmData,String testData,String objectData,String requirementName,String testPlanName) throws InterruptedException, AWTException {
		sleep(2000);
		/*click("Req_TestDesigner_Navigation_Tab", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_FolderView_Button", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		mouseHover("Req_TestDesigner_TC_Name", "Req_TestDesigner_TCCopy_Icon", rtmData);
		sleep(2000);*/
		clickElementUsingJavaScript("Req_TestExecution_ItemTab", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Req_TestExecution_RunNewTest_Button", "Req_TestExecution_RunNewTestWraper_Button", rtmData);
		//clickElementUsingJavaScript("Req_TestExecution_RunNewTest_Button","RTMRequirementTCNameCopy",rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_RunningImage_Icon",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefect_Button",rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_PopupNewDefect_Button",rtmData);
		sleep(2000);
		sendKeysWithEnter("Req_TestExecution_DefectName_Textbox", "RTMTestExecutionDefectName", rtmData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_DefectSaveClose_Button",rtmData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_SubmitResultFailed_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefectClose_Icon",rtmData);
		sleep(2000);
		getNavigateRequirementPage(rtmData, objectData);
	}

	public void getDeleteTCAndDefectCounts(String rtmData,String testData,String objectData,String testPlanName,String requirementName,String testCaseName) throws InterruptedException, AWTException {
		sleep(2000);
		click("Req_TestDesigner_Navigation_Tab", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_FolderView_Button", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		mouseHover("Req_TestDesigner_TCCopy_Name", "Req_TestDesigner_TCDelete_Icon",testCaseName,testCaseName, rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Confirm_Button",rtmData);
		sleep(2000);
		getNavigateRequirementPage(rtmData, objectData);
	}

	public void getNewelyCreatedTestPlan(String rtmData,String objectData, String testData) throws InterruptedException {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		/*click("Req_TestPlan_ItemTab", rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestPlan_NewTestPlan_Button", rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Req_NewTestPlan_TPName_Textbox", PropertiesCache.setProperty(testData, "RTMTestPlanName"), rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_NewTestPlan_Next_Button", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_NewTestPlan_Next_Button", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_NewTestPlan_Next_Button", rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_NewTestPlan_SaveClose_Button", rtmData);
		sleep(2000);*/
		getNavigateRequirementPage(rtmData, objectData);
		clickElementUsingJavaScript("Req_RTM_ShowRequirementsCaret_Button", rtmData);
		sleep(2000);
	}
	
	public void getDeletedTestPlan(String rtmData,String testPlanData,String objectData, String testData,String testPlanName) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		click("Req_TestPlan_ItemTab", rtmData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		//mouseHover("Req_TestPlan_Link", "Req_TestPlan_RowOptions_Icon", rtmData);
		//sleep(2000);
		sendKeys("TestPlan_SearchIcon", testPlanName,testPlanData,testData);
		enter();
		sleep(2000);
		//mouseHover(PropertiesCache.getProperty(rtmData, "Req_TestPlan_Link").replace("TEXT", PropertiesCache.getProperty(testData, testPlanName)));
		mouseHover("Req_TestPlan_Link", "Req_TestPlan_RowOptions_Icon",testPlanName,testPlanName, rtmData,testData);
		click("Req_TestPlan_RowOptions_Icon",testPlanName,rtmData,testData);
		click("Req_TestPlan_RowDeleteOptions_Link",testPlanName, rtmData,testData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Progress_Bar", objectData);
		/*clickElementUsingJavaScript("Req_TestPlan_RowDeleteOptions_Link", rtmData);
		sleep(1000);*/
		clickElementUsingJavaScript("Req_TestDesigner_Confirm_Button", rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		getNavigateRequirementPage(rtmData, objectData);
		clickElementUsingJavaScript("Req_RTM_ShowRequirementsCaret_Button", rtmData);
		sleep(2000);

	}














}
