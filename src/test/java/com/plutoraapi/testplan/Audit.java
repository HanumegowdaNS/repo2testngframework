package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.AuditPage;

public class Audit  {
	
	AuditPage auditPage = new AuditPage();
	
	@Test(description = "Create Audit Search", groups = { "RegressionTests" })
	public void createAuditSearch(){
		APIListener.test1.log(Status.INFO, "Create Audit Search"); 
		auditPage.createAuditSearch("createAuditSearchJson", PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		auditPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		auditPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "AuditSearchParameterNotEmpty"));
		/****************Set Identifier******************/
		auditPage.setDataToProperty("id");
	}
	
	@Test(description = "Verify Audit Search", groups = { "RegressionTests" },dependsOnMethods="createAuditSearch")
	public void verifyAuditSearch() {
		APIListener.test1.log(Status.INFO, "Verify Audit Search"); 
		auditPage.verifyAuditSearch(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		auditPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		auditPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "AuditSearchParameterNotEmpty"));
		
		auditPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "AuditSearchParameterValues"),PlutoraAPIConfiguration.testData);
	}
	

}

