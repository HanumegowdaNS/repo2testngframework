package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentGroupsGroupMembersTab {

	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test (description="Bring down the Environments based on the Group")
	public void environmentGroupMembersTab_01() throws InterruptedException  {
		//environmentGroupsPage.closeEnvironmentGroupPage(PlutoraConfiguration.environmentData);
		//Create EV
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment is created successfully !");
		
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment is created successfully !");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Create EG
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Search EG
		environmentGroupsPage.searchEnvironmentOnEnvironmentGroup(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		//Verify EG
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment shows successfully");
		
		environmentGroupsPage.searchEnvironmentOnEnvironmentGroup(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment shows successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	

	@Test (description="Add Environment to Env. Group (Drag and Drop)")
	public void environmentGroupMembersTab_02() throws InterruptedException  {
		// Create EV
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " - Environment is created successfully !");

		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " - Environment is created successfully !");

		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		// Create EG
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		// Drag and Drop
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_1",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " -  Environment shows after drag and drop successfully");

		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_2",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " -  Environment shows after drag and drop successfully");

		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}

	@Test (description="Remove the Environment from Env. Group (Drag and Drop)")
	public void environmentGroupMembersTab_03() throws InterruptedException  {
		// Create EV
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " - Environment is created successfully !");

		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " - Environment is created successfully !");

		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		// Create EG
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		// Drag and Drop
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_1",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " -  Environment shows after drag and drop successfully");

		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentGroupsPage.verifyText("EnvGrp_Environment_Name", "Environment_Automation_2",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " -  Environment shows after drag and drop successfully");

		/*
		 * environmentGroupsPage.
		 * clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration
		 * .environmentData, PlutoraConfiguration.testData,
		 * PlutoraConfiguration.objectData);
		 */
		/*environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");*/
		//Remove Drag and drop
		environmentGroupsPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentGroupsPage.verifyWebElementCount("EnvGrp_Environment_Name", "Environment_Automation_1","1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment removed from Group Member section successfully");
		
		environmentGroupsPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentGroupsPage.verifyWebElementCount("EnvGrp_Environment_Name", "Environment_Automation_2","1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment removed from Group Member section successfully");
		
		/*environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");*/
		//Delete EG
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	
	@Test (description="Open the Environment via hyperlink in 'Group Members' tab")
	public void environmentGroupMembersTab_04() throws InterruptedException  {
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")
				+ " - Environment is created successfully !");
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating Environment Group */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Searching Environment Group */
		environmentGroupsPage.searchEnvironmentOnEnvironmentGroup(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		/* Verify Environment Group */
		environmentGroupsPage.clickButton("ENVGroups_EnvironmentUnderGroupMember_Link", "Environment_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.validateElementDisplayed("Environment_Name_Label", "Environment_Automation",
				PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvGroups_EnvSaveAndCloseButton",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvGroupsMember_SaveAndClose_Button",
				PlutoraConfiguration.objectData);
	}

}
