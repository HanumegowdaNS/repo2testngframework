package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;
import com.plutoraapi.pagerepo.RequirementsPage;

public class RequirementSearch  {

	RequirementsPage requirementPage = new RequirementsPage();

	//Id
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_1() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Id' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchRequirementId","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Id");
		APIListener.addLogger( "Requirement attribute 'Id' fetching value for Equals operator successfully!"); 
	} 

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_2() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Id' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Id","ASC","searchRequirementId","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Id");
		APIListener.addLogger( "Requirement attribute 'Id' fetching value for NotEquals operator successfully!"); 
	}

	//Name
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_3() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Name' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchRequirementName","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_4() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Name' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchRequirementName","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_5() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Name' fetching value for Contains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchRequirementName","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 1)
	public void requirementSearch_6() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Name' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Name","ASC","searchRequirementName","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementName",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Name");
		APIListener.addLogger( "Requirement attribute 'Name' fetching value for NotContains operator successfully!"); 
	}

	//CreatedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 11)
	public void requirementSearch_11() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 12)
	public void requirementSearch_12() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 13)
	public void requirementSearch_13() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for GreaterThan operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","GreaterThan","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 14)
	public void requirementSearch_14() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for GreaterOrEqual operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","GreaterOrEqual","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 15)
	public void requirementSearch_15() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for LessThan operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","LessThan","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 16)
	public void requirementSearch_16() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'CreatedDate' fetching value for LessOrEqual operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedDate","ASC","searchRequirementCreatedDate","LessOrEqual","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementCreatedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.CreatedDate");
		APIListener.addLogger( "Requirement Page attribute 'CreatedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//ModifiedDate
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 17)
	public void requirementSearch_17() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 18)
	public void requirementSearch_18() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 19)
	public void requirementSearch_19() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for GreaterThan operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","GreaterThan","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"GreaterThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for GreaterThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 20)
	public void requirementSearch_20() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for GreaterOrEqual operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","GreaterOrEqual","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"GreaterOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for GreaterOrEqual operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 21)
	public void requirementSearch_21() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for LessThan operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","LessThan","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"LessThan","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for LessThan operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 22)
	public void requirementSearch_22() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedDate' fetching value for LessOrEqual operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedDate","ASC","searchRequirementModifiedDate","LessOrEqual","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementModifiedDate",PlutoraAPIConfiguration.testData,"LessOrEqual","Data.ResultSet.ModifiedDate");
		APIListener.addLogger( "Requirement Page attribute 'ModifiedDate' fetching value for LessOrEqual operator successfully!"); 
	}

	//Description
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 23)
	public void requirementSearch_23() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Description' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchRequirementDescription","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDescription",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Description");
		APIListener.addLogger( "Requirement attribute 'Description' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 24)
	public void requirementSearch_24() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Description' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchRequirementDescription","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDescription",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.Description");
		APIListener.addLogger( "Requirement attribute 'Description' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 25)
	public void requirementSearch_25() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Description' fetching value for Contains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchRequirementDescription","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDescription",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.Description");
		APIListener.addLogger( "Requirement attribute 'Description' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 26)
	public void requirementSearch_26() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'Description' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Description","ASC","searchRequirementDescription","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDescription",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.Description");
		APIListener.addLogger( "Requirement attribute 'Description' fetching value for NotContains operator successfully!"); 
	}

	//DisplayId
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 27)
	public void requirementSearch_27() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'DisplayId' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchRequirementDisplayId","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDisplayId",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Requirement attribute 'DisplayId' fetching value for Equals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 28)
	public void requirementSearch_28() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'DisplayId' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchRequirementDisplayId","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDisplayId",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Requirement attribute 'DisplayId' fetching value for NotEquals operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 29)
	public void requirementSearch_29() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'DisplayId' fetching value for Contains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchRequirementDisplayId","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDisplayId",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Requirement attribute 'DisplayId' fetching value for Contains operator successfully!"); 
	}

	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 30)
	public void requirementSearch_30() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'DisplayId' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"DisplayId","ASC","searchRequirementDisplayId","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchRequirementDisplayId",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.DisplayId");
		APIListener.addLogger( "Requirement attribute 'DisplayId' fetching value for NotContains operator successfully!"); 
	}
	
	//Filter by Modified By
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 31)
	public void requirementSearch_31() throws ParseException{
		APIListener.addLogger( "[API] - Requirement Page attribute 'ModifiedBy' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 32)
	public void requirementSearch_32() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 33)
	public void requirementSearch_33() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 34)
	public void requirementSearch_34() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName1","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 35)
	public void requirementSearch_35() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 36)
	public void requirementSearch_36() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC","searchByName2","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 37)
	public void requirementSearch_37() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"IsWithin","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 38)
	public void requirementSearch_38() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "ModifiedByName2");
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"ModifiedBy","ASC",value,"NotWithin","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.ModifiedBy.Name");
		APIListener.addLogger( "Requirements attribute 'ModifiedBy' fetching value for Not Within operator successfully!"); 
	}
	
	
	// Filter by Created by 
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 39)
	public void requirementSearch_39() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Equals operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 40)
	public void requirementSearch_40() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for NotEquals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","NotEquals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"NotEquals","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Not equals operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 41)
	public void requirementSearch_41() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for Contains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 42)
	public void requirementSearch_42() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'ModifiedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName1","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName1",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for NotContains operator successfully!"); 
	}
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 43)
	public void requirementSearch_43() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName","Contains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Contains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	@Test(description ="API - Search Test Plan", groups = { "RegressionTests" }, priority = 44)
	public void requirementSearch_44() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for NotContains operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC","searchByName2","NotContains","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName2",PlutoraAPIConfiguration.testData,"NotContains","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Contains operator successfully!"); 
	}
	
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 45)
	public void  requirementSearch_45() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"IsWithin","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"IsWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Not within operator successfully!"); 
	}
	
	@Test(description = "API - Search Test Plan", groups = { "RegressionTests" }, priority = 46)
	public void requirementSearch_46() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'CreatedBy' fetching value for isWithin operator");
		String value = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName1")+","+PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CreatedByName2");
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"CreatedBy","ASC",value,"NotWithin","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue(value,PlutoraAPIConfiguration.testData,"NotWithin","Data.ResultSet.CreatedBy.Name");
		APIListener.addLogger( "Requirements attribute 'CreatedBy' fetching value for Not Within operator successfully!"); 
	}

	
// API-D-4412
	@Test(description ="API -  - unable to filter by \"Assignee\" in the request POST requirement/search ", groups = { "RegressionTests" }, priority = 47)
	public void requirementSearch_47() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'Assigne' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Assignee","ASC","searchByName","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("searchByName",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.assignee.name");
		APIListener.addLogger( "Requirements attribute 'Assignee' fetching value for Equals operator successfully!"); 
	}
	
//R9011A-D-0011
	@Test(description ="API - filtering by \"Status\" does not work in request POST requirement/search ", groups = { "RegressionTests" }, priority = 48)
	public void requirementSearch_48() throws ParseException{
		APIListener.addLogger( "[API] - Requirements Page attribute 'Status' fetching value for Equals operator"); 
		requirementPage.searchValueData("searchRequestJson", PlutoraAPIConfiguration.testData,"Status","ASC","statusValue","Equals","RequirementSearchUrl");
		requirementPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		requirementPage.verifyResponseArrayValue("statusValue",PlutoraAPIConfiguration.testData,"Equals","Data.ResultSet.Status.Value");
		APIListener.addLogger( "Requirements attribute 'Status' fetching value for Equals operator successfully!"); 
	}
}

