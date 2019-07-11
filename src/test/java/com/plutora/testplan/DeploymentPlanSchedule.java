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
import com.plutora.utils.WebGenericUtilLib;


public class DeploymentPlanSchedule {
	DeploymentPage deploymentPlanPage= new DeploymentPage();
	ReleasePage releasePage =new ReleasePage();
	
	@Test (description="Select/unselect multiple releases")
	public void deploymentPlanSchedule_01() throws InterruptedException, ParseException  {
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" -  added system successfully !");
		//Release Creation & System Linked to release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  added release successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  Linked system to release successfully !");
		//Deployment creation
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","System_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully !");
		//Add Activity 1
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity added successfully !");
		//Add Activity 2
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_2","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity added successfully !");
		//Create group
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Activity_Checkbox","Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity usergroup added successfully !");
		//Update Planned start/End date
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_1","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_2","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan moved from Draft to Execution Mode successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		//Validate Deployment Schedule 
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OnTime_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name on time status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" -  not displayed in deployment schedule successfully !");
		
	}
	@Test (description=" -> Select/unselect interval type")
	public void deploymentPlanSchedule_02() throws InterruptedException, ParseException {	
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" -  name filtered from release dropdown in deployment schedule successfully !");
	
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Day","DeploymentSchedule_IntervalType_Dropdown");
		deploymentPlanPage.verifyText("DeploymentSchedule_Day_Text",deploymentPlanPage.getTodayDate("0", "EEE, dd/MMM, yyyy"),PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Interval Type - Day - "+deploymentPlanPage.getTodayDate("0", "EEE, dd/MMM, yyyy")+" -  displayed successfully !");
		
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Minute","DeploymentSchedule_IntervalType_Dropdown");
		deploymentPlanPage.sleep(4000);
	//	deploymentPlanPage.selectDeploymentScheduleIntervalChange(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "30");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_Minute_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Interval Type - Minute - "+"01:00"+" -  displayed successfully !");
		
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Hour","DeploymentSchedule_IntervalType_Dropdown");
		deploymentPlanPage.sleep(4000);
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_Minute_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Interval Type - Hour - "+"14:00"+" -  displayed successfully !");
		
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Select/unselect interval value")
	public void deploymentPlanSchedule_03() throws InterruptedException, ParseException {	
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" -  name filtered from release dropdown in deployment schedule successfully !");
		
		deploymentPlanPage.addDayIntervalValue();
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Day","DeploymentSchedule_IntervalType_Dropdown");
		for(int i=0;i<deploymentPlanPage.day.size();i++) {
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,deploymentPlanPage.day.get(i) ,"DeploymentSchedule_IntervalValue_Dropdown");
		deploymentPlanPage.verifyText("DeploymentSchedule_Day_Text",deploymentPlanPage.getTodayDate("0", "EEE, dd/MMM, yyyy"),PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyText("DeploymentSchedule_Day_Text",deploymentPlanPage.getTodayDate(deploymentPlanPage.day.get(i), "EEE, dd/MMM, yyyy"),PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Interval Value - "+deploymentPlanPage.day.get(i)+" - "+deploymentPlanPage.getTodayDate("0", "EEE, dd/MMM, yyyy")+" -  displayed successfully !");
		Listener.addLogger("Interval Value - "+deploymentPlanPage.day.get(i)+" - "+deploymentPlanPage.getTodayDate(deploymentPlanPage.day.get(i), "EEE, dd/MMM, yyyy")+" -  displayed successfully !");
		}
		deploymentPlanPage.addMinuteIntervalValue();
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Minute","DeploymentSchedule_IntervalType_Dropdown");
		for(int i=0;i<deploymentPlanPage.minute.size();i++) {
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,deploymentPlanPage.minute.get(i) ,"DeploymentSchedule_IntervalValue_Dropdown");
		deploymentPlanPage.verifyMinuteIntervalValue(PlutoraConfiguration.deploymentPlanData, deploymentPlanPage.minute.get(i));
		}
		
		deploymentPlanPage.addHourIntervalValue();
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Hour","DeploymentSchedule_IntervalType_Dropdown");
		for(int i=0;i<deploymentPlanPage.hour.size();i++) {
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,deploymentPlanPage.hour.get(i) ,"DeploymentSchedule_IntervalValue_Dropdown");
		deploymentPlanPage.verifyHourIntervalValue(PlutoraConfiguration.deploymentPlanData, deploymentPlanPage.hour.get(i));
		}
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Export to XLS")
	public void deploymentPlanSchedule_04() throws InterruptedException {	
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Day","DeploymentSchedule_IntervalType_Dropdown");
		deploymentPlanPage.selectDeploymentScheduleInterval(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"1" ,"DeploymentSchedule_IntervalValue_Dropdown");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "DeploymentSchedule_ExportToXLS_Button", PlutoraConfiguration.objectData);
		Listener.addLogger("Deployment scheduler export to XLS is downloaded successfully!");
		deploymentPlanPage.sleep(3000);
		//Excel Verification
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Deployment_Schedule");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Master Deployment Plan", 1);
		System.out.println(data.toString());
		System.out.println("1"+data[3]);		
		deploymentPlanPage.verifyTextValue("Deployment_Automation",data[0].trim(),PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextValue("On Time",data[1].trim());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+"<br>"+" - Export to XLS is verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Real-time update (deployment plan activities, use two incognito browsers) ")
	public void deploymentPlanSchedule_05() throws InterruptedException, ParseException {
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" -  added system successfully !");
		//Release Creation & System Linked to release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  added release successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  Linked system to release successfully !");
		
		//Deployment creation
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","System_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully !");
		//Add Activity 1
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity added successfully !");
		//Add Activity 2
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_2","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity added successfully !");
		//Create group
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Activity_Checkbox","Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity usergroup added successfully !");
		//Update Planned start/End date
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_1","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_2","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan moved from Draft to Execution Mode successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		//Validate Deployment Schedule 
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OnTime_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name on time status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		DeploymentPage.tempDriver=DeploymentPage.driver;
		DeploymentPage.getNewBrowser(PlutoraConfiguration.browserName, PlutoraConfiguration.hubIPUrl, PlutoraConfiguration.chromePath);
		DeploymentPage.driver=DeploymentPage.newDriver;
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewLogin_Email_Textfield_Value")+" - User2 loggedin successfully");
		
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OnTime_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name on time status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_1","0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_2","0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OverDue_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name overdue status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		DeploymentPage.driver=DeploymentPage.newDriver;
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OverDue_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name overdue status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		DeploymentPage.driver.close();
		
		DeploymentPage.driver=DeploymentPage.tempDriver;
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		
	}
	@Test (description="General appearance and functionality")
	public void deploymentPlanSchedule_06() throws InterruptedException, ParseException  {
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" -  added system successfully !");
		//Release Creation & System Linked to release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  added release successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  Linked system to release successfully !");
		//Deployment creation
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","System_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully !");
		//Add Activity 1
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity added successfully !");
		//Add Activity 2
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"System_Automation","Deployment_Activity_2","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity added successfully !");
		//Create group
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Activity_Checkbox","Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.selectGroupAndUngroup(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity usergroup added successfully !");
		//Update Planned start/End date
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_1","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.selectDateActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_2","10");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_2")+" - Deployment Plan activity updated planned start/end date successfully !");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_Activities_Activity_Close_Button", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan moved from Draft to Execution Mode successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		//Validate Deployment Schedule 
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyText("DeploymentSchedule_Deployment_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  name is filtered in Deployment schedule page successfully !");
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OnTime_Text", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -  Deployment name on time status displayed in deployment schedule successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
		
		deploymentPlanPage.clickButton("DeploymentSchedule_Release_Close_Icon","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" -  not displayed in deployment schedule successfully !");
	}
	@Test (description="Tick/untick 'Show Activity Titles' checkbox")
	public void deploymentPlanSchedule_07() throws InterruptedException  {
		//Deployment schedule untick activity title
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_Show_Activity_Disable_Checkbox","DeploymentSchedule_Show_Activity_Enable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name not displayed in deployment schedule successfully !");
		//Deployment schedule tick activity title
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("DeploymentSchedule_GroupName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_1")+" -  Deployment activity group name displayed in deployment schedule successfully !");
	}
	@Test (description="Resize columns width (using slider)")
	public void deploymentPlanSchedule_08() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		//Get Deployment Plan details pixel values 
		String pixel=deploymentPlanPage.getAttributeValue("DeploymentSchedule_ActivityName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData, "style").split("width:")[1].split("px")[0].trim();
		//Resize column width by drag and drop - one time 
		deploymentPlanPage.dragAndDropByOffset("DeploymentSchedule_ResizeColumn_SliderIcon", PlutoraConfiguration.deploymentPlanData, "10", "0");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		String pixelSlider=deploymentPlanPage.getAttributeValue("DeploymentSchedule_ActivityName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData, "style").split("width:")[1].split("px")[0].trim();
		//Verify Resize column width
		deploymentPlanPage.verifyDoubleValue(pixelSlider, pixel);
		
		
	}
	@Test (description="View DP details via the pop-up window")
	public void deploymentPlanSchedule_09() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.clickButton("DeploymentSchedule_GroupName", "Deployment_Activity_1", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify View DP detauls via the pop-up window 
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_ViewPopupWindow", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("View DP details via pop-up windows displayed successfully !");
		deploymentPlanPage.switchToWindowPopup();
		//Verify View DP detauls via the pop-up window  - Activity Name
		deploymentPlanPage.verifyText("DeploymentSchedule_ViewPopupWindow_ActivityName", "Deployment_Activity_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger("View DP details via pop-up windows displayed successfully !");
		//Close View DP details vie the pop-up window
		deploymentPlanPage.clickButton("DeploymentSchedule_GroupName", "Deployment_Activity_1", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "DeploymentSchedule_ViewPopupWindow_CloseIcon", PlutoraConfiguration.objectData);
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		Listener.addLogger("View DP details via pop-up window closed successfully !");
	}
	@Test (description="Open a DP via the pop-up window")
	public void deploymentPlanSchedule_10() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentSchedulePage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.closeDeploymentScheduleReleases(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.searchDeploymentScheduleRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"DeploymentSchedule_View_Button",PlutoraConfiguration.objectData);
		String parentWindow = WebGenericUtilLib.driver.getWindowHandle();
		deploymentPlanPage.clickButton("DeploymentSchedule_Deployment_Name", "Deployment_Automation", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.switchToWindowPopup();
		deploymentPlanPage.validateElementDisplayed("DeploymentSchedule_OpenPopupWindow", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Open a DP via the pop-up window displayed successfully !");
		deploymentPlanPage.verifyText("DeploymentSchedule_OpenPopupWindow_SystemName", "System_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger("Open a DP via the pop-up window "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" displayed successfully !");
		
		deploymentPlanPage.closeWindowTab();
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		
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
		
	}
}
