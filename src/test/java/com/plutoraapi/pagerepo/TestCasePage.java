package com.plutoraapi.pagerepo;

import com.plutora.utils.RestAPIGenericUtilLib;

public class TestCasePage extends RestAPIGenericUtilLib{

	static String data,data1 = null;
	
	/*public void searchTestCase(String value, String testData) throws InterruptedException {
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
*/
	
	
}
