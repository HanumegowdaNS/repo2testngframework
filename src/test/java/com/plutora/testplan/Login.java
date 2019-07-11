
package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.plutora.pagerepo.LoginPage;
import com.plutora.utils.Listener;

public class Login {	
	
	LoginPage login = new LoginPage();
	@Test (description = "User Login")
	@Parameters({"loginFile","testDataFile","objectMapFile","username","password"})
	public void login(String loginData,String testData,String objectData, String userName, String password) throws InterruptedException {		
		   //login.loginWithSSOLogin(loginData, objectData, userName);
		if(login.getBrowserTitle().contains("Sign in - Google Accounts")) {
		   //login.loginWithGoogleAccount(loginData, testData, objectData, userName, "Katpalli1201");
		   //login.loginWithGoogleAccount(loginData, objectData, userName, "1JA10sLcfTCgOcVEx64DXm57daglDMf9V");
		   //login.loginWithGoogleAccount(loginData, testData, objectData, userName, "P4@plutora");
		}
		else {
			login.loginPage(loginData,testData,objectData, userName, password);
		}
		login.waitForLoadingIconDisappear(40, "Loading_Gif",objectData);
		login.verifyTitle("Plutora");
		Listener.addLogger("Login successfully | ");
	}
	
}
