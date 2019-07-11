package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanRACIMatrix {
	
	DeploymentPage deploymentPlanPage= new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	NewUserPage newUserPage = new NewUserPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ChangesPage changePage = new ChangesPage();
	@Test (description="Add/edit/delete (only one accountable is allowed)")
	public void deploymentPlanRACIMatrix_01() throws InterruptedException, ParseException  {
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
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 1, "Deployment_Plan_AddStakeholder_Button");
		Listener.addLogger("Deployment plan stakeholder added successfully  !");
		deploymentPlanPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Deployment plan stakeholder verified successfully  !");
		new ReleasePage().selectAllRACICheckbox(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyText("StakeholderRACIResponsible_Text","R",PlutoraConfiguration.releasesData);
		deploymentPlanPage.verifyText("StakeholderRACIAccountable_Text","A",PlutoraConfiguration.releasesData);
		deploymentPlanPage.verifyText("StakeholderRACIConsulted_Text","C",PlutoraConfiguration.releasesData);
		deploymentPlanPage.verifyText("StakeholderRACIInformed_Text","I",PlutoraConfiguration.releasesData);
		Listener.addLogger("Deployment plan RACI role is verified successfully  !");
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Plan_Accountable_Icon", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Deployment plan RACI accountable is verified successfully  !");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnRACIDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		new ReleasePage().verifyStakeholderAccountableDisabled(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Plan_Stakeholder_Delete_Icon","Stakeholder_Name",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger("Deployment plan stakeholder is deleted successfully  !");
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name"));
		Listener.addLogger("Deployment plan stakeholder is verified after deletion successfully  !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
	}
	
}
