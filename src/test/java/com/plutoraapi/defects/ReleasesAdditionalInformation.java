package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.ReleasesPage;

public class ReleasesAdditionalInformation  {

	ReleasesPage releasesPage = new ReleasesPage();

	/*@Test(description = "API - PUT releases/{id} returns error if no custom fields exist in Plutora", groups = { "RegressionTests" },priority = 1)
	public void release4527AdditionalInformation_1() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating Enterprise Release"); 
		APIListener.addLogger( "Precondition: Remove all customfields from customization -> release custom field section..");
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release POST releases without custom field without Additional Information in the request body is successfully!"); 
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseDataArrayValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Releases4527AdditionalInformationFeild"),"");
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release GET releases without custom field without Additional Information in the request body is successfully!"); 
		releasesPage.updateRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release PUT releases without custom field without Additional Information in the request body is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}*/
	
	@Test(description = "API - PUT releases/{id} returns error if no custom fields exist in Plutora", groups = { "RegressionTests" },priority = 2)
	public void release4527AdditionalInformation_2() throws InterruptedException{
		APIListener.addLogger( "[API] - Creating Enterprise Release"); 
		APIListener.addLogger( "Precondition: Add customfields from customization -> release custom field section & Modify added field GUID & Name in propertyfile 'Release4527CustomFieldGuid' & 'Releases4527AdditionalInformationName'.");
		Thread.sleep(1000);
		releasesPage.createRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		Thread.sleep(1000);
		releasesPage.setDataToProperty("id");
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release POST releases with custom field without Additional Information in the request body is successfully!"); 
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseDataArrayValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Releases4527AdditionalInformationFeild"),PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Releases4527AdditionalInformationName"));
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release GET releases with custom field without Additional Information in the request body is successfully!"); 
		releasesPage.updateRelease("createRelease4325Json", PlutoraAPIConfiguration.testData);
		releasesPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release PUT releases with custom field without Additional Information in the request body is successfully!"); 
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	
	
	@Test(description = "API - PUT releases/{id} returns error if no custom fields exist in Plutora", groups = { "RegressionTests" },priority = 3)
	public void release4527AdditionalInformation_3() throws InterruptedException{
		//Custom field
		APIListener.addLogger( "Precondition: Add customfields from customization -> release custom field section & Modify added field GUID & Name in propertyfile 'Release4527CustomFieldGuid' & 'Releases4527AdditionalInformationName'.");
		Thread.sleep(1000);
		releasesPage.createReleaseWithCustomField("createRelease4527Json", PlutoraAPIConfiguration.testData,"Release4527CustomFieldGuid");
		Thread.sleep(1000);
		releasesPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id");
		APIListener.addLogger( "[API] - Enterprise Release POST releases with custom field with Additional Information in the request body is successfully!"); 
		releasesPage.verifyRelease(PlutoraAPIConfiguration.testData);
		releasesPage.verifyResponseDataArrayValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Releases4527AdditionalInformationFeild"),PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "Releases4527AdditionalInformationName"));
		releasesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release GET releases with custom field with Additional Information in the request body is successfully!"); 
		releasesPage.updateReleaseWithCustomField("createRelease4325Json", PlutoraAPIConfiguration.testData,"Release4527CustomFieldGuid");
		releasesPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - Enterprise Release PUT releases with custom field with Additional Information in the request body is successfully!");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);
	}
	
	
}

