package com.plutoraapi.testplan;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.CustomFieldsPage;
import com.plutoraapi.pagerepo.LookupFieldsPage;


public class CustomFields {
	
	CustomFieldsPage customFieldsPage = new CustomFieldsPage();
	
	@Test(description = "Get Custom fields", groups = { "RegressionTests" })
	public void verifyCustomFields_01() {
		APIListener.test1.log(Status.INFO, "Get Custom fields"); 
		customFieldsPage.getCustomFields(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomfieldsParameterNotEmpty"));
		List<String> nameList = CustomFieldsPage.response.jsonPath().getList("name");
		System.out.println(PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"customType",nameList.get(0)));
	}
	
	@Test(description = "Get Custom fields by type", groups = { "RegressionTests" })
	public void verifyCustomFields_02() {
		APIListener.test1.log(Status.INFO, "Get Custom fields by type"); 
		customFieldsPage.getCustomFieldsByType(PlutoraAPIConfiguration.testData,"customType");
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomfieldsParameterTypeNotEmpty"));
		List<String> idList = CustomFieldsPage.response.jsonPath().getList("id");
		System.out.println(PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"typeId",idList.get(0)));
	}
	
	@Test(description = "Custom fields by Id", groups = { "RegressionTests" })
	public void verifyCustomFields_03() {
		APIListener.test1.log(Status.INFO, "Get Custom fields by Id"); 
		customFieldsPage.getCustomFieldsByID(PlutoraAPIConfiguration.testData,"typeId");
		//****************Verify Status Code******************//*
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomfieldsParameterTypeNotEmpty"));
		
	}
	
	@Test(description = "Custom fields custom list", groups = { "RegressionTests" })
	public void verifyCustomFields_04() {
		APIListener.test1.log(Status.INFO, "Get Custom fields custom list"); 
		customFieldsPage.getCustomFieldsCustomList(PlutoraAPIConfiguration.testData,"typeId");
		//****************Verify Status Code******************//*
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomListParameterIDNotEmpty"));
		
	}
	
	@Test(description = "Get Custom field groups", groups = { "RegressionTests" })
	public void verifyCustomFields_05() {
		APIListener.test1.log(Status.INFO, "Get Custom field groups"); 
		customFieldsPage.getCustomFieldGroups(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomfieldsParameterNotEmpty"));
		List<String> nameList = CustomFieldsPage.response.jsonPath().getList("name");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"customGroupType",nameList.get(0));
	}
	
	@Test(description = "Get Custom field groups by type", groups = { "RegressionTests" })
	public void verifyCustomFields_06() {
		APIListener.test1.log(Status.INFO, "Get Custom field groups by type"); 
		customFieldsPage.getCustomFieldGroupsByType(PlutoraAPIConfiguration.testData,"customGroupType");
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomGroupParameter"));
		List<String> idList = CustomFieldsPage.response.jsonPath().getList("id");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"typeId",idList.get(0));
	}
	
	@Test(description = "Custom field group by Id", groups = { "RegressionTests" })
	public void verifyCustomFields_07() {
		APIListener.test1.log(Status.INFO, "Get Custom field group by Id"); 
		customFieldsPage.getCustomFieldGroupsByID(PlutoraAPIConfiguration.testData,"typeId");
		//****************Verify Status Code******************//*
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomGroupParameter"));
		
	}
	
	@Test(description = "Get Custom field Tabs", groups = { "RegressionTests" })
	public void verifyCustomFields_08() {
		APIListener.test1.log(Status.INFO, "Get Custom field Tabs"); 
		customFieldsPage.getCustomFieldTabs(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomfieldsParameterNotEmpty"));
		List<String> nameList = CustomFieldsPage.response.jsonPath().getList("name");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"customTabType",nameList.get(0));
	}
	
	@Test(description = "Get Custom field groups by type", groups = { "RegressionTests" })
	public void verifyCustomFields_09() {
		APIListener.test1.log(Status.INFO, "Get Custom field tabs by type"); 
		customFieldsPage.getCustomFieldTabsByType(PlutoraAPIConfiguration.testData,"customTabType");
		/****************Verify Status Code******************/
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomTabsParameter"));
		List<String> idList = CustomFieldsPage.response.jsonPath().getList("id");
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData,"typeId",idList.get(0));
	}
	
	@Test(description = "Custom field group by Id", groups = { "RegressionTests" })
	public void verifyCustomFields_10() {
		APIListener.test1.log(Status.INFO, "Get Custom field tabs by Id"); 
		customFieldsPage.getCustomFieldTabsByID(PlutoraAPIConfiguration.testData,"typeId");
		//****************Verify Status Code******************//*
		customFieldsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		customFieldsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "CustomTabsParameter"));
		
	}
	
}
