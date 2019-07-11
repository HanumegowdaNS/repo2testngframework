package com.plutoraapi.testplan;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.UserPreferencesPage;

public class UserPreferences  {
	
	UserPreferencesPage userPreferencesPage = new UserPreferencesPage();

	@Test(description = "Verify User Preferences", groups = { "RegressionTests" })
	public void verifyUserPreferences() {
		APIListener.test1.log(Status.INFO, "Verify User Preferences"); 
		userPreferencesPage.verifyUserPreferences(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		userPreferencesPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		userPreferencesPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "UserPreferencesParameterNotEmpty"));
	}
	

}

