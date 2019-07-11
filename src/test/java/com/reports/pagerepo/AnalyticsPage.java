package com.reports.pagerepo;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class AnalyticsPage extends TestGenericUtilLib{
	
	public void analyticsPage(String objectData, String testData) throws InterruptedException {
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		mouseHover("Reporting_Header", "Analytics_Reporting_Option", objectData);
		sleep(4000);
		switchToWindow(testData,2000, "Plutora_Window", "Tableau_Window");
	}

	public void exitPlutoraAnalytics(String objectData, String testData) {
		driver.switchTo().window(PropertiesCache.getProperty(testData,"Tableau_Window"));
		closeWindowTab();
		driver.switchTo().window(PropertiesCache.getProperty(testData,"Plutora_Window"));
	}
}