package com.plutora.testplan;


import java.io.File;
import java.text.ParseException;
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
import com.plutora.utils.WebGenericUtilLib;


public class Environments {
	EnvironmentPage environmentPage= new EnvironmentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	ReleasePage releasePage = new ReleasePage();
	
	@Test (description="Live Search")
	public void environments_01() throws InterruptedException  {
		WebGenericUtilLib.driver.navigate().refresh();
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Environment_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is verified from Live Search successfully !");
	}
	@Test (description="Add/edit/delete environment")
	public void environments_02() throws InterruptedException {	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.updateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is updated successfully !");
		environmentPage.verifyUpdatedEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is verified successfully !");
	}
	
	@Test (description="Idle")
	public void environments_03() throws InterruptedException  {	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation","Environment_Utilized_Checkbox","Environment_Utilized_Checkbox_Checked");
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation","Environment_Idle_Checkbox_Checked","Environment_Idle_Checkbox");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.validateElementDisplayed("Environment_Idle_Box", PlutoraConfiguration.environmentData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is verified for idle checkbox successfully !");
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is deleted and verified successfully !");
	}
	@Test (description="Utilized")
	public void environments_04() throws InterruptedException {	
		new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" - Environment group is created successfully !");
		environmentPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		
		releasePage.createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id","Environment_Utilized_Checkbox_Checked","Environment_Utilized_Checkbox");
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id","Environment_Idle_Checkbox","Environment_Idle_Checkbox_Checked");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		
		environmentPage.sleep(1000);
		//environmentPage.validateElementDisplayed("Environment_Utilized_Box", PlutoraConfiguration.environmentData);
		environmentPage.sleep(1000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is verified for Utilized checkbox successfully !");
	}
	@Test (description="Action -> Export to XLS")
	public void environments_05() throws InterruptedException {	
		environmentPage.sleep(3000);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id","Environment_Utilized_Checkbox_Checked","Environment_Utilized_Checkbox");
		environmentPage.selectUtilizedIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id","Environment_Idle_Checkbox_Checked","Environment_Idle_Checkbox");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.sleep(3000);
		environmentPage.clickElementUsingJavaScript("NewEnvironment_Action_Dropdown",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(3000);
		environmentPage.clickElementUsingJavaScript("Environment_ExportToXLS_Button",PlutoraConfiguration.environmentData);
		environmentPage.sleep(5000);
		Listener.addLogger("Environment export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Environments");
		String[] data=FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Environments", 1);
		environmentPage.verifyTextValue("Env_Test_Automation_Id",data[0].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("EG_Automation",data[1].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("Systems_Test_Automation_Id",data[2].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("Environment_Phase_Value",data[3].trim(),PlutoraConfiguration.testData);
		environmentPage.verifyTextValue("Environment_Status_Value",data[6].trim(),PlutoraConfiguration.testData);
		FolderManagementUtilLib.deleteFilesFromFolder(
				System.getProperty("user.dir") + File.separator+ "DownloadFiles" + File.separator);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment export to XLS is verified successfully!");
	}
	
	@Test (description="Environments -> Query Builder (QB) + Quick Access menu")
	public void environments_06() throws InterruptedException, ParseException {
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Env_CustomField_Name");
		environmentPage.sleep(2000);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		environmentPage.sendKeys("NewEnvironment_LiveSearchTextbox", "",PlutoraConfiguration.environmentData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Query_Automation");
		//Add grid selector
		environmentPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Env_CustomField_Name","Action_Button");
		
		//Add new public query
		environmentPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		environmentPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment Name", "equals", "Env_Query_Automation","1");
		environmentPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Query_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Query_Automation")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		//Condition 1
		environmentPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Status", "equals", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Status"),"1","1");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		environmentPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		environmentPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment Name", "equals", "Env_Query_Automation","2");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		environmentPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		environmentPage.sleep(1000);
		environmentPage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_CustomField_Name"), "on","3");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		environmentPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		environmentPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Used for Phase", "equals", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Phase"),"4","4");
		environmentPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//Environment Name
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Query_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("Environment_Field_Text","Environment_Status",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("Environment_Field_Text","Environment_Phase",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(1000);
		//environmentPage.verifyText("Environment_CustomFieldGrid_Text",environmentPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Query_Automation")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Status")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Phase")+"<br>"+
				environmentPage.getTodayDate("0", "dd/MM/yyyy")+"<br>"+
				"verified private query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deletePublicQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Public_Builder");
		environmentPage.deletePrivateQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Private_Builder");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Close_Button", PlutoraConfiguration.objectData);
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_CustomField_Name");
		
	}
	@Test (description="Environments -> View by Date")
	public void environments_07() throws InterruptedException, ParseException {
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PRelease_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.updatePhaseDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Phase_Name"),"0" , "30");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.addViewByDateUtilize(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Env_Test_Automation_Id","0" , "30");
		environmentPage.validateElementDisplayed("Environment_Idle_Box", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment - View by date  - Utlized successfully !");
		
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.addViewByDateIdle(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Env_Test_Automation_Id","31" , "60");
		environmentPage.validateElementDisplayed("Environment_Idle_Box", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment - View by date  - idle successfully !");
	}
	@Test (description="Environments -> View by System Name")
	public void environments_08() throws InterruptedException {
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_ViewBy_Dropdown", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_ViewBy_Dropdown_System_Option", PlutoraConfiguration.objectData);
		
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" view by environment name filtered successfully !");
		environmentPage.verifyTextContains("Environment_ViewBy_SystemName_Text","Systems_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" view by system name filtered successfully !");
	}
	@Test (description="Environments -> View by Environment Group Name")
	public void environments_09() throws InterruptedException {
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
	
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_ViewBy_Dropdown", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_ViewBy_Dropdown_EnvironmentGroup_Option", PlutoraConfiguration.objectData);
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" view by environment group name filtered successfully !");
		environmentPage.verifyTextContains("Environment_ViewBy_EnvironmentGroupName_Text","EG_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" view by environment group name filtered successfully !");
	}
	@Test (description="Action -> Grid Column Selector")
	public void environments_10() throws InterruptedException {
		
		//Create custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvironmentCustomFields_Option","Environment_CustomField_Name");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		//Add grid selector
		environmentPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Environment_CustomField_Name","Action_Button");
		//Verify grid selector
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name")+" verified in environment grid successfully !");
		//Clear grid selector
		environmentPage.clearGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
		//Verify grid selector not available
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name").toUpperCase());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_CustomField_Name").toUpperCase()+" not displayed in environment grid successfully !");
		
		//Delete custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_EnvironmentCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_CustomField_Name");
	}
	@Test (description="Action -> Duplicate Environment")
	public void environments_11() throws InterruptedException {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.createDuplicateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.verifyTextContains("Confirmation_Message","New_ENV_Create_Duplicate_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" duplicated successfully !");
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.deleteDuplicateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" duplicated deleted successfully !");
	}
	
	@Test (description="Metrics")
	public void environments_12() throws InterruptedException {
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Get metrix chart
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_HideIcon","Metrics_ViewIcon", PlutoraConfiguration.objectData,"xpath");
		//Verify metrics 
		environmentPage.validateElementDisplayed("Environment_Metrics_Utilization", PlutoraConfiguration.environmentData);
		environmentPage.validateElementDisplayed("Environment_Metrics_KeyMatrix", PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment Request grid metrics verified successfully!");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Metrics_ViewIcon","Metrics_HideIcon", PlutoraConfiguration.objectData,"xpath");
	}
	@Test (description="Filter by (right top corner)")
	public void environments_13() throws InterruptedException {
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		//Add Stakeholder
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Loggedin_Username_Value","Releases_EStakeholder_Button");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Verify Stakeholder filter by 
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "FilterBy_IamStakeholder_Tab", PlutoraConfiguration.objectData);
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Verified Environment by filter - Stakeholder tab successfully !");
		//Remove Stakeholder
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Loggedin_Username_Value","Releases_Stakeholder_Remove_Button");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Verify Stakeholder filter by 
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "FilterBy_IamStakeholder_Tab", PlutoraConfiguration.objectData);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id"));
		//Click on All filter by 
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "FilterBy_All_Tab", PlutoraConfiguration.objectData);
		environmentPage.verifyText("NewEnvironment_EnvNameLink","Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Verified Environment by filter - All tab successfully !");
	
	}
	@Test (description="Action -> Manage Groups")
	public void environments_14() throws InterruptedException {
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Get manage groups
		environmentPage.clickOnManageGroupsOption(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGroup_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGroup_Automation")+" Created successfully !");
		environmentGroupPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGroup_Automation");
		environmentGroupPage.verifyText("EnvGroups_EnvNameLink", "EnvGroup_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGroup_Automation")+" deleted successfully !");
		environmentGroupPage.closeEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		
	}
}
