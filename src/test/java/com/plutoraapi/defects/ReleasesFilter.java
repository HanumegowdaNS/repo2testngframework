package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;

public class ReleasesFilter  {

	ReleasesPage releasesPage = new ReleasesPage();

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 1)
	public void releaseFilter_1() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'id' fetching value for Equals operator"); 
		releasesPage.createRelease("createRelease4265Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id"); 
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'id' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 2)
	public void releaseFilter_2() throws ParseException{
		//identifier
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Equals operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"identifier","ASC","identifier","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("identifier",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'identifier' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 3)
	public void releaseFilter_3() throws ParseException{
		//name
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'name' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 4)
	public void releaseFilter_4() throws ParseException{
		//implementationDate
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for Equals operator successfully!");
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 5)
	public void releaseFilter_5() throws ParseException{
		//displayColor
		APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"displayColor","ASC","displayColor","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("displayColor",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'displayColor' fetching value for Equals operator successfully!");
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 6)
	public void releaseFilter_6() throws ParseException{
		//plutoraReleaseType
		APIListener.addLogger( "[API] - Releases attribute 'plutoraReleaseType' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"plutoraReleaseType","ASC","plutoraReleaseType","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("plutoraReleaseType",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'plutoraReleaseType' fetching value for Equals operator successfully!");
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 7)
	public void releaseFilter_7() throws ParseException{
		//lastModifiedDate
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for Equals operator successfully!");
	}

	//Not Equals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 8)
	public void releaseFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'id' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'id' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 9)
	public void releaseFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"identifier","ASC","identifier","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("identifier",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'identifier' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 10)
	public void releaseFilter_10() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'name' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 11)
	public void releaseFilter_11() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 12)
	public void releaseFilter_12() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"displayColor","ASC","displayColor","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("displayColor",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'displayColor' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 13)
	public void releaseFilter_13() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'plutoraReleaseType' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"plutoraReleaseType","ASC","plutoraReleaseType","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("plutoraReleaseType",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'plutoraReleaseType' fetching value for Not Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 14)
	public void releaseFilter_14() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Not Equals operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for Not Equals operator successfully!"); 
	}

	//contains
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 15)
	public void releaseFilter_15() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"identifier","ASC","identifier","Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("identifier",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'identifier' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 16)
	public void releaseFilter_16() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'name' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 17)
	public void releaseFilter_17() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"displayColor","ASC","displayColor","Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("displayColor",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'displayColor' fetching value for Contains operator successfully!"); 
	}

	//not contains
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 18)
	public void releaseFilter_18() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Not Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"identifier","ASC","identifier","NotContains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("identifier",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Releases attribute 'identifier' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 19)
	public void releaseFilter_19() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Not Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","NotContains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Releases attribute 'name' fetching value for Not Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 20)
	public void releaseFilter_20() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for Not Contains operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"displayColor","ASC","displayColor","NotContains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("displayColor",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Releases attribute 'displayColor' fetching value for Not Contains operator successfully!"); 
	}

	//GreaterThan
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 21)
	public void releaseFilter_21() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for GreaterThan operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","GreaterThan","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for GreaterThan operator successfully!"); 
	}
	//GreaterThanEquals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 22)
	public void releaseFilter_22() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for GreaterOrEqual operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","GreaterOrEqual","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	//LessThan
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 23)
	public void releaseFilter_23() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for LessThan operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","LessThan","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for LessThan operator successfully!"); 
	}
	//LessThanEquals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 24)
	public void releaseFilter_24() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for LessOrEqual operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"implementationDate","ASC","implementationDate","LessOrEqual","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("implementationDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "Releases attribute 'implementationDate' fetching value for LessOrEqual operator successfully!"); 
	}
	//GreaterThan
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 25)
	public void releaseFilter_25() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for GreaterThan operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterThan","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}
	//GreaterThanEquals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 26)
	public void releaseFilter_26() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterOrEqual","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	//LessThan
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 27)
	public void releaseFilter_27() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for LessThan operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessThan","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for LessThan operator successfully!"); 
	}
	//LessThanEquals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 28)
	public void releaseFilter_28() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for LessOrEqual operator");
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessOrEqual","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "Releases attribute 'lastModifiedDate' fetching value for LessOrEqual operator successfully!");
	}

	//releaseStatusType - equals,not equals,contains,not contains R8103P-D-4488
	@Test(description = "API - implement ability to filter by releaseStatusType parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 29)
	public void releaseFilter_R8103PD4488_29() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for Equals operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusType","ASC","releaseStatusType","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusType",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'releaseStatusType' fetching value for Equals operator is successfully!"); 
	}
	@Test(description = "API - implement ability to filter by releaseStatusType parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 30)
	public void releaseFilter_R8103PD4488_30() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for NotEquals operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusType","ASC","releaseStatusType","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusType",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'releaseStatusType' fetching value for NotEquals operator is successfully!"); 
	}
	@Test(description = "API - implement ability to filter by releaseStatusType parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 31)
	public void releaseFilter_R8103PD4488_31() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for Contains operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusType","ASC","releaseStatusType","Contains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusType",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Releases attribute 'releaseStatusType' fetching value for Contains operator is successfully!"); 
	}
	@Test(description = "API - implement ability to filter by releaseStatusType parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 32)
	public void releaseFilter_R8103PD4488_32() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for NotContains operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusType","ASC","releaseStatusType","NotContains","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusType",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Releases attribute 'releaseStatusType' fetching value for NotContains operator is successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}

	//releaseStatusTypeID - equals,not equals R8103P-D-4487
	@Test(description = "API - implement ability to filter by releaseStatusTypeID parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 33)
	public void releaseFilter_R8103PD4487_33() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusTypeID' fetching value for Equals operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusTypeID","ASC","releaseStatusTypeID","Equals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusTypeID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Releases attribute 'releaseStatusTypeID' fetching value for Equals operator is successfully!"); 
	}
	@Test(description = "API - implement ability to filter by releaseStatusType parameter in POST releases/filter request (offshore request)", groups = { "RegressionTests" },priority = 34)
	public void releaseFilter_R8103PD4487_34() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'releaseStatusTypeID' fetching value for NotEquals operator"); 
		releasesPage.getReleases(PlutoraAPIConfiguration.testData);
		releasesPage.getAndSetArrayData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ReleaseParametersAttributes"));
		releasesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"releaseStatusTypeID","ASC","releaseStatusTypeID","NotEquals","ReleaseFilterUrl");
		releasesPage.verifyResponseArrayValue("releaseStatusTypeID",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Releases attribute 'releaseStatusTypeID' fetching value for NotEquals operator is successfully!"); 
	}

	@Test(description = "API - Verify isWithin operator for releases filter", groups = { "RegressionTests" }, priority = 35)
	public void releaseFilter_35() throws ParseException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		releasesPage.searchValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC",value,"IsWithin","ReleaseFilterUrl");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"IsWithin");
		APIListener.addLogger( "Releases attribute 'name' fetching value for  IsWithin operator successfully!"); 
	}

}

