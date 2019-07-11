package com.plutoratest.pagerepo;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class UserManagementPage extends TestGenericUtilLib  {

	public static String user_email = null;
	public static String user_fullname=null;
	public static String user_role=null;
	public static String user_portfolio=null;
	public static String user_group=null;
	public static String tmpPassword=null;
	String fn = null;
	String ln = null;

	public void createNewUser(String userData, String testData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Settings_MenuTab", objectData);
		sleep(1000);
		clickElementUsingJavaScript("UserManagement_Tab", objectData);
		sleep(1000);
		waitForLoadingIconDisappear(500,"Progress_Bar", objectData);
		clickElementUsingJavaScript("NewUser_Create_Button", userData);
		sleep(1000);
		fn = PropertiesCache.setProperty(testData, "User_FN");
		sendKeys("NewUser_FirstName_Textbox",fn,userData);
		sleep(1000);
		ln = PropertiesCache.setProperty(testData, "User_LN");
		sendKeys("NewUser_LastName_Textbox",ln,userData);
		sleep(1000);
		user_fullname = fn+" "+ln;
		user_email = PropertiesCache.setProperty(testData, "user_email")+"@yopmail.com";
		sleep(1000);
		sendKeys("NewUser_Email_Textbox",user_email,userData);
		sleep(1000);
		click("NewUser_UserRole_Textbox", userData);
		sleep(1000);
		user_role=getTextData("NewUser_UserRole_ATOption", userData);
		click("NewUser_UserRole_ATOption",userData);
		sleep(1000);
		click("NewUser_Portfolio_Dropdown", userData);
		sleep(1000);
		user_portfolio=getTextData("NewUser_Portfolio_Option",userData);
		click("NewUser_Portfolio_Option",userData);
		sleep(1000);
		click("NewUser_AddUserGroup_Dropdown", userData);
		sleep(1000);
		user_group=getTextData("NewUser_AddUserGroup_Option",userData);
		click("NewUser_AddUserGroup_Option",userData);
		sleep(1000);
		/*sendKeys("NewUser_Password_Textbox","NewUser_Password",userData,testData);
		sleep(2000);*/
		click("NewUser_Save_Button", userData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		sendKeys("UserManagement_Search_Textbox",user_email,userData);
		sleep(1000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		verifyText("NewUser_Search_Email",user_email.toLowerCase(),userData );

	}

	public void verifyNewUser(String userData, String testData, String objectData) throws InterruptedException {

		verifyText("NewUser_Search_UserName",user_fullname,userData );
		//Listener.test1.log(Status.INFO,"New User name verified successfully ");
		verifyText("NewUser_Search_Email",user_email.toLowerCase(),userData );
		//Listener.test1.log(Status.INFO,"New User email id verified successfully ");
		verifyText("NewUser_Search_Role",user_role,userData);
		//Listener.test1.log(Status.INFO,"New User role verified successfully ");
		verifyText("NewUser_Search_UserGroup",user_group,userData);
		//Listener.test1.log(Status.INFO,"New User Group verified successfully ");
		verifyText("NewUser_Search_Portfolio",user_portfolio,userData);
		//Listener.test1.log(Status.INFO,"New User portfolio verified successfully ");

	}
	
	public void updateNewUser(String userData, String testData, String objectData) throws InterruptedException {

		click("NewUser_Search_UserName",userData );
		sleep(2000);
		click("NewUser_Phone_EditIcon",userData );
		sleep(1000);
		sendKeys("NewUser_Phone_Edit_Textbox","NewUser_PhoneNumber",userData,testData);
		sleep(2000);
		click("NewUser_Search_UserName",userData );
		sleep(4000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		String phoneNumber = getAttributeDataValue("NewUser_Phone_Edit_Textbox",userData);
		
		verifyTextFromTestData("NewUser_PhoneNumber",phoneNumber,testData);

	}
	
	public void forgetPasswordNewUser(String userData, String testData, String objectData,String loginData) throws InterruptedException {

		clickElementUsingJavaScript("Loggedin_Username",loginData);
		click("User_MyAccount_Link",userData);
		sleep(2000);
		click("User_Change_Password_Link",userData);
		sleep(2000);
		sendKeys("User_Popup_CurrentPassword_Textbox","NewUser_Password",userData,testData);
		sendKeys("User_Popup_NewPassword_Textbox","User_NewPassword",userData,testData);
		click("User_Popup_Submit_Button",userData);
		sleep(2000);
	}
	
	public void deleteNewUser(String userData, String testData, String objectData) throws InterruptedException {

		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Settings_MenuTab", objectData);
		sleep(2000);
		clickElementUsingJavaScript("UserManagement_Tab", objectData);
		sleep(2000);
		sendKeysWithEnter("UserManagement_Search_Textbox",user_email.toLowerCase(),userData);
		sleep(4000);
		verifyText("NewUser_Search_Email",user_email.toLowerCase(),userData );
		click("NewUser_Search_Email", userData);
		sleep(4000);
		click("NewUser_Delete_Account_Button",userData );
		sleep(2000);
		click("NewUser_Delete_Yes_Button",userData);
		sleep(1000);
		verifyTextEqualsNotDisplayedInPage(user_fullname);

	}
	
	public void activateNewUser(String userData, String testData, String objectData) {
		sleep(2000);
		launchUrl("Yopmail_HomePage_URL",testData);
		sleep(1000);
		sendKeysWithEnter("Yopmail_EmailInput","user_email",objectData,testData);
//		sendKeys("Login_Email_Textfield",UserManagementPage.user_email,loginData);
//		sendKeysWithEnter("Yopmail_EmailInput", UserManagementPage.user_email, objectData);
		sleep(3000);
		//click("Registration_CheckNewMails_Button",objectData);
		sleep(1000);
		switchToFrameByName("Frame_Name",testData);
		sleep(1000);
		tmpPassword =getTextData("Yopmail_Temporary_Password", objectData);
		clickOnActivationLink("Yopmail_Activation_Link", objectData);
		switchToWindowPopup();
	}
	
	public void givePassword(String userData, String testData, String objectData) {
		sleep(1000);
		sendKeys("NewUser_NewPassword_Textbox", "NewUser_Password", userData, testData);
		sleep(500);
		sendKeys("NewUser_ConfirmNewPassword_Textbox", "NewUser_Password", userData, testData);
		sleep(1000);
		click("NewUser_Password_Submit_Button", userData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
}
