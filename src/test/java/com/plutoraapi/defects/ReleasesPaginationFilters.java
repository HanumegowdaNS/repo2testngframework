package com.plutoraapi.defects;
import java.text.ParseException;
import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;

public class ReleasesPaginationFilters {
	
	ReleasesPage releasesPage = new ReleasesPage();
	
	//id equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 1)
	public void releasesPagination_IdEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'id' fetching value for Equals operator"); 
		releasesPage.createRelease("createReleaseJsonForFilter", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id;identifier;name","release_Id;release_identifier;release_name"); 
		releasesPage.setDataToProperty("implementationDate;displayColor;plutoraReleaseType","releases_implementDate;release_color;plutora_releaseType");
		releasesPage.setDataToProperty("releaseProjectType;releaseStatusType;lastModifiedDate","release_ProjectType;release_statusType;last_modifiedDate");
		releasesPage.setDataToProperty("parentReleaseId;parentRelease;releaseStatusTypeId","parent_ReleaseId;parent_Release;release_StatusTypeId");
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("id", "Equals", "release_Id", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("id");
		releasesPage.verifyResponseArrayValueForPagination("id","release_Id",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Releases attribute 'id' fetching value for Equals operator successfully!"); 
	}
	
	//id not equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 2)
	public void releasesPagination_IdNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'id' fetching value for Not Equals operator"); 
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("id", "Not Equals", "release_Id", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("id");
		releasesPage.verifyResponseArrayValueForPagination("id","release_Id",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Releases attribute 'id' fetching value for Not Equals operator successfully!"); 
	}
	
	//identifier equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 3)
	public void releasesPagination_identifierEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Equals operator"); 
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("identifier", "Equals", "release_identifier", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("identifier");
		releasesPage.verifyResponseArrayValueForPagination("identifier","release_identifier",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Releases attribute 'identifier' fetching value for Equals operator successfully!"); 
	}
	
	//identifier not equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 4)
	public void releasesPagination_identifierNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Not Equals operator"); 
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("identifier", "Not Equals", "release_identifier", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("identifier");
		releasesPage.verifyResponseArrayValueForPagination("identifier","release_identifier",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Releases attribute 'identifier' fetching value for Not Equals operator successfully!"); 
	}
		
	//identifier contains
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 5)
	public void releasesPagination_identifierContains() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Contains operator"); 
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("identifier", "Contains", "release_identifier", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("identifier");
		releasesPage.verifyResponseArrayValueForPagination("identifier","release_identifier",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger("Releases attribute 'identifier' fetching value for Contains operator successfully!"); 
	}
		
	//identifier not contains
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 6)
	public void releasesPagination_identifierNotContains() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'identifier' fetching value for Not Contains operator"); 
		releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("identifier", "Not Contains", "release_identifier", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("identifier");
		releasesPage.verifyResponseArrayValueForPagination("identifier","release_identifier",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("Releases attribute 'identifier' fetching value for Not Contains operator successfully!"); 
	}

	//name equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 7)
	public void releasesPagination_nameEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Equals operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("name", "Equals", "release_name", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("name");
		releasesPage.verifyResponseArrayValueForPagination("name","release_name",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Releases attribute 'name' fetching value for Equals operator successfully!"); 
	}

	//name not equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 8)
	public void releasesPagination_nameNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Not Equals operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("name", "Not Equals", "release_name", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("name");
		releasesPage.verifyResponseArrayValueForPagination("name","release_name",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Releases attribute 'name' fetching value for Not Equals operator successfully!"); 
	}
	
	//name contains
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 9)
	public void releasesPagination_nameContains() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Contains operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("name", "Contains", "release_name", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("name");
		releasesPage.verifyResponseArrayValueForPagination("name","release_name",PlutoraAPIConfiguration.testData,"Contains");
		APIListener.addLogger("Releases attribute 'name' fetching value for Contains operator successfully!"); 
	}
		
	//name not Contains
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 10)
	public void releasesPagination_nameNotContains() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'name' fetching value for Not Contains operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("name", "Not Contains", "release_name", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("name");
		releasesPage.verifyResponseArrayValueForPagination("name","release_name",PlutoraAPIConfiguration.testData,"Not Contains");
		APIListener.addLogger("Releases attribute 'name' fetching value for Not Contains operator successfully!"); 
	}
	
	//implementationDate equals
	String[] implementation_date;
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 11)
	public void releasesPagination_implementationDateEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Equals operator"); 
		implementation_date = PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "releases_implementDate").split("T");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_implementDate",implementation_date[0]);
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Equals", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("implementationDate");
		releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Equals");
		APIListener.addLogger("Releases attribute 'implementationDate' fetching value for Equals operator successfully!"); 
	}
	
	//implementationDate not equals
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 12)
	public void releasesPagination_implementationDateNotEquals() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Not Equals operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Not Equals", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("implementationDate");
		releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Not Equals");
		APIListener.addLogger("Releases attribute 'implementationDate' fetching value for Not Equals operator successfully!"); 
	}
	
