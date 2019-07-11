package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TestPlanPage;

public class TestplanSearchEO  {

	TestPlanPage testplanPage = new TestPlanPage();
	String testplanName = null;
	String testplanStatus = null;
	String testplanId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "API - Testplan Expando Object", groups = { "RegressionTests" }, priority = 1)
	public void testplanEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "API - Testplan Expando Object attribute 'Name' fetching value for Contains operator"); 
		testplanPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"Name","Contains","searchTestplanName1","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testplan expando object fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 2)
	public void testplanEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [Testplan]/filter expando object 'Name' fetching value for contains A And B operator");
		testplanName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestplanName1");
		String[] testplanNames = testplanName.split("_");
		testplanStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestplanStatus1");
		APIListener.addLogger("testplanStatus: "+ testplanStatus);
		testplanId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestplanId1");
		testplanPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",testplanNames[0],"Name","Contains","searchTestplanName1","AND","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger("POST [Testplan]/filter expando object 'Name Contains A and B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 3)
	public void testplanEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "API - Testplan Expando Object attribute 'Name' fetching value for Contains A or B operator"); 
		testplanPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",testplanName,"Name","Contains","searchTestplanName2","OR","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayTestDataValues("searchTestplanName1;searchTestplanName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Testplan]/filter expando object 'Name Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 4)
	public void testplanEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "API - Testplan Expando Object attribute 'Status' fetching value for Contains A or B operator"); 
		testplanPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",testplanStatus,"status","Contains","searchTestplanStatus2","OR","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayTestDataValues("searchTestplanStatus1;searchTestplanStatus2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status");
		APIListener.addLogger( "POST [Testplan]/filter expando object 'Status Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 5)
	public void testplanEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "API - Testplan Expando Object attribute 'Name' fetching value for Equals A or B operator"); 
		testplanPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Equals",testplanName,"Name","Equals","searchTestplanName2","OR","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayTestDataValues("searchTestplanName1;searchTestplanName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Testplan]/filter expando object 'Name Equals A or B' for Contains operator successfully!"); 
		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 6)
	public void testplanSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "API - Testplan Search Filter attribute 'Name' fetching value for Contains operator"); 
		testplanPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestplanName1","Contains","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testplan expando object fetching value for Contains operator successfully!"); 		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 7)
	public void testplanSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Testplan attribute 'Name Contains A AND B' fetching value for contains operator"); 
		testplanPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"Name","ASC","searchTestplanName1","Contains","Name","ASC","Contains","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testplan attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 8)
	public void testplanSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Testplan attribute 'Status Contains A OR B' fetching value for contains operator"); 
		String value = testplanStatus+";"+"searchTestplanStatus2";
		testplanPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "Testplan attribute 'status' Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->IsWithin
	@Test(description = "POST [Testplan]/filter", groups = { "RegressionTests" },priority = 9)
	public void testplanSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Testplan attribute 'Name Contains A OR B' fetching value for IsWithIn operator"); 
		String value = testplanName+";"+"searchTestplanName2";
		testplanPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"Name","ASC",value,"IsWithIn","TestPlanSearchUrl");
		testplanPage.verifyResponseArrayValue("searchTestplanName1",PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.Name");
		APIListener.addLogger( "Testplan attribute 'Name Contains A OR B' fetching value for IsWithin operator successfully!");
	}



}

