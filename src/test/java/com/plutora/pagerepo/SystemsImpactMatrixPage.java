package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class SystemsImpactMatrixPage extends TestGenericUtilLib  {

	public void gotoSystemsImpactMatrix(String releaseData,String objectData) throws InterruptedException {	
		sleep(2000);
		mouseHover("Releases_Header_Dropdown", "SystemsImpactMatrix_Dropdown_Menu",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
	public void switchXY(String systemImpactData,String objectData){
		clickOnButton(systemImpactData,"SystemsImpactMatrix_ReleaseName_Text", "SystemsImpactMatrix_SwithXY_Button",
				objectData, "xpath");
	}
	
	public void setShowTotalByChange(String systemImpactData, String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("SystemsImpactMatrix_QuickFitrChange_Label", systemImpactData);
	}
	
	public void setShowTotalBySystem(String systemImpactData,String objectData){
		sleep(2000);
		clickElementUsingJavaScript("SystemsImpactMatrix_QuickFitrSystem_Label",systemImpactData);
	}
	
	public void setOrganizationNameOff(String orgOffStatus, String orgOnStatus, String systemImpactData,
			String objectData) {
		sleep(1000);
		orgOffStatus = PropertiesCache.getProperty(systemImpactData, orgOffStatus);

		try {
			webElementIdentifier(orgOffStatus).isDisplayed();
			Listener.addLogger("Organisation is set to Off");

		} catch (Exception e) {
			Listener.addLogger("Setting Organization status to Off");
			clickElementUsingJavaScript(orgOnStatus, systemImpactData);
		}
	}
	
	public void setOrganizationNameON(String orgOnStatus, String orgOffStatus, String systemImpactData,
			String objectData) {
		sleep(1000);
		orgOnStatus = PropertiesCache.getProperty(systemImpactData, orgOnStatus);

		try {
			webElementIdentifier(orgOnStatus).isDisplayed();
			Listener.addLogger("Organisation is set to On");

		} catch (Exception e) {
			Listener.addLogger("Setting Organization status to On");
			clickElementUsingJavaScript(orgOffStatus, systemImpactData);
		}
	}

	public void clickQuickFilterButton(String systemImpactData, String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("SystemsImpactMatrix_QuickFilter_Button",systemImpactData);
	}
	
	public void clickOnApplyFilterButton(String systemImpactData, String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("SystemsImpactMatrix_QuickFitrApplyFilter_Button",systemImpactData);
	}
}