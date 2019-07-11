package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.DefectsPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.RequirementsPage;

public class DefectsSearchEO  {

	DefectsPage defectsPage = new DefectsPage();
	String defectName = null;
	String defectStatus = null;
	String defectId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "API - Defects Expando Object", groups = { "RegressionTests" }, priority = 1)
	public void defectsEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "API - Defects Expando Object attribute 'Name' fetching value for Contains operator"); 
		defectsPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"Name","Contains","searchDefectsName1","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Defects expando object fetching value for Contains operator successfully!"); 
	}
 
	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 2)
	public void defectsEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [Defects]/filter expando object 'Name' fetching value for contains A And B operator");
		defectName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchDefectsName1");
		String[] defectNames = defectName.split("_");
		defectStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchDefectsStatus1");
		APIListener.addLogger("defectStatus: "+ defectStatus);
		defectId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchDefectsId1");
		defectsPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",defectNames[0],"Name","Contains","searchDefectsName1","AND","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger("POST [Defects]/filter expando object 'Name Contains A and B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 3)
	public void defectsEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "API - Defects Expando Object attribute 'Name' fetching value for Contains A or B operator"); 
		defectsPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",defectName,"Name","Contains","searchDefectsName2","OR","DefectsSearchUrl");
		defectsPage.verifyResponseArrayTestDataValues("searchDefectsName1;searchDefectsName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Defects]/filter expando object 'Name Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 4)
	public void defectsEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "API - Defects Expando Object attribute 'Status' fetching value for Contains A or B operator"); 
		defectsPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",defectStatus,"status","Contains","searchDefectsStatus2","OR","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		defectsPage.verifyResponseArrayTestDataValues("searchDefectsStatus1;searchDefectsStatus2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "POST [Defects]/filter expando object 'Status Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 5)
	public void defectsEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "API - Defects Expando Object attribute 'Name' fetching value for Equals A or B operator"); 
		defectsPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Equals",defectName,"Name","Equals","searchDefectsName2","OR","DefectsSearchUrl");
		defectsPage.verifyResponseArrayTestDataValues("searchDefectsName1;searchDefectsName2",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Defects]/filter expando object 'Name Equals A or B' for Contains operator successfully!"); 
		
	}

	//SEARCHFILTER COMBINATIONS ->Name contains
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 6)
	public void defectsSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "API - Defects Search Filter attribute 'Name' fetching value for Contains operator"); 
		defectsPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchDefectsName1","Equals","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Defects expando object fetching value for Contains operator successfully!"); 		
	}

	//SEARCHFILTER COMBINATIONS ->Name Contains A and B
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 7)
	public void defectsSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Defects attribute 'Name Contains A AND B' fetching value for contains operator"); 
		defectsPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"Name","ASC","searchDefectsName1","Contains","Name","ASC","Contains","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->Status Contains A Or B
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 8)
	public void defectsSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Defects attribute 'Status Contains A OR B' fetching value for contains operator"); 
		String value = defectStatus+";"+"searchDefectsStatus2";
		//String value = defectStatus+";"+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchDefectsStatus2");
		System.out.println(value);
		defectsPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.status.value");
		APIListener.addLogger( "Defects attribute 'status' Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->IsWithIn
	@Test(description = "POST [Defects]/filter", groups = { "RegressionTests" },priority = 9)
	public void defectsSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Defects attribute 'Name Contains A OR B' fetching value for IsWithIn operator"); 
		String value = defectName+";"+"searchDefectsName2";
		defectsPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"Name","ASC",value,"IsWithIn","DefectsSearchUrl");
		defectsPage.verifyResponseArrayValue("searchDefectsName1",PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name Contains A OR B' fetching value for IsWithin operator successfully!");
	}



}

