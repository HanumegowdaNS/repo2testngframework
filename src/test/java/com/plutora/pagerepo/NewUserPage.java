package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class NewUserPage extends TestGenericUtilLib {
	
	public static String loginEmail = null;
	public List<String> userManagementFields= new ArrayList<String>();
	
	public void gotoNewUserPage(String newuserData, String testData, String objectData) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
	//	mouseHover("NewUser_SettingsDropdown", "NewUser_UserMangDropdown",newuserData);
		click("NewUser_SettingsDropdown",newuserData);
		sleep(2000);
		click("NewUser_UserMangDropdown",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void addNewUser(String newuserData, String testData, String objectData,String firstName,String secondName) throws InterruptedException{	

		gotoNewUserPage(newuserData, testData, objectData);
		waitForLoadingIconDisappear(30, "Loading_Gif",objectData);
		click("NewUser_AddNewUserButton",newuserData);
		waitForLoadingIconDisappear(30, "Loading_Gif",objectData);
		sendKeys("NewUser_FirstNameTextfield",PropertiesCache.setProperty(testData, firstName),newuserData);
		sendKeys("NewUser_LastNameTextfield",PropertiesCache.setProperty(testData, secondName),newuserData);
		loginEmail = PropertiesCache.setProperty(testData, "LoginEmail")+"@yopmail.com";
		sendKeys("NewUser_LoginEmailTextfield",loginEmail,newuserData);
		click("NewUser_RolesDropdown",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(newuserData,"NewUser_RolesFirst",objectData);
		click("NewUser_RolesDropdown",newuserData);
		click("NewUser_ActiveRadioButtton",newuserData);
		clickOnButton(newuserData,"NewUser_Indefinitely_ON_Icon","NewUser_Indefinitely_OFF_Icon",objectData,"xpath");
		clickOnButton(newuserData,"NewUser_ReceiveNotification_ON_Icon","NewUser_ReceiveNotification_OFF_Icon",objectData,"xpath");
		clickOnButton(newuserData,"NewUser_AllowLogin_ON_Icon","NewUser_AllowLogin_OFF_Icon",objectData,"xpath");
		click("NewUser_SaveCloseButton",newuserData);

	}

	public void readNewUser(String newuserData, String testData, String objectData,String username) {

		sleep(1000);
		sendKeysWithEnter("NewUser_LiveSearchTextbox",username,newuserData,testData);
		sleep(2000);
		clickElementUsingJavaScript("NewUser_SearchButton",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void updateNewUser(String newuserData, String testData, String objectData) {	

		sleep(1000);
		click("NewUser_SearchedEditButton",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("NewUser_LastNameTextfield","NewUser_LastName",newuserData,testData);
		click("NewUser_SaveCloseButton",newuserData);

	}
	
	public void activateNewUser(String newuserData, String testData, String objectData) throws InterruptedException{
		sleep(2000);
		launchUrl("Yopmail_HomePage_URL",testData);
		sleep(1000);
		sendKeysWithEnter("Yopmail_EmailInput","LoginEmail",objectData,testData);
		/*sleep(3000);
		click("Registration_CheckNewMails_Button",objectData);*/
		sleep(2000);
		switchToFrameByName("Frame_Name",testData);
		sleep(5000);
		clickOnActivationLink("Yopmail_Activation_Link", objectData);
		switchToWindowPopup();
		sleep(2000);
		sendKeysWithEnter("Registration_Password_Textbox","User_NewPassword",objectData,testData);
		sendKeysWithEnter("Registration_PhoneNumber_Textbox","User_NewPhoneNumber",objectData,testData);
		click("Registration_TermsOfUse_Checkbox",objectData);
		click("Registration_GetStarted_Button",objectData);
		sleep(1000);
		verifyTextContains("Yopmail_Activation_Confirm_Message","User_Activation_Success_Message",objectData,testData);
		Listener.addLogger("User Activated successfully | ");
		click("Yopmail_Activation_Confirm_Login_Link",objectData);
		//waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		sleep(4000);
	}


	public void resetPassword(String newuserData, String testData, String objectData) throws InterruptedException{	
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		click("Login_FullName_Link",objectData);
		//mouseHover("NewUser_SettingsDropdown", "NewUser_UserMangDropdown",newuserData);
		sleep(1000);
		click("Password_Reset_Link", objectData);
		sleep(1000);
		waitForLoadingIconDisappear(40, "Loading_Gif",objectData);
		click("User_Settings_Header", objectData);
		click("Password_Edit_Link", objectData);
		sendKeys("User_PopupOldPassword_Textfield", "User_NewPassword", newuserData, testData);
		/*click("Login_FullName_Link",objectData);
		//mouseHover("NewUser_SettingsDropdown", "NewUser_UserMangDropdown",newuserData);
		sleep(1000);
		click("Password_Reset_Link", objectData);
		sleep(1000);
		waitForLoadingIconDisappear(40, "Loading_Gif",objectData);
		click("User_Settings_Header", objectData);
		click("Password_Edit_Link", objectData);
		sendKeys("User_PopupOldPassword_Textfield", "User_NewPassword", newuserData, testData);*/
		/*waitForLoadingIconDisappear(30, "Loading_Gif",objectData);
		sleep(1000);
		sendKeysWithEnter("NewUser_LiveSearchTextbox","NewUser_FirstName",newuserData,testData);
		sleep(2000);
		click("NewUser_SearchButton",newuserData);
		sleep(4000);
		click("User_SearchedResetPassword_Button",newuserData);
		sleep(1000);*/
		sendKeys("User_PopupNewPassword_Textfield","User_ResetPassword",newuserData,testData);
		sendKeys("User_PopupConfirmNewPassword_Textfield","User_ResetPassword",newuserData,testData);
		click("User_PopupSave_Textfield",newuserData);
		waitForLoadingIconDisappear(30, "Loading_Gif",objectData);
		verifyText("NewUser_Confirmation_Message","User_Reset_Success_Message",newuserData,testData);
		click("User_Popup_Close_Button", newuserData);
	}

	/*public void resetPassword(String newuserData, String testData, String objectData) throws InterruptedException{	

		sleep(1000);
		sendKeysWithEnter("NewUser_LiveSearchTextbox","NewUser_FirstName",newuserData,testData);
		sleep(2000);
		click("NewUser_SearchButton",newuserData);
		sleep(1000);
		click("User_SearchedResetPassword_Button",newuserData);
		sleep(1000);
		sendKeysWithEnter("User_PopupNewPassword_Button","Login_Password_Textfield_Value",newuserData,testData);
		sendKeysWithEnter("User_PopupConfirmNewPassword_Button","Login_Password_Textfield_Value",newuserData,testData);
		click("User_PopupSaveClose_Button",newuserData);
		sleep(1000);
	}*/

	public void deleteNewUser(String newuserData, String testData) throws InterruptedException{	

		sleep(1000);
		sendKeysWithEnter("NewUser_LiveSearchTextbox","NewUser_FirstName",newuserData,testData);
		sleep(2000);
		click("NewUser_SearchButton",newuserData);
		sleep(1000);
		clickElementUsingJavaScript("NewUser_SearchedDeleteButton",newuserData);
		click("NewUser_DeleteYesButton",newuserData);

	}

	public List<String> getUserGroupMember(String newuserData, String testData,String objectData,String groupName) throws InterruptedException {
		
		List<String> userMember= new ArrayList<String>();
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//mouseHover("NewUser_SettingsDropdown", "NewUser_UserMangDropdown",newuserData);
		gotoNewUserPage(newuserData, testData, objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("User_ManageGroup_Button",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("User_GroupMember_Icon",groupName,newuserData, testData);
		sleep(1000);
		click("User_GroupMember_Icon",groupName,newuserData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		List<WebElement> userMemberList=webElementsIdentifier(PropertiesCache.getProperty(newuserData, "User_GroupMember_List"));
		for(WebElement element:userMemberList) {
			userMember.add(element.getText().trim());
		}
		sleep(1000);
		click("User_GroupMember_CloseIcon",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("User_ManageGroup_CloseIcon",newuserData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		return userMember;
	}
	public void getExistingUserFieldText(String newuserData, String testData, String objectData,String customlist,String userList) {	
		sleep(1000);
		click("NewUser_SearchedEditButton",newuserData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		List<WebElement> roleList= webElementsIdentifier(PropertiesCache.getProperty(newuserData, customlist));
		PropertiesCache.setProperty(PlutoraConfiguration.customizationData, userList,customizeUsermanagementFieldLocator(roleList));
		click("UserManagement_CloseIcon",newuserData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
	}
	
	private String customizeUsermanagementFieldLocator(List<WebElement> list) {
		String loc1="(//div[contains(@id,'customFieldPermissionsWindowGrid')]//div[";
		String loc3="][@class='x-grid-cell-inner ']/ancestor::tr/td[1]/div)[1]";
		String loc2="";
		for(WebElement element :list) {
			if(list.get(list.size() - 1).getText().equals(element.getText())) {
			loc2=loc2+"not(text()='"+element.getText()+"')";
			}else {
			 loc2=loc2+"not(text()='"+element.getText()+"') and ";
			}
			
		}
		return loc1+loc2+loc3;
	}
	private String customizeUsermanagementOrgFieldLocator(List<WebElement> list) {
		String loc1="(//div[contains(@id,'customFieldPermissionsWindowTree')]//span[";
		String loc3="][@class='x-tree-node-text ']/ancestor::tr/td[1]/div)[1]";
		String loc2="";
		for(WebElement element :list) {
			if(list.get(list.size() - 1).getAttribute("value").equals(element.getAttribute("value"))) 
			loc2=loc2+"not(text()='"+element.getAttribute("value")+"')";
		}
		return loc1+loc2+loc3;
	}
	public void getExistingOrganizationAssociationText(String newuserData, String testData, String objectData,String customlist,String userList){	
		sleep(1000);
		click("NewUser_SearchedEditButton",newuserData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		List<WebElement> roleList= webElementsIdentifier(PropertiesCache.getProperty(newuserData, customlist));
		PropertiesCache.setProperty(PlutoraConfiguration.customizationData, userList,customizeUsermanagementOrgFieldLocator(roleList));
		click("UserManagement_CloseIcon",newuserData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
	}
	public void inactiveUser(String userManagementData,String objectData) {
		click("NewUser_SearchedEditButton",userManagementData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(userManagementData,"NewUser_Inactive_RadioButton",objectData);
		clickOnButton(userManagementData,"NewUser_SaveCloseButton",objectData);
		Listener.addLogger("New user inactivated successfully !");
	}
	public void activeUser(String userManagementData,String objectData) {
		click("NewUser_SearchedEditButton",userManagementData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(userManagementData,"NewUser_ActiveRadioButtton",objectData);
		clickOnButton(userManagementData,"NewUser_Indefinitely_ON_Icon","NewUser_Indefinitely_OFF_Icon",objectData,"xpath");
		clickOnButton(userManagementData,"NewUser_AllowLogin_ON_Icon","NewUser_AllowLogin_OFF_Icon",objectData,"xpath");
		clickOnButton(userManagementData,"NewUser_SaveCloseButton",objectData);
		Listener.addLogger("New user activated successfully !");
	}
	
	public void validUntil(String userManagementData,String testData,String objectData) throws ParseException {
		clickOnButton(userManagementData,"NewUser_ActiveRadioButtton",objectData);
		clickOnButton(userManagementData,"NewUser_ValidUntil_RadioButton",objectData);
		clear("NewUser_ValidUntil_Textbox", userManagementData);
		sendKeysWithoutClear("NewUser_ValidUntil_Textbox", getTodayDate("0", "dd/MM/yyyy"),userManagementData);
		clickOnSaveAndCloseButton(userManagementData, objectData);
	
		readNewUser(userManagementData,testData,objectData,"NewUser_FirstName");
		clickOnButton(userManagementData, "NewUser_SearchedEditButton", objectData);
		verifyTextEqualsNotDisplayedInPage(getTodayDate("0", "dd/MM/yyyy"));
		Listener.addLogger("The date in this field must be equal to or after "+getTodayDate("0", "dd/MM/yyyy")+" validated wrong date successfully !");
		
		clickOnButton(userManagementData,"NewUser_ValidUntil_Calender_Icon",objectData);
		applicationDatePicker(userManagementData, testData, "NewUser_ValidUntil_Calender",getDate(getCurrentDate("0"),"1"));
		validateElementDisplayed("NewUser_ValidUntil_RemainingText","1",userManagementData);
		Listener.addLogger(getTextData("NewUser_ValidUntil_RemainingText", "1",userManagementData)+" Validated in usermanagement successfully !");
		clickOnSaveAndCloseButton(userManagementData, objectData);
		
	}
	public void reassignAssignee(String userManagementData,String testData,String objectData,String user1,String user2,String activitiesText) {
		clickOnButton(userManagementData,"UserManagement_Reassign_Assignee_Button",objectData);
		sendKeys("UserManagement_Reassign_Replaced_Textbox", user1,userManagementData,testData,objectData);
		//doubleClick("UserManagement_Reassign_Replaced_Dropdown",userManagementData);
		clickButton("UserManagement_Reassign_Replaced_Dropdown_Option",user1,userManagementData,testData,objectData);
		
		sendKeys("UserManagement_Reassign_Replace_With_Textbox", user2,userManagementData,testData,objectData);
		//clickOnButton(userManagementData,"UserManagement_Reassign_Replace_With_Dropdown",objectData);
		clickButton("UserManagement_Reassign_Replace_With_Dropdown_Option",user2,userManagementData,testData,objectData);
		Listener.addLogger("User Management "+PropertiesCache.getProperty(testData, user1)+" Assigned to "+PropertiesCache.getProperty(testData, user2));
		if(!activitiesText.isEmpty()) {
			click("UserManagement_Reassign_ActivitiesPast_Checkbox",userManagementData);
			click("UserManagement_Reassign_ActivitiesFuture_Checkbox",userManagementData);
			click("UserManagement_Reassign_OpenActivities_Checkbox",userManagementData);
			Listener.addLogger("User Management"+" Selected Activites checkbox successfully !");
		}
		clickOnButton(userManagementData, "UserManagement_Reassign_Save&Close_Button", objectData);
		clickOnButton(userManagementData, "NewUser_DeleteYesButton", objectData);
	}
	public void addGroupMember(String newuserData, String testData,String objectData,String groupName) throws InterruptedException {
		
		clickButton("User_GroupMember_Icon",groupName,newuserData,testData,objectData);
		sendKeys("UserManagement_ManageGroups_Users_Textbox", "Group_Member_One",newuserData,testData,objectData);
		clickButton("UserManagement_ManageGroups_Users_Dropdown_Option","Group_Member_One",newuserData,testData,objectData);
		sendKeys("UserManagement_ManageGroups_Users_Textbox", "Group_Member_Second",newuserData,testData,objectData);
		clickButton("UserManagement_ManageGroups_Users_Dropdown_Option","Group_Member_Second",newuserData,testData,objectData);
		//sendKeys("UserManagement_ManageGroups_Roles_Textbox", "Role",newuserData,testData,objectData);
		//clickButton("UserManagement_ManageGroups_Users_Dropdown_Option","Role",newuserData,testData,objectData);
		clickOnButton(newuserData,"UserManagement_ManageGroups_BulkUpdate_Save&Close_Button",objectData);
		clickOnButton(newuserData,"UserManagement_ManageGroups_Save&Close_Button",objectData);
	}
	public void createGroup(String newuserData, String testData,String objectData,String groupName,String description) {
		
		sendKeys("UserManagement_ManageGroups_AddUserGroups_Textbox",PropertiesCache.setProperty(testData, groupName),newuserData);
		doubleClick("UserManagement_ManageGroups_AddUserGroups_Description", newuserData);
		sendKeys("UserManagement_ManageGroups_AddUserGroups_Description_Textbox",PropertiesCache.setProperty(testData, description),newuserData);
		clickOnButton(newuserData,"UserManagement_ManageGroups_Save_Button",objectData);
	}
	
	public void createRole(String newuserData, String testData,String objectData,String groupName,String description) {
		sendKeys("UserManagement_ManagePermissions_AddRole_Textbox",PropertiesCache.setProperty(testData, groupName),newuserData);
		doubleClick("UserManagement_ManagePermissions_AddRole_Description", newuserData);
		sendKeys("UserManagement_ManagePermissions_AddRole_Description_Textbox",PropertiesCache.setProperty(testData, description),newuserData);
		clickOnButton(newuserData,"UserManagement_ManagePermissions_Role_Save_Button",objectData);
	}
	public void checkUserPermissionsCheckbox(String newuserData, String testData,String objectData,String roleName) throws InterruptedException {
		int i=selectMultipleDoubleButton(newuserData, "UserManagement_ManagePermissions_Unselected_Checkbox");
		clickOnButton(newuserData,"UserManagement_ManagePermissions_Permission_Save_Buttn",objectData);
		clickOnButton(newuserData,"UserManagement_ManagePermissions_Permissions_Save&Close_Button",objectData);
		gotoNewUserPage(newuserData, PlutoraConfiguration.testData, objectData);
		clickOnButton(newuserData, "UserManagement_ManagePermissions_Button", objectData);
		sleep(1000);
		doubleClick("UserManagement_ManagePermissions_Role_Row",roleName,newuserData,testData);
		doubleClick("UserManagement_ManagePermissions_Role_Row",roleName,newuserData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		verifyText("UserManagement_ManagePermissions_Role_Name",roleName,newuserData,testData);
		Listener.addLogger(PropertiesCache.getProperty(newuserData, roleName)+" existed in User management page successfully !");
		int j=getWebElementCount("UserManagement_ManagePermissions_Selected_Checkbox", "", newuserData, "");
		if(i>=j) {
			assertTrue(true);
			Listener.addLogger(PropertiesCache.getProperty(newuserData, roleName)+" New Role all permission checkbox ticked successfully !");
		}else {
			assertTrue(false);
			Listener.addLogger(PropertiesCache.getProperty(newuserData, roleName)+" New Role all permission checkbox not ticked successfully !");
		}
		clickOnButton(newuserData, "UserManagement_ManagePermissions_Close_Icon", objectData);
	}
	public void removeUserRole(String newuserData, String testData,String objectData,String roleName) {
		
		clickButton("UserManagement_ManagePermissions_Role_Row",roleName,newuserData,testData,objectData);
		clickOnButton(newuserData, "UserManagement_ManagePermissions_RemoveRole_Button", objectData);
		clickOnButton(newuserData, "UserManagement_ManagePermissions_Close_Icon", objectData);
	}
	public void verifyAdditionalInformationTab(String usermangementData,String testData,String objectData,String customFieldList,String userName) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Usermanagement_AdditionalInformation_Tab",usermangementData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName", "UM_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "UM_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(usermangementData,testData, objectData, customFieldList,"UM_CustomField_Name",userName,"NewUser_SearchedEditButton","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "UM_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	public void clickOnSaveAndCloseButton(String userManagementData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("NewUser_SaveCloseButton",userManagementData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	public void sendBroadcast(String userManagementData,String testData,String objectData,String emailSubject,String user,String body) {
		clickOnButton(userManagementData,"UserManagement_SendNotification_Button",objectData);
		sendKeys("UserManagement_SendNotification_EmailTo_Textbox",user,userManagementData,testData);
		clickButton("UserManagement_SendNotification_EmailTo_Option",user,userManagementData,testData,objectData);
		clickButton("UserManagement_SendNotification_EmailTo_Textbox",user,userManagementData,testData,objectData);
		sendKeys("UserManagement_SendNotification_EmailSubject",emailSubject,userManagementData);
		switchToFrameByElement("Global_Iframe_One", objectData);
		sendKeys("Global_Description_TextField", body,objectData);
		switchToDefaultContent();
		sendKeys("UserManagement_SendNotification_Sender_Textbox",user,userManagementData,testData);
		clickOnButton(userManagementData, "UserManagement_SendNotification_Send_Button", objectData);
	}
	
	
}
