package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleaseCalenderPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesCalender {
	ReleaseCalenderPage releaseCalenderPage = new ReleaseCalenderPage();
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	ChangesPage changePage = new ChangesPage();
	BlockoutPage blockoutPage = new BlockoutPage();
	TECRPage tecrPage=new TECRPage();
	TEBRPage tebrPage=new TEBRPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test (description="Module Release Calendar -> left panel -> Date picker")
	public void releaseCalendar_01() throws InterruptedException, ParseException {	

		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id","Release_Calender_Automation_Name","2");
		releasePage.getCustomStatusSelectionPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		releasePage.sleep(2000);
		//releaseCalenderPage.clickOnReleaseSelectAllOption(PlutoraConfiguration.releasesData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		//Content
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_Checked_Icon","ReleaseCalendar_ReleaseType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.sleep(2000);
		releasePage.clickOnReleaseStatusCustomFieldSelectOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"class","RStatus");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Validate Element
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar is appeared based on the selected date successfully !");
		releaseCalenderPage.clickOnWeekOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyReleaseWeekDate("Release_Calender_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar is appeared based on the selected date in week successfully !");
		releaseCalenderPage.verifyMonthRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		Listener.addLogger("Release Calendar is appeared based on the date in Month successfully !");
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Release Details - Contents (Changes name should be shown at the bottom of popup window)")
	public void releaseCalendar_02() throws InterruptedException, ParseException {	

		changePage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changePage.createSystem(PlutoraConfiguration.changesData,PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");
		changePage.searchSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.dragSearchedSystem1(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changePage.clickOnButton(PlutoraConfiguration.changesData,"Change_Change_Tab",PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		boolean flag = releasePage.getDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Quantity in 'Contents' grid is equal to selected changes in release successfully !");
		releasePage.getUnselectChangeReleasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("Change_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected change deleted from 'Contents' grid and Release Calendar successfully !");
		releasePage.getDeleteDetailsContentPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("Change_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted change deleted from 'Contents' grid and Release Calendar successfully !");
		releasePage.click("Release_Details_Close_Icon",PlutoraConfiguration.releasesData);
		//Test data delete
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id1");
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.click("Project_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");
	}

	@Test (description="Module Release Calendar -> left panel -> Release Details - Systems(System name should be shown at the bottom of popup window)")
	public void releaseCalendar_03() throws InterruptedException, ParseException {	
		
		boolean flag = releasePage.getReleaseCalendarSystemPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger(" Quantity in 'Systems' grid equals to selected systems in release successfully !");
		//System Update
		releasePage.getReleaseCalendarSystemUpdatePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsDisplayedInPage("DeploymentTitle_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("'Systems' grid and Release Calendar updated successfully !");
		//Unselect System
		releasePage.getReleaseCalendarSystemUnselectPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.validateElementDisplayed("Releases_Systems_DeploymnetAdd_Button", PlutoraConfiguration.releasesData);
		Listener.addLogger("Unselected systems deleted from 'Systems' grid and Release Calendar successfully !");
		//Delete System
		releasePage.getReleaseCalendarSystemDeletePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id",PlutoraConfiguration.systemsData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.switchToWindow(4000, "parentWindow");
		ReleasePage.driver.get(ReleasePage.driver.getCurrentUrl());
		releasePage.validateElementDisplayed("Release_Details_Popup_Message", PlutoraConfiguration.releasesData);
		
		//releasePage.verifyText("Release_Details_Popup_Message","ReleaseDeletePopupMessage",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Deleted system deleted from 'Systems' grid and Release Calendar successfully !");
		releasePage.sleep(1000);
		//releasePage.click("Release_Details_Ok_Button",PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		releasePage.closeWindowTab();
		ReleasePage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData,"parentWindow"));
				
		releasePage.clickElementUsingJavaScript("Release_Details_Close_Icon",PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> left panel -> Release Details - Events")
	public void releaseCalendar_04() throws InterruptedException, ParseException {	

		boolean flag = releasePage.getEventCalendarPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Quantity in 'Event' grid equal to events in release successfully !");
		releasePage.getEventCalendarUpdatePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Event_Type_Text",releasePage.eventDropdownOption,PlutoraConfiguration.releasesData);
		Listener.addLogger("'Events' grid and Release Calendar updated successfully !");
		releasePage.getEventCalendarDeletePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("Event_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("On deletion of Event, 'Events' grid and Release Calendar updated successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickElementUsingJavaScript("Release_Details_Close_Icon",PlutoraConfiguration.releasesData);

	}

	@Test (description="Module Release Calendar -> left panel -> View by -> Release ID")
	public void releaseCalendar_05() throws InterruptedException, ParseException {	

		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		releasePage.sleep(2000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user able see Release ID of release successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> View by -> Release Name")
	public void releaseCalendar_06() throws InterruptedException, ParseException {	

		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseName_RadioButton");
		releasePage.sleep(2000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Name", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user able see Release Name of release successfully !");
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");
	}

	@Test (description="Module Release Calendar -> left panel -> Release Types")
	public void releaseCalendar_07() throws InterruptedException, ParseException {	


		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","RType");

		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDateCustomData(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"AddRelease_ReleaseTypeDropdown","AddRelease_ReleaseType_CustomOption","RType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		releasePage.sleep(2000);
		//releaseCalenderPage.clickOnReleaseSelectAllOption(PlutoraConfiguration.releasesData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		//Content
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_Checked_Icon","ReleaseCalendar_ReleaseType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user able to see release with selected type successfully !");
		releasePage.click("Release_TypeCustom_Label","RType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("Release_Calender_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Releases with unselected type hidden in Release Calendar successfully !");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"RType");
		releasePage.verifyTextContainsNotDisplayedInPage("RType", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted Release Type deleted from 'Release Types' list successfully !");
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Release Status")
	public void releaseCalendar_08() throws InterruptedException,ParseException {	
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","RStatus");

		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id","Release_Calender_Automation_Name","2");
		releasePage.getCustomStatusSelectionPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"RStatus");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickOnReleaseStatusCustomFieldSelectOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"class","RStatus");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user able to see release with selected status successfully !");
		releasePage.click("AddRelease_Status_Label","RStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("Release_Calender_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Releases with unselected status hidden in Release Calendar successfully !");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"RStatus");
		releasePage.verifyTextContainsNotDisplayedInPage("RStatus", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted Release status deleted from 'Release Status' list successfully !");
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> System Deployments -> Show Date range")
	public void releaseCalendar_09() throws InterruptedException, ParseException {	

		releasePage.getReleaseCalendarSystemDateRangePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsDisplayedInPage("Release_Calender_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("User is able to see date range of systems successfully !");
		releasePage.click("Release_Calender_SystemEndDate_Radiobutton",PlutoraConfiguration.releasesData);
		releasePage.sleep(3000);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsDisplayedInPage("Release_Calender_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("User is able to see date range of systems successfully !");
	}
	@Test (description="Module Release Calendar -> left panel -> System Deployments -> Show end date only")
	public void releaseCalendar_10() throws InterruptedException, ParseException {	
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Calendar_SystemDeployment_Checked_Icon","Release_Calendar_SystemDeployment_NotChecked_Icon",PlutoraConfiguration.objectData);
		releasePage.click("Release_Calender_SystemEndDate_Radiobutton",PlutoraConfiguration.releasesData);
		releasePage.sleep(3000);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releasePage.verifyTextContainsDisplayedInPage("Release_Calender_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("User is able to see final date of systems successfully !");
		//Test data delete
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		releasePage.click("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test Data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Blockout Period Types")
	public void releaseCalendar_11() throws InterruptedException, ParseException {	

		//custom field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_BlockoutType_Option","BType");

		//create blockout period
		blockoutPage.addBlockoutWithTypeDate(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id","BType");
		//calendar page
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickOnBlockoutSelectAllOption(PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsDisplayedInPage("Blockout_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user able to see selected Blockout Period Type successfully !");
		boolean flag = releasePage.getBlockoutDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Details window appeared. Start/End Day of Blockout Period equal to date range in Release Calendar successfully !");
		releasePage.click("Release_Details_Close_Icon",PlutoraConfiguration.releasesData);
		releasePage.clickButton("Release_Calender_BlockoutSelect_Option","BType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage("Blockout_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected Blockout Period Type hidden in Release Calendar successfully !");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//customizationPage.deleteCustomizationFieldWithoutPopup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_BlockoutType_Option","BType");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"BType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.clickOnBlockoutSelectAllOption(PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsDisplayedInPage("Blockout_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted Blockout Period Types move to 'Other' type of 'Blockout Period Types' list successfully !");
		//delete test data
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		blockoutPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");

	}

	@Test (description="Module Release Calendar -> left panel -> Environments -> Activity TECR")
	public void releaseCalendar_12() throws InterruptedException, ParseException {	
	
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","2");
		tecrPage.enterNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.clickOnTECRName(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		tecrPage.updateReleaseScheduler(PlutoraConfiguration.tecrData, PlutoraConfiguration.objectData);
		
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TECR_Checked_Icon","ReleaseCalendar_TECR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestType_Checked_Icon","ReleaseCalendar_ChangeRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRType_Checked_Icon","ReleaseCalendar_TECRType_NotChecked_Icon","TECR_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestStatus_Checked_Icon","ReleaseCalendar_ChangeRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRStatus_Checked_Icon","ReleaseCalendar_TECRStatus_NotChecked_Icon","TECR_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releaseCalenderPage.verifyTextContainsDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TECR with selected Type and Status successfully !");
		releaseCalenderPage.getEnvironmentLeftpanelTECRLableUnCheckedPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, "Release_Calender_TECRTypeItem_Checked", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type"),"Release_Calender_TECRTypeItem_Button", "class");
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyTextContainsNotDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to deselect TECR with selected Type and Status successfully !");
		//delete test data
		/*environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");*/
	}

	@Test (description="Module Release Calendar -> left panel -> Environments -> Activity TEBR")
	public void releaseCalendar_13() throws InterruptedException, ParseException {	

		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		releaseCalenderPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);

		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TEBR_Checked_Icon","ReleaseCalendar_TEBR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestType_Checked_Icon","ReleaseCalendar_BookingRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRType_Checked_Icon","ReleaseCalendar_TEBRType_NotChecked_Icon","TEBR_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestStatus_Checked_Icon","ReleaseCalendar_BookingRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRStatus_Checked_Icon","ReleaseCalendar_TEBRStatus_NotChecked_Icon","TEBR_Status",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releaseCalenderPage.verifyTextContainsDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TEBR with selected Type and Status successfully !");
		releaseCalenderPage.getEnvironmentLeftpanelTECRLableUnCheckedPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, "Release_Calender_TEBRTypeItem_Checked", PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Type"),"Release_Calender_TEBRTypeItem_Button", "class");
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyTextContainsNotDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to deselect TEBR with selected Type and Status successfully !");
		//delete test data
		
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");

	}


	@Test (description="Module Release Calendar -> left panel -> Environments -> Change Request Status")
	public void releaseCalendar_14() throws InterruptedException,ParseException {	

		//TECR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECRType");
		//TECR create
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","TECRStatus","TECRType","0");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//select status
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TECR_Checked_Icon","ReleaseCalendar_TECR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestType_Checked_Icon","ReleaseCalendar_ChangeRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRType_Checked_Icon","ReleaseCalendar_TECRType_NotChecked_Icon","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(2000);
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestStatus_Checked_Icon","ReleaseCalendar_ChangeRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRStatus_Checked_Icon","ReleaseCalendar_TECRStatus_NotChecked_Icon","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		
		//releaseCalenderPage.verifyTextContainsDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TECR with selected status successfully !");
		//Unselect TECR
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TECRSelect_Option","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.sleep(2000);
		releasePage.verifyTextContainsNotDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected TECR Status hidden in Release Calendar successfully !");
		//verify start/end date
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TECRSelect_Option","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = releasePage.getTECRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Details window appeared. Start/End Day of TECR Period equal to date range in Release Calendar successfully !");
		//Delete TECR
		releasePage.getDeleteTECRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Delete TECR deleted from Release Calendar successfully !");
		releasePage.sleep(1000);
		//Delete TECR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECRStatus");
		releasePage.verifyTextContainsNotDisplayedInPage("TECRStatus", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TECR Status deleted from 'TECR Status' list successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Environments -> Change Request Type")
	public void releaseCalendar_15() throws InterruptedException,  ParseException {	

		//TECR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECRStatus");
		//TECR create
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","TECRStatus","TECRType","0");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//select status
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TECR_Checked_Icon","ReleaseCalendar_TECR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestType_Checked_Icon","ReleaseCalendar_ChangeRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRType_Checked_Icon","ReleaseCalendar_TECRType_NotChecked_Icon","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestStatus_Checked_Icon","ReleaseCalendar_ChangeRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRStatus_Checked_Icon","ReleaseCalendar_TECRStatus_NotChecked_Icon","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releaseCalenderPage.verifyTextContainsDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TECR with selected type successfully !");
		//Unselect TECR
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.scrollToElement("Release_Calender_TECRType_Link", PlutoraConfiguration.releasesData);
		releasePage.click("Release_Calender_TECRSelectType_Option","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.sleep(2000);
		releasePage.verifyTextContainsNotDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected TECR Type hidden in Release Calendar successfully !");
		//verify start/end date
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TECRSelectType_Option","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = releasePage.getTECRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Details window appeared. Start/End Day of TECR Period equal to date range in Release Calendar successfully !");
		//Delete TECR
		releasePage.getDeleteTECRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("TECR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Delete TECR deleted from Release Calendar successfully !");
		releasePage.sleep(1000);
		//Delete TECR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//customizationPage.deleteReleaseTypeCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECRType");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECRType");
		
		releasePage.verifyTextContainsNotDisplayedInPage("TECRType", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TECR Type deleted from 'TECR Type' list successfully !");
		//customizationPage.deleteReleaseTypeCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECRStatus");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECRStatus");
		Listener.addLogger("Test data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Environments -> Booking Request Status")
	public void releaseCalendar_16() throws InterruptedException, ParseException {	

		//TEBR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBRType");
		//TEBR create
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id","TEBRStatus","TEBRType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//select status
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TEBR_Checked_Icon","ReleaseCalendar_TEBR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.scrollToElementAndClick(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestType_Checked_Icon","ReleaseCalendar_BookingRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRType_Checked_Icon","ReleaseCalendar_TEBRType_NotChecked_Icon","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestStatus_Checked_Icon","ReleaseCalendar_BookingRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRStatus_Checked_Icon","ReleaseCalendar_TEBRStatus_NotChecked_Icon","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
	//	releaseCalenderPage.verifyTextContainsDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TEBR with selected status successfully !");
		//Unselect TEBR
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TEBRSelect_Option","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.sleep(2000);
		releasePage.verifyTextContainsNotDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected TEBR Status hidden in Release Calendar successfully !");
		//verify start/end date
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TEBRSelect_Option","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = releasePage.getTEBRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Details window appeared. Start/End Day of TEBR Period equal to date range in Release Calendar successfully !");
		//Delete TEBR
		releasePage.getDeleteTEBRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Delete TEBR deleted from Release Calendar successfully !");
		releasePage.sleep(1000);
		//Delete TECR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRStatus");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRType");
		releasePage.verifyTextContainsNotDisplayedInPage("TEBRStatus", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TEBR Status deleted from 'TEBR Status' list successfully !");

	}

	@Test (description="Module Release Calendar -> left panel -> Environments -> Booking Request Type")
	public void releaseCalendar_17() throws InterruptedException, ParseException {	

		//TEBR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBRType");
		//TEBR create
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id","TEBRStatus","TEBRType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//select status
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TEBR_Checked_Icon","ReleaseCalendar_TEBR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.scrollToElementAndClick(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestType_Checked_Icon","ReleaseCalendar_BookingRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRType_Checked_Icon","ReleaseCalendar_TEBRType_NotChecked_Icon","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestStatus_Checked_Icon","ReleaseCalendar_BookingRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRStatus_Checked_Icon","ReleaseCalendar_TEBRStatus_NotChecked_Icon","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.sleep(3000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//releaseCalenderPage.verifyTextContainsDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TEBR with selected type successfully !");
		//Unselect TEBR
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.scrollToElement("Release_Calender_TEBRType_Link", PlutoraConfiguration.releasesData);
		releasePage.click("Release_Calender_TEBRSelectType_Option","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.sleep(2000);
		releasePage.verifyTextContainsNotDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Unselected TEBR Type hidden in Release Calendar successfully !");
		//verify start/end date
		releaseCalenderPage.sleep(2000);
		releasePage.click("Release_Calender_TEBRSelectType_Option","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		boolean flag = releasePage.getTEBRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyTrue(flag);
		Listener.addLogger("Details window appeared. Start/End Day of TEBR Period equal to date range in Release Calendar successfully !");
		//Delete TEBR
		releasePage.getDeleteTEBRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.verifyTextContainsNotDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("Delete TEBR deleted from Release Calendar successfully !");
		releasePage.sleep(1000);
		//Delete TEBR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//customizationPage.deleteReleaseTypeCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBRType");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRType");
		releasePage.verifyTextContainsNotDisplayedInPage("TEBRType", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TEBR Type deleted from 'TEBR Type' list successfully !");
		//customizationPage.deleteReleaseTypeCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBRStatus");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRStatus");
		Listener.addLogger("Test data deleted successfully !");

	}

	@Test (description="Module Release Calendar -> Time line filtering (Day, Week, Month, Year)")
	public void releaseCalendar_18() throws InterruptedException, ParseException {	

		//Release Type A Status A
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseStatus_Option","RStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","RType");

		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageWithCustomType(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"RType");
		releasePage.getCustomStatusSelectionPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"RStatus");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		//Content
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_Checked_Icon","ReleaseCalendar_ReleaseType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.sleep(2000);
		releasePage.clickOnReleaseStatusCustomFieldSelectOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"class","RStatus");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Validate Element
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseText","Release_Calender_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar is appeared based on the selected date successfully !");
		releaseCalenderPage.clickOnWeekOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyReleaseWeekDate("Release_Calender_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar is appeared based on the selected date in week successfully !");
		releaseCalenderPage.verifyMonthRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		Listener.addLogger("Release Calendar is appeared based on the date in Month successfully !");
		releaseCalenderPage.verifyYearRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Calender_Automation_Id");
		Listener.addLogger("Release Calendar is appeared based on the date in Year successfully !");

		//TECR Type A Status A
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECRType");
		//TECR create
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","TECRStatus","TECRType","0");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		//select status
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TECR_Checked_Icon","ReleaseCalendar_TECR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestType_Checked_Icon","ReleaseCalendar_ChangeRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRType_Checked_Icon","ReleaseCalendar_TECRType_NotChecked_Icon","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestStatus_Checked_Icon","ReleaseCalendar_ChangeRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRStatus_Checked_Icon","ReleaseCalendar_TECRStatus_NotChecked_Icon","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);

		//Validate Element
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseContainsText","TECR_Test_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("TECR Calendar is appeared based on the selected date successfully !");
		releaseCalenderPage.clickOnWeekOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyReleaseWeekContainsDate("TECR_Test_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("TECR Calendar is appeared based on the selected date in week successfully !");
		releaseCalenderPage.verifyMonthContainsRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id");
		Listener.addLogger("TECR Calendar is appeared based on the date in Month successfully !");
		releaseCalenderPage.verifyYearRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Test_Automation_Id","0");
		Listener.addLogger("TECR Calendar is appeared based on the date in Year successfully !");

		//Delete TECR
		releasePage.getTECRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.getDeleteTECRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		//Delete TECR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECRStatus");
		
		releasePage.verifyTextContainsNotDisplayedInPage("TECRStatus", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TECR Status deleted from 'TECR Status' list successfully !");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECRType");
		releasePage.verifyTextContainsNotDisplayedInPage("TECRType", PlutoraConfiguration.testData);
		Listener.addLogger("Deleted TECR Type deleted from 'TECR Type' list successfully !");

		//TEBR Type A Status A
		//TEBR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBRType");
		//TEBR create
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id","TEBRStatus","TEBRType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TEBR_Checked_Icon","ReleaseCalendar_TEBR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.scrollToElementAndClick(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestType_Checked_Icon","ReleaseCalendar_BookingRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRType_Checked_Icon","ReleaseCalendar_TEBRType_NotChecked_Icon","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestStatus_Checked_Icon","ReleaseCalendar_BookingRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRStatus_Checked_Icon","ReleaseCalendar_TEBRStatus_NotChecked_Icon","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.sleep(2000);
		releaseCalenderPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyTextContainsDisplayedInPage("TEBR_Test_Automation_Id", PlutoraConfiguration.testData);
		Listener.addLogger("In Release Calendar user is able to see TEBR with selected status successfully !");
		//Validate Element
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseContainsText","TEBR_Test_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("TECR Calendar is appeared based on the selected date successfully !");
		releaseCalenderPage.clickOnWeekOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyReleaseWeekContainsDate("TEBR_Test_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("TECR Calendar is appeared based on the selected date in week successfully !");
		releaseCalenderPage.verifyMonthContainsRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger("TECR Calendar is appeared based on the date in Month successfully !");
		releaseCalenderPage.verifyYearRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id","0");
		Listener.addLogger("TECR Calendar is appeared based on the date in Year successfully !");
		//Delete TEBR
		releasePage.getTEBRDetailsPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.getDeleteTEBRFromPopupPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Details_Close_Icon");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		Listener.addLogger("TEBR deleted from Release Calendar successfully !");
		releasePage.sleep(1000);
		//Delete TEBR custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRType");
		releasePage.verifyTextContainsNotDisplayedInPage("TEBRType", PlutoraConfiguration.testData);
		Listener.addLogger("TEBR Type deleted from 'TEBR Type' list successfully !");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBRStatus");
		Listener.addLogger("Test data deleted successfully !");

		//Blockout Period Type A
		//custom field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_BlockoutType_Option","BType");
		//create blockout period
		blockoutPage.addBlockoutWithTypeDate(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id","BType");
		//calendar page
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BlockoutPeriosType_Checked_Icon","ReleaseCalendar_BlockoutPeriodType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BlockoutPeriodType_SelectAll_Checked_Icon","ReleaseCalendar_BlockoutPeriodType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		//Validate Element
		releaseCalenderPage.validateElementDisplayed("Release_Calender_Day_ReleaseContainsText","Blockout_Test_Automation_Id", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Blockout Period Calendar is appeared based on the selected date successfully !");
		releaseCalenderPage.clickOnWeekOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyReleaseWeekContainsDate("Blockout_Test_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("Blockout Period Calendar is appeared based on the selected date in week successfully !");
		releaseCalenderPage.verifyMonthContainsRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		Listener.addLogger("Blockout Period Calendar is appeared based on the date in Month successfully !");
		releaseCalenderPage.verifyYearRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		Listener.addLogger("Blockout Period Calendar is appeared based on the date in Year successfully !");
		//delete blockout period custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"BType");
		//delete test data
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");

	}

	
	@Test (description=" -> Entity popup window (data appearance, attachments)")
	public void releaseCalendar_19() throws InterruptedException, ParseException {	
		new EnvironmentPage().getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - System is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation","Enterprise_Automation_Name","2");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.linkSystemToEnterpriseRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Systems_Automation");
		releasePage.createEvent(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		//Content
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Contents_RadioButton");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_Checked_Icon","ReleaseCalendar_ReleaseType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.sleep(2000);
		
		releaseCalenderPage.clickButton("Release_Calender_Day_ReleaseText","Enterprise_Automation",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseId_Link", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseName_Link", "Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseType_Link", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Release - Content - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"</br>"+
																	PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+"</br>"+	
																	PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" validated successfully ! ");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		
		//System
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Systems_RadioButton");
		releasePage.sleep(2000);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickButton("Release_Calender_Day_ReleaseText","Enterprise_Automation",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseId_Link", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseName_Link", "Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseType_Link", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Release - System - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"</br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+"</br>"+	
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" validated successfully ! ");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		
		//Event
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_Event_RadioButton");
		releasePage.sleep(2000);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ReleaseType_SelectAll_Checked_Icon","ReleaseCalendar_ReleaseType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickButton("Release_Calender_Day_ReleaseText","Enterprise_Automation",PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseId_Link", "Enterprise_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseName_Link", "Enterprise_Automation_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("Release_Details_ReleaseType_Link", "Release_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Release - Event - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+"</br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+"</br>"+	
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type")+" validated successfully ! ");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		
		blockoutPage.refresh(PlutoraConfiguration.objectData);
		//Create blockout period
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Automation");
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Automation");
		blockoutPage.updateScheduler(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		//calendar page
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.scrollToElementAndClick(PlutoraConfiguration.releasesData,"ReleaseCalendar_BlockoutPeriosType_Checked_Icon","ReleaseCalendar_BlockoutPeriodType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BlockoutPeriodType_SelectAll_Checked_Icon","ReleaseCalendar_BlockoutPeriodType_SelectAll_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		releaseCalenderPage.clickButton("Release_Calendar_BlockoutName_Text","Blockout_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_BlockoutName_Text", "Blockout_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_BlockoutType_Text", "Blockout_Type",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_BlockoutDescription_Text", "Blockout_Desc",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Blockout Period  - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Automation")+"</br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type")+"</br>"+	
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Desc")+" validated successfully ! ");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		
		//TECR
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECRType");
		//TECR create
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation","TECRStatus","TECRType","0");
		
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_Off_Icon","ReleaseCalendar_Release_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_On_Icon","ReleaseCalendar_Environment_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Checked_Icon","ReleaseCalendar_Environment_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TECR_Checked_Icon","ReleaseCalendar_TECR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestType_Checked_Icon","ReleaseCalendar_ChangeRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRType_Checked_Icon","ReleaseCalendar_TECRType_NotChecked_Icon","TECRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_ChangeRequestStatus_Checked_Icon","ReleaseCalendar_ChangeRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TECRStatus_Checked_Icon","ReleaseCalendar_TECRStatus_NotChecked_Icon","TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickButton("Release_Calendar_TECRName_Text","TECR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_TECRName_Text", "TECR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_TECRStatus_Text", "TECRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Environment - TECR  - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+"</br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECRStatus")+" validated successfully ! ");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		//TEBR customization field creation
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRStatus_Option","TEBRStatus");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TEBRType_Option","TEBRType");
		//TEBR create
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBR(PlutoraConfiguration.tebrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TEBR_Automation","TEBRStatus","TEBRType");
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnDayOption(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_TEBR_Checked_Icon","ReleaseCalendar_TEBR_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestType_Checked_Icon","ReleaseCalendar_BookingRequestType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRType_Checked_Icon","ReleaseCalendar_TEBRType_NotChecked_Icon","TEBRType",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_BookingRequestStatus_Checked_Icon","ReleaseCalendar_BookingRequestStatus_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_TEBRStatus_Checked_Icon","ReleaseCalendar_TEBRStatus_NotChecked_Icon","TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releasePage.sleep(5000);
		releaseCalenderPage.clickButton("Release_Calendar_TEBRName_Text","TEBR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_TEBRName_Text", "TEBR_Automation",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releaseCalenderPage.verifyTextAttributeValue("ReleaseCalendar_Details_TEBRStatus_Text", "TEBRStatus",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Calendar - Environment - TEBR  - "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+"</br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBRStatus")+" validated successfully ! ");
		
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Details_Close_Icon",PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECRStatus");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECRType");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBRStatus");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TEBRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBRType");
		//Delete release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		//Delete blockout
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation");
				
		//Delete TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation");
		
		//Delete TEBR
		tebrPage.clickOnButton(PlutoraConfiguration.tebrData, "TEBR_Label", PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		
	}
	@Test (description=" -> Show >2 release types / blockout periods on Year view")
	public void releaseCalendar_20() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_BlockoutType_Option","Blockout_Type_1");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_BlockoutType_Option","Blockout_Type_2");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","Release_Type_1");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ReleaseType_Option","Release_Type_2");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_Type_1");
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRType_Option","TECR_Type_2");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_TECRStatus_Option","TECR_Status");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1","Enterprise_Automation_1_Name","2");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.clickOnReleaseField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_ReleaseTypeDropdown", "AddRelease_ReleaseType_Option", "Release_Type_1");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2","Enterprise_Automation_2_Name","2");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2");
		releasePage.clickOnReleaseField(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "AddRelease_ReleaseTypeDropdown", "AddRelease_ReleaseType_Option", "Release_Type_2");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		blockoutPage.addBlockoutWithTypeDate(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Automation_1","Blockout_Type_1");
		blockoutPage.addBlockoutWithTypeDate(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Automation_2","Blockout_Type_2");
	
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"TECR_Automation_1","TECR_Status","TECR_Type_1","2");
		
		new EnvironmentPage().getTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation_2","TECR_Status","TECR_Type_2","2");
		
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("2"));
		releasePage.sleep(5000);
		
		//Release Types
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Calender_YearButton",PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_ReleaseType_Toggle_Checked_Icon","ReleaseCalendar_Year_ReleaseType_Toggle_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_ReleaseType_Checked_Icon","ReleaseCalendar_Year_ReleaseType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_ReleaseType_Name_Checked_Icon","ReleaseCalendar_Year_ReleaseType_Name_NotChecked_Icon","Release_Type_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_ReleaseType_Name_Checked_Icon","ReleaseCalendar_Year_ReleaseType_Name_NotChecked_Icon","Release_Type_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.scrollToElement("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		releaseCalenderPage.waitForLoadingIconDisappear(100,"Loading_Gif" ,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyText("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Type_2")+" displayed in release year calendar sucessfully !");
		
		//Blockout Types
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Calender_YearButton",PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_BlockoutPeriodType_Toggle_Checked_Icon","ReleaseCalendar_Year_BlockoutPeriodType_Toggle_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_BlockoutPeriodType_Checked_Icon","ReleaseCalendar_Year_BlockoutPeriodType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_BlockoutPeriodType_Name_Checked_Icon","ReleaseCalendar_Year_BlockoutPeriodType_Name_NotChecked_Icon","Blockout_Type_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_BlockoutPeriodType_Name_Checked_Icon","ReleaseCalendar_Year_BlockoutPeriodType_Name_NotChecked_Icon","Blockout_Type_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.scrollToElement("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		releaseCalenderPage.waitForLoadingIconDisappear(100,"Loading_Gif" ,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyText("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type_2")+" displayed in release year calendar sucessfully !");
		//TECR Types
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Calender_YearButton",PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_TECRType_Toggle_Checked_Icon","ReleaseCalendar_Year_TECRType_Toggle_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Year_TECRType_Checked_Icon","ReleaseCalendar_Year_TECRType_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_TECRType_Checked_Name_Icon","ReleaseCalendar_Year_TECRType_NotChecked_Name_Icon","TECR_Type_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton("ReleaseCalendar_Year_TECRType_Checked_Name_Icon","ReleaseCalendar_Year_TECRType_NotChecked_Name_Icon","TECR_Type_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"xpath");
		
		releaseCalenderPage.scrollToElement("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		releaseCalenderPage.waitForLoadingIconDisappear(100,"Loading_Gif" ,PlutoraConfiguration.objectData);
		releaseCalenderPage.verifyText("ReleaseCalendar_Year_Title",releaseCalenderPage.getTodayDate("0", "MMMM yyyy"),PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type_1")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Type_2")+" displayed in release year calendar sucessfully !");
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRStatus_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Status");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Type_1");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_TECRType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Type_2");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Type_1");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Type_2");
		
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Type_1");
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_ReleaseType_Option");
		customizationPage.deleteCustomizationField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Type_2");
		//Delete release
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_1");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2");
		releasePage.clickCreatedReleases(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation_2");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Delete blockout
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation_1");
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation_1");
		
		blockoutPage.clickOnBlockoutPeriod(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation_2");
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Blockout_Automation_2");
		//Delete TECR
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation_1");
		
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation_2");
		tecrPage.refresh(PlutoraConfiguration.objectData);
	}
	
	@Test(description = "Filter by (right top corner)")
	public void releaseCalendar_21() throws InterruptedException, ParseException {
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_ReleasePhases_Option",
				"Phase_Name");
		/* Navigating to Release Page */
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Creating New Project Release */
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id", "0", "0");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Show_Button", "Release_Hide_Button",
				PlutoraConfiguration.objectData, "xpath");
		releasePage.clickOnStakeholderTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Loggedin_Username_Value", "Releases_StakeholderButton");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Environment_Toggle_Off_Icon","ReleaseCalendar_Environment_Toggle_On_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Toggle_On_Icon","ReleaseCalendar_Release_Toggle_Off_Icon",PlutoraConfiguration.objectData,"xpath");
		releaseCalenderPage.clickOnButton(PlutoraConfiguration.releasesData,"ReleaseCalendar_Release_Checked_Icon","ReleaseCalendar_Release_NotChecked_Icon",PlutoraConfiguration.objectData,"xpath");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_Details_ReleaseId_RadioButton");
		
		releasePage.releaseDatePicker(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				"Release_Calender_AppPickerLabel", releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releaseCalenderPage.clickElementUsingJavaScript("Release_Calender_MonthButton",
				PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on 'My Portfolio Association' */
		releasePage.clickElementUsingJavaScript("Release_MyPortfolioAssociation_Tab",
				PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Presence of Release on Calendar */
		releasePage.click("Release_Calender_Month_More_Button",releasePage.getTodayDate("0", "yyyyMMdd"),PlutoraConfiguration.releasesData);
		releasePage.sleep(3000);
		releasePage.validateElementDisplayed("ReleaseCalendar_ReleaseTitle_link", "Release_Test_Automation_Id",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		
		/* Clicking on 'I'm a Stakeholder' */
		releasePage.clickElementUsingJavaScript("Release_IamStakeholder_Tab", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Presence of Release on Calendar */
		releasePage.validateElementDisplayed("ReleaseCalendar_ReleaseTitle_link", "Release_Test_Automation_Id",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		/* Clicking on 'All' tab' */
		releasePage.clickElementUsingJavaScript("Release_All_Tab", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Presence of Release on Calendar */
		releasePage.validateElementDisplayed("ReleaseCalendar_ReleaseTitle_link", "Release_Test_Automation_Id",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Release_Calender_Today_Month_CloseButton",PlutoraConfiguration.objectData);
	}

	@Test(description = "View Full Screen")
	public void releaseCalendar_22() throws InterruptedException, ParseException, AWTException {
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				"Release_Calender_AppPickerLabel", releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_Calender_MonthButton",PlutoraConfiguration.objectData);
		releasePage.getCoordinates("ReleaseCalendar_Monday_Text", PlutoraConfiguration.releasesData,
				PlutoraConfiguration.testData, "xcoordi_1", "ycoordi_1");
		releasePage.clickElementUsingJavaScript("ReleaseCalendar_ViewFullScreen_Button",
				PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		
		releasePage.getCoordinates("ReleaseCalendar_Monday_Text", PlutoraConfiguration.releasesData,
				PlutoraConfiguration.testData, "xcoordi_2", "ycoordi_2");
		releasePage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_1"))) > (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "xcoordi_2"))));
		releasePage.escape();
		releasePage.sleep(2000);
		
	}

	//@Test(description = "Export to PDF")
	public void releaseCalender_23() throws InterruptedException, ParseException, AWTException {
		releasePage.getReleaseCalenderDetails(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.datePicker(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				"Release_Calender_AppPickerLabel", releasePage.getCurrentDate("0"));
		releasePage.sleep(5000);
		releasePage.clickElementUsingJavaScript("ReleaseCalendar_ExportToPdf_Button",
				PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		releasePage.switchToWindow(10000, "parent_window");
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		releasePage.switchToFrameByElement("ReleaseCalendar_Iframe_frame", PlutoraConfiguration.releasesData);
		releasePage.clickElementUsingJavaScript("ReleaseCalendar_DisplayReleaseSelect_DownArrow",
				PlutoraConfiguration.releasesData);
		releasePage.clickElementUsingJavaScript("ReleaseCalendar_DisplayReleaseSelect_YesOption",
				PlutoraConfiguration.releasesData);
		releasePage.clickElementUsingJavaScript("ReleaseCalendar_Pdf_button", PlutoraConfiguration.releasesData);
		releasePage.switchToWindow(8000, "parent_window_1");
		releasePage.verifyAssertTrue(releasePage.getCurrentUrl().contains("Calendar.pdf"));
		releasePage.closeWindowTab();
		ReleasePage.driver.switchTo()
				.window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parent_window_1"));
		releasePage.closeWindowTab();
		ReleasePage.driver.switchTo()
				.window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parent_window"));

	}
	
	
}
