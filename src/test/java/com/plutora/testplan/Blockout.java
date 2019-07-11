package com.plutora.testplan;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.BlockoutPage;
import com.plutora.utils.Listener;
import com.plutora.utils.WebGenericUtilLib;

public class Blockout{
	
	BlockoutPage bp = new BlockoutPage();

	@Test(description="Blockout Page Create")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void addBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {	
		bp.blockoutPage(blockoutData, testData, objectData);
		bp.addBlockout(blockoutData,testData,objectData,"Blockout_Automation");
	//	bp.verifyText("Blockout_Confirmation_Message","Blockout_Success_Message",blockoutData,testData );
		Listener.test1.log(Status.INFO,"Blockout is created successfully | ");
		
	}
	
	@Test(description="Blockout Page Read",dependsOnMethods="addBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void verifyBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {	
		bp.blockoutPage(blockoutData, testData, objectData);
		bp.readBlockout(blockoutData,testData,objectData);
		//bp.verifyText("Blockout_SearchResultName","Blockout_Automation",blockoutData,testData );
		Listener.test1.log(Status.INFO,"Blockout validated successfully | ");
		
	}
	
	@Test(description="Blockout Page Update",dependsOnMethods="verifyBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void updateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {	
		bp.blockoutPage(blockoutData, testData, objectData);
		/*TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);*/
		bp.updateBlockout(blockoutData,testData,objectData,platform,"Blockout_Automation");
		//src.delete();
		bp.verifyText("Blockout_Confirmation_Message", "Blockout_Success_Message",blockoutData,testData );
		Listener.test1.log(Status.INFO,"Blockout updated successfully | ");
		
	}
	
	@Test(description="Blockout Page Duplicate",dependsOnMethods="updateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void createDuplicateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {	
		bp.blockoutPage(blockoutData, testData, objectData);	
		bp.createDuplicateBlockout(blockoutData,testData,objectData,platform);
		bp.verifyText("Blockout_Confirmation_Message", "Blockout_Duplicate_Success_Message",blockoutData,testData );
		Listener.test1.log(Status.INFO,"Blockout duplicate record created successfully | ");
		
	}
	
	@Test(description="Blockout Page Delete Duplicate",dependsOnMethods="createDuplicateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile","platform"})
	public void deleteDuplicateBlockout(String blockoutData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {	
		bp.blockoutPage(blockoutData, testData, objectData);	
		bp.deleteDuplicateBlockout(blockoutData,testData,objectData,platform);
		bp.verifyTextEqualsNotDisplayedInPage("Copy_Blockout_Automation",testData);
		Listener.test1.log(Status.INFO,"Blockout duplicate record deleted successfully | ");
		
	}
	
	@Test(description="Blockout Page Delete",dependsOnMethods="deleteDuplicateBlockout")
	@Parameters({"blockoutFile","testDataFile","objectMapFile"})
	public void deleteBlockout(String blockoutData, String testData, String objectData) throws InterruptedException {		
		bp.blockoutPage(blockoutData, testData, objectData);
		bp.deleteBlockout(blockoutData,testData,objectData,"Blockout_Automation");
		bp.verifyTextContainsNotDisplayedInPage("Blockout_Automation",testData);
		Listener.test1.log(Status.INFO,"Blockout deleted successfully | ");
		
	}
}
