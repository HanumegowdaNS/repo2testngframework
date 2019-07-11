package com.plutora.testplan;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationReleases {
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();
	NewUserPage userPage = new NewUserPage();
	ChangesPage changesPage = new ChangesPage();
	BlockoutPage blockoutPage = new BlockoutPage();
	
	@Test (description="Releases Custom Field")
	public void customizationReleases_17() throws InterruptedException  {
		//customizationPage.addReleaseDataTypeList();
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified successfully");
		//Update Custom Field Types
		for(int i=0;i<customizationPage.releaseDataTypeOption.size();i++) {
		customizationPage.sleep(1000);
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.releaseDataTypeOption.get(i), "Release_CustomField_Name");
		customizationPage.sleep(1000);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData);
		customizationPage.verifyDataTypeOption(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"), customizationPage.releaseDataTypeOption.get(i));
		}
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified successfully");
		//Update Custom Field
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option","Release_CustomField_Name","Release_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Description"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field Description is verified successfully");
		
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="Capacity Custom Field")
	public void customizationReleases_35() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_CapacityManagement_Enable_Workflow", "Customization_CapacityManagement_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		customizationPage.addCapacityDataTypeList();
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified successfully");
		//Update Custom Field
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option","Capacity_CustomField_Name","Capacity_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Description"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Description")+" - Custom field Description is verified successfully");
		//Update Custom Field Types
		for(int i=0;i<customizationPage.capacityDataTypeOption.size();i++) {
		customizationPage.sleep(1000);
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.capacityDataTypeOption.get(i), "Capacity_CustomField_Name");
		customizationPage.sleep(1000);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData);
		customizationPage.verifyDataTypeOption(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"), customizationPage.capacityDataTypeOption.get(i));
		}
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Activity/Criteria Custom Field")
	public void customizationReleases_44() throws InterruptedException  {
		customizationPage.addCapacityDataTypeList();
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified successfully");
		//Update Custom Field
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name","AC_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Description"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Description")+" - Custom field Description is verified successfully");
		//Update Custom Field Types
		for(int i=0;i<customizationPage.capacityDataTypeOption.size();i++) {
		customizationPage.sleep(1000);
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.capacityDataTypeOption.get(i), "AC_CustomField_Name");
		customizationPage.sleep(1000);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData);
		customizationPage.verifyDataTypeOption(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"), customizationPage.capacityDataTypeOption.get(i));
		}
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AC_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Releases Custom Lists")
	public void customizationReleases_22() throws InterruptedException  {
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified successfully");
		
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "Release_CustomField_Name");
		//Add Custom List
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom List is verified successfully");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom List is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom List
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified successfully");
		//Delete Custom List
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified after deletion successfully");
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom list name is verified after deletion successfully");
		//Mandatory Custom List
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Capacity Custom Lists")
	public void customizationReleases_40() throws InterruptedException  {
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified successfully");
		
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "Capacity_CustomField_Name");
		//Add Custom List
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom List is verified successfully");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom List is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom List
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified successfully");
		//Delete Custom List
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified after deletion successfully");
		
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom list name is verified after deletion successfully");
		//Mandatory Custom List
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Activity/Criteria Capacity Custom Lists")
	public void customizationReleases_43() throws InterruptedException  {
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified successfully");
		
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "AC_CustomField_Name");
		//Add Custom List
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AC_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom List is verified successfully");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom List is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom List
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AC_CustomField_Name","CustomList_1");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified successfully");
		//Delete Custom List1 
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom list name is verified after deletion successfully");
		//Delete Custom List2
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"CustomList_1");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom list name is verified after deletion successfully");
	
		//Mandatory Custom List
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AC_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		
	}
	
	@Test (description="Releases Custom Fields view/edit/hide permissions by User")
	public void customizationReleases_18() throws InterruptedException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value")+" - Option selected for Verification successfully ! ");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value");
		
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Releases Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Releases Custom Fields view/edit/hide permissions by Organization")
	public void customizationReleases_19() throws InterruptedException  {
		//User Management values updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingOrganizationAssociationText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Organization_Text","UM_Org_Text");
		CustomizationPage.flag=false;
		//View Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value");
		//Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field", "Organization", "UM_Org_Text", "");
		//Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field");
		//Delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Releases Custom Field is deleted successfully ! ");
	}
	@Test (description="Releases Custom Fields view/edit/hide permissions by Role")
	public void customizationReleases_20() throws InterruptedException  {
		//User Management value updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Releases Custom Field is deleted successfully ! ");
	}
	@Test (description="Releases Custom Fields view/edit/hide permissions by User Group")
	public void customizationReleases_21() throws InterruptedException  {
		//User Management Values Updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value");
		//View Custom Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		//View Custom Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" - Releases Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Capacity Custom Fields view/edit/hide permissions by User")
	public void customizationReleases_36() throws InterruptedException  {
		
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value")+" - Option selected for Verification successfully ! ");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value");
		
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Capacity Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Capacity Custom Fields view/edit/hide permissions by Organization")
	public void customizationReleases_37() throws InterruptedException  {
		//User Management values updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingOrganizationAssociationText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Organization_Text","UM_Org_Text");
		CustomizationPage.flag=false;
		//View Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value");
		//Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field", "Organization", "UM_Org_Text", "");
		//Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field");
		//Delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Capacity Custom Field is deleted successfully ! ");
	}
	@Test (description="Capacity Custom Fields view/edit/hide permissions by Role")
	public void customizationReleases_38() throws InterruptedException  {
		//User Management value updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Capacity Custom Field is deleted successfully ! ");
	}
	@Test (description="Capacity Custom Fields view/edit/hide permissions by User Group")
	public void customizationReleases_39() throws InterruptedException  {
		//User Management Values Updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value");
		//View Custom Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		//View Custom Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyCapacityFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Capacity_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - Capacity Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Release Type")
	public void customizationReleases_01() throws InterruptedException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+" - created successfully ! ");
		
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+" - created successfully ! ");
		
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+" - created successfully ! ");
		//Create Enterprise Release Type + Default Checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","ReleaseType_CF_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option", "Customization_ReleaseType_Enterprise_Default_Checkbox", "ReleaseType_CF_Name");
		//Verify Enterprise Release Type Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddEnterpriseRelease_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "ReleaseType_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Enterprise Release Type
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","ReleaseType_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is updated successfully in customization page !");

		//Create Project Release Type + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option", "Customization_ReleaseType_Project_Default_Checkbox", "ReleaseType_CF_Name");
		//Verify Project Release Type Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "ReleaseType_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Enterprise Release Type
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","ReleaseType_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is updated successfully in customization page !");
		
		//Create Project Release Type + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option", "Customization_ReleaseType_Independent_Default_Checkbox", "ReleaseType_CF_Name");
		//Verify Independent Release Type Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "ReleaseType_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Enterprise Release Type
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","ReleaseType_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+"  is updated successfully in customization page !");
		
		//Customization Scheduler Color untick checkbox
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseType_StandardColors_Checkbox", "Customization_ReleaseType_StandardColors_Checkbox_Checked", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//New Enterprise Scheduler Color
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddEnterpriseRelease_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "New Enterprise");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		//New Project Scheduler Color
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "New Project");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
						
		//New Independent Scheduler Color
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "New Independent");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		//Existing Enterprise Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Existing  Project Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
						
		//Existing Independent Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		ReleasePage.flag=false;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Customization Scheduler Color tick checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseType_StandardColors_Checkbox_Checked", "Customization_ReleaseType_StandardColors_Checkbox", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//New Enterprise Scheduler Color
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddEnterpriseRelease_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "New Enterprise");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		//New Project Scheduler Color
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "New Project");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
						
		//New Independent Scheduler Color
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "New Independent");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		//Existing Enterprise Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Existing  Project Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
						
		//Existing Independent Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Update Scheduler Color Option 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		String color=customizationPage.getAttributeValue("Customization_Color_Text", "ReleaseType_CF_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,"style").split("rgb")[1].replace("(", "").replace(");", "");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Color_Code",customizationPage.toHex(Integer.parseInt(color.split(",")[0].trim()), Integer.parseInt(color.split(",")[1].trim()), Integer.parseInt(color.split(",")[2].trim())));
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseType_StandardColors_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseType_Yes_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,  PlutoraConfiguration.objectData);
		
		//Existing Enterprise Scheduler Color
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.updateReleaseType(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ReleaseType_CF_Name");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation"));
		releasePage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code")+" is equal to"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Existing  Project Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.updateReleaseType(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ReleaseType_CF_Name");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation"));
		releasePage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code")+" is equal to"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
						
		//Existing Independent Scheduler Color
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.updateReleaseType(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ReleaseType_CF_Name");
		ReleasePage.flag=true;
		releasePage.verifySchedulerColor(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation"));
		releasePage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Code")+" is equal to"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Color_Code"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);	
		
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ReleaseType_CF_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseType_CF_Name")+" - Release Type Custom Field is deleted successfully ! ");
	
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Risk Level")
	public void customizationReleases_05() throws InterruptedException  {
		
		//Create Release Risk level + Default Checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_RiskLevel_Option","RiskLevel_CF_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_RiskLevel_Option", "Customization_RiskLevel_Enterprise_Default_Checkbox", "RiskLevel_CF_Name");
	
		//Verify Enterprise Risk level Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddEnterpriseRelease_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "RiskLevel_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Release Risk level name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_RiskLevel_Option","RiskLevel_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is updated successfully in customization page !");

		//Create Project Risk Level + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_RiskLevel_Option", "Customization_RiskLevel_Project_Default_Checkbox", "RiskLevel_CF_Name");
		//Verify Project Release Type Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "RiskLevel_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Release Risk level name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_RiskLevel_Option","RiskLevel_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is updated successfully in customization page !");
		
		//Create Project Release Risk level + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_RiskLevel_Option", "Customization_RiskLevel_Independent_Default_Checkbox", "RiskLevel_CF_Name");
		//Verify Independent Release Type Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "RiskLevel_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		//Edit Release Risk level name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_RiskLevel_Option","RiskLevel_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+"  is updated successfully in customization page !");
		
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_RiskLevel_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "RiskLevel_CF_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "RiskLevel_CF_Name")+" - Risk Level Custom Field is deleted successfully ! ");
	
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_RiskLevel_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Release Status")
	public void customizationReleases_02() throws InterruptedException  {
	
		//Create Release Status + Default Checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","ReleaseStatus_CF_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option", "Customization_ReleaseStatus_Enterprise_Default_Checkbox", "ReleaseStatus_CF_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option", "Customization_ReleaseStatus_EndStatus_Checkbox", "ReleaseStatus_CF_Name");
		//Verify Enterprise Release Status Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "ReleaseStatus_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Edit Enterprise Release Status
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","ReleaseStatus_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is updated successfully in customization page !");

		//Create Project Release Status + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option", "Customization_ReleaseStatus_Project_Default_Checkbox", "ReleaseStatus_CF_Name");
		//Verify Project Release Status Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "ReleaseStatus_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is prefilled in release details page successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_Release_Dependency_Textbox",PlutoraConfiguration.objectData);
		releasePage.sendKeys("AddRelease_Release_Dependency_Textbox", "ER_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  is not displayed in Project release dependency due to end-state checkbox enabled in enterprise-release successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Edit Enterprise Release Status
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","ReleaseStatus_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is updated successfully in customization page !");
		
		//Create Project Release Status + Default Checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option", "Customization_ReleaseStatus_Independent_Default_Checkbox", "ReleaseStatus_CF_Name");
		//Verify Independent Release Status Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+" created successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "ReleaseStatus_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is prefilled in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Edit Enterprise Release Status
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","ReleaseStatus_CF_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+"  is updated successfully in customization page !");
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+"  is created successfully!");
		
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+"  is created successfully!");
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "System_Automation");
			
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.updateReleaseStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "","AddRelease_Status_Dropdown_FirstOption");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.linkChangeToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyText("Change_DR_Change_Name", "PR_Automation",PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  is displayed in delivery release page successfully!");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.updateReleaseStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ReleaseStatus_CF_Name","AddRelease_Status_Dropdown_FirstOption");
		
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  is not displayed in delivery release page successfully!");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new TECRPage().clickOnButton(PlutoraConfiguration.tecrData, "New_TECR_Button", PlutoraConfiguration.objectData);
		new TECRPage().verifyEmptyReleaseTable(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
	
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new TEBRPage().clickOnButton(PlutoraConfiguration.tebrData,"AddTEBR_Button", PlutoraConfiguration.objectData);
		new TEBRPage().verifyEmptyReleaseTable(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
	
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ReleaseStatus_CF_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseStatus_CF_Name")+" - Release Status Custom Field is deleted successfully ! ");
	
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Release Intake Status")
	public void customizationReleases_04() throws InterruptedException  {
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Release Intake Status custom field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_IntakeStatus_Option","IntakeStatus_CF_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_IntakeStatus_Option", "Customization_IntakeStatus_Default_Checkbox", "IntakeStatus_CF_Name");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_IntakeStatus_Enable_Workflow", "Customization_IntakeStatus_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickMultipleElement("Customization_ReleaseStatus_EndStatus_Checkboxes", PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData);
		customizationPage.clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","4",PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","5",PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","6",PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Verify Enterprise Release Status Preselected
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PR_Automation");
		//Select Release Dependency
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		
		releasePage.searchReleaseManifest(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.dragAndDrop("Release_Manifest_Name_Section", "Release_Scope_Manifest_Section", "PR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyText("Release_Manifest_IntakeApproval_Dropdown", "IntakeStatus_CF_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IntakeStatus_CF_Name")+" - verified release intake status successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Release Intake Status custom field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_IntakeStatus_Option");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_IntakeStatus_Option", "Customization_IntakeStatus_Default_Checkbox", "IntakeStatus_CF_Name");		
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IntakeStatus_CF_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IntakeStatus_CF_Name")+" - not displayed release intake status successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_IntakeStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IntakeStatus_CF_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IntakeStatus_CF_Name")+" - Release Status Custom Field is deleted successfully ! ");
	
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_IntakeStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Release Title")
	public void customizationReleases_08() throws InterruptedException  {
		//Add Release title
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseTitle_Option");
		customizationPage.addReleaseTitle(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "I","P","Custom");
		//Verify Custom Release Title
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_ProjectLabel","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_IndependentLabel","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" "+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Filter Name verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.verifyText("ProjectAdd_Button","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("IndependentAdd_Button","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" "+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Creation Name verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextContains("Release_Title_Text","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" Release Title name verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextContains("Ind_Title_Text","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Title name verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseTitle_Option");
		customizationPage.addReleaseTitle(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "I","P","");
		//Verify Release Title
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_ProjectLabel","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_IndependentLabel","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" "+
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Filter Name verified successfully !");
				
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.verifyText("ProjectAdd_Button","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("IndependentAdd_Button","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" "+
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Creation Name verified successfully !");
				
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "ProjectAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextContains("Release_Title_Text","P", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "P")+" Release Title name verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
				
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddNewRelease_Button", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "IndependentAdd_Button", PlutoraConfiguration.objectData);
		releasePage.verifyTextContains("Ind_Title_Text","I", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "I")+" Release Title name verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "NewRelease_Details_Close_Icon", PlutoraConfiguration.objectData);
	
	}
	@Test (description="Tab Names")
	public void customizationReleases_42() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseTabNames_Option");
		customizationPage.addCustomizationReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Custom");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Custom
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddEnterpriseRelease_Button",PlutoraConfiguration.objectData);
	
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseManifest_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseManifest_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activities_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activities_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LinkedItems_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LinkedItems_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddNewRelease_Button",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddIndependentRelease_Button",PlutoraConfiguration.objectData);
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab")+"  verified successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddNewRelease_Button",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddProjectRelease_Button",PlutoraConfiguration.objectData);
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);
		
		//default
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseTabNames_Option");
		customizationPage.addCustomizationReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Custom
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddEnterpriseRelease_Button",PlutoraConfiguration.objectData);
	
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseManifest_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseManifest_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activities_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activities_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LinkedItems_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LinkedItems_Tab")+"  verified successfully !");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddNewRelease_Button",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddIndependentRelease_Button",PlutoraConfiguration.objectData);
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tab")+"  verified successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddNewRelease_Button",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddProjectRelease_Button",PlutoraConfiguration.objectData);
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Tab")+"  verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Close_Icon",PlutoraConfiguration.objectData);

	}
	
	@Test (description="Release Workflow")
	public void customizationReleases_03() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","Release_Type_Name");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","Release_CopyToType_Name");
		customizationPage.addWorkflowProcess(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option","Release_Type_Name","Release_CopyToType_Name","Customization_ReleaseStatus_Enable_Workflow","Customization_ReleaseStatus_Disable_Workflow","Customization_ReleaseStatus_Workflow_Diagram_Button");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		
		releasePage.clickOnReleaseField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_ReleaseTypeDropdown", "AddRelease_ReleaseType_Option", "Release_Type_Name");
		releasePage.clickElementUsingJavaScript("AddRelease_StatusDropdown", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_FirstOption");
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_SecondOption");
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_ThirdOption");
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_FourthOption");
		
		releasePage.clickOnReleaseField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_ReleaseTypeDropdown", "AddRelease_ReleaseType_Option", "Release_CopyToType_Name");
		releasePage.clickElementUsingJavaScript("AddRelease_StatusDropdown", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_FirstOption");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_SecondOption");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_ThirdOption");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyWorkflowStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_Status_Dropdown_Option", "AddRelease_Status_Textbox", "Workflow_Status_FourthOption");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleaseStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Type_Name");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CopyToType_Name");
	
	}
	@Test (description="Release Phases, including/excluding weekends/blockouts")
	public void customizationReleases_06() throws InterruptedException, ParseException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  created successfully !");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  created successfully !");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  created successfully !");
		
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleasePhases_Option","Phase_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhase(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhase(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhase(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option", "Phase_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option", "Customization_PhasesGates_Enterprise_Default_Checkbox", "Phase_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option", "Customization_PhasesGates_Project_Default_Checkbox", "Phase_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option", "Customization_PhasesGates_Independent_Default_Checkbox", "Phase_Name");
				
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Phase_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified after updation of phase name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Disable_Workflow", "Customization_PGBlockout_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyReleasePhaseExcludeWeekendDaysOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name"),"dd/MM/yyyy", "10", 
				releasePage.getCountOfWeekDays(releasePage.getTodayDate("0", "dd/MM/yyyy"), releasePage.getTodayDate("10", "dd/MM/yyyy"),"dd/MM/yyyy"),"0");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Disable_Workflow", "Customization_PGWeekend_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		
		new BlockoutPage().gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		new BlockoutPage().addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation","10");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyReleasePhaseExcludeBlackoutOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name"),"dd/MM/yyyy", "-10", 20,"0");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Phase_Name");
	
	}
	@Test (description="Release Gates, including/excluding weekends/blockouts")
	public void customizationReleases_07() throws InterruptedException, ParseException  {
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  created successfully !");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  created successfully !");
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseGates_Option","Gate_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified after creation successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified after creation successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified after creation successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option", "Gate_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option", "Customization_PhasesGates_Enterprise_Default_Checkbox", "Gate_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option", "Customization_PhasesGates_Project_Default_Checkbox", "Gate_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option", "Customization_PhasesGates_Independent_Default_Checkbox", "Gate_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_PhasesAndGates_Name","Gate_Name" ,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+"  verified after updation of gate name successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Disable_Workflow", "Customization_PGBlockout_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyReleasePhaseExcludeWeekendDaysOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name"),"dd/MM/yyyy", "10", 
				releasePage.getCountOfWeekDays(releasePage.getTodayDate("0", "dd/MM/yyyy"), releasePage.getTodayDate("10", "dd/MM/yyyy"),"dd/MM/yyyy"),"0");
		
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Disable_Workflow", "Customization_PGWeekend_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new BlockoutPage().gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		new BlockoutPage().addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation","10");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyReleasePhaseExcludeBlackoutOption(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Gate_Name"),"dd/MM/yyyy", "-10", 20,"0");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseGates_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Gate_Name");
	
	}
	
	@Test (description="Release Package")
	public void customizationReleases_16() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleasePackage_Option","Package_Name_1");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_ReleasePackage_Enable", "Customization_ReleasePackage_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.editReleasePackageDate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_1", "2");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")+"  created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Package_Label", PlutoraConfiguration.releasesData);
		releasePage.verifyTextContains(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Package_Text").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1")+"  verified successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePackage_Option", "Package_Name_1");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Package_Label", PlutoraConfiguration.releasesData);
		releasePage.verifyTextContains(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Package_Text").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_1")+"  verified after update package name successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateBulkReleasePackage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePackage_Option", "Package_Name_2", "1");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Package_Label", PlutoraConfiguration.releasesData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyTextContains(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Package_Text").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_Automation")),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+"00");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Package_Name_2")+"  verified after bulk package update successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleasePackage_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_1");
		customizationPage.deletePackageCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Package_Name_2");
	}
	
	@Test (description="Systems - Deployment Type")
	public void customizationReleases_23() throws InterruptedException, ParseException  {
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_System_DeploymentType_option","DeploymentType_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation", "ER_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.linkSystemToEnterpriseRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation");
		
		/*releasePage.clickElementUsingJavaScript("Releases_Applications_Tab", PlutoraConfiguration.releasesData);
		Thread.sleep(2000);
		releasePage.clickElementUsingJavaScript("Releases_Systems_AddButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickElementUsingJavaScript("Releases_Systems_AddDeploymentButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		Thread.sleep(3000);*/
		
		releasePage.addEnterpriseDeploymentDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"DeploymentType_Name","ER_Automation");
		releasePage.verifyText("Releases_Systems_Deployment_Type", "DeploymentType_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentType_Name")+"  verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_System_DeploymentType_option", "DeploymentType_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		
		releasePage.verifyText("Releases_Systems_Deployment_Type", "DeploymentType_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentType_Name")+"  verified after updation successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_System_DeploymentType_option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "DeploymentType_Name");
	}
	@Test (description="Systems - Deployment To")
	public void customizationReleases_25() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_System_DeploymentTo_option","DeploymentTo_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.doubleClick("Releases_Systems_DeploymentTo_Text", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.verifyText("Releases_Systems_DeploymentToDropdown_Option", "DeploymentTo_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentTo_Name")+"  verified successfully !");
		
		releasePage.click("Releases_Systems_DeploymentToDropdown_Option", "DeploymentTo_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(200,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_UpdateButton", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization Release Deployment Default checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_System_DeploymentTo_option","Customization_System_DeploymentTo_Default_Checkbox","DeploymentTo_Name");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_DeploymentTo_Text", "DeploymentTo_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentTo_Name")+"  verified after default checkbox successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_System_DeploymentTo_option", "DeploymentTo_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_DeploymentTo_Text", "DeploymentTo_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentTo_Name")+"  verified after updation successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_System_DeploymentTo_option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "DeploymentTo_Name");
	}
	@Test (description="Systems - Deployment Status Label")
	public void customizationReleases_26() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Deployment_Status_Label");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Pending_CustomStatus_Radio_Button", "Customization_Deployment_Pending_CustomStatus_Textbox", "Pending", "Custom");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Completed_CustomStatus_Radio_Button", "Customization_Deployment_Completed_CustomStatus_Textbox", "Completed", "Custom");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Rejected_CustomStatus_Radio_Button", "Customization_Deployment_Rejected_CustomStatus_Textbox", "Rejected", "Custom");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		releasePage.refresh(PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_EDeploymentDates_Endorsed_Text", PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Systems_EDeploymentDates_Pending_Text", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addCustomizationDeploymentDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PR_Automation");	
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_PDeploymentDates_Completed_Text","Completed",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Systems_PDeploymentDates_Pending_Text","Pending", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_ProjectCloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.addCustomizationDeploymentDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Completed_Text","Completed",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Pending_Text","Pending", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Rejected_Text","Rejected", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_ProjectCloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Deployment_Status_Label");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Pending_Status_Radio_Button", "", "Pending", "");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Completed_Status_Radio_Button", "", "Completed", "");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Deployment_Rejected_Status_Radio_Button", "", "Rejected", "");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_EDeploymentDates_Endorsed_Text", PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Systems_EDeploymentDates_Pending_Text", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_PDeploymentDates_Completed_Text","Completed",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Systems_PDeploymentDates_Pending_Text","Pending", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_ProjectCloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Completed_Text","Completed",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Pending_Text","Pending", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//releasePage.validateElementDisplayed("Releases_Systems_IDeploymentDates_Rejected_Text","Rejected", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_ProjectCloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
	}
	@Test (description="Event Type")
	public void customizationReleases_28() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Type_Option", "Event_Type_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Type_Name")+ " - Release Event Type is created successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.createEvent(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Event type
		releasePage.verifyReleaseOptions(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ER_Automation","Releases_Event_TypeDropdown","Releases_Event_TypeDropdown_Option","Releases_Event_Type_Text","Event_Type_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization event Type
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Type_Option","Customization_ReleaseEvent_Type_Default_Checkbox","Event_Type_Name");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify event Type
		releasePage.verifyText("Releases_Event_Type_Text","Event_Type_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Type_Name")+ " - is displayed by default successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization event type
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Type_Option","Event_Type_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify event Type
		releasePage.verifyText("Releases_Event_Type_Text","Event_Type_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Type_Name")+ " - is displayed by default successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseEvent_Type_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Event_Type_Name");
		
	}
	@Test (description="Event Status")
	public void customizationReleases_30() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Status_Option", "Event_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Status_Name")+ " - Release Event Type is created successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.createEvent(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Event status
		releasePage.verifyReleaseOptions(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ER_Automation","Releases_Event_StatusDropdown","Releases_Event_StatusDropdown_Option","Releases_Event_Status_Text","Event_Status_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization Event status
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Status_Option","Customization_ReleaseEvent_Status_Default_Checkbox","Event_Status_Name");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify Release Type
		releasePage.verifyText("Releases_Event_Status_Text","Event_Status_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Status_Name")+ " - is displayed by default successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Status_Option","Event_Status_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify Event Status
		releasePage.verifyText("Releases_Event_Status_Text","Event_Status_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Status_Name")+ " - is displayed by default successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseEvent_Status_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Event_Status_Name");
	}
	@Test (description="Event Portfolio")
	public void customizationReleases_29() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Portfolio_Option", "Event_Portfolio_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Portfolio_Name")+ " - Release Event Portfolio is created successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.createEvent(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Release Portfolio
		releasePage.verifyReleaseOptions(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"ER_Automation","Releases_Event_PortfolioDropdown","Releases_Event_PortfolioDropdown_Option","Releases_Event_Portfolio_Text","Event_Portfolio_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization Release Portfolio
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Portfolio_Option","Customization_ReleaseEvent_Portfolio_Default_Checkbox","Event_Portfolio_Name");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify Release Portfolio
		releasePage.verifyText("Releases_Event_Portfolio_Text","Event_Portfolio_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Portfolio_Name")+ " - is displayed by default successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization Release Portfolio
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseEvent_Portfolio_Option","Event_Portfolio_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//Verify Release Portfolio
		releasePage.verifyText("Releases_Event_Portfolio_Text","Event_Portfolio_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Portfolio_Name")+ " - is updated by new name successfully");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseEvent_Portfolio_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Event_Portfolio_Name");
	}
	@Test (description="Event Management")
	public void customizationReleases_27() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Event_Management_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Event_Management_Disable", "Customization_Event_Management_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		Listener.addLogger("Release Event Management is Disabled successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyTextEqualsNotDisplayedInPage("Event");
		Listener.addLogger("Event Tab is not available in release details Page");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Event_Management_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Event_Management_Enable", "Customization_Event_Management_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.verifyTextDisplayedInPage("Event");
		Listener.addLogger("Event Tab is available in release details Page");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Systems - Subtype Customization")
	public void customizationReleases_31() throws InterruptedException, ParseException  {
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Sub_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Sub_Automation")+"  created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option", "Subtype_Name");
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option", "Customization_ReleaseSystem_Subtype_Enabled_Checkbox", "Subtype_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Sub_Automation","Releases_EnterpriseSystems_Subtype_Section","Subtype_Name");
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.verifyText("Releases_SystemsName_Text","System_Sub_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Sub_Automation")+" System is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Sub_Automation","Releases_NonEnterpriseSystems_Subtype_Section","Subtype_Name");
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.verifyText("Releases_SystemsName_Text","System_Sub_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Sub_Automation")+" System is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Sub_Automation","Releases_NonEnterpriseSystems_Subtype_Section","Subtype_Name");
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.verifyText("Releases_SystemsName_Text","System_Sub_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Sub_Automation")+" System is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option", "Subtype_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_Section_Name","Subtype_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseSystem_Subtype_Option");
		customizationPage.deleteCustomsReleaseSystemsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Subtype_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is not displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is not displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Subtype_Name")+" System Section Name is not displayed in Impacted Grid Successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Blockout Type")
	public void customizationReleases_33() throws InterruptedException, ParseException  {
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Blockout_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option", "Blockout_Type_Name");
		customizationPage.addCustomizationIcon(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Type_Name");
		
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		blockoutPage.verifyBlockoutPeriodOptions(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation", "Blockout_Type_Dropdown", "Blockout_Type_Dropdown_Option", "Blockout_Type_Textbox", "Blockout_Type_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option", "Customization_BlockoutType_Default_Checkbox", "Blockout_Type_Name");
		
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		blockoutPage.verifyTextAttributeValue("Blockout_Type_Textbox", "Blockout_Type_Name",PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData);
		blockoutPage.clickOnSaveAndCloseButton(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type_Name")+" Blockout Period Type is verified successfully after selection of default checkbox");

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option", "Blockout_Type_Name");
		
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		blockoutPage.verifyTextAttributeValue("Blockout_Type_Textbox", "Blockout_Type_Name",PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData);
		blockoutPage.clickOnSaveAndCloseButton(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type_Name")+" Blockout Period Type is verified successfully after updating blockout type");
		
		//Customization Scheduler Color untick checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_BlockoutType_StandardColors_Disable", "Customization_BlockoutType_StandardColors_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Customization Scheduler Color tick checkbox
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_BlockoutType_StandardColors_Enable", "Customization_BlockoutType_StandardColors_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Type_Name");
	
	}
	@Test (description="Systems - Enterprise Setup")
	public void customizationReleases_24() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemsEnterprise_Setup_Option");
		customizationPage.addSystemsEnterpriseSetupColumnsName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Type_Column"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deploying_To_Column"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Type_Column"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_StartDate_Column"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_EndDate_Column"));
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Status_Column"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemsEnterprise_Setup_Option", "Enterprise_Type");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.doubleClick("Releases_Systems_EnterpriseType_Text", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.verifyText("Releases_Systems_EnterpriseType_Dropdown_Option", "Enterprise_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.click("Releases_Systems_EnterpriseType_Dropdown_Option", "Enterprise_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(200,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_UpdateButton", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_SystemsEnterprise_Setup_Option", "Enterprise_Type");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Applications_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_DeploymentDates_Text", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Systems_EnterpriseType_Text", "Enterprise_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Systems_Deployment_CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration. objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SystemsEnterprise_Setup_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Type");
		
	}
	
	@Test (description="Channel Impacting System")
	public void customizationReleases_41() throws InterruptedException {
		
		//System Creation one
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option", "Release_Type");
				
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChannelImpactingSystem_Option");
		customizationPage.addChannelImpactingSystem(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation", "Release_Type");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - added channel impacting system successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnReleaseField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_ReleaseTypeDropdown", "AddRelease_ReleaseType_Option", "Release_Type");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage("Channel Impacting");
		Listener.addLogger("Channel Impacting custom field displayed in Release additional information tab successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ChannelImpactingSystem_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_ChannelImpactingSystem_Enable_Disable_Checkbox","Customization_ChannelImpactingSystem_Enable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_ChannelImpactingSystem_Submit_Button",PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage("Channel Impacting");
		Listener.addLogger("Channel Impacting custom field displayed in Release additional information tab successfully after disabled enable  !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Type");
		
	}
	
	@Test (description="Release Setup - Release Dependency Label")
	public void customizationReleases_14() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CustomReleaseDependency_Checkbox", "Customization_CustomReleaseDependency_Textbox", "Release_Dependency", "Custom");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency")+" displayed in Independent release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency")+" displayed in project release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.addReleaseTabNames(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseDependency_Label", "", "Release_Dependency", "");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency")+" default displayed in Independent release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Dependency")+" default displayed in Project release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
	}
	@Test (description="Enterprise Release Setup - Enable editable text field for each System in Systems tab of the Release ")
	public void customizationReleases_15() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Systems_Tab_Enable", "Customization_Systems_Tab_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.sendKeys("Customization_Systems_Tab_Textbox", PropertiesCache.setProperty(PlutoraConfiguration.testData, "Systems_Test"),PlutoraConfiguration.customizationData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" displayed in enterprise release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" displayed in project release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" displayed in independent release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Systems_Tab_Disable", "Customization_Systems_Tab_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" not displayed in enterprise release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" not displayed in project release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")+" not displayed in independent release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Capacity Management")
	public void customizationReleases_34() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_CapacityManagement_Disable_Workflow", "Customization_CapacityManagement_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.verifyTextEqualsNotDisplayedInPage("Capacity");
		Listener.addLogger("Capacity tab not displayed in Project release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);

		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.verifyTextEqualsNotDisplayedInPage("Capacity");
		Listener.addLogger("Capacity tab not displayed in Independent release page successfully ! ");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_CapacityManagement_Enable_Workflow", "Customization_CapacityManagement_Disable_Workflow", PlutoraConfiguration.objectData, "xpath");
		customizationPage.sendKeys("Customization_Bucket_Overflow_Textbox", "100",PlutoraConfiguration.customizationData);
		customizationPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option", "CapacityA");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option", "CapacityB");
		customizationPage.updateCapacityManagement(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityA", "5", "10", "Customization_CapacityManagement_Actual_Enable_Checkbox", "Customization_CapacityManagement_Actual_Disable_Checkbox","Customization_Change_Yellow_Color");
		customizationPage.updateCapacityManagement(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityB", "5", "10", "Customization_CapacityManagement_Planned_Enable_Checkbox", "Customization_CapacityManagement_Planned_Disable_Checkbox","Customization_Change_Green_Color");
	
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_Automation");
		releasePage.updateCapacitySize(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityA", "3", "3");
		releasePage.updateCapacitySize(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityB", "6", "6");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_Automation");
		releasePage.updateCapacitySize(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityA", "3", "3");
		releasePage.updateCapacitySize(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityB", "6", "6");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.selectCapacitySizeItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityA", "CapacityB");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_Automation");
		//releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Yellow_Color", PlutoraConfiguration.releasesData);
	//	releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Green_Color", PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Yellow_Color_Percentage","CapacityA", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Green_Color_Percentage","CapacityB", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Percentage", releasePage.calculateCapacitySize("3", "3", "10"),PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Percentage", releasePage.calculateCapacitySize("6", "6", "10"),PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Under_Text", releasePage.calculateCapacitySizeUnder("3", "3", "10"),PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Bucket_Over_Text", releasePage.calculateCapacitySizeOver("6", "6", "10"),PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Threshold_Value","0",PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Threshold_Value","5",PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Capacity_Size_Threshold_Value","10",PlutoraConfiguration.releasesData);
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_Automation")+" displayed in capacity tab successfully ! ");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_Automation")+" displayed in capacity tab successfully ! ");
		
		releasePage.verifyText("Releases_Capacity_Size_CA_Total_Planned","6",PlutoraConfiguration.releasesData);
		
		releasePage.verifyText("Releases_Capacity_Size_CA_Total_Actual","6",PlutoraConfiguration.releasesData);
		releasePage.verifyText("Releases_Capacity_Size_CB_Total_Planned","12",PlutoraConfiguration.releasesData);
		releasePage.verifyText("Releases_Capacity_Size_CB_Total_Actual","12",PlutoraConfiguration.releasesData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityManagement_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityA");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CapacityB");
	}
	
	@Test (description="Enterprise Release Setup - Enable Enterprise Release Activities Child Push functionality")
	public void customizationReleases_09() throws InterruptedException, ParseException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ER_ReleaseSetup")+"  created successfully !");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PR_ReleaseSetup")+"  created successfully !");
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_ReleaseSetup");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_ReleaseSetup")+"  created successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Disable", "Customization_Dependency_Association_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Disable", "Customization_Completed_Date_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Disable", "Customization_AC_Dates_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		releasePage.pushActivityChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_1","Activity_Automation_Name_1","Release_Activity_Child_Tab","PR_ReleaseSetup","PRelease_Automation_Name","Releases_AddNewActivity_Option",0);
		releasePage.pushActivityChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_2","Activity_Automation_Name_2","Release_Activity_EnterpriseAndChild_Tab","PR_ReleaseSetup","PRelease_Automation_Name","Releases_AddNewActivity_Option",1);
		releasePage.pushActivityChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_1","Criteria_Automation_Name_1","Release_Activity_Child_Tab","PR_ReleaseSetup","PRelease_Automation_Name","Releases_AddNewCriteria_Option",2);
		releasePage.pushActivityChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_2","Criteria_Automation_Name_2","Release_Activity_EnterpriseAndChild_Tab","PR_ReleaseSetup","PRelease_Automation_Name","Releases_AddNewCriteria_Option",3);
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.verifyText("Release_Activity_Id","Activity_Automation_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Id","Activity_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Id","Criteria_Automation_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Id","Criteria_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		releasePage.verifyText("Release_Activity_Name","Activity_Automation_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Activity_Automation_Name_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Criteria_Automation_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Criteria_Automation_Name_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
	
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate")+"']")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_ForecastDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_ForecastDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_ForecastDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_ForecastDate")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_StartDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_StartDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_StartDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_StartDate")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Status_0")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Status_1")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Status_2")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Status_3")+"')]")).isDisplayed();
		assertTrue(flag);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Enterprise Release Setup - Release Dependency Association - Lock the main fields in the Dependent Release for Enterprise defined Activities/Criteria")
	public void customizationReleases_10() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Disable", "Customization_Completed_Date_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Disable", "Customization_AC_Dates_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.verifyChildPushFieldsDisabled(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_1");
		releasePage.verifyChildPushFieldsDisabled(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_2");
		releasePage.verifyChildPushFieldsDisabled(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_1");
		releasePage.verifyChildPushFieldsDisabled(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_2");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Enterprise Release Setup - Enable Actual Completed Date (overrides Due Date)")
	public void customizationReleases_11() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Enable", "Customization_Completed_Date_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Disable", "Customization_AC_Dates_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//3
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_3","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Activity_Automation_3");
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.verifyDate(releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"),releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_3","Criteria_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Criteria_Automation_3");
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.verifyDate(releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"),releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_3");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_3");
		
		/*releasePage.updateActivityStatusFromGrid(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "Activity_Automation_3");
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatusFromGrid(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "Criteria_Automation_3");
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_3");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_3");
		
		releasePage.updateActivityStatusBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_3", "Criteria_Automation_3", "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_3")), "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_3")), "Completed");
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_3");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_3");*/
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sendKeysWithEnter("Releases_SearchButton","ReleaseSetup",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.updateReleaseActivityBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup", "PR_ReleaseSetup", "Activity_Test_Automation_Name", "Criteria_Test_Automation_Name", "Completed");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_3")), "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_3")), "Completed");
		
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.verifyDate( releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"),releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_3", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.verifyDate(releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"),releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Enterprise Release Setup - Calculate Release Traffic Lights")
	public void customizationReleases_12() throws InterruptedException, ParseException  {
		//-----------------4
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Enable", "Customization_Completed_Date_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Traffic_Lights_Enable", "Customization_Traffic_Lights_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Disable", "Customization_AC_Dates_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//4
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.createActivityActualCompletedDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_4","Activity_Test_Automation_Name","Completed","Releases_AddNewActivity_Option");
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.createActivityActualCompletedDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Automation_4","Criteria_Test_Automation_Name","Completed","Releases_AddNewCriteria_Option");
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_4");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_4");
		
	/*	releasePage.updateActivityStatusFromGrid(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "Activity_Automation_4");
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatusFromGrid(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "Criteria_Automation_4");
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_4");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_4");*/
		
		releasePage.updateActivityStatusBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation_4", "Criteria_Automation_4", "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_4")), "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_4")), "Completed");
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity_Automation_4");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria_Automation_4");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sendKeysWithEnter("Releases_SearchButton","ReleaseSetup",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.updateReleaseActivityBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup", "PR_ReleaseSetup",  "Activity_Test_Automation_Name", "Criteria_Test_Automation_Name", "Completed");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_4")), "Completed");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_4")), "Completed");
		
		releasePage.clickButton("Release_Activity_Id", "Activity_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.clickButton("Release_Activity_Id", "Criteria_Automation_4", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyDate(releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Actual_Completed_Date_Textbox")), releasePage.getTodayDate("0", "dd/MM/yyyy HH:mm"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Enterprise Release Setup - Update and move Activities/Criteria dates when changeing Phases/Gates dates via Release window or via Release Bulk Update window")
	public void customizationReleases_13() throws InterruptedException, ParseException  {
		boolean flag=false;
		//-----------------5
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Enable", "Customization_Completed_Date_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Traffic_Lights_Enable", "Customization_Traffic_Lights_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Enable", "Customization_AC_Dates_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "ER_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Tab", PlutoraConfiguration.objectData);
		releasePage.updatePhaseAndGateDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName"),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate"));
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		 flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PR_ReleaseSetup");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+" displayed forecast date column successfully !");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+" displayed forecast date column successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_ReleaseSetup");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IR_ReleaseSetup");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IR_ReleaseSetup")+" Validation Points----------------------------------------------!");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+" displayed start date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+" displayed start date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+" displayed start date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+" displayed start date column successfully !");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+" displayed due date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+" displayed due date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+" displayed due date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+" displayed due date column successfully !");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_1")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation_2")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_1")+" displayed forecast date column successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Automation_2")+" displayed forecast date column successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Release_Setup");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Completed_Date_Enable", "Customization_Completed_Date_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AC_Dates_Enable", "Customization_AC_Dates_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	
	
}
