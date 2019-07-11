package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class RequirementsFolderAddPage extends TestGenericUtilLib {

	RequirementsBulkUploadPage requirementsBulkUploadPage = new RequirementsBulkUploadPage();
	static String id;
	static String beforeFolderCount;
	static String afterFolderCount;

	public void getNavigateRequirementPage(String folderData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("Requirements_ItemTab", folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
	}

	public void getNavigateRequirementFolderView(String folderData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_FolderView_Button", folderData);
		sleep(2000);
	}

	public String getSelectingFolder(String folderData) {

		clickElementUsingJavaScript("Req_Folder_SelectingFolder_Name", folderData);
		sleep(2000);
		String value = getTextData("Req_Folder_SelectedFolder_AttributeName", folderData);
		return value;
	}

	public void getSelectingDefaultFolder(String folderData, String testData) {

		clickElementUsingJavaScript("Req_Folder_SelectingDefaultFolder_Name", folderData);
		sleep(2000);

	}

	public void getNewRequirementPage(String folderData,String testData,String objectData,String requirementId,String requirementName) throws InterruptedException, IOException, AWTException {
/*
		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_NewRequirementID_Textbox", PropertiesCache.setProperty(testData,requirementId), folderData );
		sendKeysWithEnter("Req_Folder_NewRequirementName_Textbox", PropertiesCache.setProperty(testData,requirementName), folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_Folder_NewRequirementSaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);*/
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button",folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("AddRequirements_IdTextfield", PropertiesCache.setProperty(testData, requirementId),
				folderData);
		sendKeys("AddRequirements_NameTextfield", PropertiesCache.setProperty(testData, requirementName),
				folderData);
		sleep(1000);
		click("AddRequirements_DescriptionTextfield", folderData);
		sendKeys("AddRequirements_DescriptionTextfield", PropertiesCache.setProperty(testData, "Requirements_Automation_Description"), folderData);
		click("AddRequirements_CategoriesDropdown", folderData);
		sleep(1000);
		click("AddRequirements_CategoriesDropdown_option", folderData);
		scrollToElement("AddRequirements_TestCoverageLabel", folderData);
		sleep(2000);
		click("AddRequirements_Dependencies_Dropdown", folderData);
		sleep(1000);
		click("AddRequirements_Dependencies_DropdownOption", folderData);
		sleep(1000);
		click("AddRequirements_Dependencies_ListDropdown", folderData);
		sleep(1000);
		click("AddRequirements_Dependencies_ListDropdown_Option", folderData);
		
		/*clickUsingAction("AddRequirements_AttachmentsIcon",folderData);
		sleep(2000);
		uploadImage(platform, fileName+PropertiesCache.getProperty(testData, "ImageName"));*/
		uploadImageByCss(".upload-item #file-uploader");
		sleep(2000);
		click("AddRequirements_TestPlanAssociationsDropdown", folderData);
		sleep(1000);
		click("AddRequirements_TestPlanAssociationaDropdown_Option",
				folderData);
		
		clickElementUsingJavaScript("Requirements_StatusRequired_Option",folderData);
        sleep(1000);
        PropertiesCache.setProperty(testData, "Requirement_Status",getTextData("Requirements_Status_Option",folderData ));
        clickElementUsingJavaScript("Requirements_Status_Option",folderData);
        sleep(1000);

		click("AddRequirements_Save&CloseButton", folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	/*public void getNewRequirementGridPage(String folderData,String testData,String objectData,String reqId,String reqName) {

		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_NewRequirementID_Textbox", reqId, folderData, testData);
		sendKeysWithEnter("Req_Folder_NewRequirementName_Textbox", reqName, folderData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_NewRequirementSaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
*/
	public void getCreatedReqAssociation(String folderData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_CreatedNewReqName_Link", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementClose(String folderData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_NewRequirementClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getDefectClose(String folderData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_DefectsPageClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getNavigateRequirementGridView(String folderData,String objectData) {
		click("Req_Folder_GridView_Button", folderData);
		sleep(2000);
	}

	public void getCreatedReqGridAssociationPage(String folderData,String objectData,String testData,String reqName) {
		sleep(2000);
		getNavigateRequirementPage(folderData, objectData);
		getNavigateRequirementFolderView(folderData,objectData);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
		sleep(2000);
		sendKeysToQuerySearch(folderData, testData, reqName);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getBulkUploadPage(String folderData,String testData,String objectData,String fileName) throws InterruptedException, IOException, AWTException {

		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(folderData,objectData,testData);
		sleep(2000);
		requirementsBulkUploadPage.getMappingPage(folderData,testData,fileName);
		requirementsBulkUploadPage.getMappingPopupValidations(folderData,testData);
		requirementsBulkUploadPage.getMappingAllCells(folderData,testData);
		requirementsBulkUploadPage.getMappingNextButton(folderData);
		requirementsBulkUploadPage.getConfirmationPage(folderData,testData);
		requirementsBulkUploadPage.getProgressStagePage(folderData,testData);
		requirementsBulkUploadPage.getSourceCloseButton(folderData,objectData);
	}

	public void getBulkCreatedReqPage(String folderData,String objectData,String testData) {

		click("Req_Folder_CreatedReqGrid_Name","ReqFolderBulkAssociationName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public String getReqCount(String folderData,String testData) {
		String reqCount = getTextData("Req_Folder_Requirements_Count", folderData);
		return reqCount;
	}

	public boolean getReqCountData(String folderData,String testData,String beforeData,String afterData) {
		boolean flag = false;
		int before = 0;
		int after  = 0;
		before = Integer.parseInt(beforeData.substring((beforeData.indexOf("(")+1), (beforeData.indexOf(")"))));
		after = Integer.parseInt(afterData.substring((afterData.indexOf("(")+1), (afterData.indexOf(")"))));
		System.out.println(before+" "+after);
		if (after >= before) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}


	//modify requirement folder
	public void getReqDragDropFolder(String folderData,String objectData,String testData) throws AWTException, InterruptedException {
		getNavigateRequirementPage(folderData, testData);
		getNavigateRequirementFolderView(folderData, objectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		//dragAndDrop("Req_Folder_Requirement1Angular_Icon", "Req_Folder_FolderChild3Angular_Icon", folderData);
		mouseHover("Req_Folder_mousemove_Icon3", folderData);
		moveRobot("Req_Folder_mousemove_Icon4", folderData);
		dragAndDrop("Req_Folder_Requirement1Angular_Icon", "Req_Folder_FolderChild3Angular_Icon", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		/*click("Req_Folder_FolderChild3Angular_Icon",folderData);
		sleep(2000);*/

	}

	//delete requirement folder

	public void getNewRequirementGridForDeletePage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_NewRequirementID_Textbox", "ReqFolderNewReqDeleteGridID", folderData, testData);
		sendKeysWithEnter("Req_Folder_NewRequirementName_Textbox", "ReqFolderNewReqDeleteGridName", folderData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_NewRequirementSaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getReqDeleteConfirmPopup(String folderData,String testData,String objectData) throws AWTException {
		getCreatedReqGridAssociationPage(folderData, objectData,testData,"ReqFolderNewReqGridName");
		sleep(2000);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);

	}

	public void getReqDeleteCancelPage(String folderData)  {
		click("Req_Folder_DeletePopupCancel_Button",folderData);
		sleep(2000);

	}

	public void getReqTestPlanCreationPage(String folderData,String testData,String objectData) {

		click("Req_TestPlan_ItemTab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		click("Req_TestPlan_NewTestPlan_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Req_NewTestPlan_TPName_Textbox", "ReqFolderNewReqTestPlanName", folderData, testData);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_TPAddReq_Button",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TP_Req_Search_Textbox", "ReqFolderNewReqDeleteGridName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TP_Req_Checkbox","ReqFolderTPReqName",folderData,testData);
		sleep(2000);
		click("Req_NewTestPlan_TPAddSelected_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_SaveClose_Button",folderData);
		sleep(2000);

	}

	public void getNewAddedTCAndDefect(String folderData,String testData,String objectData) throws InterruptedException, AWTException {
		//Test Designer
		sleep(2000);
		click("Req_TestDesigner_Navigation_Tab", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_FolderView_Button", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name","ReqFolderNewReqTestPlanName",folderData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name","ReqFolderNewReqDeleteGridName",folderData,testData);
		sleep(2000);
		handle_toast_popup("Server_Error",testData, objectData);
		click("Req_TestCase_Creation_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Req_TestCase_Name_Textbox", "ReqFolderTPTCName", folderData, testData);
		click("Req_NewTestPlan_SaveClose_Button", folderData);
		sleep(2000);
		//Test Execution
		clickElementUsingJavaScript("Req_TestExecution_ItemTab", folderData);
		sleep(2000);
		click("Req_TestDesigner_TP_Name","ReqFolderNewReqTestPlanName",folderData,testData);
		sleep(2000);
		click("Req_TestDesigner_Req_Name","ReqFolderNewReqDeleteGridName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Req_TE_RunNewTest_Button", "Req_TE_RunNewTestWraper_Button", folderData);
		//clickElementUsingJavaScript("Req_TestExecution_RunNewTest_Button","RTMRequirementTCNameCopy",rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_RunningImage_Icon",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefect_Button",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_PopupNewDefect_Button",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_TestExecution_DefectName_Textbox", "ReqFolderTPTCDefectName", folderData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_DefectSaveClose_Button",folderData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_SubmitResultFailed_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefectClose_Icon",folderData);
		sleep(2000);
		getNavigateRequirementPage(folderData, objectData);
	}

	public void getCreatedReqGridAssociationDeletePage(String folderData,String objectData,String testData) {
		getNavigateRequirementGridView(folderData, objectData);
		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqFolderNewReqDeleteGridName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqFolderNewReqDeleteGridName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getReqAssociationDeletePage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		getRequirementClose(folderData, objectData);
		getNewRequirementGridForDeletePage(folderData, testData, objectData);
		/*click("Req_TestDesigner_Navigation_Tab",folderData);
		sleep(2000);*/
		getReqTestPlanCreationPage(folderData, testData, objectData);
		//getRequirementClose(folderData, objectData);
		getNewAddedTCAndDefect(folderData, testData, objectData);
		getCreatedReqGridAssociationDeletePage(folderData, objectData,testData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}

	public void getReqAssociationTPPage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestPlan_ItemTab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TPPage_Searchbox",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TPPage_Searchbox", "ReqFolderNewReqTestPlanName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TPPage_IDSearchbox",folderData);
		click("Req_Folder_TP_Association_Link","ReqFolderNewReqTestPlanName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TP_Association_ReqTab",folderData);
		sleep(2000);

	}

	public void getReqAssociationTPClosePage(String folderData,String objectData) throws AWTException, InterruptedException {

		click("Req_Folder_TP_Association_CloseButton",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationTPSearchClearPage(String folderData) throws AWTException, InterruptedException {

		click("Req_Folder_TPPage_Search_Clear_Button",folderData);
		sleep(2000);

	}

	public void getReqAssociationTDPage(String folderData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestDesigner_Navigation_Tab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationTEPage(String folderData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestExecution_ItemTab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationTDRequirementsTab(String folderData,String objectData) throws AWTException, InterruptedException {

		click("Req_Folder_TDRequirements_Tab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationTDTCFoldersTab(String folderData,String objectData) throws AWTException, InterruptedException {

		click("Req_Folder_TDTCFolders_Tab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationDefectPage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_Defects_Navigation_Tab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_DefectPage_Search_Textbox", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_DefectPage_Search_Textbox", "ReqFolderTPTCDefectName", folderData, testData);
		sleep(2000);
		click("Req_Folder_DefectPage_SearchID_Textbox",folderData);
		sleep(2000);
		click("Req_Folder_DefectName_Link","ReqFolderTPTCDefectName",folderData,testData);
		sleep(2000);
		click("Req_Folder_DefectsReq_Tab", folderData);
		sleep(2000);

	}
	//Test plan delete
	public void getReqAssociationTPDelete(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestPlan_ItemTab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TPPage_Searchbox",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TPPage_Searchbox", "ReqFolderNewReqTestPlanName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TPPage_IDSearchbox",folderData);
		click("Req_Folder_TP_Association_Link","ReqFolderNewReqTestPlanName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TPInfo_Tab", folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Delete_Button", folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Confirm_Button", folderData);
		sleep(2000);

	}


	//defect delete
	public void getReqAssociationDefectDelete(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_Defects_Navigation_Tab", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_DefectPage_Search_Textbox", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_DefectPage_Search_Textbox", "ReqFolderTPTCDefectName", folderData, testData);
		sleep(2000);
		click("Req_Folder_DefectPage_SearchID_Textbox", folderData);
		sleep(2000);
		click("Req_Folder_DefectName_Link","ReqFolderTPTCDefectName",folderData,testData);
		sleep(2000);
		click("Req_Folder_DefectsDelete_Button", folderData);
		sleep(2000);
		click("Req_Folder_DefectsDelete_Confirm_Button", folderData);
		sleep(2000);

	}

	public void getReqAssociationDefectClear(String folderData) throws AWTException, InterruptedException {

		click("Req_Folder_DefectPage_Search_Textbox", folderData);
		enter();
		sleep(2000);
		click("Req_Folder_DefectPage_SearchClear_Button", folderData);
		sleep(2000);

	}

	//Test case delete
	public void getReqAssociationTCDelete(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestDesigner_Navigation_Tab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TDTCGridView_Button",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_Search_Textbox", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TDTC_Search_Textbox", "ReqFolderTPTCName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchID_Textbox", folderData);
		sleep(2000);
		/*mouseHover("Req_Folder_TDTC_SearchedItem_Link",folderData);
		sleep(2000);*/
		mouseHover("Req_Folder_TDTC_SearchedItem_Link","Req_Folder_TDTC_SearchedOptions_Icon",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchedOptions_Icon",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchedDelete_Button",folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Confirm_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getReqAssociationTCClear(String folderData) throws AWTException, InterruptedException {

		click("Req_Folder_TDTC_Search_Clear_Button", folderData);
		sleep(2000);

	}

	//Advanced Search filter

	public void getNewRequirementCreateForFilterPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_NewRequirementID_Textbox", "ReqAdvSearchNewReqID", folderData, testData);
		sendKeysWithEnter("Req_Folder_NewRequirementName_Textbox", "ReqAdvSearchNewReqName", folderData, testData);
		sleep(2000);
		sendKeys("Req_AdvSearchReq_DescTextfield", "ReqAdvSearchNewReqDesc", folderData,testData);
		tabout("Req_AdvSearchReq_DescTextfield", "ReqAdvSearchNewReqDesc", folderData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_NewRequirementSaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getNewRequirementCreateForDependency(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_NewRequirementID_Textbox", "ReqAdvSearchNewReqDependID", folderData, testData);
		sendKeysWithEnter("Req_Folder_NewRequirementName_Textbox", "ReqAdvSearchNewReqDependName", folderData, testData);
		sleep(2000);
		sendKeys("Req_AdvSearchReq_DescTextfield", "ReqAdvSearchNewReqDependDesc", folderData,testData);
		tabout("Req_AdvSearchReq_DescTextfield", "ReqAdvSearchNewReqDependDesc", folderData,testData);
		sleep(2000);
		click("Req_AdvSearchReq_DateTime_Textbox", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_DateTimeToday_Button", folderData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Folder_NewRequirementSaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getAdvSearchSelectingDefaultFolder(String folderData, String testData) {

		clickElementUsingJavaScript("Req_Folder_SelectingDefaultFolder_Name", folderData);
		sleep(2000);
	}

	public void getReqAssociationTPCreationPage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestPlan_ItemTab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		click("Req_TestPlan_NewTestPlan_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Req_NewTestPlan_TPName_Textbox", "ReqAdvSearchNewReqTestPlanName", folderData, testData);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_TPAddReq_Button",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TP_Req_Search_Textbox", "ReqAdvSearchNewReqName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TP_Req_Checkbox","ReqAdvSearchNewReqName",folderData,testData);
		sleep(2000);
		click("Req_NewTestPlan_TPAddSelected_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_Next_Button",folderData);
		sleep(2000);
		click("Req_NewTestPlan_SaveClose_Button",folderData);
		sleep(2000);

	}

	public void getReqAssociationTCCreationPage(String folderData,String testData,String objectData) throws InterruptedException, AWTException {
		//Test Designer
		sleep(2000);
		click("Req_TestDesigner_Navigation_Tab", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_FolderView_Button", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name","ReqAdvSearchNewReqTestPlanName",folderData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name","ReqAdvSearchNewReqName",folderData,testData);
		sleep(2000);
		handle_toast_popup("Server_Error",testData, objectData);
		click("Req_TestCase_Creation_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Req_TestCase_Name_Textbox", "ReqAdvSearchNewReqTestCaseName", folderData, testData);
		click("Req_NewTestPlan_SaveClose_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		//getNavigateRequirementPage(folderData, objectData);
	}

	public void getReqCategoryCreationPage(String folderData,String testData,String objectData) throws InterruptedException, AWTException {

		click("Req_AdvSearchReq_Settings_Tab", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Settings_ReqLink", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Settings_CategoryOption",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Settings_NewCategoryButton",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_AdvSearchReq_NewCategoryName_Textbox", "ReqAdvSearchCategoryName", folderData, testData);
		click("Req_AdvSearchReq_NewCategoryView_Checkbox", folderData);
		sendKeysWithEnter("Req_AdvSearchReq_NewCategoryDesc_Textbox", "ReqAdvSearchCategoryDesc", folderData, testData);
		click("Req_AdvSearchReq_NewCategorySave_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getReqCustomFieldCreationPage(String folderData,String testData,String objectData) throws InterruptedException, AWTException {

		click("Req_AdvSearchReq_NewCustomField_Link", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_NewCustomField_Button", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_AdvSearchReq_NewCustomFieldName_Textbox", "ReqAdvSearchCustomFieldName", folderData, testData);
		click("Req_AdvSearchReq_NewCustomFieldSave_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementCreatedCustomPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqName", folderData, testData);
		sleep(2000);
		id = getTextData("Req_Folder_CreatedReqSystemID","ReqAdvSearchNewReqName",folderData,testData);
		click("Req_Folder_CreatedReqGrid_Name","ReqAdvSearchNewReqName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void getAddRequirementCustomData(String folderData,String testData,String objectData) {

		sendKeysWithEnter("Req_AdvSearchReq_ReqCustomFieldSave_Button", "ReqAdvSearchCustomFieldName", folderData, testData);
		scrollToElement("Req_AdvSearchReq_AttachmentLabel", folderData);
		click("Req_AdvSearchReq_CategoriesDropdown", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_CategoriesOption", "ReqAdvSearchCategoryName",folderData, testData);
		scrollToElement("Req_AdvSearchReq_TestCoverageLabel", folderData);
		sleep(2000);
		click("Req_AdvSearchReq_Dependencies_Dropdown", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_Dependencies_DropdownOption", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_Dependencies_ListTextbox", folderData);
		sleep(1000);
		sendKeysWithEnter("Req_AdvSearchReq_Dependencies_ListDropdown", "ReqAdvSearchNewReqDependName", folderData, testData);
		click("Req_AdvSearchReq_Dependencies_ListDropdown_Option","ReqAdvSearchNewReqDependName",folderData,testData);
		sleep(1000);
		click("Req_AdvSearchReq_Dependencies_AddButton", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_DateTime_Textbox", folderData);
		sleep(1000);
		click("Req_AdvSearchReq_DateTimeToday_Button", folderData);
		sleep(1000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Close_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementSearchClear(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Search_Clear_Button",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementSystemIDPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", id, folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementReqIDPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_ExternalID_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqID", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementReqNamePage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqName", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementDescPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Description_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqDesc", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementCategoryPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_ExternalID_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqID", folderData,testData);
		enter();
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementTPPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_TP_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqTestPlanName", folderData,testData);
		enter();
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementTCPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_TC_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqTestCaseName", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementTCCustomFieldPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_TC_CustomField_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Contains_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchCustomFieldName", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	//Folder Filter

	public boolean getReqFolderCountData(String folderData,String testData,String beforeData,String afterData, int difference) {
		boolean flag = false;
		//4 RQs 1 RQs
		int before = 0;
		int after  = 0;

		before = Integer.parseInt(beforeData.substring(0, (beforeData.indexOf(" "))));
		after = Integer.parseInt(afterData.substring(0, (afterData.indexOf(" "))));
		if (before >= after && after>=difference) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean getAdvSearchFolderCount(String folderData, String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_SelectingDefaultFolder_Name", folderData);
		sleep(2000);
		beforeFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+beforeFolderCount);
		getRequirementReqNamePage(folderData, testData, objectData);
		afterFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+afterFolderCount);
		boolean flag = getReqFolderCountData(folderData, testData, beforeFolderCount, afterFolderCount,1);
		return flag;

	}

	public void getRequirementKeywordSearchPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvKeywordSearch", folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getRequirementAdvSearchClear(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clear("Req_Folder_ReqSearchQuery_Textbox", folderData);
		enter();
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public boolean getAdvKeywordSearchFolderCount(String folderData, String testData,String objectData) {

		getRequirementAdvSearchClear(folderData, testData, objectData);
		clickElementUsingJavaScript("Req_Folder_SelectingDefaultFolder_Name", folderData);
		sleep(2000);
		beforeFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+beforeFolderCount);
		getRequirementKeywordSearchPage(folderData, testData, objectData);
		afterFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+afterFolderCount);
		boolean flag = getReqFolderCountData(folderData, testData, beforeFolderCount, afterFolderCount,1);
		return flag;

	}

	public String getcurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;

	}

	public String getcurrentDateMinus2() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); 
		c.add(Calendar.DATE, -2); 
		String beforeDate = sdf.format(c.getTime());
		return beforeDate;

	}



	public void getRequirementDateSearchPage(String folderData,String testData,String objectData) {

		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Date_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_DateGreaterthanEqual_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", getcurrentDate()+" ", folderData);
		enter();
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Or_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_Date_Hint",folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearch_DateLessthanEqual_Hint",folderData);
		sleep(2000);
		sendKeysWithoutClear("Req_Folder_ReqSearchQuery_Textbox", getcurrentDateMinus2()+" ", folderData);
		enter();
		sleep(2000);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}


	public boolean getAdvDateSearchFolderCount(String folderData, String testData,String objectData) {

		getRequirementAdvSearchClear(folderData, testData, objectData);
		clickElementUsingJavaScript("Req_Folder_SelectingDefaultFolder_Name", folderData);
		sleep(2000);
		beforeFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+beforeFolderCount);
		getRequirementDateSearchPage(folderData, testData, objectData);
		afterFolderCount = getTextData("Req_AdvSearch_Folder_Count", folderData);
		System.out.println("Before folder Count: "+afterFolderCount);
		boolean flag = getReqFolderCountData(folderData, testData, beforeFolderCount, afterFolderCount,2);
		return flag;

	}
	//Requirement TC delete filter
	public void getReqFilterTCDelete(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestDesigner_Navigation_Tab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData, objectData);
		click("Req_Folder_TDTCGridView_Button",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_Search_Textbox", folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TDTC_Search_Textbox", "ReqAdvSearchNewReqTestCaseName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchID_Textbox", folderData);
		sleep(2000);
		/*mouseHover("Req_Folder_TDTC_SearchedItem_Link",folderData);
		sleep(2000);*/
		mouseHover("Req_Folder_TDTC_SearchedFilterItem_Link","Req_Folder_TDTC_SearchedOptions_Icon",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchedOptions_Icon",folderData);
		sleep(2000);
		click("Req_Folder_TDTC_SearchedDelete_Button",folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Confirm_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}
	//Test plan delete
	public void getReqFilterTPDelete(String folderData,String testData,String objectData) throws AWTException, InterruptedException {

		click("Req_TestPlan_ItemTab",folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TPPage_Searchbox",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_TPPage_Searchbox", "ReqAdvSearchNewReqTestPlanName", folderData, testData);
		sleep(2000);
		click("Req_Folder_TPPage_IDSearchbox",folderData);
		click("Req_Folder_TP_Association_Link","ReqAdvSearchNewReqTestPlanName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_TPInfo_Tab", folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Delete_Button", folderData);
		sleep(2000);
		click("Req_Folder_TPInfo_Confirm_Button", folderData);
		sleep(2000);

	}
	
	//Requirement delete
	public void getCreatedReqFilterDeletePage(String folderData,String testData,String objectData) {
		getNavigateRequirementPage(folderData, objectData);
		getNavigateRequirementGridView(folderData, objectData);
		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqAdvSearchNewReqName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}
	
	public void getCreatedReqFilterDependencyDeletePage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqAdvSearchNewReqDependName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqAdvSearchNewReqDependName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}
	
	public void getCreatedReqAddDeletePage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqFolderNewReqName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqFolderNewReqName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}
	
	public void getCreatedReqAddGridPage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqFolderNewReqGridName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqFolderNewReqGridName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}
	
	public void getCreatedReqAddGooglePage(String folderData,String testData,String objectData) throws AWTException, InterruptedException {
		sendKeysWithEnter("Req_Folder_ReqSearchQuery_Textbox", "ReqFolderBulkAssociationName", folderData, testData);
		sleep(2000);
		click("Req_Folder_CreatedReqGrid_Name","ReqFolderBulkAssociationName",folderData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Delete_Button",folderData);
		sleep(2000);
		click("Req_Folder_Confirm_Button",folderData);
		sleep(2000);
		click("Req_Folder_ReqQueryClear_Button",folderData);
		sleep(2000);
	}
	
	public void getReqCategoryCustomFieldDeletePage(String folderData,String testData,String objectData) throws InterruptedException, AWTException {

		click("Req_AdvSearchReq_Settings_Tab", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Settings_ReqLink", folderData);
		sleep(2000);
		clickElementUsingJavaScript("Req_AdvSearchReq_Settings_CategoryOption",folderData);
		sleep(2000);
		click("Req_AdvSearchReq_NewCategoryDelete_Icon","ReqAdvSearchCategoryName",folderData,testData);
		sleep(2000);
		click("Req_AdvSearchReq_CategoryPopupYes_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		//custom field
		click("Req_AdvSearchReq_NewCustomField_Link", folderData);
		sleep(2000);
		click("Req_AdvSearchReq_ReqCustomFieldDelete_Button","ReqAdvSearchCustomFieldName",folderData,testData);
		sleep(2000);
		click("Req_AdvSearchReq_CategoryPopupYes_Button", folderData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	
	}

	public void sendKeysToQuerySearch(String folderData,String testData,String reqName) {
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeysWithEnter("Req_Query_Search_Textbox", reqName,folderData,testData);
		sleep(2000);
		enter();
	}
	public void sendKeysToQuerySearch(String folderData,String testData,String objectData,String fieldName,String condition,String value) {
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_ReqSearch_Icon",folderData);
		sleep(2000);
		sendKeys("Req_Query_Search_Textbox", fieldName,folderData);
		sleep(2000);
		click("Req_AdvSerach_Condition_Hint",fieldName,folderData);
	
		sendKeysWithoutClear("Req_Query_Search_Textbox", "",folderData);
		click("Req_AdvSerach_Condition_Hint",condition,folderData);
		
		sendKeysWithoutClear("Req_Query_Search_Textbox", value,folderData,testData);
		enter();
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
	}
	public void deleteFolder(String folderdata,String objectData,String testData,String folderName,String buttonName) throws InterruptedException {
		//mouseHover("Req_Folder_Name", folderdata);
		try {
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(PropertiesCache.getProperty(folderdata, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(testData,folderName)))).perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		click("Req_Folder_Delete_Icon",folderName,folderdata,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		click(buttonName,folderdata);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		}catch(Exception e) {
			 
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	}
	public void deleteFolderCancelButton(String folderdata,String objectData,String testData,String folderName) throws InterruptedException {
		//mouseHover("Req_Folder_Name", folderdata);
		try {
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(PropertiesCache.getProperty(folderdata, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(testData,folderName)))).perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		click("Req_Folder_Delete_Icon",folderName,folderdata,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		click("Requirements_CancelButton",folderdata);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		}catch(Exception e) {
			 
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	}
	public void createFolderFromParent(String folderData,String objectData,String testData,String parentFolder,String createFolderName) {
		sleep(1000);
		click("Req_Folder_Name",parentFolder,folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_New_Button",folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Folder_Parent/Release_Name",folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		sendKeys("Req_Folder_Parent_Textbox", createFolderName,folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_Parent_Dropdown_Option",createFolderName,folderData,testData);
		clickElementUsingJavaScript("Req_Folder_Parent_Save_Button",folderData);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
	}
	public void createFolderFromChildParent(String folderData,String objectData,String testData,String parentFolder,String createFolderName) {
		sleep(1000);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(PropertiesCache.getProperty(folderData, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(testData,"Project_Name")))).perform();
		click("Req_Folder_Child_Icon","Project_Name",folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		sendKeys("Req_Folder_Child_Textbox", PropertiesCache.setProperty(testData,createFolderName),folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		click("Req_Folder_Requirment_Label",folderData);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
		
	}
	public void renameChildParent(String folderData,String objectData,String testData,String folderName) {
		sleep(1000);
		click("Req_Folder_Name",folderName,folderData,testData);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(PropertiesCache.getProperty(folderData, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(testData,folderName)))).perform();
		sleep(2000);
		clickElementUsingJavaScript("Req_Folder_Edit_Icon",folderName,folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Folder_Child_Update_Textbox",folderName,folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Folder_Edit_Icon",folderName,folderData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(1000);
		sendKeysWithDeleteCharacter("Req_Folder_Child_Update_Textbox", PropertiesCache.setProperty(testData, folderName),folderData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		click("Req_Folder_Requirment_Label",folderData);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
		
	}
	

}
