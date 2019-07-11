package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.OrganizationsPage;
import com.plutoraapi.pagerepo.WorkItemNamesPage;

public class WorkItemNamesPaginationFiltersWithoutPageNum {
	WorkItemNamesPage workItemNamesPage = new WorkItemNamesPage();

	   // phase id equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 1)
		public void organizations_Pagination_PhaseIdEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'Id' fetching value for Equals operator");
			workItemNamesPage.getWorkItemNamesPhases(PlutoraAPIConfiguration.testData);
			workItemNamesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			workItemNamesPage.workItemNameValuesPhases();
			String [] phase_id =WorkItemNamesPage.workItemNamePhaseList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Phase_Id",phase_id[0]);
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("id", "Equals","Phase_Id", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("id","Equals", 0);
	        APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Equals operator successfully!");
		}
		
		// phase id not equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 2)
		public void organizations_Pagination_PhaseIdNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'Id' fetching value for Not Equals operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("id", "Not Equals","Phase_Id", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
     		workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("id","Not Equals", 0);
	        APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Not Equals operator successfully!");
		}
		
		 // phase name equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 3)
		public void organizations_Pagination_PhaseNameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'name' fetching value for Equals operator");
			workItemNamesPage.getWorkItemNamesPhases(PlutoraAPIConfiguration.testData);
			workItemNamesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			workItemNamesPage.workItemNameValuesPhases();
			String [] phase_name =WorkItemNamesPage.workItemNamePhaseList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Phase_name",phase_name[1]);
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Equals","Phase_name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("name","Equals", 1);
	        APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Equals operator successfully!");
		}	
		
		 // phase name Not equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 4)
		public void organizations_Pagination_PhaseNameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'name' fetching value for Not Equals operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Not Equals","Phase_name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("name","Not Equals", 1);
	        APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Not Equals operator successfully!");
		}	
		
		 // phase name Contains 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 5)
		public void organizations_Pagination_PhaseNameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'name' fetching value for Contains operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Contains","Phase_name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("name","Contains", 1);
	        APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Contains operator successfully!");
		}
		
		// phase name Not Contains 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 6)
		public void Organizations_Pagination_PhaseNameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Phase attribute 'name' fetching value for Not Contains operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Not Contains","Phase_name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesPhases_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNamePhaseAttributesWithoutPageNum("name","Not Contains", 1);
		    APIListener.addLogger("WorkItemNames Phase attribute 'Id' fetching value for Not Contains operator successfully!");
		}
		
		 // gate id equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 7)
		public void organizations_Pagination_GateIdEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Id' fetching value for Equals operator");
			workItemNamesPage.getWorkItemNamesGates(PlutoraAPIConfiguration.testData);
			workItemNamesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			workItemNamesPage.workItemNameValuesGates();
			String [] gate_id =WorkItemNamesPage.workItemNameGateList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Gate_Id",gate_id[0]);
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("id", "Equals","Gate_Id", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("id","Equals", 0);
	        APIListener.addLogger("WorkItemNames Gates attribute 'Id' fetching value for Equals operator successfully!");
		}
		
		 // gate id not equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 8)
		public void organizations_Pagination_GateIdNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Id' fetching value for Not Equals operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("id", "Not Equals","Gate_Id", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("id","Not Equals", 0);
	        APIListener.addLogger("WorkItemNames Gates attribute 'Id' fetching value for Not Equals operator successfully!");
		}
		
		 // gate name equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 9)
		public void organizations_Pagination_GateNameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Name' fetching value for Equals operator");
			workItemNamesPage.getWorkItemNamesGates(PlutoraAPIConfiguration.testData);
			workItemNamesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			workItemNamesPage.workItemNameValuesGates();
			String [] gate_name =WorkItemNamesPage.workItemNameGateList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Gate_Name",gate_name[1]);
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Equals","Gate_Name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("name","Equals", 1);
	        APIListener.addLogger("WorkItemNames Gates attribute 'name' fetching value for Equals operator successfully!");
		}
		
		 // gate name not equals 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 10)
		public void organizations_Pagination_GateNameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Name' fetching value for Not Equals operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Not Equals","Gate_Name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("name","Not Equals", 1);
	        APIListener.addLogger("WorkItemNames Gates attribute 'name' fetching value for Not Equals operator successfully!");
		}
		
		// gate name contains 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 11)
		public void organizations_Pagination_GateNameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Name' fetching value for Contains operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Contains","Gate_Name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("name","Contains", 1);
		    APIListener.addLogger("WorkItemNames Gates attribute 'name' fetching value for Contains operator successfully!");
		}
				
		// gate name not Contains 
		@Test(description = "Pagination and filter Combinations for WorkItemNames", groups = {"RegressionTests" }, priority = 12)
		public void organizations_Pagination_GateNameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - WorkItemNames Gates attribute 'Name' fetching value for Not Contains operator");
			workItemNamesPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,workItemNamesPage.setPaginationFilterOperator("name", "Not Contains","Gate_Name", PlutoraAPIConfiguration.testData),
						 "WorkItemNamesGates_PaginationFilterURL");
			workItemNamesPage.verifyWorkItemNameGateAttributesWithoutPageNum("name","Not Contains", 1);
		    APIListener.addLogger("WorkItemNames Gates attribute 'name' fetching value for Not Contains operator successfully!");
		}
}
