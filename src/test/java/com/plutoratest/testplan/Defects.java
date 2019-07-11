package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.DefectsPage;

public class Defects {
	
	DefectsPage defectsPage = new DefectsPage();
	
	@Test(description="Creating Defects")
	public void createDefect() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Create Defects
		 ********************************************************/
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName, 1);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name1"),
				PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect created successfully ");
	}

	@Test(description="Verifying defect is created", dependsOnMethods="createDefect")
	public void verifyDefect() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Verify Defects
		 ********************************************************/
		defectsPage.validateElementDisplayed("Defect_FirstRow", PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect verified successfully ");
	}
	
	@Test(description="Update the defect", dependsOnMethods="verifyDefect")
	public void updateDefect() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Update Defects
		 ********************************************************/
		defectsPage.updateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.sleep(2000);
		defectsPage.verifyText("Defect_Req_Added_Text", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.test1.log(Status.INFO, "New Defect updated successfully ");
		defectsPage.clickOnCloseButton(PlutoraTestConfiguration.defectsData);
	}

	@Test(description="Duplicating a defect", dependsOnMethods="updateDefect")
	public void duplicateDefect() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Duplicate Defects
		 ********************************************************/
		defectsPage.duplicateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.validateElementDisplayed("Defect_DuplicateRow", PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect duplicated successfully ");
	
		defectsPage.deleteDuplicateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.verifyTextContainsNotDisplayedInPage(DefectsPage.defectDupID);
		Listener.test1.log(Status.INFO, "New Defect Duplicate deleted successfully ");
	}

	@Test(description="Deleting a Defect", dependsOnMethods="duplicateDefect")
	public void deleteDefect() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Delete Defects
		 ********************************************************/
		defectsPage.deleteDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, "Defect_Name1");
		defectsPage.verifyTextContainsNotDisplayedInPage(DefectsPage.defectID);
		Listener.test1.log(Status.INFO, "New Defect deleted successfully ");
	}
}