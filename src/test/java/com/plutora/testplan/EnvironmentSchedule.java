package com.plutora.testplan;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class EnvironmentSchedule {
	
	EnvironmentPage environmentPage=new EnvironmentPage();
	EnvironmentGroupsPage envGrpPage = new EnvironmentGroupsPage();
	ReleasePage releasePage = new ReleasePage();
	TECRPage tecrPage = new TECRPage();
	TEBRPage tebrPage = new TEBRPage();
	
	@Test (description=" -> Date Range")
	public void environmentSchedule_01() throws InterruptedException, ParseException {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.selectDateRange(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Verify
		environmentPage.verifyText("EnvironmentSchedule_Date",environmentPage.getTodayDate("0", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		Listener.addLogger(environmentPage.getTodayDate("0", "dd/MM/yyyy")+" Start date selected successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Date",environmentPage.getTodayDate("365", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		Listener.addLogger(environmentPage.getTodayDate("365", "dd/MM/yyyy")+" End date selected successfully !");
		environmentPage.verifyTextContains("EnvironmentSchedule_Date_Panel",environmentPage.getTodayDate("0", "yyyy"),PlutoraConfiguration.environmentData);
		Listener.addLogger(environmentPage.getTodayDate("0", "yyyy")+"  date displayed in environment scheduler successfully !");
	}
	
	@Test (description=" -> Filters -> Systems")
	public void environmentSchedule_02() throws InterruptedException, ParseException  {
		//System Creation one
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" - New System is created successfully !");
		//System Creation two
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_2")+" - New System is created successfully !");
		
		//EG creation one
		envGrpPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGrpPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" - Environment group is created successfully !");
		//EG creation two
		envGrpPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1", "EnvGrp_Automation_1","Systems_Automation_1");
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2", "EnvGrp_Automation_2","Systems_Automation_2");
		
		//Project Release Creation
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project release is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_1","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Environment_Automation_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Automation_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Enterprise creation
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_2","Releases_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.searchEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Environment_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name is drag & dropped successfully to environment section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section", "EnvGrp_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment section !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Environment Scheduler
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save_Button",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_2");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		//Verification in System filter
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Systems_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" - System verified in filter successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Systems_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_2")+" - System verified in filter successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		//Verification in Environment scheduler panel
		environmentPage.verifyText("EnvironmentSchedule_System_Name", "Systems_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" - System verified in environment scheduler panel successfully !");
		environmentPage.verifyText("EnvironmentSchedule_System_Name", "Systems_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_2")+" - System verified in environment scheduler panel successfully !");
		
	}

	@Test (description=" -> Filters -> Environment ")
	public void environmentSchedule_03() throws InterruptedException  {
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save_Button",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		//Verification in System filter
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment verified in filter successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment verified in filter successfully !");
		environmentPage.sleep(2000);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		//Verification in Environment scheduler panel
		environmentPage.verifyText("EnvironmentSchedule_Environment_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment verified in environment scheduler panel successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Environment_Name", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment verified in environment scheduler panel successfully !");
	}
	
	@Test (description=" -> Filters -> Release ID/Name ")
	public void environmentSchedule_04() throws InterruptedException  {
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Toggle_Icon",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Enterprise_Enable_Checkbox","EnvironmentSchedule_Release_Filter_Enterprise_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		environmentPage.selectReleaseFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Project_Enable_Checkbox","EnvironmentSchedule_Release_Filter_Project_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		environmentPage.selectReleaseFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		//Verification in Release filter
		environmentPage.verifyTextContains("EnvironmentSchedule_Filter_Name", "Enterprise_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" - Release verified in filter successfully !");
		environmentPage.verifyTextContains("EnvironmentSchedule_Filter_Name", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" -  Release verified in filter successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		//Verification in Environment scheduler panel
		environmentPage.verifyText("EnvironmentSchedule_Release_Name", "Enterprise_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" - Release verified in environment scheduler panel successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Release_Name", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" - Release verified in environment scheduler panel successfully !");
	}

	@Test (description=" -> Save Filter / Load Filter")
	public void environmentSchedule_05() throws InterruptedException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save_Button",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_2");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save_Button",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		
		//environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.saveFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Save_Filter", "Save_Filter_Description");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		
		environmentPage.loadFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Save_Filter", "Load_Filter_Description");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		//Verification in System filter
		
		/*environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Systems_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" - System verified in filter successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Systems_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_2")+" - System verified in filter successfully !");*/
		//Verification in Environment filter
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" - Environment verified in filter successfully !");
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Environment_Automation_2",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" - Environment verified in filter successfully !");
		
		environmentPage.deleteLoadFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Save_Filter");
		
	}
	@Test (description=" -> Timeline Scale")
	public void environmentSchedule_06() throws InterruptedException, ParseException  {
		//All
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.selectDateRange(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_All_Option",PlutoraConfiguration.objectData);
		EnvironmentPage.driver.findElement(By.xpath("(//div[text()='"+environmentPage.getTodayDate("0", "yyyy")+" - "+environmentPage.getQuarter()+"']/ancestor::table//following-sibling::table//div[text()='"+environmentPage.getTodayDate("0", "MMM")+"'])[1]")).isDisplayed();
		Listener.addLogger("Environment scheduler - Timeline Scale - All - "+environmentPage.getTodayDate("0", "yyyy")+" - "+environmentPage.getQuarter()+" - "+environmentPage.getTodayDate("0", "MMM")+" displayed successfully !");
		//Weekly
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Weekly_Option",PlutoraConfiguration.objectData);
		environmentPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Date_Panel").replace("TEXT",environmentPage.getTodayDate("0", "EEE dd MMM")),environmentPage.getTodayDate("0", "EEE dd MMM").toUpperCase());
		Listener.addLogger("Environment scheduler - Timeline Scale - Weekly - "+environmentPage.getTodayDate("0", "EEE dd MMM")+" displayed successfully !");
		//Monthly
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Monthly_Option",PlutoraConfiguration.objectData);
		environmentPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Date_Panel").replace("TEXT",environmentPage.getTodayDate("0", "MMM yyyy")),environmentPage.getTodayDate("0", "MMM yyyy").toUpperCase());
		Listener.addLogger("Environment scheduler - Timeline Scale - Monthly - "+environmentPage.getTodayDate("0", "MMM yyyy")+" displayed successfully !");
		//Quartely
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Quarterly_Option",PlutoraConfiguration.objectData);
		EnvironmentPage.driver.findElement(By.xpath("(//div[text()='"+environmentPage.getTodayDate("0", "yyyy")+"']/ancestor::table//following-sibling::table//div[text()='"+environmentPage.getQuarter()+"'])[1]")).isDisplayed();
		Listener.addLogger("Environment scheduler - Timeline Scale - Quartely - "+environmentPage.getTodayDate("0", "yyyy")+" - "+environmentPage.getQuarter()+" displayed successfully !");
		//Yearly
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Yearly_Option",PlutoraConfiguration.objectData);
		environmentPage.verifyText("EnvironmentSchedule_Date_Panel",environmentPage.getTodayDate("0", "yyyy"),PlutoraConfiguration.environmentData);
		Listener.addLogger("Environment scheduler - Timeline Scale - Yearly - "+environmentPage.getTodayDate("0", "yyyy")+" displayed successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Timeline_All_Option",PlutoraConfiguration.objectData);
	}
	@Test (description=" -> Conflict View (View By System Grouping) -> add/edit/delete TECR ")
	public void environmentSchedule_07() throws InterruptedException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - System - Conflict option selected successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.openTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_1");
		//TECR creation
		tecrPage.creationTECRForEnvironmentSchedule(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation","TECR_SaveButton","TECR_Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" created successfully !");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" deleted successfully !");
	}
	@Test (description=" -> Conflict View (View By Environment Grouping) -> add/edit/delete TECR ")
	public void environmentSchedule_08() throws InterruptedException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Environment - Conflict option selected successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);

		environmentPage.sleep(2000);
		environmentPage.openTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" displayed in TECR details page successfully !");
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" displayed in TECR details page successfully !");
		//TECR creation
		tecrPage.creationTECRForEnvironmentSchedule(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation","TECR_SaveButton","TECR_Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" created successfully !");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tecrPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" deleted successfully !");
		
	}
	@Test (description=" -> Project View -> add/edit/delete TECR ")
	public void environmentSchedule_09() throws InterruptedException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Release option selected successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		environmentPage.openTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation_Name");
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" displayed in TECR details page successfully !");
		//TECR creation
		tecrPage.creationTECRForEnvironmentSchedule(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Project_Automation","TECR_SaveButton","TECR_Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Project_Automation")+" created successfully !");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Project_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Project_Automation")+" deleted successfully !");
	}
	
	@Test (description=" -> Environment Group View -> add/edit/delete TECR ")
	public void environmentSchedule_10() throws InterruptedException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Environment Group option selected successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		//Verification in EG filter
		environmentPage.verifyText("EnvironmentSchedule_EG_Filter_Name", "EnvGrp_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" - Environment Group verified in filter successfully !");
		environmentPage.sleep(2000);
		//environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.openESTECRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		environmentPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" displayed in TECR details page successfully !");
		//TECR creation
		tecrPage.creationTECRForEnvironmentSchedule(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TECR_Automation","TECR_ES_SaveButton","TECR_ES_Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" created successfully !");
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		tecrPage.deleteNewlyCreatedTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TECR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Automation")+" deleted successfully !");
	}
	
	
	@Test (description=" -> Conflict View (View By System Grouping) -> add/edit/delete TEBR ")
	public void environmentSchedule_12() throws InterruptedException, ParseException  {
		//System Creation one
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation")+" - New System is created successfully !");
				
		//EG creation one
		envGrpPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGrpPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation","Systems_Automation");
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - System - Conflict option selected successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Clear_Button",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_UnallocatedEnvironment_Checkbox",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(3000);
		environmentPage.openTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//TEBR creation
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","TEBR_Automation","TEBR");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" created successfully !");
		environmentPage.doubleClick("EnvironmentSchedule_TEBR_Event",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.click("TEBR_Description_Name","TEBR_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		tebrPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
	}
	
	@Test (description=" -> Conflict View (View By Environment Grouping) -> add/edit/delete TEBR ")
	public void environmentSchedule_13() throws InterruptedException, ParseException  {
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Environment - Conflict option selected successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(3000);
		environmentPage.openTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//TEBR creation
		tebrPage.creationESTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","TEBR_Automation","TEBR_ES_Save&Close_Button","Text");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" created successfully !");
		environmentPage.doubleClick("EnvironmentSchedule_TEBR_Event",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_ES_Save_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_ES_Save&Close_Button", PlutoraConfiguration.objectData);
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
	}
	
	@Test (description=" -> Conflict View (View By no Grouping) -> add/edit/delete TEBR ")
	public void environmentSchedule_14() throws InterruptedException, ParseException  {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - None - Conflict option selected successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		//environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_None_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(3000);
		environmentPage.openTEBRDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//TEBR creation
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","TEBR_Automation","TEBR");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" created successfully !");
		environmentPage.doubleClick("EnvironmentSchedule_TEBR_Event",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
	}
	
	@Test (description=" -> Project View -> add/edit/delete booking ")
	public void environmentSchedule_15() throws InterruptedException, ParseException  {
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation", "Enterprise_Automation_Name", "0");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_2","Releases_Systems_CodeImplementation_Section","");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.searchEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_2");
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section", "Environment_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Release - Conflict option selected successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Toggle_Icon",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Enterprise_Enable_Checkbox","EnvironmentSchedule_Release_Filter_Enterprise_Disable_Checkbox",PlutoraConfiguration.objectData,"xpath");
		environmentPage.selectReleaseFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		//Verification in Release filter
		environmentPage.verifyTextContains("EnvironmentSchedule_Filter_Name", "Enterprise_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" - Release verified in filter successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(3000);
		environmentPage.openBookingDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		//Booking creation
		environmentPage.createMyEnvironmentBooking(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")+" new booking added successfully !");
		environmentPage.editMyEnvironmentBooking(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Approved","EnvGrp_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")+" new booking updated successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Environment_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyText("Release_Environment_EnvironmentGroup_Name", "EnvGrp_Automation_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")+" new booking is verified successfully !");

		releasePage.clickButton("Release_Environment_Booking_Name_Close_Icon", "EnvGrp_Automation_2", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.clickButton("Release_Environment_Booking_Close_Icon", "Environment_Automation_2", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Release_Tab");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData, "AddRelease_RemoveEnvironment_Save&CloseButton", PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Release - Conflict option selected successfully !");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation_Name")+" new booking deleted successfully !");
	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.click("Release_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}

	
	@Test (description=" -> Env.Group View -> add/edit/delete booking ")
	public void environmentSchedule_16() throws InterruptedException, ParseException  {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Environment Group option selected successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_EnvironmentGroup_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_2");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_None_Label",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.sleep(3000);
		environmentPage.clickOnHold("EnvironmentSchedule_EG_TEBR_Panel",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		//TEBR creation
		tebrPage.creationTEBRWithEnvironmentGroup(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation_2","TEBR_Automation","TEBR","TEBR_ES_Save&Close_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" created successfully !");
		/*---environmentPage.doubleClick("EnvironmentSchedule_TEBR_Event",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("1", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("1", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_EndDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_StartDate_Calender_Icon", PlutoraConfiguration.objectData);
		tebrPage.applicationDatePicker(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, "MyEnvironmentBooking_DatePicker_Calender", environmentPage.getTodayDate("2", "dd-MMMM-yyyy"));
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Additional_information_DateTimePicker_Done_Button", PlutoraConfiguration.objectData);
		
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_StartDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		environmentPage.verifyTextAttributeValueContains("MyEnvironmentBooking_EndDate_Calender_Text", environmentPage.getTodayDate("2", "dd/MM/yyyy"),PlutoraConfiguration.environmentData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.objectData);----*/
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Automation")+" deleted successfully !");
		
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")+" is deleted successfully !");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGrpPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		envGrpPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGrpPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_2");
		envGrpPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGrpPage.clickOnButton(PlutoraConfiguration.environmentData,"ENVGroups_CloseButton", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_2")+" is deleted successfully !");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_2")+" is deleted successfully !");
	}
	
	@Test (description=" -> view/clear ")
	public void environmentSchedule_11() throws InterruptedException  {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Environment - Conflict option selected successfully !");
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.selectSystemFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
	
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		//System view verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.verifyText("EnvironmentSchedule_System_Filter_LeftSection_Name", "Systems_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" displayed in Right section of System filter successfully !");
		
		//System clear verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Clear_Button",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" not displayed in System filter successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_System_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Label",PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		//Environment view verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.verifyText("EnvironmentSchedule_Filter_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" displayed in Right section of environment filter successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ClearFilter_Button",PlutoraConfiguration.objectData);
		
		//Environment clear verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" not displayed in Environment filter successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Environment_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		//Project View verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Release option selected successfully !");
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Toggle_Icon",PlutoraConfiguration.objectData);
		environmentPage.verifyTextContains("EnvironmentSchedule_Release_Filter_LeftSection_Name", "Project_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" displayed in Right section of Release filter successfully !");
		environmentPage.verifyTextContains("EnvironmentSchedule_Release_Filter_LeftSection_Name", "Enterprise_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" displayed in Right section of Release filter successfully !");
		
		//Project Clear verification
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Clear_Button",PlutoraConfiguration.objectData);
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" not displayed in Release filter successfully !");
		environmentPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" not displayed in Release filter successfully !");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Release_Filter_Save&Close_Button",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Filter_Apply_Button",PlutoraConfiguration.objectData);
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation");
		releasePage.sleep(2000);
		releasePage.clickElementUsingJavaScript("Releases_Tab",PlutoraConfiguration.releasesData);
		releasePage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		releasePage.deleteRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	}
	
	@Test (description=" -> Overview View")
	public void environmentSchedule_17() throws InterruptedException  {
		//Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation", "EnvGrp_Automation_1","Systems_Automation_1");
	
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tecrData,"AddTECR_Tab",PlutoraConfiguration.objectData);
		environmentPage.clickWebElementButton(PlutoraConfiguration.tebrData,"TEBR_Label",PlutoraConfiguration.objectData);
		
		tebrPage.creationTEBRWithEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","TEBR_Automation","");
		
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_ViewAs_Dropdown",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_Overview_Option",PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Overview option selected successfully !");
		environmentPage.waitForLoadingIconDisappear(1000,"Loading_Gif",PlutoraConfiguration.objectData);
		
		environmentPage.scrollToElement("EnvironmentSchedule_Overview_Name", "EnvGrp_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("EnvironmentSchedule_Overview_Name", "EnvGrp_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" verified in Environment scheduler overview section successfully !");
		
		environmentPage.clickButton("EnvironmentSchedule_Overview_Phase_Icon", "EnvGrp_Automation_1", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" phase expanded successfully !");
		
		environmentPage.verifyText("EnvironmentSchedule_Overview_Name", "Systems_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" verified in Environment scheduler overview section successfully !");
		
		environmentPage.clickButton("EnvironmentSchedule_Overview_System_Icon", "EnvGrp_Automation_1", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" system expanded successfully !");
		
		environmentPage.verifyText("EnvironmentSchedule_Overview_Name", "Environment_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" verified in Environment scheduler overview section successfully !");
		
		environmentPage.verifyText("EnvironmentSchedule_Overview_Name", "Environment_Automation_1",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" verified in Environment scheduler overview section successfully !");
		
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" is deleted successfully !");
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")+" is deleted successfully !");
		
		environmentPage.goToEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		envGrpPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation_1");
		envGrpPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		envGrpPage.clickOnButton(PlutoraConfiguration.environmentData,"ENVGroups_CloseButton", PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")+" is deleted successfully !");
		
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")+" is deleted successfully !");
		
	}
	
	@Test(description = "Adjust Row Height")
	public void environmentSchedule_18() throws InterruptedException {
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_ViewAs_Dropdown",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Release_Option",
				PlutoraConfiguration.objectData);
		Listener.addLogger("View As - Release option selected successfully !");
		environmentPage.waitForLoadingIconDisappear(1000, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Timeline_Dropdown",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,
				"EnvironmentSchedule_Timeline_Monthly_Option", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Height_DropDown",
				PlutoraConfiguration.objectData);
		environmentPage.click("EnvironmentSchedule_RowHeight_SliderBar", PlutoraConfiguration.environmentData);
		environmentPage.sleep(3000);
		environmentPage.click("EnvironmentSchedule_HeightAdjust_CloseIcon",
				PlutoraConfiguration.environmentData);
		environmentPage.sleep(2000);
		//int row_height_1 = environmentPage.getElementHeight("EnvironmentSchedule_ProjectReleases_FirstRow",
		//		PlutoraConfiguration.environmentData);
		int row_height_1 = envGrpPage.driver.findElement(By.xpath("//colgroup[@role='presentation']/following-sibling::tbody//tr[2]/td")).getSize().getHeight();
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Height_DropDown",
				PlutoraConfiguration.objectData);
		environmentPage.dragAndDropByOffset("EnvironmentSchedule_RowHeight_Slider",
				PlutoraConfiguration.environmentData, "80", "0");
		environmentPage.sleep(2000);
		//int row_height_2 = environmentPage.getElementHeight("EnvironmentSchedule_ProjectReleases_FirstRow",
		//		PlutoraConfiguration.environmentData);
		int row_height_2=envGrpPage.driver.findElement(By.xpath("//colgroup[@role='presentation']/following-sibling::tbody//tr[2]/td")).getSize().getHeight();
		environmentPage.verifyAssertTrue(row_height_2>row_height_1);
		Listener.addLogger("Verified Row height Increase...");

	}
	
	@Test(description = "Adjust Bar Height")
	public void environmentSchedule_19() throws InterruptedException, ParseException {
		// System Creation one
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")
				+ " - New System is created successfully !");
		// EG creation one
		envGrpPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGrpPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		envGrpPage.clickElementUsingJavaScript("MyEnvironmentBooking_Save&Close_Button", PlutoraConfiguration.environmentData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")
				+ " - Environment group is created successfully !");
		// Environment Creation
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1", "EnvGrp_Automation_1",
				"Systems_Automation_1");
		// Project Release Creation
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project release is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Automation_1",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Environment_Automation_1", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Automation_1", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_ViewAs_Dropdown",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Release_Option",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_QuickFilter_Dropdown",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_ClearFilter_Button",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Release_Toggle_Icon",
				PlutoraConfiguration.objectData);
		environmentPage.selectReleaseFilter(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,
				"EnvironmentSchedule_Release_Filter_Save&Close_Button", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Filter_Apply_Button",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Height_DropDown",
				PlutoraConfiguration.objectData);
		environmentPage.click("EnvironmentSchedule_BarHeight_SliderBar", PlutoraConfiguration.environmentData);
		environmentPage.sleep(3000);
		environmentPage.clickElementUsingJavaScript("EnvironmentSchedule_AdjustHeights_CloseIcon",
				PlutoraConfiguration.environmentData);
		environmentPage.sleep(2000);
		int bar_height_1 = environmentPage.getElementHeight("EnvironmentSchedule_EnvGrp_FirstRowBar",
				PlutoraConfiguration.environmentData,"EnvGrp_Automation_1",PlutoraConfiguration.testData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Height_DropDown",
				PlutoraConfiguration.objectData);
		environmentPage.dragAndDropByOffset("EnvironmentSchedule_BarHeight_Slider",
				PlutoraConfiguration.environmentData, "80", "0");
		environmentPage.sleep(2000);
		int bar_height_2 = environmentPage.getElementHeight("EnvironmentSchedule_EnvGrp_FirstRowBar",
				PlutoraConfiguration.environmentData,"EnvGrp_Automation_1",PlutoraConfiguration.testData);
		environmentPage.verifyAssertTrue(bar_height_2>bar_height_1);
		Listener.addLogger("Verified Bar height Increase...");
	}
	
	@Test(description = "Schedule filtering")
	public void environmentSchedule_20() throws InterruptedException, ParseException {
		environmentPage.refresh(PlutoraConfiguration.objectData);
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new SystemsPage().creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Automation_1")
				+ " - New System is created successfully !");
		envGrpPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		envGrpPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation_1");
		envGrpPage.clickElementUsingJavaScript("MyEnvironmentBooking_Save&Close_Button",
				PlutoraConfiguration.environmentData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation_1")
				+ " - Environment group is created successfully !");
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1", "EnvGrp_Automation_1",
				"Systems_Automation_1");
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")
				+ " - Project release is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Automation_1",
				"Releases_Change_Systems_CodeImplementation_Section", "");
		releasePage.clickOnEnvironmentTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(1000);
		releasePage.dragAndDrop("Releases_Environment_Section", "Releases_DropEnvironment_Section",
				"Environment_Automation_1", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Name drag & dropped successfully to environment booking section !");
		releasePage.clickOnReleaseSaveButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.dragAndDrop("Release_Environment_EnvGroup_Name", "Releases_DropEnvironment_Section",
				"EnvGrp_Automation_1", PlutoraConfiguration.releasesData, PlutoraConfiguration.testData);
		Listener.addLogger("Environment Group is drag & dropped successfully to environment booking section !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		environmentPage.gotoEnvironmentSchedule(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_QuickFilter_Dropdown",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_ClearFilter_Button",
				PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "EnvironmentSchedule_Filter_Apply_Button",
				PlutoraConfiguration.objectData);
	}
	
	@Test (description="Copy Filter (for both logged in and logged out scenarios)")
	public void environmentSchedule_21() throws InterruptedException, AWTException, HeadlessException, UnsupportedFlavorException, IOException {	
		/*Navigating to Environment page*/
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		/*Creating Environment*/
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
	    /*Finding And Opening Environment*/
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		/*Clicking Show upcoming bookings for this Environment*/
		environmentPage.click("Environment_Allocation_Schedule_Button",PlutoraConfiguration.environmentData);
		environmentPage.switchToWindow(4000, "parentWindow");
		WebGenericUtilLib.driver.get(WebGenericUtilLib.driver.getCurrentUrl());
		environmentPage.waitForLoadingIconDisappear(300,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"EnvironmentSchedule_QuickFilter_Dropdown",PlutoraConfiguration.objectData);
	    /*Clicking on Copy Filter Icon*/
		environmentPage.click("EnvironmentSchedule_Copy_Filter",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear(300,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(4000);
		/*Getting data from clipboard*/
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		/*Navigating to the copied URL*/
		environmentPage.closeWindowTab();
		WebGenericUtilLib.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData,"parentWindow"));
		environmentPage.sleep(4000);
		WebGenericUtilLib.launchUrl(dstData);
		/*Verifying Environment Name*/
		environmentPage.verifyText("EnvironmentSchedule_Environment_Name", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" redirected to environment details page after performing copy URL to clipboard for logged in session successfully !");
		/*Logging out*/
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		/*Navigating to the copied URL*/
		EnvironmentPage.launchUrl(dstData);
		/*Verifying elements*/
		environmentPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		environmentPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		EnvironmentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
		environmentPage.verifyText("EnvironmentSchedule_Environment_Name", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" redirected to environment details page after performing copy URL to clipboard for logged in session successfully !");
	}

}
