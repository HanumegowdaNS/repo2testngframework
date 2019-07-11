package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.SystemsPage;

public class Systems  {
	
	SystemsPage systemsPage = new SystemsPage();
	String systemBulkData = null;
	String data,data1,data2,message,message2,message3 = null;
	

	@Test(description = "[API] - API DELETE systems/{id} fails to remove from database", groups = { "RegressionTests" }, priority=1)
	public void createSystems4320DeleteSystem_1(){
		APIListener.addLogger( "[API] - API DELETE systems/{id} fails to remove from database"); 
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id");
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData);
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		systemsPage.verifySystems(PlutoraAPIConfiguration.testData);
		systemsPage.verifyStatusCode("NotFound_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - API DELETE systems/{id} fails to remove from database is successful! "); 
	}
	
	@Test(description = "API - create a response custom header to return Company name which the User who sent the request belongs to", groups = { "RegressionTests" }, priority=2)
	public void createSystems4428_R8103PD4471ResponseHeader_2(){
		systemsPage.verifyResponseHeader(PlutoraAPIConfiguration.testData,"system4428HeaderName");
		APIListener.addLogger( "[API] - create a response custom header to return Company name which the User who sent the request belongs to is successful! "); 
	}
	
	@Test(description = "API - Alias field is absent in Systems requests", groups = { "RegressionTests" }, priority=3)
	public void createSystems4357AliasField_3(){
		APIListener.addLogger( "API - Alias field is absent in Systems requests"); 
		String name = PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "name");
		systemsPage.createSystemWithAlias("createSystemAliasJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id");
		systemsPage.setDataToProperty("name","systemA");
		systemsPage.setDataToProperty("systemAlias[0].name","aliasA");
		systemsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		systemBulkData= systemsPage.createSystemBulkWithAlias("createSystemBulkAliasJson", PlutoraAPIConfiguration.testData,"aliasA");
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		data = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "aliasA");
		message = "Duplicate System Alias Name "+data+". This System has not been created";
		systemsPage.verifyResponseValidationWithMessage(PlutoraAPIConfiguration.testData, message);
		systemsPage.updateSystemBulkWithAlias(systemBulkData, PlutoraAPIConfiguration.testData,name);
		data1 = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "systemB");
		data2 = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "aliasB");
		message2 = "Duplicate System Alias Name "+data1+". This System has not been created";
		message3 = "Duplicate System Name of "+data2+". This System has not been created";
		systemsPage.verifyResponseValidationWithMessage(PlutoraAPIConfiguration.testData, message2);
		systemsPage.verifyResponseValidationWithMessage(PlutoraAPIConfiguration.testData, message3);
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - Alias field is absent in Systems requests is successful! "); 
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData);
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData,data2);
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "systemC"));
		APIListener.addLogger( "API - Alias field is absent in Systems requests is successful! "); 
	}
	
	

}

