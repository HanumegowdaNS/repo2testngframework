package com.plutora.pagerepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAndHoldAction;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;
import com.plutora.utils.WebGenericUtilLib;

public class EnvironmentPage extends TestGenericUtilLib {
	
	public void gotoEnvironmentPage(String envData, String objectData) throws InterruptedException {
		sleep(1000);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Environment_Header_Sidemenu", envData);
			sleep(500);
			click("Environment_Dropdown_Sidemenu", envData);
		} else {
			mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options", envData);
		}
		
	}


	public void createEnvironment(String envData, String testData, String objectData,String enviornmentName) throws InterruptedException {

		gotoEnvironmentPage(envData, objectData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		clickElementUsingJavaScript("NewEnvironment_Button", envData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		clickOnButton(envData, "Environment_Details_Tab", objectData);
		sendKeys("NewEnvironment_NameTextfield", PropertiesCache.setProperty(testData, enviornmentName), envData);
		sendKeysWithEnter("NewEnvironment_DescriptionTextfield", PropertiesCache.setProperty(testData, "New_ENV_Description"), envData);
		sleep(1000);
		clickElementUsingJavaScript("NewEnvironment_SystemDropdownIcon", envData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		click("NewEnvironment_SystemDropdownvalue", envData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		doubleClick("NewEnvironment_PhaseDropdown", envData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Environment_Phase",getTextData("NewEnvironment_PhaseDropdownvalue", envData));
		clickElementUsingJavaScript("NewEnvironment_PhaseDropdownvalue", envData);
		sendKeysWithEnter("NewEnvironment_VendorTextfield", "New_ENV_Description", envData, testData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
		doubleClick("NewEnvironment_StatusDropdown", envData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(3000);
		PropertiesCache.setProperty(testData, "Environment_Status",getTextData("NewEnvironment_StatusDropdownvalue", envData));
		click("NewEnvironment_StatusDropdownvalue", envData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}

	public void validateEnvironment(String envData, String testData, String objectData,String environmentName) {
		sleep(2000);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		sendKeysWithEnter("NewEnvironment_LiveSearchTextbox", environmentName, envData, testData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
	}
	public void clickOnEnvironment(String environmentData, String testData, String objectData,String environmentName) {
		sleep(2000);
		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", environmentName, environmentData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public void updateEnvironment(String envData, String testData, String objectData) {
		sleep(3000);

		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", "Environment_Automation", envData, testData);
//		sleep(5000);
//		click("NewEnvironment_DetailsTab", envData);
		sleep(5000);
		clear("NewEnvironment_DescriptionTextfield", envData);
		sendKeysWithEnter("NewEnvironment_DescriptionTextfield", PropertiesCache.setProperty(testData, "New_ENV_Change_Description"), envData);
		click("NewEnvironment_SaveCloseButton", envData);

	}
	
	public void updateEnvironmentWithNewStatus(String envData, String testData, String objectData,String status) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("NewEnvironment_StatusDropdown", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(6000);
		
		clickElementUsingJavaScript("NewEnvironment_StatusDropdown_Value", status,envData,testData);/*E2*/
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void createDuplicateEnvironment(String envData, String testData, String objectData,String envName)
			throws InterruptedException {
		sleep(4000);
		clickElementUsingJavaScript("NewEnvironment_EnvName_Checkbox", envName, envData, testData);
		sleep(1000);
		click("NewEnvironment_Action_Dropdown", envData);
		sleep(1000);
		click("NewEnvironment_Action_Duplicate_Option", envData);
		sleep(1000);
		click("NewEnvironment_Duplicate_Popup_Button", envData);

	}

	public void deleteDuplicateEnvironment(String envData, String testData, String objectData,String environmentName)
			throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("NewEnvironment_LiveSearchTextbox",setDuplicateName("(Copy)", environmentName, "Copy_"+environmentName, testData),envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", "Copy_"+environmentName, envData, testData);
		sleep(5000);
		click("NewEnvironment_DeleteButton", envData);
		click("NewEnvironment_DeleteYesButton", envData);
	}

	public void deleteEnvironment(String envData, String testData, String objectData,String environmentName) {

		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("NewEnvironment_LiveSearchTextbox",environmentName, envData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", environmentName, envData, testData);
		sleep(5000);
		click("NewEnvironment_DeleteButton", envData);
		click("NewEnvironment_DeleteYesButton", envData);
	}

	public void getTECRDetailsPage(String environmentData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Environment_Header_Sidemenu", environmentData);
			sleep(500);
			click("EnvironmentRequests_Dropdown_Sidemenu", environmentData);
		} else {
			mouseHover("Environment_Header_Dropdown", "EnvironmentRequests_Dropdown_Options", environmentData);
		}
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("TECR_Tab", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	public void getTECRFromMainMenuDetailsPage(String environmentData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Environment_Header_Dropdown", "EnvironmentRequests_Dropdown_Options", "TECR_TopMenu_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void getTEBRDetailsPage(String environmentData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Environment_Header_Sidemenu", environmentData);
			sleep(500);
			click("EnvironmentRequests_Dropdown_Sidemenu", environmentData);
		} else {
			mouseHover("Environment_Header_Dropdown", "EnvironmentRequests_Dropdown_Options", environmentData);
		}
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("TEBR_Tab", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
	}
	public void getTEBRFromMainMenuDetailsPage(String environmentData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Environment_Header_Dropdown", "EnvironmentRequests_Dropdown_Options", "TEBR_TopMenu_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void getSystemsOnlyDetailsPage(String environmentData, String objectData) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Systems_Option", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}


	public void getSystemsDetailsPage(String environmentData,String objectData) throws InterruptedException {
		sleep(2000);
		mouseHover("Environment_Header_Dropdown", "Environment_Systems_Option", environmentData);
		sleep(3000);
		clickElementUsingJavaScript("AddSystem_Button", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);

	}
	public void getSystemsPage(String environmentData, String objectData) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Systems_Option", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	public void goToEnvironmentRequestPage(String envData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		mouseHover("Environment_Header_Dropdown", "EnvironmentRequests_Dropdown_Options", envData);
		waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
		windowScrollDown("250");
	}
	
	public void goToEnvironmentPage(String envData, String testData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options", envData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		windowScrollDown("250");
	}
	public void goToEnvironmentGroupsPage(String envData, String testData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(2, "Loading_Gif",objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options","EnvGroups_ManageEnvGroups_Dropdown",envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		sleep(1000);
		windowScrollDown("250");
	}
	public void addHLCToEnvironment(String envData, String testData, String objectData,String envName){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeysWithEnter("NewEnvironment_LiveSearchTextbox", envName, envData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", envName, envData, testData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		click("Environment_AddHost_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clear("Environment_Specs_Textbox", envData);
		sleep(2000);
		doubleClick("Environment_AddHost_Text",envData);
		
		sendKeysWithoutClear("Environment_Specs_Textbox", PropertiesCache.setProperty(testData, "Environment_Host_Name"),envData);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("Environment_AddLayer_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	//	click("Environment_Layer_Dropdown",envData);
	//  waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Environment_Layer_Name",getTextData("Environment_Layer_Dropdown_Option", envData));
		click("Environment_Layer_Dropdown_Option",envData);
		sleep(1000);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("Environment_AddComponent_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clear("Environment_Specs_Textbox", envData);
		sleep(2000);
		doubleClick("Environment_AddComponent_Text",envData);
		sleep(2000);
		sendKeysWithoutClear("Environment_Specs_Textbox", PropertiesCache.setProperty(testData, "Environment_Component_Name"),envData);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton", envData);
	}
	public void verifyUpdatedEnvironment(String environmentData, String testData, String objectData,String environmentName) {
		validateEnvironment(environmentData, testData, objectData,environmentName);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("NewEnvironment_EnvNameLink", environmentName, environmentData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyTextAttributeValue("NewEnvironment_DescriptionTextfield", "New_ENV_Change_Description", environmentData, testData);
		sleep(2000);
		click("NewEnvironment_SaveCloseButton", environmentData);
	}
	public void clickOnEnvironmentCheckbox(String environmentData, String testData, String objectData,String checkboxId,String environmentName) {
		clickElementUsingJavaScript(checkboxId,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeysWithEnter("NewEnvironment_LiveSearchTextbox", environmentName, environmentData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);	 
		sleep(2000);
	}
	
	public void selectUtilizedIdle(String environmentData,String testData, String objectData,String environmentName,String locator1,String locator2) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	driver.findElement(By.xpath(PropertiesCache.getProperty(environmentData,locator1 )));
        } catch (NoSuchElementException e) {  
        	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath(PropertiesCache.getProperty(environmentData, locator2))));
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
	}
	public void clickOnEnvironmentDetailsCheckbox(String environmentData, String testData, String objectData,String checkboxId,String alertMsg) {
		scrollToElement(checkboxId,environmentData);
		clickElementUsingJavaScript(checkboxId,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		if(alertMsg.equals("message")) {
			sendKeys("Environment_BookingAlert_Message", PropertiesCache.setProperty(testData, "Env_BookingAlert"),environmentData);
			sleep(2000);
		}
		click("NewEnvironment_SaveCloseButton", environmentData);
	}
	
	public void selectEnvironmentGroup(String environmentData, String testData, String objectData,String environmentGroupName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",environmentGroupName, environmentData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithValue",environmentGroupName, environmentData,testData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",environmentGroupName, environmentData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(3000);
		
		click("NewEnvironment_SaveCloseButton", environmentData);
	}
	public void importHLCEnvironment(String environmentData, String testData, String objectData,String environmentName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Environment_Import_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Environment_Import_Tech_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Environment_Import_Tech_Textbox", environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Environment_Import_Tech_Value",environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Environment_Import_Tech_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void verifyAdditionalInformationTab(String environmentData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Environment_Additional_Information_Tab",environmentData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName", "Environment_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "Environment_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(environmentData,testData, objectData, customFieldList,"Environment_CustomField_Name","Env_Test_Automation_Id","NewEnvironment_EnvNameLink","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Environment_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	public void clickOnStakeholdersTab(String environmentData,String objectData) {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Environment_Stakeholders_Tab",environmentData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		
	}
	public void clickOnSaveAndCloseButton(String environmentData,String objectData){
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void clickOnSaveButton(String environmentData,String objectData){
		clickElementUsingJavaScript("NewEnvironment_SaveButton",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void verifyFieldPermissionCustomField(String environmentData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Environment_Additional_Information_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Environment_Additional_Information_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Environment_Additional_Information_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change additional information successfully");
		clickOnSaveAndCloseButton(environmentData, objectData);
	}
	public void updateEnvironmentWithNewPhase(String envData, String testData, String objectData,String status) throws InterruptedException{
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("NewEnvironment_PhaseDropdown", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		click("NewEnvironment_PhaseDropdown_Value", status,envData,testData);
		/*if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Environment_Header_Sidemenu", envData);
			sleep(500);
			click("Environment_Systems_Sidemenu", envData);
		} else {
			mouseHover("Environment_Header_Dropdown", "Environment_Systems_Option", envData);
		}*/
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("NewEnvironment_SaveCloseButton", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	public void updateStackLayerInEnvironment(String envData, String testData, String objectData,String customFieldName){
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		click("Environment_AddHost_Button",envData);
		clear("Environment_Specs_Textbox", envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		doubleClick("Environment_AddHost_Text",envData);
		sendKeys("Environment_Specs_Textbox", PropertiesCache.setProperty(testData, "Environment_Host_Name"),envData);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Environment_AddLayer_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Environment_Layer_Dropdown_Option_Value",customFieldName,envData,testData);
		sleep(1000);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("Environment_AddComponent_Button",envData);
		clear("Environment_Specs_Textbox", envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		doubleClick("Environment_AddComponent_Text",envData);
		sendKeys("Environment_Specs_Textbox", PropertiesCache.setProperty(testData, "Environment_Component_Name"),envData);
		click("NewEnvironment_SaveButton",envData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickOnSaveAndCloseButton(envData, objectData);
	}
	public void gotoEnvironmentStack(String envData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(2, "Loading_Gif",objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options","EnvironmentStack_Menu",envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		sleep(1000);
		windowScrollDown("250");
	}
	public void gotoEnvironmentSchedule(String envData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(2, "Loading_Gif",objectData);
		mouseHover("Environment_Header_Dropdown","EnvironmentSchedule_Menu",envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		sleep(1000);
		windowScrollDown("250");
	}
	public void selectDateRange(String pageData,String objectData) throws ParseException {
		clickOnButton(pageData,"EnvironmentSchedule_Date_Dropdown",objectData);
		clickOnButton(pageData,"EnvironmentSchedule_From_Today_Button",objectData);
		environmentSchedulerApplicationDatePicker(pageData, "EnvironmentSchedule_To_Calender",getTodayDate("365", "dd-MMMM-yyyy"), "To");
		clickOnButton(pageData,"EnvironmentSchedule_Submit_Button",objectData);
		
	}
	public void environmentSchedulerApplicationDatePicker(String pageData,String datePicker,String dateString,String calenderType) throws ParseException {

		String dateSelect[] = dateString.split("-");
		String ED = dateSelect[0];
		String EM = dateSelect[1];
		String EY = dateSelect[2];
		System.out.println(ED + EM + EY);
		if(ED.startsWith("0")) {
			ED=ED.replace("0", "");
		}
		sleep(2000);
		WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, datePicker));
	    if(!element.getText().split(" ")[1].equals(EY)){
	    	element.click();
	    	sleep(2000);
	    	driver.findElement(By.xpath("//a[text()='"+EY+"']")).click();
	    	sleep(1000);
	    	System.out.println(EM.substring(0, 3));
	    	driver.findElement(By.xpath("//a[text()='"+EM.substring(0, 3)+"']")).click();
	    	sleep(2000);
	    	driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
	    	sleep(2000);
	    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//label[text()='"+calenderType+"']/following-sibling::div//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
	    	sleep(1000);
	    }else if(element.getText().split(" ")[1].equals(EY)){
	    	if(!element.getText().split(" ")[0].equals(EM)){
	    		element.click();
	    		sleep(1000);
		    	driver.findElement(By.xpath("//a[text()='"+EM.substring(0, 3)+"']")).click();
		    	sleep(2000);
		    	driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
		    	sleep(2000);
		    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//label[text()='"+calenderType+"']/following-sibling::div//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
		    	sleep(1000);
	    	}else{
	    		sleep(2000);
	    		WebElement element1=driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//label[text()='"+calenderType+"']/following-sibling::div//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']"));
	    		scrollToElement(element1);
	    		sleep(1000);
	    		element1.click();
	    		sleep(2000);
	    	}
	    }
	   
	}
	public void selectSystemFilter(String pageData,String testData,String objectData,String systemId) {
		sendKeys("EnvironmentSchedule_System_Filter_Textbox", "",pageData);
		sendKeysWithoutClear("EnvironmentSchedule_System_Filter_Textbox", systemId,pageData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		verifyText("EnvironmentSchedule_System_Filter_LeftSection_Name", systemId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, systemId)+" displayed in Left section of System filter successfully !");
		dragAndDrop("EnvironmentSchedule_System_Filter_LeftSection_Name", "EnvironmentSchedule_System_Filter_RightSection",systemId,systemId,pageData,testData);
		verifyText("EnvironmentSchedule_System_Filter_LeftSection_Name", systemId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, systemId)+" displayed in Right section of System filter successfully !");
	}
	public void selectEnvironmentFilter(String pageData,String testData,String objectData,String environmentId) {
		sendKeys("EnvironmentSchedule_Environment_Filter_Textbox", "",pageData);
		sendKeysWithoutClear("EnvironmentSchedule_Environment_Filter_Textbox", environmentId,pageData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		verifyText("EnvironmentSchedule_Environment_Filter_LeftSection_Name", environmentId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, environmentId)+" displayed in Left section of Environment filter successfully !");
		dragAndDrop("EnvironmentSchedule_Environment_Filter_LeftSection_Name", "EnvironmentSchedule_Environment_Filter_RightSection",environmentId,pageData,testData);
		verifyText("EnvironmentSchedule_Environment_Filter_LeftSection_Name", environmentId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, environmentId)+" displayed in Right section of Environment filter successfully !");
	}
	public void selectReleaseFilter(String pageData,String testData,String objectData,String releaseId) {
		sendKeys("EnvironmentSchedule_Release_Filter_Textbox", "",pageData);
		sendKeysWithoutClear("EnvironmentSchedule_Release_Filter_Textbox", releaseId,pageData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		verifyTextContains("EnvironmentSchedule_Release_Filter_LeftSection_Name", releaseId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, releaseId)+" displayed in Left section of Release filter successfully !");
		dragAndDrop("EnvironmentSchedule_Release_Filter_LeftSection_Name", "EnvironmentSchedule_Release_Filter_RightSection",releaseId,releaseId,pageData,testData);
		verifyTextContains("EnvironmentSchedule_Release_Filter_LeftSection_Name", releaseId,pageData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, releaseId)+" displayed in Right section of Release filter successfully !");
	}
	
	public void saveFilter(String pageData,String testData,String objectData,String saveFilterName,String saveFilterDescription) {
		clickOnButton(pageData,"EnvironmentSchedule_SaveFilter_Button",objectData);
		sendKeys("EnvironmentSchedule_SaveFilter_Textbox", PropertiesCache.setProperty(testData, saveFilterName),pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sendKeys("EnvironmentSchedule_SaveFilter_Description_Textbox", PropertiesCache.setProperty(testData, saveFilterDescription),pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		click("EnvironmentSchedule_SaveFilter_Save&Close_Button",pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, saveFilterName)+" saved filter successfully !");
	}
	public void loadFilter(String pageData,String testData,String objectData,String saveFilterName,String loadFilterDescription) {
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_Button",objectData);
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_MyFilter_Dropdown",objectData);
		clickButton("EnvironmentSchedule_LoadFilter_MyFilter_Dropdown_Option",saveFilterName,pageData,testData,objectData);
		sendKeys("EnvironmentSchedule_LoadFilter_Description_Textbox", PropertiesCache.setProperty(testData, loadFilterDescription),pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_ApplyFilter_Button",objectData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(testData, saveFilterName)+" loaded filter successfully !");
	}
	public void deleteLoadFilter(String pageData,String testData,String objectData,String saveFilterName) {
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_Button",objectData);
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_MyFilter_Dropdown",objectData);
		clickButton("EnvironmentSchedule_LoadFilter_MyFilter_Dropdown_Option",saveFilterName,pageData,testData,objectData);
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_Delete_Button",objectData);
		verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, "Save_Filter"));
		clickOnButton(pageData,"EnvironmentSchedule_LoadFilter_ApplyFilter_Button",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, saveFilterName)+" Deleted saved filter successfully !");
	}
	public String getQuarter() {
		String[] mQuarterKey = {"Q1", "Q2", "Q3", "Q4"};
		return mQuarterKey[(Calendar.getInstance().get(Calendar.MONTH) / 3)];
	}
	public void openTECRDetailsPage(String pageData,String testData,String objectData,String groupId) {
		clickButton("EnvironmentSchedule_Setting_Icon",groupId,pageData,testData,objectData);
		sleep(2000);
		clickButton("EnvironmentSchedule_TECR_Text",groupId,pageData,testData,objectData);
		sleep(4000);
		doubleClick("EnvironmentSchedule_TECR_Panel",pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(2000);
		
	}
	public void openESTECRDetailsPage(String pageData,String testData,String objectData,String groupId) {
		sleep(2000);
		doubleClick("EnvironmentSchedule_Setting_Icon",groupId,pageData,testData);
		sleep(2000);
		//clickButton("EnvironmentSchedule_TECR_Text",groupId,pageData,testData,objectData);
		sleep(4000);
		doubleClick("EnvironmentSchedule_ES_TECR_Panel",pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(2000);
		
	}
	public void openTEBRDetailsPage(String pageData,String testData,String objectData) {
		doubleClickOnHold("EnvironmentSchedule_TEBR_Panel",pageData);
		waitForLoadingIconDisappear(1000, "Loading_Gif",objectData);
	}
	public void openBookingDetailsPage(String pageData,String objectData) {
		clickOnHold("EnvironmentSchedule_Enterprise_Booking_Panel",pageData);
		sleep(5000);
		waitForLoadingIconDisappear(1000, "Loading_Gif",objectData);
	}
	public void createMyEnvironmentBooking(String pageData,String testData,String objectData,String envGrpId) {
		clickOnButton(pageData,"MyEnvironmentBooking_Environment_Dropdown_Icon",objectData);
		sendKeys("MyEnvironmentBooking_Environment_Textbox", envGrpId,pageData,testData,objectData);
		clickButton("MyEnvironmentBooking_Environment_Dropdown_Option", envGrpId,pageData,testData,objectData);
		sleep(3000);
		clickOnButton(pageData,"MyEnvironmentBooking_Save_Button",objectData);
		clickOnButton(pageData,"MyEnvironmentBookingSchedule_Save&Close_Button",objectData);
	}
	public void editMyEnvironmentBooking(String pageData,String testData,String objectData,String status,String envGrpId) {
		sleep(2000);
		doubleClick("EnvironmentSchedule_Booking_Event",envGrpId,pageData,testData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(2000);
		click("ViewMyEnvironmentBooking_Status_Checkbox",status,pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(3000);
		clickOnButton(pageData,"MyEnvironmentBooking_Save_Button",objectData);
		clickOnButton(pageData,"MyEnvironmentBookingSchedule_Save&Close_Button",objectData);
	}

	
	public void findAndEditEnvironmentSystem(String pageData,String testData,String objectData) {
		clickElement("EnvironmentSystem_SystemNameFilter_xoutsign", pageData);
		sleep(2000);
		sendKeys("EnvSystems_SystemNameFilter_Input","Systems_Test",pageData,testData);
		enter();
	    sleep(2000);
	    clickElementUsingJavaScript("EnvironmentSystem_SystemNameResult_Link",PropertiesCache.getProperty(testData, "Systems_Test"),pageData);
	    sleep(3000);
	    clickElementUsingJavaScript("EnvironmentSystem_SystemPortfolioAssociation_xoutsign",pageData);
	    sleep(1000);
	    clickElementUsingJavaScript("EnvironmentSystem_SystemPortfolioAssociation_AddIcon",pageData);
	    clickElementUsingJavaScript("EnvironmentSystem_SystemPortfolioAssociation_ListSecondItem",pageData);
	    clickElementUsingJavaScript("EnvironmentSystem_SystemPortfolioAssociation_SaveButton",pageData);
	    sleep(2000);
	}
	
	

	public void updateBulkUpdate(String pageData,String testData,String objectData,String status) {
		clickOnButton(pageData,"MyEnvironmentBooking_ActionButton",objectData);
		clickOnButton(pageData,"MyEnvironmentBooking_BulkUpdate_Button",objectData);
		click("MyEnvironmentBooking_BulkUpdate_Status_Checkbox",status,pageData);
		clickOnButton(pageData,"MyEnvironmentBooking_Save&Close_Button",objectData);
		
	}
	public void editMyEnvironmentBookingStatus(String pageData,String testData,String objectData,String status) {
		click("ViewMyEnvironmentBooking_Status_Checkbox",status,pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		sleep(3000);
		clickOnButton(pageData,"MyEnvironmentBooking_Save_Button",objectData);
		clickOnButton(pageData,"MyEnvironmentBooking_Save&Close_Button",objectData);
	}
	public void editMyEnvironmentBookingDate(String pageData,String testData,String objectData,String environmentName) throws ParseException {
		
		clickButton("MyEnvironmentBooking_Allocation_Icon",environmentName,pageData,testData,objectData);
		
		clickOnButton(pageData,"MyEnvironmentBooking_EndDate_Calender_Icon",objectData);
		applicationDatePicker(pageData, testData, "MyEnvironmentBooking_DatePicker_Calender", getCurrentDate("15"));
		clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		clickOnButton(pageData,"MyEnvironmentBooking_StartDate_Calender_Icon",objectData);
		applicationDatePicker(pageData, testData, "MyEnvironmentBooking_DatePicker_Calender", getCurrentDate("0"));
		clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		click("MyEnvironmentBooking_TEBR_Save&Close_Button",pageData);
		waitForLoadingIconDisappear(100, "Loading_Gif",objectData);
		Listener.addLogger("My Environmnet Booking "+" "+"End Date :"+getCurrentDate("15")+"   "+"Start End  :"+getCurrentDate("0")+" updated successfully !");
	}
	public void clickOnManageGroupsOption(String pageData,String objectData) {
		clickOnButton(pageData,"NewEnvironment_Action_Dropdown",objectData);
		clickOnButton(pageData,"Environment_ManageGroups_Option",objectData);
		
	}

	 public void searchLinkedItems(String environmentData,String testData,String objectData,String moduleName,String moduleId,String moduleStatus) {
		 clickOnButton(environmentData,"Environment_LinkedItems_Tab",objectData);
		 clickOnButton(environmentData,moduleName,objectData);
		 clear("Environment_LinkedItems_Name_Textbox", environmentData);
		 clear("Environment_LinkedItems_Status_Textbox", environmentData);
		 sendKeysWithEnter("Environment_LinkedItems_Name_Textbox",moduleId,environmentData,testData);
		 sendKeysWithEnter("Environment_LinkedItems_Status_Textbox",moduleStatus,environmentData,testData);
		 
	 }
	 public void searchIdentifierLinkedItems(String environmentData,String testData,String objectData,String moduleName,String moduleId) {
		 clickOnButton(environmentData,"Environment_LinkedItems_Tab",objectData);
		 clickOnButton(environmentData,moduleName,objectData);
		 sendKeysWithEnter("Environment_LinkedItems_Identifier_Textbox",moduleId,environmentData,testData);
	 }
	 public void addParentEnvironment(String environmentData,String testData,String objectData,String environmentName) {
		clickOnButton(environmentData, "Environment_ParentTo_AddEnvironment_Icon", objectData);
		sendKeys("Environment_ParentTo_Environment_Textbox",environmentName,environmentData,testData,objectData);
		clickButton("Environment_ParentTo_Environment_Dropdown_Option",environmentName,environmentData,testData,objectData);
		clickOnButton(environmentData, "Environment_ParentTo_Environment_Dropdown", objectData);
		clickOnButton(environmentData, "Environment_Linked_Save&Close_Button", objectData);
	 }
	 public void addChildEnvironment(String environmentData,String testData,String objectData,String environmentName) {
		clickOnButton(environmentData, "Environment_ChildOf_AddEnvironment_Icon", objectData);
		sendKeys("Environment_ChildOf_Environment_Textbox",environmentName,environmentData,testData,objectData);
		sleep(3000);
		clickButton("Environment_ChildOf_Environment_Dropdown_Option",environmentName,environmentData,testData,objectData);
		sleep(2000);
		clickOnButton(environmentData, "Environment_ChildOf_Environment_Dropdown", objectData);
		clickOnButton(environmentData, "Environment_Linked_Save&Close_Button", objectData);
	}
	 public void addViewByDateUtilize(String environmentData,String testData,String objectData,String environmentName,String startDays,String endDays) throws ParseException {
		 clickOnButton(environmentData,"Environment_ViewByDate_Button",objectData);
		 //Start Date
		 clickOnButton(environmentData,"Environment_ViewByDate_StartDate_Calendar",objectData);
		 clickOnButton(objectData,"Additional_information_DatePicker_Today_Button",objectData);
		
		 //End Date
		 clickOnButton(environmentData,"Environment_ViewByDate_EndDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate(endDays));
		
		 clickOnButton(environmentData,"Environment_ViewByDate_Save&Close_Button",objectData);
		 
	 }
	 public void addViewByDateIdle(String environmentData,String testData,String objectData,String environmentName,String startDays,String endDays) throws ParseException {
		 clickOnButton(environmentData,"Environment_ViewByDate_Button",objectData);
		 //Start Date
		 clickOnButton(environmentData,"Environment_ViewByDate_StartDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate(startDays));
		
		 //End Date
		 clickOnButton(environmentData,"Environment_ViewByDate_EndDate_Calendar",objectData);
		 releaseDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate(endDays));
		 
		 clickOnButton(environmentData,"Environment_ViewByDate_Save&Close_Button",objectData);
		 
	 }

	public void verifyEnvironmentHealthCheckOption(String element, String envData) {
		validateElementDisplayed(element, envData);
		sleep(500);
	}
	
	public void uploadHelathCheckScript(String envData, String fileName, String testData){
		sleep(1000);
		click("EHC_Configure_Button",envData);
		sleep(1000);
		sendKeys("EHC_JobName_Textfield", PropertiesCache.setProperty(testData, "EHC_JobName"), envData);
		sendKeys("EHC_Description_Textfield", PropertiesCache.setProperty(testData, "EHC_Description"), envData);
		uploadFile("EHC_Script_Upload",envData,fileName);
		sleep(2000);
		click("EHC_RunAndClose_Button", envData);
		sleep(6000);
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton", envData);
		sleep(1000);
	}
			
	public void verifyHealthCheckStatus(String expectedStatus, String labelLocator, String envData){
		String actualStatus = PropertiesCache.getProperty(envData, labelLocator);
		sleep(2000);
		verifyTextContains(actualStatus, expectedStatus);
	}
	public void updateComponentVersion(String environmentData,String testData,String objectData,String componentName,String version) {
		doubleClick("Environment_Component_Value",componentName,environmentData,testData);
		sendKeysWithoutClear("Environment_Component_Textbox", version,environmentData);
		clickOnSaveAndCloseButton(environmentData, objectData);
	}
	public void updateEnvironmentGroup(String environmentData,String testData,String objectData,String envGroupName) {
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",envGroupName, environmentData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithValue",envGroupName, environmentData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",envGroupName, environmentData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickOnSaveAndCloseButton(environmentData, objectData);
	}
}
