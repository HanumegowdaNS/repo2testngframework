package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.DefectsPage;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.RequirementsPage;

public class DefectsSearch  {
 
	DefectsPage defectsPage = new DefectsPage();

	//Id
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 1)
	public void defectsSearch_1() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Id' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchDefectsId","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//defectsPage.setDataToPropertyWithTestData(PlutoraAPIConfiguration.testData,"searchName","searchName");
		defectsPage.verifyResponseArrayValue("searchDefectsId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Id");
		APIListener.addLogger( "Defects attribute 'Id' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 2)
	public void defectsSearch_2() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Id' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchDefectsId","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Id");
		APIListener.addLogger( "Defects attribute 'Id' fetching value for NotEquals operator successfully!"); 
	}

	//Name
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 3)
	public void defectsSearch_3() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Name' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchDefectsName","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 4)
	public void defectsSearch_4() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Name' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchDefectsName","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 5)
	public void defectsSearch_5() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Name' fetching value for Contains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchDefectsName","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 6)
	public void defectsSearch_6() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Name' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchDefectsName","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsName",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Name");
		APIListener.addLogger( "Defects attribute 'Name' fetching value for NotContains operator successfully!"); 
	}

	//CreatedDate
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 7)
	public void defectsSearch_7() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects attribute 'CreatedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 8)
	public void defectsSearch_8() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects attribute 'CreatedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 9)
	public void defectsSearch_9() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for GreaterThan operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","GreaterThan","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects attribute 'CreatedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 10)
	public void defectsSearch_10() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for GreaterOrEqual operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","GreaterOrEqual","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects attribute 'CreatedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 11)
	public void defectsSearch_11() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for LessThan operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","LessThan","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects Page attribute 'CreatedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 12)
	public void defectsSearch_12() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedDate' fetching value for LessOrEqual operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchDefectsCreatedDate","LessOrEqual","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsCreatedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Defects Page attribute 'CreatedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//ModifiedDate
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 13)
	public void defectsSearch_13() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 14)
	public void defectsSearch_14() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 15)
	public void defectsSearch_15() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for GreaterThan operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","GreaterThan","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 16)
	public void defectsSearch_16() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for GreaterOrEqual operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","GreaterOrEqual","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 17)
	public void defectsSearch_17() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for LessThan operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","LessThan","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 18)
	public void defectsSearch_18() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedDate' fetching value for LessOrEqual operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchDefectsModifiedDate","LessOrEqual","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Defects Page attribute 'ModifiedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//Description
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 19)
	public void defectsSearch_19() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Description' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchDefectsEqualsDescription","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsEqualsDescription",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Description");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 20)
	public void defectsSearch_20() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Description' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchDefectsDescription","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDescription",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Description");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 21)
	public void defectsSearch_21() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Description' fetching value for Contains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchDefectsDescription","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDescription",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Description");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 22)
	public void defectsSearch_22() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'Description' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchDefectsDescription","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDescription",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Description");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for NotContains operator successfully!"); 
	}

	//DisplayId
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 23)
	public void defectsSearch_23() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'DisplayId' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchDefectsDisplayId","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDisplayId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Defects attribute 'DisplayId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 24)
	public void defectsSearch_24() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'DisplayId' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchDefectsDisplayId","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDisplayId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Defects attribute 'DisplayId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 25)
	public void defectsSearch_25() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'DisplayId' fetching value for Contains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchDefectsDisplayId","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDisplayId",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Defects attribute 'DisplayId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 26)
	public void defectsSearch_26() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'DisplayId' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchDefectsDisplayId","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchDefectsDisplayId",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for DisplayId operator successfully!"); 
	}

	
	//Filter by Modified By
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 27)
	public void defectsSearch_27() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 28)
	public void defectsSearch_28() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'DisplayId' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 29)
	public void defectsSearch_29() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'Description' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 30)
	public void defectsSearch_30() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 31)
	public void defectsSearch_31() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 32)
	public void defectsSearch_32() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName2","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 33)
	public void defectsSearch_33() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"IsWithin","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 34)
	public void defectsSearch_34() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"NotWithin","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Defects attribute 'ModifiedBy' fetching value for Not Within operator successfully!"); 
	}
	

	// Filter by Created by 
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 35)
	public void defectsSearch_35() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for Equals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Equals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 36)
	public void defectsSearch_36() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedBy' fetching value for NotEquals operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","NotEquals","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 37)
	public void defectsSearch_37() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 38)
	public void defectsSearch_38() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 39)
	public void defectsSearch_39() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Contains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("ModifiedByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 40)
	public void defectsSearch_40() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName2","NotContains","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 41)
	public void defectsSearch_41() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"IsWithin","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Defects Page", groups = { "RegressionTests" }, priority = 42)
	public void defectsSearch_42() throws ParseException{
		APIListener.addLogger( "[API] - Defects Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"NotWithin","DefectsSearchUrl");
		defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Defects attribute 'CreatedBy' fetching value for Not Within operator successfully!"); 
	}
	
	
	/*
	//Filter by Modified By for bulk update search
			@Test(description = "API - Bulk update search Defects Page", groups = { "RegressionTests" }, priority = 43)
			public void defectsSearch_43() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update Defects search Page attribute 'ModifiedBy' fetching value for Equals operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Equals","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' for bulk update search fetching value for Equals operator successfully!"); 
			}
			
			@Test(description = "API - Bulk update search Defects Page", groups = { "RegressionTests" }, priority = 44)
			public void defectsSearch_44() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update Defects search  Page attribute 'DisplayId' fetching value for NotEquals operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","NotEquals","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for Not equals operator successfully!"); 
			}
			@Test(description = "API - Bulk update search Defects Page", groups = { "RegressionTests" }, priority = 45)
			public void defectsSearch_45() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update Defects search  Page attribute 'ModifiedBy' fetching value for Contains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","Contains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for Contains operator successfully!"); 
			}
			@Test(description = "API -Bulk update search Defects Page", groups = { "RegressionTests" }, priority = 46)
			public void defectsSearch_46() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update Defects search Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","NotContains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for NotContains operator successfully!"); 
			}
			@Test(description = "API - Bulk update search Defects Page", groups = { "RegressionTests" }, priority = 47)
			public void defectsSearch_47() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update  Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Contains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search  fetching value for Contains operator successfully!"); 
			}
			@Test(description = "API -Bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 48)
			public void defectsSearch_48() throws ParseException{
				APIListener.addLogger( "[API] - Bulk update Defects Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName2","NotContains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for Contains operator successfully!"); 
			}
			
			
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 49)
			public void defectsSearch_49() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'ModifiedBy' fetching value for isWithin operator");
				String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"IsWithin","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for Not within operator successfully!"); 
			}
			
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 50)
			public void defectsSearch_50() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'ModifiedBy' fetching value for isWithin operator");
				String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"NotWithin","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.ModifiedBy.Name");
				APIListener.addLogger( "Defects attribute 'ModifiedBy' bulk update search fetching value for Not Within operator successfully!"); 
			}
			
			
			// Filter by Created by bulk update search
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 51)
			public void defectsSearch_51() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'CreatedBy' fetching value for Equals operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Equals","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy'  bulk update search fetching value for Equals operator successfully!"); 
			}
			
			@Test(description = "API -  bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 52)
			public void defectsSearch_52() throws ParseException{
				APIListener.addLogger( "[API] -  bulk update Defects Page attribute 'CreatedBy' fetching value for NotEquals operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","NotEquals","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy'bulk update search fetching value for Not equals operator successfully!"); 
			}
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 53)
			public void defectsSearch_53() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'ModifiedBy' fetching value for Contains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","Contains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy' bulk update search fetching value for Contains operator successfully!"); 
			}
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 54)
			public void defectsSearch_54() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'CreatedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","NotContains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy' bulk update search fetching value for NotContains operator successfully!"); 
			}
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 55)
			public void defectsSearch_55() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'CreatedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Contains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy' bulk update fetching value for Contains operator successfully!"); 
			}
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 56)
			public void defectsSearch_56() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'CreatedBy' fetching value for NotContains operator"); 
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName2","NotContains","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy' bulk update fetching value for Contains operator successfully!"); 
			}
			
			
			@Test(description = "API - bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 57)
			public void defectsSearch_57() throws ParseException{
				APIListener.addLogger( "[API] - bulk update Defects Page attribute 'CreatedBy' fetching value for isWithin operator");
				String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"IsWithin","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy' bulk update search fetching value for Not within operator successfully!"); 
			}
			
			@Test(description = "API -  bulk update Search Defects Page", groups = { "RegressionTests" }, priority = 58)
			public void defectsSearch_58() throws ParseException{
				APIListener.addLogger( "[API] -  bulk update Defects Page attribute 'CreatedBy' fetching value for isWithin operator");
				String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
				defectsPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"NotWithin","DefectsBulkUpdateSearchUrl");
				defectsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
				defectsPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.CreatedBy.Name");
				APIListener.addLogger( "Defects attribute 'CreatedBy'  bulk update search fetching value for Not Within operator successfully!"); 
			}*/
}


