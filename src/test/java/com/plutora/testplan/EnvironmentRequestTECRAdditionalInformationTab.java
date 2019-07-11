package com.plutora.testplan;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestTECRAdditionalInformationTab {
	
	TECRPage tecrPage = new TECRPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: TECR window -> Additional Information tab -> Testcase")
	public void subareaEnvironmentRequestTECRAdditionalInformation_01() throws InterruptedException, ParseException {	
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		
		customizationPage.addEnvironmentDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.environmentDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.environmentDataTypeOption.get(i),"TECR_CustomField_Name");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		
		tecrPage.verifyAdditionalInformationTab(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.customizationData,PlutoraConfiguration.environmentData,customizationPage.environmentDataTypeOption.get(i));
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	
	@Test (description="Sub-area: TECR window -> Additional Information tab -> Information tooltip")
	public void subareaEnvironmentRequestTECRAdditionalInformation_02() throws InterruptedException, ParseException {	
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","TECR_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Tooltip", "TECR_Tooltip");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		Assert.assertTrue(TECRPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Tooltip")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Tooltip")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","TECR_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Label", "TECR_Label");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Label")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Tooltip");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Label");
	}
	@Test (description="Sub-tabs")
	public void subareaEnvironmentRequestTECRAdditionalInformation_03() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		//Add Tab
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		//Create custom field
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name","Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyText("TECR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	
		//Edit Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyText("TECR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	
		//Remove Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name");
	}
	
	@Test (description="Grouping Fields")
	public void subareaEnvironmentRequestTECRAdditionalInformation_04() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		//Add Group
		customizationPage.createCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option", "TECR_CustomField_Name");
		customizationPage.selectGroupField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name","Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyText("TECR_CustomField_Group_Name", "Group",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		//Edit Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.editCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyText("TECR_CustomField_Group_Name", "Group",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	
		//Remove Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.removeCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.click("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_AdditionalInformation_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tecr details page successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_CustomField_Name");

	}
	
	
	
}
