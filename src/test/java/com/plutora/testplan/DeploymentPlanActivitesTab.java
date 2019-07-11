package com.plutora.testplan;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanActivitesTab {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ChangesPage changePage = new ChangesPage();
	
	@Test (description="Add/Edit/delete activities")
	public void deploymentPlanActivitesTab_01() throws InterruptedException, ParseException  {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity is verified successfully");
		deploymentPlanPage.updateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity is updated successfully");
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Activity_Description","Deployment_Activity_Description",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity is verified after updation successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"Deployment_Activities_Activity_Close_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
		
	@Test (description="Action -> Export to XLS")
	public void deploymentPlanActivitesTab_02() throws InterruptedException {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(3000);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_ExportToXLS_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.sleep(5000);
		Listener.addLogger("Deployment Plan Activity export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Deployment_Automation");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Table1", 1);
		deploymentPlanPage.verifyTextValue("Deployment_Activity_Name",data[2].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Deployment_Activity_Description",data[3].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Systems_Test_Automation_Id",data[5].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Deployment_Activity_Responsible",data[7].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Deployment_Activity_Start_Time",data[10].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Deployment_Activity_End_Time",data[11].trim(),PlutoraConfiguration.testData);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan Activity export to XLS is verified successfully!");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Real-time update notification in activities\n" + 
			"(yellow message when another user is updating)")
	public void deploymentPlanActivitesTab_03() throws InterruptedException  {
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Login_Email_Textfield_Value")+" - User1 loggedin successfully");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		DeploymentPage.tempDriver=DeploymentPage.driver;
		DeploymentPage.getNewBrowser(PlutoraConfiguration.browserName, PlutoraConfiguration.hubIPUrl, PlutoraConfiguration.chromePath);
		DeploymentPage.driver=DeploymentPage.newDriver;
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLogin_Email_Textfield_Value")+" - User2 loggedin successfully");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - User1 added activity successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.clickButton("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"Deployment_Activities_Activity_Close_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		DeploymentPage.driver=DeploymentPage.newDriver;
		deploymentPlanPage.validateElementDisplayed("Deployment_Notification", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Notification_Username", "Loggedin_Username_Value",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger("User2 is verified notification successfully");
		
		deploymentPlanPage.click("Deployment_Notification_Reload_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear(150, "Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.updateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - User2 updated activity successfully");
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"Deployment_Activities_Activity_Close_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.validateElementDisplayed("Deployment_Notification", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Notification_Username", "NewLoggedin_Username_Value",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger("User1 is verified notification successfully");
		
		deploymentPlanPage.click("Deployment_Notification_Reload_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear(150, "Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		Listener.addLogger("User1 is updated status successfully");
		
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Approved_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Approved_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("User1 is verified status successfully");
		
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		DeploymentPage.driver=DeploymentPage.newDriver;
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Approved_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Approved_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("User1 is verified status successfully");
		
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		DeploymentPage.driver.close();
		
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		
	}
	
	@Test (description="Ability to select multiple systems (applications) for activity")
	public void deploymentPlanActivitesTab_04() throws InterruptedException, ParseException  {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id_2");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_2","PRelease_Automation_Name_2", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_2");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id_2",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_1","PRelease_Automation_Name_1", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id_1");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id_1",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id_2","PRelease_Automation_Name_2");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.selectSystem(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added successfully");
		
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectSystemActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is added in the activity successfully");
		
		deploymentPlanPage.verifyText("Deployment_Activity_System_Dropdown_Option","Systems_Test_Automation_Id_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is verified in the activity successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Planned Start Time / Planned End Time (+ timezone label)")
	public void deploymentPlanActivitesTab_05() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name","1");
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("0")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("1")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
	}
	@Test (description="Actual Start Time / Actual End Time")
	public void deploymentPlanActivitesTab_06() throws InterruptedException, ParseException  {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		
		deploymentPlanPage.selectStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name");
		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_InProgress_Button");
		Listener.addLogger(" Deployment Plan activity status is changed to Inprogress successfully");
		deploymentPlanPage.sleep(2000);
		String date=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new SimpleDateFormat("dd-MMMM-yyyy HH:mm").parse(deploymentPlanPage.getTodayDate("0","dd-MMMM-yyyy HH:mm")));
		deploymentPlanPage.verifyDate(deploymentPlanPage.getAttributeData("Deployment_Activity_Actual_Start_Time_Calender_Textbox", PlutoraConfiguration.deploymentPlanData),date);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		
		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Completed_Button");
		Listener.addLogger("Deployment Plan activity status is changed to Completed successfully");
		date=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new SimpleDateFormat("dd-MMMM-yyyy HH:mm").parse(deploymentPlanPage.getTodayDate("0","dd-MMMM-yyyy HH:mm")));
		deploymentPlanPage.verifyDate(deploymentPlanPage.getAttributeData("Deployment_Activity_Actual_End_Time_Calender_Textbox", PlutoraConfiguration.deploymentPlanData),date);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Revised Start Time / Revised End Time")
	public void deploymentPlanActivitesTab_07() throws InterruptedException, ParseException  {
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectRevisedDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getTodayDate("0","dd-MMMM-yyyy")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Revised_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getTodayDate("1","dd-MMMM-yyyy")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Revised_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Toggle button 'Will this cause a downtime(black notification label on activities grid)")
	public void deploymentPlanActivitesTab_08() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectDowntimeDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getTodayDate("0","dd-MMMM-yyyy")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Downtime_From_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getTodayDate("1","dd-MMMM-yyyy")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Downtime_To_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - Deployment Plan activity date is verified successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is deleted successfully");
	}
	
	@Test (description="Bulk Update")
	public void deploymentPlanActivitesTab_09() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id" , "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan Activity is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan Activity is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectActivityCheckbox(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name","Deployment_Activity_Name_1");
		deploymentPlanPage.activityBulkUpdate(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan Activity is bulk update added successfully");
		
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("1")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity date is verified successfully");
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("1")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity date is verified successfully");
		
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name_1", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("1")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity date is verified successfully");
		
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("1")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity date is verified successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Bulk Update - shift dates")
	public void deploymentPlanActivitesTab_10() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectActivityCheckbox(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name","Deployment_Activity_Name_1");
		deploymentPlanPage.activityBulkUpdateShiftDates(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Deployment Plan activity date shifted date for start And end date");
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("2")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity date is verified successfully");
		
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("2")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity date is verified successfully");
		
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name_1", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("2")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity date is verified successfully");
		
		date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("2")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(date+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity date is verified successfully");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Bulk Update - reset option")
	public void deploymentPlanActivitesTab_11() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectActivityCheckbox(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name","Deployment_Activity_Name_1");
		deploymentPlanPage.activityBulkUpdateWithoutEnteringAnyValues(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Deployment Plan activity date without entering any values");
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox","",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox","",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity start & end date are reset successfully");
		
		deploymentPlanPage.click("Deployment_Activity_Name_Text", "Deployment_Activity_Name_1", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox","",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox","",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity start & end date are reset successfully");
	
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Bulk Delete")
	public void deploymentPlanActivitesTab_12() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectActivityCheckbox(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name","Deployment_Activity_Name_1");
		deploymentPlanPage.deleteActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity deleted successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity deleted successfully");
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1"));
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		//deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is deleted successfully");
	}
	
	@Test (description="Drag and drop to re-order activities in the grid")
	public void deploymentPlanActivitesTab_13() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added successfully");
	
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added group successfully");
		deploymentPlanPage.verifyText("Deployment_Activity_Group_Name","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity added successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_Name_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan activity added group successfully");
		deploymentPlanPage.verifyText("Deployment_Activity_Group_Name","Deployment_Activity_Name_1",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.sleep(1000);
	
		deploymentPlanPage.dragAndDrop("Deployment_Activity_Name_Row","Deployment_Activity_Group_Drag_Section","Deployment_Activity_Name","Deployment_Activity_Name_1",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.dragAndDrop("Deployment_Activity_Name_Row","Deployment_Activity_Group_Drag_Section","Deployment_Activity_Name","Deployment_Activity_Name_1",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" is drag and dropped to group "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name"));
		
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="DP real-time update changing statuses(NotStarted/InProgress/Issue/Failed/Completed)")
	public void deploymentPlanActivitesTab_14() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.selectStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name");
		
		deploymentPlanPage.validateElementDisplayed("Deployment_NotStarted_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan activity NotStarted process is verified successfully");
		
		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_InProgress_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_InProgress_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan activity InProgress process is verified successfully");

		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Issue_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Issue_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan activity Issue process is verified successfully");
		
		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Failed_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Failed_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan activity Failed process is verified successfully");
		
		deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Completed_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Completed_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan activity Completed process is verified successfully");
		
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is deleted successfully");
		
	}
	
	
	@Test (description="Import from XLS -> Upload File\n" + 
			"(previously absent Aplication/System should be added to DP)\n" + 
			"(button should be available in Draft mode only, \n" + 
			"and in Approved/Execution mode with special permission)e")
	public void deploymentPlanActivitesTab_15() throws InterruptedException, AWTException, ParseException, IOException {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity is added successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"DeploymentPlanActivity");
	
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 1, PropertiesCache.setProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 2, PropertiesCache.setProperty(PlutoraConfiguration.testData, "Deployment_Activity_Description") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 3, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 4, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Responsible"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 5, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Start_Time"));
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 6, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_End_Time"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan import to xls is updated successfully");
		
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.imageFileName+excelFile, "Table1", 1);
		
		deploymentPlanPage.importActivityFromXLS(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, CommonConstants.imageFileName+PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlanActivityName"));
		deploymentPlanPage.verifyTextContains("Deployment_Activity_Name_Text",data[1],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.click("Deployment_Activity_Name_Text",data[1],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Activity_Description",data[2],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyText("Deployment_Activity_System_Textbox",data[3],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Activity_Responsible_Dropdown_Textbox",data[4],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",data[5],PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",data[6],PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan import to xls is verified successfully");
		
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is deleted successfully");	
	}
	
	@Test (description="Deployment Plan Activities Tab : Attach document to the activity")
	public void deploymentPlanActivitesTab_16() throws InterruptedException, ParseException, IOException, AWTException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Name_Link",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.uploadImageForActivity(PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage
				.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")
				+ " uploaded file verified successfully !");
        /*Download File*/
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_DownloadIcon",
				PlutoraConfiguration.objectData);
		String excelFile = FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath, "screenshot");
		Assert.assertTrue(!excelFile.isEmpty());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")
				+ " Downloaded file verified successfully !");
		/*Delete File*/
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_DeleteIcon",
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
				"Deployment_ActivitiesDeleteIconPopUpYes_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")
				+ " uploaded file deleted successfully !");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_SaveCloseButton",
				PlutoraConfiguration.objectData);
	}
	
	@Test (description="Deployment Plan Activities Tab : Comment the activity")
	public void deploymentPlanActivitesTab_17() throws InterruptedException, ParseException, IOException, AWTException  {
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Name_Link",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivityComments(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Activity_Comment", "Deployment_Activities_CommentIcon");
		deploymentPlanPage.verifyText("Deployment_ActivitiesComments_EditTextArea", "Activity_Comment",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.editActivityComments(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Activity_Edit", "Deployment_Activities_CommentIcon");
		deploymentPlanPage.verifyText("Deployment_ActivitiesComments_EditTextArea", "Activity_Edit",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.replyActivityComments(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Activity_Reply", "Deployment_Activities_CommentIcon");
		deploymentPlanPage.verifyText("Deployment_ActivitiesComments_ReplyTextArea", "Activity_Reply",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_SaveCloseButton",
				PlutoraConfiguration.objectData);
	}
	
	@Test (description="Group/Ungroup Activity")
	public void deploymentPlanActivitesTab_18() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_GroupOne",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_GroupOne")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_GroupTwo",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_GroupTwo")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.groupActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData,
				"Deployment_Activity_GroupOne", "Deployment_Activity_GroupTwo", PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesGroupName_Input",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "GroupName"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_ActivitiesGroupUngroupDisabled_Button",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test (description="Expand All Group")
	public void deploymentPlanActivitesTab_19() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_GroupOne",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_GroupOne")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_GroupTwo",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_GroupTwo")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.groupActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData,
				"Deployment_Activity_GroupOne", "Deployment_Activity_GroupTwo", PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_ActivitiesGroupCollapseAll_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyElementNotDisplayed("Deployment_ActivitiesGroupName_link",
				"Deployment_Activity_GroupOne", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyElementNotDisplayed("Deployment_ActivitiesGroupName_link",
				"Deployment_Activity_GroupTwo", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_ActivitiesGroupExpandAll_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesGroupName_link", "Deployment_Activity_GroupOne",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesGroupName_link", "Deployment_Activity_GroupTwo",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test(description = "Bringing down Activity Sets from MDP in the field 'Link to Master Deployment Plan Activity Set:'")
	public void deploymentPlanActivitesTab_20() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Deployment Master plan is created successfully");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.addActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.linkActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Activity_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDeploymentPlanInActivitiesSet(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation","1");
	}
	
	@Test(description = "Dependency (4 types)")
	public void deploymentPlanActivitesTab_21() throws InterruptedException, ParseException {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_One",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_One")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Two",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Two")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");	
	}
	
	@Test(description = "Toggle button 'Is this a milestone'")
	public void deploymentPlanActivitesTab_22() throws InterruptedException, ParseException {
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_One",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_One")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.toggleButtonMilestone(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesMilestone_StatusLabel", "Yes",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.toggleButtonMilestone(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesMilestone_StatusLabel", "No",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test(description = "Toggle button 'Is this optional'")
	public void deploymentPlanActivitesTab_23() throws InterruptedException, ParseException {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_One",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_One")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.toggleButtonOptional(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesOptional_StatusLabel", "Yes",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.toggleButtonOptional(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesOptional_StatusLabel", "No",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.toggleButtonOptional(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Save_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentExecuteComplete(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.toggleButtonOptional(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesOptional_StatusLabel", "Yes",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}

	@Test(description = "Import from XLS -> Download Template ")
	public void deploymentPlanActivitesTab_24() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_One",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_One")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentActivityDownloadTemplate(PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Import Activities - Download Template is downloaded successfully!");
		String excelFile = FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,
				"Deployment_Plan_Template");
		String[] data = FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath + excelFile, "Template", 0);
		deploymentPlanPage.verifyTextValue("Group", data[0].trim());
		deploymentPlanPage.verifyTextValue("Name", data[1].trim());
		deploymentPlanPage.verifyTextValue("Description", data[2].trim());
		deploymentPlanPage.verifyTextValue("System", data[3].trim());
		deploymentPlanPage.verifyTextValue("Responsible", data[4].trim());
		deploymentPlanPage.verifyTextValue("Start Date", data[5].trim());
		deploymentPlanPage.verifyTextValue("End Date", data[6].trim());
		deploymentPlanPage.verifyTextValue("Downtime From", data[7].trim());
		deploymentPlanPage.verifyTextValue("Downtime To", data[8].trim());
		deploymentPlanPage.verifyTextValue("Milestone", data[9].trim());
		deploymentPlanPage.verifyTextValue("Optional", data[10].trim());

		Listener.addLogger("Group" + "<br>" + "Name" + "<br>" + "Description" + "<br>" + "System" + "<br>"
				+ "Responsible" + "<br>" + "Start Date" + "<br>" + "End Date" + "<br>" + "Downtime From" + "<br>" + "Downtime To"
				+ "<br>" + "Milestone" + "<br>" + "Optional"
				+ " Import activites Download template verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator + "DownloadFiles" + File.separator);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}

	@Test(description = "Delete activity set (only Draft mode)")
	public void deploymentPlanActivitesTab_25() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Deployment Master plan is created successfully");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.addActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.linkActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Activity_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.deleteActivitySetName(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesMasterDpActivitySet_dropdownValue", "",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}

	@Test(description = "Rename activity set (only Draft mode)")
	public void deploymentPlanActivitesTab_26() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Deployment Master plan is created successfully");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.addActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.linkActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Activity_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.editActivitySetName(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData,
				"Deployment_Master_ActivitySet_Edit");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesMasterDpActivitySet_dropdownValue",
				"Deployment_Master_ActivitySet_Edit", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}

	@Test(description = "Open window 'Total Linked Activities'")
	public void deploymentPlanActivitesTab_27() throws InterruptedException, ParseException {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_ActivitySet_Tab",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDeploymentPlanInActivitiesSet(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation","1");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test (description="Bulk Import Activities -> Upload File\n" + 
			"(previously absent Aplication/System should be added to DP)\n" + 
			"(button should be available in Draft mode only, \n" + 
			"and in Approved/Execution mode with special permission)e")
	public void deploymentPlanActivitesTab_28() throws InterruptedException, AWTException, ParseException, IOException {	
		
		//Create DP - done
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id_2","PRelease_Automation_Name");
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
		
		//Navigate DPA Tab - done
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
					
		//Click Bulk Import Activities > Browse file > Next > Auto Mapping > Next > Submit > Save&Close > Save&Close DP window - done
		deploymentPlanPage.bulkImportActivities(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, CommonConstants.imageFileName+"eikiPerfectUltimateTemplate.xlsx");
		
		//Delete DP - done
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is deleted successfully");	
	}
}
