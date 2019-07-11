package com.plutora.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class LogoutPage extends TestGenericUtilLib {

	
	public void loginoutPage(String url,String loginData) throws InterruptedException{	
		//WebGenericUtilLib.launchUrl(url);
		sleep(2000);
		
		clickElementUsingJavaScript("Login_FullName_Link",loginData);
		
		clickElementUsingJavaScript("Logout_Dropdown_Option",loginData);
		
		if(getBrowserTitle().equalsIgnoreCase("Sign in - Google Accounts")) {
			launchUrl(url);
		}
	}
}

