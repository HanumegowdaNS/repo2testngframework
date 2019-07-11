package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.SystemsPage;
import com.plutoraapi.pagerepo.TEBRPage;

public class TEBR  {

	TEBRPage tebrPage = new TEBRPage();
	ReleasesPage releasesPage = new ReleasesPage();
	SystemsPage systemsPage = new SystemsPage();


	@Test(description = "[API] - Creating TEBRs fails to add systems", groups = { "RegressionTests" }, priority = 1)
	public void createTEBR4269_R8103PD4467AddingSystems_1() throws InterruptedException{

		//With Enterprise Release
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with enterprise release"); 
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000); 
		releasesPage.setDataToProperty("id","ReleaseEnterpriseID");
		releasesPage.verifyResponseValue("name;identifier",PlutoraAPIConfiguration.testData);
		//create System
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
		//link system to release
		releasesPage.addSystemToRelease("addSystemToReleaseJson", PlutoraAPIConfiguration.testData,"ReleaseEnterpriseID","System_Id");
		
		tebrPage.createTEBR4269WithRelease("createTEBRs4269Json", PlutoraAPIConfiguration.testData,"ReleaseEnterpriseID","System_Id");
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRReleasearameter4269NotEmpty"));
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with enterprise release is successful! ");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData,"ReleaseEnterpriseID");
		
		//With Project Release
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with project release"); 
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(3000);
		releasesPage.setDataToProperty("id","ReleaseProjectID");
		releasesPage.verifyResponseValue("name;identifier",PlutoraAPIConfiguration.testData);
		tebrPage.createTEBR4269WithRelease("createTEBRs4269Json", PlutoraAPIConfiguration.testData,"ReleaseProjectID","System_Id");
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRReleasearameter4269NotEmpty"));
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with project release is successful! ");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData,"ReleaseProjectID");

		//With Independent Release
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with independent release"); 
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(3000);
		releasesPage.setDataToProperty("id","ReleaseIndependentID");
		releasesPage.verifyResponseValue("name;identifier",PlutoraAPIConfiguration.testData);
		tebrPage.createTEBR4269WithRelease("createTEBRs4269Json", PlutoraAPIConfiguration.testData,"ReleaseIndependentID","System_Id");
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRReleasearameter4269NotEmpty"));
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems with independent release is successful! ");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData,"ReleaseIndependentID");
		
		//Without Release
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems without release"); 
		tebrPage.createTEBR4269("createTEBRs4269Json", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4269NotEmpty"));
		APIListener.addLogger( "[API] - Creating TEBRs fails to add systems without release is successful! ");

	}

	@Test(description = "API-D-4345 API - POST TEBRs request returns 'number': null in the response", groups = { "RegressionTests" }, priority = 2)
	public void createTEBR4345NumberValidation_2(){
		APIListener.addLogger( "[API] - Creating TEBRs for number not null"); 
		tebrPage.setDataToProperty("id");
		tebrPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4269NumberValue"));
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData);
	 /****************Verify Status Code******************/
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	  /****************Verify Parameter values
	    //@throws InterruptedException ******************/
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4269NumberValue"));
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - POST TEBRs request returns 'number': not null in the response is successful! ");
	}

	//R8103P-D-4330
	@Test(description = "API - TEBRs requests should be updated to maintain Systems Roles", groups = { "RegressionTests" }, priority = 3)
	public void createTEBR4354_R8103PD4330SystemRoles_3() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating TEBRs"); 
		tebrPage.createTEBR4269("createTEBRs4269Json", PlutoraAPIConfiguration.testData);
	   /****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		//Verify POST TEBRs
	    /****************Verify Parameter values******************/
		APIListener.addLogger( "[API] - Verifying TEBRs with Systems Roles for POST TEBRs"); 
		tebrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4345Value"));
		APIListener.addLogger( "API - TEBRs requests should be updated to maintain Systems Roles for POST TEBRs is successful! ");

		//Verify GET TEBRs
		tebrPage.setDataToProperty("id");
		tebrPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4345Value"));
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Verifying TEBRs with Systems Roles for GET TEBRs"); 
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4345Value"),PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - TEBRs requests should be updated to maintain Systems Roles for GET TEBRs is successful! ");

		//Verify PUT TEBRs
		APIListener.addLogger( "[API] - Updating TEBRs with Systems Roles for GET TEBRs"); 
		tebrPage.updateTEBR("createTEBRs4269Json", PlutoraAPIConfiguration.testData);
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		tebrPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4345Value"));
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Verifying TEBRs with Systems Roles for GET TEBRs"); 
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameter4345Value"),PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - TEBRs requests should be updated to maintain Systems Roles for PUT TEBRs is successful! ");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);

		//Verify POST TEBRs/bulk
		tebrPage.createTEBRBulk("createTEBRs4269Json", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Verifying TEBRs with Systems Roles for POST TEBRs Bulk"); 
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - TEBRs requests should be updated to maintain Systems Roles for POST TEBRs Bulk is successful! ");

		//POST releases/{id}/systems
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		
		//Create System
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
				
		releasesPage.createReleaseSystem("createRelease4325SystemJson", PlutoraAPIConfiguration.testData,"System_Id");
		APIListener.addLogger( "[API] - Verifying Release with Systems for POST releases/{id}/systems"); 
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseParameter4352Value"));
		APIListener.addLogger( "API - Rlease requests should be updated to maintain System for POST releases/{id}/systems is successful! ");

		//GET releases/{id}/systems
		releasesPage.verifyReleaseSystem(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Verifying Release with Systems Roles for GET releases/{id}/systems"); 
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseArrayValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseParameter4352Value"),PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - Release requests should be updated to maintain Systems Roles for GET releases/{id}/systems is successful! ");

		//GET releases/{id}/systems/{systemId}
		releasesPage.setDataToProperty("systemId");
		releasesPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseParameter4352Value"));
		releasesPage.verifyReleaseSystemWithSystemId(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Verifying Release with Systems Roles for GET releases/{id}/systems/{systemId}"); 
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseParameter4352Value"));
		releasesPage.verifyResponseArrayData(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseParameter4352Value"),PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - Release requests should be updated to maintain Systems Roles for GET releases/{id}/systems/{systemId} is successful! ");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	
	@Test(description = "CR4370 - API - GET TEBRs/{id}/bookings (similar to releases' one)", groups = { "RegressionTests" },priority = 7)
	public void TEBR4350_R8103PD4484GetBookings() throws InterruptedException{
		APIListener.addLogger( "API - GET TEBRs/{id}/bookings (similar to releases' one)"); 
		tebrPage.verifyTEBR(PlutoraAPIConfiguration.testData, "TEBRs4350BookingUrl");
		//****************Verify Status Code******************//
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		releasesPage.verifyMapResponseNullValue("[0]",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRs4350ParameterEmpty"), PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - GET TEBRs/{id}/bookings (similar to releases' one) is successfully!"); 
	}
	

}

