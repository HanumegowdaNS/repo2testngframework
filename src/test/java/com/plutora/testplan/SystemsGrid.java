package com.plutora.testplan;


import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SystemsGrid {

	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test(description = "Sub-ares:Add Systems")
	public void systemsGrid_01() throws InterruptedException {
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


	@Test (description="Sub-area:systems grid -> Export to XLS")
	public void systemsGrid_02() throws InterruptedException {
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

	@Test(description="Sub-area:systems grid -> Search By Systems Name/Portfolio Association/Accountable Stakeholder")
	public void systemsGrid_03() throws InterruptedException {
		
	}

	@Test(description="Sub-area:systems grid ->Filter by: My Portfolio Association/I'm a Stakeholder/All")
	public void systemsGrid_04() throws InterruptedException {
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

	@Test(description="Sub-area:systems grid -> Query Builder")
	public void systemsGrid_05() throws InterruptedException {
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

	@Test(description="Sub-area: systems grid -> Grid Column Selector")
	public void systemsGrid_06() throws InterruptedException {
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
	
	@Test(description="Sub-area: systems grid -> Grid Column Filtering")
	public void systemsGrid_07() throws InterruptedException {
		
	}

	@Test(description="Sub-area: systems grid -> Duplicate Systems")
	public void systemsGrid_08() throws InterruptedException {
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

	@Test(description="Sub-area: systems grid -> Bulk Update")
	public void systemsGrid_09() throws InterruptedException {
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_BulkUpdate_1");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_BulkUpdate_2");
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_BulkUpdate_");
		systemsPage.click("Systems_Name_Checkbox", "Systems_Test_Automation_BulkUpdate_1",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);
		systemsPage.click("Systems_Name_Checkbox", "Systems_Test_Automation_BulkUpdate_2",
				PlutoraConfiguration.systemsData, PlutoraConfiguration.testData);

		systemsPage.updateSystemBulk(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
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
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, 
				PlutoraConfiguration.objectData, (PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Bulk")) + " "
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
		systemsPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Bulk");
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

	
}
