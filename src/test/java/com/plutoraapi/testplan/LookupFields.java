package com.plutoraapi.testplan;

import java.util.List;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.LookupFieldsPage;

public class LookupFields  {
	
	LookupFieldsPage lookupFieldsPage = new LookupFieldsPage();

	@Test(description = "Verify Lookup fields", groups = { "RegressionTests" })
	public void verifyLookupFields_01() {
		APIListener.test1.log(Status.INFO, "Verify Lookup fields"); 
		lookupFieldsPage.verifyLookupFields(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		lookupFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		lookupFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LookupfieldsParameterNotEmpty"));
		List<String> nameList = LookupFieldsPage.response.jsonPath().getList("name");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"lookupType",nameList.get(0));
	}

	@Test(description = "Verify Lookup fields", groups = { "RegressionTests" })
	public void verifyLookupFields_02() {
		APIListener.test1.log(Status.INFO, "Verify Lookup fields"); 
		lookupFieldsPage.verifyLookupFieldsByType(PlutoraAPIConfiguration.testData,"lookupType");
		/****************Verify Status Code******************/
		lookupFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		lookupFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LookupfieldsParameterIDNotEmpty"));
		List<String> idList = LookupFieldsPage.response.jsonPath().getList("id");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"typeId",idList.get(0));
	}
	
	@Test(description = "Verify Lookup fields", groups = { "RegressionTests" })
	public void verifyLookupFields_03() {
		APIListener.test1.log(Status.INFO, "Verify Lookup fields"); 
		lookupFieldsPage.verifyLookupFieldsByID(PlutoraAPIConfiguration.testData,"typeId");
		//****************Verify Status Code******************//*
		lookupFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		lookupFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LookupfieldsParameterIDNotEmpty"));
		
	}
	

}

