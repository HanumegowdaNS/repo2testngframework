package com.plutora.testplan;

import java.awt.AWTException;
import java.io.File;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentImpactMatrixPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentImpactMatrix {
	ReleasePage releasePage = new ReleasePage();
	EnvironmentImpactMatrixPage environmentImpactMatrixPage = new EnvironmentImpactMatrixPage();
	EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test (description=" -> Live Search")
	public void environmentImpactMatrix_01() throws InterruptedException, ParseException, AWTException {
		//System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		//Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EnvGrp_Test_Automation_Id","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		//Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Phase_Name",releasePage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"), "data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Environment Impact Matrix
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_EG_OFF_Icon", "EnvironmentImpactMatrix_EG_ON_Icon", PlutoraConfiguration.objectData, "css");
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		//Verification
		environmentImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in environment impact matrix page");
		environmentImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" is displayed in environment impact matrix page");
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_Live_Search_CloseIcon", PlutoraConfiguration.objectData);
		
		environmentImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in environment impact matrix page after clicking Live search close Icon");
		environmentImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" is displayed in environment impact matrix page after clicking Live search close Icon");
	}
	
	@Test (description=" -> Export to XLS")
	public void environmentImpactMatrix_02() throws InterruptedException  {
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_ExportToXLS_Button", PlutoraConfiguration.objectData);
		Listener.addLogger("Environment Impact Matrix export to XLS is downloaded successfully!");
		releasePage.sleep(3000);
		//Excel Verification
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Impact Matrix");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Matrix", 1);
		environmentImpactMatrixPage.verifyTextValue("Project_Automation",data[1].trim(),PlutoraConfiguration.testData);
		environmentImpactMatrixPage.verifyTextValue("Project_Automation_Name",data[2].trim(),PlutoraConfiguration.testData);
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Allocation").substring(0, 1),data[3].trim());
		environmentImpactMatrixPage.verifyTextValue("1",data[4].trim());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" - Export to XLS is verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
	}
	
	
	@Test (description=" -> Entity popup window (data appearance, hyperlink)")
	public void environmentImpactMatrix_03() throws InterruptedException, ParseException, AWTException  {
		
		//Enterprise Creation , Link System , Link Environment & Env Group
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.searchEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully to environment section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Enterprise_Phase_Name",releasePage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"), "data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Independent Creation , Link System , Link Environment & Env Group
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation", "Independent_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Independent_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully to environment section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Independent_Phase_Name",releasePage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"), "data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		Listener.addLogger("Environment Impact Matrix - Selected Environment option");
		//Project Search - environment impact matrix - verification of View/Edit my environment booking 
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.clickWebElementButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_Enterprise_CheckboxChecked", "EnvironmentImpactMatrix_Enterprise_Checkbox", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.clickWebElementButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_Independent_CheckboxChecked", "EnvironmentImpactMatrix_Independent_Checkbox", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.clickWebElementButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_Project_CheckboxChecked", "EnvironmentImpactMatrix_Project_Checkbox", PlutoraConfiguration.objectData);
		
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		//Validate Envioronment Booking details
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Phase_Name")+" is displayed in view/edit environment booking page");
		String envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		String date=environmentImpactMatrixPage.getTodayDate("0", "dd/MM/yyyy");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		
		//Enterprise Search - environment impact matrix - verification of View/Edit my environment booking 
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Enterprise_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);

		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Phase_Name")+" is displayed in view/edit environment booking page");
		envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		
		//Independent Search - environment impact matrix - verification of View/Edit my environment booking 
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Independent_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(200,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.doubleClick("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Phase_Name")+" is displayed in view/edit environment booking page");
		envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		//EG
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentImpactMatrixData, "EnvironmentImpactMatrix_EG_ON_Icon", "EnvironmentImpactMatrix_EG_OFF_Icon", PlutoraConfiguration.objectData, "css");
		Listener.addLogger("Environment Impact Matrix - Selected Environment group option");
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Project_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Phase_Name")+" is displayed in view/edit environment booking page");
		envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		
		date=environmentImpactMatrixPage.getTodayDate("0", "dd/MM/yyyy");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		//Enterprise
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Enterprise_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
	
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Enterprise_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Phase_Name")+" is displayed in view/edit environment booking page");
		envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		//Independent 
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield", "Independent_Automation",PlutoraConfiguration.environmentImpactMatrixData,PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(200,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Impacted_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_Total_Column_Releases_Count", "1",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger("EnvironmentImpactMatrix_Total_Impacted_Count , EnvironmentImpactMatrix_Total_Releases_Count and EnvironmentImpactMatrix_Total_Column_Releases_Count is displayed in environment impact matrix page");
		
		environmentImpactMatrixPage.mouseOver("EnvironmentImpactMatrix_TopImpact_Text", "", PlutoraConfiguration.environmentImpactMatrixData, "");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_TopImpact_Text",PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
	
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation_Name")+" is displayed in view/edit environment booking page");
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_Release_Text", "Independent_Phase_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Phase_Name")+" is displayed in view/edit environment booking page");
		envID=environmentImpactMatrixPage.getAttributeData("ViewMyEnvironmentBooking_Environment_Name",PlutoraConfiguration.environmentData).split(":")[1];
		environmentImpactMatrixPage.verifyTextValue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id"), envID);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" is displayed in view/edit environment booking page");
		
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseStartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextContains("ViewMyEnvironmentBooking_PhaseEndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_StartDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextAttributeValueContains("ViewMyEnvironmentBooking_EndDate",date,PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Delete");
		environmentImpactMatrixPage.verifyTextDisplayedInPage("Status");
		Listener.addLogger("ViewMyEnvironmentBooking_PhaseStartDate , ViewMyEnvironmentBooking_PhaseEndDate, ViewMyEnvironmentBooking_StartDate , ViewMyEnvironmentBooking_EndDate , Delete and status is displayed in environment booking page");
		
		environmentImpactMatrixPage.clickElementUsingJavaScript("ViewMyEnvironmentBooking_Status_Checkbox","Approved", PlutoraConfiguration.environmentData);
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyText("EnvironmentImpactMatrix_TopImpact_Text", "A",PlutoraConfiguration.environmentImpactMatrixData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" Environment Booking status moved from Pending to Approved Successfully !");
		//Project Deletion
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is deleted successfully !");
		
		//Enterprise Deletion
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.click("Release_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" is deleted successfully !");
		
		//Independent Deletion
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.click("Independent_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Independent_Automation")+" is deleted successfully !");
		
		//System Deletion
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" is deleted successfully !");
		
		//Delete Environment Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		envGroupPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment Group is deleted successfully");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		//Delete Environment
		/*environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is deleted successfully !");*/
	}
	
	@Test(description = "View Ful Screen")
	public void environmentImpactMatrix_04() throws InterruptedException, AWTException {
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.getCoordinates("EnvironmentImpactMatrix_ReleaseID_Label",
				PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData, "x_cord_1", "y_cord_1");
		environmentImpactMatrixPage.sleep(4000);
		environmentImpactMatrixPage.click("EnvironmentImpactMatrix_ViewFullScreen_Button",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(2000);
		environmentImpactMatrixPage.getCoordinates("EnvironmentImpactMatrix_ReleaseID_Label",
				PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData, "x_cord_2", "y_cord_2");
		environmentImpactMatrixPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "y_cord_1"))) > (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "y_cord_2"))));
		environmentImpactMatrixPage.escape();
		environmentImpactMatrixPage.sleep(2000);
	}

	@Test(description = "Print")
	public void environmentImpactMatrix_05() throws InterruptedException, ParseException, AWTException {
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_Print_Button",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(5000);
		environmentImpactMatrixPage.switchToWindow(4000, "parent_window");
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ReleaseID_Label",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.closeWindowTab();
		environmentImpactMatrixPage.driver.switchTo()
				.window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parent_window"));
	}
	
	@Test(description = "Filter by (right top corner)")
	public void environmentImpactMatrix_06() throws InterruptedException, ParseException, AWTException {
		// System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " - System is created successfully !");
		// Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")
				+ " - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_Save&CloseButton",
				PlutoraConfiguration.objectData);
		// Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id", "EnvGrp_Test_Automation_Id",
				"Systems_Test_Automation_Id");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")
				+ " - Environment is created successfully !");
		// Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		// link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Env_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Phase_Name",
				releasePage.getAttributeValue(
						PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"),
						"data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",
				releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);

		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		// Verification
		environmentImpactMatrixPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page");
		// Click on My Portfolio Association
		environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_MyPortFolioAssociation_Button",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ProjectName_Link",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on clicking My Portfolio Association");

		// Click on I'm a Stakeholder
		environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_IamStakeholder_Button",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on I'm a Stakeholder");
		// Click on All
		environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_All_Button",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ProjectName_Link",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on ");
		
	}
	
	@Test(description = "Show by Environment Group")
	public void environmentImpactMatrix_07() throws InterruptedException, ParseException, AWTException {
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		if (environmentImpactMatrixPage.isElementNotDisplayed("//a[contains(@class,'x-btn customisation-notification') and not(contains(@class,'x-btn-pressed'))]")) {
			environmentImpactMatrixPage.clickElementUsingJavaScript(
					"EnvironmentImpactMatrix_ShowByEnvGroup_RadioButtonOff",
					PlutoraConfiguration.environmentImpactMatrixData);
			environmentImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		}
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_EnvName_Label",
				PlutoraConfiguration.environmentImpactMatrixData);
	}
	
	@Test(description = "'Total' counting in the matrix")
	public void environmentImpactMatrix_08() throws InterruptedException, ParseException, AWTException {
		// System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " - System is created successfully !");
		// Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")
				+ " - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_Save&CloseButton",
				PlutoraConfiguration.objectData);
		// Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id", "EnvGrp_Test_Automation_Id",
				"Systems_Test_Automation_Id");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")
				+ " - Environment is created successfully !");
		// Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		// link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Env_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Phase_Name",
				releasePage.getAttributeValue(
						PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"),
						"data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",
				releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);

		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		// Verification
		environmentImpactMatrixPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page");
		environmentImpactMatrixPage
				.verifyAssertTrue(environmentImpactMatrixPage.getTextData("EnvironmentImpactMatrix_TotalReleases_Text",
						PlutoraConfiguration.environmentImpactMatrixData).contains("1"));
		environmentImpactMatrixPage.sleep(2000);
	}
	
	@Test(description ="Release Type Filter")
	public void environmentImpactMatrix_09() throws InterruptedException, ParseException, AWTException {
		// System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " - System is created successfully !");
		// Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")
				+ " - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_Save&CloseButton",
				PlutoraConfiguration.objectData);
		// Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id", "EnvGrp_Test_Automation_Id",
				"Systems_Test_Automation_Id");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")
				+ " - Environment is created successfully !");
		// Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		// link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Env_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Phase_Name",
				releasePage.getAttributeValue(
						PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"),
						"data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",
				releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
        
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		if(environmentImpactMatrixPage.isElement_Present("EnvironmentImpactMatrix_Enterprise_CheckboxChecked", PlutoraConfiguration.environmentImpactMatrixData))
		{
			environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_Enterprise_label", PlutoraConfiguration.environmentImpactMatrixData);
		}
		
		if(environmentImpactMatrixPage.isElement_Present("EnvironmentImpactMatrix_Independent_CheckboxChecked", PlutoraConfiguration.environmentImpactMatrixData))
		{
			environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_Independent_label", PlutoraConfiguration.environmentImpactMatrixData);
		}
		if(environmentImpactMatrixPage.isElement_Present("EnvironmentImpactMatrix_Project_CheckboxChecked", PlutoraConfiguration.environmentImpactMatrixData))
		{
			environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_Project_label", PlutoraConfiguration.environmentImpactMatrixData);
		}
		
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		// Verification
		environmentImpactMatrixPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page");
	}
	
	@Test(description = "First row and first column to be freezed out on horizontal/vertical scrolling")
	public void environmentImpactMatrix_10() throws InterruptedException, ParseException, AWTException {

		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.getCoordinates("EnvironmentImpactMatrix_ReleaseID_Label",
				PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData, "x_cord", "y_cord");
		environmentImpactMatrixPage.scrollToElement("EnvironmentImpactMatrix_Vertical_Scrollbar",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.clickElementUsingJavaScript("EnvironmentImpactMatrix_Vertical_Scrollbar",
				PlutoraConfiguration.environmentImpactMatrixData);
		for(int i=0;i<=6;i++){
			environmentImpactMatrixPage.scrollDown("EnvironmentImpactMatrix_Vertical_Scrollbar",
					PlutoraConfiguration.environmentImpactMatrixData);
		}
		environmentImpactMatrixPage.getCoordinates("EnvironmentImpactMatrix_ReleaseID_Label",
				PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData, "x_cord1", "y_cord1");
		environmentImpactMatrixPage
				.verifyAssertTrue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "x_cord")
						.equals(PropertiesCache.getProperty(PlutoraConfiguration.testData, "x_cord1")));
	}
	
	@Test(description = "Query Builder (QB) + Quick Access menu")
	public void environmentImpactMatrix_11() throws InterruptedException, ParseException, AWTException {
		// System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " - System is created successfully !");
		// Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")
				+ " - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_Save&CloseButton",
				PlutoraConfiguration.objectData);
		// Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id", "EnvGrp_Test_Automation_Id",
				"Systems_Test_Automation_Id");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")
				+ " - Environment is created successfully !");
		// Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Releases_StakeholderButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		// link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Env_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Test_Automation_Id", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Phase_Name",
				releasePage.getAttributeValue(
						PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Environment_PhaseName"),
						"data-qtip").split(" ")[1]);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Allocation",
				releasePage.getTextData("Release_Environment_Allocation_Status", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);

		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sendKeys("EnvironmentImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.environmentImpactMatrixData);
		environmentImpactMatrixPage.sleep(1000);
		environmentImpactMatrixPage.sendKeysWithoutClear("EnvironmentImpactMatrix_Live_Search_Textfield",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.sleep(2000);
		// Verification
		environmentImpactMatrixPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page");

		/* Clearing existing query if any */
		environmentImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,
				10, 0);
		environmentImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

		/* Adding a new Public Query */
		environmentImpactMatrixPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Release ID", "contains", "Project_Automation", "1");
		/* Saving And Running The Query */
		environmentImpactMatrixPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Public", "Query_Public_Builder");
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

		/* Verifying Search Result */
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ProjectName_Link",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on ");
		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In with different Account */
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Navigating to EI matrix page */
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);

		/* Clicking Query Builder */
		environmentImpactMatrixPage.clickQueryBuilderOption(PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Query_Public_Builder");

		/* Verifying Search Results */
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ProjectName_Link",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on ");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

		/* Navigating to EI matrix page */
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);

		/* Adding a New Private query */
		environmentImpactMatrixPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);

		/* Adding the first Condition */
		environmentImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_New_Button",
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Release Name", "contains", "Project_Automation_Name", "1");

		/* Adding the Second Condition */
		environmentImpactMatrixPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_AddQuery_Icon",
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.addCondition(PlutoraConfiguration.objectData, "And", "2");
		environmentImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Release ID", "contains", "Project_Automation", "2");
		/* Saving and Running Query */
		environmentImpactMatrixPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Private", "Query_Private_Builder");

		/* Verifying Results */
		environmentImpactMatrixPage.validateElementDisplayed("EnvironmentImpactMatrix_ProjectName_Link",
				"Project_Automation", PlutoraConfiguration.environmentImpactMatrixData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " is displayed in environment impact matrix page on ");

		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In with another account */
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);

		/* Navigating to EI matrix page */
		environmentImpactMatrixPage.gotoEnvironmentImpactMatrix(PlutoraConfiguration.environmentImpactMatrixData,
				PlutoraConfiguration.objectData);
		/* Clicking On quick access menu */
		environmentImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,
				10, 0);
		environmentImpactMatrixPage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")
				+ " not displayed in query builder in other account successfully !");

		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

		/* Clearing existing query if */
		environmentImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,
				10, 0);
		environmentImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);
		environmentImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

	}
}
