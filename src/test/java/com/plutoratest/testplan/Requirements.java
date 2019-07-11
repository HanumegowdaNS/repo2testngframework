package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.RequirementsPage;

public class Requirements {
	RequirementsPage requirementsPage = new RequirementsPage();
	
	@Test(description = " Create Multiple Requirements")
	public void createRequirements() throws InterruptedException, IOException, AWTException {
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			requirementsPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.objectData);
			requirementsPage.createRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
					CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, i);
			Listener.test1.log(Status.INFO, "Requirement : " + i + " created successfully ");
		}
	}
	
	@Test(description = " Verify Requirements Created", dependsOnMethods="createRequirements")
	public void verifyRequirements() throws InterruptedException, IOException, AWTException {
		/********************
		 * Verify Requirements
		 *******************************************/
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			requirementsPage.searchRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			requirementsPage.verifyText("Requirements_Id", "Requirements_Automation_Id_" + i,
					PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
			requirementsPage.verifyText("Requirements_Name", "Requirements_Automation_Name_" + i,
					PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Requirement : " + i + " verified successfully ");
		}
	}
	
	@Test(description="Update a Requirement", dependsOnMethods="verifyRequirements")
	private void updateRequirement() throws InterruptedException, IOException, AWTException {
		/********************
		 * Update & Verify Requirements
		 *******************************************/
		requirementsPage.updateRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		requirementsPage.verifyText("Requirements_CommentText", "Requirements_Comment",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		requirementsPage.clickOnCloseButton(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Requirement Updated & Verified successfully ");
	}
	

	
}