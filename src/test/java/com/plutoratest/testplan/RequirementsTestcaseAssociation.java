package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutoratest.pagerepo.RequirementsBulkUploadPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class RequirementsTestcaseAssociation {
	RequirementsBulkUploadPage requirementsBulkUploadPage = new RequirementsBulkUploadPage();
	RequirementsPage requirementPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	
	@Test(description = "Bulk Upload - Test Case to Requirment Association Source")
	public void requirementsImportFolderDestination_01() throws InterruptedException, IOException, AWTException {
		//Create requirement
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
							PlutoraTestConfiguration.objectData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
							PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
							CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
						
		//Create testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
						PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
				
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		requirementsBulkUploadPage.clickOnBulkUploadDetailsPage(PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData);
		String stepsData = requirementsBulkUploadPage.getRequirementsBulkUploadStepDetails(PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepsList", stepsData,PlutoraTestConfiguration.testData);
		String sourceColor = requirementsBulkUploadPage.getRequirementsBulkUploadSourceColor(PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", sourceColor,PlutoraTestConfiguration.testData);
		Listener.addLogger("The process steps are displayed and the 'Source' step is in green as expected.");
		//source drop file container & browse local computer button
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Dropfile_Container",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Browse_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		Listener.addLogger("The Drop file container & upload option  is displayed as expected.");
		//source notes
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_1", "BulkUploadSourceNotePoint1",PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_2", "BulkUploadSourceNotePoint2",PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Notes_3", "BulkUploadSourceNotePoint3",PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		Listener.addLogger("The Drop file container & upload option  is displayed as expected.");
		//source cancel & x button
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Cancel_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_X_Button",PlutoraTestConfiguration.requirementsBulkUploadData);
		Listener.addLogger("Both the 'Cancel' button and the 'X' icon are located as expected.");
		//Upload xls file
		requirementsBulkUploadPage.getRequirementsBulkUploadFile(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,"TestCase_Association");
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_SelectedFile_Text", "BulkUploadSourceSelectedFileText",PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_Uploaded_Filename", "TestCase_Association",PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.testData);
		Listener.addLogger("The file will be displayed in the 'Source' container and '1 File Selected' will be displayed as expected.");
		//Cell & Column Mapping & Example elements
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_CellMapping_Text", "BulkUploadSourceCellMappingText",PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_CellMapping_SelectButton",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Source_ColumnMapping_Text", "BulkUploadSourceColumnMappingText",PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_ColumnMapping_SelectButton",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Source_Example_Link",PlutoraTestConfiguration.requirementsBulkUploadData);
		Listener.addLogger("Both mapping options, 'Select' buttons and 'Example' link are displayed as expected.");
		//Select mapping
		requirementsBulkUploadPage.getRequirementsBulkUploadSelectCellMapping(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_Header_Text",PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.getRequirementsBulkUploadSelectColumnMapping(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData);
		requirementsBulkUploadPage.isElementPresent("Req_Bulkupload_Mapping_Header_Text",PlutoraTestConfiguration.requirementsBulkUploadData);
		//color
		String mappingCircleColor = requirementsBulkUploadPage.getRequirementsBulkUploadMappingColor(PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepCircleColor", mappingCircleColor, PlutoraTestConfiguration.testData);
		String mappingLeftLineColor = requirementsBulkUploadPage.getRequirementsBulkUploadMappingLeftLineColor(PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyTextFromTestData("BulkUploadSourceStepLeftLineColor", mappingLeftLineColor, PlutoraTestConfiguration.testData);
		Listener.addLogger("The 'Mapping' screen is displayed and the progress bar has moved to the 'Mapping' step.");
		//Example
		boolean flag = requirementsBulkUploadPage.getRequirementsBulkUploadExampleLink(PlutoraTestConfiguration.requirementsBulkUploadData);
		requirementsBulkUploadPage.verifyTrue(flag);
		Listener.addLogger("User will be taken to the cell mapping example screen.");
		
		
		
	}

	@Test(description = "Requirements Bulk Upload:Destination")
	public void requirementsImportFolderDestination_02() {
		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData);
	}

}