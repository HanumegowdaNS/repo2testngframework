package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationPIR {
	CustomizationPage customizationPage = new CustomizationPage();
	PIRPage pirPage = new PIRPage();
	NewUserPage userPage = new NewUserPage();

	@Test (description="Post Implementation Review Custom Fields view/edit/hide permissions by User")
	public void customizationPIR_03() throws InterruptedException  {
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value")+" - Option selected for Verification successfully ! ");
		//View Value Verification
		pirPage.refresh(PlutoraConfiguration.objectData);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName,"PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//Edit Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//View Custom Field Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - PIR Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Post Implementation Review Custom Fields view/edit/hide permissions by Organization")
	public void customizationPIR_04() throws InterruptedException  {
		//User Management values updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingOrganizationAssociationText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Organization_Text","UM_Org_Text");
		CustomizationPage.flag=false;
		//View Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		//View Value Verification
		pirPage.refresh(PlutoraConfiguration.objectData);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickOnButton(PlutoraConfiguration.pirData,"PIR_Yes_Button",PlutoraConfiguration.objectData);
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		//Edit Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value");
		//Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Organization", "UM_Org_Text", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field", "Organization", "UM_Org_Text", "");
		//Custom Field Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field");
		//Delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - PIR Custom Field is deleted successfully ! ");
	}
	@Test (description="Post Implementation Review Custom Fields view/edit/hide permissions by Role")
	public void customizationPIR_05() throws InterruptedException  {
		userPage.refresh(PlutoraConfiguration.objectData);
		//User Management value updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		//View Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickOnButton(PlutoraConfiguration.pirData,"PIR_Yes_Button",PlutoraConfiguration.objectData);
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		//Edit Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field", "Role", "UM_Role_List", "");
		//View Custom Field Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DP_CustomField_Name")+" - PIR Custom Field is deleted successfully ! ");
	}
	@Test (description="Post Implementation Review Custom Fields view/edit/hide permissions by User Group")
	public void customizationPIR_06() throws InterruptedException  {
		//User Management Values Updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
		//View Value Setup
		CustomizationPage.flag=false;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		//View Value Verification
		pirPage.refresh(PlutoraConfiguration.objectData);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickOnButton(PlutoraConfiguration.pirData,"PIR_Yes_Button",PlutoraConfiguration.objectData);
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		//Edit Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value");
		//View Custom Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		//View Custom Value Verification
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.verifyPIRFieldPermissionCustomField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - PIR Custom Field is deleted successfully ! ");
	}
	
	
	@Test (description="Post Implementation Review Custom Field")
	public void customizationPIR_02() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PIR_ResetToDefault_Button",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Create Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified successfully");
		//Update Custom field
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option","PIR_CustomField_Name","PIR_CustomField_Description");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Description"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Description")+" - Custom field Description is verified successfully");
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="Post Implementation Review Custom Lists")
	public void customizationPIR_07() throws InterruptedException  {
		//Add Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified successfully");
		
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "List Field", "PIR_CustomField_Name");
		//Add Custom List
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomLists_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+" - Custom List is verified successfully");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_2")+" - Custom List is verified successfully");
		//Edit Custom Field
		customizationPage.editCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified successfully");
		//Edit Custom List
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomLists_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name","CustomList_1");
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
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomLists_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		//Delete Custom Field
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" - Custom field name is verified after deletion successfully");
		//Mandatory
		customizationPage.verifyMandatoryFields(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeleteField_Button", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="PIR Status")
	public void customizationPIR_08() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRStatus_Option","PIR_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Status_Name")+ " - PIR Status Name is created successfully");
		//Open PIR
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickOnButton(PlutoraConfiguration.pirData,"PIR_Yes_Button",PlutoraConfiguration.objectData);
		//Verify PIR Status
		pirPage.verifyPIRFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddPIR_StatusDropdown","PIR_Status_Option","PIR_Status_Textbox","PIR_Status_Name");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRStatus_Option","Customization_PIRStatus_Default_Checkbox","PIR_Status_Name");
		
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Verify PIR Status
		pirPage.verifyText("PIR_Status_Textbox","PIR_Status_Name",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Status_Name")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	//	pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR status
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRStatus_Option","PIR_Status_Name");
		
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Verify PIR status
		pirPage.verifyText("PIR_Status_Textbox","PIR_Status_Name",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Status_Name")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Name");
	}
	@Test (description="PIR Workflow")
	public void customizationPIR_09() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRType_Option","PIR_Type_Name");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRType_Option","PIR_CopyToType_Name");
		customizationPage.addWorkflowProcess(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRStatus_Option","PIR_Type_Name","PIR_CopyToType_Name","Customization_PIRStatus_Enable_Workflow","Customization_PIRStatus_Disable_Workflow","Customization_PIRStatus_Workflow_Diagram_Button");
	
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.clickOnPIRField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddPIR_TypeDropdown", "PIR_Type_Option", "PIR_Type_Name");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_FirstOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_SecondOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_ThirdOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_FourthOption");
		
		pirPage.clickOnPIRField(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddPIR_TypeDropdown", "PIR_Type_Option", "PIR_CopyToType_Name");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_FirstOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_SecondOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_ThirdOption");
		pirPage.verifyWorkflowStatus(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Status_Option", "PIR_Status_Textbox", "Workflow_Status_FourthOption");
		
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRStatus_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PIRStatus_Disable_Workflow", "Customization_PIRStatus_Enable_Workflow", PlutoraConfiguration.objectData, "xpath");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Type_Name");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CopyToType_Name");
	
	}
	@Test (description="PIR Setup")
	public void customizationPIR_01() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_PIR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PIR_Setup_Disable", "Customization_PIR_Setup_Enable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.objectData,"Dashboard_Option",PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage("PIR");
		Listener.addLogger(PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR")+" is not displayed in Main Menu successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PIR_Setup_Enable", "Customization_PIR_Setup_Disable", PlutoraConfiguration.objectData, "xpath");
		customizationPage.sendKeys("Customization_PIR_Setup_Textbox",PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR"), PlutoraConfiguration.customizationData);
		customizationPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.objectData,"Dashboard_Option",PlutoraConfiguration.objectData);
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR"));
		Listener.addLogger(PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR")+" is displayed in Main Menu successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIR_Setup_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_PIR_ResetToDefault_Button",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.objectData,"Dashboard_Option",PlutoraConfiguration.objectData);
		customizationPage.verifyTextDisplayedInPage(PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR"));
		Listener.addLogger(PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR")+" is displayed in Main Menu successfully !");
		
	}
	
	@Test (description="PIR Type")
	public void customizationPIR_10() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRType_Option","PIR_Type_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Type_Name")+ " - PIR Type Name is created successfully");
		//Open PIR
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		//pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		//Verify PIR Type
		pirPage.verifyPIRFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddPIR_TypeDropdown","PIR_Type_Option","PIR_Type_Textbox","PIR_Type_Name");
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR type
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRType_Option","PIR_Type_Name");
		
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.clickElementUsingJavaScript("PIR_Yes_Button",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Verify PIR type
		
		pirPage.verifyText("PIR_Type_Textbox","PIR_Type_Name",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Type_Name")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Type_Name");
	}
	
	@Test (description="PIR Item - Type")
	public void customizationPIR_11() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_Type_Option", "PIRItem_Type");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add customfield
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Item Type
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_ItemTypeDropdown","PIR_ItemType_Option","PIR_ItemType_Textbox","PIRItem_Type","PIRItem_Automation");
		//Update checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Type_Option","Customization_PIRItem_Type_Default_Checkbox","PIRItem_Type");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Status
		pirPage.verifyTextAttributeValue("PIR_ItemType_Textbox","PIRItem_Type",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Type")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR type
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Type_Option","PIRItem_Type");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_ItemType_Textbox","PIRItem_Type",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Type")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_Type_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Type");
	}
	@Test (description="PIR Item - Category")
	public void customizationPIR_12() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_Category_Option", "PIRItem_Category");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_ItemCategory_Dropdown","PIR_ItemCategory_Option","PIR_ItemCategory_Textbox","PIRItem_Category","PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization change theme
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Category_Option","Customization_PIRItem_Category_Default_Checkbox","PIRItem_Category");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Status
		pirPage.verifyTextAttributeValue("PIR_ItemCategory_Textbox","PIRItem_Category",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Category")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR type
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Category_Option","PIRItem_Category");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_ItemCategory_Textbox","PIRItem_Category",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Category")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_Category_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Category");
		
	}
	@Test (description="PIR Item - Sub Category")
	public void customizationPIR_13() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_Category_Option", "PIRItem_Category");
		customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_PIRItem_SubCategory_Option");
		customizationPage.addCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIRItem_Category");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.click("PIR_ItemCategory_Dropdown",PlutoraConfiguration.pirData);
		pirPage.sleep(2000);
		pirPage.clickElementUsingJavaScript("PIR_ItemCategory_Option", "PIRItem_Category",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_ItemSubCategory_Dropdown","PIR_ItemSubCategory_Option","PIR_ItemSubCategory_Textbox","CustomList_1","PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization checkbox
		customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_PIRItem_SubCategory_Option");
		customizationPage.click("Customization_SelectCustomField_Dropdown",PlutoraConfiguration.customizationData);
		customizationPage.clickElementUsingJavaScript("Customization_SelectCustomField_Value","PIRItem_Category",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_SubCategory_Option","Customization_PIRItem_SubCategory_Default_Checkbox","CustomList_1");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Item sub-category
		pirPage.verifyTextAttributeValue("PIR_ItemSubCategory_Textbox","CustomList_1",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR type
		customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_PIRItem_SubCategory_Option");
		customizationPage.editCustomLists(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Category","CustomList_1");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_ItemSubCategory_Textbox","CustomList_1",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CustomList_1")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_PIRItem_SubCategory_Option");
		customizationPage.click("Customization_SelectCustomField_Dropdown",PlutoraConfiguration.customizationData);
		customizationPage.sleep(1000);
		customizationPage.clickElementUsingJavaScript("Customization_SelectCustomField_Value","PIRItem_Category",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		customizationPage.sleep(2000);
		customizationPage.deleteMultipleCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.deleteCustomList(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CustomList_2");
	}
	
	@Test (description="PIR Item - Status")
	public void customizationPIR_14() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Status_Option","PIRItem_Status_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Status_Name")+ " - PIR Item Status Name is created successfully");
		//Open PIR Items
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Item Status
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_ItemStatusDropdown","PIR_ItemStatus_Option","PIR_ItemStatus_Textbox","PIRItem_Status_Name","PIRItem_Automation");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR item checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Status_Option","Customization_PIRItem_Status_Default_Checkbox","PIRItem_Status_Name");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		//Verify PIR Item Status
		pirPage.verifyTextAttributeValue("PIR_ItemStatus_Textbox","PIRItem_Status_Name",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Status_Name")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR status
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Status_Option","PIRItem_Status_Name");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR item status
		pirPage.verifyTextAttributeValue("PIR_ItemStatus_Textbox","PIRItem_Status_Name",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Status_Name")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_Status_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Status_Name");
		
	}
	@Test (description="PIR Item - Theme")
	public void customizationPIR_15() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_Theme_Option", "PIRItem_Theme");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add customfield
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR Item custom field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_ItemThemeDropdown","PIR_ItemTheme_Option","PIR_ItemTheme_Textbox","PIRItem_Theme","PIRItem_Automation");
		//Update  PIR Item default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Theme_Option","Customization_PIRItem_Theme_Default_Checkbox","PIRItem_Theme");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR theme
		pirPage.verifyTextAttributeValue("PIR_ItemTheme_Textbox","PIRItem_Theme",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Theme")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR theme
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_Theme_Option","PIRItem_Theme");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_ItemTheme_Textbox","PIRItem_Theme",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Theme")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_Theme_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Theme");
		
	}
	
	@Test (description="PIR Item - Preventative Measure Status")
	public void customizationPIR_16() throws InterruptedException, ParseException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_PreventativeMeasureStatus_Option", "PIRItem_PMS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add customfield
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR Item  custom field 
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_PM_Status_Dropdown","PIR_Item_PM_Status_Option","PIR_Item_PM_Status_Text","PIRItem_PMS","PIRItem_Automation");
		//Update customization default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureStatus_Option","Customization_PIRItem_PreventativeMeasureStatus_Default_Checkbox","PIRItem_PMS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR custom field
		pirPage.verifyTextAttributeValue("PIR_Item_PM_Status_Text","PIRItem_PMS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMS")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Go to Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR custom field 
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureStatus_Option","PIRItem_PMS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR custom field
		pirPage.verifyTextAttributeValue("PIR_Item_PM_Status_Text","PIRItem_PMS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMS")+ " - is displayed by default successfully");
		
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_PM_DueDate_Calendar", PlutoraConfiguration.objectData);
		pirPage.applicationDatePicker(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Additional_Information_DatePicker_Calender_1",
				pirPage.getCurrentDate("-2"));
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization default checkbox
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureStatus_Option","Customization_PIRItem_PreventativeMeasureStatus_EndState_Checkbox","PIRItem_PMS");
	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		pirPage.validateElementDisplayed("PIR_Item_PM_NotHighlight_DueDate_Text", "PIRItem_PMS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMS")+" Not Hightlighted custom field successfully !");
	
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization end state
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureStatus_Option","Customization_PIRItem_PreventativeMeasureStatus_EndState_Checkbox","PIRItem_PMS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
	
		pirPage.validateElementDisplayed("PIR_Item_PM_Highlight_DueDate_Text", "PIRItem_PMS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMS")+" Hightlighted custom field successfully !");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_PreventativeMeasureStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_PMS");
	}
	
	@Test (description="PIR Item - Action Status")
	public void customizationPIR_17() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionStatus_Option", "PIRItem_AS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add customfield
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Item custim field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Status_Dropdown","PIR_Item_Action_Status_Option","PIR_Item_Action_Status_Text","PIRItem_AS","PIRItem_Automation");
		//Update default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization 
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionStatus_Option","Customization_PIRItem_ActionStatus_Default_Checkbox","PIRItem_AS");
		//Verify PIR Action status
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Status
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Status_Text","PIRItem_AS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AS")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR item action status
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionStatus_Option","PIRItem_AS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Status_Text","PIRItem_AS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AS")+ " - is displayed by default successfully");
		
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_PM_DueDate_Calendar", PlutoraConfiguration.objectData);
		pirPage.applicationDatePicker(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Additional_Information_DatePicker_Calender_1",
				pirPage.getCurrentDate("-2"));
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionStatus_Option","Customization_PIRItem_ActionStatus_EndState_Checkbox","PIRItem_AS");
	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		pirPage.validateElementDisplayed("PIR_Item_PM_NotHighlight_DueDate_Text", "PIRItem_AS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AS")+" Not Hightlighted custom field successfully !");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionStatus_Option","Customization_PIRItem_ActionStatus_EndState_Checkbox","PIRItem_AS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
	
		pirPage.validateElementDisplayed("PIR_Item_PM_Highlight_DueDate_Text", "PIRItem_AS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AS")+" Hightlighted custom field successfully !");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_AS");
		
		}
	
	@Test (description="PIR Item - Root Cause Status")
	public void customizationPIR_18() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_RootCauseStatus_Option", "PIRItem_RCS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add customfield
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
		//Verify PIR Item 
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_RC_Status_Dropdown","PIR_Item_RCS_Status_Option","PIR_Item_RCS_Status_Text","PIRItem_RCS","PIRItem_Automation");
		//Update checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization 
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseStatus_Option","Customization_PIRItem_RootCauseStatus_Default_Checkbox","PIRItem_RCS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
		//Verify PIR Status
		pirPage.verifyTextAttributeValue("PIR_Item_RCS_Status_Text","PIRItem_RCS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCS")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR type
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseStatus_Option","PIRItem_RCS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
		//Verify PIR type
		pirPage.verifyTextAttributeValue("PIR_Item_RCS_Status_Text","PIRItem_RCS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCS")+ " - is displayed by default successfully");
		
		//pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Item_PM_DueDate_Calendar", PlutoraConfiguration.objectData);
		//	pirPage.applicationDatePicker(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Additional_Information_DatePicker_Calender_1",
		//		pirPage.getCurrentDate("-2"));
		//pirPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		
	/*	customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseStatus_Option","Customization_PIRItem_RootCauseStatus_EndState_Checkbox","PIRItem_RCS");
	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
		pirPage.validateElementDisplayed("PIR_Item_PM_NotHighlight_DueDate_Text", "PIRItem_RCS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCS")+" Not Hightlighted custom field successfully !");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);*/
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseStatus_Option","Customization_PIRItem_RootCauseStatus_EndState_Checkbox","PIRItem_RCS");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
	
		pirPage.validateElementDisplayed("PIR_Item_RCS_Status_Text", "PIRItem_RCS",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCS")+" Hightlighted custom field successfully !");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_RootCauseStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_RCS");
	}
	
	//@Test (description="PIR Item - Actions Priority")
	public void customizationPIR_19() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionsPriority_Option", "PIRItem_AP");
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add custom field
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Priority_Dropdown","PIR_Item_Action_Priority_Option","PIR_Item_Action_Priority_Text","PIRItem_AP","PIRItem_Automation");
		//Update Customization default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionsPriority_Option","Customization_PIRItem_ActionsPriority_Default_Checkbox","PIRItem_AP");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Priority_Text","PIRItem_AP",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AP")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR Action Priority
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionsPriority_Option","PIRItem_AP");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Action Priority
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Priority_Text","PIRItem_AP",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AP")+ " - is displayed by default successfully");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Delete PIR Item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionsPriority_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_AP");
	}
	@Test (description="PIR Item - Preventative Measure Type")
	public void customizationPIR_20() throws InterruptedException, ParseException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_PreventativeMeasureType_Option", "PIRItem_PMT");
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add custom field
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_PM_Type_Dropdown","PIR_Item_PM_Type_Option","PIR_Item_PM_Type_Text","PIRItem_PMT","PIRItem_Automation");
		//Update Customization default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureType_Option","Customization_PIRItem_PreventativeMeasureType_Default_Checkbox","PIRItem_PMT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyTextAttributeValue("PIR_Item_PM_Type_Text","PIRItem_PMT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMT")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR Action Priority
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_PreventativeMeasureType_Option","PIRItem_PMT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
		//Verify PIR Action Priority
		pirPage.verifyTextAttributeValue("PIR_Item_PM_Type_Text","PIRItem_PMT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_PMT")+ " - is displayed by default successfully");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Delete PIR Item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_PreventativeMeasureType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_PMT");
		
	}
	@Test (description="PIR Item - Action Type")
	public void customizationPIR_21() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionType_Option", "PIRItem_AT");
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add custom field
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Action_Type_Dropdown","PIR_Item_Action_Type_Option","PIR_Item_Action_Type_Text","PIRItem_AT","PIRItem_Automation");
		//Update Customization default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionType_Option","Customization_PIRItem_ActionType_Default_Checkbox","PIRItem_AT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Type_Text","PIRItem_AT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AT")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR Action Priority
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ActionType_Option","PIRItem_AT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
		//Verify PIR Action Priority
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Type_Text","PIRItem_AT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_AT")+ " - is displayed by default successfully");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Delete PIR Item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_ActionType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_AT");
		
	}
	@Test (description="PIR Item - Root Cause Type")
	public void customizationPIR_22() throws InterruptedException, ParseException  {
	customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_RootCauseType_Option", "PIRItem_RCT");
	//Create PIR Item
	pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
	pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
	//Add custom field
	pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.sleep(2000);
	pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	pirPage.sleep(2000);
	pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
	//Verify PIR Item custom field
	pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_RC_Type_Dropdown","PIR_Item_RC_Type_Option","PIR_Item_RC_Type_Text","PIRItem_RCT","PIRItem_Automation");
	//Update Customization default checkbox
	customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseType_Option","Customization_PIRItem_RootCauseType_Default_Checkbox","PIRItem_RCT");
	
	pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
	pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.sleep(2000);
	pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.sleep(2000);
	pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
	//Verify PIR Item custom field
	pirPage.verifyTextAttributeValue("PIR_Item_RC_Type_Text","PIRItem_RCT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCT")+ " - is displayed by default successfully");
	pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	
	//Customization Page
	customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	//Update Customization PIR Action Priority
	customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_RootCauseType_Option","PIRItem_RCT");
	
	pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
	pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.sleep(2000);
	pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	pirPage.sleep(2000);
	pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
	//Verify PIR Action Priority
	pirPage.verifyTextAttributeValue("PIR_Item_RC_Type_Text","PIRItem_RCT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_RCT")+ " - is displayed by default successfully");
	
	pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
	pirPage.sleep(2000);
	//Delete PIR Item
	pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
	//delete custom field
	customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_RootCauseType_Option");
	customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_RCT");
		
	}
	
	@Test (description="PIR Item - Impact Type")
	public void customizationPIR_23() throws InterruptedException, ParseException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_PIRItem_ImpactType_Option", "PIRItem_IT");
		//Create PIR Item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		//Add custom field
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRImpactCreatePage(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Impact_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyPIRItemFieldOptions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Impact_Type_Dropdown","PIR_Item_Impact_Type_Option","PIR_Item_Impact_Type_Text","PIRItem_IT","PIRItem_Automation");
		//Update Customization default checkbox
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateDefaultCheckbox(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ImpactType_Option","Customization_PIRItem_ImpactType_Default_Checkbox","PIRItem_IT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Impact_Automation_Summary");
		//Verify PIR Item custom field
		pirPage.verifyTextAttributeValue("PIR_Item_Impact_Type_Text","PIRItem_IT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_IT")+ " - is displayed by default successfully");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Customization Page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Update Customization PIR Action Priority
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItem_ImpactType_Option","PIRItem_IT");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.sleep(2000);
		pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Impact_Automation_Summary");
		//Verify PIR Action Priority
		pirPage.verifyTextAttributeValue("PIR_Item_Impact_Type_Text","PIRItem_IT",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_IT")+ " - is displayed by default successfully");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Delete PIR Item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItem_ImpactType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_IT");
		
	}
	
}
