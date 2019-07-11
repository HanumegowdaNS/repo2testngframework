package com.plutora.testplan;


import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentRequestTECRLinkedChangeTab {
	
	TECRPage tecrPage = new TECRPage();
	ChangesPage changePage = new ChangesPage();
	
	
	@Test (description=" Linked Change Tab -> Live Search by name")
	public void subareaEnvironmentRequestTECRChangeTab_01() throws InterruptedException {	
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" - Change is created successfully !");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		tecrPage.clickButton("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Linked_Change_Tab",PlutoraConfiguration.objectData);
		tecrPage.sendKeysWithEnter("TECR_Linked_Change_Search", "Change_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		tecrPage.verifyTextValue(tecrPage.getTextData("TECR_Linked_Change_Text","Change_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData).split("\\n")[1].trim(),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" Change verified from TECR live search successfully!");
		
	}
	

	@Test (description=" Linked Change Tab -> Drag and drop")
	public void subareaEnvironmentRequestTECRChangeTab_02() throws InterruptedException {	
		//Verify TECR linked to change
		tecrPage.dragAndDrop("TECR_Linked_Change_Text", "TECR_Linked_Change_Drop_Section", "Change_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.verifyTextValue(tecrPage.getTextData("TECR_Linked_Dropped_Change_Text","Change_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData).split("\\n")[1].trim(),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id"));
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Save&CloseButton",PlutoraConfiguration.objectData);
		tecrPage.clickButton("TECR_Name","TECR_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.verifyTextValue(tecrPage.getTextData("TECR_Linked_Dropped_Change_Text","Change_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData).split("\\n")[1].trim(),PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id"));
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData,"TECR_Save&CloseButton",PlutoraConfiguration.objectData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" Change linked TECR successfully!");
		
		//Delete Change
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		changePage.deleteChange(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		Listener.addLogger("Change is deleted successfully!");
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
	}
	
	
}
