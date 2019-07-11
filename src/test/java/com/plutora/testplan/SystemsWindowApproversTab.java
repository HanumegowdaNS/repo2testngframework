package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import java.util.List;

import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class SystemsWindowApproversTab {
	ReleasePage releasePage = new ReleasePage();
	NewUserPage newUserPage = new NewUserPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();
	List<String> userMember;


	@Test (description="Sub-area: Systems window -> My Env. Booking Approvers tab")
	public void subareaSystemsWindowApproversTab_01() throws InterruptedException, AWTException, ParseException {	
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		// releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.getApproversAddPage(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		systemsPage.validateElementDisplayed("Systems_AddedUser_Text",SystemsPage.approvers,PlutoraConfiguration.systemsData);
		Listener.addLogger(" System Approvers 'Users' combo box added user name successfully !");
		
		}



}
