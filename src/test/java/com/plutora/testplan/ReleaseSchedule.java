
package com.plutora.testplan;


import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ReleaseSchedule {

	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	BlockoutPage blockoutPage = new BlockoutPage();
	CustomizationPage customizationPage = new CustomizationPage();

	@Test (description="Module Release Schedule -> Date Range filtering")
	public void moduleReleaseSchedule_01() throws InterruptedException, AWTException, IOException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newIndependentReleasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.newERPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.newProjectReleasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getReleaseScheduleDateRangePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean flag = releasePage.getDateRangeFilterPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Date Range filtered successfully !");
	}

	@Test (description="Module Release Schedule -> Release Structure filtering")
	public void moduleReleaseSchedule_02() throws InterruptedException, AWTException, IOException, ParseException {	

		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getReleaseScheduleDateRangePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Enterprise filter
		boolean flag = releasePage.getReleaseStructureEnterprisePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Release Schedule displays a list of Enterprise releases successfully !");
		//Project filter
		boolean flag1 = releasePage.getReleaseStructureProjectPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag1);
		Listener.addLogger("Release Schedule displays a list of Project releases successfully !");
		//Project filter
		boolean flag2 = releasePage.getReleaseStructureIndependentPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag2);
		Listener.addLogger("Release Schedule displays a list of Independent releases successfully !");
		//All filter
		boolean flag3 = releasePage.getReleaseStructureAllPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag3);
		Listener.addLogger("Release Schedule displays a list of Enterprise, Project and Independent releases successfully !");
		//Group by enterprise release filter
		boolean flag4 = releasePage.getReleaseStructureGroupByPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyAssertTrue(flag4);
		Listener.addLogger("Release Schedule displays a tree-structure of Enterprise, Project and Independent releases successfully !");
		releasePage.clickOnElement(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData,"Release_StructureGroupBy_Checkbox");
		//delete ER release
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}

	//Release Id/Name
	@Test (description="Module Release Schedule -> Filters -> Release ID/Name")
	public void moduleReleaseSchedule_03() throws InterruptedException, AWTException, IOException, ParseException {	

		releasePage.getFilterReleaseIdNameAddPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Searched_Id","Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Schedule is appeared based on filter by Release ID/Name successfully !");
		boolean flag = releasePage.getFilterReleaseIdNameClearPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_IdNameToggle_Button");
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Release ID/Name filter cleared successfully !");

	}

	//Release Systems
	@Test (description="Module Release Schedule -> Filter -> System")
	public void moduleReleaseSchedule_04() throws InterruptedException, AWTException, IOException, ParseException {	

		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getFilterSystemAddPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Searched_Id","Release_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Release Schedule is appeared based on filter by System successfully !");
		boolean flag = releasePage.getFilterReleaseIdNameClearPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_SystemToggle_Button","Release_SystemPopupClear_Button");
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Release System filter cleared successfully !");

	}

	//Release Portfolio Association
	/*@Test (description="Module Release Schedule -> Filter -> Portfolio Assoc.")
	public void moduleReleaseSchedule_05() throws InterruptedException, AWTException, IOException, ParseException {	

		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getFilterPortfoilioAddPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean onFlag = releasePage.getFilterReleaseIdNameOnPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_PortfolioToggle_Button","Release_SystemPopupClear_Button");
		releasePage.verifyAssertTrue(onFlag);
		Listener.addLogger("Release Schedule is appeared based on filter by Portfolio Associations successfully !");
		boolean flag = releasePage.getFilterPortfolioClearPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_PortfolioToggle_Button");
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Portfolio Associations filter cleared successfully !");

	}*/

	//Release status
	@Test (description="Module Release Schedule -> Filter -> Release Status")
	public void moduleReleaseSchedule_06() throws InterruptedException, AWTException, IOException, ParseException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Release_Test_Automation_Id");
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"Release_Status", releasePage.getAttributeData("AddRelease_Status_Textbox", PlutoraConfiguration.releasesData));
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		ReleasePage.driver.navigate().refresh();
		releasePage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getFilterReleaseStatusAddPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean onFlag = releasePage.getFilterReleaseIdNameOnPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_StatusToggle_Button","Release_TypePopupClear_Button");
		releasePage.verifyAssertTrue(onFlag);
		Listener.addLogger("Release Schedule is appeared based on filter by Release Status successfully !");
		boolean flag = releasePage.getFilterReleaseIdNameClearPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_StatusToggle_Button","Release_TypePopupClear_Button");
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Release Status filter cleared successfully !");

	}

	//Release Type
	@Test (description="Module Release Schedule -> Filter -> Release Type")
	public void moduleReleaseSchedule_07() throws InterruptedException, AWTException, IOException, ParseException {	
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getFilterReleaseTypeAddPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean onFlag = releasePage.getFilterReleaseIdNameOnPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_TypeToggle_Button","Release_TypePopupClear_Button");
		releasePage.verifyAssertTrue(onFlag);
		Listener.addLogger("Release Schedule is appeared based on filter by Release Type successfully !");
		boolean flag = releasePage.getFilterReleaseIdNameClearPage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_TypeToggle_Button","Release_TypePopupClear_Button");
		releasePage.verifyAssertTrue(flag);
		Listener.addLogger("Release Type filter cleared successfully !");

	}

	//Release Timeline
	@Test (description="Module Release Schedule -> Timeline Scale")
	public void moduleReleaseSchedule_08() throws InterruptedException, AWTException, IOException, ParseException {	
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getReleaseScheduleDateRangePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		releasePage.getReleaseTimelinePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"123Systems_Test_Automation_Id");

		//delete ER release
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//project release
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//independent release
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"IRelease_Automation_Id");
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Test data deleted successfully !");
	}
	
	@Test (description="Schedule filtering")
	public void moduleReleaseSchedule_09() throws InterruptedException, AWTException, IOException, ParseException {	
		
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
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id", "55", "60");
		/* Navigating to Block out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_Test_Automation_Id", "55", "60");
		/* Navigating to Release page */
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findProjectReleaseInSchedule(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"60");
		/* Clicking on 'Hide Today Line' */
		releasePage.clickElementUsingJavaScript("Release_HideTodayLine_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		/* Verifying Absence of 'Today Line' */
		releasePage.validateElementNotDisplayed("Release_Timeline_Dateline", PlutoraConfiguration.releasesData);
		Listener.addLogger("Verified Absence of Today Line");
		/* Clicking on 'Hide Today Line' */
		releasePage.clickElementUsingJavaScript("Release_HideTodayLine_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		/* Clicking on 'Hide Phases Breakdown' */
		releasePage.clickElementUsingJavaScript("Release_HidePhasesBreakdown_checkbox",
				PlutoraConfiguration.releasesData);
		releasePage.sleep(2000);
		/* Verifying Absence of 'PhaseBreakdown' */
		releasePage.validateElementNotDisplayed("Release_PhaseNameOnTimeline_PhaseLine",
				PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Phase_Name")
				+ "Verified Absence of Phase Breakdown");
		/* Clicking on 'Hide Phases Breakdown' */
		releasePage.clickElementUsingJavaScript("Release_HidePhasesBreakdown_checkbox",
				PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		/* Clicking on 'Hide Blockout Periods' */
		releasePage.clickElementUsingJavaScript("Release_HideBlockPeriod_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		/* Verifying Absence of 'BlockOut Period' */
		releasePage.validateElementNotDisplayed("Release_BlockOutArea_PhaseLine", PlutoraConfiguration.releasesData);
		Listener.addLogger("Verified Absence of BlockOut Period..");
		/* Clicking on 'Hide Blockout Periods' */
		releasePage.clickElementUsingJavaScript("Release_HideBlockPeriod_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		/* Clicking on 'Hide Legends' */
		releasePage.clickElementUsingJavaScript("Release_HideBlockPeriod_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
		/* Verifying Absence of Legend tab */
		releasePage.validateElementNotDisplayed("Release_LegendSection_LegendLabel", PlutoraConfiguration.releasesData);
		Listener.addLogger("Verified Absence of 'Legends'..");
		/* Clicking on 'Hide Legends' */
		releasePage.clickElementUsingJavaScript("Release_HideBlockPeriod_checkbox", PlutoraConfiguration.releasesData);
		releasePage.sleep(1000);
	}
	
	@Test(description = "View Full Screen")
	public void moduleReleaseSchedule_10() throws InterruptedException, ParseException, AWTException {
		/* Navigating to Release page */
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Clicking on 'Yearly Timescale' */
		releasePage.selectTimeLineScale(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Yearly");
		releasePage.sleep(2000);
		releasePage.getCoordinates("ReleaseSchedule_ReleaseName_Text", PlutoraConfiguration.releasesData,
				PlutoraConfiguration.testData, "x_cord", "y_cord");
		releasePage.click("ReleaseCalendar_ViewFullScreen_Button", PlutoraConfiguration.releasesData);
		releasePage.sleep(4000);
		releasePage.getCoordinates("ReleaseSchedule_ReleaseName_Text", PlutoraConfiguration.releasesData,
				PlutoraConfiguration.testData, "x_cord_1", "y_cord_1");
		releasePage.sleep(2000);
		releasePage.verifyAssertTrue(
				(Integer.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "y_cord"))) > (Integer
						.parseInt(PropertiesCache.getProperty(PlutoraConfiguration.testData, "y_cord_1"))));
		releasePage.sleep(2000);
		releasePage.escape();
		releasePage.sleep(2000);
	}
	
	@Test (description="Save Filter/Load Filter")
	public void moduleReleaseSchedule_11() throws InterruptedException, ParseException{
		
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
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id", "65", "70");
		/* Navigating to Release page */
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findProjectReleaseInSchedule(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "70");
		/* Saving Filter */
		releasePage.saveFilter(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData,
				PlutoraConfiguration.testData);
		/* Clicking on Load Filter */
		releasePage.clickElementUsingJavaScript("Release_LoadFilter_Link", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on My Filter */
		releasePage.clickElementUsingJavaScript("Release_LoadFilterMyFilter_InputBox",
				PlutoraConfiguration.releasesData);
		/* Verifying Presence of Filter created in My Filter */
		releasePage.validateElementDisplayed("Release_LoadFilterMyFilterName_DropDownItem", "Filter_Name",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		/* Clicking on Public Filters */
		releasePage.clickElementUsingJavaScript("Release_LoadFilterPublicFilter_InputBox",
				PlutoraConfiguration.releasesData);
		/* Verifying Presence of Filter created in Public Filter */
		releasePage.validateElementDisplayed("Release_LoadFilterPublicFilterName_DropDownItem", "Filter_Name",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		/* Clicking Filter from Public filter */
		releasePage.clickElementUsingJavaScript("Release_LoadFilterPublicFilterName_DropDownItem", "Filter_Name",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		/* Clicking on 'Apply Filter' */
		releasePage.clickElementUsingJavaScript("Release_ApplyFilter_Button", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Filter Result */
		//releasePage.validateElementDisplayed("Release_Name_Link", "Release_Test_Automation_Id",
		//		PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Test_Automation_Id"));
	}
	
	@Test (description="View/Clear")
	public void moduleReleaseSchedule_12() throws InterruptedException, ParseException{
		
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
				PlutoraConfiguration.objectData, "Release_Test_Automation_Id", "65", "70");
		/* Navigating to Release page */
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.findProjectReleaseInSchedule(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "70");
		/* Verifying Results */
		releasePage.validateElementDisplayed("Release_Name_Link", "Release_Test_Automation_Id",
				PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		releasePage.verifyAssertTrue(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Implementation_Date")
				.contains(releasePage.getTextData("ReleaseSchedule_FirstImplementationDate_Text",
						PlutoraConfiguration.releasesData)));
		/* Clicking On Clear Button */
		releasePage.clickElementUsingJavaScript("Release_Clear_Button", PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verify Absence Filter Result */
		releasePage.verifyAssertTrue(!(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Implementation_Date").contains(releasePage.getTextData("ReleaseSchedule_FirstImplementationDate_Text",
						PlutoraConfiguration.releasesData))));

	}

}
