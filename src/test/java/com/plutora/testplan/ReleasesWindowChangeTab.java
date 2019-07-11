package com.plutora.testplan;


import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowChangeTab {
	ReleasePage releasePage = new ReleasePage();
	ChangesPage changePage = new ChangesPage();
	SystemsPage systemsPage = new SystemsPage();
	
	@Test (description="Sub-area:release window -> Change (Project release) -> Drag and drop left<->right part")
	public void subareaReleaseWindowChangeTab_01() throws InterruptedException, ParseException {
		
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - System is created successfully !");
		//Change creation	
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//Link system
		changePage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation");
		//Release creation
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");

		releasePage.click("Releases_Applications_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		releasePage.verifyText("Releases_SystemsName_Text","System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag and dropped successfully !");
		releasePage.verifyText("Releases_SystemsName_Text","System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems id and System name is verified after drag and dropped successfully !");
		releasePage.clickElementUsingJavaScript("AddRelease_SaveButton",PlutoraConfiguration.releasesData);
		
		releasePage.click("Releases_Change_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Change_Name_Section", "Releases_Change_Project_Release_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Change is drag and dropped successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		Listener.addLogger("Change id and Change name is verified after drag and dropped successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger("Releases saved successfully !");
	}
	@Test (description="Sub-area:release change window -> Filter by ID or Name")
	public void subareaReleaseWindowChangeTab_02() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.click("Releases_Change_Tab",PlutoraConfiguration.releasesData);
		releasePage.click("Releases_Change_LiveSearch_System_Dropdown",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Releases_Change_LiveSearch_System_Dropdown_Option", "System_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.sendKeys("Releases_Change_LiveSearch_Textbox","Change_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation"));
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.dragAndDrop("Releases_Change_Name_Section", "Releases_Change_Project_Release_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		releasePage.click("Releases_ChangeProject_LiveSearch_System_Dropdown",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Releases_ChangeProject_LiveSearch_System_Dropdown_Option", "System_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.sendKeys("Releases_ChangeProject_LiveSearch_Textbox","Change_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area:release change window -> Filter by system")
	public void subareaReleaseWindowChangeTab_03() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.click("Releases_Change_Tab",PlutoraConfiguration.releasesData);
		
		releasePage.click("Releases_Change_LiveSearch_System_Dropdown",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Releases_Change_LiveSearch_System_Dropdown_Option", "System_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.enter();
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation"));
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.dragAndDrop("Releases_Change_Name_Section", "Releases_Change_Project_Release_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		releasePage.click("Releases_ChangeProject_LiveSearch_System_Dropdown",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Releases_ChangeProject_LiveSearch_System_Dropdown_Option", "System_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.enter();
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
	}
	@Test (description="Sub-area:release change window -> Hyperlink to changes")
	public void subareaReleaseWindowChangeTab_04() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Change_Tab",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.doubleClick("Releases_ChangeProject_Name", "Change_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Change_Tab", PlutoraConfiguration.objectData);
		changePage.refresh(PlutoraConfiguration.objectData);
		//releasePage.verifyTextAttributeValue("Change_Release_Name_Textfield", "Change_Automation",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" deleted successfully ! ");
	
		//Delete Change
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" verified successfully ! ");
		changePage.deleteChange(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		
	}
	@Test (description="Sub-area:release change window -> New Change")
	public void subareaReleaseWindowChangeTab_05() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Change_Tab",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_NewChange_Button", PlutoraConfiguration.objectData);

		changePage.createReleaseChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" created successfully ! ");
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Release_SaveAndClose_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" verified successfully ! ");
		changePage.deleteChange(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" deleted successfully ! ");
		
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" deleted successfully ! ");
		
	}
}
