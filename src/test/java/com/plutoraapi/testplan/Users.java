package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.UsersPage;

public class Users  {
	
	UsersPage usersPage = new UsersPage();

	
	@Test(description = "Verify Users", groups = { "RegressionTests" })
	public void verifyUsers() {
		APIListener.test1.log(Status.INFO, "Verify Users"); 
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		usersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UsersParameterNotEmpty"));
	
	}
	

	@Test(description = "Verify List of Users Groups", groups = { "RegressionTests" },dependsOnMethods="verifyUsers")
	public void verifyListOfUserGroups() {
		APIListener.test1.log(Status.INFO, "Verify Users Groups"); 
		usersPage.verifyUserGroups(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		usersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterNotEmpty"));
	
	}


}

