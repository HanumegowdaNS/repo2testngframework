package com.plutora.testplan;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestTEBRAdditionalInformationTab {
	
	TEBRPage tebrPage = new TEBRPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test (description="Sub-area: TEBR window -> Additional Information tab -> Testcase")
	public void subareaEnvironmentRequestTEBRAdditionalInformation_01() throws InterruptedException, ParseException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		
		customizationPage.addEnvironmentDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.environmentDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.environmentDataTypeOption.get(i),"TEBR_CustomField_Name");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.clickElementUsingJavaScript("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		
		tebrPage.verifyAdditionalInformationTab(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.tebrData,customizationPage.environmentDataTypeOption.get(i));
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	
	@Test (description="Sub-area: TEBR window -> Additional Information tab -> Information tooltip")
	public void subareaEnvironmentRequestTEBRAdditionalInformation_02() throws InterruptedException, ParseException {	
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","TEBR_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Tooltip", "TEBR_Tooltip");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Assert.assertTrue(TEBRPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Tooltip")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Tooltip")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","TEBR_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Label", "TEBR_Label");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickElementUsingJavaScript("TEBR_Label",PlutoraConfiguration.tebrData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Label")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Tooltip");
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Label");
	}
	@Test (description="Sub-tabs")
	public void subareaEnvironmentRequestTEBRAdditionalInformation_03() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		//Add Tab
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		//Create custom field
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name","Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	
		//Edit Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickElementUsingJavaScript("TEBR_Label",PlutoraConfiguration.tebrData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	
		//Remove Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickElementUsingJavaScript("TEBR_Label",PlutoraConfiguration.tebrData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name");
	}
	
	@Test (description="Grouping Fields")
	public void subareaEnvironmentRequestTEBRAdditionalInformation_04() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		//Add Group
		customizationPage.createCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option", "TEBR_CustomField_Name");
		customizationPage.selectGroupField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name","Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_CustomField_Group_Name", "Group",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		//Edit Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.editCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_CustomField_Group_Name", "Group",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	
		//Remove Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.removeCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickElementUsingJavaScript("TEBR_Label",PlutoraConfiguration.tebrData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in tebr details page successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_CustomField_Name");

		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
	}
	
	
}
