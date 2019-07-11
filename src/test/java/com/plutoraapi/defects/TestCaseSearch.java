package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.RequirementsPage;
import com.plutoraapi.pagerepo.TestCasePage;

public class TestCaseSearch  {

	TestCasePage testCasePage = new TestCasePage();


	//Id
	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 1)
	public void testCaseSearch_1() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Id' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchTestCaseId","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//testCasePage.setDataToPropertyWithTestData(PlutoraAPIConfiguration.testData,"searchName","searchName");
		testCasePage.verifyResponseArrayValue("searchTestCaseId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Id");
		APIListener.addLogger( "Test Case attribute 'Id' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 2)
	public void testCaseSearch_2() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Id' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchTestCaseId","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Id");
		APIListener.addLogger( "Test Case attribute 'Id' fetching value for NotEquals operator successfully!"); 
	}

	//Name
	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 3)
	public void testCaseSearch_3() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Name' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestCaseName","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Name");
		APIListener.addLogger( "Test Case attribute 'Name' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 4)
	public void testCaseSearch_4() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Name' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestCaseName","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Name");
		APIListener.addLogger( "Test Case attribute 'Name' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 5)
	public void testCaseSearch_5() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Name' fetching value for Contains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestCaseName","Contains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Test Case attribute 'Name' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 6)
	public void testCaseSearch_6() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'Name' fetching value for NotContains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchTestCaseName","NotContains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseName",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Name");
		APIListener.addLogger( "Test Case attribute 'Name' fetching value for NotContains operator successfully!"); 
	}

	//CreatedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 7)
	public void testCaseSearch_7() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 8)
	public void testCaseSearch_8() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 9)
	public void testCaseSearch_9() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for GreaterThan operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","GreaterThan","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 10)
	public void testCaseSearch_10() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for GreaterOrEqual operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","GreaterOrEqual","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 11)
	public void testCaseSearch_11() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for LessThan operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","LessThan","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 12)
	public void testCaseSearch_12() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'CreatedDate' fetching value for LessOrEqual operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchTestCaseCreatedDate","LessOrEqual","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseCreatedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Test Case attribute 'CreatedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//ModifiedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 13)
	public void testCaseSearch_13() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 14)
	public void testCaseSearch_14() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 15)
	public void testCaseSearch_15() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for GreaterThan operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","GreaterThan","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 16)
	public void testCaseSearch_16() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for GreaterOrEqual operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","GreaterOrEqual","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 17)
	public void testCaseSearch_17() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for LessThan operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","LessThan","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 18)
	public void testCaseSearch_18() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'ModifiedDate' fetching value for LessOrEqual operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchTestCaseModifiedDate","LessOrEqual","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Test Case attribute 'ModifiedDate' fetching value for LessOrEqual operator successfully!"); 
	}
	
	//DisplayId
	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 19)
	public void testCaseSearch_19() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 20)
	public void testCaseSearch_20() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 21)
	public void testCaseSearch_21() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for Contains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","Contains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 22)
	public void testCaseSearch_22() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for NotContains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","NotContains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for NotContains operator successfully!"); 
	}

	//Description
	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 23)
	public void testCaseSearch_23() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for Equals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","Equals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 24)
	public void testCaseSearch_24() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for NotEquals operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","NotEquals","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 25)
	public void testCaseSearch_25() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for Contains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","Contains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 26)
	public void testCaseSearch_26() throws ParseException{
		APIListener.addLogger( "[API] - Test Case attribute 'DisplayId' fetching value for NotContains operator"); 
		testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchTestCaseDisplayId","NotContains","TestCaseSearchUrl");
		testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		testCasePage.verifyResponseArrayValue("searchTestCaseDisplayId",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Test Case attribute 'DisplayId' fetching value for NotContains operator successfully!"); 
	}

	//Filter by Modified By
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 27)
		public void testCaseSearch_27() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for Equals operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName","Equals","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Equals operator successfully!"); 
		}
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 32)
		public void testCaseSearch_32() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for NotEquals operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName","NotEquals","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Not equals operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 33)
		public void testCaseSearch_33() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for Contains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName1","Contains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 34)
		public void testCaseSearch_34() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName1","NotContains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for NotContains operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 35)
		public void testCaseSearch_35() throws ParseException{
			APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName","Contains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 36)
		public void requirementSearch_36() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"modifiedBy","ASC","searchByName2","NotContains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
		}
		
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 37)
		public void testCaseSearch_37() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for isWithin operator");
			String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"IsWithin","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Not within operator successfully!"); 
		}
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 38)
		public void testCaseSearch_38() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for isWithin operator");
			String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"NotWithin","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.ModifiedBy.Name");
			APIListener.addLogger( "Test Case attribute 'ModifiedBy' fetching value for Not Within operator successfully!"); 
		}
		
		
		// Filter by Created by 
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 39)
		public void testCaseSearch_39() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for Equals operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Equals","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Equals operator successfully!"); 
		}
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 40)
		public void testCaseSearch_40() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for NotEquals operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","NotEquals","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Not equals operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 41)
		public void testCaseSearch_41() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for Contains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","Contains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
		}
		@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 42)
		public void testCaseSearch_42() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","NotContains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for NotContains operator successfully!"); 
		}
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 43)
		public void testCaseSearch_43() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Contains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
		}
		@Test(description ="API - Search Test Plan", groups = { "RegressionTests" }, priority = 44)
		public void testCaseSearch_44() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for NotContains operator"); 
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName2","NotContains","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
		}
		
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 45)
		public void  testCaseSearch_45() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for isWithin operator");
			String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"IsWithin","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Not within operator successfully!"); 
		}
		
		@Test(description = "API - Search Test Case", groups = { "RegressionTests" }, priority = 46)
		public void testCaseSearch_46() throws ParseException{
			APIListener.addLogger( "[API] - Test Case Page attribute 'CreatedBy' fetching value for isWithin operator");
			String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
			testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"NotWithin","TestCaseSearchUrl");
			testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			testCasePage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.CreatedBy.Name");
			APIListener.addLogger( "Test Case attribute 'CreatedBy' fetching value for Not Within operator successfully!"); 
		}
	
		// Defect id- API-D-4412
			@Test(description ="API -  - unable to filter by \"Assignee\" in the request POST testcase/search ", groups = { "RegressionTests" }, priority = 47)
			public void testCaseSearch_47() throws ParseException{
				APIListener.addLogger( "[API] - Test Case Page attribute 'Assignee' fetching value for Equals operator"); 
				testCasePage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Assignee","ASC","searchByName","Equals","TestCaseSearchUrl");
				testCasePage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				testCasePage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.assignee.name");
				APIListener.addLogger( "Test Case attribute 'Assignee' fetching value for Equals operator successfully!"); 

			}

}

