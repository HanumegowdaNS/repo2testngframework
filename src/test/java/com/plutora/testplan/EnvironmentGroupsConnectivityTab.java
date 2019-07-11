package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentGroupsConnectivityTab {

EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test (description="Batch Add")
	public void environmentConnectivityTab_01() throws InterruptedException  {
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
		//Create
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Drag and drop
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment shows successfully");
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment shows successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//add batch
		environmentGroupsPage.addBatch(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"");
		Listener.addLogger("Added batch successfully");
		//verify 
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivityGrid_DirectionRight", PlutoraConfiguration.environmentData);
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "EnvGrp_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available after adding batch successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available after adding batch successfully");
		Listener.addLogger("Environment Right direction is validated successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type")+" -  Environment Type  is available after adding batch successfully");
		//Change Directions
		environmentGroupsPage.changeDirectionInConnectivityGrid(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_ConnectivityGrid_DirectionRight", "EnvGrp_ConnectivityGrid_DirectionLeft_Option");
		Listener.addLogger("Environment Right direction is moved to left direction successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Verify
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivityGrid_DirectionLeft", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment left direction is validated successfully");

		environmentGroupsPage.changeDirectionInConnectivityGrid(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_ConnectivityGrid_DirectionLeft", "EnvGrp_ConnectivityGrid_DirectionLeftAndRight_Option");
		Listener.addLogger("Environment Left direction is moved to Rightandleft direction successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivityGrid_DirectionLeftAndRight", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment LeftAndRight direction is validated successfully");
		
		environmentGroupsPage.deleteConnection(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment Group connection is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	

	@Test (description="Add/Delete Connection")
	public void environmentConnectivityTab_02() throws InterruptedException  {
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Add Connection
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.addConnection(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Type","EnvGrp_Type_Dropdown_Option");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Added connection successfully");
		//Verify Connection
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivityGrid_DirectionLeft", PlutoraConfiguration.environmentData);
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "EnvGrp_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available after adding batch successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available after adding batch successfully");
		Listener.addLogger("Environment Left direction is validated successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type")+" -  Environment Type  is available after adding batch successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		environmentGroupsPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully");
		//Verify Environment in Map
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully");
		Listener.addLogger("Environment Left direction is validated successfully");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Change Direction
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.changeDirectionInConnectivityGrid(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_ConnectivityGrid_DirectionLeft", "EnvGrp_ConnectivityGrid_DirectionLeftAndRight_Option");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Environment Left direction is moved to Rightandleft direction successfully");
		
		environmentGroupsPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		environmentGroupsPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully");
		//Verify Environment in Map
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully");
		Listener.addLogger("Environment Left direction is validated successfully");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Delete Connection
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.deleteConnection(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Environment_Automation_1");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment Group connection is deleted successfully");
		//Remove EV
		environmentGroupsPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentGroupsPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment removed from Group Member section successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment removed from Group Member section successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Remove EG
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	
	@Test (description="Move Connection")
	public void environmentConnectivityTab_03() throws InterruptedException  {
		/*Creating Environment #1 */
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " - Environment is created successfully !");
		
		/*Creating Environment #2 */	
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " - Environment is created successfully !");
		/*Creating EnvironmentGroup #1 */
		/*Navigating to Env Group*/
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating EnvironmentGroup #2 */
		/*Navigating to Env Group*/
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		/* Adding Environment #1 to Group */
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		/* Adding Environment #2 to Group */
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		/* Clicking on Save button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Connectivity Tab */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGrp_Connectivity_Tab",
				PlutoraConfiguration.environmentData);
		/* Adding Connection */
		environmentGroupsPage.addConnection(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"EnvGrp_Type","EnvGrp_Type_Dropdown_Option");
		/* Clicking on Save button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Moving Connection */
		environmentGroupsPage.moveConnection(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Reading Env Group #2 */
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation_2");
		/* Clicking on Group Members Tab */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGrp_GroupMember_Tab",
				PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Presence of Group Members */
		environmentGroupsPage.validateElementDisplayed("EnvGrp_GroupMemberName_Link", "Environment_Automation_1",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.validateElementDisplayed("EnvGrp_GroupMemberName_Link", "Environment_Automation_2",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		/* Clicking On Save And Close */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Ability to change settings in existing connection")
	public void environmentConnectivityTab_04() throws InterruptedException  {
		/*Creating Environment #1 */
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " - Environment is created successfully !");
		
		/*Creating Environment #2 */	
		new EnvironmentPage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " - Environment is created successfully !");
		/*Creating EnvironmentGroup #1 */
		/*Navigating to Env Group*/
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating EnvironmentGroup #2 */
		/*Navigating to Env Group*/
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")
				+ " - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		/* Adding Environment #1 to Group */
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		/* Adding Environment #2 to Group */
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		/* Clicking on Save button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Connectivity Tab */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGrp_Connectivity_Tab",
				PlutoraConfiguration.environmentData);
		/* Adding Connection */
		environmentGroupsPage.addConnection(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"EnvGrp_Type","EnvGrp_Type_Dropdown_Option");
		/* Clicking on Save button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.updateConnection(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Clicking on Save button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Validating The Presence of Source And Target after update*/
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivitySourceAfterUpdate_label",
				"Environment_Automation_2", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " - Presence of Environment after update verified !");
		environmentGroupsPage.validateElementDisplayed("EnvGrp_ConnectivityTargetAfterUpdate_label",
				"Environment_Automation_1", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " - Presence of Environment after update verified !");
		/* Clicking On Save And Close */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
}
