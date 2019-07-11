package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.InitiativePage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationEmails {
	CustomizationPage customizationPage = new CustomizationPage();
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	NewUserPage userPage = new NewUserPage();
	ReleasePage releasePage = new ReleasePage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	ChangesPage changePage = new ChangesPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	DeploymentPage deploymentPage = new DeploymentPage();
	PIRPage pirPage = new PIRPage();
	SystemsPage systemPage = new SystemsPage();
	InitiativePage initiativePage = new InitiativePage();
	EnvironmentGroupsPage environmentGroupPage =new EnvironmentGroupsPage();
	

	@Test (description=" -> Email Template Wizard (ability to create/edit/delete templates, drag and drop on 3rd tab)")
	public void customizationEmails_01() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email","Releases_UserGroup_Name","Deployment Plan","Broadcast remaining duration");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Email")+" - Email Template is added successfully !");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Email")+" Email Template is verified successfully !");
		customizationPage.updateEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_Email");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Email")+" Email Template is updated successfully !");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Email")+" - Deleted successfully");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);		
	}
	@Test (description=" -> Ability to receive email on Release (All triggers)")
	public void customizationEmails_02() throws InterruptedException, ParseException  {
		//Create Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		//Release - Implementation Date updated
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_Release_ImplementationDate","Releases_UserGroup_Name","Release","Implementation date updated");
		//Update implementation date
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.updateImplementationDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"10");
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Release_ImplementationDate", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Ability to receive email on Release Activities (All triggers)")
	public void customizationEmails_03() throws InterruptedException, ParseException  {
		//Add Stakeholder
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//Create activity
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Activity","Activity_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Add email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_Release_Activity","Releases_UserGroup_Name","Release Activities","Status updated");
		//Update status
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.updateCriteriaStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"In Progress","0","Release_Activity");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Release_Activity",  PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
	
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Ability to receive email on TECR (All triggers)")
	public void customizationEmails_04() throws InterruptedException, ParseException  {
		//Create TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Add Email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_TECR_Status","Releases_UserGroup_Name","TECRs","Status updated");
		//TECR - Status update
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.clickOnTECRField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTECR_StatusDropdown", "AddTECR_StatusSecond");
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_TECR_Status", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");

	}
	@Test (description=" -> Ability to receive email on TEBR (All triggers)")
	public void customizationEmails_05() throws InterruptedException, ParseException  {
		//Create TEBR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Add Email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_TEBR_Status","Releases_UserGroup_Name","TEBRs","Status changed");
		//TEBR - Status update
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.clickOnTEBRField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTEBR_StatusDropdown", "AddTEBR_StatusSecond");
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_TEBR_Status", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete TEBR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		
	}
	@Test (description=" -> Ability to receive email on Changes (All triggers)")
	public void customizationEmails_06() throws InterruptedException, ParseException  {
		//Create change
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//Add Email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_Change_Status","Releases_UserGroup_Name","Changes","Status updated");
		//Change - Status update
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		changePage.clickOnChangeField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Dropdown", "Change_Status_SecondOption");
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Change_Status", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete change
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Ability to receive email on Deployment Plan (All triggers)")
	public void customizationEmails_07() throws InterruptedException, ParseException, AWTException  {
		//Add release, System and Link system to release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation","Project_Automation_Name","0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Create deployment plan
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","System_Automation","Project_Automation_Name","Loggedin_Username_Value");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation", "Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan Activity is added successfully");
		//Add Email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_DeploymentPlan_BRD","Releases_UserGroup_Name","Deployment Plan","Broadcast remaining duration");
		//Deployment Plan - Update Broadcast remaining duration
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan is moved from draft to execution successfully");
		
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Broadcast_Remaining_Duration_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_DeploymentPlan_BRD", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete deployment Plan 
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		
		//Delete Release 
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		//Delete system
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		

	}
	@Test (description=" -> Ability to receive email on PIR (All triggers)")
	public void customizationEmails_08() throws InterruptedException, ParseException  {
		//Create PIR
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName,"PIR_Automation");
		
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_PIR_Status","Releases_UserGroup_Name","PIR","Status updated");
	
		//PIR - update status
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Yes_Button", PlutoraConfiguration.objectData);
		pirPage.clickOnPIRField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddPIR_StatusDropdown", "AddPIR_Status_SecondOption");
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_PIR_Status", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete PIR
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		
	}
	@Test (description=" -> Ability to receive email on PIR Item (All triggers)")
	public void customizationEmails_09() throws InterruptedException, ParseException  {
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_PIRItem_Status","Releases_UserGroup_Name","PIR Item","Status updated");
	
		//PIR - update status
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_ItemStatusDropdown", "PIR_ItemStatusSecond_Option");
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_PIRItem_Status", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete PIR item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Automation");

	}
	@Test (description=" -> Ability to receive email on PIR Preventative Measure and Action  (All triggers)")
	public void customizationEmails_10() throws InterruptedException, ParseException  {
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_PIR_PM","Releases_UserGroup_Name","PIR Preventative Measure and Action","Status updated");
	
		//PIR - update status
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.updatePIRItemActionsStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_PM_Automation_Summary","PIR_Item_PM_Status_Dropdown","PIR_Item_PM_Status_SecondOption");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_PIR_PM", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete PIR
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
	}
	@Test (description=" -> Ability to receive email on PIR Root Cause Analysis (All triggers)")
	public void customizationEmails_11() throws InterruptedException, ParseException  {
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
				
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_PIR_RCS","Releases_UserGroup_Name","PIR Root Cause Analysis","Status updated");
	
		//PIR - update status
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.updatePIRItemActionsStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_RC_Automation_Summary","PIR_Item_RC_Status_Dropdown","PIR_Item_RCS_Status_SecondOption");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_PIR_RCS", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete PIR
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
	}
	@Test (description=" -> Ability to receive email on Phase/Gate (All triggers)")
	public void customizationEmails_12() throws InterruptedException, ParseException  {
		//Create release & phase and gate
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation","Project_Automation_Name","0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_Phase/Gate","Releases_UserGroup_Name","Phase/Gate","Dates changed");
		
		//Update Release phase date
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.updatePhaseDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData,"Release_PhaseName"), "5");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Phase/Gate", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
}
	@Test (description=" -> Ability to receive email on Environment Booking (All triggers)")
	public void customizationEmails_13() throws InterruptedException, ParseException  {
		//System create
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		//Create Env Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EnvGrp_Test_Automation_Id","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		//Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_Booking","Releases_UserGroup_Name","Environment Bookings","Status updated");
		customizationPage.updateEnvironmentBookingEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_Email_Booking","Customization_Email_Template_Wizard_Trigger_Option","Status updated");
		
		//Update Environment status
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.selectEnvironmentStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Approved","APPROVED");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Booking", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Ability to receive email on IM constructor (All triggers)")
	public void customizationEmails_14() throws InterruptedException, ParseException  {
		//Enable form builder
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableOrDisableInitiativeSetup(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Initiative_Setup_Checked_Checkbox","Customization_Initiative_Setup_UnChecked_Checkbox");
		
		//Click on form builder option & create new form builder
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_FormBuilder_Option");
		customizationPage.createNewFormBuilder(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Tab", "Initiative_Form","Initiative_Panel");
		//Add new menu 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableOrDisableInitiativeSetup(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Initiative_Setup_Checked_Checkbox","Customization_Initiative_Setup_UnChecked_Checkbox");
		
		customizationPage.addNewMenu(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu", "Initiative_Form");

		//Add Email Template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email_IM","Releases_UserGroup_Name",PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form"),"Any value updated");
		customizationPage.updateIMConstructorEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Customization_Email_IM", "Customization_Email_Template_Wizard_Trigger_Option", "Any value updated");
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		customizationPage.sleep(2000);
		
		initiativePage.gotoInitiativePage(PlutoraConfiguration.initiativeData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu");
		initiativePage.clickOnFormCheckbox(PlutoraConfiguration.initiativeData, PlutoraConfiguration.objectData);
		
		//Verify in Yopmail account
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_IM", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		
		//Delete email template
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.deleteEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Delete form builder
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_FormBuilder_Option");
		customizationPage.deleteFormBuilder(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Form");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form")+" deleted successfully !");
		//Delete Menu
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_Setup_Option");
		customizationPage.deleteSetupMenu(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Menu")+" deleted successfully !");
		
		
	}
}
