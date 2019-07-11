package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class PIRWindowDetailsTab {
	PIRPage pirPage = new PIRPage();
	ReleasePage releasePage = new ReleasePage();

	@Test (description="Sub-area: PIR Window -> E/P/I releases availability in 'PIR is for Release/s' combobox")
	public void subareaPIRWindowDetailsTab_01() throws InterruptedException, AWTException, ParseException {	
		//Add E/P/I
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");
		//Add pir
		pirPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRWithoutRelease(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.sleep(1000);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRReleaseAddedPage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		String pirReleaseName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_Release_Added_Text");
		String pirProjectName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_PRelease_Added_Text");
		String pirIndependentName=pirPage.getPIRPMElementData(PlutoraConfiguration.pirData,"PIR_IRelease_Added_Text");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
		pirPage.sleep(1000);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Release_Added_TextName",pirReleaseName,PlutoraConfiguration.pirData);
		pirPage.verifyText("PIR_Release_Added_TextName",pirProjectName,PlutoraConfiguration.pirData);
		pirPage.verifyText("PIR_Release_Added_TextName",pirIndependentName,PlutoraConfiguration.pirData);
		Listener.addLogger("E/P/I releases displayed in 'PIR is for Release/s' combobox successfully !");
		//delete pir
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(1000);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
		//delete release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//delete project release
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//delete independent release
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.sleep(1000);
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Item test data deleted successfully !");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Releases_Page_Title");

	}


}
