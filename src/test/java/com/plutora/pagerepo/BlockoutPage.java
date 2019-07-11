package com.plutora.pagerepo;

import java.text.ParseException;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class BlockoutPage extends TestGenericUtilLib {
	public static String blockoutStartDate;
	public static String blockoutEndDate;
	private int year = Calendar.getInstance().get(Calendar.YEAR);
	
	public void gotoBlockoutPeriodPage(String blockoutData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Blockout_ReleaseHeader", "Blockout_BlockoutPeriodsMenu", blockoutData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void blockoutPage(String blockoutData, String testData, String objectData) throws InterruptedException {
		sleep(2000);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Releases_Header_Sidemenu", blockoutData);
			sleep(500);
			click("Blockout_BlockoutPeriodsMenu", blockoutData);
		} else {
			mouseHover("Blockout_ReleaseHeader", "Blockout_BlockoutPeriodsMenu", blockoutData);
		}
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
	}

	public void addBlockout(String blockoutData, String testData, String objectData,String blockoutId) throws InterruptedException {
		sleep(2000);
		click("Blockout_AddBlockoutButton", blockoutData);
		sleep(2000);
		sendKeys("Blockout_NameTextfield",PropertiesCache.setProperty(testData, blockoutId),blockoutData);
		sendKeysWithEnter("Blockout_DescriptionTextfield", PropertiesCache.setProperty(testData, "Blockout_Desc"), blockoutData);
		click("Blockout_Type_Dropdown", blockoutData);
		clickOnButton(blockoutData,"Blockout_Type_Dropdown_FirstOption",objectData);
		PropertiesCache.setProperty(testData, "Blockout_Type",getAttributeData("Blockout_Type_Textbox", blockoutData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Blockout_StartDateTextfield", blockoutData);
		click("Blockout_StartDateDoneTextfield", blockoutData);
		click("Blockout_EndDateTextfield", blockoutData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Blockout_EndDateNextMonthButton", blockoutData);
		click("Blockout_EndDateDoneTextfield", blockoutData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "PortFolio_Associaton",getAttributeData("Blockout_PortfolioAssociation_InputBox", blockoutData));
		click("Blockout_ShowOnSchedulerCheckbox", blockoutData);
		click("Blockout_SaveCloseButton", blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, blockoutId)+" created successfully !");

	}
	
	public void addBlockout(String blockoutData, String testData, String objectData,String blockoutId,String startDay,String endDay) throws InterruptedException, ParseException {

		click("Blockout_AddBlockoutButton", blockoutData);
		sleep(2000);
		sendKeys("Blockout_NameTextfield",PropertiesCache.setProperty(testData, blockoutId),blockoutData);
		sendKeysWithEnter("Blockout_DescriptionTextfield", PropertiesCache.setProperty(testData, "Blockout_Desc"), blockoutData);
		click("Blockout_Type_Dropdown", blockoutData);
		clickOnButton(blockoutData,"Blockout_Type_Dropdown_FirstOption",objectData);
		PropertiesCache.setProperty(testData, "Blockout_Type",getAttributeData("Blockout_Type_Textbox", blockoutData));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Blockout_EndDateTextfield", blockoutData);
		sleep(2000);
		/*waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Blockout_EndDateNextMonthButton", blockoutData);*/
		applicationDatePicker(blockoutData, testData, "Blockout_endDate_CalendatText",getCurrentDate(endDay));
		click("Blockout_DateEndDone_Button", blockoutData);
		//waitForLoadingIconDisappear("Loading_Gif", objectData);
		//PropertiesCache.setProperty(PlutoraConfiguration.testData, "PortFolio_Associaton",getAttributeData("Blockout_PortfolioAssociation_InputBox", blockoutData));
		click("Blockout_StartDateTextfield", blockoutData);
		releaseDatePicker(blockoutData, testData, "Blockout_startDate_CalendatText",getCurrentDate(startDay));
		click("Blockout_DateStartDone_Button", blockoutData);
		click("Blockout_SaveButton", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		sleep(1000);
		click("Blockout_ShowOnSchedulerCheckbox", blockoutData);
		click("Blockout_SaveCloseButton", blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, blockoutId)+" created successfully !");

	}
	
	public void addBlockout(String blockoutData, String testData, String objectData,String blockoutName,String days) throws InterruptedException, ParseException {
		waitForLoadingIconDisappear(2, "Loading_Gif", objectData);
		mouseHover("Blockout_ReleaseHeader", "Blockout_BlockoutPeriodsMenu", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		click("Blockout_AddBlockoutButton", blockoutData);
		sleep(2000);
		sendKeys("Blockout_NameTextfield",PropertiesCache.setProperty(testData, blockoutName),blockoutData);
		sendKeysWithEnter("Blockout_DescriptionTextfield",PropertiesCache.setProperty(testData, "Blockout_Desc"), blockoutData);
		
		click("Blockout_StartDateTextfield", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		sendKeys("Additional_information_DateTimePicker_Box_Textbox", "00:00", objectData);
		sleep(1000);
		click("Additional_information_DateTimePicker_Done_Button", objectData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
		
		click("Blockout_EndDateTextfield", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		sendKeys("Additional_information_DateTimePicker_Box_Textbox", "23:59", objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
				getDate(getCurrentDate("0"), days));
		click("Additional_information_DateTimePicker_Done_Button", objectData);
		waitForLoadingIconDisappear(80, "Loading_Gif", objectData);
		sleep(3000);
		
		click("Blockout_ShowOnSchedulerCheckbox", blockoutData);
		click("Blockout_SaveCloseButton", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
	}
	
	

	public void readBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {

		sleep(1000);
		click("Blockout_Show_DropDown", blockoutData);
		click("Clockout_CurrentYear_Option", String.valueOf(year), blockoutData);
		//scrollToElement("Blockout_SearchResultName", "Blockout_Automation", blockoutData, testData);
		//scrollToElement("Blockout_Automation", testData);
		/*
		 * sendKeysWithEnter(page,"NewUser_LiveSearchTextbox",
		 * "New_User_FirstName"); sleep(2000);
		 * click(page,"NewUser_SearchButton");
		 */
	}

	public void updateBlockout(String blockoutData, String testData, String objectData, String platform,String blockoutName) throws InterruptedException, IOException, AWTException{

		sleep(1000);
		clickElementUsingJavaScript("Blockout_SearchResultName", blockoutName, blockoutData, testData);
		sleep(5000);
		sendKeysWithEnter("Blockout_DescriptionTextfield", "Blockout_Changed_Desc", blockoutData, testData);
		click("Blockout_Attachment_Link", blockoutData);
		sleep(3000);
		/*doubleClick("Blockout_Add_Attachment_Button", blockoutData);
		sleep(3000);*/
		/*WebElement uploadFile = driver.findElement(By.name("uploadFile"));
		sleep(500);
		uploadFile.sendKeys(file);*/
		uploadImageByName("uploadFile");
		//uploadImage(platform, file);
		//uploadImage(platform, CommonConstants.imageFileName + PropertiesCache.getProperty(testData, "ImageName"));
		sleep(1000);
		click("Blockout_Add_Attachment_Close_Button", blockoutData);
		sleep(1000);
		click("Blockout_Attachment_Link", blockoutData);
		//sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		validateElementDisplayed("Blockout_Add_First_Attachment_Name_Text", blockoutData);
		Listener.addLogger( "Blockout attachment added successfully | ");
		click("Blockout_Add_Attachment_Close_Button", blockoutData);
		sleep(1000);
		click("Blockout_SaveCloseButton", blockoutData);

	}
	
	public void openBlockout(String blockoutData, String testData, String objectData){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Blockout_SearchResultName", "Blockout_Test_Automation_Id", blockoutData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public void clickOnElement(String blockoutData, String testData, String objectData,String elementId){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript(elementId, blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void clickOnBlockoutPeriod(String blockoutData, String testData, String objectData,String elementId){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Blockout_Name",elementId, blockoutData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public void createDuplicateBlockout(String blockoutData, String testData, String objectData, String platform) {
		sleep(2000);
		click("Blockout_SearchResultName", "Blockout_Automation", blockoutData, testData);
		sleep(5000);
		click("Blockout_SaveCloseButton", blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Blockout_Action_Dropdown", blockoutData);
		click("Blockout_Action_Duplicate_Option", blockoutData);
		sleep(1000);
		click("Blockout_Duplicate_Popup_Button", blockoutData);

	}
	
	public void duplicateBlockoutThroughAction(String blockoutData, String testData, String objectData) {
		sleep(2000);
		/* Clicking Blockout Name checkbox */
		clickElementUsingJavaScript("Blockout_Name_Chechbox", "Blockout_Test_Automation_Id", blockoutData, testData);
		/* Clicking on Action Button */
		clickElementUsingJavaScript("Action_Button", objectData);
		/* Clicking on Duplicate Blockout period */
		clickElementUsingJavaScript("Blockout_DuplicateBlockoutPeriod_DropDownOption", blockoutData);
		/* Waiting for 'Duplicate Blockout period' popup to appear */
		waitForLoadingElement(30, "Blockout_DuplicateBlockoutPeriod_PopUpWindow", blockoutData);
		/* Entering Duplicate Blockout Name */
		sendKeys("Blockout_DuplicateBlockoutPeriod_Inputfield", PropertiesCache.setProperty(
				PlutoraConfiguration.testData, "Duplicate_Blockout_Name", "Blockout_Test_Automation_Id_1"), blockoutData);
		/* Clicking on Duplicate Button */
		clickElementUsingJavaScript("Blockout_DuplicateBlockoutPeriod_DuplicateButton", blockoutData);
		/* Waiting for Loader to dissapear */
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void deleteDuplicateBlockout(String blockoutData, String testData, String objectData, String platform) {
		sleep(1000);
		setDuplicateName("(Copy) ", "Blockout_Automation", "Copy_Blockout_Automation", testData);
		click("Blockout_SearchResultName", "Copy_Blockout_Automation", blockoutData, testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("Blockout_DeleteButton", blockoutData);
		click("Blockout_DeleteYesButton", blockoutData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public void deleteBlockout(String blockoutData, String testData, String objectData,String blockoutId) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickElementUsingJavaScript("Blockout_SearchResultName", blockoutId, blockoutData, testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		click("Blockout_DeleteButton", blockoutData);
		click("Blockout_DeleteYesButton", blockoutData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, blockoutId)+" deleted successfully !");
	}
	public void clickOnSaveAndCloseButton(String blockoutData,String objectData) {
		clickOnButton(blockoutData, "Blockout_SaveCloseButton", objectData);
	}
	
	public void blockOutuploadImage(String blockoutData) throws InterruptedException, IOException, AWTException {
		scrollToElement("Blockout_Audit_BlockOutPeriodAddAttachment_Button",blockoutData);
		sleep(1000);
		clickElementUsingJavaScript("Blockout_Audit_BlockOutPeriodAddAttachment_Button",blockoutData);
		sleep(1000);
		uploadImageByName("uploadfile");
	 }
	
	public void clickOnSaveButton(String blockoutData,String objectData) {
		clickOnButton(blockoutData, "Blockout_SaveButton", objectData);
		waitForLoadingIconDisappear(30,"Loading_Gif" , objectData);
	}
	public void verifyBlockoutPeriodOptions(String blockoutData,String testData,String objectData,String blockoutName,String dropdown,String option,String textbox,String name) {
		doubleClick(dropdown,blockoutData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,blockoutData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Release Event dropdown successfully");
		click(option, name,blockoutData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(blockoutData, objectData);
		clickOnBlockoutPeriod(blockoutData, testData, objectData, blockoutName);
		verifyTextAttributeValue(textbox,name,blockoutData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after change save and close successfully");
		clickOnSaveAndCloseButton(blockoutData, objectData);
	}
	public void addBlockoutWithTypeDate(String blockoutData, String testData, String objectData,String blockoutId,String typeId) throws InterruptedException, ParseException {
		waitForLoadingIconDisappear(2, "Loading_Gif", objectData);
		mouseHover("Blockout_ReleaseHeader", "Blockout_BlockoutPeriodsMenu", blockoutData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		click("Blockout_AddBlockoutButton", blockoutData);
		sleep(2000);
		sendKeys("Blockout_NameTextfield",PropertiesCache.setProperty(testData, blockoutId),blockoutData);
		sendKeysWithEnter("Blockout_DescriptionTextfield", "Blockout_Desc", blockoutData, testData);
		click("Blockout_Type_Dropdown", blockoutData);
		click("Blockout_Type_Dropdown_Option", typeId,blockoutData,testData);
		click("Blockout_StartDateTextfield", blockoutData);
		click("Blockout_StartDateDoneTextfield", blockoutData);
		click("Blockout_EndDateTextfield", blockoutData);
		sendKeys("Blockout_EndDateTextfield", getTodayDate("2","dd/MM/yyyy HH:MM"),blockoutData);
		click("Blockout_ShowOnSchedulerCheckbox", blockoutData);
		click("Blockout_SaveButton", blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		blockoutStartDate = getAttributeValue("Blockout_StartDateTextfield",blockoutData,"value");
		blockoutEndDate = getAttributeValue("Blockout_EndDateTextfield",blockoutData,"value");
		//System.out.println("Startdate: "+blockoutStartDate +"Enddate: "+blockoutEndDate);
		click("Blockout_SaveCloseButton", blockoutData);
		sleep(2000);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, blockoutId)+" created with type "+PropertiesCache.getProperty(testData, typeId)+ " successfully !");
	}
	
	public void updateScheduler(String blockoutData,String objectData) {
		clickOnButton(blockoutData,"Blockout_ShowOnSchedulerCheckbox", objectData);
		clickOnButton(blockoutData,"Blockout_SaveButton", objectData);
		clickOnButton(blockoutData,"Blockout_SaveCloseButton", objectData);
		
	}
	
	public void addBlockoutNameQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sendKeys("QueryBuilder_NameValue_Textbox", value,objectData,testData,objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		
	}
	
	public void addOrganizationQuery(String testData,String objectData,String columnId,String condition,String value,String index,String statusIndex) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sleep(4000);
		//moveAndClickElement("QueryBuilder_Condition_Table_Dropdown_Option_One",value,objectData,testData);
		clickElementUsingJavaScript("QueryBuilder_Condition_Table_Dropdown_Option_One",objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("BuildUpYourQuery_Text",objectData);
	}
}

