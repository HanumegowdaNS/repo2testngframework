package com.plutora.testplan;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class PIRWindow {
	PIRPage pirPage = new PIRPage();

	@Test (description="Sub-area: PIR Window -> Save/Delete/Save&Close")
	public void subareaPIRWindow_01() throws InterruptedException {	
		//Add PIR
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		//Verify PIR
		pirPage.verifyText("PIR_Name","PIR_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+" Verified Save & close Button successfully !");
		//update PIR
		pirPage.clickAndUpdateNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Confirmation_Message","New_PIR_Confirmation_Message",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+" Verified Save Button successfully !");
		//delete PIR
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+" Verified Delete button successfully !");
	}
	
	@Test (description="Sub-area: PIR Window -> Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaPIRWindow_02() throws InterruptedException {	
		pirPage.getPIRDetailsPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PlutoraConfiguration.platformName, "PIR_Automation");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		pirPage.click("CopyURL_Icon",PlutoraConfiguration.pirData);
		pirPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		PIRPage.launchUrl(dstData);
		pirPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.verifyTextAttributeValue("AddPIR_IDTextfield", "PIR_Automation",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PIR_Automation")+" redirected to pir details page after performing copy URL to clipboard for logged in session successfully !");
		pirPage.clickOnSaveAndCloseButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		PIRPage.launchUrl(dstData);
		pirPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		pirPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		PIRPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
	}
	@Test (description="Sub-area: PIR Window -> Audit")
	public void subareaPIRWindow_03() throws InterruptedException {	
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Automation");
		
		pirPage.sendKeys("AddPIR_IDTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "PIR_Automation"),PlutoraConfiguration.pirData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Modify
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		PIRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
			PIRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		PIRPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox","Release_Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Audit_PIRName_Text", "PIR_Automation", PlutoraConfiguration.pirData, PlutoraConfiguration.testData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		//Added
		pirPage.addAttachment(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PIR_Attachment_NewButton");
		Listener.addLogger("Attachment added successfully !");
		pirPage.clickOnSaveButton(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox","Release_Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Audit_AddedAttachment_Text", CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ImageName"), PlutoraConfiguration.pirData,"");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		pirPage.deleteAttachment(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData);
		Listener.addLogger("Attachment deleted successfully !");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox","Release_Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		pirPage.verifyListText("PIR_Audit_DeletedAttachment_Text", CommonConstants.imageFileNameUrl+PropertiesCache.getProperty(PlutoraConfiguration.testData, "ImageName"), PlutoraConfiguration.pirData,"");
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox","Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*pirPage.scrollToElement("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		pirPage.scrollToElement("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		pirPage.scrollToElement("Audit_Modified_Icon",  PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("Audit_Modified_Icon",  PlutoraConfiguration.objectData);*/
		
		//Live Search
		pirPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "PIR_Automation",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		pirPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Audit_PIRName_Text", PlutoraConfiguration.pirData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		pirPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
	
		
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "PIR_Automation");
		pirPage.refresh(PlutoraConfiguration.objectData);
		
		
		
	}
	
	


}
