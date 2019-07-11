package com.plutoratest.testplan;

import com.plutoratest.pagerepo.LoginPage;
import com.plutoratest.pagerepo.LogoutPage;
import com.plutoratest.pagerepo.DefectsPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;
import com.plutoratest.pagerepo.TestPlanPage;
import com.plutoratest.pagerepo.UserManagementPage;

public class SmokePlutoraTest {

	RequirementsPage requirementsPage = new RequirementsPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();
	DefectsPage defectsPage = new DefectsPage();
	UserManagementPage userManagementPage = new UserManagementPage();
	LoginPage loginPage = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();

	/*@Test(dataProvider = "SmokePlutoraTestDataProvider", description = "Smoke Plutora test", groups = { "SmokeTests" })
	public void smokePlutoraTest(Hashtable<String, String> data)
			throws InterruptedException, IOException, AWTException {
		*//*********************
		 * Create Requirements
		 *******************************************//*
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			requirementsPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.objectData);
			requirementsPage.createRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
					CommonConstants.imageFileName, data, PlutoraTestConfiguration.objectData, i);
			Listener.test1.log(Status.INFO, "Requirement : " + i + " created successfully ");

		*//********************
		 * Verify Requirements
		 *******************************************//*
			requirementsPage.searchRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			requirementsPage.verifyText("Requirements_Id", "Requirements_Automation_Id_" + i,
					PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
			requirementsPage.verifyText("Requirements_Name", "Requirements_Automation_Name_" + i,
					PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Requirement : " + i + " verified successfully ");
		}
		*//********************
		 * Update & Verify Requirements
		 *******************************************//*
		requirementsPage.updateRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		requirementsPage.verifyText("Requirements_CommentText", "Requirements_Comment",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		requirementsPage.clickOnCancelButton(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Requirement Updated & Verified successfully ");

		*//******************
		 * Create Testplan 
		 *******************************************//*
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Test Plan created successfully ");

		*//******************
		 * Verify Testplan
		 *******************************************//*
		testPlanPage.searchTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testPlanPage.verifyText("TestPlan_Name", "TestPlan_Automation_Name", PlutoraTestConfiguration.testPlanData,
				PlutoraTestConfiguration.testData);
		Listener.test1.log(Status.INFO, "Test Plan verified successfully ");

		*//******************
		 * Update Testplan
		 *******************************************//*
		testPlanPage.updateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName);
		testPlanPage.sleep(4000);
		testPlanPage.verifyTextContains("TestPlan_UploadFileName",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "ImageName"),
				PlutoraTestConfiguration.testPlanData);
		testPlanPage.clickOnCancelButton(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan updated & verified successfully");

		*//******************
		 * Create Testcase 
		 *******************************************//*
		
		testExecutionPage.addEvenNumbersToList();
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
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
					

		*//******************
		 * Verify Testcase 
		*******************************************//*
			testDesignerPage.verifyText("TDTC_TestcaseName", "TDTC_Name_" + z,
					PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1) + " verified successfully ");
			
		*//******************
		* Duplicate Testcase 
		*******************************************//*
			testDesignerPage.createDuplicateTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);

			String TDTC_Name = PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TDTC_Name_" + z)
					+ "_Copy";
			testDesignerPage.verifyText("TDTC_TestcaseName", TDTC_Name, PlutoraTestConfiguration.testDesignerData);
			Listener.test1.log(Status.INFO, "Test Designer New Test Case : " + (i+1)+ " duplicated successfully ");
		}
		*//******************
		 * Update Testcase 
		*******************************************//*
		
		testDesignerPage.updateTestcase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.clickOnTestCase(PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.sleep(2000);
		testDesignerPage.verifyTextWithAttributeValue("TDTC_PreCondtion_Textarea", "TDTC_Precondition",
				PlutoraTestConfiguration.testDesignerData, PlutoraTestConfiguration.testData);
		testDesignerPage.sleep(1000);
		testDesignerPage.clickOnCloseButton(PlutoraTestConfiguration.testDesignerData);
		testDesignerPage.sleep(2000);
		Listener.test1.log(Status.INFO, "Test Designer New Test Case updated & verified successfully");
		
		*//********************
		 * Verify testcase in Testexecution Section
		 ******************************************//*
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
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

		*//*******************
		 * Delete Duplicate & Original Testcases
		 ******************************************//*
		testDesignerPage.clickOnTestDesignerButton(PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
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
		*//*******************
		 * Verify Testcase in testexecution
		 ******************************************//*
		testExecutionPage.getTestExecutionDetailsPage(PlutoraTestConfiguration.testExecutionData,
				PlutoraTestConfiguration.objectData);
		testExecutionPage.searchTestPlan(PlutoraTestConfiguration.testExecutionData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
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

		*//*******************
		 * Create Defects
		 ********************************************************//*
		defectsPage.createDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.verifyText("Defect_Searched_Name_Text",
				PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Defect_Name"),
				PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect created successfully ");

		*//*******************
		 * Verify Defects
		 ********************************************************//*
		defectsPage.validateElementDisplayed("Defect_FirstRow", PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect verified successfully ");

		*//*******************
		 * Update Defects
		 ********************************************************//*
		defectsPage.updateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.sleep(2000);
		defectsPage.verifyText("Defect_Req_Added_Text", "Requirements_Automation_Name_" + 1,
				PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData);
		Listener.test1.log(Status.INFO, "New Defect updated successfully ");
		defectsPage.clickOnCloseButton(PlutoraTestConfiguration.defectsData);

		*//*******************
		 * Duplicate Defects
		 ********************************************************//*
		defectsPage.duplicateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.validateElementDisplayed("Defect_DuplicateRow", PlutoraTestConfiguration.defectsData);
		Listener.test1.log(Status.INFO, "New Defect duplicated successfully ");

		defectsPage.deleteDuplicateDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.verifyTextContainsNotDisplayedInPage(DefectsPage.defectDupID);
		Listener.test1.log(Status.INFO, "New Defect Duplicate deleted successfully ");

		*//*******************
		 * Delete Defects
		 ********************************************************//*
		defectsPage.deleteDefect(PlutoraTestConfiguration.defectsData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.platformName);
		defectsPage.verifyTextContainsNotDisplayedInPage(DefectsPage.defectID);
		Listener.test1.log(Status.INFO, "New Defect deleted successfully ");
		
		*//*******************
		 * Duplicate testplan
		 ********************************************************//*
		testPlanPage.createDuplicateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testPlanPage.scrollToElement("DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.sleep(2000);
		requirementsPage.validateElementDisplayed("DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.deleteDuplicateTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan is duplicated successfully");
		
		*//*******************
		 * Delete testplan
		 ********************************************************//*
		testPlanPage.deleteTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Testplan is deleted successfully");
		
		
		*//*******************
		 * Duplicate Requirements
		 ********************************************************//*
		requirementsPage.createDuplicateRequirement(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		requirementsPage.scrollToElement("Requirement_DuplicateText", PlutoraTestConfiguration.objectData);
		testPlanPage.sleep(1000);
		requirementsPage.validateElementDisplayed("Requirement_DuplicateText", PlutoraTestConfiguration.objectData);
		requirementsPage.deleteDuplicateRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Requirement is duplicated & deleted successfully");
		for (int i = 1; i <= Integer
				.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
			
			*//*******************
			 * Delete Requirements
			 ********************************************************//*
			requirementsPage.deleteRequirements(PlutoraTestConfiguration.requirementsData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, i);
			Listener.test1.log(Status.INFO, "Requirement : "+i+" is deleted successfully");
		}

		*//*******************
		 * Create User management 
		 ********************************************************//*
		userManagementPage.createNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User created successfully ");
		*//*******************
		 * Verify User management 
		 ********************************************************//*
		userManagementPage.verifyNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User verified successfully ");
		*//*******************
		 * Update User management 
		 ********************************************************//*
		userManagementPage.updateNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User updated successfully ");

		*//*****************************************
		 * Forget Password
		 *****************************************************//*

		// Logout current user
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		loginPage.sleep(5000);

		// New user login with old password
		loginPage.loginWithOldPassword(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		loginPage.sleep(7000);

		userManagementPage.forgetPasswordNewUser(PlutoraTestConfiguration.userManagementData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
				PlutoraTestConfiguration.loginData);

		// Logout new user with old password
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		loginPage.sleep(5000);

		// New user login with new password
		loginPage.loginWithNewPassword(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Thread.sleep(7000);
		userManagementPage.verifyText("Loggedin_Username", UserManagementPage.user_fullname,
				PlutoraTestConfiguration.loginData);
		Listener.test1.log(Status.INFO, "New User logged in with new password successfully");

		// Logout new user with new password
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		Thread.sleep(5000);

		// Login with current user
		loginPage.reloginPage(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User forget password functionality successfully ");

		*//*****************************************
		 * Delete user 
		 *****************************************************//*
		userManagementPage.deleteNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User deleted successfully ");

	}

	*//**
	 * Data provider to access the xls file
	 *//*
	@DataProvider(name = "SmokePlutoraTestDataProvider")
	public static Object[][] getData(Method m) {
		XlsReader xls = new XlsReader(CommonConstants.xlsPath);
		 XlsReader xls = new XlsReader("TestData.xlsx"); 
		if (m.getName().equalsIgnoreCase(CommonConstants.smokePlutoraTestName)) {
			return FolderManagementUtilLib.getData(xls, CommonConstants.smokePlutoraTestName,
					CommonConstants.dataSheetName);
		}
		return null;
	}*/

}

