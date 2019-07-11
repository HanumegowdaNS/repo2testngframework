package com.plutora.testplan;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentImpactMatrixPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentMap {

	EnvironmentImpactMatrixPage environmentImpactMatrixPage = new EnvironmentImpactMatrixPage();
	EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
	EnvironmentPage environmentPage=new EnvironmentPage();
	
	@Test (description=" -> Env. Map -> Select Env. Group -> View")
	public void environmentMap_01() throws InterruptedException, ParseException {
		//Create Environment
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment is created successfully !");
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment is created successfully !");
		//Create Env Group
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		
		envGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		
		//Drag and drop
		envGroupPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment shows successfully");
		envGroupPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment shows successfully");
				
		envGroupPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Add Connection
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvGrp_Connectivity_Tab", PlutoraConfiguration.objectData);
		envGroupPage.addConnection(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Type","EnvGrp_Type_Dropdown_Option");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Added connection successfully");
		//Verify Connection
		envGroupPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.validateElementDisplayed("EnvGrp_ConnectivityGrid_DirectionLeft", PlutoraConfiguration.environmentData);
		envGroupPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("EnvGrp_ConnectivityGrid_Environment_Text", "EnvGrp_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available after adding batch successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available after adding batch successfully !");
		Listener.addLogger("Environment Left direction is validated successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type")+" -  Environment Type  is available after adding batch successfully !");
		
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		//Verify Environment in Map
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully !");
		Listener.addLogger("Environment Left & Right direction is validated successfully");
	}
	
	@Test (description=" -> Env. Map -> live search Env. Group")
	public void environmentMap_02() throws InterruptedException  {
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		//Verify Environment in Map
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully ! ");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully !");
		Listener.addLogger("Environment Left & Right direction is validated successfully");
	
	}
	@Test (description=" -> Env. Map -> Manage Groups")
	public void environmentMap_04() throws InterruptedException  {
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
				
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_ManageGroup_Button", PlutoraConfiguration.objectData);
		environmentPage.verifyText("EnvGroups_Description", "Manage Environment Groups",PlutoraConfiguration.environmentData);
		Listener.addLogger("Env. Map -> Manage Groups returned to Environment Group Page successfully !");
		environmentPage.verifyText("EnvGroups_EnvNameLink", "EnvGrp_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" Displayed successfully !");
		envGroupPage.closeEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	
	@Test (description=" -> Env. Map -> View Full Screen")
	public void environmentMap_03() throws InterruptedException, AWTException  {
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		environmentPage.getCoordinates("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_1", "ycoordi_1");
		environmentPage.clickElementUsingJavaScript("Environment_Map_FullScreenButton",
				PlutoraConfiguration.environmentData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_View_Button", PlutoraConfiguration.objectData);
		
		environmentPage.sleep(2000);
		environmentPage.getCoordinates("Environment_Map_Environment_Text","Environment_Automation_1", PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_2", "ycoordi_2");
		environmentPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_1"))) >= (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_2"))));
		environmentPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_1"))) <= (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_2"))));
		
		environmentPage.escape();
		
		environmentPage.sleep(2000);
	}
	@Test (description=" ->Env. Map -> Show Env. Names")
	public void environmentMap_05() throws InterruptedException  {
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_EnviromentNames_Checkbox_Checked","Environment_Map_Show_EnviromentNames_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully ! ");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully !");
	}
	@Test (description=" -> Env. Map -> Show Env. Group/s")
	public void environmentMap_06() throws InterruptedException  {
		//Environment group creation
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" - Environment group is created successfully !");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		//Add environment group to enviroment 
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.updateEnvironmentGroup(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_1");
		
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentPage.updateEnvironmentGroup(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_1");
		
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_EnviromentNames_Checkbox_Checked","Environment_Map_Show_EnviromentNames_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_EnviromentGroups_Checkbox_Checked","Environment_Map_Show_EnviromentGroups_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyText("Environment_Map_Environment_Text", "EnvGrp_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.verifyWebElementCount("Environment_Map_Environment_Direction", "","2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment is available in the environment map successfully ! ");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment is available in the environment map successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" -  Environment Group is available in the environment map successfully !");
	}
	@Test (description=" -> Show connectivity type information ('eye' icon)")
	public void environmentMap_07() throws InterruptedException  {
		
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		envGroupPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Company_Organization_Name"), PlutoraConfiguration.environmentData);
		envGroupPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvGrp_Connectivity_Tab", PlutoraConfiguration.objectData);
		envGroupPage.addConnection(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Type_One","EnvGrp_Type_Dropdown_Second_Option");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Connectivity  type info uncheck
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_EnviromentNames_Checkbox_Checked","Environment_Map_Show_EnviromentNames_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_EnviromentGroups_Checkbox_Checked","Environment_Map_Show_EnviromentGroups_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_ConnectivityTypeInfo_Checkbox","Environment_Map_Show_ConnectivityTypeInfo_Checkbox_Checked", PlutoraConfiguration.objectData);
		envGroupPage.sleep(1000);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		//Verify Connectivity type info uncheck
		envGroupPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type")+" not displayed in Environment Map successfuly !");
		envGroupPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type_One"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type_One")+" not displayed in Environment Map successfuly !");
		//Connectivity  type info check
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_ConnectivityTypeInfo_Checkbox_Checked","Environment_Map_Show_ConnectivityTypeInfo_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.sleep(1000);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		//Verify Connectivity type info check
		envGroupPage.validateElementDisplayed("Environment_Map_2Connection_Text", PlutoraConfiguration.environmentData);
		Listener.addLogger(" 2 connection displayed in Environment Map successfuly !");
		//enable Multiple connections
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_ConnectivityTypeInfo_Checkbox_Checked","Environment_Map_Show_ConnectivityTypeInfo_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_MultipleConnector_Checkbox_Checked","Environment_Map_Show_MultipleConnector_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.validateElementDisplayed("Environment_Map_Connection_Text", "EnvGrp_Type",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		envGroupPage.validateElementDisplayed("Environment_Map_Connection_Text", "EnvGrp_Type_One",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);	
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type")+" mulitple connection displayed in Environment Map successfuly !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Type_One")+" mulitple connection displayed in Environment Map successfuly !");
		
		//Disable Multiple connections
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_ConnectivityTypeInfo_Checkbox_Checked","Environment_Map_Show_ConnectivityTypeInfo_Checkbox", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Show_MultipleConnector_Checkbox","Environment_Map_Show_MultipleConnector_Checkbox_Checked", PlutoraConfiguration.objectData);
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Display_Options_Dropdown", PlutoraConfiguration.objectData);
		envGroupPage.validateElementDisplayed("Environment_Map_2Connection_Text", PlutoraConfiguration.environmentData);
		Listener.addLogger("Mulitple connection Text displayed in Environment Map successfuly !");
		
	}
	
	@Test (description=" -> Env. Map -> Reset Position ('circle arrow' icon)")
	public void environmentMap_08() throws InterruptedException, AWTException  {
		
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
				Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		envGroupPage.click("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData,"Environment_Map_Reset_Icon",PlutoraConfiguration.objectData);
		
		environmentPage.getCoordinates("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_1", "ycoordi_1");

		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData,"Environment_Map_Reset_Icon",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(2000);
		environmentPage.getCoordinates("Environment_Map_Environment_Text","Environment_Automation_1", PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, "xcoordi_2", "ycoordi_2");
		environmentPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_1"))) <= (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_2"))));
		environmentPage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_1"))) <= (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "ycoordi_2"))));
		
	}
	
	@Test (description=" -> Env. Map -> Ability to change Environment Icon")
	public void environmentMap_09() throws InterruptedException  {
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		envGroupPage.click("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Environment_Icon", PlutoraConfiguration.objectData);
		environmentPage.doubleClick("Environment_Map_Environment_Option","Default Icon",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(3000);
		//Verify Environment - Default Icon
		environmentPage.verifyTextAttributeValueContains("Environment_Map_Environment_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData , "xlink:href","server-database");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - changed to default icon successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Environment_Icon", PlutoraConfiguration.objectData);
		environmentPage.doubleClick("Environment_Map_Environment_Option","Admin Terminal",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		//Verify Environment - Admin Terminal
		environmentPage.verifyTextAttributeValueContains("Environment_Map_Environment_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData , "xlink:href","Admin-Terminal");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - changed to admin terminal successfully !");
	}
	@Test (description=" -> Copying Host/Layer/Component tree by 'Copy' button")
	public void environmentMap_10() throws InterruptedException  {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.addHLCToEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");

		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		envGroupPage.click("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		
		envGroupPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Map_Copy_Icon", PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		environmentPage.verifyTextContainsValue(dstData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Dropdown_Option")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name"));
		Listener.addLogger("Copying Host/Layer/Component tree by 'Copy' button"+dstData+" Matched "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Dropdown_Option")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name"));
	
	}
	@Test (description="Copy 'Version' value of the Component having no 'Update Environment' permission (CTRL+C)")
	public void environmentMap_11() throws InterruptedException  {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.updateComponentVersion(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Component_Name","1.0");
		
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Select Environment in Map
		envGroupPage.selectEnvironmentGroupInMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is selected in the environment map successfully !");
		
		envGroupPage.click("Environment_Map_Environment_Text", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.sleep(2000);
		
		envGroupPage.click("Environment_Map_Component_Text","Environment_Component_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		envGroupPage.copyValueUsingAction(PlutoraConfiguration.platformName);
		
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		environmentPage.verifyTextContainsValue(dstData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" (1.0)");
		Listener.addLogger("Copy 'Version' value of the Component having no 'Update Environment' permission (CTRL+C)"+dstData+" Matched "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" (1.0)");
	
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.deleteCharacterFromTextbox("EnvGroups_LiveSearch_Textbox",PlutoraConfiguration.environmentData);
		envGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Remove Evironment from Group Member under env group
		envGroupPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_1");
		envGroupPage.removeEnvironmentFromGroupMember(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" -  Environment removed from Group Member section successfully ! ");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" -  Environment removed from Group Member section successfully !");
		
		envGroupPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Delete Environment Group
		envGroupPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		envGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		envGroupPage.gotoEnvironmentMap(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGroupPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is not available in environment map successfully !");
		
		//Delete Environments
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment is deleted successfully !");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment is deleted successfully !");
	}
}