	//implementationDate greater than
	@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 13)
	public void releasesPagination_implementationDateGreaterThan() throws ParseException, InterruptedException{
		APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Greater than operator"); 
	    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Greater Than", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
		releasesPage.setDataToPropertys("implementationDate");
		releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Greater Than");
		APIListener.addLogger("Releases attribute 'implementationDate' fetching value for greater than operator successfully!"); 
	}
	
	//implementationDate greater or equal
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 14)
		public void releasesPagination_implementationDateGreaterOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Greater or equal operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Greater Or Equal", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("implementationDate");
			releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("Releases attribute 'implementationDate' fetching value for greater Or Equal operator successfully!"); 
		}
		
		//implementationDate less than
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 15)
		public void releasesPagination_implementationDateLessThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for Less than operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Less Than", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("implementationDate");
			releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("Releases attribute 'implementationDate' fetching value for Less than operator successfully!"); 
		}
		
		//implementationDate less or equal
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 16)
		public void releasesPagination_implementationDateLessOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'implementationDate' fetching value for less or equal operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("implementationDate", "Less Or Equal", "split_implementDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("implementationDate");
			releasesPage.verifyDateResponseArrayValueForPagination("implementationDate","split_implementDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("Releases attribute 'implementationDate' fetching value for less or equal operator successfully!"); 
		}
		
		//displayColor equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 17)
		public void releasesPagination_displayColorEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("displayColor", "Equals", "release_color", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("displayColor");
			releasesPage.verifyResponseArrayValueForPagination("displayColor","release_color",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'displayColor' fetching value for equals operator successfully!"); 
		}
		
		//displayColor not equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 18)
		public void releasesPagination_displayColorNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for not equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("displayColor", "Not Equals", "release_color", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("displayColor");
			releasesPage.verifyResponseArrayValueForPagination("displayColor","release_color",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'displayColor' fetching value for not equals operator successfully!"); 
		}
		
		//displayColor contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 19)
		public void releasesPagination_displayColorContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for contains operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("displayColor", "Contains", "release_color", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("displayColor");
			releasesPage.verifyResponseArrayValueForPagination("displayColor","release_color",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Releases attribute 'displayColor' fetching value for Contains operator successfully!"); 
		}
	
		//displayColor not Contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 20)
		public void releasesPagination_displayColorNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'displayColor' fetching value for not Contains operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("displayColor", "Not Contains", "release_color", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("displayColor");
			releasesPage.verifyResponseArrayValueForPagination("displayColor","release_color",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Releases attribute 'displayColor' fetching value for not Contains operator successfully!"); 
		}
		
		//plutoraReleaseType equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 21)
		public void releasesPagination_plutoraReleaseTypeEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'plutoraReleaseType' fetching value for equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("plutoraReleaseType", "Equals", "plutora_releaseType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("plutoraReleaseType");
			releasesPage.verifyResponseArrayValueForPagination("plutoraReleaseType","plutora_releaseType",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'plutoraReleaseType' fetching value for equals operator successfully!"); 
		}
				
		//plutoraReleaseType not equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 22)
		public void releasesPagination_plutoraReleaseTypeNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'plutoraReleaseType' fetching value for not equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("plutoraReleaseType", "Not Equals", "plutora_releaseType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("plutoraReleaseType");
			releasesPage.verifyResponseArrayValueForPagination("plutoraReleaseType","plutora_releaseType",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'plutoraReleaseType' fetching value for not equals operator successfully!"); 
		}
				
		//releaseProjectType equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 23)
		public void releasesPagination_releaseProjectTypeEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseProjectType' fetching value for equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseProjectType", "Equals", "release_ProjectType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseProjectType");
			releasesPage.verifyResponseArrayValueForPagination("releaseProjectType","release_ProjectType",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'releaseProjectType' fetching value for equals operator successfully!"); 
		}
		
		//releaseProjectType not equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 24)
		public void releasesPagination_releaseProjectTypeNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseProjectType' fetching value for not equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseProjectType", "Not Equals", "release_ProjectType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseProjectType");
			releasesPage.verifyResponseArrayValueForPagination("releaseProjectType","release_ProjectType",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'releaseProjectType' fetching value for not equals operator successfully!"); 
		}
		
		//releaseStatusType Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 25)
		public void releasesPagination_releaseStatusTypeEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusType", "Equals", "release_statusType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusType");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusType","release_statusType",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'releaseStatusType' fetching value for Equals operator successfully!"); 
		}
		
		//releaseStatusType Not Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 26)
		public void releasesPagination_releaseStatusTypeNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for not equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusType", "Not Equals", "release_statusType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusType");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusType","release_statusType",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'releaseStatusType' fetching value for Not Equals operator successfully!"); 
		}
		
		//releaseStatusType Contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 27)
		public void releasesPagination_releaseStatusTypeContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for Contains operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusType", "Contains", "release_statusType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusType");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusType","release_statusType",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Releases attribute 'releaseStatusType' fetching value for Contains operator successfully!"); 
		}
				
		//releaseStatusType Not Contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 28)
		public void releasesPagination_releaseStatusTypeNotContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusType' fetching value for Not Contains operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusType", "Not Contains", "release_statusType", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusType");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusType","release_statusType",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Releases attribute 'releaseStatusType' fetching value for Not Contains operator successfully!"); 
		}
		
		//lastModifiedDate Equals
		String[] lastModified_Date;
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 29)
		public void releasesPagination_lastModifiedDateEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Equals operator"); 
			lastModified_Date= PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "last_modifiedDate").split("T");
			PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "split_lastModifiedDate",lastModified_Date[0]);
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Equals", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Equals operator successfully!"); 
		}
		
		//lastModifiedDate not Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 30)
		public void releasesPagination_lastModifiedDateNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Not Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Not Equals", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Not Equals operator successfully!"); 
		}
		
		//lastModifiedDate greater than
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 31)
		public void releasesPagination_lastModifiedDateGreaterThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Greater Than operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Greater Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Than");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Greater Than operator successfully!"); 
		}
				
		//lastModifiedDate Greater or equal
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 32)
		public void releasesPagination_lastModifiedDateGreaterOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Greater Or Equal operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Greater Or Equal", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Greater Or Equal");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Greater Or Equal operator successfully!"); 
		}
				
		//lastModifiedDate less than
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 33)
		public void releasesPagination_lastModifiedDateLessThan() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Less Than operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Less Than", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Than");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Less Than operator successfully!"); 
		}
				
		//lastModifiedDate Less or equal
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 34)
		public void releasesPagination_lastModifiedDateLessOrEqual() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'lastModifiedDate' fetching value for Less Or Equal operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("lastModifiedDate", "Less Or Equal", "split_lastModifiedDate", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("lastModifiedDate");
			releasesPage.verifyDateResponseArrayValueForPagination("lastModifiedDate","split_lastModifiedDate",PlutoraAPIConfiguration.testData,"Less Or Equal");
			APIListener.addLogger("Releases attribute 'lastModified_Date' fetching value for Less Or Equal operator successfully!"); 
		}
		
		//parentReleaseID Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 35)
		public void releasesPagination_parentReleaseIDEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'parentReleaseID' fetching value for Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentReleaseID", "Equals", "parent_ReleaseId", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentReleaseID");
			releasesPage.verifyResponseArrayValueForPagination("parentReleaseID","parent_ReleaseId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'parentReleaseID' fetching value for Equals operator successfully!"); 
		}
		
		//parentReleaseID Not Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 36)
		public void releasesPagination_parentReleaseIDNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'parentReleaseID' fetching value for Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentReleaseID", "Not Equals", "parent_ReleaseId", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentReleaseID");
			releasesPage.verifyResponseArrayValueForPagination("parentReleaseID","parent_ReleaseId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'parentReleaseID' fetching value for Not Equals operator successfully!"); 
		}
		
		//parentRelease Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 37)
		public void releasesPagination_parentReleaseEquals() throws ParseException, InterruptedException{
     		APIListener.addLogger( "[API] - Releases attribute 'parentRelease' fetching value for Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentRelease", "Equals", "parent_Release", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentRelease");
			releasesPage.verifyResponseArrayValueForPagination("parentRelease","parent_Release",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'parentRelease' fetching value for Equals operator successfully!"); 
		}
		
		//parentRelease not Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 38)
		public void releasesPagination_parentReleaseNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'parentRelease' fetching value for Not Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentRelease", "Not Equals", "parent_Release", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentRelease");
			releasesPage.verifyResponseArrayValueForPagination("parentRelease","parent_Release",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'parentRelease' fetching value for Not Equals operator successfully!"); 
		}
				
		//parentRelease Contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 39)
		public void releasesPagination_parentReleaseContains() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'parentRelease' fetching value for Contains operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentRelease", "Contains", "parent_Release", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentRelease");
			releasesPage.verifyResponseArrayValueForPagination("parentRelease","parent_Release",PlutoraAPIConfiguration.testData,"Contains");
			APIListener.addLogger("Releases attribute 'parentRelease' fetching value for Contains operator successfully!"); 
		}
				
		//parentRelease Not Contains
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 40)
		public void releasesPagination_parentReleaseNotContains() throws ParseException, InterruptedException{
		    APIListener.addLogger( "[API] - Releases attribute 'parentRelease' fetching value for Not Contains operator"); 
			releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("parentRelease", "Not Contains", "parent_Release", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("parentRelease");
			releasesPage.verifyResponseArrayValueForPagination("parentRelease","parent_Release",PlutoraAPIConfiguration.testData,"Not Contains");
			APIListener.addLogger("Releases attribute 'parentRelease' fetching value for Not Contains operator successfully!"); 
		}
		
		//parentRelease Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 41)
		public void releasesPagination_releaseStatusTypeIDEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusTypeID' fetching value for Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusTypeID", "Equals", "release_StatusTypeId", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusTypeID");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusTypeID","release_StatusTypeId",PlutoraAPIConfiguration.testData,"Equals");
			APIListener.addLogger("Releases attribute 'releaseStatusTypeID' fetching value for Equals operator successfully!"); 
		}
		
		//parentRelease Not Equals
		@Test(description = "Pagination and filter Combinations for Releases", groups = { "RegressionTests" },priority = 42)
		public void releasesPagination_releaseStatusTypeIDNotEquals() throws ParseException, InterruptedException{
			APIListener.addLogger( "[API] - Releases attribute 'releaseStatusTypeID' fetching value for Not Equals operator"); 
		    releasesPage.paginationfilter(PlutoraAPIConfiguration.testData, releasesPage.setPaginationFilterOperator("releaseStatusTypeID", "Not Equals", "release_StatusTypeId", PlutoraAPIConfiguration.testData), "0", "10","releasesPaginationFilterUrl");
			releasesPage.setDataToPropertys("releaseStatusTypeID");
			releasesPage.verifyResponseArrayValueForPagination("releaseStatusTypeID","release_StatusTypeId",PlutoraAPIConfiguration.testData,"Not Equals");
			APIListener.addLogger("Releases attribute 'releaseStatusTypeID' fetching value for Not Equals operator successfully!"); 
		}
}

