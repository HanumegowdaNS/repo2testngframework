package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentRequestTEBRWindowCommentsTab {
	TEBRPage tebrPage = new TEBRPage();
	
	@Test (description="Sub-area: release window -> Comments Tab - General Functionality")
	public void subareaReleaseWindowCommentsTab_01() throws InterruptedException, ParseException {
		
		new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" created successfully !");
		
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation");
		tebrPage.clickButton("TEBR_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		//Add TEBR Comment
		tebrPage.addComments(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments","TEBR_Comments_Tab");
		tebrPage.verifyText("Comments_Text", "TEBR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" verified successfully !");
		//Edit TEBR Comment
		tebrPage.editComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments","TEBR_Comments_Tab");
		tebrPage.verifyText("Comments_Text", "TEBR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" verified successfully !");
		//Reply TEBR Comment
		tebrPage.replyComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Reply_Comments","TEBR_Comments_Tab");
		tebrPage.verifyText("Comments_Text", "TEBR_Reply_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Reply_Comments")+" replyed message verified successfully !");
		//Delete TEBR Comment
		tebrPage.deleteComments(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Comments_Tab");
		tebrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" deleted successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
	
	}
	
	
	
	
}
