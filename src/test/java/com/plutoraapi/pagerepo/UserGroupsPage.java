package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class UserGroupsPage extends RestAPIGenericUtilLib{
	   
		public void createUserGroups(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
			jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UsergroupsUrl"));
			APIListener.addLogger(response.asString());
		}

		public void verifyUserGroups(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UsergroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "Id"));
		}
		public void updateUserGroups(String value,String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("Id", PropertiesCache.getProperty(testData, "Id"));
			jsonObj.put("Name", PropertiesCache.setProperty(testData, "Name"));
			jsonObj.put("Description", PropertiesCache.setProperty(testData, "Description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request()
					.patch(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UsergroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "Id"));
		}
		public void deleteUserGroups(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UsergroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "Id"));
		}
		
		public void getusersUserGroups(String testData) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UserGroupsUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UserGroupsUrl"));
		}
}
