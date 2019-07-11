package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentRequestTECRWindowCommentsTab {
	TECRPage tecrPage = new TECRPage();
	
	@Test (description="Sub-area: release window -> Comments Tab - General Functionality")
	public void subareaReleaseWindowCommentsTab_01() throws InterruptedException, ParseException {
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" created successfully !");
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		//Add TECR Comment
		tecrPage.addComments(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Comments","TECR_Comments_Tab");
		tecrPage.verifyText("Comments_Text", "TECR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Comments")+" verified successfully !");
		//Edit Release Comment
		tecrPage.editComments(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Comments","TECR_Comments_Tab");
		tecrPage.verifyText("Comments_Text", "TECR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Comments")+" verified successfully !");
		//Reply Release Comment
		tecrPage.replyComments(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Reply_Comments","TECR_Comments_Tab");
		tecrPage.verifyText("Comments_Text", "TECR_Reply_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Reply_Comments")+" replyed message verified successfully !");
		//Delete Release Comment
		tecrPage.deleteComments(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Comments_Tab");
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Comments")+" deleted successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" deleted successfully !");
	
	}
	
	
	
	
}
