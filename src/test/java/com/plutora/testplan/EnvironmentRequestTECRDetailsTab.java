package com.plutora.testplan;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class EnvironmentRequestTECRDetailsTab {
	
	TECRPage tecrPage = new TECRPage();
	ReleasePage releasePage = new ReleasePage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test (description=" Releases bring down the environments")
	public void subareaEnvironmentRequestTECRDetailsTab_01() throws InterruptedException {	
		EnvironmentGroupsPage envGroupPage = new EnvironmentGroupsPage();
		envGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EG_Automation")+" - Environment group is created successfully !");
		tecrPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - System is created successfully !");
		
		new ReleasePage().createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		new ReleasePage().newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id")+" - Enterprise Release is created successfully !");
		
		new ReleasePage().releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		new ReleasePage().createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Env_Test_Automation_Id","PRelease_Automation_Id","PRelease_Automation_Name","Systems_Test_Automation_Id","Release_Test_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Project Release is created with environment successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id_1","EG_Automation","Systems_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" - Environment is created successfully !");
		environmentPage.addHLCToEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" -  Host, Layer and Component is added to Environment successfully !");
		releasePage.addEnvironmentToPhase(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" - Environment added to phase successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		tecrPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		tecrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation","PRelease_Automation_Id","");
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(3000);
		tecrPage.sendKeys("AddTECR_ReleaseName_Textbox", "PRelease_Automation_Id", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(1000);
		tecrPage.clickElementUsingJavaScript("AddTECR_ReleaseName_Option","PRelease_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.sleep(1000);
		tecrPage.validateElementDisplayed("TECR_RE_Notification", PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.clickElementUsingJavaScript("TECR_RE_No_Button",PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.validateElementDisplayed("TECR_RE_Empty_ProgressionPath_Section", PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		Listener.addLogger("Validated Release bring down the Environment 'No' option successfully !");
		tecrPage.clickElementUsingJavaScript("AddTECR_ReleaseNameDropdown",PlutoraConfiguration.tecrData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(3000);
		tecrPage.sendKeys("AddTECR_ReleaseName_Textbox", "PRelease_Automation_Id", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(1000);
		tecrPage.clickElementUsingJavaScript("AddTECR_ReleaseName_Option","PRelease_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.sleep(1000);
		tecrPage.validateElementDisplayed("TECR_RE_Notification", PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.clickElementUsingJavaScript("TECR_RE_Yes_Button",PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.validateElementDisplayed("TECR_RE_ProgressionPath_Environment_Name","Env_Test_Automation_Id", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.validateElementDisplayed("TECR_RE_ProgressionPath_Environment_Name","Env_Test_Automation_Id_1", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.sleep(1000);
		Listener.addLogger("Validated Release bring down the Environment 'Yes' option successfully !");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" -  Environment updated in TECR successfully");
		
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	}
	
	@Test (description=" Outage")
	public void subareaEnvironmentRequestTECRDetailsTab_02() throws InterruptedException, ParseException {	
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Tab", PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		tecrPage.updateTECRStartAndEndTime(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		tecrPage.sleep(1000);
		tecrPage.clickElementUsingJavaScript("TECR_Outage_No_RadioBox",PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.validateElementDisplayed("TECR_Outage_Disabled", PlutoraConfiguration.tecrData);
		Listener.addLogger("Validated TECR outage No' option successfully !");
		tecrPage.clickElementUsingJavaScript("TECR_Outage_Yes_RadioBox",PlutoraConfiguration.tecrData);
		tecrPage.sleep(1000);
		tecrPage.verifyOutageDate(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		Listener.addLogger("Validated TECR outage No' option successfully !");
		
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	}
	
	@Test (description=" 1. Progression Path(add/delete env. and env. group cards and their layers, change status) and 2. edit/delete")
	public void subareaEnvironmentRequestTECRDetailsTab_03() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.click("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		tecrPage.sleep(2000);
		tecrPage.click("TECR_Environment_Delete_Icon","Env_Test_Automation_Id",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(1000);
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Progression Path deleted environment to TECR successfully !");
		tecrPage.sleep(2000);
		tecrPage.addEnvironment(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Progression Path added environment to TECR successfully !");
		tecrPage.validateElementDisplayed("TECR_RE_ProgressionPath_Environment_Name","Env_Test_Automation_Id", PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Progression Path verified environment to TECR successfully !");
		tecrPage.addLayer(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_New_Component_Value");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" Progression Path added layer TECR environment successfully !");
		tecrPage.verifyTextValue(tecrPage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.tecrData, "TECR_Environment_Host_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Host_Name")), "data-qtip"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name"));
		tecrPage.verifyTextValue(tecrPage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.tecrData, "TECR_Environment_Layer_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Layer_Name")), "data-qtip"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Name"));
		tecrPage.verifyTextValue(tecrPage.getAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.tecrData, "TECR_Environment_Component_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Component_Name")), "data-qtip"), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name"));
		tecrPage.verifyTextAttributeValue("TECR_Environment_NewComponent_Name", "Env_New_Component_Value",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Host_Name")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Layer_Name")+"<br>"+PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Component_Name")+" Progression Path verified layer TECR environment successfully !");
		tecrPage.selectStatus(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		tecrPage.verifyTextAttributeValue(PropertiesCache.getProperty(PlutoraConfiguration.tecrData, "TECR_Environment_Status_Textbox").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Env_Test_Automation_Id")),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Environment_Status"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Status")+" Progression Path verified status TECR environment successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);	
	}
	@Test (description="Add to Favorites")
	public void subareaEnvironmentRequestTECRDetailsTab_04() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TECR added to Favorites List successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.validateElementDisplayed("Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TECR verified from Favorites List successfully !");
		
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Favorites_Remove_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TECR removed from Favorites List successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.validateElementDisplayed("Favorites_Add_Icon", PlutoraConfiguration.objectData);
		Listener.addLogger("TECR verified from Favorites List after removal successfully !");
		
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Audit")
	public void subareaEnvironmentRequestTECRDetailsTab_05() throws InterruptedException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.sendKeys("AddTECR_IDTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_Automation"),PlutoraConfiguration.tecrData);
		tecrPage.clickOnSaveButton(PlutoraConfiguration.tecrData,PlutoraConfiguration.objectData);
		//Modify
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		TECRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
		TECRPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		TECRPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox","Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tecrPage.verifyListText("TECR_Audit_Summary", "TECR_Automation", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Added
		tecrPage.addComments(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Comments","TECR_Comments_Tab");
		tecrPage.clickOnSaveButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox","Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tecrPage.verifyListText("TECR_Audit_Comments", "TECR_Comments", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		tecrPage.deleteComments(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Comments_Tab");
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox","Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		tecrPage.verifyListText("TECR_Audit_Comments", "TECR_Comments", PlutoraConfiguration.tecrData, PlutoraConfiguration.testData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox","Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*tecrPage.scrollToElement("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		tecrPage.validateElementDisplayed("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		tecrPage.scrollToElement("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		tecrPage.validateElementDisplayed("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		tecrPage.scrollToElement("Audit_Modified_Icon",  PlutoraConfiguration.objectData);
		tecrPage.validateElementDisplayed("Audit_Modified_Icon",  PlutoraConfiguration.objectData);*/
		
		//Live Search
		tecrPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "TECR_Automation",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		tecrPage.validateElementDisplayed("TECR_Audit_Summary", PlutoraConfiguration.tecrData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Attachements")
	public void subareaEnvironmentRequestTECRDetailsTab_06() throws InterruptedException, IOException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Details_Tab",PlutoraConfiguration.objectData);
		tecrPage.sleep(1000);
		
		//Add attachment
		tecrPage.addAttachment(PlutoraConfiguration.objectData);
		//Verify Attachment 
		tecrPage.clickOnButton(PlutoraConfiguration.objectData,"Attachment_Link", PlutoraConfiguration.objectData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		tecrPage.verifyText("Attachment_Name_Text", "File_Name_Text",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name_Text")+" attachment uploaded verified successfully !");
		tecrPage.click("Add_Attachment_Close_Button", PlutoraConfiguration.objectData);
		
		//Remove attachment
		tecrPage.removeAttachment(PlutoraConfiguration.objectData);
		//Verify attachment
		tecrPage.clickOnButton(PlutoraConfiguration.objectData,"Attachment_Link", PlutoraConfiguration.objectData);
		tecrPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		tecrPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name_Text"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name_Text")+" uploaded file deleted successfully !");
		tecrPage.click("Add_Attachment_Close_Button", PlutoraConfiguration.objectData);
	
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
	}
	@Test (description=" Show on Environment Schedule")
	public void subareaEnvironmentRequestTECRDetailsTab_07() throws InterruptedException, IOException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		//link environment & env grp
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully to environment section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EG_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment section !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	
		//TECR scheduler Yes checkbox 
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECRWithRelease(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation", "Project_Automation", "");
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.sleep(2000);
		tecrPage.clickWebelementButton(PlutoraConfiguration.tecrData, "TECR_Scheduler_YesCheckbox_Checked", "TECR_Scheduler_YesCheckbox_NotChecked", PlutoraConfiguration.objectData, "xpath");
		tecrPage.sleep(2000);
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		//Environment Schedule "Yes" checkbox verification
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Toggle_Icon",PlutoraConfiguration.objectData);
		
		//environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Enterprise_Enable_Checkbox","EnvironmentSchedule_Release_Filter_Enterprise_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		environmentPage.selectReleaseFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		//environmentPage.clickButton("EnvironmentSchedule_Setting_Icon","Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//environmentPage.clickButton("EnvironmentSchedule_Setting_Icon","Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentPage.sleep(5000);
		//environmentPage.validateElementDisplayed("EnvironmentSchedule_TECR_Name", "TECR_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" displayed in environment schedule successfully !");
		
		//Environment schedule No checkbox
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.sleep(2000);
		tecrPage.clickWebelementButton(PlutoraConfiguration.tecrData, "TECR_Scheduler_NoCheckbox_Checked", "TECR_Scheduler_NoCheckbox_NotChecked", PlutoraConfiguration.objectData, "xpath");
		tecrPage.sleep(2000);
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		//Environment Schedule "No" checkbox verification
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" not displayed in environment schedule successfully !");
		
		
		
	}
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaEnvironmentRequestTECRDetailsTab_08() throws InterruptedException, IOException {	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation");
		tecrPage.clickButton("TECR_Name","TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		tecrPage.clickOnButton(PlutoraConfiguration.tecrData, "AddTECR_Details_Tab", PlutoraConfiguration.objectData);
		tecrPage.click("CopyURL_Icon",PlutoraConfiguration.objectData);
		tecrPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		TECRPage.launchUrl(dstData);
		tecrPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		tecrPage.verifyTextAttributeValue("AddTECR_IDTextfield", "TECR_Automation",PlutoraConfiguration.tecrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" redirected to tecr details page after performing copy URL to clipboard for logged in session successfully !");
		tecrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		TECRPage.launchUrl(dstData);
		tecrPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		tecrPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		TECRPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
	}
	
	
}

