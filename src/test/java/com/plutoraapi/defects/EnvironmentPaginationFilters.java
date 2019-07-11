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

public class EnvironmentPaginationFilters  {

	//EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	SystemsPage systemsPage =new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	   
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 1)
		public void environmentsPagination_IdEquals() throws ParseException, InterruptedException{
			
			//create system
			systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
			systemsPage.setDataToProperty("id","System_Id");
			systemsPage.setDataToProperty("name","System_name");
			APIListener.addLogger( "System has been created successfully! ");
			
			//create environment 1
			environmentPage.createEnvironmentwithSystemName("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id","System_name");
			environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			APIListener.addLogger( "Environment has been created successfully! ");
			environmentPage.setDataToProperty("id","Env_id");
			environmentPage.setDataToProperty("name","Env_name");
			environmentPage.setDataToProperty("url","Env_url");
			environmentPage.setDataToProperty("linkedSystem","Env_linkedSystem");
			environmentPage.setDataToProperty("usageWorkItem","Env_usageWorkItem");
			environmentPage.setDataToProperty("environmentStatus","Env_status");
			environmentPage.setDataToProperty("color", "EnvGroup_color");

			
			// id equals 
			APIListener.addLogger( "[API] - Environments attribute 'id' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("id", "Equals", "Env_id", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("id");
			environmentPage.verifyResponseArrayValueForPagination("id","Env_id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'id' fetching value for Equals operator successfully!"); 
			
		}
	
		//id not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 2)
		public void environmentsPagination_idNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'id' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("id", "Not Equals", "Env_id", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("id");
			environmentPage.verifyResponseArrayValueForPagination("id","Env_id",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'id' fetching value for Not Equals operator successfully!"); 
		}
		
		//name equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 3)
		public void environmentsPagination_NameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'name' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("name", "Equals", "Env_name", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("name");
			environmentPage.verifyResponseArrayValueForPagination("name","Env_name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'name' fetching value for Equals operator successfully!"); 
		}
				
		//name not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 4)
		public void environmentsPagination_NameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'name' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("name", "Not Equals", "Env_name", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("name");
			environmentPage.verifyResponseArrayValueForPagination("name","Env_name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'name' fetching value for Not Equals operator successfully!"); 
		}
						
		//name contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 5)
		public void environmentsPagination_NameContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'name' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("name", "Contains", "Env_name", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("name");
			environmentPage.verifyResponseArrayValueForPagination("name","Env_name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'name' fetching value for Contains operator successfully!"); 
		}
						
		//name not contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 6)
		public void environmentsPagination_NameNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'name' fetching value for Not Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("name", "Not Contains", "Env_name", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("name");
			environmentPage.verifyResponseArrayValueForPagination("name","Env_name",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'name' fetching value for Not Contains operator successfully!"); 
		}
	
		//url equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 7)
		public void environmentsPagination_urlEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'url' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("url", "Equals", "Env_url", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("url");
			environmentPage.verifyResponseArrayValueForPagination("url","Env_url",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'url' fetching value for Equals operator successfully!"); 
		}
		
		//url not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 8)
		public void environmentsPagination_urlNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'url' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("url", "Not Equals", "Env_url", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("url");
			environmentPage.verifyResponseArrayValueForPagination("url","Env_url",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'url' fetching value for Not Equals operator successfully!"); 
		}
				
		//url contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 9)
		public void environmentsPagination_urlContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'url' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("url", "Contains", "Env_url", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("url");
			environmentPage.verifyResponseArrayValueForPagination("url","Env_url",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'url' fetching value for Contains operator successfully!"); 
		}
				
		//url not contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 10)
		public void environmentsPagination_urlNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'url' fetching value for Not Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("url", "Not Contains", "Env_url", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("url");
			environmentPage.verifyResponseArrayValueForPagination("url","Env_url",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'url' fetching value for Not Contains operator successfully!"); 
		}
	
		//linkedSystem equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 11)
		public void environmentsPagination_linkedSystemEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'linkedSystem' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("linkedSystem", "Equals", "Env_linkedSystem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("linkedSystem");
			environmentPage.verifyResponseArrayValueForPagination("linkedSystem","Env_linkedSystem",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'linkedSystem' fetching value for Equals operator successfully!"); 
		}
			
		//linkedSystem not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 12)
		public void environmentsPagination_linkedSystemNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'linkedSystem' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("linkedSystem", "Not Equals", "Env_linkedSystem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("linkedSystem");
			environmentPage.verifyResponseArrayValueForPagination("linkedSystem","Env_linkedSystem",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'linkedSystem' fetching value for Not Equals operator successfully!"); 
		}
		
		//linkedSystem contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 13)
		public void environmentsPagination_linkedSystemContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'linkedSystem' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("linkedSystem", "Contains", "Env_linkedSystem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("linkedSystem");
			environmentPage.verifyResponseArrayValueForPagination("linkedSystem","Env_linkedSystem",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'linkedSystem' fetching value for Contains operator successfully!"); 
		}
				
		//linkedSystem not contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 14)
		public void environmentsPagination_linkedSystemNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'linkedSystem' fetching value for Not contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("linkedSystem", "Not Contains", "Env_linkedSystem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("linkedSystem");
			environmentPage.verifyResponseArrayValueForPagination("linkedSystem","Env_linkedSystem",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'linkedSystem' fetching value for Not Contains operator successfully!"); 
		}
		
		//usageWorkItem equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 15)
		public void environmentsPagination_usageWorkItemEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'usageWorkItem' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("usageWorkItem", "Equals", "Env_usageWorkItem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("usageWorkItem");
			environmentPage.verifyResponseArrayValueForPagination("usageWorkItem","Env_usageWorkItem",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'usageWorkItem' fetching value for Equals operator successfully!"); 
		}	
		
		//usageWorkItem not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 16)
		public void environmentsPagination_usageWorkItemNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'usageWorkItem' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("usageWorkItem", "Not Equals", "Env_usageWorkItem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("usageWorkItem");
			environmentPage.verifyResponseArrayValueForPagination("usageWorkItem","Env_usageWorkItem",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'usageWorkItem' fetching value for Not Equals operator successfully!"); 
		}	
		
		//usageWorkItem Contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 17)
		public void environmentsPagination_usageWorkItemContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'usageWorkItem' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("usageWorkItem", "Contains", "Env_usageWorkItem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("usageWorkItem");
			environmentPage.verifyResponseArrayValueForPagination("usageWorkItem","Env_usageWorkItem",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'usageWorkItem' fetching value for Contains operator successfully!"); 
		}
				
		//usageWorkItem not contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 18)
		public void environmentsPagination_usageWorkItemNoContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'usageWorkItem' fetching value for Not Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("usageWorkItem", "Not Contains", "Env_usageWorkItem", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("usageWorkItem");
			environmentPage.verifyResponseArrayValueForPagination("usageWorkItem","Env_usageWorkItem",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'usageWorkItem' fetching value for Not Contains operator successfully!"); 
		}

		//status equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 19)
		public void environmentsPagination_statusEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'status' fetching value for Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("status", "Equals", "Env_status", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("status");
			environmentPage.verifyResponseArrayValueForPagination("status","Env_status",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'status' fetching value for Equals operator successfully!"); 
		}
		
		//status not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 20)
		public void environmentsPagination_statusNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'status' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("status", "Not Equals", "Env_status", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("status");
			environmentPage.verifyResponseArrayValueForPagination("status","Env_status",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'status' fetching value for Not Equals operator successfully!"); 
		}
				
		//status contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 21)
		public void environmentsPagination_statusContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'status' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("status", "Contains", "Env_status", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("status");
			environmentPage.verifyResponseArrayValueForPagination("status","Env_status",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'status' fetching value for Contains operator successfully!"); 
		}
				
		//status equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 22)
		public void environmentsPagination_statusNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Environments attribute 'status' fetching value for Not Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("status", "Not Contains", "Env_status", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("status");
			environmentPage.verifyResponseArrayValueForPagination("status","Env_status",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'status' fetching value for Not Contains operator successfully!"); 
		}
		
		//color equals
		String env_color=null;
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 23)
		public void environmentsPagination_colorEquals() throws ParseException, InterruptedException{
		    APIListener.addLogger( "[API] - Environments attribute 'color' fetching value for Equals operator");
		    env_color= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "EnvGroup_color").replace("#", "%23");
		    System.out.println(env_color);
		    PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Env_Groupcolor",env_color);
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("color", "Equals", "Env_Groupcolor", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("color");
			environmentPage.verifyResponseArrayValueForPagination("color","Env_Groupcolor",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Environments Page attribute 'color' fetching value for Equals operator successfully!"); 
		}	
		
		//color not equals
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 24)
		public void environmentsPagination_colorNotEquals() throws ParseException, InterruptedException{
		    APIListener.addLogger( "[API] - Environments attribute 'color' fetching value for Not Equals operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("color", "Not Equals", "Env_Groupcolor", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("color");
			environmentPage.verifyResponseArrayValueForPagination("color","Env_Groupcolor",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Environments Page attribute 'color' fetching value for Equals operator successfully!"); 
		}	
		
		//color contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 25)
		public void environmentsPagination_colorContains() throws ParseException, InterruptedException{
		    APIListener.addLogger( "[API] - Environments attribute 'color' fetching value for Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("color", "Contains", "Env_Groupcolor", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("color");
			environmentPage.verifyResponseArrayValueForPagination("color","Env_Groupcolor",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Environments Page attribute 'color' fetching value for Contains operator successfully!"); 
		}	
		
		//color not contains
		@Test(description = "Pagination and filter Combinations for Environments Page", groups = { "RegressionTests" },priority = 26)
		public void environmentsPagination_colorNotContains() throws ParseException, InterruptedException{
		    APIListener.addLogger( "[API] - Environments attribute 'color' fetching value for Not Contains operator");
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterOperator("color", "Not Contains", "Env_Groupcolor", PlutoraAPIConfiguration.testData), "0", "10","environmentsPaginationFilterUrl");
			environmentPage.setDataToPropertys("color");
			environmentPage.verifyResponseArrayValueForPagination("color","Env_Groupcolor",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Environments Page attribute 'color' fetching value for Not Contains operator successfully!"); 
		}	
		
	/*	
	      // combination filter  name equals (a or b) and usageWorkItemName equals (x or y) 
			@Test(description = "Pagination and filter Combinations for Environment Page", groups = { "RegressionTests" },priority = 1)
			public void environmentGroupPagination_Combinations1() throws ParseException, InterruptedException{
				
				//create system
				systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
				systemsPage.setDataToPropertys("id","System_Id");
				APIListener.addLogger( "System has been created successfully! ");
				
				//create environment 1
				environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
				environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
				APIListener.addLogger( "Environment has been created successfully! ");
				environmentPage.setDataToPropertys("id", "Environment_ID");
				environmentPage.setDataToPropertys("name;usageWorkItemName;isSharedEnvironment;linkedSystem" ,"name_1;usageWorkItemName_1;isSharedEnvironment_1;linkedSystem_1");
				environmentPage.setDataToPropertys("color;environmentStatus;usageWorkItemId;linkedSystemId" ,"color_1;environmentStatus_1;usageWorkItemId_1;linkedSystemId_1");
				
				//create another environment//
				//create system
				systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
				systemsPage.setDataToPropertys("id","System_Id1"); 
				APIListener.addLogger( "System has been created successfully! ");
				
				//create environment 
				environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id1");
				environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
				APIListener.addLogger( "Environment has been created successfully! ");
				environmentPage.setDataToPropertys("id", "Environment_ID1");
				environmentPage.setDataToPropertys("name;usageWorkItemName;isSharedEnvironment;linkedSystem" ,"name_2;usageWorkItemName_2;isSharedEnvironment_2;linkedSystem_2");
				environmentPage.setDataToPropertys("color;environmentStatus;usageWorkItemId;linkedSystemId" ,"color_2;environmentStatus_2;usageWorkItemId_2;linkedSystemId_2");
				
				// name equals (a or b) and usageWorkItemName equals (x or y) 
				environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterCombinations_1("name", "equals", "name_1","OR","name_2", "And","usageWorkItemName", "Equals","usageWorkItemName_1", "Or", "usageWorkItemName_2",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
				environmentPage.verifyResponseArrayValueCombination("name",PlutoraAPIConfiguration.testData,"Contains", new String [] {"name_1","name_2"});
				environmentPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"usageWorkItemName_1","usageWorkItemName_2"});
				APIListener.addLogger("Environment groups-- Filter Combination 1 : usageWorkItemName contains(a or b) and  organizationName equals (x or y) is successfull!"); 
					
				
			}
		 
			// environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)
			@Test(description = "Pagination and filter Combinations for Environments groups. Combination 2 :environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)", groups = { "RegressionTests" },priority = 51)
			public void changesPagination_combination2() throws ParseException, InterruptedException{
			APIListener.addLogger( "Environment groups-- Filter Combination 2 : environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b)"); 
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterCombinations_1("environmentIDs", "Equals", "envId_1","OR","envId_2", "Or","usageWorkItemName", "NotEquals","usageIteam_1", "Or", "usageIteam_1",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
			environmentPage.verifyResponseArrayValueCombination("environmentIDs",PlutoraAPIConfiguration.testData,"Contains", new String [] {"envId_1","envId_2"});
			environmentPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"usageIteam_1","usageIteam_2"});
			APIListener.addLogger("Environment groups-- Filter Combination 2 : environmentIDs equals (a or b) or usageWorkItemName notEquals (a or b) is successfull!"); 
				
			}
			
			// name contains (a or b) and color equals ( p or q)
			@Test(description = "Pagination and filter Combinations for Environments groups. Combination 3 :name contains (a or b) and color equals ( p or q)", groups = { "RegressionTests" },priority = 51)
			public void changesPagination_combination3() throws ParseException, InterruptedException{
			APIListener.addLogger( "Environment groups-- Filter Combination 3: name contains (a or b) and color equals ( p or q)"); 
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterCombinations_1("name", "Contains", "name_1","OR","name_2", "And","color", "Equals","color_1", "Or", "color_2",PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
			environmentPage.verifyResponseArrayValueCombination("name",PlutoraAPIConfiguration.testData,"Contains", new String [] {"name_1","name_2"});
			environmentPage.verifyResponseArrayValueCombination("color",PlutoraAPIConfiguration.testData,"Equals", new String [] {"color_1","color_2"});
			APIListener.addLogger("Environment groups-- Filter Combination 3 : name contains (a or b) and color equals ( p or q) is successfull!"); 
						
			}
				
			//  displayBookingAlert contains A or bookingAlertMessage contains( m or n)
			@Test(description = "Pagination and filter Combinations for Environments groups.  displayBookingAlert contains A or bookingAlertMessage contains( m or n)", groups = { "RegressionTests" },priority = 51)
			public void changesPagination_combination4() throws ParseException, InterruptedException{
			APIListener.addLogger( "Environment groups-- Filter Combination 4:  displayBookingAlert contains A or bookingAlertMessage contains( m or n)"); 
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterCombinations_3("displayBookingAlert", "Contains", "displayBook_1", "Or", "bookingAlertMessage", "Contains", "bookingAlertMsg_1", "Or", "bookingAlertMsg_2", PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
			environmentPage.verifyResponseArrayValueCombination("displayBookingAlert",PlutoraAPIConfiguration.testData,"Contains", new String [] {"displayBook_1"});
			environmentPage.verifyResponseArrayValueCombination("bookingAlertMessage",PlutoraAPIConfiguration.testData,"Contains", new String [] {"bookingAlertMsg_1","bookingAlertMsg_2"});
			APIListener.addLogger("Environment groups-- Filter Combination 4 :  displayBookingAlert contains A or bookingAlertMessage contains( m or n) is successfull!"); 
								
			}
			
		    //  name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)
		    @Test(description = "Pagination and filter Combinations for Environments groups.  1.name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)", groups = { "RegressionTests" },priority = 51)
			public void changesPagination_combination5() throws ParseException, InterruptedException{
			APIListener.addLogger( "Environment groups-- Filter Combination 5: name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n)"); 
			environmentPage.paginationfilter(PlutoraAPIConfiguration.testData, environmentPage.setPaginationFilterCombinations_2("name", "Equals", "name_1", "Or", "name_2", "And", "usageWorkItemName", "Equals", "usageIteam_1", "Or", "usageIteam_2", "Or", "isAutoApproved", "Equals", "isAutoApproved_1", "Or", "isAutoApproved_2", PlutoraAPIConfiguration.testData), "1", "10","changePaginationFilterUrl");
			environmentPage.verifyResponseArrayValueCombination("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
			environmentPage.verifyResponseArrayValueCombination("usageWorkItemName",PlutoraAPIConfiguration.testData,"Equals", new String [] {"usageIteam_1","usageIteam_2"});
			environmentPage.verifyResponseArrayValueCombination("isAutoApproved",PlutoraAPIConfiguration.testData,"Equals", new String [] {"isAutoApproved_1","isAutoApproved_2"});
			APIListener.addLogger("Environment groups-- Filter Combination 5 : name equals (a or b) and usageWorkItemName equals (x or y) or isAutoApproved equals (m or n) is successfull!"); 
									
				}*/
}