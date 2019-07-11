package com.plutora.testplan;


import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class DeploymentPlanAdditionalInformationTab {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
		
		@Test (description="Sub-area: Deployment Plan window -> Additional Information tab -> Testcase")
		public void subareaDeploymentPlanAdditionalInformation_01() throws InterruptedException, AWTException, ParseException {	
			deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
			deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
			
			customizationPage.addDeploymentPlanDataTypeList();
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanCustomFields_Option","DeploymentPlan_CustomField_Name");
			customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
			
			for(int i=0;i<customizationPage.deploymentPlanTypeOption.size();i++) {
			customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.deploymentPlanTypeOption.get(i),"DeploymentPlan_CustomField_Name");
			
			deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
			deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
			deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
			deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
			
			deploymentPlanPage.verifyAdditionalInformationTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.deploymentPlanTypeOption.get(i));
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanCustomFields_Option");
			}
			customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"DeploymentPlan_CustomField_Name");
			customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_CustomField_Name"));
			Listener.addLogger("Customization field is verified after deletion from Customization Page !");
			
			deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
			deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan deleted successfully");
		}
		
		@Test(description = "Deployment Plan -> Sub-Tabs")
		public void subareaDeploymentPlanAdditionalInformation_02() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Deployment Plan Custom Fields */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option");

		/* Adding Tab */
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option",
				"DeploymentPlan_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DeploymentPlan_CustomField_Name", "Tab");
		/* Clicking on Submit */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Deployment Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Creating New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Additional Info tab */
		deploymentPlanPage.clickAdditionalInfoTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Tab */
		deploymentPlanPage.verifyText("Deployment_CustomField_Tab_Name", "Tab", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in Deployment Plan details page successfully !");
		/* Saving And Closing Change */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		/* Editing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option");
		/* Editing Custom Field */
		customizationPage.editCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		/* Clicking On Submit Button */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Deployment Plan Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Finding And Opening Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Additional Info tab */
		deploymentPlanPage.clickAdditionalInfoTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of Tab */
		deploymentPlanPage.verifyText("Deployment_CustomField_Tab_Name", "Tab", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in Deployment Plan details page successfully !");
		/* Saving And Closing Change */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Removing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option");
		/* Removing Custom Field Tab */
		customizationPage.removeCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		/* Clicking on Submit Button */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Deployment Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Finding And Opening Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Additional Info tab */
		deploymentPlanPage.clickAdditionalInfoTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying Absence of Tab */
		deploymentPlanPage
				.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in deployment Plan page details page successfully !");
		/* Clicking On Save And Close */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Deleting Custom Field */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Change Custom Field */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option");
		/* Deleting Custom Field */
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DeploymentPlan_CustomField_Name");
		}
		
		@Test(description = "Deployment Plan -> Addtional Info -> Information tooltip")
		public void subareaDeploymentPlanAdditionalInformation_03() throws InterruptedException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);

		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option",
				"DeploymentPlan_CustomField_Name");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option",
				"DeploymentPlan_CustomField_Name", "DeploymentPlan_Tooltip");

		/* Navigating to Deployment Plan Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Creating New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Additional Info tab */
		deploymentPlanPage.clickAdditionalInfoTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying Presence of ToolTip */
		Assert.assertTrue(
				ReleasePage.driver
						.findElement(By.xpath("//div[contains(text(),'"
								+ PropertiesCache.getProperty(PlutoraConfiguration.testData,
										"DeploymentPlan_CustomField_Name")
								+ "')]/following-sibling::div[@data-qtip='"
								+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_Tooltip")
								+ "']"))
						.isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_CustomField_Name")
				+ "-" + PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_Tooltip")
				+ " verified in Deployment Plan page successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option",
				"DeploymentPlan_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox",
				"DeploymentPlan_CustomField_Name", PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option",
				"DeploymentPlan_CustomField_Name", "DeploymentPlan_Label");

		/* Navigating to Deployment Plan Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Find and Open Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Additional Info tab */
		deploymentPlanPage.clickAdditionalInfoTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying Deployment Plan Label */
		deploymentPlanPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_CustomField_Name")
				+ "-" + PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_Label")
				+ " verified label in Deployment Page successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DeploymentPlan_CustomField_Name");

		}



}
