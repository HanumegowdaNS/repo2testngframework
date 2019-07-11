package com.plutora.testplan;


import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.BlockoutPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class BlockoutPeriods {
	
	BlockoutPage blockoutPage = new BlockoutPage();
	ReleasePage releasePage = new ReleasePage();
	CustomizationPage customizationPage = new CustomizationPage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	
	@Test (description="Sub-area: Blockout Period -> Add/edit/delete Blockout Period")
	public void subareaBlockoutPeriod_01() throws InterruptedException, IOException, AWTException  {	
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		blockoutPage.verifyTextContains("Blockout_SearchResultName","Blockout_Test_Automation_Id",PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData);
		Listener.addLogger("Blockout Period added successfully !");
		blockoutPage.updateBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName,"Blockout_Test_Automation_Id");
		blockoutPage.openBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		blockoutPage.verifyTextAttributeValue("Blockout_DescriptionTextfield", "Blockout_Changed_Desc",PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData);
		Listener.addLogger("Blockout Period edited successfully !");
		blockoutPage.clickOnElement(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_SaveCloseButton");
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		blockoutPage.verifyTextContainsNotDisplayedInPage("Blockout_Test_Automation_Id",PlutoraConfiguration.testData);
		Listener.addLogger("Blockout Period deleted successfully ! ");
	}
	
	@Test (description="Checkbox 'Show On Scheduler' behavior (appearance on Release Schedule)")
	public void subareaBlockoutPeriod_02() throws InterruptedException, AWTException, ParseException {	
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releaseSchedulePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.getReleaseScheduleDateRangePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	//	String blockoutBackgroundColor = releasePage.getAttributeBackgroundColorValue(PlutoraConfiguration.releasesData,"Release_SchedulePeriod_Area");
	//	blockoutPage.verifyTextValue("BlockoutReleaseSchedulePeriodColor",blockoutBackgroundColor,PlutoraConfiguration.testData);
		releasePage.validateElementDisplayed("Release_ShowSchedule_Area", PlutoraConfiguration.releasesData);
		Listener.addLogger("Checkbox 'Show On Scheduler' behavior (appearance on Release Schedule) successfully !");
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData,PlutoraConfiguration.objectData);
		blockoutPage.deleteBlockout(PlutoraConfiguration.blockoutData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Blockout_Test_Automation_Id");
		Listener.addLogger("Blockout Period test data deleted successfully ! ");
	}
	
	
	@Test(description = "Actions -> Duplicate Blockout Period")
	public void subareaBlockoutPeriod_03() throws InterruptedException {
		/* Navigating to Blockout page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		/* Creating a new Blockout period */
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_Test_Automation_Id");
		/* Duplicating the created blockout through 'Action' dropdown */
		blockoutPage.duplicateBlockoutThroughAction(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Validating the presence of newly created Duplicate Blockout period */
		blockoutPage.validateElementDisplayed("Blockout_Name", "Duplicate_Blockout_Name",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);

	}
	
	@Test(description = "Blockout Type and Blockout Type Color")
	public void subareaBlockoutPeriod_04() throws InterruptedException {
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Add Customization Field and Color */
		customizationPage.createCustomFieldColorOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_BlockoutType_Option",
				"Blockout_CustomField_Name");
		/* Add Icon */
		customizationPage.addIconToBlockoutType(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_CustomField_Name");
		/* Getting the Color Value */
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Blockout_Type_Color",
				customizationPage.getCSSValue("Customization_BlockoutType_ColorVaue", "Blockout_CustomField_Name",
						PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, "background-color"));
		/* Navigating to Block out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		/* Clicking on '+New Block out' */
		blockoutPage.clickElementUsingJavaScript("Blockout_AddBlockoutButton", PlutoraConfiguration.blockoutData);
		/* Waiting for loader to disappear */
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Entering Block out Name */
		blockoutPage.sendKeys("Blockout_NameTextfield",
				PropertiesCache.setProperty(PlutoraConfiguration.testData, "Blockout_Test_Automation_Id"),
				PlutoraConfiguration.blockoutData);
		/* Entering Block out Description */
		blockoutPage.sendKeysWithEnter("Blockout_DescriptionTextfield",
				PropertiesCache.setProperty(PlutoraConfiguration.testData, "Blockout_Desc"),
				PlutoraConfiguration.blockoutData);
		/* Clicking on Block out type drop down */
		blockoutPage.click("Blockout_Type_Dropdown", PlutoraConfiguration.blockoutData);
		/* Verifying Presence of Customized Block Out Type */
		blockoutPage.validateElementDisplayed("Blockout_Type_Dropdown_Option", "Blockout_CustomField_Name",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		/* Selecting Customiized Dropdown Type */
		blockoutPage.clickElementUsingJavaScript("Blockout_Type_Dropdown_Option", "Blockout_CustomField_Name",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		/* Verifying Blockout Type Color */
		blockoutPage.verifyAssertTrue(blockoutPage
				.getAttributeBackgroundColorValue(PlutoraConfiguration.blockoutData,
						"Blockout_Audit_BlockOutPeriodColor")
				.contains(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type_Color")));
		/* Selecting Start and End Date */
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		blockoutPage.click("Blockout_StartDateTextfield", PlutoraConfiguration.blockoutData);
		blockoutPage.click("Blockout_StartDateDoneTextfield", PlutoraConfiguration.blockoutData);
		blockoutPage.click("Blockout_EndDateTextfield", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		blockoutPage.clickElementUsingJavaScript("Blockout_EndDateNextMonthButton", PlutoraConfiguration.blockoutData);
		blockoutPage.click("Blockout_EndDateDoneTextfield", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);

		/* Selecting Show on scheduler checkbox */
		blockoutPage.click("Blockout_ShowOnSchedulerCheckbox", PlutoraConfiguration.blockoutData);

		/* Clicking on Save And Close */
		blockoutPage.click("Blockout_SaveCloseButton", PlutoraConfiguration.blockoutData);
		blockoutPage.sleep(2000);

		/* Waiting for loader to disappear */
		blockoutPage.waitForLoadingIconDisappear(30, "Loading_Gif", PlutoraConfiguration.objectData);
		/*
		 * Verifying Presence of Customized Blockout Type on Blockout Periods
		 * page
		 */
		blockoutPage.verifyAssertTrue((blockoutPage
				.getTextData("Blockout_BlockOutType_Label", "Blockout_Test_Automation_Id",
						PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData)
				.equals(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_CustomField_Name"))));
		Listener.addLogger("Presence of Customized Blockout type verified on Blockout Period Page..!!");
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Deleting customized blockout Type */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_BlockoutType_Option");
		customizationPage.deleteCustomsField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_CustomField_Name");
		Listener.addLogger("Customized Blockout type is deleted successfully..!!");
	}

	@Test (description="Audit")
	public void subareaBlockoutPeriod_05() throws InterruptedException  {
		/* Navigating to Block Out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		/* Creating a new Block Out period */
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_Test_Automation_Id");
		/* Opening Block Out period */
		/* Clicking on Block Out period */
		blockoutPage.clickElementUsingJavaScript("Blockout_SearchResultName", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);

		/* Addition */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
			EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon",
					PlutoraConfiguration.objectData);
		} catch (Exception e) {
			EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		blockoutPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox",
				"Audit_Modified_Checkbox", PlutoraConfiguration.objectData, "xpath");
		blockoutPage.verifyListText("Blockout_Audit_BlockOutPeriodNameAudit_Text", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);

		/* Deletion */
		/* Deleting Description Content */
		blockoutPage.clear("Blockout_DescriptionTextfield", PlutoraConfiguration.blockoutData);
		/* Clicking on Save */
		blockoutPage.clickElementUsingJavaScript("Blockout_SaveButton", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Audit Icon */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Deleted Checkebox */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox",
				"Audit_Deleted_Checkbox", PlutoraConfiguration.objectData, "xpath");

		/* Verifying Deletion */
		blockoutPage.verifyText("Blockout_Audit_BlockOutPeriodDeleted_Text", "Blockout_Desc",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
		/* Clicking on Save */
		blockoutPage.clickElementUsingJavaScript("Blockout_SaveButton", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		
		/*Modification*/
		/* Entering New Text for Blockout Name */
		blockoutPage.sendKeys("Blockout_NameTextfield",
				PropertiesCache.setProperty(PlutoraConfiguration.testData, "Blockout_Test_Automation_Id_Edit"),
				PlutoraConfiguration.blockoutData);
		/* Clicking on Save */
		blockoutPage.clickElementUsingJavaScript("Blockout_SaveButton", PlutoraConfiguration.blockoutData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		
		/* Clicking on Audit Icon */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		
		/*Verifying Presence of Modified Text*/
		blockoutPage.verifyListText("Blockout_Audit_BlockOutPeriodNameAudit_Text", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
		
		/* Live Search */
		/* Clicking on Audit Icon */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		blockoutPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.objectData, PlutoraConfiguration.testData);
		blockoutPage.waitForLoadingIconDisappear(30, "Loading_Gif", PlutoraConfiguration.objectData);
		blockoutPage.validateElementDisplayed("Blockout_Audit_BlockOutPeriodNameAudit_Text",
				"Blockout_Test_Automation_Id", PlutoraConfiguration.blockoutData);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon",
				PlutoraConfiguration.objectData);
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
		blockoutPage.clickOnSaveAndCloseButton(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);

	}
	
	@Test (description="Query Builder (QB) + Quick Access menu")
	public void subareaBlockoutPeriod_06() throws InterruptedException {
		
		/* Navigating to Block Out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);

		/* Clearing existing query if any */
		blockoutPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		blockoutPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

		/* Creating BlockOut */
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_Test_Automation_Id");

		/* Adding a new Public Query */
		blockoutPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		blockoutPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Name",
				"contains", "Blockout_Test_Automation_Id", "1");
		/* Saving And Running The Query */
		blockoutPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public",
				"Query_Public_Builder");
		blockoutPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

		/* Verifying Search Result */
		blockoutPage.verifyText("Blockout_SearchResultName", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Test_Automation_Id")
				+ " verified public query builder successfully !");

		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In with different Account */
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);

		/* Navigating to Block Out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);

		/* Clicking Query Builder */
		blockoutPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Query_Public_Builder");

		/* Verifying Search Results */
		blockoutPage.verifyText("Blockout_SearchResultName", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Test_Automation_Id")
				+ " verified public query builder successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

		/* Navigation to BlockOut Page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);

		/* Adding a New Private query */
		blockoutPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);

		/* Adding the first Condition */
		blockoutPage.clickElementUsingJavaScript("QueryBuilder_New_Button", PlutoraConfiguration.objectData);
		blockoutPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Name",
				"contains", "Blockout_Test_Automation_Id", "1");

		/* Adding the Second Condition */
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_AddQuery_Icon",
				PlutoraConfiguration.objectData);
		blockoutPage.addCondition(PlutoraConfiguration.objectData, "And", "2");
		blockoutPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Description",
				"equals", "Blockout_Desc", "2");
		blockoutPage.clickOnButton(PlutoraConfiguration.objectData, "QueryBuilder_AddQuery_Icon",
				PlutoraConfiguration.objectData);

		/* Adding the Third Condition */
		blockoutPage.addCondition(PlutoraConfiguration.objectData, "Or", "3");
		blockoutPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Blockout Type", "equals", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Blockout_Type"),
				"3", "3");

		/* Saving and Running Query */
		blockoutPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private",
				"Query_Private_Builder");

		/* Verifying Results */
		blockoutPage.verifyText("Blockout_SearchResultName", "Blockout_Test_Automation_Id",
				PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		
		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In with another account */
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);

		/* Navigating to Block Out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);

		/* Clicking On quick access menu */
		blockoutPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		blockoutPage.verifyTextEqualsNotDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")
				+ " not displayed in query builder in other account successfully !");

		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);

		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

		/* Clearing existing query if */
		blockoutPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		blockoutPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		blockoutPage.waitForLoadingIconDisappear(60, "Loading_Gif", PlutoraConfiguration.objectData);

	}
	
	@Test(description = "Viewing attachments from the grid")
	public void subareaBlockoutPeriod_07() throws InterruptedException, IOException, AWTException {
		/* Navigating to Block Out page */
		blockoutPage.gotoBlockoutPeriodPage(PlutoraConfiguration.blockoutData, PlutoraConfiguration.objectData);
		/* Creating a new Block Out period */
		blockoutPage.addBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Blockout_Test_Automation_Id");
		/* Updating Blockout with Attachment */
		blockoutPage.updateBlockout(PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "", "Blockout_Test_Automation_Id");
		/* Navigating attachment through Grid */
		blockoutPage.clickElementUsingJavaScript("Blockout_Audit_BlockOutPeriodViewAttachment_GridLink",
				"Blockout_Test_Automation_Id", PlutoraConfiguration.blockoutData, PlutoraConfiguration.testData);
		/* Downloading attached document */
		blockoutPage.clickOnButton(PlutoraConfiguration.blockoutData, "Blockout_Download_image",
				PlutoraConfiguration.objectData);
		String excelFile = FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath, "screenshot");
		Assert.assertTrue(!excelFile.isEmpty());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")
				+ " Downloaded file verified successfully !");
		/*Closing Attachment Window*/
		blockoutPage.clickElementUsingJavaScript("Blockout_AttachmentWindowClose_Icon", PlutoraConfiguration.blockoutData);
	}

}
