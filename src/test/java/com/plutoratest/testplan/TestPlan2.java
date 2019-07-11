package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class TestPlan2 {

	RequirementsPage requirementsPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	
	@Test(description="Duplicating a Test Plan")
	public void duplicateTestPlan() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Duplicate testplan
		 ********************************************************/
		testPlanPage.createDuplicateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testPlanPage.scrollToElement("DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.sleep(2000);
		requirementsPage.validateElementDisplayed("DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.deleteDuplicateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan is duplicated successfully");
	}
	
	@Test(description="Deleting a Test Plan", dependsOnMethods="duplicateTestPlan")
	public void deleteTestPlan() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Delete testplan
		 ********************************************************/
		testPlanPage.deleteTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan is deleted successfully");
	}
}
	