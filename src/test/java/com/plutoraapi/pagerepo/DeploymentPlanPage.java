package com.plutoraapi.pagerepo;

import org.hamcrest.collection.IsArrayContaining;
import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class DeploymentPlanPage extends RestAPIGenericUtilLib{
	
	
	public void getAuthorizationToken(String testData) {
		 response=RestAssured.given().
					 header("Content-Type", "application/x-www-form-urlencoded").
					 formParam("client_id",PropertiesCache.getProperty(testData, "client_id")).
					 formParam("client_secret",PropertiesCache.getProperty(testData, "client_secret")).
					 formParam("grant_type",PropertiesCache.getProperty(testData, "grant_type")).
					 formParam("username",PropertiesCache.getProperty(testData, "username")).
					 formParam("password",PropertiesCache.getProperty(testData, "password")).
				     request().post(PropertiesCache.getProperty(testData, "AuthorizationUrl")+PropertiesCache.getProperty(testData, "TokenPath"));
		 
		} 
	
	public void postDeploymentPlan(String value, String testData, String orgId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void postDeploymentPlan(String value, String testData, String orgId, String releaseId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("OrganizationID",orgId);
		jsonObj.put("ReleaseID", PropertiesCache.getProperty(testData, releaseId));
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	
	public void postDeploymentPlanWithoutOrg(String value, String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void postDeploymentPlanWithSystem(String value, String testData, String systemId , String releaseId, String orgId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue);
		jsonObj.put("ReleaseID", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	
	public void updateDeploymentPlanWithSystem(String value, String testData, String dpId,String systemId, String releaseId, String orgId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, dpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue);
		jsonObj.put("ReleaseID", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
				+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString());
	}
	public void updateDeploymentPlanStatus(String value, String testData, String dpId, int status) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, dpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("UpdateToStatus", status);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
				+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString());
	}
	public void updateDeploymentPlanStatusWithSystemAndRelease(String value, String testData, String dpId,String  systemId, String releaseId, String orgId, int status) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, dpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue);
		jsonObj.put("ReleaseID", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("OrganizationID",orgId);
		jsonObj.put("UpdateToStatus", status);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
				+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString());
	}
	public void updateDeploymentPlanStatusWithMDP(String value, String testData, String dpId,String  systemId, String releaseId, String orgId, String mdpId,int status) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, dpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue);
		jsonObj.put("ReleaseID", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("OrganizationID",orgId);
		jsonObj.put("UpdateToStatus", status);
		jsonObj.put("masterDeploymentPlanId",PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
				+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "UpdateDPUrl")
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString());
	}
	public void getDeploymentPlan(String testData, String dpId) {
		APIListener.addLogger((PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetDPurl") + "/"
						+ PropertiesCache.getProperty(testData, dpId)));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetDPurl") + "/"
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
	}
	
	public void getMasterDeploymentPlan(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetMasterDPurl"));
		APIListener.addLogger(response.asString().toString());
	}
	
	public void getDeploymentPlans(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetDPBaseurl"));
		APIListener.addLogger(response.asString().toString());
	}
	
	public void deleteDeploymentPlan(String testData, String dpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "DeleteDPUrl") + "/"
				+ PropertiesCache.getProperty(testData, dpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteDPUrl") + "/"
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
	}
	
	public void createDeploymentPlanActivity(String value, String testData, String repId, String dpId, String systemId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue); 
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void createDeploymentPlanActivityWithOnlyName(String value, String testData, String dpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateDeploymentPlanActivity(String value, String testData, String repId, String dpId, String activityId, String systemId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue); 
		jsonObj.put("id", PropertiesCache.getProperty(testData, activityId));
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateDeploymentPlanActivityWithoutActivityId(String value, String testData, String repId, String dpId, String systemId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue); 
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateDeploymentPlanActivityWithStatus(String value, String testData, String repId, String dpId, String activityId, String systemId, int status) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue); 
		jsonObj.put("id", PropertiesCache.getProperty(testData, activityId));
		jsonObj.put("UpdateToStatus", status);
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateDeploymentPlanActivityWithDependency(String value, String testData, String activityName,String dependentActivityName, String repId, String dpId, String systemId,String activityId, String dependentActivityId,int dependencyType) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.getProperty(testData, activityName));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		jsonObj.put("id", PropertiesCache.getProperty(testData, activityId));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("SystemIDs", arrayValue); 
		
		JSONObject jsonObjOne = new JSONObject();
		jsonObjOne.put("Name",PropertiesCache.getProperty(testData, dependentActivityName));
		jsonObjOne.put("SourceActivityId",PropertiesCache.getProperty(testData, activityId));
		jsonObjOne.put("DependentActivityId",PropertiesCache.getProperty(testData, dependentActivityId));
		jsonObjOne.put("DependencyType",dependencyType);
		
		JSONObject jsonObjTwo = new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		arrayValue1.put(jsonObjOne);
		jsonObjTwo.put("added", arrayValue1);
		
		//JSONArray arrayValue2= new JSONArray();
		//arrayValue2.put(jsonObj);
		jsonObj.put("Dependencies", jsonObjTwo);
		
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	
	public void getDPAcivityById(String testData, String activityId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "getActivitiesURL")+PropertiesCache.getProperty(testData, activityId));
		APIListener.addLogger(response.asString().toString());
	}
	public void getDPAcivitys(String testData, String dpId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "getAllDPActivitiesURL")+PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void deleteActivity( String testData, String dpId, String activityId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "DeleteActivityurl")
				+ PropertiesCache.getProperty(testData, dpId));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData, activityId));
		System.out.println(arrayValue);
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "DeleteActivityurl")
					+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString());	
	}
	
	public void postBulkStakeholderstoDP(String value, String testData,String dpId,String userId, String roleId1, String roleId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		//JSONObject jsonObjTwo= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue2 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds", arrayValue); 
		jsonObjOne.put("userId", userId);
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId1));
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId2));
		jsonObjOne.put("roleIDs", arrayValue2);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "true");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "false");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void postBulkStakeholderstoDPAndMDP(String value, String testData,String dpId,String mdpId,String userId, String roleId1, String roleId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		//JSONObject jsonObjTwo= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue2 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		arrayValue.put(PropertiesCache.getProperty(testData,mdpId ));
		jsonObj.put("deploymentPlanIds", arrayValue); 
		jsonObjOne.put("userId", userId);
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId1));
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId2));
		jsonObjOne.put("roleIDs", arrayValue2);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "true");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "false");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void updateBulkStakeholderstoDP(String value, String testData,String dpId,String userId ,String roleId1, String roleId2 ) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue2 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds", arrayValue);
		jsonObjOne.put("userId", userId);
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId1));
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId2));
		jsonObjOne.put("roleIDs", arrayValue2);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "true");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "true");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void updateBulkStakeholderstoDPAcc(String value, String testData,String dpId,String userId ,String roleId1, String roleId2 ) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue2 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds", arrayValue);
		jsonObjOne.put("userId", userId);
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId1));
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId2));
		jsonObjOne.put("roleIDs", arrayValue2);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "false");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "true");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void postBulkStakeholdersGrouptoDP(String value, String testData,String dpId,String userId,String roleId1, String roleId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue2 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds", arrayValue);
		jsonObjOne.put("userId", userId);
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId1));
		arrayValue2.put(PropertiesCache.getProperty(testData,roleId2));
		jsonObjOne.put("roleIDs", arrayValue2);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "false");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "true");
		jsonObjOne.put("IsGroup", "true");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void postMasterDeploymentPlan(String value, String testData, String orgId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void postMasterDeploymentPlanWithSystem(String value, String testData, String systemId , String releaseId, String orgId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("systemIDs", arrayValue);
		JSONArray arrayValue1 = new JSONArray();
		arrayValue1.put(PropertiesCache.getProperty(testData,releaseId ));
		jsonObj.put("releaseIds",arrayValue1 );
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateMasterDeploymentPlanWithSystem(String value, String testData, String systemId , String releaseId, String orgId, String mdpId , int status) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUpdateUrl")+PropertiesCache.getProperty(testData, mdpId));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, mdpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("systemIDs", arrayValue);
		JSONArray arrayValue1 = new JSONArray();
		arrayValue1.put(PropertiesCache.getProperty(testData,releaseId ));
		jsonObj.put("releaseIds",arrayValue1 );
		jsonObj.put("OrganizationID",orgId);
		jsonObj.put("UpdateToStatus",status);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUpdateUrl")+PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void postMasterDeploymentPlanWithDP(String value, String testData, String systemId , String releaseId, String orgId, String dpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId ));
		jsonObj.put("systemIDs", arrayValue);
		JSONArray arrayValue1 = new JSONArray();
		arrayValue1.put(PropertiesCache.getProperty(testData,releaseId ));
		jsonObj.put("releaseIds",arrayValue1 );
		JSONArray arrayValue2 = new JSONArray();
		arrayValue2.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds",arrayValue2 );
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUrl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateMDPWithDP(String value,String mdpId, String testData, String releaseId, String orgId, String dpId, int status) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUpdateUrl")+ PropertiesCache.getProperty(testData, mdpId));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("ID", PropertiesCache.getProperty(testData, mdpId));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("externalIdentifier", PropertiesCache.setProperty(testData, "externalIdentifier"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray arrayValue1 = new JSONArray();
		arrayValue1.put(PropertiesCache.getProperty(testData,releaseId ));
		jsonObj.put("releaseIds",arrayValue1 );
		JSONArray arrayValue2 = new JSONArray();
		arrayValue2.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds",arrayValue2 );
		jsonObj.put("OrganizationID",orgId);
		jsonObj.put("UpdateToStatus",status);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "MasterDeploymentPlanUpdateUrl")+PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void getMasterDeploymentPlanById(String testData, String mdpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetMDPurl")+ "/"
				+ PropertiesCache.getProperty(testData, mdpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetMDPurl") + "/"
						+ PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void deleteMasterDeploymentPlanById(String testData, String mdpId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteMDPurl") + "/"
						+ PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
	}
	
	public void postActivitySetsMDP(String value, String testData, String masterDeploymentPlanId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "AddActivitySetToMDPurl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
		jsonObj.put("masterDeploymentPlanId",PropertiesCache.getProperty(testData, masterDeploymentPlanId));
		 APIListener.addLogger("["+jsonObj.toString()+"]"); 
		 String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "AddActivitySetToMDPurl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateActivitySetsMDP(String value, String testData, String id,String masterDeploymentPlanId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "updateActivitySetToMDPurl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
		jsonObj.put("masterDeploymentPlanId", PropertiesCache.getProperty(testData, masterDeploymentPlanId));
		jsonObj.put("id", PropertiesCache.getProperty(testData, id)).toString();
		 APIListener.addLogger("["+jsonObj.toString()+"]"); 
		 String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "updateActivitySetToMDPurl"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void getMDPActivitySet(String testData, String mdpId) {
		APIListener.addLogger((PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetMDPActivitysetURL") + "?planId="
				+ PropertiesCache.getProperty(testData, mdpId)));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetMDPActivitysetURL") + "?planId="
						+ PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void deleteMDPActivitySet(String value,String testData, String id,String masterDeploymentPlanId, String title) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "DeleteMDPActivitysetURL"));
             JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		     jsonObj.put("title", PropertiesCache.getProperty(testData, title));
			 jsonObj.put("masterDeploymentPlanId", PropertiesCache.getProperty(testData, masterDeploymentPlanId));
			 jsonObj.put("id", PropertiesCache.getProperty(testData, id));
			 APIListener.addLogger("["+jsonObj.toString()+"]"); 
			 String object="["+jsonObj.toString()+"]";
			APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).body(object).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteMDPActivitysetURL"));
		APIListener.addLogger(response.asString().toString());
	}
	public void getDPBaseStakeholders(String testData, String dpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetStakeHoldersUrl") + "?id="
				+ PropertiesCache.getProperty(testData, dpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetStakeHoldersUrl") + "?id="
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void getDPBaseCustomFields(String testData, String dpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetCustomfieldsURL") + "?id="
				+ PropertiesCache.getProperty(testData, dpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetCustomfieldsURL") + "?id="
						+ PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void getDPBaseActivityCustomFields(String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetActivityCustomfieldsURL"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetActivityCustomfieldsURL"));
		APIListener.addLogger(response.asString().toString());
	}
	public void createStakeHoldersForDeploymentPlan(String value, String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateStakeholderURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("firstName", PropertiesCache.setProperty(testData, "firstName"));
		jsonObj.put("lastName", PropertiesCache.setProperty(testData, "lastName"));
		jsonObj.put("username",PropertiesCache.setProperty(testData, "username")+"@plutora.com");
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateStakeholderURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void createCheckpointsForMDPinDraft(String value, String testData,String masterDeploymentPlanID) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateCheckpointURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateCheckpointsForMDPinDraft(String value, String testData,String masterDeploymentPlanID, String checkpointId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		jsonObj.put("id", PropertiesCache.getProperty(testData, checkpointId));
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "UpdateCheckpointURL")+ "/" 
						+PropertiesCache.getProperty(testData, checkpointId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void getCheckpoint(String testData,String checkpointId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetCheckpointURL")+ "?checkpointId=" 
				+PropertiesCache.getProperty(testData, checkpointId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetCheckpointURL")+ "?checkpointId=" 
						+PropertiesCache.getProperty(testData, checkpointId));
		APIListener.addLogger(response.asString().toString());
	}
	public void getCheckpointsOfMDP(String testData,String mdpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetCheckpointsOfMDPURL")+ "?id=" 
				+PropertiesCache.getProperty(testData, mdpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetCheckpointsOfMDPURL")+ "?id=" 
						+PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void deleteCheckpoint(String testData, String checkpointId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "DeleteCheckpointurl") + "/"
				+ PropertiesCache.getProperty(testData, checkpointId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteCheckpointurl") + "/"
						+ PropertiesCache.getProperty(testData, checkpointId));
		APIListener.addLogger(response.asString().toString());
	}
	public void batchCreateCheckpointsForMDPinDraft(String value, String testData,String masterDeploymentPlanID) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchCreateCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchCreateCheckpointURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void batchUpdateCheckpointsForMDPinDraft(String value, String testData,String masterDeploymentPlanID, String checkpointId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchUpdateCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		jsonObj.put("id", PropertiesCache.getProperty(testData, checkpointId));
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchUpdateCheckpointURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void batchDeleteCheckpointsForMDPinDraft(String value, String testData,String masterDeploymentPlanID, String checkpointId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchDeleteCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		jsonObj.put("id", PropertiesCache.getProperty(testData, checkpointId));
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchDeleteCheckpointURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void batchDeleteCheckpointsForMDPinDraftBatch(String value,String testData,String masterDeploymentPlanID, String checkpointId1,String checkpointId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchDeleteCheckpointURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		jsonObj.put("id", PropertiesCache.getProperty(testData, checkpointId1));
		JSONObject jsonObj1 = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj1.put("masterDeploymentPlanID", PropertiesCache.getProperty(testData, masterDeploymentPlanID));
		jsonObj1.put("id", PropertiesCache.getProperty(testData, checkpointId2));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(jsonObj);
		arrayValue.put(jsonObj1);
		APIListener.addLogger(arrayValue.toString()); 
		String object=arrayValue.toString();
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).
	            body(object).request().delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "BatchDeleteCheckpointURL"));
		APIListener.addLogger(response.asString());
		
	}
	
	public void getActivitySetsOfMDP(String testData,String mdpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "getActivitySetsOfMDPUrl")+ "?id=" 
				+PropertiesCache.getProperty(testData, mdpId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "getActivitySetsOfMDPUrl")+ "?planId=" 
						+PropertiesCache.getProperty(testData, mdpId));
		APIListener.addLogger(response.asString().toString());
	}
	public void postReleasesBySystemsForDP(String value, String testData,String systemId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "getReleasesBySystemsForDPUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,systemId));
		jsonObj.put("ids", arrayValue);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "getReleasesBySystemsForDPUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void updateDeploymentPlanActivityWithSet(String value, String testData, String repId, String dpId, String activityId, String activitySetId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		jsonObj.put("id", PropertiesCache.getProperty(testData, activityId));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,activitySetId));
		jsonObj.put("activitySetsIds", arrayValue);
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUpdateActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void createDeploymentPlanActivityWithSet(String value, String testData, String repId, String dpId, String activitySetId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("ResponsibleID", repId);
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,activitySetId));
		jsonObj.put("activitySetsIds", arrayValue);
	    APIListener.addLogger("["+jsonObj.toString()+"]"); 
	    String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanActivitiesUrl")+ "?deploymentPlanId=" +PropertiesCache.getProperty(testData, dpId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateActivityStatus( String testData,String activityId, int status) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "updateActivityStatusUrl")+PropertiesCache.getProperty(testData, activityId)
				+ "&status=" + status);
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "updateActivityStatusUrl")+PropertiesCache.getProperty(testData, activityId)
						+ "&status=" + status);
		APIListener.addLogger(response.asString().toString());
	}
	public void createQuestionsForMDPinDraft(String value, String testData,String entityId, String entityType) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateQuestionsURL") +
						"?entityType=" +entityType+ "&entityId="+PropertiesCache.getProperty(testData, entityId));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "CreateQuestionsURL")+ 
						"?entityType=" +entityType+ "&entityId="+PropertiesCache.getProperty(testData, entityId));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void deleteQuestionsForMDPinDraft(String value, String testData,String entityId, String entityType, String questionId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteQuestionsURL")+ 
						"?entityType=" +entityType+ "&entityId="+PropertiesCache.getProperty(testData, entityId));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, questionId));
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeleteQuestionsURL")+ 
						"?entityType=" +entityType+ "&entityId="+PropertiesCache.getProperty(testData, entityId));
		APIListener.addLogger(response.asString().toString());
	}
	public void postImplicitStakeholdersForActivities(String userGroupId, String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "PostImplicitStakeholdersUrl"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(userGroupId);
		System.out.println(arrayValue);
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
                        + PropertiesCache.getProperty(testData, "PostImplicitStakeholdersUrl"));
		APIListener.addLogger(response.asString());
		
	}
	public void getStakeholdersOfDPorMDP(String testData,String mdpIdORdpid) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "getStakeholdersOfDPurl")+ "?id=" 
				+PropertiesCache.getProperty(testData, mdpIdORdpid));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "getStakeholdersOfDPurl")+ "?id="  
						+PropertiesCache.getProperty(testData, mdpIdORdpid));
		APIListener.addLogger(response.asString().toString());
	}
	public void createIssuesForMDP(String value, String testData,String MDPid, String assigneeId, String DpId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "createIssuesURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("MasterDeploymentPlanId", PropertiesCache.getProperty(testData, MDPid));
		jsonObj.put("AssigneeId", PropertiesCache.getProperty(testData, assigneeId));
		jsonObj.put("SourceDeploymentPlanBaseId", PropertiesCache.getProperty(testData, MDPid));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,DpId ));
		jsonObj.put("ImpactedDeploymentPlanBasesIds",arrayValue );
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "createIssuesURL"));
		APIListener.addLogger(response.asString().toString());
		
	}
	public void updateIssuesForMDP(String value, String testData,String MDPid, String assigneeId, String DpId, String issueId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "updateIssuesURL"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, issueId));
		jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
		jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
		jsonObj.put("MasterDeploymentPlanId", PropertiesCache.getProperty(testData, MDPid));
		jsonObj.put("AssigneeId", PropertiesCache.getProperty(testData, assigneeId));
		jsonObj.put("SourceDeploymentPlanBaseId", PropertiesCache.getProperty(testData, MDPid));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,DpId ));
		jsonObj.put("ImpactedDeploymentPlanBasesIds",arrayValue );
        APIListener.addLogger("["+jsonObj.toString()+"]"); 
		String object="["+jsonObj.toString()+"]";
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "updateIssuesURL"));
		APIListener.addLogger(response.asString().toString());
	}
	public void getDPBaseDPs(String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "GetDPBaseDPsURL"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "GetDPBaseDPsURL"));
		APIListener.addLogger(response.asString().toString());
	}
	public void postBulkStakeholderstoDPWithoutRoleIds(String value, String testData,String dpId,String userId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONObject jsonObjOne= new JSONObject();
		//JSONObject jsonObjTwo= new JSONObject();
		JSONArray arrayValue1 = new JSONArray();
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId ));
		jsonObj.put("deploymentPlanIds", arrayValue); 
		jsonObjOne.put("userId", userId);
		jsonObjOne.put("isResponsible", "true");
		jsonObjOne.put("isAccountable", "true");
		jsonObjOne.put("isConsulted", "true");
		jsonObjOne.put("isInformed", "false");
		arrayValue1.put(jsonObjOne);
		jsonObj.put("stakeholders", arrayValue1);
	    APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "addStakeholderBulkUrl"));
		APIListener.addLogger(response.asString().toString());
	}
	public void postDeploymentPlanWithCustomFields(String value, String testData, String orgId, String lookupId) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		jsonObj.put("OrganizationID",orgId);
		APIListener.addLogger(jsonObj.toString()); 
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DeploymentPlanUrl"));
		APIListener.addLogger(response.asString());
		
	}
	public void dpBulkApprove(String testData, String dpId1, String dpId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkApproveURL"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId1 ));
		arrayValue.put(PropertiesCache.getProperty(testData,dpId2 ));
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkApproveURL"));
		APIListener.addLogger(response.asString());
		
	}
	public void dpBulkBackToDraft(String testData, String dpId1, String dpId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkBackToDraftURL"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId1 ));
		arrayValue.put(PropertiesCache.getProperty(testData,dpId2 ));
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkBackToDraftURL"));
		APIListener.addLogger(response.asString());
		
	}
	public void dpBulkExecute(String testData, String dpId1, String dpId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkExecuteURL"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId1 ));
		arrayValue.put(PropertiesCache.getProperty(testData,dpId2 ));
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkExecuteURL"));
		APIListener.addLogger(response.asString());
		
	}
	public void dpBulkComplete(String testData, String dpId1, String dpId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkApproveURL"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId1 ));
		arrayValue.put(PropertiesCache.getProperty(testData,dpId2 ));
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkCompleteURL"));
		APIListener.addLogger(response.asString());
		
	}
	public void dpBulkDelete(String testData, String dpId1, String dpId2) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkApproveURL"));
		JSONArray arrayValue = new JSONArray();
		arrayValue.put(PropertiesCache.getProperty(testData,dpId1 ));
		arrayValue.put(PropertiesCache.getProperty(testData,dpId2 ));
		System.out.println(arrayValue.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).with().
            body(arrayValue).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "DPBulkDeleteURL"));
		APIListener.addLogger(response.asString());
		
	}
	public void postCheckpointAnswers(String value, String testData, String checkpointId, String dpId, String question1Id, String response1Id, String response2Id, String questionTitle, String response1Value, String response2Value) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "checkpointBatchUpdateAnswersURL"));

		
		JSONObject jsonObj1 = new JSONObject();
		jsonObj1.put("ResponseOptionId", PropertiesCache.getProperty(testData, response1Id));
		jsonObj1.put("QuestionId", PropertiesCache.getProperty(testData, question1Id));
	
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("ID", PropertiesCache.getProperty(testData, response1Id));
		jsonObj2.put("Value", PropertiesCache.getProperty(testData, response1Value));
		jsonObj2.put("QuestionId", PropertiesCache.getProperty(testData, question1Id));
		
		JSONObject jsonObj3 = new JSONObject();
		jsonObj3.put("ID", PropertiesCache.getProperty(testData, response2Id));
		jsonObj3.put("Value", PropertiesCache.getProperty(testData, response2Value));
		jsonObj3.put("QuestionId", PropertiesCache.getProperty(testData, question1Id));
		
		JSONArray array1 = new JSONArray();
		array1.put(jsonObj2);
		array1.put(jsonObj3);
		JSONObject jsonObj4 = new JSONObject();
		jsonObj4.put("ResponseOptions", array1); 
		
	//	JSONObject jsonObj5 = new JSONObject();
		jsonObj4.put("Response", jsonObj1);
		
		jsonObj4.put("ID", PropertiesCache.getProperty(testData, question1Id));
		jsonObj4.put("Title", PropertiesCache.getProperty(testData, questionTitle));
		jsonObj4.put("Expanded", false);
		JSONArray array2 = new JSONArray();
		array2.put(jsonObj4);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("ID", PropertiesCache.getProperty(testData,checkpointId));
		jsonObj.put("DeploymentPlanID", PropertiesCache.getProperty(testData, dpId));
		jsonObj.put("QuestionAnswers", array2);
		
		APIListener.addLogger(jsonObj.toString());
		String object="["+jsonObj.toString()+"]";
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(object.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "checkpointBatchUpdateAnswersURL"));
		APIListener.addLogger(response.asString());
		
	}
}
