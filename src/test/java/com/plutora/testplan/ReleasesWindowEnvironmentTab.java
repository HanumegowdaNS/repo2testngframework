package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowEnvironmentTab {
	ReleasePage releasePage = new ReleasePage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	TECRPage tecrPage = new TECRPage();
	
	@Test (description="Sub-area: release window -> Environment tab -> Book/unbook env. and env. group (+ bulk booking by multi-selecting)")
	public void subareaReleaseWindowEnvironmentTab_01() throws InterruptedException, AWTException, ParseException {	
		for (int i=1;i<=Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvironmentCount"));i++) {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"REnvironment_Automation_"+i);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "REnvironment_Automation_"+i)+" - Environment is created successfully !");
		}
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
	
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.searchEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData,"REnvironment_Automation");
		
		for (int i=1;i<=Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvironmentCount"));i++) {
		releasePage.verifyText("Releases_EnvironmentName_Text","REnvironment_Automation_"+i,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "REnvironment_Automation_"+i)+" - Environment is verified successfully !");
		}
		
		releasePage.clickElementUsingJavaScript("Releases_Environment_SelectAll_Checkbox",PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "REnvironment_Automation_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment drag and dropped successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		
		for (int i=1;i<=Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvironmentCount"));i++) {
			releasePage.verifyText("Release_Environment_Target_Name","REnvironment_Automation_"+i,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "REnvironment_Automation_"+i)+" - is verified after drag and dropped to Environment release section !");
		}
		Listener.addLogger("Environment target is verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		for (int i=1;i<=Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvironmentCount"));i++) {
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"REnvironment_Automation_"+i);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "REnvironment_Automation_"+i)+" - Environment is deleted successfully !");
		}
	}
	
	@Test (description="Sub-area: release window -> Environment tab -> Book/unbook env. and env. group (+ bulk booking by multi-selecting)")
	public void subareaReleaseWindowEnvironmentTab_02() throws InterruptedException, AWTException, ParseException {	
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
	
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment group is created successfully !");
		releasePage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EnvGrp_Test_Automation_Id","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		
		releasePage.clickElementUsingJavaScript("Releases_Applications_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", "Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is dragged and dropped successfully !");
		releasePage.verifyText("Releases_SystemsName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is verified after drag and drop successfully !");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Environment_Env_Name","Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Release_Environment_EnvGroup_Name","EnvGrp_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is verified successfully on environment tab !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully !");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);

		releasePage.verifyText("Release_Environment_Env_Name","Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is verified successfully after drag & drop !");
	}
	@Test (description="Sub-area: release window -> Environment tab -> Turn the phase on/off (booking appearance on Env. Schedule)")
	public void subareaReleaseWindowEnvironmentTab_03() throws InterruptedException, AWTException, ParseException {	
		releasePage.click("Releases_EnviornmentRequest_Off_Checkbox",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		releasePage.validateElementDisplayed("Releases_DropEnvironment_Disabled_Section",PlutoraConfiguration.releasesData);
		Listener.addLogger("Enviroment phase Turn Off is verified successfully");
		releasePage.click("Releases_EnviornmentRequest_Off_Checkbox",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		releasePage.validateElementDisplayed("Releases_DropEnvironment_Section",PlutoraConfiguration.releasesData);
		Listener.addLogger("Enviroment phase Turn On is verified successfully");
		
	}
	@Test (description="Sub-area: release window -> Environment tab -> Availability status of environments to be booked per filtered phase")
	public void subareaReleaseWindowEnvironmentTab_04() throws InterruptedException, AWTException, ParseException {	
		
		releasePage.clickElementUsingJavaScript("Releases_Environment_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		releasePage.verifyText("Release_Environment_Status_Text","PENDING",PlutoraConfiguration.releasesData);
		Listener.addLogger("Availability status PENDING is verified sucessfully");
		releasePage.sleep(3000);
		releasePage.selectEnvironmentStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Rejected","REJECTED");
		Listener.addLogger("Availability status REJECTED is verified sucessfully");
		releasePage.selectEnvironmentStatus(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Approved","APPROVED");
		Listener.addLogger("Availability status APPROVED is verified sucessfully");
		PropertiesCache.setProperty(PlutoraConfiguration.releasesData, "Release_Environment_Enabled_Phase_Name",releasePage.getTextData("Release_Environment_Phase_Name", PlutoraConfiguration.releasesData).split(":")[1].trim());
	}
	@Test (description="Sub-area: release window -> Details Tab -> Environment Booking Smart Alerts(feature to move booking date once the phase date is moved)")
	public void subareaReleaseWindowEnvironmentTab_05() throws InterruptedException, AWTException, ParseException {	
		releasePage.verifySmartAlertWindow(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		Listener.addLogger("Environment is deleted successfully !");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.sleep(2000);
		environmentGroupsPage.clickElementUsingJavaScript("ENVGroups_CloseButton", PlutoraConfiguration.environmentData);
		releasePage.sleep(2000);
		Listener.addLogger("Environment group is deleted successfully !");
	}
	@Test (description="Sub-area: release window -> Details Tab -> New TECR Button")
	public void subareaReleaseWindowEnvironmentTab_06() throws InterruptedException, AWTException, ParseException {	
		//Env Group
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EnvGrp_Test_Automation_Id","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		//Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "180");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Environment_NewRequest_Button",PlutoraConfiguration.objectData);
		tecrPage.verifyTextAttributeValue("AddTECR_ReleaseName_Textbox", "Project_Automation_Name",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" - displayed successfully !");
		tecrPage.verifyTextAttributeValueContains("TECR_RE_ProgressionPath_Environment_Name", "Env_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,"data-qtip");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - displayed successfully !");
		
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation","Project_Automation","TECR");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" - deleted successfully !");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - deleted successfully !");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Test_Automation_Id");
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.sleep(2000);
		environmentGroupsPage.clickElementUsingJavaScript("ENVGroups_CloseButton", PlutoraConfiguration.environmentData);
		releasePage.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Test_Automation_Id")+" - deleted successfully !");
		
	}
	
	
}
