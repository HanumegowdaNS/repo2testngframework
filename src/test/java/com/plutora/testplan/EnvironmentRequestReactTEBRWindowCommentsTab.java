package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReacttebrPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentRequestReactTEBRWindowCommentsTab {

	ReacttebrPage reactTEBRPage = new ReacttebrPage();
	EnvironmentPage ep = new EnvironmentPage();
	
	
	@Test (description="Sub-area: release window -> Comments Tab - General Functionality")
	public void subareaReleaseWindowCommentsTab_01() throws InterruptedException, ParseException {
				
		ep.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		reactTEBRPage.creationTEBR(PlutoraConfiguration.reacttebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_React_Test_Automation_Id");
		Listener.addLogger("TEBR is created successfully !");
		ep.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		reactTEBRPage.enterNewlyCreatedTEBR(PlutoraConfiguration.reacttebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "TEBR_React_Test_Automation_Id");
		reactTEBRPage.click("TEBR_Name","TEBR_React_Test_Automation_Id" , PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		reactTEBRPage.click("TEBR_Comments_Button",PlutoraConfiguration.reacttebrData);
		
		//Add TEBR Comment
		reactTEBRPage.addComments(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments");
		Thread.sleep(1000);
		reactTEBRPage.verifyText("Comments_Text", "TEBR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" verified successfully !");
		//Edit TEBR Comment
		reactTEBRPage.editComments(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Comments");
		Thread.sleep(1000);
		reactTEBRPage.verifyText("Comments_Text", "TEBR_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" verified successfully !");
		//Reply TEBR Comment
		reactTEBRPage.replyComments(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Reply_Comments");
		Thread.sleep(1000);
		reactTEBRPage.verifyText("Comments_Text", "TEBR_Reply_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Reply_Comments")+" replyed message verified successfully !");
		//Delete TEBR Comment
		reactTEBRPage.deleteComments(PlutoraConfiguration.objectData);
		reactTEBRPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Comments")+" deleted successfully !");
		
		//TODO Delete cannot be done yet. 		
		//reactTEBRPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		// Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
	
	}
	
	
	
	
}
