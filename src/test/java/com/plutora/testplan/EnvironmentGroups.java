package com.plutora.testplan;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gargoylesoftware.htmlunit.javascript.host.Plugin;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentGroups {
    
	EnvironmentPage environmentpage = new EnvironmentPage();
	EnvironmentGroupsPage ep = new EnvironmentGroupsPage();

	@Test(description = "Environment Groups Create")
	@Parameters({ "environmentFile", "testDataFile", "objectMapFile" })
	public void environmentGroups_01(String envData, String testData, String objectData) throws InterruptedException {
		ep.gotoEnvironmentGroupsPage(envData, testData, objectData);
		ep.createEnvironmentGroups(envData, testData, objectData,"Env_Group_Automation");
		//ep.verifyText("EnvGroups_Confirmation_Message", "New_ENV_Groups_Success_Message", envData, testData);
		Listener.addLogger("New Environment Group created successfully | ");

	}

	@Test(description = "Environment Groups Read", dependsOnMethods = "environmentGroups_01")
	@Parameters({ "environmentFile", "testDataFile", "objectMapFile" })
	public void environmentGroups_02(String envData, String testData, String objectData) throws InterruptedException {
		ep.readEnvironmentGroups(envData, testData, objectData,"Env_Group_Automation");
		ep.verifyText("EnvGroups_EnvNameLink", "Env_Group_Automation", envData, testData);
		Listener.addLogger("New Environment reading successfully | ");

	}

	@Test(description = "Environment Groups Update", dependsOnMethods = "environmentGroups_02")
	@Parameters({ "environmentFile", "testDataFile", "objectMapFile" })
	public void environmentGroups_03(String envData, String testData, String objectData)
			throws InterruptedException {
		ep.updateEnvironmentGroups(envData, testData, objectData,"Env_Group_Automation");
		ep.readEnvironmentGroups(envData, testData, objectData,"Env_Group_Automation");
		ep.verifyText("EnvGroups_Description_Grid", "New_ENV_Groups_Description", envData, testData);
		Listener.addLogger("New Environment updated successfully | ");

	}

	@Test(description = "Environment Groups Delete", dependsOnMethods = "environmentGroups_03")
	@Parameters({ "environmentFile", "testDataFile", "objectMapFile" })
	public void environmentGroups_04(String envData, String testData, String objectData)
			throws InterruptedException {
		ep.deleteEnvironmentGroups(envData, testData, objectData);
		//ep.verifyText("EnvGroups_Confirmation_Message", "New_ENV_Groups_Success_Message", envData, testData);
		ep.closeEnvironmentGroupsPage(envData, testData, objectData);
		Listener.test1.log(Status.INFO, "New Environment deleted successfully | ");

	}
	 
}
