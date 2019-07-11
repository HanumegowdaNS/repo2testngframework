package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class Requirements2 {

	RequirementsPage requirementsPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	
	@Test(description="Duplicating a Requirement")
	public void duplicateRequirement() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Duplicate Requirements
		 ********************************************************/
		requirementsPage.createDuplicateRequirement(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		requirementsPage.scrollToElement("Requirement_DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.sleep(1000);
		requirementsPage.validateElementDisplayed("Requirement_DuplicateText", PlutoraTestConfiguration.objectData);
		requirementsPage.deleteDuplicateRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Requirement is duplicated & deleted successfully");
	}
	
	@Test(description="Deleting the Requirements", dependsOnMethods="duplicateRequirement")
	public void deleteRequirements() throws InterruptedException, IOException, AWTException {
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			
			/*******************
			 * Delete Requirements
			 ********************************************************/
			requirementsPage.deleteRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			Listener.test1.log(Status.INFO, "Requirement : "+i+" is deleted successfully");
		}
	}
}