package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class TestPlanPage extends TestGenericUtilLib  {
	public static String testPlanGeneratedId=null;
	
	public void getTestPlanPage(String testPlanData,String objectData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestPlan_ItemTab", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	
	public void getTestPlanDetailsPage(String testPlanData,String objectData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestPlan_ItemTab", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestPlan_NewButton", testPlanData);
	}
	
	public void createTestPlan(String testPlanData, String testData,
			String objectData,String testPlanName) throws InterruptedException, IOException, AWTException {

		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("AddTestPlan_NameTextField", PropertiesCache.setProperty(testData, testPlanName),
				testPlanData);
		click("AddTestPlan_DescriptionTextField", testPlanData);
		sendKeys("AddTestPlan_DescriptionTextField", PropertiesCache.setProperty(testData, "TestPlan_Automation_Description"),
				testPlanData);
		sleep(1000);
	
		click("AddTestPlan_MilestoneButton", testPlanData);
		sleep(1000);
		sendKeys("AddTestPlan_MilestoneName_TextField", "TestPlan_Milestone_Name", testPlanData,testData);
		sleep(1000);
		click("AddTestPlan_MilestoneDate_Icon", testPlanData);
		sleep(1000);
		click("AddTestPlan_TodayButton", testPlanData);
		sleep(1000);
		click("AddTestPlan_PhaseButton", testPlanData);
		sleep(1000);
		sendKeys("AddTestPlan_PhaseName_TextField", "TestPlan_Phase_Name", testPlanData,testData);
		sleep(1000);
		click("AddTestPlan_PhaseStartDate_Icon", testPlanData);
		sleep(1000);
		click("AddTestPlan_TodayButton", testPlanData);
		click("AddTestPlan_PhaseEndDate_Icon", testPlanData);
		sleep(1000);
		click("AddTestPlan_TodayButton", testPlanData);
		
		click("AddTestPlan_DetailedExecutionPlan", testPlanData);
		sleep(1000);
		sendKeys("AddTestPlan_DetailedExecutionPlan_DailyExecution_TextField", "TestPlan_DailyExecution", testPlanData,testData);
		
		click("AddTestPlan_NextButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		
		for (int i = 1; i <=Integer.parseInt(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Count")); i++) {
		click("AddTestPlan_AddRequirementsButton", testPlanData);
		sleep(1000);
		sendKeys("AddTestPlan_AddRequirements_SearchBox", "Requirements_Automation_Id_"+i, testPlanData,testData);
		sleep(1000);
		click("AddTestPlan_AddRequirements_Checkbox","Requirements_Automation_Id_"+i, testPlanData,testData);
		sleep(1000);
		click("AddTestPlab_AddRequirements_AddSelectedButton", testPlanData);
		sleep(1000);
		}
		clickElementUsingJavaScript("AddTestPlan_NextButton", testPlanData);
		
		click("AddTestPlan_TeamResources_Dropdown", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		sendKeys("AddTestPlan_TeamResources_Textbox",PropertiesCache.getProperty(testData, "TestPlan_TeamResourceName").split(" ")[0],testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		click("AddTestPlan_TeamResources_DropdownOptions",PropertiesCache.getProperty(testData, "TestPlan_TeamResourceName").split(" ")[0], testPlanData);
		sleep(1000);
		click("AddTestPlan_TeamResources_AddButton", testPlanData);
		
		click("AddTestPlan_NextButton", testPlanData);
		click("AddTestPlan_Save&CloseButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	
	public void searchTestPlan(String
			testPlanData, String testData,String objectData) {
		clickElementUsingJavaScript("TestPlan_SearchIcon","TestPlan_Automation_Name", testPlanData, testData);
		sendKeysWithEnter("TestPlan_SearchIcon", "TestPlan_Automation_Name", testPlanData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(2000);
	}
	public void searchTestPlan(String testPlanData, String testData,String objectData,String name) {
		clickElementUsingJavaScript("TestPlan_SearchIcon",name, testPlanData, testData);
		sendKeysWithEnter("TestPlan_SearchIcon", name, testPlanData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(2000);
	}
	public void clickOnTestPlan(String testPlanData,String testData,String objectData,String name) {
		clickElementUsingJavaScript("TestPlan_Name", name,testPlanData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(2000);
	}
	public void updateTestPlan(String testPlanData, String testData,String objectData,String platform,String fileName) throws InterruptedException, IOException, AWTException {
     	clickElementUsingJavaScript("TestPlan_Name", "TestPlan_Automation_Name",testPlanData,testData);
     
		scrollToElement("AddTestPlan_Dependencies_Dropdown", testPlanData);
		sleep(1000);
//		click("AddTestPlan_Dependencies_Dropdown", testPlanData);
//		sleep(1000);
//		click("AddTestPlan_Dependencies_Dropdown_Option", testPlanData);
//		sleep(1000);
//		click("AddTestPlan_Dependencies_ListDropdown", testPlanData);
//		sleep(1000);
//		click("AddTestPlan_Dependencies_ListDropdown_Option", testPlanData);
		/*sleep(1000);
		clickElementUsingJavaScript("AddTestPlan_AttachmentsIcon", testPlanData,testData);
    	sleep(2000);
		uploadImage(platform, fileName+PropertiesCache.getProperty(testData, "ImageName"));*/
		uploadImageByCss(".upload-item #file-uploader");
		sleep(1000);
		clickOnCancelButton(testPlanData, objectData);
		clickElementUsingJavaScript("TestPlan_Name", "TestPlan_Automation_Name",testPlanData,testData);
	}
	
	public void clickOnCancelButton(String testPlanData,String objectData){
		sleep(1000);
		clickElementUsingJavaScript("TestPlan_CloseButton",testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	
	public void deleteTestPlan(String testPlanData, String testData,String objectData) {
		searchTestPlan(testPlanData, testData, objectData);
		clickElementUsingJavaScript("TestPlan_Name", "TestPlan_Automation_Name",testPlanData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestPlan_DeleteButton",testPlanData);
		sleep(2000);
		clickElementUsingJavaScript("TestPlan_ConfirmButton",testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(4000);
	}
	public void deleteDuplicateTestPlan(String testPlanData, String testData,String objectData) {
		clickElementUsingJavaScript("TestPlan_DeleteButton",testPlanData);
		sleep(2000);
		clickElementUsingJavaScript("TestPlan_ConfirmButton",testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(4000);
	}
	
	public void createDuplicateTestPlan(String testPlanData, String testData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestPlan_ItemTab", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		searchTestPlan(testPlanData, testData, objectData);
		testPlanGeneratedId=getTextData("GeneratedId", objectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("GeneratedId", "DataGridOption", objectData);
		clickElementUsingJavaScript("Duplicate_Button", objectData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Progress_Bar", objectData);
		clickElementUsingJavaScript("Duplicate_Name", "TestPlan_Automation_Name",objectData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		sleep(2000);
	}
	
	public void createTestPlan(String testPlanData, String testData, String objectData) {
		
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("AddTestPlan_NameTextField", PropertiesCache.setProperty(testData, "TestPlan_Automation_Name"),
				testPlanData);
		click("AddTestPlan_DescriptionTextField", testPlanData);
		sendKeys("AddTestPlan_DescriptionTextField",
				PropertiesCache.setProperty(testData, "TestPlan_Automation_Description"), testPlanData);
		click("AddTestPlan_NextButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("AddTestPlan_NextButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("AddTestPlan_NextButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("AddTestPlan_Save&CloseButton", testPlanData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

}
