package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanInformationTab {

	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	NewUserPage newUserPage = new NewUserPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ChangesPage changePage = new ChangesPage();
	
	@Test (description="Details appearing at the top chevron panel")
	public void deploymentPlanInformationTab_01() throws InterruptedException, ParseException  {
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Draft_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Draft_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		String date1=deploymentPlanPage.getTextData("Deployment_Top_Chevron_Date", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Top chevron panel show DP is in Draft mode, update time = create time, updater = creater");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Approved_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Approved_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		String date2=deploymentPlanPage.getTextData("Deployment_Top_Chevron_Date", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDate(deploymentPlanPage.changeTopChevronDateFormat(date1), deploymentPlanPage.changeTopChevronDateFormat(date2));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Top chevron panel show DP is in Approved mode, update time = create time, updater = creater ");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_MoveToDraft_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Draft_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Draft_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Top chevron panel show DP is in Back to draft mode, update time = create time, updater = creater");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Execution_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Execution_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		date1=deploymentPlanPage.getTextData("Deployment_Top_Chevron_Date", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDate(deploymentPlanPage.changeTopChevronDateFormat(date2), deploymentPlanPage.changeTopChevronDateFormat(date1));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Top chevron panel show DP is in Execution mode, update time = create time, updater = creater ");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Complete_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Completed_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Completed_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		date2=deploymentPlanPage.getTextData("Deployment_Completed_Top_Chevron_Date", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDate(deploymentPlanPage.changeTopChevronDateFormat(date1), deploymentPlanPage.changeTopChevronDateFormat(date2));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Top chevron panel show DP is in Completed mode, update time = create time, updater = creater");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - delete successfully");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
	}
	@Test (description="Details appearing at the window title")
	public void deploymentPlanInformationTab_02() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_Created_Window_title", "Loggedin_Username_Value", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value")+" - Deployment Plan Window title displayed in the details page");
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("0")));
		date=deploymentPlanPage.formatDateField(date);
		deploymentPlanPage.verifyTextContains("Deployment_Created_Window_title", date, PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan window title show 'Created by' = 'Last Updated by' = tester, update time = the time");
		
		String updatedDate=deploymentPlanPage.getTextData("Deployment_Updated_Window_title",date, PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.updateDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan updated successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyDate(updatedDate, deploymentPlanPage.getTextData("Deployment_Updated_Window_title",date, PlutoraConfiguration.deploymentPlanData));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan  window title show 'Last Update by' = tester, update time = the time");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Add/delete multiple systems")
	public void deploymentPlanInformationTab_03() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id_1","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.systemCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		deploymentPlanPage.selectSystem(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is selected in DP details page");
		deploymentPlanPage.verifyText("Deployment_System_Text","Systems_Test_Automation_Id_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is verified in DP details page");
		deploymentPlanPage.systemCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is disappear in DP details page");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Bringing down releases from selected systems\n" + 
			"(excluding releases in 'End State' status)")
	public void deploymentPlanInformationTab_04() throws InterruptedException, ParseException  {
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectSystem(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		deploymentPlanPage.verifyText("Deployment_System_Text","Systems_Test_Automation_Id_1",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		//deploymentPlanPage.releaseCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Name");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_1")+" - System is selected in DP details page");
		deploymentPlanPage.selectRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Name","Deployment_Release_Textbox");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" - Release is selected in DP details page");
		deploymentPlanPage.validateElementDisplayed("Deployment_NoRelease_Text", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" - Display yellow warning message if no release with future implement date is available; Display releases drop-down list if correlated systems are selected");
		
		deploymentPlanPage.selectSystem(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is selected in DP details page");
		deploymentPlanPage.verifyText("Deployment_System_Text","Systems_Test_Automation_Id",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Name","Deployment_Release_Textbox");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" - Release is selected in DP details page");
		deploymentPlanPage.clickOnDeploymentRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyTextContains("Deployment_Release_Text","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+" - Release is verified in DP details page");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Bringing down systems from selected child deployment plans - ONLY MDP")
	public void deploymentPlanInformationTab_05() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation","Deployment_Automation","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Deployment Master plan is created successfully");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Integrated child DP to Master Deployment Plan successfully");
		deploymentPlanPage.verifyText("Deployment_System_Text","Systems_Test_Automation_Id",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - System is verified successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Bringing down releases from selected systems - ONLY MDP")
	public void deploymentPlanInformationTab_06() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Name","Deployment_Master_Plan_Release_Textbox");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Release is selected successfully");
		deploymentPlanPage.clickOnDeploymentRelease(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Name");
		deploymentPlanPage.verifyTextContains("Deployment_Release_Text","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Release is verified successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Delete Release")
	public void deploymentPlanInformationTab_07() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.releaseCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Name");
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Release is disappear from deployment plan details page successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	@Test (description="Edit portfolio association")
	public void deploymentPlanInformationTab_08() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectEditPortfolioAssociation(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - portfolio association is selected successfully");
		deploymentPlanPage.verifyTextAttributeValue("Deployment_Portfolio_Association_Textbox","Deployment_Portfolio_Association",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - portfolio association is verified successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="DP update going through the modes (Draft/Approved/Execution/Completed)")
	public void deploymentPlanInformationTab_09() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Draft_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Draft_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Draft mode updated successfully");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Approved_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Approved_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Approved mode updated successfully");	
	
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_MoveToDraft_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Draft_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Draft_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Back to draft mode updated successfully");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Execution_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Execution_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Execution mode updated successfully");
		
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Complete_Button");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Completed_Label",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Completed_UserName_Text",PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Completed mode updated successfully");
		
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Completed mode updated successfully");
	}
//	@Test (description="Broadcasting (email notification)")
	public void deploymentPlanInformationTab_10() throws InterruptedException, AWTException  {
		deploymentPlanPage.refresh(PlutoraConfiguration.objectData);
		newUserPage.addNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_LastName");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LoginEmail")+" - New User is added successfully");
		newUserPage.activateNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LoginEmail")+" - New User is activited successfully");
		//Logout the user
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		Thread.sleep(5000);
		
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name","NewUser_FirstName");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan Activity is added successfully");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Deployment_Broadcast_Remaining_Duration","NewUser_FirstName","Deployment Plan","Broadcast remaining duration");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Broadcast_Remaining_Duration")+" - Email Template is added successfully");
		customizationPage.addEmailTemplate(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_Email_Template_Wizard_Trigger_Option", "Deployment_Broadcast_Actual/Planned_Duration","NewUser_FirstName","Deployment Plan","Broadcast actual/planned duration");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Broadcast_Actual/Planned_Duration")+" - Email Template is added successfully");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger("Deployment Plan is moved from draft to execution successfully");
		
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Broadcast_Remaining_Duration_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Broadcast_Remaining_Duration",NewUserPage.loginEmail);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LoginEmail")+" - Deployment_Broadcast_Remaining_Duration email notification verified successfully");
		
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Actual/Planned_Duration_Button",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Broadcast_Actual/Planned_Duration",NewUserPage.loginEmail);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LoginEmail")+" - Deployment_Broadcast_Actual/Planned_Duration email notification verified successfully");
		
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		newUserPage.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		newUserPage.deleteNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		newUserPage.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear(200,"Loading_Gif", PlutoraConfiguration.objectData);
		newUserPage.sleep(5000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "LoginEmail")+" - New user is deleted successfully");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
		
		DeploymentPage.driver.navigate().refresh();
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_Email_Template_Wizard_Option");
		customizationPage.clickElementUsingJavaScript("Deployment_Customization_EmailTemplate_Delete_Field","Deployment_Broadcast_Remaining_Duration",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		customizationPage.clickElementUsingJavaScript("Deployment_Customization_EmailTemplate_Yes_Button",PlutoraConfiguration.customizationData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Broadcast_Remaining_Duration")+" - Deleted successfully");
		customizationPage.clickElementUsingJavaScript("Deployment_Customization_EmailTemplate_Delete_Field","Deployment_Broadcast_Actual/Planned_Duration",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(3000);
		customizationPage.clickElementUsingJavaScript("Deployment_Customization_EmailTemplate_Yes_Button",PlutoraConfiguration.customizationData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Broadcast_Actual/Planned_Duration")+" - Deleted successfully");

		customizationPage.clickElementUsingJavaScript("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		deploymentPlanPage.waitForLoadingIconDisappear(200,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
	}
	
	@Test (description="Save/Delete/Close DP")
	public void deploymentPlanInformationTab_11() throws InterruptedException  {
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		deploymentPlanPage.logout(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData,PlutoraConfiguration.applicationURL);
		DeploymentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnDeploymentPlanCloseIcon(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.updateDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - updated successfully");
		deploymentPlanPage.verifyUpdatedDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - verified successfully");
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - deleted successfully");
		
	}

	@Test (description="+ New Child Deployment Plan button in MDP")
	public void deploymentPlanInformationTab_12() throws InterruptedException, AWTException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Deployment Master plan is created successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.createChildFromMasterDP(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation") +" - created successfully and linked Master DP " + PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation"));
		//verify if the child is linked to master deployment plan
		deploymentPlanPage.verifyText("Deployment_Child_Dependecy_Textbox", "Deployment_Automation", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - deleted successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
	}
	
	@Test (description="+ Add/Remove Deployment Plans button in MDP")
	public void deploymentPlanInformationTab_13() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - created successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlanWithChild(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation", "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation") +" - created successfully and linked Child DP " + PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation"));
		//verify if the master is linked to child deployment plan
		deploymentPlanPage.verifyText("Deployment_Child_Dependecy_Textbox", "Deployment_Automation", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.click("Deployment_SaveCloseButton", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - deleted successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
	}
	
	@Test (description="Associate with Master Deployment Plan in CDP")
	public void deploymentPlanInformationTab_14() throws InterruptedException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Deployment Master plan is created successfully");
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.associateDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation", "Deployment_Master_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - created successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//verify the master deployment plan is linked to child deployment plan
		deploymentPlanPage.verifyText("Depolyment_Master_DP_Text", "Deployment_Master_Automation", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - deleted successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
	}
	
	@Test (description="Overview: Activity Summary (Total, Overdue, Completed, Next Due in)")
	public void deploymentPlanInformationTab_15() throws InterruptedException, ParseException  {
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
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesTotalCount_Label", "1",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData, "Deployment_SaveCloseButton",
				PlutoraConfiguration.objectData);
		deploymentPlanPage.modifyActivityPreviousDate(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation", "-2");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesOverdueCount_Label", "1",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.modifyActivityFutureDate(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation", "2");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesNextDueInCount_Label", "1",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_ExecutionAction_Button",
				PlutoraConfiguration.deploymentPlanData);

	}
	@Test (description="Overview: Remaining Duration)")
	public void deploymentPlanInformationTab_16() throws InterruptedException, ParseException  {
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
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")
				+ " - Deployment Plan Activity is added successfully");
		deploymentPlanPage.modifyActivityDate(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "-2", "2");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_ActivitiesRemainingDuration_Label", "1",
				PlutoraConfiguration.deploymentPlanData);		
	}
	
	@Test (description="Overview:Actual/Planned Duration (Dial Circles)")
	public void deploymentPlanInformationTab_17() throws InterruptedException, ParseException  {
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
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.modifyActualPlanned(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.verifyText("Deployment_ActivitiesPlannedDuration_Icon", "1 minutes",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test(description = "Audit")
	public void deploymentPlanInformationTab_18() throws InterruptedException, ParseException {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.sendKeys("Deployment_NameTextfield",
				PropertiesCache.setProperty(PlutoraConfiguration.testData, "Deployment_Automation_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		// Modify
		deploymentPlanPage.clickOnAudit(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		try {
			DeploymentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
					"Deployment_InformationAuditLiveSearch_Input", PlutoraConfiguration.objectData);
		} catch (Exception e) {
			DeploymentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		DeploymentPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
				"Deployment_InformationAuditModifiedChecked_Checkbox", "Deployment_InformationAuditModified_Checkbox",
				PlutoraConfiguration.objectData, "xpath");
		deploymentPlanPage.verifyListText("Deployment_InformationAuditModifiedDPName_label", "Deployment_Automation_1",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
				"Deployment_InformationAuditClose_Icon", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		// Add
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_1");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_1");
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, 1, "Deployment_Plan_AddStakeholder_Button");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnAudit(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);

		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
				"Deployment_InformationAuditAddedChecked_Checkbox", "Deployment_InformationAuditAdded_Checkbox",
				PlutoraConfiguration.objectData, "xpath");
		deploymentPlanPage.verifyListText("Deployment_InformationAuditStakeholder_label", "Stakeholder_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,
				"Deployment_InformationAuditClose_Icon", PlutoraConfiguration.objectData);

	}
}
