package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class NewUser {

	NewUserPage newuser = new NewUserPage();
	LoginPage login = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();

	@Test(description="New User Creation")
	@Parameters({"newUserFile","testDataFile","objectMapFile"})
	public void newUser_01(String newUserData, String testData, String objectData) throws InterruptedException {		
		newuser.addNewUser(newUserData,testData,objectData,"NewUser_FirstName","NewUser_LastName");
		newuser.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",newUserData,testData);
		Listener.addLogger("New User is created successfully | ");
		
	}
	
	@Test(description="Verifying the User is Created")
	@Parameters({"newUserFile","testDataFile","objectMapFile"})
	public void newUser_02(String newUserData, String testData, String objectData) throws InterruptedException {	
		newuser.readNewUser(newUserData,testData,objectData,"NewUser_FirstName");
		newuser.verifyText("NewUser_SearchResultFirstName","NewUser_FirstName",newUserData,testData);
		Listener.addLogger("New User reading successfully | ");
		
	}
	
	@Test(description="Updating a User")
	@Parameters({"newUserFile","testDataFile","objectMapFile", "url"})
	public void newUser_03(String newUserData, String testData, String objectData, String url) throws InterruptedException {	
		newuser.updateNewUser(newUserData,testData,objectData);
		newuser.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",newUserData,testData);
		Listener.addLogger("New User updated successfully | ");	
		logoutPage.loginoutPage(url,objectData);
	}
	
	@Test(description="Activating the new user and Logging in to Plutora")
	@Parameters({"newUserFile","testDataFile","objectMapFile","url","loginFile"})
	public void newUser_04 (String newUserData, String testData, String objectData,String url,String loginData) throws InterruptedException {	
		newuser.activateNewUser(newUserData, testData, objectData);
		login.loginPage(loginData,testData,objectData, PropertiesCache.getProperty(testData,"LoginEmail")+"@yopmail.com", PropertiesCache.getProperty(testData,"User_NewPassword"));
		Listener.addLogger("New User Activated successfully | ");	
	}
	
	@Test(description="Resetting Password")
	@Parameters({"newUserFile","testDataFile","objectMapFile","url","loginFile","username","password"})
	public void newUser_05(String newUserData, String testData, String objectData,String url,String loginData, String userName, String password) throws InterruptedException {	
		newuser.resetPassword(newUserData,testData,objectData);

		//newuser.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",newUserData,testData);
		Listener.addLogger("User Reset Password Changed successfully | ");

		//Logout the user
		logoutPage.loginoutPage(url,objectData);
		Thread.sleep(1000);
		
		//New user login with new password
		login.loginWithNewPassword(loginData,testData,objectData,PropertiesCache.getProperty(testData,"LoginEmail")+"@yopmail.com","User_ResetPassword");
		Thread.sleep(1000);
		String loggedinUsername = login.userFullName("NewUser_FirstName","NewUser_LastName",testData);
		//login.verifyText("Loggedin_Username",loggedinUsername,loginData);
		Listener.addLogger("New User logged in with new password successfully | ");		
	}
	
	@Test(description="New User Deleting")
	@Parameters({"newUserFile","testDataFile","objectMapFile","url","loginFile","username","password"})
	public void newUser_06(String newUserData, String testData, String objectData,String url,String loginData, String userName, String password) throws InterruptedException {
		//Logout user
		logoutPage.loginoutPage(url,objectData);
		Thread.sleep(1000);
		
		//Login with old user
		login.loginPage(loginData,testData,objectData, userName, password);
		login.waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		newuser.gotoNewUserPage(newUserData, testData, objectData);
		newuser.deleteNewUser(newUserData,testData);
		newuser.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",newUserData,testData);
		newuser.sleep(5000);
		Listener.addLogger("New User deleted successfully | ");
	}
	
	
	
}


