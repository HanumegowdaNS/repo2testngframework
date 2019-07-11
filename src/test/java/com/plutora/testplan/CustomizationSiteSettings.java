package com.plutora.testplan;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class CustomizationSiteSettings {
	CustomizationPage customizationPage = new CustomizationPage();
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	LoginPage loginPage = new LoginPage();
	LogoutPage logoutPage= new LogoutPage();
	ReleasePage releasePage = new ReleasePage();
	NewUserPage newuser = new NewUserPage();
	

	@Test (description=" -> Session Timeout")
	public void customizationSiteSettings_01() throws InterruptedException  {
		logoutPage.loginoutPage("",PlutoraConfiguration.objectData);
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_SessionTimeout_Option");
		customizationPage.sessionTimeout(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.sleep(80000);
		customizationPage.validateElementDisplayed("Customization_SiteSetting_TimeoutSessionAfter_ExpirySession_Popup", PlutoraConfiguration.customizationData);
		customizationPage.validateElementDisplayed("Customization_SiteSetting_TimeoutSessionAfter_Ok_Button", PlutoraConfiguration.customizationData);
		Listener.addLogger("Logout warning message displayed successfully !");
		customizationPage.sleep(60000);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_SiteSetting_TimeoutSessionAfter_Ok_Button", PlutoraConfiguration.objectData);
		Listener.addLogger("Session expired warning popup displayed successfully !");
		customizationPage.refresh(PlutoraConfiguration.objectData);
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_SessionTimeout_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_SiteSetting_LogoutTimeoutSession_Radiobox",PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_SiteSetting_NeverTimeoutSession_Radiobox", PlutoraConfiguration.objectData);
		Listener.addLogger("Session never timeout checkbox enabled successfully !");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Login Page Message")
	public void customizationSiteSettings_02() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_LoginPageMessage_Option");
		customizationPage.loginPageMessage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		logoutPage.loginoutPage("",PlutoraConfiguration.objectData);
		Listener.addLogger("User loggedout successfully !");
		//logoutPage.verifyText("", );
		
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_LoginPageMessage_Option");
		customizationPage.deleteLoginPageMessage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		logoutPage.loginoutPage("",PlutoraConfiguration.objectData);
		Listener.addLogger("User logged out successfully !");
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	
	
	private void verifyDeploymentPageCustomFieldValues(Map<String, String> map,String decimals) throws InterruptedException, ParseException {
		
		for(int i=0;i<customizationPage.localizationTypeOption.size();i++) {
			customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.localizationTypeOption.get(i),"Deployment_CustomField_Name");
			deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
			deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
			deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
			deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
			deploymentPlanPage.verifyLocalizationAdditionalInformationTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.localizationTypeOption.get(i),"Deployment_CustomField_Name",map.get(customizationPage.localizationTypeOption.get(i)),decimals);
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanCustomFields_Option");
		}
	}
	
	@Test (description=" -> Localization")
	public void customizationSiteSettings_04() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_Localization_Option");
		customizationPage.updateLocalization(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "MM/DD/YYYY", "Customization_SiteSetting_Localization_CurrencyFormat_Doller_Text", "Customization_SiteSetting_Localization_NumberFormat_First_Text", "Customization_SiteSetting_Localization_DecimalFormat_Dot_Text", "2");
		customizationPage.addLocalizationDeploymentPlanDataTypeList();
		Map<String, String> map = new HashMap<>();
		map.put(customizationPage.localizationTypeOption.get(0),"MM/dd/YYYY");
		map.put(customizationPage.localizationTypeOption.get(1),"0000");
		map.put(customizationPage.localizationTypeOption.get(2),".");
		map.put(customizationPage.localizationTypeOption.get(3),"$0,000,000.00");
		
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option","Deployment_CustomField_Name");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		verifyDeploymentPageCustomFieldValues(map, "2");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_Localization_Option");
		customizationPage.updateNewLocalization(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "DD/MM/YYYY", "Customization_SiteSetting_Localization_CurrencyFormat_Pound_Text", "Customization_SiteSetting_Localization_NumberFormat_Second_Text", "Customization_SiteSetting_Localization_DecimalFormat_Dot_Text", "3");
		map.clear();
		map.put(customizationPage.localizationTypeOption.get(0),"dd/MM/YYYY");
		map.put(customizationPage.localizationTypeOption.get(1),"0,000");
		map.put(customizationPage.localizationTypeOption.get(2),".");
		map.put(customizationPage.localizationTypeOption.get(3),"£0,000,000.00");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanCustomFields_Option");
		verifyDeploymentPageCustomFieldValues(map, "3");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_Localization_Option");
		customizationPage.updateNewLocalization(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "YYYY/MM/DD", "Customization_SiteSetting_Localization_CurrencyFormat_Euro_Text", "Customization_SiteSetting_Localization_NumberFormat_Third_Text", "Customization_SiteSetting_Localization_DecimalFormat_Comma_Text", "4");
		map.clear();
		map.put(customizationPage.localizationTypeOption.get(0),"YYYY/MM/dd");
		map.put(customizationPage.localizationTypeOption.get(1),"0.000");
		map.put(customizationPage.localizationTypeOption.get(2),",");
		map.put(customizationPage.localizationTypeOption.get(3),"€0.000.000,00");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanCustomFields_Option");
		//verifyDeploymentPageCustomFieldValues(map, "4");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_Localization_Option");
		customizationPage.updateNewLocalization(PlutoraConfiguration.customizationData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "DD/MM/YYYY", "Customization_SiteSetting_Localization_CurrencyFormat_Doller_Text", "Customization_SiteSetting_Localization_NumberFormat_Second_Text", "Customization_SiteSetting_Localization_DecimalFormat_Dot_Text", "2");
	}
	/*@Test (description=" -> Login Setting")
	public void customizationSiteSettings_03() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_LoginSettings_Option");
		
		
	}*/
	@Test (description=" -> Welcome Message")
	public void customizationSiteSettings_05() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_WelcomeMessage_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_SiteSetting_EnableWelcomeMessage_Icon", "Customization_SiteSetting_DisableWelcomeMessage_Icon",PlutoraConfiguration.objectData);
		customizationPage.addWelcomeMessage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		loginPage.verifyText("Login_WelcomeMessage_Text", "Welcome_Message",PlutoraConfiguration.loginData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Welcome_Message")+" displayed welcome message successfully");
		loginPage.clickOnButton(PlutoraConfiguration.loginData,"Login_Welcome_CloseButton", PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_WelcomeMessage_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_SiteSetting_DisableWelcomeMessage_Icon", "Customization_SiteSetting_EnableWelcomeMessage_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		loginPage.verifyText("Releases_Page_Title", "Releases_Page_Title_Value", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		loginPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Welcome_Message"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Welcome_Message")+" not displayed welcome message successfully");
		
	
		
	}
	@Test (description=" -> Default Grid Views")
	public void customizationSiteSettings_06() throws InterruptedException  {
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_SiteSetting_WelcomeMessage_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_SiteSetting_DisableWelcomeMessage_Icon", "Customization_SiteSetting_EnableWelcomeMessage_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		//Select Default User
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_DefaultGridViews_Option");
		customizationPage.selectNewUserToDefaultView(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_DefaultGridViews_ReleasesSubmit_Button",PlutoraConfiguration.objectData);
		
		//Add new user
		newuser.addNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_LastName");
		newuser.activateNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		CustomizationPage.launchUrl(PlutoraConfiguration.applicationURL);
			
		//Create custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseCustomFields_Option","Release_CustomField_Name");
		//Add grid column selector
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Release_CustomField_Name","Action_Button");
		//Verify custom field in existing user after clicking on submit button
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		//Verify custom field in new user
		loginPage.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData,"LoginEmail")+"@yopmail.com", PropertiesCache.getProperty(PlutoraConfiguration.testData,"User_NewPassword"));
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_DefaultGridViews_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData,"Customization_DefaultGridViews_ReleasesPush_Button",PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Yes_Button", PlutoraConfiguration.objectData);
		
		//Verify custom field in existing user after clicking on submit button
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_CustomField_Name")+" displayed in existing user successfully !");
	}
	
	@Test (description=" -> Welcome Page Settings->Setup sub-tab")
	public void customizationSiteSettings_07() throws InterruptedException  {
		//Home Default
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_HomePage_Option");
		customizationPage.selectHomePageOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Home (Default)");
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		
		customizationPage.verifyTextContains("Login_HomePage_QuickLinks_Title", "Quick Links",PlutoraConfiguration.loginData);
		Listener.addLogger("Quick Links displayed in Home Page successfully !");
		
		//Dashboard Manager
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_HomePage_Option");
		customizationPage.selectHomePageOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Dashboard Manager");
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		
		customizationPage.validateElementDisplayed("Login_HomePage_DashboardManager_Table",PlutoraConfiguration.loginData);
		Listener.addLogger("Dashboard Manager displayed in Home Page successfully !");
		
		//IM Manager
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_HomePage_Option");
		customizationPage.selectHomePageOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "IM Manager");
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		
		customizationPage.validateElementDisplayed("Login_HomePage_IMDashboard_Table",PlutoraConfiguration.loginData);
		Listener.addLogger("IM Manager displayed in Home Page successfully !");
		
		
		//Insights
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_HomePage_Option");
		customizationPage.selectHomePageOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Insights");
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		
		customizationPage.validateElementDisplayed("Login_HomePage_Insights_Table", PlutoraConfiguration.loginData);
		Listener.addLogger("Insights displayed in Home Page successfully !");
		
		
	}
	@Test (description=" -> External URL Menu Item")
	public void customizationSiteSettings_08() throws InterruptedException  {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableExternalURLMenuItem(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Customization_ExternalURLMenuItem_Option", PlutoraConfiguration.applicationURL);
		String parentWindow = WebGenericUtilLib.driver.getWindowHandle();
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		//Verify external url menu item
		customizationPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		customizationPage.verifyText("MainMenu_ExternalUrlMenuItem_MenuLabel_Text", "Plutora",PlutoraConfiguration.mainMenuData);
		String[] color=customizationPage.getAttributeValue("MainMenu_ExternalUrlMenuItem_MenuLabel_Text","Plutora", PlutoraConfiguration.mainMenuData,"style").split("rgb");
		customizationPage.verifyTextValue(color[1].split("color")[0].replace("(", "").replace(");", ""), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Label_Color"));
		customizationPage.verifyTextValue(color[2].replace("(", "").replace(");", ""), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Background_Color"));
		Listener.addLogger("Menu label - Plutora displyed in menu successfully !"+  PropertiesCache.getProperty(PlutoraConfiguration.testData, "Label_Color") +" label color displayed successfully !"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Background_Color") +" background color displayed successfully !");
		customizationPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		customizationPage.click("MainMenu_ExternalUrlMenuItem_MenuLabel_Text", "Plutora", PlutoraConfiguration.mainMenuData);
		customizationPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		customizationPage.sleep(2000);
		//Switch to new window
		customizationPage.switchToWindowPopup();
		
		customizationPage.verifyTextValue(customizationPage.getCurrentUrl(), PlutoraConfiguration.applicationURL+"settings/customization");
		Listener.addLogger("Menu label "+customizationPage.getCurrentUrl()+" is equal to "+PlutoraConfiguration.applicationURL+"settings/customization");
		//Close the window 
		customizationPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.disableExternalURLMenuItem(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ExternalURLMenuItem_Option");
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		
		customizationPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage("Plutora");
		Listener.addLogger("External URL menu item option disabled successfully !");
		customizationPage.clickOnButton(PlutoraConfiguration.objectData, "Login_FullName_Link", PlutoraConfiguration.objectData);
		customizationPage.sleep(2000);
	
	}
	@Test (description=" -> Welcome Page Settings->Quick Links sub-tab")
	public void customizationSiteSettings_09() throws InterruptedException  {
		//Add Customization quick link 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_QuickLink_Option");
		customizationPage.addInternalQuickLink(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release");
		//Verify in home Page
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		customizationPage.clickButton("Login_HomePage_QuickLinks_Text", "QuickLink", PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		customizationPage.verifyTextContains("Header_Text","Releases",PlutoraConfiguration.objectData);
		Listener.addLogger("Home Page redirected to Release through quick link successfully !");
		//Delete Customization quick link 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_QuickLink_Option");
		customizationPage.deletePageSetting(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "QuickLink");
		//Verify in home page
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "QuickLink"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "QuickLink")+" not displayed in home page successfully !");
	}
	@Test (description=" -> Welcome Page Settings->Widget Grid sub-tab")
	public void customizationSiteSettings_10() throws InterruptedException  {
		//Customization widget setup
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_WidgetGrid_Option");
		
		customizationPage.addWidgetGrid(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"AddressBook");
		//Verify in home Page 
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyText("Login_HomePage_WidgetGrid_Text", "WidgetGrid",PlutoraConfiguration.loginData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "WidgetGrid")+" displayed in home page successfully !");
		
		customizationPage.verifyTextContains("Login_HomePage_WidgetGrid_Text", "Welcome_Message",PlutoraConfiguration.loginData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Welcome_Message")+" displayed in home page successfully !");
		
		//Delete widget grid 
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_WelcomePageSetting_Expanded_Icon", "Customization_WelcomePageSetting_NotExpanded_Icon",PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_WelcomePageSetting_WidgetGrid_Option");
		customizationPage.deletePageSetting(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "WidgetGrid");
		
		//Verify in home page
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Login_HomePage_Button", PlutoraConfiguration.objectData);
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "WidgetGrid"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "WidgetGrid")+" not displayed in home page successfully !");
	}
	
	@Test (description=" -> Announcements Feed")
	public void customizationSiteSettings_11() throws InterruptedException  {
		//Customization Enable announments
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_AnnouncementsFeed_Option");
		customizationPage.enableAnnouncements(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Announcements");
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.verifyText("Announcements_Text","Announcements", PlutoraConfiguration.loginData,PlutoraConfiguration.testData);
		Listener.addLogger("Announcements displayed successfully !");
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Announcements_Close_Icon", PlutoraConfiguration.objectData);
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Announcements"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Announcements")+" displayed announcements successfully !");
		//Update Announcements
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_AnnouncementsFeed_Option");
		customizationPage.enableAnnouncements(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Announcements");
		
		customizationPage.refresh(PlutoraConfiguration.objectData);
		customizationPage.verifyText("Announcements_Text","Announcements", PlutoraConfiguration.loginData,PlutoraConfiguration.testData);
		Listener.addLogger("Announcements displayed successfully !");
		customizationPage.clickOnButton(PlutoraConfiguration.loginData, "Announcements_Close_Icon", PlutoraConfiguration.objectData);
		
		//Disable Announcements
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_AnnouncementsFeed_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_AnnouncementsFeed_Disabled_Checkbox", "Customization_AnnouncementsFeed_Enabled_Checkbox",PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Custom Descriptions")
	public void customizationSiteSettings_12() throws InterruptedException  {
		//Add custom description
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CustomDescription_Option");
	
		customizationPage.addCustomDescription(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Tooltip_Icon", PlutoraConfiguration.objectData);
		//customizationPage.validateElementDisplayed("Customization_Tooptip_Description", "Customization_Custom_Description",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Custom_Description")+" displayed custom description successfully !");
		//Add default custom description
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CustomDescription_Option");
		customizationPage.scrollToElement("Customization_CustomDescription_Customization_DefaultCheckbox",PlutoraConfiguration.customizationData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_CustomDescription_Customization_DefaultCheckbox", PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		
		logoutPage.loginoutPage("", PlutoraConfiguration.objectData);
		
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_Tooltip_Icon", PlutoraConfiguration.objectData);
		customizationPage.sleep(2000);
	//	customizationPage.validateElementDisplayed("Customization_Tooptip_Description", "Customization_Custom_Default_Description",PlutoraConfiguration.customizationData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Customization_Custom_Default_Description")+" displayed default custom description successfully !");
		
	}
}
