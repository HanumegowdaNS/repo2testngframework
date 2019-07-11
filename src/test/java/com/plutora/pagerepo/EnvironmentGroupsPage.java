package com.plutora.pagerepo;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class EnvironmentGroupsPage extends TestGenericUtilLib {
	
	
	public void gotoEnvironmentMap(String environmentGroupsData,String testData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		mouseHover("Environment_Header_Dropdown", "Environment_Map_Option",environmentGroupsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void gotoEnvironmentGroupsPage(String envData, String testData, String objectData) throws InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif", objectData);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Environment_Header_Sidemenu", envData);
			sleep(500);
			click("EnvGroups_ManageEnvGroups_Dropdown", envData);
		} else {
			mouseHover("Environment_Header_Dropdown", "Environment_Dropdown_Options","EnvGroups_ManageEnvGroups_Dropdown",envData);
		}
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
	}
	
	public void closeEnvironmentGroupsPage(String envData, String testData, String objectData) throws InterruptedException {
		clickElementUsingJavaScript("ENVGroups_CloseButton", envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
	}
	
	public void createEnvironmentGroups(String envData, String testData, String objectData,String envName) throws InterruptedException{	
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_IntegratedEvgGroups_Button",envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		sendKeys("EnvGroups_DetailName_Textfield",PropertiesCache.setProperty(testData, envName),envData);
		switchToFrameByElement("Global_Iframe",objectData);
		sendKeys("Global_Description_TextField", PropertiesCache.setProperty(testData, "New_ENV_Groups_Description"),objectData);
		switchToDefaultContent();
		sleep(1000);
		clickElementUsingJavaScript("EnvGroups_PhaseUsage_Dropdown",envData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "EnvGroups_Phase",getTextData("EnvGroups_PhaseUsage_FirstOption", envData));
		click("EnvGroups_PhaseUsage_FirstOption",envData);
		sleep(2000);
		scrollToElement("EnvGroups_SaveCloseButton",envData);
		/*scrollToElement("EnvGroups_ExpandBottom_Button",envData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_ExpandBottom_Button",envData);
		sleep(2000);*/
		//mouseHover("EnvGroups_SaveCloseButton","EnvGroups_SaveCloseButton",envData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_SaveCloseButton",envData);
		sleep(1000);
		
	}
	
	
	public void readEnvironmentGroups(String envData, String testData, String objectData,String envgrpName){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElement("EnvGrp_LiveSearch_xout", envData);
		//sendKeysWithEnter("EnvGroups_LiveSearch_Textbox", envgrpName, testData);
		sendKeys("EnvGroups_LiveSearch_Textbox",envgrpName,envData,testData);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("EnvGrp_Name_Row",envgrpName,envData,testData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void clickOnEnvironmentGroups(String envData, String testData, String objectData,String envgrpName){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("EnvGroups_EnvNameLink",envgrpName,envData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		/*clickElementUsingJavaScript("EnvGroups_Details_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);*/
	}
	
	public void updateEnvironmentGroups(String envData, String testData, String objectData,String envGroupName){	
		sleep(3000);
		clickElementUsingJavaScript("EnvGroups_EnvNameLink",envGroupName,envData,testData);
		switchToFrameByElement("Global_Iframe",objectData);
		sendKeys("Global_Description_TextField", PropertiesCache.setProperty(testData, "New_ENV_Groups_Description"),objectData);
		switchToDefaultContent();
		sleep(2000);
		scrollToElement("EnvGroups_SaveCloseButton",envData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_SaveCloseButton",envData);
		//sleep(1000);
	}
	
	public void deleteEnvironmentGroups(String envData, String testData, String objectData){
		
		clickOnButton(envData,"EnvGrp_GroupMember_Tab",objectData);
		try {
		sleep(2000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  	
		List<WebElement> elements=driver.findElements(By.xpath(PropertiesCache.getProperty(envData, "EnvGrp_GroupMember_Text")));
		if(elements.size()>0) {	
		for(WebElement element:elements) {
			element=driver.findElement(By.xpath(PropertiesCache.getProperty(envData, "EnvGrp_GroupMember_Text")));
			click(element);
			clickOnButton(envData,"NewEnvironment_DeleteButton", objectData);
			clickOnButton(envData,"NewEnvironment_DeleteYesButton", objectData);
			waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
			sleep(2000);
			
		 }
		}
		clickOnEnvironmentGroupsMemberSaveButton(envData, testData, objectData);
		}catch(Exception e) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_DeleteGroups_Button",envData);
		sleep(1000);
		clickOnButton(envData,"EnvGroups_DeleteYes_Button",objectData);
	}
	
	public void verifyUpdatedEnvironmentGroups(String envData, String testData, String objectData) {
		
		switchToFrameByElement("Global_Iframe",objectData);
		verifyText("Global_Description_TextField","New_ENV_Groups_Description", objectData,testData);
		switchToDefaultContent();
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		scrollToElement("EnvGroups_SaveCloseButton",envData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGroups_SaveCloseButton",envData);
	}
	
	public void clickOnEnvironmentGroupSaveAndCloseButton(String envData, String testData, String objectData){	
		sleep(2000);
		scrollToElement("EnvGroups_SaveCloseButton",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("EnvGroups_SaveCloseButton",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void clickOnEnvironmentGroupsMemberSaveAndCloseButton(String envData, String testData, String objectData){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("EnvGroupsMember_SaveAndClose_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void clickOnEnvironmentGroupsMemberSaveButton(String envData, String testData, String objectData){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("EnvGroupsMember_Save_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void clickOnShowEnvironmentMapButton(String envData, String objectData){	
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		clickElementUsingJavaScript("EnvGrp_ShowEnvMap_Button",envData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}
	
	public void updateStakeholder(String envData, String testData, String objectData) {
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, 1, "Deployment_Plan_AddStakeholder_Button");
		Listener.addLogger("Deployment plan stakeholder added successfully  !");
	}
	
	public void verifyAdditionalInformationTab(String environmentData,String testData,String objectData,String customFieldList,String envGrpName) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("EnvGrp_AdditionalInformation_Tab",environmentData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("Additional_Information_LabelName", "EnvGrp_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName", "EnvGrp_CustomField_Name",objectData,testData);
		verifyCustomFieldValue(environmentData,testData, objectData, customFieldList,"EnvGrp_CustomField_Name",envGrpName,"EnvGroups_EnvNameLink","EG_Save&Close_Button");
		Listener.addLogger(PropertiesCache.getProperty(testData, "EnvGrp_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}
	
	public void searchEnvironmentOnEnvironmentGroup(String environmentData,String testData,String objectData,String environmentName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_GroupMember_Tab",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("EnvGrp_GroupMember_Search_Result", environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void addEnvironmentToGroupMember(String environmentData,String testData,String objectData,String environmentName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_GroupMember_Tab",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		sendKeys("EnvGrp_GroupMember_Search_Result", environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		dragAndDrop("EnvGrp_Environment_Row","EnvGrp_GroupMember_Section",environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void removeEnvironmentFromGroupMember(String environmentData,String testData,String objectData,String environmentName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_GroupMember_Tab",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("EnvGrp_Environment_Row","EnvGrp_Environment_Section",environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void addBatch(String environmentData,String testData,String objectData,String typeName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Connectivity_Tab",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_Direction_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Direction_DirectionRight_Option",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_Target_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_2",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Target_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(3000);
		
		clickElementUsingJavaScript("EnvGrp_Type_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		if (typeName.equals("Connectivity_Type")) {
			clickElementUsingJavaScript("EnvGrp_Type_Dropdown_Text",typeName,environmentData,testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
		} else {
			PropertiesCache.setProperty(testData, "EnvGrp_Type",getTextData("EnvGrp_Type_Dropdown_Option", environmentData));
			clickElementUsingJavaScript("EnvGrp_Type_Dropdown_Option", environmentData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
		}
		clickElementUsingJavaScript("EnvGrp_Type_Dropdown",environmentData);
		
		clickElementUsingJavaScript("EnvGrp_Type_Dropdown",environmentData);
		clickElementUsingJavaScript("EnvGrp_Batch_Add_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void changeDirectionInConnectivityGrid(String environmentData,String testData,String objectData,String leftDirection,String rightDirection) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(leftDirection,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("EnvGrp_ConnectivityGrid_Direction_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(rightDirection,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("EnvGrp_ConnectivityGrid_Row","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void changeDirectionConnectivityGrid(String environmentData,String testData,String objectData,String leftDirection,String rightDirection) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(leftDirection,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("EnvGrp_ConnectivityGrid_Direction_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(rightDirection,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("EnvGrp_ConnectivityGrid_Row","Environment_Automation_2",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void deleteConnection(String environmentData,String testData,String objectData,String environmentName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGrp_Connectivity_Tab",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		doubleClick("EnvGrp_ConnectivityGrid_Row",environmentName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("EnvGrp_Delete_Connection_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void addConnection(String environmentData,String testData,String objectData,String type,String option) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Add_Connection_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		changeDirectionInConnectivityGrid(environmentData, testData, objectData, "EnvGrp_AddConnectivityGrid_Direction", "EnvGrp_ConnectivityGrid_DirectionLeft_Option");
		
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Target",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_2",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_File",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, type,getTextData(option, environmentData));
		clickElementUsingJavaScript(option,environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		click("EnvGrp_ConnectivityGrid_Row","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void updateTypeConnection(String environmentData,String testData,String objectData,String enviormentName) {
		doubleClick("EnvGrp_ConnectivityGrid_Type_Value",enviormentName,environmentData,testData);
		PropertiesCache.setProperty(testData, "EnvGrp_Type_One",getTextData("EnvGrp_Type_Dropdown_Second_Option", environmentData));
		clickElementUsingJavaScript("EnvGrp_Type_Dropdown_Second_Option",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnEnvironmentGroupsMemberSaveButton(environmentData, testData, objectData);
		
	}
	public void updateConnection(String environmentData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_2",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		changeDirectionConnectivityGrid(environmentData, testData, objectData, "EnvGrp_AddConnectivityGrid_Direction", "EnvGrp_ConnectivityGrid_RightDirection");
		
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Target",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_Source_Dropdown_Option","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_File1",environmentData);
		sleep(1000);
		clickElementUsingJavaScript("EnvGrp_AddConnectivityGrid_Source_Dropdown",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "EnvGrp_Type",getTextData("EnvGrp_Type_Dropdown_Option", environmentData));
		clickElementUsingJavaScript("EnvGrp_Type_Dropdown_Option",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("EnvGrp_ConnectivityGrid_Row","Environment_Automation_1",environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void moveConnection(String environmentData, String testData, String objectData) {
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
		/* Selecting the Source Checkbox */
		clickElementUsingJavaScript("EnvGrp_ConnectivityGrid_Environment_Text", "Environment_Automation_1",
				environmentData, testData);
		/* Clicking On Move Connection */
		clickElementUsingJavaScript("EnvGrp_MoveConnection_Button", environmentData);
		/* Waiting for Loader to dissapear */
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		/* Entering Group Name in Destination Input Box */
		sendKeysWithoutClear("EnvGrp_MoveToDestinationGrp_InputBox", "EnvGrp_Automation_2", environmentData, testData);
		sleep(2000);
		/* Selecting the Env Group */
		clickElementUsingJavaScript("EnvGrp_MoveToElement_DropDownElement", "EnvGrp_Automation_2", environmentData,
				testData);
		/*Clicking on Save And Close */
		clickElementUsingJavaScript("EnvGrp_MoveConnectionSaveAndClose_Button", environmentData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);

	}
	
	public void selectEnvironmentGroupInMap(String environmentData,String testData,String objectData,String envgrpName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		doubleClick("Environment_Map_EnvGrp_Dropdown",environmentData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	//	sendKeys("Environment_Map_EnvGrp_Textbox", envgrpName,environmentData,testData);
	//	waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Environment_Map_EnvGrp_Dropdown_Option",envgrpName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
		/*click("Environment_Map_Environment_Names_Checkbox",envgrpName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		
		click("Environment_Map_Environment_groups_Checkbox",envgrpName,environmentData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);*/
		
		click("Environment_Map_View_Button",environmentData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void verifyStakeholderRole(String environmentData,String testData,String objectData,String defaultValue,String name) {
		clickElementUsingJavaScript("EnvGroups_IntegratedEvgGroups_Button",environmentData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		new ReleasePage().verifyStakeholderRole(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1,"Releases_EStakeholder_Button",defaultValue,name);
		Listener.addLogger("Verified stakeholder role successfully !");
		clickElementUsingJavaScript("NewEnvGroups_Close_Button",environmentData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
		clickElementUsingJavaScript("EnvGroups_Close_Button",environmentData);
		waitForLoadingIconDisappear(60, "Loading_Gif",objectData);
	}
	
	public void verifyFieldPermissionCustomField(String environmentData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("EnvGrp_AdditionalInformation_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("EnvGrp_AdditionalInformation_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("EnvGrp_AdditionalInformation_Tab",environmentData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
			sleep(1000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change additional information successfully");
		clickElementUsingJavaScript("EnvGroups_SaveCloseButton",environmentData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		clickOnEnvironmentGroupsMemberSaveAndCloseButton(environmentData,testData,objectData);
		
	}
	/*public void closeEnvironmentGroupPage(String environmentGroupData) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
			driver.findElement(By.cssSelector("[id*=environmentGroupWindow] .x-tool-close")).click();
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		//clickElement("EnvGroups_Close_Button", environmentGroupData);
	}*/
	
	public void contactStakeHolder(String environmentData,String testData,String objectData){
		/* Clicking on 'Contact Stakeholder' */
		clickElementUsingJavaScript("EnvGroups_ContactStakeholder_Button", environmentData);
		/* Waiting for loader to dissapear */
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		/* Enter the email address */
		sendKeys("EnvGroups_AlertStakeholderFrom_InputBox",
				PropertiesCache.getProperty(testData, "sender_email"), environmentData);
		/* Enter Subject */
		sendKeys("EnvGroups_AlertStakeholderSubject_InputBox", PropertiesCache.getProperty(testData, "Email_Subject"),
				environmentData);
		/* Enter body */
		sendKeys("EnvGroups_AlertStakeholderBody_textarea", PropertiesCache.getProperty(testData, "Email_Body"),
				environmentData);
		/* Click on Send Button */
		clickElementUsingJavaScript("EnvGroups_AlertStakeholderSend_Button", environmentData);
		/* Waiting for Loader to disapear */
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		
	}
	
}
