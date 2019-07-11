package com.plutora.testplan;

import java.text.ParseException;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class UserManagement {
	
	NewUserPage userManagement = new NewUserPage();
	LoginPage login = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description=" -> Search/Clear")
	public void userManagement_01() throws InterruptedException{
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
		userManagement.validateElementDisplayed("NewUser_SearchResultFirstName","UserManagement_Username",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username")+"  results matched with the search criteria successfully !");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_Clear_Button", PlutoraConfiguration.objectData);
		userManagement.verifyTextAttributeValue("NewUser_LiveSearchTextbox", "",PlutoraConfiguration.userManagementData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username")+"  results disappeared after clicking on clear button successfully !");
	}
	
	@Test (description=" -> Add New User (+registration via yopmail)")
	public void userManagement_02() throws InterruptedException  {
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.addNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_LastName");
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName");
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_FirstName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);

		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		userManagement.activateNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		login.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData,"LoginEmail")+"@yopmail.com", PropertiesCache.getProperty(PlutoraConfiguration.testData,"User_NewPassword"));
		//Logout the user
		login.waitForLoadingIconDisappear(1000, "Loading_Gif",PlutoraConfiguration.objectData);
		login.sleep(4000);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		login.sleep(1000);
		
		login.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);
		login.waitForLoadingIconDisappear(100, "Loading_Gif",PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Feature 'Valid until' for User account ")
	public void userManagement_03() throws InterruptedException, ParseException  {
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);

		login.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);
		login.waitForLoadingIconDisappear(100, "Loading_Gif",PlutoraConfiguration.objectData);
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName");
		userManagement.inactiveUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		login.loginWithNewPassword(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,NewUserPage.loginEmail,"User_NewPassword");
		
		String loggedinUsername = login.userFullName("NewUser_FirstName","NewUser_LastName",PlutoraConfiguration.testData);
		login.verifyTextEqualsNotDisplayedInPage(loggedinUsername);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "User_NewPassword")+" New User account got disabled !");
		LoginPage.launchUrl(PlutoraConfiguration.applicationURL);
		login.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		login.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName");
		userManagement.activeUser(PlutoraConfiguration.userManagementData,  PlutoraConfiguration.objectData);
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		login.loginWithNewPassword(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,NewUserPage.loginEmail,"User_NewPassword");
		Listener.addLogger("New User logged in with new password successfully | ");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		userManagement.sleep(2000);
		
		login.loginPage(PlutoraConfiguration.loginData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		login.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "NewUser_SearchedEditButton", PlutoraConfiguration.objectData);
		userManagement.validUntil(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Reassign Assignee (each checkbox should be verified)")
	public void userManagement_04() throws InterruptedException, ParseException  {
		releasePage.refresh(PlutoraConfiguration.objectData);
		//Release Creation & System Linked to release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation","Project_Automation_Name","0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" -  added release successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName","Releases_StakeholderButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_FirstName")+" -  added stakeholder successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.addNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_SecondName","NewUser_SecondLastName");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_SecondName")+" -  added user successfully !");
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_SecondName");
		//userManagement.resetPassword(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		//userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.reassignAssignee(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_SecondName","");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_SecondName"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_SecondName")+" - user assigned in entities successfully !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Activity_1","Activity_Test_Automation_Name");
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Activity_2","Activity_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_2")+" - activities added successfully !");
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Activity_1");
		releasePage.changeDueDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "-2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_1")+" - activities due date less than current date added successfully !");
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Activity_2");
		releasePage.changeDueDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_2")+" - activities due date greater than current date added successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.reassignAssignee(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_SecondName","Activity");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		boolean flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_1")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_SecondName")+"')]")).isDisplayed();
		assertTrue(flag);
		flag = ReleasePage.driver.findElement(By.xpath("//a[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Activity_2")+"']/ancestor::td/following-sibling::td[@data-columnid='activityAssignedToColumn']//div[contains(text(),'"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_SecondName")+"')]")).isDisplayed();
		assertTrue(flag);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Grid Column Filtering (GCF)")
	public void userManagement_05() throws InterruptedException  {
		
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.addNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName","NewUser_LastName");
		//Clear filtering 
		userManagement.sleep(2000);
		userManagement.clickMultipleElement("UserManagement_FirstName_CloseIcon",PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_LastName_CloseIcon", PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_Email_CloseIcon",PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_PortfolioAssociation_CloseIcon", PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		
		userManagement.readNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"NewUser_FirstName");
		//first name 
		userManagement.sendKeysWithEnter("UserManagement_FirstName_Textbox", "NewUser_FirstName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_FirstName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_FirstName")+" verified firstname successfully !");
		//last name
		userManagement.sendKeysWithEnter("UserManagement_LastName_Textbox", "NewUser_LastName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_LastName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_LastName")+" verified lastname successfully !");
		
		//email
		userManagement.sendKeys("UserManagement_EmailName_Textbox",NewUserPage.loginEmail,PlutoraConfiguration.userManagementData);
		userManagement.enter();
		userManagement.verifyText("NewUser_SearchResultFirstName",NewUserPage.loginEmail.toLowerCase(),PlutoraConfiguration.userManagementData);
		Listener.addLogger(NewUserPage.loginEmail+" verified email successfully !");
		
		//Portfolio association
		userManagement.click("UserManagement_PortfolioAssociation_Dropdown", PlutoraConfiguration.userManagementData);
		userManagement.clickButton("UserManagement_PortfolioAssociation_Dropdown_Option", "Company_Organization_Name", PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.click("UserManagement_PortfolioAssociation_Dropdown", PlutoraConfiguration.userManagementData);
		userManagement.enter();
		userManagement.verifyText("NewUser_SearchResultFirstName","Company_Organization_Name",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Company_Organization_Name")+" verified portfolio association successfully !");
		
		userManagement.clickMultipleElement("UserManagement_FirstName_CloseIcon",PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_LastName_CloseIcon", PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_Email_CloseIcon",PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		userManagement.clickMultipleElement("UserManagement_PortfolioAssociation_CloseIcon", PlutoraConfiguration.userManagementData,PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Query Builder (QB) + Quick Access menu")
	public void userManagement_06() throws InterruptedException  {
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		userManagement.sendKeys("NewUser_LiveSearchTextbox", "",PlutoraConfiguration.userManagementData);
		//Add new public query
		userManagement.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		userManagement.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "First Name", "equals", "NewUser_FirstName","1");
		userManagement.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
		//Verify Release in current account
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_FirstName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_FirstName")+" verified public query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify Release in different account
		login.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.sendKeys("NewUser_LiveSearchTextbox", "",PlutoraConfiguration.userManagementData);
		userManagement.sleep(2000);
		userManagement.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Public_Builder")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		login.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		//Add new private query
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		//Condition 1
		userManagement.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "First Name", "equals", "NewUser_FirstName","1");
		userManagement.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);

		//Condition 2
		userManagement.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		userManagement.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Last Name", "equals", "NewUser_LastName","2");
		userManagement.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 3 
		userManagement.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		userManagement.addEmailQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Email", "equals", NewUserPage.loginEmail,"3");
		userManagement.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		//Condition 4
		userManagement.addCondition(PlutoraConfiguration.objectData, "And",  "4");
		userManagement.addOrganizationQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Portfolio Association", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Company_Organization_Name"),"4","4");
		userManagement.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
		//TEBR Name
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_FirstName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		userManagement.verifyText("NewUser_SearchResultFirstName","NewUser_LastName",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		userManagement.sleep(2000);
		userManagement.verifyText("NewUser_SearchResultFirstName",NewUserPage.loginEmail.toLowerCase(),PlutoraConfiguration.userManagementData);
		userManagement.verifyText("NewUser_SearchResultFirstName","Company_Organization_Name",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_FirstName")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "NewUser_LastName")+"<br>"+
				NewUserPage.loginEmail+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Company_Organization_Name")+"<br>"+
				"verified private query builder successfully !");
		
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		//Verify usermanagement in different account
		login.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		//Add new private query
		login.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.deletePublicQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Public_Builder");
		userManagement.deletePrivateQuery(PlutoraConfiguration.objectData, PlutoraConfiguration.testData, "Query_Private_Builder");
		userManagement.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_Close_Button", PlutoraConfiguration.objectData);
		
	}
	@Test (description=" -> Delete User")
	public void userManagement_07() throws InterruptedException  {
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.deleteNewUser(PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		userManagement.verifyText("NewUser_Confirmation_Message","New_User_Success_Message",PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData);
		Listener.addLogger("User deleted successfully !");
	}
	@Test (description=" -> Send Broadcast Notification")
	public void userManagement_08() throws InterruptedException  {
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.sendBroadcast(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Testing Send broadcast Message", "UserGroup_Name", "Verify Send broadcast Message");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Broadcast_Message","Testing Send broadcast Message");
		customizationPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Broadcast_Message", PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserManagement_Username"));
		customizationPage.switchToDefaultContent();
		customizationPage.switchToFrameByElement("Yopmail_Inbox_IFrame",PlutoraConfiguration.objectData);
		CustomizationPage.driver.findElement(By.xpath("(//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "UserGroup_Name")+"']/../following-sibling::span)[1][text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Broadcast_Message")+"']")).isDisplayed();
		customizationPage.switchToDefaultContent();
		NewUserPage.launchUrl(PlutoraConfiguration.applicationURL);
		customizationPage.sleep(2000);
	}
	
}
