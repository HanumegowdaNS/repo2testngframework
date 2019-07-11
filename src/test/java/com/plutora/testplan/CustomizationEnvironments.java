package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationEnvironments {
	CustomizationPage customizationPage = new CustomizationPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage environmentPage = new  EnvironmentPage();
	NewUserPage userPage = new NewUserPage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	ReleasePage releasePage = new ReleasePage();
	
	
	@Test (description="Status, and Not Bookable Environment Statuses feature")
	public void customizationEnvironments_01() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentStatus_Option","Enviornment_Status_Name");
	
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.updateEnvironmentWithNewStatus(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Status_Name");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TER
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation","TEBR_Automation","");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentStatus_Option","Customization_EnvironmentStatus_Default_Checkbox","Enviornment_Status_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentStatus_Option","Customization_EnvironmentStatus_NotBookable_Checkbox","Enviornment_Status_Name");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Details_Tab",PlutoraConfiguration.objectData);
		tebrPage.verifyTEBRWithEnvironmentDisabled(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentStatus_Option","Enviornment_Status_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		
		environmentPage.verifyTextAttributeValue("NewEnvironment_StatusDropdown_Textbox","Enviornment_Status_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentStatus_Option");
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"Environment_First_Status",customizationPage.getTextData("Customization_EnvironmentStatus_First_Status", PlutoraConfiguration.customizationData));
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Status_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.updateEnvironmentWithNewStatus(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_First_Status");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enviornment_Status_Name"));
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}
	@Test (description="Used for Phase")
	public void customizationEnvironments_02() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_UsedForPhase_Option","UsedForPhase_Name");
	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.updateEnvironmentWithNewPhase(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UsedForPhase_Name");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		
		environmentPage.verifyTextAttributeValue("NewEnvironment_PhaseDropdown_Textbox","UsedForPhase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_UsedForPhase_Option","Customization_UsedForPhase_Default_Checkbox","UsedForPhase_Name");
		
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyTextAttributeValue("NewEnvironment_PhaseDropdown_Textbox","UsedForPhase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_UsedForPhase_Option","UsedForPhase_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyTextAttributeValue("NewEnvironment_PhaseDropdown_Textbox","UsedForPhase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_UsedForPhase_Option");
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"Phase_First_Status",customizationPage.getTextData("Customization_UsedForPhase_First_Status", PlutoraConfiguration.customizationData));
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UsedForPhase_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.updateEnvironmentWithNewPhase(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_First_Status");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UsedForPhase_Name"));
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Stack Layer")
	public void customizationEnvironments_03() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_StackLayer_Option","StackLayer_Name");
	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.updateStackLayerInEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "StackLayer_Name");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		
		environmentPage.verifyText("Environment_Layer_Textbox","StackLayer_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_StackLayer_Option","StackLayer_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyText("Environment_Layer_Textbox","StackLayer_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_StackLayer_Option");
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"StackLayer_First_Status",customizationPage.getTextData("Customization_StackLayer_First_Status", PlutoraConfiguration.customizationData));
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "StackLayer_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.click("Environment_Host_Delete_Icon","Environment_Host_Name",PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Host_Delete_Yes_Button",PlutoraConfiguration.objectData);
		environmentPage.updateStackLayerInEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "StackLayer_First_Status");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "StackLayer_Name"));
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}

	@Test (description="TECR Status")
	public void customizationEnvironments_06() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECR_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status_Name")+ " - TECR Status Name is created successfully");
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		//Verify TECR
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation" );
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify TECR Status
		tecrPage.verifyTECRFieldOptions(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddTECR_StatusDropdown","TECR_Status_Option","TECR_Status_Textbox","TECR_Status_Name","TECR_Automation");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","Customization_TECRStatus_Default_Checkbox","TECR_Status_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify Change theme
		tecrPage.verifyTextAttributeValue("TECR_Status_Textbox","TECR_Status_Name",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECR_Status_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify Change theme
		tecrPage.verifyTextAttributeValue("TECR_Status_Textbox","TECR_Status_Name",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Name");
	}
	
	@Test (description="TECR Type")
	public void customizationEnvironments_08() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Disable TECR status workflow
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_TECRStatus_Disable_Workflow", "Customization_TECRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_Type_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type_Name")+ " - TECR Type Name is created successfully");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify TECR type
		tecrPage.verifyTECRFieldOptions(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddTECR_TypeDropDown","TECR_Type_Option","TECR_Type_Textbox","TECR_Type_Name","TECR_Automation");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","Customization_TECRType_Default_Checkbox","TECR_Type_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify Change theme
		tecrPage.verifyTextAttributeValue("TECR_Type_Textbox","TECR_Type_Name",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_Type_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		//Verify Change theme
		tecrPage.verifyTextAttributeValue("TECR_Type_Textbox","TECR_Type_Name",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","Customization_TECRType_Maintenance_Bench_Checkbox","TECR_Type_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.verifyTECRMaintenanceBenchType(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Type_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Type_Name");
	}
	@Test (description="TEBR Status")
	public void customizationEnvironments_16() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBR_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status_Name")+ " - TEBR Status Name is created successfully");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TEBR
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify TECR Status
		tebrPage.verifyTEBRFieldOptions(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddTEBR_StatusDropdown","TEBR_Status_Option","TEBR_Status_Textbox","TEBR_Status_Name","TEBR_Automation");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","Customization_TEBRStatus_Default_Checkbox","TEBR_Status_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify Change theme
		tebrPage.verifyTextAttributeValue("TEBR_Status_Textbox","TEBR_Status_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBR_Status_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify Change theme
		tebrPage.verifyTextAttributeValue("TEBR_Status_Textbox","TEBR_Status_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status_Name")+ " - is displayed by default successfully");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Name");
	}
	
	@Test (description="TEBR Type")
	public void customizationEnvironments_18() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBR_Type_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type_Name")+ " - TEBR Type Name is created successfully");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify TECR Status
		tebrPage.verifyTEBRFieldOptions(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddTEBR_TypeDropdown","TEBR_Type_Option","TEBR_Type_Textbox","TEBR_Type_Name","TEBR_Automation");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","Customization_TEBRType_Default_Checkbox","TEBR_Type_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify Change theme
		tebrPage.verifyTextAttributeValue("TEBR_Type_Textbox","TEBR_Type_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type_Name")+ " - is displayed by default successfully");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBR_Type_Name");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Verify TECR
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		//Verify Change theme
		tebrPage.verifyTextAttributeValue("TEBR_Type_Textbox","TEBR_Type_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type_Name")+ " - is displayed by default successfully");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Type_Name");
	}
	
	@Test (description="TECR Custom Fields view/edit/hide permissions by User")
	public void customizationEnvironments_10() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		
	}
	
	@Test (description="TECR Custom Fields view/edit/hide permissions by Organization")
	public void customizationEnvironments_13() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		
	}
	@Test (description="TECR Custom Fields view/edit/hide permissions by Role")
	public void customizationEnvironments_11() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation"); 
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		
	}
	@Test (description=" TECR Custom Fields view/edit/hide permissions by usergroup")
	public void customizationEnvironments_12() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");

		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation"); 
		tecrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		
	}
	
	@Test (description="TEBR Custom Fields view/edit/hide permissions by User")
	public void customizationEnvironments_21() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		
	}
	
	@Test (description="TEBR Custom Fields view/edit/hide permissions by Organization")
	public void customizationEnvironments_24() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		
	}
	@Test (description="TEBR Custom Fields view/edit/hide permissions by Role")
	public void customizationEnvironments_22() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation"); 
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		
	}
	@Test (description="TEBR Custom Fields view/edit/hide permissions by usergroup")
	public void customizationEnvironments_23() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");

		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation"); 
		tebrPage.verifyFieldPermissionCustomField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		
	}
	
	@Test (description="Environment Custom Fields view/edit/hide permissions by User")
	public void customizationEnvironments_27() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		
	}
	
	@Test (description="Environment Custom Fields view/edit/hide permissions by Organization")
	public void customizationEnvironments_30() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		
	}
	@Test (description="Environment Fields view/edit/hide permissions by Role")
	public void customizationEnvironments_28() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation"); 
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		
	}
	@Test (description="Environment Custom Fields view/edit/hide permissions by usergroup")
	public void customizationEnvironments_29() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");

		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Automation");
		environmentPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		
	}
	@Test (description="Environment Group Custom Fields view/edit/hide permissions by User")
	public void customizationEnvironments_33() throws InterruptedException  {
		//Env Group
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		
	}
	
	@Test (description="Environment Group Custom Fields view/edit/hide permissions by Organization")
	public void customizationEnvironments_36() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
	
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		
	}
	@Test (description="Environment Group Custom Fields view/edit/hide permissions by Role")
	public void customizationEnvironments_34() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		
	}
	@Test (description="Environment Group Custom Fields view/edit/hide permissions by usergroup")
	public void customizationEnvironments_35() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");

		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
	
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		
	}
	@Test (description="Systems Custom Fields view/edit/hide permissions by User")
	public void customizationEnvironments_41() throws InterruptedException  {
		
		//System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
	
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		
	}
	
	@Test (description="Systems Custom Fields view/edit/hide permissions by Organization")
	public void customizationEnvironments_44() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
	
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Custom Field", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		
	}
	@Test (description="Systems Custom Fields view/edit/hide permissions by Role")
	public void customizationEnvironments_42() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		
	}
	@Test (description="Systems Custom Fields view/edit/hide permissions by usergroup")
	public void customizationEnvironments_43() throws InterruptedException  {
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		CustomizationPage.flag=false;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");

		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
	
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "Edit Value");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyFieldPermissionCustomField(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name", "View Custom Field");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		
	}
	
	/*@Test (description="TECR Setup")
	public void customizationEnvironments_05() throws InterruptedException  {
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation","EnvGrp_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Automation")+" - Environment is created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"TECR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_Yes_Checkbox_Checked","TECR_Setup_Yes_Checkbox", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "New_TECR_Button", PlutoraConfiguration.objectData);
		customizationPage.validateElementDisplayed("TECR_Scheduler_Yes_Checkbox", PlutoraConfiguration.tecrData);
		customizationPage.clickOnButton(PlutoraConfiguration.tecrData, "TECR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"TECR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_No_Checkbox_Checked","TECR_Setup_No_Checkbox", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "New_TECR_Button", PlutoraConfiguration.objectData);
		customizationPage.validateElementDisplayed("TECR_Scheduler_No_Checkbox", PlutoraConfiguration.tecrData);
		customizationPage.clickOnButton(PlutoraConfiguration.tecrData, "TECR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"TECR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_EnterpriseRelease_Checkbox_Checked","TECR_Setup_EnterpriseRelease_Checkbox", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_NonEnterpriseRelease_Checkbox_Checked","TECR_Setup_NonEnterpriseRelease_Checkbox", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		tecrPage.addCreateKBAndPhase(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.addTECRApplicationAndInformation(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Env_Automation");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		tecrPage.addCreateKBAndPhase(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.addTECRApplicationAndInformation(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Env_Automation");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Project_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation");
		tecrPage.addCreateKBAndPhase(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.addTECRApplicationAndInformation(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Env_Automation");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Independent_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"TECR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_EnterpriseRelease_Checkbox","TECR_Setup_EnterpriseRelease_Checkbox_Checked", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "TECR_Setup_NonEnterpriseRelease_Checkbox","TECR_Setup_NonEnterpriseRelease_Checkbox_Checked", PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
*/
	@Test (description="TEBR Form")
	public void customizationEnvironments_15() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormDescription(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Form");
		customizationPage.updateTEBRFormQuestion(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Question");
		
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		customizationPage.clickElementUsingJavaScript("AddTEBR_Button",PlutoraConfiguration.tebrData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyTextContains("TEBR_Form_Description", "TEBR_Form",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		customizationPage.verifyText("TEBR_Form_Question", "TEBR_Question",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		customizationPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormDescription(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Form");
	
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		customizationPage.clickElementUsingJavaScript("AddTEBR_Button",PlutoraConfiguration.tebrData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyTextContains("TEBR_Form_Description", "TEBR_Form",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		customizationPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormDeleteQuestion(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Question");
	
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		customizationPage.clickElementUsingJavaScript("AddTEBR_Button",PlutoraConfiguration.tebrData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Question"));
		customizationPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormDescription(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "");
	}
	
	@Test (description="TECR Workflow")
	public void customizationEnvironments_07() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_TECRStatus_Disable_Workflow", "Customization_TECRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.refresh(PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_Type_Name");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_CopyToType_Name");
		customizationPage.addWorkflowProcess(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option","TECR_Type_Name","TECR_CopyToType_Name","Customization_TECRStatus_Enable_Workflow","Customization_TECRStatus_Disable_Workflow","Customization_TECRStatus_Workflow_Diagram_Button");
	
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		
		tecrPage.clickOnTECRField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTECR_TypeDropDown", "TECR_Type_Option", "TECR_Type_Name");
		tecrPage.clickOnTECRField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTECR_AssignedToDropdown", "AddTECR_AssignedTo_Option", "Loggedin_Username_Value");
		
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_FirstOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_SecondOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_ThirdOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_FourthOption");
		
		tecrPage.clickOnTECRField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTECR_TypeDropDown", "TECR_Type_Option", "TECR_CopyToType_Name");
		tecrPage.clickOnTECRField(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTECR_AssignedToDropdown", "AddTECR_AssignedTo_Option", "Loggedin_Username_Value");
		
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_FirstOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_SecondOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_ThirdOption");
		tecrPage.verifyWorkflowStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status_Option", "TECR_Status_Textbox", "Workflow_Status_FourthOption");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_TECRStatus_Disable_Workflow", "Customization_TECRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Type_Name");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CopyToType_Name");
	
	}
	@Test (description="TEBR Workflow")
	public void customizationEnvironments_17() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_TEBRStatus_Disable_Workflow", "Customization_TEBRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBR_Type_Name");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBR_CopyToType_Name");
		customizationPage.addWorkflowProcess(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option","TEBR_Type_Name","TEBR_CopyToType_Name","Customization_TEBRStatus_Enable_Workflow","Customization_TEBRStatus_Disable_Workflow","Customization_TEBRStatus_Workflow_Diagram_Button");
	
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		
		tebrPage.clickOnTEBRField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTEBR_TypeDropdown", "TEBR_Type_Option", "TEBR_Type_Name");
		tebrPage.clickOnTEBRField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTEBR_AssignedToDropdown", "AddTEBR_AssignedTo_Option", "Loggedin_Username_Value");
		
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_FirstOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_SecondOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_ThirdOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_FourthOption");
		
		tebrPage.clickOnTEBRField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTEBR_TypeDropdown", "TEBR_Type_Option", "TEBR_CopyToType_Name");
		tebrPage.clickOnTEBRField(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddTEBR_AssignedToDropdown", "AddTEBR_AssignedTo_Option", "Loggedin_Username_Value");
		
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_FirstOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_SecondOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_ThirdOption");
		tebrPage.verifyWorkflowStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Status_Option", "TEBR_Status_Textbox", "Workflow_Status_FourthOption");
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_TEBRStatus_Disable_Workflow", "Customization_TEBRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Type_Name");
	
	}
	@Test (description="TEBR Mandatory Fields")
	public void customizationEnvironments_19() throws InterruptedException  {
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "TEBR_Mandatory_Fields");
		customizationPage.selectMultipleButton(PlutoraConfiguration.customizationData, "TEBR_Unchecked_Fields");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		customizationPage.validateElementDisplayed("TEBR_Description_Mandatory_Icon", PlutoraConfiguration.tebrData);
		customizationPage.validateElementDisplayed("TEBR_ProjectReleaseName_Mandatory_Icon", PlutoraConfiguration.tebrData);
		customizationPage.validateElementDisplayed("TEBR_SystemDetails_Mandatory_Icon", PlutoraConfiguration.tebrData);
		customizationPage.validateElementDisplayed("TEBR_EnvironmentSelection_Mandatory_Icon", PlutoraConfiguration.tebrData);
		customizationPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "TEBR_Mandatory_Fields");
		customizationPage.selectMultipleButton(PlutoraConfiguration.customizationData, "TEBR_Checked_Fields");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyElementNotDisplayed("TEBR_Description_Mandatory_Icon",PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		customizationPage.verifyElementNotDisplayed("TEBR_ProjectReleaseName_Mandatory_Icon",PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData);
		customizationPage.verifyElementNotDisplayed("TEBR_SystemDetails_Mandatory_Icon",PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		customizationPage.verifyElementNotDisplayed("TEBR_EnvironmentSelection_Mandatory_Icon",PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Close_Icon", PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="TECR Custom Field")
	public void customizationEnvironments_09() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
	
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option","TECR_CustomField_Name","TECR_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Description"));
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="TEBR Custom Field")
	public void customizationEnvironments_20() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
	
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option","TEBR_CustomField_Name","TEBR_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Description"));
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="Environment Custom Field")
	public void customizationEnvironments_26() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
	
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name","Environment_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Description"));
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="Environment Group Custom Field")
	public void customizationEnvironments_32() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
	
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name","EnvGrp_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Description"));
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	@Test (description="System Custom Field")
	public void customizationEnvironments_40() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option","System_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
	
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option","System_CustomField_Name","System_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Description"));
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="TECR Custom Lists")
	public void customizationEnvironments_14() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "TECR_CustomField_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="TEBR Custom Lists")
	public void customizationEnvironments_25() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "TEBR_CustomField_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	@Test (description="Environment Custom Lists")
	public void customizationEnvironments_31() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "Environment_CustomField_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	

	@Test (description="Environment Group Custom Lists")
	public void customizationEnvironments_37() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "EnvGrp_CustomField_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="System Custom Lists")
	public void customizationEnvironments_45() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "System_CustomField_Name");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option","System_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="Title Names")
	public void customizationEnvironments_46() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Title_Names");
		customizationPage.setCustomTitleNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.verifyText("TECR_Custom_Tab","TECR", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		environmentPage.verifyText("TEBR_Custom_Tab","TEBR", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Custom_Tab","MEB", PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("Environment_Request_Title","Env", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Title_Names");
		customizationPage.setTitleNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.refresh(PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.verifyText("TECR_Custom_Tab","TECR", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		environmentPage.verifyText("TEBR_Custom_Tab","TEBR", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Custom_Tab","MEB", PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("Environment_Request_Title","Env", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
	}
	
	@Test (description="Connectivity Type")
	public void customizationEnvironments_38() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ConnectivityType_Option","Connectivity_Type");
		
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment is created successfully !");
		
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment is created successfully !");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Create
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		//Drag and drop
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment shows successfully");
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment shows successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//add batch
		environmentGroupsPage.addBatch(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Connectivity_Type");
		Listener.addLogger("Added batch successfully");
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Connectivity_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ConnectivityType_Option","Connectivity_Type");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.sleep(2000);
		
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Connectivity_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ConnectivityType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Connectivity_Type");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.deleteConnection(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment Group connection is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvGrp_Type_Dropdown", PlutoraConfiguration.objectData);
		environmentGroupsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Connectivity_Type"));
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
	}
	//@Test (description="System Dependencies")
	public void customizationEnvironments_39() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemDependencies_Option","Functional_System");
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+" System is created successfully");
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2")+" System is created successfully");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		
		systemsPage.setSystemImpactFromDependencies(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_2", "Functional_System");
		
		systemsPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemDependencies_Option","Functional_System");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.verifyText("Systems_Impact_Text", "Functional_System",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Functional_System")+" System dependency is verified after updation successfully");
		systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemDependencies_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Functional_System");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "System_Dependencies_First",customizationPage.getTextData("Customization_SystemDependencies_First_Status", PlutoraConfiguration.customizationData));
	
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.updateSystemImpactFromDependencies(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_2", "System_Dependencies_First");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_1");
		systemsPage.click("Systems_Impact_Section", "System_Automation_2",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData, "Systems_Impact_Dropdown", PlutoraConfiguration.objectData);
		systemsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Functional_System"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Functional_System")+" System dependency is not available in the Impact dropdown list");
		systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,PlutoraConfiguration.objectData);
		
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+" System is deleted successfully");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2")+" System is deleted successfully");
	}
	/*@Test (description="Scheduler TECR Row")
	public void customizationEnvironments_04() throws InterruptedException  {
		//System Creation one
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
				
		//EG creation one
		new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation","Systems_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Cucstomization_Scheduler_TECR_Row_Option");
		customizationPage.selectSchedulerTECRRowColor(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_Save_Per_User_Checkbox",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Conflict_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - System - Conflict option selected successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.clickButton("EnvironmentSchedule_Setting_Icon","EnvGrp_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String color=environmentPage.getAttributeValue("EnvironmentSchedule_TECR_Color", PlutoraConfiguration.customizationData,"style").split("rgb")[1].replace("(", "").replace(");", "");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code",environmentPage.toHex(Integer.parseInt(color.split(",")[0].trim()), Integer.parseInt(color.split(",")[1].trim()), Integer.parseInt(color.split(",")[2].trim())));
		releasePage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Color_Code"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Color_Code")+" is equal to"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code"));
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Cucstomization_Scheduler_TECR_Row_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_Scheduler_CR_Row_Checked_Checkbox","Customization_Scheduler_CR_Row_Checkbox",PlutoraConfiguration.objectData,"xpath");
		sleep(4000);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		environmentPage.clickButton("EnvironmentSchedule_Setting_Icon","EnvGrp_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		color=environmentPage.getAttributeValue("EnvironmentSchedule_TECR_Color", PlutoraConfiguration.customizationData,"style").split("rgb")[1].replace("(", "").replace(");", "");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code",environmentPage.toHex(Integer.parseInt(color.split(",")[0].trim()), Integer.parseInt(color.split(",")[1].trim()), Integer.parseInt(color.split(",")[2].trim())));
		releasePage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Color_Code"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Color_Code")+" is equal to"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Row_Color_Code"));
	}
	*/
	
}
