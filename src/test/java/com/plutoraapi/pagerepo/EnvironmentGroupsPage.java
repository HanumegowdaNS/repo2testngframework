package com.plutoraapi.pagerepo;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class EnvironmentGroupsPage extends RestAPIGenericUtilLib{
	
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
		   
		public void createEnvironmentGroup(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			jsonObj.put("color", PropertiesCache.getProperty(testData, "color"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
		}
		
		public void getEnvironmentGroup(String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
		}

		public void verifyEnvironmentGroup(String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		 
		
		
		
		public void updateEnvironmentGroup(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl")+ "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void updateEnvironmentGroup(String value, String testData, String descriptionData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("description", PropertiesCache.getProperty(testData, descriptionData));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl")
							+ PropertiesCache.getProperty(testData, "id"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl")
							+ PropertiesCache.getProperty(testData, "id"));
		}

		public void deleteEnvironmentGroup(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
	
		public void createEnvironmentGroupWithEnv(String value, String testData, String envId) { 
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));  
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description")); 
			jsonObj.put("color", PropertiesCache.getProperty(testData, "color"));
			JSONArray arrayValue = new JSONArray();
			arrayValue.put(PropertiesCache.getProperty(testData,envId ));
			jsonObj.put("environmentIDs", arrayValue);
			System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
			System.out.println(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
		}
		
		

		
		public void getEnvironmentGroups(String envGroupId, String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, envGroupId));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl")
					+ PropertiesCache.getProperty(testData, envGroupId));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, envGroupId));
		}
		
		
		public void createEnvironmentGroupWithMultipleEnvironment(String value, String testData, String envIdList) {
	          JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
	          jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
	          jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
	          jsonObj.put("color", PropertiesCache.getProperty(testData, "color"));
	          JSONArray arrayValue = new JSONArray();
	          String[] arrayList = envIdList.split(",");
	           for(String list: arrayList){
	          arrayValue.put(PropertiesCache.getProperty(testData,list));
	          }
	          jsonObj.put("environmentIDs", arrayValue);
	          System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
	                          + PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
	          System.out.println(jsonObj.toString());
	          response = RestAssured.given().header("Content-Type", "application/json")
	                  .header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
	                  .body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
	                          + PropertiesCache.getProperty(testData, "EnvironmentGroupsUrl"));
	      } 
}
