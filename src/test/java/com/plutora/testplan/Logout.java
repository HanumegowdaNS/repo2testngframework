package com.plutora.testplan;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.utils.Listener;

public class Logout {
   
	LogoutPage logoutPage = new LogoutPage();
	@Parameters({"url","objectMapFile"})
	@Test(description = "User Logout")
	public void logout(String url,String loginMapFile) throws InterruptedException {		
		logoutPage.loginoutPage(url,loginMapFile);
		Thread.sleep(5000);
		Listener.test1.log(Status.INFO,"User has logged out successfully | ");
	}
	
}

