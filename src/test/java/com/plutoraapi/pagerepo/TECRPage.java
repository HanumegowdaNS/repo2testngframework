package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class TECRPage extends RestAPIGenericUtilLib{
	   
		public void createTECR(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
			APIListener.addLogger(response.asString());
		}

		public void verifyTECR(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			APIListener.addLogger(response.asString());
		}
		public void updateTECR(String value,String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request()
					.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") 
							+ PropertiesCache.getProperty(testData, "id"));
		}
		public void deleteTECR(String testData) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void deleteTECR(String testData, String id) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
		
		public void getTECR(String testData) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
		}
		
		public void updateTECRWithUserIdNull(String value,String testData,String userId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			jsonObj.put("userID", userId);
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") 
							+ PropertiesCache.getProperty(testData, "id"));
			APIListener.addLogger("jsonObj.toString()"+jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request()
					.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") 
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void createTECRWithUserIdNull(String value, String testData,String userId,String url) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			jsonObj.put("userID", userId);
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, url));
			APIListener.addLogger("jsonObj.toString()"+jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body("["+jsonObj.toString()+"]").request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, url));
		}
		
		public void createTECRLongDescription(String value, String testData) {
			String descTestData = "The JSON output from different Server APIs can range from simple to highly nested and "
					+ "complex. The examples on this page attempt to illustrate how the JSON Data Set treats specific "
					+ "formats, and gives examples of the different constructor options that allow the user to "
					+ "tweak its behavior. See our JSON Primer for more information.";
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", descTestData);
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
		}
		
		public void verifyTECR(String testData, String url) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, url));
			APIListener.addLogger(response.asString());
		}
		
		public void createTECRWithCustomId(String value, String testData, String customId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("projectID", PropertiesCache.getProperty(testData, customId));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl"));
		}
		
		public void createTECRBulk(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body("["+jsonObj.toString()+"]").request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRBulkUrl"));
		}
		
		public void getTECRWithId(String testData, String id) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TECRUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
		
	
}
