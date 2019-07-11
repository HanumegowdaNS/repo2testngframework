package com.plutora.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class InitiativePage extends TestGenericUtilLib {

	public void gotoInitiativePage(String initiativeData,String testData,String objectData,String menuTitle) throws InterruptedException {
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		mouseHover("Initiative_Header_Dropdown", "Initiative_Dropdown_Option",menuTitle,initiativeData,testData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
	}

	public void clickOnFormCheckbox(String initiativeData,String objectData) {
		clickOnButton(initiativeData,"Initiative_Form_Checkbox",objectData);
		sleep(2000);
		clickOnButton(initiativeData, "Initiative_Form_Close_Popup", objectData);
	}
	
	
}
