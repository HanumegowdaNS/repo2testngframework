package com.plutoraapi.defects;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ChangesPage;

public class ChangesPaginationFilters  {
 
	ChangesPage changesPage = new ChangesPage(); 
	
	//ID Equals id
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 1)
		public void changesPagination_IdEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'id' fetching value for Equals operator"); 
			changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
			changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			changesPage.setDataToProperty("id", "Change_Id");
			changesPage.getChangeWithId(PlutoraAPIConfiguration.testData,"Change_Id");
			changesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			changesPage.setDataToProperty("id", "Change_Id");
			changesPage.setDataToProperty("name", "change_name"); 
			changesPage.setDataToProperty("changePriority", "change_priority");
			changesPage.setDataToProperty("changeStatus", "change_status");
			changesPage.setDataToProperty("businessValueScore", "change_BVS");
			changesPage.setDataToProperty("raisedBy", "raised_By");
			//changesPage.setDataToProperty("assignedToId", "assigned_ToId");
			//changesPage.setDataToProperty("assignedTo", "assigned_To");
			changesPage.setDataToProperty("raisedDate", "raised_Date");
			changesPage.setDataToProperty("lastModifiedDate", "last_ModifiedDate");
			changesPage.setDataToProperty("lastModifiedBy", "lastModified_By");
			System.out.println(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "last_ModifiedDate"));
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("id", "Equals", "Change_Id", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("id");
			changesPage.verifyResponseArrayValueForPagination("id","Change_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("----- With Only filter rule -----");
			changesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("id", "Equals", "Change_Id", PlutoraAPIConfiguration.testData),"changePaginationFilterUrl");
			changesPage.setDataToPropertysWithoutPage("id");
			changesPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","Change_Id",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'id' fetching value for Equals operator successfully!"); 
		}
 
		//ID Not Equals 
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 2)
			public void changesPagination_IdNotEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'id' fetching value for Not Equals operator");
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("id", "Not Equals", "Change_Id", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("id");
				changesPage.verifyResponseArrayValueForPagination("id","Change_Id",PlutoraAPIConfiguration.testData,"Not Equals");
				APIListener.addLogger("Changes attribute 'id' fetching value for Not Equals operator is successfully!"); 
                
		}
			
	    //Equals name
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 3)
		public void changesPagination_NameEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for Equals operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("name", "Equals", "change_name", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("name");
			changesPage.verifyResponseArrayValueForPagination("name","change_name",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'name' fetching value for Equals operator successfully!"); 
		}
	
	  //Not Equals name
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 4)
		public void changesPagination_NameNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'name' fetching value for Not Equals operator");
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("name", "Not Equals", "change_name", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("name");
			changesPage.verifyResponseArrayValueForPagination("name","change_name",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'name' fetching value for Not Equals operator is successfully!"); 

		}
	
	    //name contains 
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 5)
		public void changesPagination_NameContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'Name' fetching value for Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("name", "Contains", "change_name", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("name");
			changesPage.verifyResponseArrayValueForPagination("name","change_name",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger( "Changes attribute 'status' fetching value for Contains operator successfully!"); 
		}
     
	    //name not contains
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 6)
		public void changesPagination_NameNotContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'Name' fetching value for Not Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("name", "Not Contains", "change_name", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("name");
			changesPage.verifyResponseArrayValueForPagination("name","change_name",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger( "Changes attribute 'status' fetching value for NotContains operator successfully!"); 
		 
		}
	
		//Equals priority
	    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 7)
			public void changesPagination_priorityEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Equals operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("priority", "Equals", "change_priority", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("priority");
			changesPage.verifyResponseArrayValueForPagination("priority","change_priority",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'priority' fetching value for Equals operator successfully!"); 
			}
					
	   //priority Not Equals
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 8)
			public void changesPagination_priorityNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Not Equals operator");
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("priority", "Not Equals", "change_priority", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("priority");
			changesPage.verifyResponseArrayValueForPagination("priority","change_priority",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'priority' fetching value for Not Equals operator is successfully!"); 
	
			}
	
		//priority contains 
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 9)
			public void changesPagination_priorityContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("priority", "Contains", "change_priority", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("priority");
			changesPage.verifyResponseArrayValueForPagination("priority","change_priority",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger( "Changes attribute 'priority' fetching value for Contains operator successfully!"); 
			}
		     
		// priority not contains
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 10)
			public void changesPagination_priorityNotContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'priority' fetching value for Not Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("priority", "Not Contains", "change_priority", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("priority");
			changesPage.verifyResponseArrayValueForPagination("priority","change_priority",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger( "Changes attribute 'priority' fetching value for NotContains operator successfully!"); 
				 
		}
		
		//Status Equals 	
	    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 11)
			public void changesPagination_StatusEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Equals operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("status", "Equals", "change_status", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("status");
			changesPage.verifyResponseArrayValueForPagination("status","change_status",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'status' fetching value for Equals operator successfully!"); 
			}
					
	   //status Not Equals
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 12)
			public void changesPagination_statusNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Not Equals operator");
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("status", "Not Equals", "change_status", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("status");
			changesPage.verifyResponseArrayValueForPagination("status","change_status",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'status' fetching value for Not Equals operator is successfully!"); 
	
			}
		
		//status contains 
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 13)
			public void changesPagination_statusContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("status", "Contains", "change_status", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("status");
			changesPage.verifyResponseArrayValueForPagination("status","change_status",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger( "Changes attribute 'status' fetching value for Contains operator successfully!"); 
		}
			     
		// status not contains
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 14)
			public void changesPagination_statusNotContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Not Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("status", "Not Contains", "change_status", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("status");
			changesPage.verifyResponseArrayValueForPagination("status","change_status",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger( "Changes attribute 'status' fetching value for NotContains operator successfully!"); 
				 
		}
			
		//business value score Equals 
	    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 15)
			public void changesPagination_BusinessValueScoreEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'BusinessValueScore' fetching value for Equals operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Equals", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'businessValueScore' fetching value for Equals operator successfully!"); 
			}
					
	   //business value score Not Equals
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 16)
			public void changesPagination_BusinessValueScoreNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'status' fetching value for Not Equals operator");
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Not Equals", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'businessValueScore' fetching value for Not Equals operator is successfully!"); 
	
			}
		
		//business value score greater than
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 17)
		public void changesPagination_BusinessValueScoreGreaterThan() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for GreaterThan operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Greater Than", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for GreaterThan operator successfully!"); 
			}
	
		//business value score greater or equal 
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 18)
			public void changesPagination_BusinessValueScoreGreaterOrEqual() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for GreaterOrEqual operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Greater Or Equal", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for GreaterOrEqual operator successfully!"); 
	}
		//business value score less than
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 19)
			public void changesPagination_BusinessValueScoreLessThan() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for LessThan operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Less Than", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for LessThan operator successfully!"); 
		}
			
		//business value score LessThan or equal 
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 20)
			public void changesPagination_BusinessValueScoreLessOrEqual() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'businessValueScore' fetching value for LessOrEqual operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("businessValueScore", "Less Or Equal", "change_BVS", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("businessValueScore");
			changesPage.verifyResponseArrayValueForPagination("businessValueScore","change_BVS",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger( "Changes attribute 'businessValueScore' fetching value for LessOrEqual operator successfully!"); 
		}
	
		//raisedBy Equals 
	    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 21)
			public void changesPagination_raisedByEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Equals operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedBy", "Equals", "raised_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("raisedBy");
			changesPage.verifyResponseArrayValueForPagination("raisedBy","raised_By",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'raisedBy' fetching value for Equals operator successfully!"); 
			}
					
	   //raised by Not Equals
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 22)
			public void changesPagination_raisedByNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Not Equals operator");
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedBy", "Not Equals", "raised_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("raisedBy");
			changesPage.verifyResponseArrayValueForPagination("raisedBy","raised_By",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'raisedBy' fetching value for Not Equals operator is successfully!"); 
			}
		
		//raised by contains 
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 23)
			public void changesPagination_raisedByContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedBy", "Contains", "raised_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("raisedBy");
			changesPage.verifyResponseArrayValueForPagination("raisedBy","raised_By",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for Contains operator successfully!"); 
		}
			     
		// raised by not contains
		@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 24)
			public void changesPagination_raisedByNotContains() throws ParseException{
			APIListener.addLogger( "[API] - Changes attribute 'raisedBy' fetching value for Not Contains operator"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedBy", "Not Contains", "raised_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("raisedBy");
			changesPage.verifyResponseArrayValueForPagination("raisedBy","raised_By",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger( "Changes attribute 'raisedBy' fetching value for NotContains operator successfully!"); 
		}
		
		    String[] lastModified_date;
		    // //last Modified date equals
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 25)
			public void changesPagination_LastModifiedDateEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for Equals operators"); 
			System.out.println(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "last_ModifiedDate"));
			lastModified_date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "last_ModifiedDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_lastModifiedDate",lastModified_date[0]);
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Equals", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			//PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_lastModifiedDate",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "lastModifiedDate").split("T")[0]);
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for Equals operator successfully!"); 
			}
			
		 //last Modified date Not equals
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 26)
			public void changesPagination_LastModifiedDateNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for Not Equals operators"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Not Equals", "split_lastModifiedDate",PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for Not Equals operator successfully!"); 
			}
			
		    //last Modified date GreaterThan
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 27)
			public void changesPagination_LastModifiedDateGreaterThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for Greater Than operators"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Greater Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for GreaterThan operator successfully!"); 
			}
		    

		    //last Modified date GreaterOrEqual
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 28)
			public void changesPagination_LastModifiedDateGreaterOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for GreaterOrEqual operators"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Greater Or Equal","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for GreaterOrEqual operator successfully!"); 
			}
			
		    //last Modified date LessThan
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 29)
			public void changesPagination_LastModifiedDateLessThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for LessThan operators"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Less Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for LessThan operator successfully!"); 
			}
		    
		  //last Modified date LessOrEqual
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 30)
			public void changesPagination_LastModifiedDateLessOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'lastModified Date' fetching value for LessOrEqual operators"); 
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Less Or Equal", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("lastModifiedDate");
			changesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("Changes attribute 'lastModified Date' fetching value for LessOrEqual operator successfully!"); 
			}
		    
		  //assignedTo Equals 
		/*    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 31)
				public void changesPagination_assignedToEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedTo' fetching value for Equals operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedTo", "Equals", "assigned_To", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedTo");
				changesPage.verifyResponseArrayValueForPagination("assignedTo","assigned_To",PlutoraAPIConfiguration.testData,"Equals");
				APIListener.addLogger("Changes attribute 'assignedTo' fetching value for Equals operator successfully!"); 
				}
						
		   //assignedTo Not Equals
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 32)
				public void changesPagination_assignedToNotEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedTo' fetching value for Not Equals operator");
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedTo", "Not Equals", "assigned_To", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedTo");
				changesPage.verifyResponseArrayValueForPagination("assignedTo","assigned_To",PlutoraAPIConfiguration.testData,"Not Equals");
				APIListener.addLogger("Changes attribute 'assignedTo' fetching value for Not Equals operator is successfully!"); 
				}
			
			//assignedTo contains 
				@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 33)
				public void changesPagination_assignedToContains() throws ParseException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedTo' fetching value for Contains operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedTo", "Contains", "assigned_To", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedTo");
				changesPage.verifyResponseArrayValueForPagination("assignedTo","assigned_To",PlutoraAPIConfiguration.testData,"Contains");
				APIListener.addLogger( "Changes attribute 'assignedTo' fetching value for Contains operator successfully!"); 
			}
				     
			//assignedTo not contains
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 34)
				public void changesPagination_assignedToNotContains() throws ParseException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedTo' fetching value for Not Contains operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedTo", "Not Contains", "assigned_To", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedTo");
				changesPage.verifyResponseArrayValueForPagination("assignedTo","assigned_To",PlutoraAPIConfiguration.testData,"Not Contains");
				APIListener.addLogger( "Changes attribute 'assignedTo' fetching value for NotContains operator successfully!"); 
					 
			}  
			
		
			 //assignedToId Equals 
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 35)
				public void changesPagination_assignedToIdEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedToId' fetching value for Equals operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedToId", "Equals", "assigned_ToId", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedToId");
				changesPage.verifyResponseArrayValueForPagination("assignedToId","assigned_ToId",PlutoraAPIConfiguration.testData,"Equals");
				APIListener.addLogger("Changes attribute 'assignedToId' fetching value for Equals operator successfully!"); 
				}
						
		   //assignedTo Not Equals
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 36)
				public void changesPagination_assignedToIdNotEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'assignedToId' fetching value for Not Equals operator");
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("assignedToId", "Not Equals", "assigned_ToId", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("assignedToId");
				changesPage.verifyResponseArrayValueForPagination("assignedToId","assigned_ToId",PlutoraAPIConfiguration.testData,"Not Equals");
				APIListener.addLogger("Changes attribute 'assignedToId' fetching value for Not Equals operator is successfully!"); 
				}	*/   
		    
		//lastModifiedBy Equals 
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 37)
				public void changesPagination_lastModifiedByEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Equals operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedBy", "Equals", "lastModified_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("lastModifiedBy");
				changesPage.verifyResponseArrayValueForPagination("lastModifiedBy","lastModified_By",PlutoraAPIConfiguration.testData,"Equals");
				APIListener.addLogger("Changes attribute 'lastModifiedBy' fetching value for Equals operator successfully!"); 
				}
						
		   //lastModifiedBy Not Equals
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 38)
				public void changesPagination_lastModifiedByNotEquals() throws ParseException, InterruptedException{
				APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Not Equals operator");
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedBy", "Not Equals", "lastModified_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("lastModifiedBy");
				changesPage.verifyResponseArrayValueForPagination("lastModifiedBy","lastModified_By",PlutoraAPIConfiguration.testData,"Not Equals");				
				APIListener.addLogger("Changes attribute 'lastModifiedBy' fetching value for Not Equals operator is successfully!"); 
		
				}
			
			//lastModifiedBy contains 
				@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 39)
				public void changesPagination_lastModifiedByContains() throws ParseException{
				APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Contains operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedBy", "Contains", "lastModified_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("lastModifiedBy");
				changesPage.verifyResponseArrayValueForPagination("lastModifiedBy","lastModified_By",PlutoraAPIConfiguration.testData,"Contains");
				APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for Contains operator successfully!"); 
			}
				     
			//lastModifiedBy not contains
			@Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 40)
				public void changesPagination_lastModifiedByNotContains() throws ParseException{
				APIListener.addLogger( "[API] - Changes attribute 'lastModifiedBy' fetching value for Not Contains operator"); 
				APIListener.addLogger("----- With pagenum and records per page -----");
				changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedBy", "Not Contains", "lastModified_By", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("lastModifiedBy");
				changesPage.verifyResponseArrayValueForPagination("lastModifiedBy","lastModified_By",PlutoraAPIConfiguration.testData,"Not Contains");
				APIListener.addLogger( "Changes attribute 'lastModifiedBy' fetching value for NotContains operator successfully!"); 
			}  
			
			String[] raised_date_on;
			// //raised date equals
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 41)
			public void changesPagination_raisedDateEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Equals operators"); 
			raised_date_on= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "raised_Date").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_raisedDate",raised_date_on[0]);
			APIListener.addLogger("----- With pagenum and records per page -----");
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedDate", "Equals","split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.setDataToPropertys("raisedDate");
			changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Changes attribute 'raised Date' fetching value for Equals operator successfully!"); 
			}
			
			 //raised date Not equals
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 42)
			public void changesPagination_raisedDateNotEquals() throws ParseException, InterruptedException{
		    	APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Not Equals operators"); 
		    	APIListener.addLogger("----- With pagenum and records per page -----");
		    	changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedDate", "Not Equals", "split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("raisedDate");
				changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Not Equals");
				APIListener.addLogger("Changes attribute 'raised Date' fetching value for Not Equals operator successfully!"); 
			}
			
		    //raised date GreaterThan
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 43)
			public void changesPagination_raisedDateGreaterThan() throws ParseException, InterruptedException{
		    	APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Greater Than operators"); 
		    	APIListener.addLogger("----- With pagenum and records per page -----");
		    	changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedDate", "Greater Than", "split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("raisedDate");
				changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Greater Than");
				APIListener.addLogger("Changes attribute 'raised Date' fetching value for Greater Than operator successfully!"); 
			}
		    

		    //raised date GreaterOrEqual
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 44)
			public void changesPagination_raisedDateGreaterOrEqual() throws ParseException, InterruptedException{
		    	APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Greater Or Equal operators"); 
		    	APIListener.addLogger("----- With pagenum and records per page -----");
		    	changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("lastModifiedDate", "Greater Or Equal", "split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("raisedDate");
				changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
				APIListener.addLogger("Changes attribute 'raised Date' fetching value for Greater Or Equal operator successfully!"); 
			}
			
		    //raised date LessThan
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 45)
			public void changesPagination_raisedDateLessThan() throws ParseException, InterruptedException{
		    	APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Less Than operators"); 
		    	APIListener.addLogger("----- With pagenum and records per page -----");	
		    	changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedDate", "Less Than","split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
					changesPage.setDataToPropertys("raisedDate");
					changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Less Than");
					APIListener.addLogger("Changes attribute 'raised Date' fetching value for Less Than operator successfully!"); 
			}
		    
		  //raised LessOrEqual
		    @Test(description = "Pagination and filter Combinations for Changes", groups = { "RegressionTests" },priority = 46)
			public void changesPagination_raisedDateLessOrEqual() throws ParseException, InterruptedException{
		    	APIListener.addLogger( "[API] - Changes attribute 'raised Date' fetching value for Less Than operators"); 
		    	APIListener.addLogger("----- With pagenum and records per page -----");
		    	changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterOperator("raisedDate", "Less Or Equal", "split_raisedDate", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
				changesPage.setDataToPropertys("raisedDate");
				changesPage.verifyDateResponseArrayValueForPagination("raisedDate","split_raisedDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
				APIListener.addLogger("Changes attribute 'raised Date' fetching value for Less Or Equal operator successfully!"); 
			}
	  
			
	  /*  
		//combinations name equals (a or b)
		    @Test(description = "Pagination and filter Combinations for Changes. Combination 1 : name equals (a or b) ", groups = { "RegressionTests" },priority = 50)
			public void changesPagination_combination1() throws ParseException, InterruptedException{
			APIListener.addLogger( "Changes-- Filter Combination 1 : "+"name equals a or name equals b"+" "); 
			
			changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
			changesPage.setDataToPropertys("id", "Change_Id_1");
			changesPage.setDataToPropertys("name", "name_1");
			changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			
			changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
			changesPage.setDataToPropertys("id", "Change_Id_2");
			changesPage.setDataToPropertys("name", "name_2");
			changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			
			// name equals A OR name equals B
			changesPage.paginationfilter(PlutoraAPIConfiguration.testData, changesPage.setPaginationFilterCombinations("name", "Equals", "name_1","OR","name_2", PlutoraAPIConfiguration.testData), "0", "10","changePaginationFilterUrl");
			changesPage.verifyResponseArrayValueCombinations("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
			APIListener.addLogger("Changes-- Filter Combination 1 : "+"name equals a or name equals b"+" is successfull!"); 
			 changesPage.deleteChanges(PlutoraAPIConfiguration.testData, "Change_Id_1");
			 changesPage.deleteChanges(PlutoraAPIConfiguration.testData, "Change_Id_2");
		    }
		 
		      
		//combinations name equals (a or b) and status equals (x or y)
		@Test(description = "Pagination and filter Combinations for Changes. Combination 2 : name equals (a or b) and status equals (x or y)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination2() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination 2 : name equals (a or b) and status equals (x or y)"); 
		
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_1");
		changesPage.setDataToPropertys("name", "name_1");
		changesPage.setDataToPropertys("changeStatus","status_1");
		changesPage.setDataToPropertys("raisedDate","raised_Date");
		String [] dateRaised;
		
		//change the json for creating change
		changesPage.createChanges("createChanges4265Json1", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_2");
		changesPage.setDataToPropertys("name", "name_2");
		changesPage.setDataToPropertys("changeStatus","status_2");
		
		// name equals ( A OR B )  and status equals (x or y)
	     changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
				changesPage.setPaginationFilterCombinations_1("name", "Equals", "name_1", "Or", "name_2", "And","status", "status_1", "status_2", PlutoraAPIConfiguration.testData),
				"0", "10", "changePaginationFilterUrl");
	     changesPage.verifyResponseArrayValueCombinations("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
	     changesPage.verifyResponseArrayValueCombinations("status",PlutoraAPIConfiguration.testData,"Equals", new String [] {"status_1","status_2"});
		 APIListener.addLogger("Changes-- Filter Combination 2 : name equals (a or b) and status equals (x or y) is successfull!"); 
		 changesPage.deleteChanges(PlutoraAPIConfiguration.testData, "Change_Id_1");
		 changesPage.deleteChanges(PlutoraAPIConfiguration.testData, "Change_Id_2");
	

	}
		@Test(description = "Pagination and filter Combinations for Changes. Combination 2 : name equals (a or b) and status equals (x or y)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination3() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination 3 : name equals (a or b) and status equals (x)"); 
		changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
				changesPage.setPaginationFilterCombinations_2("name", "Equals", "name_1", "Or", "name_2", "And","status", "status_1", PlutoraAPIConfiguration.testData),
				"0", "10", "changePaginationFilterUrl");
	     changesPage.verifyResponseArrayValueCombinations("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
	     changesPage.verifyResponseArrayValueCombinations("status",PlutoraAPIConfiguration.testData,"Equals", new String [] {"status_1","status_2"});
		 APIListener.addLogger("Changes-- Filter Combination 3 : "+"name equals (a or b) and status equals (x)"+" is successfull!"); 
		}
		
		@Test(description = "Pagination and filter Combinations for Changes. Combination 2 : name equals (a or b) and status equals (x or y)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination4() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination 3 : name equals (a or b) and status equals (x)"); 
		changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
				changesPage.setPaginationFilterCombinations_3("raisedDate", "Greater Or Equal", "", "And", "status", "Equals","status_1", "Or","status_2", PlutoraAPIConfiguration.testData),
				"0", "10", "changePaginationFilterUrl");
	     changesPage.verifyResponseArrayValueCombinations("name",PlutoraAPIConfiguration.testData,"Equals", new String [] {"name_1","name_2"});
	     changesPage.verifyResponseArrayValueCombinations("status",PlutoraAPIConfiguration.testData,"Equals", new String [] {"status_1","status_2"});
		 APIListener.addLogger("Changes-- Filter Combination 3 : "+"name equals (a or b) and status equals (x)"+" is successfull!"); 
		}
		
		
		// deliveryRisk contains(a or b) or  businessValueScore equals (x or y)
		@Test(description = "Pagination and filter Combinations for Changes. Combination 3 : deliveryRisk contains(a or b) or  businessValueScore equals (x or y)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination3() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination  :  deliveryRisk contains(a or b) or  businessValueScore equals (x or y)"); 
		
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_1");
		changesPage.setDataToPropertys("deliveryRisk", "deliveryRisk_1");
		changesPage.setDataToPropertys("businessValueScore","businessValueScore_1");
		//change the json for creating change
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_2");
		changesPage.setDataToPropertys("deliveryRisk", "deliveryRisk_2");
		changesPage.setDataToPropertys("businessValueScore","businessValueScore_2");
		
		// name equals ( A OR B )  and status equals (x or y)
	     changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
				changesPage.setPaginationFilterCombinations_1("deliveryRisk", "Contains", "deliveryRisk_1", "Or", "deliveryRisk_2", "Or",
						"businessValueScore", "Equals", "businessValueScore_1", "Or", "businessValueScore_2", PlutoraAPIConfiguration.testData),
				"1", "10", "changePaginationFilterUrl");
	     changesPage.verifyResponseArrayValueCombination("deliveryRisk",PlutoraAPIConfiguration.testData,"Contains", new String [] {"deliveryRisk_1","deliveryRisk_2"});
	     changesPage.verifyResponseArrayValueCombination("businessValueScore",PlutoraAPIConfiguration.testData,"Equals", new String [] {"businessValueScore_1","businessValueScore_2"});
		 APIListener.addLogger("Changes-- Filter Combination : deliveryRisk contains(a or b) or  businessValueScore equals (x or y) is successfull!"); 
		}
		
		//raisedBy equals (a or b) and type equals (a or b)
		@Test(description = "Pagination and filter Combinations for Changes. Combination 4 : raisedBy equals (a or b) and type equals (a or b)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination4() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination  :  raisedBy equals (a or b) and type equals (a or b)"); 
		
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_1");
		changesPage.setDataToPropertys("raisedBy", "raisedBy_1");
		changesPage.setDataToPropertys("type","type_1");
		//change the json for creating change
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_2");
		changesPage.setDataToPropertys("raisedBy", "raisedBy_2");
		changesPage.setDataToPropertys("type","type_2");
		
		// name equals ( A OR B )  and status equals (x or y)
	     changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
				changesPage.setPaginationFilterCombinations_1("raisedBy", "Equals", "raisedBy_1", "Or", "raisedBy_2", "And",
						"type", "Equals", "type_1", "Or", "type_2", PlutoraAPIConfiguration.testData),
				"1", "10", "changePaginationFilterUrl");
	     changesPage.verifyResponseArrayValueCombination("raisedBy",PlutoraAPIConfiguration.testData,"Equals", new String [] {"raisedBy_1","raisedBy_2"});
	     changesPage.verifyResponseArrayValueCombination("type",PlutoraAPIConfiguration.testData,"Equals", new String [] {"type_1","type_2"});
		 APIListener.addLogger("Changes-- Filter Combination : raisedBy equals (a or b) and type equals (a or b) is successfull!"); 
		}
		
		// raisedDate greaterThan (a or b) and status equals( p or q)
		@Test(description = "Pagination and filter Combinations for Changes. Combination 5: raisedDate greaterThan (a or b) and status equals( p or q)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination5() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination  : raisedDate greaterThan (a or b) and status equals( p or q)"); 
			
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_1");
		changesPage.setDataToPropertys("raisedDate", "raisedDate_1");
		changesPage.setDataToPropertys("status","status_1");
		//change the json for creating change
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_2");
		changesPage.setDataToPropertys("raisedDate", "raisedDate_2");
		changesPage.setDataToPropertys("status","status_2");
		
		// raisedDate greaterThan (a or b) and status equals( p or q)
		changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
		changesPage.setPaginationFilterCombinations_1("raisedDate", "greaterThan", "raisedDate_1", "Or", "raisedDate_2", "And",
				"status", "Equals", "status_1", "Or", "status_2", PlutoraAPIConfiguration.testData),
				"1", "10", "changePaginationFilterUrl");
		changesPage.verifyResponseArrayValueCombination("raisedBy",PlutoraAPIConfiguration.testData,"greaterThan", new String [] {"raisedBy_1","raisedBy_2"});
		changesPage.verifyResponseArrayValueCombination("status",PlutoraAPIConfiguration.testData,"Equals", new String [] {"status_1","status_2"});
		APIListener.addLogger("Changes-- Filter Combination : raisedDate greaterThan (a or b) and status equals( p or q) is successfull!"); 
				}
		
		// status notEquals (a or b) or number contains(x or y) and raisedDate greaterThan (m or n)
		@Test(description = "Pagination and filter Combinations for Changes. Combination 6: status notEquals (a or b) or number contains(x or y) and raisedDate greaterThan (m or n)", groups = { "RegressionTests" },priority = 51)
		public void changesPagination_combination6() throws ParseException, InterruptedException{
		APIListener.addLogger( "Changes-- Filter Combination  :status notEquals (a or b) or number contains(x or y) and raisedDate greaterThan (m or n)"); 
			
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_1");
		changesPage.setDataToPropertys("raisedDate", "raisedDate_1");
		changesPage.setDataToPropertys("status","status_1");
		changesPage.setDataToPropertys("number","number_1");
		//change the json for creating change
		changesPage.createChanges("createChanges4265Json", PlutoraAPIConfiguration.testData);
		changesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		changesPage.setDataToPropertys("id", "Change_Id_2");
		changesPage.setDataToPropertys("raisedDate", "raisedDate_2");
		changesPage.setDataToPropertys("status","status_2");
		changesPage.setDataToPropertys("number","number_2");
		
		// status notEquals (a or b) or number contains(x or y) and raisedDate greaterThan (m or n)"
		changesPage.paginationfilter(PlutoraAPIConfiguration.testData,
		changesPage.setPaginationFilterCombinations_2("status", "notEquals", "status_1", "Or","status_2", "Or", "number", "Contains", "number_1", "Or", "number_2", "and", "raisedDate", "graterThan", "raisedDate_1", "Or", "raisedDate_2",PlutoraAPIConfiguration.testData),
				"1", "10", "changePaginationFilterUrl");
		changesPage.verifyResponseArrayValueCombination("number",PlutoraAPIConfiguration.testData,"Contains", new String [] {"number_1","number_2"});
		changesPage.verifyResponseArrayValueCombination("status",PlutoraAPIConfiguration.testData,"Equals", new String [] {"status_1","status_2"});
		changesPage.verifyResponseArrayValueCombination("raisedDate",PlutoraAPIConfiguration.testData,"greaterThan", new String [] {"raisedDate_1","raisedDate_2"});
		APIListener.addLogger("Changes-- Filter Combination :status notEquals (a or b) or number contains(x or y) and raisedDate greaterThan (m or n) is successfull!"); 
				}
	*/
}
		
