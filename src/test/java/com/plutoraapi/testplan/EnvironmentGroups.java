package com.plutoraapi.testplan;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentGroupsPage;

public class EnvironmentGroups  {
	
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	
	
	@Test(priority = 1,description = "Create Environment Groups", groups = { "RegressionTests" })
	public void createEnvironmentGroups(){
		APIListener.test1.log(Status.INFO, "Create Environment Groups"); 
		environmentGroupsPage.createEnvironmentGroup("createEnvironmentGroupsJson", PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//
		environmentGroupsPage.verifyResponseNotEmpty("id;name;description;color");
		environmentGroupsPage.verifyResponseValue("color",PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"id", environmentGroupsPage.response.path("id").toString());
	}
	
	@Test(priority = 2,description = "Verify Environment Groups", groups = { "RegressionTests" })
	public void verifyEnvironmentGroups() {
		APIListener.test1.log(Status.INFO, "Verify Environment Groups"); 
		environmentGroupsPage.verifyEnvironmentGroup(PlutoraAPIConfiguration.testData); 
		/****************Verify Status Code******************/
		environmentGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	
	}
	
	@Test(priority = 3,description = "Update Environment Groups", groups = { "RegressionTests" })
	public void updateEnvironmentGroups() {
		APIListener.test1.log(Status.INFO, "Update Environment Groups"); 
		environmentGroupsPage.updateEnvironmentGroup("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	}
	
	@Test(priority = 4,description = "Delete Environment Groups", groups = { "RegressionTests" })
	public void deleteEnvironmentGroups() {
		APIListener.test1.log(Status.INFO, "Delete Environment Groups"); 
		environmentGroupsPage.deleteEnvironmentGroup(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

