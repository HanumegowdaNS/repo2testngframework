package com.plutora.testplan;



import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class EnvironmentRequestMyEnvironmentBookingWindow {
	
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentGroupsPage environmentGroupPage= new EnvironmentGroupsPage();
	
	@Test (description="General appearance and functionality")
	public void subareaEnvironmentRequestMyEnvironmentBookingWindow_01() throws InterruptedException, ParseException {
		//System and approver
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		systemsPage.addApprovers(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Environment Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		environmentPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		//Environment
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","EnvGrp_Automation","Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		
		//Release Creation & link system 
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment 
		releasePage.linkEnvironmentToNonEnterpriseRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "Project_Tab");
		
		//On - Show my environment booking 
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" displayed in My environment booking successfully !");
		environmentPage.verifyText("MyEnvironmentBooking_Field_Text", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" displayed in My environment booking successfully !");
		//Off - Show my environment booking
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+"  not displayed in My environment booking successfully !");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" not displayed in My environment booking successfully !");
		
	}
	String parentWindow=null;
	@Test (description="Audit")
	public void subareaEnvironmentRequestMyEnvironmentBookingWindow_02() throws InterruptedException, ParseException {
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		parentWindow = WebGenericUtilLib.driver.getWindowHandle();
		environmentPage.doubleClick("MyEnvironmentBooking_Field_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickButton("MyEnvironmentBooking_ViewField_Text", "Project_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.switchToWindowPopup();
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "Project_Automation"),PlutoraConfiguration.releasesData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//Modify
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		try {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		ReleasePage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Modified_Checked_Checkbox","Release_Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_ReleaseName_Text", "Project_Automation", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Added
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_StakeholdersTab", PlutoraConfiguration.objectData);
		releasePage.addEnterpriseShakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, 1);
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Added_Checked_Checkbox","Release_Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_Stakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		releasePage.removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name","Releases_Remove_Stakeholder_Button");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Deleted_Checked_Checkbox","Release_Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_DeletedStakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_All_Checked_Checkbox","Release_Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*releasePage.scrollToElement("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);*/
		
		//Live Search
		releasePage.sendKeysWithEnter("Release_Audit_Live_Search_Textbox", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Audit_Live_Search_Text", PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		
	}
	@Test (description="Comments")
	public void subareaEnvironmentRequestMyEnvironmentBookingWindow_03() throws InterruptedException, ParseException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.doubleClick("MyEnvironmentBooking_Field_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.clickButton("MyEnvironmentBooking_ViewField_Text", "Project_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.switchToWindowPopup();
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
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		

	}
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaEnvironmentRequestMyEnvironmentBookingWindow_04() throws InterruptedException, ParseException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"MyEnvironmentBooking_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Off_Notification", "MyEnvironmentBooking_On_Notification",PlutoraConfiguration.objectData,"xpath");
		environmentPage.sendKeysWithEnter("MyEnvironmentBooking_Search", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.doubleClick("MyEnvironmentBooking_Field_Text", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(1000);
		environmentPage.clickButton("MyEnvironmentBooking_ViewField_Text", "Project_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.switchToWindowPopup();
		releasePage.click("Releases_CopyURL_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextAttributeValue("AddRelease_IDTextfield", "Project_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" redirected to release details page after performing copy URL to clipboard for logged in session successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		releasePage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		releasePage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
		environmentPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		environmentPage.refresh(PlutoraConfiguration.objectData);
	}
	
}
