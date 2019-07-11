package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.LookupFieldsPage;
import com.plutoraapi.pagerepo.TECRPage;

public class TECRPaginationFiltersWithoutPageNum {
	TECRPage tecrsPage = new TECRPage();
	LookupFieldsPage lookUp = new LookupFieldsPage();

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 1)
	public void getTECR_Pagination_IdEquals() throws ParseException, InterruptedException {
	APIListener.addLogger("[API] - TECRs attribute 'id' fetching value for Equals operator");
	tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
	tecrsPage.setDataToProperty("id","tecr_id");
	tecrsPage.setDataToProperty("title","tecr_title");
	tecrsPage.setDataToProperty("startDate", "tecr_StartDate");
	tecrsPage.setDataToProperty("dueDate", "tecr_DueDate");
	tecrsPage.setDataToProperty("description", "tecr_Description");
	tecrsPage.setDataToProperty("outage", "tecr_Outage");
	tecrsPage.setDataToProperty("outageStartDate", "outage_StartDate");
	tecrsPage.setDataToProperty("outageEndDate", "outage_EndDate");
	tecrsPage.setDataToProperty("lastModifiedDate", "last_ModifiedDate");
	tecrsPage.setDataToProperty("lastModifiedBy", "last_ModifiedBy");
	tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
	tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
	tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"tecr_id");	
	tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("id", "Equals","tecr_id", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
	tecrsPage.setDataToPropertysWithoutPage("id");
	tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","tecr_id",PlutoraAPIConfiguration.testData,"Equals");
	APIListener.addLogger("TECRs attribute 'id' fetching value for Equals operator  successfully!");
	}
	
	//id not equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 2)
	public void getTECR_Pagination_IdNotEquals() throws ParseException, InterruptedException {
	APIListener.addLogger("[API] - TECRs attribute 'id' fetching value for Not Equals operator");
	tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
	tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"tecr_id");	
	tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("id", "Not Equals","tecr_id", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
	tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("id","tecr_id",PlutoraAPIConfiguration.testData,"Not Equals");
	APIListener.addLogger("TECRs attribute 'id' fetching value for Not equals operator  successfully!");
	}

  // title equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 3)
	public void getTECR_Pagination_titleEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'title' fetching value for Equals operator");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "Equals","tecr_title", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("title");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("title","title",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TECRs attribute 'title' fetching value for equals operator  successfully!");
		}
	
	// title equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 4)
	public void getTECR_Pagination_titleNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'title' fetching value for Not Equals operator");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "Not Equals","tecr_title", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("title");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("title","tecr_title",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TECRs attribute 'title' fetching value for equals operator  successfully!");
			}
		
    // title contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 5)
		public void getTECR_Pagination_titleContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'title' fetching value for Contains operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "Contains","tecr_title", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("title");
			tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("title","tecr_title",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TECRs attribute 'title' fetching value for Contains operator  successfully!");
		}

	// title not contains
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 6)
	public void getTECR_Pagination_titleNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'title' fetching value for Not Contains operator");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "Not Contains","tecr_title", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("title");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("title","tecr_title",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("TECRs attribute 'title' fetching value for Not Contains operator  successfully!");
		}

	// crType Equals 
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 7)
	public void getTECR_Pagination_crTypeEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'crType' fetching value for Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType", "Equals", "crType", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		//tecrsPage.setDataToPropertysWithoutPage("crType");
		tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crType","crType",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TECRs attribute 'crType' fetching value for Equals operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
		
	// crType Not Equals 
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 8)
	public void getTECR_Pagination_crTypeNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'crType' fetching value for Not Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"),"tecr_id");	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType", "Not Equals", "crType", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		//tecrsPage.setDataToPropertysWithoutPage("crType");
		tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crType","crType",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TECRs attribute 'crType' fetching value for Not Equals operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}

	// crType contains 
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 9)
	public void getTECR_Pagination_crTypeContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'crType' fetching value for Contains operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType", "Contains", "crType", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crType","crType",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger("TECRs attribute 'crType' fetching value for Contains operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
   // crType Not contains 
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 10)
	public void getTECR_Pagination_crTypeNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'crType' fetching value for Not Contains operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType", "Not Contains", "crType", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crType","crType",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("TECRs attribute 'crType' fetching value for Not Contains operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
	// assignedTo equals  
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 11)
	public void getTECR_Pagination_assignedToEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'assignedTo' fetching value for Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo", "Equals", "assignedTo", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		//tecrsPage.setDataToPropertysWithoutPage("assignedTo");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TECRs attribute 'assignedTo' fetching value for Equals operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
	// assignedTo not equals  
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 12)
	public void getTECR_Pagination_assignedToNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'assignedTo' fetching value for Not Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo", "Not Equals", "assignedTo", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		//tecrsPage.setDataToPropertysWithoutPage("assignedTo");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TECRs attribute 'assignedTo' fetching value for Not Equals operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
	// assignedTo contains  
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 13)
	public void getTECR_Pagination_assignedToContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'assignedTo' fetching value for Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo", "Contains", "assignedTo", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		//tecrsPage.setDataToPropertysWithoutPage("assignedTo");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger("TECRs attribute 'assignedTo' fetching value for Contains operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
		
	// assignedTo equals  
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 14)
	public void getTECR_Pagination_assignedToNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'assignedTo' fetching value for Not Contains operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo", "Not Contains", "assignedTo", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("assignedTo");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("TECRs attribute 'assignedTo' fetching value for Not Contains operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}

	//startDate Equals
	String[] start_Date;
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 15)
	public void getTECR_Pagination_startDateEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Equals operator");
		start_Date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "tecr_StartDate").split("T");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_startDate",start_Date[0]);
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Equals","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Equals operator  successfully!");
	}
	
	//startDate not Equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 16)
	public void getTECR_Pagination_startDateNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Not Equals operator");
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Not Equals","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Not Equals operator  successfully!");
	}
	
	//startDate greater than
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 17)
	public void getTECR_Pagination_startDateGreaterThan() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Greater than operator");
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Greater Than","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Greater Than");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Greater than operator  successfully!");
	}
	
	//startDate greater or equal
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 18)
	public void getTECR_Pagination_startDateGreaterOrEqual() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Greater or Equal operator");
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Greater Or Equal","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Greater Or Equal operator  successfully!");
	}
	
	//startDate less than
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 19)
	public void getTECR_Pagination_startDatelessThan() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Less than operator");
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Less Than","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Less Than");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Less than operator  successfully!");
	}
	
	//startDate Less Or Equal
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 20)
	public void getTECR_Pagination_startDateLessOrEqual() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'startDate' fetching value for Less Or Equal operator");
	    tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("startDate", "Less Or Equal","split_startDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("startDate");
		tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("startDate","split_startDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
		APIListener.addLogger("TECRs attribute 'startDate' fetching value for Less Or Equal operator  successfully!");
	}
	
	//dueDate Equals
	String[] due_Date;
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 21)
		public void getTECR_Pagination_dueDateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for Equals operator");
			due_Date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "tecr_DueDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_dueDate",due_Date[0]);
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Equals","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for Equals operator  successfully!");
		}

	//dueDate not Equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 22)
		public void getTECR_Pagination_dueDateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for Not Equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Not Equals","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for Not Equals operator  successfully!");
	}

	//dueDate GreaterThan
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 23)
	public void getTECR_Pagination_dueDateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for GreaterThan operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Greater Than","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for GreaterThan operator  successfully!");
	}	
	
	//dueDate GreaterOrEqual
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 24)
	public void getTECR_Pagination_dueDateGreaterOrEqual() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for GreaterOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Greater Or Equal","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for GreaterOrEqual operator  successfully!");
	}	
	
	//dueDate lessThan
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 25)
	public void getTECR_Pagination_dueDateLessThan() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for Less Than operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Less Than","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for Less Than operator  successfully!");
	}	
	
	//dueDate LessOrEqual
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 26)
	public void GetTECR_Pagination_dueDateLessOrEqual() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'dueDate' fetching value for LessOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("dueDate", "Less Or Equal","split_dueDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("dueDate");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("dueDate","split_dueDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TECRs attribute 'dueDate' fetching value for LessOrEqual operator  successfully!");
	}
	

	//description Equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 27)
	public void getTECR_Pagination_DescriptionEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'description' fetching value for Equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("description", "Equals","tecr_Description", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("description");
			tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("description","tecr_Description",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'description' fetching value for Equals operator  successfully!");
	}
	
	//description Not Equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 28)
	public void getTECR_Pagination_DescriptionNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'description' fetching value for Not Equals operator");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("description", "Not Equals","tecr_Description", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("description");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("description","tecr_Description",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TECRs attribute 'description' fetching value for Not Equals operator  successfully!");
	}
	
	//description Contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 29)
		public void getTECR_Pagination_DescriptionContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'description' fetching value for Contains operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("description", "Contains","tecr_Description", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.setDataToPropertysWithoutPage("description");
			tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("description","tecr_Description",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TECRs attribute 'description' fetching value for Contains operator  successfully!");
		}
		
	//description Not Contains
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 30)
	public void getTECR_Pagination_DescriptionNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'description' fetching value for Not Contains operator");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("description", "Not Contains","tecr_Description", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.setDataToPropertysWithoutPage("description");
		tecrsPage.verifyResponseArrayValueForPaginationWithOnlyFilterRule("description","tecr_Description",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("TECRs attribute 'description' fetching value for Not Contains operator  successfully!");
	}
	
	//parentReleaseID equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 31)
	public void getTECR_Pagination_parentReleaseIDEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'parentReleaseID' fetching value for Equals operator");
		tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrsPage.setDataToProperty("id");
		tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("parentReleaseID", "Equals", "parentReleaseID", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("parentReleaseID","parentReleaseID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TECRs attribute 'parentReleaseID' fetching value for Equals operator  successfully!");
		tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
	}
	
	//parentReleaseID not equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 32)
		public void getTECR_Pagination_parentReleaseIDNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'parentReleaseID' fetching value for Not Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("parentReleaseID", "Not Equals", "parentReleaseID", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("parentReleaseID","parentReleaseID",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'parentReleaseID' fetching value for Not Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
   //ReleaseID  equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 33)
		public void getTECR_Pagination_ReleaseIDEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseID' fetching value for Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseID", "Equals", "releaseID", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseID","releaseID",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'releaseID' fetching value for Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}

        //ReleaseID not equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 34)
		public void getTECR_Pagination_ReleaseIDNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseID' fetching value for Not Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseID", "Not Equals", "releaseID", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseID","releaseID",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'releaseID' fetching value for Not Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		//Releasename equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 35)
		public void getTECR_Pagination_ReleaseNameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseName' fetching value for Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseName", "Equals", "releaseName", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'releaseName' fetching value for Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
        //Releasename not equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 36)
		public void getTECR_Pagination_ReleaseNameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseName' fetching value for Not Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseName", "Not Equals", "releaseName", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'releaseName' fetching value for Not Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		//Releasename contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 37)
		public void getTECR_Pagination_ReleaseNameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseName' fetching value for Contains operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseName", "Contains", "releaseName", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TECRs attribute 'releaseName' fetching value for Contains operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		//Releasename not Contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 38)
		public void getTECR_Pagination_ReleaseNameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'releaseName' fetching value for Not Contains operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("releaseName", "Not Contains", "releaseName", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TECRs attribute 'releaseName' fetching value for Not Contains operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		   }
		
       //crStatus equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 39)
		public void getTECR_Pagination_crStatusEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'crStatus' fetching value for Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crStatus", "Equals", "crStatus", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crStatus","crStatus",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'crStatus' fetching value for Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		 //crStatus not equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 40)
		public void getTECR_Pagination_crStatusNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'crStatus' fetching value for Not Equals operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crStatus", "Not Equals", "crStatus", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crStatus","crStatus",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'crStatus' fetching value for Not Equals operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		} 
		
		 //crStatus contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 41)
		public void getTECR_Pagination_crStatusContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'crStatus' fetching value for Contains operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crStatus", "Contains", "crStatus", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crStatus","crStatus",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TECRs attribute 'crStatus' fetching value for Contains operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		 //crStatus not Contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 42)
		public void getTECR_Pagination_crStatusNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'crStatus' fetching value for Not Contains operator");
			tecrsPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
			tecrsPage.setDataToProperty("id");
			tecrsPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
			tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));	
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crStatus", "Not Contains", "crStatus", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("crStatus","crStatus",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TECRs attribute 'crStatus' fetching value for Not Contains operator  successfully!");
			tecrsPage.deleteTECR(PlutoraAPIConfiguration.testData);
		}
		
		 //outage Equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 43)
		public void getTECR_Pagination_outageEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage' fetching value for equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outage", "Equals", "tecr_Outage", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("outage","tecr_Outage",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'outage' fetching value for Equals operator  successfully!");
		}
		
		 //outage not Equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 44)
		public void GetTECR_Pagination_outageNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage' fetching value for Not equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outage", "Not Equals", "tecr_Outage", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("outage","tecr_Outage",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'outage' fetching value for Not Equals operator  successfully!");
		}
		
		 //outage startDate Equals
		String[] outagestart_Date;
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 45)
		public void getTECR_Pagination_outageStartDateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for equals operator");
			outagestart_Date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "outage_StartDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_outagestartDate",outagestart_Date[0]);
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Equals", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for Equals operator  successfully!");
		}
		
		 //outage startDate not Equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 46)
		public void getTECR_Pagination_outageStartDateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for not equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Not Equals", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for Not Equals operator  successfully!");
		}
		
		 //outage startDate greater than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 47)
		public void getTECR_Pagination_outageStartDateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for GreaterThan operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Greater Than", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for GreaterThan operator  successfully!");
		}
		
		 //outage startDate Greater or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 48)
		public void getTECR_Pagination_outageStartDateGreaterOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for GreaterOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Greater Or Equal", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for GreaterOrEqual operator  successfully!");
		}
		 //outage startDate less than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 49)
		public void getTECR_Pagination_outageStartDateLessThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for Less Than operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Less Than", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"LessThan");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for LessThan operator  successfully!");
		}
		 //outage startDate less or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 50)
		public void getTECR_Pagination_outageStartDateLessOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage startDate' fetching value for LessOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageStartDate", "Less Or Equal", "split_outagestartDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageStartDate","split_outagestartDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TECRs attribute 'outageStartDate' fetching value for LessOrEqual operator  successfully!");
		}
		
        //outage endDate Equals
		String[] outageend_Date;
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 51)
		public void getTECR_Pagination_outageEndDateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for equals operator");
			outageend_Date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "outage_EndDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_outageendDate",outageend_Date[0]);
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Equals", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for Equals operator  successfully!");
		}

        //outage endDate not Equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 52)
		public void getTECR_Pagination_outageEndDateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for not equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Not Equals", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for Not Equals operator  successfully!");
		}

		  //outage endDate greater than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 53)
		public void getTECR_Pagination_outageEndDateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for GreaterThan operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Greater Than", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for Greater Than operator  successfully!");
		}

		  //outage endDate greater or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 54)
		public void getTECR_Pagination_outageEndDateGreaterOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for GreaterOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Greater Or Equal", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for GreaterOrEqual operator  successfully!");
		}

		  //outage endDate less than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 55)
		public void getTECR_Pagination_outageEndDateLessThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for LessThan operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Less Than", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for Less Than operator  successfully!");
		}

		 //outage endDate less or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 56)
		public void getTECR_Pagination_outageEndDateLessOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'outage endDate' fetching value for LessOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("outageEndDate", "Less Or Equal", "split_outageendDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("outageEndDate","split_outageendDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TECRs attribute 'outage endDate' fetching value for Less Or Equal operator  successfully!");
		}
		
		//last Modified Equals
		String[] lastModified_date;
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 57)
		public void getTECR_Pagination_lastModifieddateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for equals operator");
			lastModified_date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "last_ModifiedDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_lastModifiedDate",lastModified_date[0]);
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Equals", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for Equals operator  successfully!");
		}
		
		//last Modified not Equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 58)
		public void getTECR_Pagination_lastModifieddateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for not equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Equals", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for Equals operator  successfully!");
		}
		
       //last Modified endDate greater than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 59)
		public void getTECR_Pagination_lastModifieddateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for Greater Than operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Greater Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for Greater Than operator  successfully!");
		}
		
		//last Modified endDate greater or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 60)
		public void getTECR_Pagination_lastModifieddateGreaterOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for GreaterOrEqual operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Greater Or Equal", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for Greater Or Equal operator  successfully!");
		}
		
		//last Modified endDate Less than
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 61)
		public void getTECR_Pagination_lastModifieddateLessThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for LessThan operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Less Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for Less Than operator  successfully!");
		}
		
		//last Modified endDate Less or equal
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 62)
		public void getTECR_Pagination_lastModifieddateLessOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedDate' fetching value for Less Or Equal operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedDate", "Less Or Equal", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyDateResponseArrayValueForPaginationWithOnlyFilterRule("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TECRs attribute 'lastModifiedDate' fetching value for LessOrEqual operator  successfully!");
		}
		
		//last Modified by equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 63)
		public void getTECR_Pagination_lastModifiedByEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedBy' fetching value for Equals operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedBy", "Equals", "last_ModifiedBy", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("lastModifiedBy","last_ModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TECRs attribute 'lastModifiedBy' fetching value for Equals operator  successfully!");
		}
		
		//last Modified by not equals
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 64)
		public void getTECR_Pagination_lastModifiedByNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedBy' fetching value for Not Equal operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedBy", "Not Equals", "last_ModifiedBy", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("lastModifiedBy","last_ModifiedBy",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TECRs attribute 'lastModifiedBy' fetching value for Not Equals operator  successfully!");
		}
		
		//last Modified by contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 65)
		public void getTECR_Pagination_lastModifiedByContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedBy' fetching value for Contains operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedBy", "Contains", "last_ModifiedBy", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("lastModifiedBy","last_ModifiedBy",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TECRs attribute 'lastModifiedBy' fetching value for Contains operator  successfully!");
		}
		
		//last Modified by contains
		@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {"RegressionTests" }, priority = 66)
		public void GetTECR_Pagination_lastModifiedByNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TECRs attribute 'lastModifiedBy' fetching value for Not Contains operator");
			tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("lastModifiedBy", "Not Contains", "last_ModifiedBy", PlutoraAPIConfiguration.testData), "GetTECRs_PaginationFiltersUrl");
			tecrsPage.verifyResponseArrayValueForPaginationTECRWithoutPageNum("lastModifiedBy","last_ModifiedBy",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TECRs attribute 'lastModifiedBy' fetching value for Not Contains operator  successfully!");
		}
		
		
