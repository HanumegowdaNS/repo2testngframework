package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TestCasePage;

public class TestcaseExecutionSummarySearchEO  {

	TestCasePage testcasePage = new TestCasePage();
	String testcaseName = null;
	String testcaseStatus = null;
	String testcaseId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "API - Testcase Execution Summary Search Expando Object", groups = { "RegressionTests" }, priority = 1)
	public void testcaseExecutionSummaryEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "API - Testcase Execution Summary Search Expando Object attribute 'Name' fetching value for Contains operator"); 
		testcasePage.filterEOValueData("request4374ValueTestCaseEOJson", PlutoraAPIConfiguration.testData,"Name","Contains","searchTestcaseName1","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testcase Execution Summary Search expando object fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 2)
	public void testcaseExecutionSummaryEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [Testcase Execution Summary Search]/filter expando object 'Name' fetching value for contains A And B operator");
		testcaseName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestcaseName1");
		String[] testcaseNames = testcaseName.split("_");
		testcaseStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestcaseStatus1");
		APIListener.addLogger("testcaseStatu: "+ testcaseStatus);
		testcaseId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchTestcaseId1");
		testcasePage.filterEOValueData("request4374ValueTestCaseEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",testcaseNames[0],"Name","Contains","searchTestcaseName1","AND","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger("POST [Testcase Execution Summary Search]/filter expando object 'Name Contains A and B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 3)
	public void testcaseExecutionSummaryEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "API - Testcase Execution Summary Search Expando Object attribute 'Name' fetching value for Contains A or B operator"); 
		testcasePage.filterEOValueData("request4374ValueTestCaseEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",testcaseName,"Name","Contains","searchTestcaseName2","OR","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayTestDataValues("searchTestcaseName1;searchTestcaseName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Testcase Execution Summary Search]/filter expando object 'Name Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 4)
	public void testcaseExecutionSummaryEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "API - Testcase Execution Summary Search Expando Object attribute 'Status' fetching value for Contains A or B operator"); 
		testcasePage.filterEOValueData("request4374ValueTestCaseEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",testcaseStatus,"status","Contains","searchTestcaseStatus2","OR","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayTestDataValues("searchTestcaseStatus1;searchTestcaseStatus2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "POST [Testcase Execution Summary Search]/filter expando object 'Status Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 5)
	public void testcaseExecutionSummaryEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "API - Testcase Execution Summary Search Expando Object attribute 'Name' fetching value for Equals A or B operator"); 
		testcasePage.filterEOValueData("request4374ValueTestCaseEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Equals",testcaseName,"Name","Equals","searchTestcaseName2","OR","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayTestDataValues("searchTestcaseName1;searchTestcaseName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Testcase Execution Summary Search]/filter expando object 'Name Equals A or B' for Contains operator successfully!"); 
		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 6)
	public void testcaseExecutionSummarySearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "API - Testcase Execution Summary Search Search Filter attribute 'Name' fetching value for Contains operator"); 
		testcasePage.filterValueData("request4265TestCaseValueJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestcaseName1","Contains","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testcase Execution Summary Search expando object fetching value for Contains operator successfully!"); 		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 7)
	public void testcaseExecutionSummarySearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Testcase Execution Summary Search attribute 'Name Contains A AND B' fetching value for contains operator"); 
		testcasePage.filterSearchFilterValueData("request4374TestCaseSearchFilterJson", PlutoraAPIConfiguration.testData,
				"Name","ASC","searchTestcaseName1","Contains","Name","ASC","Contains","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Testcase Execution Summary Search attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 8)
	public void testcaseExecutionSummarySearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Testcase Execution Summary Search attribute 'Status Contains A OR B' fetching value for contains operator"); 
		String value = testcaseStatus+";"+"searchTestcaseStatus2";
		testcasePage.filterMultipleValueData("request4374TestCaseSearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "Testcase Execution Summary Search attribute 'status' Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->IsWithin
	@Test(description = "POST [Testcase Execution Summary Search]/filter", groups = { "RegressionTests" },priority = 9)
	public void testcaseExecutionSummarySearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Testcase Execution Summary Search attribute 'Name Contains A OR B' fetching value for IsWithIn operator"); 
		String value = testcaseName+";"+"searchTestcaseName2";
		testcasePage.filterMultipleValueData("request4374TestCaseSearchFilterJson", PlutoraAPIConfiguration.testData,"Name","ASC",value,"IsWithIn","TestCaseExecutionSummarySearchUrl");
		testcasePage.verifyResponseArrayValue("searchTestcaseName1",PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.Name");
		APIListener.addLogger( "Testcase Execution Summary Search attribute 'Name Contains A OR B' fetching value for IsWithin operator successfully!");
	}



}

