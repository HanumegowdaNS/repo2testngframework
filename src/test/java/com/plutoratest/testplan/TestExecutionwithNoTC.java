package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.TestExecutionPage;

public class TestExecutionwithNoTC {

	TestExecutionPage testExecutionPage = new TestExecutionPage();
	
	@Test(description="Verify no test cases are displayed")
	public void verifyNoTestCases() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Verify Testcase in testexecution
		 ******************************************/
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData,"TestPlan_Automation_Name");
		for (int i = 0; i < Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			int y = i + 1;
			testExecutionPage.clickElementUsingJavaScript("TestExecution_TestPlanName", "TestPlan_Automation_Name",
					PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
			testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
			testExecutionPage.clickElementUsingJavaScript("TestExecution_RequirementName",
					"Requirements_Automation_Name_" + y, PlutoraTestConfiguration.testExecutionData,
					PlutoraTestConfiguration.testData);
			testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
			int j = 1;
			int z = j + TestExecutionPage.evenNumberList.get(i);
			testExecutionPage.verifyTextEqualsNotDisplayedInPage("TDTC_Name_" + z);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1) + " is verified in Test Execution successfully ");
		}
	}
}