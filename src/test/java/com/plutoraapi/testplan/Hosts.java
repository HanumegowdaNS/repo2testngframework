package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.HostsPage;

public class Hosts  {
	
	HostsPage hostsPage = new HostsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test(description = "Create Hosts", groups = { "RegressionTests" })
	public void createHosts(){
		APIListener.addLogger( "Create Hosts"); 
		environmentPage.createEnvironment("createEnvironmentDevJson", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id","Environment_Id");
		hostsPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData,"Environment_Id");
		/****************Verify Status Code******************/
		hostsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameterNotEmpty"));
		/****************Set Identifier******************/
		hostsPage.setDataToProperty("id");
		
	}
	
	@Test(description = "Verify Hosts", groups = { "RegressionTests" },dependsOnMethods="createHosts")
	public void verifyHosts() {
		APIListener.addLogger( "Verify Hosts"); 
		hostsPage.verifyHosts(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameterNotEmpty"));
		
		hostsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update Hosts", groups = { "RegressionTests" },dependsOnMethods="verifyHosts")
	public void updateHosts() {
		APIListener.addLogger( "Update Hosts"); 
		hostsPage.updateHosts("updateHostsJson", PlutoraAPIConfiguration.testData, "id","Environment_Id");
		/****************Verify Status Code******************/
		hostsPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		APIListener.addLogger( "Verify Response after Updating Release"); 
		hostsPage.verifyHosts(PlutoraAPIConfiguration.testData);
		hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameterNotEmpty"));
		
		hostsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete Hosts", groups = { "RegressionTests" },dependsOnMethods="updateHosts")
	public void deleteHosts() {
		APIListener.addLogger("Delete Hosts"); 
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//*
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

