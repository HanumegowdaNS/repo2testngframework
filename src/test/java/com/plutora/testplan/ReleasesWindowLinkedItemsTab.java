package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesWindowLinkedItemsTab {
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	TECRPage tecrPage= new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage environmentPage = new EnvironmentPage();

	@Test (description="Sub-area: release window -> Linked Items tab -> Viewing/filtering TECR/TEBR/Deployment Plan")
	public void subareaReleaseWindowLinkedItemsTab_01() throws InterruptedException, ParseException {
		//Create release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Create System
		releasePage.createSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation","Releases_New_SystemsButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - Systems is created successfully !");
		releasePage.searchSystem(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger("Systems is verified successfully !");
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_SystemsName_Section", "Releases_Change_Systems_CodeImplementation_Section", "System_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Systems is drag & dropped to code implementation section successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Create TECR
		environmentPage.getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation", "Project_Automation","");
		//Create TEBR
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "System_Automation","TEBR_Automation","");
		//Create Deployment Plan
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","System_Automation","Project_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		//Verify TECR linked items
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_LinkedItems_Tab", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_LinkedItems_TECR_Label",PlutoraConfiguration.objectData);
		releasePage.clear("Release_LinkedItems_Identifier_Textbox", PlutoraConfiguration.releasesData);
		releasePage.searchLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TECR_Label", "TECR_Automation", "TECR_Status");
		
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TECR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TECR_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status")+
		" linked items filter verified successfully");
		
		//Verify TEBR linked items
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_LinkedItems_Tab", PlutoraConfiguration.objectData);
		releasePage.clear("Release_LinkedItems_Identifier_Textbox", PlutoraConfiguration.releasesData);
		releasePage.searchLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TEBR_Label", "TEBR_Automation", "TEBR_Status");
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TEBR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TEBR_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Status")+
				" linked items filter verified successfully");
		
		//Verify Deployment Plan linked items
		releasePage.searchLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_DeploymentPlan_Label", "Deployment_Automation", "Deployment_Status");
		releasePage.verifyText("Release_LinkedItems_Name_Text", "Deployment_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyText("Release_LinkedItems_Name_Text", "Deployment_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Status")+
				" linked items filter verified successfully");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Get TECR Number
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Number",releasePage.getTextData("TECR_Number_Text", "TECR_Automation", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData));
		//Get TEBR Number
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TEBR_Number",releasePage.getTextData("TEBR_Number_Text", "TEBR_Automation", PlutoraConfiguration.tebrData, PlutoraConfiguration.testData));
		//Release Page
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.searchLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TECR_Label", "TECR_Automation", "TECR_Status");
		releasePage.searchIdentifierLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TECR_Label","TECR_Number");
		
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TECR_Number",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Number")+
				" linked items filter verified successfully");
		
		releasePage.searchLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TEBR_Label", "TEBR_Automation", "TEBR_Status");
		releasePage.searchIdentifierLinkedItems(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_LinkedItems_TEBR_Label", "TEBR_Number");
		
		releasePage.verifyText("Release_LinkedItems_Name_Text", "TEBR_Number",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"</br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Number")+
				" linked items filter verified successfully");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Project_Tab", PlutoraConfiguration.objectData);
		
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);

		
	}
	
	
	
	
}
