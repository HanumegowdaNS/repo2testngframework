package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.RequirementsPage;

public class RequirementSearchEO  {

	RequirementsPage requirementPage = new RequirementsPage();
	String requirementName = null;
	String requirementStatus = null;
	String requirementId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "API - Requirement Expando Object", groups = { "RegressionTests" }, priority = 1)
	public void requirementEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "API - Requirement Expando Object attribute 'Name' fetching value for Contains operator"); 
		requirementPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"Name","Contains","searchRequirementName1","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement expando object fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 2)
	public void requirementEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [Requirement]/filter expando object 'Name' fetching value for contains A And B operator");
		requirementName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchRequirementName1");
		String[] requirementNames = requirementName.split("_");
		requirementStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchRequirementStatus1");
		APIListener.addLogger("requirementStatu: "+ requirementStatus);
		requirementId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "searchRequirementId1");
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",requirementNames[0],"Name","Contains","searchRequirementName1","AND","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger("POST [Requirement]/filter expando object 'Name Contains A and B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 3)
	public void requirementEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "API - Requirement Expando Object attribute 'Name' fetching value for Contains A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Contains",requirementName,"Name","Contains","searchRequirementName2","OR","RequirementSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchRequirementName1;searchRequirementName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Requirement]/filter expando object 'Name Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 4)
	public void requirementEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "API - Requirement Expando Object attribute 'Status' fetching value for Contains A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",requirementStatus,"status","Contains","searchRequirementStatus2","OR","RequirementSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchRequirementStatus1;searchRequirementStatus2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "POST [Requirement]/filter expando object 'Status Contains A or B' for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 5)
	public void requirementEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "API - Requirement Expando Object attribute 'Name' fetching value for Equals A or B operator"); 
		requirementPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"Name","Equals",requirementName,"Name","Equals","searchRequirementName2","OR","RequirementSearchUrl");
		requirementPage.verifyResponseArrayTestDataValues("searchRequirementName1;searchRequirementName2",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "POST [Requirement]/filter expando object 'Name Equals A or B' for Contains operator successfully!"); 
		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 6)
	public void requirementSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "API - Requirement Search Filter attribute 'Name' fetching value for Contains operator"); 
		requirementPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchRequirementName1","Contains","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement expando object fetching value for Contains operator successfully!"); 		
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 7)
	public void requirementSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Requirement attribute 'Name Contains A AND B' fetching value for contains operator"); 
		requirementPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"Name","ASC","searchRequirementName1","Contains","Name","ASC","Contains","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 8)
	public void requirementSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Requirement attribute 'Status Contains A OR B' fetching value for contains operator"); 
		String value = requirementStatus+";"+"searchRequirementStatus2";
		requirementPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementStatus1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Status.Value");
		APIListener.addLogger( "Requirement attribute 'status' Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->IsWithin
	@Test(description = "POST [Requirement]/filter", groups = { "RegressionTests" },priority = 9)
	public void requirementSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Requirement attribute 'Name Contains A OR B' fetching value for IsWithIn operator"); 
		String value = requirementName+";"+"searchRequirementName2";
		requirementPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"Name","ASC",value,"IsWithIn","RequirementSearchUrl");
		requirementPage.verifyResponseArrayValue("searchRequirementName1",PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name Contains A OR B' fetching value for IsWithin operator successfully!");
	}



}

