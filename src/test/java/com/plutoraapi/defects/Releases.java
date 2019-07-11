package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.SystemsPage;
import com.plutoraapi.pagerepo.TEBRPage;
import com.plutoraapi.pagerepo.TECRPage;

public class Releases  {

	ReleasesPage releasesPage = new ReleasesPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	SystemsPage systemsPage = new SystemsPage();
	ChangesPage changePage = new ChangesPage();

	/*@Test(description = "[API] - PUT/releases/{releaseID}/phases/{phaseID} and  PUT/releases/{releaseID}/gates/{gateID}", groups = { "RegressionTests" },priority = 1)
	public void release4325EnterpriseRelease_1() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating Enterprise Release"); 
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		//releasesPage.verifyResponseValue("id;name;identifier;plutoraReleaseType",PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Enterprise Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Enterprise Release Gates updated successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}

	@Test(description = "[API] - PUT/releases/{releaseID}/phases/{phaseID} and  PUT/releases/{releaseID}/gates/{gateID}", groups = { "RegressionTests" },priority = 2)
	public void release4325ProjectRelease_2() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating Project Release"); 
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(3000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//releasesPage.verifyResponseValue("id;name;identifier;plutoraReleaseType",PlutoraAPIConfiguration.testData);
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Project Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Project Release Gates updated successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}

	@Test(description = "[API] - PUT/releases/{releaseID}/phases/{phaseID} and  PUT/releases/{releaseID}/gates/{gateID}", groups = { "RegressionTests" },priority = 3)
	public void release4325IndependentRelease_3() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating Independent Release"); 
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(3000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//releasesPage.verifyResponseValue("id;name;identifier;plutoraReleaseType",PlutoraAPIConfiguration.testData);
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Independent Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("startDate","startDate1");
		releasesPage.setDataToProperty("endDate","endDate1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "startDate1"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "endDate1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("startDate;endDate");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4325BeforeValues"));
		APIListener.addLogger( "[API] - Independent Release Gates updated successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}

	@Test(description = "CR4028 - API - implement new request GET releases/{id}/linkedReleases", groups = { "RegressionTests" },priority = 4)
	public void release4403_R8103PD4479LinkedReleases_4() throws InterruptedException{
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedReleases"); 
		Thread.sleep(1000);
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData,"Releases4403Url");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesChild4403ParameterNotEmpty"));
		APIListener.addLogger( "CR4028 - API - implement new request GET releases/{id}/linkedReleases displaying child data is successfully!"); 
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesParent4403ParameterNotEmpty"));
		APIListener.addLogger( "CR4028 - API - implement new request GET releases/{id}/linkedReleases displaying parent data is successfully!"); 
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesReleated4403ParameterNotEmpty"));
		APIListener.addLogger( "CR4028 - API - implement new request GET releases/{id}/linkedReleases displaying relatedto data is successfully!"); 
		//releasesPage.verifyResponseValue("ReleasesChild4403ParameterNotEmpty", PlutoraAPIConfiguration.testData);
		
	}

	@Test(description = "CR4399 - API - implement new request GET releases/{id}/linkedItems", groups = { "RegressionTests" },priority = 5)
	public void release4405_R8103PD4482LinkedItems_5() throws InterruptedException{
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedItems"); 
		//tecrs
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		tecrPage.createTECRWithCustomId("createTECRJson", PlutoraAPIConfiguration.testData,"releaseID");
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id");
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterAttributes"));
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData,"ReleasesLinkedItemsUrl","releaseID");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterAttributess"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParameterAttributes"));
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedItems for tecrs is successfully!"); 
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		
		//Create System
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
		//tebrs
		tebrPage.createTEBR4269WithRelease("createTEBRs4269Json", PlutoraAPIConfiguration.testData,"releaseID","System_Id");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterAttributes"));
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData,"ReleasesLinkedItemsUrl","releaseID");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterAttributess"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParameterAttributes"));
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedItems for tebrs is successfully!"); 
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData,"releaseID");
		//deployment plan
		releasesPage.verifyReleaseLinkedItems(PlutoraAPIConfiguration.testData,"ReleasesLinkedItems4405Url");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotNull(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesLinkedItems4405DPAttributes"));
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedItems for deploymentPlan is successfully!"); 
		releasesPage.verifyResponseNotNull(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesLinkedItems4405MDPAttributes"));
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedItems for master deploymentPlan is successfully!"); 


	} 

	@Test(description = "CR4399 - API - implement new request GET releases/{id}/changes", groups = { "RegressionTests" },priority = 6)
	public void release4404_R8103PD4483LinkedChanges_6() throws InterruptedException{
		APIListener.addLogger( "API - implement new request GET releases/{id}/changes"); 
		Thread.sleep(1000);
		//Create release
		releasesPage.createRelease("createProjectReleaseJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","Release_Id");
		//Create System
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
		//Link system to release
		releasesPage.addSystemToRelease("addSystemToReleaseJson", PlutoraAPIConfiguration.testData,"Release_Id","System_Id");
		//Create change
		changePage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changePage.setDataToProperty("id", "Change_Id");
		//link system to change
	
		changePage.addSystemToChange("addSystemToChangeJson",PlutoraAPIConfiguration.testData,"Change_Id","System_Id");
		releasesPage.getReleaseChange(PlutoraAPIConfiguration.testData,"Release_Id","ReleaseChangesUrl");
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData,"Changes4404Url");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Changes4404ParameterNotEmpty"));
		
		APIListener.addLogger( "API - implement new request GET releases/{id}/changes is successfully!"); 
	}

	@Test(description = "API - adjustment to the response text of DELETE Release Deployment Date request", groups = { "RegressionTests" },priority = 7)
	public void release4446_R8103PD4473deleteDeploymentDates_7() throws InterruptedException{
		APIListener.addLogger( "API - adjustment to the response text of DELETE Release Deployment Date request"); 
		//deploymentPlans
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("systemId","addedSystemId");
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate");
		releasesPage.deleteReleaseDeploymentDate(PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleasesLinkedItems4405MDPAttributes"));
		APIListener.addLogger( "API - adjustment to the response text of DELETE Release Deployment Date request is successfully!"); 
	}

	@Test(description = "API - implement new method DELETE releases/{id}/systems/{systemID}/deploymentDates/{deploymentDateID}", groups = { "RegressionTests" },priority = 8)
	public void release4437_R8103PD4485deleteDeploymentDates_8() throws InterruptedException{
		APIListener.addLogger( "API - adjustment to the response text of DELETE Release Deployment Date request"); 
		//deploymentPlans
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("systemId","addedSystemId");
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate");
		releasesPage.deleteReleaseDeploymentDate(PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - implement new method DELETE releases/{id}/systems/{systemID}/deploymentDates/{deploymentDateID} is successfully!"); 
	}

	@Test(description = "CR3763 - API - implement GET/PUT/POST Releases/{id}/Systems/{systemId}/deploymentDates", groups = { "RegressionTests" },priority = 9)
	public void releaseR8103PD4486deleteDeploymentDates_9() throws InterruptedException{
		APIListener.addLogger( "API - implement GET/PUT/POST Releases/{id}/Systems/{systemId}/deploymentDates"); 
		//deploymentPlans creation for Enterprise Release
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","releaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("systemId","addedSystemId");
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate1");
		releasesPage.setDataToProperty("sortOrder","sortOrder1");
		APIListener.addLogger("1:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "deploymentDate1"));
		APIListener.addLogger("1:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "sortOrder1"));
		//verification points
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Only one Deployment Date can be created via POST at a time is successfully!"); 
		APIListener.addLogger( "\"id\" parameter should be ignored in the request body of POST request is successfully!"); 
		//deploymentStatus set to pending on creation POST
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DeploymentStatus4400Parameter"),PlutoraAPIConfiguration.testData,"DeploymentStatus4400ParameterValues");
		APIListener.addLogger( "When adding new Deployment Date, \"deploymentStatus\" can be set only to \"Pending\". This parameter should be ignored in POST request is successfully!"); 
		//sortOrder value automatic generation
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "SortOrder4400Parameter"),PlutoraAPIConfiguration.testData,"SortOrder4400ParameterValues");
		APIListener.addLogger( "\"sortOrder\" parameter should be ignored in the request body of POST request (value should be automatically generated) is successfully!"); 

		//update start & end date PUT
		releasesPage.updateDeploymentInvalidStartDate("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseValidationMessage(PlutoraAPIConfiguration.testData,"DeploymentDateInvalidResponseMessage");
		APIListener.addLogger( "\"startDate\" cannot be set greater than \"endDate\" for PUT request is successfully!"); 
		//deploymentCompletedDate set automatically PUT
		releasesPage.updateDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentEndorsed4400Status");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DeploymentCompletedDate4400Parameter"));
		APIListener.addLogger( "\"deploymentCompletedDate\" is read only and is set automatically when status is changed to completed is successfully!"); 
		APIListener.addLogger( "\"deploymentCompletedDate\" should be ignored in PUT request is successfully!"); 
		APIListener.addLogger( "Only one Deployment Date can be created via PUT at a time is successfully!"); 
		//deploymnet status for enterprise release reject gives error PUT
		releasesPage.updateDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentRejected4400Status");
		releasesPage.verifyResponseValidationMessage(PlutoraAPIConfiguration.testData,"DeploymentStatusInvalidRejectMessage");
		APIListener.addLogger( "\"Invalid deploymentStatus\" for EnterpriseReleases in PUT requests is successfully!"); 

		//update start & end date POST
		releasesPage.createDeploymentDatesInvalidStartDate("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseValidationMessage(PlutoraAPIConfiguration.testData,"DeploymentDateInvalidResponseMessage");
		APIListener.addLogger( "\"startDate\" cannot be set greater than \"endDate\" for POST request is successfully!"); 
		//deploymentCompletedDate ignored in POST
		releasesPage.createDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentEndorsed4400Status");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate2");
		releasesPage.setDataToProperty("sortOrder","sortOrder2");
		APIListener.addLogger("2:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "deploymentDate2"));
		APIListener.addLogger("2:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "sortOrder2"));
		APIListener.addLogger( "\"deploymentCompletedDate\" should be ignored in POST request is successfully!"); 
		APIListener.addLogger( "Only one Deployment Date can be created via POST at a time is successfully!"); 

		//sortorder verification
		//create deployment 2
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate3");
		releasesPage.setDataToProperty("sortOrder","sortOrder3");
		APIListener.addLogger("3:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "deploymentDate3"));
		APIListener.addLogger("3:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "sortOrder3"));
		//create deployment 3
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","deploymentDate4");
		releasesPage.setDataToProperty("sortOrder","sortOrder4");
		APIListener.addLogger("4:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "deploymentDate4"));
		APIListener.addLogger("4:: "+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "sortOrder4"));
		releasesPage.updateDeploymentDatesWithSortOrder("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentEndorsed4400Status","releaseID", "addedSystemId", "deploymentDate4","2");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyDeploymentDates(PlutoraAPIConfiguration.testData, "releaseID", "addedSystemId");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);

		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "eploymentSortOrder4400ValueParameters"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DeploymentSortOrder4400Parameters"));
		APIListener.addLogger( "After \"sortOrder\" value update in PUT request, all sequential Deployment Dates should get its values updated accordingly is successfully!"); 

		//Project & Independent release reject
		//deploymnet status for Project release reject gives error on PUT - is in development state API-D-4454
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId1");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData, "Independent", "IsProject");
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","projectReleaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData, "projectReleaseID","systemId1");
		releasesPage.setDataToProperty("systemId","addedSystemId1");
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"projectReleaseID", "addedSystemId1");
		releasesPage.setDataToProperty("id","deploymentDate4");
		releasesPage.createDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentRejected4400Status","projectReleaseID", "addedSystemId1");
		releasesPage.updateDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentRejected4400Status","projectReleaseID", "addedSystemId1", "deploymentDate4");
		//releasesPage.verifyResponseValidationMessage(PlutoraAPIConfiguration.testData,"DeploymentStatusInvalidRejectMessage");
		APIListener.addLogger( "\"Invalid deploymentStatus\" for Project Releases in PUT requests is successfully!"); 

		//deploymnet status for Independent release reject gives error on PUT
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId1");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData, "Independent", "NotIsProject");
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","independentReleaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData, "independentReleaseID","systemId1");
		releasesPage.setDataToProperty("systemId","addedSystemId1");
		releasesPage.createDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"independentReleaseID", "addedSystemId1");
		releasesPage.setDataToProperty("id","deploymentDate2");
		releasesPage.createDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentRejected4400Status","independentReleaseID", "addedSystemId1");
		releasesPage.updateDeploymentDatesWithStatus("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentRejected4400Status","independentReleaseID", "addedSystemId1", "deploymentDate2");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "\"Reject deploymentStatus\" for Independent Releases in PUT requests is successfully!"); 

	}

	@Test(description = "CR4028 - API - PUT releases/{id}/linkedReleases", groups = { "RegressionTests" },priority = 10)
	public void releaseR8103PD4492LinkedReleases_10() throws InterruptedException{
		APIListener.addLogger( "API - implement new request GET releases/{id}/linkedReleases"); 
		Thread.sleep(1000);
		//child release
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","childId");
		releasesPage.setDataToProperty("identifier","childIdentifer");
		releasesPage.setDataToProperty("name","childName");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//Parent release
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","parentId");
		releasesPage.setDataToProperty("identifier","parentIdentifier");
		releasesPage.setDataToProperty("name","parentName");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		//Related to release
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","relatedId");
		releasesPage.setDataToProperty("identifier","relatedIdentifier");
		releasesPage.setDataToProperty("name","relatedName");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData,"Releases4403Url");
		releasesPage.updateLinkedReleases("ReleasesReleated4403NameParameters", PlutoraAPIConfiguration.testData,"Releases4403Url");
		Thread.sleep(3000);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

	@Test(description = "API - unable to add release stakeholder via API - POST releases/{id}/stakeholders returns 404 error", groups = { "RegressionTests" },priority = 11)
	public void releaseP81122D0003UpdateStakeholder_11() throws InterruptedException{
		APIListener.addLogger( "API - unable to add release stakeholder via API - POST releases/{id}/stakeholders returns 404 error"); 
		Thread.sleep(1000);
		//Create Enterprise Release
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","Release_Id");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Plutora UI -> create Enterprise Release with one Stakeholder is successful! "); 
		releasesPage.createReleaseStakeholders("createReleaseStakeholder4338Json", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("stakeholders.userId[0]","stakeholderId");
		releasesPage.getReleasesStakeholders(PlutoraAPIConfiguration.testData,"id");
		releasesPage.verifyResponseValue("userId[0]",PlutoraAPIConfiguration.testData,"stakeholderId");
		APIListener.addLogger( "Plutora API -> GET changes/{id}/stakeholders is successful! ");
		//udate change
		releasesPage.updateReleasesStakeholders("update4507stakeholderJson",PlutoraAPIConfiguration.testData,"id","stakeholderId");
		releasesPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Plutora API -> PUT changes/{id}/stakeholders/{id} is successful! ");

	}

	@Test(description = "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Enterprise Release", groups = { "RegressionTests" },priority = 12)
	public void release4512EnterpriseRelease_12() throws InterruptedException{
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Enterprise Release"); 
		//Enterprise
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Plutora_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "[API] - Enterprise Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Enterprise Release is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);

		//Project
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "[API] - Enterprise Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Project Release is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);

		//Independent
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("1:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore1"));
		APIListener.addLogger("2:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "[API] - Enterprise Release Phase updated successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("isIgnore","isIgnore1");
		releasesPage.setDataToProperty("isIgnoreChild","isIgnoreChild1");
		APIListener.addLogger("3:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnore"));
		APIListener.addLogger("4:"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "isIgnoreChild1"));
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.setDataToProperty("isIgnore;isIgnoreChild");
		releasesPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512Values"),PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParameter4512BeforeValues"));
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Independent Release is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	
	@Test(description = "API - PUT releases/{id}/phases/{id} and PUT releases/{id}/gates/{id} should not allow an update of \"workItemNameId\" value", groups = { "RegressionTests" },priority = 13)
	public void release4513EnterpriseRelease_13() throws InterruptedException{
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} and PUT releases/{id}/gates/{id} should not allow an update of \"workItemNameId\" value"); 
		//Enterprise
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id;plutoraReleaseType","Release_Id;Release_Type");
		releasesPage.verifyResponseNotEmpty("id;name;identifier;plutoraReleaseType");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson1", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger("API - PUT releases/{id}/phases/{id} and PUT releases/{id}/gates/{id} should not allow an update of \\\"workItemNameId\\\" value for phase is successfully!"); 
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson1", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger("API - PUT releases/{id}/phases/{id} and PUT releases/{id}/gates/{id} should not allow an update of \\\"workItemNameId\\\" value for gate is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}

	@Test(description = "API - unable to set \"isIgnoreChild\" true via POST/PUT releases/{id}/phases or gates", groups = { "RegressionTests" },priority = 14)
	public void release4510EnterpriseRelease_14() throws InterruptedException{
		APIListener.addLogger( "API - PUT releases/{id}/phases/{id} or PUT releases/{id}/gates/{id} should not allow to set \"isIgnore\": true for Enterprise Release"); 
		
		//Enterprise
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","Release_Id");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		//Get release{id} verification
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		APIListener.addLogger( "[API] - Enterprise Release Phase verification successfully!");
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		//GET release{id} verification
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraEnterpriseIsIgnoreChild");
		APIListener.addLogger( "[API] - Enterprise Release Gate verification successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);

		//Project
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","Release_Id");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		//Get release{id} verification
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		APIListener.addLogger( "[API] - Project Release Phase verification successfully!");
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		//GET release{id} verification
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraProjectIsIgnoreChild");
		APIListener.addLogger( "[API] - Project Release Gate verification successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);

		//Independent
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","Release_Id");
		//Phase verification
		releasesPage.createReleasePhase("createReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","PhaseId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		//Get release{id} verification
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleasePhaseData("updateReleasePhaseJson", PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleasePhaseData(PlutoraAPIConfiguration.testData,"Release_Id","PhaseId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		APIListener.addLogger( "[API] - Independent Release Phase verification successfully!");
		//Gate verification
		releasesPage.createReleaseGates("createReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","GatesId");
		releasesPage.setDataToProperty("isIgnoreChild");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		//GET release{id} verification
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		//PUT release{id} verification
		releasesPage.updateReleaseGatesData("updateReleaseGatesJson", PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleaseGatesData(PlutoraAPIConfiguration.testData,"Release_Id","GatesId");
		releasesPage.verifyResponseValue("isIgnoreChild",PlutoraAPIConfiguration.testData,"plutoraIndependentIsIgnoreChild");
		APIListener.addLogger( "[API] - Independent Release Gate verification successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	*/
	
	@Test(description = "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value", groups = { "RegressionTests" },priority = 15)
	public void releaseAPID4449deleteDeploymentDates_15() throws InterruptedException{
		APIListener.addLogger( "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value"); 
		//deploymentPlans creation
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id","releaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("systemId","addedSystemId");
		releasesPage.createDeploymentDates("createDeploymentDateWithoutDTypeJson", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - POST releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value is successfully!");
		releasesPage.verifyDeploymentDates(PlutoraAPIConfiguration.testData, "releaseID", "addedSystemId");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - GET releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value is successfully!"); 
		//Raised seperate ticket for the below scenario
		releasesPage.setDataToProperty("id[0]","deploymentDate1");
		releasesPage.updateDeploymentDates("createDeploymentDate4446Json", PlutoraAPIConfiguration.testData,"DeploymentEndorsed4400Status");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "API - PUT releases/{id}/systems/{id}/deploymentDates returns error if no Deployment Type value is successfully!"); 

	}
	
}

