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

public class SystemsWindowDependenciesTab {
	ReleasePage releasePage = new ReleasePage();
	NewUserPage newUserPage = new NewUserPage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	List<String> userMember;

	@Test (description="Sub-area: Systems window -> Dependencies tab -> Add/remove Upstream Systems (Drag and Drop)")
	public void subareaSystemsWindowDependenciesTab_01() throws InterruptedException, AWTException, ParseException {	
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"System_Button",PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");

		//releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"System_Button",PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id2");

		//releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.enter();
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.getAddedUpstreamPage(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Save the System
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_SaveButton",PlutoraConfiguration.objectData);
		systemsPage.validateElementDisplayed("Systems_UpstreamDependency_SystemNameTab","Systems_Test_Automation_Id1",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Upstream Systems Dependencies added successfully !");
		systemsPage.validateElementDisplayed("Systems_DownstreamDependency_SystemNameTab","Systems_Test_Automation_Id2",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Downstream Systems Dependencies added successfully !");
		//Remove
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_Dependencies_EditPencil",PlutoraConfiguration.objectData);
		systemsPage.getRemovedUpstreamPage(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//systemsPage.searchSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");
		//Save the System
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_SaveButton",PlutoraConfiguration.objectData);
		//systemsPage.validateElementNotDisplayed("Systems_UpstreamDependency_SystemNameTab","Systems_Test_Automation_Id1",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		//Listener.addLogger("Upstream Systems Dependencies Removed successfully !");
		//systemsPage.searchSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id2");
		//systemsPage.validateElementNotDisplayed("Systems_UpstreamDependency_SystemNameTab","Systems_Test_Automation_Id2",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		systemsPage.scrollDown("Systems_Dependencies_Tab", PlutoraConfiguration.systemsData);
		systemsPage.validateElementDisplayed("System_No_Dependencies_Label", PlutoraConfiguration.systemsData);
		Listener.addLogger("Downstream Systems Dependencies Removed successfully !");
		
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_SaveButton",PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.sleep(2000);
		systemsPage.clickElement("EnvironmentSystem_SystemNameFilter_xoutsign", PlutoraConfiguration.environmentData);
		systemsPage.sleep(2000);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id2");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id2");
		Listener.addLogger("Systems test data deleted successfully !");
		
	}

	@Test (description="Sub-area: release window -> Details tab -> Making system active/inactive")
	public void subareaSystemsWindowDependenciesTab_02() throws InterruptedException, AWTException, ParseException {	
		//active check
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		systemsPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData); 
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.validateElementDisplayed("Systems_Active_Button","Systems_Test_Automation_Id",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Field values are saved. Status saved as 'Active'. On the main grid under 'Active' column checkbox remains ticked next to the system name.");
		//inactive check
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_Status_Button",PlutoraConfiguration.objectData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_SaveButton",PlutoraConfiguration.objectData);
		systemsPage.validateElementDisplayed("Systems_InActive_Button","Systems_Test_Automation_Id",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Field values saved. Status saved as 'Inactive'. On the main grid under 'Active' column checkbox remains unticked next to the system name.");
	}

	@Test (description="Sub-area: release window -> Details tab -> Add/delete Alias(es)")
	public void subareaSystemsWindowDependenciesTab_03() throws InterruptedException, AWTException, ParseException {	

		//alias add
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.getAliasPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.verifyTextContainsDisplayedInPage("Systems_Alias",PlutoraConfiguration.testData);
		Listener.addLogger("'Alias(es)' value is saved successfully !.");
		//alias delete
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.getAliasDeletePage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.verifyTextContainsNotDisplayedInPage("Systems_Alias",PlutoraConfiguration.testData);
		Listener.addLogger("'Alias(es)' value deleted successfully !.");
		
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}


}
