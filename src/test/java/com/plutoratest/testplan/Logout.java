package com.plutoratest.testplan;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutoratest.pagerepo.LogoutPage;
import com.plutora.utils.Listener;

public class Logout {
   
	LogoutPage logoutPage = new LogoutPage();
	@Parameters({"loginFile"})
	@Test(description = "User Logout")
	public void logout(String loginData) throws InterruptedException {		
		logoutPage.loginoutPage(loginData);
		Thread.sleep(5000);
		Listener.test1.log(Status.INFO,"User has logged out successfully | ");
	}
	
}

