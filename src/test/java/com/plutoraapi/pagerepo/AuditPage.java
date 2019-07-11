package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class AuditPage extends RestAPIGenericUtilLib{
	   
		public void createAuditSearch(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UserGroupsUrl"));
			
			
		}

		public void verifyAuditSearch(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "UserGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		
	
}
