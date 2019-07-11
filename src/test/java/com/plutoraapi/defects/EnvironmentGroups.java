package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentGroupsPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.SystemsPage;

public class EnvironmentGroups  {
	
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage(); 
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();

/*	@Test(priority = 1,description = "API - Swagger/Postman POST EnvironmentGroups Response 500 although record is added", groups = { "RegressionTests" })
	public void create4339_R8103PD4446EnvironmentGroups_1(){
		APIListener.test1.log(Status.INFO, "Create Environment Groups"); 
		environmentGroupsPage.createEnvironmentGroup("create4339EnvironmentGroupsJson", PlutoraAPIConfiguration.testData);
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		environmentGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4339EnvironmentGroupsValues"));
		//PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"id", environmentGroupsPage.response.path("id").toString());
		environmentGroupsPage.deleteEnvironmentGroup(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "'API - Swagger/Postman POST EnvironmentGroups Response 500 although record is added' is successful! ");
	} 
	
	@Test(priority = 2,description = "API - GET EnvironmentGroups/{id} response body should be fixed", groups = { "RegressionTests" })
	public void environmentGroup_R8112PD4516_2(){
		APIListener.test1.log(Status.INFO, "API - GET EnvironmentGroups/{id} response body should be fixed"); 
		environmentGroupsPage.createEnvironmentGroup("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData);
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		environmentGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4516EnvironmentGroupsValues"));
		environmentGroupsPage.deleteEnvironmentGroup(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - GET EnvironmentGroups/{id} response body should be fixed is successful! ");
	}
	
	@Test(priority = 3,description = "API - GET/PUT/POST EnvironmentGroups requests should maintain all UI fields", groups = { "RegressionTests" })
	public void environmentGroup_APID4486_3() throws ParseException{
		APIListener.test1.log(Status.INFO, "API - GET/PUT/POST EnvironmentGroups requests should maintain all UI fields"); 
		//Post
		environmentGroupsPage.createEnvironmentGroup("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData);
		environmentGroupsPage.setDataToProperty("id");
		//Verify Status Code//
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		environmentGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4516EnvironmentGroupsValues"));
		APIListener.addLogger( "API - POST EnvironmentGroups requests should maintain all UI fields is successful! ");
		//Put
		environmentGroupsPage.updateEnvironmentGroup("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData,"EnvironmentGroup4516Description");
		//Verify Status Code//
		environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		environmentGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4516EnvironmentGroupsValues"));
		APIListener.addLogger( "API - PUT EnvironmentGroups requests should maintain all UI fields is successful! ");
		//GET
		environmentGroupsPage.verifyEnvironmentGroup(PlutoraAPIConfiguration.testData);
		//Verify Status Code//
		environmentGroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		environmentGroupsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4516EnvironmentGroupsValues"));
		APIListener.addLogger( "API - GET EnvironmentGroups{id} requests should maintain all UI fields is successful! ");
		environmentGroupsPage.getEnvironmentGroup(PlutoraAPIConfiguration.testData);
		environmentGroupsPage.verifyGetSetJsonDatas(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "create4516EnvironmentGroupsValues"));
		APIListener.addLogger("API - GET EnvironmentGroups requests should maintain all UI fields is successful! ");
		environmentGroupsPage.deleteEnvironmentGroup(PlutoraAPIConfiguration.testData);
	}
*/
	//ticket API-D-4520
		@Test(priority = 4,description = "API - GET environmentGroups/{id} returns soft-deleted Environments IDs", groups = { "RegressionTests" })
		public void environmentGroup_softDeletedEnv() throws ParseException{
			APIListener.test1.log(Status.INFO, "API - - GET environmentGroups/{id} returns soft-deleted Environments IDs"); 
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToProperty("id","linkedSystemId");
			APIListener.addLogger( "System has been created successfully! ");
			
			//create environment
			environmentPage.createEnvironmentwithSystem("createEnvironment4520Json",PlutoraAPIConfiguration.testData, "linkedSystemId");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToProperty("id", "Environment_ID");
			
			// create environment groups
			environmentGroupsPage.createEnvironmentGroupWithEnv("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData, "Environment_ID");
			environmentGroupsPage.setDataToProperty("id", "EnvGroup_Id");
			environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment group has been created successfully! ");
			
			// get environment group for getting environment  list
			environmentGroupsPage.getEnvironmentGroups( "EnvGroup_Id",PlutoraAPIConfiguration.testData);
			environmentGroupsPage.setDataToProperty("environmentIDs.id","Environment_ID");
			
			String[] arrayString = environmentGroupsPage.addStringToArray(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"Environment_ID"));
			
			//delete the environment  
			environmentPage.deleteEnvironmentFromId(arrayString[0],PlutoraAPIConfiguration.testData);
			environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been deleted successfully! ");
			
			// verify if in get environment group , the deleted env is listed
			environmentGroupsPage.getEnvironmentGroups("EnvGroup_Id",PlutoraAPIConfiguration.testData);
			environmentGroupsPage.verifyResponseArrayEmpty("environmentIDs");
			APIListener.addLogger( "Deleted Environment is not listing in the  GET environmentGroups/{id}! ");
			
		}
			


}

