package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class SystemsWindowDetailsTab {
	ReleasePage releasePage = new ReleasePage();
	ChangesPage changesPage = new ChangesPage();
	SystemsPage systemsPage = new SystemsPage();
	//EnvironmentPage ep = new EnvironmentPage();
	
	@Test (description="Sub-area: systems window -> Details tab -> Stakeholder add/edit/delete")
	public void subareaSystemsWindowDetailsTab_01() throws InterruptedException, AWTException, ParseException {	
		SystemsPage.launchUrl(PlutoraConfiguration.applicationURL);
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		//releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.addStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1,"Releases_EStakeholder_Button");
		systemsPage.clickAndUpdateNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Added shakeholder's successfully !");
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//releasePage.updateStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		systemsPage.updateStakeholderRACI("System_EditStakeHolder_Pencil","System_StakeHolderRACI_grid", PlutoraConfiguration.systemsData);
		// systemsPage.addAccountableStakeholder(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Updated release shakeholder successfully !");
		//releasePage.verifyUpdatedShakeholder(PlutoraConfiguration.testData);
		Listener.addLogger("Verified release shakeholder successfully !");
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.deleteStakeholder("System_deleteStakeHolder_TrashCan","System_StakeHolderRACI_grid", PlutoraConfiguration.systemsData);
		//changesPage.getShakeholderRemovedPage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//changesPage.isElementPresent("Change_Shakeholder_EmptyText",PlutoraConfiguration.changesData);
		Listener.addLogger("On click of the remove button, 'Stakeholder' deleted.");
		System.out.println("On click of the remove button, 'Stakeholder' deleted.");
		//changesPage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		//systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);

	}

	/*@Test (description="Sub-area: release window -> Details tab -> Making system active/inactive",dependsOnMethods="subareaSystemsWindowDetailsTab_01")
	public void subareaSystemsWindowDetailsTab_02() throws InterruptedException, AWTException, ParseException {	
		//active check
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemsPage.validateElementSelected("Systems_Active_Button","Systems_Test_Automation_Id",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Field values are saved. Status saved as 'Active'. On the main grid under 'Active' column checkbox remains ticked next to the system name.");
		//inactive check
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_InActive_Button",PlutoraConfiguration.objectData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData,"Systems_Save&CloseButton",PlutoraConfiguration.objectData);
		systemsPage.validateElementNotSelected("Systems_Active_Button","Systems_Test_Automation_Id",PlutoraConfiguration.systemsData,PlutoraConfiguration.testData);
		Listener.addLogger("Field values saved. Status saved as 'Inactive'. On the main grid under 'Active' column checkbox remains unticked next to the system name.");
	}*/

	/*@Test (description="Sub-area: release window -> Details tab -> Add/delete Alias(es)",dependsOnMethods="subareaSystemsWindowDetailsTab_02")
	public void subareaSystemsWindowDetailsTab_03() throws InterruptedException, AWTException, ParseException {	
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//alias add
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.getAliasPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.verifyTextContainsDisplayedInPage("Systems_Alias_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("'Alias(es)' value is saved successfully !.");
		//alias delete
		systemsPage.getAliasDeletePage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.openSystemPage(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		systemsPage.verifyTextContainsNotDisplayedInPage("Systems_Alias_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("'Alias(es)' value deleted successfully !.");
		changesPage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}*/


}
