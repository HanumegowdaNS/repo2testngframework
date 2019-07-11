package com.plutora.testplan;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRWindowAdditionalInformationTab {
	PIRPage pirPage = new PIRPage();
	CustomizationPage customizationPage = new CustomizationPage();

	@Test (description="Sub-area: PIR window -> Additional Information Tab")
	public void subareaPIRWindowAdditionalInformationTab_01() throws InterruptedException, ParseException {	
		pirPage.refresh(PlutoraConfiguration.objectData);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.sleep(1000);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_Page_Title");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		customizationPage.addPIRDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		System.out.println(customizationPage.pirDataTypeOption.size());
		for(int i=0;i<customizationPage.pirDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.pirDataTypeOption.get(i),"PIR_CustomField_Name");
		customizationPage.clickOnElement(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "CustomizationHeader");
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		//pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(6000);
		
		pirPage.verifyPIRAdditionalInformationTab(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.pirDataTypeOption.get(i));
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.test1.log(Status.INFO,"Customization field is verified after deletion from Customization Page !");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		//delete pir data
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		//pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.test1.log(Status.INFO,"PIR test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}

	@Test (description="Sub-area: PIR window -> Information tooltip")
	public void subareaPIRWindowAdditionalInformationTab_02() throws InterruptedException, ParseException {	

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option", "PIR_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","PIR_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option", "PIR_CustomField_Tooltip", "PIR_Tooltip");
		
		pirPage.sleep(2000);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		Assert.assertTrue(EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Tooltip")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Tooltip")+" verified in PIR details page successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option", "PIR_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","PIR_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option", "PIR_CustomField_Label", "PIR_Label");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		pirPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Label")+" verified in PIR details page successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_CustomField_Tooltip");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_CustomField_Label");
	}
	@Test (description="Sub-area: PIR window -> Sub tabs")
	public void subareaPIRWindowAdditionalInformationTab_03() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		//Add Tab
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		//Create custom field
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option", "PIR_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name","Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		pirPage.verifyText("PIR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in pir details page successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	
		//Edit Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		pirPage.verifyText("PIR_CustomField_Tab_Name", "Tab",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in pir details page successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	
		//Remove Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_AdditionalInformation_Tab");
		pirPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in PIR details page successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_CustomField_Name");
	}
	
	
}
