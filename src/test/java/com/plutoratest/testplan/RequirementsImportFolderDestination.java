package com.plutoratest.testplan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutoratest.pagerepo.RequirementsBulkUploadPage;

public class RequirementsImportFolderDestination {
	RequirementsBulkUploadPage requirementsBulkUploadPage = new RequirementsBulkUploadPage();
	
	@Test(description = "Requirements Bulk Upload:Destination")
	public void requirementsImportFolderDestination_01() throws InterruptedException, IOException {
		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData);
		//verify destination label
		requirementsBulkUploadPage.verifyText("Req_Bulkupload_Destination_Label", "Destination",PlutoraTestConfiguration.requirementsBulkUploadData);
		//Go to direction page
		requirementsBulkUploadPage.getDirectionPage(PlutoraTestConfiguration.requirementsBulkUploadData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "TestFile.xlsx");
		
	}

	@Test(description = "Requirements Bulk Upload:Destination")
	public void requirementsImportFolderDestination_02() {
		requirementsBulkUploadPage.getRequirementsBulkUploadDetailsPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData);
	}

}