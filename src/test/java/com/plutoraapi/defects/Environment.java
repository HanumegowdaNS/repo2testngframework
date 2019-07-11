package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentPage;

@SuppressWarnings("unused") 
public class Environment  {
	
	EnvironmentPage environmentPage = new EnvironmentPage();
	 

 @Test(description = "Creating an environment using the API, the isSharedEnvironment value is always ignored", groups = { "RegressionTests" },priority = 1)
	public void createEnvironment4268_1(){
		APIListener.addLogger( "Create Environment for isSharedEnvironment value is true"); 
		environmentPage.createEnvironment("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id");
		environmentPage.setDataToProperty("isSharedEnvironment","isSharedEnvironment1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isSharedEnvironment1"));
		environmentPage.verifyEnvironment(PlutoraAPIConfiguration.testData);
		environmentPage.verifyResponseValue("isSharedEnvironment",PlutoraAPIConfiguration.testData,"isSharedEnvironment1");
		environmentPage.deleteEnvironment(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment for isSharedEnvironment value true is successful! "); 
	}

	@Test(description = "[API] POST for /environments does not have a validation for \"usageWorkItemId\"", groups = { "RegressionTests" },priority = 2)
	public void createEnvironment4515usageWorkItemId_2(){
		APIListener.addLogger( "[API] POST for /environments does not have a validation for \"usageWorkItemId\""); 
		environmentPage.createEnvironment("createEnvironment4515Json", PlutoraAPIConfiguration.testData);
		environmentPage.verifyResponseValidationWithMessage(PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Environment4515ValidationMessage"));
		environmentPage.createEnvironment("createEnvironment4515Json", PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Environment4515DeletedWorkId"));
		environmentPage.verifyResponseValidationWithMessage(PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Environment4515DeletedWorkIdMessage"));
		environmentPage.deleteEnvironment(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] POST for /environments does not have a validation for \"usageWorkItemId\" is successful! ");
	}

	@Test(description = "Creating an environment using the API, the isSharedEnvironment value is always ignored", groups = { "RegressionTests" },priority = 3 )
	public void deleteEnvironment(){
		APIListener.addLogger( "Creating an Environment"); 
		environmentPage.createEnvironment("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		 //****************Verify Status Code******************//*
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id");
		environmentPage.verifyEnvironment(PlutoraAPIConfiguration.testData);
		environmentPage.deleteEnvironment(PlutoraAPIConfiguration.testData);
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment has been deleted successfully! ");
	}
	


	
}

