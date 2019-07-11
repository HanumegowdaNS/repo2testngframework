package com.plutora.testplan;

import java.awt.AWTException;
import java.io.File;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsImpactMatrixPage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class SystemsImpactMatrix {
	ReleasePage releasePage = new ReleasePage();
	SystemsImpactMatrixPage systemsImpactMatrixPage = new SystemsImpactMatrixPage();
	ChangesPage changesPage = new ChangesPage();
	EnvironmentPage environmentPage= new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test (description=" -> Live Search")
	public void systemsImpactMatrix_01() throws InterruptedException, ParseException {
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		//Release Creation
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//System Impact Matrix
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Verification
		systemsImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in systems impact matrix page");
		systemsImpactMatrixPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" is displayed in systems impact matrix page");
		systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.systemsImpactMatrixData, "SystemsImpactMatrix_Live_Search_CloseIcon", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is displayed in systems impact matrix page");
	}
	
	@Test (description=" -> Export to XLS")
	public void systemsImpactMatrix_02() throws InterruptedException  {
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sleep(2000);
		systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.systemsImpactMatrixData, "SystemsImpactMatrix_MoreTools_Button", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.systemsImpactMatrixData, "SystemsImpactMatrix_ExportToXLS_Button", PlutoraConfiguration.objectData);
		Listener.addLogger("System Impact Matrix export to XLS is downloaded successfully!");
		releasePage.sleep(3000);
		//Excel validation
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Impact Matrix");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "New Matrix", 1);
		releasePage.verifyTextValue("Project_Automation",data[1].trim(),PlutoraConfiguration.testData);
		releasePage.verifyTextValue("Project_Automation_Name",data[2].trim(),PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" -  export to XLS is verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
	}
	
	
	@Test (description=" -> Entity popup window (data appearance, hyperlink)")
	public void systemsImpactMatrix_03() throws InterruptedException  {
		//Change Creation
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//Link system to change
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation");
		//Link change to release
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])", ""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_DeliveryRelease_ActualDelivery_Checkbox");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		//Verification in System Impact Matrix
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_Total_Changes_Count", "1",PlutoraConfiguration.systemsImpactMatrixData);
		Listener.addLogger("SystemsImpactMatrix_Total_Changes_Count is Displayed in System impact Matrix successfully !");
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_Total_Releases_Count", "1",PlutoraConfiguration.systemsImpactMatrixData);
		Listener.addLogger("SystemsImpactMatrix_Total_Releases_Count is Displayed in System impact Matrix successfully !");
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_Count", "1",PlutoraConfiguration.systemsImpactMatrixData);
		Listener.addLogger("SystemsImpactMatrix_Count is Displayed in System impact Matrix successfully !");
		systemsImpactMatrixPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sleep(2000);
		systemsImpactMatrixPage.mouseOver("SystemsImpactMatrix_Text", "", PlutoraConfiguration.systemsImpactMatrixData, "");
		systemsImpactMatrixPage.click("SystemsImpactMatrix_Details_Link","System_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sleep(2000);
		//Change details Verification
		systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ChangeId_Text", "Change_Id",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Id")+" is displayed Impact matrix successfully !");
		systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ChangeTitle_Text", "Change_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" is displayed Impact matrix successfully !");
		systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_SystemId_Text", "System_Automation",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" is displayed Impact matrix successfully !");
		systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ChangeType_Text", "Type_Name",PlutoraConfiguration.systemsImpactMatrixData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Type_Name")+" is displayed Impact matrix successfully !");
		changesPage.sleep(2000);
		systemsImpactMatrixPage.mouseHover("SystemsImpactMatrix_ChangeTitle_Text", "SystemsImpactMatrix_ChangeTitle_Text", PlutoraConfiguration.systemsImpactMatrixData);
		changesPage.sleep(2000);
		systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.systemsImpactMatrixData, "SystemsImpactMatrix_ChangeTitle_Text", PlutoraConfiguration.objectData);
		changesPage.verifyTextValue("Change_Id", changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])", ""),PlutoraConfiguration.testData);
		changesPage.sleep(2000);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.systemsImpactMatrixData, "SystemsImpactMatrix_Close_Icon", PlutoraConfiguration.objectData);
		//Release deletion
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" is deleted successfully !");
		//System Deletion
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" is deleted successfully !");
		//Change Deletion
		new ChangesPage().changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		new ChangesPage().findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_Automation");
		new ChangesPage().deleteChange(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")+" is deleted successfully !");
		
	}
	
	  @Test (description="Total by: Number of Change")
	  public void systemsImpactMatrix_04() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		//systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		//systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Change Creation */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Link system to change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
				changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
						""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_DeliveryRelease_TargetReleaseWithProjectName_Checkbox",
				"Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickQuickFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setOrganizationNameOff("SystemsImpactMatrix_QuickFitrOrgNameOff_Toggle",
				"SystemsImpactMatrix_QuickFitrOrgNameOn_Toggle", PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setShowTotalByChange(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnApplyFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.verifyAssertTrue(systemsImpactMatrixPage
				.getTextData("SystemsImpactMatrix_TotalChange_Label", PlutoraConfiguration.systemsImpactMatrixData)
				.contains("1"));
	}
	  
	  @Test (description="Total by: Number of System")
	  public void systemsImpactMatrix_05() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		//systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		//systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Change Creation */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Link system to change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
				changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
						""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_DeliveryRelease_ActualDelivery_Checkbox");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickQuickFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setOrganizationNameOff("SystemsImpactMatrix_QuickFitrOrgNameOff_Toggle",
				"SystemsImpactMatrix_QuickFitrOrgNameOn_Toggle", PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setShowTotalBySystem(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.verifyAssertTrue(systemsImpactMatrixPage
				.getTextData("SystemsImpactMatrix_TotalSystem_Label", PlutoraConfiguration.systemsImpactMatrixData)
				.contains("1"));
	  }
	  

	  @Test (description="Show by System Portfolio")
	  public void systemsImpactMatrix_06() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		// systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown",
		// PlutoraConfiguration.objectData, 10, 0);
		// systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
		// PlutoraConfiguration.objectData);
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Change Creation */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Link system to change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
				changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
						""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_DeliveryRelease_TargetReleaseWithProjectName_Checkbox",
				"Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickQuickFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setOrganizationNameON("SystemsImpactMatrix_QuickFitrOrgNameOn_Toggle",
				"SystemsImpactMatrix_QuickFitrOrgNameOff_Toggle", PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setShowTotalByChange(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnApplyFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.verifyAssertTrue(systemsImpactMatrixPage
				.getTextData("SystemsImpactMatrix_OrganizationName_Label", PlutoraConfiguration.systemsImpactMatrixData)
				.contains(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization")));
	  }
	  
	  @Test (description="'Total' counting in the matrix")
	  public void systemsImpactMatrix_07() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		//systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		//systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Change Creation */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Link system to change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
				changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
						""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_DeliveryRelease_TargetReleaseWithProjectName_Checkbox",
				"Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickQuickFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setOrganizationNameOff("SystemsImpactMatrix_QuickFitrOrgNameOff_Toggle",
				"SystemsImpactMatrix_QuickFitrOrgNameOn_Toggle", PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setShowTotalByChange(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnApplyFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.verifyAssertTrue(systemsImpactMatrixPage
				.getTextData("SystemsImpactMatrix_Total_Label", PlutoraConfiguration.systemsImpactMatrixData)
				.contains("1"));
	}
	  
	  @Test (description="'Filter by (right top corner)")
	  public void systemsImpactMatrix_08() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		//systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		//systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickElementUsingJavaScript("Releases_StakeholdersTab", PlutoraConfiguration.releasesData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Releases_EStakeholder_Button",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value"));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Change Creation */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is created successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Link system to change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
				changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
						""));
		changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_DeliveryRelease_TargetReleaseWithProjectName_Checkbox",
				"Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
				+ " is linked to release successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickQuickFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setOrganizationNameOff("SystemsImpactMatrix_QuickFitrOrgNameOff_Toggle",
				"SystemsImpactMatrix_QuickFitrOrgNameOn_Toggle", PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.setShowTotalByChange(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickOnApplyFilterButton(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sendKeysWithoutClear("SystemsImpactMatrix_Live_Search_Textfield", "Project_Automation",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_MyPortfolioAssociation_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_ProjectName_Link", "Project_Automation_Name",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_IamStakeHolder_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_All_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_ProjectName_Link", "Project_Automation_Name",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);

	}
	  
	  @Test (description="Query Builder (QB) + Quick Access menu")
	  public void systemsImpactMatrix_09() throws InterruptedException, ParseException  {
		  /* Navigating to System page */
			environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
			/* Clearing existing query if any */
			//systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
			//systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
			/* Creating New System */
			systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
			systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData);
			releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
			releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
			releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Project_Automation");
			releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Project_Automation");
			releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
					"Releases_Change_Systems_CodeImplementation_Section", "");
			releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
			/* Change Creation */
			changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
			changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Change_Automation");
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
					+ " is created successfully !");
			changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
			/* Link system to change */
			changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Change_Automation");
			changesPage.linkSystemToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
			changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
			changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Change_Automation");
			PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Id",
					changesPage.getChangeId(PlutoraConfiguration.changesData).split("-")[0].trim().replaceAll("([A-Z])",
							""));
			changesPage.getDeliveryReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData);
			changesPage.getCheckDeliveryRelease(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, "Change_DeliveryRelease_TargetReleaseWithProjectName_Checkbox",
					"Project_Automation");
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation")
					+ " is linked to release successfully !");
			changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
					PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
					PlutoraConfiguration.systemsImpactMatrixData);
			/* Clearing existing query if any */
			systemsImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
			systemsImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

			/* Adding a new Public Query */
			systemsImpactMatrixPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID",
					"equals", "Project_Automation", "1");
			/* Saving And Running The Query */
			systemsImpactMatrixPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public",
					"Query_Public_Builder");
			systemsImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

			/* Verifying Search Result */
			systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ProjectName_Link", "Project_Automation_Name",
					PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")
					+ " verified public query builder successfully !");

			/* Logging Out */
			logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

			/* Logging In with different Account */
			loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData);

			/* Navigating to SI matrix page */
			systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
					PlutoraConfiguration.objectData);

			/* Clicking Query Builder */
			systemsImpactMatrixPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
					"Query_Public_Builder");

			/* Verifying Search Results */
			systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ProjectName_Link", "Project_Automation_Name",
					PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
					+ " verified public query builder successfully !");
			logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

			/* Logging In */
			loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

			/* Navigating to SI matrix page */
			systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
					PlutoraConfiguration.objectData);

			/* Adding a New Private query */
			systemsImpactMatrixPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);

			/* Adding the first Condition */
			systemsImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_New_Button", PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID",
					"equals", "Project_Automation", "1");

			/* Adding the Second Condition */
			systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_AddQuery_Icon",
					PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.addCondition(PlutoraConfiguration.objectData, "And", "2");
			systemsImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release Type",
					"equals", "Release_Type", "2");
			systemsImpactMatrixPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_AddQuery_Icon",
					PlutoraConfiguration.objectData);

			/* Adding the Third Condition */
			systemsImpactMatrixPage.addCondition(PlutoraConfiguration.objectData, "And", "3");
			systemsImpactMatrixPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Risk Level",
					"equals", "Release_RiskLevel", "3");

			/* Saving and Running Query */
			systemsImpactMatrixPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private",
					"Query_Private_Builder");
            systemsImpactMatrixPage.sleep(3000);
			/* Verifying Results */
			systemsImpactMatrixPage.verifyText("SystemsImpactMatrix_ProjectName_Link", "Project_Automation_Name",
					PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
					+ " verified public query builder successfully !");
			
			/* Logging Out */
			logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

			/* Logging In with another account */
			loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData);

			/* Navigating to SI matrix page */
			systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
					PlutoraConfiguration.objectData);
			
			/* Clicking On quick access menu */
			systemsImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
			systemsImpactMatrixPage.verifyTextEqualsNotDisplayedInPage(
					PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")
					+ " not displayed in query builder in other account successfully !");

			/* Logging Out */
			logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

			/* Logging In */
			loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

			/* Clearing existing query if */
			systemsImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
			systemsImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
			systemsImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
	  
	  }
	  
	@Test(description = "View Full Screen")
	public void systemsImpactMatrix_10() throws InterruptedException, ParseException, AWTException {
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.getCoordinates("SystemsImpactMatrix_ReleaseName_Text",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData, "xcoordi_1", "ycoordi_1");
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_MoreTools_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_FullScreen_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sleep(2000);
		systemsImpactMatrixPage.getCoordinates("SystemsImpactMatrix_ReleaseName_Text",
				PlutoraConfiguration.systemsImpactMatrixData, PlutoraConfiguration.testData, "xcoordi_2", "ycoordi_2");
		systemsImpactMatrixPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_1"))) > (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_2"))));
		systemsImpactMatrixPage.escape();
		systemsImpactMatrixPage.sleep(2000);

	}
	@Test(description = "Print")
	public void systemsImpactMatrix_11() throws InterruptedException, ParseException, AWTException {
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_MoreTools_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.clickElementUsingJavaScript("SystemsImpactMatrix_Print_Button",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.sleep(2000);
		systemsImpactMatrixPage.switchToWindow(4000, "parent_window");
		systemsImpactMatrixPage.validateElementDisplayed("SystemsImpactMatrix_ReleaseName_Text",
				PlutoraConfiguration.systemsImpactMatrixData);
		systemsImpactMatrixPage.closeWindowTab();
		systemsImpactMatrixPage.driver.switchTo()
				.window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parent_window"));
	}
	
	@Test(description = "First row and first column should be freezed out on horizontal/vertical scrolling")
	public void systemsImpactMatrix_12() throws InterruptedException, ParseException, AWTException {
		systemsImpactMatrixPage.gotoSystemsImpactMatrix(PlutoraConfiguration.systemsImpactMatrixData,
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.sendKeys("SystemsImpactMatrix_Live_Search_Textfield", "",
				PlutoraConfiguration.systemsImpactMatrixData);
		/* Clearing existing query if */
		systemsImpactMatrixPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10,
				0);
		systemsImpactMatrixPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		systemsImpactMatrixPage.scrollToBottomOfPage();
	
	}
}
