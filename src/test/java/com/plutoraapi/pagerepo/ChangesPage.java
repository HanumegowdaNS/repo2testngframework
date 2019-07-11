package com.plutoraapi.pagerepo;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class ChangesPage extends RestAPIGenericUtilLib{

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
		   
		public void createChanges(String value, String testData) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl"));
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			APIListener.addLogger(jsonObj.toString()); 
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl"));
			APIListener.addLogger(response.asString());
			
		}

		public void verifyChanges(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void updateChanges(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, "id"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, "id"));
		}

		public void deleteChanges(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void getChanges(String testData) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl"));
		}
		  
		public void verifyChanges(String testData, String url) { 
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, url));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, url));
		}
		
		public void deleteChanges(String testData, String id) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
		
		public void getChangesStakeholders(String testData, String id) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "ChangesUrl")
					+ PropertiesCache.getProperty(testData, id)
					+ PropertiesCache.getProperty(testData, "StakeholderGetUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, id)
							+ PropertiesCache.getProperty(testData, "StakeholderGetUrl"));
		}
		
		public void updateStakeholdersChanges(String value, String testData, String changeId, String stakeholderId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("userId", PropertiesCache.getProperty(testData, stakeholderId));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "ChangesUrl")
					+ PropertiesCache.getProperty(testData, changeId)
					+ PropertiesCache.getProperty(testData, "StakeholderGetUrl") + "/"
					+ PropertiesCache.getProperty(testData, stakeholderId));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, changeId)
							+ PropertiesCache.getProperty(testData, "StakeholderGetUrl") + "/"
							+ PropertiesCache.getProperty(testData, stakeholderId));
		}
		
		public void updateChangeCurrency(String value, String testData, String changeId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "ChangesUrl")
					+ PropertiesCache.getProperty(testData, changeId));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, changeId));
		}
		public void addSystemToChange(String value,String testData,String changeId,String systemId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("systemId", PropertiesCache.getProperty(testData, systemId));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, changeId)
							+ PropertiesCache.getProperty(testData, "addSystemToChangeUrl"));
		}
		
		public void addLinkedChangesToChange(String value,String testData,String changeId,String childChangeId, String parentChangeId,String relatedChangesId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("childChanges",addJsonObjectToArray("id", childChangeId));
			jsonObj.put("parentChanges",addJsonObjectToArray("id", parentChangeId));
			jsonObj.put("relatedChanges",addJsonObjectToArray("id", relatedChangesId));		
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl")
							+ PropertiesCache.getProperty(testData, changeId)
							+ PropertiesCache.getProperty(testData, "addLinkedChangesUrl"));
		}
		
		public void getChangeWithId(String testData, String changeId) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ChangesUrl") + "/"
							+ PropertiesCache.getProperty(testData, changeId));
			APIListener.addLogger(response.asString());
		}

	
}
