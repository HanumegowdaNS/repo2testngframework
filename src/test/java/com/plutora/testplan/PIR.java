package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.pagerepo.PIRPage;
import com.plutora.utils.Listener;

public class PIR {

	PIRPage pirPage = new PIRPage();
	@Parameters({"pirFile","testDataFile","objectMapFile","platform"})
	@Test(description="PIR Creation")
	public void createPIR(String pirData,String testData,String objectData,String platform) throws InterruptedException {	
		pirPage.getPIRDetailsPage(pirData,objectData);
		pirPage.creationPIR(pirData,testData,objectData,platform);
		pirPage.verifyText("PIR_Confirmation_Message","New_PIR_Confirmation_Message", pirData,testData);
		Listener.addLogger("PIR is created successfully !");
	}
	
	@Parameters({"pirFile","testDataFile","objectMapFile"})
	@Test(description="PIR Verification",dependsOnMethods="createPIR")
	public void verifyPIR(String pirData,String testData,String objectData) throws InterruptedException {	
		pirPage.getPIRManagerPage(pirData,objectData);
		pirPage.enterNewlyCreatedPIR(pirData,testData,objectData);
		pirPage.verifyText("PIR_Name","PIR_Test_Automation_Id",pirData,testData);
		pirPage.validateElementDisplayed("PIR_Name_Status","PIR_Test_Automation_Id",pirData,testData);
	//	Common.validatePirElementDisplayed("PIR_Name_Label","New_PIR_Id_Name_Value");
		Listener.addLogger("PIR is verified successfully !");
	}
	@Parameters({"pirFile","testDataFile","objectMapFile"})
	@Test(description="PIR Updation",dependsOnMethods="verifyPIR")
	public void updatePIR(String pirData,String testData,String objectData) throws InterruptedException {	
		pirPage.getPIRManagerPage(pirData,objectData);
		pirPage.enterNewlyCreatedPIR(pirData,testData,objectData);
		pirPage.clickAndUpdateNewlyCreatedPIR(pirData,testData,objectData);
		pirPage.verifyText("PIR_Confirmation_Message","New_PIR_Confirmation_Message",pirData,testData);
		Listener.addLogger("PIR is updated successfully !");
	}
	@Parameters({"pirFile","testDataFile","objectMapFile"})
	@Test(description="PIR Deletion",dependsOnMethods="updatePIR")
	public void deletePIR(String pirData,String testData,String objectData) throws InterruptedException {
		pirPage.getPIRManagerPage(pirData,objectData);
		pirPage.enterNewlyCreatedPIR(pirData,testData,objectData);
		pirPage.deleteNewlyCreatedPIR(pirData,testData,objectData);
		pirPage.sleep(1000);
		pirPage.verifyTextContains("PIR_Confirmation_Message","Delete_PIR_Confirmation_Message",pirData,testData );
		Listener.addLogger("PIR is deleted successfully !");
		
	}
}
