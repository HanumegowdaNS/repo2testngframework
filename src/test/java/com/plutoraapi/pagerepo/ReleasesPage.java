package com.plutoraapi.pagerepo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ReleasesPage extends RestAPIGenericUtilLib{

	static String data,data1 = null;

	public void createRelease(String value, String testData) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier")); 
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		//APIListener.addLogger(response.asString().toString());
		Thread.sleep(5000);
	}

	public void createReleases(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier1"));
		//jsonObj.put("name", PropertiesCache.setProperty(testData, "name1"));
		/*APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
	}

	public void getReleases(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
	}

	public void verifyRelease(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void updateRelease(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request()
				.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	public void deleteRelease(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl") + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}

	public void createReleasePhase(String value, String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, releaseId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)+"/phases");
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData,releaseId)+"/phases");
	}

	public void createReleaseGates(String value, String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, releaseId));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)+"/gates");
	}

	public void createReleaseStakeholders(String value, String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, releaseId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData,releaseId )+"/stakeholders");
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)+"/stakeholders");
	}

	public void releasePostActivity(String value,String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workId"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)+"/activities");
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/activities");
		System.out.println(response.asString());
	}

	public void verifyReleaseGetActivity(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/activities");
	}

	public void verifyReleaseGetActivityWithActivityId(String testData,String releaseId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/activities/"
						+ PropertiesCache.getProperty(testData, "activityId"));
	}

	public void verifyReleasePutActivity(String value,String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/activities/"
						+ PropertiesCache.getProperty(testData, "activityId"));
	}

	public void releasePostCriteria(String value,String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, releaseId));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workGatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/criterias");
	}

	public void verifyReleaseGetCriteriaWithCriteriaId(String testData,String releaseId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/criteria/"
						+ PropertiesCache.getProperty(testData, "criteriaId"));
	}

	public void verifyReleasePutCriteria(String value,String testData,String releaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workGatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)+"/criterias/"
						+ PropertiesCache.getProperty(testData, "criteriaId"));
	}

	public void filterValueForReleaseData(String value, String testData, String propertyName,String driectionName,String valueId,String operatorName) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("filterOrder", 0);
		mapValue.put("property", propertyName);
		mapValue.put("direction", driectionName);
		mapValue.put("value", PropertiesCache.getProperty(testData, valueId));
		mapValue.put("operator", operatorName);
		ja.put(mapValue);
		jsonObj.put("searchFilters", ja);
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
		APIListener.addLogger(jsonObj.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
	}

	public void filterValuesForReleaseData(String value, String testData, String propertyName,String driectionName,String valueId,String operatorName) {

		String[] valueIds = null;
		valueIds = valueId.split(";");
		JSONObject jsObject = new JSONObject();
		jsObject.put("pagesize", 0);
		jsObject.put("page", 0);
		JSONObject jsObject1 = new JSONObject();
		jsObject1.put("property", propertyName);
		jsObject1.put("filterOrder", 0);
		jsObject1.put("operator", operatorName);
		jsObject1.put("direction", driectionName);
		if (valueIds.length>=0) {
			//APIListener.addLogger(PropertiesCache.getProperty(testData, valueIds[0])+PropertiesCache.getProperty(testData, valueIds[1]));
			jsObject1.append("values",PropertiesCache.getProperty(testData, valueIds[0]));
			jsObject1.append("values",PropertiesCache.getProperty(testData, valueIds[1]));
		}
		JSONArray ja = new JSONArray();
		ja.put(jsObject1);
		jsObject.put("searchFilters", ja);
		/*APIListener.addLogger(jsObject.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsObject.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
	}

	public void getAndSetArrayData(String testData,String parameter) {

		//APIListener.addLogger(response.asString());
		JSONArray ja = new JSONArray(response.asString());
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jsonData = ja.getJSONObject(i); 
			String idValue = jsonData.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, "id"))) {
				//APIListener.addLogger("inside:"+idValue);
				String item = parameter;
				String[] items = item.split(";");
				for (int j = 0; j < items.length; j++) {
					if (j==0) {
						data = jsonData.getString(items[j])+";";
					} else {
						data = data+jsonData.getString(items[j])+";";
					}
				}
				//APIListener.addLogger("colon data--: "+data);
				setDataToProperty(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""));
			}

		}

	}
	/*public void getAndSetArrayData(String testData,String parameter) {

		//APIListener.addLogger(response.asString());
		List<String> str =response.jsonPath().getList("resultSet");
		//System.out.println("ja value####" +str);
		JSONArray ja = new JSONArray(str);
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jsonData = ja.getJSONObject(i); 
			String idValue = jsonData.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, "id"))) {
				//APIListener.addLogger("inside:"+idValue);
				String item = parameter;
				String[] items = item.split(";");
				for (int j = 0; j < items.length; j++) {
					if (j==0) {
						data = jsonData.getString(items[j])+";";
					} else {
						data = data+jsonData.getString(items[j])+";";
					}
				}
				//APIListener.addLogger("colon data--: "+data);
				setDataToProperty(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""));
			}

		}

	}*/
	//JSONArray ja = new JSONArray(response.jsonPath().getObject("resultSet",));
	public void getAndSetArrayData(String testData,String parameter,String idParameter) {

		JSONArray ja1 = new JSONArray(response.asString());
		for (int i = 0; i < ja1.length(); i++) {
			JSONObject jsonData1 = ja1.getJSONObject(i); 
			String idValue = jsonData1.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, idParameter))) {
				//APIListener.addLogger("inside:"+idValue);
				String item = parameter;
				String[] items = item.split(";");
				for (int j = 0; j < items.length; j++) {
					if (j==0) {
						data1 = jsonData1.getString(items[j])+";";
					} else {
						data1 = data1+jsonData1.getString(items[j])+";";
					}
				}
				//APIListener.addLogger("colon data1: "+data1);
				setDataToPropertys(PlutoraAPIConfiguration.testData, item, data1.replaceAll("; $", ""));
			}

		}

	}

	public void createReleaseSystem(String value, String testData,String systemId) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("systemId", PropertiesCache.getProperty(testData, systemId));
		APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		Thread.sleep(2000);
	}

	public void verifyReleaseSystem(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
	}

	public void verifyReleaseSystemWithSystemId(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "systemId"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "systemId").substring(1, PropertiesCache.getProperty(testData, "systemId").length()-1));
	}

	public void deleteRelease(String testData, String id) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl") + "/"
						+ PropertiesCache.getProperty(testData, id));
	}

	public void verifyRelease(String testData, String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, url));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, url));
	}

	public void verifyRelease(String testData, String url,String id) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, id)
				+ PropertiesCache.getProperty(testData, url));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, id)
						+ PropertiesCache.getProperty(testData, url));
	}

	public void addSystemToRelease(String value, String testData) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("systemId", PropertiesCache.getProperty(testData, "systemId"));
		APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		Thread.sleep(2000);
		APIListener.addLogger(response.toString());
	}
	
	public void addSystemToRelease(String value, String testData, String releaseId, String systemId) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("systemId", PropertiesCache.getProperty(testData, systemId));
	//	APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl"));
		Thread.sleep(2000);
		APIListener.addLogger(response.asString());
	}

	public void verifyReleaseLinkedItems(String testData, String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, url));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, url));
	}

	public void createDeploymentDates(String value, String testData){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(response.asString());
	}
	
	public void createDeploymentDates(String value, String testData, String releaseId, String systemId){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, systemId)
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
	}
	
	public void createDeploymentDatesInvalidStartDate(String value, String testData){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("startDate", PropertiesCache.getProperty(testData, "DeploymentDateInvalidStart4400Date"));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(jsonObj.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
	}
	
	public void createDeploymentDatesWithStatus(String value, String testData, String statusName){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
	}
	
	public void createDeploymentDatesWithStatus(String value, String testData, String statusName, String releaseId, String systemId){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, systemId)
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
	}
	
	public void deleteReleaseDeploymentDate(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
						+ PropertiesCache.getProperty(testData, "deploymentDate"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.delete(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
						+ PropertiesCache.getProperty(testData, "deploymentDate"));
	}
	
	public void updateDeploymentInvalidStartDate(String value, String testData){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "deploymentDate1"));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("startDate", PropertiesCache.getProperty(testData, "DeploymentDateInvalidStart4400Date"));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
				+ PropertiesCache.getProperty(testData, "deploymentDate1"));*/
		//APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
								+ PropertiesCache.getProperty(testData, "deploymentDate1"));
	}
	
	
	public void updateDeploymentDatesWithStatus(String value, String testData, String statusName){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "deploymentDate1"));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
				+ PropertiesCache.getProperty(testData, "deploymentDate1"));
		APIListener.addLogger(jsonObj.toString());*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
								+ PropertiesCache.getProperty(testData, "deploymentDate1"));
	}
	
	public void updateDeploymentDates(String value, String testData, String statusName){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "deploymentDate1"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "releaseID")
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, "addedSystemId")
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
				+ PropertiesCache.getProperty(testData, "deploymentDate1"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "releaseID")
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, "addedSystemId")
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
								+ PropertiesCache.getProperty(testData, "deploymentDate1"));
	}
	
	public void updateDeploymentDatesWithStatus(String value, String testData, String statusName, String releaseId, String systemId, String deploymentDate){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, deploymentDate));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, systemId)
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
						+ PropertiesCache.getProperty(testData, deploymentDate));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, systemId)
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
								+ PropertiesCache.getProperty(testData, deploymentDate));
	}
	
	
	public void createRelease(String value, String testData, String releaseType, String projectType) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		jsonObj.put("plutoraReleaseType", releaseType);
		jsonObj.put("releaseProjectType", projectType);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		Thread.sleep(5000);
	}
	
	public void updateDeploymentDatesWithSortOrder(String value, String testData, String statusName, String releaseId, String systemId, String deploymentDate, String sortOrder){
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, deploymentDate));
		jsonObj.put("deploymentTitle", PropertiesCache.setProperty(testData, "deploymentTitle"));
		jsonObj.put("deploymentStatus", PropertiesCache.getProperty(testData, statusName));
		jsonObj.put("sortOrder", sortOrder);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, systemId)
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
						+ PropertiesCache.getProperty(testData, deploymentDate));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, systemId)
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl")
						+ PropertiesCache.getProperty(testData, deploymentDate));
	}
	
	public void verifyDeploymentDates(String testData, String releaseId, String systemId){
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
				+ PropertiesCache.getProperty(testData, systemId)
				+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.request().get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "createReleaseSystemUrl")+"/"
						+ PropertiesCache.getProperty(testData, systemId)
						+ PropertiesCache.getProperty(testData, "createDeploymentDateUrl"));
	}
	
	public void updateLinkedReleases(String value, String testData, String url){
		JSONObject jsonObj = new JSONObject(response.asString());
		JSONArray ja = jsonObj.getJSONArray("childReleases");
		JSONObject jo=ja.getJSONObject(0);
		jo.put("id", PropertiesCache.getProperty(testData, "childId"));
		jo.put("name", PropertiesCache.getProperty(testData, "childName"));
		jo.put("identifier", PropertiesCache.getProperty(testData, "childIdentifer"));
		
		JSONArray ja1 = jsonObj.getJSONArray("parentReleases");
		JSONObject jo1=ja1.getJSONObject(0);
		jo1.put("id", PropertiesCache.getProperty(testData, "parentId"));
		jo1.put("name", PropertiesCache.getProperty(testData, "parentName"));
		jo1.put("identifier", PropertiesCache.getProperty(testData, "parentIdentifier"));
		
		JSONArray ja2 = jsonObj.getJSONArray("relatedReleases");
		JSONObject jo2=ja2.getJSONObject(0);
		jo2.put("id", PropertiesCache.getProperty(testData, "relatedId"));
		jo2.put("name", PropertiesCache.getProperty(testData, "relatedName"));
		jo2.put("identifier", PropertiesCache.getProperty(testData, "relatedIdentifier"));
		
		APIListener.addLogger(jsonObj.toString());
		
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, url));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, url));
	}
	
	public void verifyReleaseWithId(String testData, String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id")+"/"
				+ PropertiesCache.getProperty(testData, url));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/"
						+ PropertiesCache.getProperty(testData, url));
	}
	
	public void getReleasesStakeholders(String testData, String id) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, id)
				+ PropertiesCache.getProperty(testData, "StakeholderGetUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, id)
						+ PropertiesCache.getProperty(testData, "StakeholderGetUrl"));
	}
	
	public void updateReleasesStakeholders(String value, String testData, String releaseId, String stakeholderId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("userId", PropertiesCache.getProperty(testData, stakeholderId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, "StakeholderGetUrl") + "/"
				+ PropertiesCache.getProperty(testData, stakeholderId));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, releaseId)
						+ PropertiesCache.getProperty(testData, "StakeholderGetUrl") + "/"
						+ PropertiesCache.getProperty(testData, stakeholderId));
	}
	
	public void createReleaseWithCustomField(String value, String testData, String customField) throws InterruptedException {
		//JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("id", PropertiesCache.getProperty(testData, customField));
		ja.put(mapValue);
		jsonObj.put("additionalInformation", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		Thread.sleep(5000);
	}
	
	public void updateReleaseWithCustomField(String value,String testData, String customField) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("id", PropertiesCache.getProperty(testData, customField));
		ja.put(mapValue);
		jsonObj.put("additionalInformation", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")
				+ PropertiesCache.getProperty(testData, "id"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request()
				.put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id"));
	}
	

	public void getReleaseChange(String testData, String releaseId,String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)
				+ PropertiesCache.getProperty(testData, url));
	
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, releaseId)+
					 PropertiesCache.getProperty(testData, url));
		System.out.println(response.asString());
	}

	public void updateReleasePhaseData(String value, String testData,String releaseId, String phaseId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/phases/"
				+ PropertiesCache.getProperty(testData, "PhaseId"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, releaseId)+"/phases/"
						+ PropertiesCache.getProperty(testData, phaseId));
	}

	public void getReleasePhaseData(String testData,String releaseId,String phaseId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.request().get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, releaseId)+"/phases/"
						+ PropertiesCache.getProperty(testData, phaseId));
	}

	public void updateReleaseGatesData(String value, String testData,String releaseId,String gateId) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, releaseId)+"/gates/"
						+ PropertiesCache.getProperty(testData, gateId));
	}

	public void getReleaseGatesData(String testData,String releaseId,String gateId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.request().get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, releaseId)+"/gates/"
						+ PropertiesCache.getProperty(testData, gateId));
	}
}
