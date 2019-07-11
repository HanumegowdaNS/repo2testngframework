package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationChange {
	CustomizationPage customizationPage = new CustomizationPage();
	ChangesPage changesPage = new ChangesPage();
	NewUserPage userPage= new NewUserPage();
	ReleasePage releasePage = new ReleasePage();
	
	@Test (description="Change Theme")
	public void customizationChange_01() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeTheme_Option","Change_Theme_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Theme_Name")+ " - Change Theme is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Create Change
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change Theme
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Theme_Dropdown","Change_Theme_Option","Change_Theme_Textbox","Change_Theme_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeTheme_Option","Customization_ChangeTheme_Default_Checkbox","Change_Theme_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyTextAttributeValue("Change_Theme_Textbox","Change_Theme_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Theme_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeTheme_Option","Change_Theme_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyTextAttributeValue("Change_Theme_Textbox","Change_Theme_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Theme_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeTheme_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Theme_Name");
	
	}
	@Test (description="Change Status")
	public void customizationChange_02() throws InterruptedException  {
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeStatus_Option","Change_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - Change Status is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change Theme
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Status_Dropdown","Change_Status_Option","Change_Status_Textbox","Change_Status_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeStatus_Option","Customization_ChangeStatus_Default_Checkbox","Change_Status_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyText("Change_Status_Textbox","Change_Status_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeStatus_Option","Change_Status_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change status
		changesPage.verifyText("Change_Status_Textbox","Change_Status_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change status
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Status_Dropdown","Change_Status_Option","Change_Status_Textbox","Change_First_Status");
		
		/*changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", "Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeStatus_Option","Customization_ChangeStatus_CompletedWorkflow_Checkbox","Change_Status_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.changeStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown", "AddRelease_Status_Dropdown_Option", "Completed");

		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		changesPage.verifyText("Change_Status_Textbox","Change_Status_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);*/
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Name");
	}
	
	@Test (description="Change workflow, including permissions based on both - user group and role")
	public void customizationChange_03() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeStatus_Option","Change_Status_Name");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeType_Option","Change_Type_Name");
		customizationPage.addWorkflowProcess(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ChangeStatus_Option","Change_Type_Name","","Customization_ChangeStatus_Enable_Workflow","Customization_ChangeStatus_Disable_Workflow","Customization_ChangeStatus_Workflow_Diagram_Button");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - Change Status is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		changesPage.clickOnChangeType(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Type_Option", "Change_Type_Name");
		changesPage.clickOnButton(PlutoraConfiguration.changesData, "Change_Status_Dropdown", PlutoraConfiguration.objectData);
		changesPage.verifyWorkflowStatus(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Option", "Change_Status_Textbox", "Workflow_Status_FirstOption");
		changesPage.verifyWorkflowStatus(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Option", "Change_Status_Textbox", "Workflow_Status_SecondOption");
		changesPage.verifyWorkflowStatus(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Option", "Change_Status_Textbox", "Workflow_Status_ThirdOption");
		changesPage.verifyWorkflowStatus(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Option", "Change_Status_Textbox", "Workflow_Status_FourthOption");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ChangeStatus_Disable_Workflow", "Customization_ChangeStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Status_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Type_Name");
	}
	@Test (description="Change Type")
	public void customizationChange_04() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ChangeStatus_Disable_Workflow", "Customization_ChangeStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeType_Option","Change_Type_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Type_Name")+ " - Change Type is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change Theme
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Type_Dropdown","Change_Type_Option","Change_Type_Textbox","Change_Type_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeType_Option","Customization_ChangeType_Default_Checkbox","Change_Type_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyText("Change_Type_Textbox","Change_Type_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Theme_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeType_Option","Change_Type_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyText("Change_Type_Textbox","Change_Type_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Type_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Type_Name");
	}
	@Test (description="Change Priority")
	public void customizationChange_05() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangePriority_Option","Change_Priority_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Priority_Name")+ " - Change Priority is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change Theme
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Priority_Dropdown","Change_Priority_Option","Change_Priority_Textbox","Change_Priority_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangePriority_Option","Customization_ChangePriority_Default_Checkbox","Change_Priority_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyText("Change_Priority_Textbox","Change_Priority_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Priority_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangePriority_Option","Change_Priority_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyText("Change_Priority_Textbox","Change_Priority_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Priority_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangePriority_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Priority_Name");
	}
	@Test (description="Change Risk")
	public void customizationChange_06() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_DeliveryRisk_Option","Change_DeliveryRisk_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Risk_Name")+ " - Change Theme is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change Theme
		changesPage.verifyChangeOptions(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_DeliveryRisk_Dropdown","Change_DeliveryRisk_Option","Change_DeliveryRisk_Textbox","Change_DeliveryRisk_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_DeliveryRisk_Option","Customization_DeliveryRisk_Default_Checkbox","Change_DeliveryRisk_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyTextAttributeValue("Change_DeliveryRisk_Textbox","Change_DeliveryRisk_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_DeliveryRisk_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_DeliveryRisk_Option","Change_DeliveryRisk_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyTextAttributeValue("Change_DeliveryRisk_Textbox","Change_DeliveryRisk_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_DeliveryRisk_Name")+ " - is displayed by default successfully");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_DeliveryRisk_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_DeliveryRisk_Name");
		
		
	}
	
	@Test (description="Change Custom Field")
	public void customizationChange_07() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name")+ " - Change Theme is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Create Change
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Customization_ChangeCustomFields_Mandatory_Option","Change_CustomField_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_DeliveryRisk_Name")+ " - is displayed by default successfully");
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Close_Icon",PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change 
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_DeliveryRisk_Name")+ " - is displayed by default successfully");
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Close_Icon",PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Customization_ChangeCustomFields_Mandatory_Option","Change_CustomField_Name");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
	}
	@Test (description="Custom Fields view/edit/hide permissions by User")
	public void customizationChange_08() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		
	}
	
	@Test (description="Custom Fields view/edit/hide permissions by Organization")
	public void customizationChange_09() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		
	}
	@Test (description="Custom Fields view/edit/hide permissions by Role")
	public void customizationChange_10() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		
	}
	@Test (description="Custom Fields view/edit/hide permissions by usergroup")
	public void customizationChange_11() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyFieldPermissionCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		
	}
	@Test (description="Change Custom List")
	public void customizationChange_12() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field","Change_CustomField_Name");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name")+ " - Change List is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Create Change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		//Verify Change 
		changesPage.verifyCustomList(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Customization_ChangeCustomFields_Mandatory_Option","Change_CustomField_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name")+ " - is displayed by default successfully");
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Close_Icon",PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Change theme
		changesPage.verifyCustomField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name")+ " - is displayed by default successfully");
		changesPage.clickOnButton(PlutoraConfiguration.changesData,"Change_Close_Icon",PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Customization_ChangeCustomFields_Mandatory_Option","Change_CustomField_Name");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_CustomField_Name");
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+ " - deleted successfully !");
	}
	@Test (description="Menu Label")
	public void customizationChange_13() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addChangeMenuLabel(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ChangeMenuLabel_Option", "Change_Title");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Title")+ " - New Change Title is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change Title
		changesPage.verifyText("Change_Page_Title","Change_Title", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Title")+ " - New Change Title is verified successfully");
		
		changesPage.clickElementUsingJavaScript("Change_New_Button",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.verifyText("NewChange_Title","Change_Title", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Title")+ " - New Change Title is verified successfully");
		
		changesPage.clickElementUsingJavaScript("NewChange_Close","Change_Title",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.sleep(1000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addChangeMenuLabel(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ChangeMenuLabel_Option", "");
		customizationPage.refresh(PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Title")+ " - Default Change Title is added successfully");
		customizationPage.sleep(3000);
		
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change Title
		changesPage.verifyText("Change_Page_Title","Customization_DefaultChange_MenuLabel", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.clickElementUsingJavaScript("Change_New_Button",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.verifyText("NewChange_Title","Customization_DefaultChange_MenuLabel", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_DefaultChange_MenuLabel")+ " - Default Change Title is verified successfully");
		
		changesPage.clickElementUsingJavaScript("NewChange_Close","Customization_DefaultChange_MenuLabel",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.sleep(1000);
		
	}
	@Test (description="Tab Names")
	public void customizationChange_14() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addChangeTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TabNames_Option", "Change_Tab");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab")+ " - New Change Tab is created successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change Tab
		changesPage.clickElementUsingJavaScript("Change_New_Button",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.verifyText("NewChange_Tab","Change_Tab", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab")+ " - Change Tab is verified successfully");
		changesPage.clickElementUsingJavaScript("NewChange_Close","Change",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.sleep(1000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addChangeTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TabNames_Option", "");
		
		Listener.addLogger("Default Change Title is added successfully");
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Verify Change Title
		changesPage.clickElementUsingJavaScript("Change_New_Button",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.verifyText("NewChange_Tab","Change", PlutoraConfiguration.changesData);
		Listener.addLogger("Change tab is verified successfully");
		changesPage.clickElementUsingJavaScript("NewChange_Close","Change",PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.sleep(1000);
	
	}

}
