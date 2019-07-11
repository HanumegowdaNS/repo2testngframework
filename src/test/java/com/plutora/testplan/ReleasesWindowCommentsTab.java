package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesWindowCommentsTab {
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: release window -> Comments Tab - General Functionality")
	public void subareaReleaseWindowCommentsTab_01() throws InterruptedException, ParseException {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		//Add Release Comment
		releasePage.addActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Comments","Release_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Release_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Comments")+" verified successfully !");
		//Edit Release Comment
		releasePage.editActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Comments","Release_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Release_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Comments")+" verified successfully !");
		//Reply Release Comment
		releasePage.replyActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Reply_Comments","Release_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Release_Reply_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Reply_Comments")+" replyed message verified successfully !");
		//Delete Release Comment
		releasePage.deleteActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Comments_Tab");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Comments")+" deleted successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Project_Tab",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Update_Id");
		releasePage.click("Independent_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Independent Release is deleted successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Update_Id");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Project Release is deleted successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Empty_Text",PlutoraConfiguration.releasesData);
		Listener.addLogger("Enterprise Release is deleted successfully !");
	
	}
	
	
	
	
}
