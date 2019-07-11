package com.plutoraapi.defects;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.TEBRPage;
import com.plutoraapi.pagerepo.TECRPage;

public class Schema  {
	
	ChangesPage changesPage = new ChangesPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	ReleasesPage releasesPage = new ReleasesPage();
	
	@Test(description = "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value", groups = { "RegressionTests" },priority = 1)
	public void changes_R8112PD4507Schema(){
		APIListener.addLogger( "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value"); 
		changesPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaChangeUrl");
		//****************Verify Status Code******************//
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		changesPage.verifyTextData("SchemaChangeJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value is successful! "); 
	}
	
	@Test(description = "CR4397 - API - 05 - Get schema/additionalInformation", groups = { "RegressionTests" },priority = 2)
	public void AdditionalInformation_R8112PD4515Schema(){
		APIListener.addLogger( "API - 05 - Get schema/additionalInformation"); 
		changesPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaAdditionalInformationUrl");
		//****************Verify Status Code******************//
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		changesPage.verifyTextData("SchemaAdditionalInformationJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - 05 - Get schema/additionalInformation is successful! "); 
	}
	
	@Test(description = "CR4397 - API - 05 - GET schema/additionalInformationList", groups = { "RegressionTests" },priority = 3)
	public void AdditionalInformationList_R8112PD451chema(){
		APIListener.addLogger( "API - 05 - Get schema/additionalInformation"); 
		changesPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaAdditionalInformationListUrl");
		//****************Verify Status Code******************//
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		changesPage.verifyTextData("SchemaAdditionalInformationListJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - 05 - Get schema/additionalInformationList is successful! "); 
	}
	
	@Test(description = "CR4397 - API - 04 - Get schema/tecrs", groups = { "RegressionTests" },priority = 5)
	public void tecr_R8112PD4513Schema(){
		APIListener.addLogger( "API - 04 - Get schema/tecrs"); 
		tecrPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaTECRUrl");
		//****************Verify Status Code******************//
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		tecrPage.verifyTextData("SchemaTECRJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - 04 - Get schema/tecrs is successful! "); 
	}
	
	@Test(description = "CR4397 - API - 03 - Get schema/tebrs", groups = { "RegressionTests" },priority = 8)
	public void tebr_R8112PD4514Schema(){
		APIListener.addLogger( "API - 03 - Get schema/tebrs"); 
		tebrPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaTEBRUrl");
		//****************Verify Status Code******************//
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		tebrPage.verifyTextData("SchemaTEBRJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - 03 - Get schema/tebrs is successful! "); 
	}
	
	@Test(description = "CR4397 - API - 02 - Get schema/releases", groups = { "RegressionTests" },priority = 11)
	public void releases_R8112PD4512Schema(){
		APIListener.addLogger( "API - 02 - Get schema/releases"); 
		releasesPage.verifySchemaData(PlutoraAPIConfiguration.testData,"SchemaReleaseUrl");
		//****************Verify Status Code******************//
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter Fields******************//
		releasesPage.verifyTextData("SchemaReleaseJson",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - 02 - Get schema/releases is successful! "); 
	}
	
	
}

