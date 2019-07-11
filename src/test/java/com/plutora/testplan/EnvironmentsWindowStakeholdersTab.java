package com.plutora.testplan;


import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentsWindowStakeholdersTab {
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();
	@Test (description="Add/edit/delete")
	public void EnvironmentsWindowStakeholdersTab_01() throws InterruptedException  {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1,"Releases_EStakeholder_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" Environment stakeholder added successfully !");
		environmentPage.sleep(1000);
		environmentPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment stakeholder verified successfully  !");
		new ReleasePage().updateStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Environment stakeholder updated successfully !");
		new ReleasePage().verifyUpdatedShakeholder(PlutoraConfiguration.testData);
		Listener.addLogger("Environment stakeholder verified after updation successfully  !");
		
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name","Releases_Stakeholder_Remove_Button");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name"));
		Listener.addLogger("Environment stakeholder deleted successfully !");
		
		new ReleasePage().updateMultipleStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Releases_EStakeholder_Button");
		environmentPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name_1","Releases_Stakeholder_Remove_Button");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_1"));
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name_2","Releases_Stakeholder_Remove_Button");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_2"));
		
		environmentPage.click("Environment_Details_Tab",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		Listener.addLogger("Environment is deleted successfully !");
		
		/*releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Project Release is deleted successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Enterprise Release is deleted successfully !");
		
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("System is deleted successfully !");
		
		new EnvironmentPage().goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		environmentPage.sleep(2000);
		new EnvironmentGroupsPage().deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		new EnvironmentGroupsPage().clickElementUsingJavaScript("ENVGroups_CloseButton", PlutoraConfiguration.environmentData);
		environmentPage.sleep(2000);
		Listener.addLogger("Environment group is deleted successfully !");*/
		
	}
	
	
	
}
