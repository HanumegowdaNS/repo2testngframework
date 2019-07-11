package com.plutora.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutoraapi.pagerepo.ReleasesPage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

import static org.testng.Assert.assertNotEquals;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class RestAPIGenericUtilLib {
	boolean flag=false;
	static String data,data1 = null;
	public static List<String> operatorList = new ArrayList<String>();
	public static List<String> lookupFieldList = new ArrayList<String>();
	public static List<String> organizationsList = new ArrayList<String>();
	public static List<String> organizationsTreeList = new ArrayList<String>();
	public static List<String> workItemNamePhaseList = new ArrayList<String>();
	public static List<String> workItemNameGateList = new ArrayList<String>();
	public static List<String> usersList = new ArrayList<String>();
	public static List<String> usersUserGroupsList=new ArrayList<String>();
	public static String expectedList;
	public static Response response;
	/******************Rest Assured*************************/
	public void verifyStatusCode(String statusCode,String testData){
		int actualValue=response.getStatusCode();
		int expectedValue=Integer.valueOf(PropertiesCache.getProperty(testData, statusCode));
		assertEquals(actualValue, expectedValue); 
		APIListener.addLogger("Status Code :"+actualValue+" is equal to "+expectedValue); 
	}

	public void verifyResponseNotEmpty(String values) {
		if (values.contains(";")) {   
			
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				assertTrue(!response.path(value[i]).toString().isEmpty());
				APIListener.addLogger( value[i] + " is not blank");
			} 
		} else {
			assertTrue(!response.path(values).toString().isEmpty());
			APIListener.addLogger( values + " is not blank");
		}
	}

	public void verifyResponseValue(String values,String testData) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				String data =PropertiesCache.getProperty(testData, value[i]);
				assertEquals(response.path(value[i]).toString(),data) ;			
				APIListener.addLogger( "Parameter : "+response.path(value[i])+ " is equals to "+data);
			}
		}else {
			String data=PropertiesCache.getProperty(testData, values);
			assertEquals(response.path(values).toString(),data) ;						
			APIListener.addLogger( "Parameter : "+response.path(values)+ " : is equals to "+data);
		}
	}

	public void verifyResponseArrayValue(String values,String testData) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				String data =PropertiesCache.getProperty(testData, value[i]);
				assertEquals(response.path(value[i]).toString().substring(1, response.path(value[i]).toString().length()-1),data) ;			
				APIListener.addLogger( "Parameter : "+response.path(value[i])+ " is equals to "+data);
			}
		}else {
			String data=PropertiesCache.getProperty(testData, values);
			assertEquals(response.path(values).toString().substring(1, response.path(values).toString().length()-1),data) ;						
			APIListener.addLogger( "Parameter : "+response.path(values)+ " : is equals to "+data);
		}
	}

	public void verifyResponseArrayData(String values,String testData) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				String data =PropertiesCache.getProperty(testData, value[i]);
				data = data.substring(1, data.length()-1);
				assertEquals(response.path(value[i]).toString(),data) ;			
				APIListener.addLogger( "Parameter : "+response.path(value[i])+ " is equals to "+data);
			}
		}else {
			String data=PropertiesCache.getProperty(testData, values);
			data = data.substring(1, data.length()-1);
			assertEquals(response.path(values).toString(),data) ;						
			APIListener.addLogger( "Parameter : "+response.path(values)+ " : is equals to "+data);
		}
	}

	public void verifyDataWithOperator(String actualData, String expectedData, String operatorName) throws ParseException {

		if (operatorName.equals("Equals")) {
			assertEquals(actualData,expectedData) ;			
		} else if(operatorName.equals("NotEquals")) {
			assertNotEquals(actualData,expectedData) ;			
			APIListener.addLogger("Parameter : "+actualData+ " is not equals to "+expectedData);
		} else if(operatorName.equals("Contains")) {
			assertTrue(expectedData.toLowerCase().contains(actualData.toLowerCase())) ;			
			APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
		} else if(operatorName.equals("IsWithIn")) {
			assertTrue(expectedData.toLowerCase().contains(actualData.toLowerCase())) ;			
			APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
		} else if(operatorName.equals("NotContains")) {
			APIListener.addLogger("Parameter : "+actualData+ " is not contains to "+expectedData);
			assertTrue(!(expectedData.toLowerCase().contains(actualData.toLowerCase()))) ;			
			APIListener.addLogger("Parameter : "+actualData+ " is not contains to "+expectedData);
		} else if(operatorName.equals("GreaterThan")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			assertTrue(expectedDate.compareTo(actualDate)>0) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
		} else if(operatorName.equals("GreaterThanNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			assertTrue(expectedValue > actualValue) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
		} else if(operatorName.equals("GreaterOrEqual")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			assertTrue(expectedDate.compareTo(actualDate)>=0) ;	
			APIListener.addLogger("Parameter : "+actualData+ " is greater than or equal "+expectedData);
		} else if(operatorName.equals("GreaterOrEqualNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			assertTrue(expectedValue >= actualValue) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than or equal "+actualData);
		} else if(operatorName.equals("LessThan")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			APIListener.addLogger(expectedDate+""+actualDate+(expectedDate.compareTo(actualDate)));
			assertTrue(expectedDate.compareTo(actualDate)<0) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than "+actualData);
		} else if(operatorName.equals("LessThanNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			assertTrue(expectedValue < actualValue) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than "+actualData);
		} else if(operatorName.equals("LessOrEqualNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			assertTrue(expectedValue <= actualValue) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		} else if(operatorName.equals("LessOrEqual")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			assertTrue(expectedDate.compareTo(actualDate)<=0) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		} else if(operatorName.equals("ANDOR")) {
			assertEquals(actualData,expectedData) ;	
			assertEquals(actualData,expectedData) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		} else if(operatorName.equals("OR")) {
			assertEquals(actualData,expectedData) ;	
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		}

	}

	public void verifyResponseArrayValue(String values,String testData,String operatorName) throws ParseException {
		String actualData;
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				String expectedData =PropertiesCache.getProperty(testData, value[i]);
				actualData   = response.path(value[i]).toString();
				actualData = actualData.substring(1,actualData.length()-1);
				String[] actualDatas = actualData.split(",");
				if (!(actualDatas.length==1)) {
					for (int j = 0; j < actualDatas.length; j++) {
						
						verifyDataWithOperator(expectedData.trim(),actualDatas[j].trim(),operatorName);	
					}
					APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
				} else {
					verifyDataWithOperator(expectedData.trim(),actualData.trim(),operatorName);	
				}	
			}
		}else {
			String expectedData =PropertiesCache.getProperty(testData, values);
			String data = "resultSet."+values;
			System.out.println(response.asString());
		    //String data = values;
			List<String> jsonResponse = response.jsonPath().getList(data);
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
				}

			} else {
				verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
			}
		}
	}

	public void verifyResponseArrayValue(String values,String testData,String operatorName,String dataString) throws ParseException {
		String actualData;
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				String expectedData =PropertiesCache.getProperty(testData, value[i]);
				actualData   = response.path(value[i]).toString();
				actualData = actualData.substring(1,actualData.length()-1);
				APIListener.addLogger("Test Data: "+ expectedData);
				APIListener.addLogger("response.path(value[i]: "+actualData);
				String[] actualDatas = actualData.split(",");
				if (!(actualDatas.length==1)) {
					for (int j = 0; j < actualDatas.length; j++) {
						verifyDataWithOperator(expectedData.trim(),actualDatas[j].trim(),operatorName);	
					}
					APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
				} else {
					verifyDataWithOperator(expectedData.trim(),actualData.trim(),operatorName);	
				}	
			}
		}else {
			String expectedData =PropertiesCache.getProperty(testData, values);
			List<String> jsonResponse = response.jsonPath().getList(dataString);
			APIListener.addLogger(jsonResponse.size());
			if (jsonResponse.size()<=0) {
				APIListener.addLogger( "No records available for "+ operatorName +" search with '"+expectedData+"'");
				Assert.assertTrue(false);
			} else if (jsonResponse.size()>1) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
				}
			} else {
				verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
			}
		}
	}

	public List<String> getListOfData(String testData, String dataString) {
		List<String> jsonResponse = response.jsonPath().getList(dataString);
		APIListener.addLogger(jsonResponse.size());
		return jsonResponse;
	}
	
	public String getListOfListData(String testData, String dataString) {
		List<List<String>> jsonResponse = response.jsonPath().getList(dataString);
		String [][] array = new String[jsonResponse.size()][];
		String[] list=new String[0];
		array[0]=jsonResponse.get(0).toArray(list);
		APIListener.addLogger("user roleId----"+array[0][0]);
		return array[0][0];
	}
	
	public void verifyResponseArrayValues(String values,String testData) {
		String actualData;
		boolean containsFlag = false;
		if (values.contains(";")) {
			String[] value = values.split(";");
			String expectedData =PropertiesCache.getProperty(testData, value[0]);
			String expectedData1 =PropertiesCache.getProperty(testData, value[1]);
			actualData   = response.path(value[0]).toString();
			actualData = actualData.substring(1,actualData.length()-1);
			String[] actualDatas = actualData.split(",");
			if (!(actualDatas.length==1)) {
				for (int j = 0; j < actualDatas.length; j++) {
					if (actualDatas[j].trim().contains(expectedData.trim()) || actualDatas[j].trim().contains(expectedData1.trim())) {
						containsFlag = true;
					} else {
						containsFlag = false;
					}
					APIListener.addLogger("Parameter : "+actualDatas[j].trim()+ " is contains to "+expectedData+" or "+expectedData1);
				}
				assertTrue(containsFlag) ;	
				APIListener.addLogger( "Parameter : "+actualData+ " is contains to "+expectedData+" or "+expectedData1);
			} else {
				if (actualData.trim().contains(expectedData.trim()) || actualData.trim().contains(expectedData1.trim())) {
					containsFlag = true;
				} else {
					containsFlag = false;
				}
				assertTrue(containsFlag) ;	
				APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
				APIListener.addLogger( "Parameter : "+actualData+ " is contains to "+expectedData);
			}	
		}else {
			String expectedData =PropertiesCache.getProperty(testData, values);
			actualData   = response.path(values).toString();
			actualData = actualData.substring(1,actualData.length()-1);
			String[] actualDatas = actualData.split(",");
			if (!(actualDatas.length==1)) {
				for (int j = 0; j < actualDatas.length; j++) {
					assertEquals(actualDatas[j].trim(),expectedData.trim()) ;
					if (actualDatas[j].trim().contains(expectedData.trim())) {
						containsFlag = true;
					} else {
						containsFlag = false;
					}
				}
				assertTrue(containsFlag) ;	
				APIListener.addLogger( "Parameter : "+actualData+ " is contains to "+expectedData);
			} else {
				if (actualData.trim().contains(expectedData.trim())) {
					containsFlag = true;
				} else {
					containsFlag = false;
				}
				assertTrue(containsFlag) ;	
				APIListener.addLogger( "Parameter : "+actualData+ " is contains to "+expectedData);
			}
		}
	}


	public void verifyMapResponseValue(String dataValue, String keys, String testData) {

		Map<String, String> mapValue = response.jsonPath().getMap(dataValue);
		if (keys.contains(";")) {
			String[] value = keys.split(";");
			for (int i = 0; i < value.length; i++) {
				String data = PropertiesCache.getProperty(testData, value[i]);
				assertEquals(mapValue.get(value[i]), data);
				APIListener.addLogger( "Parameter : " + mapValue.get(value[i]) + " : is equals to " + data);
			}
		} else {
			String data = PropertiesCache.getProperty(testData, keys);
			assertEquals(mapValue.get(keys), data);
			APIListener.addLogger( "Parameter : " + mapValue.get(keys) + " : is equals to " + data);
		}

	}

	public void verifyXpathAttributeValues(String resourceUrl,String resourcePath,String xpath,String value){
		try{
			response.
			then().
			body(xpath,equalTo(value));
			assertTrue(true);
		}catch(AssertionError e){
			assertTrue(false);
		}
	}

	public void verifyHasItemFunction(String resourceUrl,String resourcePath,String xpath,String value){

		try{
			String[] str=value.split(",");
			for(int i=0;i<str.length;i++){
				response.
				then().body(xpath,hasItem(str[i]));
			}
			assertTrue(true);
		} catch(AssertionError e){
			assertTrue(false);
		}
	}

	public boolean verifyRestAPIExtractDetailsUsingPath(String baseUrl,String resourcePath,String param1,String param1Vale,String param2,String statusCode){
		try{
			String href= RestAssured.when().
					get(baseUrl+resourcePath).
					then().
					contentType(ContentType.JSON).
					body(param1,equalTo(param1Vale)).extract().path(param2);

			RestAssured.when().get(href).then().statusCode(Integer.valueOf(statusCode));

			return true;
		} catch(AssertionError e){

			return false;
		}
	}


	public boolean verifyRestAPIItemFromList(String resourcePath,String xpath,String item){
		try{
			String response = RestAssured.get(resourcePath).asString();
			List<String> ls = JsonPath.from(response).getList(xpath);

			for(String listName:ls){
				if(listName.equals(item)){
					return true;
				}else{
					flag= true;
				}
			}
			if(flag) {
				return false;
			}
			return true;
		}catch(AssertionError e){
			APIListener.addLogger(e.getMessage());
			return false;
		}
	}

	public boolean verifyRestAPILengthOfResponse(String resourceUrl,String resourcePath,String xpath,String sumCount){
		try{
			RestAssured.given().
			get(resourceUrl+resourcePath).
			then().body("name*.length().sum()",greaterThan(Integer.valueOf(sumCount)));
			return true;
		}catch(AssertionError e){
			APIListener.addLogger(e.getMessage());
			return false;
		}

	}

	public String  getRestAPIResponseHeader(String resourcePath,String headerName){
		Response response = RestAssured.get(resourcePath);
		APIListener.addLogger(response.asString());
		return response.getHeader(headerName);
	}

	public Headers getRestAPIResponseHeaders(String resourcePath,String headerName){
		Response response = RestAssured.get(resourcePath);
		return response.getHeaders();
	}

	public Map<String,String>  getRestAPICookie(String resourcePath){
		Response response = RestAssured.get(resourcePath);
		return response.getCookies();
	}

	public boolean verifyRestAPIStatusCodeFromConnectRequest(String resourcePath,String statusCode){
		Response response= RestAssured.when().
				request("CONNECT",resourcePath).
				then()
				.extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}

	public boolean verifyRestAPIStatusCodeFromQueryParameter(String resourceUrl,String resourcePath,String queryParamKey,String queryParamValue,String statusCode){
		Response response= RestAssured.given().
				queryParam(queryParamKey, Integer.parseInt(queryParamValue)).
				when().get(resourceUrl+resourcePath).
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}

	public boolean verifyRestAPIStatusCodeFromFormParameter(String resourcePath,String queryParamKey,String queryParamValue,String statusCode){
		Response response= RestAssured.given().
				formParam(queryParamKey, queryParamValue).
				when().get(resourcePath).
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}
	public boolean verifyRestAPIStatusCodeFromSetParameter(String resourcePath,String queryParamKey,String queryParamValue,String statusCode){
		Response response= RestAssured.given().
				param(queryParamKey, queryParamValue).
				when().get(resourcePath).
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}
	public boolean verifyRestAPIStatusCodeFromSetPathParameter(String resourceUrl,String resourcePath,String queryParamKey,String queryParamValue,String statusCode){
		Response response=RestAssured.given().
				pathParam(queryParamKey, queryParamValue).
				when().post(resourceUrl+resourcePath+"/{"+queryParamKey+"}").
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}
	public boolean verifyRestAPIStatusCodeSetCookieInRequest(String resourcePath,String queryParamKey,String queryParamValue,String statusCode){
		Response response=RestAssured.given().
				cookie(queryParamKey, queryParamValue).
				when().get(resourcePath).
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}
	public boolean verifyRestAPIStatusCodeSetContentTypeInRequest(String resourcePath,String statusCode){
		Response response=RestAssured.given().
				contentType(ContentType.JSON).
				when().get(resourcePath).
				then().extract().response();
		if(response.getStatusCode()==Integer.valueOf(statusCode)){
			return true;
		}else{
			return false;
		}
	}

	public boolean verifyStatusInResponse(String resourcePath,String statusCode,String statusLine1,String statusLine2){
		try{
			RestAssured.given().get(resourcePath).then().assertThat().statusCode(Integer.parseInt(statusCode));
			RestAssured.given().get(resourcePath).then().assertThat().statusLine(statusLine1);
			RestAssured.given().get(resourcePath).then().assertThat().statusLine(statusLine2);
			return true;
		}catch(AssertionError e){
			return false;
		}
	}

	public boolean verifyResponseTimeAssertion(String resourcePath,String time){
		try{
			RestAssured.given().get(resourcePath).then().time(lessThan(Long.parseLong(time)));
			return true;
		}catch(AssertionError e){
			return false;
		}
	}

	public void verifyIntegerText(int value,String testDataValue,String testData) {
		int expectedValue=Integer.parseInt(PropertiesCache.getProperty(testData, testDataValue));
		assertEquals(value,expectedValue);
		APIListener.test1.log(Status.INFO, value+" is equal to "+expectedValue);
	}

	public void verifyText(String value,String testDataValue,String testData) {
		assertEquals(value,PropertiesCache.getProperty(testData, testDataValue));
	}
	
	public void verifyTextData(String testDataValue,String testData) {
		assertEquals(response.asString().trim(),PropertiesCache.getProperty(testData, testDataValue));
	}

	public void setDataToProperty(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				APIListener.addLogger("Value: "+response.path(value[i]).toString());
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,value[i], response.path(value[i]).toString());
			}
		}else {
			APIListener.addLogger("ReleasesPage.response.path(values).toString()"+response.path(values).toString());
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,values, ReleasesPage.response.path(values).toString());
		}

	}
	
	public void setMapValuesToProperty(String data,String key) {
		Map<String, String> mapValue = response.jsonPath().getMap("Data");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,key, mapValue.get(key));
	}

	public void getAuthorizationToken(String testData) {
		response=RestAssured.given().
				header("Content-Type", "application/x-www-form-urlencoded").
				formParam("client_id",PropertiesCache.getProperty(testData, "client_id")).
				formParam("client_secret",PropertiesCache.getProperty(testData, "client_secret")).
				formParam("grant_type",PropertiesCache.getProperty(testData, "grant_type")).
				formParam("username",PropertiesCache.getProperty(testData, "username")).
				formParam("password",PropertiesCache.getProperty(testData, "password")).
				request().post(PropertiesCache.getProperty(testData, "AuthorizationUrl")+PropertiesCache.getProperty(testData, "TokenPath"));

	}

	public void verifyResponseValue(String values,String testData,String items) {
		if (values.contains(";")&& items.contains(";")) {
			String[] value = values.split(";");
			String[] item = items.split(";");
			for (int i = 0; i < value.length; i++) {
				String data =PropertiesCache.getProperty(testData, item[i]);
				APIListener.addLogger("Parameter : "+response.path(value[i])+ " is equals to "+data);
				assertEquals(response.path(value[i]).toString(),data) ;						
				APIListener.addLogger( "Parameter : "+response.path(value[i])+ " is equals to "+data);
			}
		}else {
			String data=PropertiesCache.getProperty(testData, items);
			APIListener.addLogger("Parameter : "+response.path(values)+ " is equals to "+data);
			assertEquals(response.path(values).toString(),data) ;						
			APIListener.addLogger( "Parameter : "+response.path(values)+ " : is equals to "+data);
		}
	}
	
	public void verifyResponseStaticValue(String values,String testData,String items) {
		if (values.contains(";")&& items.contains(";")) {
			String[] value = values.split(";");
			String[] item = items.split(";");
			for (int i = 0; i < value.length; i++) {
				String data =item[i];
				APIListener.addLogger("Parameter : "+response.path(value[i])+ " is equals to "+data);
				assertEquals(response.path(value[i]).toString(),data) ;						
				APIListener.addLogger( "Parameter : "+response.path(value[i])+ " is equals to "+data);
			}
		}else {
			String data =items;
			APIListener.addLogger("Parameter : "+response.path(values)+ " is equals to "+data);
			assertEquals(response.path(values).toString(),data) ;						
			APIListener.addLogger( "Parameter : "+response.path(values)+ " : is equals to "+data);
		}
	}

	public void setDataToProperty(String values,String itemId) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			String[] item = itemId.split(";");
			for (int i = 0; i < value.length; i++) {
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,item[i], response.path(value[i]).toString());
			}
		}else {
			APIListener.addLogger(response.asString());
			APIListener.addLogger(response.path(values).toString());
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,itemId, response.path(values).toString());
			APIListener.addLogger(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,itemId));
		}
	}
	public void setDataToPropertys(String values,String itemId) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			String[] item = itemId.split(";");
			for (int i = 0; i < value.length; i++) {
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,item[i], response.path("resultSet."+value[i]).toString());
			}
		}else {
			APIListener.addLogger(response.asString());
			APIListener.addLogger(response.path(values).toString());
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,itemId, response.path("resultSet."+values).toString());
			APIListener.addLogger(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,itemId));
		}
	}
	public void setDataToPropertysWithoutPage(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				APIListener.addLogger("Value: "+response.path(value[i]).toString());
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,value[i], response.path(value[i].toString()));
			}
		}else {
			APIListener.addLogger("ReleasesPage.response.path(values).toString()"+response.path(values).toString());
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,values, ReleasesPage.response.path(values).toString());
		}
	}
	
	// for result set
	public void setDataToPropertys(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				APIListener.addLogger("Value: "+response.path(value[i]).toString());
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,value[i], response.path("resultSet."+value[i]).toString());
			}
		}else {
			APIListener.addLogger("ReleasesPage.response.path(values).toString()"+response.path("resultSet."+values).toString());
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,values, ReleasesPage.response.path("resultSet."+values).toString());
		}
	}
	public void setDataToProperty(String testData,String itemId,String itemValue) {
		if (itemId.contains(";")) {
			String[] value = itemId.split(";"); 
			String[] item = itemValue.split(";");
			for (int i = 0; i < value.length; i++) {
				PropertiesCache.setProperty(testData,value[i], item[i]);
			}
		}else {
			PropertiesCache.setProperty(testData,itemId, itemValue);
		}
	}

	public void setDataToPropertys(String testData,String itemId,String itemValue) {
		if (itemId.contains(";")) {
			String[] value = itemId.split(";");
			String[] item = itemValue.split(";");
			for (int i = 0; i < value.length; i++) {
				value[i] = value[i]+"1";
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,value[i], item[i]);
				APIListener.addLogger("itemIDs: "+value[i]+"itemValues: "+item[i]);
				APIListener.addLogger(PropertiesCache.getProperty(testData,"id1"));
			}
		}else {
			itemId = itemId+"1";
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,itemId, itemValue);
		}
	}

	public void setDataToPropertys(String testData,String itemId,String itemValue, String compareItems) {
		if (itemId.contains(";")) {
			String[] value = itemId.split(";");
			String[] item = itemValue.split(";");
			String[] compareItem = compareItems.split(";");
			for (int i = 0; i < value.length; i++) {
				value[i] = compareItem[i];
				PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,value[i], item[i]);
			}
		}else {
			itemId = compareItems;
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,itemId, itemValue);
		}
	}

	public Date formateDate(String expectedDate) throws ParseException  {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = format.parse(expectedDate);
		return date;
	}
	
	public Date formateDatePagination(String expectedDate) throws ParseException  {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(expectedDate);
		return date;
	}

	public void filterValueData(String value, String testData, String propertyName,String directionName,String valueId,String operatorName,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		//mapValue.put("filterOrder", 0);
		mapValue.put("property", propertyName);
		mapValue.put("direction", directionName);
		mapValue.put("value", PropertiesCache.getProperty(testData, valueId));
		mapValue.put("operator", operatorName);
		ja.put(mapValue);
		jsonObj.put("searchFilters", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}

	public void filterMultipleValueData(String value, String testData, String propertyName,String directionName,String valueId,String operatorName,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		String valueOrData = null;
		if (valueId.contains(";")) {
			String[] valueIdArray = valueId.split(";");
			valueOrData = valueIdArray[0]+","+PropertiesCache.getProperty(testData, valueIdArray[1]);
		} else {
			valueOrData = PropertiesCache.getProperty(testData, valueId);
		}
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("property", propertyName);
		mapValue.put("direction", directionName);
		mapValue.put("value", valueOrData);
		mapValue.put("operator", operatorName);
		ja.put(mapValue);
		jsonObj.put("searchFilters", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(response.toString());
		
	}

	public void filterSearchFilterValueData(String value, String testData, String propertyName,String directionName,String valueId,String operatorName,
			String propertyName1,String directionName1,String operatorName1,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		String[] values = PropertiesCache.getProperty(testData, valueId).split("_");
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("property", propertyName);
		mapValue.put("direction", directionName);
		mapValue.put("value", values[0]);
		mapValue.put("operator", operatorName);
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue1 = new HashMap<String, Comparable>();
		mapValue1.put("property", propertyName1);
		mapValue1.put("direction", directionName1);
		mapValue1.put("value", values[1]);
		mapValue1.put("operator", operatorName1);
		ja.put(mapValue);
		ja.put(mapValue1);
		jsonObj.put("searchFilters", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}

	public void filterSearchFilterValueData(String value, String testData, String propertyName,String directionName,String valueId,String operatorName,
			String propertyName1,String directionName1,String valueId1,String operatorName1,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("property", propertyName);
		mapValue.put("direction", directionName);
		mapValue.put("value", PropertiesCache.getProperty(testData, valueId));
		mapValue.put("operator", operatorName);
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue1 = new HashMap<String, Comparable>();
		mapValue1.put("property", propertyName1);
		mapValue1.put("direction", directionName1);
		mapValue1.put("value", PropertiesCache.getProperty(testData, valueId1));
		mapValue1.put("operator", operatorName1);
		ja.put(mapValue);
		ja.put(mapValue1);
		jsonObj.put("searchFilters", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}

	public void filterEOValueData(String value, String testData, String propertyName,String operatorName,String valueId,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value)); 
		jsonObj.getJSONObject("ExpandoObject").put("Left", propertyName);
		jsonObj.getJSONObject("ExpandoObject").put("Operator", operatorName);
		jsonObj.getJSONObject("ExpandoObject").put("Right", PropertiesCache.getProperty(testData, valueId));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}

	public void filterEOValueData(String value,String testData,String lleft,String loperator,String lright,String rleft,String roperator,String rright,String moperator,String filterUrl) {

		APIListener.addLogger(PropertiesCache.getProperty(testData, lright));
		APIListener.addLogger(PropertiesCache.getProperty(testData, rright));
		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Left").put("Left", lleft);
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Left").put("Operator", loperator);
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Left").put("Right", lright);
		jsonObj.getJSONObject("ExpandoObject").put("Operator", moperator);
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Right").put("Left", rleft);
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Right").put("Operator", roperator);
		jsonObj.getJSONObject("ExpandoObject").getJSONObject("Right").put("Right", PropertiesCache.getProperty(testData, rright));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}
	
	public void getAndSetJsonData(String testData,String parameter) {
	APIListener.addLogger(response.asString());
		JSONArray ja = new JSONArray(response.asString());
		//APIListener.addLogger(response.asString());
		//List<String> str =response.jsonPath().getList("resultSet");
		//System.out.println("ja value####" +str);
		//JSONArray ja = new JSONArray(str);
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jsonData = ja.getJSONObject(i); 
			String idValue = jsonData.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, "id"))) {
				String item = parameter;
				String[] items = item.split(";");
				for (int j = 0; j < items.length; j++) {
					if (j==0) {
						try {
							data = jsonData.getString(items[j].toString())+";";
						} catch (JSONException  e) {
							if (jsonData.isNull(items[j])) {
								data = data+""+";";
							}else {
								String value = jsonData.getBigInteger(items[j])+"";
								data = data+value.trim()+";";
							}
						}
						data = jsonData.getString(items[j].toString())+";";
					} else {
						try {
							data = data+jsonData.getString(items[j].toString())+";";
						} catch (JSONException  e) {
							if (jsonData.isNull(items[j])) {
								data = data+""+";";
							}else {
								String value = jsonData.getBigInteger(items[j])+"";
								data = data+value.trim()+";";
							}
						}
					}
				}
				setDataToProperty(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""));
			}
		}

	}

	public void getAndSetJsonData(String testData,String parameter,String id) {

		JSONArray ja = new JSONArray(response.asString());
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jsonData = ja.getJSONObject(i); 
			String idValue = jsonData.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, id))) {
				String item = parameter;
				String[] items = item.split(";");
				for (int j = 0; j < items.length; j++) {
					if (j==0) {
						try {
							data = jsonData.getString(items[j].toString())+";"; 
						} catch (JSONException  e) {
							if (jsonData.isNull(items[j])) {
								data = data+""+";";
							}else {
								String value = jsonData.getBigInteger(items[j])+"";
								data = data+value.trim()+";";
							}
						}
						data = jsonData.getString(items[j].toString())+";";
					} else {
						try {
							data = data+jsonData.getString(items[j].toString())+";";
						} catch (JSONException  e) {
							if (jsonData.isNull(items[j])) {
								data = data+""+";";
							}else {
								String value = jsonData.getBigInteger(items[j])+"";
								data = data+value.trim()+";";
							}
						}
					}
				}
				APIListener.addLogger("colon data--: "+data);
				if (!(id=="id")) {
					setDataToPropertys(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""));
				} else {
					setDataToProperty(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""));
				}

			}
		}

	}

	public void getAndSetJsonDatas(String testData,String parameter, String compareParameter) {

		JSONObject jsonData = new JSONObject(response.asString());
		String idValue = jsonData.getString("id");
		if (idValue.equals(PropertiesCache.getProperty(testData, "id"))) {
			String item = parameter;
			String[] items = item.split(";");
			for (int j = 0; j < items.length; j++) {
				if (j==0) {
					data = jsonData.getString(items[j].toString())+";";
				} else {
					data = data+jsonData.getString(items[j].toString())+";";
				}
			}
			setDataToPropertys(PlutoraAPIConfiguration.testData, item, data.replaceAll("; $", ""),compareParameter);
		}
	}

	public void verifyResponseData(String values,String testData,String operatorName) throws ParseException {
		String expectedData =PropertiesCache.getProperty(testData, "id");
		APIListener.addLogger("ExceptedData: "+ expectedData);
		List<String> jsonResponse = response.jsonPath().getList("id");
		APIListener.addLogger(jsonResponse.size());
		int line = 0;
		for (int j = 0; j <= jsonResponse.size(); j++) {
			if (jsonResponse.get(j).trim().equals(expectedData.trim())) {
				line = j;
				break;
			}
		}
		if (line!=0) {
			Map<String, String> mapValue = response.jsonPath().getMap("["+line+"]");
			//APIListener.addLogger(mapValue);
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String data = PropertiesCache.getProperty(testData, value[i]);
					assertEquals(mapValue.get(value[i]), data);
					APIListener.addLogger( "Parameter : " + mapValue.get(value[i]) + " : is equals to " + data);
				}
			} else {
				String data = PropertiesCache.getProperty(testData, values);
				assertEquals(mapValue.get(values), data);
				APIListener.addLogger( "Parameter : " + mapValue.get(values) + " : is equals to " + data);
			}

		}
	}

	public void searchValueData(String value, String testData, String propertyName,String driectionName,String valueId,String operatorName,String filterUrl) {

		JSONObject jsonObj = new JSONObject(PropertiesCache.getProperty(testData, value));
		JSONArray ja = new JSONArray();
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> mapValue = new HashMap<String, Comparable>();
		mapValue.put("property", propertyName);
		mapValue.put("direction", driectionName); 
		mapValue.put("value", PropertiesCache.getProperty(testData, valueId));
		mapValue.put("operator", operatorName);
		ja.put(mapValue);
		jsonObj.put("searchFilters", ja);
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
				+ PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(jsonObj.toString());
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token"))
				.body(jsonObj.toString()).request().post(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, filterUrl));
	}

	public void verifyResponseNotNull(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				assertTrue(!response.path(value[i]).toString().isEmpty() || response.path(value[i]).toString()=="");
				APIListener.addLogger( value[i] + " is not blank");
			}
		} else {
			assertTrue(!response.path(values).toString().isEmpty() || response.path(values).toString()=="");
			APIListener.addLogger( values + " is not blank");
		}
	}

	public void verifyResponseEmpty(String values) {
		assertTrue((response.body().asString() == ""));
		APIListener.addLogger( values + " is empty");
	}
	

	public void verifyResponseValidationMessage(String testData, String message) {
		assertTrue((response.body().asString().contains(PropertiesCache.getProperty(testData, message))));
	}

	public void verifyKeyIsEmpty(String values) {
		Map<String, String> mapValue = response.jsonPath().getMap("");
		Set<String> applicationKeys = mapValue.keySet();
		//APIListener.addLogger(applicationKeys);
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				try {
					assertTrue(!(applicationKeys.contains(value[i])));
					APIListener.addLogger( value[i] + " not displayed in the response");
				} catch (Exception e) {
					APIListener.addLogger( value[i] + " still displayed in the response");
				}
			}
		} else {
			try {
				assertTrue(!(applicationKeys.contains(values)));
				APIListener.addLogger( values + " not displayed in the response");

			} catch (NullPointerException e) {
				APIListener.addLogger( values + " still displayed in the response");
			}
		}
	}

	public void verifyKeyIsEmpty(String values,String recordNumber) {
		Map<String, String> mapValue = response.jsonPath().getMap(recordNumber);
		Set<String> applicationKeys = mapValue.keySet();
		//APIListener.addLogger(applicationKeys);
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				try {
					assertTrue(!(applicationKeys.contains(value[i])));
					APIListener.addLogger( value[i] + " not displayed in the response");
				} catch (Exception e) {
					APIListener.addLogger( value[i] + " still displayed in the response");
				}
			}
		} else {
			try {
				assertTrue(!(applicationKeys.contains(values)));
				APIListener.addLogger( values + " not displayed in the response");

			} catch (NullPointerException e) {
				APIListener.addLogger( values + " still displayed in the response");
			}
		}
	}

	public void verifyMapResponseNullValue(String dataValue, String keys, String testData) {

		Map<String, String> mapValue = response.jsonPath().getMap(dataValue);
		if (keys.contains(";")) {
			String[] value = keys.split(";");
			for (int i = 0; i < value.length; i++) {
				assertTrue(Objects.isNull(mapValue.get(value[i])));
				APIListener.addLogger( "Parameter : " + value[i] + " : is equals to null");
			}
		} else {
			assertTrue(Objects.isNull(mapValue.get(keys)));
			APIListener.addLogger( "Parameter : " + PropertiesCache.getProperty(testData, keys) + " : is equals to null");
		}

	}

	public boolean verifyDataReturnValue(String actualData, String expectedData, String operatorName) throws ParseException {
		boolean flag = false;
		if (operatorName.equals("Equals")) {
			if (actualData.equals(expectedData)) {
				flag = true;
			}
		} else if(operatorName.equals("NotEquals")) {
			if (!(actualData.equals(expectedData))) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+actualData+ " is not equals to "+expectedData);
		} else if(operatorName.equals("Contains")) {
			if (expectedData.toLowerCase().contains(actualData.toLowerCase())) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
		} else if(operatorName.equals("IsWithIn")) {
			if (expectedData.toLowerCase().contains(actualData.toLowerCase())) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
		} else if(operatorName.equals("NotContains")) {
			if (!(expectedData.toLowerCase().contains(actualData.toLowerCase()))) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+actualData+ " is not contains to "+expectedData);
		} else if(operatorName.equals("GreaterThan")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			if (expectedDate.compareTo(actualDate)>0) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
		} else if(operatorName.equals("GreaterThanNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			if (expectedValue > actualValue) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
		} else if(operatorName.equals("GreaterOrEqual")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			if (expectedDate.compareTo(actualDate)>=0) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+actualData+ " is greater than or equal "+expectedData);
		} else if(operatorName.equals("GreaterOrEqualNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			if (expectedValue >= actualValue) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is greater than or equal "+actualData);
		} else if(operatorName.equals("LessThan")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			APIListener.addLogger(expectedDate+""+actualDate+(expectedDate.compareTo(actualDate)));
			if (expectedDate.compareTo(actualDate)<0) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is less than "+actualData);
		} else if(operatorName.equals("LessThanNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			if (expectedValue < actualValue) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is less than "+actualData);
		} else if(operatorName.equals("LessOrEqualNumber")) {
			int actualValue = Integer.valueOf(actualData);
			int expectedValue = Integer.valueOf(expectedData);
			if (expectedValue <= actualValue) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		} else if(operatorName.equals("LessOrEqual")) {
			Date expectedDate = formateDate(expectedData);
			Date actualDate = formateDate(actualData);
			APIListener.addLogger(expectedDate+""+actualDate+(expectedDate.compareTo(actualDate)));
			if (expectedDate.compareTo(actualDate)<=0) {
				flag = true;
			}
			APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
		}
		return flag;

	}

	public void verifyResponseArrayValues(String values,String testData,String operatorName, String expectedName) throws ParseException {
		String actualData;
		if (values.contains(";")) {
			String[] value = values.split(";");
			String[] expectedData1 = expectedName.split(";");
			for (int i = 0; i < value.length; i++) {
				String expectedData =PropertiesCache.getProperty(testData, value[i]);
				String expectedName1 =expectedData1[i];
				actualData   = response.path(value[i]).toString();
				actualData = actualData.substring(1,actualData.length()-1);
				APIListener.addLogger("Test Data: "+ expectedData);
				APIListener.addLogger("response.path(value[i]: "+actualData);
				String[] actualDatas = actualData.split(",");
				if (!(actualDatas.length==1)) {
					for (int j = 0; j < actualDatas.length; j++) {
						if (verifyDataReturnValue(expectedData.trim(),actualDatas[j].trim(),operatorName) ||
								verifyDataReturnValue(expectedName1.trim(),actualDatas[j].trim(),operatorName)) {
							assertTrue(true);
						} else {
							assertTrue(false);
						}
					}
					APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
				} else {
					if (verifyDataReturnValue(expectedData.trim(),actualData.trim(),operatorName) ||
							verifyDataReturnValue(expectedName1.trim(),actualData.trim(),operatorName)) {
						assertTrue(true);
					} else {
						assertTrue(false);
					}
				}	
			}
		}else {
			String expectedData =PropertiesCache.getProperty(testData, values);
			String expectedData1 =expectedName;
			String data = "resultSet."+values;
			List<String> jsonResponse = response.jsonPath().getList(data);
			APIListener.addLogger(jsonResponse.size());
			APIListener.addLogger(String.valueOf(jsonResponse.get(0)));
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					if (verifyDataReturnValue(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName) ||
							verifyDataReturnValue(expectedData1.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName)) {
						assertTrue(true);
					} else {
						assertTrue(false);
					}
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
				}

			} else {
				if (verifyDataReturnValue(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName) ||
						verifyDataReturnValue(expectedData1.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName)) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
			}
		}
	}

	public void verifyResponseArrayTestDataValues(String values,String testData,String operatorName, String expectedName) throws ParseException {
		String actualData;
		if (values.contains(";")) {
			String[] value = values.split(";");
			String[] expectedData1 = expectedName.split(";");
			for (int k = 0; k < expectedData1.length; k++) {
				for (int i = 0; i < value.length; i++) {
					String expectedData =PropertiesCache.getProperty(testData, value[i]);
					String expectedName1 =expectedData1[k];
					actualData   = response.path(expectedName1).toString();
					actualData = actualData.substring(1,actualData.length()-1);
					APIListener.addLogger("Test Dat: "+ expectedData);
					APIListener.addLogger("response.path(value[i]: "+actualData);
					String[] actualDatas = actualData.split(",");
					boolean flag = false;
					if (!(actualDatas.length==1)) {
						for (int j = 0; j < actualDatas.length; j++) {
							if (verifyDataReturnValue(expectedData.trim(),actualDatas[j].trim(),operatorName)) {
								flag = true;
								break;
							} else {
								flag = false;
							}
						}
						if (flag) {
							assertTrue(true);
						} else {
							assertTrue(false);
						}
						APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
					} else {
						if (verifyDataReturnValue(expectedData.trim(),actualData.trim(),operatorName)) {
							flag = true;
						} else {
							flag = false;
						}
						if (flag) {
							assertTrue(true);
						} else {
							assertTrue(false);
						}
					}	
				}
			}
		}else {
			String expectedData =PropertiesCache.getProperty(testData, values);
			String expectedData1 =expectedName;
			String data = "resultSet."+values;
			List<String> jsonResponse = response.jsonPath().getList(data);
			APIListener.addLogger(jsonResponse.size());
			APIListener.addLogger(String.valueOf(jsonResponse.get(0)));
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					if (verifyDataReturnValue(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName) ||
							verifyDataReturnValue(expectedData1.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName)) {
						assertTrue(true);
					} else {
						assertTrue(false);
					}
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
				}

			} else {
				if (verifyDataReturnValue(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName) ||
						verifyDataReturnValue(expectedData1.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName)) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
			}
		}
	}
	
	public void verifySchemaData(String testData, String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, url));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, url));
	}
	
	public void verifyWorkflowData(String testData, String url) {
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, url));
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, url) + "/"
						+ PropertiesCache.getProperty(testData, "id"));
	}
	
	public void verifyGetSetJsonDatas(String testData,String parameter) {

		JSONArray ja = new JSONArray(response.asString());
		String item = parameter;
		String[] items = item.split(";");
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jsonData = ja.getJSONObject(i); 
			String idValue = jsonData.getString("id");
			if (idValue.equals(PropertiesCache.getProperty(testData, "id"))) {
				APIListener.addLogger("jsonData:"+jsonData);
				for (int k = 0; k < items.length; k++) {
				assertTrue(!response.path(items[k]).toString().isEmpty());
				APIListener.addLogger( items[k] + " is not blank");
				}
			}
		}
	}

	public void verifyResponseDataArrayValue(String values, String data) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				assertEquals(response.path(value[i]).toString(), "["+data+"]");
				APIListener.addLogger( value[i] + " is Not blank");
			}
		} else {
			assertEquals(response.path(values).toString(), "["+data+"]");
			APIListener.addLogger( values + " is Not blank");
		}
	}
	
	public void verifyResponseValidationWithMessage(String testData, String message) {
		APIListener.addLogger(response.body().asString());
		assertTrue((response.body().asString().contains(message)));
	}
	
	public void verifyLookupfieldsData(String testData, String url) {
		List<Object> idData = response.jsonPath().getList("id");
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")+ "lookupfields/"
						+ PropertiesCache.getProperty(testData, url));
		List<Object> idData1 = response.jsonPath().getList("id");
		assertEquals(idData1,idData);
	}

	public void getAdditionalInformation(String testData, String customUrl ,String url) {
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+ PropertiesCache.getProperty(testData, "access_token")).request()
				.get(PropertiesCache.getProperty(testData, "API_RequestUrl")
						+ PropertiesCache.getProperty(testData, customUrl) + "/"
						+ PropertiesCache.getProperty(testData, "id")+ "/"
						+ PropertiesCache.getProperty(testData, url));
	}
	
	/*public String setPaginationFilterOperator(String name,String operatorName,String key,String testData) throws ParseException {
		
		System.out.println("Rule =====>"+"\""+name+" "+setBackticksQuote(operatorName)+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key))+"\"");
		return 	"\""+name+" "+setBackticksQuote(operatorName)+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key))+"\"";

    } */
	
    public String setPaginationFilterOperator(String name,String operatorName,String key,String testData) throws ParseException {
		
    	APIListener.addLogger("Rule =====>"+"\""+setBackticksQuote(name)+" "+operatorName+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key))+"\"");
		return 	"\""+setBackticksQuote(name)+" "+operatorName+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key))+"\"";

    }  
	
	public String setPaginationFilterCombinations(String name,String operatorName1,String key1,String operatorName2, String key2,String testData) throws ParseException { 
		System.out.println("Rule =====>"+"\""+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+"\""); 
		return 	"\""+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+"\""; 
   
    }   
	  
	public String setPaginationFilterCombinations_1(String name,String operatorName1,String key1,String operatorName2, String key2, String operatorName3,String status,String key3,String key4, String testData) throws ParseException {
		System.out.println("Rule===>"+"\"("+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+" "+")"+" "+operatorName3+" "+"("+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key3))+" "+operatorName2+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key4))+" "+")\"");
		return 	"\"("+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+" "+")"+" "+operatorName3+" "+"("+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key3))+" "+operatorName2+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key4))+" "+")\"";
    } 
	
	public String setPaginationFilterCombinations_2(String name,String operatorName1,String key1,String operatorName2, String key2, String operatorName3,String status,String key3,String testData) throws ParseException {
		System.out.println("Rule===>"+"\"("+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+" "+")"+" "+operatorName3+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key3))+"\"");
		return 	"\"("+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+" "+")"+" "+operatorName3+" "+status+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key3))+"\"";
    } 
	
	 
	/*public String setPaginationFilterCombinations_2(String name, String operatorName1, String key1,
			String operatorName2, String key2, String operatorName3, String status, String operatorName4, String key3,
			String operatorName5, String key4,String operatorName6, String name1, String operatorName7, String key5, String operatorName8,
			String key6, String testData) throws ParseException {
		return name + " " + operatorName1 + " " + "//(" + " " + PropertiesCache.getProperty(testData, key1) + " "
				+ operatorName2 + " " + PropertiesCache.getProperty(testData, key2) + " " + "//)" + operatorName3 + " "
				+ status + " " + operatorName4 + " " + "//(" + PropertiesCache.getProperty(testData, key3) + " "
				+ operatorName5 + " " + PropertiesCache.getProperty(testData, key4) + " " + "//)" + operatorName6 + " "
				+ name1 + " " + operatorName7 + " " + "//(" + PropertiesCache.getProperty(testData, key5) + " "
				+ operatorName8 + " " + PropertiesCache.getProperty(testData, key6) + " " + "//)";

	}*/
	
	//filter="( raisedDate >= `2018-11-19` ) and ( status Equals `Approved` or status Equals `Draft` )"
	public String setPaginationFilterCombinations_3(String name,String operatorName1,String key1,String operatorName2, String name1, String operatorName3,String key2,String operatorName4,String key3, String testData) throws ParseException {
		return 	"\""+name+" "+operatorName1+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key1))+" "+operatorName2+" "+"("+" "+name1+" "+operatorName3+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key2))+" "+operatorName4+" "+name1+" "+operatorName3+" "+setBackticksQuote(PropertiesCache.getProperty(testData, key3))+" "+")\"";

    } 
	
	public void paginationfilter( String testData, String filterRule,String pageNum,String recordsPerpage,String filterUrl)
	{
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).
				queryParam("filter",filterRule ).
				queryParam("pagenum",pageNum ).
				queryParam("recordsperpage",recordsPerpage ).request().
				get(PropertiesCache.getProperty(testData, "API_RequestUrl")+PropertiesCache.getProperty(testData, filterUrl));
		        APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")+PropertiesCache.getProperty(testData, filterUrl)+"?filter="+filterRule+"&"+"pageNum="+pageNum+"&"+"recordsPerpage="+recordsPerpage);
		    	APIListener.addLogger("Respose =for ========="+response.asString());
						
	}
	public void paginationfilterWithoutPagenum( String testData, String filterRule,String filterUrl)
	{
		response = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+PropertiesCache.getProperty(testData, "access_token")).
				queryParam("filter",filterRule ).request().
				get(PropertiesCache.getProperty(testData, "API_RequestUrl")+PropertiesCache.getProperty(testData, filterUrl));
		APIListener.addLogger(PropertiesCache.getProperty(testData, "API_RequestUrl")+PropertiesCache.getProperty(testData, filterUrl)+"?filter="+filterRule);		
		APIListener.addLogger("Respose =for ========="+response.asString());
						
	}

	public String[] addStringToArray(String text) {
		String [] stringArray=null;
		if(text.contains(",")) {
			stringArray	 = text.replace("[", "").replace("]", "").split(",");
		}else {
			stringArray=text.replace("[", "").replace("]", "").split(" ");
		}
		
		return stringArray;
		
 	}
	
	public void verifyResponseValueEmpty(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				assertTrue(response.path(value[i]).toString().isEmpty());
				APIListener.addLogger( value[i] + " is not blank");
			}
		} else {
			assertTrue(response.path(values).toString().isEmpty());
			APIListener.addLogger( values + " is not blank");
		}
	}
	public void verifyResponseArrayEmpty(String values) {
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				if(addStringToArray(response.path(value[i]).toString())==null) {
					assertTrue(true);
				}
				APIListener.addLogger( value[i] + " is blank");
			}
		} else {
			if(addStringToArray(response.path(values).toString())==null) {
				assertTrue(true);
			}
			APIListener.addLogger( values + " is blank");
		}
	}

	public String getTodayDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String strDate = formatter.format(date);
		return strDate;
		}
	
	public void verifyResponseStringValue(String values,String operatorName) throws ParseException {
		String actualData;
		if (values.contains(";")) {
			String[] value = values.split(";");
			for (int i = 0; i < value.length; i++) {
				actualData   = response.path(value[i]).toString();
				actualData = actualData.substring(1,actualData.length()-1);
				String[] actualDatas = actualData.split(",");
				if (!(actualDatas.length==1)) {
					for (int j = 0; j < actualDatas.length; j++) {
						verifyDataWithOperator(getTodayDate().trim(),actualDatas[j].trim(),operatorName);	
					}
					APIListener.addLogger( "Parameter : "+actualData+ operatorName +getTodayDate());
				} else {
					verifyDataWithOperator(getTodayDate().trim(),actualData.trim(),operatorName);	
				}	
			}
		}else {
			String data = "resultSet."+values;
			List<String> jsonResponse = response.jsonPath().getList(data);
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					verifyDataWithOperator(String.valueOf(jsonResponse.get(j)).trim(),getTodayDate(),operatorName);	
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +getTodayDate());
				}

			} else {
				verifyDataWithOperator(getTodayDate().trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +getTodayDate());
			}
		}
	}
	
	public JSONArray addJsonObjectToArray(String key,String value) {
		JSONArray arrayValue = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		arrayValue.put(jsonObject);
		return arrayValue;
		
	}
	
    /* //for dev api
	public void addLookupFields() {
		lookupFieldList.add("ActionsByType,Insights Actions - View By Type");
		lookupFieldList.add("ActionsPriority,PIR Item - Actions Priority");
		lookupFieldList.add("ActionStatus,PIR Item - Action Status");
		lookupFieldList.add("ActionType,PIR Item - Action Type");
		lookupFieldList.add("BlockoutPeriodType,Blockout Period Type");
		lookupFieldList.add("BookingRequestStatus,TEBR Status");
		lookupFieldList.addAll(lookupFieldList);

	}*/
		
	//for demo.plutora -- systest
	public void addLookupFields() {
		lookupFieldList.add("ActionsByType,Insights Actions - View By Type");
		lookupFieldList.add("ActionStatus,PIR Item - Action Status");
		lookupFieldList.add("ActionType,PIR Item - Action Type");
		lookupFieldList.add("BlockoutPeriodType,Blockout Period Type");
		lookupFieldList.add("BookingRequestStatus,TEBR Status");
		lookupFieldList.addAll(lookupFieldList);
	}
	public void verifyLookupFieldValue(String values, String operatorName, int count) throws ParseException {
		this.addLookupFields();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		// List<String>
		// descriptionList=response.jsonPath().getList("description");

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < lookupFieldList.size();) {
				if (lookupFieldList.get(j).contains(",")) {
					expectedData = lookupFieldList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				break loop;
			}
		}
	}
	public void verifyLookupFieldValueWithoutPagenum(String values, String operatorName, int count) throws ParseException {
		this.addLookupFields();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList(values);

		// List<String>
		// descriptionList=response.jsonPath().getList("description");

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < lookupFieldList.size();) {
				if (lookupFieldList.get(j).contains(",")) {
					expectedData = lookupFieldList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				break loop;
			}
		}
	}
	
	public void verifyLookupFieldValueList(String values, String operatorName, int count) throws ParseException {
		this.addLookupFields();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		// List<String>
		// descriptionList=response.jsonPath().getList("description");

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < lookupFieldList.size();) {
				if (lookupFieldList.get(j).contains(",")) {
					expectedData = lookupFieldList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyLookupFieldValueListWithouPageNum(String values, String operatorName, int count) throws ParseException {
		this.addLookupFields();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList(values);

		// List<String>
		// descriptionList=response.jsonPath().getList("description");

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < lookupFieldList.size();) {
				if (lookupFieldList.get(j).contains(",")) {
					expectedData = lookupFieldList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	
	// for demo.plutora -- systest
	public void addOrganizationsField() {
		organizationsList.add("c0b720fd-ce15-e811-8146-029a1f64cdff,_Alina2,Department");
		organizationsList.add("7ca3d367-2121-4579-a8ba-5ec8e11d91b4,_org1,Division");
		organizationsList.add("6586eafa-bfe3-480f-bbeb-38249fa5b898,_org2,Division");
	    organizationsList.add("e76defa9-1d9f-42be-86a0-cae61cc7290d,_org3,Division");
	    organizationsList.add("1863b24c-5b73-4b79-8150-e02cef776c7d,1,Division");
		organizationsList.add("7e7f9044-9f1a-46cd-a109-f84e30689c74,1,Department");
	}
	
	// for dev api
	/*public void addOrganizationsField() {
		organizationsList.add("abfa6a4f-e0fa-41e5-885d-ec426a488b71,Clean,SubTeam");
		organizationsList.add("0107e7a0-974d-48d9-ac4f-0397b21f3f64,C&W - Billing - Consumer,Department");
		organizationsList.add("64cb281c-11e0-4751-81c4-06aa2309efca,C&W - Billing - Corporate,Department");
		organizationsList.add("88ea9a6f-1297-47c2-a2b6-c8f22853607c,C&W - Billing - Mediation & Rating,Department");
		organizationsList.add("cea0fcd6-58dd-4e36-bd16-e226133fd22f,C&W - Credit & Fraud,Department");
		organizationsList.add("d9058d28-453d-4d51-b6de-3f6f2284b995,C&W - Enterprise Collaboration DC,Department");
		
	}*/

	public void verifyOrganizationsValue(String values, String operatorName, int count) throws ParseException {
		this.addOrganizationsField();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < organizationsList.size();) {
				if (organizationsList.get(j).contains(",")) {
					expectedData = organizationsList.get(j).split(",");
					//System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyOrganizationsValueWithoutPageNum(String values, String operatorName, int count) throws ParseException {
		this.addOrganizationsField();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList(values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < organizationsList.size();) {
				if (organizationsList.get(j).contains(",")) {
					expectedData = organizationsList.get(j).split(",");
					//System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}

	public void organizationTreevalues() {
		organizationsTreeList.add("3fdddd5b-fddd-4190-b2db-485e6a478c64, The Testing Company, Company");
		organizationsTreeList.add("8bca0658-0ef5-45d9-8b0c-5db7cb8eacd6, C&W'S Organization, Division");
		organizationsTreeList.add("0107e7a0-974d-48d9-ac4f-0397b21f3f64, C&W - Billing - Consumer, Department");
		organizationsTreeList.add("64cb281c-11e0-4751-81c4-06aa2309efca, C&W - Billing - Corporate, Department");
		organizationsTreeList
				.add("88ea9a6f-1297-47c2-a2b6-c8f22853607c, C&W - Billing - Mediation & Rating, Department");
		organizationsTreeList.add("cea0fcd6-58dd-4e36-bd16-e226133fd22f, C&W - Credit & Fraud, Department");
		organizationsTreeList
				.add("d9058d28-453d-4d51-b6de-3f6f2284b995, C&W - Enterprise Collaboration DC, Department");
	}

	public void verifyOrganizationsTreeValue(String values, String operatorName, int count) throws ParseException {
		this.addOrganizationsField();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < organizationsTreeList.size(); j++) {
				if (organizationsTreeList.get(j).contains(",")) {
					expectedData = organizationsTreeList.get(j).split(",");
					System.out.println(attributeList.get(i) + " " + expectedData[count]);
					verifyDataWithOperator(attributeList.get(i), expectedData[count], operatorName);
				}
				break loop;
			}
		}
	}

	/*// for dev-api
	public void workItemNameValuesPhases() {
		workItemNamePhaseList.add("cb68561e-a72d-4ba1-aeb7-b6b076d8a251,phase1");
		workItemNamePhaseList.add("e5d1438d-210a-45b7-a828-f3a5e2d8b06f,phase2");
		workItemNamePhaseList.add("45d968b2-d353-431b-ae35-d272eb5524a3,phase3");
	}
	  // for dev-api
		public void workItemNameValuesGates() {	
		workItemNameGateList.add("0ca98f9a-5a1a-4a93-9246-29aae1740d6c,gate1");
		workItemNameGateList.add("4756028f-9421-4c78-ad36-3b71cc59ddbe,gate2");
		workItemNameGateList.add("195fd99b-d684-4ad3-bb74-d043636996e7,gate3");
	}*/
	
    //demo.plutora.co --systest
	public void workItemNameValuesPhases() {
		workItemNamePhaseList.add("82d40baf-a642-e811-8146-029a1f64cdff,phase1");
		workItemNamePhaseList.add("e85909f5-6cce-4ab3-8e93-d4c738c3e96f,phase2");
		workItemNamePhaseList.add("09c1dda4-fec3-4e2a-b76a-e8ab444b6b43,phase3");
	}
	//demo.plutora.co -- systest
		public void workItemNameValuesGates() {	
		workItemNameGateList.add("c4de827b-7d8a-49fa-9054-a821404ca401,gate1");
		workItemNameGateList.add("dc29c479-91e5-4d9f-b092-8b68e94f6ae7,gate2");
		workItemNameGateList.add("1d7b76f0-b2b8-4c46-9880-59c272d6d197,gate3");
	}
   
    // for dev-api
	/*public void usersUserGroupsValues()
	{
		usersUserGroupsList.add("6675b853-3c28-e911-a9d2-0691b9f9b51e,Usergroup-automation test,Usergroup-automation");
		usersUserGroupsList.add("66c5eb41-59f7-e811-a9c5-0691b9f9b51e,Plutora User Group, ");
		usersUserGroupsList.add("7bf85d8d-69f7-e811-a9c5-0691b9f9b51e,PlutoraTest User Group,PlutoraTest User Group (description)");
		usersUserGroupsList.add("7604cf83-3bfc-e811-a9c6-0691b9f9b51e,test group, ");
	}*/
	
	// for demo.plutora.co-- systest
	public void usersUserGroupsValues()
	{
		usersUserGroupsList.add("881e2d49-749a-e611-8138-029a1f64cdff,eiki_test_group,eiki's test group");
		usersUserGroupsList.add("50e8b684-7418-e911-815f-029a1f64cdff,eiki_test_group9011,for R9011R sprint");
		usersUserGroupsList.add("9dec61b8-82d9-e711-8144-029a1f64cdff,A_Users, ");
		usersUserGroupsList.add("7a47800a-a959-e811-8146-029a1f64cdff,name_2331,Usergroup-automation");
	}
	
	// for demo.plutora.co -- systest
	public void usersValues()
	{
		usersList.add("f69c501f-9ff8-474b-8157-0058757f9090,Tim,Zapevalov,tim.zapevalov@plutora.com,Active");
		usersList.add("9df3322d-9cc2-e711-8144-029a1f64cdff,Hang,Fan,hang.fan@plutora.com,Active");
		usersList.add("72f911d1-4839-e811-8146-029a1f64cdff,Sarath,Ag,sarath.ag@plutora.com,InActive");
		usersList.add("c67ae164-fe41-e811-8146-029a1f64cdff,Eugene,Rublev,eugene.rublev@plutora.com,Active");
	}
	
		
	public void verifyusersUserGroupsAttributes(String values, String operatorName, int count) throws ParseException {
		this.usersUserGroupsValues();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < usersUserGroupsList.size();) {
				if (usersUserGroupsList.get(j).contains(",")) {
					expectedData = usersUserGroupsList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperator(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}}
	public void verifyusersUserGroupsAttributesWithoutPageNum(String values, String operatorName, int count) throws ParseException {
		this.usersUserGroupsValues();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList(values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < usersUserGroupsList.size();) {
				if (usersUserGroupsList.get(j).contains(",")) {
					expectedData = usersUserGroupsList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperator(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}}
		
		public void verifyusersAttributes(String values, String operatorName, int count) throws ParseException {
			this.usersUserGroupsValues();
			String[] expectedData;
			List<String> attributeList = response.jsonPath().getList("resultSet."+values);

			loop: for (int i = 0; i < attributeList.size(); i++) {
				for (int j = 0; j < usersList.size();) {
					if (usersList.get(j).contains(",")) {
						expectedData = usersList.get(j).split(",");
						System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
						verifyDataWithOperator(attributeList.get(i), expectedData[count], operatorName);
					}
					continue loop;
				}
			}
		}
			public void verifyusersAttributesWithoutPageNum(String values, String operatorName, int count) throws ParseException {
				this.usersUserGroupsValues();
				String[] expectedData;
				List<String> attributeList = response.jsonPath().getList(values);

				loop: for (int i = 0; i < attributeList.size(); i++) {
					for (int j = 0; j < usersList.size();) {
						if (usersList.get(j).contains(",")) {
							expectedData = usersList.get(j).split(",");
							System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
							verifyDataWithOperator(attributeList.get(i), expectedData[count], operatorName);
						}
						continue loop;
					}
				}
	
	}
	public void verifyWorkItemNamePhaseAttributes(String values, String operatorName, int count) throws ParseException {
		this.workItemNameValuesPhases();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < workItemNamePhaseList.size();) {
				if (workItemNamePhaseList.get(j).contains(",")) {
					expectedData = workItemNamePhaseList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyWorkItemNamePhaseAttributesWithoutPageNum(String values, String operatorName, int count) throws ParseException {
		this.workItemNameValuesPhases();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < workItemNamePhaseList.size();) {
				if (workItemNamePhaseList.get(j).contains(",")) {
					expectedData = workItemNamePhaseList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyWorkItemNameGateAttributes(String values, String operatorName, int count) throws ParseException {
		this.workItemNameValuesGates();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < workItemNameGateList.size();) {
				if (workItemNameGateList.get(j).contains(",")) {
					expectedData = workItemNameGateList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyWorkItemNameGateAttributesWithoutPageNum(String values, String operatorName, int count) throws ParseException {
		this.workItemNameValuesGates();
		String[] expectedData;
		List<String> attributeList = response.jsonPath().getList("resultSet."+values);

		loop: for (int i = 0; i < attributeList.size(); i++) {
			for (int j = 0; j < workItemNameGateList.size();) {
				if (workItemNameGateList.get(j).contains(",")) {
					expectedData = workItemNameGateList.get(j).split(",");
					System.out.println(expectedData[count] +" "+ "is"+" "+operatorName+" "+"to"+" " + attributeList.get(i));
					verifyDataWithOperatorForPagination(attributeList.get(i), expectedData[count], operatorName);
				}
				continue loop;
			}
		}
	}
	public void verifyResponseArrayValueCombination(String values,String testData,String operatorName,String[] keys) throws ParseException {
		
			String data = "resultSet."+values;
			List<String> jsonResponse = response.jsonPath().getList(data);
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					String expectedData =PropertiesCache.getProperty(testData, keys[j]);
					verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
					APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
				}

			} else {
				String expectedData =PropertiesCache.getProperty(testData, keys[0]);
				verifyDataWithOperator(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
				APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
			}
		}
       public void verifyResponseArrayValueCombinations(String values,String testData,String operatorName,String[] keys) throws ParseException {
		
		String data = values;
		List<String> jsonResponse = response.jsonPath().getList(data);
		if (!(jsonResponse.size()==1)) {
			for (int j = 0; j < jsonResponse.size(); j++) {
				String expectedData =PropertiesCache.getProperty(testData, keys[j]);
				verifyDataWithOperatorForPagination(expectedData.trim(),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
				//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
			}

		} else {
			String expectedData =PropertiesCache.getProperty(testData, keys[0]);
			verifyDataWithOperatorForPagination(expectedData.trim(),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
			//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
		}
	}
	public String setBackticksQuote(String key) {
		String quoteText = null;
		if (!key.isEmpty()) {
			quoteText = "`" + key + "`";
			System.out.println(quoteText);
			}
		return quoteText;
	}
	//setPaginationFilterCombinationWith2Keys
		public String setPaginationFilterCombinations1(String name,String operatorName1,String key1,String operatorName2, String key2,String testData) throws ParseException {
			this.setBackticksQuote(key1);
			this.setBackticksQuote(key2);
			return 	name+" "+operatorName1+" "+"//("+" "+PropertiesCache.getProperty(testData, key1)+" "+operatorName2+" "+PropertiesCache.getProperty(testData, key2)+" "+"//)";

	    } 
		//(Id Equals (a or b) and Name contains m)and Environment Id Equals y [Format]
		public String setPaginationFilterCombinationWithKeys(String name,String operatorName, String key1, String operatorName1, String key2,String operatorName2, String name1, String operatorName3, String key3, String key4,  String testData) throws ParseException {
			this.setBackticksQuote(key1);
			this.setBackticksQuote(key2);
			this.setBackticksQuote(key3);
			this.setBackticksQuote(key4);
			return 	   name +" "+operatorName+" "+"//("+" "+PropertiesCache.getProperty(testData, key1)+" "+operatorName1+" "+PropertiesCache.getProperty(testData, key2) +" "+ operatorName2 + name1 +" "+operatorName3+" " +"//("+" "+PropertiesCache.getProperty(testData, key3) +" "+ operatorName2 + name1 +" "+operatorName+" "+"//("+" "+PropertiesCache.getProperty(testData, key4)+ " ";

	    } 
		//setPaginationFilterCombinationWith3Keys
		public String setPaginationFilterCombinationWith3Keys(String name,String operatorName, String key1, String operatorName1, String key2,String operatorName2, String name1, String operatorName3, String key3, String testData) throws ParseException {
			this.setBackticksQuote(key1);
			this.setBackticksQuote(key2);
			this.setBackticksQuote(key3);
			
			return 	  name +" "+operatorName+" "+"//("+" "+PropertiesCache.getProperty(testData, key1)+" "+operatorName1+" "+PropertiesCache.getProperty(testData, key2) +" "+ operatorName2 + name1 +" "+operatorName3+" "+"//("+" "+PropertiesCache.getProperty(testData, key3)+" ";

	    } 
		//setPaginationFilterCombinationWith4Keys
		public String setPaginationFilterCombinationWith2Operators(String name,String operatorName1, String key1, String operatorName2, String key2,String operatorName, String name1, String operatorName3, String key3,String operatorName4 ,String key4, String testData) throws ParseException {
			this.setBackticksQuote(key1);
			this.setBackticksQuote(key2);
			this.setBackticksQuote(key3);
			this.setBackticksQuote(key4);
			return 	  name +" "+operatorName1+" "+"//("+" "+PropertiesCache.getProperty(testData, key1)+" "+operatorName2+" "+PropertiesCache.getProperty(testData, key2)+" "+ operatorName + name1 +" "+operatorName3+" "+"//("+" "+PropertiesCache.getProperty(testData, key3)+" "+operatorName4+" "+PropertiesCache.getProperty(testData, key4)+ "";

	    } 
		//setPaginationFilterCombinationWith6Keys
		public String setPaginationFilterCombinationWith3Operators(String name,String operatorName1,String key1,String operatorName2, String key2,String operatorName3, String name1, String operatorName4,String key3,String operatorName5, String key4, String operatorName6, String name2, String operatorName7, String key5, String operatorName8, String key6, String testData) throws ParseException {
			this.setBackticksQuote(key1);
			this.setBackticksQuote(key2);
			this.setBackticksQuote(key3);
			this.setBackticksQuote(key4);
			this.setBackticksQuote(key5);
			this.setBackticksQuote(key6);
			return 	  name +" "+operatorName1+" "+"//("+" "+PropertiesCache.getProperty(testData, key1)+" "+operatorName2+" "+PropertiesCache.getProperty(testData, key2) +" "+ operatorName3 + name1 +" "+operatorName4+" "+"//("+" "+PropertiesCache.getProperty(testData, key3)+" "+operatorName5+" "+"//("+" "+PropertiesCache.getProperty(testData, key4)+" "+operatorName6+ name2 +" "+ operatorName7+" "+"//("+" "+PropertiesCache.getProperty(testData, key5)+ " " +operatorName8+ " "+"//("+" "+PropertiesCache.getProperty(testData, key6)+" ";

	    }
  
		public String setQMarkToUrl(String key) {
			String quoteText = null;
			if (!key.isEmpty()) {
				quoteText = "?";
				System.out.println(quoteText);
				}
			return quoteText;
		}
  
		public void verifyDataWithOperatorForPagination(String actualData, String expectedData, String operatorName) throws ParseException {

			if (operatorName.equals("Equals")) {
				assertEquals(actualData,expectedData) ;
				APIListener.addLogger("Parameter : "+actualData+ " is equals to "+expectedData);
			} else if(operatorName.equals("Not Equals")) {
				assertNotEquals(actualData,expectedData) ;			
				APIListener.addLogger("Parameter : "+actualData+ " is not equals to "+expectedData);
			} else if(operatorName.equals("Contains")) {
				assertTrue(expectedData.toLowerCase().contains(actualData.toLowerCase())) ;			
				APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
			} else if(operatorName.equals("Is WithIn")) {
				assertTrue(expectedData.toLowerCase().contains(actualData.toLowerCase())) ;			
				APIListener.addLogger("Parameter : "+actualData+ " is contains to "+expectedData);
			} else if(operatorName.equals("Not Contains")) {
				APIListener.addLogger("Parameter : "+actualData+ " is not contains to "+expectedData);
				assertTrue(!(expectedData.toLowerCase().contains(actualData.toLowerCase()))) ;			
				APIListener.addLogger("Parameter : "+actualData+ " is not contains to "+expectedData);
			} else if(operatorName.equals("Greater Than")) {
				try {
				if(isInteger(actualData, Integer.parseInt(actualData))) {
				int actualValue = Integer.valueOf(actualData);
				int expectedValue = Integer.valueOf(expectedData);
				assertTrue(expectedValue > actualValue) ;
				APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
				}
				}catch(Exception e) {
				Date expectedDate = formateDatePagination(expectedData);
				Date actualDate = formateDatePagination(actualData);
				assertTrue(expectedDate.compareTo(actualDate)>0) ;	
				APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
				}
			} else if(operatorName.equals("Greater Or Equal")) {
				try {
				if(isInteger(actualData, Integer.parseInt(actualData))) {
					int actualValue = Integer.valueOf(actualData);
					int expectedValue = Integer.valueOf(expectedData);
					assertTrue(expectedValue > actualValue) ;
					APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
					}
				}catch(Exception e) {
				
				Date expectedDate = formateDatePagination(expectedData);
				Date actualDate = formateDatePagination(actualData);
				assertTrue(expectedDate.compareTo(actualDate)>=0) ;	
				APIListener.addLogger("Parameter : "+actualData+ " is greater than or equal "+expectedData);
				}
			} else if(operatorName.equals("Less Than")) {
				try {
				if(isInteger(actualData, Integer.parseInt(actualData))) {
					int actualValue = Integer.valueOf(actualData);
					int expectedValue = Integer.valueOf(expectedData);
					assertTrue(expectedValue < actualValue) ;
					APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
				    }
				}catch(Exception e) {
				Date expectedDate = formateDatePagination(expectedData);
				Date actualDate = formateDatePagination(actualData);
				APIListener.addLogger(expectedDate+""+actualDate+(expectedDate.compareTo(actualDate)));
				assertTrue(expectedDate.compareTo(actualDate)<0) ;	
				APIListener.addLogger("Parameter : "+expectedData+ " is less than "+actualData);
				}
			} else if(operatorName.equals("Less Or Equal")) {
				try {
				if(isInteger(actualData, Integer.parseInt(actualData))) {
					int actualValue = Integer.valueOf(actualData);
					int expectedValue = Integer.valueOf(expectedData);
					assertTrue(expectedValue < actualValue) ;
					APIListener.addLogger("Parameter : "+expectedData+ " is greater than "+actualData);
					} 
				}catch (Exception e) {
				Date expectedDate = formateDatePagination(expectedData);
				Date actualDate = formateDatePagination(actualData);
				assertTrue(expectedDate.compareTo(actualDate)<=0) ;	
				APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
				}
			} else if(operatorName.equals("ANDOR")) {
				assertEquals(actualData,expectedData) ;	
				assertEquals(actualData,expectedData) ;	
				APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
			} else if(operatorName.equals("OR")) {
				assertEquals(actualData,expectedData) ;	
				APIListener.addLogger("Parameter : "+expectedData+ " is less than or equal "+actualData);
			}

		}

		public void verifyResponseArrayValueForPaginationWithOnlyFilterRule(String data,String values,String testData,String operatorName) throws ParseException {
			String actualData;
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String expectedData =PropertiesCache.getProperty(testData, value[i]);
					actualData   = response.path(value[i]).toString();
					actualData = actualData.substring(1,actualData.length()-1);
					String[] actualDatas = actualData.split(",");
					if (!(actualDatas.length==1)) {
						for (int j = 0; j < actualDatas.length; j++) {
							
							verifyDataWithOperatorForPagination(expectedData.trim(),actualDatas[j].trim(),operatorName);	
						}
					//	APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
					} else {
						verifyDataWithOperatorForPagination(expectedData.trim(),actualData.trim(),operatorName);	
					}	
				}
			}else {
				String expectedData =PropertiesCache.getProperty(testData, values);
				//String data = "resultSet."+values;
				//System.out.println(response.asString()+"resultSet."+values+data);
				//String data = values;
				List<String> jsonResponse = response.jsonPath().getList(data);
				if (!(jsonResponse.size()==1)) {
					for (int j = 0; j < jsonResponse.size(); j++) {
						verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
						//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
					}

				} else {
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
					//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
				}
			}
		}
		
		//with filter, pagenum and records per page --- result set
		public void verifyResponseArrayValueForPagination(String data,String values,String testData,String operatorName) throws ParseException {
			String actualData;
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String expectedData =PropertiesCache.getProperty(testData, value[i]);
					actualData   = response.path(value[i]).toString();
					actualData = actualData.substring(1,actualData.length()-1);
					String[] actualDatas = actualData.split(",");
					if (!(actualDatas.length==1)) {
						for (int j = 0; j < actualDatas.length; j++) {
							
							verifyDataWithOperatorForPagination(expectedData.trim(),actualDatas[j].trim(),operatorName);	
						}
					//	APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
					} else {
						verifyDataWithOperatorForPagination(expectedData.trim(),actualData.trim(),operatorName);	
					}	
				}
			}else {
				String expectedData =PropertiesCache.getProperty(testData, values);
				//String data = "resultSet."+values;
				//System.out.println(response.asString()+"resultSet."+values+data);
				//String data = values;
				List<String> jsonResponse = response.jsonPath().getList("resultSet."+data);
				if (!(jsonResponse.size()==1)) {
					for (int j = 0; j < jsonResponse.size(); j++) {
						verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
						//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
					}

				} else {
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
					//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
				}
			}
		}
		public  boolean isInteger(String s, int radix) {
		    if(s.isEmpty()) return false;
		    for(int i = 0; i < s.length(); i++) {
		        if(i == 0 && s.charAt(i) == '-') {
		            if(s.length() == 1) return false;
		            else continue;
		        }
		        if(Character.digit(s.charAt(i),radix) < 0) return false;
		    }
		    return true;
		}
		
		public void verifyDateResponseArrayValueForPaginationWithOnlyFilterRule(String data,String values,String testData,String operatorName) throws ParseException {
				String expectedData =PropertiesCache.getProperty(testData, values);
				List<String> jsonResponse = response.jsonPath().getList(data);
				if (!(jsonResponse.size()==1)) {
					for (int j = 0; j < jsonResponse.size(); j++) {
						System.out.println(String.valueOf(jsonResponse.get(j)).trim().split("T")[0]);
						verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim().split("T")[0],operatorName);	
					
					}
					

				} else {
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim().split("T")[0],operatorName);	
				}
			
		}
		
		//date for result set
		public void verifyDateResponseArrayValueForPagination(String data,String values,String testData,String operatorName) throws ParseException {
			String expectedData =PropertiesCache.getProperty(testData, values);
			List<String> jsonResponse = response.jsonPath().getList("resultSet."+data);
			if (!(jsonResponse.size()==1)) {
				for (int j = 0; j < jsonResponse.size(); j++) {
					System.out.println(String.valueOf(jsonResponse.get(j)).trim().split("T")[0]);
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim().split("T")[0],operatorName);	
				
				}
				

			} else {
				verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim().split("T")[0],operatorName);	
			}
		
	}
		public void verifyResponseArrayValueForPaginationTECRWithoutPageNum(String data,String values,String testData,String operatorName) throws ParseException {
			String actualData;
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String expectedData =PropertiesCache.getProperty(testData, value[i]);
					actualData   = response.path(value[i]).toString();
					actualData = actualData.substring(1,actualData.length()-1);
					String[] actualDatas = actualData.split(",");
					if (!(actualDatas.length==1)) {
						for (int j = 0; j < actualDatas.length; j++) {
							
							verifyDataWithOperatorForPagination(expectedData.trim(),actualDatas[j].trim(),operatorName);	
						}
					//	APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
					} else {
						verifyDataWithOperatorForPagination(expectedData.trim(),actualData.trim(),operatorName);	
					}	
				}
			}else {
				String expectedData =PropertiesCache.getProperty(testData, values);
				//String data = "resultSet."+values;
				
				String[] data1=null;
				if(expectedData.contains(",")) {
					data1 = expectedData.split(",");
				}
				System.out.println(response.asString());
				//String data = values;
				List<String> jsonResponse = response.jsonPath().getList(data);
				if (!(jsonResponse.size()==1)) {
					if(!expectedData.contains(",")) {
						for (int j = 0; j < jsonResponse.size(); j++) {
							verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
							//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
						}
					}else {
					for (int k = 0; k <data1.length ; k++)
					{
					for (int j = 0; j < jsonResponse.size(); j++) {
						verifyDataWithOperatorForPagination(data1[k].trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
						//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
					}
					}
					}
				} else {
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
					//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
				}
			}
		}
		
		// for result set
		public void verifyResponseArrayValueForPaginationTECR(String data,String values,String testData,String operatorName) throws ParseException {
			String actualData;
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String expectedData =PropertiesCache.getProperty(testData, value[i]);
					actualData   = response.path(value[i]).toString();
					actualData = actualData.substring(1,actualData.length()-1);
					String[] actualDatas = actualData.split(",");
					if (!(actualDatas.length==1)) {
						for (int j = 0; j < actualDatas.length; j++) {
							
							verifyDataWithOperatorForPagination(expectedData.trim(),actualDatas[j].trim(),operatorName);	
						}
					//	APIListener.addLogger( "Parameter : "+actualData+ operatorName +expectedData);
					} else {
						verifyDataWithOperatorForPagination(expectedData.trim(),actualData.trim(),operatorName);	
					}	
				}
			}else {
				String expectedData =PropertiesCache.getProperty(testData, values);
				//String data = "resultSet."+values;
				
				String[] data1=null;
				if(expectedData.contains(",")) {
					data1 = expectedData.split(",");
				}
				System.out.println(response.asString());
				//String data = values;
				List<String> jsonResponse = response.jsonPath().getList("resultSet."+data);
				if (!(jsonResponse.size()==1)) {
					if(!expectedData.contains(",")) {
						for (int j = 0; j < jsonResponse.size(); j++) {
							verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
							//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
						}
					}else {
					for (int k = 0; k <data1.length ; k++)
					{
					for (int j = 0; j < jsonResponse.size(); j++) {
						verifyDataWithOperatorForPagination(data1[k].trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(j)).trim(),operatorName);	
						//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(j)).trim()+ operatorName +expectedData);
					}
					}
					}
				} else {
					verifyDataWithOperatorForPagination(expectedData.trim().replace("[", "").replace("]", ""),String.valueOf(jsonResponse.get(0)).trim(),operatorName);	
					//APIListener.addLogger( "Parameter : "+String.valueOf(jsonResponse.get(0)).trim()+ operatorName +expectedData);
				}
			}
		}


		
	/*	//for DEMOAU- demoau.plutora.co Pagination
		public void addLookupFields() {
			lookupFieldList.add("ActionsByType,Insights Actions - View By Type");
			lookupFieldList.add("ActionStatus,PIR Item - Action Status");
			lookupFieldList.add("ActionType,PIR Item - Action Type");
			lookupFieldList.add("BlockoutPeriodType,Blockout Period Type");
			lookupFieldList.add("BookingRequestStatus,TEBR Status");
			lookupFieldList.addAll(lookupFieldList);
		}
		
		//for DEMOAU -demoau.plutora.co Pagination
		public void addOrganizationsField() {
	        organizationsList.add("ea76fcf2-de54-4ff9-9a3f-9c2f9e5ac174,demoau,Company");
			organizationsList.add("9af34ad3-80e2-e811-a982-f2cb536a8f94,ABC Group,Division");
			organizationsList.add("0b0106e2-69db-e811-a982-f2cb536a8f94,CAB Approval,Division");
			organizationsList.add("809340e0-e4cc-e811-a982-f2cb536a8f94,_org2,Division");
		    organizationsList.add("e76defa9-1d9f-42be-86a0-cae61cc7290d,CTL,Division");
			organizationsList.add("20e9c12c-3127-e811-a980-fc49c3e38ffc,4,SubTeam");
		}
		*/
		//for DEMOAU- demoau.plutora.co Pagination
		/*public void usersValues()
	    {
			usersList.add("9f36865d-86dc-4fa3-8e76-cddcf2414f37,Aaron,McCaughan,aaron.mccaughan@plutora.com,Active");
			usersList.add("476b26e6-ff28-e911-a982-f2cb536a8f94,Abhisheka,Katpalli,abhisheka.katpalli@plutora.com,Active");
			usersList.add("d29a9906-3ee2-e811-a982-f2cb536a8f94,PenTest1,StandardUsere,pentest.standard@plutora.com,InActive");
			usersList.add("42a97c49-97f6-e811-a982-f2cb536a8f94,Bill,Hamawi,bill.hamawi@plutora.com,Active");
		}*/
		
		/*
		//for DEMOAU - demoau.plutora.co Pagination
		public void usersUserGroupsValues()
		{
			usersUserGroupsList.add("2a2af6ac-3d28-e911-a982-f2cb536a8f94,User Group Created Via API - to be deleted 123,test");
			usersUserGroupsList.add("4bcf9440-2e74-e811-a982-f2cb536a8f94,TestAPIGroup, ");
			usersUserGroupsList.add("153df4f2-3ddb-e811-a982-f2cb536a8f94,Plutora_Support_Group,Plutora's support group ");
			
		}
		
		//for DEMOAU - demoau.plutora.co Pagination
		public void workItemNameValuesPhases() {
			workItemNamePhaseList.add("6c2af175-bce7-4193-9751-027df6c6342c,PVT");
			workItemNamePhaseList.add("96ebf441-8832-48df-9324-18f8aa4149e8,IMP");
			workItemNamePhaseList.add("0d4c194b-065c-44f3-ab87-ea12c4a3d534,phase3");
		}
		
		//for DEMOAU - demoau.plutora.co Pagination
		public void workItemNameValuesGates() {	
			workItemNameGateList.add("695926ad-df28-4d55-9f41-133405890113,gate2");
			workItemNameGateList.add("53b3fd51-b9e6-4a02-8d5e-45e600007d19,gate3");
			workItemNameGateList.add("afce5598-d8b8-41ed-8332-47c58f98b4a1,Design Approved");

		}*/
		public void verifyResponseIsNull(String values) {
			
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					try {
					System.out.println(response.path(value[i]).toString());
					response.path(value[i]).toString();
					}catch(NullPointerException e) {
					 assertTrue(true);
					 APIListener.addLogger(value[i]+" is Null");
					}
				}
			} else {
				try {
				System.out.println(response.path(values).toString());
				response.path(values).toString();
				}catch(NullPointerException e) {
					assertTrue(true);
					APIListener.addLogger(values+" is Null");
				}
			}
			
		}
		
    public void verifyResponseIsNotNull(String values) {
			
			if (values.contains(";")) {
				String[] value = values.split(";");
				for (int i = 0; i < value.length; i++) {
					String text=response.path(value[i]).toString();
					text=text.replace("[", "").replace("]", "");
					if(text.equals("null")) {
						assertTrue(false);
						 APIListener.addLogger(value[i]+" is Null");
					}else {
						assertTrue(true);
						 APIListener.addLogger(value[i]+" is not Null");
					}
					
				}
			} else {
					String text=response.path(values).toString();
					text=text.replace("[", "").replace("]", "");
					if(text.equals("null")) {
						assertTrue(false);
						 APIListener.addLogger(values+" is Null");
					}else {
						assertTrue(true);
						 APIListener.addLogger(values+" is not Null");
					}
				}
			
		}
}