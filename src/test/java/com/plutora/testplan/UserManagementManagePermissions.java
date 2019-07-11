package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.NewUserPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class UserManagementManagePermissions {
	
	NewUserPage userManagement = new NewUserPage();
	
	@Test (description=" -> Add Role")
	public void userManagementManagePermissions_01() throws InterruptedException{
		userManagement.refresh(PlutoraConfiguration.objectData);
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Button", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_AddRole_Button", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Role_Save_Button", PlutoraConfiguration.objectData);
		userManagement.validateElementDisplayed("UserManagement_ManagePermissions_Validation_Message", PlutoraConfiguration.userManagementData);
		Listener.addLogger(userManagement.getTextData("UserManagement_ManagePermissions_Validation_Message", PlutoraConfiguration.userManagementData)+" verified validation message successfully ! ");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Hide_Button", PlutoraConfiguration.objectData);
		
		userManagement.createRole(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestRole","TestRoleDescription");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestRole")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestRoleDescription")+" Added user role successfully ! ");
		userManagement.clickButton("UserManagement_ManagePermissions_Role_Row","TestRole" ,PlutoraConfiguration.userManagementData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		userManagement.checkUserPermissionsCheckbox(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestRole");
	}
	
	@Test (description=" -> Delete Role")
	public void userManagementManagePermissions_02() throws InterruptedException  {
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Button", PlutoraConfiguration.objectData);
		userManagement.removeUserRole(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestRole");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Button", PlutoraConfiguration.objectData);
		userManagement.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestRole"));
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManagePermissions_Close_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestRole")+" Not existed in user management page successfully !");
	}
	
}
