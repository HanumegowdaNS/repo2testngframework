package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ChangesWindowAdditionInformationTab {
	ChangesPage changePage = new ChangesPage();
	CustomizationPage customizationPage = new CustomizationPage();
	SystemsPage systemsPage = new SystemsPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	TECRPage tecrPage = new TECRPage();

	@Test(description = "Sub-area: change window -> Additional Information tab -> DataPicker/TimePicker/Data time picker/List Field/List Select/Free Text/Number/Decimal/Currency")
	public void subareaChangeWindowAdditionalInformation_01()
			throws InterruptedException, AWTException, ParseException {

		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.verifyText("Change_Page_Title", "Change_Page_Title_Value", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);

		customizationPage.addChangeDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name");
		customizationPage.click("Customization_Submit_Button", PlutoraConfiguration.customizationData);
		for (int i = 0; i < customizationPage.changeDataTypeOption.size(); i++) {
			customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, customizationPage.changeDataTypeOption.get(i),
					"Change_CustomField_Name");
			changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
			changePage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData);
			changePage.verifyAdditionalInformationField(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
					PlutoraConfiguration.objectData, customizationPage.changeDataTypeOption.get(i));
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
					PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
					PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");

	}

	@Test(description = "Sub-area: change window -> Additional Information tab -> Sub-Tabs")
	public void subareaChangeWindowAdditionalInformation_02() throws InterruptedException, ParseException {

		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Change Custom Field */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");

		/* Adding Tab */
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name", "Tab");
		/* Clicking on Submit */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clearing already existing grid filters if any */
		changePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
	
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Tab */
		changePage.verifyText("Change_CustomField_Tab_Name", "Tab", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in change details page successfully !");
		/* Saving And Closing Change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Editing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		/* Editing Custom Field */
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		/* Clicking On Submit Button */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Tab */
		changePage.verifyText("Change_CustomField_Tab_Name", "Tab", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in change details page successfully !");
		/* Saving And Closing Change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Removing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		/* Removing Custom Field Tab */
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		/* Clicking on Submit Button */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Absence of Tab */
		changePage
				.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in change details page successfully !");
		/* Clicking On Save And Close */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Deleting Custom Field */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Change Custom Field */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		/* Deleting Custom Field */
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name");
	}

	@Test(description = "Sub-area: change window -> Additional Information tab -> Grouping Field")
	public void subareaChangeWindowAdditionalInformation_03() throws InterruptedException, ParseException {

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		/* Adding Group */
		customizationPage.createCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Group");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name");
		customizationPage.selectGroupField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name", "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clearing already existing grid filters if any */
		changePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Group */
		changePage.verifyText("Change_CustomField_Group_Name", "Group", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")
				+ " verified in change details page successfully !");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Editing Group */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.editCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Group */
		changePage.verifyText("Change_CustomField_Group_Name", "Group", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")
				+ " verified in change details page successfully !");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Remove Group */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.removeCustomFieldGroup(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Group");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);

		/* Verifying Absence of Group */
		changePage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Group")
				+ " verified in change details page successfully !");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		/* Deleting Custom field */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name");
	}

	@Test(description = "Sub-area: change window -> Addtional Info -> Information tooltip")
	public void subareaChangeWindowAdditionalInformation_04() throws InterruptedException, ParseException {

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name",
				"Change_Tooltip");

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clearing Filters */
		changePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of ToolTip */
		Assert.assertTrue(
				ReleasePage.driver
						.findElement(
								By.xpath("//div[contains(text(),'"
										+ PropertiesCache.getProperty(PlutoraConfiguration.testData,
												"Change_CustomField_Name")
										+ "')]/following-sibling::div[@data-qtip='"
										+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tooltip")
										+ "']"))
						.isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name") + "-"
				+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Tooltip")
				+ " verified in change details page successfully !");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox", "Change_CustomField_Name",
				PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option", "Change_CustomField_Name",
				"Change_Label");

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.clearGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
		/* Find and Open Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying Change Label */
		changePage
				.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name") + "-"
				+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Label")
				+ " verified in release details page successfully !");
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_ChangeCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_CustomField_Name");

	}

	
	@Test(description = "Sub-area: change window -> System tab -> New System")
	public void subareaChangeWindowAdditionalInformation_05() throws InterruptedException, ParseException {

		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clearing Filters */
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clicking On Systems Tab */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Systems_Tab",
				PlutoraConfiguration.objectData);
		/* Clicking On New Systems */
		changePage.sleep(2000);
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_NewSystem_Button",
				PlutoraConfiguration.objectData);
		/* Switching Window */
		changePage.switchToWindow(4000,"parentWindow");
		changePage.sleep(2000);
		//changePage.driver.get(changePage.driver.getCurrentUrl());
		/* Creating New Change System */
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test");
		systemsPage.closeWindowTab();
		systemsPage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parentWindow"));
		/*Clicking On System Tab*/
		systemsPage.clickElementUsingJavaScript("Change_Systems_Tab", PlutoraConfiguration.changesData);
		/* Entering Newly Created System Name in 'System Available' */
		systemsPage.sendKeys("Change_Systems_SystemAvailable", "Systems_Test", PlutoraConfiguration.changesData,
				PlutoraConfiguration.testData);
		systemsPage.sleep(2000);
		/* Verifying System present in search Result */
		System.out.println(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"));
		systemsPage.validateElementDisplayed("Change_Systems_Name",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"),
				PlutoraConfiguration.changesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")
				+ " verified in change page system search result !");
		/* Clicking on Save & Close */
		systemsPage.clickElementUsingJavaScript("System_Save&CloseButton", PlutoraConfiguration.systemsData);
		systemsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
	}

	@Test(description = "Sub-area: change window -> System tab -> Filter By Portfolio Association")
	public void subareaChangeWindowAdditionalInformation_06() throws InterruptedException, ParseException {
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clearing Filters */
		changePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Clicking On Systems Tab */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Systems_Tab",
				PlutoraConfiguration.objectData);
		/* Clicking On New Systems */
		changePage.sleep(2000);
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_NewSystem_Button",
				PlutoraConfiguration.objectData);
		/* Switching Window */
		changePage.switchToWindow(4000,"parentWindow");
		//changePage.driver.get(changePage.driver.getCurrentUrl());
		/* Creating New Change System */
		changePage.sleep(2000);
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test");
		systemsPage.closeWindowTab();
		systemsPage.driver.switchTo().window(PropertiesCache.getProperty(PlutoraConfiguration.testData, "parentWindow"));
		/* Searching Newly created system */
		systemsPage.sendKeys("System_SearchButton", "Systems_Test", PlutoraConfiguration.systemsData,
				PlutoraConfiguration.testData);
		/* Clicking on Save And Close Button */
		changePage.clickElementUsingJavaScript("Change_SaveClose_Button", PlutoraConfiguration.changesData);
		/* Navigating to Systems */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Search for System using Live search */
		environmentPage.findAndEditEnvironmentSystem(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Searching for a change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Navigate to System */
		changePage.clickOnButton(PlutoraConfiguration.changesData, "Change_Systems_Tab",
				PlutoraConfiguration.objectData);
		/* Selecting Portfolio Association under Organization */
		changePage.clickElementUsingJavaScript("Change_SystemPortfolioAssociation_DownArrow",
				PlutoraConfiguration.changesData);
		changePage.waitForLoadingElement(10, "Change_SystemPortfolioAssociation_ListSecondItem",
				PlutoraConfiguration.changesData);
		changePage.clickElementUsingJavaScript("Change_SystemPortfolioAssociation_ListSecondItem",
				PlutoraConfiguration.changesData);
		/* Verifying Presence of System */
		changePage.validateElementDisplayed("Change_Systems_Name",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test"),
				PlutoraConfiguration.changesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test")
				+ " verified in portfolio filter search result.. !");
	}

	@Test(description = "Sub-area: change window -> Linked Items tab -> Viewing/Filtering TECR")
	public void subareaChangeWindowAdditionalInformation_07() throws InterruptedException, ParseException {

		/* Navigate to Environment Request Page */
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.objectData);
		/* Creating New Environment */
		tecrPage.creationTECR(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "TECR_Test_Automation_Id");
		/* Searching for the newly created TECR */
		changePage.sendKeysWithEnter("TECR_SearchButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id"),
				PlutoraConfiguration.tecrData);
		/* Setting TECR number to Test Data */
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "TECR_ID",
				(tecrPage.getTextData("TECR_Number_Text",
						PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id"),
						PlutoraConfiguration.tecrData)));
		// tecrPage.getTextData(objectLocator, text, pageData)
		/* Navigate to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changePage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changePage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		/* Creating Change */
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving Change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Navigate to Environment Request Page */
		environmentPage.goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.objectData);
		/* Searching TECR */
		tecrPage.sendKeysWithEnter("EnvironmentRequests_LiveSearch_Input",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id"),
				PlutoraConfiguration.environmentData);
		/* Linking Change with TECR */
		tecrPage.verifyTECRLinkedChange(PlutoraConfiguration.tecrData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Navigate to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Searching and Opening Changes */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Navigating to Linked change Tab */
		changePage.clickElementUsingJavaScript("Change_LinkedItems_Tab", PlutoraConfiguration.changesData);
		/* Verifying Presence of TECR */
		changePage.validateElementDisplayed("Change_LinkedItemsTecrIdentifier_link",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Test_Automation_Id"),
				PlutoraConfiguration.changesData);
		changePage.validateElementDisplayed("Change_LinkedItemsTecrName_link",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_ID"),
				PlutoraConfiguration.changesData);
		changePage.validateElementDisplayed("Change_LinkedItemsTecrStatus_label",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "TECR_Status"),
				PlutoraConfiguration.changesData);
		Listener.addLogger("Presence of TECR verified in changed linked Tab..");

	}
	
	@Test(description = "Sub-area: change window -> Comments tab -> General Functionality, saving changes")
	public void subareaChangeWindowAdditionalInformation_08() throws InterruptedException, ParseException {
		/* Navigating to Change Page */
		changePage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changePage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Saving and closing the created change */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/* Finding And Opening Change */
		changePage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Navigating to Comments Tab And Adding Comments */
		changePage.addComments(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Add_Comment", "Change_Comments_Tab");
		/* Editing Comments */
		changePage.editComments(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Edit_Comment", "Change_Comments_Tab");
		/* Replying to Comments */
		changePage.replyComments(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Reply_Comment", "Change_Comments_Tab");
		/* Deleting Comments */
		changePage.deleteComments(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Change_Comments_Tab");
		/* Click on Save And Close */
		changePage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	}
}
