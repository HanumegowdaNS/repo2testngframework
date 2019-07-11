package com.plutora.pagerepo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class TECRPage extends TestGenericUtilLib  {
	CustomizationPage customizationPage = new CustomizationPage();
	public static String startDate,endDate=null;
	
	public void getTECRDetilsPageFromNewMenu(String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("New_Option", "New_Environment_Option",objectData);
		mouseHover("New_Environment_Option","New_TECR_Option",objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void creationTECR(String tecrData,String testData,String objectData,String tecrId){	
		clickOnButton(tecrData, "New_TECR_Button", objectData);
		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		/* Selection of Release Name */
		clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		if(PlutoraConfiguration.browserName.equals("FF")) {
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		}
		/* Storing release name in static variable */
		PropertiesCache.setProperty(testData, "releaseName",getTextData("AddTECR_ReleaseNameFirst_Option",tecrData));

		click("AddTECR_ReleaseNameFirst_Option",tecrData);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		 /* Selection of End DatePicker */
	//	click("AddTECR_EndDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		//waitPolling("AddTECR_StatusDropdown", tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		/* Selection of Type Dropdown */
		clickElementUsingJavaScript("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Type",getTextData("AddTECR_TypeFirst",tecrData));
		click("AddTECR_TypeFirst",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		 /* Selection of Status Dropdown */
		click("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Status",getTextData("AddTECR_StatusFirst",tecrData));
		click("AddTECR_StatusFirst",tecrData);
		
		/* Selection of Assigned To Dropdown  */
		click("AddTECR_AssignedToDropdown",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "TECR_AssignedTo",getTextData("AddTECR_AssignedToFirst",tecrData));
		clickElementUsingJavaScript("AddTECR_AssignedToFirst",tecrData);
		click("TECR_Save&CloseButton",tecrData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tecrId)+" created successfully !");

	}
	public void creationTECRWithRelease(String tecrData,String testData,String objectData,String tecrId,String projectId,String text){
		if(text.isEmpty()) {
			clickOnButton(tecrData, "New_TECR_Button", objectData);
		}
		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		/* Selection of Release Name */
		clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		if(PlutoraConfiguration.browserName.equals("FF")) {
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		}
		/* Storing release name in static variable */
		sendKeys("AddTECR_ReleaseName_Textbox", projectId, tecrData,testData);
		waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_ReleaseName_Option",projectId,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		 /* Selection of End DatePicker */
		//click("AddTECR_EndDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		waitPolling("AddTECR_StatusDropdown", tecrData);
		/* Selection of Type Dropdown */
		click("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Type",getTextData("AddTECR_TypeFirst",tecrData));
		click("AddTECR_TypeFirst",tecrData);
		 /* Selection of Status Dropdown */
		sleep(1000);
		clickElementUsingJavaScript("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Status",getTextData("AddTECR_StatusFirst",tecrData));
		click("AddTECR_StatusFirst",tecrData);
		sleep(4000);
		/* Selection of Assigned To Dropdown  */
		clickElementUsingJavaScript("AddTECR_AssignedToDropdown",tecrData);
		//assignedTo=getTextData("AddTECR_AssignedToFirst",tecrData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_AssignedTo",getTextData("AddTECR_AssignedToFirst",tecrData));
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("AddTECR_AssignedToFirst",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickOnButton(tecrData,"TECR_Save&CloseButton",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tecrId)+" created successfully !");
	}
	public void clickOnSaveAndCloseButton(String tecrData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnSaveButton(String tecrData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TECR_SaveButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void enterNewlyCreatedTECR(String tecrData,String testData,String objectData,String tecrId){
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_Tab",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("TECR_SearchButton",tecrId,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public  void enterNewlyCreatedTECR(String tecrData,String testData,String objectData,String searchBox,String tecrId){
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickElementUsingJavaScript("AddTECR_Tab",tecrData);
		sleep(2000);
		sendKeys(searchBox,tecrId,tecrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public  void clickAndUpdateNewlyCreatedTECR(String tecrData,String testData,String objectData,String platform,String tecrName){
		sleep(3000);
		click("TECR_Name",tecrName,tecrData,testData);
		//clickElementUsingJavaScript("LeftJustfiyText_Button", objectData);
		sleep(1000);
		switchToFrameByElement("TECR_Iframe",objectData);
		if (PlutoraConfiguration.browserName.equals("FF")) {
			sendKeysWithDelete("TECR_Description_TextField","TECR_Description_TextField_Value", tecrData, testData,platform);
		} else {
			sendKeys("TECR_Description_TextField", "TECR_Description_TextField_Value", tecrData, testData);
		}
		switchToDefaultContent();
		sleep(2000);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void createDuplicateTECR(String tecrData,String testData,String objectData,String tecrName){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("TECR_Name_Checkbox",tecrName,tecrData,testData);
		sleep(1000);
		clickElementUsingJavaScript("TECR_ActionButton",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("TECR_DuplicateRequest_Option",tecrData);
		sleep(1000);
		clickElementUsingJavaScript("TECR_DuplicateButton",tecrData);
	}

	public void enterNewlyCreatedDuplicateTECR(String tecrData,String testData,String objectData,String tecrName){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("TECR_SearchButton",setDuplicateName("(Copy) ", tecrName, "Copy_"+tecrName, testData),tecrData);
		sleep(3000);
	}

	public  void deleteNewlyCreatedDuplicateTECR(String tecrData,String testData,String tecrName){
		clickElementUsingJavaScript("TECR_Name","Copy_"+tecrName,tecrData,testData);
		sleep(2000);
		clickElementUsingJavaScript("TECR_Delete_Button",tecrData);
		sleep(1000);
		click("TECR_Yes_Button",tecrData);
	}

	public  void deleteNewlyCreatedTECR(String tecrData,String testData,String objectData,String tecrId){
		enterNewlyCreatedTECR(tecrData, testData, objectData,tecrId);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TECR_Name",tecrId,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		clickElementUsingJavaScript("TECR_Delete_Button",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("TECR_Yes_Button",tecrData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tecrId)+" deleted successfully !");
	}
	public void selectTECRMaintenanceBench(String tecrData,String testData,String objectData,String releaseId) {
		clickElementUsingJavaScript("TECR_Maintenance_Bench_Button",tecrData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TECR_Maintenance_Bench_Clear_Button",tecrData);
		waitForLoadingIconDisappear(300,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Yes_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Maintenance_Bench_ReleaseId_Dropdown",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("TECR_Maintenance_Bench_ReleaseId_Textbox", releaseId, tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Maintenance_Bench_ReleaseId_Option",releaseId,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger("Selected release in the TECR maintenance bench !");
	}
	public void verifyAdditionalInformationTab(String tecrData,String testData,String objectData,String customizationData,String environmentData,String customFieldList) throws ParseException, InterruptedException {
		click("AddTECR_AdditionalInformation_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		verifyText("TECR_Additional_Information_LabelName", "TECR_CustomField_Name",tecrData,testData);
		verifyCustomFieldValue(tecrData,testData,objectData,customFieldList,"TECR_CustomField_Name","TECR_Test_Automation_Id","TECR_Name","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "TECR_CustomField_Name")+" - "+customFieldList+" is displayed and verified with values on the web page");
	}
	
   public void verifyTECRLinkedChange(String tecrData,String testData,String objectData) {
		
	    click("TECR_Name","TECR_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		click("TECR_Linked_Change_Tab",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		sendKeysWithEnter("TECR_Linked_Change_Search", "Change_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		verifyTextValue(getTextData("TECR_Linked_Change_Text","Change_Automation_Id",tecrData,testData).split("\\n")[1].trim(),PropertiesCache.getProperty(testData, "Change_Automation_Id"));
		sleep(2000);
		dragAndDrop("TECR_Linked_Change_Text", "TECR_Linked_Change_Drop_Section", "Change_Automation_Id",tecrData,testData);
		verifyTextValue(getTextData("TECR_Linked_Dropped_Change_Text","Change_Automation_Id",tecrData,testData).split("\\n")[1].trim(),PropertiesCache.getProperty(testData, "Change_Automation_Id"));
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Name","TECR_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		verifyTextValue(getTextData("TECR_Linked_Dropped_Change_Text","Change_Automation_Id",tecrData,testData).split("\\n")[1].trim(),PropertiesCache.getProperty(testData, "Change_Automation_Id"));
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
	}
	
	
	public void verifyOutageDate(String tecrData,String testData,String objectData,String tecrName) throws ParseException {
		validateElementDisplayed("TECR_Outage_Enabled", tecrData);
		clickElementUsingJavaScript("TECR_Outage_StartDate_Calender_Icon",tecrData);
		sleep(1000);
		sendKeys("TECR_Outage_Calender_Box_Textbox", "00:00",tecrData);
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_StartDate_Textbox"), date+" 00:00");
		Listener.addLogger(date+" 00:00"+" is updated successfully !");
		sleep(1000);
		sendKeys("TECR_Outage_Calender_Box_Textbox", "23:59", tecrData);
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_EndDate_Textbox"), date+" 23:59");
		Listener.addLogger(date+" 23:59"+" is updated successfully !");
		sleep(1000);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Name",tecrName,tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_StartDate_Textbox"), date+" 00:00");
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_EndDate_Textbox"), date+" 23:59");
		
		click("AddTECR_EndDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		applicationDatePicker(tecrData, testData, "TECR_Outage_Calender", getDate(getCurrentDate("0"), "2"));
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		sleep(2000);
		click("AddTECR_StartDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		applicationDatePicker(tecrData, testData, "TECR_Outage_Calender", getDate(getCurrentDate("0"), "2"));
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("TECR_Outage_Calender_Done_Button",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("TECR_Outage_StartDate_Calender_Icon",tecrData);
		sleep(1000);
		sendKeys("TECR_Outage_Calender_Box_Textbox", "00:00",tecrData);
		sleep(1000);
		applicationDatePicker(tecrData, testData, "TECR_Outage_Calender", getDate(getCurrentDate("0"), "2"));
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_StartDate_Textbox"), date+" 00:00");
		Listener.addLogger(date+" 00:00"+" is updated successfully !");
		sleep(2000);
		sendKeys("TECR_Outage_Calender_Box_Textbox", "23:59",tecrData);
		sleep(1000);
		applicationDatePicker(tecrData, testData, "TECR_Outage_Calender", getDate(getCurrentDate("0"), "2"));
		sleep(1000);
		click("TECR_Outage_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_EndDate_Textbox"), date+" 23:59");
		Listener.addLogger(date+" 23:59"+" is updated successfully !");
		sleep(2000);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Name",tecrName,tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_StartDate_Textbox"), date+" 00:00");
		verifyTextAttributeValue(PropertiesCache.getProperty(tecrData, "TECR_Outage_EndDate_Textbox"), date+" 23:59");
		
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void addEnvironment(String tecrData,String testData,String objectData) {
		click("TECR_AddEnvironment_Button",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Environment_Dropdown",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sendKeys("TECR_Environment_Textbox", "Env_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Environment_Dropdown_Option","Env_Test_Automation_Id",tecrData,testData);
		sleep(1000);
		click("TECR_Environment_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void addLayer(String tecrData,String testData,String objectData,String newComponentValue) {
		sleep(2000);
		click("TECR_Environment_Add_Layer_Button","Env_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click("TECR_Environment_Host_Dropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TECR_Environment_Host_Dropdown_Option",tecrData);
		sleep(2000);
		click("TECR_Environment_Layer_Dropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TECR_Environment_Layer_Dropdown_Option",tecrData);
		sleep(2000);
		click("TECR_Environment_Component_Dropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TECR_Environment_Component_Dropdown_Option",tecrData);
		sleep(1000);
		sendKeys("TECR_Environment_NewComponent_Value",PropertiesCache.setProperty(testData, newComponentValue),tecrData);
		sleep(1000);
		click("TECR_Environment_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void selectStatus(String tecrData,String testData,String objectData) {
		click("TECR_Environment_Status_Dropdown","Env_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Environment_Status",getTextData("TECR_Environment_Status_Dropdown_Option", tecrData));
		click("TECR_Environment_Status_Dropdown_Option",tecrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
	}
	public  void updateTECRByName(String tecrData,String testData,String objectData) throws InterruptedException{
		sleep(3000);
		click("TECR_Name","TECR_Test_Automation_Id",tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, "TECR_Test_Automation_Id"),tecrData);
		sleep(1000);
		click("TECR_Save&CloseButton",tecrData);
		
	}
	
	public void updateInsightsTECR(String tecrData,String testData,String objectData) throws ParseException{	

		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, "TECR_Test_Automation_Id"),tecrData);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(tecrData, testData, "AddTECR_Date_Calender", getDate(getCurrentDate("0"), "0"));
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		PropertiesCache.setProperty(testData, "TECR_StartDate",getAttributeData("AddTECR_StartDate_Value",tecrData).split(" ")[0].trim());
		 /* Selection of End DatePicker */
		//click("AddTECR_EndDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(tecrData, testData, "AddTECR_Date_Calender", getDate(getCurrentDate("0"), "0"));
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		PropertiesCache.setProperty(testData, "TECR_EndDate",getAttributeData("AddTECR_EndDate_Value",tecrData).split(" ")[0].trim());
		waitPolling("AddTECR_StatusDropdown", tecrData);
		/* Selection of Type Dropdown */
		click("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Type",getTextData("AddTECR_TypeFirst",tecrData));
		click("AddTECR_TypeFirst",tecrData);
		 /* Selection of Status Dropdown */
		sleep(1000);
		clickElementUsingJavaScript("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Status",getTextData("AddTECR_StatusFirst",tecrData));
		click("AddTECR_StatusFirst",tecrData);
		sleep(1000);
		/* Selection of Assigned To Dropdown  */
		clickElementUsingJavaScript("AddTECR_AssignedToDropdown",tecrData);
		PropertiesCache.setProperty(testData, "TECR_AssignedTo",getTextData("AddTECR_AssignedToFirst",tecrData));
		click("AddTECR_AssignedToFirst",tecrData);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
	}
	public void verifyTECRFieldOptions(String tecrData,String testData,String objectData,String dropdown,String option,String textbox,String name,String tecrId) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(dropdown,tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tecrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in TECR dropdown successfully");
		clickElementUsingJavaScript(option, name,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		enterNewlyCreatedTECR(tecrData, testData, objectData,tecrId);
		clickOnTECRName(tecrData, testData, objectData,tecrId);
		verifyTextAttributeValue(textbox,name,tecrData,testData);
		
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after TECR save and close successfully");
		click("TECR_Save&CloseButton",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
	}
	
	public  void clickOnTECRName(String tecrData,String testData,String objectData,String tecrId) {
		sleep(1000);
		clickElementUsingJavaScript("TECR_Name",tecrId,tecrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void verifyTECRMaintenanceBenchType(String tecrData,String testData,String objectData,String name) {
		click("TECR_Maintenance_Bench_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextAttributeValue("TECR_Maintenance_Bench_Type_Textbox",name, tecrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is verified TECR Maintenance Bench Type successfully");
		sleep(1000);
		click("TECR_Maintenance_Bench_Close_Icon",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyFieldPermissionCustomField(String tecrData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("AddTECR_AdditionalInformation_Button",tecrData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("AddTECR_AdditionalInformation_Button",tecrData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("AddTECR_AdditionalInformation_Button",tecrData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " "+type+" - is selected permission from option successfully");
		clickOnSaveAndCloseButton(tecrData, objectData);
	}
	
	public void addTECRApplicationAndInformation(String tecrData,String testData,String objectData,String systemId,String environmentId) {
		
		click("TECR_Maintenance_Bench_Add_Icon",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_SystemId_Information",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("TECR_Maintenance_Bench_System_Textbox", systemId,tecrData,testData);
		sleep(1000);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(4000);
		
		clickElementUsingJavaScript("TECR_Maintenance_Bench_TECRType",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_CreateKB_Checkbox",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_Phase",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_Start_Date",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_Calender_Done_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_Environment",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		click("TECR_Maintenance_Bench_TECR_Status",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TECR_Maintenance_Bench_TECR_AssignedTo",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_Dropdown_First_Option",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		
		click("TECR_Maintenance_Bench_Save&Close_Button",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
	}
	public void addCreateKBAndPhase(String tecrData,String testData,String objectData) {
		click("TECR_Maintenance_Bench_Application_Text",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("TECR_Maintenance_Bench_Application_Column_Dropdown",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("TECR_Maintenance_Bench_Application_Columns_Text",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(tecrData, "TECR_Maintenance_Bench_Application_Column_CreateKB_Checkbox_Checked","TECR_Maintenance_Bench_Application_Column_CreateKB_Checkbox", objectData,"xpath");
		clickOnButton(tecrData, "TECR_Maintenance_Bench_Application_Column_Phase_Checkbox_Checked","TECR_Maintenance_Bench_Application_Column_Phase_Checkbox", objectData,"xpath");
		sleep(1000);
		click("TECR_Maintenance_Bench_Application_Column_Dropdown",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnTECRField(String tecrData,String testData,String objectData,String dropdown,String option,String name) {
		clickElementUsingJavaScript(dropdown, tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tecrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in TECR dropdown successfully");
		sleep(1000);
		click(option, name,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyWorkflowStatus(String tecrData,String testData,String objectData,String option,String textbox,String name) {
		clickElementUsingJavaScript("AddTECR_StatusDropdown", tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tecrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in TECR dropdown successfully");
		click(option, name,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//verifyText(textbox,name,tecrData,testData);
		clickOnSaveButton(tecrData, objectData);
	}
	public void verifyEmptyReleaseTable(String tecrData,String testData,String objectData,String projectId) {
		clickOnButton(tecrData, "AddTECR_ReleaseNameDropdown", objectData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sendKeys("AddTECR_ReleaseName_Textbox",projectId, tecrData,testData,objectData);
		verifyElementNotDisplayed("TECR_Release_EmptyTable", tecrData,objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, projectId)+ " - is not displayed in TECR dropdown successfully due to Release enabled end-status checkbox !");
		clickOnButton(tecrData, "TECR_Close_Icon", objectData);
	}
	public void creationTECRForEnvironmentSchedule(String tecrData,String testData,String objectData,String tecrId,String saveButton,String saveAndcloseButton){	

		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		/* Selection of Release Name */
		if(!tecrId.contains("Project")) {
		clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		if(PlutoraConfiguration.browserName.equals("FF")) {
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		}
		/* Storing release name in static variable */
		PropertiesCache.setProperty(testData, "releaseName",getTextData("AddTECR_ReleaseNameFirst_Option",tecrData));

		click("AddTECR_ReleaseNameFirst_Option",tecrData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		 /* Selection of End DatePicker */
		click("AddTECR_EndDatePicker",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		waitPolling("AddTECR_StatusDropdown", tecrData);
		/* Selection of Type Dropdown */
		click("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("AddTECR_TypeFirst",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		 /* Selection of Status Dropdown */
		click("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "status",getTextData("AddTECR_StatusFirst",tecrData));
		click("AddTECR_StatusFirst",tecrData);

		/* Selection of Assigned To Dropdown  */
		click("AddTECR_AssignedToDropdown",tecrData);
		click("AddTECR_AssignedToFirst",tecrData);
		/* Click on Save & close Button */
		clickOnButton(tecrData,saveButton,objectData);
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickOnButton(tecrData,saveAndcloseButton,objectData);
	}
	public void creationTECR(String tecrData,String testData,String objectData,String tecrId,String customStatus,String customType,String days) throws InterruptedException, ParseException{	
		clickOnButton(tecrData, "New_TECR_Button", objectData);
		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		/* Selection of Release Name */
		clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		if(PlutoraConfiguration.browserName.equals("FF")) {
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		}
		/* Storing release name in static variable */
		PropertiesCache.setProperty(testData, "releaseName",getTextData("AddTECR_ReleaseNameFirst_Option",tecrData));

		click("AddTECR_ReleaseNameFirst_Option",tecrData);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		/* Selection of End DatePicker */
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		releaseDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		sleep(2000);
		startDate=getAttributeData("AddTECR_StartDate_Value",tecrData);
		endDate=getAttributeData("AddTECR_EndDate_Value",tecrData);
		waitPolling("AddTECR_StatusDropdown", tecrData);
		/* Selection of Type Dropdown */
		click("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_CustomType_Text",customType,tecrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/* Selection of Status Dropdown */
		click("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_CustomStatus_Text",customStatus,tecrData,testData);
		sleep(2000);
		/* Selection of Assigned To Dropdown  */
		clickElementUsingJavaScript("AddTECR_AssignedToDropdown",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		//assignedTo=getTextData("AddTECR_AssignedToFirst",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_AssignedToFirst",tecrData);
		sleep(2000);
		//clickElementUsingJavaScript("AddTECR_ReleaseSchedulerYesCheckbox",tecrData);
		sleep(2000);
		click("TECR_Save&CloseButton",tecrData);
		Listener.addLogger(PropertiesCache.getProperty(testData, tecrId)+" created with type "+PropertiesCache.getProperty(testData, customType)+ 
				"-  with status "+PropertiesCache.getProperty(testData, customStatus)+" successfully !");
	}
	public void updateReleaseScheduler(String tecrData,String objectData) {
		clickOnButton(tecrData,"AddTECR_ReleaseSchedulerYesCheckbox",objectData);
		clickOnButton(tecrData,"TECR_Save&CloseButton",objectData);
	}
	public void bulkUpdate(String tecrData,String testData,String objectData,String tecrNameOne,String tecrNameSecond) throws ParseException {
		sleep(2000);
		clickButton("TECR_Name_Checkbox",tecrNameOne,tecrData,testData,objectData);
		sleep(2000);
		clickButton("TECR_Name_Checkbox",tecrNameSecond,tecrData,testData,objectData);
		clickOnButton(tecrData,"TECR_ActionButton",objectData);
		clickOnButton(tecrData,"TECR_BulkUpdate_Option",objectData);
		//Type dropdown
		clickOnButton(tecrData,"TECR_BulkUpdate_Type_Dropdown",objectData);
		PropertiesCache.setProperty(testData, "TECR_Bulk_Type",getTextData("TECR_BulkUpdate_Type_Dropdown_Option", tecrData));
		clickOnButton(tecrData,"TECR_BulkUpdate_Type_Dropdown_Option",objectData);
		//Assignee dropdown
		clickOnButton(tecrData,"TECR_BulkUpdate_Assignee_Dropdown",objectData);
		PropertiesCache.setProperty(testData, "TECR_Bulk_Assignee",getTextData("TECR_BulkUpdate_Assignee_Dropdown_Option", tecrData));
		clickOnButton(tecrData,"TECR_BulkUpdate_Assignee_Dropdown_Option",objectData);
		//Start date calendar
		clickOnButton(tecrData,"TECR_BulkUpdate_StartDate_Dropdown",objectData);
		applicationDatePicker(PlutoraConfiguration.objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		clickOnButton(objectData,"Additional_information_DateTimePicker_Done_Button",objectData);
		sleep(2000);
		//End date calendar
		applicationDatePicker(PlutoraConfiguration.objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("4"));
		clickOnButton(objectData,"Additional_information_DateTimePicker_Done_Button",objectData);
		//Status
		clickOnButton(tecrData,"TECR_BulkUpdate_Status_Dropdown",objectData);
		PropertiesCache.setProperty(testData, "TECR_Bulk_Status",getTextData("TECR_BulkUpdate_Status_Dropdown_Option", tecrData));
		clickOnButton(tecrData,"TECR_BulkUpdate_Status_Dropdown_Option",objectData);
		//Outage
		clickOnButton(tecrData,"TECR_BulkUpdate_Outage_Dropdown",objectData);
		PropertiesCache.setProperty(testData, "TECR_Bulk_Outage",getTextData("TECR_BulkUpdate_Outage_Dropdown_Option", tecrData));
		clickOnButton(tecrData,"TECR_BulkUpdate_Outage_Dropdown_Option",objectData);
		//Update Button
		clickOnButton(tecrData,"TECR_BulkUpdate_Update_Button",objectData);
	
	}
	
	public void addAttachment(String objectData) throws InterruptedException, IOException {
		click("Attachment_Link", objectData);
		uploadImageByName("uploadFile");
		sleep(4000);
		click("Add_Attachment_Close_Button", objectData);
		Listener.addLogger("Attachement uploaded to TECR page successfully !");
	}
	public void removeAttachment(String objectData) throws InterruptedException, IOException {
		click("Attachment_Link", objectData);
		clickOnButton(objectData, "Attachment_Delete_Icon", objectData);
		clickOnButton(objectData, "Attachment_Yes_Button", objectData);
		click("Add_Attachment_Close_Button", objectData);
		Listener.addLogger("Attachement uploaded to TECR page successfully !");
	}
	
	public void updateTECRStartAndEndTime(String tecrData,String testData,String objectData,String tecrName) throws ParseException {
		sleep(2000);
		click("AddTECR_StartDatePicker",tecrData);
		sleep(1000);
		sendKeys("TECR_Outage_Calender_Box_Textbox", "00:00",tecrData);
		sleep(1000);
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		
		sendKeys("TECR_Outage_Calender_Box_Textbox", "23:59", tecrData);
		sleep(1000);
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveButton(tecrData, objectData);
	}
	public void clickOnTECRField(String tecrData,String testData,String objectData,String dropdown,String option) {
		clickElementUsingJavaScript(dropdown, tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(option,tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(tecrData, objectData);
	}
	
	public void creationTECR(String tecrData,String testData,String objectData,String tecrId,String days) throws InterruptedException, ParseException{	
		clickOnButton(tecrData, "New_TECR_Button", objectData);
		/* Enter New TECR Name */
		sendKeys("AddTECR_IDTextfield",PropertiesCache.setProperty(testData, tecrId),tecrData);
		/* Selection of Release Name */
		clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		if(PlutoraConfiguration.browserName.equals("FF")) {
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
			clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",tecrData);
		}
		/* Storing release name in static variable */
		PropertiesCache.setProperty(testData, "releaseName",getTextData("AddTECR_ReleaseNameFirst_Option",tecrData));

		click("AddTECR_ReleaseNameFirst_Option",tecrData);
		/* Selection of Start DatePicker */
		click("AddTECR_StartDatePicker",tecrData);
		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
		click("AddTECR_StartDatePicker_DoneButton",tecrData);
		/* Selection of End DatePicker */
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		releaseDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
		click("AddTECR_EndDatePicker_DoneButton",tecrData);
		sleep(2000);
		startDate=getAttributeData("AddTECR_StartDate_Value",tecrData);
		endDate=getAttributeData("AddTECR_EndDate_Value",tecrData);
		waitPolling("AddTECR_StatusDropdown", tecrData);
		/* Selection of Type Dropdown */
		click("AddTECR_TypeDropDown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Type",getTextData("AddTECR_TypeFirst",tecrData));
		click("AddTECR_TypeFirst",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/* Selection of Status Dropdown */
		click("AddTECR_StatusDropdown",tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TECR_Status",getTextData("AddTECR_StatusFirst",tecrData));
		click("AddTECR_StatusFirst",tecrData);
		sleep(2000);
		/* Selection of Assigned To Dropdown  */
		clickElementUsingJavaScript("AddTECR_AssignedToDropdown",tecrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		//assignedTo=getTextData("AddTECR_AssignedToFirst",tecrData);
		sleep(2000);
		clickElementUsingJavaScript("AddTECR_AssignedToFirst",tecrData);
		sleep(2000);
		//clickElementUsingJavaScript("AddTECR_ReleaseSchedulerYesCheckbox",tecrData);
		sleep(2000);
		click("TECR_Save&CloseButton",tecrData);
	}
	
	
}
