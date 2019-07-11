package com.plutora.pagerepo;

import java.awt.AWTException;
import java.text.ParseException;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;
import com.plutora.pagerepo.MainMenuPage;

public class SystemsPage extends TestGenericUtilLib  {

	MainMenuPage mainmenuPage = new MainMenuPage();
	
	public static String assignedTo=null;
	// List<String> userMember;
	public static String approvers=null;
	public static String userStakeHolder = null;
	
	public  void creationSystems(String systemsData,String testData,String objectData) {	
		/* Enter New Systems Name */
		//waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		sendKeys("AddSystems_NameTextfield",PropertiesCache.setProperty(testData, "Systems_Test_Automation_Id"),systemsData);
		sendKeys("AddSystems_DescriptonTextfield","New_Systems_Description_Value",systemsData,testData);
		sendKeys("AddSystems_VendorTextfield","New_Systems_Vendor_Value",systemsData,testData);
		//clickElementUsingJavaScript("AddSystems_PortfolioAssociation", systemsData);
		sleep(1000);
		sendKeys("AddSystems_PortfolioAssociation","New_ER_Portfolio_Association_Value", systemsData, testData);
		sleep(1000);
		click("Systems_Portofolio_Association_search", "New_ER_Portfolio_Association_Value", systemsData, testData);
		
		//clickElementUsingJavaScript("Systems_Details_Label",systemsData);
		sleep(2000);
		//clickElementUsingJavaScript("AddSystems_ActiveRadio",systemsData);
		/* Click on Save & close Button */
		clickElementUsingJavaScript("Systems_SaveButton",systemsData);
		sleep(2000);
		//click("Systems_BackButton",systemsData);
	}

