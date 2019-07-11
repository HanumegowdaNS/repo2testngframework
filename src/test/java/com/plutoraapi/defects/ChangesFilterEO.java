package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;

public class ChangesFilterEO  {

	ChangesPage changesPage = new ChangesPage();
	String changeName = null;
	String changeStatus = null;
	String changeId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains 
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 1)
	public void changesEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - POST [Changes]/filter expando object 'name' fetching value for contains operator"); 
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id");
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"name","Contains","name","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("POST [Changes]/filter expando object 'Name Contains A' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 2)
	public void changesEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [Changes]/filter expando object 'name' fetching value for contains operator");
		changeName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "name");
		String[] changeNames = changeName.split("_");
		changeStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "status");
		APIListener.addLogger("changeStatus: "+changeStatus);
		changeId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "id");
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id","id1");
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"),"id1");
		changesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Contains",changeNames[0],"name","Contains","name1","AND","ChangesFilterUrl");
		changesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Contains",changeName);
		APIListener.addLogger("POST [Changes]/filter expando object 'Name Contains A AND B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 3)
	public void changesEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - POST [Changes]/filter expando object 'name' fetching value for contains operator");
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"),"id1");
		changesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Contains",changeName,"name","Contains","name1","OR","ChangesFilterUrl");
		changesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Contains",changeName);
		APIListener.addLogger("POST [Changes]/filter expando object 'Name Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 4)
	public void changesEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - POST [Changes]/filter expando object 'status' fetching value for contains operator");
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"),"id1");
		changesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",changeStatus,"status","Contains","status1","OR","ChangesFilterUrl");
		changesPage.verifyResponseArrayValues("status",PlutoraAPIConfiguration.testData,"Contains",changeStatus);
		APIListener.addLogger("POST [Changes]/filter expando object 'Status Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 5)
	public void changesEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - POST [Changes]/filter expando object 'name' fetching value for equals operator");
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"),"id1");
		changesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Equals",changeName,"name","Equals","name1","OR","ChangesFilterUrl");
		changesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Equals",changeName);
		APIListener.addLogger("POST [Changes]/filter expando object 'Name Equals A OR B' fetching value for Equals operator successfully!"); 
	}


	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 6)
	public void changesSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'name' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 7)
	public void changesSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'Name Contains A AND B' fetching value for contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changeName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "name");
		//String[] changeNames = changeName.split("_");
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"name","ASC","name","Contains","name","ASC","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 8)
	public void changesSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'Status Contains A OR B' fetching value for contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		String value = changeStatus+";"+"status1";
		changesPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'Status Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Changes]/filter", groups = { "RegressionTests" },priority = 9)
	public void changesSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'Name IsWithIn A OR B' fetching value for IsWithIn operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		String value = changeName+";"+"name1";
		changesPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"name","ASC",value,"IsWithIn","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"IsWithIn");
		APIListener.addLogger( "Changes attribute 'Name IsWithIn A OR B' fetching value for IsWithIn operator successfully!");
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData);
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData,changeId);
	}

}

