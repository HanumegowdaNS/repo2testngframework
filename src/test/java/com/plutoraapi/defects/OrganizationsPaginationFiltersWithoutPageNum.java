package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;
import com.plutoraapi.pagerepo.LookupFieldsPage;
import com.plutoraapi.pagerepo.OrganizationsPage;

public class OrganizationsPaginationFiltersWithoutPageNum {
	OrganizationsPage organizationsPage = new OrganizationsPage();
	
	// Id 
	@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 1)
	public void organizations_Pagination_IdEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Organizations attribute 'Id' fetching value for Equals operator");
		organizationsPage.getOrganizations(PlutoraAPIConfiguration.testData);
		organizationsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		organizationsPage.addOrganizationsField();
		String [] org_id =OrganizationsPage.organizationsList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Organization_Id",org_id[0]);
		organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("id", "Equals","Organization_Id", PlutoraAPIConfiguration.testData),
					 "GetOrganizations_PaginationFiltersUrl");
		organizationsPage.verifyOrganizationsValueWithoutPageNum("id","Equals", 0);
        APIListener.addLogger("Organizations attribute 'Id' fetching value for Equals operator successfully!");
	}
	
	// Id not equals 
	@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 2)
	public void organizations_Pagination_IdNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Organizations attribute 'Id' fetching value for operator");
		organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("id", "Not Equals","Organization_Id", PlutoraAPIConfiguration.testData),
					 "GetOrganizations_PaginationFiltersUrl");
		organizationsPage.verifyOrganizationsValueWithoutPageNum("id","Not Equals", 0);
        APIListener.addLogger("Organizations attribute 'Id' fetching value for not equals perator successfully!");
	}
	
	// name equals
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 3)
		public void organizations_Pagination_nameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - Organizations attribute 'name' fetching value for Equals operator");
			organizationsPage.getOrganizations(PlutoraAPIConfiguration.testData);
			organizationsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			organizationsPage.addOrganizationsField();
			String [] org_name =OrganizationsPage.organizationsList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Organization_name",org_name[1]);
			organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("name", "Equals","Organization_name", PlutoraAPIConfiguration.testData),
						 "GetOrganizations_PaginationFiltersUrl");
				organizationsPage.verifyOrganizationsValueWithoutPageNum("name","Equals", 1);
	        APIListener.addLogger("Organizations attribute 'Organization name' fetching value for Equals operator successfully!");
		}
		
		// name not equals
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 4)
		public void organizations_Pagination_nameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - Organizations attribute 'name' fetching value for Not Equals operator");
			organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("name", "Not Equals","Organization_name", PlutoraAPIConfiguration.testData),
						 "GetOrganizations_PaginationFiltersUrl");
			organizationsPage.verifyOrganizationsValueWithoutPageNum("name","Not Equals", 1);
		    APIListener.addLogger("Organizations attribute 'Organization name' fetching value for Not Equals operator successfully!");
				}
		
		// name contains
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 5)
		public void organizations_Pagination_nameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - Organizations attribute 'name' fetching value for contains operator");
			organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("name", "Contains","Organization_name", PlutoraAPIConfiguration.testData),
						 "GetOrganizations_PaginationFiltersUrl");
			organizationsPage.verifyOrganizationsValueWithoutPageNum("name","Contains", 1);
		    APIListener.addLogger("Organizations attribute 'Organization name' fetching value for Contains operator successfully!");
			}
		
		// name not contains 
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 6)
		public void organizations_Pagination_nameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - Organizations attribute 'name' fetching value for Not Contains operator");
			organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("name", "Not Contains","Organization_name", PlutoraAPIConfiguration.testData),
						 "GetOrganizations_PaginationFiltersUrl");
			organizationsPage.verifyOrganizationsValueWithoutPageNum("name","Not Contains", 1);
		    APIListener.addLogger("Organizations attribute 'Organization name' fetching value for Not Contains operator successfully!");
			}
		
		// type equals
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 7)
		public void organizations_Pagination_typeEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - Organizations attribute 'type' fetching value for Equals operator");
			organizationsPage.getOrganizations(PlutoraAPIConfiguration.testData);
			organizationsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			organizationsPage.addOrganizationsField();
			String [] org_type =OrganizationsPage.organizationsList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Organization_type",org_type[2]);
			organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("type", "Equals","Organization_type", PlutoraAPIConfiguration.testData),
						 "GetOrganizations_PaginationFiltersUrl");
			organizationsPage.verifyOrganizationsValueWithoutPageNum("type","Equals", 2);
	        APIListener.addLogger("Organizations attribute 'Organization type' fetching value for Equals operator successfully!");
		}		
		
		@Test(description = "Pagination and filter Combinations for OrganizationsTree", groups = {"RegressionTests" }, priority = 8)
        public void organizations_Pagination_typeNotEquals() throws ParseException, InterruptedException {
	        APIListener.addLogger("[API] - Organizations attribute 'type' fetching value for Not Equals operator");
	        organizationsPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,organizationsPage.setPaginationFilterOperator("type", "Not Equals","Organization_type", PlutoraAPIConfiguration.testData),
				 "GetOrganizations_PaginationFiltersUrl");
		    organizationsPage.verifyOrganizationsValueWithoutPageNum("type","Not Equals", 2);
            APIListener.addLogger("Organizations attribute 'Organization type' fetching value for Not Equals operator successfully!");
        }		
		
}
	