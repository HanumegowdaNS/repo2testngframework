package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class HostsPage extends RestAPIGenericUtilLib{
	   
		String json ;
		
		public void createHosts(String value, String testData,String environmentId) {
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "HostsUrl"));
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl"));
		}
        
		public void createHosts(String value, String testData) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("title", PropertiesCache.setProperty(testData, "title"));
			jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl"));
			APIListener.addLogger(jsonObj.toString());
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl"));
		}
		public void verifyHosts(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		public void updateHosts(String value,String testData, String id,String environmentId) {
			JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
			jsonObj.put("id", PropertiesCache.getProperty(testData, id));
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request()
					.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl") + "/"
							+ PropertiesCache.getProperty(testData, id));
		}
		public void deleteHosts(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl") + "/"
							+ PropertiesCache.getProperty(testData, "id"));
		}
		
		public void update4345Hosts(String testData) {
			json = response.asString().toString();
			JSONObject jsonObj = new JSONObject(json);
			jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
			APIListener.addLogger("Added updated json"+jsonObj.toString());
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "LayersUrl")
				    + PropertiesCache.getProperty(testData, "id"));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl")
						    + PropertiesCache.getProperty(testData, "id"));
		}
		
		public void createHostsBulk(String testData) {
			JSONObject jsonObj = new JSONObject(json);
			APIListener.addLogger(json);
			APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsBulkUrl"));
			APIListener.addLogger("["+jsonObj.toString()+"]");
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
					.body("["+jsonObj.toString()+"]").request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsBulkUrl"));
			APIListener.addLogger(response.asString());
			
		}
		
		public void getHosts(String testData) {
			/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "TEBRUrl"));*/
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "HostsUrl"));
		}
		
	
}
