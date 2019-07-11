package com.plutora.testplan;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanActivitesTabCustomFields {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();
	EnvironmentPage environmentPage= new EnvironmentPage();
	SystemsPage systemsPage = new SystemsPage();
	ChangesPage changePage = new ChangesPage();
	
	@Test (description="Sub-area: Deployment Plan activities tab -> Customfield")
	public void subareaDeploymentPlanCustomFieldsAdditionalInformation_01() throws InterruptedException, AWTException, ParseException {	
		
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan created successfully");
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name","Deployment_Activities_Name_Link");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Activity_Name")+" - Deployment Plan activity added successfully");
		
		customizationPage.addDeploymentPlanDataTypeList();
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.addCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanActivityCustomFields_Option","DeploymentPlan_Activity_CustomField_Name");
		customizationPage.click("Customization_Submit_Button",PlutoraConfiguration.customizationData);
		
		for(int i=0;i<customizationPage.deploymentPlanTypeOption.size();i++) {
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, customizationPage.deploymentPlanTypeOption.get(i),"DeploymentPlan_Activity_CustomField_Name");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
	
		deploymentPlanPage.verifyCustomFieldsAdditionalInformationTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,customizationPage.deploymentPlanTypeOption.get(i),"Deployment_Activity_Name");
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_DeploymentPlanActivityCustomFields_Option");
		}
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"DeploymentPlan_Activity_CustomField_Name");
		customizationPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DeploymentPlan_Activity_CustomField_Name"));
		Listener.addLogger("Customization field is verified after deletion from Customization Page !");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" Deployment Plan is deleted successfully");
		
	}
	
	@Test (description="Sub-area: Deployment Plan activities tab -> Sub Tabs")
	public void subareaDeploymentPlanCustomFieldsAdditionalInformation_02()
			throws InterruptedException, AWTException, ParseException {
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking on Deployment Plan Activity Custom Fields */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
		/* Adding Tab */
		customizationPage.createCustomFieldTab(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Tab");
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option",
				"DPA_CustomField_Name");
		customizationPage.selectTabParent(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DPA_CustomField_Name", "Tab");
		/* Clicking on Submit */
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		/* Navigating to Deployment Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Creating New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");

		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");

		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Clicking on Activity Name */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_ActivityAdditional_Information_Tab",
				PlutoraConfiguration.deploymentPlanData);
		/* Verifying Presence of Tab */
		deploymentPlanPage.verifyText("Deployment_CustomField_Tab_Name", "Tab", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in Deployment Plan details page successfully !");
		/* Saving And Closing DP */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Editing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
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
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Clicking on Activity Name */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_ActivityAdditional_Information_Tab",
				PlutoraConfiguration.deploymentPlanData);
		/* Verifying Presence of Tab */
		deploymentPlanPage.verifyText("Deployment_CustomField_Tab_Name", "Tab", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Tab")
				+ " verified in Deployment Plan details page successfully !");
		/* Saving And Closing DP */
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Removing Tab */
		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Clicking On Custom Field Option */
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
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
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Clicking on Activity Name */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_ActivityAdditional_Information_Tab",
				PlutoraConfiguration.deploymentPlanData);
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
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
		/* Deleting Custom Field */
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DPA_CustomField_Name");
	}
	
	@Test (description="Sub-area: Deployment Plan activities tab ->Information tooltip")
	public void subareaDeploymentPlanCustomFieldsAdditionalInformation_03() throws InterruptedException, ParseException{
		/* Waiting for Plutora Logo */
		customizationPage.waitForLoadingElement(60, "PlutoraLogo_Image", PlutoraConfiguration.objectData);
		/* Navigating to System page */
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Clearing existing query if any */
		/*systemsPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData, 10, 0);
		systemsPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option",
				PlutoraConfiguration.objectData);*/
		/* Creating New System */
		systemsPage.clickElementUsingJavaScript("AddSystem_Button", PlutoraConfiguration.systemsData); 
		systemsPage.creationSystems(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		changePage.newProjectReleasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.verifyRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"PRelease_Automation_Id");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option",
				"DPA_CustomField_Name");
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option",
				"DPA_CustomField_Name", "DPA_Tooltip");

		/* Navigating to Deployment Plan Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Creating New Deployment Plan */
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		deploymentPlanPage.addActivity(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Systems_Test_Automation_Id", "Deployment_Activity_Name",
				"Deployment_Activities_Name_Link");
		/* Finding Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on the Deployment Plan */
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Clicking on Activity Name */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_ActivityAdditional_Information_Tab",
				PlutoraConfiguration.deploymentPlanData);
		/* Verifying Presence of ToolTip */
		Assert.assertTrue(
				ReleasePage.driver
						.findElement(By.xpath("//div[contains(text(),'"
								+ PropertiesCache.getProperty(PlutoraConfiguration.testData,
										"DPA_CustomField_Name")
								+ "')]/following-sibling::div[@data-qtip='"
								+ PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_Tooltip")
								+ "']"))
						.isDisplayed());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_CustomField_Name")
				+ "-" + PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_Tooltip")
				+ " verified in Deployment Plan page successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option",
				"DPA_CustomField_Name");
		customizationPage.clickButton("Customization_CustomField_UnderLabel_Radiobox",
				"DPA_CustomField_Name", PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnSubmitButton(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option",
				"DPA_CustomField_Name", "DPA_Label");

		/* Navigating to Deployment Plan Page */
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Find and Open Deployment Plan */
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		/* Clicking on Activities tab */
		deploymentPlanPage.clickOnActivitiesDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Clicking on Activity Name */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_ActivityAdditional_Information_Tab",
				PlutoraConfiguration.deploymentPlanData);
		/* Verifying Deployment Plan Label */
		deploymentPlanPage.verifyTextDisplayedInPage(
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_Label"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_CustomField_Name")
				+ "-" + PropertiesCache.getProperty(PlutoraConfiguration.testData, "DPA_Label")
				+ " verified label in Deployment Page successfully !");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);

		/* Navigating to Customization Page */
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData,
				PlutoraConfiguration.objectData, "Customization_DeploymentPlanActivityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "DPA_CustomField_Name");
	}
}
