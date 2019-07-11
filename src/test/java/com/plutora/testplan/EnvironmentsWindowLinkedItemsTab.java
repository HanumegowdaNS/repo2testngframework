package com.plutora.testplan;


import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentsWindowLinkedItemsTab {
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	
	@Test (description="Viewing/filtering TECR/TEBR")
	public void environmentsWindowLinkedItemsTab_01() throws InterruptedException, ParseException  {	
	
		//System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - System is created successfully !");
		//Env Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","EnvGrp_Automation","System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_One","EnvGrp_Automation","System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_One")+" - Environment is created successfully !");
		//Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Environment_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Create TECR
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation", "Project_Automation","");
		//Create TEBR
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "System_Automation","TEBR_Automation","");
		tebrPage.updateTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "TEBR_Automation","TEBR_Save&CloseButton");
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_LinkedItems_Tab", PlutoraConfiguration.objectData);
		//Verify TECR linked items
		environmentPage.clear("Environment_LinkedItems_Identifier_Textbox", PlutoraConfiguration.environmentData);
		environmentPage.searchLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TECR_Label", "TECR_Automation", "TECR_Status");
		
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TECR_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TECR_Status",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status")+
		" linked items filter verified successfully");
		
		//Verify TEBR linked items
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_LinkedItems_Tab", PlutoraConfiguration.objectData);
		environmentPage.clear("Environment_LinkedItems_Identifier_Textbox", PlutoraConfiguration.environmentData);
		environmentPage.searchLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TEBR_Label", "TEBR_Automation", "TEBR_Status");
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TEBR_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TEBR_Status",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status")+
				" linked items filter verified successfully");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		//Get TECR Number
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Number",environmentPage.getTextData("TECR_Number_Text", "TECR_Automation", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData));
		//Get TEBR Number
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TEBR_Number",environmentPage.getTextData("TEBR_Number_Text", "TEBR_Automation", PlutoraConfiguration.tebrData, PlutoraConfiguration.testData));
		//Environment Page
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_LinkedItems_Tab", PlutoraConfiguration.objectData);
		environmentPage.searchLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TECR_Label", "TECR_Automation", "TECR_Status");
		environmentPage.searchIdentifierLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TECR_Label","TECR_Number");
		
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TECR_Number",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Number")+
				" linked items filter verified successfully");
		
		environmentPage.searchLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TEBR_Label", "TEBR_Automation", "TEBR_Status");
		environmentPage.searchIdentifierLinkedItems(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_LinkedItems_TEBR_Label", "TEBR_Number");
		
		environmentPage.verifyText("Environment_LinkedItems_Name_Text", "TEBR_Number",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Number")+
				" linked items filter verified successfully");
		
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		
	}
	
	
	
}
