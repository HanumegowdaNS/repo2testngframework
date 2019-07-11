package com.plutoratest.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class LogoutPage extends TestGenericUtilLib {
	
	public void loginoutPage(String loginData) throws InterruptedException{	
		Thread.sleep(2000);
		clickElementUsingJavaScript("Loggedin_Username",loginData);
		click("Logout_Dropdown_Option",loginData);
}

}