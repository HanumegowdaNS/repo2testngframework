package com.plutoraapi.defects;

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

public class DeploymentPlanDefects {

	DeploymentPlanPage deploymentPlanPage = new DeploymentPlanPage();
	OrganizationsPage organizationPage = new OrganizationsPage();
	SystemsPage systemsPage = new SystemsPage();
	ReleasesPage releasesPage = new ReleasesPage();
	UsersPage usersPage = new UsersPage();
	String orgId,userId,roleIds,userGroupId;
	

	@Test(priority = 1,description = "CR664 - Stakeholders, AccountableId and Status is retrieved as Null in response of GET /DeploymentPlan/Get/{id}--R9041A-D-4713", groups = { "RegressionTests" })
	public void cr664_Defect1_R9041A_D_4713() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - Stakeholders, AccountableId and Status is retrieved as Null in response of GET /DeploymentPlan/Get/{id}--R9041A-D-4713");
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
	@Test(priority = 2,description = "CR664 - Not able to change the DP status to execution when MDP is linked to DP--R9041A-D-4657", groups = { "RegressionTests" })
	public void cr664_Defect2_R9041A_D_4657() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - Not able to change the DP status to execution when MDP is linked to DP--R9041A-D-4657.");
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
		deploymentPlanPage.updateDeploymentPlanStatusWithMDP("updateDPStatusWithMDP", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, "MDP_Id",2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateMDPWithDP("updateMDPWithDP", "MDP_Id",  PlutoraAPIConfiguration.testData, "releaseID", orgId,"DP_Id", 2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateDeploymentPlanStatusWithMDP("updateDPStatusWithMDP", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, "MDP_Id",3);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =3,description = "CR664 - GET /DeploymentPlanBase/GetCustomFields - returns wrong status code for invalid request.--R9041A-D-4718", groups = { "RegressionTests" })
	public void cr664_Defect3_R9041A_D_4718() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - GET /DeploymentPlanBase/GetCustomFields - returns wrong status code for invalid request.-R9041A-D-4718");
		deploymentPlanPage.getDPBaseCustomFields(PlutoraAPIConfiguration.testData,"invalidId");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =4,description = "CR664 - POST /DeploymentPlanBase/UpdateActivityStatus should accept only existing status values--R9041A-D-4724", groups = { "RegressionTests" })
	public void cr664_Defect4_R9041A_D_4724() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST /DeploymentPlanBase/UpdateActivityStatus should accept only existing status values--R9041A-D-4724");
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId2", 9);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority =5,description = "CR664 - POST DeploymentPlanBase/UpdateActivityStatus?activityId={id}&status=1 allows to update Activity Status even though DP or MDP is not in Execution Status--R9041A-D-4706", groups = { "RegressionTests" })
	public void cr664_Defect5_R9041A_D_4706() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST DeploymentPlanBase/UpdateActivityStatus?activityId={id}&status=1 allows to update Activity Status even though DP or MDP is not in Execution Status--R9041A-D-4706");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
	   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId");
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId", 2);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId", 3);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId", 4);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId", 1);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateDeploymentPlanActivityWithStatus("updateActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id", "DP_activityId", "systemId", 2);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "DP_activityId");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"NotStarted");
	}
	@Test(priority =6,description = "CR664 - absent validation for Dependency field in DP Activities when changing DP Activity Status via API--S-S--R9041A-D-4663", groups = { "RegressionTests" })
	public void cr664_Defect6_R9041A_D_4663() throws InterruptedException{
	   systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	   systemsPage.setDataToProperty("id","systemId");
	   releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	   releasesPage.setDataToProperty("id","releaseID");
	   releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	   releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	   deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_one");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_one_name");
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_two");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_two_name");
	   deploymentPlanPage.updateDeploymentPlanActivityWithDependency("addDependencyToActivity", PlutoraAPIConfiguration.testData, "DP_activityId_two_name", "DP_activityId_one_name", userId, "DP_Id", "systemId", "DP_activityId_two", "DP_activityId_one", 3);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 3);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 0);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "DP_activityId_two");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"NotStarted");
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 0);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);   
	}
	@Test(priority =7,description = "CR664 - absent validation for Dependency field in DP Activities when changing DP Activity Status via API-- F-F--R9041A-D-4663", groups = { "RegressionTests" })
	public void cr664_Defect7_R9041A_D_4663() throws InterruptedException{
	   systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	   systemsPage.setDataToProperty("id","systemId");
	   releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	   releasesPage.setDataToProperty("id","releaseID");
	   releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	   releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	   deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_one");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_one_name");
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_two");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_two_name");
	   deploymentPlanPage.updateDeploymentPlanActivityWithDependency("addDependencyToActivity", PlutoraAPIConfiguration.testData, "DP_activityId_two_name", "DP_activityId_one_name", userId, "DP_Id", "systemId", "DP_activityId_two", "DP_activityId_one", 1);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 3);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 1);
	   deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 0);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "DP_activityId_two");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"InProgress");
	}
	@Test(priority =8,description = "CR664 - absent validation for Dependency field in DP Activities when changing DP Activity Status via API-- S-F--R9041A-D-4663", groups = { "RegressionTests" })
	public void cr664_Defect8_R9041A_D_4663() throws InterruptedException{
	   systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	   systemsPage.setDataToProperty("id","systemId");
	   releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	   releasesPage.setDataToProperty("id","releaseID");
	   releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	   releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	   deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_one");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_one_name");
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_two");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_two_name");
	   deploymentPlanPage.updateDeploymentPlanActivityWithDependency("addDependencyToActivity", PlutoraAPIConfiguration.testData, "DP_activityId_two_name", "DP_activityId_one_name", userId, "DP_Id", "systemId", "DP_activityId_two", "DP_activityId_one", 2);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 3);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 1);
	   deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 0);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "DP_activityId_two");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"InProgress");
	}
	@Test(priority =9,description = "CR664 - absent validation for Dependency field in DP Activities when changing DP Activity Status via API-- F-S--R9041A-D-4663", groups = { "RegressionTests" })
	public void cr664_Defect9_R9041A_D_4663() throws InterruptedException{
	   systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	   systemsPage.setDataToProperty("id","systemId");
	   releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	   releasesPage.setDataToProperty("id","releaseID");
	   releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	   releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	   deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_one");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_one_name");
	   deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId_two");
	   deploymentPlanPage.setDataToProperty("data.Data[0].Name", "DP_activityId_two_name");
	   deploymentPlanPage.updateDeploymentPlanActivityWithDependency("addDependencyToActivity", PlutoraAPIConfiguration.testData, "DP_activityId_two_name", "DP_activityId_one_name", userId, "DP_Id", "systemId", "DP_activityId_two", "DP_activityId_one", 4);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateDeploymentPlanStatus("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id", 3);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 1);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_two", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.updateActivityStatus(PlutoraAPIConfiguration.testData, "DP_activityId_one", 2);
	   deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.getDPAcivityById( PlutoraAPIConfiguration.testData, "DP_activityId_two");
       deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	   deploymentPlanPage.verifyResponseValue("data.Status",PlutoraAPIConfiguration.testData,"InProgress");
	}
	@Test(priority = 10,description = "CR664 - DELETE /Questions/Delete should not require entire object in the request - only 'id' should be enough to delete a Question--R9041A-D-4667", groups = { "RegressionTests" })
	public void cr664_Defect10_R9041A_D_4667(){
		APIListener.test1.log(Status.INFO, "CR664 - DELETE /Questions/Delete should not require entire object in the request - only 'id' should be enough to delete a Question--R9041A-D-4667");
		deploymentPlanPage.postMasterDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
		deploymentPlanPage.createQuestionsForMDPinDraft("CreateQuestionsJson", PlutoraAPIConfiguration.testData, "MDP_Id", "MasterDeploymentPlan");
		deploymentPlanPage.setDataToProperty("data[0].ID","QuestionID");
		deploymentPlanPage.deleteQuestionsForMDPinDraft("DeleteQuestionsJson", PlutoraAPIConfiguration.testData, "MDP_Id", "MasterDeploymentPlan","QuestionID");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 11,description = "CR664 - POST DeploymentPlanBase/ImplicitStakeholdersForActivities returns invalid response with error--R9041A-D-4637", groups = { "RegressionTests" })
	public void cr664_Defect11_R9041A_D_4637(){
		APIListener.test1.log(Status.INFO, "CR664 - POST DeploymentPlanBase/ImplicitStakeholdersForActivities returns invalid response with error---R9041A-D-4637");
		usersPage.verifyUserGroups(PlutoraAPIConfiguration.testData);
		List<String> listUserGroupOfIds = usersPage.getListOfData(PlutoraAPIConfiguration.testData, "id");
		userGroupId= listUserGroupOfIds.get(1);
		System.out.println(userGroupId); 
		deploymentPlanPage.postImplicitStakeholdersForActivities(userGroupId,PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 12,description = "CR664 - POST DeploymentPlan/Create allows to create DP with Release without validation on System and Release Implementation Date --R9041A-D-4705", groups = { "RegressionTests" })
	public void cr664_Defect12_R9041A_D_4705()throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST DeploymentPlan/Create allows to create DP with Release without validation on System and Release Implementation Date --R9041A-D-4705");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId1");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId2");
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		deploymentPlanPage.postDeploymentPlan("createDPWithReleaseOnly", PlutoraAPIConfiguration.testData,orgId,"releaseID");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData, "releaseID", "systemId1");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId2", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId1", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 13,description = "CR664 - POST Issues/Create and PUT /Issues/Update unexpectedly requires parameter RaisedById --R9041A-D-4720", groups = { "RegressionTests" })
	public void cr664_Defect13_R9041A_D_4720()throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST Issues/Create and PUT /Issues/Update unexpectedly requires parameter RaisedById---R9041A-D-4720");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
 	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "MDP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.getStakeholdersOfDPorMDP(PlutoraAPIConfiguration.testData, "MDP_Id");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data[0].ID","stk_id");
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 3);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateMDPWithDP("updateMDPWithDP", "MDP_Id",  PlutoraAPIConfiguration.testData, "releaseID", orgId,"DP_Id", 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateMDPWithDP("updateMDPWithDP", "MDP_Id",  PlutoraAPIConfiguration.testData, "releaseID", orgId,"DP_Id", 3);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.createIssuesForMDP("createIssuesJson", PlutoraAPIConfiguration.testData, "MDP_Id", "stk_id", "DP_Id");
	deploymentPlanPage.setDataToProperty("data[0].ID","Issue_Id");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateIssuesForMDP("updateIssuesJson", PlutoraAPIConfiguration.testData, "MDP_Id", "stk_id", "DP_Id","Issue_Id");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	
	}
	@Test(priority = 14,description = "CR664 - POST/PUT/DELETE DeploymentPlanActivitySets allows to update Activity Sets when Master Deployment Plan is not in Draft Status--R9041A-D-4645", groups = { "RegressionTests" })
	public void cr664_Defect14_R9041A_D_4645()throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - POST/PUT/DELETE DeploymentPlanActivitySets allows to update Activity Sets when Master Deployment Plan is not in Draft Status--R9041A-D-4645");
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","systemId");
		releasesPage.createRelease("createRelease4325IndependentJson", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","releaseID");
		releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postMasterDeploymentPlanWithSystem("createMDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
		deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "MDPParametersNotEmptyIfSystemsAndRelease"));
		deploymentPlanPage.postActivitySetsMDP("AddActivitySetJson",PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.setDataToProperty("data[0].ID;data[0].Title","activitySet_Id;activitySet_title");
		deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ActivitySetParameters"));
		deploymentPlanPage.updateMasterDeploymentPlanWithSystem("updateMDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId, "MDP_Id",2);
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.postActivitySetsMDP("AddActivitySetJson",PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.updateActivitySetsMDP("UpdateActivitySetJson", PlutoraAPIConfiguration.testData, "activitySet_Id", "MDP_Id");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.deleteMDPActivitySet("UpdateActivitySetJson", PlutoraAPIConfiguration.testData,"activitySet_Id", "MDP_Id","activitySet_title");
		deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 15,description = "CR664 - GET /DeploymentPlan/Get/{id} gives object reference error--R9041A-D-4649", groups = { "RegressionTests" })
	public void cr664_Defect15_R9041A_D_4649(){
		APIListener.test1.log(Status.INFO, "CR664 - GET /DeploymentPlan/Get/{id} gives object reference error--R9041A-D-4649");
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "MDP_Id");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("message",PlutoraAPIConfiguration.testData,"ErrorMsgGetDP");
	}
	@Test(priority =16,description = "CR664 - DELETE /MasterDeploymentPlan/Delete/{id} - returns object reference error with 200 status code.--R9041A-D-4650", groups = { "RegressionTests" })
	public void cr664_Defect16_R9041A_D_4650() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - DELETE /MasterDeploymentPlan/Delete/{id} - returns object reference error with 200 status code.--R9041A-D-4650");
		deploymentPlanPage.deleteMasterDeploymentPlanById(PlutoraAPIConfiguration.testData, "MDP_Id");
		deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		deploymentPlanPage.verifyResponseValue("success",PlutoraAPIConfiguration.testData,"successMsg");
	}
	@Test(priority =17,description = "CR664 - Error message shown is wrong when tried to delete the activity when it is in In-progress/Completed status.--R9041A-D-4634", groups = { "RegressionTests" })
	public void cr664_Defect17_R9041A_D_4634() throws InterruptedException{
		APIListener.test1.log(Status.INFO, "CR664 - Error message shown is wrong when tried to delete the activity when it is in In-progress/Completed status.--R9041A-D-4634");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
	deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.Data[0].ID", "DP_activityId");
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 3);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanActivityWithStatus("updateActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id", "DP_activityId", "systemId", 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.deleteActivity(PlutoraAPIConfiguration.testData,"DP_Id","DP_activityId");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.Errors[0]",PlutoraAPIConfiguration.testData,"ErrorMessageIfActivityIsDeletedInProgress");
	}
	@Test(priority = 18,description = "CR664 - Delete /deploymentPlan/Delete/{id} returns object reference error with 200 status code.--R9041A-D-4653", groups = { "RegressionTests" })
	public void cr664_Defect18_R9041A_D_4653(){
	APIListener.test1.log(Status.INFO, "CR664 - Delete /deploymentPlan/Delete/{id} returns object reference error with 200 status code--R9041A-D-4653.");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "ChildDp_id");
	deploymentPlanPage.deleteDeploymentPlan( PlutoraAPIConfiguration.testData, "ChildDp_id");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("success",PlutoraAPIConfiguration.testData,"successMsg");
    }
	@Test(priority = 19,description = "CR664 - API created activities do not open via UI - POST DeploymentPlanActivities/BatchCreate?deploymentPlanId={{dp-er-guid}}--R9041A-D-4651", groups = { "RegressionTests" })
	public void cr664_Defect19_R9041A_D_4651() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - API created activities do not open via UI - POST DeploymentPlanActivities/BatchCreate?deploymentPlanId={{dp-er-guid}}--R9041A-D-4651");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[0].Status",PlutoraAPIConfiguration.testData,"defaultMode");
	deploymentPlanPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "DPParametersNotEmptyIfSystems"));
   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.createDeploymentPlanActivity("createActivityWithoutDowntimesJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.createDeploymentPlanActivity("createActivityForDatesJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
    }
	@Test(priority = 20,description = "CR664 - not working POST DeploymentPlanBase/BulkUpdateStakeholders-- R9041A-D-4654", groups = { "RegressionTests" })
	public void cr664_Defect20_R9041A_D_4654() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - not working POST DeploymentPlanBase/BulkUpdateStakeholders--R9041A-D-4654");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id_22");
	deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id_22" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
	deploymentPlanPage.postBulkStakeholderstoDPAndMDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id_22","MDP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "DP_Id_22");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	//deploymentPlanPage.verifyResponseValue("data.Stakeholders[0].UserID",PlutoraAPIConfiguration.testData,"userId");
	deploymentPlanPage.getMasterDeploymentPlanById(PlutoraAPIConfiguration.testData, "MDP_Id");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	//deploymentPlanPage.verifyResponseValue("data.Stakeholders[0].UserID",PlutoraAPIConfiguration.testData,"userId");
    }
	@Test(priority = 21,description = "CR664 - invalid response in&#160;GET /DeploymentPlanBase/GetDeployments -- R9041A-D-4656", groups = { "RegressionTests" })
	public void cr664_Defect21_R9041A_D_4656() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - invalid response in&#160;GET /DeploymentPlanBase/GetDeployments-- R9041A-D-4656");
	deploymentPlanPage.getDPBaseDPs(PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 22,description = "CR664 - Able to create an activity when DP is in execution mode --R9041A-D-4658", groups = { "RegressionTests" })
	public void cr664_Defect22_R9041A_D_4658() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - Able to create an activity when DP is in execution mode--R9041A-D-4658");
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id_22","systemId", "releaseID", orgId, 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id_22","systemId", "releaseID", orgId, 3);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id_22","systemId");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.Errors[0]",PlutoraAPIConfiguration.testData,"ErrorMsgWhenAddActInDPExe");
	}
	@Test(priority = 23,description = "CR664 - POST /DeploymentPlanBase/BulkUpdateStakeholders - able to add stakeholders when DP is in completed mode --R9041A-D-4660", groups = { "RegressionTests" })
	public void cr664_Defect23_R9041A_D_4660() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - POST /DeploymentPlanBase/BulkUpdateStakeholders - able to add stakeholders when DP is in completed mode --R9041A-D-4660");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 2);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 3);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanStatusWithSystemAndRelease("updateDPStatus", PlutoraAPIConfiguration.testData, "DP_Id","systemId", "releaseID", orgId, 5);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
  	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("message",PlutoraAPIConfiguration.testData,"ErrorWhileAddingStakeholderInDPCompleted");
	}
	@Test(priority = 24,description = "CR664- POST /DeploymentPlanBase/BulkUpdateStakeholders gives Object reference error-- R9041A-D-4661", groups = { "RegressionTests" })
	public void cr664_Defect24_R9041A_D_4661() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664- POST /DeploymentPlanBase/BulkUpdateStakeholders gives Object reference error --R9041A-D-4661");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id");
	deploymentPlanPage.postBulkStakeholderstoDPWithoutRoleIds("CreateStakeholderWithoutRoleIdsJson", PlutoraAPIConfiguration.testData, "Dp_id", userId);
   	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.verifyResponseValue("message",PlutoraAPIConfiguration.testData,"ErrorWhileAddingStakeholderWithOutRoleIds");
	}
	@Test(priority = 25,description = "CR664 - PUT /DeploymentPlan/Update/{id} does not update custom fields -- R9041A-D-4664", groups = { "RegressionTests" })
	public void cr664_Defect25_R9041A_D_4664() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - PUT /DeploymentPlan/Update/{id} does not update custom fields-- R9041A-D-4664");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id");
	}
	@Test(priority = 26,description = "CR664 - DP Status attribute validation failure from Draft to other status-- R9041A-D-4670", groups = { "RegressionTests" })
	public void cr664_Defect26_R9041A_D_4670() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - \"Status\" attribute validation failure from Draft to other status -- R9041A-D-4670");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_one");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_two");
	deploymentPlanPage.dpBulkBackToDraft(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkExecute(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkComplete(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_one");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[1].Status",PlutoraAPIConfiguration.testData,"ApprovedStatus");
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[1].Status",PlutoraAPIConfiguration.testData,"ApprovedStatus");
	}
	@Test(priority = 27,description = "CR664 - DP Status attribute validation failure from Approve to other status -- R9041A-D-4670", groups = { "RegressionTests" })
	public void cr664_Defect27_R9041A_D_4670() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - \"Status\" attribute validation failure from Approve to other status -- R9041A-D-4670");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_one");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_two");
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkBackToDraft(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkComplete(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkExecute(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_one");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[2].Status",PlutoraAPIConfiguration.testData,"ExecuteStatus");
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[2].Status",PlutoraAPIConfiguration.testData,"ExecuteStatus");
	}
	@Test(priority = 28,description = "CR664 - Status attribute validation failure from Execute to other status -- R9041A-D-4670", groups = { "RegressionTests" })
	public void cr664_Defect28_R9041A_D_4670() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - \"Status\" attribute validation failure from Execute to other status -- R9041A-D-4670");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_one");
	deploymentPlanPage.postDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID", "Dp_id_two");
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkExecute(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkBackToDraft(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkComplete(PlutoraAPIConfiguration.testData, "Dp_id_one", "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_one");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[3].Status",PlutoraAPIConfiguration.testData,"CompleteStatus");
	deploymentPlanPage.getDeploymentPlan( PlutoraAPIConfiguration.testData, "Dp_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.verifyResponseValue("data.StatusHistory[3].Status",PlutoraAPIConfiguration.testData,"CompleteStatus");
	}
	@Test(priority = 29,description = "CR664 - DELETE Checkpoints/BatchDelete - should be sufficient to provide only Checkpoint ID in the request --R9041A-D-4666", groups = { "RegressionTests" })
	public void cr664_Defect29_R9041A_D_4666() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - DELETE Checkpoints/BatchDelete - should be sufficient to provide only Checkpoint ID in the request--R9041A-D-4666");
	deploymentPlanPage.postMasterDeploymentPlan("createDP", PlutoraAPIConfiguration.testData,orgId);
	deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.createCheckpointsForMDPinDraft("createCheckpointMDPinDraft",PlutoraAPIConfiguration.testData,"MDP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","checkpoint_id_one");
	deploymentPlanPage.createCheckpointsForMDPinDraft("createCheckpointMDPinDraft",PlutoraAPIConfiguration.testData,"MDP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","checkpoint_id_two");
	deploymentPlanPage.batchDeleteCheckpointsForMDPinDraftBatch("BatchDeleteCheckpointJson",PlutoraAPIConfiguration.testData,"MDP_Id","checkpoint_id_one","checkpoint_id_two");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	@Test(priority = 30,description = "CR664 - PUT /DeploymentPlanActivities/BatchUpdate -- gives 200 success code if activity Id is not included in the request.--R9041A-D-4672", groups = { "RegressionTests" })
	public void cr664_Defect30_R9041A_D_4672() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - PUT /DeploymentPlanActivities/BatchUpdate -- gives 200 success code if activity Id is not included in the request.--R9041A-D-4672");
	systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
	systemsPage.setDataToProperty("id","systemId");
	releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
	releasesPage.setDataToProperty("id","releaseID");
	releasesPage.addSystemToRelease("createReleaseSystem4405Json", PlutoraAPIConfiguration.testData);
	releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postDeploymentPlanWithSystem("createDPWithSystemAndRelease", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId);
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","DP_Id");
   	deploymentPlanPage.postBulkStakeholderstoDP("addStakeholderToDP", PlutoraAPIConfiguration.testData, "DP_Id", userId, "rolesIds1","rolesIds2");
   	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
   	deploymentPlanPage.createDeploymentPlanActivity("createActivityJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.updateDeploymentPlanActivityWithoutActivityId("updateActivityWithoutActivityIdJson", PlutoraAPIConfiguration.testData, userId, "DP_Id","systemId");
	deploymentPlanPage.verifyStatusCode("BadRequest_Status_Code", PlutoraAPIConfiguration.testData);

	}
	@Test(priority = 31,description = "CR664 - expose API endpoint PUT CheckpointAnswers/BatchUpdate--R9041A-D-4716", groups = { "RegressionTests" })
	public void cr664_Defect31_R9041A_D_4716() throws InterruptedException{
	APIListener.test1.log(Status.INFO, "CR664 - expose API endpoint PUT CheckpointAnswers/BatchUpdate --R9041A-D-4716");
	deploymentPlanPage.postMasterDeploymentPlanWithDP("createMDPWithDP", PlutoraAPIConfiguration.testData, "systemId", "releaseID", orgId,"DP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data.ID","MDP_Id");
	deploymentPlanPage.batchCreateCheckpointsForMDPinDraft("checkpointCreate1questionsJson",PlutoraAPIConfiguration.testData,"MDP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.setDataToProperty("data[0].ID","Checkpoint_Id");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].ID","Q1_Id");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].ResponseOptions[0].ID","Q1_R1_Id");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].ResponseOptions[0].Value","Q1_R1_Value");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].ResponseOptions[1].ID","Q1_R2_Id");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].ResponseOptions[1].Value","Q1_R2_Value");
	deploymentPlanPage.setDataToProperty("data[0].Questions[0].Title","Q1_Title");
	deploymentPlanPage.dpBulkApprove(PlutoraAPIConfiguration.testData, "DP_Id", "MDP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.dpBulkExecute(PlutoraAPIConfiguration.testData, "DP_Id","MDP_Id" );
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	deploymentPlanPage.postCheckpointAnswers("checkpointAnswersFor1QuestionJson", PlutoraAPIConfiguration.testData, "Checkpoint_Id", "DP_Id", "Q1_Id", "Q1_R1_Id", "Q1_R2_Id", "Q1_Title", "Q1_R1_Value", "Q1_R2_Value");
	deploymentPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}
	}