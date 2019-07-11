package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.RequirementsBulkUploadPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.SettingPage;

public class RequirementsBulkUpload {
	RequirementsBulkUploadPage requirementsBulkUploadPage = new RequirementsBulkUploadPage();
	SettingPage settingPage = new SettingPage();
	RequirementsPage requirementPage = new RequirementsPage();
	
	@Test(description = "Requirements Bulk Upload:Source")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsBulkUpload_01(String bulkUploadData, String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {
		//source landing page
		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(bulkUploadData,objectData,testData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Source_Header_Text","BulkUploadSourceHeaderText",bulkUploadData,testData);
		Listener.addLogger("Stryka 'Bulk Upload' screen is displayed as expected.");
		//source elements verification
		String stepsData = requirementsBulkUploadPage.getRequirementsBulkUploadStepDetails(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepsList", stepsData,testData);
		String sourceColor = requirementsBulkUploadPage.getRequirementsBulkUploadSourceColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", sourceColor,testData);
		Listener.addLogger("The process steps are displayed and the 'Source' step is in green as expected.");
		//source drop file container & browse local computer button
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Dropfile_Container",bulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Browse_Button",bulkUploadData);
		Listener.addLogger("The Drop file container & upload option  is displayed as expected.");
		//source notes
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_1", "BulkUploadSourceNotePoint1",bulkUploadData,testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_2", "BulkUploadSourceNotePoint2",bulkUploadData,testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_3", "BulkUploadSourceNotePoint3",bulkUploadData,testData);
		Listener.addLogger("The Drop file container & upload option  is displayed as expected.");
		//source cancel & x button
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Cancel_Button",bulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_X_Button",bulkUploadData);
		Listener.addLogger("Both the 'Cancel' button and the 'X' icon are located as expected.");
		//Upload xls file
		requirementsBulkUploadPage.getRequirementsBulkUploadFile(bulkUploadData,testData,"BulkUploadSourceXlsFileName");
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_SelectedFile_Text", "BulkUploadSourceSelectedFileText",bulkUploadData, testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Uploaded_Filename", "BulkUploadSourceXlsFileName",bulkUploadData, testData);
		Listener.addLogger("The file will be displayed in the 'Source' container and '1 File Selected' will be displayed as expected.");
		//Cell & Column Mapping & Example elements
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_CellMapping_Text", "BulkUploadSourceCellMappingText",bulkUploadData, testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_CellMapping_SelectButton",bulkUploadData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_ColumnMapping_Text", "BulkUploadSourceColumnMappingText",bulkUploadData, testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_ColumnMapping_SelectButton",bulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Example_Link",bulkUploadData);
		Listener.addLogger("Both mapping options, 'Select' buttons and 'Example' link are displayed as expected.");
		//Select mapping
		requirementsBulkUploadPage.getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_Header_Text",bulkUploadData);
		requirementsBulkUploadPage.getRequirementsBulkUploadSelectColumnMapping(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_Header_Text",bulkUploadData);
		//color
		String mappingCircleColor = requirementsBulkUploadPage.getRequirementsBulkUploadMappingColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", mappingCircleColor, testData);
		String mappingLeftLineColor = requirementsBulkUploadPage.getRequirementsBulkUploadMappingLeftLineColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepLeftLineColor", mappingLeftLineColor, testData);
		Listener.addLogger("The 'Mapping' screen is displayed and the progress bar has moved to the 'Mapping' step.");
		//Example
		boolean flag = requirementsBulkUploadPage.getRequirementsBulkUploadExampleLink(bulkUploadData);
		requirementsBulkUploadPage.verifyTrue(flag);
		Listener.addLogger("User will be taken to the cell mapping example screen.");

	}

	@Test(description = "Requirements Bulk Upload:Mapping")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsBulkUpload_02(String bulkUploadData, String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {
		//************************
		//requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(bulkUploadData,objectData);
		//************************
		//mapping landing page
		requirementsBulkUploadPage.getCloseUploadedFile(bulkUploadData, testData, platform);
		requirementsBulkUploadPage.getMappingPage(bulkUploadData,testData,"BulkUploadSourceXlsTestFileName");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_Header_Text",bulkUploadData);
		Listener.addLogger("The 'Mapping' screen is displayed as expected.");
		//mapping elements verification
		String stepsData = requirementsBulkUploadPage.getRequirementsBulkUploadStepDetails(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepsList", stepsData,testData);
		String mappingCircleColor = requirementsBulkUploadPage.getRequirementsBulkUploadMappingColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", mappingCircleColor, testData);
		Listener.addLogger("The process steps are displayed and the 'Mapping' step is in green as expected.");
		//mapping mandatory fields validation
		requirementsBulkUploadPage.getMappingPopupValidations(bulkUploadData,testData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_TextAutomation_Selected_Text", "BulkUploadMappingSelectedReleaseName",bulkUploadData, testData);
		Listener.addLogger("The relevant project has been selected successfully.");
		requirementsBulkUploadPage.getMappingNextButton(bulkUploadData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Mapping_Popup_Message", "BulkUploadMappingPopupMessage",bulkUploadData, testData);
		String warningDataList = requirementsBulkUploadPage.getMappingWarningList(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadMappingWarningList", warningDataList,testData);
		Listener.addLogger("The warning message is displayed as expected.");
		//mapping
		requirementsBulkUploadPage.getWarningPopupClose(bulkUploadData,testData);
		requirementsBulkUploadPage.getMappingFirstCell(bulkUploadData,testData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Mapping_CopyValue_Popup_Header", "BulkuploadMappingCopyValuePopupHeader",bulkUploadData, testData);
		Listener.addLogger("A pop up dialog box with the message \"Copy the value from (insert cell) into:\" is displayed with a drop down menu of mapping fields as expected.");
		requirementsBulkUploadPage.getMappingCellsRequiredFields(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_ReqFields_Text",bulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_NonReqFields_Text",bulkUploadData);
		String popupRequiredList = requirementsBulkUploadPage.getMappingPopupFieldsList(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadMappingPopupReqList", popupRequiredList,testData);
		Listener.addLogger("The drop down should be separated into Required Fields with asterisk and Non-Required fields and sorted alphabetically.");
		//clear mappings
		requirementsBulkUploadPage.getClearMappingCells(bulkUploadData,testData);
		requirementsBulkUploadPage.verifyTextAttributeClassContains("Req_Bulkupload_Mapping_XLSheet_B2Cell", "BulkUploadMappingClearMapClassValue",bulkUploadData, testData);
		Listener.addLogger("All mappings should be deleted as expected.");
		//mapping all fields
		requirementsBulkUploadPage.getMappingAllCells(bulkUploadData,testData);
		requirementsBulkUploadPage.getMappingNextButton(bulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Header_Text",bulkUploadData);
		Listener.addLogger("The mappings are all saved successfully and the next step in the process is displayed.");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Checked_Text",bulkUploadData);
		Listener.addLogger("All required fields have at least one field/column mapped as expected.");
	}

	@Test(description = "Requirements Bulk Upload:Validation")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsBulkUpload_03(String bulkUploadData, String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {

		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Header_Text",bulkUploadData);
		Listener.addLogger("The 'Validation' screen should be displayed.");
		requirementsBulkUploadPage.getRequirementsBulkUploadBackButton(bulkUploadData);
		requirementsBulkUploadPage.getRequirementsBulkUploadErrorMapping(bulkUploadData, testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Error_Text",bulkUploadData);
		Listener.addLogger("Error should be displayed at \"Sheet 1, A?. field name is empty\". Errors and count should show.");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Warnning_Text",bulkUploadData);
		Listener.addLogger("Warning should be displayed at \"Sheet 1, A?. field name is empty\".. Warnings and count should show.");
		//Error items
		requirementsBulkUploadPage.getErrorItems(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Errors_Items",bulkUploadData);
		//warnning items
		requirementsBulkUploadPage.getWarnningItems(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Warning_Items",bulkUploadData);
		Listener.addLogger("Details of the Errors/Warnings should be displayed. For example: Field \"<insert name> in <insert cell#> is empty.");
		//Select Ignore Errors & Warnnings
		requirementsBulkUploadPage.getIgnoreErrorsWarnningsSelect(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Destination_Header_Text",bulkUploadData);
		Listener.addLogger("All records containing errors will be skipped during import and all records containing warnings will be imported with system default field values.");
		//Select Start Over
		requirementsBulkUploadPage.getStartOverSelect(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_HeaderOption_Text",bulkUploadData);
		Listener.addLogger("User should be able to correct the errors in the upload file and start over again.");
		//Field validations - 2 to 4
		requirementsBulkUploadPage.getRequirementsBulkUploadSelectCellMapping(bulkUploadData,testData);
		requirementsBulkUploadPage.getFieldValidations(bulkUploadData,testData);
		requirementsBulkUploadPage.getWarnings2(bulkUploadData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Validation_Warning_Date_Text","BulkUploadValidationDateWarningText",bulkUploadData,testData);
		Listener.addLogger("Date fields with an invalid format.");
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Validation_Warning_Name_Text","BulkUploadValidationNameWarningText",bulkUploadData,testData);
		Listener.addLogger("User Names that do not match.");
		//requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Validation_Warning_Dropdown_Text","BulkUploadValidationDropdownWarningText",bulkUploadData,testData);
		//Listener.addLogger("Drop down field values that do not match.");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Warnings2_Tab",bulkUploadData);
		Listener.addLogger("Errors/Warnings and count should be displayed.");
		//All fields have valid data
		requirementsBulkUploadPage.getAllFieldsValidData(bulkUploadData,testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Validation_AllValidData_Text","BulkUploadValidationAllFieldsValidData",bulkUploadData,testData);
		Listener.addLogger("Error and Warning should be displayed at \"All fields have valid data\". Errors/Warnings and count should show.");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_Checked_Text",bulkUploadData);
		Listener.addLogger("The validation screen will display a \"Checked\" button in green if check on all required fields and subsequent tabs is successful.");
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Validation_ProgressNext_Select_Button",bulkUploadData);
		Listener.addLogger("A 'Select' button should be available for user to select where requirements would be imported to.");

	}

	@Test(description = "Requirements Bulk Upload:Confirmation")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsBulkUpload_04(String bulkUploadData, String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {

		requirementsBulkUploadPage.getConfirmationPage(bulkUploadData,testData);
		String confirmColor = requirementsBulkUploadPage.getRequirementsBulkUploadConfirmColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", confirmColor,testData);
		Listener.addLogger("'Confirmation' screen will be displayed and the progress button should be in green.");
		//Source file section
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Confirm_SourceFile_Name","BulkUploadSourceXlsTestFileName",bulkUploadData,testData);
		Listener.addLogger("The uploaded files and the file name should be displayed in the 'Sources' section.");
		//upload overview section
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Confirm_Imported_Text","BulkUploadConfirmImportedText",bulkUploadData,testData);
		Listener.addLogger("Total Number of Requirements text displayed.");
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Confirm_Skipped_Text","BulkUploadConfirmSkippedText",bulkUploadData,testData);
		Listener.addLogger("Total Number of requirements that will be skipped due to Errors text displayed.");
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_Confirm_Warning_Text","BulkUploadConfirmWarningText",bulkUploadData,testData);
		Listener.addLogger("Total number requirements with warnings text displayed.");
		//'Imported', Skipped' and 'Warning' are color coded
		String importedCountColor = requirementsBulkUploadPage.getRequirementsBulkUploadConfirmImported(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadConfirmImportedColor", importedCountColor,testData);
		Listener.addLogger("'Imported' count displayed and the count color should be in green.");
		String skippedCountColor = requirementsBulkUploadPage.getRequirementsBulkUploadConfirmSkipped(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadConfirmSkippedColor", skippedCountColor,testData);
		Listener.addLogger("'Skipped' count displayed and the count color should be in red.");
		String warningCountColor = requirementsBulkUploadPage.getRequirementsBulkUploadConfirmWarning(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadConfirmWarningColor", warningCountColor,testData);
		Listener.addLogger("'Warnning' count displayed and the count color should be in orange.");
		requirementsBulkUploadPage.getProgressStagePage(bulkUploadData,testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Confirm_Progressing_Text",bulkUploadData);
		Listener.addLogger("On clicking 'Submit and Import', UI change to progressing stage.");

	}

	@Test(description = "Requirements Bulk Upload:Import")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile"})
	public void requirementsBulkUpload_05(String bulkUploadData, String testData, String objectData) throws InterruptedException, IOException {

		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Import_ProgressingCount_Text","BulkUploadConfirmNoOfRequirementCount",bulkUploadData,testData);
		Listener.addLogger("On clicking 'Submit and Import', UI change to processing stage. User will see \"Uploading in progress\" and the number of requirements completed.");
		requirementsBulkUploadPage.getSourceCloseButton(bulkUploadData,objectData);
		List<String> uploadFileName=new ArrayList<String>();
		uploadFileName.add("BulkUploadSourceXlsTestFileName");
		requirementsBulkUploadPage.getImportedSummaryErrorsPage(bulkUploadData,testData,objectData,uploadFileName);
		//data validation records
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Import_SkipRecord_Count",bulkUploadData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Import_SkipRecord_Count","BulkUploadConfirmSkipedRecordCount",bulkUploadData,testData);
		Listener.addLogger("System should validate the data types and should skip records those do not pass the data validation.");
	}

	@Test(description = "Requirements Bulk Upload:Summary of Results")
	@Parameters({"requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsBulkUpload_06(String bulkUploadData, String testData, String objectData, String platform) throws InterruptedException, IOException {

		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Summary_HeaderOption_Text",bulkUploadData);
		//color
		String mappingCircleColor = requirementsBulkUploadPage.getRequirementsBulkUploadSummaryColor(bulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", mappingCircleColor, testData);
		Listener.addLogger("The 'Summary of results' screen will open and the progress button is in green colour.");
		//Summary of results overview section
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_SummaryRow1_Text","BulkUploadSummaryRow1Text",bulkUploadData,testData);
		Listener.addLogger("Total Number of records successfully created text displayed.");
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_SummaryRow3_Text","BulkUploadSummaryRow3Text",bulkUploadData,testData);
		Listener.addLogger(" Total number records created with warnings (Missing information) text displayed.");
		//requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_SummaryRow4_Text","BulkUploadSummaryRow4Text",bulkUploadData,testData);
		//Listener.addLogger("Total Number of records that will be skipped due to validation errors text displayed.");
		//Full Log section
		requirementsBulkUploadPage.getFullLogPage(bulkUploadData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_ErrorLog_Text1","BulkUploadSummaryLogResultText1",bulkUploadData,testData);
		requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_ErrorLog_Text2","BulkUploadSummaryLogResultText2",bulkUploadData,testData);
		//requirementsBulkUploadPage.verifyTextContains("Req_Bulkupload_ErrorLog_Text3","BulkUploadSummaryLogResultText3",bulkUploadData,testData);
		Listener.addLogger("A full error log on screen should include details of the skipped records and associated error.");
		requirementsBulkUploadPage.getSourceCloseButton(bulkUploadData, testData);
		
	}
	
	@Test(description = "Requirements Bulk Upload: Permission")
	public void requirementsBulkUpload_07() throws InterruptedException, IOException {
		//Disable Requirement bulk upload 
		settingPage.gotoSettingPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.gotoUserManagementPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.disableRequirementBulkUpload(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		//Verify Bulk Upload button
		requirementsBulkUploadPage.refresh(PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.baseUrl,"Progress_Bar");
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.verifyTextEqualsNotDisplayedInPage("Bulk Upload");
		Listener.addLogger("Bulk Upload Not displayed successfully !");
		//Enable requirement bulk upload
		settingPage.gotoSettingPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.gotoUserManagementPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.disableRequirementBulkUpload(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		
		//Verify Bulk Upload button
		requirementsBulkUploadPage.refresh(PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.baseUrl,"Progress_Bar");
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.verifyTextDisplayedInPage("Bulk Upload");
		Listener.addLogger("Bulk Upload displayed successfully !");
		
	}
	@Test(description = "Requirements Bulk Upload: Performance")
	public void requirementsBulkUpload_08() throws InterruptedException, IOException {
		//Verify Blank worksheet
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsBulkUploadPage.validateBlankWorksheetMessage(PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"BlankWorkSheetName");
		requirementsBulkUploadPage.validateElementDisplayed("Req_Bulkupload_BlankWorksheet_Validation_Warning_Text", PlutoraTestConfiguration.requirementsBulkUploadData);;
		Listener.addLogger("One or more sheets were blank and will be excluded displayed successfully !");
		requirementsBulkUploadPage.click("Req_Bulkupload_Source_Cancel_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.sleep(2000);
		
		//Upload multiple Files
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		List<String> uploadFileName=new ArrayList<String>();
		uploadFileName.add("BulkUploadSourceXlsTestFileName");
		uploadFileName.add("BulkUploadSourceXlsTestSecondFileName");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"TestFile");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 1, PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_One") );
		String excelFileOne=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"TestFile2");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFileOne, "Sheet1", 1, 1, PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_Two") );
		requirementsBulkUploadPage.getImportedSummaryErrorsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,uploadFileName);
		Listener.addLogger("Multiple Files uploaded successfully !");
		requirementsBulkUploadPage.click("Req_Bulkupload_Source_Cancel_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.sleep(2000);
		
		//Verify Requirements 
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirement_Bulk_Import_One");
		requirementPage.verifyText("Requirements_Name", "Requirement_Bulk_Import_One",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_One")+" Uploaded successfully !");
		
		
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirement_Bulk_Import_Two");
		requirementPage.verifyText("Requirements_Name", "Requirement_Bulk_Import_Two",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_Two")+" Uploaded successfully !");
	}
	@Test(description = "Requirements created in Requirements module")
	public void requirementsBulkUpload_09() throws InterruptedException, IOException {
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData);
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"TestFile");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 1, PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_One"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 2, PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_Description"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 3, "Pending" );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 4, "Category");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 7, PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Loggedin_Username_Value") );
		List<String> uploadFileName=new ArrayList<String>();
		uploadFileName.add("BulkUploadSourceXlsTestFileName");
		requirementsBulkUploadPage.getImportedSummaryErrorsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,uploadFileName);
		requirementsBulkUploadPage.click("Req_Bulkupload_Source_Cancel_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.sleep(2000);
		
		//Verify Requirements 
		requirementPage.refresh(PlutoraTestConfiguration.objectData, "", "Progress_Bar");
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirement_Bulk_Import_One");
		//Verify Requirement Name
		requirementPage.verifyText("Requirements_Name", "Requirement_Bulk_Import_One",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_One")+" Uploaded successfully !");
		//Verify Requirement Description
		requirementPage.verifyText("Requirements_Description", "Requirement_Bulk_Import_Description",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Description")+" Uploaded successfully !");
		//Verify Requirement Status
		requirementPage.verifyText("Requirements_Status", "Pending",
				PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Pending"+" Uploaded successfully !");
		//Verify Requirement Category
		/*requirementPage.verifyText("Requirements_Name", "Requirement_Bulk_Import_One",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import_One")+" Uploaded successfully !");
		*/
		//Verify Requirement Assignee
		/*requirementPage.verifyText("Requirements_Assignee",PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Loggedin_Username_Value").split(" ")[0].charAt(0)+""+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Loggedin_Username_Value").split(" ")[1].charAt(0) ,
				PlutoraTestConfiguration.requirementsData);*/
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Loggedin_Username_Value")+" Uploaded successfully !");
		
	}
	

}