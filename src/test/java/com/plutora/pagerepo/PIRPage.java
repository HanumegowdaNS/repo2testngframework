package com.plutora.pagerepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

@SuppressWarnings("unused")
public class PIRPage  extends TestGenericUtilLib{
	public static String status = null;
	public static String pirID = null;
	public static String questionName = null;
	public static String pmSystemName = null;
	public static String pmStatusName = null;
	public static String pmAssignedToName = null;
	public static String pmElementName = null;

	public void getPIRDetailsPage(String pirData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear(60,"Loading_Gif", objectData);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("PIR_Header_Sidemenu", pirData);
			sleep(500);
			click("PIR_PIRManager_Sidemenu", pirData);
		} else {
			mouseHover("PIR_Header_Dropdown", "PIR_PIRManager_Option",pirData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Button",pirData);
	}

	public void getPIRManagerPage(String pirData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		mouseHover("PIR_Header_Dropdown", "PIR_PIRManager_Option",pirData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
	}

	public void getPIRCreationPage(String pirData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Button",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void creationPIR(String pirData,String testData,String objectData,String platform) throws InterruptedException{	
		/* Enter New Systems Name */
	//	click("PIR_Button",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddPIR_IDTextfield",PropertiesCache.setProperty(testData, "PIR_Test_Automation_Id"),pirData);
		sendKeys("AddPIR_NameTextfield",PropertiesCache.setProperty(testData, "PIR_Test_Automation_Name"),pirData);
//		sleep(4000);
//		click("LeftJustfiyText_Button", objectData);
		sleep(2000);
		switchToFrameByElement("PIR_Iframe",objectData);
		if (PlutoraConfiguration.browserName.equals("FF")) {
			sendKeysWithBackspace("PIR_Description_TextField","PIR_Description_TextField_Value", objectData, testData,platform);
		} else {
			sendKeys("PIR_Description_TextField", "PIR_Description_TextField_Value", objectData, testData);
		}
		switchToDefaultContent();
		click("AddPIR_TypeDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "PIR_Type",getTextData("AddPIR_Type_Option1", pirData));
		click("AddPIR_Type_Option1",pirData);
		sleep(2000);
		click("AddPIR_StatusDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "PIR_Status",getTextData("AddPIR_Status_Option", pirData));
		click("AddPIR_Status_Option",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddPIR_ReleaseDropdown",pirData);
		sleep(2000);
		click("AddPIR_ReleaseFirst_Option",pirData);
		sleep(2000);
		//click("AddPIR_IDTextfield",pirData);
		/* Click on Save & close Button */
		click("PIR_Save&CloseButton",pirData);
	}
	
	public void creationPIRWithoutRelease(String pirData,String testData,String objectData,String platform) throws InterruptedException{	
		/* Enter New Systems Name */
		sleep(4000);
		sendKeys("AddPIR_IDTextfield",PropertiesCache.setProperty(testData, "PIR_Test_Automation_Id"),pirData);
		sendKeys("AddPIR_NameTextfield",PropertiesCache.setProperty(testData, "PIR_Test_Automation_Name"),pirData);
		sleep(4000);
		click("LeftJustfiyText_Button", objectData);
		sleep(2000);
		switchToFrameByElement("PIR_Iframe",objectData);
		if (PlutoraConfiguration.browserName.equals("FF")) {
			sendKeysWithBackspace("PIR_Description_TextField","PIR_Description_TextField_Value", objectData, testData,platform);
		} else {
			sendKeys("PIR_Description_TextField", "PIR_Description_TextField_Value", objectData, testData);
		}
		switchToDefaultContent();
		click("AddPIR_TypeDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("AddPIR_Type_Option1",pirData);
		sleep(2000);
		click("AddPIR_StatusDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddPIR_Status_Option",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//click("AddPIR_IDTextfield",pirData);
		/* Click on Save & close Button */
		click("PIR_Save&CloseButton",pirData);
	}

	public void creationPIR(String pirData,String testData,String objectData,String platform,String pirId) throws InterruptedException{	
		/* Enter New Systems Name */
		sleep(4000);
		sendKeys("AddPIR_IDTextfield",PropertiesCache.setProperty(testData,pirId),pirData);
		sendKeys("AddPIR_NameTextfield",PropertiesCache.setProperty(testData, "PIR_Test_Automation_Name"),pirData);
		sleep(4000);
		click("LeftJustfiyText_Button", objectData);
		sleep(2000);
		switchToFrameByElement("PIR_Iframe",objectData);
		if (PlutoraConfiguration.browserName.equals("FF")) {
			sendKeysWithBackspace("PIR_Description_TextField","PIR_Description_TextField_Value", objectData, testData,platform);
		} else {
			sendKeys("PIR_Description_TextField", "PIR_Description_TextField_Value", objectData, testData);
		}
		switchToDefaultContent();
		click("AddPIR_TypeDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddPIR_Type_Option1",pirData);
		sleep(2000);
		click("AddPIR_StatusDropdown",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddPIR_Status_Option",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddPIR_ReleaseDropdown",pirData);
		sleep(2000);
		click("AddPIR_ReleaseFirst_Option",pirData);
		sleep(2000);
		//click("AddPIR_IDTextfield",pirData);
		/* Click on Save & close Button */
		click("PIR_Save&CloseButton",pirData);
	}

	public void creationPIRItem(String pirData,String testData,String objectData,String pirItemId){	

		sleep(2000);
		click("PIR_ItemButton",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		/* Enter New Systems Name */
		sleep(4000);
		sendKeys("PIR_ItemSummaryTextField",PropertiesCache.setProperty(testData, pirItemId),pirData);
		sendKeys("PIR_Item_Description_Textarea",PropertiesCache.setProperty(testData, "PIR_Item_Automation_Description"),pirData);
		sleep(4000);
		click("PIR_ItemStatusDropdown",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "PIR_Item_Status",getTextData("PIR_ItemStatusFirst_Option", pirData));
		click("PIR_ItemStatusFirst_Option",pirData);
		sleep(2000);
		click("PIR_ItemTypeDropdown",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "PIR_Item_Type",getTextData("PIR_ItemTypeFirst_Option", pirData));
		click("PIR_ItemTypeFirst_Option",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_SaveButton",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(4000);
		pirID=getAttributeData("PIR_ItemPIRIDTextField", pirData);
		PropertiesCache.setProperty(testData,"PIR_Action_Identifier",getAttributeData("PIR_ItemPIRIDTextField", pirData));
		Listener.addLogger("PIR ID: "+pirID);
		PropertiesCache.setProperty(testData,"PIR_Item_Category",getAttributeData("PIR_ItemCategoryTextField", pirData));
		click("PIR_Save&ExitButton",pirData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	public void enterNewlyCreatedPIR(String pirData,String testData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_SearchIcon",pirData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_SearchButton","PIR_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Name","PIR_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void enterNewlyCreatedPIR(String pirData,String testData,String objectData,String pirId) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_SearchIcon",pirData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_SearchButton",pirId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		doubleClick("PIR_Name",pirId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void searchNewlyCreatedPIR(String pirData,String testData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_SearchIcon",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_SearchButton","PIR_Test_Automation_Id",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void searchNewlyCreatedPIR(String pirData,String testData,String objectData,String pirId) throws InterruptedException{
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_SearchIcon",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_SearchButton",pirId,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void searchNewlyCreatedPIRItem(String pirData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Item_ID_Search_Textbox",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("PIR_Item_ID_Search_Textbox",pirID,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void searchNewlyCreatedPIRItem(String pirData,String testData,String objectData,String pirID){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Item_ID_Search_Textbox",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("PIR_Item_ID_Search_Textbox",pirID,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void searchNewlyCreatedPIRManagerPIRItem(String pirData,String testData,String objectData,String pirID){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Window_Grid_Summary",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("PIR_Window_Grid_Summary",pirID,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void clickOnNewlyCreatedPIRItem(String pirData,String testData,String objectData){
		sleep(2000);
		click("PIR_Item_ID_Searched_Summary_Link","PIR_Item_Automation_Summary",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickOnNewlyCreatedPIRItem(String pirData,String testData,String objectData,String pirItemId) throws InterruptedException{
		sleep(2000);
		clickButton("PIR_Item_ID_Searched_Summary_Link",pirItemId,pirData,testData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public void clickAndUpdateNewlyCreatedPIR(String pirData,String testData,String objectData) throws InterruptedException{
		/*waitForLoadingIconDisappear(10, "Loading_Gif");
		click(page,"PIR_ItemLabel");
		waitForLoadingIconDisappear(3, "Loading_Gif");
		click(page,"PIR_ItemButton");
		waitForLoadingIconDisappear(3, "Loading_Gif");
		sendKeys(page, "PIR_ItemSummaryTextField","New_PIR_Item_Name_Value");
		click(page,"PIR_ItemStatusDropdown");
		waitForLoadingIconDisappear(3, "Loading_Gif");
		status=getTextPIRData("PIR_ItemStatusFirst_Option");
		click(page,"PIR_ItemStatusFirst_Option");
		sleep(2000);
		click(page,"PIR_SaveButton");
		sleep(3000);
		click(page,"PIR_Save&ExitButton");
		sleep(4000);
		waitForLoadingIconDisappear(30, "Loading_Gif");*/
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddPIR_NameTextfield","New_PIR_Name_Update_Value",pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Save&CloseButton",pirData);
		sleep(2000);
	}

	public void clickAndUpdateNewlyCreatedPIRItem(String pirData,String testData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_ID_Searched_Summary_Link","PIR_Item_Automation_Summary",pirData,testData);
		sleep(2000);
		sendKeys("PIR_ItemSummaryTextField",PropertiesCache.setProperty(testData, "PIR_Item_Automation_Summary"),pirData);
		sleep(2000);
		click("PIR_Save&ExitButton",pirData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void deleteNewlyCreatedPIR(String pirData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Name","PIR_Test_Automation_Id",pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Delete_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
	}	

	public void deleteNewlyCreatedPIR(String pirData,String testData,String objectData,String pirId){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Name",pirId,pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Delete_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
	}
	public void deleteNewlyCreatedPIRAll(String pirData,String testData,String objectData,String pirId){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Name",pirId,pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Delete_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_All_Button",pirData);
	}
	
	public void deleteNewlyCreatedPIRItem(String pirData,String testData,String objectData,String pirItemId){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_ID_Searched_Summary_Link",pirItemId,pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_Delete_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
	}	

	public void clickOnPIRExportToXLS(String pirData,String testData,String objectData) {

		click("PIR_ItemSummary_Row_Checkbox","PIR_Item_Automation_Summary",pirData,testData);
		sleep(2000);
		click("PIR_Item_Action_Button",pirData);
		sleep(2000);
		click("PIR_Item_ExportToXls_Option",pirData);
		sleep(6000);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
	}


	public void getPIRItemTabPage(String pirData,String objectData,String tabName) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript(tabName,pirData);
		sleep(2000);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
	}

	public void createQuestionnaire(String pirData,String testData,String objectData) throws InterruptedException{	

		sleep(2000);
		click("PIR_Item_CreateQuestionnaire_Button",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(4000);
		sendKeys("PIR_Item_QuestionnaireName_Textbox",PropertiesCache.setProperty(testData, "PIR_Automation_QuestionName"),pirData);
		sendKeys("PIR_Item_QuestionnaireEmail_Textarea",PropertiesCache.getProperty(testData, "Login_Email_Textfield_Value"),pirData);
		sleep(4000);
		click("PIR_Item_AddNewQuestion_Button",pirData);
		sleep(1000);
		sendKeys("PIR_Item_Question_Textbox1",PropertiesCache.setProperty(testData, "PIR_Automation_Question"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickUpdateCreatedQuestionName(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		click("PIR_Item_CreatedQuestionnaire_Link","PIR_Automation_QuestionName",pirData,testData);
		sleep(2000);
		sendKeys("PIR_Item_QuestionnaireName_Textbox",PropertiesCache.setProperty(testData, "PIR_Automation_QuestionName"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void deleteCreatedQuestionName(String pirData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Item_CreatedQuestionnaire_Delete_Button","PIR_Automation_QuestionName",pirData,testData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
	}	

	public void clickVerifyCreatedQuestion(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		click("PIR_Item_CreatedQuestionnaire_Link","PIR_Automation_QuestionName",pirData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickUpdateCreatedQuestion(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		click("PIR_Item_Question_InactiveTextbox1",pirData);
		sleep(1000);
		sendKeysWithoutClear("PIR_Item_Question_Textbox1","", pirData);
		sendKeysWithoutClear("PIR_Item_Question_Textbox1",PropertiesCache.setProperty(testData, "PIR_Automation_Question"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void deleteCreatedQuestion(String pirData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Item_Question1_Delete_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
	}	

	public void createQuestionGroup(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_AddNewGroup_Button",pirData);
		sleep(1000);
		/*clickElementUsingJavaScript("PIR_Item_Question_InactiveTextbox1",pirData);
		sleep(2000);*/
		sendKeys("PIR_Item_Question_Textbox1",PropertiesCache.setProperty(testData, "PIR_Automation_Group"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickEditCreatedGroup(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		click("PIR_Item_Question_InactiveTextbox1",pirData);
		sleep(1000);
		sendKeysWithoutClear("PIR_Item_Question_Textbox1","", pirData);
		sendKeysWithoutClear("PIR_Item_Question_Textbox1",PropertiesCache.setProperty(testData, "PIR_Automation_Group"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void createQuestionnaireEmail(String pirData,String testData,String objectData) throws InterruptedException{	

		sleep(2000);
		click("PIR_Item_CreateQuestionnaire_Button",pirData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(4000);
		sendKeys("PIR_Item_QuestionnaireName_Textbox",PropertiesCache.setProperty(testData, "PIR_Automation_QuestionName"),pirData);
		sendKeys("PIR_Item_QuestionnaireEmail_Textarea",PropertiesCache.getProperty(testData, "Login_Email_Textfield_Value"),pirData);
		sleep(4000);
		click("PIR_Item_AddNewQuestion_Button",pirData);
		sleep(1000);
		sendKeys("PIR_Item_Question_Textbox1",PropertiesCache.setProperty(testData, "PIR_Automation_Question"),pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Item_Questionnaire_Send_Button",pirData);
		sleep(1000);
	}

	public void createdQuestionSettings(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_Questionnaire_Settings_Button",pirData);
		sleep(3000);
		sendKeys("PIR_Item_Questionnaire_MaxRating_Textbox",PropertiesCache.getProperty(testData, "QuestionMaxRating"),pirData);
		sleep(1000);
		sendKeys("PIR_Item_Questionnaire_Coments_Textarea",PropertiesCache.getProperty(testData, "QuestionComments"),pirData);
		sleep(2000);
		click("PIR_Item_Questionnaire_SettingsOk_Button",pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getCopyQuestionnairePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_CreateQuestionnaire_Button",pirData);
		sleep(1000);
		sendKeys("PIR_Item_QuestionnaireName_Textbox",PropertiesCache.setProperty(testData, "PIR_Automation_QuestionName"),pirData);
		sleep(1000);
		clickElementUsingJavaScript("PIR_Item_CopyQuestionnaire_Button",pirData);
		sleep(1000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		mouseHover("PIR_Item_Questionnaire_Select_Option1", "PIR_Item_Questionnaire_Select_Option1", pirData);
		sleep(1000);
		questionName = getTextData("PIR_Item_Questionnaire_Select_Option1",pirData);
		Listener.addLogger("Question Name: "+questionName);
		/*scrollToElement("PIR_Item_Questionnaire_Select_Option","PIR_Automation_QuestionName1",pirData,testData);
		sleep(3000);
		clickElementUsingJavaScript("PIR_Item_Questionnaire_Select_Option","PIR_Automation_QuestionName1",pirData,testData);
		sleep(2000);*/
		clickElementUsingJavaScript("PIR_Item_Questionnaire_CopyClose_Button",pirData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("PIR_Save&CloseButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getPIRPMCreatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		sleep(2000);
		click("PIR_Item_PM_Link",pirData);
		sleep(4000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_PM_Automation_Summary"),pirData);
		sleep(1000);
		sendKeys("PIR_Item_PM_Description_Textarea",PropertiesCache.setProperty(testData, "PIR_Item_PM_Automation_Description"),pirData);
		sleep(1000);
		click("PIR_Item_PM_Status_Dropdown",pirData);
		sleep(3000);
		click("PIR_Item_PM_Status_Option1",pirData);
		sleep(2000);
		click("PIR_Item_PM_Systems_Dropdown",pirData);
		sleep(2000);
		click("PIR_Item_PM_Systems_Option1",pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(4000);
	}

	public String getPIRPMAddedSystem(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		pmSystemName = getTextData("PIR_Item_PM_Added_Status1_Text", pirData);
		return pmSystemName;
	}

	public String getPIRPMAddedStatus(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		pmStatusName = getAttributeData("PIR_Item_PM_Status_Text", pirData);
		Listener.addLogger("Status: "+pmStatusName);
		return pmStatusName;
	}

	public String getPIRPMAddedAssinedTo(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		pmAssignedToName = getTextData("PIR_Item_PM_AssignedTo_Text", pirData);
		Listener.addLogger("AssignedToName: "+pmAssignedToName);
		return pmAssignedToName;
	}
	
	public String getPIRPMElementData(String pirData,String elementId) throws InterruptedException{
		sleep(1000);
		pmElementName = getTextData(elementId, pirData);
		Listener.addLogger("pmElementName: "+pmElementName);
		return pmElementName;
	}
	public String getPIRPMElementData(String pirData,String testData,String objectData,String elementId) throws InterruptedException{
		sleep(1000);
		pmElementName = getTextData(elementId,testData,pirData,testData);
		Listener.addLogger("pmElementName: "+pmElementName);
		return pmElementName;
	}
	
	public String getPIRPMAttributeValue(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		String color = getCSSValue("PIR_Item_PM_Added_StatusDueDate_Box",pirData,"background-color");
		Listener.addLogger("color: "+color);
		return color;
	}
	
	public String getPIRPMFontColorValue(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		String color = getCSSValue("PIR_Item_PM_Added_StatusDueDate_Box",pirData,"color");
		Listener.addLogger("color: "+color);
		return color;
	}

	public void getPIRPMUpdatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_PM_Automation_Summary"),pirData);
		sleep(1000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getPIRPMDeletePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text_RadioButton","PIR_Item_PM_Automation_Summary",pirData,testData);
		sleep(1000);
		click("PIR_Item_RootCause_Actions_Button",pirData);
		sleep(2000);
		click("PIR_Item_RootCause_DeleteItems_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void getPIRActionCreatePage(String pirData,String testData,String objectData,String actionName) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		clickElementUsingJavaScript("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_Action_Link",pirData);
		sleep(4000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, actionName),pirData);
		sleep(1000);
		sendKeys("PIR_Item_PM_Description_Textarea",PropertiesCache.setProperty(testData, "PIR_Item_Action_Automation_Description"),pirData);
		sleep(1000);
		click("PIR_Item_Action_Status_Dropdown",pirData);
		sleep(2000);
		click("PIR_Item_Action_Status_Option1",pirData);
		sleep(1000);
		click("PIR_Item_PM_Systems_Dropdown",pirData);
		sleep(3000);
		click("PIR_Item_PM_Systems_Option1",pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
	}

	public void getPIRActionUpdatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_Action_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_Action_Automation_Summary"),pirData);
		sleep(1000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getPIRActionDeletePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text_RadioButton","PIR_Item_Action_Automation_Summary",pirData,testData);
		sleep(1000);
		click("PIR_Item_RootCause_Actions_Button",pirData);
		sleep(2000);
		click("PIR_Item_RootCause_DeleteItems_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void getPIRRCCreatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		scrollToElement("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		clickElementUsingJavaScript("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_RC_Link",pirData);
		sleep(4000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_RC_Automation_Summary"),pirData);
		sleep(1000);
		sendKeys("PIR_Item_PM_Description_Textarea",PropertiesCache.setProperty(testData, "PIR_Item_RC_Automation_Description"),pirData);
		sleep(1000);
		click("PIR_Item_RC_Status_Dropdown",pirData);
		sleep(2000);
		click("PIR_Item_Action_Status_Option1",pirData);
		sleep(1000);
		/*click("PIR_Item_PM_Systems_Dropdown",pirData);
		sleep(3000);
		click("PIR_Item_PM_Systems_Option1",pirData);
		sleep(2000);*/
		click("PIR_SaveButton",pirData);
		sleep(2000);
	}

	public void getPIRRCUpdatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_RC_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_RC_Automation_Summary"),pirData);
		sleep(1000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getPIRRCDeletePage(String pirData,String testData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("PIR_Item_PM_Header_Text_RadioButton","PIR_Item_RC_Automation_Summary",pirData,testData);
		sleep(1000);
		click("PIR_Item_RootCause_Actions_Button",pirData);
		sleep(2000);
		click("PIR_Item_RootCause_DeleteItems_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void getPIRImpactCreatePage(String pirData,String testData,String objectData) throws InterruptedException{
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		scrollToElement("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		clickElementUsingJavaScript("PIR_Item_RootCauseAction_AddNew_Button",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Item_Impact_Link",pirData);
		sleep(4000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_Impact_Automation_Summary"),pirData);
		sleep(1000);
		sendKeys("PIR_Item_PM_Description_Textarea",PropertiesCache.setProperty(testData, "PIR_Item_Impact_Automation_Description"),pirData);
		sleep(1000);
		click("PIR_Item_Impact_Type_Dropdown",pirData);
		sleep(2000);
		click("PIR_Item_Action_Status_Option1",pirData);
		sleep(1000);
		/*click("PIR_Item_PM_Systems_Dropdown",pirData);
		sleep(3000);
		click("PIR_Item_PM_Systems_Option1",pirData);
		sleep(2000);*/
		click("PIR_SaveButton",pirData);
		sleep(2000);
	}

	public void getPIRImpactUpdatePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_Impact_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_PM_Summary_Textbox",PropertiesCache.setProperty(testData, "PIR_Item_Impact_Automation_Summary"),pirData);
		sleep(1000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getPIRImpactDeletePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text_RadioButton","PIR_Item_Impact_Automation_Summary",pirData,testData);
		sleep(1000);
		click("PIR_Item_RootCause_Actions_Button",pirData);
		sleep(2000);
		click("PIR_Item_RootCause_DeleteItems_Button",pirData);
		sleep(2000);
		clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public void verifyPIRAdditionalInformationTab(String pirData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("Additional_Information_LabelName", "PIR_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "PIR_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(pirData,testData, objectData, customFieldList,"PIR_CustomField_Name","PIR_Test_Automation_Id","PIR_Name","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "PIR_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}

	public void verifyAdditionalInformationTab(String pirData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("Additional_Information_LabelName", "PIRItem_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "PIRItem_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(pirData,testData, objectData, customFieldList,"PIRItem_CustomField_Name","PIR_Item_Automation_Summary","PIR_Item_ID_Searched_Summary_Link","PIR_Save&ExitButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "PIRItem_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}

	public void getPIRPMStatusEditPage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("PIR_Item_PM_Status_Dropdown",pirData);
		sleep(3000);
		click("PIR_Item_PM_Status_Option3",pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void updatePIRItemStatusActions(String pirData,String testData,String objectData,String radioButton,String headerText,String actionName,String status,String statusDropdown) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(radioButton,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(headerText,actionName,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(statusDropdown,pirData);
		sleep(3000);
		click("PIR_Item_PM_Status_Option",status,pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRPMAssigneedToPage(String pirData,String testData,String objectData,String optionId) throws InterruptedException{

		sleep(1000);
		click("PIR_Item_PM_AssignedTo_Dropdown",pirData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(3000);
		click(optionId,pirData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getPIRPMAssigneedToDeletePage(String pirData,String testData,String objectData) throws InterruptedException{

		sleep(1000);
		click("PIR_Item_PM_AssignedTo_CloseButton",pirData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
	}
	
	public void getPIRPMReleaseDeletePage(String pirData,String testData,String objectData) throws InterruptedException{

		sleep(1000);
		click("PIR_Item_PM_SearchedReleasesClose_Icon",pirData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPMPage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_RootCauseAction_RadioButton",pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRPMFeatureReleasePage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		click("PIR_Item_PM_Releases_Textbox",pirData);
		sleep(3000);
		sendKeys("PIR_Item_PM_Releases_Textbox","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("PIR_Item_PM_Systems_Header",pirData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRPMProjectAddPage(String pirData,String testData,String objectData,String optionId) throws InterruptedException{
		sleep(1000);
		click("PIR_Item_PM_Releases_Textbox",pirData);
		sleep(3000);
		sendKeys("PIR_Item_PM_Releases_Textbox",optionId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name",optionId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("PIR_Item_PM_Systems_Header",pirData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRPMTrafiLightningPage(String pirData,String testData,String objectData) throws InterruptedException, ParseException{
		sleep(1000);
		click("PIR_Item_PM_Added_DueDate_Textbox",pirData);
		sleep(3000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	    Date date = new Date();  
	    String currentDate = formatter.format(date);
		String dueDate = getDateByString(currentDate, "dd/MM/yyyy HH:mm", "-2");
		Listener.addLogger("Due date: "+dueDate);
		sendKeys("PIR_Item_PM_Added_DueDate_Textbox",dueDate,pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRReleaseProjectPage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		click("PIR_Item_ReleaseProjects_Dropdown",pirData);
		sleep(3000);
		//release
		sendKeys("PIR_Item_ReleaseProjects_Textbox","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		//project
		sendKeys("PIR_Item_ReleaseProjects_Textbox","PRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","PRelease_Automation_Id",pirData,testData);
		sleep(2000);
		//independent
		sendKeys("PIR_Item_ReleaseProjects_Textbox","IRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","IRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void getPIRSystemAddPage(String pirData,String testData,String objectData,String optionId) throws InterruptedException{
		sleep(1000);
		click("PIR_Item_ImpactedSystems_Textbox",pirData);
		sleep(3000);
		sendKeys("PIR_Item_ImpactedSystems_Textbox",optionId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_SearchedSystem_Name",optionId,pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public String getPIRItemAddedSystem(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(2000);
		pmSystemName = getTextData("PIR_Item_AddedSystem_Text", pirData);
		return pmSystemName;
	}
	
	public void getPIRReleaseAddedPage(String pirData,String testData,String objectData) throws InterruptedException{
		sleep(1000);
		click("PIR_Release_Dropdown",pirData);
		sleep(3000);
		//release
		sendKeys("PIR_Release_Textbox","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","Release_Test_Automation_Id",pirData,testData);
		sleep(2000);
		//project
		sendKeys("PIR_Release_Textbox","PRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","PRelease_Automation_Id",pirData,testData);
		sleep(2000);
		//independent
		sendKeys("PIR_Release_Textbox","IRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_SearchedReleases_Name","IRelease_Automation_Id",pirData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void verifyPIRFieldPermissionCustomField(String pirData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("PIR_AdditionalInformation_Tab",pirData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "Edit Value":
			clickOnButton(pirData,"PIR_Yes_Button",objectData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickElementUsingJavaScript("PIR_AdditionalInformation_Tab",pirData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "View Custom Field":
			clickOnButton(pirData,"PIR_Yes_Button",objectData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("PIR_AdditionalInformation_Tab",pirData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
			
		}
		clickOnSaveAndCloseButton(pirData, objectData);
	}

	public void clickOnSaveAndCloseButton(String pirData,String objectData) {
		clickOnButton(pirData,"PIR_Save&CloseButton",objectData);
	}
	public void clickOnSaveButton(String pirData,String objectData) {
		clickOnButton(pirData,"PIR_SaveButton",objectData);
	}
	public void verifyPIRFieldOptions(String pirData,String testData,String objectData,String dropdown,String option,String textbox,String name) {
	//	clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click(dropdown,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,pirData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in module dropdown successfully");
		clickElementUsingJavaScript(option, name,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(pirData, objectData);
		//clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		enterNewlyCreatedPIR(pirData, testData, objectData,"PIR_Automation");
		verifyText(textbox,name,pirData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after module save and close successfully");
		clickOnSaveAndCloseButton(pirData, objectData);
		
		//clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		sleep(2000);
		
	}
	public void verifyPIRItemFieldOptions(String pirData,String testData,String objectData,String dropdown,String option,String textbox,String name,String pirItemName) throws InterruptedException {
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click(dropdown,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,pirData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in module dropdown successfully");
		clickElementUsingJavaScript(option, name,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndExitButton(pirData, objectData);
		//clickElementUsingJavaScript("PIR_Yes_Button",pirData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		searchNewlyCreatedPIRManagerPIRItem(pirData, testData, objectData, pirItemName);
		sleep(2000);
		clickOnNewlyCreatedPIRItem(pirData, testData, objectData, pirItemName);
		switch(name) {
		case "PIRItem_PMS":
		case "PIRItem_PMT":
			clickOnPIRItemActions(pirData, testData, objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_PM_Automation_Summary");
			break;
		case "PIRItem_AS":
		case "PIRItem_AT":
			clickOnPIRItemActions(pirData, testData, objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Action_Automation_Summary");
			break;
		case "PIRItem_RCS":
		case "PIRItem_RCT":
			clickOnPIRItemActions(pirData, testData, objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_RC_Automation_Summary");
			break;
		case "PIRItem_IT":
			clickOnPIRItemActions(pirData, testData, objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", "PIR_Item_Impact_Automation_Summary");
			break;
					
		default:
			break;
			
		}
		
		verifyTextAttributeValue(textbox,name,pirData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after module save and close successfully");
		clickOnSaveAndExitButton(pirData, objectData);
		sleep(2000);
			
		}
	public void verifyWorkflowStatus(String releaseData,String testData,String objectData,String option,String textbox,String name) {
		sleep(4000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("AddPIR_StatusDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in PIR Status dropdown successfully");
		click(option, name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//verifyText(textbox,name,tebrData,testData);
		clickOnSaveButton(releaseData, objectData);
	}
	public void clickOnPIRField(String releaseData,String testData,String objectData,String dropdown,String option,String name) {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click(dropdown, releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in PIR dropdown successfully");
		sleep(1000);
		click(option, name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void updatePIRActionAssignee(String pirData,String testData,String objectData,String pirActionId,String status,String assignee) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("PIR_Item_PM_Header_Text",pirActionId,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(pirData,"PIR_Item_Action_Status_Dropdown",objectData);
		click("PIR_Item_Action_Status_Option",status,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("PIR_Item_Action_Assignee_Textbox", assignee,pirData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("PIR_Item_Action_Assignee_Option",assignee,pirData,testData);
		clickOnButton(pirData,"PIR_Save&ExitButton",objectData);
	}
	public void addAttachment(String pirData,String testData,String objectData,String newButton) {
		scrollToElement(newButton,pirData);
		sleep(1000);
		clickOnButton(pirData,newButton,objectData);
		sleep(1000);
		doubleClick("PIR_Attachment_NewURLOption",pirData);
		sleep(1000);
		sendKeys("PIR_Attachment_NewURLTextbox",CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(testData, "ImageName"),pirData);
		sleep(4000);
		click("PIR_Attachment_NewURLSave&Close_Button",pirData);
		clickOnSaveButton(pirData, objectData);
	}
	public void deleteAttachment(String pirData,String objectData) {
		clickOnButton(pirData,"PIR_Attachment_Delete_Icon",objectData);
		clickOnButton(pirData,"PIR_Yes_Button",objectData);
		clickOnSaveButton(pirData, objectData);
	}
	
	public void updateReleaseSystemInPIRItem(String pirData,String testData,String objectData,String releaseId,String systemId){
		//Release 
		clickOnButton(pirData,"PIR_Item_Release_Dropdown",objectData);
		sendKeys("PIR_Item_Release_Textbox", releaseId,pirData,testData,objectData);
		clickButton("PIR_Item_Release_Dropdown_Option",releaseId,pirData,testData,objectData);
		//System
		clickOnButton(pirData,"PIR_Item_System_Dropdown",objectData);
		sendKeys("PIR_Item_System_Textbox", systemId,pirData,testData,objectData);
		clickButton("PIR_Item_System_Dropdown_Option",systemId,pirData,testData,objectData);
		 
		clickOnButton(pirData,"PIR_Save&ExitButton",objectData);
		
	}
	public void updatePIRIDToPIRItem(String pirData,String testData,String objectData,String pirID) {
		//PIR ID 
		clickOnButton(pirData,"PIR_Item_PIRID_Dropdown",objectData);
		sendKeys("PIR_Item_PIRID_Textbox", pirID,pirData,testData,objectData);
		clickButton("PIR_Item_PIRID_Dropdown_Option",pirID,pirData,testData,objectData);
		clickOnButton(pirData,"PIR_Save&ExitButton",objectData);
	}
	public void clickOnActionItems(String pirData,String objectData,String actionCount) {
		clickOnButton(pirData,actionCount,objectData);
		clickOnButton(pirData,"PIR_Item_ViewDetails_Button",objectData);
	}
	public void clickOnSaveAndExitButton(String pirData,String objectData) {
		clickOnButton(pirData,"PIR_Save&ExitButton",objectData);
		waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
	}
	public void clickOnPIRItemActions(String pirData,String testData,String objectData,String radioButton,String headerText,String actionName) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(radioButton,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement(headerText,actionName,pirData,testData);
		clickElementUsingJavaScript(headerText,actionName,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnPIRField(String pirData,String testData,String objectData,String dropdown,String option) {
		clickElementUsingJavaScript(dropdown, pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(option,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(pirData, objectData);
	}
	public void clickOnPIRItemField(String pirData,String testData,String objectData,String dropdown,String option) {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click(dropdown, pirData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click(option,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndExitButton(pirData, objectData);
	}
	public void updatePIRItemActionsStatus(String pirData,String testData,String objectData,String radioButton,String headerText,String actionName,String statusDropdown,String option) throws InterruptedException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(radioButton,pirData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(headerText,actionName,pirData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(statusDropdown,pirData);
		sleep(3000);
		click(option,pirData);
		sleep(2000);
		click("PIR_SaveButton",pirData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	 public void addPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 sendKeys("PIR_Comments_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_Send_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" added successfully !");
	 }
	 public void editPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 clickOnButton(objectData,"PIR_Comments_Edit_Link",objectData);
		 sendKeys("PIR_Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_Edit_Link",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" updated successfully !");
	 }
	 public void replyPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 clickOnButton(objectData,"PIR_Comments_Reply_Link",objectData);
		 sendKeys("PIR_Comments_Reply_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_ReplySend_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" replyed successfully !");
	 }
}
