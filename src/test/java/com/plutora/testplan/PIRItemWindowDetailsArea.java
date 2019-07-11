package com.plutora.testplan;


import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRItemWindowDetailsArea {
	PIRPage pirPage = new PIRPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();

	@Test (description="Sub-area: PIR Item window -> E/P/I releases availability in 'Impacted Release/ Projects' combobox")
	public void subareaPIRItemManagerDetailsArea_01() throws InterruptedException, ParseException {	

		//Add E/P/I
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		//Add Assign to Future Release/Project
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRReleaseProjectPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String pmReleaseName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Item_SearchedReleases_Text");
		String pmProjectName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Item_SearchedProject_Text");
		String pmIndependentName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Item_SearchedIndependent_Text");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_SearchedReleases_Text",pmReleaseName,PlutoraConfiguration.pirData);
		pirPage.verifyText("PIR_Item_SearchedProject_Text",pmProjectName,PlutoraConfiguration.pirData);
		pirPage.verifyText("PIR_Item_SearchedIndependent_Text",pmIndependentName,PlutoraConfiguration.pirData);
		Listener.addLogger("E/P/I releases available in 'Impacted Release/ Projects' combobox successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
	}

	@Test (description="Sub-area: PIR Item window -> Combobox 'Impacted Systems' (should be no inactive systems)")
	public void subareaPIRItemManagerDetailsArea_02() throws InterruptedException, ParseException {	
		//Create system
		systemsPage.refresh(PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);

		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRSystemAddPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//Add PM
		String pirItemSystemName=pirPage.getPIRItemAddedSystem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_AddedSystem_Text",pirItemSystemName,PlutoraConfiguration.pirData);
		Listener.addLogger("Combobox 'Impacted Systems' (should be no inactive systems) added successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		//delete pir item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		
		pirPage.waitForLoadingIconDisappear(1000,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(3000);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//delete release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//delete project release
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//delete independent release
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Item test data deleted successfully !");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
	}
	@Test (description="Sub-area: PIR Item window ->Top panel information (Raised By, Last Updated By)")
	public void subareaPIRItemManagerDetailsArea_03() throws InterruptedException, ParseException {	
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
		String raisedBy[]=pirPage.getAttributeValue("PIR_Item_RaisedBy_Text", PlutoraConfiguration.pirData, "data-qtip").split(" ");
		
		pirPage.verifyDate(raisedBy[5]+" "+raisedBy[6],pirPage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		Listener.addLogger("Raised by updated succeefully");
		
		pirPage.sleep(60000);
		pirPage.sendKeys("PIR_ItemSummaryTextField", PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR_Item_Automation"),PlutoraConfiguration.pirData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		String lastUpdatedBy[]=pirPage.getAttributeValue("PIR_Item_LastUpdated_Text", PlutoraConfiguration.pirData, "data-qtip").split(" ");
		pirPage.verifyDate(raisedBy[5]+" "+raisedBy[6], lastUpdatedBy[6]+" "+lastUpdatedBy[7]);
		Listener.addLogger("Last update by updated succeefully");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: PIR Item window -> Tour Assistant")
	public void subareaPIRItemManagerDetailsArea_04() throws InterruptedException, ParseException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		//Skip
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Instructions_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Skip_Button", PlutoraConfiguration.objectData);
		pirPage.verifyTextEqualsNotDisplayedInPage("Plutora’s Root Cause Analysis feature");
		Listener.addLogger("Tour Assistant - Skip button operated successfully !");
		//Start Tour & first Assistant
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Instructions_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_StartTour_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_AnalysisInterface_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant - Start tour operated successfully !");
		Listener.addLogger("Tour Assistant - Analysis Interface popup displayed successfully !");
		
		//Second Assistant
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Next_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_NewActions_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant - New Actions popup displayed successfully !");
		
		//Third Assistant
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Next_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_EditDetails_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant -  Edit Details popup displayed successfully !");
		
		//Fourth Assistant
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Next_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_OrganizeActions_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant - Organize your actions popup displayed successfully !");

		//Fifth Assistant
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Next_Button", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Prev_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_OrganizeActions_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant - Prev button operated successfully !");
		
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_Next_Button", PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_TourComplete_Text", PlutoraConfiguration.pirData);
		Listener.addLogger("Tour Assistant - Tour complete popup displayed successfully !");
		
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_EndTour_Button", PlutoraConfiguration.objectData);
		pirPage.verifyTextEqualsNotDisplayedInPage("Plutora’s Root Cause Analysis feature");
		Listener.addLogger("Tour Assistant - End tour operated successfully !");;
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: PIR Item window -> Audit")
	public void subareaPIRItemManagerDetailsArea_05() throws InterruptedException, ParseException {	
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
	
		pirPage.sendKeys("PIR_ItemSummaryTextField", PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR_Item_Automation"),PlutoraConfiguration.pirData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Modify
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		PIRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
			PIRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		PIRPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox","Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Item_Audit_PIRName_Text", "PIR_Item_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Added
		pirPage.addAttachment(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Attachment_NewButton");
		Listener.addLogger("Attachment added successfully !");
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox","Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Item_Audit_AddedAttachment_Text", CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ImageName"), PlutoraConfiguration.pirData,"");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Deleted
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
		pirPage.deleteAttachment(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		Listener.addLogger("Attachment deleted successfully !");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox","Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Item_Audit_DeletedAttachment_Text", CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ImageName"), PlutoraConfiguration.pirData,"");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox","Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*pirPage.scrollToElement("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		pirPage.scrollToElement("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		pirPage.scrollToElement("Audit_Modified_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Modified_Icon",  PlutoraConfiguration.objectData);*/
		
		//Live Search
		pirPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "PIR_Item_Automation",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		pirPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_Audit_PIRName_Text", PlutoraConfiguration.pirData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
	
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_Automation");
		pirPage.refresh(PlutoraConfiguration.objectData);
	}
	
}
