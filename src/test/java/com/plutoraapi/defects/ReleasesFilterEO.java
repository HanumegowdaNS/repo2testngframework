package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;

public class ReleasesFilterEO  {

	ReleasesPage releasesPage = new ReleasesPage();
	String releaseName = null;
	String releaseStatus = null;
	String releaseId = null;

	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "POST [releases]/filter", groups = { "RegressionTests" },priority = 1)
	public void releasesEOFilter_1() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases expando object 'identifier' fetching value for Contains operator"); 
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"name","Contains","name","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases expando object for 'name' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Name AND
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 2)
	public void releasesEOCombinationFilter_2() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - POST [Releases]/filter expando object 'name' fetching value for contains operator");
		releaseName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "name");
		String[] releaseNames = releaseName.split("_");
		releaseStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releaseStatusType");
		APIListener.addLogger("releaseStatusType: "+ releaseStatus);
		releaseId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "id");
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","id1");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"),"id1");
		releasesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Contains",releaseNames[0],"name","Contains","name1","AND","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Contains",releaseName);
		APIListener.addLogger("POST [Releases]/filter expando object 'Name Contains A AND B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains Name OR
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 3)
	public void releasesEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - POST [Releases]/filter expando object 'name' fetching value for contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"),"id1");
		releasesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Contains",releaseName,"name","Contains","name1","OR","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Contains",releaseName);
		APIListener.addLogger("POST [Releases]/filter expando object 'Name Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status OR
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 4)
	public void releasesEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - POST [Releases]/filter expando object 'status' fetching value for contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"),"id1");
		releasesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"releaseStatusType","Contains",releaseStatus,"releaseStatusType","Contains","releaseStatusType1","OR","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValues("releaseStatusType",PlutoraAPIConfiguration.testData,"Contains",releaseStatus);
		APIListener.addLogger("POST [Releases]/filter expando object 'Status Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals Name OR
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 5)
	public void releasesEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - POST [Releases]/filter expando object 'name' fetching value for equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"),"id1");
		releasesPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"name","Equals",releaseName,"name","Equals","name1","OR","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValues("name",PlutoraAPIConfiguration.testData,"Equals",releaseName);
		APIListener.addLogger("POST [Releases]/filter expando object 'Name Equals A OR B' fetching value for Equals operator successfully!"); 
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 6)
	public void releasesSearchFilter_6() throws ParseException{
		//name
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'name' fetching value for Equals operator successfully!"); 
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 7)
	public void releasesSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'Name Contains A AND B' fetching value for contains operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releaseName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "name");
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"name","ASC","name","Contains","name","ASC","Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'Name Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 8)
	public void releasesSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'Status Contains A OR B' fetching value for contains operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		String value = releaseStatus+";"+"releaseStatusType1";
		releasesPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"releaseStatusType","ASC",value,"Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusType",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'releaseStatusType Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "POST [Releases]/filter", groups = { "RegressionTests" },priority = 9)
	public void releasesSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'Name IsWithin A OR B' fetching value for IsWithin operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		String value = releaseName+";"+"name1";
		releasesPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"name","ASC",value,"IsWithin","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"IsWithin");
		APIListener.addLogger( "Releases attribute 'Name IsWithin A OR B' fetching value for IsWithin operator successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData,releaseId);
	}




}

