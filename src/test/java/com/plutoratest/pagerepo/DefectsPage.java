package com.plutoratest.pagerepo;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class DefectsPage extends TestGenericUtilLib  {
	public static String defectDupID = null;
	public static String defectID = null;

	public void createDefect(String defectData, String testData, String objectData,String platform, int i) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		click("Defects_MenuTab", objectData);
		sleep(4000);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		click("NewDefect_Button", defectData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("NewDefect_AssignToDropdown", defectData);
		click("NewDefect_AssignToDropdown_Option", defectData);
		sleep(1000);
		sendKeys("Defect_Name_Textbox",PropertiesCache.setProperty(testData, "Defect_Name"+i),defectData);
		click("Defect_Description_Textbox", defectData);
		sendKeys("Defect_Description_Textbox",PropertiesCache.setProperty(testData, "Defect_Description"+i),defectData);
		sleep(2000);
		/*click("Defect_Attachment_Link", defectData);
		sleep(3000);*/
		/*WebElement uploadFile = driver.findElement(By.id("file-uploader"));
		sleep(500);
		uploadFile.sendKeys(CommonConstants.imageFileName + PropertiesCache.getProperty(testData, "ImageName"));*/
		uploadImageByCss(".upload-item #file-uploader");
//		uploadImage(platform, CommonConstants.imageFileName + PropertiesCache.getProperty(testData, "ImageName"));
		sleep(5000);
		validateElementDisplayed("Defect_Attachment_Name_Text", defectData);
		Listener.test1.log(Status.INFO, "Defect attachment added successfully");
		click("Defect_Team_Dropdown_Icon", defectData);
		sleep(2000);
		click("Defect_Team_Dropdown_Option", defectData);
		click("Defect_Subsystem_Dropdown_Icon", defectData);
		sleep(2000);
		click("Defect_Subsystem_Dropdown_Option", defectData);
		click("Defect_DetectedEnv_Dropdown_Icon", defectData);
		sleep(2000);
		click("Defect_DetectedEnv_Dropdown_Option", defectData);
		click("Defect_SaveClose_Button", defectData);
		sleep(10000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_AdvancedSearch_Textbox", defectData);
		sleep(1000);
		sendKeysWithEnter("Defect_Searched_Name_Textbox",PropertiesCache.getProperty(testData, "Defect_Name"+i),defectData);
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);


	}

	public void updateDefect(String defectData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		defectID   = getTextData("Defect_Searched_ID_Text",defectData);
		click("Defect_Searched_Name_Text", defectData);
		sleep(8000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Association_Add_Icon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Add_Requirements_Tab", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Requirements_Search_Textbox", defectData);
		sendKeysWithEnter("Defect_Requirements_Search_Textbox","Requirements_Automation_Name_"+1,defectData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_FirstSearch_Checkbox", defectData);
		sleep(3000);
		click("Defect_Req_SaveClose_Button", defectData);
		sleep(8000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		scrollToElement("Defect_Requirements_Tab", defectData);
		click("Defect_Requirements_Tab", defectData);
		sleep(2000);

	}

	public void duplicateDefect(String defectData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("Defect_FirstRow", "Defect_FirstRow_DataGrid_Item", defectData);
		sleep(2000);
		click("Defect_FirstRow_Duplicate_Option", defectData);
		sleep(10000);
		//click("Defect_Delete_Confirm_Button", defectData);
		//sleep(3000);
		defectDupID   = getTextData("Defect_Searched_DupID_Text",defectData);
		System.out.println("Duplicate id: "+defectDupID);

	}
	
	public void deleteDuplicateDefect(String defectData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {

		click("Defect_Searched_DupName_Text", defectData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Delete_Button", defectData);
		sleep(2000);
		click("Defect_DeleteConfirm_Button", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Search_Display_Textbox", defectData);
		sleep(1000);
		sendKeysWithEnter("Defect_Searched_Name_Textbox",PropertiesCache.getProperty(testData, "Defect_Name1"),defectData);
		sleep(4000);

	}
	
	public void deleteDefect(String defectData, String testData, String objectData,String name) throws InterruptedException, IOException, AWTException {

		click("Defect_Searched_Name_Text", defectData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		click("Defect_Delete_Button", defectData);
		sleep(2000);
		click("Defect_DeleteConfirm_Button", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Search_Display_Textbox", defectData);
		sleep(1000);
		sendKeysWithEnter("Defect_Searched_Name_Textbox",PropertiesCache.getProperty(testData, name),defectData);
		sleep(4000);

	}
	
	public void clickOnCloseButton(String defectData) {
		click("Defect_Close_Button", defectData);
	}

	public void updateTestPlanToDefect(String defectData, String testData, String objectData,String defectName,String testplanName) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		click("Defect_Name_Text",defectName,defectData,testData);
		sleep(8000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Association_Add_Icon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Add_TestPlan_Tab", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_TestPlan_Search_Textbox", defectData);
		sendKeysWithEnter("Defect_TestPlan_Search_Textbox",testplanName,defectData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_FirstSearch_Checkbox", defectData);
		sleep(3000);
		click("Defect_Req_SaveClose_Button", defectData);
		sleep(8000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickOnCloseButton(defectData);
	}
	
	public void searchDefect(String testData, String defectData, String objectData, String name) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error", testData, objectData);
		sleep(2000);
		click("Defects_MenuTab", objectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter("Defect_Searched_Name_Textbox", PropertiesCache.getProperty(testData, name),
				defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);

	}

	public void openDefect(String defectName) {
		String locator = "//a[text()='" + defectName + "']$xpath";
		click(locator);

	}

	public void cancelAssociation(String associationTab, String entityName, String searchBox, String searchData, String defectData, String objectData, String testData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(associationTab, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Association_Add_Icon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(entityName, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(searchBox, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeysWithEnter(searchBox, searchData, defectData,
				testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_FirstSearch_Checkbox", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("AddingAssociationCloseIcon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		Listener.addLogger("Association of : "
				+ PropertiesCache.getProperty(testData, searchData)
				+ ", Canceled Successfully");

	}

	public void addAssociation(String associationTab, String entityName, String searchBox, String searchData, String defectData, String objectData, String testData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(associationTab, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Association_Add_Icon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(entityName, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(searchBox, defectData);
		sendKeysWithEnter(searchBox, searchData, defectData,
				testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_FirstSearch_Checkbox", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_SaveClose_Button", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		Listener.addLogger("Association of: "
				+ PropertiesCache.getProperty(testData, searchData) + ", Added Successfully");
	}
	
	public void verifyTestRunStatusUnderDefectAssociationsSection(String testCase, String status) {
		String locator = "//a[text()='"+testCase+"']/../following-sibling::span[text()='"+status+"']$xpath";
		mouseOver(driver.findElement(By.xpath("//a[text()='"+testCase+"']/../following-sibling::span[text()='"+status+"']")));
		verifyText(locator, status);
	}
	
	public void verifyRemoveAssociationConfirmationPopUp() {
		assertTrue(isElement_Present("//div[text()='Are you sure you wish to remove this association?']$xpath"));
	}
	
	public void clickOnOkInRemoveAssociationConfirmationPopUp() {
		click("//button[text()='Ok']$xpath");
	}
	
	public void clickOnCancelInRemoveAssociationConfirmationPopUp() {
		click("//button[text()='Cancel']$xpath");
	}
	
	public void addDefectAssociation(String associationTab, String entityName, String dropDownLocator, String searchBox, String searchData, String associationStatus, String defectData, String objectData, String testData) {
		
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(associationTab, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Association_Add_Icon", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(entityName, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		verifySelectTypeOptionsInAddAssociationsWindow(dropDownLocator, defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		selectByVisibleText(dropDownLocator, "Related To", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click(searchBox, defectData);
		sendKeysWithEnter(searchBox, searchData, defectData,
				testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		verifyAssociationStatusInAddAssociationWindow(searchData, associationStatus);
		click("Defect_Req_FirstSearch_Checkbox", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Defect_Req_SaveClose_Button", defectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		Listener.addLogger("Association of: "
				+ PropertiesCache.getProperty(testData, searchData) + ", Added Successfully");
	}
	
	public void verifySelectTypeOptionsInAddAssociationsWindow(String locator, String defectData) {
		String[] selectTypes = {"Related To", "Parent For", "Subtask Of", "Duplicated By", "Duplicate Of", "Dependant On", "Required For"};
		List<WebElement> allOptions = getAllOptionsFromDropdown(locator, defectData);
		System.out.println(allOptions.size());
			for(int i=0; i<selectTypes.length; i++) {
				Listener.addLogger(i+" drop down value is : "+ allOptions.get(i));
				assertTrue(selectTypes[i].equals((allOptions.get(i+1).getText()).trim()));			
			
		}
		
	}
	
	public void verifyAssociationStatusInAddAssociationWindow(String name, String Status) {
		String locator = "//span[contains(text(),'"+name+"')]/following-sibling::span[contains(text(),'"+Status+"')]$xpath";
		assertTrue(isElement_Present(locator));
		
	}
	
	public void verifyDefectUnderDefectAssociationsSection(String type, String defect, String status) {
		String locator = "//span[contains(text(),'"+type+"')]/ancestor::div[1]/following-sibling::div//span[text()='"+defect+"']/../following-sibling::span$xpath";
		verifyText(locator, status);
	}

}
