package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class ChangesWindowDetailsTab {
	ChangesPage changesPage = new ChangesPage();

	@Test (description="Sub-area: change window -> Details tab -> Lock/Unlock")
	public void subareaChangesDetailsTabExportXls_01() throws InterruptedException, AWTException, ParseException {	
		//Lock Unlock
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Page_Header",PlutoraConfiguration.changesData );
		Listener.addLogger("Selected Change entity window opened.");
		changesPage.getLockedChangePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementNotEnabled("Change_Name_Textfield",PlutoraConfiguration.changesData );
		Listener.addLogger("'Lock sign' closed.  All fields  in Change entity became grayed out (disabled).");
		changesPage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		changesPage.validateElementDisplayed("Change_GridRow_Lock_Icon",PlutoraConfiguration.changesData );
		Listener.addLogger("Change entity closed. User is back on the main 'Change' window. Next to the selected Change entity 'Lock icon' closed and grayed out.");
		changesPage.getOpenChangePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Page_Header",PlutoraConfiguration.changesData );
		changesPage.validateElementDisplayed("Change_Page_Lock_Icon",PlutoraConfiguration.changesData );
		Listener.addLogger("Grayed out Change entity should open. 'Lock sign' on the right top corner is closed.");
		changesPage.getUnLockedChangePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementEnabled("Change_Name_Textfield",PlutoraConfiguration.changesData );
		Listener.addLogger("'Lock sign' opend. All fields in Change entity enabled (available for editing/saving).");
		changesPage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);

	}

	@Test (description="Sub-area: change window -> Details tab -> Linked Changes",dependsOnMethods="subareaChangesDetailsTabExportXls_01")
	public void subareaChangesDetailsTabLinkedChanges_02() throws InterruptedException, AWTException, ParseException {	
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//creating releated parent child changes
		changesPage.createChangeReleateTo(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		
		changesPage.createChangeChildOf(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//linking
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_Page_Header",PlutoraConfiguration.changesData );
		Listener.addLogger("Selected Change entity window opened.");
		changesPage.addRelatesToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.addParentToChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.addChildOfChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	}



}
