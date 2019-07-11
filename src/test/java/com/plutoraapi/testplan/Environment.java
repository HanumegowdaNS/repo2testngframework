package com.plutoraapi.testplan;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentPage;

public class Environment  {
	
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	
	@Test(priority = 1,description = "Create Environment", groups = { "RegressionTests" })
	public void createEnvironment(){
		APIListener.test1.log(Status.INFO, "Create Environment"); 
		environmentPage.createEnvironment("createEnvironmentDevJson", PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);// chnage the status code 
		//****************Verify Parameter values******************//
		environmentPage.verifyResponseNotEmpty("id;name;vendor;linkedSystemId;usageWorkItemId;environmentStatusId;isSharedEnvironment");
		environmentPage.verifyResponseValue("isSharedEnvironment",PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"id", environmentPage.response.path("id").toString());
	}
	
	@Test(priority = 2,description = "Verify Environment", groups = { "RegressionTests" })
	public void verifyEnvironment() {
		APIListener.test1.log(Status.INFO, "Verify Environment"); 
		environmentPage.verifyEnvironment(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	
	}
	
	@Test(priority = 3,description = "Update Environment", groups = { "RegressionTests" })
	public void updateEnvironment() {
		APIListener.test1.log(Status.INFO, "Update Environment"); 
		environmentPage.updateEnvironment("createEnvironmentDevJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
	}
	
	@Test(priority = 4,description = "Delete Environment", groups = { "RegressionTests" })
	public void deleteEnvironment() {
		APIListener.test1.log(Status.INFO, "Delete Environment"); 
		environmentPage.deleteEnvironment(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

