package com.plutora.testplan;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowActivitiesTabCustomFields {
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: release window -> Activites  Tab -> DataPicker/TimePicker/Data time picker/List Field/List Select/Free Text/Number/Contact/Decimal")
	public void subareaReleaseWindowActivitiesTabCustomFields_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project release is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name","Activity_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Custom field add
		customizationPage.addCapacityDataTypeList();
		customizationPage.sleep(2000);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_Activity/CriteriaCustomFields_Option","AC_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.capacityDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.capacityDataTypeOption.get(i),"AC_CustomField_Name");
		//Release Page Search
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Release Page Additional Information Verification
		releasePage.verifyACAdditionalInformation(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AC_CustomField_Name",customizationPage.capacityDataTypeOption.get(i),"Project_Automation","Activity_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Activity/CriteriaCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AC_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	
	@Test (description="Sub-area: release window -> Activites  Tab -> Information tooltip")
	public void subareaReleaseWindowActivitiesTabCustomFields_02() throws InterruptedException, ParseException {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option", "AC_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","AC_CustomField_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option", "AC_CustomField_Name", "Release_Tooltip");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		//releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_ActivitesTab",PlutoraConfiguration.objectData);
		//releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		Assert.assertTrue(ReleasePage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+" verified in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save&CloseButton",PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option", "AC_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","AC_CustomField_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option", "AC_CustomField_Name", "Release_Label");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_ActivitesTab",PlutoraConfiguration.objectData);
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AC_CustomField_Name")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label")+" verified in release details page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save&CloseButton",PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Activity/CriteriaCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AC_CustomField_Name");
	}
	
	
	
	
}
