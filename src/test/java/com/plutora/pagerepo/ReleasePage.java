package com.plutora.pagerepo;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class ReleasePage extends TestGenericUtilLib {
	public String eventDropdownOption;
	private String phaseName = null,gateName=null,stakeHolderName=null,activityId=null,raciValue=null;
	String fromDate,toDate;
	
	public void releasePage(String releaseData,String objectData) throws InterruptedException{	
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		/*if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Releases_Header_Sidemenu", releaseData);
			sleep(500);
			click("ReleaseManager_Dropdown_Options", releaseData);
		} else {*/
			mouseHover("Releases_Header_Dropdown", "ReleaseManager_Dropdown_Options",releaseData);
		//}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData, "Releases_Metrics_ViewIcon","Releases_Metrics_HideIcon", objectData,"xpath");
	}
	
	private void clickOnHideButton(String releaseData) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			driver.findElement(By.xpath(PropertiesCache.getProperty(releaseData, "Release_Hide_Button"))).click();
		}catch(Exception e) {}
		 finally {  
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }
	}
	public void newERPage(String releaseData,String testData,String objectData,String enterpriseId) {	
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddEnterpriseRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		clickOnHideButton(releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, enterpriseId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, "Release_Test_Automation_Name"),releaseData);

		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Release_Type",getTextData("AddRelease_ReleaseType_FirstOption", releaseData));
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sleep(1000);
		
		click("AddRelease_OrganisationDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Release_Organization",getTextData("AddRelease_Organistion_Option_Value", releaseData));
		clickElementUsingJavaScript("AddRelease_Organistion_Option_Value",releaseData);
		sleep(1000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_ImplementationDate_TodayButton",releaseData);
		sleep(1000);
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, enterpriseId)+" created successfully !");
	}
	public void newIndependentReleasePage(String releaseData,String testData,String objectData,String independentId){	
		sleep(2000);
		scrollToElement("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddNewRelease_Button",releaseData);
		waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		clickElementUsingJavaScript("AddIndependentRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnHideButton(releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, independentId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, "IRelease_Automation_Name"),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddRelease_ReleaseType_FirstOption", releaseData);
		sleep(2000);
		sendKeys("Releases_Independent_Release_Dependency_Dropdown_Option","Independent",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(2000);
		click("AddRelease_Dependency_Dropdown",releaseData);
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);;
		clickElementUsingJavaScript("AddRelease_ImplementationDate_TodayButton",releaseData);
		sleep(2000);
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, independentId)+" created successfully !");
	}
	public void updateReleaseStatus(String releaseData,String testData,String objectData,String status,String option){		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddRelease_Status_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		if(!status.isEmpty()) {
		clickElementUsingJavaScript("AddRelease_Status_Dropdown_Option",status,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		}else {
		clickElementUsingJavaScript(option,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);	
		}
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void newProjectReleasePage(String releaseData,String testData,String objectData,String projectId){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddProjectRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnHideButton(releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, projectId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, "PRelease_Automation_Name"),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sendKeys("Releases_Independent_Release_Dependency_Dropdown_Option","Independent",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(2000);
		click("AddRelease_Dependency_Dropdown",releaseData);
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_ImplementationDate_TodayButton",releaseData);
		sleep(2000);
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, projectId)+" created successfully !");
	}

	public void newProjectReleasePage(String releaseData,String testData,String objectData,String projectId,String startDate,String endDate) throws ParseException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddProjectRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnHideButton(releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, projectId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, "PRelease_Automation_Name"),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sendKeys("Releases_Independent_Release_Dependency_Dropdown_Option","Independent",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(2000);
		click("AddRelease_Dependency_Dropdown",releaseData);
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		//clickElementUsingJavaScript("AddRelease_ImplementationDate_TodayButton",releaseData);
		//sleep(2000);
		applicationDatePicker(releaseData, testData, "AddRelease_ImplementationDate_Calendar", getCurrentDate(endDate));
		clickElementUsingJavaScript("Release_ShowPhaseAndGates_Button", releaseData);
		addPhase(releaseData, testData, objectData,"Phase_Name",getCurrentDate(startDate),getCurrentDate(endDate));
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, projectId)+" created successfully !");
		
	}
	public void verifyRelease(String releaseData,String testData,String objectData,String releaseName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Releases_Live_Search", releaseName,releaseData,testData);
		enter();
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	public void verifyRelease(String releaseData,String testData,String objectData,String searchField,String releaseName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter(searchField, releaseName,releaseData,testData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
	}
	
	public void clickOnRelease(String releaseData,String testData,String objectData,String releaseName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Releases_Live_Search", releaseName,releaseData,testData);
		enter();
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}

	public void newERPageBasedOnDate(String releaseData,String testData,String objectData,String releaseId,String releaseName,String days) throws ParseException{	
		if(releaseId.contains("Release_Calender") || releaseId.contains("Enterprise") || releaseId.contains("ER")) {
			click("AddEnterpriseRelease_Button",releaseData);
		}else if(releaseId.contains("Project") || releaseId.contains("PRelease") || releaseId.contains("PR") ) {
			scrollToElement("AddNewRelease_Button",releaseData);
			click("AddNewRelease_Button",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("AddProjectRelease_Button",releaseData);
		}else if(releaseId.contains("Independent")) {
			scrollToElement("AddNewRelease_Button",releaseData);
			click("AddNewRelease_Button",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("AddIndependentRelease_Button",releaseData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, releaseId),releaseData);
		sendKeys("AddRelease_NameTextfield", PropertiesCache.setProperty(testData, releaseName),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Release_RiskLevel", getTextData("AddRelease_RiskLevel_FirstOption", releaseData));
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		clickElementUsingJavaScript("AddRelease_ReleaseType_FirstOption", releaseData);
		PropertiesCache.setProperty(testData, "Release_Type",getAttributeData("AddRelease_ReleaseTypeDropdown", releaseData));
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		datePicker(releaseData,testData,"Release_Calender_DatePickerLabel",getCurrentDate(days));
		sleep(1000);
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, releaseId)+" created successfully !");
	}


	public void updateRelease(String releaseData,String testData,String objectData,String releaseName){	
		System.out.println("Release link is clicked and release page has opened");
		sendKeys("AddRelease_IDTextfield",PropertiesCache.setProperty(testData, releaseName),releaseData);
		sleep(4000);
		/*windowScrollDown("400");
		scrollToElement("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		uploadImageByName("uploadfile");*/
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		sleep(2000);
	}

	public void updatePhaseAndGate(String releaseData,String testData,String objectData,String count){
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		for (int i = 1; i <= Integer.parseInt(PropertiesCache.getProperty(testData, count)); i++) {
			addPhaseAndGate(releaseData, testData,objectData);
			Listener.addLogger("Added phase and gate successfully !");
			sleep(1000);
			verifyText("Release_PhasesAndGates_Name", phaseName, releaseData);
			sleep(1000);
			verifyText("Release_PhasesAndGates_Name", gateName, releaseData);
			Listener.addLogger("Verified phase and gate successfully !");
		}
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		sleep(2000);

	}

	public void addStakeholders(String releaseData,String testData,String objectData){
		clickElementUsingJavaScript("Releases_StakeholdersTab", releaseData);
		sleep(2000);
		for (int i = 1; i <= Integer.parseInt(PropertiesCache.getProperty(testData, "CountOfReleaseAction")); i++) {
			addStakeholder(releaseData, testData,objectData, i,"Releases_StakeholderButton");
			sleep(1000);
			verifyText("Releases_Shakeholder_Name_Value",stakeHolderName,releaseData);
			Listener.addLogger(stakeHolderName+" Added successfully !");
		}
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		sleep(2000);
	}
	public void clickOnStakeholderTab(String releaseData,String objectData){
		clickElementUsingJavaScript("Releases_StakeholdersTab", releaseData);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		sleep(2000);
	}
	
	public void updateStakeholdersToGates(String releaseData, String testData, String objectData)  {

		clickElementUsingJavaScript("Releases_Gates_ShakeholderButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		sendKeys("Releases_UserGroupTextbox", PropertiesCache.getProperty(testData, "Loggedin_Username_Value").split(" ")[0], releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		deleteSingleCharacter("Releases_UserGroupTextbox", releaseData);
		waitForLoadingIconDisappear(40,"Loading_Gif",objectData);
		sleep(2000);
		click("Releases_UserGroupTextboxFirst_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(4000);
		click("Releases_RoleFirst_Option", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		click("Releases_Add&CloseButton",releaseData);
		Listener.addLogger("Added shakeholder to phase & gate successfully !");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyText("Releases_Shakeholder_Name_Value", "Loggedin_Username_Value", releaseData,testData);
		Listener.addLogger("Verified stakeholder from phase & gate successfully !");
		sleep(2000);
		clickElementUsingJavaScript("Releases_GA_CloseButton", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_GA_AddShakeholder",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_GA_AddShakeholder_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_GA_Shakeholder_NameOption","Loggedin_Username_Value",releaseData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);

	}
	public void updateUserGroupsToStakeholder(String releaseData, String testData, String objectData,String userName,String stakeholderButton) {
		
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(4000);
		sendKeys("Releases_UserGroupTextbox", userName, releaseData,testData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(4000);
		clickElementUsingJavaScript("Releases_UserGroupTextboxFirst_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(4000);
		click("Releases_RoleFirst_Option", releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		click("Release_ShakeholderAccountable_Option",releaseData);
		sleep(2000);
		click("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyTextContains("Releases_Shakeholder_Name_Value", userName, releaseData,testData);
		Listener.addLogger("Added stakeholder is verified successfully !");
		sleep(2000);
	}

	public void updateStakeholder(String releaseData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Shakeholder_Name_Value","Stakeholder_Name",releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		raciValue=getTextData("Release_ShakeholderRACIFirst_Option",releaseData);
		PropertiesCache.setProperty(testData, "RACI_Value",raciValue);
		sleep(1000);
		clickElementUsingJavaScript("Release_ShakeholderRACIFirst_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Update&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void selectAllRACICheckbox(String releaseData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Releases_Shakeholder_Name_Value","Stakeholder_Name",releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("StakeholderRACIResponsible_Option",releaseData);
		click("StakeholderRACIAccountable_Option",releaseData);
		click("StakeholderRACIConsulted_Option",releaseData);
		click("StakeholderRACIInformed_Option",releaseData);
		sleep(2000);
		click("StakeholderRACIEdit&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyStakeholderAccountableDisabled(String releaseData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Releases_Shakeholder_Name_Value","Stakeholder_Name",releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("StakeholderRACIEdit&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	
	public void verifyUpdatedShakeholder(String testData) {

		boolean flag = driver
				.findElement(By.xpath("//span[text()='"
						+ PropertiesCache.getProperty(testData, "RACI_Value").split(" ")[1].replace("(", "").replace(")", "").trim()
						+ "']/ancestor::div[contains(@id,'headercontainer')]/following-sibling::div//td[3]/div"))
				.getText().isEmpty();
		assertFalse(flag);
	}
	public void addActivties(String releaseData,String testData,String objectData){
		clickElementUsingJavaScript("Releases_ActivitesTab",releaseData);
		sleep(1000);
		for (int i = 1; i <= Integer.parseInt(PropertiesCache.getProperty(testData, "CountOfReleaseAction")); i++) {
			createReleaseActivity(releaseData, testData, objectData,i);
			sleep(1000);
			verifyText("Release_Activity_Id",activityId,releaseData);
			verifyText("Release_Activity_Name","New_Activites_Releases_Name_Value", releaseData,testData);
			sleep(2000);
		}
	}

	public void addCriteria(String releaseData, String testData, String objectData,String criteriaId,String criteriaName) {
		clickElementUsingJavaScript("Releases_ActivitesTab", releaseData);
		createReleaseCriteria(releaseData, testData, objectData,criteriaId,criteriaName);
		sleep(1000);
		verifyText("Release_Criteria_Id", "Criteria_Test_Automation_Id", releaseData,testData);
		verifyText("Release_Criteria_Name", "Criteria_Test_Automation_Name", releaseData, testData);
		sleep(2000);

	}
	
	public void findAndOpenRelease(String releaseData,String testData,String objectData,String releaseName) {		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Releases_Search_Result",releaseName,releaseData,testData);
		clickElementUsingJavaScript("Releases_Search_Result",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);

	}

	public void clickOnReleaseTab(String releaseData,String objectData,String tabLocator) {		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript(tabLocator,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void deleteRelease(String releaseData,String testData,String objectData){	
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Yes_Button",releaseData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Release deleted successfully !");
	}

	public void getReleaseDetails(String releaseData,String objectData) throws InterruptedException{	
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		mouseHover("Releases_Header_Dropdown", "ReleaseManager_Dropdown_Options",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddNewRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddProjectRelease_Button",releaseData);
	}

	public void getReleaseCalenderDetails(String releaseData,String objectData) throws InterruptedException{	
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		if(isElementNotPresent(".plt__l--Menu")) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Releases_Header_Sidemenu", releaseData);
			sleep(500);
			click("Release_Calender_Dropdown_Option", releaseData);
		} else {
			mouseHover("Releases_Header_Dropdown", "Release_Calender_Dropdown_Option",releaseData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void addStakeholder(String releaseData,String testData,String objectData,int i,String stakeholderButton){
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		sleep(2000);
		if(stakeholderButton.contains("Releases_CStakeholder_Button")) {
		clickElementUsingJavaScript("Change_UserGroupDropdown",releaseData);
		}else {
		clickElementUsingJavaScript("Releases_UserGroupDropdown",releaseData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//ul[contains(@id,'boundlist')]//div[@class='users_group_icon'])["+i+"]/div"));
		stakeHolderName=element.getText();
		PropertiesCache.setProperty(testData, "Stakeholder_Name",element.getText());
		clickElementUsingJavaScript(element);
		//clickElementUsingJavaScript("Releases_UserGroupFirst_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//click("Releases_RoleFirst_Option", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void addStakeholder(String releaseData,String testData,String objectData,String stakeholderButton){
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		sleep(2000);
		if(stakeholderButton.contains("Releases_CStakeholder_Button")) {
		clickElementUsingJavaScript("Change_UserGroupDropdown",releaseData);
		}else {
		clickElementUsingJavaScript("Releases_UserGroupDropdown",releaseData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("Releases_UserGroupTextbox", "stakeholder_Name",releaseData , testData);
		sleep(2000);
		clickElementUsingJavaScript("Release_StakeholderName_DropDown",PropertiesCache.getProperty(testData, "stakeholder_Name") , releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void addStakeholder(String releaseData,String testData,String objectData,String stakeholderButton,String stakeholderName){
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		sleep(2000);
		if(stakeholderButton.contains("Releases_CStakeholder_Button")) {
		clickElementUsingJavaScript("Change_UserGroupDropdown",releaseData);
		}else {
		clickElementUsingJavaScript("Releases_UserGroupDropdown",releaseData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("Releases_UserGroupTextbox",stakeholderName,releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_StakeholderName_DropDown",stakeholderName, releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void verifyStakeholderRole(String releaseData,String testData,String objectData,int i,String stakeholderButton,String defaultValue,String name){
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		if(!defaultValue.equals("Default")) {
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText("Releases_Role_Option", name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Role_Option",name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		sleep(2000);
		}
		verifyText("Releases_Role", name,releaseData,testData);
		click("Stakeholder_Close_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void addStakeholder(String releaseData,String objectData,int i,String stakeholderButton){
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_UserGroupDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		WebElement element = driver.findElement(By.xpath("(//ul[contains(@id,'boundlist')]//div[@class='users_group_icon'])["+i+"]/div"));
		stakeHolderName=element.getText();
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Stakeholder_Name",element.getText());
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_RoleFirst_Option", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		click("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void addEnterpriseShakeholder(String releaseData,String objectData,int i){
		sleep(1000);
		clickElementUsingJavaScript("Releases_StakeholderButton",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Enterprise_UserGroupDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		WebElement element = driver.findElement(By.xpath("(//ul[contains(@id,'boundlist')]//div[@class='users_group_icon'])["+i+"]/div"));
		stakeHolderName=element.getText();
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Stakeholder_Name",element.getText());
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_RoleDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_RoleFirst_Option", releaseData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
		click("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void createReleaseActivity(String releaseData,String testData,String objectData,int i){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_AddNewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_AddNewActivity_Option",releaseData);
		sleep(1000);
		activityId=PropertiesCache.getProperty(testData, "New_Activites_Releases_Id_Value")+" "+String.valueOf(i);
		sendKeys("Release_Activity_IdTextField",activityId,releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField","New_Activites_Releases_Name_Value",releaseData,testData);
		sleep(2000);
		click("Release_Activity_AssignedToPhaseDropdown",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdown",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
	}
	public void createNewReleaseActivity(String releaseData,String testData,String objectData,String activityId,String activityName){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_AddNewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_AddNewActivity_Option",releaseData);
		sleep(1000);
		sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, activityId),releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, activityName),releaseData);
		sleep(2000);
		click("Release_Activity_AssignedToPhaseDropdown",releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Release_Activity_PhaseName",getTextData("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData));
		sleep(1000);
		click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdown",releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Release_Activity_AssignedTo",getTextData("Release_Activity_AssignedToDropdownFirst_Option",releaseData));
		sleep(1000);
		click("Release_Activity_AssignedToDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
		sleep(4000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, activityId)+" created successfully !");
	}

	public void createReleaseCriteria(String releaseData,String testData,String objectData,String criteriaId,String criteriaName){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_AddNewButton",releaseData);
		sleep(1000);
		click("Releases_AddNewCriteria_Option",releaseData);
		sleep(1000);
		sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, criteriaId),releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, criteriaName),releaseData);
		sleep(2000);
		click("Release_Criteria_AssignedToGateDropdown",releaseData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Criteria_Gate",getTextData("Release_Activity_AssignedToDropdownFirst_Option", releaseData));
		
		click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdown",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdownFirst_Option",releaseData);
		sleep(1000);
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(testData, criteriaId)+" created successfully !");
	}

	public  void clickAndUpdateNewlyCreatedReleaseActivity(String releaseData,String testData,String objectData,String platform,String activityName) throws  IOException, AWTException{

		//clickElementUsingJavaScript("Release_Activity_Id","New_Activites_Releases_Id1_Value",releaseData,testData);
		clickElementUsingJavaScript("Release_Activity_Id",activityName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(5000);
		//clickElementUsingJavaScript("Releases_Tab",releaseData);
		sleep(1000);
		scrollToElement("Releases_Attachment_ActivityNewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Attachment_ActivityNewButton",releaseData);
		sleep(1000);
		doubleClick("Releases_Attachment_NewURLOption",releaseData);
		sleep(1000);
		sendKeys("Releases_Attachment_NewURLTextbox",CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(testData, "ImageName"),releaseData);
		sleep(4000);
		click("Releases_Attachment_NewURLSave&Close_Button",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_ActivitesTab",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Release_Activity_Id",activityName,releaseData,testData);
	}

	public  void clickAndUpdateNewlyCreatedReleaseCriteria(String releaseData,String testData,String objectData,String platform) throws  IOException, AWTException{

		clickElementUsingJavaScript("Release_Criteria_Id","Criteria_Test_Automation_Id",releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(5000);
		scrollToElement("Releases_Attachment_ActivityNewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Attachment_ActivityNewButton",releaseData);
		sleep(1000);
		doubleClick("Releases_Attachment_NewURLOption",releaseData);
		sleep(1000);
		sendKeys("Releases_Attachment_NewURLTextbox",CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(testData, "ImageName"),releaseData);
		sleep(4000);
		click("Releases_Attachment_NewURLSave&Close_Button",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_ActivitesTab",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Release_Criteria_Id","Criteria_Test_Automation_Id",releaseData,testData);
	}
    
    public void updateCriteriaStatus(String releaseData,String testData,String objectData,String status,String days,String criteriaId) throws ParseException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_Criteria_Id",criteriaId,releaseData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Criteria_Status_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Criteria_Status_Option",status,releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_DueDateDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(releaseData, testData, "Release_Activity_DueDate_Calender", getDate(getCurrentDate("0"),days));
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
		
	}
	public  void deleteNewlyCreatedReleaseActivites(String releaseData,String testData,String objectData){
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(2000);
		//clickElementUsingJavaScript("Releases_Activity_Id_Checkbox","New_Activites_Releases_Id_Value",releaseData,testData);
		clickElementUsingJavaScript("Release_Activity_ActionButton",releaseData);
		sleep(2000);
		click("Release_Activity_Action_DeleteButton",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Release Activity deleted successfully !");
	}
	public  void deleteNewCreatedReleaseActivites(String releaseData,String testData,String activityId,String objectData){
		//clickElementUsingJavaScript("Releases_Activity_Id_Checkbox",activityId,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_ActionButton",releaseData);
		sleep(2000);
		click("Release_Activity_Action_DeleteButton",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Release Activity deleted successfully !");
	}

	public void createDuplicateRelease(String releaseData,String testData,String objectData,String releaseName){
		enterNewlyCreatedRelease(releaseData, testData, objectData,releaseName);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Name_Checkbox",releaseName,releaseData,testData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_ActionButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_DuplicateReleaseButton",releaseData);
		sleep(1000);
		click("DuplicateReleases_SelectAllOption",releaseData);
		click("DuplicateReleases_DuplicateButton",releaseData);
		
	}
	public void enterNewlyCreatedDuplicateReleases(String releaseData,String testData,String objectData,String releaseName){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeysWithEnter("Releases_SearchButton",setDuplicateName("(Copy)", releaseName, "Copy_"+releaseName, testData),releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickAndUpdateNewlyCreatedDuplicateReleases(String releaseData,String testData,String objectData,String platform,String releaseName) throws InterruptedException, IOException, AWTException{
		sleep(4000);
		clickElementUsingJavaScript("Releases_Id","Copy_"+releaseName,releaseData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Tab",releaseData);
		sleep(2000);
		windowScrollDown("400");
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		scrollToElement("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		uploadImageByName("uploadfile");
		clickElementUsingJavaScript("AddRelease_Save&CloseButton",releaseData);
		sleep(2000);
		enterNewlyCreatedDuplicateReleases(releaseData, testData, objectData,releaseName);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Id","Copy_"+releaseName,releaseData,testData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Tab",releaseData);
		windowScrollDown("400");
		sleep(4000);
		scrollToElement("Releases_Attachment_NewButton",releaseData);
		sleep(2000);
	}
	public  void deleteNewlyCreatedDuplicateReleases(String releaseData){
		sleep(2000);
		clickElementUsingJavaScript("Releases_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Yes_Button",releaseData);
	}
	public void enterNewlyCreatedRelease(String releaseData,String testData,String objectData,String releaseName){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeysWithEnter("Releases_SearchButton",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}

	public void clickCreatedReleases(String releaseData,String testData,String objectData,String releaseName){
		clickElementUsingJavaScript("Releases_Id",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}

	public void addPhaseAndGate(String releaseData,String testData,String objectData){
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_NewButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_Phase_Option",releaseData);
		clickElementUsingJavaScript("Release_PhasesAndGates_NameTextbox",releaseData);
		phaseName=getTextData("Release_PhasesAndGates_NameFirst_Option",releaseData);
		PropertiesCache.setProperty(testData, "Release_PhaseName",phaseName);
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_NameFirst_Option",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_PhasesAndGates_NewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_Gate_Option",releaseData);
		clickElementUsingJavaScript("Release_PhasesAndGates_NameTextbox",releaseData);
		gateName=getTextData("Release_PhasesAndGates_NameFirst_Option",releaseData);
		PropertiesCache.setProperty(testData, "Release_GateName",gateName);
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_NameFirst_Option",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public void addPhase(String releaseData,String testData,String objectData,String phaseName){
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_NewButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(releaseData,"Release_PhasesAndGates_Phase_Option",objectData);
		clickOnButton(releaseData,"Release_PhasesAndGates_NameTextbox",objectData);
		sleep(2000);
		click("Release_PhasesAndGates_Name_Text",phaseName,releaseData,testData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void addPhase(String releaseData,String testData,String objectData,String phaseName,String startdate ,String enddate) throws ParseException{
		sleep(1000);
		clickElementUsingJavaScript("Release_PhasesAndGates_NewButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(releaseData,"Release_PhasesAndGates_Phase_Option",objectData);
		clickOnButton(releaseData,"Release_PhasesAndGates_NameTextbox",objectData);
		sleep(2000);
		clickButton("Release_PhasesAndGates_Name_Text",phaseName,releaseData,testData,objectData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_SaveButton", releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Release_PhaseStartDate_Input",phaseName, releaseData, testData);
		sleep(2000);
		applicationDatePicker(releaseData, testData,"Release_PhaseStartDate_Calendar" ,startdate);
		sleep(1000);
		clickElementUsingJavaScript("Release_PhaseEndDate_Input",phaseName, releaseData, testData);
		sleep(1000);
		applicationDatePicker(releaseData, testData,"Release_PhaseEndDate_Calendar" ,enddate);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void addGate(String releaseData,String testData,String objectData,String gateName){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_PhasesAndGates_NewButton",releaseData);
		sleep(1000);
		clickOnButton(releaseData,"Release_PhasesAndGates_Gate_Option",objectData);
		clickOnButton(releaseData,"Release_PhasesAndGates_NameTextbox",objectData);
		sleep(1000);
		clickButton("Release_PhasesAndGates_Name_Text",gateName,releaseData,testData,objectData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void editPhaseAndGate(String releaseData,String testData,String objectData) throws ParseException{
		sleep(2000);
		String phaseDate=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//td[7]/div)[1]")).getText();
		String gateDate=driver.findElement(By.xpath("(//div[text()='"+gateName+"']/ancestor::tr//td[7]/div)[1]")).getText();

		String currentDate,futureDate;
		//if(phaseDate.matches("\\d{2}/\\d{2}/\\d{4}") || gateDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
			currentDate=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
			futureDate=new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
		//}
			/*else {
			currentDate=new SimpleDateFormat("yyyy/MM/dd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
			futureDate=new SimpleDateFormat("yyyy/MM/dd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
		}*/

		WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+currentDate+"')])[2]"));
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getCurrentDate("2"));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		element=driver.findElement(By.xpath("//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+futureDate+"')]"));
		assertTrue(element.isDisplayed());
		Listener.addLogger("Release Phase is updated successfully !");

		element=driver.findElement(By.xpath("(//div[text()='"+gateName+"']/ancestor::tr//div[contains(text(),'"+currentDate+"')])[2]"));
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getCurrentDate("2"));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		element=driver.findElement(By.xpath("//div[text()='"+gateName+"']/ancestor::tr//div[contains(text(),'"+futureDate+"')]"));
		assertTrue(element.isDisplayed());
		Listener.addLogger("Release Gate is updated successfully !");

	}

	public void deletePhaseAndGate(String releaseData,String testData,String objectData){
		/*clickElementUsingJavaScript("Release_PhasesAndGates_Checkbox",phaseName,releaseData);
		clickElementUsingJavaScript("Release_PhasesAndGates_DeleteButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_PhasesAndGates_Checkbox",gateName,releaseData);
		clickElementUsingJavaScript("Release_PhasesAndGates_DeleteButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);*/
		clickElementUsingJavaScript("Release_PhasesAndGates_DeleteButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Yes_All_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyTextEqualsNotDisplayedInPage(phaseName);
		sleep(1000);
		verifyTextEqualsNotDisplayedInPage(gateName);
	}


	public void getMetricsChart(String releasesData) {
		try {
			webElementIdentifier(PropertiesCache.getProperty(releasesData, "Releases_Metrics_HideIcon")).isDisplayed();
		}catch(Exception e) {
			click("Releases_Metrics_ViewIcon", releasesData);
			sleep(1000);
		}
	}

	public void createSystem(String releaseData,String testData,String objectData,String systemsName,String newSystemButton) throws InterruptedException {
		clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click(newSystemButton,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		switchToWindow(4000, "parentWindow");
		driver.get(driver.getCurrentUrl());
		sleep(3000);
		sendKeys("Releases_Systems_Name",PropertiesCache.setProperty(testData, systemsName),releaseData);
		sendKeys("Releases_Systems_DescriptonTextfield",PropertiesCache.setProperty(testData, "Systems_Automation_Description"),releaseData);
		sendKeys("Releases_Systems_VendorTextfield",PropertiesCache.setProperty(testData, "Systems_Automation_VendorValue"),releaseData);
		//clickElementUsingJavaScript("Releases_Systems_ActiveRadio",releaseData);
		sleep(1000);
		sendKeys("AddSystems_PortfolioAssociation","New_ER_Portfolio_Association_Value", releaseData, testData);
		sleep(1000);
		click("Systems_Portofolio_Association_search", "New_ER_Portfolio_Association_Value", releaseData, testData);
		/* Click on Save & close Button */
		clickElementUsingJavaScript("Systems_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(4000);
		closeWindowTab();
		driver.switchTo().window(PropertiesCache.getProperty(testData,"parentWindow"));
	}

	public void searchSystem(String releaseData,String testData,String objectData,String systemsName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeysWithEnter("Releases_Systems_SearchResults",systemsName, releaseData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		deleteSingleCharacter("Releases_Systems_SearchResults", releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		enter();
	}
	String deployingTo,deploymentStartDate,deploymentEndDate;
	public void addDeploymentDate(String releaseData,String testData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("Releases_Systems_AddButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Systems_AddDeploymentButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("Releases_Systems_DeploymentType_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Systems_DeploymentTypeDropdownFirst_Option",releaseData);
		sleep(2000);

		//sendKeys("Releases_Systems_DeploymentTitle_TextField","Releases_Deployment_Title",releaseData,testData);
		deployingTo=getTextData("Releases_Systems_DeployingToOption", releaseData);
		deploymentStartDate=getTextData("Releases_Systems_DeploymentStartDate", releaseData);
		deploymentEndDate=getTextData("Releases_Systems_DeploymentEndDate", releaseData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_UpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_ProjectCloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public void addCustomizationDeploymentDate(String releaseData,String testData,String objectData,String releaseName) throws InterruptedException {
		refresh(objectData);
		releasePage(releaseData, objectData);
		enterNewlyCreatedRelease(releaseData, testData, objectData, releaseName);
	    findAndOpenRelease(releaseData, testData, objectData,releaseName);
	    clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Systems_AddButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_AddDeploymentButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		clickElementUsingJavaScript("Releases_Systems_DeploymentType_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Systems_DeploymentTypeDropdownFirst_Option",releaseData);
		sleep(2000);
		
		clickElementUsingJavaScript("Releases_Systems_Deployment_UpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		deployingTo=getTextData("Releases_Systems_DeployingToOption", releaseData);
		deploymentStartDate=getTextData("Releases_Systems_DeploymentStartDate", releaseData);
		deploymentEndDate=getTextData("Releases_Systems_DeploymentEndDate", releaseData);
		
		clickElementUsingJavaScript("Releases_Systems_Deployment_ProjectCloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public void addEnterpriseDeploymentDate(String releaseData,String testData,String objectData,String releaseName) throws InterruptedException {
	    clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		sleep(3000);
		click("Releases_Systems_AddButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(4000);
		doubleClick("Releases_Systems_AddDeploymentButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_DeploymentTypeDropdownFirst_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		deployingTo=getTextData("Releases_Systems_DeployingToOption", releaseData);
		deploymentStartDate=getTextData("Releases_Systems_DeploymentStartDate", releaseData);
		deploymentEndDate=getTextData("Releases_Systems_DeploymentEndDate", releaseData);
		click("Releases_Systems_Deployment_UpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void addEnterpriseDeploymentDate(String releaseData,String testData,String objectData,String typeName,String releaseName) throws InterruptedException {
	    clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		sleep(4000);
		clickElementUsingJavaScript("Releases_Systems_AddButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(4000);
		doubleClick("Releases_Systems_AddDeploymentButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Releases_Systems_DeploymentTypeDropdown_Option",typeName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		deployingTo=getTextData("Releases_Systems_DeployingToOption", releaseData);
		deploymentStartDate=getTextData("Releases_Systems_DeploymentStartDate", releaseData);
		deploymentEndDate=getTextData("Releases_Systems_DeploymentEndDate", releaseData);
		click("Releases_Systems_Deployment_UpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void addDeploymentDate(String releaseData,String testData,String objectData,String typeName,String releaseName) throws InterruptedException {
	    clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Systems_AddButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(4000);
		doubleClick("Releases_Systems_AddDeploymentButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(3000);
		click("Releases_Systems_DeploymentType_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Systems_DeploymentTypeDropdown_Option",typeName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		deployingTo=getTextData("Releases_Systems_DeployingToOption", releaseData);
		deploymentStartDate=getTextData("Releases_Systems_DeploymentStartDate", releaseData);
		deploymentEndDate=getTextData("Releases_Systems_DeploymentEndDate", releaseData);
		click("Releases_Systems_Deployment_UpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void validateDeploymentAudit() {
		boolean flag=driver.findElement(By.xpath("//div[@class='dep-date'][1]//b/parent::div/following-sibling::div[text()='"+deploymentStartDate+" - "+deploymentEndDate+"']")).isDisplayed();
		assertTrue(flag);
	}
	public void createEvent(String releaseData,String testData,String objectData) {
		click("Releases_Event_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click("Releases_New_EventButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("Releases_Event_IdTextfield",PropertiesCache.setProperty(testData, "Event_Test_Automation_Id"),releaseData);
		sleep(1000);
		sendKeys("Releases_Event_NameTextfield",PropertiesCache.setProperty(testData, "Event_Test_Automation_Name"),releaseData);
		sleep(1000);
		sendKeys("Releases_Event_DescriptionTextfield",PropertiesCache.setProperty(testData, "Event_Test_Automation_Description"),releaseData);
		sleep(1000);
		click("UpdateButton", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Event_Test_Automation_Id")+" created successfully !");
	}
	public void updateEvent(String releaseData,String testData,String objectData) {
		clickElementUsingJavaScript("Releases_Event_TypeDropdown_Box",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Event_TypeDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		eventDropdownOption=getTextData("Releases_Event_TypeDropdownSecond_Option", releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Event_TypeDropdownSecond_Option",releaseData);
		sleep(1000);
		click("UpdateButton", objectData);
	}
	public void deleteEvent(String releaseData,String objectData) {
		clickElementUsingJavaScript("Releases_Event_DeleteButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnEnvironmentTab(String releaseData,String objectData) {
		clickElementUsingJavaScript("Releases_Environment_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
		click("Releases_EnviornmentRequest_Off_Checkbox",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
	}
	public void searchEnvironment(String releaseData,String objectData,String environmentId) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Releases_EnvironmentSearchbox", environmentId,releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
	}
	public void searchEnvironment(String releaseData,String testData,String objectData,String environmentId) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Releases_EnvironmentSearchbox", environmentId,releaseData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
	}
	public void clickOnChangeTab(String releaseData,String testData,String objectData) {
		click("Releases_Change_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_New_Change_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void createChangeSystem(String releaseData,String testData,String objectData,String systemsName,String newSystemButton) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("Releases_Systems_Name",PropertiesCache.setProperty(testData, systemsName),releaseData);
		sendKeys("Releases_Systems_DescriptonTextfield",PropertiesCache.setProperty(testData, "Systems_Automation_Description"),releaseData);
		sendKeys("Releases_Systems_VendorTextfield",PropertiesCache.setProperty(testData, "Systems_Automation_VendorValue"),releaseData);
		clickElementUsingJavaScript("Releases_Systems_ActiveRadio",releaseData);
		/* Click on Save & close Button */
		clickElementUsingJavaScript("Releases_Change_Systems_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void createEnvironment(String envData, String testData, String objectData,String enviornmentName,String envGroupName,String systemId) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options", envData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		windowScrollDown("250");
		click("NewEnvironment_Button", envData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		clickOnButton(envData, "Environment_Details_Tab", objectData);
		sendKeys("NewEnvironment_NameTextfield", PropertiesCache.setProperty(testData, enviornmentName), envData);
		sendKeysWithEnter("NewEnvironment_DescriptionTextfield", "New_ENV_Description", envData, testData);
		sendKeys("NewEnvironment_SystemTextbox", systemId, envData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("NewEnvironment_SystemValue",systemId, envData,testData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",envGroupName, envData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithValue",envGroupName, envData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvEnvironment_IntegrateWithTextbox",envGroupName, envData,testData);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		doubleClick("NewEnvironment_PhaseDropdown", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Environment_Phase_Value",getTextData("NewEnvironment_PhaseDropdownvalue",envData));
		clickElementUsingJavaScript("NewEnvironment_PhaseDropdownvalue", envData);
		sendKeysWithEnter("NewEnvironment_VendorTextfield", "New_ENV_Description", envData, testData);
		sleep(4000);
		doubleClick("NewEnvironment_StatusDropdown", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		PropertiesCache.setProperty(testData, "Environment_Status_Value",getTextData("NewEnvironment_StatusDropdownvalue",envData));
		click("NewEnvironment_StatusDropdownvalue", envData);
		sleep(1000);
		clickElementUsingJavaScript("NewEnvironment_SaveCloseButton", envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
	}
	public void clickOnSaveAndCloseButton(String releaseData,String objectData) {
		clickElementUsingJavaScript("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		sleep(1000);
	}
	public void clickOnReleaseSaveButton(String releaseData,String objectData) {
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
	}
	public void addCapacityValues(String releaseData,String testData,String objectData) {
		click("Releases_Capacity_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Releases_Capacity_FreeTextbox", "Capacity Free Text", releaseData);
		sleep(1000);
		//click("Releases_Capacity_A2Billing_Dropdown",releaseData);
		sleep(1000);

		clickOnSaveAndCloseButton(releaseData, objectData);

	}
	public void verifyCapacityValues(String releaseData,String testData,String objectData) {
		click("Releases_Capacity_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		verifyTextAttributeValue("Releases_Capacity_FreeTextbox", "Capacity Free Text", releaseData);
		//verifyTextAttributeValue("Releases_Capacity_CATTextbox", "Capacity CAT/AT Text", releaseData);
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	public void addRelatesToRelease(String releaseData,String testData,String objectData,String releaseId,String releaseName) {
		click("Releases_Link_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Releases_Link_RelatesTo_Label",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		scrollToElement("Releases_Link_RelatesTo_Textbox", releaseData);
		sleep(1000);
		click("Releases_Link_RelatesTo_Textbox",releaseData);
		sleep(2000);
		sendKeys("Releases_Link_RelatesTo_Textbox",releaseId,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		String projectId=PropertiesCache.getProperty(testData, releaseId);
		String projectName=PropertiesCache.getProperty(testData, releaseName);
		driver.findElement(By.xpath("//li[text()='"+projectId+": "+projectName+"']")).click();
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Releases_Link_AddButton",releaseData);
		Listener.addLogger("Relates Release is addded successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Relates to:']/following-sibling::div//div[@data-qtip='"+projectId+": "+projectName+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Relates Release is verified successfully !");

	}
	public void addParentToRelease(String releaseData,String testData,String objectData,String releaseId,String releaseName) {
		sleep(1000);
		click("Releases_Link_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Releases_Link_ParentTo_Label",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		scrollToElement("Releases_Link_ParentTo_Textbox", releaseData);
		sleep(1000);
		click("Releases_Link_ParentTo_Textbox",releaseData);
		sleep(2000);
		sendKeys("Releases_Link_ParentTo_Textbox",releaseId,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		String projectId=PropertiesCache.getProperty(testData, releaseId);
		String projectName=PropertiesCache.getProperty(testData, releaseName);
		driver.findElement(By.xpath("//li[text()='"+projectId+": "+projectName+"']")).click();
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		click("Releases_Link_AddButton",releaseData);
		Listener.addLogger("Parent Release is added successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Parent to:']/following-sibling::div//div[@data-qtip='"+projectId+": "+projectName+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Parent Release is verified successfully !");
	}
	public void addChildOfRelease(String releaseData,String testData,String objectData,String releaseId,String releaseName) {
		sleep(2000);
		click("Releases_Link_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Releases_Link_Childof_Label",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		scrollToElement("Releases_Link_Childof_Textbox", releaseData);
		sleep(1000);
		click("Releases_Link_Childof_Textbox",releaseData);
		sleep(2000);
		sendKeys("Releases_Link_Childof_Textbox",releaseId,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		String projectId=PropertiesCache.getProperty(testData, releaseId);
		String projectName=PropertiesCache.getProperty(testData, releaseName);
		driver.findElement(By.xpath("//li[text()='"+projectId+": "+projectName+"']")).click();
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Releases_Link_AddButton",releaseData);
		Listener.addLogger("Child Release is added successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Child of:']/following-sibling::div//div[@data-qtip='"+projectId+": "+projectName+"']")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Child Release is verified successfully !");
		sleep(1000);
	}
	public void addBulkUpdatePhaseAndGate(String releaseData,String testData,String objectData) throws ParseException {

		sleep(2000);
		String phaseDate=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//td[7]/div)[1]")).getText();
		String gateDate=driver.findElement(By.xpath("(//div[text()='"+gateName+"']/ancestor::tr//td[7]/div)[1]")).getText();
		WebElement element;

		sleep(2000);
		click("Release_PhasesAndGates_BulkUpdateButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Release_PhaseAndGates_ShiftDateValue","PhaseAndGatesDays",releaseData,testData);
		sleep(1000);
		click("Release_PhaseAndGates_Save&CloseButton",releaseData);
		Listener.addLogger("Bulk phase and gate is added successfully !");
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger("Release phase/gate bulk updation is successfully !");

		//if(phaseDate.matches("\\d{2}/\\d{2}/\\d{4}") || gateDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
			element=driver.findElement(By.xpath("//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getDateByString(phaseDate, "dd/MM/yyyy", "2")+"')]"));
			assertTrue(element.isDisplayed());
			Listener.addLogger("Bulk update Release Phase is verified successfully !");
			element=driver.findElement(By.xpath("//div[text()='"+gateName+"']/ancestor::tr//div[contains(text(),'"+getDateByString(gateDate, "dd/MM/yyyy", "2")+"')]"));
			assertTrue(element.isDisplayed());
			Listener.addLogger("Bulk update Release Gate is verified successfully !");
	/*	}else {
			element=driver.findElement(By.xpath("//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getDateByString(phaseDate, "yyyy/MM/dd", "2")+"')]"));
			assertTrue(element.isDisplayed());
			Listener.addLogger("Bulk update Release phase is verified successfully !");
			element=driver.findElement(By.xpath("//div[text()='"+gateName+"']/ancestor::tr//div[contains(text(),'"+getDateByString(gateDate, "yyyy/MM/dd", "2")+"')]"));
			assertTrue(element.isDisplayed());
			Listener.addLogger("Bulk update Release gate is verified successfully !");
		}*/
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	public void selectReleaseDependency(String releaseData,String testData,String objectData,String releaseName) {
		click("AddRelease_Release_Dependency_Textbox",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("AddRelease_Release_Dependency_Textbox",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("AddRelease_Release_Dependency_Value",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_PhaseAndGates_OnlyCheckbox",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_PhaseAndGates_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		Listener.addLogger("Added release dependency to release successfully !");
	}
	public void verifyPhaseAndGate(String releaseData,String testData,String objectData){
		//clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyText("Release_PhasesAndGates_Name", "Release_PhaseName", releaseData,testData);
		sleep(1000);
		verifyText("Release_PhasesAndGates_Name", "Release_GateName", releaseData,testData);
		sleep(2000);
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickOnSaveAndCloseButton(releaseData, objectData);
		Listener.addLogger("Verified phase & gate successfully !");

	}
	public void verifyNotVisiblePhaseAndGate(String releaseData,String testData,String objectData){
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, "Release_PhaseName"));
		sleep(1000);
		verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, "Release_GateName"));
		sleep(2000);
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickOnSaveAndCloseButton(releaseData, objectData);
	}

	public void phaseChildPush(String releaseData,String testData,String objectData) {
		click("Release_PhasesAndGates_ChildPush_Checkbox","Release_PhaseName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		sleep(1000);
		click("Release_PhasesAndGates_ChildPushButton",PlutoraConfiguration.releasesData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		click("Releases_Yes_Button",PlutoraConfiguration.releasesData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Update_Id"));
		verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IRelease_Automation_Update_Id"));
		verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Name"));
		verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IRelease_Automation_Name"));

		click("Release_PhaseAndGates_ChildPush_Close_Button",PlutoraConfiguration.releasesData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		Listener.addLogger("Added release child push sucessfully !");
	}
	public void gateIgnoreChild(String releaseData,String testData,String objectData) {
		click("Release_PhasesAndGates_IgnoreChild_Checkbox","Release_GateName",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		sleep(2000);
		Listener.addLogger("Added release ignore child sucessfully !");
	}
	public void verifyChildAndIgnorePushPhaseAndGate(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{
	//	clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		String phaseDate=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//td[6]/div)[1]")).getText();
		WebElement element=driver.findElement(By.xpath("//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+phaseDate+"')]"));
		assertTrue(element.isDisplayed());
		Listener.addLogger("Release Phase is verified successfully !");
		sleep(1000);
		verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, "Release_GateName"));
		sleep(2000);
		//clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		clickOnSaveAndCloseButton(releaseData, objectData);
	}

	public void searchReleaseManifest(String releaseData,String testData,String objectData,String releaseName) {
		sleep(1000);
		click("Release_Manifest_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeysWithEnter("Release_Manifest_SearchResult",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}

	public void selectManifestIntakeApproval(String releaseData,String testData,String objectData,String releaseName) {
		click("Release_Manifest_IntakeApproval_Dropdown",releaseName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "IntakeApprovalValue",getTextData("Release_Manifest_IntakeApproval_Dropdown_Value", releaseData));
		click("Release_Manifest_IntakeApproval_Dropdown_Value",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "IntakeApprovalValue")+" - Selected Intake Value from Release Manifest sucessfully");
	}
	public void verifySystemComment(String releaseData,String testData,String objectData) {
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Impact_CommentIcon",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Releases_Systems_Impact_CommentTextarea",PropertiesCache.setProperty(testData, "System_Comment_Text"),releaseData);
		sleep(1000);
		click("Releases_Systems_Impact_Send_Button",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(5000);
		Listener.addLogger("System comment is added successfully !");
		verifyText("Releases_Systems_Text","System_Comment_Text", releaseData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Releases_Systems_Close_Icon",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		verifyText("Releases_Systems_Impact_CommentNumber","1", releaseData);
		sleep(2000);
	}
	public void verifyAdditionalInformationField(String releaseData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		scrollToElement("Release_Additional_Information_Text", releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Additional_Information_Other_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyText("Release_Additional_Information_LabelName", "Release_CustomField_Name",releaseData,testData);
		validateElementDisplayed("Release_Additional_Information_LabelTextbox", "Release_CustomField_Name",releaseData,testData);
		/*if(customFieldList.contains("and")) {
			customFieldList=customFieldList.replace("and", "And");
		}
		customFieldList=customFieldList.replace(" ", "");
		boolean flag=driver.findElement(By.xpath("//label[text()='"+PropertiesCache.getProperty(testData, "Release_CustomField_Name")+"']/following-sibling::div/div[@dynamic-switch-when='EnumsManager.DataType."+customFieldList+"']")).isDisplayed();
		assertTrue(flag);*/
		//verifyCustomFieldValue(testData, objectData, customFieldList,releaseData,"Release_CustomField_Name","Release_Test_Automation_Id","Releases_Search_Result");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Release_CustomField_Name")+" - "+customFieldList+" is displayed on the web page");
	}

	public void verifyCapacityFields(String releaseData,String testData,String objectData,String capacityFieldvalue,String customFieldName) {
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Capacity_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		verifyText("Releases_Capacity_Label", customFieldName,releaseData,testData);
		validateElementDisplayed("Releases_Capacity_LabelTextbox", customFieldName,releaseData,testData);
		boolean flag=driver.findElement(By.xpath("(//div[text()='"+PropertiesCache.getProperty(testData, customFieldName)+"']/parent::div/following-sibling::div//div[contains(@id,'"+capacityFieldvalue+"')])[1]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" - "+capacityFieldvalue+" is displayed on the web page");
		sleep(1000);
		clickOnSaveAndCloseButton(releaseData, objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
	}
	public void selectEnvironmentStatus(String releaseData,String testData,String objectData,String checkbox,String status) {
		clickElementUsingJavaScript("Releases_Environment_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
		click("Release_Environment_Booking_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		validateElementDisplayed("Release_Environment_Booking_Title", releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Environment_Status_Checkbox",checkbox,releaseData);
		sleep(2000);
		click("Release_Environment_SaveAndClose_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		verifyText("Release_Environment_Status_Text",status,releaseData);
		sleep(2000);
	}
	public void verifySmartAlertWindow(String releaseData,String testData,String objectData,String environmentName) throws ParseException {

		sleep(2000);

		String phaseName=PropertiesCache.getProperty(releaseData, "Release_Environment_Enabled_Phase_Name");
		String phaseEndDate=getTextData("Release_Environment_Phase_EndDate",environmentName,releaseData,testData).split(":")[1].trim();

		String currentDate,futureDate;
		//if(phaseEndDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
			currentDate=getDateByString(phaseEndDate, "dd/MM/yyyy", "0");
			futureDate=getDateByString(phaseEndDate, "dd/MM/yyyy", "2");
			phaseEndDate=new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(phaseEndDate));
		/*}else {
			currentDate=getDateByString(phaseEndDate, "yyyy/MM/dd", "0");
			futureDate=getDateByString(phaseEndDate, "yyyy/MM/dd", "2");
			phaseEndDate=new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(phaseEndDate));
			System.out.println(phaseEndDate);
		}*/

		WebElement element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::tr/preceding-sibling::tr//td[contains(@class,'switch-small-on-icon')]/following-sibling::td//b[text()='Start Date:']/parent::div[contains(text(),'"+currentDate+"')]"));
		assertTrue(element.isDisplayed());
		element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::tr/preceding-sibling::tr//td[contains(@class,'switch-small-on-icon')]/following-sibling::td//b[text()='End Date:']/parent::div[contains(text(),'"+currentDate+"')]"));
		assertTrue(element.isDisplayed());
		element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::div[@class='row']/following-sibling::div[contains(@class,'environment-bundle-status')]/div[text()='"+currentDate+" - "+currentDate+"']"));
		assertTrue(element.isDisplayed());
		Listener.addLogger("Environment phase & gate start date and end date is verified sucessfully");

		click("Project_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		//clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+currentDate+"')])[2]"));

		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(phaseEndDate, "2"));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger("Release Phase is updated successfully !");

		clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		validateElementDisplayed("Release_PhaseAndGates_EnvironmentBookingSmartAlertText", releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_PhaseAndGates_Shift_Checkbox",releaseData);
		sleep(2000);
		click("Release_PhaseAndGates_EnvironmentBookingSmartAlert_ContinueButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_PhaseAndGates_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Resolved smart alert popup sucessfully");

		element=driver.findElement(By.xpath("//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+futureDate+"')]"));
		assertTrue(element.isDisplayed());

		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);

		clickElementUsingJavaScript("Releases_Environment_Tab",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(4000);

		element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::tr/preceding-sibling::tr//td[contains(@class,'switch-small-on-icon')]/following-sibling::td//b[text()='Start Date:']/parent::div[contains(text(),'"+currentDate+"')]"));
		assertTrue(element.isDisplayed());
		element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::tr/preceding-sibling::tr//td[contains(@class,'switch-small-on-icon')]/following-sibling::td//b[text()='End Date:']/parent::div[contains(text(),'"+futureDate+"')]"));
		assertTrue(element.isDisplayed());
		element=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, environmentName)+"']/ancestor::div[@class='row']/following-sibling::div[contains(@class,'environment-bundle-status')]/div[text()='"+currentDate+" - "+futureDate+"']"));
		assertTrue(element.isDisplayed());
		Listener.addLogger("Phase & Gate Feature to move booking date once the phase date is moved is verified sucessfully");

	}
	public void clickOnCapacityExportToXLS(String releaseData,String testData,String objectData) {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		click("Releases_Capacity_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Capacity_SizingItems_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		click("Releases_Capacity_SizingItems_Dropdown_Option",releaseData);
		waitForLoadingIconDisappear(200,"Loading_Gif", objectData);
		sleep(4000);
		click("Releases_Capacity_Thresholds_Label",releaseData);
		sleep(2000);
		click("Releases_Capacity_ExportToXLS",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(4000);
	}
	public void clickOnActivityExportToXLS(String releaseData,String testData,String objectData) {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		click("Releases_ActivitesTab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_ImportActivities_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Release_Activity_ExportToXLS_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);

	}
	
	public void importReleaseActivites(String releaseData,String testData,String objectData,String releaseId) {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_ActivitesTab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_ImportActivities_Button",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ImportFromRelease_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		sendKeys("Release_Activity_ImportFromRelease_ReleaseId", releaseId, releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(3000);
		clickElementUsingJavaScript("Dropdown_First_Option",objectData);
		sleep(1000);
		click("Release_Activity_ImportFromRelease_Import_Checkbox",releaseData);
		sleep(2000);
		click("Release_Activity_ImportFromRelease_Import_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	public void createDuplicateActivities(String releaseData,String testData,String objectData,String activityId) {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Id_Checkbox",activityId,releaseData,testData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ActionButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_Action_DuplicateActivities_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Release_Activity_Duplicate_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Release_Activity_Duplicate_Yes_button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	public void pushActivityChild(String releaseData,String testData,String objectData,String activityId,String activityName,String tab,String releaseId,String releaseName,String activityButton,int i){
		clickElementUsingJavaScript("Releases_ActivitesTab", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_AddNewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript(activityButton,releaseData);
		sleep(1000);
		clickElementUsingJavaScript(tab,releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, activityId),releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, activityName),releaseData);
		sleep(2000);
		if(activityId.contains("Activity")) {
			click("Release_Activity_AssignedToPhaseDropdown",releaseData);
			sleep(1000);
			PropertiesCache.setProperty(testData, "Release_Activity_PhaseName",getTextData("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData));
			sleep(1000);
			click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
			sleep(1000);
		}else {
			click("Release_Criteria_AssignedToGateDropdown",releaseData);
			sleep(1000);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			PropertiesCache.setProperty(testData, "Criteria_Gate",getTextData("Release_Activity_AssignedToDropdownFirst_Option", releaseData));
			click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
			sleep(1000);
		}
		click("Release_Activity_AssignedToDropdown",releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Release_Activity_AssignedTo",getTextData("Release_Activity_AssignedToDropdownFirst_Option",releaseData));
		sleep(1000);
		click("Release_Activity_AssignedToDropdownFirst_Option",releaseData);
		sleep(1000);
		
		click("Release_Activity_ForecastDate_Drodown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		PropertiesCache.setProperty(testData, "Release_Activity_ForecastDate",getAttributeData("Release_Activity_ForecastDate_Value",releaseData).split(" ")[0].trim());
		sleep(4000);
		
		click("Release_Activity_StartDate_Dropdown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		PropertiesCache.setProperty(testData, "Release_Activity_StartDate",getAttributeData("Release_Activity_StartDate_Value",releaseData).split(" ")[0].trim());
		sleep(4000);
		
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(3000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
		sleep(4000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		performChildPush(releaseData, testData, objectData,activityId,releaseId,releaseName,i);
	}
	
	public void performChildPush(String releaseData,String testData,String objectData,String activityId,String releaseId,String releaseName,int i) {
		clickElementUsingJavaScript("Release_Activity_Id",activityId,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Button",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_AssignedTo_Checkbox",releaseData);
		clickElementUsingJavaScript("Release_Activity_ChildPush_ForecastDate_Checkbox",releaseData);
		clickElementUsingJavaScript("Release_Activity_ChildPush_DueDate_Checkbox",releaseData);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Status_Checkbox",releaseData);
		sleep(4000);
		selectDDLByIndex("Release_Activity_ChildPush_Status_Dropdown", i, releaseData);
		PropertiesCache.setProperty(testData, "Status_"+i,getSelectedOptionFromSelectDropdown("Select_Dropdown", releaseData));
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_CustomFields_Checkbox",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Yes_Button",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		verifyTextDisplayedInPage(PropertiesCache.getProperty(testData, releaseId));
		verifyTextDisplayedInPage(PropertiesCache.getProperty(testData, releaseName));
		Listener.addLogger("Release Id and Release Name  is available during child push !");
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Close_Button",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnActivityImportFromXLS(String releaseData,String testData,String objectData,String platform,String fileName) throws IOException, AWTException {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		click("Releases_ActivitesTab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_ImportActivities_Button",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif", objectData);
		sleep(3000);
		//click("Release_Activity_ImportFromXLS_Option",releaseData);
		//waitForLoadingIconDisappear("Loading_Gif", objectData);
		//sleep(2000);
		uploadImage("UploadFile", objectData,fileName);
		waitForLoadingIconDisappear(120,"Loading_Gif", objectData);
		sleep(5000);
	}
	public String getFormatDate(String date,String format,String parseDate) throws ParseException {
		if(date.matches("\\d{2}/\\d{2}/\\d{4}")) {
			date=new SimpleDateFormat(format).format(new SimpleDateFormat("dd/MM/yyyy").parse(parseDate));
		}else {
			date=new SimpleDateFormat(format).format(new SimpleDateFormat("yyyy/MM/dd").parse(parseDate));
		}
		return date;
	}
	public void createProjectReleaseWithEnvironment(String releaseData,String testData,String objectData,String envId,String releaseId,String releaseName,String systemId,String enterpriseReleaseName ) {	
		sleep(2000);
		scrollToElement("AddNewRelease_Button",releaseData);
		clickElementUsingJavaScript("AddNewRelease_Button",releaseData);
		sleep(2000);
		click("AddProjectRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnHideButton(releaseData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, releaseId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, releaseName),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sendKeys("Releases_Independent_Release_Dependency_Dropdown_Option","Independent",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(2000);
		click("AddRelease_Dependency_Dropdown",releaseData);
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate",releaseData);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_ImplementationDate_TodayButton",releaseData);
		sleep(2000);
		selectReleaseDependency(releaseData, testData, objectData,enterpriseReleaseName);
		click("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Applications_Tab",PlutoraConfiguration.releasesData);
		waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		sleep(2000);
		searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,systemId);
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_RegressionVerificationDependency_Section", systemId,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		click("AddRelease_SaveButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);

		clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", envId,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Release_Phase_Name",getTextData("Release_Environment_Phase_Name", PlutoraConfiguration.releasesData).split(" ")[1].trim());
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public void addEnvironmentToPhase(String releaseData,String testData,String objectData,String environmentName) throws InterruptedException {
		releasePage(releaseData, objectData);
		enterNewlyCreatedRelease(releaseData, testData, objectData, "PRelease_Automation_Id");
		findAndOpenRelease(releaseData, testData, objectData, "PRelease_Automation_Id");
		clickElementUsingJavaScript("Releases_Environment_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
		dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", environmentName,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		click("AddRelease_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);

	}

	public void bookEnvironment(String releaseData,String testData,String objectData,String environmentName) throws InterruptedException {
		releasePage(releaseData, objectData);
		enterNewlyCreatedRelease(releaseData, testData, objectData, "PRelease_Automation_Id");
		findAndOpenRelease(releaseData, testData, objectData, "PRelease_Automation_Id");
		clickElementUsingJavaScript("Releases_Environment_Tab",releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Environment_Booking_Close_Icon",environmentName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", environmentName,PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		waitForLoadingIconDisappear(800,"Loading_Gif",objectData);
		sleep(2000);
	}

	public void removeStakeholder(String releaseData,String testData,String objectData,String stakeHolderName,String removeButton) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		doubleClick("Releases_Shakeholder_Name_Row",stakeHolderName,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(removeButton,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	private void stakeholderSelection(String releaseData,String testData,String objectData,int i) {
		clickElementUsingJavaScript("Releases_UserGroupDropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//ul[contains(@id,'boundlist')]//div[@class='users_group_icon'])["+i+"]/div"));
		sleep(1000);
		PropertiesCache.setProperty(testData, "Stakeholder_Name_"+i,element.getText());
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_ShakeholderRACILabel",releaseData);
		sleep(2000);
	}
	public void updateMultipleStakeholder(String releaseData,String testData,String objectData,String stakeholderButton){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		try {
		clickElementUsingJavaScript("Releases_StakeholdersTab", releaseData);
		}catch(Exception e) {
			
		}
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript(stakeholderButton,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		stakeholderSelection(releaseData, testData, objectData, 1);
		click("Releases_Save&AddMore_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		stakeholderSelection(releaseData, testData, objectData, 2);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Releases_Add&CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);

	}
	
	public void clickOnElement(String releaseData,String objectData,String releaseId){
		clickElementUsingJavaScript(releaseId,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void updateInsightActivity(String releaseData,String testData,String objectData){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, "Activity_Name"),releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, "Activity_Title"),releaseData);
		sleep(2000);
		click("Release_Activity_AssignedToPhaseDropdown",releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Activity_AssignedToPhase",getTextData("Release_Activity_AssignedToPhaseDropdownSecond_Option", releaseData));
		click("Release_Activity_AssignedToPhaseDropdownSecond_Option",releaseData);
		sleep(1000);
		click("Release_Activity_AssignedToDropdown",releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Activity_AssignedTo",getTextData("Release_Activity_AssignedToDropdownSecond_Option", releaseData));
		click("Release_Activity_AssignedToDropdownSecond_Option",releaseData);
		sleep(1000);
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
	}
	public void updateDueDate(String releaseData,String testData,String objectData,String days) throws ParseException{
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, "Activity_Name"),releaseData);
		sleep(1000);
		sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, "Activity_Title"),releaseData);
		sleep(2000);
		click("Release_Activity_DueDateDropdown",releaseData);
		sleep(2000);
		applicationDatePicker(releaseData, testData, "Release_Activity_DueDate_Calender", getDate(getCurrentDate("0"), days));
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
	}
	

	//Release schedule
	public void releaseSchedulePage(String releaseData,String objectData) throws InterruptedException {	
		sleep(2000);
		mouseHover("Releases_Header_Dropdown", "Release_Scheduler_DropdownOption",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getReleaseScheduleDateRangePage(String releaseData, String testData, String objectData) throws  ParseException {
		//from date
		sleep(1000);
		click("Release_SearchRelease_FromDate_Textbox",releaseData);
		sleep(3000);

		applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1", getCurrentDate("0"));
		sleep(1000);
		click("Release_SearchRelease_ToDate_Textbox",releaseData);
		sleep(2000);
		
		releaseDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1", getCurrentDate("30"));
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public boolean getDateRangeFilterPage(String releaseData, String testData, String objectData) throws  ParseException {
		boolean flag = false;
		String releaseFromDate = getTextData("Release_ScheduleImplementationDate_Text", releaseData);
		String releaseToDate = getTextData("Release_ScheduleImplementationDate_Text", releaseData);
		if (releaseFromDate.equals("")) {
			releaseFromDate = getTextData("Release_ScheduleImplementationDate_Text", releaseData);
		}
		Date fromDates = convertStringToDate(getTodayDate("0", "dd/MM/yyyyy"));
		Date fromReleaseDates = convertStringToDate(releaseFromDate);
		Date toDates = convertStringToDate(getTodayDate("30", "dd/MM/yyyyy"));
		Date toReleaseDates = convertStringToDate(releaseToDate);
		if (fromDates.compareTo(fromReleaseDates)<=0 &&
				toDates.compareTo(toReleaseDates)>=0) {
			flag = true;
		}
		return flag;
	}

	public Date convertStringToDate(String convertDate) throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.parse(convertDate);
		return date;

	}

	public boolean getReleaseStructureEnterprisePage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {
		boolean flag = false;
		doubleClick("Release_StructureAll_Checkbox", releaseData);
		sleep(1000);
		click("Release_StructureEnterprise_Checkbox",releaseData);
		sleep(1000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int gridRows = elementsCount("Release_StructureGrid_Rows", releaseData);
		int entImages = elementsCount("Release_StructureEnterprise_Images", releaseData);
		if (gridRows==entImages) {
			flag = true;
		}
		return flag;
	}

	public boolean getReleaseStructureProjectPage(String releaseData, String testData, String objectData) throws ParseException {
		boolean flag = false;
		doubleClick("Release_StructureAll_Checkbox", releaseData);
		sleep(1000);
		click("Release_StructureProject_Checkbox",releaseData);
		sleep(1000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int gridRows = elementsCount("Release_StructureGrid_Rows", releaseData);
		int proImages = elementsCount("Release_StructureProject_Images", releaseData);
		if (gridRows==proImages) {
			flag = true;
		}
		return flag;
	}

	public boolean getReleaseStructureIndependentPage(String releaseData, String testData, String objectData) throws  ParseException {
		boolean flag = false;
		doubleClick("Release_StructureAll_Checkbox", releaseData);
		sleep(1000);
		click("Release_StructureIndependent_Checkbox",releaseData);
		sleep(1000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int gridRows = elementsCount("Release_StructureGrid_Rows", releaseData);
		int indImages = elementsCount("Release_StructureIndependent_Images", releaseData);
		if (gridRows==indImages) {
			flag = true;
		}
		return flag;
	}

	public boolean getReleaseStructureAllPage(String releaseData, String testData, String objectData) throws  ParseException {
		boolean flag = false;
		doubleClick("Release_StructureAll_Checkbox", releaseData);
		sleep(1000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int gridRows = elementsCount("Release_StructureGrid_Rows", releaseData);
		int entImages = elementsCount("Release_StructureEnterprise_Images", releaseData);
		int proImages = elementsCount("Release_StructureProject_Images", releaseData);
		int indImages = elementsCount("Release_StructureIndependent_Images", releaseData);
		if (gridRows==(entImages+proImages+indImages)) {
			flag = true;
		}
		return flag;
	}

	public boolean getReleaseStructureGroupByPage(String releaseData, String testData, String objectData) throws  ParseException {
		boolean flag = false;
		doubleClick("Release_StructureAll_Checkbox", releaseData);
		sleep(1000);
		click("Release_StructureGroupBy_Checkbox",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int gridRows = elementsCount("Release_StructureGrid_Rows", releaseData);
		int entImages = elementsCount("Release_StructureEnterprise_Images", releaseData);
		int proImages = elementsCount("Release_StructureProject_Images", releaseData);
		int indImages = elementsCount("Release_StructureIndependent_Images", releaseData);
		if (gridRows==(entImages+proImages+indImages)) {
			flag = true;
		}
		return flag;
	}

	public void getToggleButtonsOffPage(String releaseData, String testData, String objectData) throws  ParseException {
		String toggleReleaseIdName = getAttributeValue("Release_IdNameToggle_Button", releaseData,"class");
		String toggleSystem = getAttributeValue("Release_SystemToggle_Button", releaseData,"class");
		String togglePortfolio = getAttributeValue("Release_PortfolioToggle_Button", releaseData,"class");
		String toggleReleaseStatus = getAttributeValue("Release_StatusToggle_Button", releaseData,"class");
		String toggleReleaseType = getAttributeValue("Release_TypeToggle_Button", releaseData,"class");
		//Release Id Name
		if (toggleReleaseIdName.contains("x-btn-pressed")) {
			getToggleClearData(releaseData, testData, objectData, "Release_IdNameToggle_Button");
		}
		//System
		if (toggleSystem.contains("x-btn-pressed")) {
			getToggleClearData(releaseData, testData, objectData, "Release_SystemToggle_Button");
		}
		//Portfolio
		if (togglePortfolio.contains("x-btn-pressed")) {
			getToggleClearData(releaseData, testData, objectData, "Release_PortfolioToggle_Button");
		}
		//Release Status
		if (toggleReleaseStatus.contains("x-btn-pressed")) {
			getToggleClearData(releaseData, testData, objectData, "Release_StatusToggle_Button");
		}
		//Release Type
		if (toggleReleaseType.contains("x-btn-pressed")) {
			getToggleClearReleaseType(releaseData, testData, objectData, "Release_TypeToggle_Button");
		}

	}

	public void getToggleClearData(String releaseData, String testData, String objectData, String elementId) throws ParseException {
		//Toggle clear data
		sleep(1000);
		click(elementId,releaseData);
		sleep(1000);
		click("Release_TogglePopupClear_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getToggleClearReleaseType(String releaseData, String testData, String objectData, String elementId) throws ParseException {
		//Toggle clear data
		sleep(1000);
		click(elementId,releaseData);
		sleep(1000);
		click("Release_TypePopupClear_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}


	public void getFilterReleaseIdNameAddPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"123Systems_Test_Automation_Id","Releases_New_SystemsButton");
		searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"123Systems_Test_Automation_Id");
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "123Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData, "AddRelease_SaveButton");
		clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData, "Release_Tab");
		clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		driver.navigate().refresh();
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		sleep(2000);
		click("Release_Scheduler_Clear_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/*getReleaseScheduleDateRangePage(releaseData,testData,objectData);
		sleep(2000);*/
		click("Release_IdNameToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Release_TogglePopupLiveSearch_Textbox", PropertiesCache.getProperty(testData, "Release_Test_Automation_Id"),releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		dragAndDrop("Release_PopupSearchedRelease_Text", "Release_PopupSelected_Area", "Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		mouseHover("Releases_GA_Header","Releases_GA_Header",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public boolean getFilterReleaseIdNameClearPage(String releaseData, String testData, String objectData) throws  ParseException {

		boolean flag = false;
		sleep(2000);
		getToggleClearData(releaseData, testData, objectData, "Release_IdNameToggle_Button");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String actualValue = getAttributeValue("Release_IdNameToggle_Button", releaseData,"class");
		if (actualValue.contains("x-btn-pressed")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}
	
	public void getFilterPortfoilioAddPage(String releaseData, String testData, String objectData) throws InterruptedException {
		sleep(2000);
		click("Release_Scheduler_Clear_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_SystemToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Release_TogglePopupLiveSearch_Textbox", PropertiesCache.getProperty(testData, "Release_Test_Automation_Id"),releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		dragAndDrop("Release_PopupSearchedRelease_Text", "Release_PopupSelected_Area", "Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		mouseHover("Releases_GA_Header","Releases_GA_Header",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void changeStatus(String releaseData,String testData,String objectData,String dropdown,String option,String name) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(dropdown,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(option, name,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(releaseData,"Release_Change_Status_Yes_Button", objectData);
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	
	public void getFilterReleaseCreatePage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		releasePage(releaseData,objectData);
		newERPage(releaseData, testData,objectData,"Release_Test_Automation_Id");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyRelease(releaseData, testData,objectData, "Release_Test_Automation_Id");
		findAndOpenRelease(releaseData,testData,objectData,"Release_Test_Automation_Id");
		createSystem(releaseData,testData,objectData,"123Systems_Test_Automation_Id","Releases_New_SystemsButton");
		searchSystem(releaseData,testData,objectData,"123Systems_Test_Automation_Id");
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "123Systems_Test_Automation_Id",releaseData,testData);
		clickOnElement(releaseData,objectData, "AddRelease_SaveButton");
		clickOnElement(releaseData,objectData, "Release_Tab");
		clickOnSaveAndCloseButton(releaseData, objectData);
		driver.navigate().refresh();
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		releasePage(releaseData,objectData);
		releaseSchedulePage(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public boolean getFilterReleaseIdNameClearPage(String releaseData, String testData, String objectData,String elementId) throws InterruptedException, ParseException {

		boolean flag = false;
		sleep(2000);
		getToggleClearData(releaseData, testData, objectData, elementId);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String actualValue = getAttributeValue(elementId, releaseData,"class");
		if (actualValue.contains("x-btn-pressed")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}
	public void getFilterSystemAddPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		click("Release_SystemToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
		mouseHover("Release_SystemSelectedName_Text","Release_SystemSelectedNameSorting_Button",releaseData);
		sleep(1000);
		click("Release_SystemSelectedNameAsc_Link",releaseData); 
		sleep(2000);
		dragAndDrop("Release_SystemAvailable_Text", "Release_SystemSelected_Area","123Systems_Test_Automation_Id",releaseData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Release_TogglePopupSaveClose_Button",releaseData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		mouseHover("Releases_GA_Header","Releases_GA_Header",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}
	public boolean getFilterReleaseIdNameClearPage(String releaseData, String testData, String objectData,String elementId,String popupElementId) throws InterruptedException, ParseException {

		boolean flag = false;
		sleep(2000);
		getToggleClearData(releaseData, testData, objectData, elementId,popupElementId);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String actualValue = getAttributeValue(elementId, releaseData,"class");
		if (actualValue.contains("x-btn-pressed")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}
	public void getToggleClearData(String releaseData, String testData, String objectData, String elementId,String popupClearButton) throws  ParseException {
		//Toggle clear data
		sleep(1000);
		click(elementId,releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript(popupClearButton,releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public boolean getFilterReleaseIdNameOnPage(String releaseData, String testData, String objectData,String elementId,String popupElementId) throws  ParseException {

		boolean flag = false;
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String actualValue = getAttributeValue(elementId, releaseData,"class");
		if (actualValue.contains("x-btn-pressed")) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
	public boolean getFilterPortfolioClearPage(String releaseData, String testData, String objectData,String elementId) throws  ParseException {

		boolean flag = false;
		click("Release_PortfolioToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Release_PortfolioSelected_Text", "Release_PortfolioAvailable_Area",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String actualValue = getAttributeValue(elementId, releaseData,"class");
		if (actualValue.contains("x-btn-pressed")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}
	public void getFilterReleaseStatusAddPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		click("Release_StatusToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		dragAndDrop("Release_StatusAvailable_Text", "Release_SystemSelected_Area","Release_Status",releaseData,testData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(2000);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		mouseHover("Releases_GA_Header","Releases_GA_Header",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}
	public void getFilterReleaseTypeAddPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		click("Release_TypeToggle_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("Release_TypePopupSearch_Textbox", "Release_Type", releaseData, testData);
		sleep(2000);
		dragAndDrop("Release_StatusAvailable_Text", "Release_SystemSelected_Area","Release_Type",releaseData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(2000);
		click("Release_TogglePopupSaveClose_Button",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//clickElementUsingJavaScript("Releases_GA_Header",releaseData);
		mouseHover("Releases_GA_Header","Releases_GA_Header",releaseData);
		sleep(2000);
		click("Release_SearchRelease_View_Button",releaseData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}
	public void getReleaseTimelinePage(String releaseData, String testData, String objectData) throws ParseException {

		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_Timeline_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//Weekly
		click("Release_TimelineWeekly_Option",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyTextContainsLowerCase("Release_TimelineWeekly_Text",getCurrentDate("0").substring(3, 6),releaseData);
		Listener.addLogger("Release Schedule shown based on the timeline Weekly scale successfully !");
		//Quarterly
		clickElementUsingJavaScript("Release_Timeline_Dropdown",releaseData);
		click("Release_TimelineQuarterly_Option",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyTextContains("Release_TimelineWeekly_Text","ReleaseQuaterlyText",releaseData,testData);
		Listener.addLogger("Release Schedule shown based on the timeline Quartely scale successfully !");
		sleep(2000);
		//Monthly
		clickElementUsingJavaScript("Release_Timeline_Dropdown",releaseData);
		click("Release_TimelineMonthly_Option",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		verifyTextContainsLowerCase("Release_TimelineYearly_Text",getCurrentDate("0").substring(3, 6),releaseData);
		Listener.addLogger("Release Schedule shown based on the timeline Monthly scale successfully !");
		sleep(2000);
		//Yearly
		clickElementUsingJavaScript("Release_Timeline_Dropdown",releaseData);
		sleep(2000);
		click("Release_TimelineYearly_Option",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyTextContains("Release_TimelineYearly_Text", getCurrentDate("0").substring((getCurrentDate("0")).length()-4),releaseData);
		Listener.addLogger("Release Schedule shown based on the timeline Yearly scale successfully !");

	}

	public void verifyReleaseFieldPermissionCustomField(String releaseData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Release_Additional_Information_Other_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Release_Additional_Information_LabelName", name,releaseData,testData);
			sleep(1000);
			verifyText("Release_Additional_Information_LabelName",name,releaseData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,releaseData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Release_Additional_Information_Other_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Release_Additional_Information_LabelName", name,releaseData,testData);
			sleep(1000);
			verifyText("Release_Additional_Information_LabelName",name,releaseData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,releaseData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Release_Additional_Information_Other_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		}
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	public void verifyCapacityFieldPermissionCustomField(String releaseData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickElementUsingJavaScript("Releases_Capacity_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			sleep(1000);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Releases_Capacity_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Releases_Capacity_Tab",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		}
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	
	public void verifySchedulerColor(String releaseData,String testData,String objectData,String releaseName) {
		if(!flag) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SchedulerColor_Dropdown",objectData);
		clickOnButton(releaseData,"AddRelease_SchedulerColor_SecondOption",objectData);
		Listener.addLogger(releaseName+" able to select scheduler color successfully");
		}else {
		validateElementDisplayed("AddRelease_SchedulerColor_Disabled", releaseData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Release_Color_Code",getAttributeValue("AddRelease_SchedulerColor_Disabled", releaseData,"value").replace("#",""));
		Listener.addLogger(releaseName+" unable to select scheduler color successfully");
		}
	}
	public void updateReleaseType(String releaseData,String testData,String objectData,String typeName) {
		clickElementUsingJavaScript("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("AddRelease_ReleaseType_Option",typeName, releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnReleaseSaveButton(releaseData, objectData);
	}
	public void linkSystemToRelease(String releaseData,String testData,String objectData,String systemId,String sectionName,String customizationId) {
		clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		searchSystem(releaseData,testData,objectData,systemId);
		verifyText("Releases_SystemsName_Text",systemId,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, systemId)+" - Systems is verified successfully !");
		sleep(1000);
		dragAndDrop("Releases_SystemsName_Section", sectionName, systemId,customizationId,releaseData,testData);
		Listener.addLogger("Systems is dragged and dropped to Impacted grid successfully !");
		clickOnReleaseSaveButton(releaseData, objectData);
	}
	public void linkSystemToEnterpriseRelease(String releaseData,String testData,String objectData,String systemId) {
		clickElementUsingJavaScript("Releases_Applications_Tab",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		searchSystem(releaseData,testData,objectData,systemId);
		verifyText("Releases_SystemsName_Text",systemId,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, systemId)+" - Systems is verified successfully !");
		sleep(1000);
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", systemId,releaseData,testData);
		Listener.addLogger("Systems is dragged and dropped successfully !");
		clickOnReleaseSaveButton(releaseData, objectData);
		sleep(3000);
	}
	public void linkChangeToRelease(String releaseData,String testData,String objectData,String systemId) {
		click("Releases_Change_Tab",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		verifyTextDisplayedInPage(PropertiesCache.getProperty(testData, systemId));
		Listener.addLogger("Systems is verified successfully !");
		sleep(1000);
		dragAndDrop("Releases_Change_Name_Section", "Releases_Change_Project_Release_Section", systemId,releaseData,testData);
		Listener.addLogger("Change is drag and dropped successfully !");
		clickOnReleaseSaveButton(releaseData, objectData);
	}
	public void clickOnReleaseField(String releaseData,String testData,String objectData,String dropdown,String option,String name) {
		clickElementUsingJavaScript(dropdown, releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in release dropdown successfully");
		sleep(1000);
		clickElementUsingJavaScript(option, name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyWorkflowStatus(String releaseData,String testData,String objectData,String option,String textbox,String name) {
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_StatusDropdown", releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
	//	verifyText(option, name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in release dropdown successfully");
		click(option, name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//verifyText(textbox,name,tebrData,testData);
		clickOnReleaseSaveButton(releaseData, objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void verifyReleasePhaseExcludeWeekendDaysOption(String releaseData,String testData,String objectData,String phaseName,String format,String days,int weekDaysCount,String currentDate) throws ParseException {
		
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", format)+"')])[2]"));

		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat(format).parse(getTodayDate("0", format))), days));
		sleep(2000);
		waitForLoadingIconDisappear(10,"Loading_Gif",objectData);
		//sendKeys("Additional_information_TimePicker_Box_Textbox", "23:59",objectData);
		click("Additional_Information_HourSlider", objectData);
        click("Additional_Information_MinuteSlider",objectData);
		sleep(2000);
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		Listener.addLogger("Release Phase is updated successfully !");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
		sleep(2000);
		String duration=getTextData("Release_PhaseAndGates_Duration_Text",phaseName,PlutoraConfiguration.releasesData).split("Days")[0].trim();
		Listener.addLogger(duration+" "+weekDaysCount);
		if(weekDaysCount+1 >= Integer.parseInt(duration)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		//verifyTextContains("Release_PhaseAndGates_Duration_Text",String.valueOf(weekDaysCount),PlutoraConfiguration.releasesData);
		Listener.addLogger(weekDaysCount+1+ " - number of weekdays are available after choosing 'Exclude weekends when calculating total duration of Phases' option from customization page !");
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	public void verifyReleasePhaseExcludeBlackoutOption(String releaseData,String testData,String objectData,String phaseName,String format,String days,int weekDaysCount,String currentDate) throws ParseException {
		clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		sleep(2000);
		WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate(currentDate, format)+"')])[1]"));

		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat(format).parse(getTodayDate(currentDate, format))), days));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		Listener.addLogger("Release Phase is updated successfully !");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
		sleep(2000);
		String duration=getTextData("Release_PhaseAndGates_Duration_Text",phaseName,PlutoraConfiguration.releasesData).split("Days")[0].trim();
		Listener.addLogger(weekDaysCount+" "+duration);
		if(weekDaysCount >= Integer.parseInt(duration)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		//verifyTextContains("Release_PhaseAndGates_Duration_Text",String.valueOf(weekDaysCount+weekDaysCount),PlutoraConfiguration.releasesData);
		Listener.addLogger(weekDaysCount+ " - number of weekdays are available after choosing 'Exclude weekends when calculating total duration of Phases' option from customization page !");
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		clickOnSaveAndCloseButton(releaseData, objectData);
	}
	public void verifyReleaseOptions(String releaseData,String testData,String objectData,String releaseName,String dropdown,String option,String textbox,String name) {
		click(textbox,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		doubleClick(dropdown,releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Release Event dropdown successfully");
		click(option, name,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("UpdateButton", objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(releaseData, objectData);
		enterNewlyCreatedRelease(releaseData, testData, objectData, releaseName);
		findAndOpenRelease(releaseData, testData, objectData, releaseName);
		verifyText(textbox,name,releaseData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after change save and close successfully");
		clickOnSaveAndCloseButton(releaseData, objectData);
		
	}
	public void verifyChildPushFieldsDisabled(String releaseData,String testData,String objectData,String activityId) {
		clickElementUsingJavaScript("Release_Activity_Id",activityId,releaseData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		validateElementDisplayed("Release_NameField_ReadOnly", releaseData);
		validateElementDisplayed("Release_TitleField_ReadOnly", releaseData);
		if(activityId.contains("Criteria")) {
		validateElementDisplayed("Release_EntryCriteriaField_ReadOnly", releaseData);
		validateElementDisplayed("Release_ExitCriteriaField_ReadOnly", releaseData);
		}else {
		validateElementDisplayed("Release_ActivityField_ReadOnly", releaseData);
		validateElementDisplayed("Release_MilestoneField_ReadOnly", releaseData);
		validateElementDisplayed("Release_StageGateField_ReadOnly", releaseData);
		validateElementDisplayed("Release_DecisionPointField_ReadOnly", releaseData);
		}
		validateElementDisplayed("Release_PhaseField_ReadOnly", releaseData);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(1000);
		
	}
	 public void updateActivityStatusFromGrid(String releaseData,String testData,String objectData,String status,String activityId){
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Activity_Status_Column", activityId,releaseData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("Release_Criteria_Status_Option",status,releaseData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(status+" updated activity grid successfully !");
		
	}
	 public void updateActivityStatusBulkUpdate(String releaseData,String testData,String objectData,String activityId,String criteriaId,String status) {
		 sleep(2000);
		 clickElementUsingJavaScript("Release_Activity_Row",activityId,releaseData,testData);
		 sleep(2000);
		// clickElementUsingJavaScript("Release_Activity_Row",criteriaId,releaseData,testData);
		 //sleep(2000);
		 clickOnButton(releaseData, "Release_Activity_ActionButton", objectData);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate", objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Status_Dropdown", objectData);
		 click("Release_Criteria_Status_Option",status,releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
	 }
	 public void updateReleaseActivityBulkUpdate(String releaseData,String testData,String objectData,String enterpriseId,String projectId,String activityName,String criteriaName,String status) {
		 sleep(2000);
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData, "Releases_ActionButton", objectData);
		 clickOnButton(releaseData, "Releases_BulkUpdate_Button", objectData);
		 clickOnButton(releaseData, "Release_BulkUpdate_Activities_Tab", objectData);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,activityName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,enterpriseId)+"')]/ancestor::tr/td[1]/div/div"));
		 js.executeScript("arguments[0].click();", element);
		 sleep(1000);
		 element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,criteriaName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,enterpriseId)+"')]/ancestor::tr/td[1]/div/div"));
		 js.executeScript("arguments[0].click();", element);
		 sleep(2000);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 doubleClick("Release_BulkUpdate_Activities_Status_Dropdown", releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 clickElementUsingJavaScript("Release_Criteria_Status_Option",status,releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 sleep(2000);
		 clickOnButton(releaseData, "Release_BulkUpdate_Update_Button", objectData);
	 }
	 
	 public void createActivityActualCompletedDate(String releaseData,String testData,String objectData,String activityId,String activityName,String status,String activityButton){
			sleep(2000);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickElementUsingJavaScript("Releases_AddNewButton",releaseData);
			sleep(1000);
			clickElementUsingJavaScript(activityButton,releaseData);
			sleep(1000);
			sendKeys("Release_Activity_IdTextField",PropertiesCache.setProperty(testData, activityId),releaseData);
			sleep(1000);
			sendKeys("Release_Activity_TitleTextField",PropertiesCache.setProperty(testData, activityName),releaseData);
			sleep(2000);
			if(activityId.contains("Activity")) {
				click("Release_Activity_AssignedToPhaseDropdown",releaseData);
				sleep(1000);
				PropertiesCache.setProperty(testData, "Release_Activity_PhaseName",getTextData("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData));
				sleep(1000);
				click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
				sleep(1000);
			}else {
				click("Release_Criteria_AssignedToGateDropdown",releaseData);
				sleep(1000);
				waitForLoadingIconDisappear("Loading_Gif",objectData);
				PropertiesCache.setProperty(testData, "Criteria_Gate",getTextData("Release_Activity_AssignedToDropdownFirst_Option", releaseData));
				click("Release_Activity_AssignedToPhaseDropdownFirst_Option",releaseData);
				sleep(1000);
			}
			click("Release_Activity_AssignedToDropdown",releaseData);
			sleep(1000);
			PropertiesCache.setProperty(testData, "Release_Activity_AssignedTo",getTextData("Release_Activity_AssignedToDropdownFirst_Option",releaseData));
			sleep(1000);
			click("Release_Activity_AssignedToDropdownFirst_Option",releaseData);
			sleep(1000);
			click("Release_Activity_DueDateDropdown",releaseData);
			sleep(3000);
			clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
			PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
			sleep(4000);
			clickElementUsingJavaScript("Release_Criteria_Status_Dropdown",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Release_Criteria_Status_Option",status,releaseData);
			sleep(1000);
			clickElementUsingJavaScript("Release_Actual_Completed_Date_Dropdown",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sendKeys("Additional_information_DateTimePicker_Box_Textbox", "00:00", objectData);
			sleep(1000);
			clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
			sleep(4000);
			clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
			waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
			sleep(1000);
		}
	 public void updateActivityStatus(String releaseData,String testData,String objectData,String status,String days,String criteriaId) throws ParseException{
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickElementUsingJavaScript("Release_Criteria_Id",criteriaId,releaseData,testData);
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			clickElementUsingJavaScript("Release_Criteria_Status_Dropdown",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			scrollToElement("Release_Criteria_Status_Option", status, releaseData);
			click("Release_Criteria_Status_Option",status,releaseData);
			sleep(1000);
			clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
			waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
			sleep(1000);
	}
	 public void updatePhaseAndGateDate(String releaseData,String testData,String objectData,String phaseName,String gateName) throws ParseException {
	 	clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		sleep(2000);
		//WebElement element1=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'Days')])[3]"));
		//doubleClick(element1);
		sleep(2000);
		WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", "dd/MM/yyyy")+"')])[2]"));
	 	sleep(4000);
	 	doubleClick(element);
		sleep(1000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		applicationDatePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(getTodayDate("0", "dd/MM/yyyy"))), "4"));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		Listener.addLogger("Release Phase is updated successfully !");
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
		sleep(2000);
		
		element=driver.findElement(By.xpath("(//div[text()='"+gateName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", "dd/MM/yyyy")+"')])[1]"));

		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(getTodayDate("0", "dd/MM/yyyy"))), "2"));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		Listener.addLogger("Release Gate is updated successfully !");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
		sleep(2000);
		clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
		//clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		clickOnReleaseSaveButton(releaseData, objectData);
	 }
	 
	 public void updateCapacitySize(String releaseData,String testData,String objectData,String capacityName,String plannedValue,String actualValue) {
		 clickOnButton(releaseData,"Releases_Capacity_Tab",objectData);
		 scrollToElement("Releases_Capacity_Planned_Value",capacityName,releaseData,testData);
		 clickButton("Releases_Capacity_Planned_Value",capacityName,releaseData,testData,objectData);
		 sendKeys("Releases_Capacity_Planned_Textbox", plannedValue,releaseData);
		 waitForLoadingIconDisappear("Loading_Gif",objectData);
		 clickButton("Releases_Capacity_Actual_Value",capacityName,releaseData,testData,objectData);
		 sendKeys("Releases_Capacity_Actual_Textbox", actualValue,releaseData);
		 clickOnReleaseSaveButton(releaseData, objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, capacityName)+" "+plannedValue+" "+" "+actualValue+" Updated capacity size successfully ! ");
	 }
	 public void selectCapacitySizeItems(String releaseData,String testData,String objectData,String capacity1,String capacity2) {
		click("Releases_Capacity_Tab",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Capacity_SizingItems_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		selectMultipleButton(releaseData, "Releases_Capacity_Size_Items");
		clickElementUsingJavaScript("Releases_Capacity_Size_Item",capacity1,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Capacity_Size_Item",capacity2,releaseData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Capacity_SizingItems_Dropdown",releaseData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickOnReleaseSaveButton(releaseData, objectData);

	 }
	 public String calculateCapacitySize(String actual,String planned,String redthreshold) {
		 return   String.valueOf(((Integer.parseInt(actual)+Integer.parseInt(planned))*100)/Integer.parseInt(redthreshold));
	 }
	 public String calculateCapacitySizeUnder(String actual,String planned,String redthreshold) {
		 return   String.valueOf(Integer.parseInt(redthreshold)-(Integer.parseInt(actual)+Integer.parseInt(planned)));
	 }
	 public String calculateCapacitySizeOver(String actual,String planned,String redthreshold) {
		 return   String.valueOf((Integer.parseInt(actual)+Integer.parseInt(planned))-Integer.parseInt(redthreshold));
	 }
	 public void updateOrganization(String releaseData,String testData,String objectData,String organizationName,String option) {
		clickOnButton(releaseData, "AddRelease_OrganisationDropdown", objectData);
		if(option.isEmpty()) {
		clickButton("AddRelease_Organization_Option",organizationName,releaseData,testData,objectData);
		}else {
		sleep(2000);
		PropertiesCache.setProperty(testData, "Release_Organization_Name",getTextData(option, releaseData));	
		clickOnButton(releaseData,option,objectData);
		}
		clickOnSaveAndCloseButton(releaseData, objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, organizationName)+" updated in release successfully !");
	 }
	 //user management
	 public void changeDueDate(String releaseData,String testData,String objectData,String days) throws ParseException{
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(releaseData,"Release_Activity_DueDateDropdown",objectData);
		sleep(2000);
		applicationDatePicker(releaseData, testData, "Release_Activity_DueDate_Calender", getDate(getCurrentDate("0"), days));
		clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",releaseData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Release_Activity_DueDate",getAttributeData("Release_Activity_DueDate_Value",releaseData).split(" ")[0].trim());
		sleep(2000);
		clickElementUsingJavaScript("Releases_Activity_Save&CloseButton",releaseData);
		sleep(1000);
		}
	 
	 public void clickOnActivity(String releaseData,String testData,String objectData,String activityName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickButton("Release_Activity_Id", activityName, releaseData, testData, objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	 public void verifyACAdditionalInformation(String releaseData,String testData,String objectData,String customFieldName,String customFieldList,String releaseId,String activityName) throws ParseException, InterruptedException {
		clickOnButton(releaseData,"Releases_ActivitesTab",objectData);
		clickOnActivity(releaseData, testData, objectData, activityName);
		verifyText("Additional_Information_LabelName", customFieldName,objectData,testData);
		verifyCustomFieldValue(releaseData,testData,objectData,customFieldList,customFieldName,releaseId,"Releases_Search_Result","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" - "+customFieldList+" is displayed and verified with values on the web page");
	}
	 public void getCustomStatusSelectionPage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		enterNewlyCreatedRelease(releaseData, testData, objectData, "Release_Calender_Automation_Id");
		findAndOpenRelease(releaseData, testData, objectData, "Release_Calender_Automation_Id");
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
		PropertiesCache.setProperty(testData, "RStatus",getAttributeData("AddRelease_Status_Textbox", releaseData));
		//System.out.println("Release Status: "+PropertiesCache.getProperty(PlutoraConfiguration.testData,"Release_Status"));
		sleep(1000);
		click("AddRelease_Save&CloseButton",releaseData);
	}

	public void getCustomStatusSelectionPage(String releaseData,String testData,String objectData,String fieldData) throws InterruptedException, ParseException{	

		enterNewlyCreatedRelease(releaseData, testData, objectData, "Release_Calender_Automation_Id");
		findAndOpenRelease(releaseData, testData, objectData, "Release_Calender_Automation_Id");
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(4000);
		clickElementUsingJavaScript("AddRelease_StatusDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		click("AddRelease_Status_Option",fieldData, releaseData,testData);
		sleep(1000);
		click("AddRelease_Save&CloseButton",releaseData);
	}
	public void clickOnReleaseStatusCustomFieldSelectOption(String releaseData,String testData,String objectData,String parameter,String fieldData) {
		clickOnReleaseStatusCollapse(releaseData, testData, objectData, "class");
		String value = getAttributeValue("AddRelease_Status_Checkbox", fieldData,releaseData,testData, parameter);
		System.out.println("Value :  "+value);
		if (value.contains("x-form-cb-checked")) {
			System.out.println("Element selected state");
		} else {
			click("AddRelease_Status_Label",fieldData,releaseData,testData);
		}

	}
	public void clickOnReleaseStatusCollapse(String releaseData,String testData,String objectData,String parameter) 
	{
		String value = getAttributeValue("AddRelease_Status_Collapse_Button",releaseData, parameter);
		System.out.println("Release Status: "+value);
		if (value.contains("x-fieldset x-fieldset-collapsed x-fieldset-with-title x-fieldset-with-legend x-fieldset-default")) {
			scrollToElement("Release_Statuses_Type_Link", releaseData);
			click("Release_Statuses_Type_Link", releaseData);
		} else {
			System.out.println("Release Status collapsed");
		}
	}
	public boolean getDetailsPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		boolean flag = false;

		releasePage(releaseData,objectData);
		newERPageBasedOnDate(releaseData,testData,objectData,"PRelease_Automation_Id","PRelease_Automation_Name","2");
		verifyRelease(releaseData,testData,objectData,"PRelease_Automation_Id");
		findAndOpenRelease(releaseData, testData, objectData,"PRelease_Automation_Id");
		clickOnElement(releaseData, objectData,"Releases_Applications_Tab");
		searchSystem(releaseData,testData,objectData,"Systems_Test_Automation_Id1");
		sleep(1000);
		dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "Systems_Test_Automation_Id1",releaseData,testData);
		click("AddRelease_SaveButton",releaseData);
		click("Releases_Change_Tab",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Releases_Change_Name_Section1", "Releases_Change_Project_Release_Section", "Systems_Test_Automation_Id1",releaseData,testData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Contents_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","PRelease_Automation_Id",releaseData, testData);
		sleep(2000);
		int contentCount = elementsCount("Release_Details_PopupContentsRow_Count", releaseData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Releases_Change_Tab",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		int changeCount = elementsCount("Release_Details_SelectedChanges_Count", releaseData);
		if (contentCount == changeCount) {
			flag = true;
		}

		return flag;
	}
	public void getUnselectChangeReleasePage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		dragAndDrop("Release_Details_SelectedChanges_Link","Release_Details_AvailableChanges_Area", "Systems_Test_Automation_Id1",releaseData,testData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		sleep(2000);
		click("Release_Details_Close_Icon",releaseData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Contents_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","PRelease_Automation_Id",releaseData, testData);
		sleep(2000);

	}
	public void getDeleteDetailsContentPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		click("Releases_Change_Tab",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Releases_Change_Name_Section1", "Releases_Change_Project_Release_Section", "Systems_Test_Automation_Id1",releaseData,testData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		click("Release_Details_Close_Icon",releaseData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Contents_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","PRelease_Automation_Id",releaseData, testData);
		sleep(2000);
		click("Release_Details_SelectedChanges_Name", "Change_Automation_Id",releaseData,testData);
		sleep(3000);
		clickElementUsingJavaScript("Release_DetailsChange_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Yes_Button",releaseData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_Close_Icon",releaseData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Contents_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","PRelease_Automation_Id",releaseData, testData);
		sleep(2000);
	}
	public boolean getReleaseCalendarSystemPage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	
		boolean flag = false;
		getReleaseCalendarSystemAddPage(releaseData, testData, objectData);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int eventCount = elementsCount("Release_Details_PopupContentsRow_Count", releaseData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Applications_Tab",releaseData);
		int changeCount = elementsCount("Releases_Systems_CodeImplementationRow_Count", releaseData);
		if (eventCount == changeCount) {
			flag = true;
		}

		return flag;

	}
	public void getReleaseCalendarSystemAddPage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	
		releasePage(releaseData,objectData);
		newERPageBasedOnDate(releaseData, testData,objectData,"Release_Calender_Automation_Id","Release_Calender_Automation_Name","2");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyRelease(releaseData, testData,objectData, "Release_Calender_Automation_Id");
		findAndOpenRelease(releaseData,testData,objectData,"Release_Calender_Automation_Id");
	
		createSystem(releaseData,testData,objectData,"Systems_Test_Automation_Id","Releases_New_SystemsButton");
		click("Releases_Applications_Tab",releaseData);
		searchSystem(releaseData,testData,objectData,"Systems_Test_Automation_Id");
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "Systems_Test_Automation_Id",releaseData,testData);
		clickOnElement(releaseData,objectData, "AddRelease_SaveButton");
		//Add deployment date
		addEnterpriseDeploymentDate(releaseData,testData,objectData,"Release_Calender_Automation_Id");
		clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//calendar page
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Systems_RadioButton");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void getReleaseCalendarSystemUpdatePage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		sleep(2000);
		clickElementUsingJavaScript("Releases_Systems_Deploymnet_Link",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		doubleClick("Releases_Systems_DeploymnetTitle_Column",releaseData);
		sleep(2000);
		doubleClick("Releases_Systems_DeploymnetTitle_Textbox",releaseData);
		sleep(2000);
		sendKeys("Releases_Systems_DeploymnetTitle_Textbox", PropertiesCache.setProperty(testData, "DeploymentTitle_Automation_Id"),releaseData);
		sleep(1000);
		click("UpdateButton", objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Releases_Systems_Deployment_CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Systems_RadioButton");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//scrollToElement("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Applications_Tab",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Systems_Deploymnet_Link",releaseData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	public void getReleaseCalendarSystemUnselectPage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		clickElementUsingJavaScript("Releases_Systems_Deployment_CloseButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Release_Systems_ImplementationSystem_Link", "Release_Systems_Available_Area", "Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Systems_RadioButton");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//scrollToElement("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Applications_Tab",releaseData);
		sleep(1000);
		searchSystem(releaseData,testData,objectData,"Systems_Test_Automation_Id");
		dragAndDrop("Releases_SystemsName_Section", "Releases_Systems_CodeImplementation_Section", "Systems_Test_Automation_Id",releaseData,testData);

	}
	public void getReleaseCalendarSystemDeletePage(String releaseData,String testData,String objectData,String releaseName,String systemsData) throws InterruptedException, ParseException{	


		addEnterpriseDeploymentDate(releaseData,testData,objectData,releaseName);
		clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData,objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Systems_RadioButton");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//scrollToElement("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(3000);
		click("Release_Details_SelectedChanges_Name","Systems_Test_Automation_Id",releaseData, testData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
		switchToWindow(4000, "parentWindow");
		driver.get(driver.getCurrentUrl());
		clickElementUsingJavaScript("Systems_Action_Button", systemsData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		sleep(1000);
		click("Systems_Yes_Button",systemsData);
		closeWindowTab();
		driver.switchTo().window(PropertiesCache.getProperty(testData,"parentWindow"));
		
		/*clickElementUsingJavaScript("Release_DetailsChange_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Yes_Button",releaseData);		
		sleep(1000);*/
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Systems_RadioButton");
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//scrollToElement("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(3000);
		click("Release_Details_SelectedChanges_Name","Systems_Test_Automation_Id",releaseData, testData);
		sleep(3000);

	}
	public boolean getEventCalendarPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {

		boolean flag=false;
		releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		newERPageBasedOnDate(releaseData,testData,objectData,"Release_Calender_Automation_Id","Release_Calender_Automation_Name","2");
		verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		createEvent(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Event_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		int eventCount = elementsCount("Release_Details_PopupContentsRow_Count", releaseData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Event_Tab",releaseData);
		int changeCount = elementsCount("Release_Event_GridRow_Count", releaseData);
		if (eventCount == changeCount) {
			flag = true;
		}

		return flag;

	}
	public void getEventCalendarUpdatePage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		updateEvent(releaseData,testData,objectData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		sleep(2000);
		click("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Event_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Event_Tab",releaseData);

	}
	public void getEventCalendarDeletePage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		deleteEvent(releaseData,objectData);
		clickOnSaveAndCloseButton(releaseData, objectData);
		sleep(2000);
		click("Release_Details_Close_Icon",releaseData);
		sleep(2000);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("2"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnElement(releaseData,objectData,"Release_Details_ReleaseId_RadioButton");
		clickOnElement(releaseData,objectData,"Release_Details_Event_RadioButton");
		sleep(2000);
		click("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id",releaseData, testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Release_Details_ReleaseId_Link",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Releases_Event_Tab",releaseData);

	}
	public void newERPageBasedOnDateCustomData(String releaseData,String testData,String objectData,String dropDownId,String dropDownOptionId,String customId) throws InterruptedException, ParseException{	
		click("AddEnterpriseRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, "Release_Calender_Automation_Id"),releaseData);
		sendKeys("AddRelease_NameTextfield", PropertiesCache.setProperty(testData, "Release_Calender_Automation_Name"),releaseData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click(dropDownId, releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript(dropDownOptionId, customId,releaseData,testData);
		sleep(1000);
		click("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		datePicker(releaseData,testData,"Release_Calender_DatePickerLabel",getCurrentDate("2"));
		sleep(1000);
		click("AddRelease_SaveButton",releaseData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_Save&CloseButton",releaseData);
	}
	public void getReleaseCalendarSystemDateRangePage(String releaseData,String testData,String objectData) throws InterruptedException, ParseException{	

		getReleaseCalendarSystemAddPage(releaseData, testData, objectData);
		clickOnSystemDeploymentsOption(releaseData);
		click("Release_Calender_SystemDateRange_Radiobutton",releaseData);
		sleep(3000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	public void clickOnSystemDeploymentsOption(String pageData) {
		String objectLocator=PropertiesCache.getProperty(pageData, "Release_Calender_SystemDeployment_Label");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.xpath(objectLocator)).isDisplayed();
		if (!flag) {
			scrollToElement("Release_Calender_SystemDeploymentType", pageData);
			click("Release_Calender_SystemDeploymentType", pageData);
			System.out.println("System Deployment Type is expanded");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickOnBlockoutSelectAllOption(String pageData) {

		String objectLocator=PropertiesCache.getProperty(pageData, "Release_Calender_BlockoutSelectAll_Button");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean flag = driver.findElement(By.xpath(objectLocator)).isDisplayed();
		if (!flag) {
			//System.out.println("Blockout type is expanded");
			scrollToElement("Release_Calender_BlockoutTypes", pageData);
			click("Release_Calender_BlockoutTypes", pageData);
			System.out.println("Blockout type is expanded");
		}

		String objectLocator1=PropertiesCache.getProperty(pageData, "Release_Calender_BlockoutSelectAll_NotChecked");
		try {
			driver.findElement(By.xpath(objectLocator1)).isDisplayed();
		} catch(Exception e) {
			driver.findElement(By.xpath(objectLocator)).click();
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		//System.out.println("Blockout select all checked");
	}
	public boolean getBlockoutDetailsPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {
		boolean flag = false;

		clickElementUsingJavaScript("Release_Calendar_BlockoutName_Text","Blockout_Test_Automation_Id",releaseData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String startDate = getAttributeValue("Release_Calendar_BlockoutStartDate_Textbox",releaseData,"value");
		String endDate = getAttributeValue("Release_Calendar_BlockoutEndDate_Textbox",releaseData,"value");
		startDate = formatDateOneFormateToOtherFormate(startDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		endDate = formatDateOneFormateToOtherFormate(endDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		System.out.println("Bstart: "+startDate +"Bend: "+endDate );
		if (startDate.equals(BlockoutPage.blockoutStartDate) && endDate.equals(BlockoutPage.blockoutEndDate)) {
			flag = true;
		}
		return flag;
	}
	public boolean getTEBRDetailsPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {
		boolean flag = false;
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_Calendar_TEBRName_Text","TEBR_Test_Automation_Id",releaseData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String startDate = getAttributeValue("Release_Calendar_BlockoutStartDate_Textbox",releaseData,"value");
		String endDate = getAttributeValue("Release_Calendar_BlockoutEndDate_Textbox",releaseData,"value");
		startDate = formatDateOneFormateToOtherFormate(startDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		endDate = formatDateOneFormateToOtherFormate(endDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		System.out.println("Bstart : "+startDate +"Bend: "+endDate );
		System.out.println("TBstart: "+TEBRPage.startDate +"TBend: "+TEBRPage.endDate );
		if (startDate.equals(TEBRPage.startDate) && endDate.equals(TEBRPage.endDate)) {
			flag = true;
		}
		return flag;
	}
	public void getDeleteTEBRFromPopupPage(String releaseData, String testData, String objectData,String closeIconId) throws InterruptedException, ParseException {

		click("Release_Calender_TEBRId_Link",releaseData);
		sleep(5000);
		click("Release_Calender_TEBRDetails_Tab",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_DetailsChange_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Yes_Button",releaseData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(closeIconId,releaseData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("0"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
	}
	public void getDeleteTECRFromPopupPage(String releaseData, String testData, String objectData,String closeIconId) throws InterruptedException, ParseException {

		doubleClick("Release_Calender_TECRId_Link",releaseData);
		sleep(3000);
		click("Release_Calender_TECRDetails_Tab",releaseData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Release_DetailsChange_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Release_Activity_ChildPush_Yes_Button",releaseData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(closeIconId,releaseData);
		getReleaseCalenderDetails(releaseData,objectData);
		datePicker(releaseData,testData,"Release_Calender_AppPickerLabel",getCurrentDate("0"));
		sleep(3000);
		new ReleaseCalenderPage().clickOnDayOption(releaseData,objectData);
		sleep(2000);
	}
	public boolean getTECRDetailsPage(String releaseData, String testData, String objectData) throws InterruptedException, ParseException {
		boolean flag = false;
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Release_Calendar_TECRName_Text","TECR_Test_Automation_Id",releaseData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String startDate = getAttributeValue("Release_Calendar_BlockoutStartDate_Textbox",releaseData,"value");
		String endDate = getAttributeValue("Release_Calendar_BlockoutEndDate_Textbox",releaseData,"value");
		startDate = formatDateOneFormateToOtherFormate(startDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		endDate = formatDateOneFormateToOtherFormate(endDate, "dd MMMM YYYY HH:MM", "dd/MM/YYYY HH:MM");
		System.out.println("Bstart: "+startDate +"Bend: "+endDate );
		if (startDate.equals(TECRPage.startDate) && endDate.equals(TECRPage.endDate)) {
			flag = true;
		}
		return flag;
	}
	public void newERPageWithCustomType(String releaseData,String testData,String objectData,String customType) throws InterruptedException, ParseException{	
		click("AddEnterpriseRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, "Release_Calender_Automation_Id"),releaseData);
		sendKeys("AddRelease_NameTextfield", PropertiesCache.setProperty(testData, "Release_Calender_Automation_Name"),releaseData);
		clickElementUsingJavaScript("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		System.out.println("Release Type: "+PropertiesCache.getProperty(PlutoraConfiguration.testData,customType));
		clickElementUsingJavaScript("AddRelease_ReleaseType_Option", customType,releaseData,testData);
		sleep(1000);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		datePicker(releaseData,testData,"Release_Calender_DatePickerLabel",getCurrentDate("2"));
		sleep(1000);
		click("AddRelease_Save&CloseButton",releaseData);
	}
	
	
	 public void updateReleaseBulkUpdate(String releaseData,String testData,String objectData,String enterpriseId,String projectId,String activityName,String criteriaName,String status) throws ParseException {
	
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_BulkUpdate_Button",objectData);
		//Release Information
		 clickOnButton(releaseData,"Release_BulkUpdate_ReleaseInformation_Tab",objectData);
		 
		 sleep(1000);
		 click("Release_BulkUpdate_ReleaseType_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_ReleaseType_Option","Release_Type",releaseData,testData,objectData);
		 
		 click("Release_BulkUpdate_Status_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_Status_Dropdown_Option","Release_Status",releaseData,testData,objectData);
		 
		/* click("Release_BulkUpdate_PortfolioAssociation_Dropdown",releaseData);
		 PropertiesCache.setProperty(testData, "Release_PortfolioAssociation",getTextData("AddRelease_Organistion_Option_Value",releaseData));
		 sleep(2000);
		 clickWebElementButton(releaseData,"AddRelease_Organistion_Option_Value",objectData);*/
		 
		 click("Release_BulkUpdate_RiskLevel_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_RiskLevel_Option","Release_RiskLevel",releaseData,testData,objectData);
		 
		 sendKeys("Release_BulkUpdate_ReleaseLocation_Textbox", "Release Location",releaseData);
		 
		 click("Release_BulkUpdate_ImplementationDate_Calendar_Icon",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 click("Release_BulkUpdate_Phases_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("Release_BulkUpdate_PhasesGates_Option","Release_PhaseName",releaseData,testData,objectData);
		 
		 click("Release_BulkUpdate_Phases_StartDate_Calendar",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 
		 click("Release_BulkUpdate_Phases_EndDate_Calendar",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		
		 click("Release_BulkUpdate_Gates_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("Release_BulkUpdate_PhasesGates_Option","Release_GateName",releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Gates_StartDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 sleep(1000);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Gates_EndDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 
		 //Additional Information
		 clickOnButton(releaseData,"Release_BulkUpdate_AdditionalInformation_Tab",objectData);
		 clickButton("Release_BulkUpdate_AdditionalInformation_CustomField_Calendar","Release_CustomField_Name",releaseData,testData,objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 
		 //Systems Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Systems_Tab",objectData);
		 searchSystem(releaseData,testData,objectData,"System_Automation");
		 dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "System_Automation",releaseData,testData);
		 
		 //Stakeholder Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Stakeholders_Tab",objectData);
		 addStakeholder(releaseData, objectData, 2, "Releases_StakeholderButton");
		
		 //Activities Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Activites_Tab",objectData);
		
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 doubleClick("Release_BulkUpdate_Activities_Status_Dropdown", releaseData);
		 clickElementUsingJavaScript("Release_Criteria_Status_Option",status,releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Activities_AssignedTo_Dropdown",objectData);
		 PropertiesCache.setProperty(testData, "AssignedTo_Text",getTextData("Release_Activity_AssignedToDropdownSecond_Option", releaseData));
		 clickOnButton(releaseData,"Release_Activity_AssignedToDropdownSecond_Option",objectData);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,activityName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,enterpriseId)+"')]/ancestor::tr/td[1]/div/div"));
		 js.executeScript("arguments[0].click();", element);
		 sleep(1000);
//		 element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,criteriaName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,enterpriseId)+"')]/ancestor::tr/td[1]/div/div"));
//		 js.executeScript("arguments[0].click();", element);
//		 sleep(2000);
		
		 clickOnButton(releaseData, "Release_BulkUpdate_Update_Button", objectData);
	 }
	 public void updateReleaseDuplicate(String releaseData,String testData,String objectData,String enterpriseId,String newEnterpriseId,String newEnterpriseIdName) {
		 waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		 sleep(2000);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_DuplicateReleaseButton",objectData);		 
		 waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		 sendKeys("Release_DuplicateRelease_ReleaseId_Textbox",PropertiesCache.setProperty(testData, newEnterpriseId),releaseData);
		 sendKeys("Release_DuplicateRelease_ReleaseName_Textbox",PropertiesCache.setProperty(testData, newEnterpriseIdName),releaseData);
		 clickOnButton(releaseData,"Release_DuplicateRelease_Duplicate_Checked_Checkbox","Release_DuplicateRelease_Duplicate_Checkbox",objectData,"xpath");
		 clickOnButton(releaseData,"DuplicateReleases_SelectAllOption",objectData);
		 clickOnButton(releaseData,"Release_DuplicateRelease_ReleaseAfterDuplicating_Checked_Checkbox","Release_DuplicateRelease_ReleaseAfterDuplicating_Checkbox",objectData,"xpath");
		 clickOnButton(releaseData,"DuplicateReleases_DuplicateButton",objectData);
		
	 }
	 public void updateReleaseDuplicateNewDate(String releaseData,String testData,String objectData,String enterpriseId,String newEnterpriseId,String newEnterpriseIdName) throws ParseException {
		 waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		 sleep(2000);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_DuplicateReleaseButton",objectData);		 
		 waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		 sendKeys("Release_DuplicateRelease_ReleaseId_Textbox",PropertiesCache.setProperty(testData, newEnterpriseId),releaseData);
		 sendKeys("Release_DuplicateRelease_ReleaseName_Textbox",PropertiesCache.setProperty(testData, newEnterpriseIdName),releaseData);
		 clickOnButton(releaseData,"Release_DuplicateRelease_DuplicateNewDates_Checkbox",objectData);
		 clickOnButton(releaseData,"Release_DuplicateRelease_PhaseNewDates_Checkbox",objectData);
		 
		 clickOnButton(releaseData,"Release_DuplicateRelease_DuplicateNewDates_Calendar_Icon",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 clickOnButton(releaseData,"Release_DuplicateRelease_PhaseNewDates_Calendar_Icon",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 clickOnButton(releaseData,"Release_DuplicateRelease_ReleaseAfterDuplicating_Checkbox","Release_DuplicateRelease_ReleaseAfterDuplicating_Checked_Checkbox",objectData,"xpath");
		 clickOnButton(releaseData,"DuplicateReleases_DuplicateButton",objectData);
		
	 }
	 public List<String> addNonEnterpriseReleaseNameToList(String projectReleaseName,String independentReleaseName) {
		 List<String> releaseList=new ArrayList<String>();
		 releaseList.add(projectReleaseName);
		 releaseList.add(independentReleaseName);
		 return releaseList;
	 }
	 public void uploadImage(String releaseData,String objectData) throws InterruptedException, IOException {
		scrollToElement("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Attachment_NewButton",releaseData);
		sleep(1000);
		uploadImageByName("uploadfile");
	 }
	 public void searchPortfolioAssociation(String releaseData,String testData,String objectData,String organizationName,String dropdownName) {
		 clickOnButton(releaseData,"Releases_Applications_Tab",objectData);
		 sleep(2000);
		// clickOnButton(releaseData,"Release_System_LiveSearch_Clear_Icon",objectData);
		 click(dropdownName,releaseData);
		 sleep(2000);
		 clickButton("Release_System_PortfolioAssociation_Dropdown_Option",organizationName,releaseData,testData,objectData);
		 waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, organizationName)+" searched in release details page successfully !");
	 }
	 public void updateActivityAssignedToFromGrid(String releaseData,String testData,String objectData,String assignedTo,String activityId) {
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickButton("Release_Activity_AssignedToGrid_Column", activityId,releaseData,testData,objectData);
			click("Release_Activity_AssignedToGrid_Option",assignedTo,releaseData);
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			sleep(2000);
			Listener.addLogger(assignedTo+" updated activity grid successfully !");
	}
	 public void clickOnDownloadTemplate(String releaseData,String testData,String objectData) {
			waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
			sleep(2000);
			click("Releases_ActivitesTab",releaseData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			clickElementUsingJavaScript("Release_Activity_ImportActivities_Button",releaseData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			click("Release_Activity_DownloadTemplate_Option",releaseData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);

		}
	 
	 public void clickOnBulkUpdateOption(String releaseData,String testData,String objectData,String activityId,String criteriaId) {
		 clickElementUsingJavaScript("Release_Activity_Row",activityId,releaseData,testData);
		 sleep(2000);
		 clickElementUsingJavaScript("Release_Activity_Row",criteriaId,releaseData,testData);
		 sleep(2000);

		 clickOnButton(releaseData, "Release_Activity_ActionButton", objectData);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate", objectData);
		 

	 }
	 public void updateActivityBulkUpdate(String releaseData,String testData,String objectData,String activityId,String criteriaId,String status,String shiftDates) throws ParseException {
		 sleep(2000);
		 clickOnBulkUpdateOption(releaseData, testData, objectData, activityId, criteriaId);
     
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ActivityInformation_Tab", objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Status_Dropdown", objectData);
		 click("Release_Criteria_Status_Option",status,releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_AssignedTo_Dropdown", objectData);

		 PropertiesCache.setProperty(PlutoraConfiguration.testData, "Activity_Update_AssignedTo",getTextData("Release_Activity_BulkUpdate_AssignedTo_Dropdown_Option", releaseData));
		 click("Release_Activity_BulkUpdate_AssignedTo_Dropdown_Option",releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Phase/Gate_Dropdown", objectData);
		 PropertiesCache.setProperty(PlutoraConfiguration.testData, "Activity_Update_PhaseGate",getTextData("Release_Activity_BulkUpdate_Phase/Gate_Dropdown_Option", releaseData));
		 click("Release_Activity_BulkUpdate_Phase/Gate_Dropdown_Option",releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ForecastDate_Calendar", objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("0"));
		 click(releaseData,"Additional_information_DateTimePicker_Done_Button",objectData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 click("Release_Activity_BulkUpdates_ShiftDates_RadioIcon",releaseData);
		 sendKeys("Release_Activity_BulkUpdate_ShiftDates_Days_Textbox",shiftDates,releaseData);
		 
		 sendKeys("Release_Activity_BulkUpdate_Find_Textbox", "Automation",releaseData);
		 sendKeys("Release_Activity_BulkUpdate_Replace_Textbox", "TestAutomation",releaseData);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
	 }
	 public void updateActivityBulkUpdateShiftDateBackward(String releaseData,String testData,String objectData,String activityId,String criteriaId,String shiftDates) throws ParseException {
		 clickOnBulkUpdateOption(releaseData, testData, objectData, activityId, criteriaId);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ActivityInformation_Tab", objectData);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ShiftDates_SecondDropdown", objectData);
		 click("Release_Activity_BulkUpdates_ShiftDates_Backward_Option",releaseData);
		 
		 sendKeys("Release_Activity_BulkUpdate_ShiftDates_Days_Textbox",shiftDates,releaseData);
		
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
		 
	 }
	 public void updateActivityBulkUpdateShiftDateDueDateForward(String releaseData,String testData,String objectData,String activityId,String criteriaId,String shiftDates) throws ParseException {
		 clickOnBulkUpdateOption(releaseData, testData, objectData, activityId, criteriaId);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ActivityInformation_Tab", objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ShiftDates_FirstDropdown", objectData);
		 click("Release_Activity_BulkUpdates_ShiftDates_DueDates",releaseData);
		 
		 sendKeys("Release_Activity_BulkUpdate_ShiftDates_Days_Textbox",shiftDates,releaseData);
		
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
		 
	 }
	 public void updateActivityBulkUpdateShiftDateDueDateBackward(String releaseData,String testData,String objectData,String activityId,String criteriaId,String shiftDates) throws ParseException {
		 clickOnBulkUpdateOption(releaseData, testData, objectData, activityId, criteriaId);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ActivityInformation_Tab", objectData);
		
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ShiftDates_SecondDropdown", objectData);
		 click("Release_Activity_BulkUpdates_ShiftDates_Forward_Option",releaseData);
		 
		 sendKeys("Release_Activity_BulkUpdate_ShiftDates_Days_Textbox",shiftDates,releaseData);
		
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
	
	 }
	 public void updateActivityBulkUpdateSelectNew(String releaseData,String testData,String objectData,String activityId,String criteriaId,String startDateDays,String endDateDays) throws ParseException {
		 clickOnBulkUpdateOption(releaseData, testData, objectData, activityId, criteriaId);
		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_ActivityInformation_Tab", objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdates_ShiftDates_StartDate_Calendar", objectData);
		 applicationDatePicker(releaseData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate(startDateDays));
		 click(releaseData,"Additional_information_DateTimePicker_Done_Button",objectData);
		 
		 clickOnButton(releaseData, "Release_Activity_BulkUpdates_ShiftDates_DueDate_Calendar", objectData);
		 applicationDatePicker(releaseData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate(startDateDays));
		 click(releaseData,"Additional_information_DateTimePicker_Done_Button",objectData);
		 

		 clickOnButton(releaseData, "Release_Activity_BulkUpdate_Save&Close_Button", objectData);
	 }
	 
	 public void addActivityComments(String releaseData,String testData,String objectData,String activityComments,String activityTab) {
		 clickOnButton(releaseData,activityTab,objectData);
		 sendKeys("Release_Activity_Comments_Textarea",PropertiesCache.setProperty(testData, activityComments),releaseData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Send_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, activityComments)+" added successfully !");
	 }
	 public void editActivityComments(String releaseData,String testData,String objectData,String activityComments,String activityTab) {
		 clickOnButton(releaseData,activityTab,objectData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Edit_Link",objectData);
		 sendKeys("Release_Activity_Comments_Edit_Textarea",PropertiesCache.setProperty(testData, activityComments),releaseData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Update_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, activityComments)+" updated successfully !");
	 }
	 public void replyActivityComments(String releaseData,String testData,String objectData,String activityComments,String activityTab) {
		 clickOnButton(releaseData,activityTab,objectData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Reply_Link",objectData);
		 
		 clickOnButton(releaseData,"Release_Activity_Comments_Cancel_Button",objectData);
		
		 clickOnButton(releaseData,"Release_Activity_Comments_Reply_Link",objectData);
		 sendKeys("Release_Activity_Comments_Edit_Textarea",PropertiesCache.setProperty(testData, activityComments),releaseData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Reply_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, activityComments)+" replyed successfully !");
	 }
	 public void deleteActivityComments(String releaseData,String testData,String objectData,String activityTab) {
		 clickOnButton(releaseData,activityTab,objectData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Delete_Link",objectData);
		 clickOnButton(releaseData,"Release_Activity_Comments_Yes_Button",objectData);
	 }
	 public String calculateKPIMetrics(String planned,String actual,String releaseData) {
		sendKeys("Release_Activity_KPIPlanned_Textbox", planned,releaseData);
		sendKeys("Release_Activity_KPIActual_Textbox", actual,releaseData);
		int metrics= (Integer.parseInt(actual) /Integer.parseInt(planned))*100;
		if(metrics>200) {
			metrics=200;
		}
		return String.valueOf(metrics);
	 }
	 public void searchLinkedItems(String releaseData,String testData,String objectData,String moduleName,String moduleId,String moduleStatus) {
		 clickOnButton(releaseData,"Release_LinkedItems_Tab",objectData);
		 clickOnButton(releaseData,moduleName,objectData);
		 clear("Release_LinkedItems_Name_Textbox", releaseData);
		 clear("Release_LinkedItems_Status_Textbox", releaseData);
		 sendKeysWithEnter("Release_LinkedItems_Name_Textbox",moduleId,releaseData,testData);
		 sendKeysWithEnter("Release_LinkedItems_Status_Textbox",moduleStatus,releaseData,testData);
		 
	 }
	 public void searchIdentifierLinkedItems(String releaseData,String testData,String objectData,String moduleName,String moduleId) {
		 clickOnButton(releaseData,"Release_LinkedItems_Tab",objectData);
		 clickOnButton(releaseData,moduleName,objectData);
		 sendKeysWithEnter("Release_LinkedItems_Identifier_Textbox",moduleId,releaseData,testData);
	 }
	 public void updateStakeholders(String releaseData,String testData,String objectData){
			clickElementUsingJavaScript("Releases_StakeholdersTab", releaseData);
			sleep(2000);
			for (int i = 1; i <= Integer.parseInt(PropertiesCache.getProperty(testData, "CountOfReleaseAction")); i++) {
				addStakeholder(releaseData, objectData, i,"Releases_EStakeholder_Button");
				sleep(1000);
				verifyText("Releases_Shakeholder_Name_Value",stakeHolderName,releaseData);
			}
			sleep(2000);
			clickElementUsingJavaScript("AddRelease_SaveButton",releaseData);
			sleep(2000);
		}
		
		public void updateActivties(String releaseData,String testData,String objectData){
			clickElementUsingJavaScript("Releases_ActivitesTab",releaseData);
			sleep(1000);
			for (int i = 1; i <= Integer.parseInt(PropertiesCache.getProperty(testData, "CountOfReleaseAction")); i++) {
				createReleaseActivity(releaseData, testData, objectData,i);
				sleep(1000);
				verifyText("Release_Activity_Id",activityId,releaseData);
				verifyText("Release_Activity_Name","New_Activites_Releases_Name_Value", releaseData,testData);
				sleep(2000);
			}
		}
		public void linkEnvironmentToNonEnterpriseRelease(String releaseData,String testData,String objectData,String environmentName,String tabName) {
			clickOnEnvironmentTab(releaseData, objectData);
			sleep(1000);
			dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", environmentName,releaseData,testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, environmentName)+"Environment Name drag & dropped successfully to environment booking section !");
			clickOnReleaseTab(releaseData, objectData, tabName);
			clickOnSaveAndCloseButton(releaseData, objectData);
		}
		public void updatePhaseDate(String releaseData,String testData,String objectData,String phaseName,String startDays,String endDays) throws ParseException {
		 	clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
			WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", "dd/MM/yyyy")+"')])[2]"));
			clickElementUsingJavaScript(element);
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(getTodayDate("0", "dd/MM/yyyy"))), endDays));
			clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
			Listener.addLogger("Release Phase is updated successfully !");
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
			sleep(2000);
			click("Release_PhaseAndGates_EnvironmentBookingSmartAlert_ContinueButton",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			click("Release_PhaseAndGates_Save&CloseButton",releaseData);
			
			element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", "dd/MM/yyyy")+"')])[1]"));
			clickElementUsingJavaScript(element);
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(getTodayDate("0", "dd/MM/yyyy"))), startDays));
			clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
			sleep(2000);
			click("Release_PhaseAndGates_EnvironmentBookingSmartAlert_ContinueButton",releaseData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			click("Release_PhaseAndGates_Save&CloseButton",releaseData);
			
			clickOnButton(releaseData,"Release_Show_Button","Release_Hide_Button",objectData,"xpath");
			clickOnReleaseSaveButton(releaseData, objectData);
		 }
		public void updateImplementationDate(String releaseData,String testData,String objectData,String days) throws ParseException {
			click("AddRelease_ImplementationDate",releaseData);
			sleep(1000);
			datePicker(releaseData,testData,"Release_Calender_DatePickerLabel",getCurrentDate(days));
			sleep(1000);
			click("AddRelease_Save&CloseButton",releaseData);
			waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		}
		
		public void findProjectReleaseInSchedule(String releaseData,String testData,String objectData, String noOfDays) throws ParseException{
			/*Click on Clear Button*/
			clickElementUsingJavaScript("Release_Clear_Button", releaseData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			/*enetring From And To Dates in the date range*/
			clickElementUsingJavaScript("Release_DateRangeFrom_Calendar", releaseData);
			applicationDatePicker(releaseData, testData, "Release_DateRangeFrom_DateText", getCurrentDate(noOfDays));
			Listener.addLogger("From Date Set !");
			sleep(2000);
			clickElementUsingJavaScript("Release_DateRangeTo_Calendar", releaseData);
			releaseDatePicker(releaseData, testData, "Release_DateRangeTo_DateText", getCurrentDate(noOfDays));
			Listener.addLogger("To Date Set !");
			sleep(1000);
			PropertiesCache.setProperty(testData,"Implementation_Date",getAttributeValue("ReleaseSchedule_Todate_InputBox", releaseData,"value" ));
			Listener.addLogger("Click on Release Structure Project Checkbox");
			clickElementUsingJavaScript("Release_ReleaseStructureProject_Checkbox", releaseData);
			sleep(1000);
			selectTimeLineScale(releaseData,objectData,"Yearly");
			Listener.addLogger("Click on View Button");
			clickElementUsingJavaScript("Release_SearchRelease_View_Button", releaseData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
		}
		
		public void selectTimeLineScale(String releaseData,String objectData,String timeLineOption){
			/*Clicking on Time line Scale DropDown */
			Listener.addLogger("Click on Timescale Down Arrow");
			clickElementUsingJavaScript("Release_Timescale_DownArrow",releaseData);
			sleep(1000);
			/*Selecting the Time line Option */
			Listener.addLogger("Click on Timescale Option");
			clickElementUsingJavaScript("Release_Timescale_YearlyOption", timeLineOption, releaseData);
			sleep(1000);
			/*Selecting the Time line Option */
			waitForLoadingIconDisappear("Loading_Gif", objectData);
		}
		
	
	public void saveFilter(String releaseData, String objectData, String testData) {
			/* Click on Save Filter */
			clickElementUsingJavaScript("Release_SaveFilter_Link", releaseData);
			sleep(1000);
			/* Entering Filter Name */
			sendKeys("Release_FilterName_Inputbox", PropertiesCache.setProperty(testData, "Filter_Name"), releaseData);
			/* Entering Description */
			sendKeys("Release_Description_textarea", PropertiesCache.setProperty(testData, "Filter_Desc"), releaseData);
			/* Clicking On Save And Close */
			clickElementUsingJavaScript("Release_FilterSaveAndClose_Button", releaseData);
			/* Waiting for Loader to dissapear */
			waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	public void updatePhaseDate(String releaseData,String testData,String objectData,String phaseName,String endDays) throws ParseException {
	 	clickOnButton(releaseData,"Release_Hide_Button","Release_Show_Button",objectData,"xpath");
		WebElement element=driver.findElement(By.xpath("(//div[text()='"+phaseName+"']/ancestor::tr//div[contains(text(),'"+getTodayDate("0", "dd/MM/yyyy")+"')])[2]"));
		clickElementUsingJavaScript(element);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		datePicker(releaseData,testData,"Release_PhasesAndGates_EndDateCalender",getDate(new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(getTodayDate("0", "dd/MM/yyyy"))), endDays));
		clickOnButton(objectData, "Additional_information_DateTimePicker_Done_Button", objectData);
		Listener.addLogger("Release Phase is updated successfully !");
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickOnButton(releaseData,"AddRelease_SaveButton",objectData);
		sleep(2000);
	}
	
	
	 public void updateReleaseBulkUpdateAdditionalInformation(String releaseData,String testData,String objectData,String enterpriseId,String projectId) throws ParseException {
		 sleep(2000);
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_BulkUpdate_Button",objectData);
		 
		 //Additional Information
		 clickOnButton(releaseData,"Release_BulkUpdate_AdditionalInformation_Tab",objectData);
		 clickButton("Release_BulkUpdate_AdditionalInformation_CustomField_Calendar","Release_CustomField",releaseData,testData,objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 click("Release_BulkUpdate_Update_Button", releaseData);
		 waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		 sleep(4000);
	 }
	 
	 public void updateReleaseBulkUpdateSystemTab(String releaseData,String testData,String objectData,String enterpriseId,String projectId) throws ParseException {
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_BulkUpdate_Button",objectData);
		 
		 //Systems Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Systems_Tab",objectData);
		 searchSystem(releaseData,testData,objectData,"System_Automation");
		 dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "System_Automation",releaseData,testData);
		 
		 click("Release_BulkUpdate_Update_Button", releaseData);
		 waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		 sleep(4000);
	 }
	 
	 public void updateReleaseBulkUpdateSATab(String releaseData,String testData,String objectData,String enterpriseId,String projectId,String activityEnterpriseName,String activityProjectName,String status) throws ParseException {
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_BulkUpdate_Button",objectData);
		 
		 //Stakeholder Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Stakeholders_Tab",objectData);
		 addStakeholder(releaseData, objectData, 2, "Releases_StakeholderButton");
		
		 //Activities Tab
		 clickOnButton(releaseData,"Release_BulkUpdate_Activites_Tab",objectData);
		
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 doubleClick("Release_BulkUpdate_Activities_Status_Dropdown", releaseData);
		 clickElementUsingJavaScript("Release_Criteria_Status_Option",status,releaseData);
		 waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Activities_AssignedTo_Dropdown",objectData);
		 PropertiesCache.setProperty(testData, "AssignedTo_Text",getTextData("Release_Activity_AssignedToDropdownSecond_Option", releaseData));
		 clickOnButton(releaseData,"Release_Activity_AssignedToDropdownSecond_Option",objectData);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,activityEnterpriseName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,enterpriseId)+"')]/ancestor::tr/td[1]/div/div"));
		 js.executeScript("arguments[0].click();", element);
		 sleep(1000);
		 
		 js = (JavascriptExecutor) driver;
		 element= driver.findElement(By.xpath("//div[text()='"+PropertiesCache.getProperty(testData,activityProjectName)+"']/ancestor::tr/td//div[contains(text(),'"+PropertiesCache.getProperty(testData,projectId)+"')]/ancestor::tr/td[1]/div/div"));
		 js.executeScript("arguments[0].click();", element);
		 sleep(1000);
		
		 click("Release_BulkUpdate_Update_Button", releaseData);
		 waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		 sleep(4000);
	 }
	 public void updateReleaseBulkUpdateInformationTab(String releaseData,String testData,String objectData,String enterpriseId,String projectId) throws ParseException {
			
		 scrollToElement("Release_Name_Row",enterpriseId,releaseData,testData);
		 clickButton("Release_Name_Row",enterpriseId,releaseData,testData,objectData);
		 sleep(2000);
		 scrollToElement("Release_Name_Row",projectId,releaseData,testData);
		 clickButton("Release_Name_Row",projectId,releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Releases_ActionButton",objectData);
		 clickOnButton(releaseData,"Releases_BulkUpdate_Button",objectData);
		//Release Information
		 clickOnButton(releaseData,"Release_BulkUpdate_ReleaseInformation_Tab",objectData);
		 
		 sleep(1000);
		 click("Release_BulkUpdate_ReleaseType_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_ReleaseType_Option","Release_Type",releaseData,testData,objectData);
		 
		 click("Release_BulkUpdate_Status_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_Status_Dropdown_Option","Release_Status",releaseData,testData,objectData);
		 
		/* click("Release_BulkUpdate_PortfolioAssociation_Dropdown",releaseData);
		 PropertiesCache.setProperty(testData, "Release_PortfolioAssociation",getTextData("AddRelease_Organistion_Option_Value",releaseData));
		 sleep(2000);
		 clickWebElementButton(releaseData,"AddRelease_Organistion_Option_Value",objectData);*/
		 
		 click("Release_BulkUpdate_RiskLevel_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("AddRelease_RiskLevel_Option","Release_RiskLevel",releaseData,testData,objectData);
		 
		 sendKeys("Release_BulkUpdate_ReleaseLocation_Textbox", "Release Location",releaseData);
		 
		 click("Release_BulkUpdate_ImplementationDate_Calendar_Icon",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 
		 click("Release_BulkUpdate_Phases_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("Release_BulkUpdate_PhasesGates_Option","Release_PhaseName",releaseData,testData,objectData);
		 
		 click("Release_BulkUpdate_Phases_StartDate_Calendar",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 
		 click("Release_BulkUpdate_Phases_EndDate_Calendar",releaseData);
		 sleep(1000);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		
		 click("Release_BulkUpdate_Gates_Dropdown",releaseData);
		 sleep(1000);
		 clickButton("Release_BulkUpdate_PhasesGates_Option","Release_GateName",releaseData,testData,objectData);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Gates_StartDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 sleep(1000);
		 
		 clickOnButton(releaseData,"Release_BulkUpdate_Gates_EndDate_Calendar",objectData);
		 applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender", getCurrentDate("2"));
		 click("Additional_information_DateTimePicker_Done_Button",objectData);
		 sleep(2000);
		 clickElementUsingJavaScript("Release_BulkUpdate_Update_Button", releaseData);
		 waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		 sleep(4000);
	 }
		
}

