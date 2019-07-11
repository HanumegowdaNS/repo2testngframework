package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.utils.Listener;

public class TEBR  {

	TEBRPage tebrPage = new TEBRPage();
	EnvironmentPage ep = new EnvironmentPage();
	
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Creation")
	public void createTEBR(String environmentData,String tebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.creationTEBR(tebrData,testData,objectData,"TEBR_Test_Automation_Id");
		tebrPage.verifyText("TEBR_Confirmation_Message","New_TEBR_Confirmation_Message",tebrData,testData);
		Listener.addLogger("TEBR is created successfully !");
	}
	
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Verification",dependsOnMethods="createTEBR")
	public void verifyTEBR(String environmentData,String tebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.enterNewlyCreatedTEBR(tebrData,testData,objectData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		tebrPage.verifyText("TEBR_Name","TEBR_Test_Automation_Id",tebrData,testData);
		tebrPage.verifyText("TEBR_Status_Name",TEBRPage.status, tebrData);
		tebrPage.verifyText("TEBR_AssignedTo_Name",TEBRPage.assignedTo, tebrData);
		//tebrPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",tebrData,testData);
		Listener.addLogger("TEBR is verified successfully !");
	}
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile","platform"})
	@Test(description="TEBR Updation",dependsOnMethods="verifyTEBR")
	public void updateTEBR(String environmentData,String tebrData,String testData,String objectData ,String platform) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.enterNewlyCreatedTEBR(tebrData,testData,objectData);
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		tebrPage.clickAndUpdateNewlyCreatedTEBR(tebrData,objectData,testData,platform,"TEBR_Test_Automation_Id");
		tebrPage.verifyText("TEBR_Description_Name","TEBR_Description_TextField_Value",tebrData,testData);
		Listener.addLogger("TEBR is updated successfully !");
	}
	
	@Test(description="Duplicate TEBR",dependsOnMethods="updateTEBR")
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile"})
	public void duplicateTEBR(String environmentData,String tebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.enterNewlyCreatedTEBR(tebrData,testData,objectData);
		tebrPage.createDuplicateTEBR(tebrData,testData,objectData,"TEBR_Test_Automation_Id");
		tebrPage.verifyText("Confirmation_Message","New_TEBR_Duplicate_Confirmation_Message",objectData,testData);
		tebrPage.enterNewlyCreatedDuplicateTEBR(tebrData, testData, objectData);
		tebrPage.verifyText("TEBR_Name","Copy_TEBR_Test_Automation_Id", tebrData,testData);
		tebrPage.verifyText("TEBR_Status_Name",TEBRPage.status, tebrData);
		tebrPage.verifyText("TEBR_AssignedTo_Name",TEBRPage.assignedTo, tebrData);
		//tebrPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",tebrData,testData);
		Listener.addLogger("Duplicate TEBR is Created & Verified successfully !");
	}
	
	@Test(description="Delete Duplicate TEBR",dependsOnMethods="duplicateTEBR")
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile"})
	public void deleteDuplicateTEBR(String environmentData,String tebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.enterNewlyCreatedDuplicateTEBR(tebrData, testData, objectData);
		tebrPage.deleteNewlyCreatedDuplicateTEBR(tebrData,testData, objectData);
		tebrPage.enterNewlyCreatedDuplicateTEBR(tebrData, testData, objectData);
		//tebrPage.validateElementDisplayed("TEBR_Empty_Text",tebrData);
		Listener.addLogger("Duplicate TEBR is deleted successfully !");
	}
	
	@Parameters({"environmentFile","tebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Deletion",dependsOnMethods="deleteDuplicateTEBR")
	public void deleteTEBR(String environmentData,String tebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		tebrPage.enterNewlyCreatedTEBR(tebrData,testData,objectData);
		tebrPage.deleteNewlyCreatedTEBR(tebrData,testData,objectData,"TEBR_Test_Automation_Id");
		//WebGenericUtilLib.validateTextInTebrPage("Delete_TEBR_Confirmation_Message", "TEBR_Confirmation_Message");
		tebrPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		//TEBRPage.enterNewlyCreatedTEBR();
		//WebGenericUtilLib.validateTEBREElementDisplayed("TEBR_Empty_Text");
		Listener.addLogger("TEBR is deleted successfully !");
		
	}
}
