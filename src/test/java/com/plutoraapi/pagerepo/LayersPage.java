package com.plutoraapi.pagerepo;

import org.json.JSONObject;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class LayersPage extends RestAPIGenericUtilLib{

	public void createLayers(String value, String testData,String environmentId) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("hostID",response.path("id").toString());
		PropertiesCache.setProperty(testData, "hostID",jsonObj.get("hostID").toString());
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl"));
		APIListener.addLogger("LayerCreate: "+jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl"));
	}

	public void verifyLayers(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void updateLayers(String value,String testData,String environmentId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("hostID", PropertiesCache.getProperty(testData, "hostID"));
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request()
				.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	
	public void updateLayerswithHostid(String value,String testData,String environmentId, String hostID) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("hostID", PropertiesCache.getProperty(testData, hostID));
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		APIListener.addLogger("LayerUpdate: "+jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request()
				.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void deleteLayers(String testData) {
		APIListener.addLogger(response.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl")
						+ PropertiesCache.getProperty(testData, "id"));
	}

	public void update4345Layers(String value, String testData,String environmentId) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("hostID", PropertiesCache.getProperty(testData, "hostID"));
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "LayersUrl")
			    + PropertiesCache.getProperty(testData, "id"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl")
					    + PropertiesCache.getProperty(testData, "id"));
	}
	public void createLayersBulk(String value, String testData,String environmentId) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("hostID",response.path("id").toString());
		PropertiesCache.setProperty(testData, "hostID",jsonObj.get("hostID").toString());
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersBulkUrl"));
		APIListener.addLogger("["+jsonObj.toString()+"]");
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body("["+jsonObj.toString()+"]").request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersBulkUrl"));
	}

	public void createLayersWithHostId(String value, String testData,String environmentId, String hostID) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("hostID",response.path("id").toString());
		PropertiesCache.setProperty(testData, "hostID",jsonObj.get("hostID").toString());
		jsonObj.put("componentName", PropertiesCache.setProperty(testData, "componentName"));
		jsonObj.put("version", PropertiesCache.setProperty(testData, "version"));
		jsonObj.put("environmentID", PropertiesCache.getProperty(testData, environmentId));
		jsonObj.put("hostID", PropertiesCache.getProperty(testData, hostID));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl"));
		APIListener.addLogger("LayerCreate: "+jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LayersUrl"));
	}
}
