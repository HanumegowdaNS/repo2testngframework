package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TEBRPage;

public class TEBR  {
	
	TEBRPage tebrPage = new TEBRPage();

	@Test(description = "Create TEBR", groups = { "RegressionTests" })
	public void createTEBR(){
		APIListener.test1.log(Status.INFO, "Create TEBR"); 
		tebrPage.createTEBR("createTEBRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterNotEmpty"));
		/****************Set Identifier******************/
		tebrPage.setDataToProperty("id");
	}
	
	@Test(description = "Verify TEBR", groups = { "RegressionTests" },dependsOnMethods="createTEBR")
	public void verifyTEBR() {
		APIListener.test1.log(Status.INFO, "Verify TEBR"); 
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		//tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterNotEmpty"));
		
		tebrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update TEBR", groups = { "RegressionTests" },dependsOnMethods="verifyTEBR")
	public void updateTEBR() {
		APIListener.test1.log(Status.INFO, "Update TECR"); 
		tebrPage.updateTEBR("createTEBRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		APIListener.test1.log(Status.INFO, "Verify Response after Updating Release"); 
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData);
		//tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterNotEmpty"));
		
		tebrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete TEBR", groups = {"RegressionTests"},dependsOnMethods="updateTEBR")
	public void deleteTEBR() {
		APIListener.test1.log(Status.INFO, "Delete TEBR"); 
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

