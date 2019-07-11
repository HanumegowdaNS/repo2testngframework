package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentGroupsPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.SystemsPage;
import com.plutoraapi.pagerepo.TECRPage;

public class Connectivity  {
	
	EnvironmentPage environmentPage = new EnvironmentPage();
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	SystemsPage systemsPage =new SystemsPage();

	@Test(description = "API - POST connectivities returns error though entity is successfully created", groups = { "RegressionTests" }, priority = 0)
	public void createTECR4342_R8103D4476OutDirectionConnectivity_1(){ 
		APIListener.addLogger( "[API] - Creating Connectivity"); 
		//create system
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
		APIListener.addLogger( "System has been created successfully! ");
		//create environment 1
		environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment has been created successfully! ");
		environmentPage.setDataToProperty("id", "Environment_ID1");
		//create environment 2
		environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment has been created successfully! ");
		environmentPage.setDataToProperty("id", "Environment_ID2");
		// create environment groups
		environmentGroupsPage.createEnvironmentGroupWithMultipleEnvironment("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData, "Environment_ID1,Environment_ID2");
		environmentGroupsPage.setDataToProperty("id", "EnvGroup_Id");
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment group has been created successfully! ");
		// create connectivity
		environmentPage.createConnectivityWithSourceAndTarget("createConnectivityJson", PlutoraAPIConfiguration.testData, "EnvGroup_Id", "Environment_ID1", "Environment_ID2","Out");
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Connectivity has been created successfully! ");
		/****************Verify Parameter Fields******************/
		environmentPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ConnectivityParameterNotEmpty"));
		environmentPage.setDataToProperty("id");
		environmentPage.setDataToProperty("environmentGroupId");
		environmentPage.setDataToProperty("direction");
		environmentPage.verifyConnectivity(PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		environmentPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ConnectivityParameterValues"),PlutoraAPIConfiguration.testData);
		environmentPage.deleteConnectivity(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "POST connectivities returns 201 status code though entity created for 'Out' direction is successful! "); 
	}
	
	@Test(description = "API - POST connectivities returns error though entity is successfully created", groups = { "RegressionTests" }, priority = 1)
	public void createTECR4342_R8103PD4476InAndOutDirectionConnectivity_2(){
		APIListener.addLogger( "[API] - Creating Connectivity"); 
		environmentPage.createConnectivityWithSourceAndTarget("createConnectivityJson", PlutoraAPIConfiguration.testData, "EnvGroup_Id", "Environment_ID1", "Environment_ID2","InAndOut");
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Connectivity has been created successfully! ");
		environmentPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ConnectivityParameterNotEmpty"));
		environmentPage.setDataToProperty("id");
		environmentPage.setDataToProperty("environmentGroupId");
		environmentPage.setDataToProperty("direction");
		environmentPage.verifyConnectivity(PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		environmentPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ConnectivityParameterValues"),PlutoraAPIConfiguration.testData);
		environmentPage.deleteConnectivity(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "POST connectivities returns 201 status code though entity created for 'InAndOut' direction is successful! "); 
	}

}

