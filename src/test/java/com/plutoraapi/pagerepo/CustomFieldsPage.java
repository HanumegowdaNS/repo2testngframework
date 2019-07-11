package com.plutoraapi.pagerepo;

import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

import io.restassured.RestAssured;

public class CustomFieldsPage extends RestAPIGenericUtilLib {

		public void getCustomFields(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldsUrl"));
		} 

        public void getCustomFieldsByType(String testData, String customType) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customType));
		}
        
        
		public void getCustomFieldsByID(String testData, String customTypeId) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customTypeId));
		}
		
		public void getCustomFieldsCustomList(String testData, String customTypeId) {
			APIListener.addLogger((PropertiesCache.getProperty(testData, "API_RequestUrl")
					+ PropertiesCache.getProperty(testData, "CustomFieldsUrl") + "/"
					+ PropertiesCache.getProperty(testData, customTypeId)+ "/" + PropertiesCache.getProperty(testData, "CustomListUrl")));
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customTypeId)+ "/" + PropertiesCache.getProperty(testData, "CustomListUrl"));
		}
		public void getCustomFieldGroups(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldGroupsUrl"));
		} 

        public void getCustomFieldGroupsByType(String testData, String customType) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customType));
		}
        
        
		public void getCustomFieldGroupsByID(String testData, String customTypeId) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldGroupsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customTypeId));
		}	
		
		public void getCustomFieldTabs(String testData) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldTabsUrl"));
		} 

        public void getCustomFieldTabsByType(String testData, String customType) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldTabsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customType));
		}
        
        
		public void getCustomFieldTabsByID(String testData, String customTypeId) {
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + PropertiesCache.getProperty(testData, "access_token")).request()
					.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
							+ PropertiesCache.getProperty(testData, "CustomFieldTabsUrl") + "/"
							+ PropertiesCache.getProperty(testData, customTypeId));
		}	
}
