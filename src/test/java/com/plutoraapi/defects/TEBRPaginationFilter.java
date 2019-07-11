package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TEBRPage;

public class TEBRPaginationFilter {
	TEBRPage tebrPage = new TEBRPage();
	String changeName = null;
	String changeStatus = null;

	// ID
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 1)
	public void getTebrs_Pagination_IdEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TEBRs attribute 'id' fetching value for  Equals operator");
		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id", "TEBR_Id");
		//tebrPage.setDataToProperty("number", "TEBR_number");
		tebrPage.setDataToProperty("title", "TEBR_title");
		tebrPage.setDataToProperty("startDate", "TEBR_startDate");
		tebrPage.setDataToProperty("endDate", "TEBR_endDate");
		tebrPage.setDataToProperty("description", "TEBR_description");
		tebrPage.setDataToProperty("statusID", "TEBR_statusID");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"),"TEBR_Id");	
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("id", "Equals","TEBR_Id", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
		tebrPage.setDataToPropertys("id");
		tebrPage.verifyResponseArrayValueForPagination("id","TEBR_Id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("TEBRs attribute 'id' fetching value for  Equals operator successfully!");
	}
	
	//id not equals 
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 2)
	public void getTebrs_Pagination_IdNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - TEBRs attribute 'id' fetching value for  Not Equals operator");
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("id", "Not Equals","TEBR_Id", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
		tebrPage.setDataToPropertys("id");
		tebrPage.verifyResponseArrayValueForPagination("id","TEBR_Id",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("TEBRs attribute 'id' fetching value for  Not Equals operator successfully!");
	}
	
    	//numeber equals 
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 3)
		public void getTebrs_Pagination_NumberEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'number' fetching value for  Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("number", "Equals","TEBR_number", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("number");
			tebrPage.verifyResponseArrayValueForPagination("number","TEBR_number",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'number' fetching value for  Equals operator successfully!");
		}
		
	//numeber not equals 
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 4)
		public void getTebrs_Pagination_NumberNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'number' fetching value for  Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("number", "Not Equals","TEBR_number", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("number");
			tebrPage.verifyResponseArrayValueForPagination("number","TEBR_number",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'number' fetching value for  Not Equals operator successfully!");
		}
		
		//numeber contains 
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 5)
		public void getTebrs_Pagination_NumberContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'number' fetching value for  Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("number", "Contains","TEBR_number", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("number");
			tebrPage.verifyResponseArrayValueForPagination("number","TEBR_number",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'number' fetching value for  Contains operator successfully!");
		}
		
		//numeber not Contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 6)
		public void getTebrs_Pagination_NumberNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'number' fetching value for  Not Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("number", "Not Contains","TEBR_number", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("number");
			tebrPage.verifyResponseArrayValueForPagination("number","TEBR_number",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'number' fetching value for  Not Contains operator successfully!");
		}
		
		//title Equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 7)
		public void getTebrs_Pagination_titleEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'title' fetching value for  Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("title", "Equals","TEBR_title", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("title");
			tebrPage.verifyResponseArrayValueForPagination("title","TEBR_title",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'title' fetching value for Equals operator successfully!");
		}
		
		//title not Equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 8)
		public void getTebrs_Pagination_titleNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'title' fetching value for  Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("title", "Not Equals","TEBR_title", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("title");
			tebrPage.verifyResponseArrayValueForPagination("title","TEBR_title",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'title' fetching value for Not Equals operator successfully!");
		}
		
		//title Contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 9)
		public void getTebrs_Pagination_titleContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'title' fetching value for  Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("title", "Contains","TEBR_title", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("title");
			tebrPage.verifyResponseArrayValueForPagination("title","TEBR_title",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'title' fetching value for Contains operator successfully!");
		}
		
		//title not Contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 10)
		public void getTebrs_Pagination_titleNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'title' fetching value for  Not Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("title", "Not Contains","TEBR_title", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("title");
			tebrPage.verifyResponseArrayValueForPagination("title","TEBR_title",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'title' fetching value for Not Contains operator successfully!");
		}

		//release name equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 11)
		public void getTebrs_Pagination_releaseNameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'releaseName' fetching value for Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("releaseName", "Equals","releaseName", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("releaseName");
			tebrPage.verifyResponseArrayValueForPaginationTECR("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'releaseName' fetching value for Equals operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
		
		//release name not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 12)
		public void getTebrs_Pagination_releaseNameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'releaseName' fetching value for Not Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("releaseName", "Not Equals","releaseName", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("releaseName");
			tebrPage.verifyResponseArrayValueForPagination("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'releaseName' fetching value for Not Equals operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
	
        //release name contains
        @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 13)
		public void getTebrs_Pagination_releaseNameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'releaseName' fetching value for Contains operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("releaseName", "Contains","releaseName", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("releaseName");
			tebrPage.verifyResponseArrayValueForPaginationTECR("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'releaseName' fetching value for Contains operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}

        //release name not Contains
        @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 14)
		public void getTebrs_Pagination_releaseNameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'releaseName' fetching value for Not Contains operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("releaseName", "Not Contains","releaseName", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("releaseName");
			tebrPage.verifyResponseArrayValueForPagination("releaseName","releaseName",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'releaseName' fetching value for Not Contains operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}

	   //start date equals
		String[] start_date;
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 15)
		public void getTebrs_Pagination_startDateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Equals operator");
			start_date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBR_startDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_startdate",start_date[0]);
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Equals","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Equals operator successfully!");
		}
		
       //start date not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 16)
		public void getTebrs_Pagination_startDateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Not Equals","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Not Equals operator successfully!");
		}

        //start date greater than
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 17)
		public void getTebrs_Pagination_startDateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Greater than operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Greater Than","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Greater Than operator successfully!");
		}
		
		  //start date greater or equal
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 18)
		public void GetTebrs_Pagination_startDateGreaterorequal() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Greater or equal operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Greater Or Equal","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Greater Or Equal operator successfully!");
		}
		
		  //start date less than
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 19)
		public void getTebrs_Pagination_startDatelessthan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Less Than operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Less Than","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Less Than operator successfully!");
		}
		
		  //start date less or equal
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 20)
		public void getTebrs_Pagination_startDateLessOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'startDate' fetching value for Less Or Equal operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("startDate", "Less Or Equal","split_startdate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("startDate");
			tebrPage.verifyDateResponseArrayValueForPagination("startDate","split_startdate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TEBRs attribute 'startDate' fetching value for Less Or Equal operator successfully!");
		}
		
		  //end date equals
		String[] end_date;
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 21)
		public void getTebrs_Pagination_endDateEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for Equals operator");
			end_date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBR_endDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_enddate",end_date[0]);
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Equals","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for Equals operator successfully!");
		}
			
		// end date not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 22)
		public void getTebrs_Pagination_endDateNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Not Equals","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for Not Equals operator successfully!");
		}
		
        // end date less than
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 23)
		public void getTebrs_Pagination_endDateLessThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for LessThan operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Less Than","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for LessThan operator successfully!");
		}
		
		// end date less or equal
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 24)
		public void GetTebrs_Pagination_endDateLessOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for Less Or Equal operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Less Or Equal","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for Less Or Equal operator successfully!");
		}
		
		// end date greater than
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 25)
		public void getTebrs_Pagination_endDateGreaterThan() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for Greater Than operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Greater Than","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for Greater Than operator successfully!");
		}
		
		// end date Greater Or Equal
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 26)
		public void getTebrs_Pagination_endDateGreaterOrEqual() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'endDate' fetching value for Greater Or Equal operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("endDate", "Greater Or Equal","split_enddate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("endDate");
			tebrPage.verifyDateResponseArrayValueForPagination("endDate","split_enddate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TEBRs attribute 'endDate' fetching value for Greater Or Equal operator successfully!");
		}
	//assignedTo equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 27)
		public void getTebrs_Pagination_AssignedToEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'assignedTo' fetching value for Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("assignedTo", "Equals","assignedTo", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("assignedTo");
			tebrPage.verifyResponseArrayValueForPaginationTECR("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'assignedTo' fetching value for Equals operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
		
      //assignedTo not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 28)
		public void getTebrs_Pagination_AssignedToNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'assignedTo' fetching value for Not Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("assignedTo", "Not Equals","assignedTo", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("assignedTo");
			tebrPage.verifyResponseArrayValueForPagination("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'assignedTo' fetching value for Not Equals operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
		
		//assignedTo contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 29)
		public void getTebrs_Pagination_AssignedToContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'assignedTo' fetching value for Contains operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("assignedTo", "Contains","assignedTo", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("assignedTo");
			tebrPage.verifyResponseArrayValueForPaginationTECR("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'assignedTo' fetching value for Contains operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
		//assignedTo not contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 30)
		public void getTebrs_Pagination_AssignedToNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'assignedTo' fetching value for Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id");
			tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
			tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
			tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));	
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("assignedTo", "Not Contains","assignedTo", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("assignedTo");
			tebrPage.verifyResponseArrayValueForPagination("assignedTo","assignedTo",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'assignedTo' fetching value for Not Contains operator successfully!");
			tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		}
		
		 //description equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 31)
		public void getTebrs_Pagination_descriptionEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'description' fetching value for Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("description", "Equals","TEBR_description", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("description");
			tebrPage.verifyResponseArrayValueForPagination("description","TEBR_description",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'description' fetching value for Equals operator successfully!");
		}
		
		 //description not  equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 32)
		public void getTebrs_Pagination_descriptionNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'description' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("description", "Not Equals","TEBR_description", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("description");
			tebrPage.verifyResponseArrayValueForPagination("description","TEBR_description",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'description' fetching value for Not Equals operator successfully!");
		}
		
		 //description contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 33)
		public void getTebrs_Pagination_descriptionContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'description' fetching value for Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("description", "Contains","TEBR_description", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("description");
			tebrPage.verifyResponseArrayValueForPagination("description","TEBR_description",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'description' fetching value for Contains operator successfully!");
		}
		
		 //description not contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 34)
		public void getTebrs_Pagination_descriptionNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'description' fetching value for Not Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("description", "Not Contains","TEBR_description", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("description");
			tebrPage.verifyResponseArrayValueForPagination("description","TEBR_description",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'description' fetching value for Not Contains operator successfully!");
		}
		

		 //statusId equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 35)
		public void getTebrs_Pagination_statusIdEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'statusID' fetching value for Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("statusID", "Equals","TEBR_statusID", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("statusID");
			tebrPage.verifyResponseArrayValueForPagination("statusID","TEBR_statusID",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'statusID' fetching value for Equals operator successfully!");
		}
		
		//statusId not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 36)
		public void getTebrs_Pagination_statusIdNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'statusID' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("statusID", "Not Equals","TEBR_statusID", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("statusID");
			tebrPage.verifyResponseArrayValueForPagination("statusID","TEBR_statusID",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'statusID' fetching value for Not Equals operator successfully!");
		}
		
		
		//status equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 37)
		public void getTebrs_Pagination_statusEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'status' fetching value for Equals operator");
			tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
			tebrPage.setDataToProperty("id", "TEBR_Id");
			tebrPage.getTEBRwithId(PlutoraAPIConfiguration.testData,"TEBR_Id");
			tebrPage.setDataToProperty("status", "TEBR_status");
			tebrPage.setDataToProperty("type", "TEBR_type");
			tebrPage.setDataToProperty("lastModifiedDate", "TEBR_lastModifiedDate");
			tebrPage.setDataToProperty("lastModifiedBy", "TEBR_lastModifiedBy");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("status", "Equals","TEBR_status", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("status");
			tebrPage.verifyResponseArrayValueForPagination("status","TEBR_status",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'status' fetching value for Equals operator successfully!");
		}
		
		//status not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 38)
		public void getTebrs_Pagination_statusNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'status' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("status", "Not Equals","TEBR_status", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("status");
			tebrPage.verifyResponseArrayValueForPagination("status","TEBR_status",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'status' fetching value for Not Equals operator successfully!");
		}
		
		//status contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 39)
		public void getTebrs_Pagination_statusContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'status' fetching value for Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("status", "Contains","TEBR_status", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("status");
			tebrPage.verifyResponseArrayValueForPagination("status","TEBR_status",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'status' fetching value for Contains operator successfully!");
		} 
		
		//status not contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 40)
		public void getTebrs_Pagination_statusNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'status' fetching value for Not Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("status", "Not Contains","TEBR_status", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("status");
			tebrPage.verifyResponseArrayValueForPagination("status","TEBR_status",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'status' fetching value for Not Contains operator successfully!");
		}
		
		//type equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 41)
		public void getTebrs_Pagination_TypeEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'type' fetching value for Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("type", "Equals","TEBR_type", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("type");
			tebrPage.verifyResponseArrayValueForPagination("type","TEBR_type",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'type' fetching value for Equals operator successfully!");
		}
		//type not equals
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 42)
		public void getTebrs_Pagination_TypeNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'type' fetching value for Not Equals operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("type", "Not Equals","TEBR_type", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("type");
			tebrPage.verifyResponseArrayValueForPagination("type","TEBR_type",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'type' fetching value for Not Equals operator successfully!");
		}
		
		//type Contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 43)
		public void getTebrs_Pagination_TypeContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'type' fetching value for Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("type", "Contains","TEBR_type", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("type");
			tebrPage.verifyResponseArrayValueForPagination("type","TEBR_type",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'type' fetching value for Contains operator successfully!");
		}
		
		//type not Contains
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {"RegressionTests" }, priority = 44)
		public void getTebrs_Pagination_TypeNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - TEBRs attribute 'type' fetching value for Not Contains operator");
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("type", "Not Contains","TEBR_type", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("type");
			tebrPage.verifyResponseArrayValueForPagination("type","TEBR_type",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'type' fetching value for Not Contains operator successfully!");
		}
		
		  String[] lastModified_date;
		    //last Modified date equals
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 45)
			public void getTebrs_LastModifiedDateEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for Equals operators"); 
			lastModified_date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBR_lastModifiedDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_lastModifiedDate",lastModified_date[0]);
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Equals","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Equals operator successfully!");
		}
		    
		  //last Modified date not equals
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 46)
			public void getTebrs_LastModifiedDateNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for Not Equals operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Not Equals","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Not Equals operator successfully!");
		}
				    
				    
		  //last Modified date greater than
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 47)
			public void getTebrs_LastModifiedDateGreaterThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for Greater Than operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Greater Than","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Greater Than operator successfully!");
		}
	
		  //last Modified date greater or equal
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 48)
			public void getTebrs_LastModifiedDateGreaterOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for Greater Or Equal operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Greater Or Equal","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Greater Or Equal operator successfully!");
		}
						    
		  //last Modified dat less than
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 49)
			public void GetTebrs_LastModifiedDateLessThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for LessThan operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Less Than","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Less Than operator successfully!");
		}
		    
		  //last Modified date less or equal
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 50)
			public void getTebrs_LastModifiedDateLessOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedDate' fetching value for Less Or Equal operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedDate", "Less Or Equal","split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedDate");
			tebrPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("TEBRs attribute 'lastModifiedDate' fetching value for Less Or Equal operator successfully!");
		}
		    
		  //last Modified by equals
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 51)
			public void getTebrs_LastModifiedByEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedBy' fetching value for Equals operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedBy", "Equals","TEBR_lastModifiedBy", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedBy");
			tebrPage.verifyResponseArrayValueForPagination("lastModifiedBy","TEBR_lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("TEBRs attribute 'lastModifiedBy' fetching value for Equals operator successfully!");
		}
		  //last Modified by not equals
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 52)
			public void getTebrs_LastModifiedByNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedBy' fetching value for Not Equals operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedBy", "Not Equals","TEBR_lastModifiedBy", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedBy");
			tebrPage.verifyResponseArrayValueForPagination("lastModifiedBy","TEBR_lastModifiedBy",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("TEBRs attribute 'lastModifiedBy' fetching value for Not Equals operator successfully!");
		}
		    
		  //last Modified by contains
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 53)
			public void getTebrs_LastModifiedByContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedBy' fetching value for Contains operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedBy", "Contains","TEBR_lastModifiedBy", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedBy");
			tebrPage.verifyResponseArrayValueForPagination("lastModifiedBy","TEBR_lastModifiedBy",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("TEBRs attribute 'lastModifiedBy' fetching value for Contains operator successfully!");
		}
		    
		  //last Modified by Not Contains
		    @Test(description = "Pagination and filter Combinations for GET TEBRs", groups = { "RegressionTests" },priority = 54)
			public void getTebrs_LastModifiedByNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - TEBRs attribute 'lastModifiedBy' fetching value for Not Contains operators"); 
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterOperator("lastModifiedBy", "Not Contains","TEBR_lastModifiedBy", PlutoraAPIConfiguration.testData), "0", "10","GET_TEBRs_PaginationFiltersURL");
			tebrPage.setDataToPropertys("lastModifiedBy");
			tebrPage.verifyResponseArrayValueForPagination("lastModifiedBy","TEBR_lastModifiedBy",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("TEBRs attribute 'lastModifiedBy' fetching value for Not Contains operator successfully!");
		}
				
	
				
	/*
	// releaseName COMBINATIONS--> contains(a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : ReleaseName contains (a or b) ", groups = {
			"RegressionTests" }, priority = 20)
	public void GetTebrs_releaseName_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : ReleaseName contains (a or b)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_releaseName_Id1");
		tebrPage.setDataToPropertys("releaseName", "ReleaseName_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_releaseName_Id2");
		tebrPage.setDataToPropertys("releaseName", "ReleaseName_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Release name contains ( A OR B )
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
				tebrPage.setPaginationFilterCombinations("releaseName", "Contains", "ReleaseName_1", "OR",
						"ReleaseName_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("name", PlutoraAPIConfiguration.testData, "Contains",
				new String[] { "ReleaseName_1", "ReleaseName_2" });
		APIListener.addLogger("Tebrs-- Filter Combination 1 : name contains (a or b) is successfull!");

	}

	// releaseName COMBINATIONS--> status equals (x or y)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : name equals (a or b) ", groups = {
			"RegressionTests" }, priority = 21)
	public void GetTebrs_releaseName_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 2 : Status equals (x or y)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_status_Id1");
		tebrPage.setDataToPropertys("status", "status_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_status_Id2");
		tebrPage.setDataToPropertys("status", "status_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Status equals ( X OR Y )
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("status", "equals",
						"status_1", "OR", "status_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("status", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "status_1", "status_2" });
		APIListener.addLogger("Tebr-- Filter Combination 1 : name equals (x or y) is successfull!");
	}

	// releaseName COMBINATIONS--> contains(a or b) and status equals (x or y)
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {
			"RegressionTests" }, priority = 22)
	public void GetTebrs_Pagination_ReleaseName_Status_CombinationFilters()
			throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Tebr attribute 'releaseName contains(a or b) and status equals (x or y)' fetching value for  operator");
		this.GetTebrs_releaseName_Combination1();
		this.GetTebrs_releaseName_Combination2();
		// releaseName contains(a or b) and status equals (x or y)
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
				tebrPage.setPaginationFilterCombinationWith2Operators("releaseName", "Contains", "ReleaseName_1", "OR",
						"ReleaseName_2", "AND", "status", "Equals", "status_1", "OR", "status_2",
						PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");

		APIListener.addLogger(
				"Tebr attribute 'releaseName contains(a or b) and status equals (x or y)' fetching value for  operator successfully!");
	}

	// AssignedTo COMBINATIONS--> equals(a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : AssignedTo equals (a or b) ", groups = {
			"RegressionTests" }, priority = 23)
	public void GetTebrs_Pagination_AssignedTo_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : AssignedTo equals (a or b)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_AssignedTo_Id1");
		tebrPage.setDataToPropertys("assignedTo", "AssignedTo_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_AssignedTo_Id2");
		tebrPage.setDataToPropertys("assignedTo", "AssignedTo_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// AssignedTo equals ( A OR B )
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("assignedTo", "Equals",
						"AssignedTo_1", "OR", "AssignedTo_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("assignedTo", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "AssignedTo_1", "AssignedTo_2" });
		APIListener.addLogger("Tebrs's-- Filter Combination 1 : name contains (a or b) is successfull!");

	}

	// Requester COMBINATIONS--> equals(a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : Requester equals (a or b) ", groups = {
			"RegressionTests" }, priority = 24)
	public void GetTebrs_Pagination_Requester_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : Requester equals (a or b)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Requester_Id1");
		tebrPage.setDataToPropertys("assignedTo", "Requester_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Requester_Id2");
		tebrPage.setDataToPropertys("assignedTo", "Requester_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Requester equals ( A OR B )
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("assignedTo", "Equals",
						"Requester_1", "OR", "Requester_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("requester", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Requester_1", "Requester_2" });
		APIListener.addLogger("Tebrs's-- Filter Combination 1 : Requester equals (a or b) is successfull!");

	}

	// AssignedTo COMBINATIONS--> equals(a or b) and Requester equals (a or b)
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {
			"RegressionTests" }, priority = 25)
	public void GetTebrs_Pagination_AssignedTo_Requester_CombinationFilters()
			throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Tebr attribute 'AssignedTo equals (a or b) and Requester equals (a or b)' fetching value for  operator");
		this.GetTebrs_Pagination_AssignedTo_Combination1();
		this.GetTebrs_Pagination_Requester_Combination2();
		// AssignedTo contains(a or b) and Requester equals (x or y)
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
				tebrPage.setPaginationFilterCombinationWith2Operators("assignedTo", "Equals", "AssignedTo_1", "OR",
						"AssignedTo_2", "AND", "requester", "Equals", "Requester_1", "OR", "Requester_2",
						PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");

		APIListener.addLogger(
				"Tebr attribute 'AssignedTo equals (a or b) and Requester equals (a or b)' fetching value for  operator successfully!");
	}

	// StartDate COMBINATIONS--> equals(a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : StartDate equals (a or b) ", groups = {
			"RegressionTests" }, priority = 26)
	public void GetTebrs_Pagination_StartDate_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : StartDate equals (a or b)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_StartDate_Id1");
		tebrPage.setDataToPropertys("startDate", "StartDate_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_StartDate_Id2");
		tebrPage.setDataToPropertys("startDate", "StartDate_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// StartDate equals ( A OR B )
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("startDate", "Equals",
						"StartDate_1", "OR", "StartDate_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("startDate", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "StartDate_1", "StartDate_2" });
		APIListener.addLogger("Tebrs's-- Filter Combination 1 : StartDate equals (a or b) is successfull!");

	}

	// EndDate COMBINATIONS--> greaterThan (p or q)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 2 : EndDate greaterThan (p or q) ", groups = {
			"RegressionTests" }, priority = 27)
	public void GetTebrs_Pagination_EndDate_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 2 : EndDate greaterThan (p or q)");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_EndDate_Id1");
		tebrPage.setDataToPropertys("endDate", "EndDate_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_EndDate_Id2");
		tebrPage.setDataToPropertys("endDate", "EndDate_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// EndDate greaterThan (p or q)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("endDate", "Equals",
						"EndDate_1", "OR", "EndDate_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("endDate", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "EndDate_1", "EndDate_2" });
		APIListener.addLogger("Tebrs's-- Filter Combination 2 : EndDate greaterThan (p or q) is successfull!");

	}

	// StartDate COMBINATIONS--> equals ( A OR B ) and EndDate greaterThan (p or
	// q)
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {
			"RegressionTests" }, priority = 28)
	public void GetTebrs_Pagination_StartDate_EndDate_CombinationFilters() throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Tebr attribute 'StartDate equals ( A OR B ) and EndDate greaterThan (p or q)' fetching value for  operator");
		this.GetTebrs_Pagination_StartDate_Combination1();
		this.GetTebrs_Pagination_EndDate_Combination2();
		// AssignedTo contains(a or b) and Requester equals (x or y)
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
				tebrPage.setPaginationFilterCombinationWith2Operators("startDate", "Equals", "StartDate_1", "OR",
						"StartDate_2", "AND", "endDate", "GreaterThan", "EndDate_1", "OR", "EndDate_2",
						PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");

		APIListener.addLogger(
				"Tebr attribute 'StartDate equals ( A OR B ) and EndDate greaterThan (p or q)' fetching value for  operator successfully!");
	}

	// Number COMBINATIONS--> Contains (a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 2 : EndDate greaterThan (p or q) ", groups = {
			"RegressionTests" }, priority = 29)
	public void GetTebrs_Pagination_Number_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : Number Contains (a or b) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Number_Id1");
		tebrPage.setDataToPropertys("number", "Number_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Number_Id2");
		tebrPage.setDataToPropertys("number", "Number_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Number Contains (a or b)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("number", "Contains",
						"Number_1", "OR", "Number_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("number", PlutoraAPIConfiguration.testData, "Contains",
				new String[] { "Number_1", "Number_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 1 : Number Contains (a or b) etching value for  operator successfully!");
	}

	// Status COMBINATIONS--> Equals (x or y)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 2 : EndDate greaterThan (p or q) ", groups = {
			"RegressionTests" }, priority = 30)
	public void GetTebrs_Pagination_Status_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 2 : Status Equals (x or y) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Status_Id1");
		tebrPage.setDataToPropertys("status", "Status_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Status_Id2");
		tebrPage.setDataToPropertys("status", "Status_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Status Equals (x or y)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("status", "Equals",
						"Status_1", "OR", "Status_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("status", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Status_1", "Status_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 2 : Status Equals (x or y) fetching value for  operator successfully!");
	}

	// Type COMBINATIONS--> Equals (1 or 2)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 3 : Type Equals (1 or 2) ", groups = {
			"RegressionTests" }, priority = 31)
	public void GetTebrs_Pagination_Type_Combination3() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 3 : Type Equals (1 or 2) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Type_Id1");
		tebrPage.setDataToPropertys("type", "Type_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Type_Id2");
		tebrPage.setDataToPropertys("type", "Type_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Status Equals (x or y)
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("type",
				"Equals", "Type_1", "OR", "Type_2", PlutoraAPIConfiguration.testData), "1", "10",
				"GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("type", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Type_1", "Type_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 3 : Type Equals (1 or 2) fetching value for  operator successfully!");
	}

	// Number Contains (a or b) and Status Equals (x or y) or Type Equals (1 or
	// 2) Combinations
	@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {
			"RegressionTests" }, priority = 32)
	public void GetTebrs_Pagination_Number_Status_Type_CombinationFilters()
			throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Tebr attribute 'Number Contains (a or b) and Status Equals (x or y) or Type Equals (1 or 2)' fetching value for  operator");
		this.GetTebrs_Pagination_Number_Combination1();
		this.GetTebrs_Pagination_Status_Combination2();
		this.GetTebrs_Pagination_Type_Combination3();
		// AssignedTo contains(a or b) and Requester equals (x or y)
		tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
				tebrPage.setPaginationFilterCombinationWith3Operators("number", "Contains", "Number_1", "OR",
						"Number_2", "AND", "status", "Equals", "Status_1", "OR", "Status_2", "OR", "type", "Equals",
						"Type_1", "OR", "Type_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");

		APIListener.addLogger(
				"Tebr attribute 'Number Contains (a or b) and Status Equals (x or y) or Type Equals (1 or 2)' fetching value for  operator successfully!");
	}

	// Status COMBINATIONS--> NotEquals (a or b)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 1 : Status NotEquals (a or b) ", groups = {
			"RegressionTests" }, priority = 33)
	public void GetTebrs_Pagination_Status_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 1 : Status NotEquals (a or b) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Status_Id1");
		tebrPage.setDataToPropertys("status", "Status_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Status_Id2");
		tebrPage.setDataToPropertys("status", "Status_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Status NotEquals (a or b)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("status", "NotEquals",
						"Status_1", "OR", "Status_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("status", PlutoraAPIConfiguration.testData, "NotEquals",
				new String[] { "Status_1", "Status_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 1 : Status NotEquals (a or b) fetching value for  operator successfully!");
	}

	// Number COMBINATIONS--> Contains (x or y)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 2 : Number Contains (x or y) ", groups = {
			"RegressionTests" }, priority = 34)
	public void GetTebrs_Pagination_Number_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 2 : Number Contains (x or y) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Number_Id1");
		tebrPage.setDataToPropertys("number", "Number_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_Number_Id2");
		tebrPage.setDataToPropertys("number", "Number_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Number Contains (a or b)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("number", "Contains",
						"Number_1", "OR", "Number_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("number", PlutoraAPIConfiguration.testData, "Contains",
				new String[] { "Number_1", "Number_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 2 : Number Contains (x or y) fetching value for  operator successfully!");
	}

	// raisedDate COMBINATIONS--> GreaterThan(m or n)
	@Test(description = "Pagination and filter Combinations for Tebrs. Combination 3 : raisedDate GreaterThan(m or n) ", groups = {
			"RegressionTests" }, priority = 35)
	public void GetTebrs_Pagination_RaisedDate_Combination3() throws ParseException, InterruptedException {
		APIListener.addLogger("Tebr's-- Filter Combination 3 : raisedDate GreaterThan(m or n) fetching value for  operator");

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_RaisedDate_Id1");
		tebrPage.setDataToPropertys("raisedDate", "RaisedDate_1");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		tebrPage.createTEBR("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToPropertys("id", "Tebrs_RaisedDate_Id2");
		tebrPage.setDataToPropertys("raisedDate", "RaisedDate_2");
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// raisedDate GreaterThan (m or n)
		tebrPage.paginationfilter(
				PlutoraAPIConfiguration.testData, tebrPage.setPaginationFilterCombinations("raisedDate", "GreaterThan",
						"RaisedDate_1", "OR", "RaisedDate_2", PlutoraAPIConfiguration.testData),
				"1", "10", "GET_TEBRs_PaginationFiltersURL");
		tebrPage.verifyResponseArrayValueCombinations("raisedDate", PlutoraAPIConfiguration.testData, "GreaterThan",
				new String[] { "RaisedDate_1", "RaisedDate_2" });
		APIListener.addLogger(
				"Tebr's-- Filter Combination 3 : raisedDate GreaterThan(m or n) fetching value for  operator successfully!");
	}
	//Status NotEquals (a or b) or Number Contains (x or y) and raisedDate GreaterThan(m or n)
		@Test(description = "Pagination and filter Combinations for GET TEBRs", groups = {
				"RegressionTests" }, priority = 28)
		public void GetTebrs_Pagination_Status_Number_RaisedDate_CombinationFilters() throws ParseException, InterruptedException {
			APIListener.addLogger(
					"[API] - Tebr attribute 'Status NotEquals (a or b) or Number Contains (x or y) and raisedDate GreaterThan(m or n)' fetching value for  operator");
			this.GetTebrs_Pagination_StartDate_Combination1();
			this.GetTebrs_Pagination_EndDate_Combination2();
			// AssignedTo contains(a or b) and Requester equals (x or y)
			tebrPage.paginationfilter(PlutoraAPIConfiguration.testData,
					tebrPage.setPaginationFilterCombinationWith3Operators("status", "NotEquals", "Status_1", "OR",
							"Status_2", "OR", "Number", "Contains", "Number_1", "OR", "Number_2", "AND", "raisedDate", "GreaterThan",
							"RaisedDate_1", "OR", "RaisedDate_2", PlutoraAPIConfiguration.testData),
					"1", "10", "GET_TEBRs_PaginationFiltersURL");

			APIListener.addLogger(
					"Tebr attribute 'Status NotEquals (a or b) or Number Contains (x or y) and raisedDate GreaterThan(m or n)' fetching value for  operator successfully!");
		}*/
}
