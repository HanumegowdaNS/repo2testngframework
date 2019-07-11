package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class TestExecutionPage extends TestGenericUtilLib  {
	public static List<Integer> evenNumberList = new ArrayList<Integer>();
	
	public boolean verifyTestCaseFolderName(String testCaseName,String testPlanName,String testData) {
		return driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, testCaseName)+"']/ancestor::div/following-sibling::div[contains(@class,'folderpath')]/span[contains(text(),'"+PropertiesCache.getProperty(testData, testPlanName)+"')]")).isDisplayed();
	}
	public boolean verifyTestCaseAssigneeName(String testCaseName,String testPlanName,String testData) {
	//	return driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, testCaseName)+"']/ancestor::div/following-sibling::div[contains(@class,'ass')]/span[contains(text(),'"+PropertiesCache.getProperty(testData, testPlanName)+"')]")).isDisplayed();
		return driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, testCaseName)+"']/ancestor::div/following-sibling::div[contains(@class,'ass')]/span[contains(text(),'Unassigned')]")).isDisplayed();
	}
	public void getTestExecutionDetailsPage(String testExecutionData,String objectData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TestExecution_ItemTab", testExecutionData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void searchTestPlan(String testExecutionData,String testData,String objectData,String testPlanName) {
		sleep(2000);
		clickElementUsingJavaScript("TestExecution_SearchItem",testPlanName, testExecutionData, testData);
		sendKeys("TestExecution_SearchItem", testPlanName, testExecutionData, testData);
		sleep(2000);
	}
	public void addEvenNumbersToList() {
		evenNumberList.add(0);
		evenNumberList.add(1);
		evenNumberList.add(2);
		evenNumberList.add(3);
	}
	public void createDefect(String testExecutionData,String rtmData,String testData,String objectData,String requirementName,String testPlanName,String testcaseName) throws InterruptedException, AWTException {
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_ItemTab", rtmData);
		sleep(2000);
		searchTestPlan(testExecutionData, testData, objectData, testPlanName);
		
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Req_TestExecution_RunNewTest_Button", "Req_TestExecution_RunNewTestWraper_Button", testcaseName,testcaseName,rtmData,testData);
		
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(4000);
		clickElementUsingJavaScript("Req_TestExecution_RunningImage_Icon",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefect_Button",rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_PopupNewDefect_Button",rtmData);
		sleep(2000);
		sendKeysWithEnter("Req_TestExecution_DefectName_Textbox", PropertiesCache.setProperty(testData, "Defect_Name"), rtmData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_DefectSaveClose_Button",rtmData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_SubmitResultFailed_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_TestExecution_DefectSave_Button",rtmData);
		sleep(2000);
		waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestExecution_RaiseDefectClose_Icon",rtmData);
		waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
		sleep(2000);
		refresh(objectData,PlutoraTestConfiguration.baseUrl,"Progress_Bar");
		
	}
	public void associateTestExecution(String testExecutionData,String rtmData,String testData,String objectData,String requirementName,String testPlanName,String testcaseName,String id) throws InterruptedException {
		clickElementUsingJavaScript("Req_TestExecution_ItemTab", rtmData);
		sleep(2000);
		searchTestPlan(testExecutionData, testData, objectData, testPlanName);
		
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Req_TestExecution_RunNewTest_Button", "Req_TestExecution_RunNewTestWraper_Button", testcaseName,testcaseName,rtmData,testData);
		
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TestExecution_TestCaseInformation_Tab",testExecutionData);
		scrollToElement("TestExecution_Associations_Label",testExecutionData);
		
		clickElementUsingJavaScript("TestExecution_Associations_Requirments_Label", testExecutionData);
        sleep(1000);
        closeAssociation(testExecutionData,testData, objectData,requirementName);
        
        clickElementUsingJavaScript("TestExecution_Associations_Add_Button", testExecutionData);
        sleep(1000);
        clickElementUsingJavaScript("TestExecution_Associations_Requirements_Link",testExecutionData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        sendKeysWithoutClear("TestExecution_Associations_Textbox", id, testExecutionData);
        waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
        sleep(2000);
        clickElementUsingJavaScript("TestExecution_SearchResult_Checkbox",requirementName,testExecutionData,testData);
        sleep(1000);
        clickElementUsingJavaScript("TestExecution_Save&Close_Button",testExecutionData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
	
	}
	public void closeAssociation(String testExecutionData,String testData,String objectData,String requirementName) {
		clickElementUsingJavaScript("TestExecution_Associations_Requirments_Label", testExecutionData);
		sleep(1000);
		moveToElement("TestExecution_Associations_Requirments_Name", requirementName, testExecutionData, testData);
		clickElementUsingJavaScript("TestExecution_Associations_Requirments_Close_Icon", requirementName, testExecutionData, testData);
		sleep(1000);
		clickElementUsingJavaScript("TestExecution_Associations_Ok_Button", testExecutionData);
		waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
	}
	public void notAssociatedTestExecution(String testExecutionData,String rtmData,String testData,String objectData,String requirementName,String testPlanName,String testcaseName,String id) throws InterruptedException {
		clickElementUsingJavaScript("Req_TestExecution_ItemTab", rtmData);
		sleep(2000);
		searchTestPlan(testExecutionData, testData, objectData, testPlanName);
		
		clickElementUsingJavaScript("Req_TestDesigner_TP_Name",testPlanName,rtmData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Req_TestDesigner_Req_Name",requirementName,rtmData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Req_TestExecution_RunNewTest_Button", "Req_TestExecution_RunNewTestWraper_Button", testcaseName,testcaseName,rtmData,testData);
		
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TestExecution_TestCaseInformation_Tab",testExecutionData);
		scrollToElement("TestExecution_Associations_Label",testExecutionData);
		
		clickElementUsingJavaScript("TestExecution_Associations_Requirments_Label", testExecutionData);
        sleep(1000);
        clickElementUsingJavaScript("TestExecution_Associations_Add_Button", testExecutionData);
        sleep(1000);
        clickElementUsingJavaScript("TestExecution_Associations_Requirements_Link",testExecutionData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        sendKeysWithoutClear("TestExecution_Associations_Textbox", id, testExecutionData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        sleep(2000);
	
	}

}
