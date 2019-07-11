package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class SystemsWindowAdditionalInformationTab {
	
	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: Systems window -> Additional Information tab -> Testcase")
	public void subareaSystemsAdditionalInformation_01() throws InterruptedException, AWTException, ParseException {	
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		customizationPage.addSystemDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option","System_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.systemDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.systemDataTypeOption.get(i),"System_CustomField_Name");
		new EnvironmentPage().getSystemsOnlyDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.enter();
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.sleep(2000);
		
		systemsPage.verifyAdditionalInformationTab(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.systemDataTypeOption.get(i));
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_SystemCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	
	
	
}
