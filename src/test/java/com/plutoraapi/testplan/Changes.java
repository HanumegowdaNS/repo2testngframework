package com.plutoraapi.testplan;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.EnvironmentPage;

public class Changes  {
	
	ChangesPage changesPage = new ChangesPage();
	
	
	@Test(priority = 1,description = "Create Changes", groups = { "RegressionTests" })
	public void createChanges(){
		APIListener.test1.log(Status.INFO, "Create Changes"); 
		changesPage.createChanges("createChangesJson", PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//
		changesPage.verifyResponseNotEmpty("id;name;changePriorityId;changeStatusId;raisedById;organizationId;changeTypeId;changeDeliveryRiskId;changeThemeId");
		//****************Verify Status Code******************//
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"id", ChangesPage.response.path("id").toString());
	}
	
	@Test(priority = 2,description = "Verify Changes", groups = { "RegressionTests" })
	public void verifyChanges() {
		APIListener.test1.log(Status.INFO, "Verify Changes"); 
		changesPage.verifyChanges(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	
	}
	
	@Test(priority = 3,description = "Update Changes", groups = { "RegressionTests" })
	public void updateChanges() {
		APIListener.test1.log(Status.INFO, "Update Changes"); 
		changesPage.updateChanges("createChangesJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);//changed the status code from 204 to 201

	}
	
	@Test(priority = 4,description = "Delete Changes", groups = { "RegressionTests" })
	public void deleteChanges() {
		APIListener.test1.log(Status.INFO, "Delete Changes"); 
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}


}

