package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.LookupFieldsPage;
import com.plutoraapi.pagerepo.UsersPage;

 public class UsersPaginationFiltersWithoutPageNum {
	 
	 UsersPage usersPage = new UsersPage();
	 
	 //id equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 1)
	public void getUsersFields_Pagination_idEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'id' fetching value for Equals operator");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usersPage.usersValues();
		String [] user_id =LookupFieldsPage.usersList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "userid",user_id[0]);
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("id", "Equals","userid", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl"); 
		usersPage.verifyusersAttributesWithoutPageNum("id","Equals", 0);
		APIListener.addLogger("Users attribute 'id' fetching value for equals operator is successfully!");
	}
	 
	 //id not equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 2)
	public void getUsersFields_Pagination_idNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'id' fetching value for Not Equals operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("id", "Not Equals","userid", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("id","Not Equals", 0);
		APIListener.addLogger("Users attribute 'id' fetching value for Not equals operator is successfully!");
	}
	 
	 //firstname equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 3)
	public void getUsersFields_Pagination_firstNameEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'firstName' fetching value for Equals operator");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usersPage.usersValues();
		String [] user_firstName =LookupFieldsPage.usersList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "userFirstName",user_firstName[1]);
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("firstName", "Equals","userFirstName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("firstName","Equals", 1);
		APIListener.addLogger("Users attribute 'firstName' fetching value for equals operator is successfully!");
	}
	 
	 //firstname not equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 4)
	public void getUsersFields_Pagination_firstNameNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'firstName' fetching value for Not Equals operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("firstName", "Not Equals","userFirstName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("firstName","Not Equals", 1);
		APIListener.addLogger("Users attribute 'firstName' fetching value for Not equals operator is successfully!");
	}
	 
	 //firstname contains
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 5)
	public void getUsersFields_Pagination_firstNameContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'firstName' fetching value for Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("firstName", "Contains","userFirstName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("firstName","Contains", 1);
		APIListener.addLogger("Users attribute 'firstName' fetching value for Contains operator is successfully!");
	}
	 
	 //firstname not Contains
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 6)
	public void getUsersFields_Pagination_firstNameNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'firstName' fetching value for Not Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("firstName", "Not Contains","userFirstName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("firstName","Not Contains", 1);
		APIListener.addLogger("Users attribute 'firstName' fetching value for Not Contains operator is successfully!");
	}
	 
    //lastname equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 7)
	public void getUsersFields_Pagination_lastNameEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'lastName' fetching value for Equals operator");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usersPage.usersValues();
		String [] user_lastName =LookupFieldsPage.usersList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "userLastName",user_lastName[2]);
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("lastName", "Equals","userLastName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("lastName","Equals", 2);
		APIListener.addLogger("Users attribute 'lastName' fetching value for equals operator is successfully!");
	}
	 
	//lastname not equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 8)
	 public void getUsersFields_Pagination_lastNameNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'lastName' fetching value for Equals operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("lastName", "Not Equals","userLastName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("lastName","Not Equals", 2);
		APIListener.addLogger("Users attribute 'lastName' fetching value for Not equals operator is successfully!");
	}
	 
    //lastname Contains
	  @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 9)
	  public void getUsersFields_Pagination_lastNamecontains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'lastName' fetching value for Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("lastName", "Contains","userLastName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("lastName","Contains", 2);
		APIListener.addLogger("Users attribute 'lastName' fetching value for Contains operator is successfully!");
	}
		 
	//lastname not Contains
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 10)
	 public void getUsersFields_Pagination_lastNameNotContains() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Users attribute 'lastName' fetching value for Not Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("lastName", "Not Contains","userLastName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("lastName","Not Contains", 2);
		APIListener.addLogger("Users attribute 'lastName' fetching value for Not Contains operator is successfully!");
	}
	 
     //username equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 11)
	 public void getUsersFields_Pagination_userNameEquals() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'userName' fetching value for Equals operator");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usersPage.usersValues();
		String [] user_userName =LookupFieldsPage.usersList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "usersUserName",user_userName[3]);
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("userName", "Equals","usersUserName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("userName","Equals", 3);
		APIListener.addLogger("Users attribute 'userName' fetching value for equals operator is successfully!");
	}
	 
   //username not equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 12)
	 public void getUsersFields_Pagination_userNameNotEquals() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'userName' fetching value for Not Equals operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("userName", "Not Equals","usersUserName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("userName","Not Equals", 3);
		APIListener.addLogger("Users attribute 'userName' fetching value for Not equals operator is successfully!");
	}
	 
    //username contains
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 13)
	 public void getUsersFields_Pagination_userNameContains() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'userName' fetching value for Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("userName", "Contains","usersUserName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("userName","Contains", 3);
		APIListener.addLogger("Users attribute 'userName' fetching value for Contains operator is successfully!");
	}
	 
	//username not Contains
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 14)
	 public void getUsersFields_Pagination_userNameNotContains() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'userName' fetching value for Not Contains operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("userName", "Not Contains","usersUserName", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("userName","Not Contains", 3);
		APIListener.addLogger("Users attribute 'userName' fetching value for Not Contains operator is successfully!");
	}
	 
	 //status equals
	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 15)
	 public void getUsersFields_Pagination_statusEquals() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'status' fetching value for Equals operator");
		usersPage.verifyUsers(PlutoraAPIConfiguration.testData);
		usersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		usersPage.usersValues();
		String [] user_status =LookupFieldsPage.usersList.get(0).split(",");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "users_status",user_status[4]);
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("status", "Equals","users_status", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("status","Equals", 4);
		APIListener.addLogger("Users attribute 'status' fetching value for equals operator is successfully!");
	}
	 
    //status not equals
 	 @Test(description = "Pagination and filter Combinations for Users", groups = {"RegressionTests" }, priority = 16)
	 public void getUsersFields_Pagination_statusNotEquals() throws ParseException, InterruptedException {
	 	APIListener.addLogger("[API] - Users attribute 'status' fetching value for Not Equals operator");
		usersPage.paginationfilterWithoutPagenum(PlutoraAPIConfiguration.testData,usersPage.setPaginationFilterOperator("status", "Not Equals","users_status", PlutoraAPIConfiguration.testData),
				 "users_PaginationFilterUrl");
		usersPage.verifyusersAttributesWithoutPageNum("status","Not Equals", 4);
		APIListener.addLogger("Users attribute 'status' fetching value for Not equals operator is successfully!");
	}
}
