package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class EnvironmentPage extends RestAPIGenericUtilLib{
	
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
		    
		public void createEnvironment(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			APIListener.addLogger(response.asString());
		}

		public void verifyEnvironment(String testData) {
			//APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void updateEnvironment(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl")+ "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}

		public void deleteEnvironment(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void createConnectivity(String value, String testData, String direction) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("direction", PropertiesCache.setProperty(testData, "direction", direction));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl"));
			APIListener.addLogger(response.asString());
		}
		
		public void verifyConnectivity(String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		} 
		
		public void deleteConnectivity(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void createEnvironment(String value, String testData, String workId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			jsonObj.put("usageWorkItemId", workId);
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			APIListener.addLogger(response.asString());
		}
	
		public void createEnvironmentwithSystem(String value, String testData, String linkedSystemId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			jsonObj.put("url", PropertiesCache.setProperty(testData, "url"));
			jsonObj.put("linkedSystemId",PropertiesCache.getProperty(testData, linkedSystemId));
			System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			System.out.println(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			System.out.println(response.asString());
		}
		
		public void createEnvironmentwithSystemName(String value, String testData, String linkedSystemId,String linkedSystem) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
			jsonObj.put("url", PropertiesCache.setProperty(testData, "url"));
			jsonObj.put("linkedSystemId",PropertiesCache.getProperty(testData, linkedSystemId));
			jsonObj.put("linkedSystem",PropertiesCache.getProperty(testData, linkedSystem));
			System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			System.out.println(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
			System.out.println(response.asString());
		}
	 
		public void deleteEnvironment(String envId, String testData ) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl") + "/"
							+ PropertiesCache.getProperty(testData, envId));
			System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "EnvironmentUrl")+ PropertiesCache.getProperty(testData, envId));
		} 
		
		public void deleteEnvironmentFromId(String envId, String testData ) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl") + "/"
							+ envId); 
			System.out.println(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "EnvironmentUrl")+ envId);
		}
		
		
		public void createConnectivityWithSourceAndTarget(String value, String testData, String envGroupId, String sourceId, String targetId, String direction ) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("environmentGroupId",PropertiesCache.getProperty(testData, envGroupId));
			jsonObj.put("sourceId",PropertiesCache.getProperty(testData, sourceId));
			jsonObj.put("targetId",PropertiesCache.getProperty(testData, targetId));
			jsonObj.put("direction", PropertiesCache.setProperty(testData, "direction", direction));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl"));
			APIListener.addLogger(response.asString());
		}

		public void getConnectivities(String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl"));
}
		public void getEnvironments(String testData) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "EnvironmentUrl"));
}
		public void getConnectivityWithId(String testData, String id) {
			APIListener.addLogger( PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "ConnectivitiesUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		} 

}