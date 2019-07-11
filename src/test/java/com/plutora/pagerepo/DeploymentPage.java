package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class DeploymentPage extends TestGenericUtilLib {
	
	public List<String> activityStatus = new ArrayList<String>();
	
	public List<String> day = new ArrayList<String>();
	public List<String> minute = new ArrayList<String>();
	public List<String> hour = new ArrayList<String>();
	
	public String questionStatus[]= {"N/A","Good","Bad","Issue"};
	
	public String dataTypeStatus[]= {"Single Select","Multi Select","Radio Button","Free Text Area"};
	public void deploymentPlanPage(String deployData, String testData, String objectData) throws InterruptedException {
		sleep(2000);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Deployment_Header_Sidemenu", deployData);
			sleep(500);
			click("Deployment_Dropdown_Sidemenu", deployData);
		} else {
			mouseHover("Deployment_Dropdown_Link", "Deployment_Dropdown_Plan",deployData);
		} 
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		click("Deployment_All", deployData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}


	public void gotoDeploymentPage(String deployData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Deployment_Dropdown_Link", "Deployment_Dropdown_Plan", deployData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
	}
	public void gotoCommandCenterPage(String deployData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Deployment_Dropdown_Link", "Deployment_Command_Center", deployData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
	}

	public void addDeploymentPlan(String deployData, String testData, String objectData,String deploymentPlan) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_Information_Tab", deployData);
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deployData);
		clickElementUsingJavaScript("Deployment_System_Dropdown",deployData);
		waitForLoadingElement(60,"Deployment_System_Dropdown_OptionOne" , deployData);
		PropertiesCache.setProperty(testData, "System_Option", getTextData("Deployment_System_Dropdown_OptionOne", deployData));
		clickElementUsingJavaScript("Deployment_System_Dropdown_OptionOne",deployData);
		clickElementUsingJavaScript("Deployment_System_Dropdown",deployData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_SaveCloseButton", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}

	public void associateDeploymentPlan(String deployData, String testData, String objectData,String deploymentPlan, String masterDeploymentPlan) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deployData);
		sendKeys("Deployment_Master_DP_Combobox", masterDeploymentPlan, deployData, testData);
		//select the master deployment plan from the dropdown
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Master_DP_Dropdown_Option", masterDeploymentPlan, deployData, testData);
		click("Deployment_SaveCloseButton", deployData);
		sleep(2000);
	}
	
	public void clickOnNewDeploymentPlan(String deploymentPlanData, String testData, String objectData) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_Button", deploymentPlanData);
		click("Deployment_New_DP_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);	
	}
	
	public void clickOnAudit(String deploymentPlanData, String objectData) {
		clickElementUsingJavaScript("Deployment_InformationAudit_Icon", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);	
	}
	

	public void addDeploymentPlan(String deploymentPlanData, String testData, String objectData,String deploymentPlan,String descriptionName) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeysWithEnter("Deployment_ExternalIdTextfield", PropertiesCache.setProperty(testData, descriptionName), deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickOnRACIDetailsTab(deploymentPlanData, objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 1, "Deployment_Plan_AddStakeholder_Button");
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		click("Deployment_SaveCloseButton", deploymentPlanData);
		sleep(2000);
	}
	
	public void addDeploymentPlan(String deploymentPlanData, String testData, String objectData,String deploymentPlan,String systemId,String releaseId) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeysWithEnter("Deployment_ExternalIdTextfield", PropertiesCache.setProperty(testData, "New_DP_ExtID_Description"), deploymentPlanData);
		selectSystem(deploymentPlanData, testData, objectData, systemId);
		sleep(2000);
		selectRelease(deploymentPlanData, testData, objectData,releaseId,"Deployment_Release_Textbox");
		clickOnDeploymentRelease(deploymentPlanData, testData, objectData, releaseId);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickOnRACIDetailsTab(deploymentPlanData, objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,1, "Deployment_Plan_AddStakeholder_Button");
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_SaveCloseButton", deploymentPlanData);
		sleep(2000);
	}
	public void addDeploymentPlan(String deploymentPlanData, String testData, String objectData,String deploymentPlan,String systemId,String releaseId,String userName) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeysWithEnter("Deployment_ExternalIdTextfield", PropertiesCache.setProperty(testData, "New_DP_ExtID_Description"), deploymentPlanData);
		selectSystem(deploymentPlanData, testData, objectData, systemId);
		sleep(2000);
		selectRelease(deploymentPlanData, testData, objectData,releaseId,"Deployment_Release_Textbox");
		clickOnDeploymentRelease(deploymentPlanData, testData, objectData, releaseId);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickOnRACIDetailsTab(deploymentPlanData, objectData);
		new ReleasePage().updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, userName, "Deployment_Plan_AddStakeholder_Button");
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		click("Deployment_SaveCloseButton", deploymentPlanData);
		sleep(2000);
	}

	public void clickOnMasterDeploymentPlan(String deployData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_Button", deployData);
		click("Deployment_New_MDP_Button", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void addMasterDeploymentPlan(String deployData, String testData, String objectData,String deploymentPlan) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deployData);
		click("Deployment_SaveCloseButton", deployData);
		sleep(2000);
	}
	
	public void addMasterDeploymentPlanWithChild(String deploymentPlanData, String testData, String objectData,String deploymentPlan,String childDeploymenytPlan) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deploymentPlanData);
		selectChildDependency(deploymentPlanData, testData, objectData, childDeploymenytPlan,"Deployment_Master_Add/Remove_Dependency_Button","Deployment_Master_Plan_Dependency_Text","Deployment_Master_Plan_Dragged_Dependency_Section");
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	
	public void addMasterDeploymentPlan(String deploymentPlanData, String testData, String objectData,String deploymentPlan,String childDeploymenytPlan,String releaseId) throws InterruptedException {
		sendKeys("Deployment_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deploymentPlanData);
		selectChildDependency(deploymentPlanData, testData, objectData, childDeploymenytPlan,"Deployment_Master_Add/Remove_Dependency_Button","Deployment_Master_Plan_Dependency_Text","Deployment_Master_Plan_Dragged_Dependency_Section");
		//selectRelease(deploymentPlanData, testData, objectData,releaseId,"Deployment_Master_Plan_Release_Textbox");
		//clickOnDeploymentRelease(deploymentPlanData, testData, objectData, releaseId);
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickOnRACIDetailsTab(deploymentPlanData, objectData);
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 1, "Deployment_Plan_AddStakeholder_Button");
	
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	
	public void readDeploymentPlan(String deployData, String testData, String objectData, String deploymentName) {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Deployment_LiveSearchTextbox", deploymentName, deployData, testData);
		waitForLoadingIconDisappear(60,"Loading_Gif", objectData);
		sleep(2000);
	}

	public void clickOnDeploymentPlan(String deployData, String testData, String objectData, String deploymentName) {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", deploymentName, deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}

	public void updateDeploymentPlan(String deployData, String testData, String objectData,String deploymentPlan){
		sleep(2000);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", deploymentPlan, deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickOnInformationDetailsTab(deployData, objectData);
		sendKeysWithEnter("Deployment_ExternalIdTextfield", PropertiesCache.setProperty(testData, "New_DP_ExtID_Description"), deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_SaveCloseButton", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	
	public void createChildFromMasterDP(String deployData, String testData, String objectData,String deploymentPlan) throws InterruptedException{
		sleep(2000);
		click("Deployment_Master_New_Child_Deployment_Button", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sendKeys("Deployment_Child_NameTextfield", PropertiesCache.setProperty(testData, deploymentPlan),deployData);
		click("Deployment_Child_SaveCloseButton", deployData);
		sleep(2000);
	}
	
	public void duplicateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException, ParseException {
		
		
		sleep(2000);
		clickElementUsingJavaScript("Deployment_LiveSearched_Checkbox", "Deployment_Automation", deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Duplicate_Button", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		/*clickElementUsingJavaScript("Deployment_Duplicate_Activites_Checkbox",deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Duplicate_Start_Time_Calender_Icon",deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		datePicker(deployData,testData,"Deployment_Duplicate_Start_Time_Calender",getCurrentDate("2"));
		sleep(1000);*/
		click("Deployment_Popup_DuplicateClose_Button", deployData);
		waitForLoadingIconDisappear(20, "Loading_Gif", objectData);
		sendKeys("Deployment_LiveSearchTextbox",
				setDuplicateName(" (1)", "Deployment_Automation", "Copy_Deployment_Automation", testData, ""),
				deployData);
		sleep(2000);
	}

	public void createDuplicateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException, ParseException {
		
		
		sleep(2000);
		clickElementUsingJavaScript("Deployment_LiveSearched_Checkbox", "Deployment_Automation", deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Duplicate_Button", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Duplicate_Activites_Checkbox",deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Duplicate_Start_Time_Calender_Icon",deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		datePicker(deployData,testData,"Deployment_Duplicate_Start_Time_Calender",getCurrentDate("2"));
		sleep(1000);
		click("Deployment_Popup_DuplicateClose_Button", deployData);
		waitForLoadingIconDisappear(20, "Loading_Gif", objectData);
		sendKeys("Deployment_LiveSearchTextbox",
				setDuplicateName(" (1)", "Deployment_Automation", "Copy_Deployment_Automation", testData, ""),
				deployData);
		sleep(2000);
	}

	public void deleteDuplicateDeploymentPlan(String deployData, String testData, String objectData){
		sendKeys("Deployment_LiveSearchTextbox", "Copy_Deployment_Automation", deployData, testData);
		waitForLoadingIconDisappear(20, "Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", "Copy_Deployment_Automation", deployData, testData);
		waitForLoadingIconDisappear(30, "Loading_Gif", objectData);
		click("Deployment_DeleteButton", deployData);
		click("Deployment_DeleteYesButton", deployData);
	}

	public void deleteDeploymentPlan(String deployData, String testData, String objectData,String deploymentPlanName){
		sendKeys("Deployment_LiveSearchTextbox", deploymentPlanName, deployData, testData);
		sleep(2000);
		clickElementUsingJavaScript("DeploymentPlan_All_Tab",deployData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", deploymentPlanName, deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickOnInformationDetailsTab(deployData, objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_DeleteButton", deployData);
		sleep(1000);
		click("Deployment_DeleteYesButton", deployData);
//		waitForLoadingIconDisappear("Loading_Gif", objectData);
//		sleep(1000);

	}
	public void deleteDP(String deployData, String testData, String objectData,String deploymentPlanName){
		sendKeys("Deployment_LiveSearchTextbox", deploymentPlanName, deployData, testData);
		sleep(2000);
		clickElementUsingJavaScript("DeploymentPlan_All_Tab",deployData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", deploymentPlanName, deployData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickOnInformationDetailsTab(deployData, objectData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Delete_Button", deployData);
		sleep(1000);
		click("Deployment_DeleteYesButton", deployData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);

	}
	public void verifyAdditionalInformationTab(String deploymentPlanData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("DeploymentPlan_Additional_Information_Tab",deploymentPlanData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName","DeploymentPlan_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "DeploymentPlan_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(deploymentPlanData,testData, objectData, customFieldList,"DeploymentPlan_CustomField_Name","Deployment_Automation","Deployment_LiveSearched_Link","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "DeploymentPlan_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	public void verifyCustomFieldsAdditionalInformationTab(String deploymentPlanData,String testData,String objectData,String customFieldList,String activityName) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);	
		click("Deployment_Activity_Additional_Information_Tab",deploymentPlanData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName","DeploymentPlan_Activity_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "DeploymentPlan_Activity_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(deploymentPlanData,testData, objectData, customFieldList,"DeploymentPlan_Activity_CustomField_Name","Deployment_Automation","Deployment_LiveSearched_Link","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "DeploymentPlan_Activity_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	public void verifyUpdatedDeploymentPlan(String deploymentPlanData, String testData, String objectData,String deploymentId) {
		readDeploymentPlan(deploymentPlanData, testData, objectData,deploymentId);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Deployment_LiveSearched_Link", deploymentId, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyTextAttributeValue("Deployment_ExternalIdTextfield", "New_DP_ExtID_Description", deploymentPlanData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_SaveCloseButton", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void clickOnInformationDetailsTab(String deploymentPlanData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Information_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public void clickOnRACIDetailsTab(String deploymentPlanData,String objectData) {
		click("Deployment_Plan_RACI_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	
	public void clickAdditionalInfoTab(String deploymentPlanData,String objectData) {
		click("Deployment_Activity_AdditionalInformation_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	
	public void clickOnActivitiesDetailsTab(String deploymentPlanData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activities_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public void clickOnMasterActivitySetsDetailsTab(String deploymentPlanData,String objectData) {
		click("Deployment_Master_ActivitySet_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void clickOnMasterCheckpointDetailsTab(String deploymentPlanData,String objectData) {
		click("Deployment_Master_Checkpoints_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	
	public void clickOnMasterIssuesDetailsTab(String deploymentPlanData,String objectData) {
		click("Deployment_Master_Issues_Tab",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void selectSystem(String deploymentPlanData, String testData, String objectData,String systemId) {
		click("Deployment_System_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Deployment_System_Textbox",systemId, deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Deployment_System_Dropdown_Option",systemId,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void systemCloseButton(String deploymentPlanData, String testData, String objectData,String systemId) {
		click("Deployment_System_Close_Icon",systemId,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void releaseCloseButton(String deploymentPlanData, String testData, String objectData,String releaseId) {
		click("Deployment_Release_Close_Icon",releaseId,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void selectEditPortfolioAssociation(String deploymentPlanData, String testData, String objectData) {
		click("Deployment_Portfolio_Association_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		validateElementDisplayed("Deployment_Portfolio_Association_Dropdown_Option", deploymentPlanData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Deployment_Portfolio_Association",getTextData("Deployment_Portfolio_Association_Dropdown_Option", deploymentPlanData));
		click("Deployment_Portfolio_Association_Dropdown_Option",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnSaveAndCloseButton(String deploymentPlanData,String objectData) {
		sleep(1000);
		clickElementUsingJavaScript("Deployment_SaveCloseButton",deploymentPlanData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void selectRelease(String deploymentPlanData, String testData, String objectData,String releaseId,String releaseTextbox) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Release_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys(releaseTextbox,releaseId, deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnDeploymentRelease(String deploymentPlanData,String testData,String objectData,String releaseId) {
		sleep(1000);
		click("Deployment_Release_Dropdown_Option",releaseId,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnDeploymentPlanCloseIcon(String deploymentPlanData,String testData,String objectData) {
		sendKeysWithEnter("Deployment_ExternalIdTextfield", PropertiesCache.setProperty(testData, "New_DP_ExtID_Description"), deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Close_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Deployment_DeleteYesButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	
	public void selectChildDependency(String deploymentPlanData,String testData,String objectData,String dependencyId,String deploymentAddButton,String dependencyText,String dragSection) {
		scrollToElement(deploymentAddButton,deploymentPlanData);
		click(deploymentAddButton,deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Search_Dependency_Textbox", dependencyId,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyText(dependencyText, dependencyId,deploymentPlanData,testData);
		sleep(2000);
		dragAndDrop(dependencyText, dragSection,dependencyId ,deploymentPlanData, testData);
		sleep(2000);
		verifyText(dependencyText, dependencyId,deploymentPlanData,testData);
		sleep(1000);
		click("Deployment_Master_Plan_SaveAndClose_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void selectNewStatusDependency(String deploymentPlanData,String testData,String objectData,String status) {
		scrollUp();
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		clickOnInformationDetailsTab(deploymentPlanData, objectData);
		scrollToElement("Deployment_Action_Button", deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Action_Button",deploymentPlanData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement(status, deploymentPlanData);
		clickElementUsingJavaScript(status,deploymentPlanData);
		waitForLoadingIconDisappear(200,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void addMasterDeploymentPlanActivity(String deploymentPlanData,String testData,String objectData,String activityName,String systemId) {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("Deployment_Activities_New_Button",deploymentPlanData);
		
		clickOnButton(deploymentPlanData,"Deployment_Activities_Name_Link",objectData);
		sendKeys("Deployment_Activity_Name",PropertiesCache.setProperty(testData, activityName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		sleep(3000);
		clickOnSaveButton(deploymentPlanData, objectData);
		sleep(2000);
		click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
		sendKeys("Deployment_Activity_Description",PropertiesCache.setProperty(testData, "Deployment_Activity_Description"),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("Deployment_Activity_System_Dropdown",deploymentPlanData);
		click("Deployment_Activity_System_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Deployment_Activity_System_Dropdown_Option",systemId,deploymentPlanData,testData);
		sleep(2000);
		scrollToElement("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Start_Time",getAttributeData("Deployment_Activity_Start_Time_Calender_Textbox", deploymentPlanData));
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		click("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_End_Time",getAttributeData("Deployment_Activity_End_Time_Calender_Textbox", deploymentPlanData));
		scrollToElement("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		click("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Responsible",getTextData("Deployment_Activity_Responsible_Dropdown_Option", deploymentPlanData));
		click("Deployment_Activity_Responsible_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		click("Deployment_SaveCloseButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		
	}
	public void addActivity(String deploymentPlanData,String testData,String objectData,String systemId,String activityName,String activityLink) {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("Deployment_Activities_New_Button",deploymentPlanData);
		sleep(1000);
		clickOnButton(deploymentPlanData,activityLink,objectData);
		sendKeys("Deployment_Activity_Name",PropertiesCache.setProperty(testData, activityName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Deployment_Activity_Description",PropertiesCache.setProperty(testData, "Deployment_Activity_Description"),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("Deployment_Activity_System_Dropdown",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_System_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activity_System_Dropdown_Option",systemId,deploymentPlanData,testData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Start_Time",getAttributeData("Deployment_Activity_Start_Time_Calender_Textbox", deploymentPlanData));
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_End_Time",getAttributeData("Deployment_Activity_End_Time_Calender_Textbox", deploymentPlanData));
		scrollToElement("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Responsible",getTextData("Deployment_Activity_Responsible_Dropdown_Option", deploymentPlanData));
		clickElementUsingJavaScript("Deployment_Activity_Responsible_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_SaveCloseButton",objectData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void modifyActualPlanned(String deploymentPlanData,String testData,String objectData,String deploymentName) throws ParseException{
		clickOnActivitiesDetailsTab(deploymentPlanData,objectData);
		clickElementUsingJavaScript("Deployment_Activities_Name_Link",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_ActivitiesInProgress_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_ActivitiesInProgress_Icon",deploymentPlanData);
		sleep(65000);
		clickElementUsingJavaScript("Deployment_ActivitiesComplete_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_SaveCloseButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnDeploymentPlan(deploymentPlanData,testData,objectData,deploymentName);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		clickOnInformationDetailsTab(deploymentPlanData, objectData);
	}
	
	
	public void modifyActivityPreviousDate(String deploymentPlanData,String testData,String objectData,String deploymentName,String modificationDays) throws ParseException{
		clickOnDeploymentPlan(deploymentPlanData,testData,objectData,deploymentName);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		clickOnActivitiesDetailsTab(deploymentPlanData,objectData);
		clickElementUsingJavaScript("Deployment_Activities_Name_Link",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);	
		applicationDatePicker(objectData, testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(modificationDays));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		applicationDatePicker(PlutoraConfiguration.objectData,testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(modificationDays));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void modifyActivityFutureDate(String deploymentPlanData,String testData,String objectData,String deploymentName,String modificationDays) throws ParseException{
		clickElementUsingJavaScript("Deployment_Activities_Name_Link",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);	
		applicationDatePicker(objectData, testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(modificationDays));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		applicationDatePicker(PlutoraConfiguration.objectData,testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(modificationDays));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void modifyActivityDate(String deploymentPlanData,String testData,String objectData,String deploymentName,String startday,String endday) throws ParseException{
		clickOnDeploymentPlan(deploymentPlanData,testData,objectData,deploymentName);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		clickOnActivitiesDetailsTab(deploymentPlanData,objectData);
		clickElementUsingJavaScript("Deployment_Activities_Name_Link",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);	
		applicationDatePicker(objectData, testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(startday));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		applicationDatePicker(PlutoraConfiguration.objectData,testData,
				"Additional_Information_DateTimePicker_Calender_1",getCurrentDate(endday));
		clickElementUsingJavaScript("Deployment_Activity_Done_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void uploadImageForActivity(String deploymentPlanData) throws InterruptedException, IOException, AWTException {
		clickElementUsingJavaScript("Deployment_Activities_AttachmentIcon",deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activities_AttachmentNewButton",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activities_AttachmentAddFile",deploymentPlanData);
		sleep(1000);
		uploadImageByName("uploadfile");
	 }
	
	public void addActivity(String deploymentPlanData,String testData,String objectData,String activityName) {
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		click("Deployment_Activities_New_Button",deploymentPlanData);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Name_Link",objectData);
		
		sendKeys("Deployment_Activity_Name",PropertiesCache.setProperty(testData, activityName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("Deployment_Activity_Description",PropertiesCache.setProperty(testData, "Deployment_Activity_Description"),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Start_Time",getAttributeData("Deployment_Activity_Start_Time_Calender_Textbox", deploymentPlanData));
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		click("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_End_Time",getAttributeData("Deployment_Activity_End_Time_Calender_Textbox", deploymentPlanData));
		scrollToElement("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		click("Deployment_Activity_Responsible_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Responsible",getTextData("Deployment_Activity_Responsible_Dropdown_Option", deploymentPlanData));
		click("Deployment_Activity_Responsible_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		click("Deployment_SaveCloseButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, activityName)+" - Deployment Plan activity added successfully");
		
	}

	public void updateActivity(String deploymentPlanData, String testData, String objectData,String deploymentActivityName) {

		click("Deployment_Activity_Name_Text", deploymentActivityName, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Activity_Name", PropertiesCache.setProperty(testData, deploymentActivityName),
				deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Activity_Description",
				PropertiesCache.setProperty(testData, "Deployment_Activity_Description"), deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_Name_Text",deploymentActivityName,PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
	}

	public void selectSystemActivity(String deploymentPlanData, String testData, String objectData) {
		click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_System_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		click("Deployment_Activity_System_Dropdown_Option","Systems_Test_Automation_Id_1",deploymentPlanData,testData);
		sleep(2000);
	}
	public void selectDateActivity(String deploymentPlanData, String testData, String objectData,String activityName,String days) throws ParseException {
		click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_Start_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, activityName)+" - Start date - Today date selected successfully");
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Activity_Start_Time",getAttributeData("Deployment_Activity_Start_Time_Calender_Textbox", deploymentPlanData));
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		sleep(2000);
		click("Deployment_Activity_End_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getCurrentDate(days));
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, activityName)+" - End date - Tomorrow date selected successfully");
		PropertiesCache.setProperty(testData, "Deployment_Activity_End_Time",getAttributeData("Deployment_Activity_End_Time_Calender_Textbox", deploymentPlanData));
	}

	public void selectRevisedDateActivity(String deploymentPlanData, String testData, String objectData) throws ParseException {
		click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		scrollToElement("Deployment_Activity_Revised_Start_Time_Calender_Icon",deploymentPlanData);
		click("Deployment_Activity_Revised_Start_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Start date - Today date selected successfully");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_Revised_End_Time_Calender_Icon",deploymentPlanData);
		click("Deployment_Activity_Revised_End_Time_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getCurrentDate("1"));
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - End date - Tomorrow date selected successfully");
	}
	public void selectDowntimeDateActivity(String deploymentPlanData, String testData, String objectData) throws ParseException {
		click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		scrollToElement("Deployment_Downtime_Off_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Downtime_Off_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Deployment_Activity_Downtime_From_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Start date - Today date selected successfully");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Deployment_Activity_Downtime_To_Calender_Icon",deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activity_Downtime_To_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getCurrentDate("1"));
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - End date - Tomorrow date selected successfully");
	}
	public void selectStatusActivity(String deploymentPlanData, String testData, String objectData,String activityName) {
		selectNewStatusDependency(deploymentPlanData, testData, objectData, "Deployment_Action_Approve_Button");
		selectNewStatusDependency(deploymentPlanData, testData, objectData, "Deployment_Action_Execute_Button");
		clickOnActivitiesDetailsTab(deploymentPlanData, objectData);
		clickElementUsingJavaScript("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger("Deployment Plan activity is moved from draft to execution mode successfully");
	}
	public void changeStatusActivity(String deploymentPlanData, String testData, String objectData,String statusElement){
		validateElementDisplayed(statusElement, deploymentPlanData);
		click(statusElement,deploymentPlanData);
		waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
		sleep(1000);
	}
	public void clickOnSaveButton(String deploymentPlanData, String objectData) {
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}

	public void clickOnYesButton(String deploymentPlanData, String testData, String objectData) {
		click("Deployment_DeleteYesButton", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public String changeTopChevronDateFormat(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy")
				.format(new SimpleDateFormat("dd MMMM yyyy").parse(date.split("-")[1].trim())) + " "
				+ date.split("-")[0].trim();
	}
	public void importActivityFromXLS(String deploymentPlanData,String testData,String objectData,String fileName) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_BulkUpload_Option",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(5000);
		System.out.println(fileName);
		//WebElement element = driver.findElement(By.xpath("//div[contains(@class,'actionImportFromXLSMenuCls')][not(contains(@style,'display: none'))]//input[@name='uploadFile']"));
		WebElement element = driver.findElement(By.xpath("//input[@class='fileinput']"));
		element.sendKeys(fileName);
		sleep(5000);
		waitForLoadingIconDisappear(120,"Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkImportNext_button",deploymentPlanData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkAutoMapping_button",deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkAutoMappingClose_button",deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkImportNext_button",deploymentPlanData);
		sleep(3000);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkImportNext_button",deploymentPlanData);
		sleep(3000);
		clickElementUsingJavaScript("Deployment_ActivitiesBulkAutoClose_button",deploymentPlanData);
		sleep(2000);
	}
	public void bulkImportActivities(String deploymentPlanData,String testData,String objectData,String fileName) {
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Button",deploymentPlanData);
		sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//input[@class='fileinput'])[2]"));
		element.sendKeys(fileName);
		sleep(5000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Next_Button",deploymentPlanData);
		sleep(5000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_AutoMapping_Button",deploymentPlanData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Warning_Close_Button",deploymentPlanData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Next_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(5000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Next_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(5000);
		validateElementDisplayed("Deployment_Activity_BulkImportActivities_Records_Imported", "9", deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activity_BulkImportActivities_Close_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(5000);
		validateElementDisplayed("Deployment_Activity_Total_Records", "Activities (9)", deploymentPlanData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_SaveCloseButton",deploymentPlanData);
	}
	public void addActivitySet(String deploymentPlanData,String testData,String objectData) {
		sendKeys("Deployment_Master_ActivitySet_Textbox", PropertiesCache.setProperty(testData, "Deployment_Master_ActivitySet"),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);	
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void linkActivitySet(String deploymentPlanData,String testData,String objectData,String activityName) {
		click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);	
		scrollToElement("Deployment_Activity_LinkToMasterDeploymentPlan_Dropdown",deploymentPlanData);
		click("Deployment_Activity_LinkToMasterDeploymentPlan_Dropdown", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);	
		click("Deployment_Activity_LinkToMasterDeploymentPlan_Option","Deployment_Master_ActivitySet", deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);	
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		scrollToElement("Deployment_SaveCloseButton", deploymentPlanData);
		clickElementUsingJavaScript("Deployment_SaveCloseButton", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void verifyDeploymentPlanInActivitiesSet(String deploymentPlanData,String testData,String objectData,String mDeploymentPlan,String cDeploymentPlan,String activityCount) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		click("Deployment_Master_ActivitySet_Collapsed_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		verifyText("Deployment_Master_Linked_Activity_Count",activityCount,deploymentPlanData);
		sleep(1000);
		click("Deployment_Master_Linked_Activity_Link",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		verifyTextDisplayedInPage(PropertiesCache.getProperty(testData, mDeploymentPlan));
		verifyTextDisplayedInPage(PropertiesCache.getProperty(testData, cDeploymentPlan));
		sleep(1000);
		click("Deployment_Master_ActivitySet_Close_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Save_Button", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void updateStakeholders(String deploymentPlanData,String testData, String objectData){
		
		/* Clicking on Update Stakeholder Button */
		clickElementUsingJavaScript("DeploymentPlan_UpdateStakeholder_Button", deploymentPlanData);
		/* waiting for Add Stakeholder Button */
		waitForLoadingElement(30, "DeploymentPlan_AddBulkUpdateStakeholder_Button", deploymentPlanData);
		/* Clicking on Stakeholder Button */
		clickElementUsingJavaScript("DeploymentPlan_AddBulkUpdateStakeholder_Button", deploymentPlanData);
		sleep(3000);
		/* Clicking on User Group DropDown */
		clickElementUsingJavaScript("DeploymentPlan_UserGroupDropdown", deploymentPlanData);
		/* Capturing Name to Properties File */
		PropertiesCache.setProperty(testData, "Deployment_Plan_UpdatedName",
				getTextData("DeploymentPlan_UserGroupTextboxFirst_Option", deploymentPlanData));
		/* Clicking on First Option In DropDown */
		clickElementUsingJavaScript("DeploymentPlan_UserGroupTextboxFirst_Option", deploymentPlanData);
		/* Clicking on Add And Close Button */
		clickElementUsingJavaScript("DeploymentPlan_AddStakeHolderAddAndClose_Button", deploymentPlanData);
		/* Clicking on Update And Close Button */
		clickElementUsingJavaScript("DeploymentPlan_BulkUpdateAndClose_Button", deploymentPlanData);
		/* Waiting for loader to dissapear */
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
	}
	
	public Map<String,String> activitySet=new HashMap<String,String>();
	public void addActivityStatusList() {
		activityStatus.add("Not started");
		activityStatus.add("In Progress");
		activityStatus.add("Issue");
		activityStatus.add("Failed");
		activityStatus.add("Completed");
		addActivityStatusLocator();
	}
	public void addActivityStatusLocator() {
		activitySet.put(activityStatus.get(0),"Deployment_NotStarted_Button");
		activitySet.put(activityStatus.get(1),"Deployment_InProgress_Button");
		activitySet.put(activityStatus.get(2),"Deployment_Issue_Button");
		activitySet.put(activityStatus.get(3),"Deployment_Failed_Button");
		activitySet.put(activityStatus.get(4),"Deployment_Completed_Button");
	}
	public void createNewCheckpointQAndA(String deploymentPlanData,String testData,String objectData,String checkPointName) throws ParseException {
		click("Deployment_Master_Checkpoint_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Checkpoint_Textbox",PropertiesCache.setProperty(testData, checkPointName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Checkpoint_Time_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_From_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_To_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate("1", "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_EditQ&A_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	
		for(int i=0;i<questionStatus.length;i++) {
			scrollToElement("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
			click("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
			sleep(1000);
			sendKeys(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_QuestionName_Textfield").replace("TEXT", "Question "+(i+1)),PropertiesCache.setProperty(testData, "Deployment_Checkpoint_Question_"+(i+1)));
			waitForLoadingIconDisappear("Loading_Gif", objectData);
		
			sendKeys(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_Answer_Textfield").replace("TEXT", "Question "+(i+1)),PropertiesCache.setProperty(testData, "Deployment_Checkpoint_Answer_"+(i+1)));
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			click(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_Answer_Dropdown").replace("TEXT", "Question "+(i+1)));
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			click("Deployment_Master_Checkpoint_Answer_Dropdown_Option",questionStatus[i],deploymentPlanData);
		}
		
		click("Deployment_Master_Checkpoint_Save&CloseButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void createOrEditQAndA(String deploymentPlanData,String testData,String objectData,String question,String answer,String edit_or_new) throws ParseException{
		
		click("Deployment_Master_Checkpoint_EditQ&A_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		if(edit_or_new.equals("New")){
		   scrollToElement("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
		   click("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
		   sleep(1000);
		}   
		sendKeys("Deployment_Master_Checkpoint_QuestionOne_Textfield",PropertiesCache.setProperty(testData,question),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		if(edit_or_new.equals("New")){
			sendKeys("Deployment_Master_Checkpoint_AnswerOne_Textfield",PropertiesCache.setProperty(testData,answer),deploymentPlanData);	
		}
		else{
			sendKeys("Deployment_Master_Checkpoint_AnswerOneToEdit_Textfield",PropertiesCache.setProperty(testData,answer),deploymentPlanData);
		}	
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_CheckpointQASaveAndClose_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void duplicateQAndA(String deploymentPlanData,String objectData) throws ParseException{
		click("Deployment_Master_Checkpoint_EditQ&A_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_CheckpointQAOneThreeDots_Link",deploymentPlanData);
		sleep(1000);
		click("Deployment_CheckpointQAOneDuplicate_Link",deploymentPlanData);
		sleep(1000);
		click("Deployment_CheckpointQASaveAndClose_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
	}
	
	public void deleteQAndA(String deploymentPlanData,String objectData) throws ParseException{
		click("Deployment_Master_Checkpoint_EditQ&A_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_CheckpointQATwoThreeDots_Link",deploymentPlanData);
		sleep(1000);
		click("Deployment_CheckpointQAOneDelete_Link",deploymentPlanData);
		sleep(1000);
		click("Deployment_CheckpointQASaveAndClose_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
	}
	public void createNewCheckpoint(String deploymentPlanData,String testData,String objectData,String checkPointName) throws ParseException {
		click("Deployment_Master_Checkpoint_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Checkpoint_Textbox",PropertiesCache.setProperty(testData, checkPointName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Checkpoint_Time_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"CheckPoint_Time",getAttributeDataValue("Deployment_CheckpointTime_Input",deploymentPlanData));
		click("Deployment_Master_Checkpoint_From_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_To_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate("1", "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_CheckpointCreation_SaveButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void createNewCheckpoint(String deploymentPlanData,String testData,String objectData,String checkPointName,String fromDaysBeforeToday,String toDaysBeforeToday) throws ParseException {
		click("Deployment_Master_Checkpoint_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Checkpoint_Textbox",PropertiesCache.setProperty(testData, checkPointName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Checkpoint_Time_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"CheckPoint_Time",getAttributeDataValue("Deployment_CheckpointTime_Input",deploymentPlanData));
		
		click("Deployment_Master_Checkpoint_From_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate(fromDaysBeforeToday, "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_To_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate(toDaysBeforeToday, "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_CheckpointCreation_SaveButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void createNewCheckpointWithoutResponsePeriod(String deploymentPlanData,String testData,String objectData,String checkPointName) throws ParseException {
		click("Deployment_Master_Checkpoint_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Checkpoint_Textbox",PropertiesCache.setProperty(testData, checkPointName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Checkpoint_Time_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"CheckPoint_Time",getAttributeDataValue("Deployment_CheckpointTime_Input",deploymentPlanData));
		click("Deployment_Master_CheckpointCreation_SaveButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	
	public void updateCheckpoint(String deploymentPlanData,String testData,String objectData,String checkPointName) throws ParseException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Checkpoint_Textbox",PropertiesCache.setProperty(testData, checkPointName),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Checkpoint_Time_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_From_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Master_Checkpoint_To_Calender",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate("1", "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_CheckpointCreation_SaveButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	public void deleteCheckpoint(String deploymentPlanData,String objectData)  {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_DeleteCheckpoint_Button", deploymentPlanData);
	}
	
	public void duplicateCheckpoint(String deploymentPlanData,String objectData)  {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_DuplicateCheckpoint_Button", deploymentPlanData);
	}	
	
	public void setupQuestion(String deploymentPlanData,String testData,String objectData) {
		
		click("Deployment_Master_Issue_Setup_Questions_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		for(int i=0;i<dataTypeStatus.length;i++) {
			scrollToElement("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
			click("Deployment_Master_Checkpoint_NewQuestion_Button",deploymentPlanData);
			sleep(1000);
			sendKeys(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_QuestionName_Textfield").replace("TEXT", "Question "+(i+1)),PropertiesCache.setProperty(testData, "Deployment_Issue_Question_"+(i+1)));
			waitForLoadingIconDisappear("Loading_Gif", objectData);
		
			sendKeys(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_Answer_Textfield").replace("TEXT", "Question "+(i+1)),PropertiesCache.setProperty(testData, "Deployment_Issue_Answer_"+(i+1)));
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(2000);
			driver.findElement(By.xpath("//label[text()='"+"Question "+(i+1)+"']/ancestor::div[contains(@class,'questionTopBar')]/following-sibling::div//span[text()='"+dataTypeStatus[i]+"']")).click();
			//click(PropertiesCache.getProperty(deploymentPlanData, "Deployment_Master_Checkpoint_Answer_Dropdown").replace("TEXT", "Question "+(i+1)));
			//click("Deployment_Master_Issue_DataType_Text",dataTypeStatus[i],deploymentPlanData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			
		}
		click("Deployment_Master_Checkpoint_Save&CloseButton",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	public void selectMasterDeploymentPlanFromCommandCenter(String deploymentPlanData,String testData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		mouseOver("Deployment_Command_Center_Area", "", deploymentPlanData, "");
		clickOnButton(deploymentPlanData,"Deployment_Command_Center_Area",objectData);
		clickOnButton(deploymentPlanData,"Deployment_Command_Center_Title",objectData);
		click("Deployment_Command_Center_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Command_Center_Textbox", "Deployment_Master_Automation",deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Command_Center_Dropdown_Option","Deployment_Master_Automation",deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
	}
	
	/*public void verifyEmailNotification(String deploymentPlanData,String testData,String objectData,String duration) {
		launchUrl("Yopmail_HomePage_URL",testData);
		sleep(1000);
		sendKeysWithEnter("Yopmail_EmailInput",NewUserPage.loginEmail,objectData);
		sleep(3000);
		click("Registration_CheckNewMails_Button",objectData);
		sleep(3000);
		switchToFrameByName("Frame_Name",testData);
		sleep(2000);
		verifyText("Yopmail_Subject_Text",duration, objectData,testData);
		sleep(4000);
	}*/
	
	public void selectActivityCheckbox(String deploymentPlanData,String testData,String objectData,String activityName1,String activityName2) {
		click("Deployment_Activity_Checkbox",activityName1,deploymentPlanData,testData);
		click("Deployment_Activity_Checkbox",activityName2,deploymentPlanData,testData);
	}
	public void activityBulkUpdate(String deploymentPlanData,String testData,String objectData,String systemsName) throws ParseException {
		click("Deployment_Activity_Bulk_Update_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Checkbox",deploymentPlanData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Dropdown_Option","Deployment_Activity_Responsible",deploymentPlanData,testData);
		sleep(1000);
		
		click("Deployment_Activity_BU_System_Checkbox",deploymentPlanData);
		sleep(1000);
		click("Deployment_Activity_BU_System_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_BU_System_Dropdown_Option",systemsName,deploymentPlanData,testData);
		sleep(1000);
	
		click("Deployment_Activity_BU_PlannedDate&Time_Checkbox",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activity_BU_StartDate_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate("1", "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		scrollToElement("Deployment_Activity_BU_EndDate_Calender_Icon",deploymentPlanData);
		clickElementUsingJavaScript("Deployment_Activity_BU_EndDate_Calender_Icon",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		applicationDatePicker(deploymentPlanData, testData, "Deployment_Activity_End_Time_Calender", getTodayDate("1", "dd-MMMM-yyyy"));
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Deployment_Activity_Done_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		
		scrollToElement("Deployment_Activity_BU_Save&Close_Button",deploymentPlanData);
		click("Deployment_Activity_BU_Save&Close_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void activityBulkUpdateShiftDates(String deploymentPlanData,String testData,String objectData) throws ParseException {
		click("Deployment_Activity_Bulk_Update_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Activity_BU_PlannedDate&Time_Checkbox",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Activity_BU_Shift_Planned_Checkbox",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		sendKeys("Deployment_Activity_BU_Shift_Day_Textbox","1", deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Activity_BU_Save&Close_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	
	public void activityBulkUpdateWithoutEnteringAnyValues(String deploymentPlanData,String testData,String objectData) throws ParseException {
		click("Deployment_Activity_Bulk_Update_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Checkbox",deploymentPlanData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Activity_BU_Responsible_Dropdown_Option","Deployment_Activity_Responsible",deploymentPlanData,testData);
		sleep(1000);
		
		click("Deployment_Activity_BU_System_Checkbox",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Activity_BU_PlannedDate&Time_Checkbox",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		
		clickElementUsingJavaScript("Deployment_Activity_BU_Remove_Dates_Checkbox",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
		click("Deployment_Activity_BU_Save&Close_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void deleteActivity(String deploymentPlanData,String testData,String objectData) {
		click("Deployment_Activity_Delete_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
		click("Deployment_DeleteYesButton",PlutoraConfiguration.deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
	}
	public void createIssue(String deploymentPlanData,String testData,String objectData,String childDependencyId) {
		click("Deployment_Master_Issues_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Issues_Textbox", PropertiesCache.setProperty(testData, "Deployment_Issue"),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		selectChildDependency(deploymentPlanData, testData, objectData, childDependencyId,"Deployment_Master_Issue_Add/Remove_Button","Deployment_Master_Issue_Dependency_Text","Deployment_Master_Issue_Dependency_Drag_Section");
		
		scrollToElement("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		click("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Status",getTextData("Deployment_Master_Issue_Dropdown_Option", deploymentPlanData));
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Master_Issue_Type_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Type",getTextData("Deployment_Master_Issue_Dropdown_Option", deploymentPlanData));
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Master_Issue_Assignee_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Assignee",getTextData("Deployment_Master_Issue_Dropdown_Option", deploymentPlanData));
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		scrollToElement("Deployment_Master_Issue_SourceDeploymentPlan_Dropdown",deploymentPlanData);
		click("Deployment_Master_Issue_SourceDeploymentPlan_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Issue")
				+ " - Deployment Issue created successfully");
		
	}
	
	public void createIssueWithStatus(String deploymentPlanData,String testData,String objectData,String childDependencyId,String deploymentIssueDropDownOption) {
		click("Deployment_Master_Issues_New_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
		sendKeys("Deployment_Master_Issues_Textbox", PropertiesCache.setProperty(testData, "Deployment_Issue"+deploymentIssueDropDownOption),deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		selectChildDependency(deploymentPlanData, testData, objectData, childDependencyId,"Deployment_Master_Issue_Add/Remove_Button","Deployment_Master_Issue_Dependency_Text","Deployment_Master_Issue_Dependency_Drag_Section");
		
		scrollToElement("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		click("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Status",getTextData(deploymentIssueDropDownOption, deploymentPlanData));
		click(deploymentIssueDropDownOption,deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Master_Issue_Type_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Type",getTextData(deploymentIssueDropDownOption, deploymentPlanData));
		click(deploymentIssueDropDownOption,deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Master_Issue_Assignee_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Assignee",getTextData("Deployment_Master_Issue_Dropdown_Option", deploymentPlanData));
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		scrollToElement("Deployment_Master_Issue_SourceDeploymentPlan_Dropdown",deploymentPlanData);
		click("Deployment_Master_Issue_SourceDeploymentPlan_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		click("Deployment_Master_Issue_Dropdown_Option",deploymentPlanData);
		sleep(1000);
		
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		
	}
	
	public void setIssueStatus(String deploymentPlanData,String testData,String objectData,String deploymentIssueDropDownOption) {
		scrollToElement("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		click("Deployment_Master_Issue_Status_Dropdown",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Deployment_Issue_Status",getTextData(deploymentIssueDropDownOption, deploymentPlanData));
		click(deploymentIssueDropDownOption,deploymentPlanData);
		sleep(1000);
		click("Deployment_Save_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}
	public void deleteIssue(String deploymentPlanData,String testData,String objectData) {
		click("Deployment_Master_Issue_Name","Deployment_Issue",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);

		click("Deployment_Master_Issue_Delete_Button",PlutoraConfiguration.deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
	}
	public void removeDeploymentPlan(String deploymentPlanData,String testData,String objectData,String dependencyId) {
		click("Deployment_Master_Issue_Name","Deployment_Issue",PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		sleep(1000);
		click("Deployment_Master_Issue_Add/Remove_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		dragAndDrop("Deployment_Master_Issue_Dragged_Dependency_Text", "Deployment_Impacted_DP_Source_Section",dependencyId ,deploymentPlanData, testData);
		sleep(2000);
		verifyText("Deployment_Master_Issue_Dragged_Dependency_Text", dependencyId,deploymentPlanData,testData);
		sleep(1000);
		click("Deployment_Master_Plan_SaveAndClose_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		verifyTextContains("Deployment_Master_Issue_Impacted_Deployment_Plan", dependencyId,deploymentPlanData,testData);
		sleep(1000);
		sendKeys("Deployment_Master_Issue_ReasonForRemoval_Textbox", "Reason_For_Removal",deploymentPlanData,testData);
		sleep(1000);
		click("Deployment_Master_Issue_Submit_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void selectGroupAndUngroup(String deploymentPlanData,String testData,String objectData,String activityName) {
		click("Deployment_Activity_Checkbox",activityName,deploymentPlanData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_Activity_Group/Ungroup_Activites_Button",deploymentPlanData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void verifyDeploymentGridDetails(String deploymentId,String projectId,String projectName,String testData) {
		boolean flag=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, deploymentId)+"']/ancestor::tr/td//div[text()='"+PropertiesCache.getProperty(testData, projectId)+"']")).isDisplayed();
		flag=driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(testData, deploymentId)+"']/ancestor::tr/td//div[text()='"+PropertiesCache.getProperty(testData, projectId)+"']")).isDisplayed();
		if(flag) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
	public void verifyDPFieldPermissionCustomField(String deploymentPlanData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("DeploymentPlan_Additional_Information_Tab",deploymentPlanData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("DeploymentPlan_Additional_Information_Tab",deploymentPlanData);
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
			click("DeploymentPlan_Additional_Information_Tab",deploymentPlanData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
			break;
			
		}
		clickOnSaveAndCloseButton(deploymentPlanData, objectData);
	}
	public void verifyDPAFieldPermissionCustomField(String deploymentPlanData,String testData,String objectData,String name,String type,String activityName) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);	
			click("Deployment_Activity_Additional_Information_Tab",deploymentPlanData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);	
			click("Deployment_Activity_Additional_Information_Tab",deploymentPlanData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Deployment_Activity_Name_Text", activityName, deploymentPlanData, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);	
			click("Deployment_Activity_Additional_Information_Tab",deploymentPlanData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(2000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is verified for "+type+" successfully");
		clickOnSaveAndCloseButton(deploymentPlanData, objectData);
	}
	
	public void setGroupName(String deploymentPlanData,String testData,String objectData,String groupName) throws InterruptedException {
		clickButton("Deployment_Activity_Name_Text","DP_Activity", deploymentPlanData, testData,objectData);
		clickOnButton(deploymentPlanData,"Deployment_Activities_Activity_Close_Button",objectData);
		clickButton("Deployment_Activity_Checkbox","DP_Activity", deploymentPlanData, testData,objectData);
		clickOnButton(deploymentPlanData,"Deployment_Activity_Group/Ungroup_Activites_Button",objectData);
		mouseOver("Deployment_Activity_Group_Name", "DP_Activity",deploymentPlanData,testData);
		clickOnButton(deploymentPlanData,"Deployment_Activity_Group/Ungroup_Edit_Button",objectData);
		clickOnButton(deploymentPlanData,"Deployment_Activity_Predefined_Forms_Radio_Button",objectData);
		clickOnButton(deploymentPlanData,"Deployment_Activity_Predefined_Forms_Dropdown",objectData);
		clickButton("Deployment_Activity_Predefined_Forms_Option", groupName, deploymentPlanData, testData, objectData);
		clickOnButton(deploymentPlanData,"Deployment_Activity_Group_Format_Save_Button",objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, groupName)+ " - is selected from prefilled form dropdown successfully");
	}
	//Deployment Scheduler
	public void gotoDeploymentSchedulePage(String deployData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Deployment_Dropdown_Link", "DeploymentSchedule_Menu", deployData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
	}
	public void searchDeploymentScheduleRelease(String deploymentPlanData,String testData,String objectData ,String releaseName) {
		clickOnButton(deploymentPlanData,"DeploymentSchedule_Release_Dropdown",objectData);
		sendKeys("DeploymentSchedule_Release_Textbox",releaseName,deploymentPlanData,testData,objectData);
		sleep(1000);
		clickElementUsingJavaScript("DeploymentSchedule_Release_Dropdown_Option",releaseName,deploymentPlanData,testData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",objectData,"xpath");
		clickOnButton(deploymentPlanData,"DeploymentSchedule_View_Button",objectData);
	}
	public void searchDeploymentScheduleIntervalType(String deploymentPlanData,String testData,String objectData ,String releaseName) {
		clickOnButton(deploymentPlanData,"DeploymentSchedule_Release_Dropdown",objectData);
		sendKeys("DeploymentSchedule_Release_Textbox",releaseName,deploymentPlanData,testData,objectData);
		clickButton("DeploymentSchedule_Release_Dropdown_Option",releaseName,deploymentPlanData,testData,objectData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		clickOnButton(deploymentPlanData,"DeploymentSchedule_Show_Activity_Enable_Checkbox","DeploymentSchedule_Show_Activity_Disable_Checkbox",objectData,"xpath");
		clickOnButton(deploymentPlanData,"DeploymentSchedule_View_Button",objectData);
	}
	public void selectDeploymentScheduleInterval(String deploymentPlanData,String testData,String objectData ,String type,String dropdown) {
		clickOnButton(deploymentPlanData,dropdown,objectData);
		click("DeploymentSchedule_Release_Dropdown_Option",type,deploymentPlanData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		sleep(2000);
		clickOnButton(deploymentPlanData,"DeploymentSchedule_View_Button",objectData);
	}
	public void selectDeploymentScheduleIntervalChange(String deploymentPlanData,String testData,String objectData,String type) {
		clickOnButton(deploymentPlanData,"DeploymentSchedule_IntervalValue_Dropdown",objectData);
		click("DeploymentSchedule_Release_Dropdown_Option",type,deploymentPlanData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		clickOnButton(deploymentPlanData,"DeploymentSchedule_IntervalValue_Continue_Button",objectData);
	}
	public void closeDeploymentScheduleReleases(String deploymentPlanData,String objectData) {
		try {
		while(getWebElementCount("DeploymentSchedule_Release_Close", "",deploymentPlanData, "")>=1) {
			clickElementUsingJavaScript("DeploymentSchedule_Release_Close", "",deploymentPlanData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		}
		}catch(Exception e) {
			
		}
	}
	//Activities By Status
	public void gotoActivitiesByStatusPage(String deployData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Deployment_Dropdown_Link", "ActivitiesByStatus_Menu", deployData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
	}
	public void searchActivitiesByStatusRelease(String deploymentPlanData,String testData,String objectData ,String releaseName) {
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_Release_Dropdown",objectData);
		sendKeys("ActivitiesByStatus_Release_Textbox",releaseName,deploymentPlanData,testData,objectData);
		sleep(1000);
		clickElementUsingJavaScript("ActivitiesByStatus_Release_Dropdown_Option",releaseName,deploymentPlanData,testData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_Release_Dropdown",objectData);
		//clickOnButton(deploymentPlanData,"ActivitiesByStatus_Enable_Checkbox","ActivitiesByStatus_Disable_Checkbox",objectData,"css");
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_View_Button",objectData);
	}
	
	public void searchActivitiesByStatusGroups(String deploymentPlanData,String testData,String objectData ,String groupName) {
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_Groups_Dropdown",objectData);
		sendKeys("ActivitiesByStatus_Groups_Textbox",groupName,deploymentPlanData,testData,objectData);
		sleep(1000);
		clickElementUsingJavaScript("ActivitiesByStatus_Groups_Dropdown_Option",groupName,deploymentPlanData,testData);
		waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
		sleep(1000);
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_Groups_Dropdown",objectData);
		//clickOnButton(deploymentPlanData,"ActivitiesByStatus_Enable_Checkbox","ActivitiesByStatus_Disable_Checkbox",objectData,"css");
		clickOnButton(deploymentPlanData,"ActivitiesByStatus_View_Button",objectData);
	}
	public void addDayIntervalValue() {
		day.add("1");
		day.add("2");
		day.add("3");
		day.add("4");
		day.add("5");
		day.add("10");
		day.add("15");
		day.add("20");
		day.add("25");
		day.add("30");
	}
	public void addMinuteIntervalValue() {
		minute.add("5");
		minute.add("10");
		minute.add("15");
		minute.add("30");
		minute.add("45");
		minute.add("60");
	}
	public void addHourIntervalValue() {
		hour.add("1");
		hour.add("2");
		hour.add("3");
		hour.add("4");
		hour.add("5");
		hour.add("6");
		hour.add("12");
		hour.add("24");
	}
	public void verifyMinuteIntervalValue(String deploymentData,String minuteValue) {
		String firstPosition=getTextData("DeploymentSchedule_Minute_First_Value", deploymentData);
		String secondPosition=getTextData("DeploymentSchedule_Minute_Second_Value", deploymentData);
		if(!minuteValue.equals("60")) {
			int i=	Integer.parseInt(firstPosition.split(":")[1].trim())+Integer.parseInt(secondPosition.split(":")[1].trim());
			verifyTextValue(i,Integer.parseInt(minuteValue));
			Listener.addLogger("Interval Value - "+minuteValue+" - "+firstPosition+" - "+secondPosition+" -  values filtered successfully !");
		}else {
			int i=Integer.parseInt(firstPosition.split(":")[0].trim())+1;
			verifyTextValue(i,Integer.parseInt(secondPosition.split(":")[0].trim()));
			Listener.addLogger("Interval Value - "+minuteValue+" - "+firstPosition+" - "+secondPosition+" -  values filtered successfully !");
		}
	}
	public void verifyHourIntervalValue(String deploymentData,String hourValue) {
		String firstPosition=getTextData("DeploymentSchedule_Minute_First_Value", deploymentData);
		String secondPosition=getTextData("DeploymentSchedule_Minute_Second_Value", deploymentData);
	
		if(hourValue.equals("24")) {
			verifyTextValue(Integer.parseInt(firstPosition.split(":")[0].trim()),Integer.parseInt(secondPosition.split(":")[0].trim()));
			Listener.addLogger("Interval Value - "+hourValue+" - "+firstPosition+" - "+secondPosition+" -  values filtered successfully !");
		}else {
			int i=Integer.parseInt(firstPosition.split(":")[0].trim())+Integer.parseInt(hourValue);
			if(i < 24) {
				verifyTextValue(i,Integer.parseInt(secondPosition.split(":")[0].trim()));
				Listener.addLogger("Interval Value - "+hourValue+" - "+firstPosition+" - "+secondPosition+" -  values filtered successfully !");
			}else {
				int j=i-24;
				verifyTextValue(j,Integer.parseInt(secondPosition.split(":")[0].trim()));
				Listener.addLogger("Interval Value - "+hourValue+" - "+firstPosition+" - "+secondPosition+" -  values filtered successfully !");
			}
		}
	}
	public void verifyLocalizationAdditionalInformationTab(String deploymentPlanData,String testData,String objectData,String customFieldList,String customFieldName,String format,String decimals) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("DeploymentPlan_Additional_Information_Tab",deploymentPlanData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName",customFieldName,objectData,testData);
		sleep(1000);
		verifyLocalizationCustomFieldValue(deploymentPlanData,testData, objectData, customFieldList,customFieldName,format,decimals,"Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, customFieldName)+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	public void logout(String pageData,String objectData,String url) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	webElementIdentifier(PropertiesCache.getProperty(pageData, "Deployment_Dropdown_Link"));
        	new LogoutPage().loginoutPage(url,objectData);
			
        } catch (Exception e) {  
        
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
       
	}
	 public void addActivityComments(String pageData,String testData,String objectData,String comments,String CommentIcon) {
		 clickOnButton(pageData,CommentIcon,objectData);
		 sendKeys("Deployment_ActivitiesComments_Textarea",PropertiesCache.setProperty(testData, comments),pageData);
		 clickOnButton(pageData,"Deployment_ActivitiesComments_SendButton",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" added successfully !");
	 }
	 public void editActivityComments(String pageData,String testData,String objectData,String editcomments,String CommentIcon) {
		 clickOnButton(pageData,CommentIcon,objectData);
		 clickOnButton(pageData,"Deployment_ActivitiesComments_EditLink",objectData);
		 sendKeys("Deployment_ActivitiesComments_EditTextArea",PropertiesCache.setProperty(testData, editcomments),pageData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, editcomments)+" updated successfully !");
	 }
	 public void replyActivityComments(String pageData,String testData,String objectData,String replycomments,String CommentIcon) {
		 clickOnButton(pageData,CommentIcon,objectData);
		 clickOnButton(pageData,"Deployment_ActivitiesComments_ReplyLink",objectData);
		 sendKeysWithoutClear("Deployment_ActivitiesCommentsReply_Textarea",PropertiesCache.setProperty(testData, replycomments),pageData);
		 clickOnButton(pageData,"Deployment_ActivitiesCommentsReply_SendButton",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, replycomments)+" replyed successfully !");
	 }
	 
	 public void deploymentDraftApprove(String pageData,String objectData){
		 scrollToElement("Deployment_ActivitiesDraftAction_Button", pageData);
		 clickElementUsingJavaScript("Deployment_ActivitiesDraftAction_Button",pageData);
		 clickElementUsingJavaScript("Deployment_ActivitiesDraftApprove_Button",pageData);
		 waitForLoadingIconDisappear("Loading_Gif", objectData);
	 }
	
	 public void deploymentApprovedExecute(String pageData,String objectData){
		 clickElementUsingJavaScript("Deployment_ActivitiesApproveAction_Button",pageData);
		 clickElementUsingJavaScript("Deployment_ActivitiesExecuteAction_Button",pageData);
		 waitForLoadingIconDisappear("Loading_Gif", objectData);
	 }
	 
	 public void deploymentExecuteComplete(String pageData,String objectData){
		 clickElementUsingJavaScript("Deployment_ExecutionAction_Button",pageData);
		 clickElementUsingJavaScript("Deployment_ExecutionComplete_Button",pageData);
		 waitForLoadingIconDisappear("Loading_Gif", objectData);
	 }
	 
	 public void groupActivity(String pageData,String objectData,String deploymentNameOne,String deploymentNameTwo,String testData ){
		clickElementUsingJavaScript("Deployment_ActivitiesGroup_Checkbox", deploymentNameOne, pageData);
		clickElementUsingJavaScript("Deployment_ActivitiesGroup_Checkbox", deploymentNameTwo, pageData);
		clickElementUsingJavaScript("Deployment_Activity_Group/Ungroup_Activites_Button", pageData);
		moveToElement("Deployment_ActivitiesGroupName_Input","",pageData, testData);
		moveAndClickElement("Deployment_ActivitiesGroupEdit_Icon", "", pageData,
				testData);
        sendKeys("Deployment_ActivitiesGroupName_InputBox",PropertiesCache.setProperty(testData,"GroupName","Group_Name"),pageData);
        clickElementUsingJavaScript("Deployment_ActivitiesGroupSave_Button",pageData);
        waitForLoadingIconDisappear("Loading_Gif", objectData);
	 }
	 
	public void toggleButtonMilestone(String pageData, String objectData) {
		clickElementUsingJavaScript("Deployment_Activities_Name_Link", pageData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		scrollToElement("Deployment_ActivitiesMilestone_toggleButton", pageData);
		clickElementUsingJavaScript("Deployment_ActivitiesMilestone_toggleButton", pageData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button", pageData);
	}

	public void toggleButtonOptional(String pageData, String objectData) {
		clickElementUsingJavaScript("Deployment_Activities_Name_Link", pageData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		scrollToElement("Deployment_ActivitiesOptional_toggleButton", pageData);
		clickElementUsingJavaScript("Deployment_ActivitiesOptional_toggleButton", pageData);
		clickElementUsingJavaScript("Deployment_Activities_Activity_Close_Button", pageData);
	}

	public void deploymentActivityDownloadTemplate(String pageData) {
		//clickElementUsingJavaScript("Deployment_ActivitiesImportFromXLS_Button", pageData);
		//clickElementUsingJavaScript("Deployment_ActivitiesDownloadTemplate_Button", pageData);
		clickElementUsingJavaScript("Deployment_BulkUpload_Option", pageData);
		sleep(2000);
		clickElementUsingJavaScript("Deployment_BulkImportTemplateFile_Link", pageData);
		sleep(4000);
	}
	
	public void editActivitySetName(String pageData,String objectData,String newActivityName) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_ActivitiesSetsEditname_Icon", pageData);
		sleep(1000);
		clear("Deployment_ActivitiesSetsEditname_InputBox", pageData);
		sleep(1000);
		clickElementUsingJavaScript("Deployment_ActivitiesSetsEditname_Icon", pageData);
		sendKeysWithEnter("Deployment_ActivitiesSetsEditname_InputBox",newActivityName,pageData);
		clickElementUsingJavaScript("Deployment_Save_Button", pageData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void deleteActivitySetName(String pageData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("Deployment_ActivitiesSetName_checkBox", pageData);
		clickElementUsingJavaScript("Deployment_ActivitiesSetDelete_button", pageData);
		sleep(3000);
		clickElementUsingJavaScript("Deployment_ActivitiesSetDeleteYes_button", pageData);
		clickElementUsingJavaScript("Deployment_Save_Button",pageData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
}
