package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;
import com.plutoraapi.pagerepo.EnvironmentGroupsPage;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.SystemsPage;

public class EnvironmentGroupsPaginationFilters  {
 
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	SystemsPage systemsPage =new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	   
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 1)
		public void environmentGroupPagination_IdEquals() throws ParseException, InterruptedException{
			
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToProperty("id","System_Id"); 
			APIListener.addLogger( "System has been created successfully! ");
			
			//create environment 
			environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToProperty("id", "Environment_ID");
			
			// create environment groups
			environmentGroupsPage.createEnvironmentGroupWithEnv("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData, "Environment_ID");
			environmentGroupsPage.setDataToProperty("id", "EnvGroup_Id");
			environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment group has been created successfully! ");
			// set all attributes
			environmentGroupsPage.setDataToProperty("name", "EnvGroup_name");
			environmentGroupsPage.setDataToProperty("description", "EnvGroup_description");
			environmentGroupsPage.setDataToProperty("color", "EnvGroup_color");
			environmentGroupsPage.setDataToProperty("usageWorkItemId", "EnvGroup_usageWorkItemId");
			environmentGroupsPage.setDataToProperty("usageWorkItemName", "EnvGroup_usageWorkItemName");
			environmentGroupsPage.setDataToProperty("organizationId", "EnvGroup_organizationId");
			//environmentGroupsPage.setDataToProperty("organizationName", "EnvGroup_organizationName");
			//environmentGroupsPage.setDataToProperty("environmentIDs", "EnvGroup_environmentIDs");
			environmentGroupsPage.setDataToProperty("isAutoApproved", "EnvGroup_isAutoApproved");
			environmentGroupsPage.setDataToProperty("displayBookingAlert", "EnvGroup_displayBookingAlert");
      	    environmentGroupsPage.setDataToProperty("bookingAlertMessage", "EnvGroup_bookingAlertMessage");
      	    environmentGroupsPage.getEnvironmentGroups("EnvGroup_Id",  PlutoraAPIConfiguration.testData);
      	    environmentGroupsPage.setDataToProperty("organizationName", "EnvGroup_organizationName");
			// id Equals
			APIListener.addLogger( "[API] - Environment Groups attribute 'id' fetching value for Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("id", "Equals", "EnvGroup_Id", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("id");
			environmentGroupsPage.verifyResponseArrayValueForPagination("id","EnvGroup_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'id' fetching value for Equals operator successfully!"); 
		}
		

		 //id not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 2)
		public void environmentGroupPagination_IdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'id' fetching value for Not Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("id", "Not Equals", "EnvGroup_Id", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("id");
			environmentGroupsPage.verifyResponseArrayValueForPagination("id","EnvGroup_Id",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'id' fetching value for Not Equals operator successfully!"); 
		}
		 
		 //name equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 3)
		public void environmentGroupPagination_NameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'name' fetching value for Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("name", "Equals", "EnvGroup_name", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("name");
			environmentGroupsPage.verifyResponseArrayValueForPagination("name","EnvGroup_name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'name' fetching value for Equals operator successfully!"); 
		}
		
		 //name Not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 4)
		public void environmentGroupPagination_NameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'name' fetching value for Not Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("name", "Not Equals", "EnvGroup_name", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("name");
			environmentGroupsPage.verifyResponseArrayValueForPagination("name","EnvGroup_name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'name' fetching value for Not Equals operator successfully!"); 
		}
		
		 //name contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 5)
		public void environmentGroupPagination_NameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'name' fetching value for Contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("name", "Contains", "EnvGroup_name", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("name");
			environmentGroupsPage.verifyResponseArrayValueForPagination("name","EnvGroup_name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'name' fetching value for Contains operator successfully!"); 
		}
		
		 //name not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 6)
		public void environmentGroupPagination_NameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'name' fetching value for Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("name", "Not Contains", "EnvGroup_name", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("name");
			environmentGroupsPage.verifyResponseArrayValueForPagination("name","EnvGroup_name",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'name' fetching value for Not Contains operator successfully!"); 
		}
	
		 //description equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 7)
		public void environmentGroupPagination_descriptionEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'description' fetching value for Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("description", "Equals", "EnvGroup_description", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("description");
			environmentGroupsPage.verifyResponseArrayValueForPagination("description","EnvGroup_description",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'description' fetching value for Equals operator successfully!"); 
		}
		
		 //description Not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 8)
		public void environmentGroupPagination_descriptionNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'description' fetching value for Not Equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("description", "Not Equals", "EnvGroup_description", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("description");
			environmentGroupsPage.verifyResponseArrayValueForPagination("description","EnvGroup_description",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'description' fetching value for Not Equals operator successfully!"); 
		}
		
		 //description contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 9)
		public void environmentGroupPagination_descriptionContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'description' fetching value for Contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("description", "Contains", "EnvGroup_description", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("description");
			environmentGroupsPage.verifyResponseArrayValueForPagination("description","EnvGroup_description",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'description' fetching value for contains operator successfully!"); 
		}
		
		 //description not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 10)
		public void environmentGroupPagination_descriptionNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'description' fetching value for Not contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("description", "Not Contains", "EnvGroup_description", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("description");
			environmentGroupsPage.verifyResponseArrayValueForPagination("description","EnvGroup_description",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'description' fetching value for Not contains operator successfully!"); 
		}

		 //color equals
		String env_color;
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 11)
		public void environmentGroupPagination_colorEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'color' fetching value for equals operator");
			env_color= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "EnvGroup_color").replace("#", "%23");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Group_color",env_color);
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("color", "Equals", "Group_color", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("color");
			environmentGroupsPage.verifyResponseArrayValueForPagination("color","Group_color",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'color' fetching value for Equals operator successfully!"); 
		}

		 //color not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 12)
		public void environmentGroupPagination_colorNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'color' fetching value for Not equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("color", "Not Equals", "Group_color", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("color");
			environmentGroupsPage.verifyResponseArrayValueForPagination("color","Group_color",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'color' fetching value for Not Equals operator successfully!"); 
		}

	 //color contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 13)
		public void environmentGroupPagination_colorContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'color' fetching value for contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("color", "Contains", "Group_color", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("color");
			environmentGroupsPage.verifyResponseArrayValueForPagination("color","Group_color",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'color' fetching value for Contains operator successfully!"); 
		}

		 //color not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 14)
		public void environmentGroupPagination_colorNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'color' fetching value for not contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("color", "Not Contains", "Group_color", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("color");
			environmentGroupsPage.verifyResponseArrayValueForPagination("color","Group_color",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'color' fetching value for Not Contains operator successfully!"); 
		}

		//EnvGroup_usageWorkItemId equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 15)
		public void environmentGroupPagination_usageWorkItemIdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemId' fetching value for equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemId", "Equals", "EnvGroup_usageWorkItemId", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("usageWorkItemId");
			environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemId","EnvGroup_usageWorkItemId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemId' fetching value for Equals operator successfully!"); 
		}
		
		//EnvGroup_usageWorkItemId Not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 16)
		public void environmentGroupPagination_usageWorkItemIdNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemId' fetching value for not equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemId", "Not Equals", "EnvGroup_usageWorkItemId", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("usageWorkItemId");
			environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemId","EnvGroup_usageWorkItemId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemId' fetching value for Not Equals operator successfully!"); 
		}
		
		//usageWorkItemName equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 17)
		public void environmentGroupPagination_usageWorkItemNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemName' fetching value for equals operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemName", "Equals", "EnvGroup_usageWorkItemName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			APIListener.addLogger(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"usageWorkItemName"));
			environmentGroupsPage.setDataToPropertys("usageWorkItemName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemName","EnvGroup_usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemName' fetching value for Equals operator successfully!"); 
		}
		
		//usageWorkItemName not equals 
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 18)
		public void environmentGroupPagination_usageWorkItemNameNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemName' fetching value for equals operator");
		   environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemName", "Not Equals", "EnvGroup_usageWorkItemName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
		   environmentGroupsPage.setDataToPropertys("usageWorkItemName");
		   environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemName","EnvGroup_usageWorkItemName",PlutoraAPIConfiguration.testData,"Not Equals");
		   APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemName' fetching value for Not Equals operator successfully!"); 
				}
		
		//usageWorkItemName contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 19)
		public void environmentGroupPagination_usageWorkItemNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemName' fetching value for contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemName", "Contains", "EnvGroup_usageWorkItemName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("usageWorkItemName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemName","EnvGroup_usageWorkItemName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemName' fetching value for Contains operator successfully!"); 
		}
		
		//usageWorkItemName not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 20)
		public void environmentGroupPagination_usageWorkItemNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'usageWorkItemName' fetching value for Not contains operator");
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("usageWorkItemName", "Not Contains", "EnvGroup_usageWorkItemName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("usageWorkItemName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("usageWorkItemName","EnvGroup_usageWorkItemName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'usageWorkItemName' fetching value for Not contains operator successfully!"); 
		}
		
		//organizationId Equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 21)
		public void environmentGroupPagination_organizationIdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationId' fetching value for Equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationId", "Equals", "EnvGroup_organizationId", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationId");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationId","EnvGroup_organizationId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'organizationId' fetching value for Equals operator successfully!"); 
		}	
		
		//organizationId Not Equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 22)
		public void environmentGroupPagination_organizationIdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationId' fetching value for Not Equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationId", "Not Equals", "EnvGroup_organizationId", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationId");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationId","EnvGroup_organizationId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'organizationId' fetching value for Not Equals operator successfully!"); 
		}	
		
		//organizationName Equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 23)
		public void environmentGroupPagination_organizationNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationName' fetching value for Equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationName", "Equals", "EnvGroup_organizationName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationName","EnvGroup_organizationName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'organizationName' fetching value for Equals operator successfully!"); 
		}	
		
		//organizationName Not Equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 24)
		public void environmentGroupPagination_organizationNameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationName' fetching value for Not Equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationName", "Not Equals", "EnvGroup_organizationName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationName","EnvGroup_organizationName",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'organizationName' fetching value for Not Equals operator successfully!"); 
		}
				
		//organizationName contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 25)
		public void environmentGroupPagination_organizationNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationName' fetching value for Contains operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationName", "Contains", "EnvGroup_organizationName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationName","EnvGroup_organizationName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'organizationName' fetching value for Contains operator successfully!"); 
		}
				
		//organizationName not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 26)
		public void environmentGroupPagination_organizationNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'organizationName' fetching value for Not contains operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("organizationName", "Not Contains", "EnvGroup_organizationName", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("organizationName");
			environmentGroupsPage.verifyResponseArrayValueForPagination("organizationName","EnvGroup_organizationName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'organizationName' fetching value for Not Contains operator successfully!"); 
		}
				
	/*	
		//environmentIDs contains
		String [] arrayString;
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 27)
		public void environmentGroupPagination_environmentIDsContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'environmentIDs' fetching value for contains operator");
			arrayString = environmentGroupsPage.addStringToArray(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"EnvGroup_environmentIDs"));
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("environmentIDs", "Contains", arrayString[0], PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("environmentIDs","EnvGroup_environmentIDs");
			arrayString = environmentGroupsPage.addStringToArray(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"EnvGroup_environmentIDs"));
			environmentGroupsPage.verifyResponseArrayValueForPagination("environmentIDs",arrayString[0],PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'environmentIDs' fetching value for Contains operator successfully!"); 
		}
		
		//environmentIDs not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 28)
		public void environmentGroupPagination_environmentIDsNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'environmentIDs' fetching value for Not contains operator");
			arrayString = environmentGroupsPage.addStringToArray(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"EnvGroup_environmentIDs"));
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("environmentIDs", "Not Contains", arrayString[0], PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("environmentIDs");
			arrayString = environmentGroupsPage.addStringToArray(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData,"EnvGroup_environmentIDs"));
			environmentGroupsPage.verifyResponseArrayValueForPagination("environmentIDs",arrayString[0],PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'environmentIDs' fetching value for Not Contains operator successfully!"); 
		}*/
		
		//isAutoApproved equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 29)
		public void environmentGroupPagination_isAutoApprovedEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'isAutoApproved' fetching value for equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("isAutoApproved", "Equals","EnvGroup_isAutoApproved", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("isAutoApproved");
			environmentGroupsPage.verifyResponseArrayValueForPagination("isAutoApproved","EnvGroup_isAutoApproved",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'isAutoApproved' fetching value for Equals operator successfully!"); 
		}
		
		//isAutoApproved not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 30)
		public void environmentGroupPagination_isAutoApprovedNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'isAutoApproved' fetching value for not equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("isAutoApproved", "Not Equals","EnvGroup_isAutoApproved", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("isAutoApproved");
			environmentGroupsPage.verifyResponseArrayValueForPagination("isAutoApproved","EnvGroup_isAutoApproved",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'isAutoApproved' fetching value for Not Equals operator successfully!"); 
		}
		
		//displayBookingAlert equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 31)
		public void environmentGroupPagination_displayBookingAlertEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("displayBookingAlert", "Equals","EnvGroup_displayBookingAlert", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("displayBookingAlert");
			environmentGroupsPage.verifyResponseArrayValueForPagination("displayBookingAlert","EnvGroup_displayBookingAlert",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'displayBookingAlert' fetching value for Equals operator successfully!"); 
		}
		
		//displayBookingAlert not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 32)
		public void environmentGroupPagination_displayBookingAlertNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for not equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("displayBookingAlert", "Not Equals","EnvGroup_displayBookingAlert", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("displayBookingAlert");
			environmentGroupsPage.verifyResponseArrayValueForPagination("displayBookingAlert","EnvGroup_displayBookingAlert",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'displayBookingAlert' fetching value for Not Equals operator successfully!"); 
		}
	
		//bookingAlertMessage equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 33)
		public void environmentGroupPagination_bookingAlertMessageEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("bookingAlertMessage", "Equals","EnvGroup_bookingAlertMessage", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("bookingAlertMessage");
			environmentGroupsPage.verifyResponseArrayValueForPagination("bookingAlertMessage","EnvGroup_bookingAlertMessage",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environment Groups Page attribute 'bookingAlertMessage' fetching value for Equals operator successfully!"); 
		}
		
		//bookingAlertMessage not equals
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 34)
		public void environmentGroupPagination_bookingAlertMessageNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for equals operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("bookingAlertMessage", "Not Equals","EnvGroup_bookingAlertMessage", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("bookingAlertMessage");
			environmentGroupsPage.verifyResponseArrayValueForPagination("bookingAlertMessage","EnvGroup_bookingAlertMessage",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environment Groups Page attribute 'bookingAlertMessage' fetching value for Not Equals operator successfully!"); 
		}
		
		//bookingAlertMessage contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 35)
		public void environmentGroupPagination_bookingAlertMessageContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for Contains operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("bookingAlertMessage", "Contains","EnvGroup_bookingAlertMessage", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("bookingAlertMessage");
			environmentGroupsPage.verifyResponseArrayValueForPagination("bookingAlertMessage","EnvGroup_bookingAlertMessage",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environment Groups Page attribute 'bookingAlertMessage' fetching value for Contains operator successfully!"); 
		}
		
		//bookingAlertMessage not contains
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 36)
		public void environmentGroupPagination_bookingAlertMessageNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'displayBookingAlert' fetching value for Not contains  operator");
		    environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterOperator("bookingAlertMessage", "Not Contains","EnvGroup_bookingAlertMessage", PlutoraAPIConfiguration.testData), "0", "10","envGroupPaginationFilterUrl");
			environmentGroupsPage.setDataToPropertys("bookingAlertMessage");
			environmentGroupsPage.verifyResponseArrayValueForPagination("bookingAlertMessage","EnvGroup_bookingAlertMessage",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environment Groups Page attribute 'bookingAlertMessage' fetching value for Not Contains operator successfully!"); 
		}
/*	
		@Test(description = "Pagination and filter Combinations for Environment Groups Page", groups = { "RegressionTests" },priority = 1)
		public void environmentGroupPagination_Combinations1() throws ParseException, InterruptedException{
			
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToPropertys("id","System_Id"); 
			APIListener.addLogger( "System has been created successfully! ");
			
			//create environment 
			environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToPropertys("id", "Environment_ID");
			
			// create environment groups
			environmentGroupsPage.createEnvironmentGroupWithEnv("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData, "Environment_ID");
			environmentGroupsPage.setDataToPropertys("id", "EnvGroup_Id");
			environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment group has been created successfully! ");
			environmentGroupsPage.setDataToPropertys("name;usageWorkIteamName;isAutoApproved;organizationName","name_1;usageIteam_1;isAutoApproved_1;orgName_1");
			environmentGroupsPage.setDataToPropertys("environmentIDs;color;displayBookingAlert;bookingAlertMessage" ,"envId_1;color_1;displayBook_1;bookingAlertMsg_1");
			
			//create another environment group
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToPropertys("id","System_Id1"); 
			APIListener.addLogger( "System has been created successfully! ");
			
			//create environment 
			environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id1");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToPropertys("id", "Environment_ID1");
			
			// create environment groups
			environmentGroupsPage.createEnvironmentGroupWithEnv("CreateEnvironmentGroup4516Json1", PlutoraAPIConfiguration.testData, "Environment_ID1");
			environmentGroupsPage.setDataToPropertys("id", "EnvGroup_Id1");
			environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment group has been created successfully! ");
			environmentGroupsPage.setDataToPropertys("name;usageWorkIteamName;isAutoApproved;organizationName","name_2;usageIteam_2;isAutoApproved_2;orgName_2");
			environmentGroupsPage.setDataToPropertys("environmentIDs;color;displayBookingAlert;bookingAlertMessage" ,"envId_2;color_2;displayBook_2;bookingAlertMsg_2");

			//usageWorkItemName contains(a or b) and  organizationName equals (x or y)
			environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterCombinations_1("usageWorkItemName", "Contains", "usageIteam_1","OR","usageIteam_2", "And","organizationName", "Equals","orgName_1", "Or", "orgName_2",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
			environmentGroupsPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Contains", new String [] {"usageIteam_1","usageIteam_2"});
			environmentGroupsPage.verifyResponseArrayValueCombination("organizationName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"orgName_1","orgName_2"});
			APIListener.addLogger("Environment groups-- Filter Combination 1 : usageWorkItemName contains(a or b) and  organizationName equals (x or y) is successfull!"); 
				
			
		}
	 
		// environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)
		@Test(description = "Pagination and filter Combinations for Environments groups. Combination 2 :environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination2() throws ParseException, InterruptedException{
		APIListener.addLogger( "Environment groups-- Filter Combination 2 : environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)"); 
		environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterCombinations_1("environmentIDs", "Equals", "envId_1","OR","envId_2", "Or","usageWorkItemName", "NotEquals","usageIteam_1", "Or", "usageIteam_1",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
		environmentGroupsPage.verifyResponseArrayValueCombination("environmentIDs",PlutoraAPIConfiguration.testData,"Contains", new String [] {"envId_1","envId_2"});
		environmentGroupsPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"usageIteam_1","usageIteam_2"});
		APIListener.addLogger("Environment groups-- Filter Combination 2 : environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b) is successfull!"); 
			
		}
		
		// name contains (a or b) and color equals ( p or q)
		@Test(description = "Pagination and filter Combinations for Environments groups. Combination 3 :name contains (a or b) and color equals ( p or q)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination3() throws ParseException, InterruptedException{
		APIListener.addLogger( "Environment groups-- Filter Combination 3: name contains (a or b) and color equals ( p or q)"); 
		environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterCombinations_1("name", "Contains", "name_1","OR","name_2", "And","color", "Equals","color_1", "Or", "color_2",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
		environmentGroupsPage.verifyResponseArrayValueCombination("name",PlutoraAPIConfiguration.testData,"Contains", new String [] {"name_1","name_2"});
		environmentGroupsPage.verifyResponseArrayValueCombination("color",PlutoraAPIConfiguration.testData,"Equals", new String [] {"color_1","color_2"});
		APIListener.addLogger("Environment groups-- Filter Combination 3 : name contains (a or b) and color equals ( p or q) is successfull!"); 
					
		}
			
		//  displayBookingAlert contains A or bookingAlertMessage contains( m or n)
		@Test(description = "Pagination and filter Combinations for Environments groups.  displayBookingAlert contains A or bookingAlertMessage contains( m or n)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination4() throws ParseException, InterruptedException{
		APIListener.addLogger( "Environment groups-- Filter Combination 4:  displayBookingAlert contains A or bookingAlertMessage contains( m or n)"); 
		environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterCombinations_3("displayBookingAlert", "Contains", "displayBook_1", "Or", "bookingAlertMessage", "Contains", "bookingAlertMsg_1", "Or", "bookingAlertMsg_2", PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
		environmentGroupsPage.verifyResponseArrayValueCombination("displayBookingAlert",PlutoraAPIConfiguration.testData,"Contains", new String [] {"displayBook_1"});
		environmentGroupsPage.verifyResponseArrayValueCombination("bookingAlertMessage",PlutoraAPIConfiguration.testData,"Contains", new String [] {"bookingAlertMsg_1","bookingAlertMsg_2"});
		APIListener.addLogger("Environment groups-- Filter Combination 4 :  displayBookingAlert contains A or bookingAlertMessage contains( m or n) is successfull!"); 
							
		}
		
	    //  name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)
	    @Test(description = "Pagination and filter Combinations for Environments groups.  1.name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination5() throws ParseException, InterruptedException{
		APIListener.addLogger( "Environment groups-- Filter Combination 5: name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)"); 
		environmentGroupsPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentGroupsPage.setPaginationFilterCombinations_2("name", "Equals", "name_1", "Or", "name_2", "And", "usageWorkItemName", "Equals", "usageIteam_1", "Or", "usageIteam_2", "Or", "isAutoApproved", "Equals", "isAutoApproved_1", "Or", "isAutoApproved_2", PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
		environmentGroupsPage.verifyResponseArrayValueCombination("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
		environmentGroupsPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"usageIteam_1","usageIteam_2"});
		environmentGroupsPage.verifyResponseArrayValueCombination("isAutoApproved",PlutoraAPIConfiguration.testData,"Equals", new String [] {"isAutoApproved_1","isAutoApproved_2"});
		APIListener.addLogger("Environment groups-- Filter Combination 5 : name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n) is successfull!"); 
								
			}*/
}
