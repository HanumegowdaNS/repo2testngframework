package com.plutoraapi.defects;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.TEBRPage;
import com.plutoraapi.pagerepo.TECRPage;

public class Workflows  {
	
	ChangesPage changesPage = new ChangesPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	ReleasesPage releasesPage = new ReleasesPage();
	
	@Test(description = "CR4398 - API - get workflow for Changes - GET workflow/changes/{id}", groups = { "RegressionTests" },priority = 1)
	public void changes_R8112PD4509Workflow_1(){
		APIListener.addLogger( "Precondiation: Changes workflow test data needs to setup in the environment & Enable the Changes Workflow from customization."); 
		APIListener.addLogger( "API - get workflow for Changes - GET workflow/changes/{id}"); 
		changesPage.createChanges("createWorkflowChangeJson", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id");
		changesPage.verifyWorkflowData(PlutoraAPIConfiguration.testData,"WorkflowChangeUrl");
		changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.verifyResponseStaticValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowValue"),PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowData"));
		APIListener.addLogger( "API - get workflow for Changes - GET workflow/changes/{id} is successful! "); 
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData);
	}
	
	@Test(description = "CR4398 - API - get workflow for Releases - GET workflow/release/{id}", groups = { "RegressionTests" },priority = 2)
	public void releases_R8112PD4508Workflow_2(){
		APIListener.addLogger( "Precondiation: Releases workflow test data needs to setup in the environment & Enable the Releases Workflow from customization."); 
		APIListener.addLogger( "API - get workflow for Releases - GET workflow/releases/{id}"); 
		releasesPage.createReleases("createWorkflowReleaseJson", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id");
		releasesPage.verifyWorkflowData(PlutoraAPIConfiguration.testData,"WorkflowReleaseUrl");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseStaticValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowValue"),PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowData"));
		APIListener.addLogger( "CR4398 - API - get workflow for Releases - GET workflow/release/{id} is successful! "); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	
	@Test(description = "CR4398 - API - get workflow for TECRs - GET workflow/tecrs/{id}", groups = { "RegressionTests" },priority = 3)
	public void tecr_R8112PD4511Workflow_3(){
		APIListener.addLogger( "Precondiation: TECR workflow test data needs to setup in the environment & Enable the TECR Workflow from customization."); 
		APIListener.addLogger( "CR4398 - API - get workflow for TECRs - GET workflow/tecrs/{id}"); 
		tecrPage.createTECR("createWorkflowTECRJson", PlutoraAPIConfiguration.testData);
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id");
		tecrPage.verifyWorkflowData(PlutoraAPIConfiguration.testData,"WorkflowTECRUrl");
		tecrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.verifyResponseStaticValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowValue"),PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowData"));
		APIListener.addLogger( "CR4398 - API - get workflow for TECRs - GET workflow/tecrs/{id} is successful! "); 
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
	@Test(description = "CR4398 - API - get workflow for TEBRs - GET workflow/tecrs/{id}", groups = { "RegressionTests" },priority = 4)
	public void tebr_R8112PD4512Workflow_4() {
		APIListener.addLogger( "Precondiation: TEBR workflow test data needs to setup in the environment & Enable the TEBR Workflow from customization."); 
		APIListener.addLogger( "CR4398 - API - get workflow for TEBRs - GET workflow/tecrs/{id}"); 
		tebrPage.createTEBR("createWorkflowTEBRJson", PlutoraAPIConfiguration.testData);
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		tebrPage.verifyWorkflowData(PlutoraAPIConfiguration.testData,"WorkflowTEBRUrl");
		tebrPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.verifyResponseStaticValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowValue"),PlutoraAPIConfiguration.testData, PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ParameterWorkflowData"));
		APIListener.addLogger( "CR4398 - API - get workflow for TEBRs - GET workflow/tecrs/{id} is successful! "); 
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
	}
	
	
	
	
	
	
	
	
}

