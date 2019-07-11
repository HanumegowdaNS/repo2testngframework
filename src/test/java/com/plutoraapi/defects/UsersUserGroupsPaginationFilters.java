package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.OrganizationsPage;
import com.plutoraapi.pagerepo.UserGroupsPage;
import com.plutoraapi.pagerepo.WorkItemNamesPage;

public class UsersUserGroupsPaginationFilters {
	UserGroupsPage usergroupsPage = new UserGroupsPage();
	
	// Id equals
	@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 1)
	public void usersUserGroups_Pagination_IdEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - User Groups attribute 'Id' fetching value for Equals operator");
		usergroupsPage.getusersUserGroups(PlutoraAPIConfiguration.testData);
		usergroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usergroupsPage.usersUserGroupsValues();
		String [] group_id =UserGroupsPage.usersUserGroupsList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Group_Id",group_id[0]);
		usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("id", "Equals","Group_Id", PlutoraAPIConfiguration.testData),
						"0", "10", "UserGroupsUrl");
		usergroupsPage.verifyusersUserGroupsAttributes("id","Equals", 0);
        APIListener.addLogger("User Groups attribute 'Id' fetching value for Equals operator successfully!");
	}

	
	// Id not equals
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 2)
		public void usersUserGroups_Pagination_IdNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'Id' fetching value for Not Equals operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("id", "Not Equals","Group_Id", PlutoraAPIConfiguration.testData),
							"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("id","Not Equals", 0);
	        APIListener.addLogger("User Groups attribute 'Id' fetching value for Not Equals operator successfully!");
		}
		
	// groupName equals
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 3)
		public void usersUserGroups_Pagination_NameEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Name' fetching value for Equals operator");
			usergroupsPage.getusersUserGroups(PlutoraAPIConfiguration.testData);
			usergroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			usergroupsPage.usersUserGroupsValues();
			String [] group_name =UserGroupsPage.usersUserGroupsList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Group_Name",group_name[1]);
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("groupName", "Equals","Group_Name", PlutoraAPIConfiguration.testData),
							"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("groupName","Equals", 1);
	        APIListener.addLogger("User Groups attribute 'group name' fetching value for Equals operator successfully!");
		}
		
	// groupName not equals
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 4)
		public void usersUserGroups_Pagination_NameNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Name' fetching value for Not Equals operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("groupName", "Not Equals","Group_Name", PlutoraAPIConfiguration.testData),
						"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("groupName","Not Equals", 1);
	        APIListener.addLogger("User Groups attribute 'group name' fetching value for Not Equals operator successfully!");
		} 

	// groupName Contains
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 5)
		public void usersUserGroups_Pagination_NameContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Name' fetching value for Contains operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("groupName", "Contains","Group_Name", PlutoraAPIConfiguration.testData),
						"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("groupName","Contains", 1);
	        APIListener.addLogger("User Groups attribute 'group name' fetching value for Contains operator successfully!");
		}

	// groupName Not Contains
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 6)
		public void usersUserGroups_Pagination_NameNotContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Name' fetching value for Not Contains operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("groupName", "Not Contains","Group_Name", PlutoraAPIConfiguration.testData),
						"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("groupName","Not Contains", 1);
	        APIListener.addLogger("User Groups attribute 'group name' fetching value for Not Contains operator successfully!");
		}
		
	// groupDescription equals
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 7)
		public void usersUserGroups_Pagination_DescriptionEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Description' fetching value for Equals operator");
			usergroupsPage.getusersUserGroups(PlutoraAPIConfiguration.testData);
			usergroupsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
			usergroupsPage.usersUserGroupsValues();
			String [] group_description =UserGroupsPage.usersUserGroupsList.get(0).split(",");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "Group_Description",group_description[2]);
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("description", "Equals","Group_Description", PlutoraAPIConfiguration.testData),
					"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("description","Equals", 2);
	        APIListener.addLogger("User Groups attribute 'group Description' fetching value for Equals operator successfully!");
		}
		
	// groupDescription not equals
		@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 8)
		public void usersUserGroups_Pagination_DescriptionNotEquals() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Description' fetching value for Not Equals operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("description", "Not Equals","Group_Description", PlutoraAPIConfiguration.testData),
					"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("description","Not Equals", 2);
		    APIListener.addLogger("User Groups attribute 'group Description' fetching value for Not Equals operator successfully!");
		}
		
	// groupDescription contains
	  @Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 9)
	  public void usersUserGroups_Pagination_DescriptionContains() throws ParseException, InterruptedException {
			APIListener.addLogger("[API] - User Groups attribute 'group Description' fetching value for Contains operator");
			usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("description", "Contains","Group_Description", PlutoraAPIConfiguration.testData),
					"0", "10", "UserGroupsUrl");
			usergroupsPage.verifyusersUserGroupsAttributes("description","Contains", 2);
		    APIListener.addLogger("User Groups attribute 'group Description' fetching value for Contains operator successfully!");
		}
	  
	// groupDescription not contains
	@Test(description = "Pagination and filter Combinations for User groups", groups = {"RegressionTests" }, priority = 10)
	public void usersUserGroups_Pagination_DescriptionNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - User Groups attribute 'group Description' fetching value for Not Equals operator");
		usergroupsPage.paginationfilter(PlutoraAPIConfiguration.testData,usergroupsPage.setPaginationFilterOperator("description", "Not Contains","Group_Description", PlutoraAPIConfiguration.testData),
				"0", "10", "UserGroupsUrl");
		usergroupsPage.verifyusersUserGroupsAttributes("description","Not Contains", 2);
	    APIListener.addLogger("User Groups attribute 'group Description' fetching value for Not Contains operator successfully!");
	}	 
}	