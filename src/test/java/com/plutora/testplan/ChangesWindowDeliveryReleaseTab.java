package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;


public class ChangesWindowDeliveryReleaseTab {
	ChangesPage changePage = new ChangesPage();
	ReleasePage releasePage = new ReleasePage();
	EnvironmentPage environmentPage= new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();

	@Test (description="Sub-area: change window -> Delivery Release tab -> Direct link from the release Actual Delivery Release checkbox")
	public void subareaChangeWindowDeliveryReleaseTab_01() throws InterruptedException, AWTException, ParseException {	
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any 
		systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//changePage.linkSystemReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.searchReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.searchReleaseLinkChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_ActualDelivery_Checkbox","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Direct link from the release (Drag under the Change tab) ->\r\n" + 
				"Actual Delivery Release checkbox checked (only one checkbox to be ticked) successfully !.");
		changePage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		//delete
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		//changePage.deleteSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.environmentData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		Listener.addLogger("Direct link Test Data deleted successfully !.");

	}

	@Test (description="Sub-area: change window -> Delivery Release tab -> Indirect link from the release -> Target Release checkbox")
	public void subareaChangeWindowDeliveryReleaseTab_02() throws InterruptedException, AWTException, ParseException {	
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any 
		systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//changePage.linkSystemReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.searchReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.searchReleaseLinkChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_TargetRelease_Checkbox","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Indirect link from the release (Drag under the Change tab) -> Target Release checkbox checked successfully !.");
		changePage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		//delete
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

	}

	@Test (description="Sub-area: change window -> Delivery Release tab -> Link Release shown on the page by direct link with Change - Actual Delivery Release")
	public void subareaChangeWindowDeliveryReleaseTab_03() throws InterruptedException, AWTException, ParseException {	
		/*Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any 
		systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//changePage.linkSystemReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.searchReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.getCheckDeliveryRelease(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_DeliveryRelease_ActualDelivery_Checkbox");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.navigateToReleaseChange(PlutoraConfiguration.changesData);
		changePage.verifyTextContains("Change_Release_Change_GridLink","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Change is saved as linked to Release and appears in the right grid of linked Changes in Release window.");
		changePage.clickOnChangeCloseIcon(PlutoraConfiguration.changesData);
		//delete
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		changePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	}

	@Test (description="Sub-area: change window -> Delivery Release tab -> Link Release shown on the page by NOT direct link with Change - Target Release checkbox (multiple checkboxes to be ticked)")
	public void subareaChangeWindowDeliveryReleaseTab_04() throws InterruptedException, AWTException, ParseException {	
        //system 1
		/*Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any 
		systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//release 1
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//changePage.linkSystemReleasePage(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Release_Automation_Id");
		releasePage.verifyTextContains("Release_ImpactedSystems_link","Systems_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("System linked to realese 1 successfully !.");
		//changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//release 2
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		changePage.linkSystemToRelease2(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		Listener.addLogger("System linked to release 2 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//change 1
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.searchReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Impact_GridLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System linked to change 1 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//change 2
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_Automation_Id2");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id2");
		changePage.searchReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedReleaseLinkSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Impact_GridLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System linked to change 2 successfully. and linked System appears as linked in both Releases and in Change.");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Checking target release for change 2
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.getCheckDeliveryRelease(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_DeliveryRelease_TargetRelease_Checkbox2");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_TargetRelease_Checkbox2","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Checkbox 'Target Release' is saved as selected next to Release 2 successfully !.");
		System.out.println("Checkbox 'Target Release' is saved as selected next to Release 2 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Checking target release for change 1
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.getCheckDeliveryRelease(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Change_DeliveryRelease_TargetRelease_Checkbox");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_TargetRelease_Checkbox","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Checkbox 'Target Release' is saved as selected next to Release 1 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Unlinking system from change 1
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.openChangeSystemTab(PlutoraConfiguration.changesData);
		changePage.unlinkSystem(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Systems_ImpactedArea_SystemLink", "Change_Systems_Available_Area", "Systems_Test_Automation_Id");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Available_AreaLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System unlinked from Change 1 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Unlinking system from change 2
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id2");
		changePage.openChangeSystemTab(PlutoraConfiguration.changesData);
		changePage.unlinkSystem(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Systems_ImpactedArea_SystemLink", "Change_Systems_Available_Area", "Systems_Test_Automation_Id");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Available_AreaLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System unlinked from Change 2 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//Unlinking system from release 1
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		changePage.openReleaseSystemTab(PlutoraConfiguration.changesData);
		changePage.unlinkSystem(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_ReleaseSystem_CodeImplAreaLink", "Change_Systems_Available_Grid", "Systems_Test_Automation_Id");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Available_GridLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System unlinked from Release 1 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//Unlinking system from release 2
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		changePage.openReleaseSystemTab(PlutoraConfiguration.changesData);
		changePage.unlinkSystem(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_ReleaseSystem_CodeImplAreaLink", "Change_Systems_Available_Grid", "Systems_Test_Automation_Id");
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.verifyTextContains("Change_Systems_Available_GridLink","Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("System unlinked from Release 2 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//verify change 1 delivery tab target release checkbox 
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_TargetRelease_Checkbox","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Target Release checkbox is selected next to Release 1 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//verify change 2 delivery tab target release checkbox 
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id2");
		changePage.getDeliveryReleasePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.verifyTextAttributeClassContains("Change_DeliveryRelease_TargetRelease_Checkbox","DeliveryReleaseClassName",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Target Release checkbox is selected next to Release 2 successfully !.");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		//delete
		changePage.deleteSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.environmentData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id1");
		changePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id2");
		changePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id1");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_Id2");
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		Listener.addLogger("Link Release with Target Release Test Data deleted successfully !.");

	}

}
