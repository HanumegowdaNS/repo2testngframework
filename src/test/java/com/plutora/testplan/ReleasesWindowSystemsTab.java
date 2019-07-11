package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.OrganizationStructurePage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowSystemsTab {
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	OrganizationStructurePage organizationStructurePage = new OrganizationStructurePage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	
	@Test (description="Sub-area:release window -> Systems (enterprise release) -> Drag and drop left<->right part")
	public void subareaReleaseWindowSystemsTab_01() throws InterruptedException, AWTException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description=" 1. Sub-area: release window ->Systems tab -> Deployment Dates window (+Audit) 2. Impacted/regression systems grid - \n" + 
			"'Paper Based', 'Deployment Type', 'Deployment Date' columns")
	public void subareaReleaseWindowSystemsTab_02() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.addEnterpriseDeploymentDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.validateDeploymentAudit();
		Listener.addLogger("Deployment date window validated successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	
	@Test (description="Sub-area: release window ->Systems tab -> Impacted/regression systems grid - ability to comment system ")
	public void subareaReleaseWindowSystemsTab_03() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.verifySystemComment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("System comment is validated successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Live search by portfolio association or by system ")
	public void subareaReleaseWindowSystemsTab_04() throws InterruptedException {	
		
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData, "OrganizationStructure_Company_Name", PlutoraConfiguration.objectData);
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Name");
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System is created successfully !");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.updatePortfolioAssociation(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name","");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.searchPortfolioAssociation(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Name","Release_System_PortfolioAssociation_Dropdown");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System is verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Hyperlink to systems")
	public void subareaReleaseWindowSystemsTab_05() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.searchPortfolioAssociation(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Name","Release_System_PortfolioAssociation_UpdateDropdown");
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System is verified after dropped to code implementation area successfully !");
		releasePage.clickButton("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releasePage.switchToWindow(4000, "parentWindow");
		ReleasePage.driver.get(ReleasePage.driver.getCurrentUrl());
		systemsPage.clickElementUsingJavaScript("Systems_Action_Button", PlutoraConfiguration.systemsData);
		systemsPage.sleep(2000);
		systemsPage.clickElementUsingJavaScript("Systems_Delete_Button",PlutoraConfiguration.systemsData);
		systemsPage.sleep(1000);
		systemsPage.click("Systems_Yes_Button",PlutoraConfiguration.systemsData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - deleted successfully !");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - not displayed successfully !");
		
		releasePage.closeWindowTab();
		ReleasePage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData,"parentWindow"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData, "OrganizationStructure_Company_Name", PlutoraConfiguration.objectData);
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Reassign_Name");
		organizationStructurePage.deleteReassignOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name", "Organization_Reassign_Name");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_Organization_Textbox", "Organization_Reassign_Name", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name","AddRelease_Organistion_Option_Value");
		
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.deleteOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Reassign_Name");
		
	}
	
	@Test (description="New System")
	public void subareaReleaseWindowSystemsTab_06() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" System verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Systems subtypes feature\n" + 
			"(custom types should have 'impacted system' behavior, i.e. Deployment Dates)")
	public void subareaReleaseWindowSystemsTab_07() throws InterruptedException {	
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option", "Subtype_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option", "Customization_ReleaseSystem_Subtype_Enabled_Checkbox", "Subtype_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_EnterpriseSystems_Subtype_Section","Subtype_Name");
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" System is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option");
		customizationPage.deleteCustomsReleaseSystemsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Subtype_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is not displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	
}
