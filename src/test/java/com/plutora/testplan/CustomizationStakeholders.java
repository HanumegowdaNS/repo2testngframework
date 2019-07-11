package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationStakeholders {
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();

	@Test (description="Stakeholder Role")
	public void customizationStakeholders_01() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_StakeholderRole_Option","SH_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "SH_Name")+ " - Custome field is created successfully");
	
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.verifyStakeholderRole(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"","SH_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_StakeholderRole_Option","Customization_StakeholderRole_Default_Checkbox","SH_Name");
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.verifyStakeholderRole(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Default","SH_Name");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_StakeholderRole_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "SH_Name");
		
	}
}
