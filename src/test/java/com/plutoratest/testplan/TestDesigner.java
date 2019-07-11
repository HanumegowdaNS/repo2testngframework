package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;

public class TestDesigner {
	
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();
	
	@Test(description="Creating Test cases for requirements")
	public void createTestCase() throws InterruptedException, IOException, AWTException {
		
		testExecutionPage.addEvenNumbersToList();
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Automation_Name");
		for (int i = 0; i < Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, (i+1));
			int j = 1;
			int z = j + TestExecutionPage.evenNumberList.get(i);
			testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, z, i + 1);
			testDesignerPage.sleep(2000);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1) + " created successfully ");
		}
	}
	
	@Test(description="Verify test case created", dependsOnMethods="createTestCase")
	public void verifyTestCase() throws InterruptedException, IOException, AWTException {

		for (int i = 0; i < Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, (i+1));
			int j = 1;
			int z = j + TestExecutionPage.evenNumberList.get(i);
			testDesignerPage.verifyText("TDTC_TestcaseName", "TDTC_Name_" + z,
					PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1) + " verified successfully ");
		}
	}
	
	@Test(description="Duplicating Test case", dependsOnMethods="verifyTestCase")
	public void duplicateTestCase() throws InterruptedException, IOException, AWTException {

		for (int i = 0; i < Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, (i+1));
			int j = 1;
			int z = j + TestExecutionPage.evenNumberList.get(i);
			testDesignerPage.createDuplicateTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);

			String TDTC_Name = PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name_" + z)
					+ "_Copy";
			testDesignerPage.verifyText("TDTC_TestcaseName", TDTC_Name, PlutoraTestConfiguration.testDesignerData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1)+ " duplicated successfully ");
		}
	}
	
	@Test(description="Update Test Case", dependsOnMethods="duplicateTestCase")
	public void updateTestCase() throws InterruptedException, IOException, AWTException {
		testDesignerPage.updateTestcase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.clickOnTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.sleep(2000);
		testDesignerPage.verifyTextWithAttributeValue("TDTC_PreCondtion_Textarea", "TDTC_Precondition",
				PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,"value");
		testDesignerPage.sleep(1000);
		testDesignerPage.clickOnCloseButton(PlutoraTestConfiguration.testDesignerData);
		testDesignerPage.sleep(2000);
		Listener.test1.log(Status.INFO, "Test Designer New Test Case updated & verified successfully");
	}
}