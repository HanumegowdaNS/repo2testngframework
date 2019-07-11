package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class TestDesignerPage extends TestGenericUtilLib  {
	public static String TDTC_ID = null;

	public void createTestcase(String tdData, String testData, String objectData, String platform,int j,int i) throws InterruptedException, IOException, AWTException {
		
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		click("TDTC_Create_Button", tdData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		//TDTC_ID = getTextData("TD_TC_ID_Text",tdData);
		sendKeys("TDTC_Name_Textbox",PropertiesCache.setProperty(testData, "TDTC_Name_"+j),tdData);
		sleep(2000);
		click("TDTC_Desc_Textarea", tdData);
		sendKeys("TDTC_Desc_Textarea",PropertiesCache.setProperty(testData, "TDTC_Desc"),tdData);
		sleep(1000);
		/*click("TDTC_Attachment_Link", tdData);
		sleep(3000);
		uploadImage(platform, CommonConstants.imageFileName + PropertiesCache.getProperty(testData, "ImageName"));*/
		uploadImageByCss(".upload-item #file-uploader");
		sleep(1000);
		sendKeys("TDTC_PreCondtion_Textarea",PropertiesCache.setProperty(testData, "TDTC_Precondition"),tdData);
		sendKeys("TDTC_PostCondtion_Textarea",PropertiesCache.setProperty(testData, "TDTC_Postcondition"),tdData);
		sleep(1000);		
		sendKeys("TDTC_Env_Textbox",PropertiesCache.setProperty(testData, "TDTC_Env"),tdData);
//		clickElementUsingJavaScript("TDTC_TestCaseType_Icon", tdData);
//		sleep(2000);
//		clickElementUsingJavaScript("TDTC_TestCaseType_Option", tdData);
//		sleep(1000);
		clickElementUsingJavaScript("TDTC_SaveClose_Button", tdData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		sleep(1000);
		click("TDTC_TestcaseName", "TDTC_Name_"+j,tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_Close_Button", tdData);
		//handle_toast_popup("Testcase_Success_Message", testData, objectData);
		clickElementUsingJavaScript("TDTC_RequirementName","Requirements_Automation_Name_"+i, tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);		
	}
	public void getTestDesignerDetails(String testData,String objectData) {
		click("TD_MenuTab", objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
	}
	
	public void searchTestplan(String testDesignerData,String testData,String objectData,String testplanName) {
		clickElementUsingJavaScript("TD_Folder_Button",testDesignerData);
		sleep(1000);
		clickElementUsingJavaScript("TDTC_SearchItem",testplanName, testDesignerData, testData);
		sendKeys("TDTC_SearchItem",testplanName, testDesignerData, testData);
		sleep(1000);
		clickElementUsingJavaScript("TDTC_TestPlanName",testplanName, testDesignerData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(1000);
	}
	public void clickOnRequirement(String testDesignerData,String testData,String objectData,int i) {
		clickElementUsingJavaScript("TDTC_RequirementName","Requirements_Automation_Name_"+i, testDesignerData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(1000);
	}
	public void updateTestcase(String tdData, String testData, String objectData) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		searchTestplan(tdData, testData, objectData,"TestPlan_Automation_Name");
		clickOnRequirement(tdData, testData, objectData, 1);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_TestcaseName", "TDTC_Name_"+1,tdData, testData);
		sleep(2000);
		sendKeys("TDTC_PreCondtion_Textarea",PropertiesCache.setProperty(testData, "TDTC_Precondition"),tdData);
		click("TDTC_Close_Button", tdData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}
	
	public void deleteTestcase(String tdData,String testData,String objectData,int i) throws InterruptedException, IOException, AWTException {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("TDTC_TestcaseSection","TDTC_DeleteIcon", tdData);
		sleep(1000);
		click("TDTC_Delete_Confirm_Button", tdData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
	}
	
	public void clickOnCloseButton(String tdData) {
		click("TDTC_Close_Button", tdData);
	}
	public void clickOnTestDesignerButton(String objectData) {
		click("TD_MenuTab", objectData);
	}
	public void clickOnTestCase(String tdData,String testData,String objectData) {
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_TestcaseName", "TDTC_Name_"+1,tdData, testData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		click("TDTC_PreCondtion_Textarea", tdData);
		sleep(5000);
	}
	public void createDuplicateTestcase(String tdData,String testData,String objectData) throws InterruptedException {
		mouseHover("TDTC_TestcaseSection","TDTC_CopyIcon", tdData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
	}
	public void associateRequirementWithTestCase(String tdData,String testData,String testPlanName,String reqName,String testCaseName,String id,String objectData) throws InterruptedException {
		sleep(2000);
		searchTestplan(tdData, testData, objectData,testPlanName);
		sleep(2000);
		clickOnRequirement(tdData, testData, objectData, 1);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_TestcaseName", testCaseName,tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		scrollToElement("TDTC_Requirments_Label", tdData);
		clickElementUsingJavaScript("TDTC_Requirments_Label", tdData);
        sleep(1000);
        closeAssociation(tdData, testData, objectData, reqName);
        clickElementUsingJavaScript("TDTC_Associations_Add_Button", tdData);
        sleep(1000);
        clickElementUsingJavaScript("TDTC_Associations_Requirements_Link",tdData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        sendKeysWithoutClear("TDTC_Associations_Textbox", reqName, tdData, testData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        clickElementUsingJavaScript("TDTC_SearchResult_Checkbox",reqName,tdData,testData);
        sleep(1000);
        verifyTextContains("TDTC_Associations_Text", id,tdData);
        Listener.addLogger(id+" displayed in associations list successfully !");
        clickElementUsingJavaScript("TDTC_Save&Close_Button",tdData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        
    }
	public void closeAssociation(String tdData,String testData,String objectData,String requirementName) {
		clickElementUsingJavaScript("TDTC_Associations_Requirments_Label", tdData);
		sleep(1000);
		moveToElement("TDTC_Associations_Requirments_Name", requirementName, tdData, testData);
		clickElementUsingJavaScript("TDTC_Associations_Requirments_Close_Icon", requirementName, tdData, testData);
		sleep(1000);
		clickElementUsingJavaScript("TDTC_Associations_Ok_Button", tdData);
		waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
	}
	public void notAssociatedTestExecution(String tdData,String testData,String testPlanName,String reqName,String testCaseName,String id,String objectData) throws InterruptedException {
		sleep(2000);
		searchTestplan(tdData, testData, objectData,testPlanName);
		clickOnRequirement(tdData, testData, objectData, 1);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_TestcaseName", testCaseName,tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		scrollToElement("TDTC_Requirments_Label", tdData);
		clickElementUsingJavaScript("TDTC_Requirments_Label", tdData);
        sleep(1000);
        closeAssociation(tdData, testData, objectData, reqName);
        clickElementUsingJavaScript("TDTC_Associations_Add_Button", tdData);
        sleep(1000);
        clickElementUsingJavaScript("TDTC_Associations_Requirements_Link",tdData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
        sendKeysWithoutClear("TDTC_Associations_Textbox", reqName, tdData, testData);
        waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	
	public void searchTestcase(String tdData,String testData,String objectData){
		searchTestplan(tdData, testData, objectData,"TestPlan_Automation_Name");
		clickOnRequirement(tdData, testData, objectData, 1);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_TestcaseName", "TDTC_Name_"+1,tdData, testData);
		
	}
	
	public void createTestcase(String tdData, String testData, String objectData, int i)
			throws InterruptedException, IOException, AWTException {

		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error", testData, objectData);
		click("TDTC_Create_Button", tdData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("TDTC_Name_Textbox", PropertiesCache.setProperty(testData, "TDTC_Name"), tdData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_Desc_Textarea", tdData);
		sendKeys("TDTC_Desc_Textarea", PropertiesCache.setProperty(testData, "TDTC_Desc"), tdData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("TDTC_SaveClose_Button", tdData);
		waitForLoadingIconDisappear(80, "Progress_Bar", objectData);
		click("TDTC_TestcaseName", "TDTC_Name", tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("TDTC_Close_Button", tdData);
		clickElementUsingJavaScript("TDTC_RequirementName", "Requirements_Automation_Name_" + i, tdData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
}
