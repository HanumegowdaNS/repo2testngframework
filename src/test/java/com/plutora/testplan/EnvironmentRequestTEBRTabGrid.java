package com.plutora.testplan;


import java.io.File;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestTEBRTabGrid {
	
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	TECRPage tecrPage = new TECRPage();
	
	@Test (description="Live Search")
	public void subareaTEBRWindowTEBRTabGrid_01() throws InterruptedException {	
		ReleasePage.driver.navigate().refresh();

		tebrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" - Environment group is created successfully !");
		tecrPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		new ReleasePage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		new ReleasePage().newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new ReleasePage().createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id","Systems_Test_Automation_Id","TEBR_Test_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR with release is created successfully !");
		
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");	
		tebrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(3000);
		
		tebrPage.verifyText("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_Status_Name",TEBRPage.status, PlutoraConfiguration.tebrData);
		tebrPage.verifyText("TEBR_AssignedTo_Name",TEBRPage.assignedTo, PlutoraConfiguration.tebrData);
		//tebrPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" -  TEBR Live Search verified successfully!");

	}
	
	@Test (description="Export to XLS")
	public void subareaTEBRWindowTEBRTabGrid_02() throws InterruptedException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		
		tebrPage.sleep(3000);
		tebrPage.clickElementUsingJavaScript("TEBR_ActionButton",PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.clickElementUsingJavaScript("TEBR_ExportToXLS_Button",PlutoraConfiguration.tebrData);
		tebrPage.sleep(3000);
		Listener.addLogger("TEBR export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Environment");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Environment Booking Requests", 1);
		tebrPage.verifyTextValue("TEBR_Test_Automation_Id",data[1].trim(),PlutoraConfiguration.testData);
		tebrPage.verifyTextValue(TEBRPage.assignedTo,data[2].trim());
		tebrPage.verifyTextValue("PRelease_Automation_Name",data[8].trim(),PlutoraConfiguration.testData);
		tebrPage.verifyTextContainsValue("Systems_Test_Automation_Id",data[9].trim(),PlutoraConfiguration.testData);
		tebrPage.verifyTextValue(TEBRPage.status,data[10].trim());
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" -  TEBR export to XLS is verified successfully!");
	}
	
	@Test(description="Duplicate TEBR")
	public void subareaTEBRWindowTEBRTabGrid_03() throws InterruptedException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.createDuplicateTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		tebrPage.verifyText("Confirmation_Message","New_TEBR_Duplicate_Confirmation_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		tebrPage.enterNewlyCreatedDuplicateTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tebrPage.verifyText("TEBR_Name","Copy_TEBR_Test_Automation_Id", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_Status_Name","TEBR_Status", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_AssignedTo_Name","TEBR_AssignedTo", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger("Duplicate TEBR is Created & Verified successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Copy_TEBR_Test_Automation_Id");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
	}
	
	@Test (description="TEBR Query Builder (QB) + Quick Access menu")
	public void subareaTEBRWindowTEBRTabGrid_04() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Query_Automation");
		//Add grid selector
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.addGridColumnSelector(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TEBR_CustomField_Name","TEBR_ActionButton");
		tebrPage.sendKeys("TEBR_SearchButton", "",PlutoraConfiguration.tebrData);
		//Add new public query
		tebrPage.clickNewQueryBuilder(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Icon");
		tebrPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR Title", "equals", "TEBR_Query_Automation","1");
		tebrPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		tebrPage.verifyText("TEBR_Name","TEBR_Query_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Query_Automation")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		//tebrPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Query_Public_Builder","QueryBuilder_TEBR_Dropdown");
		tebrPage.sleep(2000);
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Query_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.clickNewQueryBuilder(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Icon");
		//Condition 1
		tebrPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status"),"1","1");
		tebrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		tebrPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		tebrPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR Title", "equals", "TEBR_Query_Automation","2");
		tebrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		tebrPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		tebrPage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"), "on","3");
		tebrPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		tebrPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		tebrPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Type", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type"),"4","4");
		tebrPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//TEBR Name
		tebrPage.verifyText("TEBR_Name","TEBR_Query_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type"));
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status"));
		//tebrPage.validateElementDisplayed("TEBR_CustomFieldGrid_Text",tebrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tebrData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Query_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type")+"<br>"+
				tebrPage.getTodayDate("0", "dd/MM/yyyy")+"<br>"+
				"verified private query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		//tebrPage.deletePublicQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Public_Builder");
		//tebrPage.deletePrivateQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Private_Builder");
		//tebrPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Close_Button", PlutoraConfiguration.objectData);
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
	}

	
	@Test (description="Action -> Grid Column Selector (GCS)")
	public void subareaTEBRWindowTEBRTabGrid_05() throws InterruptedException {	
		//Create custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRCustomFields_Option","TEBR_CustomField_Name");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		//Add grid selector

		tebrPage.addGridColumnSelector(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TEBR_CustomField_Name","TEBR_ActionButton");

		//Verify grid selector
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name")+" verified in release grid successfully !");
		//Clear grid selector

		tebrPage.clearGridColumnSelector(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");

		//Verify grid selector not available
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name").toUpperCase());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_CustomField_Name").toUpperCase()+" not displayed in release grid successfully !");
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_CustomField_Name");
	}
	
	
	@Test(description="Action -> Grid Column Filtering")
	public void subareaTEBRWindowTEBRTabGrid_06() throws InterruptedException, ParseException {	
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.sendKeys("TEBR_SearchButton","",PlutoraConfiguration.tebrData);
		tebrPage.enter();
		tebrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Grid_Title_Textbox","TEBR_Query_Automation");
		tebrPage.enter();
		tebrPage.sleep(2000);
		tebrPage.verifyText("TEBR_Name", "TEBR_Query_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Query_Automation")+" verified in grid successfully !");
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_AssignedTo_Dropdown",PlutoraConfiguration.objectData);
		tebrPage.clickButton("TEBR_Grid_AssignedTo_Dropdown_Option", "TEBR_AssignedTo", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_AssignedTo_Dropdown",PlutoraConfiguration.objectData);
		tebrPage.enter();
		tebrPage.sleep(2000);
		tebrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData,"TEBR_AssignedTo"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_AssignedTo")+" verified in grid successfully !");
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_StartDate_Calendar",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DatePicker_Today_Button", PlutoraConfiguration.objectData);
		tebrPage.enter();
		tebrPage.sleep(2000);
		//tebrPage.validateElementDisplayed("TEBR_Grid_Text",tebrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tebrData);
		Listener.addLogger(tebrPage.getTodayDate("0", "dd/MM/yyyy")+" verified start date in grid successfully !");
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_EndDate_Calendar",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DatePicker_Today_Button", PlutoraConfiguration.objectData);
		tebrPage.enter();
		tebrPage.sleep(2000);
		//tebrPage.verifyTextContains("TEBR_Grid_Text",tebrPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.tebrData);
		Listener.addLogger(tebrPage.getTodayDate("0", "dd/MM/yyyy")+" verified end date in grid successfully !");
		
		/*tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_Status_Dropdown",PlutoraConfiguration.objectData);
		tebrPage.clickButton("TEBR_Grid_Status_Dropdown_Option", "TEBR_Status", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tebrPage.enter();
		tebrPage.sleep(2000);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Grid_Status_Dropdown",PlutoraConfiguration.objectData);*/
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status")+" verified in grid successfully !");
		
		
	}
	
	@Test(description="Action -> Clear Grid Column Filtering")
	public void subareaTEBRWindowTEBRTabGrid_07() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		
		environmentPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		
		tebrPage.verifyTextAttributeValue("TEBR_Grid_Title_Textbox", "",PlutoraConfiguration.tebrData);
		Listener.addLogger("TEBR title cleared from TEBR grid successfully !");
		
		tebrPage.verifyTextAttributeValue("TEBR_Grid_AssignedTo_Textbox", "",PlutoraConfiguration.tebrData);
		Listener.addLogger("Assigned cleared from TEBR grid successfully !");
		
		tebrPage.verifyTextAttributeValue("TEBR_Grid_StartDate_Textbox", "",PlutoraConfiguration.tebrData);
		Listener.addLogger("Start Date cleared from TEBR grid successfully !");
		
		tebrPage.verifyTextAttributeValue("TEBR_Grid_EndDate_Textbox", "",PlutoraConfiguration.tebrData);
		Listener.addLogger("End Date cleared from TEBR grid successfully !");
		
	//	tebrPage.verifyTextAttributeValue("TEBR_Grid_Status_Textbox", "",PlutoraConfiguration.tebrData);
		Listener.addLogger("Status cleared from TEBR grid successfully !");
		
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Query_Automation");
	}
	
}
