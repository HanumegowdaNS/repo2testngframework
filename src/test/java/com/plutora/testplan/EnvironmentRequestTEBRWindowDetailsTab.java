package com.plutora.testplan;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

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
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestTEBRWindowDetailsTab {
	
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	SystemsPage systemsPage= new SystemsPage();
	EnvironmentGroupsPage environmentGroupPage= new EnvironmentGroupsPage();
	
	@Test (description=" 1.Add/edit/delete TEBR with release, 2. Releases bring down systems, environments, phases  3. Book/unbook environments via TEBR with release")
	public void subareaTEBRWindowDetailsTab_01() throws InterruptedException {	
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
		releasePage.createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id_2","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_2")+" - Environment is created successfully !");
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id","Systems_Test_Automation_Id","TEBR_Test_Automation_Id","");
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");	
		tebrPage.verifyText("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_Status_Name",TEBRPage.status, PlutoraConfiguration.tebrData);
		tebrPage.verifyText("TEBR_AssignedTo_Name",TEBRPage.assignedTo, PlutoraConfiguration.tebrData);
		//tebrPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_Release_Name","PRelease_Automation_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextContains("TEBR_Systems_Name","Systems_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger("TEBR with release is verified successfully !");
		tebrPage.updateTEBRWithReleaseEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id","Env_Test_Automation_Id_2");
		Listener.addLogger("TEBR with release is updated successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger("TEBR with release is deleted successfully !");
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_2");
		Listener.addLogger("Environment is deleted successfully !");
	}
	
	@Test (description=" 1.Add/edit/delete TEBR with environment  2. Book/unbook environments via TEBR with environment only (without release) ")
	public void subareaTEBRWindowDetailsTab_02() throws InterruptedException {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Env_Test_Automation_Id_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_2")+" - Environment is created successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		//tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		//tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		//Create TEBR
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_2","TEBR_Test_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR with environment is created successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");	
		tebrPage.verifyText("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyText("TEBR_Status_Name",TEBRPage.status, PlutoraConfiguration.tebrData);
		tebrPage.verifyText("TEBR_AssignedTo_Name",TEBRPage.assignedTo, PlutoraConfiguration.tebrData);
		tebrPage.verifyText("TEBR_Environment_Name","Env_Test_Automation_Id_2",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger("TEBR with environment is verified successfully !");
		tebrPage.updateTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.environmentData,"Env_Test_Automation_Id_2");
		tebrPage.verifyTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR with environment is updated successfully !");
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger("TEBR with environment is deleted successfully !");
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_2");
		Listener.addLogger("Environment is deleted successfully !");
	}
	
	@Test (description=" 1. Edit booking  2.Export (Print and Export to XLS)")
	public void subareaTEBRWindowDetailsTab_03() throws InterruptedException {
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id_2","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_2")+" - Environment created successfully !");
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id","Systems_Test_Automation_Id","TEBR_Test_Automation_Id","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR created successfully !");
		
		//tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Test_Automation_Id");
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");	
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.click("TEBR_Name","TEBR_Test_Automation_Id",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(1000);
		tebrPage.updateEditBooking(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_2");
		tebrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(4000);
		tebrPage.clickElementUsingJavaScript("TEBR_Export_Icon",PlutoraConfiguration.tebrData);
		tebrPage.sleep(1000);
		tebrPage.clickElementUsingJavaScript("TEBR_ExportToXLS_Button",PlutoraConfiguration.tebrData);
		tebrPage.sleep(3000);
		Listener.addLogger("TEBR details tab export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"TEBR");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Booking Request", 2);
		tebrPage.verifyTextValue("TEBR_Test_Automation_Id",data[1].trim(),PlutoraConfiguration.testData);
		data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Booking Request", 9);
		tebrPage.verifyTextValue(TEBRPage.status,data[1].trim());
		data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Booking Request", 10);
		tebrPage.verifyTextValue(TEBRPage.assignedTo,data[1].trim());
		data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Booking Request", 16);
	//	tebrPage.verifyTextValue("PRelease_Automation_Name",data[1].trim(),PlutoraConfiguration.testData);
		tebrPage.click("TEBR_Save&CloseButton",PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger("TEBR is deleted successfully !");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" -  TEBR details tab export to XLS is verified successfully!");
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_2");
		Listener.addLogger("Environment is deleted successfully !");
	}
	@Test (description="Add to Favorites ")
	public void subareaTEBRWindowDetailsTab_04() throws InterruptedException {
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");	
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR added to Favorites List successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR verified from Favorites List successfully !");
		
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR removed from Favorites List successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR verified from Favorites List after removal successfully !");
		
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");		
		
	}
	
	@Test (description="Availability status of Environments available for booking, TEBR with Release")
	public void subareaTEBRWindowDetailsTab_05() throws InterruptedException, ParseException {
		environmentGroupPage.refresh(PlutoraConfiguration.objectData);
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGroup_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGroup_Automation")+" - Environment group is created successfully !");
		tebrPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System is created successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Automation","EnvGroup_Automation","Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enviornment_Automation")+" - Environment is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Systems_Automation", "TEBR_Automation", "");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");	
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_ReleaseName_Dropdown",PlutoraConfiguration.objectData);
		tebrPage.sendKeys("TEBR_ReleaseName_Textbox", "Project_Automation", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.clickButton("TEBR_ReleaseName_Option","Project_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.verifyText("TEBR_ReleaseName_SystemName", "Systems_Automation", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		
		tebrPage.clickElementUsingJavaScript("TEBR_ReleaseName_AvailableFor_Dropdown",PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(2000);
		tebrPage.validateElementDisplayed("TEBR_ReleaseName_AvailableFor_Dropdown_Option",PlutoraConfiguration.tebrData);
		Listener.addLogger(tebrPage.getTextData("TEBR_ReleaseName_AvailableFor_Dropdown_Option", PlutoraConfiguration.tebrData)+ "Phases displayed successfully !");
		tebrPage.clickElementUsingJavaScript("TEBR_ReleaseName_AvailableFor_Dropdown_Option",PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("TEBR_Available_Status",PlutoraConfiguration.tebrData);
		Listener.addLogger(tebrPage.getTextData("TEBR_Available_Status", PlutoraConfiguration.tebrData)+ " status displayed successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Availability status of booked Environments (right grid), TEBR with Release")
	public void subareaTEBRWindowDetailsTab_06() throws InterruptedException, ParseException {
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.bookEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Automation");
		tebrPage.verifyText("TEBR_Environment_Dropped_Env_Name","Enviornment_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enviornment_Automation")+"Environment Name is verified after drag & dropped successfully !");
		tebrPage.sleep(2000);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		
		
	}
	@Test (description="Availability status of available/Booked Environments (right grid), TEBR without Release")
	public void subareaTEBRWindowDetailsTab_07() throws InterruptedException, ParseException {
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Automation","EnvGroup_Automation","Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enviornment_Automation")+" - Environment is created successfully !");
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enviornment_Automation", "TEBR_Automation", "");
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		//tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData,"QueryBuilder_TEBR_Dropdown");
		//tebrPage.clearGridColumnFiltering(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData,"TEBR_ActionButton");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		/*tebrPage.scrollToElement("TEBR_Environment_Checkbox",PlutoraConfiguration.tebrData);
		tebrPage.clickElementUsingJavaScript("TEBR_Environment_Checkbox",PlutoraConfiguration.tebrData);
		tebrPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);*/
		tebrPage.sleep(2000);
		//tebrPage.scrollToElement("TEBR_Environment_Dropped_Env_Name","Environment_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextContains("TEBR_Environment_Dropped_Env_Name","Enviornment_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enviornment_Automation")+" -  verified successfully!");
		tebrPage.validateElementDisplayed("TEBR_Environment_Available_Text","Enviornment_Automation", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(tebrPage.getTextData("TEBR_Environment_Available_Text","Enviornment_Automation", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData)+" -  verified successfully!");
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Audit")
	public void subareaTEBRWindowDetailsTab_09() throws InterruptedException {	
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.sendKeys("AddTEBR_IDTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "TEBR_Automation"),PlutoraConfiguration.tebrData);
		tebrPage.clickOnSaveButton(PlutoraConfiguration.tebrData,PlutoraConfiguration.objectData);
		//Modify
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		TEBRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
		TEBRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		TEBRPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox","Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tebrPage.verifyListText("TEBR_Audit_Summary", "TEBR_Automation", PlutoraConfiguration.tebrData, PlutoraConfiguration.testData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Added
		tebrPage.addComments(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments","TEBR_Comments_Tab");
		tebrPage.clickOnSaveButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox","Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tebrPage.verifyListText("TEBR_Audit_Comments", "TEBR_Comments", PlutoraConfiguration.tebrData, PlutoraConfiguration.testData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		tebrPage.deleteComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Comments_Tab");
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox","Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tebrPage.verifyListText("TEBR_Audit_Comments", "TEBR_Comments", PlutoraConfiguration.tebrData, PlutoraConfiguration.testData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox","Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*tebrPage.scrollToElement("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		tebrPage.scrollToElement("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		tebrPage.scrollToElement("Audit_Modified_Icon",  PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("Audit_Modified_Icon",  PlutoraConfiguration.objectData);*/
		
		//Live Search
		tebrPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "TEBR_Automation",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		tebrPage.validateElementDisplayed("TEBR_Audit_Summary", PlutoraConfiguration.tebrData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Environment Specific' area (questions with yes/no radiobuttons)\n" + 
			"(custom questions, create/edit/save TEBR when no questions)")
	public void subareaTEBRWindowDetailsTab_10() throws InterruptedException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormQuestion(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Form_Question");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRLandingCheckbox(PlutoraConfiguration.customizationData, "Customization_TEBR_Form_Landing_Enabled_Checkbox", "Customization_TEBR_Form_Landing_Disabled_Checkbox", PlutoraConfiguration.objectData);
		//Verify Question
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Icon", PlutoraConfiguration.objectData);
		tebrPage.verifyTextContains("TEBR_TermAndCondition_Question_Text", "TEBR_Form_Question",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question")+" verified successfully !");
		
		tebrPage.updateQuestionStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Form_Question","TEBR_TermAndCondition_Question_Yes_Checkbox");
		//Validate Yes checkbox
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Icon", PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("TEBR_TermAndCondition_Question_Yes_Checkbox_Checked","TEBR_Form_Question", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question")+" enabled 'Yes' checkbox successfully !");
		
		tebrPage.updateQuestionStatus(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TEBR_Form_Question","TEBR_TermAndCondition_Question_No_Checkbox");
		//Validate No Checkbox
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Icon", PlutoraConfiguration.objectData);
		tebrPage.validateElementDisplayed("TEBR_TermAndCondition_Question_No_Checkbox_Checked","TEBR_Form_Question", PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question")+" enabled 'No' checkbox successfully !");
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Submit_Button", PlutoraConfiguration.objectData);
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Update question name
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormEditQuestion(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Form_Question");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Icon", PlutoraConfiguration.objectData);
		tebrPage.verifyTextContains("TEBR_TermAndCondition_Question_Text", "TEBR_Form_Question",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question")+" verified after edition successfully !");
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Submit_Button", PlutoraConfiguration.objectData);
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Delete question 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRFormDeleteQuestion(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Form_Question");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Icon", PlutoraConfiguration.objectData);
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Form_Question")+" not displayed successfully !");
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_TermAndCondition_Submit_Button", PlutoraConfiguration.objectData);
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Disable TEBR landing page
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRLandingCheckbox(PlutoraConfiguration.customizationData, "Customization_TEBR_Form_Landing_Disabled_Checkbox", "Customization_TEBR_Form_Landing_Enabled_Checkbox", PlutoraConfiguration.objectData);
	}
	
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaTEBRWindowDetailsTab_11() throws InterruptedException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBR_Form_Option");
		customizationPage.updateTEBRLandingCheckbox(PlutoraConfiguration.customizationData, "Customization_TEBR_Form_Landing_Disabled_Checkbox", "Customization_TEBR_Form_Landing_Enabled_Checkbox", PlutoraConfiguration.objectData);
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.click("CopyURL_Icon",PlutoraConfiguration.objectData);
		tebrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		TEBRPage.launchUrl(dstData);
		tebrPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Details_Tab",PlutoraConfiguration.objectData);
		tebrPage.verifyTextAttributeValue("AddTEBR_IDTextfield", "TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" redirected to tebr details page after performing copy URL to clipboard for logged in session successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		TEBRPage.launchUrl(dstData);
		tebrPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		tebrPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		TEBRPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
	}
	@Test (description="Import from XLS")
	public void subareaTEBRWindowDetailsTab_12() throws InterruptedException, ParseException, IOException, AWTException {	
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData, "QueryBuilder_TEBR_Dropdown");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"Booking_Request_Template");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 2, 1, PropertiesCache.setProperty(PlutoraConfiguration.testData, "TEBR_Automation") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 3, 1, PropertiesCache.setProperty(PlutoraConfiguration.testData, "TEBR_Automation_Description") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 6, 1, tebrPage.getTodayDate("0", "dd/MM/yyyy hh:mm"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 7, 1, tebrPage.getTodayDate("0", "dd/MM/yyyy hh:mm"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 8, 1, PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 9, 1, PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 10, 1, PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_AssignedTo") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Booking Request", 12, 1, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation") );
		
		tebrPage.uploadTemplateImportFromXLS(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData,CommonConstants.imageFileName+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Template"));
		
		tebrPage.sleep(5000);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Details_Tab",PlutoraConfiguration.objectData);
		tebrPage.verifyTextAttributeValue("AddTEBR_IDTextfield", "TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextAttributeValue("TEBR_Type_Textbox", "TEBR_Type",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextAttributeValue("TEBR_Status_Textbox", "TEBR_Status",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.verifyTextAttributeValue("AddTEBR_AssignedTo_Textbox", "TEBR_AssignedTo",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation_Description")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type")+"<br>"+
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_AssignedTo"+"<br>"+ tebrPage.getTodayDate("0", "dd/MM/yyyy hh:mm"))+"<br>"+" -  Environment Request TEBR import to XLS is updated in excel successfully!");
		
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		
	}
	
	@Test (description="Show TEBR and booking on Env.Schedule")
	public void subareaTEBRWindowDetailsTab_13() throws InterruptedException, ParseException {	
		//Environment Group creation 
		new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		//Release Page
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Create System
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation","Systems_Automation");
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData, "QueryBuilder_TEBR_Dropdown");
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Systems_Automation", "TEBR_Automation", "");
		tebrPage.updateTEBRWithReleaseEnvironmentGroup(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation", "EnvGrp_Automation");
		tebrPage.updateTEBRWithReleaseEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation","Environment_Automation");
		
		tebrPage.updateTEBRWithEnvironmentGroup(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation", "TEBR_Automation", "","TEBR_Save&CloseButton");
		//tebrPage.updateTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "TEBR_Automation","TEBR_Save&CloseButton");
	
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.clickOnSaveButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		//Environment schedule
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Option",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		//Filter environment group 
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_TEBR_Type_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		//Verify TEBR in environment schedule 
		//environmentPage.verifyText("EnvironmentSchedule_TEBR_Name", "TEBR_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" displayed in environment schedule successfully !");
		//Delete TEBR
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
		
	}
	@Test (description="Watchers (Plutora and non-Plutora users to receive TEBR email notifications)")
	public void subareaTEBRWindowDetailsTab_14() throws InterruptedException, ParseException {	
		//External User
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Details_Tab", PlutoraConfiguration.objectData);
		tebrPage.addExternalUserForWatchers(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Customization_Email","Releases_UserGroup_Name","TEBRs","New comments added");
		customizationPage.updateWatchersEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tebrPage.addComments(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments","TEBR_Comments_Tab");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		//Verify in yopmail.com
		tebrPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		TEBRPage.launchUrl(PlutoraConfiguration.applicationURL);
		//tebrPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Watcher_ExternalUser"));
		TEBRPage.launchUrl(PlutoraConfiguration.applicationURL);
		
	}
	
	//@Test (description="Scheduler area: 'Assess My Environment Booking Conflicts\n" + 
		//	"with other Projects/Releases and TEBR'")
	public void subareaTEBRWindowDetailsTab_15() throws InterruptedException, ParseException {	
		TEBRPage.launchUrl(PlutoraConfiguration.applicationURL);
		//Environment Group creation 
		new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		//Release Page
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Create System
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation","Systems_Automation");
		
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData, "QueryBuilder_TEBR_Dropdown");
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Systems_Automation", "TEBR_Automation", "");
		tebrPage.updateTEBRWithReleaseEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation","Environment_Automation");

		tebrPage.clickOnButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);

		environmentPage.editMyEnvironmentBookingDate(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		
		tebrPage.verifyText("TEBR_Conflicts_ReleaseName", "Project_Automation_Name",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+"Scheduler area: 'Assess My Environment Booking Conflicts\\n\" + \n" + 
				"			\"with other Projects/Releases and TEBR dispalyed successfully ");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		
	}
	
	
}
