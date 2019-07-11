package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;

public class ChangesFilter  {
 
	ChangesPage changesPage = new ChangesPage(); 

	//Equals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 1)
	public void changesFilter_1() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'id' fetching value for Equals operator"); 
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.setDataToProperty("id");
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"id","ASC","id","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Changes attribute 'id' fetching value for Equals operator successfully!"); 
	}
	   
	@Test(description = "API - Get Releases, TECRsand TEBRs based on last updated date", groups = { "RegressionTests" },priority = 2)
	public void changesFilter_2() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'name' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 3)
	public void changesFilter_3() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 4)
	public void changesFilter_4() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"priority","ASC","changePriority","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("priority",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'priority' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 5)
	public void changesFilter_5() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'status' fetching value for Equals operator successfully!"); 
	}

	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 6)
	public void changesFilter_6() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 7)
	public void changesFilter_7() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedBy","ASC","raisedBy","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedBy",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 8)
	public void changesFilter_8() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 9)
	public void changesFilter_9() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 10)
	public void changesFilter_10() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Equals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Equals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for Equals operator successfully!"); 
	}

	//Not Equals
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 11)
	public void changesFilter_11() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'name' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 12)
	public void changesFilter_12() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'name' fetching value for NotEquals operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 13)
	public void changesFilter_13() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 14)
	public void changesFilter_14() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"priority","ASC","changePriority","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("priority",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'priority' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 15)
	public void changesFilter_15() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'status' fetching value for NotEquals operator successfully!"); 
	}

	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 16)
	public void changesFilter_16() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 17)
	public void changesFilter_17() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedBy","ASC","raisedBy","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedBy",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 18)
	public void changesFilter_18() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 19)
	public void changesFilter_19() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 20)
	public void changesFilter_20() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for NotEquals operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotEquals","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotEquals");
		APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for NotEquals operator successfully!"); 
	}
	
	//Contains
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 21)
	public void changesFilter_21() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'name' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 22)
	public void changesFilter_22() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 23)
	public void changesFilter_23() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"priority","ASC","changePriority","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("priority",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'priority' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 24)
	public void changesFilter_24() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'status' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 25)
	public void changesFilter_25() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedBy","ASC","raisedBy","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedBy",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for Contains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 26)
	public void changesFilter_26() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Contains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Contains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	//Not Contains
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 27)
	public void changesFilter_27() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"name","ASC","name","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("name",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'name' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 28)
	public void changesFilter_28() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for NotContains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 29)
	public void changesFilter_29() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"priority","ASC","changePriority","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("priority",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'priority' fetching value for NotContains operator successfully!"); 
	}

	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 30)
	public void changesFilter_30() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"status","ASC","status","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("status",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'status' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 31)
	public void changesFilter_31() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedBy","ASC","raisedBy","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedBy",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for NotContains operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 32)
	public void changesFilter_32() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for NotContains operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","NotContains","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"NotContains");
		APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for NotContains operator successfully!"); 
	}
	
	//Greater Than
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 33)
	public void changesFilter_33() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for GreaterThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","GreaterThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"GreaterThanNumber");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 34)
	public void changesFilter_34() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for GreaterThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","GreaterThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"GreaterThanNumber");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 35)
	public void changesFilter_35() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for GreaterThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","GreaterThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 36)
	public void changesFilter_36() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for GreaterThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}
	
	//GreaterThan Or Equal
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 37)
	public void changesFilter_37() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for GreaterOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","GreaterOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"GreaterOrEqualNumber");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 38)
	public void changesFilter_38() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for GreaterOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","GreaterOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"GreaterOrEqualNumber");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 39)
	public void changesFilter_39() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for GreaterOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","GreaterOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 40)
	public void changesFilter_40() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","GreaterOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}
	
	//Less Than
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 41)
	public void changesFilter_41() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for LessThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","LessThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"LessThanNumber");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 42)
	public void changesFilter_42() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for LessThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","LessThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"LessThanNumber");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 43)
	public void changesFilter_43() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for LessThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","LessThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for LessThan operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 44)
	public void changesFilter_44() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for LessThan operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessThan","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessThan");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for LessThan operator successfully!"); 
	}
	
	//Less Or Equal
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 45)
	public void changesFilter_45() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'changeId' fetching value for LessOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"changeId","ASC","changeId","LessOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("changeId",PlutoraAPIConfiguration.testData,"LessOrEqualNumber");
		APIListener.addLogger( "Changes attribute 'changeId' fetching value for LessOrEqual operator successfully!"); 
	}
	 
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 46)
	public void changesFilter_46() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for LessOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"businessValueScore","ASC","businessValueScore","LessOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("businessValueScore",PlutoraAPIConfiguration.testData,"LessOrEqualNumber");
		APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for LessOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 47)
	public void changesFilter_47() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'raisedDate' fetching value for LessOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"raisedDate","ASC","raisedDate","LessOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("raisedDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "Changes attribute 'raisedDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	@Test(description = "API - Get Releases, TECR�s and TEBR�s based on last updated date", groups = { "RegressionTests" },priority = 48)
	public void changesFilter_48() throws ParseException{
		APIListener.addLogger( "[API] - Changes attribute 'lastModifiedDate' fetching value for LessOrEqual operator"); 
		changesPage.getChanges(PlutoraAPIConfiguration.testData);
		changesPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ChangesParameterAttributes"));
		changesPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","LessOrEqual","ChangesFilterUrl");
		changesPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual");
		APIListener.addLogger( "Changes attribute 'lastModifiedDate' fetching value for LessOrEqual operator successfully!");
		changesPage.deleteChanges(PlutoraAPIConfiguration.testData);
	}
	
}

