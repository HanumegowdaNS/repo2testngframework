package com.plutoratest.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutoratest.pagerepo.LoginPage;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;

public class Login extends PlutoraTestConfiguration{	
	
	LoginPage login = new LoginPage();
	@Test (description = "User Login", groups = {"SmokeTests"})
	@Parameters({"loginFile","testDataFile","objectMapFile","username","password"})
	public void login(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException {	
		if(login.getBrowserTitle().equalsIgnoreCase("Sign in - Google Accounts")) {
			login.loginWithGoogleAccount(loginData, testData, objectData, userName, "Katpalli1201");
		}
		else {
			login.loginPage(loginData,testData,objectData, userName, password);
		}
		//login.verifyTextContains("Loggedin_Username","Loggedin_Username_Value",loginData,testData);
		Listener.test1.log(Status.INFO,"Login successfully | ");
	}
}
