package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowEventTab {
	ReleasePage releasePage = new ReleasePage();
	
	@Test (description="Sub-area: release window -> Events tab -> Add/Delete/Update an event")
	public void subareaReleaseWindowEventTab_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.createEvent(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Event_Test_Automation_Id")+" - Event is created successfully !");
		releasePage.verifyText("Releases_Event_Id_Text","Event_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_Event_Name_Text","Event_Test_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Releases_Event_Description_Text","Event_Test_Automation_Description",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Event is verified successfully !");
		releasePage.updateEvent(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Event is updated successfully !");
		releasePage.verifyText("Releases_Event_Type_Text",releasePage.eventDropdownOption,PlutoraConfiguration.releasesData);
		Listener.addLogger("Event is verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	
	@Test(description="Release Implementation Date displaying by default\n" + 
			"(+ Events Date the same by default)")
	public void subareaReleaseWindowEventTab_02() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Implementation_Date",releasePage.getAttributeData(PropertiesCache.getProperty(PlutoraConfiguration.releasesData, "AddRelease_ImplementationDate_Textbox")));
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Event_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextContains("Releases_Event_Date_Text", "Implementation_Date",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Implementation_Date")+" displayed in event details page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	}
	
	
	
}
