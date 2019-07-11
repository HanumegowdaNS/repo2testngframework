package com.plutora.testplan;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.plutora.pagerepo.BlockoutPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class BlockoutPeriodWindow{
	
	BlockoutPage bp = new BlockoutPage();

	@Test(description="Blockout Page Create")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void addBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {		
		bp.addBlockout(blockoutData,testData,objectData,"Blockout_Test_Automation_Id");
		bp.verifyText("Blockout_Confirmation_Message","Blockout_Success_Message",blockoutData,testData );
		Listener.addLogger("Blockout is created successfully | ");
		
	}
	
	@Test(description="Blockout Page Read",dependsOnMethods="addBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void verifyBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {	
		bp.readBlockout(blockoutData,testData,objectData);
		bp.verifyText("Blockout_SearchResultName","Blockout_Automation",blockoutData,testData );
		Listener.addLogger("Blockout validated successfully | ");
		
	}
	
	@Test(description="Blockout Page Update",dependsOnMethods="verifyBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void updateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {		
		bp.updateBlockout(blockoutData,testData,objectData,platform,"Blockout_Test_Automation_Id");
		bp.verifyText("Blockout_Confirmation_Message", "Blockout_Success_Message",blockoutData,testData );
		Listener.addLogger("Blockout updated successfully | ");
		
	}
	
	@Test(description="Blockout Page Duplicate",dependsOnMethods="updateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void createDuplicateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {		
		bp.createDuplicateBlockout(blockoutData,testData,objectData,platform);
		bp.verifyText("Blockout_Confirmation_Message", "Blockout_Duplicate_Success_Message",blockoutData,testData );
		Listener.addLogger("Blockout duplicate record created successfully | ");
		
	}
	
	@Test(description="Blockout Page Delete Duplicate",dependsOnMethods="createDuplicateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void deleteDuplicateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {		
		bp.deleteDuplicateBlockout(blockoutData,testData,objectData,platform);
		bp.verifyTextEqualsNotDisplayedInPage("Copy_Blockout_Automation",testData);
		Listener.addLogger("Blockout duplicate record deleted successfully | ");
		
	}
	
	@Test(description="Blockout Page Delete",dependsOnMethods="deleteDuplicateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void deleteBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {		
		bp.deleteBlockout(blockoutData,testData,objectData,"Blockout_Test_Automation_Id");
		bp.verifyTextContainsNotDisplayedInPage("Blockout_Automation",testData);
		Listener.addLogger("Blockout deleted successfully | ");
		
	}
	
	
}
