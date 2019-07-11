package com.plutoraapi.defects;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.SystemsPage;

public class Lookupfields  {

	ChangesPage changesPage = new ChangesPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();

	//change
	@Test(description = "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data", groups = { "RegressionTests" },priority = 1)
	public void changes_4455CustomField_1() {
		APIListener.addLogger( "Precondiation: Before creating Change, change have atlease one additional information field."); 
		APIListener.addLogger( "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data"); 
		changesPage.createChanges("createChanges4507stakeholderJson", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id");
		changesPage.getAdditionalInformation(PlutoraAPIConfiguration.testData, "ChangesUrl","AdditionalInformationUrl");
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.verifyLookupfieldsData(PlutoraAPIConfiguration.testData,"ChangeCustomFieldUrl");
		APIListener.addLogger( "API - GET lookupFields CustomField requests return no data for change is successful! "); 
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData);
	}
	
	//environment
	@Test(description = "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data", groups = { "RegressionTests" },priority = 2)
	public void environment_4455CustomField_2(){
		APIListener.addLogger( "Precondiation: Before creating environment, environment have atlease one additional information field."); 
		APIListener.addLogger( "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data"); 
		environmentPage.createEnvironment("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id");
		environmentPage.getAdditionalInformation(PlutoraAPIConfiguration.testData, "EnvironmentUrl","AdditionalInformationUrl");
		environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		environmentPage.verifyLookupfieldsData(PlutoraAPIConfiguration.testData,"EnvironmentCustomFieldUrl");
		APIListener.addLogger( "API - GET lookupFields CustomField requests return no data for environment is successful! "); 
		environmentPage.deleteEnvironment(PlutoraAPIConfiguration.testData);
	}

	//System 
	@Test(description = "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data", groups = { "RegressionTests" },priority = 3)
	public void system_4455CustomField_3(){
		APIListener.addLogger( "Precondiation: Before creating system, system have atlease one additional information field."); 
		APIListener.addLogger( "API - GET lookupFields CustomField and CustomFieldTab and CustomFieldGroup requests return no data"); 
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id");
		systemsPage.getAdditionalInformation(PlutoraAPIConfiguration.testData, "SystemsUrl","AdditionalInformationUrl");
		systemsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		systemsPage.verifyLookupfieldsData(PlutoraAPIConfiguration.testData,"SystemCustomFieldUrl");
		APIListener.addLogger( "API - GET lookupFields CustomField requests return no data for system is successful! "); 
		systemsPage.deleteSystems(PlutoraAPIConfiguration.testData);	
	}












}

