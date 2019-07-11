package com.plutoraapi.pagerepo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class RequirementsPage extends RestAPIGenericUtilLib{

	static String data,data1 = null;

	public void createRequirement(String value, String testData) throws InterruptedException {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.setProperty(testData, "identifier"));
		jsonObj.put("name", PropertiesCache.setProperty(testData, "name"));
		APIListener.addLogger(jsonObj.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
		Thread.sleep(2000);
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
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseUrl"));
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

	public void createReleasePhase(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, "id")+"/phases");
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, "id")+"/phases");
	}

	public void createReleaseGates(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, "id")+"/gates");
	}

	public void createReleaseStakeholders(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+PropertiesCache.getProperty(testData, "id")+"/stakeholders");
	}

	public void updateReleasePhaseData(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "PhaseId"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/phases/"
						+ PropertiesCache.getProperty(testData, "PhaseId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/phases/"
						+ PropertiesCache.getProperty(testData, "PhaseId"));
	}
	
	public void getReleasePhaseData(String testData) {
		/*JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "PhaseId"));*/
		APIListener.addLogger("GetPhase: "+PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/phases/"
						+ PropertiesCache.getProperty(testData, "PhaseId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.request().get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/phases/"
						+ PropertiesCache.getProperty(testData, "PhaseId"));
	}
	
	public void updateReleaseGatesData(String value, String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "GatesId"));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/gates/"
						+ PropertiesCache.getProperty(testData, "GatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/gates/"
						+ PropertiesCache.getProperty(testData, "GatesId"));
	}
	
	public void getReleaseGatesData(String testData) {
		APIListener.addLogger("GetGates: "+PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/gates/"
						+ PropertiesCache.getProperty(testData, "GatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.request().get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")+ PropertiesCache.getProperty(testData, "id")+"/gates/"
						+ PropertiesCache.getProperty(testData, "GatesId"));
	}

	public void releasePostActivity(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/activities");
	}

	public void verifyReleaseGetActivity(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/activities");
	}

	public void verifyReleaseGetActivityWithActivityId(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/activities/"
						+ PropertiesCache.getProperty(testData, "activityId"));
	}

	public void verifyReleasePutActivity(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/activities/"
						+ PropertiesCache.getProperty(testData, "activityId"));
	}

	public void releasePostCriteria(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("id", PropertiesCache.getProperty(testData, "id"));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workGatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/criterias");
	}

	public void verifyReleaseGetCriteriaWithCriteriaId(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/criteria/"
						+ PropertiesCache.getProperty(testData, "criteriaId"));
	}

	public void verifyReleasePutCriteria(String value,String testData) {
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.put("identifier", PropertiesCache.getProperty(testData, "identifier"));
		jsonObj.put("assignedWorkItemID", PropertiesCache.getProperty(testData, "workGatesId"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().put(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseUrl")
						+ PropertiesCache.getProperty(testData, "id")+"/criterias/"
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
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
	}

	public void filterValuesForReleaseData(String value, String testData, String propertyName,String driectionName,String valueId,String operatorName) {

		//JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
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
		APIListener.addLogger(jsObject.toString());
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, "ReleaseFilterUrl"));
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
	
	
	
	
	
}
