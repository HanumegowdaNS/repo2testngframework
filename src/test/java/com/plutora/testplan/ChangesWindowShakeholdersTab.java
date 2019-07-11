package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class ChangesWindowShakeholdersTab {
	ChangesPage changesPage = new ChangesPage();


	@Test (description="Sub-area: changes window -> Stakeholders tab -> Add/edit/delete")
	public void subareaChangesWindowShakeholders_01() throws InterruptedException, AWTException, ParseException {

		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Page_Header_Text","ChangePageHeader",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		Listener.addLogger("Change window opens.");
		changesPage.clickOnShakeholderTab(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Shakeholder_TabPage",PlutoraConfiguration.changesData);
		Listener.addLogger("Stakeholders tab opens.");
		changesPage.clickOnShakeholderNewTab(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Shakeholder_AddNew_Header",PlutoraConfiguration.changesData);
		Listener.addLogger("'Add New Stakeholders' window opens.");
		changesPage.addStakeholderName(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyTextAttributeValue("Change_UserGroupUser_EmailId","Login_Email_Textfield_Value",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("User name and associated e-mail address appears.");
		changesPage.addShakeholderRole(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.isElementPresent("Change_CreatedUserGroup_Row",PlutoraConfiguration.changesData);
		Listener.addLogger("'Role'appears. Stakeholders Role can be customized.");
		changesPage.verifyTextContainsNotDisplayedInPage("ChangeRACICheckIcon",PlutoraConfiguration.testData);
		Listener.addLogger("Stakeholder is saved (without choosing Stakeholder RACI).");
		/*changesPage.addShakeholderUpdate(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.isElementPresent("Change_CreatedUserGroup_R_CheckIcon",PlutoraConfiguration.changesData);
		changesPage.isElementPresent("Change_CreatedUserGroup_A_CheckIcon",PlutoraConfiguration.changesData);
		changesPage.isElementPresent("Change_CreatedUserGroup_C_CheckIcon",PlutoraConfiguration.changesData);
		changesPage.isElementPresent("Change_CreatedUserGroup_I_CheckIcon",PlutoraConfiguration.changesData);
		Listener.addLogger("Tick Icon appeared under Raci Matrix.");
		changesPage.shakeholderAccountableUpdate(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.isElementPresent("Change_PeoplePanel_Accountable_User",PlutoraConfiguration.changesData);
		Listener.addLogger("Last added Accountable Stakeholder appeared in the 'People'panel in the main Change window.");
		changesPage.getShakeholderEditPage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.isElementPresent("Change_Shakeholder_PopupHeader",PlutoraConfiguration.changesData);
		Listener.addLogger("On click of existing shakeholder, all fields can be edited.");*/
		//changesPage.getShakeholderUpdatePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//changesPage.verifyTextContainsDisplayedInPage("ChangeShakeholderSecondRole",PlutoraConfiguration.testData);
		//Listener.addLogger("On click of existing shakeholder, updated amendments are saved.");
		changesPage.getShakeholderRemovedPage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//changesPage.isElementPresent("Change_Shakeholder_EmptyText",PlutoraConfiguration.changesData);
		Listener.addLogger("On click of the remove button, 'Stakeholder' deleted.");
		changesPage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		
	}


}
