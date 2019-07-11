package com.plutora.testplan;

import java.text.ParseException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlan {

	DeploymentPage dp = new DeploymentPage();
	ReleasePage releasePage = new ReleasePage();

	@Test(description = "Deployment Plan Create")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void addDeploymentPlan(String deployData, String testData, String objectData) throws InterruptedException {

		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.clickOnNewDeploymentPlan(deployData, testData, objectData);
		dp.addDeploymentPlan(deployData, testData, objectData,"Deployment_Automation");
		//dp.verifyText("Deployment_Confirmation_Message", "New_DP_Success_Message", deployData, testData);
		Listener.addLogger("Deployment Plan is created successfully | ");

	}

	@Test(description = "Deployment Plan Read", dependsOnMethods = "addDeploymentPlan")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void validateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException {
		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.readDeploymentPlan(deployData, testData, objectData,"Deployment_Automation");
		dp.verifyText("Deployment_LiveSearched_Link", "Deployment_Automation", deployData, testData);
		Listener.addLogger("Deployment Plan validated successfully | ");

	}

	@Test(description = "Deployment Plan Update", dependsOnMethods = "validateDeploymentPlan")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void updateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException {

		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.updateDeploymentPlan(deployData, testData, objectData,"Deployment_Automation");
//		dp.verifyText("Deployment_Confirmation_Message", "New_DP_Success_Message", deployData, testData);
		Listener.addLogger("Deployment Plan updated successfully | ");

	}

	@Test(description = "Deployment Plan Create Duplicate", dependsOnMethods = "updateDeploymentPlan")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void createDuplicateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException, ParseException {
		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.duplicateDeploymentPlan(deployData, testData, objectData);
		dp.sleep(1000);
		dp.verifyText("Deployment_LiveSearched_Link", "Copy_Deployment_Automation", deployData, testData);
		Listener.addLogger("Deployment Plan duplicate created successfully | ");

	}

	@Test(description = "Deployment Plan Delete Duplicate", dependsOnMethods = "createDuplicateDeploymentPlan")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void deleteDuplicateDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException {

		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.deleteDuplicateDeploymentPlan(deployData, testData, objectData);
		dp.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", deployData, testData);
		Listener.addLogger("Deployment Plan duplicate deleted successfully | ");
		dp.sleep(2000);
	}

	@Test(description = "Deployment Plan Delete", dependsOnMethods = "deleteDuplicateDeploymentPlan")
	@Parameters({ "deploymentFile", "testDataFile", "objectMapFile" })
	public void deleteDeploymentPlan(String deployData, String testData, String objectData)
			throws InterruptedException {

		dp.deploymentPlanPage(deployData, testData, objectData);
		dp.deleteDeploymentPlan(deployData, testData, objectData,"Deployment_Automation");
		dp.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", deployData, testData);
		Listener.addLogger("Deployment Plan deleted successfully | ");
		dp.sleep(2000);
	}

}
