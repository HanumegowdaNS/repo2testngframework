package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class EnvironmentManageGroups {

	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	
	
	@Test (description="Live Search Env. Group")
	public void environmentMangeGroupsTab_01() throws InterruptedException  {
		WebGenericUtilLib.driver.navigate().refresh();
		environmentGroupsPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentGroupsPage.sleep(2000);
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Create
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Verify
		environmentGroupsPage.verifyText("EnvGroups_EnvNameLink", "EnvGrp_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("EnvGroups_Description", "New_ENV_Groups_Description", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("EnvGroups_PhaseName", "EnvGroups_Phase", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" -  Environment Group Live search is verified successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	
	@Test (description="Add/edit/delete env. group")
	public void environmentMangeGroupsTab_02() throws InterruptedException  {
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Update
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.updateEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is updated successfully");
		
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.verifyUpdatedEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is verified after updation successfully");
		//Delete
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}

	
}
