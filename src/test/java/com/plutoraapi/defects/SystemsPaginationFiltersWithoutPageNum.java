package com.plutoraapi.defects;

import java.text.ParseException;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.EnvironmentGroupsPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.SystemsPage;

public class SystemsPaginationFiltersWithoutPageNum  {

	SystemsPage systemsPage =new SystemsPage();
	
	   
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 1)
		public void systemsPagination_IdEquals() throws ParseException, InterruptedException{
			
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "System has been created successfully! ");
			systemsPage.setDataToProperty("id","System_Id");
			systemsPage.setDataToProperty("name","System_name");

			// id equals
			APIListener.addLogger( "[API] - Systems attribute 'id' fetching value for Equals operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("id","Equals","System_Id", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
			systemsPage.setDataToPropertysWithoutPage("id");
			systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","System_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Systems Page attribute 'id' fetching value for Equals operator successfully!"); 
	    }
		
		// id not equals
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 2)
		public void systemsPagination_IdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Systems attribute 'id' fetching value for Not Equals operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("id","Not Equals","System_Id", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
			systemsPage.setDataToPropertysWithoutPage("id");
			systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","System_Id",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Systems Page attribute 'id' fetching value for Not Equals operator successfully!"); 
	    }
		
		// name equals
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 3)
		public void systemsPagination_nameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Systems attribute 'name' fetching value for Equals operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("name","Equals","System_name", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
			systemsPage.setDataToPropertysWithoutPage("name");
			systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("name","System_name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Systems Page attribute 'name' fetching value for Equals operator successfully!"); 
		 }

		// name not equals
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 4)
		public void systemsPagination_nameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Systems attribute 'name' fetching value for Not Equals operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("name","Not Equals","System_name", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
		    systemsPage.setDataToPropertysWithoutPage("name");
		    systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("name","System_name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Systems Page attribute 'name' fetching value for Not Equals operator successfully!"); 
		 }

		// name contains
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 5)
		public void systemsPagination_nameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Systems attribute 'name' fetching value for Equals operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("name","Contains","System_name", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
			systemsPage.setDataToPropertysWithoutPage("name");
			systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("name","System_name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Systems Page attribute 'name' fetching value for contains operator successfully!"); 
		 }

		// name not contains
		@Test(description = "Pagination and filter Combinations for Systems Page", groups = { "RegressionTests" },priority = 6)
		public void systemsPagination_nameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Systems attribute 'name' fetching value for Not Contains operator"); 
			systemsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, systemsPage.setPaginationFilterOperator("name","Not Contains","System_name", PlutoraAPIConfiguration.testData),"systemsPaginationFilterUrl");
			systemsPage.setDataToPropertysWithoutPage("name");
			systemsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("name","System_name",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Systems Page attribute 'name' fetching value for Not Contains operator successfully!"); 
		 }
}