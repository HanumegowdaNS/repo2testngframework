package com.plutoraapi.defects;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;

public class Changes  {
	
	ChangesPage changesPage = new ChangesPage();
	
/*	
	@Test(description = "CR4399 - API - implement new request GET changes/{id}/linkedItems", groups = { "RegressionTests" },priority = 1)
	public void changes4406_R8103PD4481GetLinkedItems(){
		APIListener.addLogger( "API - implement new request GET changes/{id}/linkedItems"); 
		changesPage.verifyChanges(PlutoraAPIConfiguration.testData,"Changes4406Url");
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//*
		changesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Changes4406ParameterNotEmpty"));
		APIListener.addLogger( "API - implement new request GET changes/{id}/linkedItems is successful! "); 
	}
	*/
	@Test(description = "API - unable to update Change Stakeholder - PUT changes/{id}/stakeholders/{id} returns 400 error", groups = { "RegressionTests" },priority = 2)
	public void changes4507StakeholdersUpdate(){
		APIListener.addLogger( "API - unable to update Change Stakeholder - PUT changes/{id}/stakeholders/{id} returns 400 error"); 
		changesPage.createChanges("createChanges4507stakeholderJson",PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//*
		APIListener.addLogger( "Plutora UI -> create Change with one Stakeholder is successful! "); 
		changesPage.setDataToProperty("id");
		changesPage.setDataToProperty("stakeholders.userId[0]","stakeholderId");
		changesPage.getChangesStakeholders(PlutoraAPIConfiguration.testData,"id");
		changesPage.verifyResponseValue("userId[0]",PlutoraAPIConfiguration.testData,"stakeholderId");
		APIListener.addLogger( "Plutora API -> GET changes/{id}/stakeholders is successful! ");
		//udate change
		changesPage.updateStakeholdersChanges("update4507stakeholderJson",PlutoraAPIConfiguration.testData,"id","stakeholderId");
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData,"id");
		APIListener.addLogger( "Plutora API -> PUT changes/{id}/stakeholders/{id} is successful! ");
	}
	
	@Test(description = "API - Currency Custom Field Not Getting Updated After Sending PUT API Request", groups = { "RegressionTests" },priority = 3)
	public void changes4307CurrencyCustomFieldUpdate(){
		APIListener.addLogger( "API - Currency Custom Field Not Getting Updated After Sending PUT API Request"); 
		changesPage.createChanges("createChanges4507stakeholderJson",PlutoraAPIConfiguration.testData);
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id");
		changesPage.updateChangeCurrency("updateChanges4307Json",PlutoraAPIConfiguration.testData,"id");
		//****************Verify Status Code******************//*
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData,"id");
		APIListener.addLogger( "API - Currency Custom Field Not Getting Updated After Sending PUT API Request is successful! ");
	}
	 
	@Test(description = "[API]  - GET/POST/PUT Changes request should maintain new attribute \"AssignedTo\"", groups = { "RegressionTests" },priority = 4)
	public void changes_AssignedToFieldCheck(){
		APIListener.addLogger( "[API] - Creating TECRs"); 
		changesPage.createChanges("createChanges4265Json",PlutoraAPIConfiguration.testData);
	 //****************Verify Status Code******************//*
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	  //****************Verify Parameter Fields******************//*
		changesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributesForChange"));
		changesPage.setDataToProperty("id");
		changesPage.setDataToProperty("assignedTo");
		changesPage.verifyChanges(PlutoraAPIConfiguration.testData);
	   //****************Verify Parameter values******************//*
		changesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesAssignedToParameter"),PlutoraAPIConfiguration.testData);
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData,"id");
		APIListener.addLogger( "[API]  - GET/POST/PUT Changes request should maintain new attribute \\\"AssignedTo\\\"\" is successfull "); 
	}
	
	
/*	@Test(description = "CR4532 - API - implement GET changes/{id}/linkedChanges and PUT changes/{id}/linkedChanges", groups = { "RegressionTests" },priority = 5)
	public void changes_linkedChangesCheck(){
		APIListener.addLogger( "CR4532 - API - implement GET changes/{id}/linkedChanges and PUT changes/{id}/linkedChanges"); 
		//create 4 changes
		changesPage.createChanges("createChangesJson",PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id","Change_id");
		
		changesPage.createChanges("createChangesJson",PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id","Change_id_forChild");
		
		changesPage.createChanges("createChangesJson",PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id","Change_id_forParent");
		
		changesPage.createChanges("createChangesJson",PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id","Change_id_forRelated");
		
		changesPage.addLinkedChangesToChange("addLinkedChangesJson", PlutoraAPIConfiguration.testData, "Change_id", "Change_id_forChild", "Change_id_forParent", "Change_id_forRelated");
		
	}
	*/
	
}

