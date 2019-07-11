package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class CustomizationPage extends TestGenericUtilLib {
	public List<String> dataTypeOption = new ArrayList<String>();
	public List<String> releaseDataTypeOption = new ArrayList<String>();
	public List<String> capacityDataTypeOption = new ArrayList<String>();
	public List<String> releaseCapacityDataTypeOption = new ArrayList<String>();
	public List<String> changeDataTypeOption = new ArrayList<String>();
	public List<String> environmentDataTypeOption = new ArrayList<String>();
	public List<String> deploymentPlanTypeOption = new ArrayList<String>();
	public List<String> localizationTypeOption = new ArrayList<String>();
	public List<String> emailWizardEntityFields = new ArrayList<String>();
	public List<String> systemDataTypeOption = new ArrayList<String>();
	public List<String> pirDataTypeOption = new ArrayList<String>();
	public List<String> pirItemDataTypeOption = new ArrayList<String>();
	public static boolean flag=false;

	public void getCustomizationDetailsPage(String customizationData, String testData, String objectData) throws InterruptedException{	
		refresh(objectData);
		waitForLoadingIconDisappear(800,"Loading_Gif", objectData);
		sleep(1000);
		//mouseHover("SettingsDropdown", "CustomizationDropdown",customizationData);
		clickElementUsingJavaScript("SettingsDropdown",customizationData);
		waitForLoadingIconDisappear(800,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("CustomizationDropdown",customizationData);
		waitForLoadingIconDisappear(800,"Loading_Gif", objectData);
	}
	public void clickOnCustomListsOption(String customizationData,String objectData,String option) {
		scrollToElement(option,customizationData);
		sleep(1000);
		click(option,customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void addCustomField(String customizationData, String testData, String objectData,String option,String name) {
		clickOnCustomFieldOption(customizationData,objectData,option);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Customization_AddField_Button",customizationData);
		scrollToElement("Customization_Field_Name",customizationData);
		sendKeys("Customization_Field_Name", PropertiesCache.setProperty(testData, name), customizationData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" - Added Customization field successfully on Customization Page !");
	}

	public void addCustomLists(String customizationData, String testData, String objectData,String customFieldName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Customization_SelectCustomField_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		clickElementUsingJavaScript("Customization_SelectCustomField_Value",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Customization_AddField_Button",customizationData);
		scrollToElement("Customization_Field_Name",customizationData);
		sendKeys("Customization_Field_Name", PropertiesCache.setProperty(testData, "CustomList_1"), customizationData);
		sleep(2000);
		click("Customization_AddField_Button",customizationData);
		sendKeys("Customization_Field_Name", PropertiesCache.setProperty(testData, "CustomList_2"), customizationData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "CustomList_1")+" "+PropertiesCache.getProperty(testData, "CustomList_2")+" - Added Customization List successfully on Customization Page !");

	}
	public void addDataTypeOption(String customizationData, String testData, String objectData,String dataTypeOption,String customFieldName) {
		//scrollToElement("Customization_DataType_Dropdown", "Release_CustomField_Name", customizationData,testData);
		clickElementUsingJavaScript("Customization_CustomFields_Row",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		doubleClick("Customization_DataType_Dropdown",customFieldName, customizationData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Customization_DataType_Dropdown_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Customization_DataType_Dropdown_Option",dataTypeOption,customizationData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(dataTypeOption+" is selected from Custom field data type dropdown !");
	}

	public void addReleaseDataTypeList() {
		releaseDataTypeOption.clear();
		releaseDataTypeOption.add("Date Picker");
		releaseDataTypeOption.add("Time Picker");
		releaseDataTypeOption.add("Date Time Picker");
		releaseDataTypeOption.add("List Field");
		releaseDataTypeOption.add("List Select");
		releaseDataTypeOption.add("Free Text");
		releaseDataTypeOption.add("Number");
		//releaseDataTypeOption.add("Drag and Drop");
		releaseDataTypeOption.add("Contact");
		releaseDataTypeOption.add("Decimal");
		releaseDataTypeOption.add("Currency");
		
	}
	public void addEnvironmentDataTypeList() {
		environmentDataTypeOption.clear();
		environmentDataTypeOption.add("Time Picker");
		environmentDataTypeOption.add("Date Picker");
		environmentDataTypeOption.add("Date Time Picker");
		environmentDataTypeOption.add("List Field");
		environmentDataTypeOption.add("List Select");
		environmentDataTypeOption.add("Free Text");
		environmentDataTypeOption.add("Number");
	}

	public void addDataTypeList() {
		dataTypeOption.clear();
		dataTypeOption.add("Date Picker");
		dataTypeOption.add("Time Picker");
		dataTypeOption.add("Date Time Picker");
		dataTypeOption.add("List Field");
		dataTypeOption.add("List Select");
		dataTypeOption.add("Free Text");
		dataTypeOption.add("Number");
		dataTypeOption.add("Decimal");
		dataTypeOption.add("Currency");
	}

	public void addCapacityDataTypeList() {
		capacityDataTypeOption.clear();
		capacityDataTypeOption.add("Date Picker");
		capacityDataTypeOption.add("Time Picker");
		capacityDataTypeOption.add("Date Time Picker");
		capacityDataTypeOption.add("List Field");
		capacityDataTypeOption.add("List Select");
		capacityDataTypeOption.add("Free Text");
		capacityDataTypeOption.add("Number");
		capacityDataTypeOption.add("Currency");
		capacityDataTypeOption.add("Decimal");
		releaseCapacityDataTypeOption.clear();
		releaseCapacityDataTypeOption.add("date");
		releaseCapacityDataTypeOption.add("container");
		releaseCapacityDataTypeOption.add("datetime");
		releaseCapacityDataTypeOption.add("container");
		releaseCapacityDataTypeOption.add("container");
		releaseCapacityDataTypeOption.add("textarea");
		releaseCapacityDataTypeOption.add("numeric");
		releaseCapacityDataTypeOption.add("currency");
		releaseCapacityDataTypeOption.add("decimal");
	}
	public void addDeploymentPlanDataTypeList() {
		deploymentPlanTypeOption.clear();
		deploymentPlanTypeOption.add("Date Picker");
		deploymentPlanTypeOption.add("Time Picker");
		deploymentPlanTypeOption.add("Date Time Picker");
		deploymentPlanTypeOption.add("List Field");
		deploymentPlanTypeOption.add("List Select");
		deploymentPlanTypeOption.add("Free Text");
		deploymentPlanTypeOption.add("Number");
		deploymentPlanTypeOption.add("Decimal");
		deploymentPlanTypeOption.add("Currency");
	}
	public void addLocalizationDeploymentPlanDataTypeList() {
		localizationTypeOption.clear();
		localizationTypeOption.add("Date Picker");
		localizationTypeOption.add("Number");
		localizationTypeOption.add("Decimal");
		localizationTypeOption.add("Currency");
	}

	public void addChangeDataTypeList() {
		changeDataTypeOption.clear();
		changeDataTypeOption.add("Date Picker");
		changeDataTypeOption.add("Time Picker");
		changeDataTypeOption.add("Date Time Picker");
		changeDataTypeOption.add("List Field");
		changeDataTypeOption.add("List Select");
		changeDataTypeOption.add("Free Text");
		changeDataTypeOption.add("Number");
		changeDataTypeOption.add("Decimal");
		changeDataTypeOption.add("Currency");
	}

	public void addSystemDataTypeList() {
		systemDataTypeOption.clear();
		systemDataTypeOption.add("Date Picker");
		systemDataTypeOption.add("Time Picker");
		systemDataTypeOption.add("Date Time Picker");
		systemDataTypeOption.add("List Field");
		systemDataTypeOption.add("List Select");
		systemDataTypeOption.add("Free Text");
		systemDataTypeOption.add("Number");
		systemDataTypeOption.add("Decimal");
		systemDataTypeOption.add("Currency");
	}

	public void addPIRItemDataTypeList() {
		pirItemDataTypeOption.clear();
		pirItemDataTypeOption.add("Time Picker");
		pirItemDataTypeOption.add("Date Picker");
		pirItemDataTypeOption.add("Date Time Picker");
		pirItemDataTypeOption.add("List Field");
		pirItemDataTypeOption.add("List Select");
		pirItemDataTypeOption.add("Free Text");
		pirItemDataTypeOption.add("Number");
		pirItemDataTypeOption.add("Decimal");
		pirItemDataTypeOption.add("Currency");
	}

	public void addPIRDataTypeList() {
		pirDataTypeOption.clear();
		pirDataTypeOption.add("List Field");
		pirDataTypeOption.add("List Select");
		pirDataTypeOption.add("Free Text");
		pirDataTypeOption.add("Number");
		pirDataTypeOption.add("Decimal");
		pirDataTypeOption.add("Currency");
		pirDataTypeOption.add("Date Picker");
		pirDataTypeOption.add("Time Picker");
		pirDataTypeOption.add("Date Time Picker");
	}

	public void deleteCustomField(String customizationData, String testData,String objectData,String customFieldName) {
		sleep(3000);
		clickElementUsingJavaScript("Customization_Field_First_Checkbox",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(3000);
		clickElementUsingJavaScript("Customization_Field_Checkbox",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" Customization field name is deleted from Customization Page !");
	}
	public void deleteCustomizationField(String customizationData, String testData,String objectData,String customFieldName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Customization_Option_Name", customFieldName, customizationData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_Delete_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" Customization field name is deleted from Customization Page !");
	}
	public void deleteCustomsField(String customizationData, String testData,String objectData,String customFieldName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Customization_Option_Name", customFieldName, customizationData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" Customization field name is deleted from Customization Page !");
	}
	public void deletePackageCustomsField(String customizationData, String testData,String objectData,String customFieldName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Customization_Package_Option_Name", customFieldName, customizationData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" Customization field name is deleted from Customization Page !");
	}
	public void deleteCustomsReleaseSystemsField(String customizationData, String testData,String objectData,String customFieldName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Customization_Option_Name", customFieldName, customizationData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(customizationData,"Customization_Yes_Button",objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" Customization field name is deleted from Customization Page !");
	}

	public void clickOnElement(String customizationData,String objectData,String elementId) {
		sleep(1000);
		clickElementUsingJavaScript(elementId,customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void addEntityFields() {
		emailWizardEntityFields.add("Email_Recipient");
		emailWizardEntityFields.add("Company_Name");
		emailWizardEntityFields.add("Comments");
		emailWizardEntityFields.add("Requester_Role");
		emailWizardEntityFields.add("Status");
		emailWizardEntityFields.add("Activity_Systems");
		emailWizardEntityFields.add("Release");
		emailWizardEntityFields.add("External_Identifier");
		emailWizardEntityFields.add("Start_Date");
		emailWizardEntityFields.add("End_Date");
		emailWizardEntityFields.add("Responsible");
		emailWizardEntityFields.add("Direct_link");
		emailWizardEntityFields.add("Remaining_Duration");
		emailWizardEntityFields.add("Actual_Duration");
		emailWizardEntityFields.add("Planned_Duration");
		emailWizardEntityFields.add("Update_via_Secure_URL");

	}
		
	public void addEmailTemplate(String customizationData, String testData,String objectData,String option,String emailSubjectName,String user,String entityName,String triggerName) {
			addEntityFields();
			click("Customization_Email_Template_Wizard_Add_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			sendKeys("Customization_Email_Template_Wizard_Name_Textfield", PropertiesCache.setProperty(testData,emailSubjectName),customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Customization_Email_Template_Wizard_Status_Dropdown",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			click("Customization_Email_Template_Wizard_Active_Status",customizationData);
			sleep(1000);
			click("Customization_Email_Template_Wizard_Next_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);

			click("Customization_Email_Template_Wizard_Entity_Dropdown",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			clickElementUsingJavaScript("Customization_Email_Template_Wizard_Entity_Dropdown_Option",entityName,customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			clickElementUsingJavaScript("Customization_Email_Template_Wizard_Trigger_Dropdown",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			click(option,triggerName,customizationData);
			sleep(1000);	
			click("Customization_Email_Template_Wizard_Next_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);

			sendKeys("Customization_Email_Template_Wizard_EmailSubject_Textbox",emailSubjectName,customizationData,testData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			/*for(int i=0;i<emailWizardEntityFields.size();i++) {
			dragAndDropToFrames(PropertiesCache.getProperty(customizationData, "Customization_Email_Template_Wizard_EntityFields").replace("TEXT", emailWizardEntityFields.get(i)), PropertiesCache.getProperty(customizationData, "Customization_Email_Template_Wizard_MailBody_Section"), "Customization_Email_Template_Wizard_Frame",customizationData);
			}*/

			click("Customization_Email_Template_Wizard_Next_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);

			click("Customization_Email_Template_Wizard_Next_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);

			click("Customization_Email_Template_Wizard_EmailRecipients_Dropdown",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			sendKeys("Customization_Email_Template_Wizard_EmailRecipients_Textbox",user,customizationData,testData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			click("Customization_Email_Template_Wizard_EmailRecipients_Dropdown_Option",user,customizationData,testData);
			sleep(1000);
			/*sendKeys("Customization_Email_Template_Wizard_EmailRecipients_Textbox","testingbroadcast",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			click("Customization_Email_Template_Wizard_EmailRecipients_Dropdown_Option","testingbroadcast",customizationData);
			sleep(1000);*/

			click("Customization_Email_Template_Wizard_Save&Close_Button",customizationData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);

		
	}
	
	public void updateEmailTemplate(String customizationData,String testData,String objectData,String templateName) {
		clickButton("Customization_Email_Template_Wizard_Edit_Button",templateName,customizationData,testData,objectData);
		sendKeys("Customization_Email_Template_Wizard_Name_Textfield", PropertiesCache.setProperty(testData,templateName),customizationData);
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_Save&Close_Button",objectData);
		Listener.addLogger("Email template updated successfully !");
	}
	
	public void updateWatchersEmailTemplate(String customizationData,String testData,String objectData,String templateName) {
		clickButton("Customization_Email_Template_Wizard_Edit_Button",templateName,customizationData,testData,objectData);
		clickOnButton(customizationData, "Customization_Email_Template_Wizard_EmailRecipients_Tab", objectData);
		clickOnButton(customizationData,"Customization_Email_Template_SendToWatchers_Checkbox",objectData);
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_Save&Close_Button",objectData);
		Listener.addLogger("Email template updated successfully !");
	}
	public void clickOnCustomFieldOption(String customizationData,String objectData,String option) {
		scrollToElement(option,customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript(option,customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(option+" is selected in customization page successfully");
	}

	public void updateDefaultCheckbox(String customizationData, String testData,String objectData,String option,String checkbox,String name) {
		
		clickOnCustomFieldOption(customizationData, objectData, option);
		scrollToElement(checkbox,name,customizationData,testData);
		click(checkbox,name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" is updated with default checkbox option in customization page successfully !");
	}
	public void updateCustomFieldOptionName(String customizationData, String testData,String objectData,String option,String name) throws InterruptedException {
		clickOnCustomFieldOption(customizationData, objectData, option);
		PropertiesCache.setProperty(testData,"Change_First_Status",getTextData("Customization_Change_First_Status", customizationData));
		click("Customization_Option_Name", name, customizationData, testData);
		click("Customization_EditField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clear("Customization_Field_Name", customizationData);
		doubleClick("Customization_ClickToAddName_Button",customizationData);
		sleep(1000);
		sendKeysWithoutClear("Customization_Field_Name", PropertiesCache.setProperty(testData, name), customizationData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" Custom field is updated successfully");
	
	}
	public void createCustomField(String customizationData, String testData,String objectData,String option,String name) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		click("Customization_AddField_Button",customizationData);
		scrollToElement("Customization_Field_Name",customizationData);
		sendKeys("Customization_Field_Name", PropertiesCache.setProperty(testData, name), customizationData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" - Added Customization field successfully in Customization Page !");
		clickOnSubmitButton(customizationData, objectData);
	}
	public void verifyMandatoryFields(String customizationData, String testData,String objectData,String option) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		click("Customization_AddField_Button",customizationData);
		scrollToElement("Customization_Field_Name",customizationData);
		clickOnSubmitButton(customizationData, objectData);
		sleep(2000);
		validateElementDisplayed("Customization_Mandatory_Field_Text", customizationData);
		Listener.addLogger(getTextData("Customization_Mandatory_Field_Text", customizationData)+" Custom field Blank name is verified successfully !");
	}
	
	public void createCustomFieldColorOption(String customizationData, String testData,String objectData,String option,String name) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		clickElementUsingJavaScript("Customization_AddField_Button",customizationData);
		sendKeys("Customization_Field_Name", PropertiesCache.setProperty(testData, name), customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(5000);
		//Add color
		doubleClick("Customization_Change_ClickToAddColor",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(4000);
		doubleClick("Customization_Change_Color_Dropdown",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("Customization_Change_Color_FirstOption",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" - Added Customization field successfully on Customization Page !");
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void addIconToBlockoutType(String customizationData,String testData,String objectData,String name){
		/*Double click on 'Click to add Icon' */
		doubleClick("Customization_BlockoutType_IconTab",name, customizationData, testData);
		/* selecting of of the options of the Icon List */
		clickElementUsingJavaScript("Customization_BlockoutType_IconOption", customizationData);
		/* clcking on submit button */
		clickOnSubmitButton(customizationData, objectData);
	}

	public void updateChangeStatus(String customizationData, String testData,String objectData) {
		scrollToElement("Customization_ChangeStatus_Option",customizationData);
		sleep(1000);
		click("Customization_ChangeStatus_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Customization_Default_Checkbox","Change_Theme_Name",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Change_Status_Name")+" - Updated customization field successfully !");
	}
	
	public void addChangeMenuLabel(String customizationData, String testData,String objectData,String option,String changeTitle) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		if (changeTitle.equals("Change_Title")) {
			click("Customization_NewChange_MenuLabel", customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			sendKeys("Customization_NewChangeTitle_Texbox", PropertiesCache.setProperty(testData, changeTitle), customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			Listener.addLogger(PropertiesCache.getProperty(testData,changeTitle )+" - Added Change menu label in customization page successfully !");
		} else {
			click("Customization_DefaultChange_MenuLabel", customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			PropertiesCache.setProperty(testData, "Customization_DefaultChange_MenuLabel",getTextData("Customization_DefaultChange_MenuLabel", customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData,"Customization_DefaultChange_MenuLabel")+" - Added Change menu label in customization page successfully !");
		}
		clickOnSubmitButton(customizationData, objectData);
		
	}
	public void addChangeTabNames(String customizationData, String testData,String objectData,String option,String changeTitle) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		if (changeTitle.equals("Change_Tab")) {
			click("Customization_ChangeNewTabName_RadioButton", customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			sendKeys("Customization_ChangeNewTabName_Textbox", PropertiesCache.setProperty(testData, changeTitle), customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			Listener.addLogger(PropertiesCache.getProperty(testData, changeTitle)+" - Added Customization change Tab Names successfully in Customization Page !");
		} else {
			click("Customization_ChangeTabName_RadioButton", customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
		}
		clickOnSubmitButton(customizationData, objectData);
		
	}
	
	public void disableWorkflowProcess(String customizationData,String disableLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 try {  
			 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			 driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Enable_Workflow")));
        } catch (NoSuchElementException e) {  
       	 sleep(1000);
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Enable_Workflow"))));
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       } 
	}	
	public void addChangeWorkflowProcess(String customizationData, String testData,String objectData,String option) {
		clickOnCustomFieldOption(customizationData, objectData, option); 
		clickOnButton(customizationData, "Customization_ChangeStatus_Enable_Workflow", "Customization_ChangeStatus_Disable_Workflow", objectData, "xpath");
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ChangeStatus_Workflow_Diagram_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, "Change_Type_Name"), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_Option", "Customization_ChangeStatus_Workflow_Draggable_Section","Change_Status_Name", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Change_Status_Name",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Change_Status_Name")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		//Status 1
		click("Customization_ChangeStatus_Workflow_Start_Button","Change_Status_Name",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Status 2
		click("Customization_ChangeStatus_Workflow_Diagram_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, "Change_Type_Name"), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_FirstOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_FirstOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_FirstOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_FirstOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_FirstOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Status 3
		click("Customization_ChangeStatus_Workflow_Diagram_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, "Change_Type_Name"), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_SecondOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_SecondOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_SecondOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_SecondOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_SecondOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Customization_ChangeStatus_Workflow_Diagram_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, "Change_Type_Name"), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Move to offset
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_SecondOption", customizationData, testData, "128", "800");
		sleep(2000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_FirstOption", customizationData, testData, "128", "500");
		sleep(2000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Change_Status_Name", customizationData, testData, "218", "200");
		sleep(2000);
		//Add connection between status
		dragAndDrop("Customization_ChangeStatus_Connection_Point", "Customization_ChangeStatus_Workflow_Dragged_Option","Change_Status_Name","Workflow_Status_FirstOption", customizationData,testData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Change_Status_Name")+" - is add connection to "+PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption"));
		dragAndDrop("Customization_ChangeStatus_Connection_Point", "Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_FirstOption","Workflow_Status_SecondOption", customizationData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")+" - is add connection to"+PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption"));
		sleep(2000);
		//Add Priority
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Change_Status_Name")), "1");
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")), "2");
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")), "3");
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
	}
	
	public void setFieldPermission(String customizationData, String testData,String objectData,String name,String type,String by,String checkbox,String option) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_Option_Name", name, customizationData, testData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(2000);
		if(flag!=true) {
		sleep(2000);
		scrollToElement("Customization_ChangeCustomFields_FieldPermission_Checkbox",name,customizationData,testData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeCustomFields_FieldPermission_Checkbox",name,customizationData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		flag=true;
		}
		clickElementUsingJavaScript("Customization_ChangeCustomFields_FieldPermission_Button",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Type
		clickElementUsingJavaScript("Customization_ChangeCustomFields_FieldPermission_Type_Dropdown",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ChangeCustomFields_FieldPermission_Type_Option",type,customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//By
		click("Customization_ChangeCustomFields_FieldPermission_By_Dropdown",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ChangeCustomFields_FieldPermission_By_Option",by,customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		if(by.equals("Role") || by.equals("User Group") ) {
			driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, checkbox))).click();
		}else {
		driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, checkbox).replace("TEXT", option))).click();
		}
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		//Save
		click("Customization_ChangeCustomFields_FieldPermission_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//Submit
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" "+type+" "+by+" are selected permission for option ! ");
	}
	public void updateTEBRFormDescription(String customizationData,String testData,String objectData,String name) {
		
		switchToFrameByElement("Customization_TEBR_Form_Frame",customizationData);
		sendKeys("Customization_TEBR_Form_Textbox", CommonConstants.tebrFormDescription+PropertiesCache.setProperty(testData, name) , customizationData);
		switchToDefaultContent();
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(CommonConstants.tebrFormDescription+PropertiesCache.getProperty(testData, name)+" Updated TEBR desciption successfully ! ");
	}
	public void updateTEBRFormQuestion(String customizationData,String testData,String objectData,String name) {
		scrollToElement("Customization_TEBR_Form_Question_Icon",customizationData);
		clickElementUsingJavaScript("Customization_TEBR_Form_Question_Icon",customizationData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Customization_TEBR_Form_Question_Textbox", PropertiesCache.setProperty(testData, name) , customizationData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" Updated TEBR form Question successfully ! ");
	}
	public void updateTEBRFormEditQuestion(String customizationData,String testData,String objectData,String name) {
		scrollToElement("Customization_TEBR_Form_Question_Icon",customizationData);
		sleep(1000);
		click("Customization_TEBR_Form_Question_Text",name,customizationData,testData);
		clear("Customization_TEBR_Form_Question_Textbox", customizationData);
		click("Customization_TEBR_Form_New_Question_Text", customizationData);
		sendKeysWithoutClear("Customization_TEBR_Form_Question_Textbox", PropertiesCache.setProperty(testData, name) , customizationData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" Updated TEBR form Question successfully ! ");
	}
	public void updateTEBRFormDeleteQuestion(String customizationData,String testData,String objectData,String name) {
		scrollToElement("Customization_TEBR_Form_Question_Icon",customizationData);
		clickElementUsingJavaScript("Customization_TEBR_Form_Question_Delete_Icon",name,customizationData,testData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" Deleted TEBR form Question successfully ! ");
	}
	public void clickOnSubmitButton(String customizationData,String objectData) {
		sleep(1000);
		clickElementUsingJavaScript("Customization_Submit_Button",customizationData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void addWorkflowProcess(String customizationData, String testData,String objectData,String option,String typeName,String tecrCopyToType,String enable,String disable,String workflowButton) {
		clickOnCustomFieldOption(customizationData, objectData, option); 
		clickOnButton(customizationData, enable, disable, objectData, "xpath");
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//Status 1 
		click(workflowButton, customizationData);
		waitForLoadingIconDisappear(1000,"Loading_Gif", objectData);
		sleep(4000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, typeName), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_FirstOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_FirstOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_FirstOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_FirstOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_FirstOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Customization_ChangeStatus_Workflow_Start_Button","Workflow_Status_FirstOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Status 2
		click(workflowButton, customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, typeName), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_SecondOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_SecondOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_SecondOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_SecondOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_SecondOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Status 3
		click(workflowButton, customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, typeName), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_ThirdOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_ThirdOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_ThirdOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_ThirdOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_ThirdOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_ThirdOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Status 4
		click(workflowButton, customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, typeName), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Workflow_Status_FourthOption" ,getTextData("Customization_ChangeStatus_Workflow_Status_FourthOption", customizationData));
		dragAndDrop("Customization_ChangeStatus_Workflow_Status_FourthOption", "Customization_ChangeStatus_Workflow_Draggable_Section","Workflow_Status_FourthOption", customizationData,testData);
		scrollToElement("Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_FourthOption",customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FourthOption")+" - is Dragged and Dropped in Workflow section of Customization Page !");
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click(workflowButton, customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		selectByVisibleText("Customization_ChangeStatus_Workflow_Type_Dropdown", PropertiesCache.getProperty(testData, typeName), customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//Move Offset
		scrollToElement("Customization_Status_Workflow_Option", customizationData);
		sleep(1000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_FourthOption", customizationData, testData, "128", "1300");
		sleep(2000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_ThirdOption", customizationData, testData, "128", "900");
		sleep(2000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_SecondOption", customizationData, testData, "128", "500");
		sleep(2000);
		dragAndDropByOffset("Customization_ChangeStatus_Workflow_Dragged_Option", "Workflow_Status_FirstOption", customizationData, testData, "128", "100");
		sleep(2000);
		
		scrollToElement("Customization_ChangeStatus_Connection_Point","Workflow_Status_FirstOption",customizationData,testData);
		sleep(1000);
		dragAndDrop("Customization_ChangeStatus_Connection_Point", "Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_FirstOption","Workflow_Status_SecondOption", customizationData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")+" - is add connection to "+PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption"));
		scrollToElement("Customization_ChangeStatus_Connection_Point","Workflow_Status_SecondOption",customizationData,testData);
		sleep(2000);
		dragAndDrop("Customization_ChangeStatus_Connection_Point", "Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_SecondOption","Workflow_Status_ThirdOption", customizationData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")+" - is add connection to "+PropertiesCache.getProperty(testData, "Workflow_Status_ThirdOption"));
		//scrollToElement("Customization_ChangeStatus_Connection_Point","Workflow_Status_FourthOption",customizationData,testData);
		sleep(4000);
		scrollToElement("Customization_ChangeStatus_Connection_Point","Workflow_Status_ThirdOption",customizationData,testData);
		dragAndDrop("Customization_ChangeStatus_Connection_Point", "Customization_ChangeStatus_Workflow_Dragged_Option","Workflow_Status_ThirdOption","Workflow_Status_FourthOption", customizationData,testData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_ThirdOption")+" - is add connection to "+PropertiesCache.getProperty(testData, "Workflow_Status_FourthOption"));
		//Set Priority
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")), "1");
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")), "2");
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_ThirdOption")), "3");
		sendKeys(PropertiesCache.getProperty(customizationData, "Customization_ChangeStatus_Priority_Textbox").replace("TEXT", PropertiesCache.getProperty(testData, "Workflow_Status_FourthOption")), "4");
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		//assign user
		if(workflowButton.contains("TECR")) {
		setAssignedToInERWDO(customizationData, testData, objectData, "Workflow_Status_FirstOption");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FirstOption")+" - is assigned user successfully !");
		setAssignedToInERWDO(customizationData, testData, objectData, "Workflow_Status_SecondOption");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_SecondOption")+" - is assigned user successfully !");
		setAssignedToInERWDO(customizationData, testData, objectData, "Workflow_Status_ThirdOption");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_ThirdOption")+" - is assigned user successfully !");
		setAssignedToInERWDO(customizationData, testData, objectData, "Workflow_Status_FourthOption");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Workflow_Status_FourthOption")+" - is assigned user successfully !");
		//Save
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		}
		//Copy
		if(!workflowButton.contains("Change")) {
		clickElementUsingJavaScript("Customization_Status_CopyTo_Button",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_Status_CopyTo_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_Status_CopyTo_Option",tecrCopyToType,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_Status_CopyTo_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_Status_CopyTo_Copy&Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_Status_CopyTo_Yes_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, typeName)+" - is copied to "+PropertiesCache.getProperty(testData, tecrCopyToType));
		}
		//Save
		clickElementUsingJavaScript("Customization_ChangeStatus_Workflow_Save_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_ChangeStatus_Close_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
	}
	private void setAssignedToInERWDO(String customizationData,String testData,String objectData,String option) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Customization_ChangeStatus_Setting_Icon",option,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ERWDO_AssignedTo_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_ERWDO_AssignedTo_Textbox", "Loggedin_Username_Value",customizationData,testData);
		sleep(1000);
		click("Customization_ERWDO_AssignedTo_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Customization_ERWDO_SaveAndClose_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void editCustomField(String customizationData, String testData,String objectData,String option,String customFieldName) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		doubleClick("Customization_CustomFields_Row",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_EditField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clear("Customization_Field_Name", customizationData);
		doubleClick("Customization_ClickToAddName_Button",customizationData);
		sleep(1000);
		sendKeysWithoutClear("Customization_Field_Name", PropertiesCache.setProperty(testData, customFieldName), customizationData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" - Updated Customization field Name successfully on Customization Page !");
		clickOnSubmitButton(customizationData, objectData);
	}
	public void editCustomLists(String customizationData, String testData, String objectData,String customFieldName,String customListName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Customization_SelectCustomField_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		clickElementUsingJavaScript("Customization_SelectCustomField_Value",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		doubleClick("Customization_CustomFields_Row",customListName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_EditField_Button",customizationData);
		clear("Customization_Field_Name", customizationData);
		doubleClick("Customization_ClickToAddName_Button",customizationData);
		sleep(1000);
		sendKeysWithoutClear("Customization_Field_Name", PropertiesCache.setProperty(testData, customListName), customizationData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customListName)+" - Updated Customization List name successfully on Customization Page !");

	}
	public void deleteMultipleCustomList(String customizationData, String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_Delete_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization List is deleted from Customization Page !");
	}
	public void deleteCustomList(String customizationData, String testData,String objectData,String customListName) {

		click("Customization_CustomFields_Row",customListName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Customization_DeleteField_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization List is deleted from Customization Page !");
	}
	public void updateCustomField(String customizationData, String testData,String objectData,String option,String customFieldName,String descriptionName) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		click("Customization_CustomFields_Row",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		doubleClick("Customization_Description",customFieldName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		sendKeys("Customization_Description_Textbox", PropertiesCache.setProperty(testData, descriptionName),customizationData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, descriptionName)+" - Added Custom Field description successfully !");
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void setCustomTitleNames(String customizationData,String testData,String objectData) {
		clickElementUsingJavaScript("Customization_Environment_Custom_Radio_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_Environment_Custom_Textbox", PropertiesCache.setProperty(testData, "Env"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Env")+" - Added Custom Title Name successfully !");
		
		clickElementUsingJavaScript("Customization_TECR_Custom_Radio_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_TECR_Custom_Textbox", PropertiesCache.setProperty(testData, "TECR"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "TECR")+" - Added Custom Title Name successfully !");
		
		clickElementUsingJavaScript("Customization_TEBR_Custom_Radio_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_TEBR_Custom_Textbox", PropertiesCache.setProperty(testData, "TEBR"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "TEBR")+" - Added Custom Title Name successfully !");
		
		clickElementUsingJavaScript("Customization_MyEnvironmentBooking_Custom_Radio_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_MyEnvironmentBooking_Custom_Textbox", PropertiesCache.setProperty(testData, "MEB"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "MEB")+" - Added Custom Title Name successfully !");
		
		clickOnSubmitButton(customizationData, objectData);
	}
	public void setTitleNames(String customizationData,String testData,String objectData) {
		clickElementUsingJavaScript("Customization_Environment_Radio_Button",customizationData);
		PropertiesCache.setProperty(testData, "Env",getTextData("Customization_Environment_Radio_Button", customizationData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Env")+" - Added Default Title Name successfully !");
	
		clickElementUsingJavaScript("Customization_TECR_Radio_Button",customizationData);
		PropertiesCache.setProperty(testData, "TECR",getTextData("Customization_TECR_Radio_Button", customizationData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "TECR")+" - Added Default Title Name successfully !");
		
		clickElementUsingJavaScript("Customization_TEBR_Radio_Button",customizationData);
		PropertiesCache.setProperty(testData, "TEBR",getTextData("Customization_TEBR_Radio_Button", customizationData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "TEBR")+" - Added Default Title Name successfully !");
		
		clickElementUsingJavaScript("Customization_MyEnvironmentBooking_Radio_Button",customizationData);
		PropertiesCache.setProperty(testData, "MEB",getTextData("Customization_MyEnvironmentBooking_Radio_Button", customizationData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "MEB")+" - Added Default Title Name successfully !");

		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void customActivityStatus(String customizationData,String testData,String objectData) {
		clickElementUsingJavaScript("Customization_DeploymentPlanCustomActivityStatus_RadioButton",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Customization_DeploymentPlanActivityStatus_NotStarted_Textbox", PropertiesCache.setProperty(testData, "NotStarted"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "NotStarted")+" - Added Custom Activity Status Name successfully !");
		
		sendKeys("Customization_DeploymentPlanActivityStatus_InProgress_Textbox", PropertiesCache.setProperty(testData, "InProgress"),customizationData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "InProgress")+" - Added Custom Activity Status Name successfully !");
		
		sendKeys("Customization_DeploymentPlanActivityStatus_Issue_Textbox", PropertiesCache.setProperty(testData, "Issue"),customizationData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Issue")+" - Added Custom Activity Status Name successfully !");
		
		sendKeys("Customization_DeploymentPlanActivityStatus_Failed_Textbox", PropertiesCache.setProperty(testData, "Failed"),customizationData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Failed")+" - Added Custom Activity Status Name successfully !");
		
		sendKeys("Customization_DeploymentPlanActivityStatus_Completed_Textbox", PropertiesCache.setProperty(testData, "Completed"),customizationData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Completed")+" - Added Custom Activity Status Name successfully !");
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void verifyDataTypeOption(String customFieldName,String dataType) {
		
		boolean flag = driver.findElement(By.xpath("//div[text()='"+customFieldName+"']/ancestor::tr/td/div[text()='"+dataType+"']")).isDisplayed();
		if (flag) {
			assertTrue(true);
			Listener.addLogger(customFieldName+" "+dataType+ "verified data type successfully !");
		} else {
			assertTrue(false);
			Listener.addLogger(customFieldName+" "+dataType+ "not verified data type successfully !");
		}
	}
	
	public void addReleaseTabNames(String customizationData, String testData,String objectData,String radioButton,String textbox,String title,String custom) {
		
		if (custom.equals("Custom")) {
			click(radioButton, customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			sendKeys(textbox, PropertiesCache.setProperty(testData, title), customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
		} else {
			click(radioButton, customizationData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			PropertiesCache.setProperty(testData, title,getTextData(radioButton,customizationData));
		}
		Listener.addLogger(PropertiesCache.getProperty(testData, title)+" - Added Customization Tab Names successfully in Customization Page !");
	}
	
	public void addCustomizationReleaseTabNames(String customizationData, String testData,String objectData,String tabName) throws InterruptedException {
		
		if (tabName.equals("Custom")) {
			clickOnButton(customizationData,"Customization_CustomRelease_RadioButton", objectData);
			sendKeys("Customization_CustomRelease_Textbox", PropertiesCache.setProperty(testData, "Release_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Release_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomProject_RadioButton", objectData);
			sendKeys("Customization_CustomProject_Textbox", PropertiesCache.setProperty(testData, "Project_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Project_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomIndependent_RadioButton", objectData);
			sendKeys("Customization_CustomIndependent_Textbox", PropertiesCache.setProperty(testData, "Independent_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Independent_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomAdditionalInformation_RadioButton", objectData);
			sendKeys("Customization_CustomAdditionalInformation_Textbox", PropertiesCache.setProperty(testData, "AdditionalInformation_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "AdditionalInformation_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomReleaseManifest_RadioButton", objectData);
			sendKeys("Customization_CustomReleaseManifest_Textbox", PropertiesCache.setProperty(testData, "ReleaseManifest_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "ReleaseManifest_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomSystems_RadioButton", objectData);
			sendKeys("Customization_CustomSystems_Textbox", PropertiesCache.setProperty(testData, "Systems_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Systems_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomEvent_RadioButton", objectData);
			sendKeys("Customization_CustomEvent_Textbox", PropertiesCache.setProperty(testData, "Event_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Event_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomChange_RadioButton", objectData);
			sendKeys("Customization_CustomChange_Textbox", PropertiesCache.setProperty(testData, "Change_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Change_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomEnvironments_RadioButton", objectData);
			sendKeys("Customization_CustomEnvironments_Textbox", PropertiesCache.setProperty(testData, "Environment_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Environment_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomStakeholders_RadioButton", objectData);
			sendKeys("Customization_CustomStakeholders_Textbox", PropertiesCache.setProperty(testData, "Stakeholder_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Stakeholder_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomActivites_RadioButton", objectData);
			sendKeys("Customization_CustomActivites_Textbox", PropertiesCache.setProperty(testData, "Activities_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Activities_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomLinkedItems_RadioButton", objectData);
			sendKeys("Customization_CustomLinkedItems_Textbox", PropertiesCache.setProperty(testData, "LinkedItems_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "LinkedItems_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_CustomCapacity_RadioButton", objectData);
			sendKeys("Customization_CustomCapacity_Textbox", PropertiesCache.setProperty(testData, "Capacity_Tab"), customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, "Capacity_Tab")+" - Added Customization Tab Names successfully in Customization Page !");
			
			clickOnSubmitButton(customizationData, objectData);
		} else {
			clickOnButton(customizationData,"Customization_Release_Tab", objectData);
			PropertiesCache.setProperty(testData, "Release_Tab",getTextData("Customization_Release_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Release_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Project_Tab", objectData);
			PropertiesCache.setProperty(testData, "Project_Tab",getTextData("Customization_Project_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Project_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Independent_Tab", objectData);
			PropertiesCache.setProperty(testData, "Independent_Tab",getTextData("Customization_Independent_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Independent_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			sleep(1000);
			clickOnButton(customizationData,"Customization_AdditionalInformation_Tab", objectData);
			PropertiesCache.setProperty(testData, "AdditionalInformation_Tab",getTextData("Customization_AdditionalInformation_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "AdditionalInformation_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_ReleaseManifest_Tab", objectData);
			PropertiesCache.setProperty(testData, "ReleaseManifest_Tab",getTextData("Customization_ReleaseManifest_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "ReleaseManifest_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Systems_Tab", objectData);
			PropertiesCache.setProperty(testData, "Systems_Tab",getTextData("Customization_Systems_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Systems_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Event_Tab", objectData);
			PropertiesCache.setProperty(testData, "Event_Tab",getTextData("Customization_Event_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Event_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Change_Tab", objectData);
			PropertiesCache.setProperty(testData, "Change_Tab",getTextData("Customization_Change_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Change_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Environments_Tab", objectData);
			PropertiesCache.setProperty(testData, "Environment_Tab",getTextData("Customization_Environments_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Environment_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Stakeholders_Tab", objectData);
			PropertiesCache.setProperty(testData, "Stakeholder_Tab",getTextData("Customization_Stakeholders_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Stakeholder_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Activites_Tab", objectData);
			PropertiesCache.setProperty(testData, "Activities_Tab",getTextData("Customization_Activites_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Activities_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_LinkedItems_Tab", objectData);
			PropertiesCache.setProperty(testData, "LinkedItems_Tab",getTextData("Customization_LinkedItems_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "LinkedItems_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnButton(customizationData,"Customization_Capacity_Tab", objectData);
			PropertiesCache.setProperty(testData, "Capacity_Tab",getTextData("Customization_Capacity_Tab",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, "Capacity_Tab")+" - Added default Customization Tab Names successfully in Customization Page !");
			
			clickOnSubmitButton(customizationData, objectData);
		}
		
	}
	
	public void addReleaseTitle(String customizationData,String testData,String objectData,String title1,String title2,String custom) {
		if (custom.contains("Custom")) {
			clickOnButton(customizationData,"Customization_ReleaseTitle_Custom_Independent_RadioButton",objectData);
			sendKeys("Customization_ReleaseTitle_Custom_Independent_Textbox", PropertiesCache.setProperty(testData, title1),customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, title1)+" - Added Customization Tab Names successfully in Customization Page !");
			clickOnButton(customizationData,"Customization_ReleaseTitle_Custom_Project_RadioButton",objectData);
			sendKeys("Customization_ReleaseTitle_Custom_Project_Textbox", PropertiesCache.setProperty(testData, title2),customizationData);
			Listener.addLogger(PropertiesCache.getProperty(testData, title2)+" - Added Customization Tab Names successfully in Customization Page !");
			
		} else {
			clickOnButton(customizationData,"Customization_ReleaseTitle_Independent_RadioButton",objectData);
			PropertiesCache.setProperty(testData, title1,getTextData("Customization_ReleaseTitle_Independent_RadioButton",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, title1)+" - Added Customization Tab Names successfully in Customization Page !");
			clickOnButton(customizationData,"Customization_ReleaseTitle_Project_RadioButton",objectData);
			PropertiesCache.setProperty(testData, title2,getTextData("Customization_ReleaseTitle_Project_RadioButton",customizationData));
			Listener.addLogger(PropertiesCache.getProperty(testData, title2)+" - Added Customization Tab Names successfully in Customization Page !");
		}
		clickOnSubmitButton(customizationData, objectData);
	}
	public void editReleasePackageDate(String customizationData,String testData,String objectData,String name,String days) throws ParseException {
		click("Customization_CustomFields_Row",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		doubleClick("Customization_ReleasePackage_EndDate", name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
	}
	public void updateBulkReleasePackage(String customizationData, String testData,String objectData,String option,String name,String days) throws InterruptedException, ParseException {
		clickOnCustomFieldOption(customizationData, objectData, option);
		click("Customization_BulkAddReleasePackages_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("Customization_Bulk_StartDate_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Additional_information_DatePicker_Today_Button",objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("Customization_Bulk_EndDate_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
	
		click("Customization_Bulk_PackageFrequency_Icon",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_Bulk_PackageFrequency_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		sendKeys("Customization_Bulk_Package_Name", PropertiesCache.setProperty(testData, name), customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		
		click("Customization_Bulk_Preview_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		
		click("Customization_Bulk_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" Release Package is updated successfully");
	}
	public void addCustomizationIcon(String customizationData, String testData,String objectData,String name) {
		click("Customization_CustomFields_Row",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//Add icon
		doubleClick("Customization_ClickOnAddIcon_Button",name,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		doubleClick("Customization_AddIcon_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+" - Added Custom Icon field to custom field successfully in Customization Page !");
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void addSystemsEnterpriseSetupColumnsName(String customizationData,String testData,String objectData) {
		sendKeys("Customization_SystemsEnterprise_Setup_EnterpriseType_Textbox",PropertiesCache.setProperty(testData, "Enterprise_Type_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_EnterpriseDates_Textbox",PropertiesCache.setProperty(testData, "Enterprise_Dates_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeploymentType_Textbox",PropertiesCache.setProperty(testData, "Deployment_Type_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeployingTo_Textbox",PropertiesCache.setProperty(testData, "Deploying_To_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeploymentStartDate_Textbox",PropertiesCache.setProperty(testData, "Deployment_StartDate_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeploymentEndDate_Textbox",PropertiesCache.setProperty(testData, "Deployment_EndDate_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeploymentStatus_Textbox",PropertiesCache.setProperty(testData, "Deployment_Status_Column"),customizationData);
		sendKeys("Customization_SystemsEnterprise_Setup_DeploymentDates_Textbox",PropertiesCache.setProperty(testData, "Deployment_Dates_Column"),customizationData);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void updateCapacityManagement(String customizationData,String testData,String objectData,String capacityName,String atCount,String rtCount,String enableCheckbox,String disableCheckbox,String colorButton){
		sleep(2000);
		doubleClick("Customization_CapacityManagement_AmberThreshold_Text",capacityName,customizationData,testData);
		sleep(2000);
		sendKeysWithDeleteCharacter("Customization_CapacityManagement_AmberThreshold_Textbox", atCount,customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		doubleClick("Customization_CapacityManagement_RedThreshold_Text",capacityName,customizationData,testData);
		sleep(2000);
		sendKeysWithDeleteCharacter("Customization_CapacityManagement_RedThreshold_Textbox",rtCount,customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(enableCheckbox,disableCheckbox,capacityName,customizationData,testData,objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
	}
	public void sessionTimeout(String customizationData,String testData,String objectData) {
		clickOnButton(customizationData,"Customization_SiteSetting_TimeoutSessionAfter_Radiobox",objectData);
		sendKeys("Customization_SiteSetting_TimeoutSessionAfter_Textbox", "2",customizationData);
		clickOnButton(customizationData,"Customization_SiteSetting_LogoutTimeoutSession_Radiobox",objectData);
		sendKeys("Customization_SiteSetting_LogoutTimeoutSession_Textbox", "1",customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickOnSubmitButton(customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Session Timeout after checkox enabled successfully !");
	}
	public void loginPageMessage(String customizationData,String testData,String objectData) {
		switchToFrameByElement("TECR_Iframe",objectData);
		sendKeys("Description", "LoginPageMessage", objectData, testData);
		switchToDefaultContent();
		clickOnSubmitButton(customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "LoginPageMessage")+" Added to Login Page message textbox successfully !");
	}
	public void deleteLoginPageMessage(String customizationData,String testData,String objectData) {
		switchToFrameByElement("TECR_Iframe",objectData);
		sendKeysWithDelete("Description", "LoginPageMessage", objectData, testData,PlutoraConfiguration.platformName);
		switchToDefaultContent();
		clickOnSubmitButton(customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Removed Login page message successfully !");
	}
	public void updateLocalization(String customizationData,String testData,String objectData,String dateFormatText,String currencyFormatText,String numberFormatText,String decimalFormat,String decimalText) {
		clickElementUsingJavaScript("Customization_SiteSetting_Localization_DateFormat_Text",dateFormatText,customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnButton(customizationData,currencyFormatText,objectData);
		clickOnButton(customizationData,numberFormatText,objectData);
		PropertiesCache.setProperty(testData, "Number_Format",getTextData(numberFormatText, customizationData));
		clickOnButton(customizationData,decimalFormat,objectData);
		sendKeys("Customization_SiteSetting_Localization_DecimalFormat_Textbox",decimalText,customizationData);
		clickOnSubmitButton(customizationData, objectData);
		clickOnButton(customizationData,"Customization_SiteSetting_Localization_Yes_Button",objectData);
	}
	public void updateNewLocalization(String customizationData,String testData,String objectData,String dateFormatText,String currencyFormatText,String numberFormatText,String decimalFormat,String decimalText) {
		clickElementUsingJavaScript("Customization_SiteSetting_Localization_DateFormat_Text",dateFormatText,customizationData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnButton(customizationData,currencyFormatText,objectData);
		clickElement("Customization_SiteSetting_Localization_Yes_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		//clickOnButton(customizationData,"Customization_SiteSetting_Localization_Yes_Button",objectData);
		clickOnButton(customizationData,numberFormatText,objectData);
		PropertiesCache.setProperty(testData, "Number_Format",getTextData(numberFormatText, customizationData));
		clickOnButton(customizationData,decimalFormat,objectData);
		sendKeys("Customization_SiteSetting_Localization_DecimalFormat_Textbox",decimalText,customizationData);
		clickOnSubmitButton(customizationData, objectData);
		//clickOnButton(customizationData,"Customization_SiteSetting_Localization_Yes_Button",objectData);
		clickElement("Customization_SiteSetting_Localization_Yes_Button", customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public void selectSchedulerTECRRowColor(String customizationData,String testData,String objectData) {
		doubleClick("Customization_Scheduler_CR_Row_Color_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		doubleClick("Customization_Change_Color_FirstOption",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		String color=getAttributeValue("Customization_Scheduler_CR_Row_Color", customizationData,"style").split("none")[0].split("rgb")[1].replace("(", "").replace(");", "").split("color")[0].trim();
		System.out.println(color);
		PropertiesCache.setProperty(testData, "TECR_Color_Code",toHex(Integer.parseInt(color.split(",")[0].trim()), Integer.parseInt(color.split(",")[1].trim()), Integer.parseInt(color.split(",")[2].trim())));
	}
	public void addChannelImpactingSystem(String customizationData,String testData,String objectData,String systemId,String type) {
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_Add_Button",objectData);
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_Application_Dropdown",objectData);
		sendKeys("Customization_ChannelImpactingSystem_Application_Textbox", systemId,customizationData,testData,objectData);
		clickButton("Customization_ChannelImpactingSystem_Application_Option", systemId,customizationData,testData,objectData);
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_Save&Close_Button",objectData);
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_Enable_Checkbox","Customization_ChannelImpactingSystem_Enable_Disable_Checkbox",objectData,"xpath");
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_ReleaseType_Dropdown",objectData);
		selectMultipleButton(customizationData, "Customization_ChannelImpactingSystem_ReleaseType_Selected_Options");
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_ReleaseType_Option",objectData);
		clickOnButton(customizationData,"Customization_ChannelImpactingSystem_Submit_Button",objectData);
		
	}
	public void deleteEmailTemplate(String customizationData,String objectData) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			List<WebElement> elements=webElementsIdentifier(PropertiesCache.getProperty(customizationData, "Customization_Email_Template_Wizard_Delete_Icon"));
			for(WebElement element:elements) {
				element.isDisplayed();
				clickElementUsingJavaScript(element);
				waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
				clickElementUsingJavaScript("Customization_Email_Template_Wizard_Yes_Button",customizationData);
				waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			}
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		
	}
	
	public void setupCustomization(String customizationData,String testData,String objectData) throws InterruptedException, IOException {
		getCustomizationDetailsPage(customizationData, testData, objectData);
		//Tab Names
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleaseTabNames_Option");
		addCustomizationReleaseTabNames(customizationData, testData, objectData,"");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Tab Names - Verified !");
		
		//------------------------------------------------------Change-----------------------------------------------------------------------------//
		//Change Status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ChangeStatus_Option");
		clickOnButton(customizationData,"Customization_ChangeStatus_Disable_Workflow","Customization_ChangeStatus_Enable_Workflow",objectData,"xpath");
		clickElement("Customization_ChangeStatus_AllCompleted_Checkbox", customizationData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Change - Status - Verified !");
		
		//Change Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ChangeCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Change - Custom Field - Verified !");
		
		//Change Menu label
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ChangeMenuLabel_Option");
		addChangeMenuLabel(customizationData, testData, objectData, "Customization_ChangeMenuLabel_Option", "");
		Listener.addLogger("Customization - Change - Menu Label - Verified !");
		
		//Change Tab Names
		getCustomizationDetailsPage(customizationData, testData, objectData);
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TabNames_Option");
		addChangeTabNames(customizationData, testData, objectData, "Customization_TabNames_Option", "");
		Listener.addLogger("Customization - Change - Tab Names - Verified !");
		//------------------------------------------------------Stakeholder-----------------------------------------------------------------------------//
		//Stakeholder role
		clickOnCustomFieldOption(customizationData, objectData, "Customization_StakeholderRole_Option");
		clickWebelementButton(customizationData,"Customization_StakeholderRole_LastRecord_Default_Checked_Checkbox","Customization_StakeholderRole_LastRecord_Default_Checkbox",objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Stakeholder Role - Verified !");
		//-----------------------------------------------------Environment------------------------------------------------------------------------------//
		//Environment status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_EnvironmentStatus_Option");
		clickMultipleElement("Customization_EnvironmentStatus_NotBookable_Checkboxes", customizationData,objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment - Status - Verified !");
		
		//Environment scheduler TECR row
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Scheduler_TECR_Row_Option");
		clickOnButton(customizationData,"Customization_Scheduler_CR_Row_Checked_Checkbox","Customization_Scheduler_CR_Row_Checkbox",objectData,"xpath");
		sleep(4000);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment - Scheduler TECR Row - Verified !");
		
		//TECR Setup
		clickOnCustomFieldOption(customizationData, objectData, "TECR_Setup_Option");
		clickOnButton(customizationData, "TECR_Setup_No_Checkbox_Checked","TECR_Setup_No_Checkbox", objectData,"xpath");
		clickOnButton(customizationData, "TECR_Setup_EnterpriseRelease_Checkbox","TECR_Setup_EnterpriseRelease_Checkbox_Checked", objectData,"xpath");
		clickOnButton(customizationData, "TECR_Setup_NonEnterpriseRelease_Checkbox","TECR_Setup_NonEnterpriseRelease_Checkbox_Checked", objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TECR - Setup - Verified !");
		
		
		
		//TECR status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TECRStatus_Option");
		clickOnButton(customizationData, "Customization_TECRStatus_Disable_Workflow", "Customization_TECRStatus_Enable_Workflow", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TECR - Status - Verified !");
		
		//TECR Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TECRCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TECR - Custom Field - Verified !");
		
		//TEBR status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TEBRStatus_Option");
		clickOnButton(customizationData, "Customization_TEBRStatus_Disable_Workflow", "Customization_TEBRStatus_Enable_Workflow", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TEBR - Status - Verified !");
		
		//TEBR mandatory fields
		clickOnCustomFieldOption(customizationData, objectData, "TEBR_Mandatory_Fields");
		clickMultipleElement("TEBR_Checked_Fields", customizationData,objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TEBR - Mandatory Field - Verified !");
		
		//TEBR form
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TEBR_Form_Option");
		updateTEBRLandingCheckbox(PlutoraConfiguration.customizationData, "Customization_TEBR_Form_Landing_Disabled_Checkbox", "Customization_TEBR_Form_Landing_Enabled_Checkbox", PlutoraConfiguration.objectData);
		Listener.addLogger("Customization - Environment Request - TEBR Form - Disabled - Verified !");
		
		//TEBR Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_TEBRCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Request - TEBR - Custom Field - Verified !");
	
		//Environment Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_EnvironmentCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment - Custom Field - Verified !");
		
		//Environment Group Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_EnvGrpCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Environment Group - Custom Field - Verified !");
		
		//System Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_SystemCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - System - Custom Field - Verified !");
		
		//Environment Title Names
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Title_Names");
		setTitleNames(customizationData, testData,objectData);
		Listener.addLogger("Customization - Environment - Title Names - Verified !");

		//-----------------------------------------------------Deployments------------------------------------------------------------------------------//
		//Deployment Activities
		clickOnCustomFieldOption(customizationData, objectData, "Customization_DeploymentPlanActivities_Option");
		clickOnButton(PlutoraConfiguration.customizationData, "Customization_DeploymentPlanActivityStatus_RadioButton", PlutoraConfiguration.objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Deployment - Activities - Verified !");
		
		//Deployment Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_DeploymentPlanCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Deployment - Custom Field - Verified !");
		
		//Deployment Activities Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Deployment - Activities - Custom Field - Verified !");
		
		//-----------------------------------------------------Release------------------------------------------------------------------------------//
		//Release Status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleaseStatus_Option");
		clickOnButton(customizationData, "Customization_ReleaseStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		clickMultipleElement("Customization_ReleaseStatus_EndStatus_Checkboxes", customizationData,objectData);
		clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","4",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","5",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_ReleaseStatus_Last_Default_Checked_Checkbox","Customization_ReleaseStatus_Last_Default_Checkbox","6",customizationData,objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Status - Verified !");
		
		//Release Custom Field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleaseCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Custom Field - Verified !");
		
		//Capacity Custom Field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_CapacityCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Capacity - Custom Field - Verified !");
		
		//Add Custom field
		addCustomField(customizationData, testData, objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Name");
		addDataTypeOption(customizationData, testData, objectData, "Free Text","Capacity_CustomField_Name");
		
		//Activity/Criteria Custom Field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Activity/CriteriaCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Capacity - Custom Field - Verified !");
		
		//Release Phases
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleasePhases_Option");
		clickOnButton(customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", objectData, "xpath");
		clickOnButton(customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", objectData, "xpath");
		
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","4",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","5",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","6",customizationData,objectData,"xpath");
		
		clickWebelementButton("Customization_PhasesGates_Second_Default_Checked_Checkbox","Customization_PhasesGates_Second_Default_Checkbox","4",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_Second_Default_Checked_Checkbox","Customization_PhasesGates_Second_Default_Checkbox","5",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_Second_Default_Checked_Checkbox","Customization_PhasesGates_Second_Default_Checkbox","6",customizationData,objectData,"xpath");
		
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Phases - Verified !");
		
		//Release Gates
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleaseGates_Option");
		clickOnButton(customizationData, "Customization_PGWeekend_Enable_Workflow", "Customization_PGWeekend_Disable_Workflow", objectData, "xpath");
		clickOnButton(customizationData, "Customization_PGBlockout_Enable_Workflow", "Customization_PGBlockout_Disable_Workflow", objectData, "xpath");
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","4",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","5",customizationData,objectData,"xpath");
		clickWebelementButton("Customization_PhasesGates_First_Default_Checked_Checkbox","Customization_PhasesGates_First_Default_Checkbox","6",customizationData,objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Gates - Verified !");
		
		//Release Title Names
		clickOnCustomFieldOption(customizationData, objectData, "Customization_ReleaseTitle_Option");
		addReleaseTitle(customizationData, testData, objectData, "ITitle","PTitle","");
		Listener.addLogger("Customization - Release - Title Names - Verified !");
		
		//Event Management
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Event_Management_Option");
		clickOnButton(customizationData, "Customization_Event_Management_Enable", "Customization_Event_Management_Disable", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Event Management - Verified !");
		
		//Release Setup
		clickOnCustomFieldOption(customizationData,objectData, "Customization_Release_Setup");
		clickOnButton(customizationData, "Customization_Enterprise_Activities_Enable", "Customization_Enterprise_Activities_Disable", objectData, "xpath");
		clickOnButton(customizationData, "Customization_Dependency_Association_Enable", "Customization_Dependency_Association_Disable", objectData, "xpath");
		clickOnButton(customizationData, "Customization_Completed_Date_Enable", "Customization_Completed_Date_Disable", objectData, "xpath");
		clickOnButton(customizationData, "Customization_AC_Dates_Enable", "Customization_AC_Dates_Disable",objectData, "xpath");
		addReleaseTabNames(customizationData, testData, objectData, "Customization_ReleaseDependency_Label", "", "Release_Dependency", "");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Setup - Verified !");
		
		//Release System Deployment To
		clickOnCustomFieldOption(customizationData,objectData, "Customization_System_DeploymentTo_option");
		clickWebelementButton(customizationData, "Customization_System_DeploymentTo_Default_Checked_Checkbox", "Customization_System_DeploymentTo_Default_Unchecked_Checkbox", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - System - Deployment To - Verified !");
		
		//Release deployment status label
		getCustomizationDetailsPage(customizationData, testData, objectData);
		clickOnCustomFieldOption(customizationData, objectData,"Customization_Deployment_Status_Label");
		addReleaseTabNames(customizationData, testData, objectData, "Customization_Deployment_Pending_Status_Radio_Button", "", "Pending", "");
		addReleaseTabNames(customizationData, testData, objectData, "Customization_Deployment_Completed_Status_Radio_Button", "", "Completed", "");
		addReleaseTabNames(customizationData, testData, objectData, "Customization_Deployment_Rejected_Status_Radio_Button", "", "Rejected", "");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - System - Deployment Status Label - Verified !");
		
		//Capacity Management
		clickOnCustomFieldOption(customizationData, objectData,"Customization_CapacityManagement_Option");
		clickOnButton(customizationData, "Customization_CapacityManagement_Enable_Workflow", "Customization_CapacityManagement_Disable_Workflow", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Release - Capacity Management - Verified !");
		
		//-----------------------------------------------------Email Settings------------------------------------------------------------------------------//
		//Email Setting
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Email_Template_Wizard_Option");
		deleteEmailTemplate(customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Email Setting - Verified !");
		
		//Session timeout
		clickOnCustomFieldOption(customizationData, objectData, "Customization_SiteSetting_SessionTimeout_Option");
		clickOnButton(customizationData, "Customization_SiteSetting_NeverTimeoutSession_Radiobox", objectData);
		clickOnSubmitButton(customizationData, objectData);
		
		//Login Page Message
		clickOnCustomFieldOption(customizationData, objectData, "Customization_SiteSetting_LoginPageMessage_Option");
		switchToFrameByElement("TECR_Iframe",objectData);
		clear("Description", objectData);
		switchToDefaultContent();
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Site Setting - Login Page Message - Verified !");
		
		//Localization
		clickOnCustomFieldOption(customizationData, objectData, "Customization_SiteSetting_Localization_Option");
		updateNewLocalization(customizationData,testData, objectData, "DD/MM/YYYY", "Customization_SiteSetting_Localization_CurrencyFormat_Doller_Text", "Customization_SiteSetting_Localization_NumberFormat_Second_Text", "Customization_SiteSetting_Localization_DecimalFormat_Dot_Text", "2");
		Listener.addLogger("Customization - Site Setting - Localization - Verified !");
		//--------------------------------------------------------------PIR---------------------------------------------------------------------//
		
		//PIR Setup
		clickOnCustomFieldOption(customizationData, objectData, "Customization_PIR_Setup_Option");
		clickOnButton(customizationData, "Customization_PIR_ResetToDefault_Button",objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - PIR - Setup - Verified !");
		
		//PIR Status
		clickOnCustomFieldOption(customizationData, objectData, "Customization_PIRStatus_Option");
		clickOnButton(customizationData, "Customization_PIRStatus_Disable_Workflow", "Customization_ReleaseStatus_Enable_Workflow", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - PIR - Status - Verified !");
		
		//PIR Custom field
		clickOnCustomFieldOption(customizationData, objectData, "Customization_PIRItemCustomFields_Option");
		clickMultipleElement("Customization_Mandatory_Checkbox",customizationData, objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger("Customization - Capacity - Custom Field - Verified !");

	}
	public void createCustomFieldTab(String customizationData,String testData,String objectData,String tabName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Tabs",objectData);
		clickOnButton(customizationData,"Customization_CustomField_Tabs_Add_Button",objectData);
		sendKeys("Customization_CustomField_Tabs_Textbox", PropertiesCache.setProperty(testData, tabName),customizationData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_CustomField_Tabs_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tabName)+" created custom field tab successfully !");
	}
	
	public void createCustomFieldGroup(String customizationData,String testData,String objectData,String groupName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Grouping",objectData);
		clickOnButton(customizationData,"Customization_CustomField_Groups_Add_Button",objectData);
		sleep(2000);
		sendKeys("Customization_CustomField_Group_Textbox", PropertiesCache.setProperty(testData, groupName),customizationData);
		sleep(5000);
		//Add color
		clickOnButton(customizationData,"Customization_Change_ClickToAddColor",objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(5000);
		doubleClick("Customization_CustomField_Group_Color_Dropdown",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("Customization_Change_Color_FirstOption",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_CustomField_Group_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, groupName)+" updated custom field group field successfully !");
	}

	public void editCustomFieldTab(String customizationData,String testData,String objectData,String tabName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Tabs",objectData);
		click("Customization_TabParent_Name",tabName,customizationData,testData);
		sleep(1000);
		clear("Customization_CustomField_Tabs_Textbox", customizationData);
		clickOnButton(customizationData,"Customization_TabParent_Selected_Row",objectData);
		sleep(1000);
		WebElement element = webElementIdentifier(PropertiesCache.getProperty(customizationData, "Customization_CustomField_Tabs_Textbox"));
		element.sendKeys(PropertiesCache.setProperty(testData, tabName));
		sleep(2000);
		clickOnButton(customizationData,"Customization_CustomField_Tabs_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tabName)+" updated custom field tab successfully !");
	}

	public void editCustomFieldGroup(String customizationData,String testData,String objectData,String groupName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Grouping",objectData);
		click("Customization_TabParent_Name",groupName,customizationData,testData);
		sleep(1000);
		clear("Customization_CustomField_Group_Textbox", customizationData);
		clickOnButton(customizationData,"Customization_GroupFields_Selected_Row",objectData);
		sleep(1000);
		WebElement element = webElementIdentifier(PropertiesCache.getProperty(customizationData, "Customization_CustomField_Group_Textbox"));
		element.sendKeys(PropertiesCache.setProperty(testData, groupName));
		sleep(2000);
		clickOnButton(customizationData,"Customization_CustomField_Group_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, groupName)+" updated custom field group field successfully !");
	}
	public void removeCustomFieldTab(String customizationData,String testData,String objectData,String tabName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Tabs",objectData);
		doubleClick("Customization_TabParent_Name",tabName,customizationData,testData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_TabParent_Remove_Button",objectData);
		clickOnButton(customizationData,"Customization_CustomField_Tabs_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tabName)+" removed custom field tab successfully !");
	}
	public void removeCustomFieldGroup(String customizationData,String testData,String objectData,String groupName) {
		clickOnButton(customizationData,"Customization_CustomField_Add/Edit_Grouping",objectData);
		doubleClick("Customization_TabParent_Name",groupName,customizationData,testData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_TabParent_Remove_Button",objectData);
		clickOnButton(customizationData,"Customization_CustomField_Group_Close_Icon",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, groupName)+" removed custom field group field successfully !");
	}
	public void selectTabParent(String customizationData,String testData,String objectData,String customFieldName,String tabName) {
		clickButton("Customization_CustomFields_Row",customFieldName,customizationData,testData,objectData);
		doubleClick("Customization_TabParent",customFieldName,customizationData,testData);
		clickOnButton(customizationData, "Customization_TabParent_Dropdown_Icon", objectData);
		clickButton("Customization_TabParent_Dropdown_Option",tabName,customizationData,testData,objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tabName)+" Choosen tab to custom field successfully ! ");
	}
	public void selectGroupField(String customizationData,String testData,String objectData,String customFieldName,String groupName) {
		clickButton("Customization_CustomFields_Row",customFieldName,customizationData,testData,objectData);
		doubleClick("Customization_GroupFields",customFieldName,customizationData,testData);
		clickOnButton(customizationData, "Customization_GroupFields_Dropdown_Icon", objectData);
		clickButton("Customization_GroupFields_Dropdown_Option",groupName,customizationData,testData,objectData);
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, groupName)+" Choosen tab to custom field successfully ! ");
	}
	public void setBulkUpdatePermission(String customizationData, String testData,String objectData,String name1,String name2,String type,String by,String checkbox,String option) throws InterruptedException {
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		clickOnButton(customizationData,"Customization_CustomField_Default_Checked_Checkbox",objectData);
		clickOnButton("Customization_CustomField_Checked_Checkbox","Customization_CustomField_Checkbox",name1,customizationData,testData,objectData,"xpath");
		clickOnButton("Customization_CustomField_Checked_Checkbox","Customization_CustomField_Checkbox",name2,customizationData,testData,objectData,"xpath");
		clickOnButton(customizationData,"Customization_CustomField_BulkUpdatePermissions_Button",objectData);
		//Type
		clickElementUsingJavaScript("Customization_ChangeCustomFields_FieldPermission_Type_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ChangeCustomFields_FieldPermission_Type_Option",type,customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//By
		click("Customization_ChangeCustomFields_FieldPermission_By_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Customization_ChangeCustomFields_FieldPermission_By_Option",by,customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		if(by.equals("Role") || by.equals("User Group") ) {
			driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, checkbox))).click();
		}else {
		sleep(2000);
		driver.findElement(By.xpath(PropertiesCache.getProperty(customizationData, checkbox).replace("TEXT", option))).click();
		}
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		//Save
		click("Customization_ChangeCustomFields_FieldPermission_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		//Submit
		clickOnSubmitButton(customizationData, objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name1)+" "+type+" "+by+" are selected permission for option ! ");
		Listener.addLogger(PropertiesCache.getProperty(testData, name2)+" "+type+" "+by+" are selected permission for option ! ");
	}
	
	public void updateTEBRLandingCheckbox(String customizationData,String enableCheckbox,String disableCheckbox,String objectData) {
		clickOnButton(customizationData,enableCheckbox,disableCheckbox,objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
	}
	public void enableSubEnvironments(String customizationData,String objectData,String option) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		clickOnButton(customizationData, "Customization_Enable_SubEnvironments_Checked_Checkbox", "Customization_Enable_SubEnvironments_UnChecked_Checkbox", objectData, "xpath");
		clickOnSubmitButton(customizationData, objectData);
	}
	public void enableExternalURLMenuItem(String customizationData,String testData,String objectData,String option,String url) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		clickOnButton(customizationData,"Customization_ExternalUrlMenuItem_Enabled_Checkbox_Checked","Customization_ExternalUrlMenuItem_Enabled_Checkbox",objectData,"xpath");
		sendKeys("Customization_ExternalUrlMenuItem_MenuLabel_Textbox", "Plutora",customizationData);
		clickOnButton(customizationData, "Customization_ExternalUrlMenuItem_LabelColor_Dropdown", objectData);
		doubleClick("Customization_Change_Color_FirstOption",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		
		clickOnButton(customizationData, "Customization_ExternalUrlMenuItem_BackgroundColor_Dropdown", objectData);
		doubleClick("Customization_Change_Color_FirstOption",customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		
		sendKeys("Customization_ExternalUrlMenuItem_Url_Textbox", url,customizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		
		clickOnSubmitButton(customizationData, objectData);
		PropertiesCache.setProperty(testData, "Label_Color",getAttributeValue("Customization_ExternalUrlMenuItem_LabelColor_Textbox",customizationData , "style").split("rgb")[1].split("color")[0].replace("(", "").replace(");", ""));
		PropertiesCache.setProperty(testData, "Background_Color",getAttributeValue("Customization_ExternalUrlMenuItem_BackgroundColor_Textbox",customizationData , "style").split("rgb")[1].split("color")[0].replace("(", "").replace(");", ""));
	}
	public void disableExternalURLMenuItem(String customizationData,String objectData,String option) {
		clickOnCustomFieldOption(customizationData, objectData, option);
		clickOnButton(customizationData,"Customization_ExternalUrlMenuItem_Enabled_Checkbox","Customization_ExternalUrlMenuItem_Enabled_Checkbox_Checked",objectData,"xpath");
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void addWelcomeMessage(String customizationData,String testData,String objectData ) {
		switchToFrameByElement("Customization_SiteSetting_WelcomeMessage_Frame", customizationData);
		sendKeys("Customization_SiteSetting_WelcomeMessage_Text", "Welcome_Message",customizationData,testData);
		switchToDefaultContent();
		clickOnSubmitButton(customizationData, objectData);
		
	}
	public void selectHomePageOption(String customizationData,String testData,String objectData,String option) {
		clickOnButton(customizationData,"Customization_WelcomePageSetting_HomePage_Dropdown",objectData);
		click("Customization_WelcomePageSetting_HomePage_Dropdown_Option", option, customizationData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void addInternalQuickLink(String customizationData,String testData,String objectData,String option) {
		clickOnButton(customizationData, "Customization_WelcomePageSetting_QuickLink_NewLink_Button", objectData);
		sendKeys("Customization_WelcomePageSetting_QuickLink_NewLink_Textbox", PropertiesCache.setProperty(testData, "QuickLink"),customizationData);
		clickOnButton(customizationData, "Customization_WelcomePageSetting_QuickLink_LaunchInternal_Checkbox", objectData);
		clickOnButton(customizationData, "Customization_WelcomePageSetting_QuickLink_LaunchInternal_Dropdown", objectData);
		click("Customization_WelcomePageSetting_QuickLink_LaunchInternal_Dropdown_Option",option,customizationData);
		clickOnSubmitButton(customizationData, objectData);
		
	}
	public void addWidgetGrid(String customizationData,String testData,String objectData,String iconOption) {
		clickOnButton(customizationData, "Customization_WelcomePageSetting_QuickLink_NewLink_Button", objectData);
		sendKeys("Customization_WelcomePageSetting_WidgetGrid_Title_Textbox", PropertiesCache.setProperty(testData, "WidgetGrid"),customizationData);
		clickOnButton(customizationData, "Customization_WelcomePageSetting_WidgetGrid_Icon_Dropdown", objectData);
		click("Customization_WelcomePageSetting_WidgetGrid_Icon_Option",iconOption,customizationData);
		
		switchToFrameByElement("Customization_WelcomePageSetting_WidgetGrid_Content_Frame", customizationData);
		sendKeys("Customization_WelcomePageSetting_WidgetGrid_Content_Textarea", "Welcome_Message",customizationData,testData);
		sendKeysWithoutClear("Customization_WelcomePageSetting_WidgetGrid_Content_Textarea", " ",customizationData);
		switchToDefaultContent();
		sleep(1000);
		
		clickOnSubmitButton(customizationData, objectData);
	}
	public void selectNewUserToDefaultView(String customizationData,String testData,String objectData,String firstName) {
		clickOnButton(customizationData, "Customization_DefaultGridViews_ReleasesDefaultView_Text", objectData);
		clear("Customization_DefaultGridViews_ReleasesDefaultView_Textbox", customizationData);
		clickOnButton(customizationData, "Customization_DefaultGridViews_ReleasesDefaultView_Text", objectData);
		sendKeysWithoutClear("Customization_DefaultGridViews_ReleasesDefaultView_Textbox", firstName, customizationData,testData);
		click("Customization_DefaultGridViews_ReleasesDefaultView_Option",firstName,customizationData,testData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void deletePageSetting(String customizationData,String testData,String objectData,String customField) {
		clickButton("Customization_WelcomePageSetting_Text",customField,customizationData,testData,objectData);
		clickOnButton(customizationData,"Customization_Delete_Button",objectData);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void enableAnnouncements(String customizationData,String testData,String objectData,String announcementText) {
		clickOnButton(customizationData, "Customization_AnnouncementsFeed_Enabled_Checkbox", "Customization_AnnouncementsFeed_Disabled_Checkbox",objectData);
		sendKeys("Customization_AnnouncementsFeed_Textarea", PropertiesCache.setProperty(testData, announcementText),customizationData);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void addCustomDescription(String customizationData,String testData,String objectData) {
		scrollToElement("Customization_CustomDescription_Customization_DefaultCheckbox",customizationData);
		clickOnButton(customizationData, "Customization_CustomDescription_Customization_DefaultCheckbox", objectData);
		doubleClick("Customization_CustomDescription_Customization_Description",customizationData);
		clear("Customization_CustomDescription_Customization_Description_Textbox", customizationData);
		doubleClick("Customization_CustomDescription_Customization_Description",customizationData);
		sendKeysWithoutClear("Customization_CustomDescription_Customization_Description_Textbox", "Customization_Custom_Description",customizationData,testData);
		sleep(2000);
		click("Customization_CustomDescription_Customization_Text",customizationData);
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void enableOrDisableDashboardsAndReports(String customizationData,String testData,String objectData,String checkedOption,String notCheckedOption) {
		//Select Dashboard and Report option
		clickOnCustomFieldOption(customizationData, objectData, "Customization_DashboardsAndReports_Option");
		clickOnButton(customizationData, "Customization_DashboardsAndReports_Expanded_Icon", "Customization_DashboardsAndReports_NotExpanded_Icon", objectData);
		clickOnButton(customizationData, "Customization_DashboardsAndReports_VisibilityOfDashboardsPanels", objectData);
		//Select role
		clickOnButton(customizationData, "Customization_DashboardsAndReports_SelectRole_Dropdown", objectData);
		click("Customization_DashboardsAndReports_SelectRole_Dropdown_Option","Super Admin",customizationData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		clickOnSubmitButton(customizationData, objectData);
		//Enable dashboard option
		clickWebElementButton(customizationData, checkedOption,notCheckedOption, objectData);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void enableOrDisableInitiativeSetup(String customizationData,String objectData,String checkedOption,String notCheckedOption) {
		//Select setup option
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Initiative_Option");
		clickOnButton(customizationData, "Customization_Initiative_Expanded_Icon", "Customization_Initiative_NotExpanded_Icon", objectData);
		clickOnButton(customizationData, "Customization_Initiative_Setup_Option", objectData);
		//Enable setup option
		clickWebElementButton(customizationData, checkedOption,notCheckedOption, objectData);
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void clickOnInitiativeOption(String customizationData,String objectData,String option) {
		//Select Initiative option
		clickOnCustomFieldOption(customizationData, objectData, "Customization_Initiative_Option");
		clickOnButton(customizationData, "Customization_Initiative_Expanded_Icon", "Customization_Initiative_NotExpanded_Icon", objectData);
		clickOnButton(customizationData, option, objectData);
	}
	public void createNewFormBuilder(String customizationData,String testData,String objectData,String tabName,String formName,String panelName) {
		clickOnButton(customizationData, "Customization_Initiative_NewForm_Button", objectData);
		
		//Tab Name 
		clickOnButton(customizationData, "Customization_Initiative_Tab_Edit_Icon", objectData);
		sendKeys("Customization_Initiative_Tab_Title_Textbox", PropertiesCache.setProperty(testData, tabName),customizationData);
		clickOnButton(customizationData, "Customization_Initiative_Tab_Title_Submit_Button", objectData);
		
		//Panel Modification
		clickOnButton(customizationData, "Customization_Initiative_Panel_Setting_Icon", objectData);
		clickOnButton(customizationData, "Customization_Initiative_Panel_Edit_Link", objectData);
		dragAndDrop("Customization_Initiative_Panel_Button_Option", "Customization_Initiative_Panel_Area", customizationData);
		dragAndDrop("Customization_Initiative_Panel_Checkbox_Option", "Customization_Initiative_Panel_Area", customizationData);
		dragAndDrop("Customization_Initiative_Panel_CheckboxGroup_Option", "Customization_Initiative_Panel_Area", customizationData);
		dragAndDrop("Customization_Initiative_Panel_Number_Option", "Customization_Initiative_Panel_Area", customizationData);
		
		clickOnButton(customizationData, "Customization_Initiative_Panel_Save_Button", objectData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_Initiative_Panel_Close_Icon",objectData );
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		//Rename Panel 
		clickOnButton(customizationData, "Customization_Initiative_Panel_Setting_Icon", objectData);
		clickOnButton(customizationData, "Customization_Initiative_Panel_Rename_Link", objectData);
	    sendKeys("Customization_Initiative_Panel_Textbox", PropertiesCache.setProperty(testData, panelName),customizationData);	
	    sleep(2000);
		//Edit form information
		clickWebElementButton(customizationData, "Customization_Initiative_FormInformation_Expanded_Icon","Customization_Initiative_FormInformation_NotExpanded_Icon", objectData);
		sendKeys("Customization_Initiative_FormInformation_Textbox",PropertiesCache.setProperty(testData, formName),customizationData);
		clickOnButton(customizationData,"Customization_Initiative_FormInformation_AllowAttachments_Checkbox",objectData);
		clickOnButton(customizationData,"Customization_Initiative_FormInformation_AllowComments_Checkbox",objectData);
		sleep(2000);
		clickOnButton(customizationData, "Customization_Initiative_FormInformation_Close_Icon", objectData);
		
	}
	public void updateNewFormBuilder(String customizationData,String testData,String objectData,String formName) {
		clickButton("Customization_Initiative_Form_Title", formName, customizationData, testData, objectData);
		sleep(2000);
		clickWebElementButton(customizationData, "Customization_Initiative_FormInformation_Expanded_Icon","Customization_Initiative_FormInformation_NotExpanded_Icon", objectData);
		sendKeys("Customization_Initiative_FormInformation_Textbox",PropertiesCache.setProperty(testData, formName),customizationData);
		sleep(2000);
	
		clickOnButton(customizationData, "Customization_Initiative_FormInformation_Close_Icon", objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
	public void deleteFormBuilder(String customizationData,String testData,String objectData,String formName) {
		sleep(2000);
		clickButton("Customization_Initiative_Form_Row", formName, customizationData, testData, objectData);
		clickOnButton(customizationData, "Customization_Initiative_Form_Delete_Button", objectData);
		clickOnButton(customizationData, "Customization_Initiative_Form_Yes_Button", objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	public void deleteSetupMenu(String customizationData,String testData,String objectData,String menuName) throws InterruptedException {
		mouseOver("Customization_Initiative_Menu_Row", menuName, customizationData, testData);
		clickButton("Customization_Initiative_Menu_Row", menuName, customizationData, testData,objectData);
		clickButton("Customization_Initiative_Menu_Delete_Icon", menuName,customizationData,testData,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickOnSubmitButton(customizationData, objectData);
	}
	public void addNewMenu(String customizationData,String testData,String objectData,String menuName,String formName) {
		clickOnButton(customizationData, "Customization_Initiative_Setup_NewMenu_Button", objectData);
		sendKeys("Customization_Initiative_Setup_MenuTitle_Textbox",PropertiesCache.setProperty(testData, menuName),customizationData);
		clickOnButton(customizationData, "Customization_Initiative_Setup_LaunchForm_Dropdown", objectData);
		clickButton("Customization_Initiative_Setup_LaunchForm_Dropdown_Option",formName , customizationData, testData, objectData);
		clickOnButton(customizationData, "Customization_Initiative_Setup_SaveAndClose_Button", objectData);
		clickOnSubmitButton(customizationData, objectData);
	}
	
	public void updateEmailTemplate(String customizationData,String testData,String objectData,String templateName,String emailSubjectName,String entityName,String option,String triggerName ) {
		clickButton("Customization_Email_Template_Wizard_Edit_Button",templateName,customizationData,testData,objectData);
		sendKeys("Customization_Email_Template_Wizard_Name_Textfield", PropertiesCache.setProperty(testData,emailSubjectName),customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Customization_Email_Template_Wizard_Next_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);

		click("Customization_Email_Template_Wizard_Entity_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Customization_Email_Template_Wizard_Entity_Dropdown_Option",entityName,customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Customization_Email_Template_Wizard_Trigger_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click(option,triggerName,customizationData);
		sleep(1000);	
		click("Customization_Email_Template_Wizard_Next_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);

		sendKeys("Customization_Email_Template_Wizard_EmailSubject_Textbox",emailSubjectName,customizationData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		click("Customization_Email_Template_Wizard_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void updateEnvironmentBookingEmailTemplate(String customizationData,String testData,String objectData,String templateName,String option,String triggerName ) {
		clickButton("Customization_Email_Template_Wizard_Edit_Button",templateName,customizationData,testData,objectData);
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_EntityAndTrigger_Tab",objectData);
		
		clickElementUsingJavaScript("Customization_Email_Template_Wizard_Trigger_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click(option,triggerName,customizationData);
		
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_EB_On_Button","Customization_Email_Template_Wizard_EB_Off_Button",objectData);
		sleep(2000);
		
		click("Customization_Email_Template_Wizard_EB_Dropdown",customizationData);
		sleep(2000);
		click("Customization_Email_Template_Wizard_EB_Dropdown_Option","Approved",customizationData);
		sleep(2000);
		click("Customization_Email_Template_Wizard_EB_Dropdown",customizationData);
		sleep(2000);
		
		click("Customization_Email_Template_Wizard_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
	}
	public void updateIMConstructorEmailTemplate(String customizationData,String testData,String objectData,String templateName,String option,String triggerName ) {
		clickButton("Customization_Email_Template_Wizard_Edit_Button",templateName,customizationData,testData,objectData);
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_EntityAndTrigger_Tab",objectData);
		clickElementUsingJavaScript("Customization_Email_Template_Wizard_Trigger_Dropdown",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click(option,triggerName,customizationData);
		
		click("Customization_Email_Template_Wizard_IM_Trigger_Dropdown",customizationData);
		sleep(2000);
		clickOnButton(customizationData,"Customization_Email_Template_Wizard_IM_Trigger_Dropdown_Option",objectData);
		click("Customization_Email_Template_Wizard_IM_Trigger_Dropdown",customizationData);
		sleep(2000);
		
		click("Customization_Email_Template_Wizard_Save&Close_Button",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
	}
	
	
	
	
}
