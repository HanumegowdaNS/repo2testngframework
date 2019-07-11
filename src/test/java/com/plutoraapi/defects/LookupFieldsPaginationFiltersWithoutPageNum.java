package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.LookupFieldsPage;
import com.plutoraapi.pagerepo.OrganizationsPage;

public class LookupFieldsPaginationFiltersWithoutPageNum {
	LookupFieldsPage lookupFields = new LookupFieldsPage();
	
	
	/*@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 1)
	public void OrganizationsTree_Pagination_IdEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Organizations attribute 'Id' fetching value for Equals operator");
		organizationsPage.getOrganizations(PlutoraAPIConfiguration.testData);
		organizationsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		organizationsPage.addOrganizationsField();
		String [] org_id =OrganizationsPage.organizationsList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Organization_Id",org_id[0]);
		organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("id", "Equals","Organization_Id", PlutoraAPIConfiguration.testData),
					 "GetOrganizations_PaginationFiltersUrl");
		organizationsPage.verifyOrganizationsValue("id","Equals", 0);
        APIListener.addLogger("Organizations attribute 'Id' fetching value for Equals operator successfully!");
	}*/
	
	// Name equals
	
	@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 1)
	public void getLookupFields_Pagination_NameEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - LookupFields attribute 'Name' fetching value for Equals operator");
		lookupFields.getLookupFields(PlutoraAPIConfiguration.testData);
		lookupFields.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		lookupFields.addLookupFields();
		String [] lookup_name =LookupFieldsPage.lookupFieldList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "LookupName",lookup_name[0]);
		lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,lookupFields.setPaginationFilterOperator("name", "Equals","LookupName", PlutoraAPIConfiguration.testData),
				 "LookupFields_PaginationFilterUrl");
		lookupFields.verifyLookupFieldValueWithoutPagenum("name","Equals", 0);
		APIListener.addLogger("LookupFields attribute 'Name' fetching value for equals operator is successfully!");
	}
	
	//name not equals
	@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 2)
	public void getLookupFields_Pagination_NameNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - LookupFields attribute 'Name' fetching value for Not equals operator");
		lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("name", "Not Equals", "LookupName", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
		lookupFields.setDataToProperty("name");
		lookupFields.verifyLookupFieldValueListWithouPageNum("name","Not Equals", 0);
		APIListener.addLogger("LookupFields attribute 'Name' fetching value for not equals operator is successfully!");
	}
	
     //name contains
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 3)
		public void getLookupFields_Pagination_Namecontains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'Name' fetching value for contains operator");
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("name", "Contains", "LookupName", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("name");
			lookupFields.verifyLookupFieldValueWithoutPagenum("name","Contains", 0);
			APIListener.addLogger("LookupFields attribute 'Name' fetching value for contains operator is successfully!");
		}
		
		//name not contains
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 4)
		public void getLookupFields_Pagination_NameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'Name' fetching value for Not contains operator");
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("name", "Not Contains", "LookupName", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("name");
			lookupFields.verifyLookupFieldValueListWithouPageNum("name","Not Contains", 0);
			APIListener.addLogger("LookupFields attribute 'Name' fetching value for Not contains operator is successfully!");
		}
		
		//description equals 
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 5)
		public void getLookupFields_Pagination_descriptionEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'description' fetching value for equals operator");
			lookupFields.getLookupFields(PlutoraAPIConfiguration.testData);
			lookupFields.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			lookupFields.addLookupFields();
			String [] lookup_name =LookupFieldsPage.lookupFieldList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "LookupDescription",lookup_name[1]);
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("description", "Equals", "LookupDescription", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("description");
			lookupFields.verifyLookupFieldValueWithoutPagenum("description","Equals", 1);
			APIListener.addLogger("LookupFields attribute 'description' fetching value for equals operator is successfully!");
		} 
		
		//description not equals 
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 6)
		public void getLookupFields_Pagination_descriptionNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'description' fetching value for not equals operator");
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("description", "Not Equals", "LookupDescription", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("description");
			lookupFields.verifyLookupFieldValueListWithouPageNum("description","Not Equals", 1);
			APIListener.addLogger("LookupFields attribute 'description' fetching value for not equals operator is successfully!");
		}
				
		//description contains
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 7)
		public void getLookupFields_Pagination_descriptionContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'description' fetching value for contains operator");
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("description", "Contains", "LookupDescription", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("description");
			lookupFields.verifyLookupFieldValueWithoutPagenum("description","Contains", 1);
			APIListener.addLogger("LookupFields attribute 'description' fetching value for contains operator is successfully!");
		}
				
		//description not contains
		@Test(description = "Pagination and filter Combinations for LookupFields", groups = {"RegressionTests" }, priority = 8)
		public void getLookupFields_Pagination_descriptionNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - LookupFields attribute 'description' fetching value for equals operator");
			lookupFields.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData, lookupFields.setPaginationFilterOperator("description", "Not Contains", "LookupDescription", PlutoraAPIConfiguration.testData), "LookupFields_PaginationFilterUrl");
			lookupFields.setDataToProperty("description");
			lookupFields.verifyLookupFieldValueListWithouPageNum("description","Not Contains", 1);
			APIListener.addLogger("LookupFields attribute 'description' fetching value for Not contains operator is successfully!");
		}
	
}