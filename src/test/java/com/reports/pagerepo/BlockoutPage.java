package com.reports.pagerepo;

import static org.testng.Assert.assertEquals;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class BlockoutPage extends TestGenericUtilLib{
		
	public void blockoutPage(String blockoutData, String testData, String objectData) throws InterruptedException {
		sleep(2000);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Releases_Header_Sidemenu", blockoutData);
			sleep(500);
			click("Blockout_BlockoutPeriodsMenu", blockoutData);
		} else {
			mouseHover("Blockout_ReleaseHeader", "Blockout_BlockoutPeriodsMenu", blockoutData);
		}
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
	}
	
	public void readBlockout(String blockoutData, String testData, String objectData, String year) throws InterruptedException {
		sleep(1000);
		click("Blockout_Show_DropDown", blockoutData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		click("Clockout_CurrentYear_Option", String.valueOf(year), blockoutData);
	}
	
	public void clickOnBlockoutPeriod(String blockoutData, String testData, String objectData,String elementId){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Blockout_Name",elementId, blockoutData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	
	public void verifyBlockout(String blockoutData, String testData, String objectData) {
		String blockoutName = getTextData("Blockout_Name", BlockoutReportPage.blockoutName, blockoutData);
		assertEquals(BlockoutReportPage.blockoutName,blockoutName);
	}
	
}