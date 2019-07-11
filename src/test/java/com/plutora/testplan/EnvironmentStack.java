package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentStack {
	ReleasePage releasePage = new ReleasePage();
	EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test (description=" -> Live Search")
	public void environmentStack_01() throws InterruptedException, ParseException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		//System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		//Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EnvGrp_Test_Automation_Id","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		//Add host,layer and componet
		environmentPage.addHLCToEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is add host,layer and component successfully !");
		//Environment Stack
		environmentPage.gotoEnvironmentStack(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.sendKeys("EnvironmentStack_Textbox", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.clickButton("EnvironmentStack_Dropdown_Option", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - is selected from Environment Stack dropdown successfully");
		environmentPage.validateElementDisplayed("EnvironmentStack_Diagram", PlutoraConfiguration.environmentData);
		Listener.addLogger(" Environment Stack digram is displayed successfully !");
		
	}
	
	@Test (description=" -> Navigation between branches by clicking on it")
	public void environmentStack_02() throws InterruptedException  {
		environmentPage.gotoEnvironmentStack(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Environment Stack Layer
		environmentPage.sendKeys("EnvironmentStack_Textbox", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickButton("EnvironmentStack_Dropdown_Option", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.verifyText("EnvironmentStack_Layer_Disable", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" -  is displayed in environment stack successfully !");
		//Env Group
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.moveAndClickElement("EnvironmentStack_Layer_Disable_Checkbox","EnvGrp_Test_Automation_Id", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.sleep(4000);
		environmentPage.verifyText("EnvironmentStack_Layer_Disable", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" -   is displayed in environment stack successfully !");
		//Host
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(4000);
		environmentPage.moveAndClickElement("EnvironmentStack_Layer_Disable_Checkbox","Env_Test_Automation_Id", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.sleep(4000);
		environmentPage.verifyText("EnvironmentStack_Layer_Disable", "Environment_Host_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" -  is displayed in environment stack successfully !");
		//Layer
		environmentPage.sleep(4000);
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.moveAndClickElement("EnvironmentStack_Layer_Disable_Checkbox","Environment_Host_Name", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.sleep(4000);
		environmentPage.verifyText("EnvironmentStack_Layer_Disable", "Environment_Layer_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Name")+" -  is displayed in environment stack successfully !");
		//Component
		environmentPage.sleep(4000);
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.moveAndClickElement("EnvironmentStack_Layer_Disable_Checkbox","Environment_Layer_Name", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.sleep(4000);
		environmentPage.verifyText("EnvironmentStack_Layer_Disable", "Environment_Component_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name")+" - is displayed in environment stack successfully !");
		
		
	}
	@Test (description=" -> Go Back to Environments' link at the left top corner")
	public void environmentStack_04() throws InterruptedException  {
		environmentPage.gotoEnvironmentStack(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentStack_GoBackToEnvironment_Link", PlutoraConfiguration.objectData);
		environmentPage.verifyText("Header_Text", "Environment",PlutoraConfiguration.objectData);
		Listener.addLogger("Go Back to Environments' link at the left top corner returned to Environment Page successfully !");
		
	}
	@Test (description=" -> View Full Screen")
	public void environmentStack_03() throws InterruptedException, AWTException  {
		environmentPage.gotoEnvironmentStack(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.sendKeys("EnvironmentStack_Textbox", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(500, "Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickButton("EnvironmentStack_Dropdown_Option", "EnvGrp_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		environmentPage.getCoordinates("EnvironmentStack_Layer_Disable","EnvGrp_Test_Automation_Id", PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_1", "ycoordi_1");
		environmentPage.clickElementUsingJavaScript("EnvironmentStack_FullScreenButton",
				PlutoraConfiguration.environmentData);
		environmentPage.sleep(2000);
		environmentPage.getCoordinates("EnvironmentStack_Layer_Disable","EnvGrp_Test_Automation_Id", PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_2", "ycoordi_2");
		environmentPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_1"))) <= (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_2"))));
		environmentPage.escape();

		//System Deletion
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" is deleted successfully !");
		
		//Delete Environment Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		envGroupPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment Group is deleted successfully");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	
}
