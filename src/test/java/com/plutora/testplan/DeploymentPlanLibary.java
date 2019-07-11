package com.plutora.testplan;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class DeploymentPlanLibary {
	DeploymentPage deploymentPlanPage= new DeploymentPage();
	ReleasePage releasePage =new ReleasePage();
	
	@Test (description="Live Search")
	public void deploymentPlanLibary_01() throws InterruptedException  {
		WebGenericUtilLib.driver.navigate().refresh();
		deploymentPlanPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_1");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_2")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", "Systems_Test_Automation_Id_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id_2","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is created successfully !");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyText("Deployment_LiveSearched_Link","Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is verified from Live Search successfully !");
	}
	@Test (description="Add/edit/delete deployment plans")
	public void deploymentPlanLibary_02() throws InterruptedException {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.updateDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" -Deployment Plan is updated successfully !");
		deploymentPlanPage.verifyUpdatedDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is verified successfully !");
	}
	
	@Test (description="Duplicate")
	public void deploymentPlanLibary_03() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2","Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added successfully !");
		deploymentPlanPage.createDuplicateDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Deployment Plan duplicated successfully !");
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.verifyText("Deployment_LiveSearched_Link", "Copy_Deployment_Automation", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Copy_Deployment_Automation")+" - Duplicate Deployment Plan verified successfully !");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Copy_Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Activity_Name_Text","Deployment_Activity_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		String date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(deploymentPlanPage.getCurrentDate("2")));
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_Start_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyTextAttributeValueContains("Deployment_Activity_End_Time_Calender_Textbox",date,PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Deployment Plan verified with start & end time after duplicate successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="DP update on the grid going through the modes(Draft/Approved/Execution/Completed)")
	public void deploymentPlanLibary_04() throws InterruptedException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_2")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id_2");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", "Systems_Test_Automation_Id_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation","Systems_Test_Automation_Id_2","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is created successfully !");
		
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Draft_Icon", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan Grid - Draft - verified successfully !");
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Approved_Icon", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan Grid - Approved - verified successfully !");
		
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Execution_Icon", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan Grid -Execution - verified successfully !");
		
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Complete_Button");
		//deploymentPlanPage.clickOnDeploymentPlanCloseIcon(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Grid_Completed_Icon", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan Grid - Completed - verified successfully !");
	}
	@Test (description="Details appearing at the specific deployment plan row (Name, Description, Accountable, etc. - all columns)")
	public void deploymentPlanLibary_05() throws InterruptedException {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("Deployment_System_Text","Systems_Test_Automation_Id_2",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.verifyTextContains("Deployment_Release_Text","PRelease_Automation_Name",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "New_DP_ExtID_Description")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id_2")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+"<br>"+" All elements are displayed in deployment plan details page");
		
		//deploymentPlanPage.clickOnDeploymentPlanCloseIcon(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Close_Icon", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.verifyDeploymentGridDetails("Deployment_Automation", "PRelease_Automation_Id", "PRelease_Automation_Name", PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name")+"<br>"+" All elements are displayed in deployment plan grid page");
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan deleted successfully !");
	}
	
	@Test (description="Deployment : Filter By")
	public void deploymentPlanLibary_06() throws InterruptedException, ParseException {
		
		/* Navigating to Deployment Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Clicking on New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Creating a new Deployment plan */
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on RACI tab */
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Adding Stakeholder */
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Loggedin_Username_Value", "Releases_CStakeholder_Button");
		/* Closing Deployment Plan Pop Up */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Click on I'm a Stakeholder */
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_IamStakeholder_Tab",
				PlutoraConfiguration.objectData);
		/* Verifying I'm a Stakeholder */
		deploymentPlanPage.verifyTextContains("Deployment_DeploymentName_Link", "Deployment_Automation",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Presence verified on I'm a Stakeholder");
		/* Click on My Portfolio Association */
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_MyPortfolioAssociation_Tab",
				PlutoraConfiguration.objectData);
		/* Verifying Portfolio Association */
		deploymentPlanPage.verifyTextContains("Deployment_DeploymentName_Link", "Deployment_Automation",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Presence verified on clicking My Portfolio Association");
		/* Clicking on All */
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_All_Tab",
				PlutoraConfiguration.objectData);
		/* Verifying All Result */
		deploymentPlanPage.verifyTextContains("Deployment_DeploymentName_Link", "Deployment_Automation",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Presence verified on clicking All");
		
	}
	
	@Test (description="Deployment : Action -> Bulk Update Stakeholder")
	public void deploymentPlanLibary_07() throws InterruptedException, ParseException {
      
		/* Navigating to Deployment Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Clicking on New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Creating a new Deployment plan #1 */
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_Bulk_1")
				+ " - Deployment Plan is added successfully");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_1");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_1");
		/* Clicking on RACI tab */
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Adding Stakeholder */
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Loggedin_Username_Value", "Releases_CStakeholder_Button");
		/* Closing Deployment Plan Pop Up */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Clicking on New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Creating a new Deployment plan #2 */
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_Bulk_2")
				+ " - Deployment Plan is added successfully");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_2");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_2");
		/* Clicking on RACI tab */
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Adding Stakeholder */
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Loggedin_Username_Value", "Releases_CStakeholder_Button");
		/* Closing Deployment Plan Pop Up */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Selecting Deployment Plans to update stakeholder */
		deploymentPlanPage.sendKeys("Deployment_LiveSearchTextbox", "Deployment_Automation_Bulk_",
				PlutoraConfiguration.deploymentPlanData);
		/* Selecting Checkboxes */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_LiveSearched_Checkbox",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_Bulk_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_LiveSearched_Checkbox",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation_Bulk_2"),
				PlutoraConfiguration.deploymentPlanData);
		/* Updating Stakeholders */
		deploymentPlanPage.updateStakeholders(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying First Deployment Plan for Updated stakeholder */
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_1");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_1");
		/* Clicking on RACI tab */
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Verifying Presence of Updated Name */
		deploymentPlanPage.verifyText("DeploymentPlan_UpdatedStakeholderName_Link", "Deployment_Plan_UpdatedName",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Plan_UpdatedName")
				+ " - Verified to be updated in the Deployment Plan");
		/* Clicking on Save And Close */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton", PlutoraConfiguration.deploymentPlanData);
		/* Verifying Second Deployment Plan for Updated stakeholder */
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_2");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation_Bulk_2");
		/* Clicking on RACI tab */
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Verifying Presence of Updated Name */
		deploymentPlanPage.verifyText("DeploymentPlan_UpdatedStakeholderName_Link", "Deployment_Plan_UpdatedName",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Plan_UpdatedName")
				+ " - Verified to be updated in the Deployment Plan");
		/* Clicking on Save And Close */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton", PlutoraConfiguration.deploymentPlanData);

	}	
	
}
