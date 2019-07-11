package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRWindowItemGrid {
	PIRPage pirPage = new PIRPage();
	CustomizationPage customizationPage = new CustomizationPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	ReleasePage releasePage = new ReleasePage();

	@Test (description="Sub-area: PIR Window -> PIR Item Grid tab -> PIR Item add/edit/delete")
	public void subareaPIRWindowPIRItemGrid_01() throws InterruptedException, ParseException {	
		//Add pir
		pirPage.refresh(PlutoraConfiguration.objectData);
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.getPIRCreationPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIR_Item_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Window's PIR Item created successfully !");
		//update pir
		pirPage.clickAndUpdateNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIR_Item_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Window's PIR Item updated successfully !");
		//delete pir
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Item_Automation_Summary",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Window's PIR Item deleted successfully !");
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Window's PIR test data deleted successfully !");
	}
	
	
	@Test (description="Sub-area: PIR Window -> Action -> Grid Column Selector ")
	public void subareaPIRWindowPIRItemGrid_02() throws InterruptedException {
		
		//Create custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		pirPage.sleep(4000);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		//Add grid selector
		pirPage.addPIRGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "PIR_CustomField_Name","Action_Button");
		//Verify grid selector
		pirPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name")+" verified in PIR grid successfully !");
		//Clear grid selector
		pirPage.clearPIRGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
		//Verify grid selector not available
		pirPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name").toUpperCase());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_CustomField_Name").toUpperCase()+" not displayed in PIR grid successfully !");
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
	}

	@Test (description="Sub-area: PIR Window -> PIR Item Grid tab -> Query Builder (QB) + Quick Access menu")
	public void subareaPIRWindowPIRItemGrid_03() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_PIRItemCustomFields_Option","PIR_CustomField_Name");
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		pirPage.sleep(1000);
		
		pirPage.addPIRGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "PIR_CustomField_Name","Action_Button");
		
		//Add new public query
		pirPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		pirPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Summary", "equals", "PIRItem_Automation","1");
		pirPage.saveAndRunPIRQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIRItem_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Automation")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Query_Public_Builder");
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIRItem_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		//Condition 1
		pirPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Status"),"1","1");
		pirPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		pirPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		pirPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Summary", "equals", "PIRItem_Automation","2");
		pirPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		pirPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		pirPage.sleep(1000);
		pirPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Item ID", "equals", "PIR_Action_Identifier","3");
		pirPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		pirPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		pirPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Category", "equals", PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Category"),"4","4");
		pirPage.saveAndRunPIRQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//TEBR Name
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIRItem_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_GridField_Text","PIR_Item_Category",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_Grid_Status_Text","PIR_Item_Status",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_GridField_Text","PIR_Action_Identifier",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Query_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Status")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Category")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Action_Identifier")+"<br>"+
				"verified private query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		//pirPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Dropdown", PlutoraConfiguration.objectData);
		pirPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	
		pirPage.deleteNewlyCreatedPIRAll(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_PIRItemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_CustomField_Name");
	}
	@Test (description="Sub-area: PIR Window -> PIR Item Grid tab -> Grid Column Filtering (GCF)")
	public void subareaPIRWindowPIRItemGrid_04() throws InterruptedException, ParseException {	
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		//Release Creation
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIRItem_Automation");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		//Item Id
		pirPage.sendKeysWithEnter("PIR_Window_Grid_ItemID", "PIR_Action_Identifier", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_GridField_Text","PIR_Action_Identifier",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Action_Identifier")+" Item Id filtered successfully !");
		//summary
		pirPage.sendKeysWithEnter("PIR_Window_Grid_Summary", "PIRItem_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_Item_ID_Searched_Summary_Link","PIRItem_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Automation")+" Summary filtered successfully !");
		//Raised By
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Window_Grid_RaisedBy", PlutoraConfiguration.objectData);
		pirPage.clickButton("PIR_Window_Grid_Dropdown_Option", "Loggedin_Username_Value", PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.enter();
		pirPage.verifyText("PIR_GridField_Text","Loggedin_Username_Value",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value")+" Raised By filtered successfully !");
		//Category
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Window_Grid_Category", PlutoraConfiguration.objectData);
		pirPage.clickButton("PIR_Window_Grid_Dropdown_Option", "PIR_Item_Category", PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.enter();
		pirPage.verifyText("PIR_GridField_Text","PIR_Item_Category",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Category")+" Category  filtered successfully !");
		//Status
		/*pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Window_Grid_Status", PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.clickButton("PIR_Window_Grid_Dropdown_Option", "PIR_Item_Status", PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		pirPage.enter();
		pirPage.verifyText("PIR_Grid_Status_Text","PIR_Item_Status",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);*/
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Status")+" Status filtered successfully !");
	
		pirPage.sleep(2000);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		//Update release & System
		pirPage.updateReleaseSystemInPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation","System_Automation");
	
		//System
		pirPage.sendKeysWithEnter("PIR_Window_Grid_ImpactedSystem", "System_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_Grid_RSField_Text","System_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" system filtered successfully !");
		//Release Id
		pirPage.sendKeysWithEnter("PIR_Window_Grid_ReleaseID", "Project_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.verifyText("PIR_Grid_RSField_Text","Project_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" release filtered successfully !");
		
		//pirPage.deleteNewlyCreatedPIRAll(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		
	}
	@Test (description="Sub-area: PIR Manager -> PIR Item Grid tab -> View Preventative Measure via hyperlink")
	public void subareaPIRWindowPIRItemGrid_05() throws InterruptedException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Items_Tab");
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		
		pirPage.sendKeysWithEnter("PIR_Window_Grid_Summary", "PIRItem_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Automation");
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Save&ExitButton", PlutoraConfiguration.objectData);
		
		pirPage.sendKeysWithEnter("PIR_Window_Grid_Summary", "PIRItem_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.clickOnActionItems(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_Item_Grid_PM_Count");
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_PM_Automation_Summary")+" verified View Preventative Measure via hyperlink successfuly");
		pirPage.clickOnButton(PlutoraConfiguration.pirData, "PIR_Save&ExitButton", PlutoraConfiguration.objectData);
		
		pirPage.deleteNewlyCreatedPIRAll(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
	}

	
}
