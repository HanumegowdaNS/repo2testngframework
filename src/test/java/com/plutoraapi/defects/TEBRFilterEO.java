package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TEBRPage;

public class TEBRFilterEO  {

	TEBRPage tebrPage = new TEBRPage();
	String TEBRName = null;
	String TEBRStatus = null;
	String TEBRId = null;


	//EXPANDOOBJECT COMBINATIONS -> Contains
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 1)
	public void tebrEOCombinationFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - POST [TEBR]/filter expando object 'title' fetching value for contains operator"); 
		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterEOValueData("request4374ValueEOJson", PlutoraAPIConfiguration.testData,"title","Contains","title","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "POST [TEBR]/filter expando object 'title' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains A AND B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 2)
	public void tebrEOCombinationFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - POST [TEBR]/filter expando object 'title' fetching value for contains operator");
		TEBRName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "title");
		String[] TEBRNames = TEBRName.split("_");
		TEBRStatus = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "status");
		APIListener.addLogger("TEBRStatus: "+TEBRStatus);
		TEBRId = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "id");
		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id","id1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"),"id1");
		tebrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Contains",TEBRNames[0],"title","Contains","title1","AND","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Contains",TEBRName);
		APIListener.addLogger("POST [TEBR]/filter expando object 'Title Contains A AND B' fetching value for Contains operator successfully!"); 
	}


	//EXPANDOOBJECT COMBINATIONS -> Contains A OR B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 3)
	public void tebrEOCombinationFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - POST [TEBR]/filter expando object 'title' fetching value for contains operator");
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"),"id1");
		tebrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Contains",TEBRName,"title","Contains","title1","OR","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Contains",TEBRName);
		APIListener.addLogger("POST [TEBR]/filter expando object 'Title Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Contains Status A OR B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 4)
	public void tebrEOCombinationFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - POST [TEBR]/filter expando object 'status' fetching value for contains operator");
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"),"id1");
		tebrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"status","Contains",TEBRStatus,"status","Contains","status1","OR","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValues("status",PlutoraAPIConfiguration.testData,"Contains",TEBRStatus);
		APIListener.addLogger("POST [TEBR]/filter expando object 'Status Contains A OR B' fetching value for Contains operator successfully!"); 
	}

	//EXPANDOOBJECT COMBINATIONS -> Equals A OR B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 5)
	public void tebrEOCombinationFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - POST [TEBR]/filter expando object 'title' fetching value for Equals operator");
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"),"id1");
		tebrPage.filterEOValueData("request4374ValueEOMultipleJson", PlutoraAPIConfiguration.testData,"title","Equals",TEBRName,"title","Equals","title1","OR","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValues("title",PlutoraAPIConfiguration.testData,"Equals",TEBRName);
		APIListener.addLogger("POST [TEBR]/filter expando object 'Title Equals A OR B' fetching value for Equals operator successfully!"); 
	}


	//SEARCHFILTER COMBINATIONS -> Title contains A
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 6)
	public void tebrSearchCombinationFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'title' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'title' fetching value for Contains operator successfully!"); 
	}

	//SEARCHFILTER COMBINATIONS -> title contains A And B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 7)
	public void tebrSearchCombinationFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'Title Contains A AND B' fetching value for contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		TEBRName = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "title");
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterSearchFilterValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,
				"title","ASC","title","Contains","title","ASC","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'Title Contains A AND B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS -> Status contains A Or B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 8)
	public void tebrSearchCombinationFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'Status Contains A OR B' fetching value for contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		String value = TEBRStatus+";"+"status1";
		tebrPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"status","ASC",value,"Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'Status Contains A OR B' fetching value for Contains operator successfully!");
	}

	//SEARCHFILTER COMBINATIONS -> Title Equals A OR B
	@Test(description = "POST [TEBR]/filter", groups = { "RegressionTests" },priority = 9)
	public void tebrsSearchCombinationFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'Title IsWithIn A OR B' fetching value for IsWithIn operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		String value = TEBRName+";"+"title1";
		tebrPage.filterMultipleValueData("request4374SearchFilterJson", PlutoraAPIConfiguration.testData,"title","ASC",value,"IsWithIn","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"IsWithIn");
		APIListener.addLogger( "TEBRs attribute 'Title IsWithIn A OR B' fetching value for IsWithIn operator successfully!");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData,TEBRId);
	}



}

