package com.plutoratest.testplan;

import java.awt.AWTException;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutoratest.pagerepo.DefectsPage;
import com.plutoratest.pagerepo.LoginPage;
import com.plutoratest.pagerepo.LogoutPage;
import com.plutoratest.pagerepo.RequirementsFolderAddPage;
import com.plutoratest.pagerepo.RequirementsPage;
import com.plutoratest.pagerepo.SettingPage;
import com.plutoratest.pagerepo.TestDesignerPage;
import com.plutoratest.pagerepo.TestExecutionPage;
import com.plutoratest.pagerepo.TestPlanPage;

public class RequirementsFolderAdd {
	RequirementsFolderAddPage requirementsFolderPage = new RequirementsFolderAddPage();
	RequirementsPage requirementPage = new RequirementsPage();
	LoginPage loginPage = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();
	TestPlanPage testPlanPage = new TestPlanPage();
	DefectsPage defectsPage = new DefectsPage();
	TestDesignerPage testDesignerPage = new TestDesignerPage();
	TestExecutionPage testExecutionPage = new TestExecutionPage();
	SettingPage settingPage = new SettingPage();
	
	static String beforeReqValue;
	static String afterReqValue;
	
	@Test(description = "Requirements Folder: Add Folder")
	public void requirementsFolder_01() throws InterruptedException, IOException, AWTException{
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		//Delete existing folder
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.verifyText("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Verify Edit,Child Folder & delete icon 
		Actions builder = new Actions(RequirementsPage.driver);
		builder.moveToElement(requirementsFolderPage.webElementIdentifier(PropertiesCache.getProperty(PlutoraTestConfiguration.requirementsData, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"Project_Name")))).perform();
		requirementsFolderPage.validateElementDisplayed("Req_Folder_Edit_Icon", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		
		requirementsFolderPage.validateElementDisplayed("Req_Folder_Child_Icon", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		
		requirementsFolderPage.validateElementDisplayed("Req_Folder_Delete_Icon", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Create folder from child Parent
		requirementsFolderPage.createFolderFromChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		//Collapse & Expand
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_ExpandAll_Button","Req_Folder_CollapseAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_CollapseAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are collapsed successfully !");
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_CollapseAll_Button","Req_Folder_ExpandAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_ExpandAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are Expanded successfully !");
		//Create requirement to folder
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		String requirementBeforeCount=requirementsFolderPage.getTextData("Req_Folder_Count","Parent_Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData).split(" ")[0];
		//Create requirement 
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.getNewRequirementPage(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Req_Id","Req_Name");
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Req_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		requirementsFolderPage.refresh(PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.baseUrl,"Progress_Bar");
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		String requirementAfterCount=requirementsFolderPage.getTextData("Req_Folder_Count","Parent_Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData).split(" ")[0];
		assertEquals(Integer.parseInt(requirementBeforeCount), Integer.parseInt(requirementAfterCount));
		Listener.addLogger("Requirements matching"+Integer.parseInt(requirementBeforeCount)+1+ " "+Integer.parseInt(requirementAfterCount));
		
	}
	@Test(description = "Requirements Folder: Modify Folder")
	public void requirementsFolder_02() throws InterruptedException, IOException, AWTException{
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		/*requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.verifyText("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Create 
		requirementsFolderPage.createFolderFromChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", PlutoraTestConfiguration.requirementsData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		//edit child parent
		requirementsFolderPage.renameChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData, "TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" edited sucessfully !");

		
		//Collapse & Expand
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_ExpandAll_Button","Req_Folder_CollapseAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_CollapseAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are collapsed successfully !");
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_CollapseAll_Button","Req_Folder_ExpandAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_ExpandAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are Expanded successfully !");
		*/
		//Drag and drop requirements
		requirementsFolderPage.getCoordinates("Req_Folder_Name_DraggableIcon","Project_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, "X", "Y");
		
		System.out.println(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "X")+" "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Y"));
		
		requirementsFolderPage.dragAndDrop("Req_Folder_Requirement_DraggableIcon", "Req_Folder_Name_DraggableIcon", "Requirements_Automation_Id_1", "Project_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		//requirementsFolderPage.dragAndDropWithClickAndHoldWithPosition("Req_Folder_Requirement_DraggableIcon", "Req_Folder_Name_DraggableIcon", "Requirements_Automation_Id_1", "Project_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData,-100,-100);
		requirementsFolderPage.waitForLoadingIconDisappear(5000,"Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sleep(3000);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.verifyTextContains("Req_Folder_NewRequirement_Name", "Requirements_Automation_Id_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1")+" dragged dropped folder from "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TestAutomation1")+" to "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name"));
		
		//Drag and drop folder
		requirementsFolderPage.dragAndDropWithClickAndHoldWithPosition("Req_Folder_Name", "Req_Folder_Name", "Project_Name", "TestAutomation1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData,-100,-100);
		
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" edited sucessfully !");
		
	}
	
	@Test(description = "Requirements Folder: Delete Folder")
	public void requirementsFolder_03() throws InterruptedException{
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		//Verify cancel button
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"TestAutomation1","Requirements_CancelButton");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" cancel button operating successfully !");
		//Verify confirm button
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"TestAutomation1","Requirements_ConfirmButton");
		requirementsFolderPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TestAutomation1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" deleted folder sucessfully !");
	}
	@Test(description = "Requirements Folder: Project Folder")
	public void requirementsFolder_04() throws InterruptedException{
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		Actions builder = new Actions(RequirementsPage.driver);
		builder.moveToElement(requirementsFolderPage.webElementIdentifier(PropertiesCache.getProperty(PlutoraTestConfiguration.requirementsData, "Req_Folder_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"Parent_Project_Name")))).perform();
		RequirementsPage.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		requirementsFolderPage.click("Req_Folder_Project_Icon","Parent_Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sleep(1000);
		//Validate Project/Release Icon & information
		requirementsFolderPage.validateElementDisplayed("Req_Folder_Project_Header_Text", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Project Header text verified successfully !");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_Project_Information_Text", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Project Header Information Text verified successfully !");
		
		//Verify project which is already added
		requirementsFolderPage.click("Req_Folder_Parent/Release_Name",PlutoraTestConfiguration.requirementsData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sleep(1000);
		
		requirementsFolderPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" folder not available on Select project/release list ");
		//Close project popup
		requirementsFolderPage.click("Req_Folder_Project_ClosePopup",PlutoraTestConfiguration.requirementsData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sleep(1000);
		//Delete existing folder
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		requirementsFolderPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.verifyText("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		
		requirementsFolderPage.createFolderFromChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		LoginPage.launchUrl(PlutoraTestConfiguration.baseUrl);
		//Verify Release in different account
		loginPage.newLoginPage(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "NewLogin_Email_Textfield_Value"),PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "NewLogin_Password_Textfield_Value"));
		
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name"));
		
		logoutPage.loginoutPage(PlutoraTestConfiguration.loginData);
		LoginPage.launchUrl(PlutoraTestConfiguration.baseUrl);
		//login back to user account
		loginPage.newLoginPage(PlutoraTestConfiguration.loginData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.username,PlutoraTestConfiguration.password);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
	}
	@Test(description = "Requirements Folder: Create folder structure in requirement module")
	public void requirementsFolder_05() throws InterruptedException, IOException, AWTException{
		//Go to requirement page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.verifyText("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Create 
		requirementsFolderPage.createFolderFromChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		
		//Create requirement to folder
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		//Create requirement 
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		String requirementBeforeCount=requirementsFolderPage.getTextData("Req_Folder_Count","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData).split(" ")[0];
		//requirementsFolderPage.getNewRequirementPage(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Req_Id","Req_Name");
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", PlutoraTestConfiguration.requirementsData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Requirements_Automation_Name_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		//Go to testplan page
		testPlanPage.getTestPlanPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		//Create requirement to folder
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementGridView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirements_Automation_Name_1");
		
		//Go to testplan page
		testPlanPage.getTestPlanPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.verifyText("Requirements_Name", "Requirements_Automation_Name_1",
				PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		//Verify Parent folder
		requirementsFolderPage.verifyText("Req_Folder_Name", "Parent_Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Parent_Project_Name")+" parent folder verified sucessfully !");
		
		//hide/show folder
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_Project_Collapsed_Icon","Req_Folder_Project_Expanded_Icon","Parent_Project_Name",PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_CollapseAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are collapsed successfully !");
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_Project_Expanded_Icon","Req_Folder_Project_Collapsed_Icon","Parent_Project_Name",PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_ExpandAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are Expanded successfully !");
		
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		//Verify requirment name 
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Requirements_Automation_Name_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1")+" verified requirements name in folder successfully ! ");
		//Verify requirement description
		requirementsFolderPage.verifyText("Req_Folder_NewRequirement_Description", "Requirements_Automation_Description", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Description")+" verified requirement description in folder successfully ! ");
		//Verify requirement status
		requirementsFolderPage.verifyText("Req_Folder_NewRequirement_Status", "Requirement_Status", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Status")+" verified requirement status in folder successfully ! ");
		
		
		//Verify requirment count
		String requirementAfterCount=requirementsFolderPage.getTextData("Req_Folder_Count","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData).split(" ")[0];
		assertEquals(Integer.parseInt(requirementBeforeCount)+1, Integer.parseInt(requirementAfterCount));
		Listener.addLogger(Integer.parseInt(requirementBeforeCount)+1+" "+Integer.parseInt(requirementAfterCount)+" requirement count validated successfully !");
	}
	
	@Test(description = "Requirements Folder: Add Requirements")
	public void requirementsFolder_06() throws InterruptedException, IOException ,AWTException{
		//Requirements folder selection & verify requirement association
		requirementsFolderPage.getNavigateRequirementPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.verifyText("Req_Folder_Name","Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("A folder selected & Verified requirement");
		//+ new requirement
		requirementsFolderPage.getNewRequirementPage(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Req_Id","Req_Name");
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Req_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("The new requirement created in the folder view and associated to the selected folder.");
		beforeReqValue = requirementsFolderPage.getReqCount(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		//new requirement Requirments view grid
		requirementsFolderPage.getNavigateRequirementGridView(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsFolderPage.getNewRequirementPage(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Req_Grid_Id","Req_Grid_Name");
		requirementsFolderPage.getCreatedReqGridAssociationPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Req_Grid_Name");
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Req_Grid_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("The new requirement created and associated to the parent (default) folder.");
		//BulkUpload
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.imageFileName,"TestFile");
		FolderManagementUtilLib.setExcelData(CommonConstants.imageFileName+excelFile, "Sheet1", 1, 1, PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "Requirement_Bulk_Import") );
		
		requirementsFolderPage.getBulkUploadPage(PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"BulkUploadSourceXlsTestFileName");
		requirementsFolderPage.getNavigateRequirementPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sendKeysToQuerySearch(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, "Requirement_Bulk_Import");
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Requirement_Bulk_Import", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger("Requirement imported successfully.");
		Listener.addLogger("The imported requirement visibled in the requirement grid view and associated to the parent (default) folder in the folder view.");
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.getSelectingDefaultFolder(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger("The imported requirement visibled in the requirement folder view and associated to the parent (default) folder in the folder view.");
		requirementsFolderPage.click("Req_Query_Search_ClearQuery_Icon",PlutoraTestConfiguration.requirementsData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		afterReqValue=requirementsFolderPage.getReqCount(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		//Requirement count verification
		boolean flag = requirementsFolderPage.getReqCountData(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData,beforeReqValue,afterReqValue);
		requirementsFolderPage.verifyTrue(flag);
		Listener.addLogger("The requirement count updated in both grid/folder view.");

	}

	@Test(description = "Requirements Folder: Modify Requirement")
	public void requirementsFolder_07() throws InterruptedException, AWTException, IOException{
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.verifyText("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Create 
		requirementsFolderPage.createFolderFromChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +"Created folder from parent sucessfully !");
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", PlutoraTestConfiguration.requirementsData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		//edit child parent
		requirementsFolderPage.renameChildParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData, PlutoraTestConfiguration.testData, "TestAutomation1");
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" edited sucessfully !");

		
		//Collapse & Expand
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_ExpandAll_Button","Req_Folder_CollapseAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_CollapseAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are collapsed successfully !");
		requirementsFolderPage.clickElement(PlutoraTestConfiguration.requirementsData,"Req_Folder_CollapseAll_Button","Req_Folder_ExpandAll_Button",PlutoraTestConfiguration.objectData,"Progress_Bar");
		requirementsFolderPage.validateElementDisplayed("Req_Folder_ExpandAll_Folder", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Folder are Expanded successfully !");
		
		//Drag and drop requirements
		requirementsFolderPage.getCoordinates("Req_Folder_Name_DraggableIcon","Project_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, "X", "Y");
		
		System.out.println(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "X")+" "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Y"));
		
		requirementsFolderPage.dragAndDropWithClickAndHoldWithPosition("Req_Folder_Requirement_DraggableIcon", "Req_Folder_Name_DraggableIcon", "Requirements_Automation_Id_1", "Project_Name", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData,-100,-100);
		requirementsFolderPage.waitForLoadingIconDisappear(5000,"Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementsFolderPage.sleep(3000);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_Name","Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.verifyTextContains("Req_Folder_NewRequirement_Name", "Requirements_Automation_Id_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1")+" dragged dropped folder from "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "TestAutomation1")+" to "+PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name"));
		
		//Drag and drop folder
		requirementsFolderPage.dragAndDropWithClickAndHoldWithPosition("Req_Folder_Name", "Req_Folder_Name", "Project_Name", "TestAutomation1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData,-100,-100);
		
		requirementsFolderPage.verifyText("Req_Folder_Name", "TestAutomation1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData,"TestAutomation1") +" edited sucessfully !");
		
	}
	

	@Test(description = "Requirements Folder: Delete Requirements")
	public void requirementsFolder_08() throws InterruptedException, IOException, AWTException {
		//Create requirement
		requirementPage.getRequirementsDetailsPage(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.objectData);
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		
		//Create testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		
		//Create Testcase
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, 1,  1);
		//Create defect
		testExecutionPage.createDefect(PlutoraTestConfiguration.testExecutionData,PlutoraTestConfiguration.requirementsBulkUploadData,PlutoraTestConfiguration.testData,PlutoraTestConfiguration.objectData,"Requirements_Automation_Name_1","TestPlan_Name_1","TDTC_Name_1");
		//delete cancel button
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		requirementPage.sleep(1000);
		requirementPage.clickElementUsingJavaScript("Requirements_Name",  "Requirements_Automation_Name_1",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		requirementPage.clickElementUsingJavaScript("Requirements_DeleteButton",PlutoraTestConfiguration.requirementsData);
		requirementPage.sleep(1000);
		requirementPage.clickElementUsingJavaScript("Requirements_CancelButton", PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("Requirement cancel button operated successfully !");
		testPlanPage.clickElementUsingJavaScript("Requirements_CloseButton",PlutoraTestConfiguration.requirementsData);
		
		//Delete confirm button
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		requirementPage.deleteRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		Listener.addLogger("Requirement cancel button operated successfully !");
		requirementPage.searchRequirements(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "Requirements_Automation_Name_1");
		requirementPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1")+" deleted requirement successfully");
		//Verify testplan 
		testPlanPage.refresh(PlutoraTestConfiguration.objectData, "", "Progress_Bar");
		testPlanPage.getTestPlanPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.sleep(2000);
		testPlanPage.searchTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testPlanPage.clickOnTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, "TestPlan_Name_1");
		testPlanPage.clickElementUsingJavaScript("TestPlan_Requirement_Tab",PlutoraTestConfiguration.testPlanData);
		testPlanPage.validateElementDisplayed("TestPlan_Requirement_Count", "0",PlutoraTestConfiguration.testPlanData);
		testPlanPage.clickElementUsingJavaScript("TestPlan_CloseButton",PlutoraTestConfiguration.testPlanData);
		testPlanPage.waitForLoadingIconDisappear(100,"Progress_Bar", PlutoraTestConfiguration.objectData);
		Listener.addLogger("Requirement count in Test plan validated successfully !");
	
	}

	@Test(description = "Requirements Folder: Search and Filter Requirements")
	public void requirementsFolder_09() throws InterruptedException, IOException, AWTException {
		settingPage.gotoSettingPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.gotoCustomizationPage(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.objectData);
		settingPage.addCustomField(PlutoraTestConfiguration.settingsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"Requirement_CustomField");
		
		//Go to requirement Page
		requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		//requirements Advanced search filter
		requirementsFolderPage.isElementPresent("Req_AdvSearch_Icon",PlutoraTestConfiguration.requirementsData);
		requirementsFolderPage.isElementPresent("Req_AdvSearchReq_Header",PlutoraTestConfiguration.requirementsData);
		Listener.addLogger("The Advanced Search/Query Builder visibled and placed next to the Requirements count.");
		
		//Delete existing folder
		requirementsFolderPage.deleteFolder(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Project_Name","Requirements_ConfirmButton");
		//Create folder from Parent
		requirementsFolderPage.createFolderFromParent(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData,PlutoraTestConfiguration.testData,"Parent_Project_Name","Project_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Project_Name")+" Created folder from parent sucessfully !");
		//Verify Folder Name which is created from Parent
		requirementsFolderPage.click("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.clickElementUsingJavaScript("Req_Folder_NewRequirement_Button", PlutoraTestConfiguration.requirementsData);
		//Create requirement for Parent
		requirementPage.createRequirements(PlutoraTestConfiguration.requirementsData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, PlutoraTestConfiguration.objectData, 1);
		//Create testplan
		testPlanPage.getTestPlanDetailsPage(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.objectData);
		testPlanPage.createTestPlan(PlutoraTestConfiguration.testPlanData, PlutoraTestConfiguration.testData, 
				PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		
		//Create Testcase
		testDesignerPage.getTestDesignerDetails(PlutoraTestConfiguration.testData,
				PlutoraTestConfiguration.objectData);
		testDesignerPage.searchTestplan(PlutoraTestConfiguration.testDesignerData,
				PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"TestPlan_Name_1");
		testDesignerPage.clickOnRequirement(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData, 1);
		testDesignerPage.createTestcase(PlutoraTestConfiguration.testDesignerData,
					PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,
					PlutoraTestConfiguration.platformName, 1,  1);
	
		//Go to requirement Page
				requirementPage.gotoRequirementsPage(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.objectData);
		//Navigate to folder view 
		requirementsFolderPage.getNavigateRequirementFolderView(PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.objectData);
		requirementsFolderPage.click("Req_Folder_Name", "Project_Name",PlutoraTestConfiguration.requirementsData,PlutoraTestConfiguration.testData);
		requirementsFolderPage.sendKeysToQuerySearch(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1");
		//Verify requirment name 
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Requirements_Automation_Name_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Name_1")+" verified requirements name in folder successfully ! ");
		
		requirementsFolderPage.sendKeysToQuerySearch(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1");
		//Verify requirement id
		requirementsFolderPage.verifyTextContains("Req_Folder_CreatedNewReqName_Link", "Requirements_Automation_Id_1", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Id_1")+" verified requirements name in folder successfully ! ");
		//Verify requirement description
		requirementsFolderPage.sendKeysToQuerySearch(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"Description","equals","Requirements_Automation_Description");
		requirementsFolderPage.verifyText("Req_Folder_NewRequirement_Description", "Requirements_Automation_Description", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirements_Automation_Description")+" verified requirement description in folder successfully ! ");
		//Verify requirement status
		requirementsFolderPage.sendKeysToQuerySearch(PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData, PlutoraTestConfiguration.objectData,"Status","equals","Requirement_Status");
		requirementsFolderPage.verifyText("Req_Folder_NewRequirement_Status", "Requirement_Status", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Status")+" verified requirement status in folder successfully ! ");
		//Verify category

		requirementsFolderPage.verifyText("Req_Folder_NewRequirement_Status", "Requirement_Category", PlutoraTestConfiguration.requirementsData, PlutoraTestConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraTestConfiguration.testData, "Requirement_Category")+" verified requirement category in folder successfully ! ");
		requirementsFolderPage.click("Req_Folder_TestPlan_Count_Icon",PlutoraTestConfiguration.requirementsData);
	
	}














}