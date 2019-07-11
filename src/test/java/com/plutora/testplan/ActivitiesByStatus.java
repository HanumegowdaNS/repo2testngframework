package com.plutora.testplan;


import java.io.File;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
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


public class ActivitiesByStatus {
	DeploymentPage deploymentPlanPage= new DeploymentPage();
	ReleasePage releasePage =new ReleasePage();
	
	@Test (description=" -> Select/unselect multiple releases")
	public void activitiesByStatus_01() throws InterruptedException, ParseException  {
		for(int i=1;i<=2;i++) {
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation_"+i);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_"+i)+" -  added system successfully !");
		//Release Creation & System Linked to release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_"+i,"Project_Automation_Name_"+i,"0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_"+i)+" -  added release successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_"+i);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_"+i);
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation_"+i,"Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_"+i)+" -  Linked system to release successfully !");
		//Deployment creation
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation_"+i,"System_Automation_"+i, "Project_Automation_Name_"+i);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_"+i)+" - Deployment Plan is added successfully !");
		//Add Activity 1
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation_"+i,"Deployment_Activity_1_"+i,"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_"+i)+" - Deployment Plan activity added successfully !");
		//Add Activity 2
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation_"+i,"Deployment_Activity_2_"+i,"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_"+i)+" - Deployment Plan activity added successfully !");
		//Create group
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_"+i);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Activity_Checkbox","Deployment_Activity_1_"+i,PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2_"+i);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_"+i)+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_"+i)+" - Deployment Plan activity usergroup added successfully !");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan moved from Draft to Execution Mode successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		}
		//Validate Deployment Schedule 
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_2");
		//System verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_SystemsName_FirstRow", "System_Automation_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_SystemsName_SecondRow", "System_Automation_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2")+" -  name is filtered in Activities by Status page successfully !");
		//Activity Status Verification
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "4", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		//Activity Name Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_2")+" -  name is filtered in Activities by Status page successfully !");
		
		deploymentPlanPage.verifyText("ActivitiesByStatus_SecondRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_SecondRowTop_Name", "Deployment_Activity_2_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_2")+" -  name is filtered in Activities by Status page successfully !");
		
		//Start Date & End Date Verification
		//First row
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_FirstRowTop_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "4", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in first top row under Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_FirstRowBottom_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "4", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in first bottom row under Activities by Status page successfully !");
		//Second Row
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_SecondRowTop_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in second top row under Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_SecondRowBottom_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in second bottom row under Activities by Status page successfully !");
		
		//Activity N/A status verification
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_N/AStatus", "", "4", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities N/A status displayed in Activites by Status page successfully !");
	
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"ActivitiesByStatus_View_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_2"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_2"));
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+"<br>"+
						   PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2")+"<br>"+
						   PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+"<br>"+
						   PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_2")+"<br>"+
						   PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+"<br>"+
						   PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_2")+"<br>"+
							"  not displayed in Activities by status page successfully !");
	}
	
	@Test (description=" -> View/Clear")
	public void activitiesByStatus_02() throws InterruptedException, ParseException {	
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1"));
		
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
	
		//System verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_SystemsName_FirstRow", "System_Automation_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+" -  name is filtered in Activities by Status page successfully !");
		//Activity Status Verification
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		//Activity Name Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		
		//Start Date & End Date Verification
		//First row
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_FirstRowTop_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "3", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in first top row under Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_FirstRowBottom_Name", deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"), "3", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy")+" -  date is filtered in first bottom row under Activities by Status page successfully !");
		
		//Activity N/A status verification
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_FirstRow_N/AStatus", "", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities N/A status displayed in Activites by Status page successfully !");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Tick/untick Activity Status")
	public void activitiesByStatus_03() throws InterruptedException {	
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"ActivitiesByStatus_Disable_Checkbox","ActivitiesByStatus_Enable_Checkbox",PlutoraConfiguration.objectData,"css");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"ActivitiesByStatus_View_Button",PlutoraConfiguration.objectData);
		
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1"));
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  Deployment activity group name not displayed in deployment schedule successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  Deployment activity group name not displayed in deployment schedule successfully !");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"ActivitiesByStatus_Enable_Checkbox","ActivitiesByStatus_Disable_Checkbox",PlutoraConfiguration.objectData,"css");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"ActivitiesByStatus_View_Button",PlutoraConfiguration.objectData);
		
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Export to XLS")
	public void activitiesByStatus_04() throws InterruptedException, ParseException {	
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_2");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_ExportToXLS_Button", PlutoraConfiguration.objectData);
		Listener.addLogger("Activities By Status export to XLS is downloaded successfully!");
		deploymentPlanPage.sleep(3000);
		//Excel Verification
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Activities_by_Status");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "MasterPlanBySystem", 1);
		deploymentPlanPage.verifyTextValue("Deployment_Automation_1",data[0].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("System_Automation_1",data[1].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Overdue",data[2].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_1_1",data[3].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[4].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_2_1",data[5].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[6].trim());
		
		data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "MasterPlanBySystem", 2);
		deploymentPlanPage.verifyTextValue("Deployment_Automation_1",data[0].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("System_Automation_1",data[1].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Overdue",data[2].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_2_1",data[3].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[4].trim());
		deploymentPlanPage.verifyTextContainsValue("N/A",data[5].trim());
		deploymentPlanPage.verifyTextContainsValue("N/A",data[6].trim());
		
		data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "MasterPlanBySystem", 3);
		deploymentPlanPage.verifyTextValue("Deployment_Automation_2",data[0].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("System_Automation_2",data[1].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Overdue",data[2].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_1_2",data[3].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[4].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_2_2",data[5].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[6].trim());
		
		data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "MasterPlanBySystem", 4);
		deploymentPlanPage.verifyTextValue("Deployment_Automation_2",data[0].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("System_Automation_2",data[1].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("Overdue",data[2].trim());
		deploymentPlanPage.verifyTextContainsValue("Deployment_Activity_2_2",data[3].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContainsValue(deploymentPlanPage.getTodayDate("0", "dd/MM/yyyy"),data[4].trim());
		deploymentPlanPage.verifyTextContainsValue("N/A",data[5].trim());
		deploymentPlanPage.verifyTextContainsValue("N/A",data[6].trim());
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_1")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_2")+" - Export to XLS is verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Real-time update (deployment plan activities, use two incognito browsers) ")
	public void activitiesByStatus_05() throws InterruptedException, ParseException {
		//Validate Activities by status
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		//First Row Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		
		DeploymentPage.tempDriver=DeploymentPage.driver;
		DeploymentPage.getNewBrowser(PlutoraConfiguration.browserName, PlutoraConfiguration.hubIPUrl, PlutoraConfiguration.chromePath);
		DeploymentPage.driver=DeploymentPage.newDriver;
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLogin_Email_Textfield_Value")+" - User2 loggedin successfully");
		
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		//Second Browser Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Dropdown_Link", PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_1");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_1");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_1_1","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_2_1","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		//First Row Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		
		DeploymentPage.driver=DeploymentPage.newDriver;
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		//First Row Verification
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyWebElementCount("ActivitiesByStatus_Status_Name", "Overdue", "2", PlutoraConfiguration.deploymentPlanData, "");
		Listener.addLogger("Activities overdue status displayed in Activites by Status page successfully !");
		
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		DeploymentPage.driver.close();
		
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Dropdown_Link", PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_1");
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation_2");
		
		//Release deletion	
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation_2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation_2");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_2")+" is deleted successfully !");
		
		//System Deletion
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_2")+" is deleted successfully !");
		
	}
	@Test (description=" -> Select/unselect multiple groups")
	public void activitiesByStatus_06() throws InterruptedException, ParseException {	
		//Deployment creation
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","System_Automation_1", "Project_Automation_Name_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully !");
		
		//Add Activity 1
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation_1","Deployment_Activity_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity added successfully !");
		//Add Activity 2
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation_1","Deployment_Activity_2","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity added successfully !");
		//Create group
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2");
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity usergroup added successfully !");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan moved from Draft to Execution Mode successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
	
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  name is filtered in Activities by Status page successfully !");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" -  name is filtered in Activities by Status page successfully !");
		
		deploymentPlanPage.clickElementUsingJavaScript("ActivitiesByStatus_Close_Icon","Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  name is disappear in Activities by Status page successfully !");
		
		deploymentPlanPage.clickElementUsingJavaScript("ActivitiesByStatus_Close_Icon","Deployment_Activity_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" -  name is disappear in Activities by Status page successfully !");
		
		deploymentPlanPage.searchActivitiesByStatusGroups(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_1");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  name is filtered in Activities by Status page successfully !");
		
		deploymentPlanPage.searchActivitiesByStatusGroups(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2");
		deploymentPlanPage.verifyText("ActivitiesByStatus_FirstRowTop_Name", "Deployment_Activity_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" -  name is filtered in Activities by Status page successfully !");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name_2")+" -  not displayed in deployment schedule successfully !");
		
	}
	@Test (description=" -> Open a DP vie the 'i' icon ('DP' coulmn)")
	public void activitiesByStatus_07() throws InterruptedException, ParseException {	
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.gotoActivitiesByStatusPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_Clear_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.searchActivitiesByStatusRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name_1");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_FirstRowTop_InformationIcon", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_FirstRowTop_InformationIcon"), "Deployment Plan: "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation"));
		Listener.addLogger("Open a DP vie the 'i' icon ('DP' coulmn) - First Row Verified successfully !");
		
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_SecondRowTop_InformationIcon", PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.deploymentPlanData, "ActivitiesByStatus_SecondRowTop_InformationIcon"), "Deployment Plan: "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation"));
		Listener.addLogger("Open a DP vie the 'i' icon ('DP' coulmn) - Second Row Verified successfully !");
		
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		//	deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Dropdown_Link", PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		
		//Release deletion	
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation_1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation_1");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_1")+" is deleted successfully !");
		
		//System Deletion
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation_1")+" is deleted successfully !");
		
	}
}