/*	
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_title1() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'tile' fetching value for  NotEquals operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "NotEquals",
								"tecr_Title", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("tecr_Title", PlutoraAPIConfiguration.testData, "NotEquals");
		APIListener.addLogger("TECRs attribute 'title' fetching value for NotEquals operator  successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_title2() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'tile' fetching value for  Contains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "Contains",
								"tecr_Title", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("tecr_Title", PlutoraAPIConfiguration.testData, "Contains");
		APIListener.addLogger("TECRs attribute 'title' fetching value for Contains operator  successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_title3() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'tile' fetching value for  NotContains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "NotContains",
								"tecr_Title", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("tecr_Title", PlutoraAPIConfiguration.testData, "NotContains");
		APIListener.addLogger("TECRs attribute 'title' fetching value for NotContains operator  successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_title4() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'tile' fetching value for  isWithin operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "isWithin",
								"tecr_Title", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("tecr_Title", PlutoraAPIConfiguration.testData, "isWithin");
		APIListener.addLogger("TECRs attribute 'title' fetching value for isWithin operator  successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_title5() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TECRs attribute 'tile' fetching value for  NotWithin operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("title", "NotWithin",
								"tecr_Title", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("tecr_Title", PlutoraAPIConfiguration.testData, "NotWithin");
		APIListener.addLogger("TECRs attribute 'title' fetching value for NotWithin operator  successfully!");
	}

	// CR Type
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 5)
	public void GetTECR_Pagination_CRType1() throws ParseException, InterruptedException {
		lookUp.verifyLookupFieldsByID(PlutoraAPIConfiguration.testData, "crType_id");
		lookUp.setDataToPropertysWithoutPage("value", "crType");
		APIListener.addLogger("[API] - Changes attribute 'CRType' fetching value for  Equals operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,
				tecrsPage.setPaginationFilterOperator("crType", "Equals", "crType", PlutoraAPIConfiguration.testData),
				"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("crType", PlutoraAPIConfiguration.testData, "Equals");
		APIListener.addLogger("Changes attribute 'CRType' fetching value for Equals operator successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_CRType2() throws ParseException, InterruptedException {
		lookUp.verifyLookupFieldsByID(PlutoraAPIConfiguration.testData, "crType_id");
		lookUp.setDataToPropertysWithoutPage("value", "crType");
		APIListener.addLogger("[API] - Changes attribute 'CRType' fetching value for  NotEquals operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType",
				"NotEquals", "crType", PlutoraAPIConfiguration.testData), "1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("crType", PlutoraAPIConfiguration.testData, "NotEquals");
		APIListener.addLogger("Changes attribute 'CRType' fetching value for operator NotEquals successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 7)
	public void GetTECR_Pagination_CRType3() throws ParseException, InterruptedException {
		lookUp.verifyLookupFieldsByID(PlutoraAPIConfiguration.testData, "crType_id");
		lookUp.setDataToPropertysWithoutPage("value", "crType");
		APIListener.addLogger("[API] - Changes attribute 'CRType' fetching value for  Contains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,
				tecrsPage.setPaginationFilterOperator("crType", "Contains", "crType", PlutoraAPIConfiguration.testData),
				"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("crType", PlutoraAPIConfiguration.testData, "Contains");
		APIListener.addLogger("Changes attribute 'CRType' fetching value for operator Contains successfully!");
	}

	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 8)
	public void GetTECR_Pagination_CRType4() throws ParseException, InterruptedException {
		lookUp.verifyLookupFieldsByID(PlutoraAPIConfiguration.testData, "crType_id");
		lookUp.setDataToPropertysWithoutPage("value", "crType");
		APIListener.addLogger("[API] - Changes attribute 'CRType' fetching value for  NotContains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("crType",
				"NotContains", "crType", PlutoraAPIConfiguration.testData), "1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("crType", PlutoraAPIConfiguration.testData, "NotContains");
		APIListener.addLogger("Changes attribute 'CRType' fetching value for operator NotContains successfully!");
	}

	// Assigned To equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_AssignedTo() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Changes attribute 'Assigned To' fetching value for equals operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),"tecr_Id");
		tecrsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo",
				"Equals", "assigned_To", PlutoraAPIConfiguration.testData), "1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("assigned_To", PlutoraAPIConfiguration.testData, "Equals");
		APIListener.addLogger("Changes attribute 'Assigned To' fetching value for equals operator successfully!");
	}

	// Assigned To not equals
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_AssignedTo1() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Changes attribute 'Assigned To' fetching value for  NotEquals operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo",
								"NotEquals", "assigned_To", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("assigned_To", PlutoraAPIConfiguration.testData, "NotEquals");
		APIListener.addLogger("Changes attribute 'Assigned To' fetching value for NotEquals operator successfully!");
	}

	// Assigned To contains
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_AssignedTo2() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Changes attribute 'Assigned To' fetching value for  Contains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo",
								"Contains", "assigned_To", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("assigned_To", PlutoraAPIConfiguration.testData, "Contains");
		APIListener.addLogger("Changes attribute 'Assigned To' fetching value for Contains operator successfully!");
	}

	// Assigned To NotContains
	@Test(description = "Pagination and filter Combinations for Get TECRs", groups = {
			"RegressionTests" }, priority = 6)
	public void GetTECR_Pagination_AssignedTo3() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Changes attribute 'Assigned To' fetching value for  NotContains operator");
		tecrsPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrsPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,
				PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "GetTECRsParametersAttributes"),
				"tecr_Id");
		tecrsPage
				.paginationfilterWithoutPagenum(
						PlutoraAPIConfiguration.testData, tecrsPage.setPaginationFilterOperator("assignedTo",
								"NotContains", "assigned_To", PlutoraAPIConfiguration.testData),
						"1", "10", "GetTECRs_PaginationFiltersUrl");
		tecrsPage.verifyResponseArrayValue("assigned_To", PlutoraAPIConfiguration.testData, "NotContains");
		APIListener.addLogger("Changes attribute 'Assigned To' fetching value for NotContains operator successfully!");
	}
*/
}
