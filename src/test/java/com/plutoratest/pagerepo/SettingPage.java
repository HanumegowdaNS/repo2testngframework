package com.plutoratest.pagerepo;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class SettingPage extends TestGenericUtilLib  {
	
	public void gotoSettingPage(String settingData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("SettingIcon", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void gotoUserManagementPage(String settingData,String objectData) {
		sleep(2000);
		click("Setting_UserManagement_Tab", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void gotoCustomizationPage(String settingData,String objectData) {
		sleep(2000);
		click("Setting_Customization_Tab", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void disableRequirementBulkUpload(String settingData,String objectData) {
		click("Setting_UserManagement_ManageRoleAndPermissions_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_UserManagement_Admin_Text", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Setting_UserManagement_Requirement_Expand_Dropdown", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		scrollToElement("Setting_UserManagement_Requirement_BulkUpload_Text",settingData);
		sleep(1000);
		clickElement(settingData,"Setting_UserManagement_Requirement_BulkUpload_NotChecked","Setting_UserManagement_Requirement_BulkUpload_Checked",objectData,"Progress_Bar");
		clickElementUsingJavaScript("Setting_UserManagement_Requirement_Save_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_UserManagement_Requirement_Cancel_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void enableRequirementBulkUpload(String settingData,String objectData) {
		click("Setting_UserManagement_ManageRoleAndPermissions_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_UserManagement_Admin_Text", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_UserManagement_Requirement_Expand_Dropdown", settingData);
		clickElement(settingData,"Setting_UserManagement_Requirement_BulkUpload_Checked","Setting_UserManagement_Requirement_BulkUpload_NotChecked",objectData,"Progress_Bar");
		click("Setting_UserManagement_Requirement_Save_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_UserManagement_Requirement_Cancel_Button", settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void addCustomField(String settingData,String testData,String objectData,String name) {
		click("Setting_Customization_Tab",settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElement(settingData,"Setting_Customization_Requirement_Expanded_Icon","Setting_Customization_Requirement_Collapsed_Icon",objectData,"Progress_Bar");
		click("Setting_Customization_Requirement_CustomFields_Option",settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_Customization_Requirement_NewCustomField_Button",settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("Setting_Customization_Requirement_CustomField_Textbox", PropertiesCache.setProperty(testData, name),settingData);
		selectDDLByVisibleText("Setting_Customization_Requirement_CustomField_Type", "String", settingData);
		click("Setting_Customization_Requirement_CustomField_Save_Button",settingData);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
		
	}
	
	public void deleteCustomField(String settingData,String testData,String objectData,String name) {
		click("Setting_Customization_Tab",settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElement(settingData,"Setting_Customization_Requirement_Expanded_Icon","Setting_Customization_Requirement_Collapsed_Icon",objectData,"Progress_Bar");
		click("Setting_Customization_Requirement_CustomFields_Option",settingData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_Customization_Requirement_CustomField_Delete_Icon",name,settingData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		click("Setting_Customization_Requirement_CustomField_Delete_Yes_Button",settingData);
		waitForLoadingIconDisappear(100,"Progress_Bar", objectData);
	}
}