	public  void creationSystems(String systemsData,String testData,String objectData,String systemID) {	
		/* Enter New Systems Name */
		sleep(2000);
		sendKeys("AddSystems_NameTextfield",PropertiesCache.setProperty(testData, systemID),systemsData);
		sendKeys("AddSystems_DescriptonTextfield","New_Systems_Description_Value",systemsData,testData);
		sendKeys("AddSystems_VendorTextfield","New_Systems_Vendor_Value",systemsData,testData);
		sleep(1000);
		sendKeys("AddSystems_PortfolioAssociation","New_ER_Portfolio_Association_Value", systemsData, testData);
		sleep(1000);
		click("Systems_Portofolio_Association_search", "New_ER_Portfolio_Association_Value", systemsData, testData);
		/* Click on Save & close Button */
		clickElementUsingJavaScript("Systems_SaveButton",systemsData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}
	
	public  void creationSystemsWithStakeholder(String systemsData,String testData,String objectData,String systemID) {	
		/* Enter New Systems Name */
		sleep(2000);
		sendKeys("AddSystems_NameTextfield",PropertiesCache.setProperty(testData, systemID),systemsData);
		sendKeys("AddSystems_DescriptonTextfield","New_Systems_Description_Value", systemsData,testData);
		sendKeys("AddSystems_VendorTextfield","New_Systems_Vendor_Value",systemsData,testData);
		sleep(1000);
		sendKeys("AddSystems_PortfolioAssociation","New_ER_Portfolio_Association_Value", systemsData, testData);
		sleep(1000);
		click("Systems_Portofolio_Association_search", "New_ER_Portfolio_Association_Value", systemsData, testData);
		/* Click on Save & close Button */
		clickElementUsingJavaScript("Systems_SaveButton",systemsData);
		sleep(2000);
		//click("Systems_BackButton",systemsData);
		sleep(4000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public  void enterNewlyCreatedSystems(String systemsData,String testData,String objectData,String systemId) {
		//sendKeysWithEnter("Systems_SearchSystemName",systemId,systemsData,testData);
		sendKeysWithDeleteCharacter("Systems_SearchSystemName",systemId,systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public  void enterNewlyCreatedSystems(String systemsData,String objectData,String systemId) {
		sendKeysWithDeleteCharacter("Systems_SearchSystemName",systemId,systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void clickOnSystem(String systemsData,String testData,String objectData,String systemId) {
		sleep(2000);
		clickElementUsingJavaScript("Systems_Name",systemId,systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}

	public  void clickAndUpdateNewlyCreatedSystems(String systemsData,String testData,String objectData) {
		windowScrollDown("400");
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickElementUsingJavaScript("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Systems_ShakeholderButton",systemsData);
		sleep(2000);
		click("Systems_UserGroupDropdown",systemsData);
		assignedTo=getTextData("Systems_UserGroupFirst_Option",systemsData);
		click("Systems_UserGroupFirst_Option",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		doubleClick("Systems_Stakeholders_Label",systemsData);
		sleep(2000);
		clickElementUsingJavaScript("System_Save&CloseButton", systemsData);
		sleep(2000);
		click("Systems_SaveButton",systemsData);
		//		click("Releases_RoleDropdown", systemsData);
		//		sleep(1000);
		//		click("Releases_RoleFirst_Option", systemsData);
		//		sleep(500);
		//click("System_Add&CloseButton",systemsData);
		//click("Systems_SaveButton",systemsData);
		/*waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Systems_SearchButton","Systems_Test_Automation_Id",systemsData,testData);
		click("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Systems_Save&CloseButton",systemsData);

		//enterNewlyCreatedSystems(systemsData, testData,objectData,"Systems_Test_Automation_Id");
		waitForLoadingIconDisappear("Loading_Gif",objectData);

		enterNewlyCreatedSystems(systemsData, testData,objectData,"Systems_Test_Automation_Id");
		waitForLoadingIconDisappear("Loading_Gif",objectData);*/

	}
	public void reactAddGridColumnSelector(String systemData, String testData, String customFieldName){
		click("Systems_ActionButton",systemData);
		click("Systems_Add_Remove_Columns", systemData);
		sleep(2000);
		click("System_CustomField_Name","System_CustomField_Name", systemData, testData);
		clickOnButton(systemData, "Systems_CustomField_Save");
		Listener.addLogger(PropertiesCache.getProperty(systemData, customFieldName)+" added in grid column selector successfully !");
		sleep(1000);
	}
	public void deleteNewlyCreatedSystems(String systemsData,String testData,String objectData){
		
		sleep(1000);
		clickElementUsingJavaScript("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Action_Button", systemsData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		sleep(1000);
		click("Systems_Yes_Button",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void deleteNewlyCreatedSystems(String systemsData,String testData,String objectData,String systemId){
		sleep(2000);
		enterNewlyCreatedSystems(systemsData, testData,objectData,systemId);
		sleep(1000);
		clickElementUsingJavaScript("Systems_Name",systemId,systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Action_Button", systemsData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		sleep(1000);
		click("Systems_Yes_Button",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}


	public void createDuplicateSystems(String systemsData,String testData,String objectData){
		/*switchToDefaultContent();
		sleep(1000);
		click("Systems_Save&CloseButton",systemsData);
		enterNewlyCreatedSystems(systemsData, testData,objectData,"Systems_Test_Automation_Id");
		waitForLoadingIconDisappear("Loading_Gif",objectData);*/
		click("Systems_Name_Checkbox","Systems_Test_Automation_Id",systemsData,testData);
		sleep(2000);
		click("Systems_ActionButton",systemsData);
		sleep(1000);
		click("Systems_DuplicateRequest_Option",systemsData);
		sleep(1000);
		click("Systems_DuplicateButton",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void enterNewlyCreatedDuplicateSystems(String systemsData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//sendKeysWithEnter("Systems_SearchSystemName",systemId,systemsData,testData);


		String systemID = setDuplicateName("(Copy) ", "Systems_Test_Automation_Id", "Copy_Systems_Test_Automation_Id", testData);
		sendKeysWithDeleteCharacter("Systems_SearchSystemName","Copy_Systems_Test_Automation_Id",systemsData,testData);
		//sendKeysWithEnter("Systems_SearchSystemName",setDuplicateName("(Copy) ", "Systems_Test_Automation_Id", "Copy_Systems_Test_Automation_Id", testData),systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public  void deleteNewlyCreatedDuplicateSystems(String systemsData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Systems_Name","Copy_Systems_Test_Automation_Id",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Action_Button", systemsData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		sleep(1000);
		click("Systems_Yes_Button",systemsData);
	}

	public  void getportfolioAssociationPage(String systemsData){
		sleep(2000);
		clickElementUsingJavaScript("Systems_PortfolioAssociation_Button",systemsData);
		sleep(2000);
	}

	public void openSystemPage(String systemsData,String testData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		sleep(2000);
	}

	public void openSystemPage(String systemsData,String testData,String objectData,String systemId) {
		sleep(2000);
		click("Systems_Name",systemId,systemsData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
	}

	public void clickOnSystemsExportToXLS(String systemsData,String testData,String objectData) {

		click("Systems_Name_Checkbox","Systems_Test_Automation_Id",systemsData,testData);
		sleep(2000);
		click("Systems_ActionButton",systemsData);
		sleep(2000);
		click("Systems_ExportToXLS_Option",systemsData);
		sleep(6000);
		
	}

	public  void getAliasPage(String systemsData,String testData,String objectData) {
		sleep(2000);
		sendKeysWithEnter("Systems_Alias_Textbox",PropertiesCache.setProperty(testData, "Systems_Alias"),systemsData);
		sleep(1000);
		//click("Systems_Alias_Button",systemsData);
		//sleep(2000);
		//waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		click("Systems_SaveButton",systemsData);
		sleep(2000);
	}

	public  void getAliasDeletePage(String systemsData,String testData,String objectData) {
		click("Systems_Alias_DeleteButton","Systems_Alias",systemsData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		click("Systems_SaveButton",systemsData);
		sleep(2000);
	}

	public void verifyAdditionalInformationTab(String systemData,String testData,String objectData,String customFieldList) throws ParseException, InterruptedException {
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		scrollToElement("React_Additional_Information_LabelName", "System_CustomField_Name",objectData,testData);
		sleep(1000);
		verifyText("React_Additional_Information_LabelName", "System_CustomField_Name",objectData,testData);
		verifyReactCustomFieldValue(systemData,testData, objectData, customFieldList,"System_CustomField_Name","Systems_Test_Automation_Id","Systems_Name","Systems_SaveButton");

		Listener.addLogger(PropertiesCache.getProperty(testData, "System_CustomField_Name")+" - "+customFieldList+" is displayed & verified with values on the web page");
	}

	public void addApprovers(String systemsData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/*click("Systems_Approvers_Tab",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Systems_MyBooking_Approvers_Dropdown",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		sendKeys("Systems_MyBooking_Approvers_Textbox", "Loggedin_Username_Value",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Systems_MyBooking_Approvers_Option","Loggedin_Username_Value",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Systems_Details_Tab",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Systems_Save&CloseButton",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);*/
		click("Systems_Approvers_Dropdown",systemsData);
		sleep(4000);
		click("Systems_Approvers_Option","Loggedin_Username_Value",systemsData,testData);
		sleep(2000);
		clickOnSaveButton(systemsData);
		
	}

	public void getAddedUpstreamPage(String systemData,String testData,String objectData) throws ParseException, InterruptedException, AWTException {
		sleep(2000);

		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnButton(systemData,"Systems_Dependencies_EditPencil",objectData);
		sleep(2000);
		
		sendKeysWithDeleteCharacter("Systems_AvailableSearch_Textbox","Systems_Test_Automation_Id1",systemData,testData);
		sleep(2000);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//dragAndDrop("Systems_SystemsName_LeftPanel", "Systems_UpstreamDependency_Grid", "Systems_Test_Automation_Id1",systemData,testData);
		//dragAndDropByOffset("Systems_SystemsName_LeftPanel", "Systems_Test_Automation_Id1", systemData, testData, "128", "800");
		int xcord = getXCoordinate("System_UpStream_Text", systemData, testData,"x_cord")+200;
		int ycord = getYCoordinates("System_UpStream_Text", systemData, testData,"y_cord")-50;
		dragAndDropWithClickAndHold("Systems_SystemsName_LeftPanel", "Systems_UpstreamDependency_Grid", "Systems_Test_Automation_Id1", systemData, testData,xcord,ycord);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//clickOnButton(systemData,"Systems_UpstreamDependencyCollapse_Button",objectData);
		//sleep(1000);
		sendKeysWithDeleteCharacter("Systems_AvailableSearch_Textbox","Systems_Test_Automation_Id2",systemData,testData);
		sleep(1000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//getCoordinates("System_DownStream_Text", systemData, testData, "a", "b");
		//dragAndDrop("Systems_SystemsName_LeftPanel", "Systems_DownstreamDependency_Grid", "Systems_Test_Automation_Id2",systemData,testData);
		int xcord1 = getXCoordinate("System_DownStream_Text", systemData, testData,"x_cord1")+200;
		int ycord1 = getYCoordinates("System_DownStream_Text", systemData, testData,"y_cord1")-50;
		dragAndDropWithClickAndHold("Systems_SystemsName_LeftPanel", "Systems_DownstreamDependency_Grid", "Systems_Test_Automation_Id2", systemData, testData,xcord1,ycord1);
		sleep(3000);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//clickOnButton(systemData,"Systems_UpstreamDependencyCollapse_Button",objectData);
		//sleep(1000);
		click("Systems_Dependencies_CloseButton",systemData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);

	}

	public void getRemovedUpstreamPage(String systemData,String testData,String objectData) throws ParseException, InterruptedException, AWTException {
		sleep(2000);
		int xcor = getXCoordinate("Systems_Dependencies_Grid", systemData, testData,"x_cord");
		int ycor = getYCoordinates("Systems_Dependencies_Grid", systemData, testData, "y_cord");
		dragAndDropWithClickAndHold("Systems_UpstreamDependency_Grid", "Systems_Dependencies_LeftPanel", "Systems_Test_Automation_Id1", systemData, testData,-800,200);
		//dragAndDrop("Systems_UpstreamDependency_Grid", "Systems_SystemsName_LeftPanel", "Systems_Test_Automation_Id1",systemData,testData);
		sleep(3000);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		dragAndDropWithClickAndHold("Systems_DownstreamDependency_Grid", "Systems_Dependencies_LeftPanel", "Systems_Test_Automation_Id2", systemData, testData,-800,200);
		//dragAndDrop("Systems_DownstreamDependency_Grid", "Systems_SystemsName_LeftPanel", "Systems_Test_Automation_Id2",systemData,testData);
		sleep(3000);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Systems_Dependencies_CloseButton",systemData);
		//waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void searchSystem(String systemData,String testData,String objectData,String systemId) {
		sleep(2000);
		sendKeysWithEnter("Systems_AvailableSearch_Textbox",systemId,systemData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
	}

	public void getApproversAddPage(String systemData,String testData,String objectData){

		click("Systems_Users_Textbox",systemData);
		sleep(2000);
		approvers=getTextData("Systems_SearchedUser_Checkbox",systemData);
		click("Systems_SearchedUser_Checkbox",systemData);
		sleep(2000);
		click("Systems_SaveButton",systemData);
		
	}


	public void getApproversRemovePage(String systemData,String testData,String objectData){

		click("Systems_AddedUserClose_Icon","Systems_Approver_Name",systemData,testData);
		sleep(1000);
		clickOnButton(systemData,"Systems_Dependencies_Tab",objectData);
		sleep(1000);
		clickOnButton(systemData,"Systems_Approvers_Tab",objectData);
		sleep(1000);
	}

	public void getSystemDeleteForApproversPage(String systemData,String testData,String objectData) {

		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemData);
		sleep(1000);
		click("Systems_Yes_Button",systemData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void updateSystems(String systemData,String testData,String objectData)  {

		sendKeys("AddSystems_NameTextfield",PropertiesCache.setProperty(testData, "Systems_Test_Automation_Id"),systemData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Systems_Save&CloseButton",systemData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
	}
	public void verifyFieldPermissionCustomField(String systemsData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("React_Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("React_Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("React_FieldPermission_ViewValue", name,objectData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
			sleep(2000);
			scrollToElement("React_Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("React_Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("React_FieldPermission_EditValue", name,objectData,testData);
			break;
		case "View Custom Field":
			waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
			sleep(2000);
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change additional information successfully");
		clickElementUsingJavaScript("Systems_SaveButton",systemsData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	public void setSystemImpactFromDependencies(String systemData,String testData,String objectData,String systemId,String systemType)  {
		sleep(1000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnButton(systemData,"Systems_Dependencies_EditPencil",objectData);
	    sleep(2000);
	    sendKeysWithEnter("Systems_AvailableSearch_Textbox",systemId,systemData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		dragAndDrop("Systems_Additional_Information_LabelName", "Systems_UpstreamDependency_Grid", systemId,systemData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, systemId)+" System is dragged and dropped into Upstream Dependencies Section successfully");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		doubleClick("Systems_Impact_Section",systemId,systemData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Systems_Impact_Dropdown",systemData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Systems_Impact_Dropdown_Option",systemType,systemData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, systemType)+" Custom System dependency is selected from dropdown successfully");
		clickOnSaveAndCloseButton(systemData, objectData);
	}
	public void updateSystemImpactFromDependencies(String systemData,String testData,String objectData,String systemId,String systemType) {
		doubleClick("Systems_Impact_Section",systemId,systemData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Systems_Impact_Dropdown",systemData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
		click("Systems_Impact_Dropdown_Option",systemType,systemData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnSaveButton(systemData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, systemType)+" Custom System dependency is selected from dropdown successfully");
	}
	public void clickOnSaveAndCloseButton(String systemData,String objectData) {
		sleep(1000);
		clickElementUsingJavaScript("Systems_Save&CloseButton",systemData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void updatePortfolioAssociation(String systemsData,String testData,String objectData,String organizationName) {
		click("AddSystems_PortfolioAssociation", systemsData);
		clickOnButton(systemsData,"Systems_PortfolioAssociation_Expand_Icon","Systems_PortfolioAssociation_Collpase_Icon",objectData);
		clickButton("Systems_PortfolioAssociation_Dropdown_Option",organizationName,systemsData,testData,objectData);
		clickOnSaveButton(systemsData);
		Listener.addLogger(PropertiesCache.getProperty(testData, organizationName)+" updated in system successfully !");
	}
	
	public void updateSystemBulk(String systemsData,String testData,String objectData){
		
		click("Systems_ActionButton",systemsData);
		sleep(500);
		clickElementUsingJavaScript("Systems_BulkUpdate_Button", PlutoraConfiguration.systemsData);
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		/* Clicking on System Details Tab */
		click("Systems_Details_Tab", systemsData);
		sleep(2000);
		/* Updating System Name */
		sendKeys("Update_AddSystem_NameTextfield", PropertiesCache.setProperty(testData, "Systems_Test_Automation_Bulk"),
				systemsData);
		/* Updating System Description */
		sendKeys("Update_AddSystem_DescriptonTextfield", PropertiesCache.setProperty(testData, "Systems_Description"),
				systemsData);
		/* Updating System Vendor */
		sendKeys("Update_AddSystem_VendorTextfield", PropertiesCache.setProperty(testData, "Systems_Vendor"), systemsData);
		Listener.addLogger("Cliking on Portfolio Association DrpDown....");
		/* Updating Portfolio Association */
		clickElementUsingJavaScript("System_PortfolioAssociation_DownArrow", systemsData);
		waitForLoadingElement(10, "System_PortfolioAssociation_ListSecondItem", systemsData);
		Listener.addLogger("Selecting the First Option in the first Company...");
		PropertiesCache.setProperty(testData, "System_PortfolioAssociation_ListSecondItem",
				getTextData("System_PortfolioAssociation_ListSecondItem", systemsData));
		clickElementUsingJavaScript("System_PortfolioAssociation_ListSecondItem", systemsData);
		sleep(1000);
		/* Updating Status */
		click("AddSystems_InactiveRadio", systemsData);
		/* Clicking On Save And Close */
		sleep(2000);
		click("Update_System_Save&CloseButton", systemsData);
				
	}
	public void deleteSystemBulk(String systemsData,String objectData){
		/*Navigating to Actions*/
		clickElementUsingJavaScript("Systems_ActionButton", systemsData);
		/*Clicking on 'Delete'*/
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		/*Clicking on 'Yes' Button*/
		clickElementUsingJavaScript("Systems_Yes_Button",systemsData);
		/*Waiting for Loader to disapear*/
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
	}
	
	public void createDuplicateSystem(String systemsData,String objectData){
		/*Navigating to Actions*/
		clickElementUsingJavaScript("Systems_ActionButton", systemsData);
		/*Clicking on 'Duplicate System'*/
		clickElementUsingJavaScript("Systems_DuplicateRequest_Option",systemsData);
		/*Clicking on 'Duplicate' Button*/
		clickElementUsingJavaScript("Systems_DuplicateButton",systemsData);
		/*Waiting for Loader to disapear*/
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
	}
	
	public void contactStakeHolder(String systemsData,String testData,String objectData){
		clickElementUsingJavaScript("Systems_ContactStakeholder_Button", systemsData);
		sendKeys("System_AlertStakeholderFrom_InputBox",
				PropertiesCache.getProperty(testData, "ForgotPassword_Username"), systemsData);
		/* Enter Subject */
		sendKeys("System_AlertStakeholderSubject_InputBox", PropertiesCache.getProperty(testData, "Email_Subject"),
				systemsData);
		/* Enter body */
		sendKeys("System_AlertStakeholderBody_textarea", PropertiesCache.getProperty(testData, "Email_Body"),
				systemsData);
		/* Click on Send Button */
		clickElementUsingJavaScript("System_AlertStakeholderSend_Button", systemsData);
		/* Waiting for Loader to disapear */
		waitForLoadingIconDisappear(100, "Loading_Gif", objectData);
		
	}

	public void addAccountableStakeholder(String systemsData, String testData, String objectData, String user)
	{
		sleep(3000);	
		click("Systems_ShakeholderButton",systemsData);
		sleep(2000);
		click("Systems_UserGroupDropdown",systemsData);
		sleep(2000);
		sendKeysWithEnter("Systems_UserGroup_InputBox", PropertiesCache.getProperty(testData, user), systemsData);
		sleep(2000);
		doubleClick("Systems_Stakeholders_Label",systemsData);
		sleep(2000);
		clickElementUsingJavaScript("System_Stakeholder_RACI_CheckBox", systemsData);
		sleep(500);
		clickElementUsingJavaScript("System_Save&CloseButton", systemsData);
		sleep(2000);
		click("Systems_SaveButton",systemsData);
	}
	
	public void addAccountableStakeholder(String systemsData, String testData, String objectData)
    {
        sleep(3000);    
        userStakeHolder = mainmenuPage.getLoggedInUserName(objectData);
        sleep(3000);
        click("Systems_ShakeholderButton",systemsData);
        sleep(2000);
        click("Systems_UserGroupDropdown",systemsData);
        sleep(2000);
        sendKeys("Systems_UserGroup_InputBox", userStakeHolder, systemsData);
        sleep(2000);
        clickElementUsingJavaScript("Systems_RoleFirst_Option", systemsData);
        sleep(2000);
        doubleClick("Systems_Stakeholders_Label",systemsData);
        sleep(2000);
        clickElementUsingJavaScript("System_Stakeholder_RACI_CheckBox", systemsData);
        sleep(500);
        clickElementUsingJavaScript("System_Save&CloseButton", systemsData);
        sleep(2000);
        click("Systems_SaveButton",systemsData);
    }
	
	public void updateStakeholderRACI(String elementLocator, String header, String systemsData)
	{
		hoverOver(elementLocator, header, systemsData);
		sleep(1000);
		clickElementUsingJavaScript("System_Stakeholder_RACI_CheckBox", systemsData);
        sleep(500);
        clickElementUsingJavaScript("Systems_Update&Close_Button", systemsData);
        sleep(2000);
        click("Systems_SaveButton",systemsData);
		sleep(1000);
		
		
	}
	public void deleteStakeholder(String elementLocator, String header, String systemsData)
	{
		hoverOver(elementLocator, header, systemsData);
		sleep(1000);
		click("Systems_SaveButton",systemsData);
		sleep(1000);
	}
	public void clickOnSaveButton(String systemData) {
		clickElementUsingJavaScript("Systems_SaveButton",systemData);
		sleep(2000);
	}
}
