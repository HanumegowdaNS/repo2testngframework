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

public class ConnectivityPaginationFiltersWithoutPageNum  {

	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	SystemsPage systemsPage =new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	   
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 1)
		public void connectivityPagination_IdEquals() throws ParseException, InterruptedException{
			
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToProperty("id","System_Id");
			APIListener.addLogger( "System has been created successfully! ");
			//create environment 1
			environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToProperty("id", "Environment_ID1");
			//create environment 2
			environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToProperty("id", "Environment_ID2");
			// create environment groups
			environmentGroupsPage.createEnvironmentGroupWithMultipleEnvironment("CreateEnvironmentGroup4516Json", PlutoraAPIConfiguration.testData, "Environment_ID1,Environment_ID2");
			environmentGroupsPage.setDataToProperty("id", "EnvGroup_Id");
			environmentGroupsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment group has been created successfully! ");
			// create connectivity
			environmentPage.createConnectivityWithSourceAndTarget("createConnectivityJson", PlutoraAPIConfiguration.testData, "EnvGroup_Id", "Environment_ID1", "Environment_ID2","Out");
			environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Connectivity has been created successfully! ");
			environmentPage.setDataToProperty("id", "connectivity_Id");
			//get attributes
			environmentPage.getConnectivityWithId(PlutoraAPIConfiguration.testData, "connectivity_Id");
			environmentPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			environmentPage.setDataToProperty("id","connectivityId");
			environmentPage.setDataToProperty("environmentGroupId","environment_GroupId");
			environmentPage.setDataToProperty("environmentGroupName","environment_GroupName");
			environmentPage.setDataToProperty("sourceId","source_Id");
			environmentPage.setDataToProperty("sourceName","source_Name");
			environmentPage.setDataToProperty("targetId","target_Id");
			environmentPage.setDataToProperty("targetName","target_Name");
			environmentPage.setDataToProperty("connectivityTypeId","connectivity_TypeId");
			environmentPage.setDataToProperty("connectivityTypeName","connectivity_TypeName");
			environmentPage.setDataToProperty("direction","direction_name");
		
			// id Equals
		    APIListener.addLogger( "[API] - Connectivity attribute 'id' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("id", "Equals", "connectivityId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("id");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","connectivityId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'id' fetching value for  Equals successfully!"); 
			  }
		
		  @Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 2)
		  public void connectivityPagination_IdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Connectivity attribute 'id' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("id", "Not Equals", "connectivityId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("id");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","connectivityId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'id' fetching value for  Not Equals successfully!"); 
			  }
		
		 //environmentGroupId Equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 3)
		public void connectivityPagination_environmentGroupIdEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Environment Groups attribute 'Environment GroupId' fetching value for Equals operator"); 
		environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupId", "Equals", "environment_GroupId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
		environmentPage.setDataToPropertysWithoutPage("environmentGroupId");
		environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupId","environment_GroupId",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Connectivity Page attribute 'environmentGroupId' fetching value for Equals operator successfully!"); 
		}
		 
		 //environmentGroupId Not Equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 4)
		public void connectivityPagination_environmentGroupIdNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Environment Groups attribute 'Environment GroupId' fetching value for Not Equals operator"); 
		environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupId", "Not Equals", "environment_GroupId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
		environmentPage.setDataToPropertysWithoutPage("environmentGroupId");
		environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupId","environment_GroupId",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Connectivity Page attribute 'environmentGroupId' fetching value for Not Equals operator successfully!"); 
		}
		
		 //environmentGroupName Equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 5)
		public void connectivityPagination_environmentGroupNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Connectivity attribute 'environment GroupName' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupName", "Equals", "environment_GroupName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("environmentGroupName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupName","environment_GroupName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'environment GroupName' fetching value for Equals operator successfully!"); 
			    }
		
		//environmentGroupName Not Equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 6)
		public void connectivityPagination_environmentGroupNameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Connectivity attribute 'environment GroupName' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupName", "Not Equals", "environment_GroupName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("environmentGroupName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupName","environment_GroupName",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'environment GroupName' fetching value for Not Equals operator successfully!"); 
			    }
		
		//environmentGroupName Contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 7)
		public void connectivityPagination_environmentGroupNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Connectivity attribute 'environment GroupName' fetching value for Contains operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupName", "Contains", "environment_GroupName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("environmentGroupName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupName","environment_GroupName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Connectivity Page attribute 'environment GroupName' fetching value for Contains operator successfully!"); 
		    }		
		
		//environmentGroupName Not contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 8)
		public void connectivityPagination_environmentGroupNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Connectivity attribute 'environment GroupName' fetching value for Not Contains operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("environmentGroupName", "Not Contains", "environment_GroupName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("environmentGroupName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("environmentGroupName","environment_GroupName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Connectivity Page attribute 'environment GroupName' fetching value for Not Contains operator successfully!"); 
			 }
		
		//sourceId equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 9)
		public void connectivityPagination_sourceIdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Id' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceId", "Equals", "source_Id", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceId","source_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'sourceId' fetching value for Equals operator successfully!"); 
			    }
		
		//sourceId equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 10)
		public void connectivityPagination_sourceIdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Id' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceId", "Not Equals", "source_Id", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceId","source_Id",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'sourceId' fetching value for Not Equals operator successfully!"); 
			   }
		
		//sourceName equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 11)
		public void connectivityPagination_sourceNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Name' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceName", "Equals", "source_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceName","source_Name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'sourceName' fetching value for Equals operator successfully!"); 
	    	}
		
		//sourceName Not equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 12)
		public void connectivityPagination_sourceNameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Name' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceName", "Not Equals", "source_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceName","source_Name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'sourceName' fetching value for Not Equals operator successfully!"); 
		   	}
		
		//sourceName contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 13)
		public void connectivityPagination_sourceNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Name' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceName", "Contains", "source_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceName","source_Name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Connectivity Page attribute 'sourceName' fetching value for contains operator successfully!"); 
		   	}
		
		//sourceName contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 14)
		public void connectivityPagination_sourceNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Name' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("sourceName", "Not Contains", "source_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("sourceName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("sourceName","source_Name",PlutoraAPIConfiguration.testData,"Not Contains");
		    APIListener.addLogger("Connectivity Page attribute 'sourceName' fetching value for Not contains operator successfully!"); 
			}
		
		//targetId equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 15)
		public void connectivityPagination_targetIdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Id' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetId", "Equals", "target_Id", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetId","target_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'targetId' fetching value for Equals operator successfully!"); 
			    }
		
		//targetId Not equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 16)
		public void connectivityPagination_targetIdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'targetId' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetId", "Not Equals", "target_Id", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetId","target_Id",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'targetId' fetching value for Not Equals operator successfully!"); 
			   }
		
		//targetName equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 17)
		public void connectivityPagination_targetNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'source Name' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetName", "Equals", "target_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetName","target_Name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'targetName' fetching value for Equals operator successfully!"); 
	    	}
		
		//targetName Not equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 18)
		public void connectivityPagination_targetNameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'targetName' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetName", "Not Equals", "target_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetName","target_Name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'targetName' fetching value for Not Equals operator successfully!"); 
		   	}
		
		//targetName contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 19)
		public void connectivityPagination_targetNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'targetName' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetName", "Contains", "target_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetName","target_Name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Connectivity Page attribute 'targetName' fetching value for contains operator successfully!"); 
		   	}
		
		//targetName not contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 20)
		public void connectivityPagination_targetNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'targetName' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("targetName", "Not Contains", "target_Name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("targetName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("targetName","target_Name",PlutoraAPIConfiguration.testData,"Not Contains");
		    APIListener.addLogger("Connectivity Page attribute 'targetName' fetching value for Not contains operator successfully!"); 
			}
	
		//connectivityTypeId equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 21)
		public void connectivityPagination_connectivityTypeIdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeId' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeId", "Equals", "connectivity_TypeId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeId","connectivity_TypeId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeId' fetching value for Equals operator successfully!"); 
		    }
				
		//connectivityTypeId Not equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 22)
		public void connectivityPagination_connectivityTypeIdNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeId' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeId", "Not Equals", "connectivity_TypeId", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeId");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeId","connectivity_TypeId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeId' fetching value for Not Equals operator successfully!"); 
		   }
				

		//connectivityTypeName equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 23)
		public void connectivityPagination_connectivityTypeNameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeName' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeName", "Equals", "connectivity_TypeName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeName","connectivity_TypeName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeName' fetching value for Equals operator successfully!"); 
		    }
		
		//connectivityTypeName not equals
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 24)
		public void connectivityPagination_connectivityTypeNameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeName' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeName", "Not Equals", "connectivity_TypeName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeName","connectivity_TypeName",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeName' fetching value for Not Equals operator successfully!"); 
		    }
		
		//connectivityTypeName contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 25)
		public void connectivityPagination_connectivityTypeNameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeName' fetching value for Contains operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeName", "Contains", "connectivity_TypeName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeName","connectivity_TypeName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeName' fetching value for Contains operator successfully!"); 
		    }
		
		//connectivityTypeName not contains
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 26)
		public void connectivityPagination_connectivityTypeNameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'connectivityTypeName' fetching value for Not contains operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("connectivityTypeName", "Not Contains", "connectivity_TypeName", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("connectivityTypeName");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("connectivityTypeName","connectivity_TypeName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Connectivity Page attribute 'connectivityTypeName' fetching value for Not Contains operator successfully!");
		    }
		
		//direction equals 
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 27)
		public void connectivityPagination_directionEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'direction' fetching value for Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("direction", "Equals", "direction_name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("direction");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("direction","direction_name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Connectivity Page attribute 'direction' fetching value for Equals operator successfully!");
		    }
		
		//direction equals 
		@Test(description = "Pagination and filter Combinations for Connectivity Page", groups = { "RegressionTests" },priority = 28)
		public void connectivityPagination_directionNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environment Groups attribute 'direction' fetching value for Not Equals operator"); 
			environmentPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("direction", "Not Equals", "direction_name", PlutoraAPIConfiguration.testData),"connectivitiesFilterUrl");
			environmentPage.setDataToPropertysWithoutPage("direction");
			environmentPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("direction","direction_name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Connectivity Page attribute 'direction' fetching value for Not Equals operator successfully!");
				    }
}