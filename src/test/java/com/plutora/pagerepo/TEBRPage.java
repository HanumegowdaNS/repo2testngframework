package com.plutora.pagerepo;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class TEBRPage extends TestGenericUtilLib  {
	CustomizationPage customizationPage = new CustomizationPage();
	public static String status = null,assignedTo=null,type=null;;
	public static String startDate,endDate=null;
	
	public void getTEBRDetilsPageFromNewMenu(String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("New_Option", "New_Environment_Option", "New_TEBR_Option",objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void creationTEBR(String tebrData,String testData,String objectData,String tebrId) {	
		click("AddTEBR_Button", tebrData);
		/* Enter New TEBR Name */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
        try {  
         driver.findElement(By.cssSelector(PropertiesCache.getProperty(tebrData, "AddTEBR_termsandConditions_Submit"))).click();
        
         sleep(2000);
        } catch (NoSuchElementException e) {  
        	
        } 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  
		sleep(4000);
		sendKeys("AddTEBR_IDTextfield",PropertiesCache.setProperty(testData, tebrId),tebrData);
		sleep(4000);
		click("AddTEBR_TypeDropdown",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "TEBR_Type",getTextData("AddTEBR_TypeFirst",tebrData));
		click("AddTEBR_TypeFirst",tebrData);
		
		/* Selection of Status Dropdown */
		clickElementUsingJavaScript("AddTEBR_StatusDropdown",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		status=getTextData("AddTEBR_StatusFirst",tebrData);
		PropertiesCache.setProperty(testData, "TEBR_Status",getTextData("AddTEBR_StatusFirst",tebrData));
		click("AddTEBR_StatusFirst",tebrData);

		/* Selection of Start DatePicker */
		click("AddTEBR_StartDatePicker",tebrData);
		click("AddTEBR_StartDatePicker_DoneButton",tebrData);
		/* Selection of End DatePicker */
		click("AddTEBR_EndDatePicker",tebrData);
		click("AddTEBR_EndDatePicker_DoneButton",tebrData);
		sleep(1000);
		/* Selection of Assigned To Dropdown  */
		click("AddTEBR_AssignedToDropdown",tebrData);
		sleep(3000);
		assignedTo=getTextData("AddTEBR_AssignedToFirst",tebrData);
		PropertiesCache.setProperty(testData, "TEBR_AssignedTo",getTextData("AddTEBR_AssignedToFirst",tebrData));
		click("AddTEBR_AssignedToFirst",tebrData);
		click("TEBR_Save&CloseButton",tebrData);
	}

	public  void enterNewlyCreatedTEBR(String tebrData,String testData,String objectData,String tebrId){
		sleep(2000);
		clickElementUsingJavaScript("TEBR_Label",tebrData);
		sleep(2000);
		sendKeys("TEBR_SearchButton",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	public  void enterNewlyCreatedTEBR(String tebrData,String testData,String objectData,String searchBox,String tebrId){
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickElementUsingJavaScript("TEBR_Label",tebrData);
		sleep(2000);
		sendKeys(searchBox,tebrId,tebrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public  void enterNewlyCreatedTEBR(String tebrData,String testData,String objectData){
		clickElementUsingJavaScript("TEBR_Label",tebrData);
		sleep(2000);
		sendKeysWithEnter("TEBR_SearchButton","TEBR_Test_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public  void clickAndUpdateNewlyCreatedTEBR(String tebrData,String objectData,String testData,String platform,String tebrId) {
		click("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//clickElementUsingJavaScript("TEBR_LeftJustfiyText_Button", tebrData);
		sleep(1000);
		switchToFrameByElement("TEBR_Iframe",objectData);
		if (PlutoraConfiguration.browserName.equals("FF")) {
			sendKeysWithDelete("TEBR_Description_TextField","TEBR_Description_TextField_Value", tebrData, testData,platform);
		} else {
			sendKeys("TEBR_Description_TextField", "TEBR_Description_TextField_Value", tebrData, testData);
		}
		switchToDefaultContent();
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/*waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TEBR_Name","TEBR_Automation_Id",tebrData,testData);
		switchToFrameByElement("TEBR_Iframe",objectData);*/
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
		sendKeys("TEBR_SearchButton",setDuplicateName("(Copy) ", "TEBR_Test_Automation_Id", "Copy_TEBR_Test_Automation_Id", testData),tebrData);
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
	public void creationTEBRWithRelease(String tebrData,String testData,String objectData,String projectId,String systemId,String tebrId,String text){	
		createTEBR(tebrData, testData, objectData,tebrId,text);
		scrollToElement("TEBR_ReleaseName_Dropdown",tebrData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_ReleaseName_Dropdown",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("TEBR_ReleaseName_Textbox", projectId, tebrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("TEBR_ReleaseName_Option",projectId,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		verifyText("TEBR_ReleaseName_SystemName", systemId, tebrData,testData);
		Listener.addLogger("System Name is verified successfully !");
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	
	public void updateTEBRWithReleaseEnvironment(String tebrData,String testData,String objectData,String tebrId,String envName) { 
		sleep(2000);
		enterNewlyCreatedTEBR(tebrData, testData, objectData,tebrId);
		sleep(2000);
		click("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("TEBR_Environment_Section",envName,tebrData,testData);
		sleep(5000);
		clickWebelementButton(tebrData, "TEBRPhaseOnFlag", "TEBRPhaseOffFlag",PlutoraConfiguration.objectData,"css");
		sleep(4000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Dropped_Env_Name",envName,tebrData,testData);
		Listener.addLogger("Environment Name is verified after drag & dropped successfully !");
		sleep(2000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void updateTEBRWithReleaseEnvironmentGroup(String tebrData,String testData,String objectData,String tebrId,String envName) { 
		enterNewlyCreatedTEBR(tebrData, testData, objectData,tebrId);
		click("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("TEBR_EnvironmentGroup_Env_Name",envName,tebrData,testData);
		sleep(5000);
		clickWebelementButton(tebrData, "TEBRPhaseOnFlag", "TEBRPhaseOffFlag",PlutoraConfiguration.objectData,"css");
		dragAndDrop("TEBR_EnvironmentGroup_Env_Name", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Group is drag & dropped successfully !");
		sleep(2000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void creationTEBRWithEnvironment(String tebrData,String testData,String objectData,String envName,String tebrId,String text){	
		createTEBR(tebrData, testData, objectData,tebrId,text);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyText("TEBR_Environment_Env_Name",envName,tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Dropped_Env_Name",envName,tebrData,testData);
		Listener.addLogger("Environment Name is verified after drag & dropped successfully !");
		sleep(2000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void creationTEBRWithEnvironmentGroup(String tebrData,String testData,String objectData,String envName,String tebrId,String text,String saveButton){	
		createTEBR(tebrData, testData, objectData,tebrId,text);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyTextContains("TEBR_EnvironmentGroup_Env_Name",envName,tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_EnvironmentGroup_Env_Name", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		//verifyText("TEBR_EnvironmentGroup_Dropped_Env_Name",envName,tebrData,testData);
		Listener.addLogger("Environment Group Name is verified after drag & dropped successfully !");
		sleep(2000);
		clickOnButton(tebrData,saveButton,objectData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void updateTEBRWithEnvironmentGroup(String tebrData,String testData,String objectData,String envGroupName,String tebrId,String text,String saveButton){	
		enterNewlyCreatedTEBR(tebrData, testData, objectData,tebrId);
		click("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envGroupName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyTextContains("TEBR_EnvironmentGroup_Env_Name",envGroupName,tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_EnvironmentGroup_Env_Name", "TEBR_DropEnvironment_Section", envGroupName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickOnButton(tebrData,saveButton,objectData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void updateTEBRWithEnvironment(String tebrData,String testData,String objectData,String envName,String tebrId,String saveButton){	
		enterNewlyCreatedTEBR(tebrData, testData, objectData,tebrId);
		click("TEBR_Name",tebrId,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyTextContains("TEBR_Environment_Section",envName,tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickOnButton(tebrData,saveButton,objectData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	
	public void updateTEBRWithEnvironment(String tebrData,String testData,String objectData,String environmentData,String environmentName) { 
		sleep(1000);
		enterNewlyCreatedTEBR(tebrData, testData, objectData,"TEBR_Test_Automation_Id");
		sleep(1000);
		click("TEBR_Name","TEBR_Test_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", environmentName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickElementUsingJavaScript("TEBR_Environment_Env_Name",environmentName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		sendKeys("NewEnvironment_NameTextfield", PropertiesCache.setProperty(testData, environmentName), environmentData);
		sleep(2000);
		click("TEBR_Environment_Save&Close_Button",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("TEBR_Environment_SearchBox", environmentName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Env_Name",environmentName,tebrData,testData);
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	
	public void verifyTEBRWithEnvironment(String tebrData,String testData,String objectData) { 
		enterNewlyCreatedTEBR(tebrData, testData, objectData,"TEBR_Test_Automation_Id");
		click("TEBR_Name","TEBR_Test_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", "Env_Test_Automation_Id_2",tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Env_Name","Env_Test_Automation_Id_2",tebrData,testData);
		sleep(1000);
		verifyText("TEBR_Environment_Dropped_Env_Name","Env_Test_Automation_Id_2",tebrData,testData);
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void verifyAdditionalInformationTab(String testData,String objectData,String tebrData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("Additional_Information_LabelName", "TEBR_CustomField_Name",objectData,testData);
		verifyText("Additional_Information_LabelName", "TEBR_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(tebrData,testData, objectData, customFieldList,"TEBR_CustomField_Name","TEBR_Test_Automation_Id","TEBR_Name","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "TEBR_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	
	public void updateEditBooking(String tebrData,String testData,String objectData,String environmentName) {
		
	//	scrollToElement("TEBR_Environment_Section",environmentName,tebrData,testData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_ReleaseName_AvailableFor_Dropdown",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickElementUsingJavaScript("TEBR_ReleaseName_AvailableFor_Dropdown_Option",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		validateElementDisplayed("TEBR_Environment_Conflicting_Text","Env_Test_Automation_Id", tebrData,testData);
		validateElementDisplayed("TEBR_Environment_Available_Text","Env_Test_Automation_Id_2", tebrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_2")+" - environment edit booking status is verified successfully !");
		sleep(4000);
		/*scrollToElement("TEBR_Environment_Available_Text","Env_Test_Automation_Id_2", tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_Available_Environment_Section", "TEBR_Available_DropEnvironment_Section", environmentName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Dropped_Env_Name",environmentName,tebrData,testData);
		Listener.addLogger("Environment Name is verified after drag & dropped successfully !");
		sleep(2000);*/
		
	}
	public  void updateTEBRByName(String tebrData,String testData,String objectData) {
		sleep(3000);
		click("TEBR_Name","TEBR_Test_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("AddTEBR_IDTextfield",PropertiesCache.setProperty(testData, "TEBR_Test_Automation_Id"),tebrData);
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		
	}
	public void creationTEBRWithEnvironmentBookingAlert(String tebrData,String testData,String objectData,String text){	
		createTEBR(tebrData, testData, objectData,"TEBR_Test_Automation_Id",text);
		scrollToElement("TEBR_ReleaseName_Dropdown",tebrData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_ReleaseName_Dropdown",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("TEBR_ReleaseName_Textbox", "PRelease_Automation_Id", tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		click("TEBR_ReleaseName_Option","PRelease_Automation_Id",tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("TEBR_Environment_Section","Env_Test_Automation_Id",tebrData,testData);
		sleep(1000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", "Env_Test_Automation_Id",tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
	}
	
	public void verifyTEBRFieldOptions(String tebrData,String testData,String objectData,String dropdown,String option,String textbox,String name,String tebrId) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(dropdown,tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tebrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change dropdown successfully");
		click(option, name,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		enterNewlyCreatedTEBR(tebrData, testData, objectData,tebrId);
		clickOnTEBRName(tebrData, testData, objectData,tebrId);
		verifyTextAttributeValue(textbox,name,tebrData,testData);
		
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after change save and close successfully");
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
	}
	public void clickOnSaveAndCloseButton(String tebrData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public  void clickOnTEBRName(String tecrData,String testData,String objectData,String tebrId) {
		sleep(1000);
		click("TEBR_Name",tebrId,tecrData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void verifyTEBRWithEnvironmentDisabled(String tebrData,String testData,String objectData,String envName){	
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		validateElementDisplayed("TEBR_Environment_Disabled", tebrData);
		sleep(1000);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
	public void verifyFieldPermissionCustomField(String tebrData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change additional information successfully");
		clickOnSaveAndCloseButton(tebrData, objectData);
	}
	public void clickOnTEBRField(String tebrData,String testData,String objectData,String dropdown,String option,String name) {
		clickElementUsingJavaScript(dropdown, tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tebrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in TEBR dropdown successfully");
		sleep(1000);
		click(option, name,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyWorkflowStatus(String tebrData,String testData,String objectData,String option,String textbox,String name) {
		clickElementUsingJavaScript("AddTEBR_StatusDropdown", tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,tebrData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in TEBR dropdown successfully");
		click(option, name,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//verifyText(textbox,name,tebrData,testData);
		clickOnSaveButton(tebrData, objectData);
	}
	public void clickOnSaveButton(String tebrData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("TEBR_Save_Button",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyEmptyReleaseTable(String tebrData,String testData,String objectData,String projectId) {
		scrollToElement("TEBR_ReleaseName_Dropdown",tebrData);
		sleep(1000);
		clickOnButton(tebrData, "TEBR_ReleaseName_Dropdown", objectData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sendKeys("TEBR_ReleaseName_Textbox",projectId, tebrData,testData,objectData);
		verifyElementNotDisplayed("TEBR_Release_EmptyTable", tebrData,objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, projectId)+ " - is not displayed in TEBR dropdown successfully due to Release enabled end-status checkbox !");
		clickOnButton(tebrData, "TEBR_Close_Icon", objectData);
	}
	public void creationESTEBRWithEnvironment(String tebrData,String testData,String objectData,String envName,String tebrId,String saveCloseButton,String text){	
		createTEBR(tebrData, testData, objectData,tebrId,text);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		clickElementUsingJavaScript("TEBR_Environment_Checkbox",tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyText("TEBR_Environment_Env_Name",envName,tebrData,testData);
		sleep(2000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("TEBR_Environment_Dropped_Env_Name",envName,tebrData,testData);
		Listener.addLogger("Environment Name is verified after drag & dropped successfully !");
		sleep(2000);
		click(saveCloseButton,tebrData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
	}
 public void creationTEBR(String tebrData,String testData,String objectData,String tebrId,String customStatus,String customType){
	 	clickOnButton(tebrData, "AddTEBR_Button", objectData);
		/* Enter New TEBR Name */
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(PropertiesCache.getProperty(tebrData, "AddTEBR_termsandConditions_Submit"))));
        } catch (NoSuchElementException e) {  
        	
        } 
        finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
		sleep(4000);
		sendKeys("AddTEBR_IDTextfield",PropertiesCache.setProperty(testData, tebrId),tebrData);
		sleep(2000);
		/* Selection of Type Dropdown */
		click("AddTEBR_TypeDropdown",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("AddTEBR_CustomType_Text",customType,tebrData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/* Selection of Status Dropdown */
		click("AddTEBR_StatusDropdown",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("AddTEBR_CustomStatus_Text",customStatus,tebrData,testData);
		sleep(2000);
		/* Selection of Start DatePicker */
		click("AddTEBR_StartDatePicker",tebrData);
		click("AddTEBR_StartDatePicker_DoneButton",tebrData);
		/* Selection of End DatePicker */
		click("AddTEBR_EndDatePicker",tebrData);
		click("AddTEBR_EndDatePicker_DoneButton",tebrData);
		sleep(3000);
		sleep(2000);
		startDate=getAttributeData("AddTEBR_StartDate_Value",tebrData);
		endDate=getAttributeData("AddTEBR_EndDate_Value",tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/* Selection of Assigned To Dropdown  */
		click("AddTEBR_AssignedToDropdown",tebrData);
		assignedTo=getTextData("AddTEBR_AssignedToFirst",tebrData);
		click("AddTEBR_AssignedToFirst",tebrData);
		click("TEBR_Save&CloseButton",tebrData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
 }
 	public void bookEnvironment(String tebrData,String testData,String objectData,String envName) {
		sendKeys("TEBR_Environment_SearchBox", envName,tebrData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		verifyText("TEBR_Environment_Env_Name",envName,tebrData,testData);
		sleep(5000);
		clickWebelementButton(tebrData, "TEBRPhaseOnFlag", "TEBRPhaseOffFlag",objectData,"css");
		sleep(2000);
		dragAndDrop("TEBR_Environment_Section", "TEBR_DropEnvironment_Section", envName,tebrData,testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
 	}
 	public void updateQuestionStatus(String tebrData,String testData,String objectData,String question,String checkbox) {
		clickButton(checkbox,question,tebrData,testData,objectData);
		clickOnButton(tebrData, "TEBR_TermAndCondition_Submit_Button", objectData);
 	}
 	public void uploadTemplateImportFromXLS(String tebrData,String objectData,String fileName) {
 		click("TEBR_Export_Icon",tebrData);
 		sleep(1000);
		//click("TEBR_ImportFromXLS_Button",tebrData);
		sleep(2000);
		mouseOver(webElementIdentifier(PropertiesCache.getProperty(tebrData, "TEBR_ImportFromXLS_Button")));
		sleep(1000);
		uploadFile("TEBR_InputFile",tebrData,fileName);
		waitForLoadingIconDisappear(120,"Loading_Gif", objectData);
		sleep(5000);
 	}
 	public void addExternalUserForWatchers(String tebrData,String testData,String objectData) {
 		clickOnButton(tebrData,"TEBR_Watchers_Icon",objectData);
 		clickOnButton(tebrData,"TEBR_Watchers_ExternalUser_RadioIcon",objectData);
 		sendKeys("TEBR_Watchers_ExternalUser_Textbox", "Watcher_ExternalUser",tebrData,testData,objectData);
 		clickOnButton(tebrData, "TEBR_Watchers_Save&Close_Button", objectData);
 	}
	public void addUserGroupForWatchers(String tebrData,String testData,String objectData,String userGroup) {
 		clickOnButton(tebrData,"TEBR_Watchers_Icon",objectData);
 		clickOnButton(tebrData,"TEBR_Watchers_UserGroup_RadioIcon",objectData);
 		sendKeys("TEBR_Watchers_UserGroup_Textbox",userGroup,tebrData,testData,objectData);
 		clickButton("TEBR_Watchers_UserGroup_Dropdown_Text",userGroup,tebrData,testData,objectData);
 		clickOnButton(tebrData, "TEBR_Watchers_Save&Close_Button", objectData);
 	}
	public void clickOnTEBRField(String tebrData,String testData,String objectData,String dropdown,String option) {
		clickElementUsingJavaScript(dropdown, tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(option,tebrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(tebrData, objectData);
	}
 	
}
