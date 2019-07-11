package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.utils.Listener;

public class TECR  {
	
	TECRPage tecrPage=new TECRPage();
	EnvironmentPage ep = new EnvironmentPage();
	
	@Test(description="TECR Creation")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile"})
	public void createTECR(String environmentData,String tecrData,String testData,String objectData) throws InterruptedException {	
		ep.getTECRDetailsPage(environmentData,objectData);
		tecrPage.creationTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Confirmation_Message","New_TECR_Confirmation_Message",tecrData,testData);
		Listener.addLogger("TECR is created successfully !");
	}
	
	@Test(description="TECR Verification",dependsOnMethods="createTECR")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile"})
	public void verifyTECR(String environmentData,String tecrData,String testData,String objectData) throws InterruptedException {		
		ep.getTECRDetailsPage(environmentData,objectData);
		tecrPage.enterNewlyCreatedTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Name","TECR_Test_Automation_Id",tecrData,testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", tecrData,testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",tecrData,testData);
		//tecrPage.verifyText("TECR_Requestor_Name","Loggedin_Username_Value",tecrData,testData);
		Listener.addLogger("TECR is verified successfully !");
	}
	
	@Test(description="TECR Updation",dependsOnMethods="verifyTECR")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile","platform"})
	public void updateTECR(String environmentData,String tecrData,String testData,String objectData,String platform) throws InterruptedException {	
		ep.getTECRDetailsPage(environmentData,objectData);
		tecrPage.enterNewlyCreatedTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.clickAndUpdateNewlyCreatedTECR(tecrData,testData,objectData,platform,"TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Description","TECR_Description_TextField_Value", tecrData,testData);
		Listener.addLogger("TECR is updated successfully !");
	}
	
	@Test(description="Duplicate TECR",dependsOnMethods="updateTECR")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile"})
	public void duplicateTECR(String environmentData,String tecrData,String testData,String objectData) throws InterruptedException {	
		ep.getTECRDetailsPage(environmentData,objectData);		
		tecrPage.enterNewlyCreatedTECR(tecrData, testData, objectData,"TECR_Test_Automation_Id");
		tecrPage.createDuplicateTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.verifyText("Confirmation_Message","New_TECR_Duplicate_Confirmation_Message",objectData,testData);
		tecrPage.enterNewlyCreatedDuplicateTECR(tecrData, testData, objectData,"TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Name","Copy_TECR_Test_Automation_Id", tecrData,testData);
		tecrPage.verifyText("TECR_Status_Name","TECR_Status", tecrData,testData);
		tecrPage.verifyText("TECR_AssignedTo_Name","TECR_AssignedTo",tecrData,testData);
		//tecrPage.verifyText("TECR_Requestor_Name","Loggedin_Username_Value",tecrData,testData);
		Listener.addLogger("Duplicate TECR is Created & Verified successfully !");
	}
	
	@Test(description="Delete Duplicate TECR",dependsOnMethods="duplicateTECR")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile"})
	public void deleteDuplicateTECR(String environmentData,String tecrData,String testData,String objectData) throws InterruptedException {
		ep.getTECRDetailsPage(environmentData,objectData);
		tecrPage.enterNewlyCreatedDuplicateTECR(tecrData, testData, objectData,"TECR_Test_Automation_Id");
		tecrPage.deleteNewlyCreatedDuplicateTECR(tecrData,testData,"TECR_Test_Automation_Id");
		tecrPage.enterNewlyCreatedDuplicateTECR(tecrData, testData, objectData,"TECR_Test_Automation_Id");
		tecrPage.validateElementDisplayed("TECR_Empty_Text",tecrData);
		Listener.addLogger("Duplicate TECR is deleted successfully !");
	}
	
	@Test(description="TECR Deletion",dependsOnMethods="deleteDuplicateTECR")
	@Parameters({"environmentFile","tecrFile","testDataFile","objectMapFile"})
	public void deleteTECR(String environmentData,String tecrData,String testData,String objectData) throws InterruptedException {	
		ep.getTECRDetailsPage(environmentData,objectData);
		tecrPage.enterNewlyCreatedTECR(tecrData, testData, objectData,"TECR_Test_Automation_Id");
		tecrPage.deleteNewlyCreatedTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.verifyText("TECR_Confirmation_Message","Delete_TECR_Confirmation_Message", tecrData,testData);
		tecrPage.enterNewlyCreatedTECR(tecrData,testData,objectData,"TECR_Test_Automation_Id");
		tecrPage.validateElementDisplayed("TECR_Empty_Text",tecrData);
		Listener.addLogger("TECR is deleted successfully !");
		
	}
}
