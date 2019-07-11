package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.TestExecutionPage;

public class TestExecutionwithTC {

	TestExecutionPage testExecutionPage = new TestExecutionPage();
	
	@Test(description="Verifing test cases in test execution", groups={"group1"})
	public void verifyTestCases() throws InterruptedException, IOException, AWTException {
		/********************
		 * Verify testcase in Testexecution Section
		 ******************************************/
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData,"TestPlan_Automation_Name");
		testExecutionPage.verifyText("TestExecution_TestPlanName", "TestPlan_Automation_Name",
				PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
		int x = 0;
		for (int i = 0; i < Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			testExecutionPage.clickElementUsingJavaScript("TestExecution_TestPlanName", "TestPlan_Automation_Name",
					PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
			testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
			x = i + 1;
			testExecutionPage.verifyText("TestExecution_RequirementName", "Requirements_Automation_Name_" + x,
					PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
			testExecutionPage.clickElementUsingJavaScript("TestExecution_RequirementName",
					"Requirements_Automation_Name_" + x, PlutoraTestConfiguration.testExecutionData,
					PlutoraTestConfiguration.testData);
			testExecutionPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);

			int j = 1;
			int z = j + TestExecutionPage.evenNumberList.get(i);
			testExecutionPage.verifyText("TestExecution_TestcaseName", "TDTC_Name_" + z,
					PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1) + " is verified in Test Execution successfully ");
			
			testExecutionPage.verifyTestCaseFolderName("TDTC_Name_" + z, "TestPlan_Automation_Name",
					PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case folder : " + (i+1)+ " is verified in Test Execution successfully ");
			
			testExecutionPage.verifyTestCaseAssigneeName("TDTC_Name_" + z, "TestPlan_Automation_Name",
					PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case assignee : " + (i+1)+ " is verified in Test Execution successfully ");
		}
	}
}