package com.plutora.testplan;


import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRItemWindowCommentsTab {
	PIRPage pirPage = new PIRPage();
	CustomizationPage customizationPage = new CustomizationPage();

	@Test (description="Sub-area: PIR Item window -> Comments Tab")
	public void subareaPIRItemWindowCommentsTab_01() throws InterruptedException, ParseException {	
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.sleep(1000);
		pirPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		pirPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.clickOnNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		//Add PIR Item Comment
		pirPage.addPIRItemComments(PlutoraConfiguration.pirData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Comments");
		pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Comments")+" verified successfully !");
		//Edit PIR Item Comment
		pirPage.editPIRItemComments(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Comments");
		pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Comments")+" verified successfully !");
		//Reply PIR Item Comment
		pirPage.replyPIRItemComments(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIRItem_Reply_Comments");
		pirPage.verifyTextContains("PIR_Comments_Text", "PIRItem_Reply_Comments",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIRItem_Reply_Comments")+" replyed message verified successfully !");
		
		pirPage.clickOnSaveAndExitButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Delete PIR item
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.searchNewlyCreatedPIRManagerPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Item_Automation");
		pirPage.deleteNewlyCreatedPIRItem(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Item_Automation");
		
	}
	
}
