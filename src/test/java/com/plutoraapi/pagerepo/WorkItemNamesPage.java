package com.plutoraapi.pagerepo;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class WorkItemNamesPage extends RestAPIGenericUtilLib {
	
	public void getWorkItemNamesPhases(String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "WorkItemNamesPhases_PaginationFilterURL"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "WorkItemNamesPhases_PaginationFilterURL"));
	}
	public void getWorkItemNamesGates(String testData) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "WorkItemNamesGates_PaginationFilterURL"));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "WorkItemNamesGates_PaginationFilterURL"));
	}
}
