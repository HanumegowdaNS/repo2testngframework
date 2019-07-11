package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.WebGenericUtilLib;

public class PIRManagerGrid {
	PIRPage pirPage = new PIRPage();

	@Test (description="Sub-area: PIR Manager -> PIR Grid tab -> PIR add/edit/delete")
	public void subareaPIRManagerPIRGrid_01() throws InterruptedException, AWTException, ParseException {	
		WebGenericUtilLib.driver.navigate().refresh();
		pirPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		//Add pir
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.sleep(1000);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Name","PIR_Test_Automation_Id",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.validateElementDisplayed("PIR_Name_Status","PIR_Test_Automation_Id",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR created successfully !");
		//update pir
		pirPage.clickAndUpdateNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextAttributeValue("AddPIR_NameTextfield","New_PIR_Name_Update_Value",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR edited successfully !");
		//delete pir
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(1000);
		pirPage.searchNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Description_TextField_Value",PlutoraConfiguration.testData );
		Listener.addLogger("PIR deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}


}
