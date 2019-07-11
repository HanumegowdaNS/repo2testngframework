package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.UserGroupsPage;

public class UserGroups  {
	
	UserGroupsPage userGroupsPage = new UserGroupsPage();
	
	@Test(description = "Create User Groups", groups = { "RegressionTests" })
	public void createUserGroups(){
		APIListener.test1.log(Status.INFO, "Create User Groups"); 
		userGroupsPage.createUserGroups("createUserGroupsJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		userGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		userGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterNotEmpty"));
		/****************Set Identifier******************/
		userGroupsPage.setMapValuesToProperty("Data","Id");
	}
	
	@Test(description = "Verify User Groups", groups = { "RegressionTests" },dependsOnMethods="createUserGroups")
	public void verifyUserGroups() {
		APIListener.test1.log(Status.INFO, "Verify User Groups"); 
		userGroupsPage.verifyUserGroups(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		userGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		userGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterNotEmpty"));
		userGroupsPage.verifyMapResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsDataParameterValues"),PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update User Groups", groups = { "RegressionTests" },dependsOnMethods="verifyUserGroups")
	public void updateUserGroups() {
		APIListener.test1.log(Status.INFO, "Update User Groups"); 
		userGroupsPage.updateUserGroups("createUserGroupsJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		userGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		APIListener.test1.log(Status.INFO, "Verify Response after Updating Release"); 
		userGroupsPage.verifyUserGroups(PlutoraAPIConfiguration.testData);
		userGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterNotEmpty"));
		userGroupsPage.verifyMapResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsDataParameterValues"),PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserGroupsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete User Groups", groups = { "RegressionTests" },dependsOnMethods="updateUserGroups")
	public void deleteUserGroups() {
		APIListener.test1.log(Status.INFO, "Delete User Groups"); 
		userGroupsPage.deleteUserGroups(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		userGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

