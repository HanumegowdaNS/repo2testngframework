package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.TestDesignerPage;

public class TestCase {
	
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	
	@Test(description="Deleting all test cases")
	public void deleteTestCases() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Delete Duplicate & Original Testcases
		 ******************************************/
		testDesignerPage.clickOnTestDesignerButton(PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Automation_Name");
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			testDesignerPage.deleteTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			testDesignerPage.deleteTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			testDesignerPage.sleep(2000);
			Listener.test1.log(Status.INFO, "Test Designer : "+i+" New Test Case duplicate deleted successfully ");
			testDesignerPage.verifyTextEqualsNotDisplayedInPage(
					PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name_" + i));
			Listener.test1.log(Status.INFO, "Test Designer : "+i+" New Test Case deleted successfully ");

		}
	}
}