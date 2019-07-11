package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TECRPage;

public class TECRFilter  {

	TECRPage tecrPage = new TECRPage();

	//Equals
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 1)
	public void tecrFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'id' fetching value for Equals operator"); 
		tecrPage.createTECR("createTECRJsonForFilter", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id");
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'id' fetching value for Equals operator successfully!"); 
	}
	
/*	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 2)
	public void tecrFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'requestNumberIndex' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"requestNumberIndex","ASC","requestNumberIndex","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("requestNumberIndex",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'requestNumberIndex' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 3)
	public void tecrFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'title' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'title' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 4)
	public void tecrFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crType' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crType","ASC","crType","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crType",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'crType' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 5)
	public void tecrFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 6)
	public void tecrFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 7)
	public void tecrFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'description' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'description' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 8)
	public void tecrFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'parentReleaseID' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"parentReleaseID","ASC","parentReleaseID","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("parentReleaseID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'parentReleaseID' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 9)
	public void tecrFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseID' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseID","ASC","releaseID","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'releaseID' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 10)
	public void tecrFilter_10() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseName' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'releaseName' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 11)
	public void tecrFilter_11() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crStatus' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crStatus","ASC","crStatus","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crStatus",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'crStatus' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 12)
	public void tecrFilter_12() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outage' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outage","ASC","outage","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outage",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'outage' fetching value for Equals operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 13)
	public void tecrFilter_13() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		System.out.println(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "outageStartDate"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 14)
	public void tecrFilter_14() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for Equals operator successfully!"); 
	}
	
/*	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 15)
	public void tecrFilter_15() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneId' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneId","ASC","timeZoneId","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneId",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'timeZoneId' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 16)
	public void tecrFilter_16() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for Equals operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 17)
	public void tecrFilter_17() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 18)
	public void tecrFilter_18() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedBy' fetching value for Equals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "TECRs attribute 'lastModifiedBy' fetching value for Equals operator successfully!"); 
	}
	
	//NotEqual
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 19)
	public void tecrFilter_19() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'id' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'id' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 20)
	public void tecrFilter_20() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'requestNumberIndex' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"requestNumberIndex","ASC","requestNumberIndex","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("requestNumberIndex",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'requestNumberIndex' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 21)
	public void tecrFilter_21() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'title' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'title' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 22)
	public void tecrFilter_22() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crType' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crType","ASC","crType","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crType",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'crType' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 23)
	public void tecrFilter_23() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 24)
	public void tecrFilter_24() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 25)
	public void tecrFilter_25() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'description' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'description' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 26)
	public void tecrFilter_26() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'parentReleaseID' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"parentReleaseID","ASC","parentReleaseID","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("parentReleaseID",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'parentReleaseID' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 27)
	public void tecrFilter_27() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseID' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseID","ASC","releaseID","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseID",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'releaseID' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 28)
	public void tecrFilter_28() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseName' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'releaseName' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 29)
	public void tecrFilter_29() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crStatus' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crStatus","ASC","crStatus","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crStatus",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'crStatus' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 30)
	public void tecrFilter_30() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outage' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outage","ASC","outage","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outage",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'outage' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 31)
	public void tecrFilter_31() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 32)
	public void tecrFilter_32() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for NotEquals operator successfully!"); 
	}
	
	/*@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 33)
	public void tecrFilter_33() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneId' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneId","ASC","timeZoneId","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneId",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'timeZoneId' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 34)
	public void tecrFilter_34() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for NotEquals operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 35)
	public void tecrFilter_35() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 36)
	public void tecrFilter_36() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedBy' fetching value for NotEquals operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotEquals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "TECRs attribute 'lastModifiedBy' fetching value for NotEquals operator successfully!"); 
	}
	
	//Contains
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 37)
	public void tecrFilter_37() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'requestNumberIndex' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"requestNumberIndex","ASC","requestNumberIndex","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("requestNumberIndex",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'requestNumberIndex' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 38)
	public void tecrFilter_38() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'title' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'title' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 39)
	public void tecrFilter_39() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crType' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crType","ASC","crType","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crType",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'crType' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 40)
	public void tecrFilter_40() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'description' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'description' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 41)
	public void tecrFilter_41() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'parentReleaseID' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"parentReleaseID","ASC","parentReleaseID","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("parentReleaseID",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'parentReleaseID' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 42)
	public void tecrFilter_42() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseID' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseID","ASC","releaseID","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseID",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'releaseID' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 43)
	public void tecrFilter_43() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseName' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'releaseName' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 44)
	public void tecrFilter_44() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crStatus' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crStatus","ASC","crStatus","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crStatus",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'crStatus' fetching value for Contains operator successfully!"); 
	}
	
/*	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 45)
	public void tecrFilter_45() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneId' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneId","ASC","timeZoneId","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneId",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'timeZoneId' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 46)
	public void tecrFilter_46() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for Contains operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 47)
	public void tecrFilter_47() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedBy' fetching value for Contains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Contains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "TECRs attribute 'lastModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	//NotContains
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 48)
	public void tecrFilter_48() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'requestNumberIndex' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"requestNumberIndex","ASC","requestNumberIndex","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("requestNumberIndex",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'requestNumberIndex' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 49)
	public void tecrFilter_49() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'title' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"title","ASC","title","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("title",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'title' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 50)
	public void tecrFilter_50() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crType' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crType","ASC","crType","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crType",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'crType' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 51)
	public void tecrFilter_51() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'description' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"description","ASC","description","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("description",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'description' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 52)
	public void tecrFilter_52() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'parentReleaseID' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"parentReleaseID","ASC","parentReleaseID","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("parentReleaseID",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'parentReleaseID' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 53)
	public void tecrFilter_53() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseID' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseID","ASC","releaseID","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseID",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'releaseID' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 54)
	public void tecrFilter_54() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'releaseName' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseName","ASC","releaseName","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("releaseName",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'releaseName' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 55)
	public void tecrFilter_55() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'crStatus' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"crStatus","ASC","crStatus","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("crStatus",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'crStatus' fetching value for NotContains operator successfully!"); 
	}
	
	/*@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 56)
	public void tecrFilter_56() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneId' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneId","ASC","timeZoneId","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneId",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'timeZoneId' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 57)
	public void tecrFilter_57() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for NotContains operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 58)
	public void tecrFilter_58() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedBy' fetching value for NotContains operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotContains","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "TECRs attribute 'lastModifiedBy' fetching value for NotContains operator successfully!");
	}
	
	//GreaterThan
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 59)
	public void tecrFilter_59() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 60)
	public void tecrFilter_60() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 61)
	public void tecrFilter_61() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 62)
	public void tecrFilter_62() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for GreaterThan operator successfully!"); 
	}
	/*
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 63)
	public void tecrFilter_63() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for GreaterThan operator successfully!"); 
	}
	*/
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 64)
	public void tecrFilter_64() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for GreaterThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	//Greater or Equal
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 65)
	public void tecrFilter_65() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 66)
	public void tecrFilter_66() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 67)
	public void tecrFilter_67() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 68)
	public void tecrFilter_68() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	/*@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 69)
	public void tecrFilter_69() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for GreaterOrEqual operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 70)
	public void tecrFilter_70() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	//LessThan
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 71)
	public void tecrFilter_71() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 72)
	public void tecrFilter_72() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 73)
	public void tecrFilter_73() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 74)
	public void tecrFilter_74() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for LessThan operator successfully!"); 
	}
	
	/*@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 75)
	public void tecrFilter_75() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for LessThan operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 76)
	public void tecrFilter_76() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for LessThan operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessThan","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for LessThan operator successfully!"); 
	}
	
	//Greater or Equal
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 77)
	public void tecrFilter_77() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'startDate' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"startDate","ASC","startDate","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("startDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'startDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 78)
	public void tecrFilter_78() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'dueDate' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"dueDate","ASC","dueDate","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("dueDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'dueDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 79)
	public void tecrFilter_79() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageStartDate' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageStartDate","ASC","outageStartDate","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageStartDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'outageStartDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 80)
	public void tecrFilter_80() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'outageEndDate' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"outageEndDate","ASC","outageEndDate","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("outageEndDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'outageEndDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	/*@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 81)
	public void tecrFilter_81() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'timeZoneOffset' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"timeZoneOffset","ASC","timeZoneOffset","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("timeZoneOffset",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'timeZoneOffset' fetching value for LessOrEqual operator successfully!"); 
	}*/
	
	@Test(description = "API - Get Releases, TECR’s and TEBR’s based on last updated date", groups = { "RegressionTests" },priority = 82)
	public void tecrFilter_82() throws ParseException{
		APIListener.addLogger( "[API] - TECR attribute 'lastModifiedDate' fetching value for LessOrEqual operator"); 
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessOrEqual","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "TECRs attribute 'lastModifiedDate' fetching value for LessOrEqual operator successfully!");
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
}

