package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.SystemsPage;

public class Systems  {
	
	SystemsPage systemsPage = new SystemsPage();

	@Test(description = "Create Systems", groups = { "RegressionTests" })
	public void createSystems(){
		APIListener.test1.log(Status.INFO, "Create Systems"); 
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		systemsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		systemsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SystemsParameterNotEmpty"));
		/****************Set Identifier******************/
		systemsPage.setDataToProperty("id");
	} 
	
	@Test(description = "Verify Systems", groups = { "RegressionTests" },dependsOnMethods="createSystems")
	public void verifySystems() {
		APIListener.test1.log(Status.INFO, "Verify TEBR"); 
		systemsPage.verifySystems(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		systemsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SystemsParameterNotEmpty"));
	
		systemsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SystemsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update Systems", groups = { "RegressionTests" },dependsOnMethods="verifySystems")
	public void updateSystems() {
		APIListener.test1.log(Status.INFO, "Update TECR"); 
		systemsPage.updateSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		systemsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		APIListener.test1.log(Status.INFO, "Verify Response after Updating Release"); 
		systemsPage.verifySystems(PlutoraAPIConfiguration.testData);
		systemsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SystemsParameterNotEmpty"));
		
		systemsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SystemsParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete Systems", groups = {"RegressionTests"},dependsOnMethods="updateSystems")
	public void deleteSystems() {
		APIListener.test1.log(Status.INFO, "Delete Systems"); 
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

