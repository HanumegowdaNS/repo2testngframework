package com.plutora.testplan;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class TECRMaintenanceBench {
	ReleasePage releasePage = new ReleasePage();
	TECRPage tecrPage = new TECRPage();

	@Test (description=" -> Ability to select Release, and view linked to it TECRs with all details in the grid")
	public void tecrMaintenanceBench_01() throws InterruptedException  {

		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id","Project_Automation","");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id"));
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type"));
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status"));
		tecrPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_AssignedTo"));
		
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "TECR_Maintenance_Bench_Save&Close_Button", PlutoraConfiguration.objectData);
	}
	
	@Test (description=" -> Ability to create new TECR for selected Release")
	public void tecrMaintenanceBench_02() throws InterruptedException  {
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		tecrPage.addTECRApplicationAndInformation(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Env_Automation");
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "TECR_Maintenance_Bench_Save&Close_Button", PlutoraConfiguration.objectData);
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Requestor_Name","Loggedin_Username_Value",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" -  TECR Tab Live Search is verified successfully!");
	}
	
	
	@Test (description=" -> Ability to create Environment Booking for selected TECR(using 'Create EB' checkbox)")
	public void tecrMaintenanceBench_03() throws InterruptedException, AWTException  {
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Automation","EnvGrp_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Automation")+" - Environment is created successfully !");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.selectTECRMaintenanceBench(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		tecrPage.addCreateKBAndPhase(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.addTECRApplicationAndInformation(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Env_Automation");
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyText("TECR_Requestor_Name","Loggedin_Username_Value",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id")+" -  TECR Tab Live Search is verified successfully!");
		
	}
	

}
