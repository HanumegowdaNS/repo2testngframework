package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanActivitySetsTab {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();
	EnvironmentPage environmentPage= new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();
	ChangesPage changePage = new ChangesPage();
	
	@Test (description="Create activity set (only Draft mode)")
	public void deploymentPlanActivitesSetTab_01() throws InterruptedException, ParseException  {
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
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation","Deployment_Automation","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.clickOnMasterActivitySetsDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_ActivitySet")+" - Master Deployment Plan Activity Set is added successfully");
		
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		//deploymentPlanPage.addMasterDeploymentPlanActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Activity_Name_1","Systems_Test_Automation_Id_2");
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Deployment_Activity_Name_1","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Master Deployment Plan Activity is added successfully");
		//deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.linkActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Master Deployment Plan Activity linked to Activity set successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Deployment_Activity_Name_2","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Deployment Plan Activity is added successfully");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.linkActivitySet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_2")+" - Deployment Plan Activity linked to Activity set successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
		deploymentPlanPage.clickOnMasterActivitySetsDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyDeploymentPlanInActivitiesSet(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation", "Deployment_Automation","2");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.selectStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Activity_Name_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name_1")+" - Master Deployment Plan moved from draft to execution successfully");
		deploymentPlanPage.clickOnButton(PlutoraConfiguration.deploymentPlanData,"Deployment_Activities_Activity_Close_Button",PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivityStatusList();
		for(int i=0;i<deploymentPlanPage.activityStatus.size();i++) {
			deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
			deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name_1",
					PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
			deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			deploymentPlanPage.changeStatusActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, deploymentPlanPage.activitySet.get(deploymentPlanPage.activityStatus.get(i)));
			deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData,  PlutoraConfiguration.objectData);
			deploymentPlanPage.clickOnMasterActivitySetsDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
			if(deploymentPlanPage.activityStatus.get(i).equals("Not started")) {
				deploymentPlanPage.validateElementDisplayed("Deployment_Master_Activity_Notstarted_Status_Count", deploymentPlanPage.activityStatus.get(i),PlutoraConfiguration.deploymentPlanData);
				Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_ActivitySet")+" - "+deploymentPlanPage.activityStatus.get(i)+" - Master Deployment Plan activity set count verified successfully");
			}else {
				deploymentPlanPage.validateElementDisplayed("Deployment_Master_Activity_Status_Count", deploymentPlanPage.activityStatus.get(i),PlutoraConfiguration.deploymentPlanData);
				Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_ActivitySet")+" - "+deploymentPlanPage.activityStatus.get(i)+" - Master Deployment Plan activity set count verified successfully");
			}
		}
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" Deployment Plan activity is deleted successfully");
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" Master Deployment Plan activity is deleted successfully");
	}
	
}
