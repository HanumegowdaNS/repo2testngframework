package com.plutora.testplan;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowActivitiesTab {
	ReleasePage releasePage = new ReleasePage();
	boolean flag=false;
	@Test (description="Progress bar ('Total Activities' bar)")
	public void subareaReleaseWindowActivitiesTab_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity1","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Activity1");
		releasePage.verifyTextContains("Release_Activity_ProgressBar", "100",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity1")+"Release Activity progress bar is reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "N/A", "0", "Activity2");
		releasePage.verifyTextContains("Release_Activity_ProgressBar", "100",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"Release Activity progress bar is reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity3","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity3");
		releasePage.verifyTextContains("Release_Activity_ProgressBar", "50",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"Release Activity progress bar is reached to 50 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity4","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "In Progress", "0", "Activity4");
		releasePage.verifyTextContains("Release_Activity_ProgressBar", "33",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity4")+"Release Activity progress bar is reached to 33 % successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Show/hide phases/gates")
	public void subareaReleaseWindowActivitiesTab_02() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation","Project_Automation_Name","0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity5","Activity_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.importReleaseActivites(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria","Criteria_Test_Automation_Name");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HidePhases_Button","Release_Activity_ShowPhases_Button",PlutoraConfiguration.objectData,"xpath");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity5")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+" displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_ShowPhases_Button","Release_Activity_HidePhases_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+" not displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HideGates_Button","Release_Activity_ShowGates_Button",PlutoraConfiguration.objectData,"xpath");
		 flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate")+" displayed successfully !");
		
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_ShowGates_Button","Release_Activity_HideGates_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Gate")+" not displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HideDependentChild_Button","Release_Activity_ShowDependentChild_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyText("Release_Activity_Id","Activity5",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity5")+" displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_ShowDependentChild_Button","Release_Activity_HideDependentChild_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity5"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity5")+" not displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HidePhases_Button","Release_Activity_ShowPhases_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Status filtering")
	public void subareaReleaseWindowActivitiesTab_03() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickMultipleElement("Release_Activity_StatusFilter_ActiveLink", PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
	
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_StatusFilter_Completed", PlutoraConfiguration.objectData);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'Completed')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity1")+" - "+" Completed"+" displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_StatusFilter_N/A", PlutoraConfiguration.objectData);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'N/A')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+" - "+" Completed"+" displayed successfully !");
		
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_StatusFilter_NotStarted", PlutoraConfiguration.objectData);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'Not Started')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+" - "+" Completed"+" displayed successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_StatusFilter_InProgress", PlutoraConfiguration.objectData);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity4")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'In Progress')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity4")+" - "+" Completed"+" displayed successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Assigned To filtering")
	public void subareaReleaseWindowActivitiesTab_04() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_AssignedToFilter_Dropdown", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Activity_AssignedToFilter_Dropdown_Option", "Release_Activity_AssignedTo", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity1")+" - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+" displayed successfully !");
		
		releasePage.updateActivityAssignedToFromGrid(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo"), "Activity1");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_AssignedToFilter_Dropdown", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Activity_AssignedToFilter_Dropdown_Option", "Release_Activity_AssignedTo", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+" not displayed successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Clear Filter link")
	public void subareaReleaseWindowActivitiesTab_05() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_AssignedToFilter_Dropdown", PlutoraConfiguration.objectData);
		releasePage.clickButton("Release_Activity_AssignedToFilter_Dropdown_Option", "Release_Activity_AssignedTo", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("Release_Activity_AssignedToFilter_Textbox", "Release_Activity_AssignedTo", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+" displayed in assigned to filter successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_ClearFilter_Link", PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("Release_Activity_AssignedToFilter_Textbox", "", PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+" not displayed in assigned to filter successfully !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Counter ('Total Activities')")
	public void subareaReleaseWindowActivitiesTab_09() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.verifyText(releasePage.getTextData(PlutoraConfiguration.releasesData, "Release_Activity_Activities_Count").split(":")[1].trim(), String.valueOf(releasePage.getWebElementCount("Release_Total_Activity_Row", "", PlutoraConfiguration.releasesData, "")));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "Release_Total_Activity_Row")+ "Activities displayed successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Tabs of phases/gates")
	public void subareaReleaseWindowActivitiesTab_06() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//-----------------------------------------------------------------------------------------Phase
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Activity5");
		releasePage.clickButton("Release_Activity_Grid_Tab","Release_Activity_PhaseName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release Activity Phase Grid reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "N/A", "0", "Activity2");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"Release Activity progress bar is reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity3","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Activity3");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "50",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"Release Activity progress bar is reached to 50 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity4","Activity_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "In Progress", "0", "Activity4");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "33",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity4")+"Release Activity progress bar is reached to 33 % successfully !");
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Activity4");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "66",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity4")+"Release Activity progress bar is reached to 66 % successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_MarkPhaseAsCompleted_Button", PlutoraConfiguration.objectData);
		
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release All Activities Gate Grid reached to 100 % successfully !");
		
		//-------------------------------------------------------------------------------Gate
		releasePage.clickButton("Release_Activity_Grid_Tab","Criteria_Gate",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.testData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria1","Criteria_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Criteria1");
	
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release Activity Phase Grid reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria2","Criteria_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "N/A", "0", "Criteria2");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria2")+"Release Activity progress bar is reached to 100 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria3","Criteria_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Not Started", "0", "Criteria3");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria3")+"Release Activity progress bar is reached to 33 % successfully !");
		
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria4","Criteria_Test_Automation_Name");
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "In Progress", "0", "Criteria4");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "33",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria4")+"Release Activity progress bar is reached to 33 % successfully !");
		
		releasePage.updateActivityStatus(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Completed", "0", "Criteria4");
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar", "66",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria4")+"Release Activity progress bar is reached to 66 % successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_MarkPhaseAsCompleted_Button", PlutoraConfiguration.objectData);
		
		releasePage.verifyTextContains("Release_Activity_Grid_PhaseProgressBar","100",PlutoraConfiguration.releasesData);
		Listener.addLogger("Release All Activities Gate Grid reached to 100 % successfully !");
				
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Import Activities -> Download Template")
	public void subareaReleaseWindowActivitiesTab_07() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnDownloadTemplate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Import Activities - Download Template is downloaded successfully!");
		releasePage.sleep(3000);
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Release_Activity_Template");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Table1", 0);
		releasePage.verifyTextValue("ID",data[0].trim());
		releasePage.verifyTextValue("Title",data[1].trim());
		releasePage.verifyTextValue("Description",data[2].trim());
		releasePage.verifyTextValue("Type",data[3].trim());
		releasePage.verifyTextValue("Assigned To",data[4].trim());
		releasePage.verifyTextValue("Assign to Phase or Gate",data[5].trim());
		releasePage.verifyTextValue("Forecast Date",data[6].trim());
		releasePage.verifyTextValue("Start Date",data[7].trim());
		releasePage.verifyTextValue("Due Date",data[8].trim());
		releasePage.verifyTextValue("Status",data[9].trim());
		releasePage.verifyTextValue("Release Framework",data[10].trim());
		
		Listener.addLogger("ID"+"<br>"+"Title"+"<br>"+"Description"+"<br>"+"Type"+"<br>"+"Assigned To"+"<br>"+"Assign to Phase or Gate"+"<br>"+"Forecast Date"+"<br>"+"Start Date"+
		"<br>"+"Due Date"+"<br>"+"Status"+"<br>"+"Release Framework"+" Import activites Download template verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Action -> Bulk Update")
	public void subareaReleaseWindowActivitiesTab_08() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.updateActivityBulkUpdate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2", "Activity3", "Completed", "2");
		releasePage.clickElementUsingJavaScript("Release_Criteria_Id","Activity2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Update_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Update_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Update_PhaseGate")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Update_PhaseGate")+"']")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityForecastDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'Completed')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStatusColumn']//div[contains(text(),'Completed')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		releasePage.updateActivityBulkUpdateShiftDateBackward(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2", "Activity3", "2");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		releasePage.updateActivityBulkUpdateShiftDateDueDateForward(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2", "Activity3", "2");
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		releasePage.updateActivityBulkUpdateShiftDateDueDateBackward(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2", "Activity3", "2");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("-2", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		
		releasePage.updateActivityBulkUpdateSelectNew(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity2", "Activity3", "0", "8");
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityStartColumn']//div[contains(text(),'"+releasePage.getTodayDate("0", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("8", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity3")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+releasePage.getTodayDate("8", "dd/MM/yyyy")+"')]")).isDisplayed();
		assertTrue(flag);
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
}
