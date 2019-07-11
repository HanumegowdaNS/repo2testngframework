package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;

public class Releases  {
	
	ReleasesPage releasesPage = new ReleasesPage();

	/*@Test(description = "Create Access Token", groups = { "RegressionTests" })
	public void createAccessToken() {
		*//****************Authorization************************//*
		APIListener.test1.log(Status.INFO, "Create access token"); 
		*//****************Verify Status Code******************//*
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		*//****************Verify Parameter values******************//*
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TokenParameter"));
		releasesPage.verifyResponseValue("token_type",PlutoraAPIConfiguration.testData);
		*//****************Set Parameter
		 * @throws InterruptedException **************************//*
		releasesPage.setDataToProperty("access_token;refresh_token");
	}*/
	@Test(description = "Create Release", groups = { "RegressionTests" })
	public void createRelease() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create Release"); 
		releasesPage.createRelease("createReleaseJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameterNotEmpty"));
		
		releasesPage.verifyResponseValue("name;identifier;plutoraReleaseType",PlutoraAPIConfiguration.testData);
		/****************Set Parameter******************/
		releasesPage.setDataToProperty("id");
	}
	
	@Test(description = "Verify Release", groups = { "RegressionTests" },dependsOnMethods="createRelease")
	public void verifyRelease() {
		APIListener.test1.log(Status.INFO, "Verify Release"); 
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameterNotEmpty"));
		
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update Release", groups = { "RegressionTests" },dependsOnMethods="verifyRelease")
	public void updateRelease() {
		APIListener.test1.log(Status.INFO, "Update Release"); 
		releasesPage.updateRelease("createReleaseJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		releasesPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		APIListener.test1.log(Status.INFO, "Verify Response after Updating Release"); 
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameterNotEmpty"));
		
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameterValues"),PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete Release", groups = { "RegressionTests" },dependsOnMethods="updateRelease")
	public void deleteRelease() {
		APIListener.test1.log(Status.INFO, "Delete Release"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

