package com.plutoraapi.pagerepo;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class OrganizationsPage extends RestAPIGenericUtilLib{
	public void getOrganizations(String testData) {
		/*APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "TEBRUrl"));*/
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "OrganizationsUrl"));
	}
	public void verifyOrganizations(String testData) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, "OrganizationsUrl"));
	}

	
} 
