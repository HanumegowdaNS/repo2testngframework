package com.plutoraapi.pagerepo;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class SystemsPage extends RestAPIGenericUtilLib{

	public void createSystems(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
		APIListener.addLogger(jsonObj.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
	}

	public void verifySystems(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void updateSystems(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request()
				.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void deleteSystems(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}

	public void verifySystemsWithoutId(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
	}

	public void verifyResponseHeader(String testData, String headerName) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
		assertTrue(!response.header(PropertiesCache.getProperty(testData, headerName)).isEmpty());
	}
	
	public void createSystemWithAlias(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("name", PropertiesCache.setProperty(testData, "name"));
		ja.put(mapValue);
		jsonObj.put("systemAlias", ja);
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
		jsonObj.put("description", PropertiesCache.setProperty(testData, "description"));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
		APIListener.addLogger(jsonObj.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl"));
	}
	
	public String createSystemBulkWithAlias(String value, String testData, String aliasName) {
		JSONArray ja = new JSONArray(PropertiesCache.getProperty(testData, value));
		JSONObject ja1= ja.getJSONObject(0);
		JSONObject ja2= ja.getJSONObject(1);
		JSONArray ja0 = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("name", PropertiesCache.setProperty(testData, "name"));
		setDataToProperty(testData,"systemB",PropertiesCache.getProperty(testData, "name"));
		ja0.put(mapValue);
		ja1.put("systemAlias", ja0);
		ja1.put("name", PropertiesCache.setProperty(testData, "name"));
		setDataToProperty(testData,"aliasB",PropertiesCache.getProperty(testData, "name"));
		ja1.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
		ja1.put("description", PropertiesCache.setProperty(testData, "description"));
		JSONArray jaa1 = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue1 = new HashMap<String, Comparable>();
		mapValue1.put("name", PropertiesCache.getProperty(testData, aliasName));
		jaa1.put(mapValue1);
		ja2.put("systemAlias", jaa1);
		ja2.put("name", PropertiesCache.setProperty(testData, "name"));
		setDataToProperty(testData,"systemC",PropertiesCache.getProperty(testData, "name"));
		ja2.put("vendor", PropertiesCache.setProperty(testData, "vendor"));
		ja2.put("description", PropertiesCache.setProperty(testData, "description"));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsBulkUrl"));
		APIListener.addLogger(ja.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(ja.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsBulkUrl"));
		return ja.toString();
	}

	public void updateSystemBulkWithAlias(String value, String testData, String aliasName) {
		JSONArray ja = new JSONArray(value);
		JSONObject ja2= ja.getJSONObject(1);
		JSONArray jaa1 = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue1 = new HashMap<String, Comparable>();
		mapValue1.put("name", aliasName);
		jaa1.put(mapValue1);
		ja2.put("systemAlias", jaa1);
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsBulkUrl"));
		APIListener.addLogger(ja.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(ja.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsBulkUrl"));
	}
	
	public void deleteSystems(String testData, String id) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "SystemsUrl") + "/"
						+ PropertiesCache.getProperty(testData, id));
	}

}
