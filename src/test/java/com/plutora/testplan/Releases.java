package com.plutora.testplan;


import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ReleaseCalenderPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class Releases {
	ReleasePage releasePage = new ReleasePage();
	ReleaseCalenderPage releaseCalenderPage = new ReleaseCalenderPage();
	
	@Parameters({"releasesFile","testDataFile","objectMapFile"})
	@Test (description="Creating a New Enterprise Release")
	public void releases_01(String releaseData, String testData, String objectData) throws InterruptedException {	
		releasePage.releasePage(releaseData,objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",releaseData,testData);
		releasePage.newERPage(releaseData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Enterprise Release is created successfully !");
	}
	
	@Parameters({"releasesFile","testDataFile","objectMapFile"})
	@Test (description="Verifying Release is created")
	public void releases_02(String releaseData, String testData, String objectData) throws InterruptedException {		
		releasePage.releasePage(releaseData,objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",releaseData,testData);
		releasePage.verifyRelease(releaseData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.verifyText("Releases_Search_Result","Release_Test_Automation_Id",releaseData,testData);
		Listener.addLogger("Release created in the first case is found");
	}
	
	@Parameters({"releasesFile","testDataFile","objectMapFile"})
	@Test (description="Verifying Release in Release Calendar. Filletring by Day, Week and Month")
	public void releases_03(String releaseData, String testData, String objectData) throws InterruptedException {
		releasePage.getReleaseCalenderDetails(releaseData,objectData);
		releaseCalenderPage.clickOnReleaseSelectAllOption(releaseData);
		releaseCalenderPage.clickOnTodayOption(releaseData,objectData);
		releaseCalenderPage.clickOnDayOption(releaseData,objectData);
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Test_Automation_Id", releaseData,testData);
		releaseCalenderPage.clickOnWeekOption(releaseData,objectData);
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Week_ReleaseText","Release_Test_Automation_Id" ,releaseData,testData);
		releaseCalenderPage.verifyTodayMonthRelease(releaseData,testData,objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Release Calender verified successfully !");
	}
	
	@Parameters({"releasesFile","testDataFile","objectMapFile","platform"})
	@Test (description="Updating the Release by changing the Release ID")
	public void releases_04(String releaseData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {	
		releasePage.releasePage(releaseData, objectData);
		releasePage.findAndOpenRelease(releaseData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.verifyTextContains("Release_SubTitle","Release_Test_Automation_Id", releaseData,testData);
		releasePage.updateRelease(releaseData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.clickOnSaveAndCloseButton(releaseData, objectData);
	}
	
	@Test (description="Adding Phases & Gates, Stackholders and Activities")
	@Parameters ({"releasesFile","testDataFile","objectMapFile","platform"})
	public void releases_05 (String releaseData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {
		releasePage.releasePage(releaseData, objectData);
		releasePage.enterNewlyCreatedRelease(releaseData, testData, objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(releaseData, testData, objectData,"Release_Test_Automation_Id");
		releasePage.updatePhaseAndGate(releaseData, testData,objectData,"CountOfReleaseAction");
		releasePage.updateStakeholders(releaseData, testData, objectData);
		releasePage.updateActivties(releaseData, testData, objectData);
		
		releasePage.sleep(4000);
	//	releasePage.verifyText("Release_Activity_Id","New_Activites_Releases_Id_Value",releaseData,testData);
	//	releasePage.verifyText("Release_Activity_Name","New_Activites_Releases_Name_Value", releaseData,testData);
		
		releasePage.clickAndUpdateNewlyCreatedReleaseActivity(releaseData,testData,objectData,platform,"New_Activites_Releases_Id1_Value");
		releasePage.sleep(2000);
		releasePage.scrollToElement("Releases_Attachment_URLTable", releaseData);
		releasePage.validateElementDisplayed("Releases_Attachment_URLTable",releaseData);
		releasePage.deleteNewlyCreatedReleaseActivites(releaseData,testData,objectData);
		
		releasePage.enterNewlyCreatedRelease(releaseData, testData, objectData,"Release_Test_Automation_Id");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",objectData);
		releasePage.verifyText("Releases_Search_Result","Release_Test_Automation_Id",releaseData,testData);
		Listener.addLogger("Enterprise Release updated successfully !");
	}
	
	@Parameters({"releasesFile","testDataFile","objectMapFile","platform"})
	@Test (description="Duplicate a Release")
	public void releases_06(String releaseData, String testData, String objectData,String platform) throws InterruptedException, IOException, AWTException {	
		releasePage.createDuplicateRelease(releaseData, testData, objectData,"Release_Test_Automation_Id");
		//releasePage.verifyText("Confirmation_Message","New_Duplicate_Releases_Confirmation_Message",objectData,testData);
		releasePage.enterNewlyCreatedDuplicateReleases(releaseData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.verifyText("Releases_Id","Copy_Release_Test_Automation_Id",releaseData,testData);
		//releasePage.verifyText("Releases_Name","Release_Test_Automation_Name", releaseData,testData);
		/*TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);*/
		releasePage.clickAndUpdateNewlyCreatedDuplicateReleases(releaseData,testData,objectData,platform,"Release_Test_Automation_Id");
		//src.delete();
		releasePage.sleep(2000);
		releasePage.validateElementDisplayed("Releases_Attachment_Table",releaseData);
		Listener.addLogger("Enterprise Release updated successfully !");
	}
	
	@Test(description="Duplicate Releases Deletion")
	@Parameters({"releasesFile","testDataFile","objectMapFile"})
	public void releases_07(String releasesData,String testData,String objectData) throws InterruptedException {	
		releasePage.deleteRelease(releasesData,testData,objectData);
		releasePage.enterNewlyCreatedDuplicateReleases(releasesData,testData,objectData,"Release_Test_Automation_Id");
		releasePage.validateElementDisplayed("Releases_Empty_Text",releasesData);
		Listener.addLogger("Duplicate Releases is deleted successfully !");
	}
	
	@Parameters({"releasesFile","testDataFile","objectMapFile"})
	@Test (description="Deleting a Release")
	public void releases_08(String releaseData, String testData, String objectData) throws InterruptedException {	
		releasePage.releasePage(releaseData, objectData);
		releasePage.enterNewlyCreatedRelease(releaseData, testData, objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(releaseData, testData, objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(releaseData,testData,objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",releaseData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",releaseData,testData);
		Listener.addLogger("Enterprise Release deleted successfully !");
	}
	
	
}
