package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.RequirementsPage;
import com.plutoraapi.pagerepo.TestPlanPage;

public class TestPlanSearch  {

	TestPlanPage testPlanPage = new TestPlanPage();


	//Id
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void testPlanSearch_1() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Id' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"id","ASC","searchTestPlanId","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Id");
		APIListener.addLogger( "Test Plan attribute 'Id' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 2)
	public void testPlanSearch_2() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Id' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchTestPlanId","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Id");
		APIListener.addLogger( "Test Plan attribute 'Id' fetching value for NotEquals operator successfully!"); 
	}

	//Name 
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 3)
	public void testPlanSearch_3() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'name' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestPlanName","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Name");
		APIListener.addLogger( "Test Plan attribute 'Name' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 4)
	public void testPlanSearch_4() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'name' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestPlanName","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Name");
		APIListener.addLogger( "Test Plan attribute 'Name' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 5)
	public void testPlanSearch_5() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'name' fetching value for Contains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestPlanName","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Test Plan attribute 'Name' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 6)
	public void testPlanSearch_6() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'name' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestPlanName","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanName",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Name");
		APIListener.addLogger( "Test Plan attribute 'Name' fetching value for NotContains operator successfully!"); 
	}

	//Type
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 7)
	public void testPlanSearch_7() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Type' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Type","ASC","searchTestPlanType","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanType",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Type");
		APIListener.addLogger( "Test Plan attribute 'Type' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 8)
	public void testPlanSearch_8() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Type' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Type","ASC","searchTestPlanType","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanType",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Type");
		APIListener.addLogger( "Test Plan attribute 'Type' fetching value for NotEquals operator successfully!"); 
	}

	//Status
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 9)
	public void testPlanSearch_9() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Status' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Status","ASC","searchTestPlanStatus","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanStatus",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Status");
		APIListener.addLogger( "Test Plan attribute 'Status' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 10)
	public void testPlanSearch_10() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Status' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Status","ASC","searchTestPlanStatus","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanStatus",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Status");
		APIListener.addLogger( "Test Plan attribute 'Status' fetching value for NotEquals operator successfully!"); 
	}

	//CreatedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 11)
	public void testPlanSearch_11() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 12)
	public void testPlanSearch_12() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 13)
	public void testPlanSearch_13() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for GreaterThan operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","GreaterThan","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 14)
	public void testPlanSearch_14() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for GreaterOrEqual operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","GreaterOrEqual","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 15)
	public void testPlanSearch_15() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for LessThan operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","LessThan","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 16)
	public void testPlanSearch_16() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'CreatedDate' fetching value for LessOrEqual operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestPlanCreatedDate","LessOrEqual","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanCreatedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Plan attribute 'CreatedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//ModifiedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 17)
	public void testPlanSearch_17() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 18)
	public void testPlanSearch_18() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 19)
	public void testPlanSearch_19() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for GreaterThan operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","GreaterThan","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 20)
	public void testPlanSearch_20() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for GreaterOrEqual operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","GreaterOrEqual","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 21)
	public void testPlanSearch_21() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for LessThan operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","LessThan","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 22)
	public void testPlanSearch_22() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'ModifiedDate' fetching value for LessOrEqual operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestPlanModifiedDate","LessOrEqual","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Plan attribute 'ModifiedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//DisplayId
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 23)
	public void testPlanSearch_23() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'DisplayId' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestPlanDisplayId","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDisplayId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Plan attribute 'DisplayId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 24)
	public void testPlanSearch_24() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'DisplayId' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestPlanDisplayId","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDisplayId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Plan attribute 'DisplayId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 25)
	public void testPlanSearch_25() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'DisplayId' fetching value for Contains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestPlanDisplayId","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDisplayId",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Plan attribute 'DisplayId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 26)
	public void testPlanSearch_26() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'DisplayId' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestPlanDisplayId","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDisplayId",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Plan attribute 'DisplayId' fetching value for NotContains operator successfully!"); 
	}

	//Description
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 27)
	public void testPlanSearch_27() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Description' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchTestPlanDescription","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDescription",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Description");
		APIListener.addLogger( "Test Plan attribute 'Description' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 28)
	public void testPlanSearch_28() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Description' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchTestPlanDescription","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDescription",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Description");
		APIListener.addLogger( "Test Plan attribute 'Description' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 29)
	public void testPlanSearch_29() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Description' fetching value for Contains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchTestPlanDescription","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDescription",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Description");
		APIListener.addLogger( "Test Plan attribute 'Description' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 30)
	public void testPlanSearch_30() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan attribute 'Description' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchTestPlanDescription","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchTestPlanDescription",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Description");
		APIListener.addLogger( "Test Plan attribute 'Description' fetching value for NotContains operator successfully!"); 
	}
	
	//Filter by Modified By
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 31)
	public void testPlanSearch_31() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 32)
	public void testPlanSearch_32() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 33)
	public void testPlanSearch_33() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 34)
	public void testPlanSearch_34() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 35)
	public void testPlanSearch_35() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 36)
	public void testPlanSearch_36() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName2","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 37)
	public void testPlanSearch_37() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"IsWithin","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 38)
	public void testPlanSearch_38() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"NotWithin","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'ModifiedBy' fetching value for Not Within operator successfully!"); 
	}
	
	
	// Filter by Created by 
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 39)
	public void testPlanSearch_39() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for Equals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Equals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 40)
	public void testPlanSearch_40() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for NotEquals operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","NotEquals","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 41)
	public void testPlanSearch_41() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 42)
	public void testPlanSearch_42() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","NotContains","TestCaseSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 43)
	public void testPlanSearch_43() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Contains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description ="API - Search Test Plan", groups = { "RegressionTests" }, priority = 44)
	public void testPlanSearch_44() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName2","NotContains","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 45)
	public void  testPlanSearch_45() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"IsWithin","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 46)
	public void testPlanSearch_46() throws ParseException{
		APIListener.addLogger( "[API] - Test Plan Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		testPlanPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"NotWithin","TestPlanSearchUrl");
		testPlanPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testPlanPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Test Plan attribute 'CreatedBy' fetching value for Not Within operator successfully!"); 
	}

}

