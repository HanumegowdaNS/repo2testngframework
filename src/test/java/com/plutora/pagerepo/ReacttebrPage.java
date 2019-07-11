package com.plutora.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class ReacttebrPage extends TestGenericUtilLib {
	CustomizationPage customizationPage = new CustomizationPage();
	public static String status = null, assignedTo = null, type = null;;
	public static String startDate, endDate = null;

	public void getTEBRDetilsPageFromNewMenu(String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("New_Option", "New_Environment_Option", "New_TEBR_Option", objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void creationTEBR(String tebrData, String testData, String objectData, String tebrId)
			throws InterruptedException {
		click("AddTEBR_Button", tebrData);
		/* Enter New TEBR Name */
		
		sleep(4000);
		sendKeys("AddTEBR_IDTextfield", PropertiesCache.setProperty(testData, tebrId), tebrData);
		sleep(2000);
		sendKeys("AddTEBR_DescriptonTextfield", "New_TEBR_Description_Value", tebrData);
		// click("AddTEBR_TypeDropdown", tebrData);
		
		sleep(2000);
		// PropertiesCache.setProperty(testData, "TEBR_Type", getTextData("AddTEBR_TypeFirst", tebrData));
		// click("AddTEBR_TypeFirst", tebrData);

		/* Selection of Status Dropdown 
		clickElementUsingJavaScript("AddTEBR_StatusDropdown", tebrData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		status = getTextData("AddTEBR_StatusFirst", tebrData);
		PropertiesCache.setProperty(testData, "TEBR_Status", getTextData("AddTEBR_StatusFirst", tebrData));
		click("AddTEBR_StatusFirst", tebrData);

		/* Selection of Start DatePicker  
		click("AddTEBR_StartDatePicker", tebrData);
		click("AddTEBR_StartDatePicker_DoneButton", tebrData);
		/* Selection of End DatePicker 
		click("AddTEBR_EndDatePicker", tebrData);
		click("AddTEBR_EndDatePicker_DoneButton", tebrData);
		sleep(1000);
		/*
		//  Selection of Assigned To Dropdown 
		 * 
		 */
		
		click("AddTEBR_AssignedToDropdown", tebrData);
		sleep(3000);
		assignedTo = getTextData("AddTEBR_AssignedToFirst", tebrData);
		PropertiesCache.setProperty(testData, "TEBR_AssignedTo", getTextData("AddTEBR_AssignedToFirst", tebrData));
		click("AddTEBR_AssignedToFirst", tebrData);
		sleep(3000);
		click("TEBR_SaveButton", tebrData);
		sleep(3000);
	}

	public void enterNewlyCreatedTEBR(String tebrData, String testData, String objectData, String tebrId) {
		sleep(2000);
		clickElementUsingJavaScript("TEBR_Label", tebrData);
		sleep(2000);
		sendKeys("TEBR_SearchButton", tebrId, tebrData, testData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
	}

	public void enterNewlyCreatedTEBR(String tebrData, String testData, String objectData, String searchBox,
			String tebrId) {
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		clickElementUsingJavaScript("TEBR_Label", tebrData);
		sleep(2000);
		sendKeys(searchBox, tebrId, tebrData, testData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
	}

	public void enterNewlyCreatedTEBR(String tebrData, String testData, String objectData) {
		clickElementUsingJavaScript("TEBR_Label", tebrData);
		sleep(2000);
		sendKeysWithEnter("TEBR_SearchButton", "TEBR_Test_Automation_Id", tebrData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void clickAndUpdateNewlyCreatedTEBR(String tebrData, String objectData, String testData, String tebrId) {
		 click("TEBR_Name", tebrId, tebrData, testData);
		// waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		// clickElementUsingJavaScript("TEBR_LeftJustfiyText_Button", tebrData);
		sleep(1000);
		sendKeys("AddTEBR_DescriptonTextfield", "Update_React_TEBR_Description_Value", tebrData);
		//sendKeys("React_TEBR_Description_TextField", "TEBR_Description_TextField_Value", tebrData, testData);
		sleep(1000);
		click("TEBR_SaveButton", tebrData);
		sleep(3000);
		
	}
	
	public  void deleteNewlyCreatedTEBR(String tebrData,String testData,String objectData,String tebrId){
		enterNewlyCreatedTEBR(tebrData, testData,objectData,tebrId);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(5000);
		clickElementUsingJavaScript("TEBR_Delete_Button",tebrData);
		sleep(3000);
		click("TEBR_Yes_Button",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}

	public void createDuplicateTEBR(String tebrData,String testData,String objectData,String tebrName) throws InterruptedException {
		/*switchToDefaultContent();
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Save&CloseButton",tebrData);
		sleep(2000);
		enterNewlyCreatedTEBR(tebrData, testData,objectData,"TEBR_Test_Automation_Id");
		sleep(4000);
		clickElementUsingJavaScript("TEBR_Name_Checkbox","TEBR_Test_Automation_Id",tebrData,testData);
		sleep(2000);
		sleep(1000);
		enterNewlyCreatedTEBR(tebrData, testData,objectData);*/
		sleep(2000);
		click("TEBR_Name_Checkbox",tebrName,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_ActionButton",tebrData);
		mouseHover("TEBR_Duplicate_Option", "TEBR_Duplicate_Once_Option",tebrData);
		//sleep(1000);
		//click("TEBR_Duplicate_Once_Option",tebrData);
		sleep(2000);
		clickElementUsingJavaScript("TEBR_DuplicateButton",tebrData);
	}
	

	public void enterNewlyCreatedDuplicateTEBR(String tebrData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("TEBR_SearchButton",setDuplicateName("(Copy) ", "TEBR_React_Test_Automation_Id", "Copy_TEBR_React_Test_Automation_Id", testData),tebrData);
		sleep(1000);
	}

	public  void deleteNewlyCreatedDuplicateTEBR(String tebrData,String testData, String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("TEBR_Name","Copy_TEBR_Test_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("TEBR_Delete_Button",tebrData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Yes_Button",tebrData);
	}
	private void createTEBR(String tebrData,String testData,String objectData,String tebrId,String text) {
		if(text.isEmpty()) {
			click("AddTEBR_Button", tebrData);
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(PropertiesCache.getProperty(tebrData, "AddTEBR_termsandConditions_Submit"))));
        } catch (NoSuchElementException e) {  
        	
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
		
		//click("AddTEBR_termsandConditions_Submit", tebrData);
		sleep(2000);
		sendKeys("AddTEBR_IDTextfield",PropertiesCache.setProperty(testData, tebrId),tebrData);
		sleep(4000);
		/* Selection of Status Dropdown */
		click("AddTEBR_StatusDropdown",tebrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		status=getTextData("AddTEBR_StatusFirst",tebrData);
		PropertiesCache.setProperty(testData, "TEBR_Status",getTextData("AddTEBR_StatusFirst",tebrData));
		click("AddTEBR_StatusFirst",tebrData);

		/* Selection of Start DatePicker */
		click("AddTEBR_StartDatePicker",tebrData);
		click("AddTEBR_StartDatePicker_DoneButton",tebrData);
		/* Selection of End DatePicker */
		click("AddTEBR_EndDatePicker",tebrData);
		click("AddTEBR_EndDatePicker_DoneButton",tebrData);
		sleep(3000);

		/* Selection of Assigned To Dropdown  */
		click("AddTEBR_AssignedToDropdown",tebrData);
		assignedTo=getTextData("AddTEBR_AssignedToFirst",tebrData);
		PropertiesCache.setProperty(testData, "TEBR_AssignedTo",getTextData("AddTEBR_AssignedToFirst",tebrData));
		click("AddTEBR_AssignedToFirst",tebrData);
	}
	
	 public void addComments(String testData,String objectData,String comments) {
		 sendKeys("Comments_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Send_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" added successfully !");
	 }
	 public void editComments(String testData,String objectData,String comments) {
		 clickOnButton(objectData,"Comments_Edit_Link",objectData);
		 sendKeys("Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Update_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" updated successfully !");
	 }
	 public void replyComments(String testData,String objectData,String comments) {
		 clickOnButton(objectData,"Comments_Reply_Link",objectData);
		 clickOnButton(objectData,"Comments_Cancel_Button",objectData);
		 clickOnButton(objectData,"Comments_Reply_Link",objectData);
		 sendKeys("Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Reply_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" replyed successfully !");
	 }
	 public void deleteComments(String objectData) {
		 clickOnButton(objectData,"Comments_Delete_Link",objectData);
		 clickOnButton(objectData,"Comments_Yes_Button",objectData);
	 }
}

