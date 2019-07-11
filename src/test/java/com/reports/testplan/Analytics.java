package com.reports.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.reports.pagerepo.AnalyticsPage;

public class Analytics {
	AnalyticsPage ap = new AnalyticsPage();
	
	@Test(description="Logging in to Plutora Analytics")
	@Parameters({"objectMapFile", "testDataFile"})
	public void analytics_01(String objectData, String testData) throws InterruptedException {
		ap.analyticsPage(objectData, testData);
		ap.isElement_Present("Tableau_Explore_Label", objectData);
		ap.verifyTitle(PropertiesCache.getProperty(testData,"Analytics_Page_Title"));
		Listener.addLogger("Login to Plutora Analytics successfully | ");
	}
	
	@Test(description="Close Plutora Analytics tab and switch to Plutora site")
	@Parameters({"objectMapFile", "testDataFile"})
	public void analytics_02(String objectData, String testData) {
		ap.exitPlutoraAnalytics(objectData, testData);
		Listener.addLogger("Closed Plutora Analytics Tab and shifted focus to Plutora successfully | ");
	}
}