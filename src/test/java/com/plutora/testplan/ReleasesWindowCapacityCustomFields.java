package com.plutora.testplan;



import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesWindowCapacityCustomFields {
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	
	@Test (description="Sub-area: release window -> Capacity tab -> custom fields-> DataPicker/TimePicker/Data time picker/List Field/List Select/Free Text/Number/Contact/Decimal")
	public void subareaReleaseWindowCapacityCustomFields_01() throws InterruptedException, ParseException {	
		customizationPage.addCapacityDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//create custom field
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option","Capacity_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.capacityDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.capacityDataTypeOption.get(i),"Capacity_CustomField_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Verify custom fields
		releasePage.verifyCapacityFields(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.releaseCapacityDataTypeOption.get(i),"Capacity_CustomField_Name");
		releasePage.sleep(2000);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_CapacityCustomFields_Option");
		}
		//Delete custom field
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Capacity_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" - is deleted successfully !");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
	}
	
	@Test (description="Information tooltip")
	public void subareaReleaseWindowCapacityCustomFields_02() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Create custom field for tooltip
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","Capacity_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Update Custom field
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Tooltip", "Release_Tooltip");
		//Verify tooltip in release page
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Capacity_Tab",PlutoraConfiguration.objectData);
		Assert.assertTrue(ReleasePage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Tooltip")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Create customfield for Label
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","Capacity_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Update customfield for Label
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Label", "Release_Label");
		//Verify Label in release page
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Capacity_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Delete custom fields
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Capacity_CustomField_Tooltip");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Capacity_CustomField_Label");
	}
	
}
