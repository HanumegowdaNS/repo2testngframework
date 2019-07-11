package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TECRPage;

public class TECR  {

	TECRPage tecrPage = new TECRPage();


	@Test(description = "[API] - Incorrect Label Of TECR Variable - should be crStatus instead of status", groups = { "RegressionTests" },priority = 1)
	public void TECR4270IncorrectLabel(){
		APIListener.addLogger( "[API] - Creating TECRs"); 
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
	 /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	  /****************Verify Parameter Fields******************/
		tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		tecrPage.setDataToProperty("id");
		tecrPage.setDataToProperty("crStatusID");
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData);
	   /****************Verify Parameter values******************/
		tecrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameter4270Values"),PlutoraAPIConfiguration.testData);
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Incorrect Label Of TECR Variable - should be crStatus instead of status is successful! "); 
	}

	@Test(description = "PUT - TECRs/{ID} Overwrite AssignTo field Needs To Be Required Field to Not Overwrite AssignedTo UI.", groups = { "RegressionTests" },priority = 2)
	public void TECR4341UpdatesUserId(){
		//Create UserID with null value for POST TECRs
		APIListener.addLogger( "[API] - Creating TECRs with userID Null value for POST TECRs"); 
		tecrPage.createTECRWithUserIdNull("createTECRJson", PlutoraAPIConfiguration.testData,"","TECRUrl");
	    /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "POST TECRs Overwrite AssignTo field Needs To Be Required Field to Not Overwrite AssignedTo UI is successful! ");

		//Create UserID with null value for POST TECRs/bulk
		APIListener.addLogger( "[API] - Creating TECRs with userID Null value for POST TECRs/bulk"); 
		tecrPage.createTECRWithUserIdNull("createTECR4341Json", PlutoraAPIConfiguration.testData,"","TECRBulkUrl");
	     /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "POST TECRs/bulk Overwrite AssignTo field Needs To Be Required Field to Not Overwrite AssignedTo UI is successful! ");

		//Update UserId for PUT TECRs/{id}
		APIListener.addLogger( "[API] - Update TECRs with userId Null value for PUT - TECRs/{ID}"); 
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
	      /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	       /****************Verify Parameter Fields******************/
		tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		tecrPage.setDataToProperty("id");
		tecrPage.setDataToProperty("userID");
		tecrPage.updateTECRWithUserIdNull("createTECRJson", PlutoraAPIConfiguration.testData, "");
		tecrPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "PUT - TECRs/{ID} Overwrite AssignTo field Needs To Be Required Field to Not Overwrite AssignedTo UI is successful! "); 
	}

	@Test(description = "Kaiser - Get https://usapi.plutora.com/TECRs/ Truncation of the Description Field - bug state", groups = { "RegressionTests" },priority = 3)
	public void TECRNSPD0040_4422_R8103PD4478LongDescription(){

		APIListener.addLogger( "[API] - Creating TECR with Long Description Test Data"); 
		tecrPage.createTECRLongDescription("createTECRJson", PlutoraAPIConfiguration.testData);
	        /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields*****************
		tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNotEmpty"));
		tecrPage.setDataToProperty("id");
		tecrPage.setDataToProperty("description");
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values*****************
		tecrPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterNSPD0040Values"),PlutoraAPIConfiguration.testData);
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Truncation of the Description Field Verification is successful! "); 

	}

	@Test(description = "CR4399 - API - implement new request GET tecrs/{id}/linkedChanges", groups = { "RegressionTests" },priority = 4)
	public void TECR4407_R8103PD4480GetTECRsLinkedChanges(){
		//Create UserID with null value for POST TECRs
		APIListener.addLogger( "API - implement new request GET tecrs/{id}/linkedChanges"); 
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData,"TECR4407Url");
	         /****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	          /****************Verify Parameter Fields******************/
		tecrPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4407ParameterNotEmpty"));
		APIListener.addLogger( "API - implement new request GET tecrs/{id}/linkedChanges is successful! "); 
	}

	@Test(description = "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses", groups = { "RegressionTests" },priority = 4)
	public void TECR4416_R8103PD4474RemoveTimezonefields(){
		APIListener.addLogger( "[API] - Creating TECRs"); 
		//GET TECRs
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter Fields******************/
		tecrPage.verifyKeyIsEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4416EmptyParameter"),"[0]");
		APIListener.addLogger( "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses for POST TECRs is successful! "); 
		//POST TECRs
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter Fields******************/
		tecrPage.verifyKeyIsEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4416EmptyParameter"));
		tecrPage.setDataToProperty("id");
		APIListener.addLogger( "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses for POST TECRs is successful! "); 
		//GET/{id} TECRs 
		tecrPage.verifyTECR(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter Fields******************/
		tecrPage.verifyKeyIsEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4416EmptyParameter"));
		APIListener.addLogger( "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses for GET{id} TECRs is successful! "); 
		//PUT TECRs
		tecrPage.updateTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter Fields******************/
		tecrPage.verifyKeyIsEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4416EmptyParameter"));
		APIListener.addLogger( "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses for PUT TECRs is successful! ");
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		//POST TECRs/bulk
		tecrPage.createTECRBulk("createTECRJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter Fields******************/
		tecrPage.verifyKeyIsEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECR4416EmptyParameter"),"[0]");
		tecrPage.setDataToProperty("id[0]");
		APIListener.addLogger( "EBR/TECR Dates Impact - remove parameters timeZoneId and timeZoneOffset from TECR requests and responses for POST TECRs/bulk is successful! "); 
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	


}

