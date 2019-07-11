package com.plutora.testplan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRItemWindowItemPMARCI {
	PIRPage pirPage = new PIRPage();
	ReleasePage releasePage = new ReleasePage();

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Add/edit/delete PM, A, RC, I ")
	public void subareaPIRItemManagerPMARCI_01() throws InterruptedException, ParseException {	
		//Add PM
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new PM added successfully !");
		//Edit PM
		pirPage.getPIRPMUpdatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new PM updated successfully !");
		//Delete PM
		pirPage.getPIRPMDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Item_PM_Automation_Summary",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Item new PM deleted successfully !");
		//Add Action
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Action_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Action added successfully !");
		//Edit Action
		pirPage.getPIRActionUpdatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Action_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Action updated successfully !");
		//Delete Action
		pirPage.getPIRActionDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Item_Action_Automation_Summary",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Item new Action deleted successfully !");
		//Add RC
		pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_RC_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new RC added successfully !");
		//Edit RC
		pirPage.getPIRRCUpdatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_RC_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new RC updated successfully !");
		//Delete RC
		pirPage.getPIRRCDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Item_RC_Automation_Summary",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Item new RC deleted successfully !");
		//Add Impact
		pirPage.getPIRImpactCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Impact_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Impact added successfully !");
		//Edit Impact
		pirPage.getPIRImpactUpdatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Impact_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Impact updated successfully !");
		//Delete Impact
		pirPage.getPIRImpactDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Item_Impact_Automation_Summary",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Item new Impact deleted successfully !");

	}

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Add 'Impacted Systems' via 'PM' 'Systems' field ")
	public void subareaPIRItemManagerPMARCI_02() throws InterruptedException, ParseException {	
		//Add PM
		String pmSystemName=pirPage.getPIRPMAddedSystem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_ImpactedSystems1_Text",pmSystemName,PlutoraConfiguration.pirData);
		Listener.addLogger("The systems added in 'System' field appeared in 'Impacted Systems' field as well successfully !");
	}

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Ability to change status")
	public void subareaPIRItemManagerPMARCI_03() throws InterruptedException, ParseException {	
		//Add PM system
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMStatusEditPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String pmStatusName=pirPage.getPIRPMAddedStatus(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextAttributeValue("PIR_Item_PM_Status_Text",pmStatusName,PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to changed status successfully !");
	}

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Ability to add/edit/delete 'Assigned To' value")
	public void subareaPIRItemManagerPMARCI_04() throws InterruptedException, ParseException {	
		//Added user
		pirPage.getPIRPMAssigneedToPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action_Status_Option1");
		String pmAssignedToName=pirPage.getPIRPMAddedAssinedTo(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_AssignedTo_Text",pmAssignedToName,PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to added assigned to value successfully !");
		//Edit user
		pirPage.getPIRPMAssigneedToDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMAssigneedToPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action_Status_Option2");
		pmAssignedToName=pirPage.getPIRPMAddedAssinedTo(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_AssignedTo_Text",pmAssignedToName,PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to edited assigned to value successfully !");
		//delete user
		pirPage.getPIRPMAssigneedToDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextAttributeValue("PIR_Item_Action_Assignee_Textbox", "",PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to deleted assigned to value successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
	}

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Ability to add/edit/delete 'Assign to Future Release/Project' value")
	public void subareaPIRItemManagerPMARCI_05() throws InterruptedException, ParseException {	
		//Add environment data
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		//Add Assign to Future Release/Project
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMFeatureReleasePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String pmReleaseName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Item_PM_SearchedReleases_Text");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_SearchedReleases_Text",pmReleaseName,PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to added 'Assign to Future Release/Project' value successfully !");
		//Edit Assign to Future Release/Project
		pirPage.getPIRPMReleaseDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMProjectAddPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		pmReleaseName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Item_PM_SearchedReleases_Text");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_SearchedReleases_Text",pmReleaseName,PlutoraConfiguration.pirData);
		Listener.addLogger("User is able to edited 'Assign to Future Release/Project' value successfully !");
		//delete Assign to Future Release/Project
		pirPage.getPIRPMReleaseDeletePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage(pmReleaseName);
		Listener.addLogger("User is able to deleted 'Assign to Future Release/Project' value successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);

	}

	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Traffic Lighting Status on A/PM")
	public void subareaPIRItemManagerPMARCI_06() throws InterruptedException, ParseException {	

		//Add Traffic Lighting Status on A/PM
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPMPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRPMTrafiLightningPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String statusColor = pirPage.getPIRPMAttributeValue(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextValue("PIRItemPMStatusColor",statusColor,PlutoraConfiguration.testData);
		String statusFontColor = pirPage.getPIRPMFontColorValue(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextValue("PIRItemPMStatusFontColor",statusFontColor,PlutoraConfiguration.testData);
		Listener.addLogger("A PM Due Date is in the past, and entity has not been completed yet, then Status color replaced with red background and white font color successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&ExitButton");
		//delete pir
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation_Summary");
		pirPage.sleep(1000);
		//delete release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//delete project release
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Item test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
		
	}
	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> General appearance and functionality")
	public void subareaPIRItemManagerPMARCI_07() throws InterruptedException, ParseException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		//PM
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new PM added successfully !");
		//Action
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Action_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Action added successfully !");
		//RC
		pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_RC_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new RC added successfully !");
		//PIR Impact 
		pirPage.getPIRImpactCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Impact_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Impact added successfully !");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//PM status change
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_PM_Automation_Summary","Open","PIR_Item_PM_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_PM_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Open']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_PM_Automation_Summary","In-Progress","PIR_Item_PM_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_PM_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='In-Progress']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_PM_Automation_Summary","Closed","PIR_Item_PM_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_PM_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Closed']")).isDisplayed();
	
		//Action status change
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_Action_Automation_Summary","Open","PIR_Item_Action_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Open']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_Action_Automation_Summary","In-Progress","PIR_Item_Action_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='In-Progress']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_Action_Automation_Summary","Closed","PIR_Item_Action_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Action_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Closed']")).isDisplayed();
		
		//RC Status change
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_RC_Automation_Summary","Open","PIR_Item_RC_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_RC_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Open']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_RC_Automation_Summary","In-Progress","PIR_Item_RC_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_RC_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='In-Progress']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_RC_Automation_Summary","Closed","PIR_Item_RC_Status_Dropdown");
		PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_RC_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Closed']")).isDisplayed();
		
		//Impact status change
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_Impact_Automation_Summary","Customer","PIR_Item_Impact_Type_Dropdown");
	//	PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Impact_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Customer']")).isDisplayed();
		
		pirPage.updatePIRItemStatusActions(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_RootCauseAction_RadioButton","PIR_Item_Action_RadioButton","PIR_Item_Impact_Automation_Summary","Functional","PIR_Item_Impact_Type_Dropdown");
		//PIRPage.driver.findElement(By.xpath("//span[text()='"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Item_Impact_Automation_Summary")+"']/ancestor::td/following-sibling::td//div[text()='Functional']")).isDisplayed();
		
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Delete PIR Item
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_Automation");
		
		
	}
	@Test (description="Sub-area: PIR Item window -> (PM), (A), (RC) and (I) -> Ability to comment PM, A, RC, I  ")
	public void subareaPIRItemManagerPMARCI_08() throws InterruptedException, ParseException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		//PM
		pirPage.getPIRPMCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_PM_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new PM added successfully !");
		//Action
		pirPage.getPIRActionCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Action_Automation_Summary");
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Action_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Action added successfully !");
		//RC
		pirPage.getPIRRCCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_RC_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new RC added successfully !");
		//PIR Impact 
		pirPage.getPIRImpactCreatePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_PM_Header_Text","PIR_Item_Impact_Automation_Summary",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Item new Impact added successfully !");
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//PM status change
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
		List<String> actionName= new ArrayList<String>();
		actionName.add("PIR_Item_PM_Automation_Summary");
		actionName.add("PIR_Item_Action_Automation_Summary");
		actionName.add("PIR_Item_RC_Automation_Summary");
		actionName.add("PIR_Item_Impact_Automation_Summary");
		
		
		for(int i=0;i<actionName.size();i++) {
		
			pirPage.clickOnPIRItemActions(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Item_RootCauseAction_RadioButton", "PIR_Item_Action_RadioButton", actionName.get(i));
			pirPage.addPIRItemComments(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Comments");
			pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Comments")+" verified successfully !");
			//Edit PIR Item Comment
			pirPage.editPIRItemComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Comments");
			pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Comments")+" verified successfully !");
			//Reply PIR Item Comment
			pirPage.replyPIRItemComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Reply_Comments");
			pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Reply_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Reply_Comments")+" replyed message verified successfully !");
			pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		}
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		//Delete PIR item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Automation");
	}
}
