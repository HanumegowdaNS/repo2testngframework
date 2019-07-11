package com.plutora.testplan;


import java.awt.AWTException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestMyEnvironmentBookingTab {
	
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test (description="1. Change Status / Start Date / End Date / Env. or Env. Group  2.Status/Availability columns  3.Live Search")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_01() throws InterruptedException, AWTException, ParseException {	
		releasePage.refresh(PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" - Environment group is created successfully !");
		envGroupPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		String date;
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Env_MEB_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_MEB_Id")+" - Environment created successfully !");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Dropdown");
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "PRelease_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("MyEnvironmentBooking_Id_Text", "PRelease_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Name_Text", "PRelease_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("MyEnvironmentBooking_Environment_Name_Text", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_StartDate",environmentPage.getTextData("MyEnvironmentBooking_StartDate_Text", PlutoraConfiguration.environmentData));
		environmentPage.verifyText("MyEnvironmentBooking_StartDate_Text", "MEB_StartDate",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_EndDate",environmentPage.getTextData("MyEnvironmentBooking_EndDate_Text", PlutoraConfiguration.environmentData));
		environmentPage.verifyText("MyEnvironmentBooking_EndDate_Text", "MEB_EndDate",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_Phase_Name",environmentPage.getTextData("MyEnvironmentBooking_PhaseName_Text", PlutoraConfiguration.environmentData));
		environmentPage.verifyText("MyEnvironmentBooking_PhaseName_Text", "MEB_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_Status_Name",environmentPage.getTextData("MyEnvironmentBooking_Status_Text", PlutoraConfiguration.environmentData));
		environmentPage.verifyText("MyEnvironmentBooking_Status_Text", "MEB_Status_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(" My environment booking Status / Start Date / End Date / Env. or Env. Group & Status/Availability columns verified successfully !");
		
		environmentPage.click("MyEnvironmentBooking_Id_Text","PRelease_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_Status_Name",environmentPage.getTextData("MyEnvironmentBooking_Status_Checkbox_Name", PlutoraConfiguration.environmentData));
		environmentPage.sleep(2000);
		environmentPage.clickElementUsingJavaScript("MyEnvironmentBooking_Status_Checkbox",PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		environmentPage.click("MyEnvironmentBooking_EndDate_Calender_Icon",PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		date=new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "MEB_EndDate")));
		environmentPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getDate(date,"2"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_EndDate",environmentPage.getAttributeData("MyEnvironmentBooking_EndDate_Calender_Text", PlutoraConfiguration.environmentData));
		environmentPage.click("MyEnvironmentBooking_Date_Label",PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		environmentPage.click("MyEnvironmentBooking_StartDate_Calender_Icon",PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		date=new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(PropertiesCache.getProperty(PlutoraConfiguration.testData, "MEB_StartDate")));
		environmentPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getDate(date,"2"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.sleep(1000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "MEB_StartDate",environmentPage.getAttributeData("MyEnvironmentBooking_StartDate_Calender_Text", PlutoraConfiguration.environmentData));
		environmentPage.clickElementUsingJavaScript("MyEnvironmentBooking_Environment_Dropdown_Icon",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.clear("MyEnvironmentBooking_Environment_Textbox", PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		environmentPage.click("MyEnvironmentBooking_Environment_Dropdown_Icon",PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		environmentPage.sendKeys("MyEnvironmentBooking_Environment_Textbox","Env_MEB_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Environment_Dropdown_Option","Env_MEB_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(3000);
		environmentPage.click("MyEnvironmentBooking_Save&Close_Button",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("MyEnvironmentBooking_Id_Text", "PRelease_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Name_Text", "PRelease_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Environment_Name_Text", "Env_MEB_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("MyEnvironmentBooking_MyBooking_StartDate_Text", "MEB_StartDate",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("MyEnvironmentBooking_MyBooking_EndDate_Text", "MEB_EndDate",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_PhaseName_Text", "MEB_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		//environmentPage.verifyText("MyEnvironmentBooking_Status_Text", "MEB_Status_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(" My environment booking Status / Start Date / End Date / Env. or Env. Group & Status/Availability columns verified after updating with new values successfully !");
	}
	
	@Test (description=" Export to XLS")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_02() throws InterruptedException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(3000);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search","PRelease_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.clickElementUsingJavaScript("MyEnvironmentBooking_ActionButton",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickElementUsingJavaScript("MyEnvironmentBooking_ExportToXLS_Button",PlutoraConfiguration.environmentData);
		environmentPage.sleep(3000);
		Listener.addLogger("My Environment Booking export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"EnvironmentAllocationRequests");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Environment Bookings", 1);
		environmentPage.verifyTextValue("PRelease_Automation_Id",data[0].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("PRelease_Automation_Name",data[1].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("Env_MEB_Id",data[2].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextContainsValue("MEB_StartDate",data[4].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextContainsValue("MEB_EndDate",data[5].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("MEB_Phase_Name",data[6].trim(),PlutoraConfiguration.testData);
	//	environmentPage.verifyTextValue("MEB_Status_Name",data[9].trim(),PlutoraConfiguration.testData);
	//	environmentPage.verifyTextValue("Loggedin_Username_Value",data[10].trim(),PlutoraConfiguration.testData);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" -  My Booking environment export to XLS is verified successfully!");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_MEB_Id");
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		Listener.addLogger("Environment is deleted successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Project Release is deleted successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Enterprise Release is deleted successfully !");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("System is deleted successfully !");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		environmentPage.sleep(2000);
		new EnvironmentGroupsPage().deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		new EnvironmentGroupsPage().clickElementUsingJavaScript("ENVGroups_CloseButton", PlutoraConfiguration.environmentData);
		environmentPage.sleep(2000);
		Listener.addLogger("Environment group is deleted successfully !");
		
	}
	@Test (description="Show by My Environment Bookings")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_03() throws InterruptedException, ParseException {
		//System and approver
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.addApprovers(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Environment Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		environmentPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		//Environment
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","EnvGrp_Automation","Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		
		//Release Creation & link system 
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation", "Project_Bulk_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment 
		releasePage.linkEnvironmentToNonEnterpriseRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "Project_Tab");
		
		//On - Show my environment booking 
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text", "Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" displayed in My environment booking successfully !");
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text", "Project_Bulk_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_Name")+" displayed in My environment booking successfully !");
		//Off - Show my environment booking
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"  not displayed in My environment booking successfully !");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_Name")+" not displayed in My environment booking successfully !");
		
	}
	@Test (description="Query Builder (QB) + Quick Access menu")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_04() throws InterruptedException, ParseException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Dropdown");
		environmentPage.sendKeys("MyEnvironmentBooking_Search", "",PlutoraConfiguration.environmentData);
		environmentPage.enter();
		//Add new public query
		environmentPage.clickNewQueryBuilder(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Icon");
		environmentPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID", "equals", "Project_Bulk_Automation","1");
		environmentPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "MyEnvironmentBooking_Id_Text")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clear("MyEnvironmentBooking_Search", PlutoraConfiguration.environmentData);
		environmentPage.enter();
		environmentPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Query_Public_Builder","QueryBuilder_MyBooking_Dropdown");
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Project_Bulk_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Status",releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		environmentPage.clickNewQueryBuilder(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Icon");
		//Condition 1
		environmentPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status"),"1","1");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		environmentPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		environmentPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID", "equals", "Project_Bulk_Automation","2");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		environmentPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		environmentPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release Name", "equals", "Project_Bulk_Automation_Name","3");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		environmentPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		environmentPage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Start Date", "on","4");
		environmentPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//Release Name
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text","Project_Bulk_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text","Release_Status",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextContains("MyEnvironmentBooking_Field_Text",environmentPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_Name")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+"<br>"+
				environmentPage.getTodayDate("0", "dd/MM/yyyy")+"<br>"+
				"verified private query builder successfully !");
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify environment in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,10,0);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
	}
	@Test (description="Metrics")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_05() throws InterruptedException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Dropdown");
		//Get metrix chart
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_HideIcon","Metrics_ViewIcon", PlutoraConfiguration.objectData,"xpath");
		//Verify metrics 
		environmentPage.verifyText("EnvironmentRequest_Metrics_RequestAction","Environment_Requests_Actioned_Text",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("EnvironmentRequest_Metrics_OutstandingRequests","Environment_Outstanding_Requests_Text",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.validateElementDisplayed("EnvironmentRequest_Metrics_RequestAction_Graph", PlutoraConfiguration.environmentData);
		environmentPage.validateElementDisplayed("EnvironmentRequest_Metrics_OutstandingRequests_Graph", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment Request grid metrics verified successfully!");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_ViewIcon","Metrics_HideIcon", PlutoraConfiguration.objectData,"xpath");
	}
	@Test (description="Action -> Bulk Update")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_06() throws InterruptedException, ParseException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		//System and approver
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_One");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_One");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_One");
		systemsPage.addApprovers(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Environment Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_One");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_One")+" - Environment group is created successfully !");
		environmentPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		//Environment
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_One","EnvGrp_Automation_One","Systems_Automation_One");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_One")+" - Environment is created successfully !");
		
		//Release Creation & link system 
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation_One", "Project_Bulk_Automation_Name_One", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation_One");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation_One");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_One","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment 
		releasePage.linkEnvironmentToNonEnterpriseRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_One", "Project_Tab");
		//Search bulk update key
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Dropdown");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search","Project_Bulk",PlutoraConfiguration.environmentData);
		
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation" ,PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation_One" , PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		//Rejected status 
		environmentPage.updateBulkUpdate(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Rejected");
		//Verify rejected status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Rejected']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Rejected"+" "+"Displayed successfully !");
		
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+"')]/ancestor::tr/td/div[text()='Rejected']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+" Status "+"Rejected"+" "+"Displayed successfully !");
		
		//Approved status
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation" ,PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation_One" , PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		
		environmentPage.updateBulkUpdate(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Approved");
		//Verify approved status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Approved']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Approved"+" "+"Displayed successfully !");
		
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+"')]/ancestor::tr/td/div[text()='Approved']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+" Status "+"Approved"+" "+"Displayed successfully !");
		
		//Pending status
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation" ,PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Field_Checkbox","Project_Bulk_Automation_One" , PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.updateBulkUpdate(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Pending");
		//Verify pending status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Pending']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Pending"+" "+"Displayed successfully !");
		
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+"')]/ancestor::tr/td/div[text()='Pending']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation_One")+" Status "+"Pending"+" "+"Displayed successfully !");
	}
	@Test (description="Action -> Duplicate Request (should be disabled)")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_07() throws InterruptedException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_MyBooking_Dropdown");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_ActionButton", PlutoraConfiguration.objectData);
		environmentPage.verifyTextEqualsNotDisplayedInPage("Duplicate Request");
		Listener.addLogger("Duplicate Request - Action - Not displayed in My enviornment booking successfully !");
	}
	@Test (description="Column 'Status' behavior")
	public void subareaEnvironmentRequestMyEnvironmentBookingTab_08() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(4000);
		environmentPage.doubleClick("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		//Pending
		environmentPage.editMyEnvironmentBookingStatus(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Pending");
		
		//Verify pending status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Pending']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Pending"+" "+"Displayed successfully !");
		
		//Approved
		environmentPage.doubleClick("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.editMyEnvironmentBookingStatus(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Approved");
		
		//Verify approved status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Approved']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Approved"+" "+"Displayed successfully !");
		
		//Rejected
		environmentPage.doubleClick("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.click("MyEnvironmentBooking_Tab_Field_Text","Project_Bulk_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.editMyEnvironmentBookingStatus(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Rejected");
		
		//Verify rejected status
		EnvironmentPage.driver.findElement(By.xpath("//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+"')]/ancestor::tr/td/div[text()='Rejected']")).isDisplayed();
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" Status "+"Rejected"+" "+"Displayed successfully !");
		
		
		
	}
}
