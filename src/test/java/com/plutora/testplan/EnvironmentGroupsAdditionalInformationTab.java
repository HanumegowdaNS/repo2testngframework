package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentGroupsAdditionalInformationTab {

	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();

	@Test (description="Sub-area: Environment window -> Additional Information tab -> Testcase")
	public void subareaEnvironmentGroupWindowAdditionalInformation_01() throws InterruptedException, AWTException, ParseException {	
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Create
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Add custom field
		customizationPage.addDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option","EnvGrp_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.dataTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.dataTypeOption.get(i),"EnvGrp_CustomField_Name");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Verify additional information tab 
		environmentGroupsPage.verifyAdditionalInformationTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.dataTypeOption.get(i),"EnvGrp_Automation");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_EnvGrpCustomFields_Option");
		}
		//Delete Custom field
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
		
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.doubleClick("EnvGroups_PortfolioAssociationName_Label",PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name"), PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
	}
	
	@Test (description="Sub-area: Environment window -> Additional Information tab -> Information Tooltip")
	public void subareaEnvironmentGroupWindowAdditionalInformation_02() throws InterruptedException{
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option", "EnvGrp_CustomField_Name");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option", "EnvGrp_CustomField_Name",
				"EnvGrp_Tooltip");

		/* Navigating to EnvGroup Page */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating EnvGroup */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Saving and closing the created EnvGroup */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Finding And Opening EnvGroup */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Clicking on Environment Group Link */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_EnvNameLink", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Additional information Tab */
		environmentGroupsPage.clickElementUsingJavaScript("Environment_Additional_Information_Tab",
				PlutoraConfiguration.environmentData);
		/* Verifying Presence of ToolTip */
		Assert.assertTrue(
				ReleasePage.driver
						.findElement(
								By.xpath("//div[contains(text(),'"
										+ PropertiesCache.getProperty(PlutoraConfiguration.testData,
												"EnvGrp_CustomField_Name")
										+ "')]/following-sibling::div[@data-qtip='"
										+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Tooltip")
										+ "']"))
						.isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name") + "-"
				+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Tooltip")
				+ " verified in change details page successfully !");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option", "EnvGrp_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox", "EnvGrp_CustomField_Name",
				PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option", "EnvGrp_CustomField_Name",
				"EnvGrp_Label");

		/* Finding And Opening EnvGroup */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Clicking on Environment Group Link */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_EnvNameLink", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Additional information Tab */
		environmentGroupsPage.clickElementUsingJavaScript("Environment_Additional_Information_Tab",
				PlutoraConfiguration.environmentData);
		/* Verifying EnvGrp Label */ 
		environmentGroupsPage
				.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_CustomField_Name") + "-"
				+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Label")
				+ " verified in release details page successfully !");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_EnvGrpCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_CustomField_Name");

	}
	
	@Test (description="Audit")
	public void subareaEnvironmentGroupWindowAdditionalInformation_03() throws InterruptedException  {
		/* Navigating to EnvGroup Page */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Creating EnvGroup */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Saving and closing the created EnvGroup */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Finding And Opening EnvGroup */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Clicking on Environment Group Link */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_EnvNameLink", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);

		//Modify
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
			EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		environmentGroupsPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox",
				"Audit_Modified_Checkbox", PlutoraConfiguration.objectData, "xpath");
		environmentGroupsPage.verifyListText("ENVGroups_Audit_EnvGrpName_Text", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Added
		releasePage.addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, 1, "Releases_EStakeholder_Button");
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);

		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox",
				"Audit_Added_Checkbox", PlutoraConfiguration.objectData, "xpath");
		environmentGroupsPage.verifyListText("Environment_Audit_Stakeholder_Text", "Stakeholder_Name",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
        
		//Deleted
		releasePage.removeStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Stakeholder_Name", "Releases_Stakeholder_Remove_Button");
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox",
				"Audit_Deleted_Checkbox", PlutoraConfiguration.objectData, "xpath");
		environmentGroupsPage.verifyListText("Environment_Audit_DeletedStakeholder_Text", "Stakeholder_Name",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
        
		//All
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox",
				"Audit_All_Checkbox", PlutoraConfiguration.objectData, "xpath");
		/*environmentGroupsPage.scrollToElement("Audit_Deleted_Icon", PlutoraConfiguration.objectData);
		environmentGroupsPage.validateElementDisplayed("Audit_Deleted_Icon", PlutoraConfiguration.objectData);
		environmentGroupsPage.scrollToElement("Audit_Added_Icon", PlutoraConfiguration.objectData);
		environmentGroupsPage.validateElementDisplayed("Audit_Added_Icon", PlutoraConfiguration.objectData);*/

		//Live Search
		environmentGroupsPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "EnvGrp_Automation",
				PlutoraConfiguration.objectData, PlutoraConfiguration.testData);
		environmentGroupsPage.waitForLoadingIconDisappear(30, "Loading_Gif", PlutoraConfiguration.objectData);
		environmentGroupsPage.validateElementDisplayed("ENVGroups_Audit_EnvGrpNameAudit_Text", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon",
				PlutoraConfiguration.objectData);
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		
	}
}
