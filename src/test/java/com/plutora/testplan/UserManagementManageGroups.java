package com.plutora.testplan;

import org.testng.annotations.Test;

import com.plutora.pagerepo.NewUserPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class UserManagementManageGroups {
	
	NewUserPage userManagement = new NewUserPage();
	
	@Test (description=" -> Add User Group with Users and Roles in it\n" + 
			"Verify Counting in User Group (considering users in both - individuals and roles)")
	public void userManagementManageGroups_01() throws InterruptedException {
		NewUserPage.launchUrl(PlutoraConfiguration.applicationURL);
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "User_ManageGroup_Button", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_AddUserGroups_Button", PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_Save_Button", PlutoraConfiguration.objectData);
		userManagement.validateElementDisplayed("UserManagement_ManageGroups_Validation_Message", PlutoraConfiguration.userManagementData);
		Listener.addLogger(userManagement.getTextData("UserManagement_ManageGroups_Validation_Message", PlutoraConfiguration.userManagementData)+" verified validation message successfully ! ");
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_Hide_Button", PlutoraConfiguration.objectData);
		//Create Group
		userManagement.createGroup(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestGroup","TestGroupDescription");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroupDescription")+" Added usergroup successfully ! ");
		userManagement.addGroupMember(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestGroup");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup")+" Added usergroup members "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group_Member_One")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group_Member_Second")+"successfully ! ");
		
		int i=userManagement.getUserGroupMember(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TestGroup").size();
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "User_ManageGroup_Button", PlutoraConfiguration.objectData);
		userManagement.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_Count").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup")),String.valueOf(i));
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_Save&Close_Button", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup")+" Group Member "+i+" matched successfully !");
	}
	
	@Test (description=" -> Delete User Group")
	public void userManagementManageGroups_02() throws InterruptedException {
		userManagement.gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "User_ManageGroup_Button", PlutoraConfiguration.objectData);
		//Remove User Group 
		userManagement.clickButton("UserManagement_ManageGroups_Row","TestGroup",PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		userManagement.clickOnButton(PlutoraConfiguration.userManagementData, "UserManagement_ManageGroups_RemoveUserGroups_Button", PlutoraConfiguration.objectData);
		
		//Verify User Group
		userManagement.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TestGroup")+" User group removed successfully !");
	}
	
}
