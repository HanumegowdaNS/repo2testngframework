package com.plutoraapi.testplan;

import org.testng.annotations.Test;

import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.RestAPIGenericUtilLib;

public class Authorization extends RestAPIGenericUtilLib {
	
	@Test(description = "Create Access Token", groups = { "RegressionTests" })
	public void createAccessToken() {
		/****************Authorization************************/
		APIListener.addLogger("Create access token"); 
		getAuthorizationToken(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TokenParameter"));
		verifyResponseValue("token_type",PlutoraAPIConfiguration.testData);
		/****************Set Parameter**************************/
		setDataToProperty("access_token;refresh_token");
	}
	

}

