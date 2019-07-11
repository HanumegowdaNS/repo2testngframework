package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class RequirementSearchAssociation {
	RequirementsPage requirementsPage = new RequirementsPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();
	RequirementsPage requirementPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	
	@Test(description = "Associated Requirements: Ability to Search for Associated Requirements in 'Test Designer' edit screen")
	public void requirementSearchAssociation_01() throws InterruptedException, IOException, AWTException {
	 //Create requirement
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.objectData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
					CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirements_Automation_Name_1");
		String requirementExtID=requirementPage.getExtIDRequirement(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,"Requirements_Automation_Name_1");
		
				
		//Create testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		
		//Create Testcase
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, 1,  1);

		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		testDesignerPage.associateRequirementWithTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData, "TestPlan_Name_1","Requirements_Automation_Name_1","TDTC_Name_1",requirementExtID,PlutoraTestConfiguration.objectData);
		
		//Close test execution
		testDesignerPage.clickElementUsingJavaScript("TDTC_Close_Icon",PlutoraTestConfiguration.testDesignerData);
		testDesignerPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		
		testDesignerPage.refresh(PlutoraTestConfiguration.objectData,"","Progress_Bar");
		//Associate requirements using requirement name
		testDesignerPage.associateRequirementWithTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData, "TestPlan_Name_1","Requirements_Automation_Name_1","TDTC_Name_1",PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1"),PlutoraTestConfiguration.objectData);
		testDesignerPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		//Close test designer
		testDesignerPage.clickElementUsingJavaScript("TDTC_Close_Icon",PlutoraTestConfiguration.testDesignerData);
		testDesignerPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		
		//Delete requirement
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData,
						PlutoraTestConfiguration.objectData);
		requirementPage.deleteRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
				
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testDesignerPage.verifyTextEqualsNotDisplayedInPage("Requirements_Automation_Name_1",PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1")+" not displayed successfully !");
		
	}


	@Test(description = "Associated Requirements: Ability to Search for Associated Requirements in 'Test Designer' edit screen")
	public void requirementSearchAssociation_02() throws InterruptedException, IOException, AWTException {
		
		//Create requirement
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirements_Automation_Name_1");
		String requirementExtID=requirementPage.getExtIDRequirement(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,"Requirements_Automation_Name_1");
		
		//Create testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		
		//Create Testcase
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, 1,  1);
		//associate requirements using requirement name
		testExecutionPage.associateTestExecution(PlutoraTestConfiguration.testExecutionData,PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Requirements_Automation_Name_1","TestPlan_Name_1","TDTC_Name_1",PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1"));
	
		//Close test execution
		testExecutionPage.clickElementUsingJavaScript("TestExecution_Close_Icon",PlutoraTestConfiguration.testExecutionData);
		testExecutionPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		
		//Associate requirements using Ext ID
		testExecutionPage.associateTestExecution(PlutoraTestConfiguration.testExecutionData,PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Requirements_Automation_Name_1","TestPlan_Name_1","TDTC_Name_1",requirementExtID);
		
		//Close test execution
		testExecutionPage.clickElementUsingJavaScript("TestExecution_Close_Icon",PlutoraTestConfiguration.testExecutionData);
		testExecutionPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		
		//Delete requirement
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementPage.deleteRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "TestPlan_Name_1");
		testExecutionPage.verifyTextEqualsNotDisplayedInPage("Requirements_Automation_Name_1",PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1")+" not displayed successfully !");
	}
	

	@Test(description = "Associated Requirements: Ability to Search for Associated Requirements in 'Test Designer' edit screen")
	public void requirementSearchAssociation_03() throws InterruptedException, IOException, AWTException {
	//Create requirement
			requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
						PlutoraTestConfiguration.objectData);
			requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
						PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
						CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
			requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirements_Automation_Name_1");
			String requirementExtID=requirementPage.getExtIDRequirement(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,"Requirements_Automation_Name_1");
			
					
			//Create testplan
			testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
			testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
					PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
			
			//Create Testcase
			testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
					PlutoraTestConfiguration.objectData);
			testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
			testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
						PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
			testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
						PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
						PlutoraTestConfiguration.platformName, 1,  1);

			testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
			testDesignerPage.associateRequirementWithTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData, "TestPlan_Name_1","Requirements_Automation_Name_1","TDTC_Name_1",requirementExtID,PlutoraTestConfiguration.objectData);
			
			//Close test execution
			testDesignerPage.clickElementUsingJavaScript("TDTC_Close_Icon",PlutoraTestConfiguration.testDesignerData);
			testDesignerPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
			
			//Associate requirements using requirement name
			testDesignerPage.associateRequirementWithTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData, "TestPlan_Name_1","Requirements_Automation_Name_1","TDTC_Name_1",PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1"),PlutoraTestConfiguration.objectData);
			
			//Close test designer
			testDesignerPage.clickElementUsingJavaScript("TDTC_Close_Icon",PlutoraTestConfiguration.testDesignerData);
			testDesignerPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);

	}


}