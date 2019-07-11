package com.plutora.testplan;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowAdditionInformationTab {
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	NewUserPage userPage = new NewUserPage();
	
	@Test (description="Sub-area: release window -> Additional Information tab -> DataPicker/TimePicker/Data time picker/List Field/List Select/Free Text/Number/Drag and Drop/Contact/Decimal")
	public void subareaReleaseWindowAdditionalInformation_01() throws InterruptedException, ParseException {	
		//Custom field add
		customizationPage.addReleaseDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.releaseDataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.releaseDataTypeOption.get(i),"Release_CustomField_Name");
		//Release Page Search
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		//Release Page Additional Information Verification
		releasePage.verifyAdditionalInformationField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.releaseDataTypeOption.get(i));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
	}
	

	@Test (description="Releases Custom Fields view/edit/hide permissions by User")
	public void subareaReleaseWindowAdditionalInformation_02() throws InterruptedException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		//View Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_1");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_2");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1","Release_CustomField_Name_2", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value")+" - Option selected for Verification successfully ! ");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value");
		
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		CustomizationPage.flag=true;
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Custom Field", "Individual", "Customization_ChangeCustomFields_FieldPermission_Individual_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLoggedin_Username_Value"));
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Custom Field");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_1")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_2")+
				" - Releases Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Releases Custom Fields view/edit/hide permissions by Organization")
	public void subareaReleaseWindowAdditionalInformation_03() throws InterruptedException  {
		//User Management values updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingOrganizationAssociationText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Organization_Text","UM_Org_Text");
		CustomizationPage.flag=true;
		//View Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_1");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_2");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1","Release_CustomField_Name_2", "View Value", "Organization", "UM_Org_Text", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "Edit Value", "Organization", "UM_Org_Text", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value");
		//Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value", "Organization", "Customization_ChangeCustomFields_FieldPermission_Organization_Checkbox", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"));
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Custom Field", "Organization", "UM_Org_Text", "");
		//Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Custom Field");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Custom Field");
		//Delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_1")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_2")+
				" - Releases Custom Field is deleted successfully ! ");
	}
	@Test (description="Releases Custom Fields view/edit/hide permissions by Role")
	public void subareaReleaseWindowAdditionalInformation_04() throws InterruptedException  {
		//User Management value updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_Role_List","UM_Role_List");
		//View Value Setup
		CustomizationPage.flag=true;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_1");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_2");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Value", "Role", "UM_Role_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value", "Role", "UM_Role_List", "");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "Edit Value", "Role", "UM_Role_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value");
		//View Custom Field Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value", "Role", "UM_Role_List", "");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Custom Field", "Role", "UM_Role_List", "");
		//View Custom Field Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Custom Field");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_1")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_2")+
				" - Releases Custom Field is deleted successfully ! ");
	}
	@Test (description="Releases Custom Fields view/edit/hide permissions by User Group")
	public void subareaReleaseWindowAdditionalInformation_05() throws InterruptedException  {
		//User Management Values Updation
		userPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userPage.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Loggedin_Username_Value");
		userPage.getExistingUserFieldText(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"UserManagement_UserGroup_List","UM_UserGroup_List");
		//View Value Setup
		CustomizationPage.flag=true;
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_1");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name_2");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Value", "User Group", "UM_UserGroup_List", "");
		//View Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value");
		//Edit Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "Edit Value", "User Group", "UM_UserGroup_List", "");
		//Edit Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value");
		//View Custom Value Setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setFieldPermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "Edit Value", "User Group", "UM_UserGroup_List", "");
		customizationPage.setBulkUpdatePermission(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "Release_CustomField_Name_2", "View Custom Field", "User Group", "UM_UserGroup_List", "");
		//View Custom Value Verification
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1", "View Custom Field");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyReleaseFieldPermissionCustomField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2", "View Custom Field");
		//Delete Custom Field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_1");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_1")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name_2")+
				" - Releases Custom Field is deleted successfully ! ");
	}
	
	@Test (description="Sub-tabs")
	public void subareaReleaseWindowAdditionalInformation_06() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		//Add Tab
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name","Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyText("Release_CustomField_Tab_Name", "Tab",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Edit Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyText("Release_CustomField_Tab_Name", "Tab",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Remove Tab
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Name");
	}
	
	@Test (description="Grouping Fields")
	public void subareaReleaseWindowAdditionalInformation_07() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		//Add Group
		customizationPage.createCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Name");
		customizationPage.selectGroupField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name","Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_CustomField_Group_Name", "Group",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Edit Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.editCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_CustomField_Group_Name", "Group",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Remove Group
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.removeCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Name");

	}
	
	
	@Test (description="Release Structure (see Release Custom Fields page column)")
	public void subareaReleaseWindowAdditionalInformation_08() throws InterruptedException, ParseException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_All_ReleaseStructure_Radiobox","Release_CustomField_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation", "Project_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation", "Independent_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.clickButton("Customization_CustomField_Enterprise_ReleaseStructure_Radiobox","Release_CustomField_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.clickButton("Customization_CustomField_Other_ReleaseStructure_Radiobox","Release_CustomField_Name",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Independent_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Name");
	
	}
	@Test (description="Information tooltip")
	public void subareaReleaseWindowAdditionalInformation_09() throws InterruptedException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Tooltip");
		customizationPage.clickButton("Customization_CustomField_AsTooltip_Radiobox","Release_CustomField_Tooltip",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Tooltip", "Release_Tooltip");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		Assert.assertTrue(ReleasePage.driver.findElement(By.xpath("//label[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Tooltip")+"')]/following-sibling::a[@data-qtip='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+"']")).isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Tooltip")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Tooltip")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Label");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox","Release_CustomField_Label",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option", "Release_CustomField_Label", "Release_Label");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.scrollToElement("Release_Additional_Information_Other_Tab", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Additional_Information_Other_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Label")+"-"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Label")+" verified in release details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Tooltip");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_CustomField_Label");
	}
}
