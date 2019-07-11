package com.plutora.testplan;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleasesWindowActivityCriteriaWindow {
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: release window -> Activites  Tab -> activity/criteria window -> Copy URL to clipboard\n" + 
			"(for both logged in and logged out scenarios, for both activity and criteria)")
	public void subareaReleaseWindowActivityCriteriaWindow_01() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Project Release creation
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project release is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//Add activity/Criteria
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name","Activity_Test_Automation_Name");
		releasePage.createReleaseCriteria(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Name","Criteria_Test_Automation_Name");
		
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.click("Releases_Activity_CopyURL_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		//Activity Copy URL to clipboard 
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		      System.out.println(dstData);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		ReleasePage.launchUrl(dstData);
		releasePage.waitForLoadingIconDisappear(1000,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		//Verify Activity Name
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Activity_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name")+" redirected to release details page after performing copy URL to clipboard for logged in session successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save&CloseButton",PlutoraConfiguration.objectData);
		
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		//Validate login page
		releasePage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		releasePage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Criteria_Name");
		releasePage.click("Releases_Activity_CopyURL_Icon", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(4000);
		//Criteria Copy URL to clipboard 
		myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		      System.out.println(dstData);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		ReleasePage.launchUrl(dstData);
		releasePage.waitForLoadingIconDisappear(1000,"Loading_Gif",PlutoraConfiguration.objectData);
		//Verify Criteria Name
		releasePage.verifyTextAttributeValue("Release_Activity_IdTextField", "Criteria_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Criteria_Name")+" redirected to release details page after performing copy URL to clipboard for logged in session successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save&CloseButton",PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		ReleasePage.launchUrl(dstData);
		//Validate Login page
		releasePage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		releasePage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ReleasePage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
	}
	
	@Test (description="Sub-area: release window -> Activities tab -> activity/criteria window -> Comments")
	public void subareaReleaseWindowActivityCriteriaWindow_02() throws InterruptedException{	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//Add activity Comment
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.addActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Comments","Release_Activity_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Activity_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" verified successfully !");
		//Edit Activity Comment
		releasePage.editActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Comments","Release_Activity_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Activity_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" verified successfully !");
		//Reply Activity Comment
		releasePage.replyActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Reply_Comments","Release_Activity_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Activity_Reply_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Reply_Comments")+" replyed message verified successfully !");
		//Delete Activity Comment
		releasePage.deleteActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Activity_Comments_Tab");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" deleted successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save&CloseButton",PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Sub-area: release window -> Activities tab -> activity/criteria window -> Audit")
	public void subareaReleaseWindowActivityCriteriaWindow_03() throws InterruptedException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Project_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Information_Tab", PlutoraConfiguration.objectData);
		releasePage.sendKeys("Release_Activity_IdTextField", PropertiesCache.setProperty(PlutoraConfiguration.testData, "Activity_Name_1"),PlutoraConfiguration.releasesData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save_Button",PlutoraConfiguration.objectData);
		//Modify Audit
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Audit_Icon", PlutoraConfiguration.objectData);
		try {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
		ReleasePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		ReleasePage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Modified_Checked_Checkbox","Release_Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Name_1")+" modified in audit page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Added audit
		releasePage.click("Release_Activity_StartDate_Dropdown",PlutoraConfiguration.releasesData);
		releasePage.sleep(3000);
		releasePage.clickElementUsingJavaScript("Release_Activity_DueDateDone_Button",PlutoraConfiguration.releasesData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Activity_Save_Button",PlutoraConfiguration.objectData);
		releasePage.sleep(3000);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Added_Checked_Checkbox","Release_Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyTextDisplayedInPage(releasePage.getTodayDate("0", "dd/MM/yyyy hh"));
		Listener.addLogger(releasePage.getTodayDate("0", "dd/MM/yyyy hh")+" added in audit page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted audit
		releasePage.addActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Comments","Release_Activity_Comments_Tab");
		releasePage.verifyText("Release_Activity_Comments_Text", "Activity_Comments",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" verified successfully !");
		
		releasePage.deleteActivityComments(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Activity_Comments_Tab");
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" deleted successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Deleted_Checked_Checkbox","Release_Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		releasePage.verifyListText("Release_Audit_ActivityComments_Text", "Activity_Comments", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Activity_Comments")+" deleted in audit page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All option
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_All_Checked_Checkbox","Release_Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*releasePage.scrollToElement("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Deleted_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Added_Icon",  PlutoraConfiguration.releasesData);
		releasePage.scrollToElement("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);
		releasePage.validateElementDisplayed("Release_Audit_Modified_Icon",  PlutoraConfiguration.releasesData);*/
		Listener.addLogger("All option displayed Added/Modified/Deleted in audit page successfully !");
		//Live Search
		releasePage.sendKeysWithEnter("Release_Audit_Live_Search_Textbox", "Activity_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Release_Audit_Activity_Live_Search_Text", PlutoraConfiguration.releasesData);
		Listener.addLogger("Live search validated in audit page successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Audit_Close_Icon", PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Activity_Information_Tab", PlutoraConfiguration.objectData);
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	}
	@Test (description="Sub-area: release window -> Activities tab -> activity/criteria window -> KPI")
	public void subareaReleaseWindowActivityCriteriaWindow_04() throws InterruptedException, ParseException {
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Disable KPI metrix Planned and Actual tracking
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_KPIMatrixType_Option");
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_KPIMatrixType_Tracking_UnChecked_Checkbox", "Customization_KPIMatrixType_Tracking_Checked_Checkbox",PlutoraConfiguration.objectData,"xpath");
		Listener.addLogger("KPI Matrix view disabled in customization successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, 1,"Releases_StakeholderButton");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		//Add activity/Criteria
		releasePage.createNewReleaseActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name","Activity_Test_Automation_Name");
		
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		
		releasePage.verifyTextEqualsNotDisplayedInPage("KPI Type");
		Listener.addLogger("KPI Type not displayed in enterprise release successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_KPIMatrixType_Option");
		//Enable KPI metrix Planned and Actual tracking
		customizationPage.clickOnButton(PlutoraConfiguration.customizationData, "Customization_KPIMatrixType_Tracking_Checked_Checkbox", "Customization_KPIMatrixType_Tracking_UnChecked_Checkbox",PlutoraConfiguration.objectData,"xpath");
		Listener.addLogger("KPI Matrix view enabled in customization successfully !");
		
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_KPIMatrixType_Option", "KPIMatrix_Type");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_KPIMatrixType_Option");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_ActivitesTab", PlutoraConfiguration.objectData);
		releasePage.clickOnActivity(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Activity_Name");
		releasePage.verifyTextDisplayedInPage("KPI Type");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Activity_KPI_Type_Dropdown",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Activity_KPI_Type_Dropdown_Option", "KPIMatrix_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "KPIMatrix_Type")+" displayed in KPI matrix type dropdown successfully !");
		releasePage.clickButton("Release_Activity_KPI_Type_Dropdown_Option", "KPIMatrix_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Verify Planned & Actual Values Percentage 
		String metrics=releasePage.calculateKPIMetrics("10", "10", PlutoraConfiguration.releasesData);
		releasePage.verifyTextContains("Release_Activity_KPIMetrix_Percentage",metrics,PlutoraConfiguration.releasesData);
		Listener.addLogger(metrics+" % achieved successfully !");
		
		metrics=releasePage.calculateKPIMetrics("100", "10", PlutoraConfiguration.releasesData);
		releasePage.verifyTextContains("Release_Activity_KPIMetrix_Percentage",metrics,PlutoraConfiguration.releasesData);
		
		Listener.addLogger(metrics+" % achieved successfully !");
		
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Releases_Activity_Save&CloseButton", PlutoraConfiguration.objectData);
		
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	
	}
}
