package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.TestPlanPage;

public class TestPlan {

	TestPlanPage testPlanPage = new TestPlanPage();
	
	@Test(description="Creating Test Plan")
	private void createTestPlan() throws InterruptedException, IOException, AWTException {
		/******************
		 * Create Testplan 
		 *******************************************/
		System.out.println(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1"));
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Automation_Name");
		Listener.test1.log(Status.INFO, "Test Plan created successfully ");
	}
	
	@Test(description="Verify Test Plan created", dependsOnMethods="createTestPlan")
	public void verifyTestPlan() throws InterruptedException, IOException, AWTException {
		/******************
		 * Verify Testplan
		 *******************************************/
		testPlanPage.searchTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testPlanPage.verifyText("TestPlan_Name", "TestPlan_Automation_Name", PlutoraTestConfiguration.testPlanData,
				PlutoraTestConfiguration.testData);
		Listener.test1.log(Status.INFO, "Test Plan verified successfully ");
	}
	
	@Test(description="Update Test Plan", dependsOnMethods="verifyTestPlan")
	private void updateTestPlan() throws InterruptedException, IOException, AWTException {
		/******************
		 * Update Testplan
		 *******************************************/
		testPlanPage.updateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName);
		testPlanPage.sleep(4000);
//		testPlanPage.verifyTextContains("TestPlan_UploadFileName",
//				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "ImageName"),
//				PlutoraTestConfiguration.testPlanData);
		testPlanPage.clickOnCancelButton(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan updated & verified successfully");
	}
	}