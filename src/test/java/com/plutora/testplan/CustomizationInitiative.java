package com.plutora.testplan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.InitiativePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class CustomizationInitiative {
	CustomizationPage customizationPage = new CustomizationPage();
	InitiativePage initiativePage = new InitiativePage();

	@Test (description="Sub-area: Form Builder")
	public void customizationInitiative_01() throws InterruptedException  {
		//Enable initiative setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableOrDisableInitiativeSetup(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Initiative_Setup_Checked_Checkbox","Customization_Initiative_Setup_UnChecked_Checkbox");
		
		//Click on form builder option & create new form builder
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_FormBuilder_Option");
		customizationPage.createNewFormBuilder(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Tab", "Initiative_Form","Initiative_Panel");
		
		customizationPage.verifyText("Customization_Initiative_Form_Title", "Initiative_Form",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form")+" created successfully !");
		
		//Update form builder
		customizationPage.updateNewFormBuilder(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Form");
		customizationPage.verifyText("Customization_Initiative_Form_Title", "Initiative_Form",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form")+" updated form name successfully !");
		
	}
	
	@Test (description="Sub-area: Setup")
	public void customizationInitiative_02() throws InterruptedException, IOException  {
		//Enable initiative setup
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableOrDisableInitiativeSetup(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_Initiative_Setup_Checked_Checkbox","Customization_Initiative_Setup_UnChecked_Checkbox");
		
		customizationPage.addNewMenu(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu", "Initiative_Form");
		customizationPage.verifyText("Customization_Initiative_Menu_Title", "Initiative_Menu",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Menu")+" created successfully !");
		
		customizationPage.verifyText("Customization_Initiative_LaunchForm_Title", "Initiative_Form",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form")+" verified in customization successfully !");
		
		initiativePage.refresh(PlutoraConfiguration.objectData);
		initiativePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		initiativePage.sleep(2000);
		
		initiativePage.gotoInitiativePage(PlutoraConfiguration.initiativeData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu");
		
		initiativePage.verifyText("Initiative_Form_Tab_Name", "Initiative_Tab",PlutoraConfiguration.initiativeData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Tab")+" displayed successfully !");
		
		initiativePage.verifyText("Initiative_Form_Panel_Name", "Initiative_Panel",PlutoraConfiguration.initiativeData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Panel")+" displayed successfully !");
		
		initiativePage.validateElementDisplayed("Initiative_Form_Attachments", PlutoraConfiguration.initiativeData);
		Listener.addLogger("Attachments Icon displayed successfully !");
		
		initiativePage.validateElementDisplayed("Initiative_Form_Comments", PlutoraConfiguration.initiativeData);
		Listener.addLogger("Comments Icon displayed successfully !");
		//Add attachment
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData, "Initiative_Form_Attachments", PlutoraConfiguration.objectData);
		initiativePage.scrollToElement("Attachment_New_Button",PlutoraConfiguration.objectData);
		initiativePage.sleep(1000);
		initiativePage.clickElementUsingJavaScript("Attachment_New_Button",PlutoraConfiguration.objectData);
		initiativePage.sleep(1000);
		initiativePage.uploadImageByName("uploadfile");
		initiativePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData,"File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" displayed successfully !");
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData, "Initiative_Form_Close_Icon", PlutoraConfiguration.objectData);
		
		//Add Comments
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData, "Initiative_Form_Comments", PlutoraConfiguration.objectData);
		initiativePage.sendKeys("Initiative_Form_Comments_Textarea",PropertiesCache.setProperty(PlutoraConfiguration.testData, "Initiative_Comments"),PlutoraConfiguration.initiativeData);
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData,"Initiative_Form_Comments_Send_Button",PlutoraConfiguration.objectData);
		initiativePage.verifyText("Initiative_Form_Comments_Text", "Initiative_Comments",PlutoraConfiguration.initiativeData,PlutoraConfiguration.testData);
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData, "Initiative_Form_Close_Icon", PlutoraConfiguration.objectData);
		//Close Popup
		initiativePage.clickOnButton(PlutoraConfiguration.initiativeData, "Initiative_Form_Close_Popup", PlutoraConfiguration.objectData);
	
		//Delete form builder
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_FormBuilder_Option");
		customizationPage.deleteFormBuilder(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Form");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Form")+" deleted successfully !");
		//Delete Menu
		customizationPage.clickOnInitiativeOption(PlutoraConfiguration.customizationData,PlutoraConfiguration.objectData,"Customization_Initiative_Setup_Option");
		customizationPage.deleteSetupMenu(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Initiative_Menu");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Initiative_Menu")+" deleted successfully !");
		
	}
	
}
