package com.plutora.testplan;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class EnvironmentRequestTECRTabGrid {
	
	TECRPage tecrPage = new TECRPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	boolean flag=false;
	
	
	@Test (description="Live Search")
	public void subareaEnvironmentRequestTECRTabGrid_01() throws InterruptedException {	
		WebGenericUtilLib.driver.navigate().refresh();
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation","PRelease_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" - TECR with release is created successfully !");
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.click("AddTECR_Tab",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.sendKeys("TECR_SearchButton","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.verifyText("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Requestor_Name","Loggedin_Username_Value",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" -  TECR Tab Live Search is verified successfully!");
	}
	
	@Test (description="Export to XLS")
	public void subareaEnvironmentRequestTECRTabGrid_02() throws InterruptedException {	
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.sendKeys("TECR_SearchButton","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.sleep(4000);
		tecrPage.clickElementUsingJavaScript("TECR_ActionButton",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("TECR_ExportToXLS_Button",PlutoraConfiguration.tecrData);
		tecrPage.sleep(3000);
		Listener.addLogger("TECR Tab grid export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Environment");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Environment Change Requests", 1);
		tecrPage.verifyTextValue("TECR_Automation",data[1].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("TECR_Type",data[2].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("TECR_AssignedTo",data[3].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("Env_Test_Automation_Id",data[7].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("Release_Test_Automation_Id",data[11].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("PRelease_Automation_Id",data[12].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("PRelease_Automation_Name",data[13].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("TECR_Status",data[14].trim(),PlutoraConfiguration.testData);
		tecrPage.verifyTextValue("Loggedin_Username_Value",data[18],PlutoraConfiguration.testData);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" -  TECR Tab grid export to XLS is verified successfully!");
	}
	
	@Test (description="Action -> Duplicate Request")
	public void subareaEnvironmentRequestTECRTabGrid_03() throws InterruptedException, ParseException {	
		
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.createDuplicateTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyText("Confirmation_Message","New_TECR_Duplicate_Confirmation_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		tecrPage.enterNewlyCreatedDuplicateTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.verifyText("TECR_Name","Copy_TECR_Automation", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" Duplicate TECR is Created & Verified successfully !");
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		
	}
	@Test (description="TECR Query Builder (QB) + Quick Access menu")
	public void subareaEnvironmentRequestTECRTabGrid_04() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Query_Automation");
		//Add grid selector
		tecrPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TECR_CustomField_Name","Action_Button");
		
		//Add new public query
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		tecrPage.sendKeys("TECR_SearchButton","", PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		tecrPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR Title", "equals", "TECR_Query_Automation","1");
		tecrPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		tecrPage.verifyText("TECR_Name","TECR_Query_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Query_Automation")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		tecrPage.sleep(2000);
		tecrPage.clear("TECR_SearchButton", PlutoraConfiguration.tecrData);
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Query_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Query_Automation")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		
		tecrPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		//Condition 1
		tecrPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status"),"1","1");
		tecrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		tecrPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		tecrPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR Title", "equals", "TECR_Query_Automation","2");
		tecrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		tecrPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		tecrPage.sleep(1000);
		tecrPage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"), "on","3");
		tecrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		tecrPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		tecrPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Type", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type"),"4","4");
		tecrPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//TECR Name
		tecrPage.verifyText("TECR_Name","TECR_Query_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Field_Text","TECR_Type",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Field_Text","TECR_Status",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyTextContains("TECR_CustomFieldGrid_Text",tecrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tecrData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Query_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type")+"<br>"+
				tecrPage.getTodayDate("0", "dd/MM/yyyy")+"<br>"+
				"verified private query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	//	tecrPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Dropdown", PlutoraConfiguration.objectData);
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Delete public and private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		tecrPage.deletePublicQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Public_Builder");
		tecrPage.deletePrivateQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Private_Builder");
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Close_Button", PlutoraConfiguration.objectData);
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
	}

	
	
	@Test (description="Action -> Grid Column Selector (GCS)")
	public void subareaEnvironmentRequestTECRTabGrid_07() throws InterruptedException {	
		//Create custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRCustomFields_Option","TECR_CustomField_Name");
		
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		tecrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		//Add grid selector
		tecrPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TECR_CustomField_Name","Action_Button");
		//Verify grid selector
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name")+" verified in release grid successfully !");
		//Clear grid selector
		tecrPage.clearGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
		//Verify grid selector not available
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name").toUpperCase());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_CustomField_Name").toUpperCase()+" not displayed in release grid successfully !");
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_CustomField_Name");
	}
	@Test(description="Action -> Grid Column Filtering")
	public void subareaEnvironmentRequestTECRTabGrid_05() throws InterruptedException, ParseException {	
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.sendKeys("TECR_SearchButton","",PlutoraConfiguration.tecrData);
		tecrPage.enter();
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Grid_Title_Textbox","TECR_Query_Automation");
		tecrPage.enter();
		tecrPage.verifyText("TECR_Name", "TECR_Query_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Query_Automation")+" verified in grid successfully !");
		
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_AssignedTo_Dropdown",PlutoraConfiguration.objectData);
		tecrPage.clickButton("TECR_Grid_AssignedTo_Dropdown_Option", "TECR_AssignedTo", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_AssignedTo_Dropdown",PlutoraConfiguration.objectData);
		tecrPage.verifyText("TECR_Grid_Text", "TECR_AssignedTo",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_AssignedTo")+" verified in grid successfully !");
		
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_StartDate_Calendar",PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DatePicker_Today_Button", PlutoraConfiguration.objectData);
		tecrPage.verifyTextContains("TECR_Grid_Text",tecrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tecrData);
		Listener.addLogger(tecrPage.getTodayDate("0", "dd/MM/yyyy")+" verified start date in grid successfully !");
		
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_EndDate_Calendar",PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DatePicker_Today_Button", PlutoraConfiguration.objectData);
		tecrPage.verifyTextContains("TECR_Grid_Text",tecrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tecrData);
		Listener.addLogger(tecrPage.getTodayDate("0", "dd/MM/yyyy")+" verified end date in grid successfully !");
		
	//	tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_Status_Dropdown",PlutoraConfiguration.objectData);
	//	tecrPage.clickButton("TECR_Grid_Status_Dropdown_Option", "TECR_Status", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	//	tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Grid_Status_Dropdown",PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status")+" verified in grid successfully !");
		
		
	}
	
	@Test(description="Action -> Clear Grid Column Filtering")
	public void subareaEnvironmentRequestTECRTabGrid_06() throws InterruptedException {	
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		
		tecrPage.verifyTextAttributeValue("TECR_Grid_Title_Textbox", "",PlutoraConfiguration.tecrData);
		Listener.addLogger("TECR title cleared from TECR grid successfully !");
		
		tecrPage.verifyTextAttributeValue("TECR_Grid_AssignedTo_Textbox", "",PlutoraConfiguration.tecrData);
		Listener.addLogger("Assigned cleared from TECR grid successfully !");
		
		tecrPage.verifyTextAttributeValue("TECR_Grid_StartDate_Textbox", "",PlutoraConfiguration.tecrData);
		Listener.addLogger("Start Date cleared from TECR grid successfully !");
		
		tecrPage.verifyTextAttributeValue("TECR_Grid_EndDate_Textbox", "",PlutoraConfiguration.tecrData);
		Listener.addLogger("End Date cleared from TECR grid successfully !");
		
		//tecrPage.verifyTextAttributeValue("TECR_Grid_Status_Textbox", "",PlutoraConfiguration.tecrData);
		Listener.addLogger("Status cleared from TECR grid successfully !");
		
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Query_Automation");
	}
	
	@Test (description="Action -> Bulk Update")
	public void subareaEnvironmentRequestTECRTabGrid_08() throws InterruptedException, ParseException {	
		
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_BulkUpdate_One");
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_BulkUpdate_Two");
		tecrPage.clear("TECR_SearchButton", PlutoraConfiguration.tecrData);
		tecrPage.sendKeys("TECR_SearchButton","BulkUpdate",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear(500,"Loading_Gif", PlutoraConfiguration.objectData);
		tecrPage.sleep(4000);
		//Bulk Update
		tecrPage.bulkUpdate(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_BulkUpdate_One", "TECR_BulkUpdate_Two");
		
		//Verify Type
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Type")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Type")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Type")+" dispalyed successfully !");
		
		//Verify Assignee
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Assignee")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Assignee")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Assignee")+" dispalyed successfully !");
		
		//Verify StartDate
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+tecrPage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+tecrPage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ tecrPage.getTodayDate("2", "dd/MM/yyyy")+" dispalyed successfully !");
		
		//Verify End Date
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+tecrPage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+tecrPage.getTodayDate("4", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ tecrPage.getTodayDate("4", "dd/MM/yyyy")+" dispalyed successfully !");
		
		
		//Verify status
	//flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Status")+"')]")).isDisplayed();
	//	assertTrue(flag);
	//	flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Status")+"')]")).isDisplayed();
	//	assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Status")+" dispalyed successfully !");
		
		//Verify Outage
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Outage")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Outage")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_One")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_BulkUpdate_Two")+" - "+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Bulk_Outage")+" dispalyed successfully !");
		
		
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_BulkUpdate_One");
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_BulkUpdate_Two");
	}
	
	
}
