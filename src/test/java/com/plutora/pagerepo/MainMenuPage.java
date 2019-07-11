package com.plutora.pagerepo;

import java.awt.AWTException;
import java.io.IOException;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.TestGenericUtilLib;

public class MainMenuPage extends TestGenericUtilLib {

	public void searchItem(String mainMenuData,String testData,String objectData,String name) {
		clickOnButton(mainMenuData,"MainMenu_Search_Icon",objectData);
		sendKeysWithEnter("MainMenu_Search_Textbox", name, mainMenuData,testData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		clickOnButton(mainMenuData,"MainMenu_Search_Option",objectData);
	}
	public void recentItem(String mainMenuData,String testData,String objectData,String name) {
		clickOnButton(mainMenuData,"MainMenu_Recent_Items_Option",objectData);
	//	clickOnButton(mainMenuData,"MainMenu_View_Recent_Items_Button",objectData);
	//	clickOnButton(mainMenuData,"MainMenu_Recent_Items_Option",objectData);
		clickButton("MainMenu_Recent_Items_Text",name,mainMenuData,testData,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
	public void clickOnMyPIRActions(String mainMenuData,String objectData) {
		clickOnButton(mainMenuData,"MainMenu_Message_Icon",objectData);
		clickOnButton(mainMenuData,"MainMenu_MyPIRActions_Button",objectData);
	}
	public void closeDefaultPIRStatus(String mainMenuData,String objectData) {
		try {
		while(getWebElementCount("MainMenu_MyPIRActions_Status_Close_Icon", "",mainMenuData, "")==1) {
			clickElementUsingJavaScript("MainMenu_MyPIRActions_Status_Close_Icon", "",mainMenuData);
			waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		}
		}catch(Exception e) {
			
		}
	}
	public void selectPIRStatus(String mainMenuData,String objectData,String status) {
		clickOnButton(mainMenuData,"MainMenu_MyPIRActions_Status_Dropdown",objectData);
		click("MainMenu_MyPIRActions_Status_Option",status,mainMenuData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		sleep(4000);
		clickOnButton(mainMenuData,"MainMenu_MyPIRActions_Status_Dropdown",objectData);
	}
	public void addNewAvatarImage(String mainMenuData,String objectData) throws InterruptedException, IOException, AWTException {
		clickOnButton(objectData, "Login_FullName_Link", objectData);
		clickOnButton(mainMenuData, "MainMenu_Profile_Option", objectData);
		uploadImageByName("AvatarFile");
		clickOnButton(mainMenuData, "MainMenu_Save&Close_Button", objectData);
		
	}
	public void addDefaultAvatarImage(String mainMenuData,String objectData) throws InterruptedException, IOException, AWTException {
		clickOnButton(objectData, "Login_FullName_Link", objectData);
		clickOnButton(mainMenuData, "MainMenu_Profile_Option", objectData);
		clickOnButton(mainMenuData,"MainMenu_Avatar_DefaultAvatar_Button",objectData);
		clickOnButton(mainMenuData, "MainMenu_Save&Close_Button", objectData);
		
	}
	public void clickOnReleaseActivitiesTab(String mainMenuData,String objectData) {
		clickOnButton(mainMenuData,"MainMenu_Message_Icon",objectData);
		clickOnButton(mainMenuData,"MainMenu_Release_Activities_Tab",objectData);
	}
	public void clickOnActivityStatus(String mainMenuData,String objectData) {
	    clickOnButton(mainMenuData,"MainMenu_Release_Activities_NotStarted_Checkox_Checked","MainMenu_Release_Activities_NotStarted_Checkbox",objectData);
	    clickOnButton(mainMenuData,"MainMenu_Release_Activities_InProgress_Checkbox_Checked","MainMenu_Release_Activities_InProgress_Checkbox",objectData);
	    sleep(2000);
	    clickOnButton(mainMenuData,"MainMenu_Release_Activities_Completed_Checkbox_Checked","MainMenu_Release_Activities_Completed_Checkbox",objectData);
	    clickOnButton(mainMenuData,"MainMenu_Release_Activities_NA_Checkbox_Checked","MainMenu_Release_Activities_NA_Checkbox",objectData);
	}
	
	public String getLoggedInUserName(String objectData) {
	     clickOnButton(objectData, "Login_FullName_Link");
	     return getTextData("LoggedIn_FullName", objectData);
	    }
	
	public void activitesBulkUpdate(String mainMenuData,String value,String objectData) {
		clickOnButton(mainMenuData, "MainMenu_Release_Activities_BulkUpdate_Button",objectData);
		clickOnButton(mainMenuData, "MainMenu_Release_Activities_BulkUpdate_Status_Dropdown",objectData);
		click("MainMenu_Release_Activities_BulkUpdate_Status_Dropdown_Option",value,mainMenuData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickOnButton(mainMenuData,"MainMenu_Release_Activities_BulkUpdate_SaveAndClose_Button",objectData);
		
	}
}
