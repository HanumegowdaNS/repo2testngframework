package com.plutoraapi.pagerepo;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class LookupFieldsPage extends RestAPIGenericUtilLib {

	public void verifyLookupFields(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LookupFieldsUrl"));
	} 

	public void verifyLookupFieldsByID(String testData, String typeId) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LookupFieldsUrl") + "/"
						+ PropertiesCache.getProperty(testData, typeId));
	}

	public void verifyLookupFieldsByType(String testData, String lookupType) {
		
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LookupFieldsUrl") + "/"
						+ PropertiesCache.getProperty(testData, lookupType));
	}

	public void getLookupFields(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "TEBRUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "LookupFieldsUrl"));
	}
}
