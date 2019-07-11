package com.plutora.testplan;


import java.awt.AWTException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class EnvironmentRequest {
	
	TECRPage tecrPage = new TECRPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	TEBRPage tebrPage = new TEBRPage();
	
	@Test (description="New TECR from top panel button")
	public void subareaEnvironmentRequest_01() throws InterruptedException {	
		WebGenericUtilLib.driver.navigate().refresh();
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is created from Top Panel successfully !");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.updateTECRByName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is updated successfully !");
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is deleted successfully !");
	}
	@Test (description="New TECR from main menu")
	public void subareaEnvironmentRequest_02() throws InterruptedException {	
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is created from main menu successfully !");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.updateTECRByName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is updated successfully !");
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is deleted successfully !");
	}
	@Test (description="New TEBR from top panel button")
	public void subareaEnvironmentRequest_03() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is created from Top Panel successfully !");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.updateTEBRByName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is updated successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is deleted successfully !");
	}
	@Test (description="New TEBR from main menu")
	public void subareaEnvironmentRequest_04() throws InterruptedException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is created from main menu successfully !");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.updateTEBRByName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is updated successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is deleted successfully !");
	}
	
	@Test (description="TECR Maintenance Bench button")
	public void subareaEnvironmentRequest_05() throws InterruptedException, AWTException {	
		
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" - Environment group is created successfully !");
		tecrPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		new ReleasePage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		new ReleasePage().newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new ReleasePage().createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		tecrPage.verifyTextAttributeValue("TECR_Maintenance_Bench_ParentReleaseId_Textbox", "Release_Test_Automation_Id", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.verifyTextAttributeValue("TECR_Maintenance_Bench_ParentReleaseName_Textbox", "Release_Test_Automation_Name", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.sleep(2000);
		tecrPage.verifyTextAttributeValue("TECR_Maintenance_Bench_ReleaseId_Textbox", "PRelease_Automation_Id", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.verifyTextAttributeValue("TECR_Maintenance_Bench_ReleaseName_Textbox", "PRelease_Automation_Name", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.sleep(2000);
		tecrPage.verifyTextContains("TECR_Maintenance_Bench_ReleaseId_Information", "PRelease_Automation_Id",PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.verifyTextContains("TECR_Maintenance_Bench_SystemId_Information", "Systems_Test_Automation_Id",PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.sleep(2000);
		Listener.addLogger("Verified TECR maintenance bench popup successfully !");
		tecrPage.click("TECR_Save&CloseButton",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(1000);
	}
	
	//@Test (description="New TECR from '+New' menu")
	public void subareaEnvironmentRequest_06() throws InterruptedException {	
		tecrPage.getTECRDetilsPageFromNewMenu(PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is created from main menu successfully !");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.updateTECRByName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is updated successfully !");
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" - TECR is deleted successfully !");
	}
	
	//@Test (description="New TEBR from '+New' menu")
	public void subareaEnvironmentRequest_07() throws InterruptedException {
		tebrPage.getTEBRDetilsPageFromNewMenu(PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is created from main menu successfully !");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.updateTEBRByName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is updated successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is deleted successfully !");
	}
	
	@Test (description="Metrics")
	public void subareaEnvironmentRequest_08() throws InterruptedException, AWTException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Get metrix chart
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_HideIcon","Metrics_ViewIcon", PlutoraConfiguration.objectData,"xpath");
		//Verify metrics 
		environmentPage.verifyText("EnvironmentRequest_Metrics_RequestAction","Environment_Requests_Actioned_Text",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("EnvironmentRequest_Metrics_OutstandingRequests","Environment_Outstanding_Requests_Text",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.validateElementDisplayed("EnvironmentRequest_Metrics_RequestAction_Graph", PlutoraConfiguration.environmentData);
		environmentPage.validateElementDisplayed("EnvironmentRequest_Metrics_OutstandingRequests_Graph", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment Request grid metrics verified successfully!");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_ViewIcon","Metrics_HideIcon", PlutoraConfiguration.objectData,"xpath");
	}
	
	
	
	
}
