package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class TEBRPage extends RestAPIGenericUtilLib{
	   
		public void createTEBR(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
		}

		public void verifyTEBR(String testData) {
			APIListener.addLogger("Verify: "+PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		public void updateTEBR(String value,String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request()
					.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		public void deleteTEBR(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void deleteTEBR(String testData, String id) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
		
		
		public void createTEBR4269(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
		}
		
		public void getTEBR(String testData) {
			/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));*/
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
		}
		
		public void createTEBRBulk(String value,String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRBulkUrl"));
			APIListener.addLogger("["+jsonObj.toString()+"]");
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body("["+jsonObj.toString()+"]").request()
					.post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRBulkUrl"));
		}
		
		public void createTEBR4269WithRelease(String value, String testData,String releaseId,String systemId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			jsonObj.put("releaseID", PropertiesCache.getProperty(testData, releaseId));
			jsonObj.put("systemId", PropertiesCache.getProperty(testData, systemId));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));
		}
		
		public void verifyTEBR(String testData, String customURL) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, customURL));
		}
		
		public void getTEBRwithId(String testData, String id) {
			APIListener.addLogger("Verify: "+PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
	
}
