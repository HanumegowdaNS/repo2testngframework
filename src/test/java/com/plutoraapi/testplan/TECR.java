package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TECRPage;

public class TECR  {
	
	TECRPage tecrPage = new TECRPage();

	@Test(description = "Create TECR", groups = { "RegressionTests" })
	public void createTECR(){
		APIListener.test1.log(Status.INFO, "Create TECR"); 
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		/****************Set Identifier******************/
		tecrPage.setDataToProperty("id");
	}
	
	@Test(description = "Verify TECR", groups = { "RegressionTests" },dependsOnMethods="createTECR")
	public void verifyTECR() {
		APIListener.test1.log(Status.INFO, "Verify TECR"); 
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		//tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		
		tecrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update TECR", groups = { "RegressionTests" },dependsOnMethods="verifyTECR")
	public void updateTECR() {
		APIListener.test1.log(Status.INFO, "Update TECR"); 
		tecrPage.updateTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);//Changed the status code to 201 from 204
		/****************Verify Parameter values******************/
		APIListener.test1.log(Status.INFO, "Verify Response after Updating Release"); 
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData);
		//tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		
		tecrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete TECR", groups = { "RegressionTests" },dependsOnMethods="updateTECR")
	public void deleteTECR() {
		APIListener.test1.log(Status.INFO, "Delete TECR"); 
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

