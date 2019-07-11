package com.plutora.testplan;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.MainMenuPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;

public class SystemsTab {

	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	ReleasePage releasePage = new ReleasePage();

	public static String userName = null;

	@Test(description = "Systems -> Systems Tab")
	public void subareaSystemsWindowSystemsTab_01() throws InterruptedException, AWTException {

		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		Listener.addLogger("Systems is created successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.verifyText("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger("Systems is verified successfully !");
		systemsPage.clickAndUpdateNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.verifyText("Systems_Shakeholder_Name_Value", SystemsPage.assignedTo,
				PlutoraConfiguration.systemsData);
		Listener.addLogger("Systems is updated successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.createDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.verifyText("Systems_Name", "Copy_Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger("Duplicate System is created successfully !");
		systemsPage.deleteNewlyCreatedDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.verifyTextContains("System_NoData_Label", "No data", PlutoraConfiguration.systemsData);
		Listener.addLogger("Duplicate System is deleted successfully !");
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.deleteNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.sleep(1000);
		systemsPage.verifyTextContains("System_NoData_Label", "No data", PlutoraConfiguration.systemsData);
		Listener.addLogger("Systems is deleted successfully !");
		systemsPage.sleep(1000);
	}

	@Test(description = "Search by Systems Name")
	public void subareaSystemsWindowSystemsTab_02() throws InterruptedException, AWTException {
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		Listener.addLogger("Systems is created successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.verifyText("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger("System' displayed successfully !");
	}

	@Test(description = "Export to XLS")
	public void subareaSystemsWindowSystemsTab_03() throws InterruptedException, AWTException {
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		Listener.addLogger("Systems is created successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.clickOnSystemsExportToXLS(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		String excelFile = FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath, "System");
		String[] data = FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath + excelFile, "Systems",
				1);
		System.out.println(data[0].split("\\n")[0].trim());
		systemsPage.verifyTextValue("Systems_Test_Automation_Id", data[0].split("\\n")[0].trim(),
				PlutoraConfiguration.testData);
		Listener.addLogger("System export to XLS is downloaded successfully!");
	}

	@Test(description = "System:Action -> Grid Column Selector")
	public void subareaSystemsWindowSystemsTab_04() throws InterruptedException, AWTException {
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating Systems Customs Field */
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option", "System_CustomField_Name");
		/* Navigating to Systems Page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Adding Grid Column */
		systemsPage.reactAddGridColumnSelector(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				"System_CustomField_Name");
		/* Verifying presence of added column */
		systemsPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name"));
		Listener.addLogger(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name").toUpperCase()
						+ " verified in System grid successfully !");
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Deleting Systems custom field created earlier */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_SystemCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "System_CustomField_Name");
		/* Navigating to Systems Page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Verifying Absence of Deleted Column */
		systemsPage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name").toUpperCase());
		Listener.addLogger(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_CustomField_Name").toUpperCase()
						+ " verified Not displayed !");
	}

	@Test(description = "System -> Filter By(My PortFolio Association, I'm a Stakeholder")
	public void subareaSystemsWindowSystemsTab_06() throws InterruptedException, AWTException {
		/* Navigating to Systems Page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		/* Creating New System */
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Finding Newly created System */
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		/* Clicking On 'My Portfolio Association' */
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData, "Systems_PortfolioAssociation_Button");
		/* Verifying Portfolio Association */
		systemsPage.verifyTextContains("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " verified in System Page successfully using Portfolio Association !");
		/* Navigating to the newly created System */
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.clickElementUsingJavaScript("Systems_Name", "Systems_Test_Automation_Id",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		systemsPage.addAccountableStakeholder(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("Systems_SaveButton", PlutoraConfiguration.systemsData);

		/* Finding Newly created System */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData, "Systems_StakeHolder_Button");
		/* Verifying Stakeholder Filter */
		systemsPage.verifyTextContains("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " verified in System Page successfully using Stakeholder Filter !");

		/* Clicking on All Filter */
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData, "Systems_All_Button");
		/* Verifying All Filter */
		systemsPage.verifyTextContains("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " verified in System Page successfully using All Filter !");

	}

	@Test(description = "System -> Bulk Update")
	public void subareaSystemsWindowSystemsTab_07() throws InterruptedException, AWTException {
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_BulkUpdate_1");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_BulkUpdate_2");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.objectData,
				"Systems_Test_Automation_BulkUpdate_");
		systemsPage.click("Systems_Name_Checkbox", "Systems_Test_Automation_BulkUpdate_1",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		systemsPage.click("Systems_Name_Checkbox", "Systems_Test_Automation_BulkUpdate_2",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);

		systemsPage.updateSystemBulk(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.objectData,
				"Systems_Test_Automation_Bulk");
		systemsPage.clickElementUsingJavaScript("Systems_Name", "Systems_Test_Automation_Bulk",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		Listener.addLogger("Validating Upadation for first System...");
		Listener.addLogger("Validating System Name Input Box...");
		Thread.sleep(3000);
		Assert.assertEquals(systemsPage.getTextData("System_Title_Text", PlutoraConfiguration.systemsData),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk"));
		Thread.sleep(1000);
		Assert.assertEquals(systemsPage.getTextData("System_Description_TextBox", PlutoraConfiguration.systemsData),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Description"));
		Thread.sleep(1000);
		systemsPage.validateElementDisplayed("Systems_InActive_Button", PlutoraConfiguration.systemsData);
		Thread.sleep(1000);
		Assert.assertEquals(
				systemsPage.getAttributeValue("Systems_Vendor_Text",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Vendor"),
						PlutoraConfiguration.systemsData, "value"),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Vendor"));
		Thread.sleep(2000);
		Assert.assertEquals(
				systemsPage.getAttributeValue("Systems_Portfolio_Text",
						PropertiesCache.getProperty(PlutoraConfiguration.testData,
								"System_PortfolioAssociation_ListSecondItem"),
						PlutoraConfiguration.systemsData, "value"),
				PropertiesCache.getProperty(PlutoraConfiguration.testData,
						"System_PortfolioAssociation_ListSecondItem"));
		Listener.addLogger("Portfolio Association Verified");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.objectData,
				(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk")) + " "
						+ "(1)");
		Listener.addLogger((PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk"))
				+ " " + "(1)");
		systemsPage.clickElementUsingJavaScript("Systems_Name",
				(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk")) + " "
						+ "(1)",
				PlutoraConfiguration.systemsData);
		Thread.sleep(3000);
		Listener.addLogger("Validating Upadation for Second System...");
		Listener.addLogger("Validating System Name Input Box...");
		Assert.assertEquals(systemsPage.getTextData("System_Title_Text", PlutoraConfiguration.systemsData),
				(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk")) + " "
						+ "(1)");
		Thread.sleep(1000);
		Assert.assertEquals(systemsPage.getTextData("System_Description_TextBox", PlutoraConfiguration.systemsData),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Description"));
		Thread.sleep(1000);
		systemsPage.validateElementDisplayed("Systems_InActive_Button", PlutoraConfiguration.systemsData);

		Thread.sleep(1000);
		Assert.assertEquals(
				systemsPage.getAttributeValue("Systems_Vendor_Text",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Vendor"),
						PlutoraConfiguration.systemsData, "value"),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Vendor"));
		Thread.sleep(2000);
		Assert.assertEquals(
				systemsPage.getAttributeValue("Systems_Portfolio_Text",
						PropertiesCache.getProperty(PlutoraConfiguration.testData,
								"System_PortfolioAssociation_ListSecondItem"),
						PlutoraConfiguration.systemsData, "value"),
				PropertiesCache.getProperty(PlutoraConfiguration.testData,
						"System_PortfolioAssociation_ListSecondItem"));
		Thread.sleep(1000);
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.objectData,
				"Systems_Test_Automation_Bulk");
		Thread.sleep(3000);
		systemsPage.click("Systems_Name_Checkbox",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk"),
				PlutoraConfiguration.systemsData);

		systemsPage.click("Systems_Name_Checkbox",
				(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk")) + " "
						+ "(1)",
				PlutoraConfiguration.systemsData);
		systemsPage.deleteSystemBulk(PlutoraConfiguration.systemsData, PlutoraConfiguration.objectData);
		Listener.addLogger("Systems Deleted Successfully");

	}

	@Test(description = "Action -> Duplicate System")
	public void subareaSystemsWindowSystemsTab_08() throws InterruptedException, AWTException {
		/* Navigating to System page */
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		Listener.addLogger("Systems is created successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.verifyText("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger("Systems is verified successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemsPage.createDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedDuplicateSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.verifyText("Systems_Name", "Copy_Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Listener.addLogger("Duplicate System is created successfully !");
		/* Navigating to the Duplicate System */
		systemsPage.clickElementUsingJavaScript("Systems_Name",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Copy_Systems_Test_Automation_Id"),
				PlutoraConfiguration.systemsData);
		/* Verifying the System Details */
		Listener.addLogger("Validating System Name Input Box...");
		Thread.sleep(3000);
		Assert.assertEquals(systemsPage.getTextData("System_Title_Text", PlutoraConfiguration.systemsData),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Copy_Systems_Test_Automation_Id"));
		Thread.sleep(1000);

		Assert.assertEquals(systemsPage.getTextData("System_Description_TextBox", PlutoraConfiguration.systemsData),
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "New_Systems_Description_Value"));
		Listener.addLogger("Duplicate System is verified successfully !");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}

	
	@Test(description = "System -> Query Builder (QB) + Quick Access menu")
	public void subareaSystemsWindowSystemsTab_10() throws InterruptedException, AWTException {
		/* Creating System */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Searching for Newly created System */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		/* Clearing Search */
		systemsPage.clearCharacters("Systems_SearchSystemName", PlutoraConfiguration.systemsData);
		systemsPage.clickOnButton(PlutoraConfiguration.systemsData, "Systems_All_Button");
		/* Adding a new Public Query */
		systemsPage.clickReactNewQueryBuilder(PlutoraConfiguration.objectData);
		systemsPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System Name",
				"contains", "Systems_Test_Automation_Id", "1");
		/* Saving And Running The Query */
		systemsPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public",
				"Query_Public_Builder");
		systemsPage.verifyText("Systems_Name", "Systems_Test_Automation_Id", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		Thread.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")
				+ " verified public query builder successfully !");
		Thread.sleep(3000);
		systemsPage.clickElementUsingJavaScript("React_QueryBuilder_DropDown_Icon", PlutoraConfiguration.objectData);
		Thread.sleep(4000);
		systemsPage.clickElementUsingJavaScript("React_QueryBuilder_Clear_Button", PlutoraConfiguration.objectData);
		Thread.sleep(3000);

	}

	@Test(description = "System ->Button 'Contact stakeholders' and email notification on it")
	public void subareaSystemsWindowSystemsTab_11() throws InterruptedException, AWTException {

		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);

		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Searching for Newly created system */
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		/* Opening systems Page */
		systemsPage.clickElementUsingJavaScript("Systems_Name", "Systems_Test_Automation_Id",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		systemsPage.addAccountableStakeholder(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "stakeholder_Name");
		/* Navigating to system */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Searching for Newly created system */
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		/* Opening systems Page */
		systemsPage.clickElementUsingJavaScript("Systems_Name", "Systems_Test_Automation_Id",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		/* Clicking on Contact stakeholder */
		systemsPage.contactStakeHolder(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying email Notification */
		systemsPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Email_Subject", PropertiesCache.getProperty(PlutoraConfiguration.testData, "ForgotPassword_Username"));

	}

	/*
	 * 
	 * 
	 * @Test (description="System -> Additional Info Tab -> Grouping fields") public
	 * void subareaSystemsWindowSystemsTab_12() throws InterruptedException,
	 * AWTException { Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking on System Custom Field
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Adding Group
	 * customizationPage.createCustomFieldGroup(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData, "Group");
	 * customizationPage.createCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name");
	 * customizationPage.selectGroupField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "System_CustomField_Name", "Group"); Clicking on Submit
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to Systems Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Clearing existing query if any
	 * systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown",
	 * PlutoraConfiguration.objectData, 10, 0);
	 * systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
	 * PlutoraConfiguration.objectData); Creating System
	 * systemsPage.clickElementUsingJavaScript("AddSystem_Button",
	 * PlutoraConfiguration.systemsData);
	 * systemsPage.creationSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Searching
	 * for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Presence of Group
	 * systemsPage.verifyText("System_CustomField_Name", "Group",
	 * PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Group") + " verified in system page successfully !");
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData); Editing Tab Navigating to Customization
	 * Page customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking On Custom Field Option
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Editing Custom Field
	 * customizationPage.editCustomFieldGroup(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData, "Group"); Clicking On Submit Button
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to Systems Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Searching for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Presence of Group
	 * systemsPage.verifyText("System_CustomField_Name", "Group",
	 * PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Group") + " verified in system details page successfully !"); Saving And
	 * Closing Change
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData);
	 * 
	 * Removing Group Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking On Custom Field Option
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Removing Custom Field Tab
	 * customizationPage.removeCustomFieldGroup(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData, "Group"); Clicking on Submit Button
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to Systems Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Searching for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Verifying
	 * Absence of Tab systemsPage
	 * .verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(
	 * PlutoraConfiguration.testData, "Group"));
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Group") + " verified in system details page successfully !"); Clicking On
	 * Save And Close
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData);
	 * 
	 * Deleting Custom Field Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking on Systems Custom Field
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Deleting Custom Field
	 * customizationPage.deleteCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "System_CustomField_Name");
	 * 
	 * }
	 * 
	 * @Test(description = "System  -> Addtional Info -> Information tooltip")
	 * public void subareaSystemsWindowSystemsTab_13() throws InterruptedException,
	 * ParseException {
	 * 
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.createCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name");
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.updateCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name",
	 * "System_Tooltip");
	 * 
	 * Navigating to Systems Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Creating System
	 * systemsPage.clickElementUsingJavaScript("AddSystem_Button",
	 * PlutoraConfiguration.systemsData);
	 * systemsPage.creationSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Searching
	 * for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Presence of ToolTip
	 * Assert.assertTrue( ReleasePage.driver .findElement(
	 * By.xpath("//div[contains(text(),'" +
	 * PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "System_CustomField_Name") + "')]/following-sibling::div[@data-qtip='" +
	 * PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Tooltip")
	 * + "']")) .isDisplayed());
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "System_CustomField_Name") + "-" +
	 * PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Tooltip")
	 * + " verified in change details page successfully !");
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData); Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.createCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name");
	 * customizationPage.clickButton(
	 * "Customization_CustomField_UnderLabel_Radiobox", "System_CustomField_Name",
	 * PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.updateCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name",
	 * "System_Label");
	 * 
	 * Navigating to Systems Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData);
	 * 
	 * Searching for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Verifying
	 * System Label systemsPage
	 * .verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.
	 * testData, "System_Label"));
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "System_CustomField_Name") + "-" +
	 * PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Label") +
	 * " verified in release details page successfully !");
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData); Navigating to Customization page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData);
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option");
	 * customizationPage.deleteCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "System_CustomField_Name");
	 * 
	 * }
	 * 
	 * @Test(description = "System -> Additional Information tab -> Sub-Tabs")
	 * public void subareaSystemsWindowSystemsTab_14() throws InterruptedException,
	 * ParseException {
	 * 
	 * Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking on System Custom Field
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Adding Tab
	 * customizationPage.createCustomFieldTab(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData, "Tab");
	 * customizationPage.createCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option", "System_CustomField_Name");
	 * customizationPage.selectTabParent(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "System_CustomField_Name", "Tab"); Clicking on Submit
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to System Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Creating System
	 * systemsPage.clickElementUsingJavaScript("AddSystem_Button",
	 * PlutoraConfiguration.systemsData);
	 * systemsPage.creationSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Searching
	 * for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Presence of Tab
	 * systemsPage.verifyText("System_CustomField_Tab_Name", "Tab",
	 * PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Tab") + " verified in systems details page successfully !"); Saving And
	 * Closing Change
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData);
	 * 
	 * Editing Tab Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking On Custom Field Option
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Editing Custom Field
	 * customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Tab");
	 * Clicking On Submit Button
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to System Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Searching for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Presence of Tab
	 * systemsPage.verifyText("System_CustomField_Tab_Name", "Tab",
	 * PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Tab") + " verified in systems details page successfully !"); Saving And
	 * Closing Change
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData); Removing Tab Navigating to Customization
	 * Page customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking On Custom Field Option
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Removing Custom Field Tab
	 * customizationPage.removeCustomFieldTab(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData, "Tab"); Clicking on Submit Button
	 * customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.objectData); Navigating to System Page
	 * environmentPage.getSystemsPage(PlutoraConfiguration.environmentData,
	 * PlutoraConfiguration.objectData); Searching for Newly created system
	 * systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "Systems_Test_Automation_Id"); Opening systems Page
	 * systemsPage.openSystemPage(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData); Clicking on
	 * additional Info tab
	 * systemsPage.clickElementUsingJavaScript("Systems_AdditionalInformation_Tab",
	 * PlutoraConfiguration.systemsData); Verifying Absence of Tab systemsPage
	 * .verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(
	 * PlutoraConfiguration.testData, "Tab"));
	 * Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData,
	 * "Tab") + " verified in change details page successfully !"); Clicking On Save
	 * And Close
	 * systemsPage.clickOnSaveAndCloseButton(PlutoraConfiguration.systemsData,
	 * PlutoraConfiguration.objectData);
	 * 
	 * Deleting Custom Field Navigating to Customization Page
	 * customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.testData,
	 * PlutoraConfiguration.objectData); Clicking on Change Custom Field
	 * customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.
	 * customizationData, PlutoraConfiguration.objectData,
	 * "Customization_SystemCustomFields_Option"); Deleting Custom Field
	 * customizationPage.deleteCustomField(PlutoraConfiguration.customizationData,
	 * PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
	 * "System_CustomField_Name"); }
	 * 
	 */
}
