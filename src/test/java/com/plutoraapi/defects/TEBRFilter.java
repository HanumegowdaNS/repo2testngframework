package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TEBRPage;

public class TEBRFilter  {

	TEBRPage tebrPage = new TEBRPage();

	//Equals
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 1)
	public void tebrFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'id' fetching value for Equals operator"); 
		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'id' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 2)
	public void tebrFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'number' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"number","ASC","number","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("number",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'number' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 3)
	public void tebrFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'title' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'title' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 4)
	public void tebrFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'assignedTo' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"assignedTo","ASC","assignedTo","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("assignedTo",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'assignedTo' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 5)
	public void tebrFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 6)
	public void tebrFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 7)
	public void tebrFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'description' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'description' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 8)
	public void tebrFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'releaseName' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'releaseName' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 9)
	public void tebrFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'statusID' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"statusID","ASC","statusID","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("statusID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'statusID' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 10)
	public void tebrFilter_10() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'status' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'status' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 11)
	public void tebrFilter_11() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'type' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"type","ASC","type","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("type",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'type' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 12)
	public void tebrFilter_12() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for Equals operator successfully!"); 
	}
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 13)
	public void tebrFilter_13() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedBy' fetching value for Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedBy' fetching value for Equals operator successfully!"); 
	}

	//NotEquals
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 14)
	public void tebrFilter_14() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'id' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'id' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 15)
	public void tebrFilter_15() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'number' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"number","ASC","number","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("number",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'number' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 16)
	public void tebrFilter_16() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'title' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'title' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 17)
	public void tebrFilter_17() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'assignedTo' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"assignedTo","ASC","assignedTo","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("assignedTo",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'assignedTo' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 18)
	public void tebrFilter_18() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 19)
	public void tebrFilter_19() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 20)
	public void tebrFilter_20() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'description' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'description' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 21)
	public void tebrFilter_21() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'releaseName' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'releaseName' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 22)
	public void tebrFilter_22() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'statusID' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"statusID","ASC","statusID","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("statusID",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'statusID' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 23)
	public void tebrFilter_23() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'status' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'status' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 24)
	public void tebrFilter_24() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'type' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"type","ASC","type","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("type",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'type' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 25)
	public void tebrFilter_25() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for Not Equals operator successfully!"); 
	}
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 26)
	public void tebrFilter_26() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedBy' fetching value for Not Equals operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotEquals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedBy' fetching value for Not Equals operator successfully!"); 
	}

	//Contains
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 27)
	public void tebrFilter_27() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'number' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"number","ASC","number","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("number",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'number' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 28)
	public void tebrFilter_28() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'title' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'title' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 29)
	public void tebrFilter_29() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'assignedTo' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"assignedTo","ASC","assignedTo","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("assignedTo",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'assignedTo' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 30)
	public void tebrFilter_30() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'description' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'description' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 31)
	public void tebrFilter_31() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'releaseName' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'releaseName' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 32)
	public void tebrFilter_32() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'status' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'status' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 33)
	public void tebrFilter_33() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'type' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"type","ASC","type","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("type",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'type' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 34)
	public void tebrFilter_34() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedBy' fetching value for Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Contains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	//Not Contains
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 35)
	public void tebrFilter_35() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'number' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"number","ASC","number","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("number",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'number' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 36)
	public void tebrFilter_36() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'title' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'title' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 37)
	public void tebrFilter_37() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'assignedTo' fetching value for NotContains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"assignedTo","ASC","assignedTo","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("assignedTo",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'assignedTo' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 38)
	public void tebrFilter_38() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'description' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'description' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 39)
	public void tebrFilter_39() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'releaseName' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'releaseName' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 40)
	public void tebrFilter_40() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'status' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'status' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 41)
	public void tebrFilter_41() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'type' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"type","ASC","type","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("type",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'type' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 42)
	public void tebrFilter_42() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedBy' fetching value for Not Contains operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotContains","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedBy' fetching value for Not Contains operator successfully!"); 
	}
	
	//Greater Than
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 43)
	public void tebrFilter_43() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for GreaterThan operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","GreaterThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 44)
	public void tebrFilter_44() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for GreaterThan operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","GreaterThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 45)
	public void tebrFilter_45() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for GreaterThan operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	//GreaterThan or Equal
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 46)
	public void tebrFilter_46() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for Greater or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","GreaterOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for Greater or Equal operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 47)
	public void tebrFilter_47() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for Greater Or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","GreaterOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for Greater Or Equal operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 48)
	public void tebrFilter_48() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for Greater Or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for Greater Or Equal operator successfully!"); 
	}
	
	//Less Than
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 49)
	public void tebrFilter_49() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for Less Than operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","LessThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for Less Than operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 50)
	public void tebrFilter_50() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for LessThan operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","LessThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 51)
	public void tebrFilter_51() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for LessThan operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessThan","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for LessThan operator successfully!"); 
	}
	
	//Less Than or Equal
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 52)
	public void tebrFilter_52() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'startDate' fetching value for Less or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","LessOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TEBRs attribute 'startDate' fetching value for Less or Equal operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 53)
	public void tebrFilter_53() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'endDate' fetching value for Less Or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"endDate","ASC","endDate","LessOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("endDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TEBRs attribute 'endDate' fetching value for Less Or Equal operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 54)
	public void tebrFilter_54() throws ParseException{
		APIListener.addLogger( "[API] - TEBR attribute 'lastModifiedDate' fetching value for Less Or Equal operator"); 
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessOrEqual","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TEBRs attribute 'lastModifiedDate' fetching value for Less Or Equal operator successfully!");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
	}
	
	
	
}

