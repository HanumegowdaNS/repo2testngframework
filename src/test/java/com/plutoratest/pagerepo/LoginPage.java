package com.plutoratest.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class LoginPage extends TestGenericUtilLib {
	public void loginPage(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException{	
		//sendKeys("Login_Email_Textfield","Login_Email_Textfield_Value",loginData,testData);
		//sendKeys("Login_Password_Textfield","Login_Password_Textfield_Value",loginData,testData);
		sendKeys("Login_Email_Textfield", userName, loginData);
		sendKeys("Login_Password_Textfield", password, loginData);
		click("Login_Button",loginData);
		click("Login_Search",loginData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("Login_Search", "TestAutomation",loginData);
		sleep(2000);
		clickElementUsingJavaScript("Login_ProjectName","Project_Name",loginData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void loginWithOldPassword(String loginData,String testData,String objectData) throws InterruptedException{
		sleep(3000);
		sendKeys("Login_Email_Textfield",UserManagementPage.user_email,loginData);
		sendKeys("Login_Password_Textfield","NewUser_Password",loginData,testData);
		click("Login_Button",loginData);
		sleep(2000);
	}
	
	public void loginWithNewPassword(String loginData,String testData,String objectData) throws InterruptedException{
		sleep(3000);
		sendKeys("Login_Email_Textfield",UserManagementPage.user_email,loginData);
		sendKeys("Login_Password_Textfield","User_NewPassword",loginData,testData);
		click("Login_Button",loginData);
		sleep(2000);
	}
	
	public void reloginPage(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException{	
		//sendKeys("Login_Email_Textfield","Login_Email_Textfield_Value",loginData,testData);
		//sendKeys("Login_Password_Textfield","Login_Password_Textfield_Value",loginData,testData);
		sendKeys("Login_Email_Textfield", userName, loginData);
		sendKeys("Login_Password_Textfield", password, loginData);
		click("Login_Button",loginData);
		sleep(2000);
	}
	
	public void loginWithTempPassword(String loginData,String tempPassword,String objectData) throws InterruptedException{
		sleep(3000);
		sendKeys("Login_Email_Textfield",UserManagementPage.user_email.toLowerCase(),loginData);
		sendKeys("Login_Password_Textfield", tempPassword, loginData);
		//sendKeys("Login_Password_Textfield","NewUser_Password",loginData,testData);
		click("Login_Button",loginData);
		sleep(2000);
	}
	
	public void loginWithGoogleAccount(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException{	
		sendKeys("Google_Email_Textfield", userName, loginData);
		click("Google_Next_Button", loginData);
		sleep(1000);
		sendKeys("Google_Password_Textfield", password, loginData);
		click("Google_SignIn_button", loginData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("Login_Search", "TestAutomation",loginData);
		sleep(2000);
		clickElementUsingJavaScript("Login_ProjectName","Project_Name",loginData,testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void newLoginPage(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException{	
		sendKeys("Login_Email_Textfield", userName, loginData);
		sendKeys("Login_Password_Textfield", password, loginData);
		click("Login_Button",loginData);
		click("Login_Search",loginData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
}
