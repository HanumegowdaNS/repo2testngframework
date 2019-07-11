package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.utils.Listener;

public class Environment {
	
	EnvironmentPage ep = new EnvironmentPage();
	
	@Test(description="Environment Create")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_01(String envData, String testData, String objectData) throws InterruptedException {
		ep.gotoEnvironmentPage(envData, objectData);
		ep.createEnvironment(envData, testData, objectData,"Environment_Automation");
//		ep.verifyText("Confirmation_Message","New_ENV_Success_Message",objectData,testData );
		Listener.addLogger("New Environment created successfully | ");
	
	}
	
	@Test(description="Environment Validate")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_02(String envData, String testData, String objectData) throws InterruptedException {
		ep.gotoEnvironmentPage(envData, objectData);
		ep.validateEnvironment(envData, testData, objectData,"Environment_Automation");
		ep.verifyText("NewEnvironment_EnvNameLink","Environment_Automation",envData,testData);
		Listener.addLogger("New Environment validated successfully | ");
		
	}
	
	@Test(description="Environment Update")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_03(String envData, String testData, String objectData) throws InterruptedException {		
		ep.gotoEnvironmentPage(envData, objectData);
		ep.updateEnvironment(envData, testData, objectData);
//		ep.verifyText("Confirmation_Message","New_ENV_Success_Message",objectData,testData);
		Listener.addLogger("New Environment updated successfully | ");
		
	}
	
	@Test(description="Environment Create Duplicate")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_04(String envData, String testData, String objectData) throws InterruptedException {		
		ep.gotoEnvironmentPage(envData, objectData);
		ep.createDuplicateEnvironment(envData, testData, objectData,"Environment_Automation");
		ep.verifyTextContains("Confirmation_Message","New_ENV_Create_Duplicate_Message",objectData,testData);
		Listener.addLogger("New Environment duplicate created successfully | ");
	}
	
	@Test(description="Environment Delete Duplicate")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_05(String envData, String testData, String objectData) throws InterruptedException {		
		ep.gotoEnvironmentPage(envData, objectData);
		ep.deleteDuplicateEnvironment(envData, testData, objectData,"Environment_Automation");
		ep.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",objectData,testData);
		Listener.addLogger("New Environment duplicate deleted successfully | ");
		
	}
	
	@Test(description="Environment Delete")
	@Parameters({"environmentFile","testDataFile","objectMapFile"})
	public void environment_06(String envData, String testData, String objectData) throws InterruptedException {		
		ep.gotoEnvironmentPage(envData, objectData);
		ep.deleteEnvironment(envData, testData, objectData,"Environment_Automation");
		ep.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",objectData,testData);
		Listener.test1.log(Status.INFO,"New Environment deleted successfully | ");
		
	}
}
