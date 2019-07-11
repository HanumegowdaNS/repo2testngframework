package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import com.plutora.constants.CommonConstants;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class RequirementsBulkUploadPage extends TestGenericUtilLib {
	public static String requirementGeneratedId=null;

	public void getRequirementsBulkUploadDetailsPage(String requirementsData,String objectData,String testData) {
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_ItemTab", requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_NewButton", requirementsData);
		sleep(2000);
	}
	
	public void clickOnBulkUploadDetailsPage(String requirementsData,String objectData,String testData) {
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_Bulkupload_NewButton", requirementsData);
		sleep(2000);
	}
	public String getRequirementsBulkUploadStepDetails(String requirementsData) {
		String concatedString = concatenateString("Req_Bulkupload_Source_Steps_Headers", requirementsData);
		return concatedString;
	}

	public String getRequirementsBulkUploadSourceColor(String requirementsData) {
		String color = getCSSBackgroundColor("Req_Bulkupload_Source_Circle_Icon", requirementsData);
		return color;
	}
	
	public String getRequirementsBulkUploadConfirmColor(String requirementsData) {
		String color = getCSSBackgroundColor("Req_Bulkupload_Confirm_Circle_Icon", requirementsData);
		return color;
	}
	
	public String getRequirementsBulkUploadConfirmImported(String requirementsData) {
		String color = getCSSColor("Req_Bulkupload_Confirm_Imported_Count", requirementsData);
		return color;
	}
	
	public String getRequirementsBulkUploadConfirmSkipped(String requirementsData) {
		String color = getCSSColor("Req_Bulkupload_Confirm_Skipped_Count", requirementsData);
		return color;
	}
	
	public String getRequirementsBulkUploadConfirmWarning(String requirementsData) {
		String color = getCSSColor("Req_Bulkupload_Confirm_Warning_Count", requirementsData);
		return color;
	}

	public void getRequirementsBulkUploadFile(String requirementsData,String testData,String fileName) throws InterruptedException, IOException {
		sleep(4000);
		String fileNameString = CommonConstants.imageFileName + PropertiesCache.getProperty(testData, fileName);
		driver.findElement(By.xpath(PropertiesCache.getProperty(requirementsData,"Req_BulkUpload_FileInput"))).sendKeys(fileNameString);
		sleep(4000);
	}

	public void getRequirementsBulkUploadTestFile(String requirementsData, String testData,String filename) throws InterruptedException, IOException {
		String fileName = CommonConstants.imageFileName + PropertiesCache.getProperty(testData, filename);
		sleep(4000);
		driver.findElement(By.xpath(PropertiesCache.getProperty(requirementsData,"Req_BulkUpload_FileInput"))).sendKeys(fileName);
		//uploadImageByXpath("Req_BulkUpload_FileInput", requirementsData);
		sleep(4000);
	}

	public void getRequirementsBulkUploadSelectCellMapping(String requirementsData, String testData) {
		clickElementUsingJavaScript("Req_Bulkupload_Source_CellMapping_SelectButton", requirementsData);
		sleep(4000);

	}

	public void getRequirementsBulkUploadSelectColumnMapping(String requirementsData, String testData) {
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_Back_Button", requirementsData);
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_ColumnMapping_SelectButton", requirementsData);
		sleep(4000);
	}

	public String getRequirementsBulkUploadMappingColor(String requirementsData) {
		String color = getCSSBackgroundColor("Req_Bulkupload_Mapping_Circle_Icon", requirementsData);
		return color;
	}
	
	public String getRequirementsBulkUploadSummaryColor(String requirementsData) {
		String color = getCSSBackgroundColor("Req_Bulkupload_Summary_Circle_Icon", requirementsData);
		return color;
	}

	public String getRequirementsBulkUploadMappingLeftLineColor(String requirementsData) {
		String color = getCSSBorderColor("Req_Bulkupload_Mapping_LeftLine", requirementsData);
		return color;
	}

	public boolean getRequirementsBulkUploadExampleLink(String requirementsData) {
		boolean flag = false;
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_Back_Button", requirementsData);
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_Example_Link", requirementsData);
		sleep(4000);
		String parentWindow = switchToWindowReturnParent();
		flag = isElementPresent("Req_Bulkupload_Mapping_Example_Image",requirementsData);
		sleep(2000);
		closeWindowPopupReturnToParent(parentWindow);
		sleep(2000);
		return flag;
	}
	
	public void getCloseUploadedFile(String bulkUploadData, String testData, String platform) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		click("Req_Bulkupload_Source_Uploaded_FileCloseButton",bulkUploadData);
	}

	public void getMappingPage(String bulkUploadData, String testData,String fileName) throws InterruptedException, IOException, AWTException {

		getRequirementsBulkUploadTestFile(bulkUploadData,testData,fileName);
		sleep(4000);
		getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		sleep(4000);
	}

	public void getMappingPopupValidations(String bulkUploadData, String testData) throws InterruptedException, IOException {

		clickElementUsingJavaScript("Req_Bulkupload_SelectReleaseCaret_Button",bulkUploadData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_SelectRelease_Textbox",bulkUploadData);
		sendKeys("Req_Bulkupload_SelectRelease_Textbox", "BulkUploadMappingSelectReleaseName",bulkUploadData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_SelectRelease_Option","BulkUploadMappingSelectReleaseName",bulkUploadData,testData);
		sleep(2000);
	}

	public void getMappingNextButton(String bulkUploadData) throws InterruptedException, IOException {

		sleep(2000);
		click("Req_Bulkupload_Mapping_Next_Button",bulkUploadData);
		sleep(2000);
	}

	public String getMappingWarningList(String requirementsData) {
		String concatedString = concatenateString("Req_Bulkupload_Mapping_Popup_ListData", requirementsData);
		return concatedString;
	}

	public void getWarningPopupClose(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Mapping_Popup_Close_Button",bulkUploadData);
		sleep(2000);
	}

	public void getMappingFirstCell(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_B2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
	}

	public void getMappingCellsRequiredFields(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
	}
	public String getMappingPopupFieldsList(String requirementsData) {
		String concatedString = concatenateString("Req_Bulkupload_Mapping_PopupFields_List", requirementsData);
		return concatedString;
	}

	public void getClearMappingCells(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ReqFields_Name",bulkUploadData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ClearMappings_Button",bulkUploadData);
		sleep(1000);
	}

	public void getMappingAllCells(String bulkUploadData, String testData) throws InterruptedException, IOException {

		//b2 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_B2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ReqFields_Name",bulkUploadData);
		sleep(1000);
		//c2 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_C2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ReqFields_Description",bulkUploadData);
		sleep(1000);
		//D2 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_D2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ReqFields_Status",bulkUploadData);
		sleep(2000);

	}
	public void getRequirementsBulkUploadBackButton(String bulkUploadData) {
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_Back_Button", bulkUploadData);
		sleep(4000);
	}

	public void getRequirementsBulkUploadErrorMapping(String bulkUploadData, String testData) {
		//D3 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_D3Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_ReqFields_Status",bulkUploadData);
		sleep(2000);
		//E3 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_E3Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_NonFields_Assignee",bulkUploadData);
		sleep(2000);
		click("Req_Bulkupload_Mapping_Next_Button",bulkUploadData);
		sleep(4000);

	}

	public void getErrorItems(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Validation_Details_Link",bulkUploadData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_Validation_Errors_Tab",bulkUploadData);
		sleep(1000);
	}

	public void getWarnningItems(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Validation_Warnings_Tab",bulkUploadData);
		sleep(2000);
	}

	public void getIgnoreErrorsWarnningsSelect(String bulkUploadData, String testData) throws InterruptedException, IOException {

		clickElementUsingJavaScript("Req_Bulkupload_Validation_Ignore_Select_Button",bulkUploadData);
		sleep(2000);
	}

	public void getStartOverSelect(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Source_Back_Button", bulkUploadData);
		sleep(4000);
		clickElementUsingJavaScript("Req_Bulkupload_Validation_StartOver_Select_Button",bulkUploadData);
		sleep(2000);
	}

	public void getFieldValidations(String bulkUploadData, String testData) throws InterruptedException, IOException {

		getMappingAllCells(bulkUploadData,testData);
		//E2 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_E2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_NonFields_CreatedBy",bulkUploadData);
		sleep(2000);
		//F2 cell
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_F2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_NonFields_Assignee",bulkUploadData);
		sleep(2000);
		//G2 cell
		/*clickElementUsingJavaScript("Req_Bulkupload_Mapping_XLSheet_G2Cell",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_MapValue_Link",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_SelectField_Icon",bulkUploadData);
		sleep(1000);
		clickElementUsingJavaScript("Req_Bulkupload_Mapping_NonFields_Dependency",bulkUploadData);
		sleep(2000);*/
		click("Req_Bulkupload_Mapping_Next_Button",bulkUploadData);
		sleep(4000);
		
	}
	
	public void getWarnings3(String bulkUploadData) {
		clickElementUsingJavaScript("Req_Bulkupload_Validation_Warnings3_Tab",bulkUploadData);
		sleep(2000);
	}
	public void getWarnings2(String bulkUploadData) {
		clickElementUsingJavaScript("Req_Bulkupload_Validation_Warnings2_Tab",bulkUploadData);
		sleep(2000);
	}
	public void getAllFieldsValidData(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Validation_StartOver_Select_Button",bulkUploadData);
		sleep(2000);
		getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		getMappingAllCells(bulkUploadData,testData);
		getMappingNextButton(bulkUploadData);
	}
	
	public void getConfirmationPage(String bulkUploadData, String testData) throws InterruptedException, IOException, AWTException {

		clickElementUsingJavaScript("Req_Bulkupload_Validation_ProgressNext_Select_Button",bulkUploadData);
		sleep(2000);
		getMappingNextButton(bulkUploadData);
	}
	
	public void getFullLogPage(String bulkUploadData) throws InterruptedException, IOException {
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_FullLog_Link",bulkUploadData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_FullLog_Warning2_Link",bulkUploadData);
		sleep(2000);
	}
	
	public void getProgressStagePage(String bulkUploadData, String testData) throws InterruptedException, IOException {
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_Confirm_SubmitImport_Button",bulkUploadData);
	}
	
	public void getSourceCloseButton(String bulkUploadData, String testData) throws InterruptedException, IOException {
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_Source_Close_Button",bulkUploadData);
	}
	
	public void getImportedSummaryErrorsPage(String bulkUploadData, String testData, String objectData,List<String> fileName) throws InterruptedException, IOException {
		sleep(2000);
		getRequirementsBulkUploadDetailsPage(bulkUploadData,objectData,testData);
		for(int i=0;i<fileName.size();i++) {
			getRequirementsBulkUploadTestFile(bulkUploadData,testData,fileName.get(i));
		}
		getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		getMappingPopupValidations(bulkUploadData,testData);
		getFieldValidations(bulkUploadData, testData);
		if(fileName.size()>=2) {
			sleep(8000);
		}
		getIgnoreErrorsWarnningsSelect(bulkUploadData, testData);
		getMappingNextButton(bulkUploadData);
		sleep(2000);
		getRequirementsBulkUploadBackButton(bulkUploadData);
		getMappingNextButton(bulkUploadData);
		getProgressStagePage(bulkUploadData, testData);
		
	}
	public void validateBlankWorksheetMessage(String bulkUploadData, String testData, String objectData,String fileName) throws InterruptedException, IOException {
		sleep(2000);
		getRequirementsBulkUploadDetailsPage(bulkUploadData,objectData,testData);
		getRequirementsBulkUploadTestFile(bulkUploadData,testData,fileName);
		getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		getMappingPopupValidations(bulkUploadData,testData);
		getFieldValidations(bulkUploadData, testData);
		sleep(1000);
		click("Req_Bulkupload_BlankWorksheet_Validation_Details_Link",bulkUploadData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Req_Bulkupload_BlankWorksheet_Validation_Warning_Label",bulkUploadData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public void getDirectionPage(String bulkUploadData, String testData, String objectData,String fileName) throws InterruptedException, IOException {
		sleep(2000);
		getRequirementsBulkUploadDetailsPage(bulkUploadData,objectData,testData);
		getRequirementsBulkUploadTestFile(bulkUploadData,testData,fileName);
		getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		getMappingPopupValidations(bulkUploadData,testData);
		getFieldValidations(bulkUploadData, testData);
		getIgnoreErrorsWarnningsSelect(bulkUploadData, testData);
		/*getMappingNextButton(bulkUploadData);
		sleep(2000);
		getRequirementsBulkUploadBackButton(bulkUploadData);
		getMappingNextButton(bulkUploadData);
		getProgressStagePage(bulkUploadData, testData);*/
		
		
	}

}
