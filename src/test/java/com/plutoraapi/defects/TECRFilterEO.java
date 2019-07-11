package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TECRPage;

public class TECRFilterEO  {

	TECRPage tecrPage = new TECRPage();
	String TECRName = null;
	String TECRStatus = null;
	String TECRId = null;


	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 1)
	public void tecrCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - POST [TECR]/filter expando object  'title' fetching value for Contains operator"); 
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id");
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"title","Contains","title","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "POST [TECR]/filter expando object 'title' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains A AND B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 2)
	public void tecrEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [TECR]/filter expando object 'title' fetching value for contains operator");
		TECRName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "title");
		String[] TECRNames = TECRName.split("_");
		TECRStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "crStatus");
		APIListener.addLogger("TECRStatus: "+TECRStatus);
		TECRId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "id");
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id","id1");
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"id1");
		tecrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Contains",TECRNames[0],"title","Contains","title1","AND","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Contains",TECRName);
		APIListener.addLogger("POST [TECR]/filter expando object 'Title Contains A AND B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains A OR B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 3)
	public void tecrEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - POST [TECR]/filter expando object 'title' fetching value for contains operator");
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"id1");
		tecrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Contains",TECRName,"title","Contains","title1","OR","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Contains",TECRName);
		APIListener.addLogger("POST [TECR]/filter expando object 'Title Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status A OR B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 4)
	public void tecrEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - POST [TECR]/filter expando object 'status' fetching value for contains operator");
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"id1");
		tecrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"crStatus","Contains",TECRStatus,"crStatus","Contains","crStatus1","OR","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValues("crStatus",PlutoraAPIConfiguration.testData,"Contains",TECRStatus);
		APIListener.addLogger("POST [TECR]/filter expando object 'Status Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals A OR B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 5)
	public void tecrEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - POST [TECR]/filter expando object 'title' fetching value for Equals operator");
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"id1");
		tecrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Equals",TECRName,"title","Equals","title1","OR","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Equals",TECRName);
		APIListener.addLogger("POST [TECR]/filter expando object 'Title Equals A OR B' fetching value for Equals operator successfully!"); 
	}

	//SEARCHFILTER COMBINATIONS ->
	@Test(description = "", groups = { "RegressionTests" },priority = 6)
	public void tecrSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'title' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'title' fetching value for Equals operator successfully!"); 
	}

	//SEARCHFILTER COMBINATIONS -> title contains A And B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 7)
	public void tecrSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'Title Contains A AND B' fetching value for contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		TECRName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "title");
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"title","ASC","title","Contains","title","ASC","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'Title Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS -> Status contains A Or B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 8)
	public void tecrSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'Status Contains A OR B' fetching value for contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		String value = TECRStatus+";"+"crStatus1";
		tecrPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"crStatus","ASC",value,"Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crStatus",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'Status Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS -> Title Equals A OR B
	@Test(description = "POST [TECR]/filter", groups = { "RegressionTests" },priority = 9)
	public void tecrsSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'Title IsWithin A OR B' fetching value for IsWithin operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		String value = TECRName+";"+"title1";
		tecrPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"title","ASC",value,"IsWithin","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"IsWithin");
		APIListener.addLogger( "TECRs attribute 'Title IsWithin A OR B' fetching value for IsWithin operator successfully!");
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData,TECRId);
	}

}

