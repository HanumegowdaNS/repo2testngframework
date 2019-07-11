package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;


import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutoraapi.pagerepo.HostsPage;
import com.plutoraapi.pagerepo.SystemsPage;

public class HostPaginationFilters {
	HostsPage hostPage = new HostsPage();
	SystemsPage systemsPage =new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 1)
	public void getHosts_Pagination_IdEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Hosts attribute 'id' fetching value for  operator");
		//create system
		systemsPage.createSystems("createSystemsJson", PlutoraAPIConfiguration.testData);
		systemsPage.setDataToProperty("id","System_Id");
		APIListener.addLogger( "System has been created successfully! ");
		//create environment 1
		environmentPage.createEnvironmentwithSystem("createEnvironmentJson",PlutoraAPIConfiguration.testData, "System_Id");
		environmentPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "Environment has been created successfully! ");
		environmentPage.setDataToProperty("id","Env_Id");
		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData,"Env_Id");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		
		hostPage.setDataToProperty("id;name;environmentID", "host_Id;host_name;host_environmentID");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("id", "Equals", "host_Id", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("id");
		hostPage.verifyResponseArrayValueForPagination("id","host_Id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Hosts Page attribute 'id' fetching value for Equals operator successfully!"); 
		
	}

	//id not equals
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 2)
    public void getHosts_Pagination_IdNotEquals() throws ParseException, InterruptedException {
		APIListener.addLogger("[API] - Hosts attribute 'id' fetching for Not Equals operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("id", "Not Equals", "host_Id", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("id");
		hostPage.verifyResponseArrayValueForPagination("id","host_Id",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Hosts Page attribute 'id' fetching value for Not Equals operator successfully!"); 
		
	}
	
	//name equals
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 3)
	public void getHosts_Pagination_nameEquals() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'name' fetching for Equals operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("name", "Equals", "host_name", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("name");
		hostPage.verifyResponseArrayValueForPagination("name","host_name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Hosts Page attribute 'name' fetching value for Equals operator successfully!"); 
	}
				
	//name not equals
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 4)
	public void getHosts_Pagination_nameNotEquals() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'name' fetching for Not Equals operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("name", "Not Equals", "host_name", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("name");
		hostPage.verifyResponseArrayValueForPagination("name","host_name",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Hosts Page attribute 'name' fetching value for Not Equals operator successfully!"); 
		}
		
	//name contains
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 5)
	public void getHosts_Pagination_NameContains() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'name' fetching for Contains operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("name", "Contains", "host_name", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("name");
		hostPage.verifyResponseArrayValueForPagination("name","host_name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger("Hosts Page attribute 'name' fetching value for Contains operator successfully!"); 
		}
			
	//name not contains
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 6)
	public void getHosts_Pagination_nameNotContains() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'name' fetching for Not Contains operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("name", "Not Contains", "host_name", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("name");
		hostPage.verifyResponseArrayValueForPagination("name","host_name",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("Hosts Page attribute 'name' fetching value for Not Contains operator successfully!"); 
	}
	
	//environmentID equals
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 7)
	public void getHosts_Pagination_environmentIDEquals() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'environmentID' fetching for Equals operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("environmentID", "Equals", "host_environmentID", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("environmentID");
		hostPage.verifyResponseArrayValueForPagination("environmentID","host_environmentID",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Hosts Page attribute 'environmentID' fetching value for Equals operator successfully!"); 
	}
		
	//environmentID not equals
	@Test(description = "Pagination and filter Combinations for Get Hosts", groups = {"RegressionTests" }, priority = 8)
	public void getHosts_Pagination_environmentIDNotEquals() throws ParseException, InterruptedException {
	    APIListener.addLogger("[API] - Hosts attribute 'environmentID' fetching for Not Equals operator");
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterOperator("environmentID", "Not Equals", "host_environmentID", PlutoraAPIConfiguration.testData), "0", "10","Hosts_PaginationFiltersURL");
		hostPage.setDataToPropertys("environmentID");
		hostPage.verifyResponseArrayValueForPagination("environmentID","host_environmentID",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Hosts Page attribute 'environmentID' fetching value for Not Equals operator successfully!"); 
	}
			
/*
	// Name Combination --> Equals (a or b)
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 : Name Equals (a or b) ", groups = {
			"RegressionTests" }, priority = 4)
	public void GetHosts_Pagination_Name_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Hosts-- Filter Combination 1 : Name Equals (a or b) fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.setDataToPropertys("name", "Name_1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id2");
		hostPage.setDataToPropertys("name", "Name_2");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Name Equals (a or b)
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterCombinations("name",
				"Equals", "Name_1", "OR", "Name_2", PlutoraAPIConfiguration.testData), "1", "10",
				"Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("name", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Name_1", "Name_2" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 1 : Name Equals (a or b) fetching value for  operator successfully!");
	}

	// Environment Id Combinations --> Equals (x or y)
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 : Environment Id Equals (x or y) ", groups = {
			"RegressionTests" }, priority = 5)
	public void GetHosts_Pagination_EnvironmentId_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger(
				"Hosts-- Filter Combination 2 : Environment Id Equals (x or y) fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.setDataToPropertys("environmentId", "EnvironmentId_1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id2");
		hostPage.setDataToPropertys("environmentId", "EnvironmentId_2");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Environment Id Equals (x or y)
		hostPage.paginationfilter(
				PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterCombinations("environmentId", "Equals",
						"EnvironmentId_1", "OR", "EnvironmentId_2", PlutoraAPIConfiguration.testData),
				"1", "10", "Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("environmentId", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "EnvironmentId_1", "EnvironmentId_2" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 2 : Environment Id Equals (x or y) fetching value for  operator successfully!");
	}

	// Name Equals (a or b) and Environment Id Equals (x or y)
	@Test(description = "Pagination and filter Combinations for GET HOSTS", groups = {
			"RegressionTests" }, priority = 6)
	public void GetHosts_Pagination_Name_EnvironmentId_CombinationFilters()
			throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Hosts attribute 'Name Equals (a or b) and Environment Id Equals (x or y)' fetching value for  operator");
		this.GetHosts_Pagination_Name_Combination1();
		this.GetHosts_Pagination_EnvironmentId_Combination2();
		// Name Equals (a or b) and Environment Id Equals (x or y)
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData,
				hostPage.setPaginationFilterCombinationWith2Operators("name", "Equals", "Name_1", "OR", "Name_2", "AND",
						"environmentId", "Equals", "EnvironmentId_1", "OR", "EnvironmentId_2",
						PlutoraAPIConfiguration.testData),
				"1", "10", "Hosts_PaginationFiltersURL");

		APIListener.addLogger(
				"Hosts attribute 'Name Equals (a or b) and Environment Id Equals (x or y)' fetching value for  operator successfully!");
	}

	// Id Combination --> Equals(a or b)
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 : Id Equals (a or b) ", groups = {
			"RegressionTests" }, priority = 7)
	public void GetHosts_Pagination_Id_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Hosts-- Filter Combination 1: Id Equals (a or b) fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id2");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Id Equals (a or b)
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterCombinations("id",
				"Equals", "Hosts_Id1", "OR", "Hosts_Id2", PlutoraAPIConfiguration.testData), "1", "10",
				"Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("id", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Hosts_Id1", "Hosts_Id2" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 1 : Id Equals (a or b) fetching value for  operator successfully!");
	}

	// EnvironmentId Combination --> Equals x
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 :Id Equals (a or b) ", groups = {
			"RegressionTests" }, priority = 8)
	public void GetHosts_Pagination_Environment_Id_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Hosts-- Filter Combination 2: Environment Id Equals X fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.setDataToPropertys("environmentId", "EnvironmentId_1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		hostPage.getHosts(PlutoraAPIConfiguration.testData);
		// EnvironmentId Equals x
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData,
				hostPage.setPaginationFilterOperator("environmentId", "Equals", "EnvironmentId_1",
						PlutoraAPIConfiguration.testData),
				"1", "10", "Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("environmentId", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "EnvironmentId_1" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 2 :  Environment Id Equals X fetching value for  operator successfully!");
	}

	// Id Equals (a or b) or Environment Id Equals X
	@Test(description = "Pagination and filter Combinations for GET HOSTS", groups = {
			"RegressionTests" }, priority = 9)
	public void GetHosts_Pagination_Id_EnvironmentId_CombinationFilters() throws ParseException, InterruptedException {
		APIListener.addLogger(
				"[API] - Hosts attribute 'Id Equals (a or b) or Environment Id Equals X' fetching value for  operator");
		this.GetHosts_Pagination_Id_Combination1();
		this.GetHosts_Pagination_Environment_Id_Combination2();

		// Id Equals (a or b) or Environment Id Equals X
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData,
				hostPage.setPaginationFilterCombinationWith3Keys("id", "Equals", "Hosts_Id1", "OR", "Hosts_Id2", "OR",
						"environmentId", "Equals", "EnvironmentId_1", PlutoraAPIConfiguration.testData),
				"1", "10", "Hosts_PaginationFiltersURL");

		APIListener.addLogger(
				"Hosts attribute 'Id Equals (a or b) or Environment Id Equals X' fetching value for  operator successfully!");
	}

	// Id Equals (a or b)
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 :Id Equals (a or b) ", groups = {
			"RegressionTests" }, priority = 10)
	public void GetHosts_Pagination_Id1_Combination1() throws ParseException, InterruptedException {
		APIListener.addLogger("Hosts-- Filter Combination 1: Id Equals (a or b) fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id2");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);

		// Id Equals (a or b)
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData, hostPage.setPaginationFilterCombinations("id",
				"Equals", "Hosts_Id1", "OR", "Hosts_Id2", PlutoraAPIConfiguration.testData), "1", "10",
				"Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("id", PlutoraAPIConfiguration.testData, "Equals",
				new String[] { "Hosts_Id1", "Hosts_Id1" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 1 :  Id Equals (a or b) fetching value for  operator successfully!");
	}

	// Name contains m
	@Test(description = "Pagination and filter Combinations for Hosts. Combination 1 : Name contains m ", groups = {
			"RegressionTests" }, priority = 11)
	public void GetHosts_Pagination_Name_Combination2() throws ParseException, InterruptedException {
		APIListener.addLogger("Hosts-- Filter Combination 2: 'Name contains m' fetching value for  operator");

		hostPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData);
		hostPage.setDataToPropertys("id", "Hosts_Id1");
		hostPage.setDataToPropertys("name", "name_1");
		hostPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		hostPage.getHosts(PlutoraAPIConfiguration.testData);

		// Name contains m
		hostPage.paginationfilter(PlutoraAPIConfiguration.testData,
				hostPage.setPaginationFilterOperator("name", "Contains", "name_1", PlutoraAPIConfiguration.testData),
				"1", "10", "Hosts_PaginationFiltersURL");
		hostPage.verifyResponseArrayValueCombinations("name", PlutoraAPIConfiguration.testData, "Contains",
				new String[] { "name_1" });
		APIListener.addLogger(
				"Hosts-- Filter Combination 2 :  'Name contains m' fetching value for  operator successfully!");
	}*/

	/*
	 * // (Id Equals (a or b) and Name contains m)and Environment Id Equals y
	 * 
	 * @Test(description = "Pagination and filter Combinations for GET HOSTS",
	 * groups = { "RegressionTests" }, priority = 12) public void
	 * GetHosts_Pagination_Id_Name_EnvironmentId_CombinationFilters() throws
	 * ParseException, InterruptedException { APIListener.addLogger(
	 * "[API] - Hosts attribute '(Id Equals (a or b) and Name contains m)and Environment Id Equals y' fetching value for  operator"
	 * ); this.GetHosts_Pagination_Id1_Combination1();
	 * this.GetHosts_Pagination_Name_Combination2();
	 * this.GetHosts_Pagination_Environment_Id_Combination2();
	 * 
	 * // (Id Equals (a or b) and Name contains m)and Environment Id Equals y
	 * hostPage.paginationfilter(PlutoraAPIConfiguration.testData,
	 * hostPage.setPaginationFilterCombinationWithKeys("id", "Equals", "Hosts_Id1",
	 * "OR", "Hosts_Id2", "AND","name", "Contains", "name_1","AND","environmentId",
	 * "Equals","EnvironmentId_1", PlutoraAPIConfiguration.testData), "1", "10",
	 * "Hosts_PaginationFiltersURL");
	 * 
	 * APIListener.addLogger(
	 * "Hosts attribute '(Id Equals (a or b) and Name contains m)and Environment Id Equals y' fetching value for  operator successfully!"
	 * ); }
	 */
}
