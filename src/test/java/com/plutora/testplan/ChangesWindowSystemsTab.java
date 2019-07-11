package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ChangesWindowSystemsTab {
	ChangesPage changePage = new ChangesPage();
	SystemsPage systemsPage = new SystemsPage();
	
	@Test (description="Sub-area: change window -> Systems tab -> Drag and drop systems")
	public void subareaChangeWindowSystemsTab_01() throws InterruptedException, AWTException, ParseException {	

		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyText("Change_Page_Title","Change_Page_Title_Value",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Systems Tab */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Systems_Tab",
				PlutoraConfiguration.objectData);
		/* Clicking On New Systems */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_NewSystem_Button",
				PlutoraConfiguration.objectData);
		/* Switching Window */
		changePage.switchToWindow(4000,"parentWindow");
		changePage.driver.get(changePage.driver.getCurrentUrl());
		/* Creating New Change System */
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id1");
		systemsPage.closeWindowTab();
		systemsPage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parentWindow"));
		//changePage.createSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Systems Tab */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Systems_Tab",
				PlutoraConfiguration.objectData);
		/* Clicking On New Systems */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_NewSystem_Button",
				PlutoraConfiguration.objectData);
		/* Switching Window */
		changePage.switchToWindow(4000,"parentWindow");
		changePage.driver.get(changePage.driver.getCurrentUrl());
		/* Creating New Change System */
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id2");
		systemsPage.closeWindowTab();
		systemsPage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parentWindow"));

		//changePage.createSystem2(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//system 1
		changePage.searchSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//system 2
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.searchSystem2(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedSystem2(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.getSystemPage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyText("Change_Systems_ImpactedArea_SystemLink", "Systems_Test_Automation_Id1",PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changePage.verifyText("Change_Systems_RiskArea_SystemLink", "Systems_Test_Automation_Id2",PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		Listener.addLogger("Systems are added accordingly to selected panels successfully !.");
		//drag right to left
		changePage.dragBackCreatedSystems(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.getSystemPage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//system1
		changePage.searchSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyText("Change_Systems_Searched_DataLink", "Systems_Test_Automation_Id1",PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		//system2
		changePage.searchSystem2(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyText("Change_Systems_Searched_DataLink", "Systems_Test_Automation_Id2",PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		Listener.addLogger("On Remove Systems by dragging them back into left-hand 'Systems Available' panel, Systems are appeared in 'Systems Available' list.");	
		
	}
	
}
