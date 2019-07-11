package com.plutora.testplan;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesGrid {
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test(description = "Sub-area:release grid -> Add/edit/delete enterprise release")
	public void subareaReleaseGrid_01() throws InterruptedException {

		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.verifyText("Releases_Page_Title", "Releases_Page_Title_Value", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//Create Enterprise
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		//Verify
		releasePage.verifyText("Releases_Search_Result", "Release_Test_Automation_Id",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.verifyTextContains("Release_SubTitle","Release_Test_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//Update
		releasePage.updateRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Update_Id");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Update_Id")+" - Enterprise Release is updated successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_Test_Automation_Update_Id");
		releasePage.verifyText("Releases_Search_Result","Release_Test_Automation_Update_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Update_Id")+" - Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Update_Id");
		//Delete
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Update_Id")+" - Enterprise Release is deleted successfully !");
	}
	
	@Test (description="Sub-area:release grid -> Add/edit/delete independent release ('Dependency'='Independent')")
	public void subareaReleaseGrid_02() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//Create Independent
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IRelease_Automation_Id")+" - Independent Release is created successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Verify
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.verifyText("Releases_Search_Result","IRelease_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Independent Release is verified successfully !");
		//Update
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.updateRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.clickElementUsingJavaScript("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		Listener.addLogger("Independent Release is updated successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Search_Result","IRelease_Automation_Update_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Independent Release is verified successfully !");
			
	}
	
	@Test (description="Sub-area:release grid -> Add/edit/delete project release ('Dependency'='Independent')")
	public void subareaReleaseGrid_03() throws InterruptedException {	

		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Create Project
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Verify
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyText("Releases_Search_Result","PRelease_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Project Release is verified successfully !");
		//Update
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.updateRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.clickElementUsingJavaScript("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		Listener.addLogger("Project Release is updated successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Search_Result","PRelease_Automation_Update_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Project Release is verified successfully !");
		
	}
	
	@Test (description="Sub-area:release grid ->Gates & Approvals (Visual View) + ability to define Stakeholder as an approver")
	public void subareaReleaseGrid_04() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		//Update phase and gate
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"CountOfPG");
		releasePage.sleep(4000);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		releasePage.click("AddRelease_SaveButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		//Set flag
		releasePage.clickElementUsingJavaScript("Releases_FlagIcon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_GA_Header","Releases_Gates&ApprovalHeader_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(3000);
		releasePage.click("Releases_GA_GatesButton", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.scrollToElement("Releases_GA_ShakeholderButton", PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		releasePage.clickElementUsingJavaScript("Releases_GA_ShakeholderButton", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		//Update stakeholder
		releasePage.updateStakeholdersToGates(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.click("Releases_GA_GreenApproverButton",PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		releasePage.validateElementDisplayed("Releases_GA_GreenApprover", PlutoraConfiguration.releasesData);
		Listener.addLogger("Release Approver activation is verified successfully !");
		releasePage.sleep(1000);
		Listener.addLogger("Project Release is verified successfully !");
		releasePage.click("Releases_GA_RedApproverButton",PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		releasePage.validateElementDisplayed("Releases_GA_RedApprover", PlutoraConfiguration.releasesData);
		Listener.addLogger("Release Approver deactivation is verified successfully !");

	}
	
	@Test (description="Sub-area:release grid ->Enterprise/Project/Independent checkbox filters")
	public void subareaReleaseGrid_05() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//Create Enterprise
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		//Enterprise Release Checkbox Filter
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Enterprise_Checkbox_Checked","Releases_Enterprise_Checkbox",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.verifyText("Releases_Search_Result","Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(2000);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_EnterpriseIcon","Releases_EnterpriseIcon_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Enterprise Release checkbox filter verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Enterprise_Checkbox_Checked","Releases_Enterprise_Checkbox",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Project Release Checkbox Filter
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Project_Checkbox_Checked","Releases_Project_Checkbox",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.verifyText("Releases_Search_Result","PRelease_Automation_Update_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(2000);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_ProjectIcon","Releases_ProjectIcon_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Project Release checkbox filter verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Project_Checkbox_Checked","Releases_Project_Checkbox",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Indenpendent Release Checkbox Filter
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Independent_Checkbox_Checked","Releases_Independent_Checkbox",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.verifyText("Releases_Search_Result","IRelease_Automation_Update_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(2000);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Independent_Checkbox_Checked","Releases_Independent_Checkbox",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_IndependentIcon","Releases_IndependentIcon_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Independent Release checkbox filter verified successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Independent_Checkbox_Checked","Releases_Independent_Checkbox",PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area:release grid ->\"Add/edit/delete child release (independent)\n" + 
			"(phases/gates brought down from parent release after selecting 'Dependency' value)\"")
	public void subareaReleaseGrid_06() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Update phase and gate
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		//Select Release Dependency
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.verifyPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Release_PhasesAndGates_Checkbox","Release_PhaseName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		//Delete phase and gate
		releasePage.deletePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Release Phase is successfully deleted !");
		releasePage.sleep(1000);
		releasePage.click("Release_PhasesAndGates_Checkbox","Release_GateName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		releasePage.deletePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Release Gate is successfully deleted !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.verifyNotVisiblePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Project Release Phase & gate are verified after deletion sucessfully !");
	}
	
	
	@Test (description="Sub-area:release grid ->\"Add/edit/delete child release (project)\n" + 
			"(phases/gates brought down from parent release after selecting 'Dependency' value)\"")
	public void subareaReleaseGrid_07() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Update phase and gate
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		//Select Release Dependency
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Name");
		releasePage.verifyPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.click("Release_PhasesAndGates_Checkbox","Release_PhaseName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		//Delete phase and gate
		releasePage.deletePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Release Phase is successfully deleted !");
		releasePage.sleep(1000);
		releasePage.click("Release_PhasesAndGates_Checkbox","Release_GateName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		releasePage.deletePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Release Gate is successfully deleted !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.verifyNotVisiblePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Independent Release Phase & gate are verified after deletion sucessfully !");
	}
	@Test (description="Sub-area:release grid ->Child & Ignore Child")
	public void subareaReleaseGrid_08() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Update Phase and Gate
		releasePage.updatePhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "CountOfPG");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.verifyPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Edit phase and gate
		releasePage.editPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.phaseChildPush(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.gateIgnoreChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		//Verify child & ignore
		releasePage.verifyChildAndIgnorePushPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Verified pushed child & ignore child phase & gate sucessfully !");
	}
	

	@Test (description="Sub-area:release grid -> Metrics")
	public void subareaReleaseGrid_09() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		//Get metrix chart
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Metrics_HideIcon","Releases_Metrics_ViewIcon", PlutoraConfiguration.objectData,"xpath");
		//Verify
		releasePage.verifyText("Releases_Metrics_OverTimeHeader","Releases_OverTimeHeader_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_Metrics_Next5ReleasesHeader","Releases_Next5Releases_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_Metrics_KeyMetricsHeader","Releases_KeyMetrics_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Releases_Metrics_OverTime_Chart",PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Metrics_Next5Releases_Chart",PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Metrics_KeyMetrics_Chart",PlutoraConfiguration.releasesData);
		Listener.addLogger("Releases grid metrics verified successfully!");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Metrics_ViewIcon","Releases_Metrics_HideIcon", PlutoraConfiguration.objectData,"xpath");
		
	}
	@Test (description="Sub-area:release grid -> Export to XLS")
	public void subareaReleaseGrid_10() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickElementUsingJavaScript("Releases_Name_Checkbox","Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		//Export to XLS
		releasePage.clickElementUsingJavaScript("Releases_ActionButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickElementUsingJavaScript("Releases_ExportToXLSButton",PlutoraConfiguration.releasesData);
		releasePage.sleep(3000);
		Listener.addLogger("Releases export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Releases");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Releases", 1);
		releasePage.verifyTextValue("Release_Test_Automation_Id",data[0].trim(),PlutoraConfiguration.testData);
		releasePage.verifyTextValue("Release_Test_Automation_Name",data[1].trim(),PlutoraConfiguration.testData);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Name")+" -  Releases export to XLS is verified successfully!");
	}
	
	@Test (description="Sub-area:release grid -> Live Search")
	public void subareaReleaseGrid_11() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.verifyText("Releases_Search_Result","Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" verified live search result successfully !");
		
		releasePage.verifyText("Release_Organization_SearchField_Text","Release_Organization",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization_Name")+" verified live search result successfully !");
		
		releasePage.verifyText("Release_Implementation_SearchField_Text",releasePage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(releasePage.getTodayDate("0", "dd/MM/yyyy")+" verified live search result successfully !");
	}
	
	@Test (description="Sub-area:release grid -> Filter by: My Portfolio Association / I'm a Stakeholder / All")
	public void subareaReleaseGrid_12() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" created successfully !");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "","AddRelease_Organistion_Option_Value");
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_MyPortfolioAssociation_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Organization_SearchField_Text","Release_Organization_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization_Name")+" verified in release grid successfully !");
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_StakeholdersTab");
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,  "Loggedin_Username_Value", "Releases_StakeholderButton");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_IamStakeholder_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verified in release grid successfully !");
		
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_All_Tab", PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verified in release grid successfully !");
		
	}
	@Test (description="Sub-area:release grid -> Query Builder (QB) + Quick Access menu")
	public void subareaReleaseGrid_13() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_CustomField_Name","Action_Button");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.sendKeys("Releases_Live_Search", "",PlutoraConfiguration.releasesData);
		releasePage.enter();
		//Add new public query
		releasePage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		releasePage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID", "equals", "Enterprise_Automation","1");
		releasePage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		releasePage.sendKeys("Releases_Live_Search", "",PlutoraConfiguration.releasesData);
		releasePage.enter();
		//Verify Release in current account
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sendKeys("Releases_Live_Search", "",PlutoraConfiguration.releasesData);
		releasePage.enter();
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder"));
		//releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage("",PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Status",releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name","AddRelease_Organistion_Option_Value");
		releasePage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		//Condition 1
		releasePage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status"),"1","1");
		releasePage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		releasePage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		releasePage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release ID", "equals", "Enterprise_Automation","2");
		releasePage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		releasePage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		releasePage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"), "on","3");
		releasePage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		releasePage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		releasePage.addOrganizationQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Portfolio Association", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization_Name"),"4","4");
		releasePage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//Release Name
		//releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Organization_SearchField_Text","Release_Organization_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Status_SearchField_Text","Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyTextContains("Release_Grid_ImplementationDate_Text",releasePage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization_Name")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+"<br>"+
				releasePage.getTodayDate("0", "dd/MM/yyyy")+"<br>"+
				"verified private query builder successfully !");
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
		
	}
	@Test (description="Show Child Releases checkbox (when QB query is defined)")
	public void subareaReleaseGrid_14() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sendKeys("Releases_Live_Search", "",PlutoraConfiguration.releasesData);
		releasePage.enter();
		releasePage.waitForLoadingIconDisappear(1000,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000); 
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_ShowRelatedReleases_Checked_Checkbox", "Release_ShowRelatedReleases_Checkbox",PlutoraConfiguration.objectData);
		
		//Enterprise Release Name
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verified show Child Releases checkbox successfully !");
		
		//Project Release Name
		releasePage.verifyText("Releases_Search_Result","Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" verified show Child Releases checkbox successfully !");
		
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		
		releasePage.deletePublicQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Public_Builder");
		releasePage.deletePrivateQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Private_Builder");
		releasePage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Close_Button", PlutoraConfiguration.objectData);
	
	}
	@Test (description="Grid Column Filtering (GCF)")
	public void subareaReleaseGrid_15() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.sleep(1000);
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Status",releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "","AddRelease_Organistion_Option_Value");
		
		//Release Name
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.verifyText("Releases_Search_Result","Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" verify in Grid Column Filtering section successfully !");
		
		//Release Name
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Name_Live_SearchField","Enterprise_Automation_Name");
		releasePage.verifyText("Release_Name_Live_SearchField_Text","Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" verified in Grid Column Filtering section successfully !");
		
		//Release Organization 
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Organization_SearchField_Dropdown", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Organization_SearchField_Dropdown_Option","Release_Organization_Name" , PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Organization_SearchField_Text","Release_Organization_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Organization_Name")+" verified in Grid Column Filtering section successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Organization_SearchField_Dropdown", PlutoraConfiguration.objectData);
		
		//Release Implementation Date
		/*releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Implementation_SearchField_Calendar", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DatePicker_Today_Button", PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Implementation_SearchField_Text",releasePage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);*/
		Listener.addLogger(releasePage.getTodayDate("0", "dd/MM/yyyy")+" verified in Grid Column Filtering section successfully !");
		
		//Release Status
	/*	releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Status_SearchField_Dropdown", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Status_SearchField_Option","Release_Status" , PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Status_SearchField_Text","Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);*/
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+" verified in Grid Column Filtering section successfully !");
		
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	}
		
	@Test (description="Action -> Grid Column Selector (check custom fields behavior)")
	public void subareaReleaseGrid_17() throws InterruptedException, ParseException {	
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		
		releasePage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_CustomField_Name","Action_Button");
		
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name").toUpperCase()+" verified in release grid successfully !");
		
		releasePage.clearGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
		
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name").toUpperCase());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name").toUpperCase()+" not displayed in release grid successfully !");
		

	}
	@Test (description="Action -> Duplicate (all selected fields are duplicated?)")
	public void subareaReleaseGrid_18() throws InterruptedException, ParseException {
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
		
		//EG creation
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation","Systems_Automation");

		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.searchEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Environment_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully to environment section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment section !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Automation","Activity_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.updateReleaseDuplicate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation","Enterprise_Automation", "Enterprise_Automation_Name");
	
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_IDTextfield", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" duplicate Release-Id Verified successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_NameTextfield", "Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" duplicate Release-Name Verified successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_ImplementationDate_Textbox", releasePage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(releasePage.getTodayDate("0", "dd/MM/yyyy")+" duplicate Implementation-Date Verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Applications_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" duplicate System-Name Verified successfully !");
		
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Environment_Target_Name","Environment_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" duplicate Environment-Name Verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" duplicate Stakeholder-Name Verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_ActivitesTab",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Activity_Id","Activity_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Activity_Test_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Automation")+" duplicate Release-Activity-Id Verified successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name")+" duplicate Release-Activity-Name Verified successfully !");
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.updateReleaseDuplicateNewDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation","Enterprise_Automation", "Enterprise_Automation_Name");
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_ImplementationDate_Textbox", releasePage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(releasePage.getTodayDate("2", "dd/MM/yyyy")+" duplicate Implementation-Date Verified successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		Listener.addLogger(releasePage.getTodayDate("2", "dd/MM/yyyy")+" duplicate Phase and Gate-New-Date Verified successfully !");
		releasePage.sleep(2000);
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	/*@Test (description="Action -> Bulk Update (all tabs)")
	public void subareaReleaseGrid_19() throws InterruptedException, ParseException {	
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - New System is created successfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Enterprise_Bulk_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" created successfully !");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation", "Project_Bulk_Automation_Name", "0");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Status",releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_OrganisationDropdown",PlutoraConfiguration.objectData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_PortfolioAssociation",releasePage.getTextData("AddRelease_Organistion_Option_Value", PlutoraConfiguration.releasesData));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.sendKeysWithEnter("Releases_SearchButton","Bulk",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.updateReleaseBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Project_Bulk_Automation", "Activity_Test_Automation_Name", "Activity_Test_Automation_Name","Completed");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		//Enterprise - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "Release_RiskLevel",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_RiskLevel")+" updated successfully !");
		
		//releasePage.verifyTextAttributeValue("AddRelease_Organization_Textbox", "Release_PortfolioAssociation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PortfolioAssociation")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_Location_Textbox", "Release Location",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release Location")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_ImplementationDate_Textbox", releasePage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Impementation Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue(
				PropertiesCache.getProperty(PlutoraConfiguration.objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField")),
				releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Custom Field Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Phase and Gate - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName")+" updated successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
	
		//Enterprise - System
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" updated successfully !");
		
		//Enterprise - Stakeholder
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_StakeholdersTab");
		releasePage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" updated successfully !");
		
		//Enterprise - Activities
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" updated successfully !");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" updated successfully !");
		
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		//flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		//assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Project 
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		
		//Project - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "Release_RiskLevel",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_RiskLevel")+" updated successfully !");
		
	//	releasePage.verifyTextAttributeValue("AddRelease_Organization_Textbox", "Release_PortfolioAssociation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	//	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PortfolioAssociation")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_Location_Textbox", "Release Location",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release Location")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_ImplementationDate_Textbox", releasePage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Impementation Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue(
				PropertiesCache.getProperty(PlutoraConfiguration.objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField")),
				releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Custom Field Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Phase and Gate - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName")+" updated successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
	
		//Project - System
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" updated successfully !");
		
		//Project - Stakeholder
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_StakeholdersTab");
		releasePage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" updated successfully !");
		
		//Project - Activities
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" updated successfully !");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" updated successfully !");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField_Name");
		
	}*/
	
	
	
	@Test (description="Action -> Clear Grid Column Filter")
	public void subareaReleaseGrid_16() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		
		releasePage.verifyTextAttributeValue("Releases_Live_Search", "",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release ID cleared successfully !");
		
		releasePage.verifyTextAttributeValue("Release_Name_Live_SearchField", "",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release Name cleared successfully !");
		
		releasePage.verifyTextAttributeValue("Release_PortfolioAssociation_Textbox", "",PlutoraConfiguration.releasesData);
		Listener.addLogger("Port  cleared successfully !");
		releasePage.sleep(1000);
		Listener.addLogger("Release Implementation date textbox cleared successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Action -> Bulk Update information tab")
	public void subareaReleaseGrid_19() throws InterruptedException, ParseException {	
		//System Creation
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - New System is created successfully !");
		//Add customfield
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField");
		//Add Enterprise release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Enterprise_Bulk_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" created successfully !");
		//Add Project release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Bulk_Automation", "Project_Bulk_Automation_Name", "0");
		//Add phase & Gate
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Status",releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_OrganisationDropdown",PlutoraConfiguration.objectData);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_PortfolioAssociation",releasePage.getTextData("AddRelease_Organistion_Option_Value", PlutoraConfiguration.releasesData));
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.addPhaseAndGate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		//Enterprise Add stakeholder
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		//Enterprise Add Release activity & criteria
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Enterprise_Id","Activity_Enterprise_Name");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Enterprise_Id","Criteria_Enterprise_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Project Add stakeholder
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		//Project Add Release activity & criteria
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Project_Id","Activity_Project_Name");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Project_Id","Criteria_Project_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.sendKeysWithEnter("Releases_SearchButton","Bulk",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		//Bulk Update - Information Tab 
		releasePage.updateReleaseBulkUpdateInformationTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Project_Bulk_Automation");
		//Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		//Enterprise - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" updated successfully !");
		//Enterprise - Information Tab Verification
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "Release_RiskLevel",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_RiskLevel")+" updated successfully !");
		
		releasePage.verifyTextDisplayedInPage("Release Location");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release Location")+" updated successfully !");
		
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Impementation Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Phase and Gate - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName")+" updated successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		
		//Project - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.verifyTextAttributeValue("AddRelease_ReleaseTypeDropdown", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" updated successfully !");
		//Project - Information tab Verification
		releasePage.verifyTextAttributeValue("AddRelease_Status_Textbox", "Release_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Status")+" updated successfully !");
		
		releasePage.verifyTextAttributeValue("AddRelease_RiskLevelDropdown", "Release_RiskLevel",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_RiskLevel")+" updated successfully !");
		
		releasePage.verifyTextDisplayedInPage("Release Location");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release Location")+" updated successfully !");
		
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Impementation Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Hide_Button","Release_Show_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("2", "dd/MM/yyyy"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Phase and Gate - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_PhaseName")+" updated successfully !");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_GateName")+" updated successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
	    
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	
	
	@Test (description="Action -> Bulk Update additional information")
	public void subareaReleaseGrid_20() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.sendKeysWithEnter("Releases_SearchButton","Bulk",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		//Bulk Update - Additional information
		releasePage.updateReleaseBulkUpdateAdditionalInformation(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Project_Bulk_Automation");
		//Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		//Enterprise - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		//Enterprise - Additional Information Verification
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField"));
		/*releasePage.verifyTextAttributeValue(
				PropertiesCache.getProperty(PlutoraConfiguration.objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField")),
				releasePage.getTodayDate("2", "dd/MM/yyyy"));*/
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - Custom Field Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		
		//Project - Release Tab
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		//Project - Additional information verification
		/*releasePage.verifyTextAttributeValue(
				PropertiesCache.getProperty(PlutoraConfiguration.objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField")),
				releasePage.getTodayDate("2", "dd/MM/yyyy"));*/
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - Custom Field Date - "+releasePage.getTodayDate("2", "dd/MM/yyyy")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Action -> Bulk Update System tab")
	public void subareaReleaseGrid_21() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.sendKeysWithEnter("Releases_SearchButton","Bulk",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		//Bulk Update - System Tab
		releasePage.updateReleaseBulkUpdateSystemTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Project_Bulk_Automation");
		//Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
	
		//Enterprise - System Verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.verifyText("Releases_SystemsName_Text","System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" updated successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		
		//Project - System Verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_Applications_Tab");
		releasePage.verifyText("Releases_SystemsName_Text","System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" updated successfully !");
				
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Action -> Bulk Update SA tab")
	public void subareaReleaseGrid_22() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		releasePage.sendKeysWithEnter("Releases_SearchButton","Bulk",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		//Bulk Update stakeholder and activites tab
		releasePage.updateReleaseBulkUpdateSATab(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Bulk_Automation", "Project_Bulk_Automation", "Activity_Enterprise_Name", "Activity_Project_Name","Completed");
		//Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
	
		//Enterprise - Stakeholder Verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_StakeholdersTab");
		releasePage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" updated successfully !");
		
		//Enterprise - Activities Verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Enterprise_Id")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Enterprise_Id")+" updated successfully !");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Enterprise_Id")), "Not Started");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Enterprise_Id")+" updated successfully !");
		
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Enterprise_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Enterprise_Id")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		//Project Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		
		//Project - Stakeholder verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_StakeholdersTab");
		releasePage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" updated successfully !");
		
		//Project - Activities verification
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Releases_ActivitesTab");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Project_Id")), "Completed");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Project_Id")+" updated successfully !");
		releasePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.releasesData,"Release_Activity_Status_Column").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Project_Id")), "Not Started");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Project_Id")+" updated successfully !");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Project_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Bulk_Automation")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Project_Id")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "AssignedTo_Text")+" updated successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Delete Custom field 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_CustomField");
		//Delete Enterprise Release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Bulk_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Delete Project Release
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Bulk_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
	}
	
	
}
