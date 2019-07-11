package com.plutora.testplan;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindow {
	ReleasePage releasePage = new ReleasePage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	DeploymentPage deploymentPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area:release window -> Linked Releases")
	public void subareaReleaseWindow_01() throws InterruptedException, ParseException {	
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Independent_Automation", "Independent_Automation_Name", "0");
	
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		//Add Relates to
		releasePage.addRelatesToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation","Independent_Automation_Name");
		//Add Parent to
		releasePage.addParentToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation","Independent_Automation_Name");
		//Add Child Of
		releasePage.addChildOfRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation","Enterprise_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area:release window -> Add to Favorites")
	public void subareaReleaseWindow_02() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("Release added to Favorites List successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.validateElementDisplayed("Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("Release verified from Favorites List successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("Release removed from Favorites List successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.validateElementDisplayed("Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("Release verified from Favorites List after removal successfully !");
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Sub-area:release window -> Audit")
	public void subareaReleaseWindow_03() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "Enterprise_Automation_1"),PlutoraConfiguration.releasesData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//Modify
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		try {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		ReleasePage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Modified_Checked_Checkbox","Release_Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_ReleaseName_Text", "Enterprise_Automation_1", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Added
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Added_Checked_Checkbox","Release_Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_Stakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		releasePage.removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name","Releases_Remove_Stakeholder_Button");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Deleted_Checked_Checkbox","Release_Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_DeletedStakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_All_Checked_Checkbox","Release_Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
	/*	releasePage.scrollToElement("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);*/
		
		//Live Search
		releasePage.sendKeysWithEnter("Release_Audit_Live_Search_Textbox", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Audit_Live_Search_Text", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.refresh(PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area:release window -> Soft delete enterprise release")
	public void subareaReleaseWindow_04() throws InterruptedException, ParseException {	
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
				
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Systems_CodeImplementation_Section","");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" created successfully !");
		//TECR Creation
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id","Enterprise_Automation","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" created with release integration successfully !");
		//TEBR Creation
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation","Systems_Automation","TEBR_Test_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" created with release integration successfully !");
		//Deployment plan Creation
		deploymentPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Automation", "Enterprise_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" created with release integration successfully !");
		//Delete Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" deleted successdully !");
		//TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" displayed successfully in TECR page!");
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" displayed successfully in TECR page !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		//TEBR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" displayed successfully in TEBR page !");
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" displayed successfully in TEBR page !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Deployment Plan
		deploymentPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" displayed successfully in Deployment Plan page !");
		deploymentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" displayed successfully in Deployment Plan page !");
		deploymentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area:release window -> Soft delete non-enterprise release")
	public void subareaReleaseWindow_05() throws InterruptedException, ParseException{	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//Create Project release
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" created successfully !");
		//Create Independent release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation", "Independent_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" created successfully !");
		List<String> releaseName=releasePage.addNonEnterpriseReleaseNameToList("Project_Automation", "Independent_Automation");
		
		for(int i=0;i<releaseName.size();i++) {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, releaseName.get(i));
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, releaseName.get(i));
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData,  releaseName.get(i).split("_")[0]+"_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);		
		environmentPage.sleep(2000);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id", releaseName.get(i),"");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" created with release integration successfully !");
		tecrPage.sleep(1000);
		//TEBR Creation
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,releaseName.get(i),"Systems_Automation","TEBR_Test_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" created with release integration successfully !");
		//Deployment plan Creation
		deploymentPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Automation", releaseName.get(i)+"_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" created with release integration successfully !");
		
		//Delete Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,releaseName.get(i));
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,releaseName.get(i));
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i))+" deleted successdully !");
		//TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i))+" displayed successfully in TECR page!");
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name")+" displayed successfully in TECR page !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		//TEBR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i))+" displayed successfully in TEBR page !");
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name")+" displayed successfully in TEBR page !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Deployment Plan
		deploymentPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i))+" displayed successfully in Deployment Plan page !");
		deploymentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, releaseName.get(i)+"_Name")+" displayed successfully in Deployment Plan page !");
		deploymentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		}
	}
	
	@Test (description="Visual View(Phase and Gate) button on the right top")
	public void subareaReleaseWindow_06() throws InterruptedException, ParseException  {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_FlagIcon",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_GA_Header","Releases_Gates&ApprovalHeader_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty("Releases_Gates&ApprovalHeader_Value", PlutoraConfiguration.testData)+" title displayed successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_GA_GatesButton", PlutoraConfiguration.releasesData);
		Listener.addLogger("Gates are displayed successfuly !");
	}
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaReleaseWindow_07() throws InterruptedException, AWTException, HeadlessException, UnsupportedFlavorException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.click("Releases_CopyURL_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_IDTextfield", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" redirected to release details page after performing copy URL to clipboard for logged in session successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		releasePage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		releasePage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
	}
	@Test (description="Release package combobox on the right top \n" + 
			"(it should display applicable release packages from Customization)")
	public void subareaReleaseWindow_08() throws InterruptedException, ParseException {	
		customizationPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleasePackage_Option","Package_Name_1");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleasePackage_Enable", "Customization_ReleasePackage_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.editReleasePackageDate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_1", "2");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1")+" created successfully !");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleasePackage_Option","Package_Name_2");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleasePackage_Enable", "Customization_ReleasePackage_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.editReleasePackageDate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_2", "2");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+" created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Package_Icon", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Package_List_Text","Package_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1")+" displayed in release details page successfully !");
		releasePage.validateElementDisplayed("Release_Package_List_Text","Package_Name_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+" displayed in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePackage_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+" created successfully !");
		customizationPage.deletePackageCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+" deleted successfully !");
	}
	
}
