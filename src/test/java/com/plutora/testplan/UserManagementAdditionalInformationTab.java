package com.plutora.testplan;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class UserManagementAdditionalInformationTab {
	
	NewUserPage userManagement = new NewUserPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description=" -> Additional Information Tab")
	public void userManagement_01() throws InterruptedException, ParseException{
		//Add custom field
		customizationPage.addDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_UserCustomField_Option","UM_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.dataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.dataTypeOption.get(i),"UM_CustomField_Name");
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "NewUser_SearchedEditButton", PlutoraConfiguration.objectData);
		//Verify additional information tab 
		userManagement.verifyAdditionalInformationTab(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.dataTypeOption.get(i),"UserManagement_Username");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_UserCustomField_Option");
		}
		//Delete Custom field
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UM_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	@Test (description=" -> Information tooltip")
	public void userManagement_02() throws InterruptedException, ParseException{
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option", "UM_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","UM_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option", "UM_CustomField_Tooltip", "UM_Tooltip");
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "NewUser_SearchedEditButton", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData,"Usermanagement_AdditionalInformation_Tab",PlutoraConfiguration.objectData);
		Assert.assertTrue(NewUserPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_CustomField_Tooltip")+"')]/following-sibling::div[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_Tooltip")+" verified in usermanagement details page successfully !");
		userManagement.clickOnSaveAndCloseButton(PlutoraConfiguration.userManagementData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option", "UM_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","UM_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option", "UM_CustomField_Label", "UM_Label");
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "NewUser_SearchedEditButton", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData,"Usermanagement_AdditionalInformation_Tab",PlutoraConfiguration.objectData);
		userManagement.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UM_Label")+" verified in usermanagement details page successfully !");
		userManagement.clickOnSaveAndCloseButton(PlutoraConfiguration.userManagementData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UM_CustomField_Tooltip");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_UserCustomField_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UM_CustomField_Label");
	}
	
}	
