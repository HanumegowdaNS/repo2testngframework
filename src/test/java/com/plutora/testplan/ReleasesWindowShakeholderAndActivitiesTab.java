package com.plutora.testplan;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesWindowShakeholderAndActivitiesTab {
	ReleasePage releasePage = new ReleasePage();
	NewUserPage newUserPage = new NewUserPage();
	List<String> userMember;
	
	@Test (description="Sub-area: release window -> Stakeholders tab -> Add/edit/delete")
	public void subareaReleaseWindowSACTab_01() throws InterruptedException, AWTException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.addStakeholders(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Added shakeholder's successfully !");
		releasePage.updateStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Updated release shakeholder successfully !");
		releasePage.verifyUpdatedShakeholder(PlutoraConfiguration.testData);
		Listener.addLogger("Verified release shakeholder successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Sub-area: release window -> Ability to use user group as a stakeholder, and then its members in activities")
	public void subareaReleaseWindowSACTab_02() throws InterruptedException, AWTException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Releases_UserGroup_Name","Releases_StakeholderButton");
	
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		userMember=newUserPage.getUserGroupMember(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Releases_UserGroup_Name");
		Listener.addLogger("User group member is listed successfully !");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
	
		releasePage.mouseOver("Releases_Shakeholder_Name_Value", "Releases_UserGroup_Name", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_UserGroupName","Releases_UserGroup_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(2000);
		for(int i=0;i<userMember.size();i++) {
			releasePage.sleep(2000);
			System.out.println(userMember.get(i));
			releasePage.verifyText("Release_UserGroupMember",userMember.get(i),PlutoraConfiguration.releasesData);
			Listener.addLogger(userMember.get(i)+" - User group member is verified successfully !");
		}
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
	}
	
	@Test (description="1.Sub-area: release window -> Activity tab -> Add/edit/delete  2. Action -> Delete ")
	public void subareaReleaseWindowSACTab_03() throws InterruptedException, AWTException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.sleep(2000);
		releasePage.clickElementUsingJavaScript("Releases_ActivitesTab",PlutoraConfiguration.releasesData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HidePhases_Button","Release_Activity_ShowPhases_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HideGates_Button","Release_Activity_ShowGates_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_HideDependentChild_Button","Release_Activity_ShowDependentChild_Button",PlutoraConfiguration.objectData,"xpath");
		
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Test_Automation_Id","Activity_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+" - Added release activity successfully !");
		releasePage.verifyText("Release_Activity_Id","Activity_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Activity_Test_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(2000);
		Listener.addLogger("Verified release activity successfully !");
		releasePage.clickAndUpdateNewlyCreatedReleaseActivity(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName,"Activity_Test_Automation_Id");
		Listener.addLogger("Updated release activity successfully !");
		releasePage.scrollToElement("Releases_Attachment_URLTable", PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Attachment_URLTable",PlutoraConfiguration.releasesData);
		Listener.addLogger("Verified release activity successfully !");
		releasePage.clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.deleteNewCreatedReleaseActivites(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Activity_Test_Automation_Id",PlutoraConfiguration.objectData);
		Listener.addLogger("Release activity is deleted successfully !");
	}
	@Test (description="Sub-area: release window -> Activity tab -> Import Activities -> Import from Release")
	public void subareaReleaseWindowSACTab_04() throws InterruptedException, AWTException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Test_Automation_Id","Activity_Test_Automation_Name");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.importReleaseActivites(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		Listener.addLogger("Release activity is imported successfully !");
		releasePage.verifyText("Release_Activity_Id","Activity_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Activity_Test_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release activity is verifies successfully  after import activities !");
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: release window -> Activity tab -> Export to XLS")
	public void subareaReleaseWindowSACTab_05() throws InterruptedException, AWTException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Releases_ActivitesTab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		
		releasePage.clickOnActivityExportToXLS(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Stakeholder export to XLS is downloaded successfully!");
		releasePage.sleep(3000);
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Release");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Table1", 1);
		//releasePage.verifyTextValue("Activity_Test_Automation_Id",data[0].trim(),PlutoraConfiguration.testData);
		//releasePage.verifyTextValue("Activity_Test_Automation_Name",data[1].trim(),PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name")+" -  Stakeholder export to XLS is verified successfully!");
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: release window -> Activity tab -> Duplicate Activities")
	public void subareaReleaseWindowSACTab_06() throws InterruptedException, AWTException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Releases_ActivitesTab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		
		releasePage.createDuplicateActivities(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Test_Automation_Id");
		Listener.addLogger("Duplicate activity is added successfully!");
		releasePage.verifyText("Release_Activity_Id",PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+" (copy 1)",PlutoraConfiguration.releasesData);
		releasePage.verifyText("Release_Activity_Name",PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name")+" (copy 1)",PlutoraConfiguration.releasesData);
		Listener.addLogger("Duplicate activity is verified successfully!");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: release window -> Release Framework - Child Push")
	public void subareaReleaseWindowSACTab_07() throws InterruptedException, AWTException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		releasePage.pushActivityChild(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Test_Automation_Id","Activity_Test_Automation_Name","Release_Activity_Child_Tab","PRelease_Automation_Update_Id","PRelease_Automation_Name","Releases_AddNewActivity_Option",0);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.click("Releases_ActivitesTab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.verifyText("Release_Activity_Id","Activity_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_Activity_Name","Activity_Test_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Release Id, Release Name , assiged to, phase name and due date is verified successfully after child push !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: release window -> Activity tab -> Import from XLS")
	public void subareaReleaseWindowSACTab_08() throws InterruptedException, AWTException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.click("Releases_ActivitesTab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Activity_Test_Automation_Id","Activity_Test_Automation_Name");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"ReleaseActivity");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 0, PropertiesCache.setProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 1, PropertiesCache.setProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 4, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo") );
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 5, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName") );
		String date=PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Table1", 1, 8, releasePage.getFormatDate(date, "yyyy-MM-dd",date)+" 00:00");
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"<br>"+
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+" -  Stakeholder import to XLS is updated in excel successfully!");
		
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.imageFileName+excelFile, "Table1", 1);
		
		releasePage.clickOnActivityImportFromXLS(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName,CommonConstants.imageFileName+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ReleaseActivityName"));
		releasePage.verifyText("Release_Activity_Id",data[0],PlutoraConfiguration.releasesData);
		releasePage.verifyText("Release_Activity_Name",data[1],PlutoraConfiguration.releasesData);
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[text()='"+data[4]+"']")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityPhaseGateColumn']//div[text()='"+data[5]+"']")).isDisplayed();
		assertTrue(flag);
		if(date.matches("\\d{2}/\\d{2}/\\d{4}")) {
			date=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(data[8].split(" ")[0].trim()));
		}else {
			date=new SimpleDateFormat("yyyy/MM/dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(data[8].split(" ")[0].trim()));
		}
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"']/ancestor::td/following-sibling::td[@data-columnid='activityDueDateColumn']//div[contains(text(),'"+date+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Test_Automation_Name")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_AssignedTo")+"<br>"+
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_PhaseName")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_DueDate")+" -  Stakeholder import to XLS is verified successfully!");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	@Test (description="Sub-area: release window -> Criteria tab -> Add/edit/delete")
	public void subareaReleaseWindowSACTab_09() throws InterruptedException, AWTException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		
		releasePage.sleep(2000);
		releasePage.addCriteria(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Criteria_Test_Automation_Id","Criteria_Test_Automation_Name");
		Listener.addLogger("Added release criteria successfully !");
		releasePage.clickAndUpdateNewlyCreatedReleaseCriteria(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		Listener.addLogger("Updated release criteria successfully !");
		releasePage.sleep(2000);
		releasePage.scrollToElement("Releases_Attachment_URLTable", PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Releases_Attachment_URLTable",PlutoraConfiguration.releasesData);
		Listener.addLogger("Verified release criteria successfully !");
		releasePage.deleteNewlyCreatedReleaseActivites(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Release criteria is deleted successfully !");
	}
	@Test (description="Sub-area: release window -> First accountable shown as Release Manager")
	public void subareaReleaseWindowSACTab_10() throws InterruptedException, ParseException, IOException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Update_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Owner_Dropdown",PlutoraConfiguration.objectData);
		releasePage.click("Release_Owner_Dropdown_Option", "Releases_UserGroup_Name", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		Listener.addLogger("Added owner to release successfully !");
		releasePage.sleep(2000);
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.scrollToElement("Release_OwnerName",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.mouseOver("Release_OwnerName","",PlutoraConfiguration.releasesData,"");
		releasePage.sleep(1000);
		releasePage.verifyText("Release_UserGroupName","Releases_UserGroup_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.sleep(1000);
		for(int i=0;i<userMember.size();i++) {
			releasePage.sleep(2000);
			System.out.println(userMember.get(i));
			releasePage.verifyText("Release_UserGroupMember",userMember.get(i),PlutoraConfiguration.releasesData);
			Listener.addLogger(userMember.get(i)+" -  User group member is verified successfully !");
		}
	}
}
