package com.plutora.testplan;


import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowDetailsTab {
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: release window ->Details tab ->  Add/delete/update phase/gate")
	public void subareaReleaseWindowDetailsTab_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//Verify
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		//Update Phase and gate
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"CountOfPG");
		Listener.addLogger("Added new phase/gates successfully !");
		//Edit Phase and gate
		releasePage.editPhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Updated new phase/gates successfully !");
		//Delete Phase and gate
		releasePage.deletePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Deleted new phase/gates successfully !");
		releasePage.sleep(2000);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.sleep(2000);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}

	@Test (description="Sub-area:release window -> Details tab -> Phases/gates bulk update")
	public void subareaReleaseWindowDetailsTab_02() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"CountOfPG");
		Listener.addLogger("Release phase/gate added successfully !");
		//Bulk update
		releasePage.addBulkUpdatePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
	}
	
	@Test (description="Sub-area:release window -> Details tab -> Release Type and Scheduler Color dependency")
	public void subareaReleaseWindowDetailsTab_03() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area:release window -> Details tab -> Attachments")
	public void subareaReleaseWindowDetailsTab_04() throws InterruptedException, ParseException, IOException, AWTException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.uploadImage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" uploaded file verified successfully !");
		
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Download 
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Attachment_Download_Icon", PlutoraConfiguration.objectData);
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"screenshot");
		Assert.assertTrue(!excelFile.isEmpty());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" Downloaded file verified successfully !");
		//Delete
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Attachment_Delete_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Yes_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" uploaded file deleted successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area:release window -> Details tab -> Phases duration (excluding weekends or blockout periods)")
	public void subareaReleaseWindowDetailsTab_05() throws InterruptedException, ParseException {	
		//Create Customization Phase Name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleasePhases_Option","Phase_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option", "Customization_PhasesGates_Enterprise_Default_Checkbox", "Phase_Name");
		//Disable Customization Weekends
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Disable_Workflow", "Customization_PGBlockout_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Verify Exclude weekdays option
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhase(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyReleasePhaseExcludeWeekendDaysOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name"),"dd/MM/yyyy", "10", 
				releasePage.getCountOfWeekDays(releasePage.getTodayDate("0", "dd/MM/yyyy"), releasePage.getTodayDate("10", "dd/MM/yyyy"),"dd/MM/yyyy"),"0");
		//Disable Customization blockout period
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Disable_Workflow", "Customization_PGWeekend_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Create blockout period
		new BlockoutPage().gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		new BlockoutPage().addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation","10");
		//Verify exclude blockout period
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.verifyReleasePhaseExcludeBlackoutOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name"),"dd/MM/yyyy", "-10", 20,"0");
		//Enable Customization blockout period
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Disable_Workflow", "Customization_PGBlockout_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		//Delete Customization phase name
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
		
	}
	@Test (description="Sub-area:release window -> Details tab -> Gates duration (excluding weekends or blockout periods)")
	public void subareaReleaseWindowDetailsTab_06() throws InterruptedException, ParseException {	
		//Create Customization Gate Name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseGates_Option","Gate_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option", "Customization_PhasesGates_Enterprise_Default_Checkbox", "Gate_Name");
		//Disable Customization Weekends
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Verify Exclude weekdays option
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyReleasePhaseExcludeWeekendDaysOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name"),"dd/MM/yyyy", "10", 
				releasePage.getCountOfWeekDays(releasePage.getTodayDate("0", "dd/MM/yyyy"), releasePage.getTodayDate("10", "dd/MM/yyyy"),"dd/MM/yyyy"),"0");
		
		//Disable Customization blockout period
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Disable_Workflow", "Customization_PGWeekend_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Create blockout period
		new BlockoutPage().gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		new BlockoutPage().addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation","10");
		//Verify exclude blockout period
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleasePhaseExcludeBlackoutOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name"),"dd/MM/yyyy", "-10", 20,"0");
		//Enable Customization blockout period
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Disable_Workflow", "Customization_PGBlockout_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		//Delete Customization gate name
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
		
	}
}
