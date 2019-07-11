package com.plutora.testplan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReacttebrPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class Reacttebr  {

	ReacttebrPage reactTEBRPage = new ReacttebrPage();
	EnvironmentPage ep = new EnvironmentPage();
	
	@Parameters({"environmentFile","reacttebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Creation")
	public void createTEBR(String environmentData,String reacttebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		reactTEBRPage.creationTEBR(reacttebrData,testData,objectData,"TEBR_React_Test_Automation_Id");
		// reactTEBRPage.verifyText("TEBR_Confirmation_Message","New_TEBR_Confirmation_Message",reactTebrData,testData);
		Listener.addLogger("TEBR is created successfully !");
	}

	@Parameters({"environmentFile","reacttebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Verification", dependsOnMethods="createTEBR")
	public void verifyTEBR(String environmentData,String reacttebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		reactTEBRPage.enterNewlyCreatedTEBR(reacttebrData,testData,objectData, "TEBR_React_Test_Automation_Id");
		reactTEBRPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		reactTEBRPage.verifyText("TEBR_Name","TEBR_React_Test_Automation_Id",reacttebrData,testData);
		Thread.sleep(2000);
		//TODO after full implementation is done 
		//reactTEBRPage.verifyText("TEBR_Status_Name",ReactTEBRPage.status, reactTebrData);
		reactTEBRPage.verifyText("TEBR_AssignedTo_Name",ReacttebrPage.assignedTo, reacttebrData);
		//TODO after full implementation is done
		//ReactTEBRPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",reactTebrData,testData);
		Listener.addLogger("TEBR is verified successfully !");
	}
	
	@Parameters({"environmentFile","reacttebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Updation",dependsOnMethods="verifyTEBR")
	public void updateTEBR(String environmentData,String reacttebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		reactTEBRPage.enterNewlyCreatedTEBR(reacttebrData,testData,objectData, "TEBR_React_Test_Automation_Id");
		reactTEBRPage.clickAndUpdateNewlyCreatedTEBR(reacttebrData,objectData,testData,"TEBR_React_Test_Automation_Id");
		Assert.assertEquals(reactTEBRPage.getTextData("AddTEBR_DescriptonTextfield", reacttebrData),"Update_React_TEBR_Description_Value");
		Listener.addLogger("TEBR is updated successfully !");
	}


	@Test(description="Duplicate TEBR",dependsOnMethods="updateTEBR")
	@Parameters({"environmentFile","reacttebrFile","testDataFile","objectMapFile"})
	public void duplicateTEBR(String environmentData,String reacttebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		reactTEBRPage.enterNewlyCreatedTEBR(reacttebrData,testData,objectData, "TEBR_React_Test_Automation_Id");
		reactTEBRPage.createDuplicateTEBR(reacttebrData,testData,objectData,"TEBR_React_Test_Automation_Id");
		//TODO after full implementation is done
		// reactTEBRPage.verifyText("Confirmation_Message","New_TEBR_Duplicate_Confirmation_Message",objectData,testData);
		reactTEBRPage.enterNewlyCreatedDuplicateTEBR(reacttebrData, testData, objectData);
		reactTEBRPage.verifyText("TEBR_Name","Copy_TEBR_React_Test_Automation_Id", reacttebrData,testData);
		//TODO after full implementation is done
		// reactTEBRPage.verifyText("TEBR_Status_Name", reactTEBRPage.status, reactTebrData);
		reactTEBRPage.verifyText("TEBR_AssignedTo_Name", ReacttebrPage.assignedTo, reacttebrData);
		//TODO after full implementation is done
		// reactTEBRPage.verifyText("TEBR_Requestor_Name","Loggedin_Username_Value",reactTebrData,testData);
		Listener.addLogger("Duplicate TEBR is Created & Verified successfully !");
	}
}	


/*
//TODO Delete after the React TEBR is working from the Action button.  
	
	@Test(description="Delete Duplicate TEBR",dependsOnMethods="duplicateTEBR")
	@Parameters({"environmentFile","ReactTebrFile","testDataFile","objectMapFile"})
	public void deleteDuplicateTEBR(String environmentData,String reactTebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		reactTEBRPage.enterNewlyCreatedDuplicateTEBR(reactTebrData, testData, objectData);
		reactTEBRPage.deleteNewlyCreatedDuplicateTEBR(reactTebrData,testData, objectData);
		reactTEBRPage.enterNewlyCreatedDuplicateTEBR(reactTebrData, testData, objectData);
		//ReactTEBRPage.validateElementDisplayed("TEBR_Empty_Text",reactTebrData);
		Listener.addLogger("Duplicate TEBR is deleted successfully !");
	}
}

 	@Parameters({"environmentFile","ReactTebrFile","testDataFile","objectMapFile"})
	@Test(description="TEBR Deletion",dependsOnMethods="deleteDuplicateTEBR")
	public void deleteTEBR(String environmentData,String reactTebrData,String testData,String objectData) throws InterruptedException {	
		ep.getTEBRDetailsPage(environmentData,objectData);
		ReactTEBRPage.enterNewlyCreatedTEBR(reactTebrData,testData,objectData);
		ReactTEBRPage.deleteNewlyCreatedTEBR(reactTebrData,testData,objectData,"TEBR_Test_Automation_Id");
		//WebGenericUtilLib.validateTextInReactTEBRPage("Delete_TEBR_Confirmation_Message", "TEBR_Confirmation_Message");
		ReactTEBRPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		//ReactTEBRPage.enterNewlyCreatedTEBR();
		//WebGenericUtilLib.validateTEBREElementDisplayed("TEBR_Empty_Text");
		Listener.addLogger("TEBR is deleted successfully !");
		
	}
	*/

