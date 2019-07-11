package com.plutora.testplan;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.MainMenuPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class MainMenu {
	DeploymentPage deploymentPlanPage= new DeploymentPage();
	ReleasePage releasePage =new ReleasePage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ChangesPage changesPage = new ChangesPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	MainMenuPage mainMenuPage = new MainMenuPage();
	SystemsPage systemsPage = new SystemsPage();
	PIRPage pirPage = new PIRPage();
	BlockoutPage blockoutPage = new BlockoutPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	
	
	@Test (description=" -> Live Search")
	public void mainMenu_01() throws InterruptedException, ParseException   {
		
		//Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" - Enterprise release is created successfully !");
		
		//Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project release is created successfully !");
		
		//Independent Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation", "Independent_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" - Independent release is created successfully !");
		
		//Change
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_Automation");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" - Change is created successfully !");
		
		//System
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
		
		//TECR
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" - TECR is created from Top Panel successfully !");
		
		//TEBR
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" - TEBR is created from Top Panel successfully !");
		
		//Environment
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment created successfully !");
		
		//Blockout Period
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Automation")+" - Blockout Period created successfully !");
		
		//Environment verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.verifyText("Environment_SubTitle", "Environment_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment details page displayed successfully !");
		environmentPage.clickElementUsingJavaScript("Environment_Details_Close_Icon","Environment_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//TEBR verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.waitForLoadingIconDisappear(400,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.verifyTextContains("TEBR_SubTitle", "TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" - TEBR details page displayed successfully !");
		tebrPage.clickElementUsingJavaScript("TEBR_Close_Icon", PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//TECR verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		tecrPage.verifyTextContains("TECR_SubTitle", "TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" - TECR details page displayed successfully !");
		tecrPage.clickElementUsingJavaScript("TECR_Close_Icon", PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//System verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		//systemsPage.verifyTextContains("Systems_SubTitle", "Systems_Automation",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System details page displayed successfully !");
		//systemsPage.clickElementUsingJavaScript("Systems_Close_Icon",PlutoraConfiguration.systemsData);
		systemsPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//Change verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.verifyTextContains("Change_SubTitle_Text", "Change_Automation",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" - Change details page displayed successfully !");
		changesPage.clickElementUsingJavaScript("Change_Close_Icon","Change_Automation", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//Independent verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Independent_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" - Independent details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		//Project verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		//Enterprise verification
		mainMenuPage.searchItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" - Enterprise details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
	}
	
	@Test (description=" -> Recent Items")
	public void mainMenu_02() throws InterruptedException{	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name","Activity_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" added successfully !");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Name","Criteria_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" added successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Test_Automation_Name");
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Activity_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" - Release activity details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Activity_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Test_Automation_Name");
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Criteria_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" - Release criteria details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Activity_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" - Enterprise details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.verifyTextContains("Release_SubTitle", "Independent_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" - Independent details page displayed successfully !");
		releasePage.clickElementUsingJavaScript("Release_Close_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.verifyTextContains("Change_SubTitle_Text", "Change_Automation",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" - Change details page displayed successfully !");
		changesPage.clickElementUsingJavaScript("Change_Close_Icon","Change_Automation", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		//systemsPage.verifyTextContains("Systems_SubTitle", "Systems_Automation",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System details page displayed successfully !");
		//systemsPage.clickElementUsingJavaScript("Systems_Close_Icon",PlutoraConfiguration.systemsData);
		systemsPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		tecrPage.verifyTextContains("TECR_SubTitle", "TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" - TECR details page displayed successfully !");
		tecrPage.clickElementUsingJavaScript("TECR_Close_Icon", PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.waitForLoadingIconDisappear(400,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.verifyTextContains("TEBR_SubTitle", "TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" - TEBR details page displayed successfully !");
		tebrPage.clickElementUsingJavaScript("TEBR_Close_Icon", PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.verifyText("Environment_SubTitle", "Environment_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment details page displayed successfully !");
		environmentPage.clickElementUsingJavaScript("Environment_Details_Close_Icon","Environment_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation");
		blockoutPage.clickElementUsingJavaScript("Blockout_Close_Icon", PlutoraConfiguration.blockoutData);
		
		mainMenuPage.recentItem(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		blockoutPage.verifyTextAttributeValue("Blockout_NameTextfield", "Blockout_Automation",PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Automation")+" - Blockout details page displayed successfully !");
		blockoutPage.clickElementUsingJavaScript("Blockout_Close_Icon", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		/*blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Automation")+" deleted successfully ! ");*/
		
	}
	@Test (description=" -> Your Release Activities (My PIR Actions)")
	public void mainMenu_03() throws ParseException, InterruptedException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item")+" created successfully !");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item");
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action");
		pirPage.updatePIRActionAssignee(PlutoraConfiguration.pirData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action","Open","Loggedin_Username_Value");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item")+" updated assignee & status successfully !");
		
		mainMenuPage.clickOnMyPIRActions(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.closeDefaultPIRStatus(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.selectPIRStatus(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData, "Open");
		
		mainMenuPage.verifyText("MainMenu_MyPIRActions_Name", "PIR_Item_Action",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")+" - displayed in My PIR Actions page successfully !");
		mainMenuPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.mainMenuData, "MainMenu_MyPIRActions_ItemIdentifier_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")), PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Action_Identifier"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Action_Identifier")+" - displayed in My PIR Actions page successfully !");
		mainMenuPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.mainMenuData, "MainMenu_MyPIRActions_Status_Text").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")), "Open");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")+" - Status - "+" Open "+" displayed in My PIR Actions page successfully !");
		
		boolean flag = MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")+"')]/ancestor::td/following-sibling::td/div[contains(text(),'"+mainMenuPage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")+" - "+mainMenuPage.getTodayDate("0", "dd/MM/yyyy")+" -  due date displayed in My PIR Actions page successfully !");
		
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_MyPIRActions_Close_Icon", PlutoraConfiguration.objectData);
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item")+" created successfully !");
		
		mainMenuPage.clickOnMyPIRActions(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action"));
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_MyPIRActions_Close_Icon", PlutoraConfiguration.objectData);
		
		mainMenuPage.refresh(PlutoraConfiguration.objectData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action")+" not displayed in My PIR actions page successfully !");
	}
	@Test (description=" -> Your Release Activities (Release Activities) ")
	public void mainMenu_04() throws ParseException, InterruptedException {	
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Create Enterprise
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		//Create Project 
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		//Add dependency 
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation_Name");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Add stakeholder
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//Add activity1
		//releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Id_1","Activity_Name_1");
		//Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_1")+" added successfully !");
		//Update activity status
		//releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Activity_Id_1");
		releasePage.createActivityActualCompletedDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Id_1", "Activity_Name_1", "Completed", "Releases_AddNewActivity_Option");
		
		//Add activity2
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Id_2","Activity_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_2")+" added successfully !");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Id_2");
		//Add activity3
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Id_3","Activity_Name_3");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_3")+" added successfully !");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "In Progress", "0", "Activity_Id_3");
		//Add activity4
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Id_4","Activity_Name_4");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_4")+" added successfully !");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "N/A", "0", "Activity_Id_4");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		mainMenuPage.clickOnReleaseActivitiesTab(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.clickOnActivityStatus(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		//Search enterprise Name
		mainMenuPage.sendKeys("MainMenu_Release_Activities_Enterprise_Textbox","Enterprise_Automation",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		mainMenuPage.sleep(3000);
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+"')]/ancestor::td/preceding-sibling::td//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"')]")).click();
		
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Activity_Id_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_1")+" verified successfully !");;
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Close_Icon",PlutoraConfiguration.objectData);
		
		//Search project Name
		mainMenuPage.sendKeys("MainMenu_Release_Activities_NonEnterprise_Textbox","Project_Automation",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		mainMenuPage.sleep(3000);
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+"')]/ancestor::td/preceding-sibling::td//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"')]")).click();
		
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Activity_Id_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_1")+" verified successfully !");;
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Close_Icon",PlutoraConfiguration.objectData);
		
		//Search activity title
		mainMenuPage.sendKeys("MainMenu_Release_Activities_Title_Textbox","Activity_Name_1",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		mainMenuPage.sleep(3000);
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+"')]")).click();
		
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Activity_Id_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Id_1")+" verified successfully !");;
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Close_Icon",PlutoraConfiguration.objectData);
		//Click on due date
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Release_Activities_DueDate_Label",PlutoraConfiguration.objectData);
		mainMenuPage.validateElementDisplayed("MainMenu_Release_Activities_DueDate_Text",mainMenuPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.mainMenuData);
		
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Release_Activities_Title_Clear_Icon",PlutoraConfiguration.objectData);
		
		//Click On status & verify
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Release_Activities_Status_Label",PlutoraConfiguration.objectData);
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+"')]/ancestor::td/following-sibling::td//div[text()='3']")).isDisplayed();
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_2")+"')]/ancestor::td/following-sibling::td//div[text()='1']")).isDisplayed();
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_3")+"')]/ancestor::td/following-sibling::td//div[text()='2']")).isDisplayed();
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_4")+"')]/ancestor::td/following-sibling::td//div[text()='4']")).isDisplayed();
		
		//Bulk Update
		mainMenuPage.clickButton("MainMenu_Release_Activities_Checkbox","Activity_Name_1",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		mainMenuPage.clickButton("MainMenu_Release_Activities_Checkbox","Activity_Name_2",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		mainMenuPage.activitesBulkUpdate(PlutoraConfiguration.mainMenuData, "Completed", PlutoraConfiguration.objectData);
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+"')]/ancestor::td/following-sibling::td//div[text()='3']")).isDisplayed();
		MainMenuPage.driver.findElement(By.xpath("//a[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_2")+"')]/ancestor::td/following-sibling::td//div[text()='3']")).isDisplayed();
		
		mainMenuPage.refresh(PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> User Menu (External URL Menu Item, Profile, Settings, Help, Logout)")
	public void mainMenu_05() throws ParseException, InterruptedException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableExternalURLMenuItem(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ExternalURLMenuItem_Option", PlutoraConfiguration.applicationURL);
		String parentWindow = WebGenericUtilLib.driver.getWindowHandle();
		
		mainMenuPage.refresh(PlutoraConfiguration.objectData);
		//Verify external url menu item
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.verifyText("MainMenu_ExternalUrlMenuItem_MenuLabel_Text", "Plutora",PlutoraConfiguration.mainMenuData);
		Listener.addLogger("Menu label - Plutora displyed in menu successfully !");
		mainMenuPage.click("MainMenu_ExternalUrlMenuItem_MenuLabel_Text", "Plutora", PlutoraConfiguration.mainMenuData);
		mainMenuPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		mainMenuPage.sleep(2000);
		//Switch to new window
		mainMenuPage.switchToWindowPopup();
		
		mainMenuPage.verifyTextValue(mainMenuPage.getCurrentUrl(), PlutoraConfiguration.applicationURL+"settings/customization");
		Listener.addLogger("Menu label "+mainMenuPage.getCurrentUrl()+" is equal to "+PlutoraConfiguration.applicationURL+"settings/customization");
		//Close the window 
		mainMenuPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.disableExternalURLMenuItem(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ExternalURLMenuItem_Option");
		
		//Profile
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Profile_Option", PlutoraConfiguration.objectData);
		//First Name verification
		mainMenuPage.verifyTextAttributeValue("MainMenu_Profile_FirstName_Text", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value").split(" ")[0],PlutoraConfiguration.mainMenuData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value").split(" ")[0]+" is displayed in Profile page successfully ! ");
		//Lastname verification
		mainMenuPage.verifyTextAttributeValue("MainMenu_Profile_LastName_Text", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value").split(" ")[1],PlutoraConfiguration.mainMenuData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value").split(" ")[1]+" is displayed in Profile page successfully ! ");
		//Email Verification
		mainMenuPage.verifyTextAttributeValue("MainMenu_Profile_Username_Text", "Login_Email_Textfield_Value", PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Login_Email_Textfield_Value")+" updated in Profile page successfully !");
		//Update Phone Number & Location 
		mainMenuPage.sendKeys("MainMenu_Profile_PhoneNumber_Textbox", "Loggedin_Username_PhoneNumber",PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		mainMenuPage.doubleClick("MainMenu_Profile_Location_Dropdown",PlutoraConfiguration.mainMenuData);
		mainMenuPage.sleep(2000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"Location_Name",mainMenuPage.getTextData("MainMenu_Profile_Location_Dropdown_Option", PlutoraConfiguration.mainMenuData));
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Profile_Location_Dropdown_Option", PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Save&Close_Button", PlutoraConfiguration.objectData);
		//Verify Location and Phone Number
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Profile_Option", PlutoraConfiguration.objectData);
		
		mainMenuPage.verifyTextAttributeValue("MainMenu_Profile_PhoneNumber_Textbox", "Loggedin_Username_PhoneNumber", PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_PhoneNumber")+" updated in Profile page successfully !");
		
	//	mainMenuPage.verifyTextAttributeValue("MainMenu_Profile_Location_Textbox", "Location_Name", PlutoraConfiguration.mainMenuData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Location_Name")+" updated in Profile page successfully !");
		
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Save&Close_Button", PlutoraConfiguration.objectData);
		
		//Password & TimeZone
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_PasswordAndTimezone_Option", PlutoraConfiguration.objectData);
		mainMenuPage.verifyText("MainMenu_Profile_TimezoneDate_Text", mainMenuPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.mainMenuData);
		Listener.addLogger(mainMenuPage.getTodayDate("0", "dd/MM/yyyy")+" updated in Password and Timezone successfully !");
		
		mainMenuPage.clickOnButton(PlutoraConfiguration.mainMenuData, "MainMenu_Profile_Timezone_Close_Icon", PlutoraConfiguration.objectData);
		
		//help
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.click("MainMenu_Help_Option",PlutoraConfiguration.mainMenuData);
		mainMenuPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		mainMenuPage.sleep(2000);
		//Switch to new window
		mainMenuPage.switchToWindowPopup();
		mainMenuPage.sleep(1000);
		
		mainMenuPage.verifyTextValue(mainMenuPage.getCurrentUrl(), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Plutora_Help_Url"));
		Listener.addLogger("Help option  "+mainMenuPage.getCurrentUrl()+" is equal to "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Plutora_Help_Url"));
		//Close the window 
		mainMenuPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		
		
		//Logout 
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
	}
	@Test (description=" -> Avatar")
	public void mainMenu_06() throws ParseException, InterruptedException, IOException, AWTException {	
		//Change avatar image 
		mainMenuPage.addNewAvatarImage(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.validateElementDisplayed("MainMenu_NewAvatar_Icon",PlutoraConfiguration.mainMenuData);
		Listener.addLogger("Added and verified new avatar image successfully !");
		//Change default avatar image
		mainMenuPage.addDefaultAvatarImage(PlutoraConfiguration.mainMenuData, PlutoraConfiguration.objectData);
		mainMenuPage.refresh(PlutoraConfiguration.objectData);
		mainMenuPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		mainMenuPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		mainMenuPage.validateElementDisplayed("MainMenu_DefaultAvatar_Icon",PlutoraConfiguration.mainMenuData);
		Listener.addLogger("Default avator image verified successfully !");
	}
}
