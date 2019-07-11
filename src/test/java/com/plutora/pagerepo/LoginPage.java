package com.plutora.pagerepo;

import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class LoginPage extends TestGenericUtilLib {
	public void loginPage(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException{	
		sendKeys("Login_Email_Textfield", userName, loginData);
		sendKeys("Login_Password_Textfield", password, loginData);
		click("Login_Button",loginData);
		sleep(5000);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		//loginWithSSOLogin(loginData, objectData, userName);
		//loginWithGoogleAccount(loginData, objectData, userName, password);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Login_Email_Textfield_Value")+" Logged into system successfully !");
	}
	public void loginWithNewPassword(String loginData,String testData,String objectData,String username,String password) throws InterruptedException{
		sleep(3000);
		sendKeys("Login_Email_Textfield",username,loginData);
		sendKeys("Login_Password_Textfield",password,loginData,testData);
		click("Login_Button",loginData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//loginWithSSOLogin(loginData, objectData, username);
		//loginWithGoogleAccount(loginData, objectData, username, password);
		Listener.addLogger("User able to login with new password successfully");
	}
	public void newLoginPage(String loginData,String testData,String objectData){	
		sendKeys("Login_Email_Textfield","NewLogin_Email_Textfield_Value",loginData,testData);
		sendKeys("Login_Password_Textfield","NewLogin_Password_Textfield_Value",loginData,testData);
		click("Login_Button",loginData);
	
		//loginWithSSOLogin(loginData, objectData, testData,"NewLogin_Email_Textfield_Value");
		//loginWithGoogleAccount(loginData, testData, objectData, "NewLogin_Email_Textfield_Value", "NewLogin_Password_Textfield_Value");
		sleep(5000);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "NewLogin_Email_Textfield_Value")+" Logged into system successfully !");
	}
	public void forgotPassword(String loginData,String testData,String objectData) {
		click("ForgotPasswordLink",loginData);
		sendKeys("ForgotPassword_EmailId_Textfield", "ForgotPassword_Username",loginData,testData);
		click("ForgotPassword_Reset_Button",loginData);
		Listener.addLogger("Reset password link has been sent to yopmail account successfully !");
	}
	public void loginPageWithLoginPageMessage(String loginData,String testData,String objectData){	
		sendKeys("Login_Email_Textfield","Login_Email_Textfield_Value",loginData,testData);
		sendKeys("Login_Password_Textfield","Login_Password_Textfield_Value",loginData,testData);
		//sendKeys("Login_Email_Textfield",PropertiesCache.getProperty(testData,"LoginEmail")+"@yopmail.com",loginData);
		//sendKeys("Login_Password_Textfield","User_ResetPassword",loginData,testData);
		click("Login_Button",loginData);
		sleep(5000);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		clickOnButton(loginData,"Login_Welcome_CloseButton",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Login_Email_Textfield_Value")+" Logged into system successfully !");
	}

	public void loginWithGoogleAccount(String loginData,String objectData, String userName, String password) {	
		switchToWindowPopup();
		sendKeys("Google_Email_Textfield", userName, loginData);
		click("Google_Next_Button", loginData);
		sleep(1000);
		sendKeys("Google_Password_Textfield", password, loginData);
		click("Google_SignIn_button", loginData);
	}
	public void loginWithSSOLogin(String loginData,String objectData,String userName) {
		sleep(1000);
		sendKeys("Login_Email_Textfield", userName, loginData);
		sleep(3000);
		click("Login_SSO_Button",loginData);
		sleep(1000);
		
	}
	public void loginWithSSOLogin(String loginData,String objectData,String testData,String userName) {
		sendKeys("Login_Email_Textfield", userName, loginData,testData);
		click("Login_SSO_Button",loginData);
		sleep(1000);
		
	}
	public void loginWithGoogleAccount(String loginData,String testData,String objectData, String userName, String password) {	
		switchToWindowPopup();
		sendKeys("Google_Email_Textfield", userName, loginData,testData);
		click("Google_Next_Button", loginData);
		sleep(1000);
		sendKeys("Google_Password_Textfield", password, loginData,testData);
		click("Google_SignIn_button", loginData);
	}
}
