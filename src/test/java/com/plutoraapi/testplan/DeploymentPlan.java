package com.plutoraapi.testplan;

import java.lang.reflect.Array;
import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.DeploymentPlanPage;
import com.plutoraapi.pagerepo.OrganizationsPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.SystemsPage;
import com.plutoraapi.pagerepo.UsersPage;

public class DeploymentPlan {

	DeploymentPlanPage deploymentPlanPage = new DeploymentPlanPage();
	OrganizationsPage organizationPage = new OrganizationsPage();
	SystemsPage systemsPage = new SystemsPage();
	ReleasesPage releasesPage = new ReleasesPage();
	UsersPage usersPage = new UsersPage();
	String orgId,userId,roleIds,userGroupId;

	@Test(priority = 1,description = "Create DeploymentPlan with only name,description and organization name. Verify mode is set to Draft", groups = { "RegressionTests" })
	public void createChildDP(){
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan- [API]- POST/DeploymentPlan/Create");
		organizationPage.getOrganizations(PlutoraAPIConfiguration.testData);
		List<String> listOfIds = organizationPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		orgId= listOfIds.get(0);
	   	System.out.println(orgId); 
		deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID", "ChildDp_id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmpty"));
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseArrayEmpty("data.SystemIDs");
		deploymentPlanPage.verifyResponseIsNull("data.ReleaseID;data.MasterDeploymentPlanId");
	}
	@Test(priority = 2,description = "Create DeploymentPlan without name or organization name", groups = { "RegressionTests" })
	public void createChildDP1(){
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan- [API]- POST/DeploymentPlan/Create");
		deploymentPlanPage.postDeploymentPlanWithoutOrg("createDPWithoutOrganization", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 3,description = "Create DeploymentPlan with invalid organization id", groups = { "RegressionTests" })
	public void createChildDP2(){
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan- [API]- POST/DeploymentPlan/Create");
		deploymentPlanPage.postDeploymentPlanWithoutOrg("createDPWithInvalidOrganization", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	
	@Test(priority = 4,description = "Create DeploymentPlan with system and Enterprise release", groups = { "RegressionTests" })
	public void createChildDPWithSystemAndRelease() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST/DeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData,"releaseID","systemId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
	}
	@Test(priority = 5,description = "Create DeploymentPlan with release but no systems linked to it-- R9041A-D-4655", groups = { "RegressionTests" })
	public void createChildDP3(){
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan- [API]- POST/DeploymentPlan/Create");
		deploymentPlanPage.postDeploymentPlan("createDPWithReleaseOnly", PlutoraAPIConfiguration.testData,orgId,"releaseID");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		/*deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmpty"));
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseArrayEmpty("data.SystemIDs");
		deploymentPlanPage.verifyResponseIsNull("data.ReleaseID;data.MasterDeploymentPlanId");*/
	}
	@Test(priority = 6,description = "Create DeploymentPlan with system and Project release", groups = { "RegressionTests" })
	public void createChildDPWithPR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST/DeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
	}
	@Test(priority = 7,description = "Create DeploymentPlan with system and Independent release", groups = { "RegressionTests" })
	public void createChildDPWithIR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST/DeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData,"releaseID","systemId");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
	}
	
	@Test(priority = 8,description = "Get DeploymentPlan without system and release", groups = { "RegressionTests" })
	public void getDeploymentPlanWithId_child() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get DeploymentPlan - [API] - GET/DeploymentPlan/Get/{id}");
		deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "ChildDp_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmpty"));
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseArrayEmpty("data.SystemIDs");
		deploymentPlanPage.verifyResponseIsNull("data.ReleaseID;data.MasterDeploymentPlanId");
	}
	@Test(priority = 9,description = "Get DeploymentPlan with system and release", groups = { "RegressionTests" })
	public void getDeploymentPlanWithId() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get DeploymentPlan - [API] - GET/DeploymentPlan/Get/{id}");
		deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "DP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		List<String> listOfIds = deploymentPlanPage.getListOfData(PlutoraAPIConfiguration.testData, "data.PlanCustomFieldPrototype.Name");
	   	System.out.println(listOfIds);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		//deploymentPlanPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParameterValues"),PlutoraAPIConfiguration.testData);
	}
	String invalidId="432532799";
	@Test(priority = 10,description = "Get DeploymentPlan with invalid DP id", groups = { "RegressionTests" })
	public void getDeploymentPlanWithInvalidId() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get DeploymentPlan - [API] - GET/DeploymentPlan/Get/{id}");
		deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, invalidId);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}

	@Test(priority = 11,description = "Update DeploymentPlan with system and release- ER", groups = { "RegressionTests" })
	public void updateChildDPWithSystemAndRelease() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Update DeploymentPlan - [API]- PUT /DeploymentPlan/Update/{id}");
		deploymentPlanPage.updateDeploymentPlanWithSystem("updateDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "DP_Id", "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
	}
	@Test(priority = 12,description = "Delete DeploymentPlan with system and release", groups = { "RegressionTests" })
	public void deleteDeploymentPlan() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Delete DeploymentPlan - [API] - DELETE/DeploymentPlan/Delete/{id}");
		deploymentPlanPage.deleteDeploymentPlan( PlutoraAPIConfiguration.testData, "DP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 13,description = "Get Master Deployment Plans", groups = { "RegressionTests" })
	public void getMasterDeploymentPlans() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get Master Deployment Plans - [API] - GET/DeploymentPlan/GetMasterDeploymentPlans");
		deploymentPlanPage.getMasterDeploymentPlan(PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}	
	
	@Test(priority = 14,description = "Get Deployment Plan base", groups = { "RegressionTests" })
	public void getDeploymentPlans() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get Deployment Plan base - [API]- GET/DeploymentPlanBase/GetDeployments");
		deploymentPlanPage.getDeploymentPlans(PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	
	@Test(priority = 15,description = "Add stakeholders to Deployment Plan", groups = { "RegressionTests" })
	public void addStakeholdertoDeploymentPlan() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get Deployment Plan base - [API]- POST/DeploymentPlanBase/BulkUpdateStakeholders");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id_Stk");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		List<String> listOfIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userId= listOfIds.get(0);
		System.out.println(userId); 
	   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id_Stk", userId, "rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	//##### update stakeholder ####
	   	deploymentPlanPage.updateBulkStakeholderstoDPAcc("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id_Stk", userId,"rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	//#### add user group to the DP####//
	   	usersPage.verifyUserGroups(PlutoraAPIConfiguration.testData);
	   	List<String> listOfGroupIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userGroupId= listOfGroupIds.get(0);
		System.out.println(userGroupId); 
	   	deploymentPlanPage.postBulkStakeholdersGrouptoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id_Stk", userGroupId,"rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);  	  	
	}
	@Test(priority = 16,description = "Update stakeholders to Deployment Plan", groups = { "RegressionTests" })
	public void updateStakeholdertoDeploymentPlan() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get Deployment Plan base - [API]- POST/DeploymentPlanBase/BulkUpdateStakeholders");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		List<String> listOfIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userId= listOfIds.get(0);
		System.out.println(userId); 
		//usersPage.getListOfListData(PlutoraAPIConfiguration.testData, "resultSet.roles.id");
		//String roleIds = usersPage.getListOfListData(PlutoraAPIConfiguration.testData, "resultSet.roles.id");
		//roleIds=listOfRoleIds.get(0);
	    // 	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, userId, roleIds, "DP_Id");
	   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

	
	@Test(priority = 17,description = "Create activity in not started mode for  Deployment Plan", groups = { "RegressionTests" })
	public void createDeploymentPlanActivityForER() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create activity for Deployment Plan ER - [API]- POST/DeploymentPlanActivities/BatchCreate");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id_Act");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		List<String> listOfIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userId= listOfIds.get(0);
		System.out.println(userId); 
		deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id_Act","systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.Data[0].ID", "activityId");
		//deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "activitiyParameters"));
		deploymentPlanPage.verifyResponseValue("data.Data[0].Status",PlutoraAPIConfiguration.testData,"NotStarted");
		/*deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id_Act","systemId", "releaseID", orgId, 2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id_Act","systemId", "releaseID", orgId, 3);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);*/
	}
	@Test(priority = 18,description = "Get activity Not started mode for  Deployment Plan", groups = { "RegressionTests" })
	public void getDeploymentPlanActivityById() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create activity for Deployment Plan ER - [API]- GET /DeploymentPlanActivities/GetActivity");
		deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "activityId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetactivitiyParameters"));
		deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"NotStarted");
	}
	@Test(priority = 19,description = "Get activitys Not started mode for Deployment Plan", groups = { "RegressionTests" })
	public void getDeploymentPlanActivitys() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create activity for Deployment Plan ER - [API]- GET /DeploymentPlanActivities/GetGridActivities");
		deploymentPlanPage.getDPAcivitys( PlutoraAPIConfiguration.testData, "DP_Id_Act");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	//	deploymentPlanPage.verifyResponseIsNotNull(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetactivitiyParameters"));
		deploymentPlanPage.verifyResponseValue("data[0].Status",PlutoraAPIConfiguration.testData,"NotStarted");
	}
	
	@Test(priority = 20,description = "Update activity in Not started mode for Deployment Plan", groups = { "RegressionTests" })
	public void updateDeploymentPlanActivity() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create activity for Deployment Plan ER - [API]- PUT /DeploymentPlanActivities/BatchUpdate");
		System.out.println(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "activityId"));
		deploymentPlanPage.updateDeploymentPlanActivity("updateActivityWithoutStatusJson", PlutoraAPIConfiguration.testData, userId, "DP_Id_Act","activityId","systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "activitiyParameters"));
		deploymentPlanPage.verifyResponseValue("data.Data[0].Status",PlutoraAPIConfiguration.testData,"NotStarted");
	}

	/*@Test(priority = 21,description = "Delete activity in Not started mode for Deployment Plan", groups = { "RegressionTests" })
	public void deleteDeploymentPlanActivity() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create activity for Deployment Plan ER - [API]- PUT /DeploymentPlanActivities/GetActivity");
		deploymentPlanPage.deleteActivity("DeleteActivityJson", PlutoraAPIConfiguration.testData,"DP_Id","activityId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}*/


	@Test(priority = 22,description = "Create Master DeploymentPlan with only name,description and organization name", groups = { "RegressionTests" })
	public void createMDP(){
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan- [API]- POST /MasterDeploymentPlan/Create");
		deploymentPlanPage.postMasterDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmpty"));
	
	}
	
	@Test(priority = 23,description = "Create Master DeploymentPlan with system and Enterprise release", groups = { "RegressionTests" })
	public void createMDPWithSystemAndReleaseER() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postMasterDeploymentPlanWithSystem("createMDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfSystemsAndRelease"));
	
	}
	
	@Test(priority = 24,description = "Create Master DeploymentPlan with system and Project release", groups = { "RegressionTests" })
	public void createMDPWithPR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postMasterDeploymentPlanWithSystem("createMDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfSystemsAndRelease"));
	
	}
	
	@Test(priority = 25,description = "Create Master DeploymentPlan with system and Project release", groups = { "RegressionTests" })
	public void createMDPWithIR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postMasterDeploymentPlanWithSystem("createMDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfSystemsAndRelease"));
	
	}
	@Test(priority = 26,description = "Create Master DeploymentPlan with child DP-ER", groups = { "RegressionTests" })
	public void createMDPwithDP_ER() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		
		deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfDP"));
	
	}
	
	@Test(priority = 27,description = "Create Master DeploymentPlan with child DP-PR", groups = { "RegressionTests" })
	public void createMDPWithDP_PR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325ProjectJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfDP"));
	}
	
	@Test(priority = 28,description = "Create Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void createMDPWithDP_IR() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Create DeploymentPlan - [API]- POST /MasterDeploymentPlan/Create");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfDP"));
	}
	
	@Test(priority = 29,description = "Get Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void getMDPById() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API] - GET /MasterDeploymentPlan/Get/{id}");
		deploymentPlanPage.getMasterDeploymentPlanById(PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//Verify Parameter values//
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfDP"));
	}
	
	/*@Test(priority =30,description = "Delete Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void deletMDPById() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get master DeploymentPlan");
		deploymentPlanPage.deleteMasterDeploymentPlanById(PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}*/
	
	@Test(priority =31,description = "POST Activity set to Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void addActivitySetMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]-POST /DeploymentPlanActivitySets/BatchCreate");
		deploymentPlanPage.postActivitySetsMDP("AddActivitySetJson",PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data[0].ID","activitySet_Id");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetParameters"));
	}
	
	@Test(priority =32,description = "Update Activity set to Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void updateActivitySetMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- PUT /DeploymentPlanActivitySets/BatchUpdate");
		deploymentPlanPage.updateActivitySetsMDP("UpdateActivitySetJson", PlutoraAPIConfiguration.testData, "activitySet_Id", "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data[0].Title","activitySet_title");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetParameters"));
	}
	
	@Test(priority =33,description = "Get Activity set to Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void getActivitySetMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /DeploymentPlanActivitySets/ActivitySets");
		deploymentPlanPage.getMDPActivitySet(PlutoraAPIConfiguration.testData,"MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetParameters"));
	}
	
	/*@Test(priority =34,description = "Delete Activity set Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void deleteActivitySetMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get master DeploymentPlan");
		deploymentPlanPage.deleteMDPActivitySet("UpdateActivitySetJson", PlutoraAPIConfiguration.testData,"activitySet_Id", "MDP_Id","activitySet_title");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	*/
	@Test(priority =35,description = "Get DeploymentPlan stakeholders", groups = { "RegressionTests" })
	public void getDPBaseStakeholders() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /DeploymentPlanBase/Stakeholders");
		deploymentPlanPage.getDPBaseStakeholders(PlutoraAPIConfiguration.testData,"DP_Id_Stk");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);  
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "StakeHoldersParameters"));
	}
	
	@Test(priority =36,description = "Get DeploymentPlan customFields", groups = { "RegressionTests" })
	public void getDPBaseCustomFields() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /DeploymentPlanBase/GetCustomFields");
		deploymentPlanPage.getDPBaseCustomFields(PlutoraAPIConfiguration.testData,"DP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		List<String> listOfIds = deploymentPlanPage.getListOfData(PlutoraAPIConfiguration.testData, "data.Name");
	   	System.out.println(listOfIds); 
	}
	
	@Test(priority =37,description = "Get DeploymentPlan activity customFields Prototype", groups = { "RegressionTests" })
	public void getDPBaseActivityCustomFields() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API] -GET /DeploymentPlanBase/ActivityCustomFieldPrototype");
		deploymentPlanPage.getDPBaseActivityCustomFields(PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		List<String> listOfIds = deploymentPlanPage.getListOfData(PlutoraAPIConfiguration.testData, "data.CustomFieldPrototype.Name");
	   	System.out.println(listOfIds); 
	}
	
	@Test(priority =38,description = "Create Stakeholders for DeploymentPlanBase", groups = { "RegressionTests" })
	public void createStakeholdersDPBase() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- POST /DeploymentPlanBase/CreateStakeholderUser");
		deploymentPlanPage.createStakeHoldersForDeploymentPlan("CreateStakeholderJson", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		
	}
	@Test(priority =39,description = "Create Checkpoints  for Master DeploymentPlanBase in Draft Mode", groups = { "RegressionTests" })
	public void addCheckPointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- POST /Checkpoints/Create");
		deploymentPlanPage.createCheckpointsForMDPinDraft("createCheckpointMDPinDraft",PlutoraAPIConfiguration.testData,"MDP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","checkpoint_id");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "checkpointsParameters"));
	}
	@Test(priority =40,description = "Update Checkpoints  for Master DeploymentPlanBase in Draft Mode", groups = { "RegressionTests" })
	public void updateCheckPointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- PUT /Checkpoints/Update/{id}");
		deploymentPlanPage.updateCheckpointsForMDPinDraft("updateCheckpointMDPinDraft", PlutoraAPIConfiguration.testData,"MDP_Id","checkpoint_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "checkpointsParameters"));
	}
	@Test(priority =41,description = "Get Check point of Master DeploymentPlan", groups = { "RegressionTests" })
	public void getCheckpoint() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /Checkpoints/GetCheckpoint");
		deploymentPlanPage.getCheckpoint(PlutoraAPIConfiguration.testData,"checkpoint_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "checkpointsParameters"));
	}
	@Test(priority =42,description = "Get All Check points of Master DeploymentPlan", groups = { "RegressionTests" })
	public void getCheckpointsPDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /Checkpoints/GetCheckpoints");
		deploymentPlanPage.getCheckpointsOfMDP(PlutoraAPIConfiguration.testData,"MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "checkpointsParameters"));
		List<String> listOfIds = deploymentPlanPage.getListOfData(PlutoraAPIConfiguration.testData, "data.Name");
	   	System.out.println(listOfIds);
	}
	@Test(priority =43,description = "Delete Checkpoint of Master DeploymentPlan", groups = { "RegressionTests" })
	public void deleteCheckpointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- DELETE /Checkpoints/Delete/{id}");
		deploymentPlanPage.deleteCheckpoint(PlutoraAPIConfiguration.testData,"checkpoint_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =44,description = "Batch Create Checkpoints  for Master DeploymentPlanBase in Draft Mode", groups = { "RegressionTests" })
	public void batchCreateCheckPointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- POST /Checkpoints/BatchCreate");
		deploymentPlanPage.batchCreateCheckpointsForMDPinDraft("BatchCreateCheckpointJson",PlutoraAPIConfiguration.testData,"MDP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data[0].ID","checkpoint_id");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "batchCheckpintsParameters"));
	}
	@Test(priority =45,description = "Batch Update Checkpoints  for Master DeploymentPlanBase in Draft Mode", groups = { "RegressionTests" })
	public void batchUpdateCheckPointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- PUT /Checkpoints/BatchUpdate");
		deploymentPlanPage.batchUpdateCheckpointsForMDPinDraft("BatchUpdateCheckpointJson", PlutoraAPIConfiguration.testData, "MDP_Id", "checkpoint_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "batchCheckpintsParameters"));
	}
	@Test(priority =46,description = "Batch Delete Checkpoints  for Master DeploymentPlanBase in Draft Mode", groups = { "RegressionTests" })
	public void batchDeleteCheckPointMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- DELETE /Checkpoints/BatchDelete");
		deploymentPlanPage.batchDeleteCheckpointsForMDPinDraft("BatchDeleteCheckpointJson", PlutoraAPIConfiguration.testData, "MDP_Id", "checkpoint_id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =47,description = "Get Activity set lookups of Master DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void getActivitySetLookupsMDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "[API]- GET /DeploymentPlanActivitySets/ActivitySetsLookups");
		deploymentPlanPage.getActivitySetsOfMDP(PlutoraAPIConfiguration.testData,"MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetsLookupParameters"));
	}
