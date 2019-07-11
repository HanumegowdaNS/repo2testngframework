package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.RequirementsPage;

public class CategorySettingsEO  {

	RequirementsPage requirementPage = new RequirementsPage();
	String categorySettingsName = null;
	String categorySettingsStatus = null;
	String categorySettingsId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "API - Category Settings Expando Object", groups = { "RegressionTests" }, priority = 1)
	public void categorySettingsEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "API - Category Settings Expando Object attribute 'Name' fetching value for Contains operator"); 
		requirementPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"Name","Contains","searchCategorySettingsName1","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Category Settings expando object fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 2)
	public void categorySettingsEOCombinationFilter_2() throws ParseException {
		APIListener.addLogger( "[API] - POST [Category Settings]/filter expando object 'Name' fetching value for contains A And B operator");
		categorySettingsName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchCategorySettingsName1");
		String[] categorySettingsNames = categorySettingsName.split("_");
		categorySettingsStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchCategorySettingsStatus1");
		APIListener.addLogger("CategorySettingsStatus: "+ categorySettingsStatus);
		categorySettingsId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchCategorySettingsId1");
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",categorySettingsNames[0],"Name","Contains","searchCategorySettingsName1","AND","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger("POST [Category Settings]/filter expando object 'Name Contains A and B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 3)
	public void categorySettingsEOCombinationFilter_3() throws ParseException, InterruptedException{
		APIListener.addLogger( "API - Category Settings Expando Object attribute 'Name' fetching value for Contains A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",categorySettingsName,"Name","Contains","searchCategorySettingsName2","OR","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchCategorySettingsName1;searchCategorySettingsName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Category Settings]/filter expando object 'Name Contains A or B' for Contains operator successfully!"); 
	}

	/*//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 4)
	public void categorySettingsEOCombinationFilter_4() throws ParseException, InterruptedException{
		APIListener.addLogger( "API - Category Settings Expando Object attribute 'Status' fetching value for Contains A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",categorySettingsStatus,"status","Contains","searchCategorySettingsStatus2","OR","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchCategorySettingsStatus1;searchCategorySettingsStatus2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "POST [Category Settings]/filter expando object 'Status Contains A or B' for Contains operator successfully!"); 
	}*/

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 5)
	public void categorySettingsEOCombinationFilter_4() throws ParseException, InterruptedException{
		APIListener.addLogger( "API - Category Settings Expando Object attribute 'Name' fetching value for Equals A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Equals",categorySettingsName,"Name","Equals","searchCategorySettingsName2","OR","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchCategorySettingsName1;searchCategorySettingsName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Category Settings]/filter expando object 'Name Equals A or B' for Contains operator successfully!"); 
		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 6)
	public void categorySettingsSearchCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "API - Category Settings Search Filter attribute 'Name' fetching value for Contains operator"); 
		requirementPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchCategorySettingsName1","Contains","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Category Settings expando object fetching value for Contains operator successfully!"); 		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 7)
	public void categorySettingsSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - Category Settings attribute 'Name Contains A AND B' fetching value for contains operator"); 
		requirementPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"Name","ASC","searchCategorySettingsName1","Contains","Name","ASC","Contains","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Category Settings attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	/*//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 8)
	public void categorySettingsSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Category Settings attribute 'Status Contains A OR B' fetching value for contains operator"); 
		String value = categorySettingsStatus+";"+"searchCategorySettingsStatus2";
		requirementPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "Category Settings attribute 'status' Contains A OR B' fetching value for Contains operator successfully!");
	}*/

	//SEARCHFILTER COMBINATIONS ->IsWithin
	@Test(description = "POST [Category Settings]/filter", groups = { "RegressionTests" },priority = 9)
	public void categorySettingsSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Category Settings attribute 'Name Contains A OR B' fetching value for IsWithIn operator"); 
		String value = categorySettingsName+";"+"searchCategorySettingsName2";
		requirementPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"Name","ASC",value,"IsWithIn","CategorySettingsSearchUrl");
		requirementPage.verifyResponseArrayValue("searchCategorySettingsName1",PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.Name");
		APIListener.addLogger( "Category Settings attribute 'Name Contains A OR B' fetching value for IsWithin operator successfully!");
	}



}

