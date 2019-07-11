package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.utils.Listener;

public class Systems {

	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage ep = new EnvironmentPage();
	
	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	@Test(description="Systems Creation")
	public void createSystems(String environmentData,String systemsData,String testData,String objectData) throws InterruptedException {	
		ep.getSystemsDetailsPage(environmentData, objectData);
		systemsPage.creationSystems(systemsData,testData,objectData);
		//systemsPage.verifyText("Systems_Confirmation_Message","New_Systems_Confirmation_Message",systemsData,testData);
		Listener.addLogger("Systems is created successfully !");
	}

	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	@Test(description="Systems Verification",dependsOnMethods="createSystems")
	public void verifySystems(String environmentData,String systemsData,String testData,String objectData ) throws InterruptedException {	
		ep.getSystemsPage(environmentData,objectData);
		systemsPage.enterNewlyCreatedSystems(systemsData,testData,objectData,"Systems_Test_Automation_Id");
		systemsPage.verifyText("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		//systemsPage.validateElementDisplayed("Systems_ActiveCheckbox",systemsData);
		Listener.addLogger("Systems is verified successfully !");
	}

	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	@Test(description="Systems Updation",dependsOnMethods="verifySystems")
	public void updateSystems(String environmentData,String systemsData,String testData,String objectData) throws InterruptedException {	
		ep.getSystemsPage(environmentData,objectData);
		systemsPage.enterNewlyCreatedSystems(systemsData,testData,objectData,"Systems_Test_Automation_Id");
		systemsPage.clickAndUpdateNewlyCreatedSystems(systemsData,testData,objectData);
		systemsPage.verifyText("Systems_Shakeholder_Name_Value",SystemsPage.assignedTo,systemsData);
		Listener.addLogger("Systems is updated successfully !");
	}
		
	@Test(description="Duplicate Systems",dependsOnMethods="updateSystems")
	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	public void duplicateSystems(String environmentData,String systemsData,String testData,String objectData) throws InterruptedException {	
		ep.getSystemsPage(environmentData,objectData);
		systemsPage.enterNewlyCreatedSystems(systemsData,testData,objectData,"Systems_Test_Automation_Id");
		systemsPage.createDuplicateSystems(systemsData,testData,objectData);
		systemsPage.verifyText("Confirmation_Message","New_System_Duplicate_Confirmation_Message",objectData,testData);
		systemsPage.enterNewlyCreatedDuplicateSystems(systemsData, testData, objectData);
		systemsPage.verifyText("Systems_Name","Copy_Systems_Test_Automation_Id", systemsData,testData);
		Listener.addLogger("Duplicate System is created successfully !");
	}
	
	@Test(description="Delete Duplicate Systems",dependsOnMethods="duplicateSystems")
	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	public void deleteDuplicateSystems(String environmentData,String systemsData,String testData,String objectData) throws InterruptedException {	
		ep.getSystemsPage(environmentData,objectData);
		systemsPage.enterNewlyCreatedDuplicateSystems(systemsData, testData, objectData);
		systemsPage.deleteNewlyCreatedDuplicateSystems(systemsData,testData, objectData);
		systemsPage.enterNewlyCreatedDuplicateSystems(systemsData, testData, objectData);
		//systemsPage.verifyTextContainsNotDisplayedInPage("Systems_Test_Automation_Id",testData);
		systemsPage.verifyTextContains("System_NoData_Label","No data",systemsData);
		Listener.addLogger("Duplicate TEBR is deleted successfully !");
	}	

	
	@Parameters({"environmentFile","systemsFile","testDataFile","objectMapFile"})
	@Test(description="Systems Deletion",dependsOnMethods="deleteDuplicateSystems")
	public void deleteSystems(String environmentData,String systemsData,String testData,String objectData) throws InterruptedException {
		ep.getSystemsPage(environmentData,objectData);
		systemsPage.enterNewlyCreatedSystems(systemsData,testData,objectData,"Systems_Test_Automation_Id");
		systemsPage.deleteNewlyCreatedSystems(systemsData,testData,objectData);
		//systemsPage.verifyText("Systems_Confirmation_Message","Delete_Systems_Confirmation_Message",systemsData,testData);
		//systemsPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		systemsPage.enterNewlyCreatedSystems(systemsData,testData,objectData,"Systems_Test_Automation_Id");
		systemsPage.sleep(1000);
		systemsPage.verifyTextContains("System_NoData_Label","No data",systemsData);
		Listener.addLogger("Systems is deleted successfully !");
	}
	
}