/*	@Test(priority =48,description = "Get Releases by systems for DeploymentPlan with child DP-IR", groups = { "RegressionTests" })
	public void getReleasesBySystemsDP() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "Get master DeploymentPlan");
		deploymentPlanPage.postReleasesBySystemsForDP("getReleasesBySystems",PlutoraAPIConfiguration.testData,"systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetsLookupParameters"));
	}*/
	@Test(priority = 48,description = "CR664 - Stakeholders, AccountableId and Status is retrieved as Null in response of GET /DeploymentPlan/Get/{id}", groups = { "RegressionTests" })
	public void cr664_Defect1() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - Stakeholders, AccountableId and Status is retrieved as Null in response of GET /DeploymentPlan/Get/{id}");
		organizationPage.getOrganizations(PlutoraAPIConfiguration.testData);
		List<String> listOfIds = organizationPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		orgId= listOfIds.get(0);
	   	System.out.println(orgId); 
	   	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		//add system
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		List<String> listUserOfIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userId= listUserOfIds.get(0);
		System.out.println(userId); 
	   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId1");
	   	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId2");
		deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "DP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersForGetDP"));
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");		
	}
	/*@Test(priority = 49,description = "CR664 - Not able to change the DP status to execution when MDP is linked to DP", groups = { "RegressionTests" })
	public void cr664_Defect2() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - Not able to change the DP status to execution when MDP is linked to DP.");
		deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
	 	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "MDP_Id", userId, "rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	deploymentPlanPage.postActivitySetsMDP("AddActivitySetJson",PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data[0].ID","activitySet_Id");
	   	deploymentPlanPage.updateDeploymentPlanActivityWithSet("updateActivityJsonWithSet", PlutoraAPIConfiguration.testData, userId, "DP_Id","DP_activityId1","activitySet_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	deploymentPlanPage.createDeploymentPlanActivityWithSet("createActivityJsonWithSet", PlutoraAPIConfiguration.testData, userId, "MDP_Id","activitySet_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.Data[0].ID", "MDP_activityId1");
		deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateMDPWithDP("updateMDPWithDP", "MDP_Id",  PlutoraAPIConfiguration.testData, "releaseID", orgId,"DP_Id", 2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 3);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}*/
	@Test(priority =50,description = "CR664 - GET /DeploymentPlanBase/GetCustomFields - returns wrong status code for invalid request.", groups = { "RegressionTests" })
	public void cr664_Defect2() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - GET /DeploymentPlanBase/GetCustomFields - returns wrong status code for invalid request.");
		deploymentPlanPage.getDPBaseCustomFields(PlutoraAPIConfiguration.testData,"invalidId");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =51,description = "CR664 - POST /DeploymentPlanBase/UpdateActivityStatus should accept only existing status values", groups = { "RegressionTests" })
	public void cr664_Defect3() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST /DeploymentPlanBase/UpdateActivityStatus should accept only existing status values");
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId2", 9);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
}

