package com.plutora.testplan;


import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowManifestTab {
	ReleasePage releasePage = new ReleasePage();
	
	@Test (description="Sub-area: release window -> Release Manifest tab (enterprise release) -> Drag and drop")
	public void subareaReleaseWindowManifestTab_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Independent_Automation", "Independent_Automation_Name", "0");
		//Project Release Dependency
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Select Release Dependency
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation_Name");
		//Indenpendent Release Dependency
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Independent_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Independent_Automation");
		//Select Release Dependency
		releasePage.selectReleaseDependency(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.searchReleaseManifest(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name");
		releasePage.verifyText("Release_Manifest_Name","Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Manifest_Name","Project_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release is verified successfully on Release manifest tab !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Release_Manifest_Name_Section", "Release_Scope_Manifest_Section", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release is drag & dropped successfully !");
		releasePage.verifyText("Release_Manifest_Name","Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Manifest_Name","Project_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Project Release Id - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"<br>"+"Project Release Name - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+ " is verified sucessfully");
		//releasePage.clickElementUsingJavaScript("Releases_PhaseAndGates_OnlyCheckbox",PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		//releasePage.clickElementUsingJavaScript("Releases_PhaseAndGates_Save&CloseButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area: release window -> Release Manifest tab (enterprise release) -> Change Intake flow")
	public void subareaReleaseWindowManifestTab_02() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Manifest_Tab", PlutoraConfiguration.objectData);
		releasePage.selectManifestIntakeApproval(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_Release_Dependency_Textbox","Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("AddRelease_Release_Dependency_IntakeValue","IntakeApprovalValue",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IntakeApprovalValue")+" - Release intake value is verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Open Child Release")
	public void subareaReleaseWindowManifestTab_03() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Manifest_Tab", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Manifest_Name","Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_IDTextfield", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Able to open child release id from release manifest page successfully !");
		releasePage.verifyTextAttributeValue("AddRelease_NameTextfield", "Project_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" - Able to open child release name from release manifest page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
}
