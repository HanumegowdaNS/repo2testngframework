package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.PropertiesCache;

public class ForgotPassword extends PlutoraConfiguration {

 LoginPage loginPage = new LoginPage();
 LogoutPage logoutPage = new LogoutPage();
  
  @Test (description="Forgot Password")
  public void forgotPassword() throws InterruptedException {
	  //Forgot Password Reset
	  loginPage.forgotPassword(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	  //Email Verification
	  loginPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ForgotPassword_Subject",PropertiesCache.getProperty(PlutoraConfiguration.testData, "ForgotPassword_Username"));
	  loginPage.resetPassword(PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	  LoginPage.launchUrl(PlutoraConfiguration.applicationURL);
	  //Login with new password 
	  loginPage.loginWithNewPassword(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PropertiesCache.getProperty(PlutoraConfiguration.testData, "ForgotPassword_Username"),"ForgotPassword_NewPassword");
	  logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
	  //Forgot Password Reset to old password
	  loginPage.forgotPassword(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	  //Email Verification
	  loginPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ForgotPassword_Subject",PropertiesCache.getProperty(PlutoraConfiguration.testData, "ForgotPassword_Username"));
	  loginPage.resetPassword(PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	  LoginPage.launchUrl(PlutoraConfiguration.applicationURL);
  }
  
}
