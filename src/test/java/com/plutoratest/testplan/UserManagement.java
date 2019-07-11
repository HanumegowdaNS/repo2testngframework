package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutoratest.pagerepo.LoginPage;
import com.plutoratest.pagerepo.LogoutPage;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutoratest.pagerepo.UserManagementPage;

public class UserManagement {
	
	UserManagementPage userManagementPage = new UserManagementPage();
	LoginPage loginPage = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();
	
	@Test(description="Creating a New User")
	public void createUser() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Create User management 
		 ********************************************************/
		userManagementPage.createNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User created successfully ");
	}
	
	@Test(description="Verifying the User created", dependsOnMethods="createUser")
	public void verifyUser() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Verify User management 
		 ********************************************************/
		userManagementPage.verifyNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User verified successfully ");
	}
	
	@Test(description="Updating a User", dependsOnMethods="verifyUser")
	public void updateUser() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Update User management 
		 ********************************************************/
		userManagementPage.updateNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User updated successfully ");
	}
	
	@Test(description="Activating the New User", dependsOnMethods="updateUser")
	public void activateUser() throws InterruptedException, IOException, AWTException {
		/*******************
		 * Login to Yopmail and Activate the User created above 
		 ********************************************************/
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		userManagementPage.activateNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		loginPage.loginWithTempPassword(PlutoraTestConfiguration.loginData, UserManagementPage.tmpPassword, PlutoraTestConfiguration.objectData);
		userManagementPage.givePassword(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "Activated New User successfully ");
	}
	
	@Test(description="Activate the user, Login as new user and change password", dependsOnMethods="activateUser")
	@Parameters({"username","password"})
	public void changePassword(String userName, String password) throws InterruptedException, IOException, AWTException {
	
		/*****************************************
		 * Forget Password
		 *****************************************************/
	
		/*// Logout current user
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		loginPage.sleep(5000);
	
		// New user login with old password
		loginPage.loginWithOldPassword(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		loginPage.sleep(7000);*/
	
		userManagementPage.forgetPasswordNewUser(PlutoraTestConfiguration.userManagementData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
				PlutoraTestConfiguration.loginData);
	
		// Logout new user with old password
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		loginPage.sleep(2000);
	
		// New user login with new password
		loginPage.loginWithNewPassword(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Thread.sleep(2000);
		userManagementPage.verifyText("Loggedin_Username", UserManagementPage.user_fullname,
				PlutoraTestConfiguration.loginData);
		Listener.test1.log(Status.INFO, "New User logged in with new password successfully");
	
		// Logout new user with new password
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		Thread.sleep(2000);
	
		// Login with current user
		loginPage.reloginPage(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData, userName, password);
		Listener.test1.log(Status.INFO, "New User forget password functionality successfully ");
	}
	
	@Test(description="Delete a User", dependsOnMethods="changePassword")
	public void deleteUser() throws InterruptedException, IOException, AWTException {
	
		/*****************************************
		 * Delete user 
		 *****************************************************/
		userManagementPage.deleteNewUser(PlutoraTestConfiguration.userManagementData, PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		Listener.test1.log(Status.INFO, "New User deleted successfully ");
	}
}