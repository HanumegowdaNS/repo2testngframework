package com.plutora.testplan;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;


public class ChangesWindowChangeGrid {
	ChangesPage changesPage = new ChangesPage();
	CustomizationPage customizationPage = new CustomizationPage();
	ReleasePage releasePage = new ReleasePage();
	LogoutPage logoutPage = new LogoutPage();
	LoginPage loginPage = new LoginPage();
	

	@Test (description="Sub-area: changes window -> Add/Edit/Delete")
	public void subareaChangesGrid_01() throws InterruptedException, ParseException {	
		changesPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.changePage(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changesPage.verifyText("Change_Page_Title","Change_Page_Title_Value", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.createChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		Listener.addLogger("Change is created successfully !");
		changesPage.verifyText("Change_Page_Title","Change_Page_Title_Value",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.verifyChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyText("Change_Result_Gridview_Name","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Change created in the first case is found");
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyTextContains("Change_SubTitle","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.updateChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Updated description field in Change successfully !");
		changesPage.createDuplicateChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyTextContains("Confirmation_Message","New_Change_Create_Duplicate_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger("Change duplicate record created successfully !");
		changesPage.deleteDuplicateChange(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		changesPage.verifyTextContainsNotDisplayedInPage("New_Change_Create_Duplicate_Message",PlutoraConfiguration.testData);
		Listener.addLogger("Change duplicate record deleted successfully !");
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.verifyTextContains("Change_SubTitle","Change_Automation_Id", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		changesPage.deleteChange(PlutoraConfiguration.changesData,PlutoraConfiguration.objectData);
		changesPage.verifyText( "Change_NoResult_Found","Change_not_Found_Value",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger("Change deleted successfully !");
	}

	@Test(description = "Sub-area: changes window -> Export to XLS")
	public void subareaChangesGrid_02() throws InterruptedException, ParseException {
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.clickOnChangesExportToXLS(PlutoraConfiguration.changesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		changesPage.sleep(3000);
		String excelFile = FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath, "Change");
		String[] data = FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath + excelFile, "Change", 1);
		System.out.println(data[2].split("\\n")[0].trim());
		changesPage.verifyTextValue("Change_Automation_Id", data[2].split("\\n")[0].trim(),
				PlutoraConfiguration.testData);
		Listener.addLogger( "Change export to XLS is downloaded successfully!");
	}

	@Test (description="Sub-area: changes window -> Live Search")
	public void subareaChangesGrid_03() throws InterruptedException, AWTException, ParseException {	
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		//Live Search
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean flag = changesPage.findChangeRowDisplayed(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1);
		changesPage.verifyTrue(flag);
		Listener.addLogger("All Change entities containing specified name filtered.");
		changesPage.getLiveSearchClosePage(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		boolean flag1 = changesPage.findChangeRowDisplayed(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Infinite");
		changesPage.verifyTrue(flag1);
		Listener.addLogger("'Name' is deleted from Live Search combo box. All existing Change entities appeared in the Grid.");

	}
	
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	@Test (description="Sub-area: changes window -> Action -> Lock Selected Items")
	public void subareaChangesGrid_04() throws InterruptedException,ParseException {	
		
		//Creating Changes
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation_Lock_1");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation_Lock_2");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		//Locking Changes 
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Lock");
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.lockSelectedItems(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		//Validating the Locked Changes
		changesPage.validateElementDisplayed("Change_Grid_Row_LockIcon", "Change_Automation_Lock_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changesPage.validateElementDisplayed("Change_Grid_Row_LockIcon", "Change_Automation_Lock_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	    
		//Validating Locked items cannot be deleted
		changesPage.deleteSelectedItems(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.validateElementDisplayed("Change_DeleteSelectedItem_PopUp", PlutoraConfiguration.changesData);
		changesPage.click("Change_DeleteSelectedItem_PopUpOKButton", PlutoraConfiguration.changesData);
		
	}
	
	/**
	 * @author Abhishek Kumar
	 * @throws InterruptedException 
	 *
	 */
	@Test (description="Sub-area: changes window -> Action -> UnLock Selected Items")
	public void subareaChangesGrid_05() throws InterruptedException {
	   //Navigating to Change Page
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Lock");
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	  //Unlocking Changes
		changesPage.unlockSelectedItems(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	  //Validating the UnLocked Changes
		changesPage.validateElementDisplayed("Change_Grid_Row_UnLockIcon", "Change_Automation_Lock_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changesPage.validateElementDisplayed("Change_Grid_Row_UnLockIcon", "Change_Automation_Lock_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		
	}
	
	
	/**
	 * @author Abhishek Kumar
	 * @throws InterruptedException 
	 *
	 */
	@Test (description="Sub-area: changes window -> Action -> Bulk Delete")
	public void subareaChangesGrid_06() throws InterruptedException {
	   //Navigating to Change Page
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	  
	  //Deleting Selected items
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Lock");
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_Lock_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);	 
		changesPage.deleteSelectedItems(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	  
	  //Confirming delete Action
		changesPage.click("Change_DeleteConfimationBox_PopUpYesButton", PlutoraConfiguration.changesData);
		
	  //Waiting for delete action to take affect
		changesPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		
	  //Validating items are deleted
	    changesPage.verifyElementNotDisplayed("Change_ChangeName_link","Change_Automation_Lock_1",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
	    changesPage.verifyElementNotDisplayed("Change_ChangeName_link","Change_Automation_Lock_2",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);

	}
	
	/**
	 * @author Abhishek Kumar
	 * @throws InterruptedException 
	 *
	 */
	@Test (description="Sub-area: changes window -> Grid Column Filtering ")
	public void subareaChangesGrid_07() throws InterruptedException {
	//Navigating to Change Page
	  changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Clearing already existing grid filters if any

	  changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	  changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
	  changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");

    //Creating Change
	  changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	//Saving and closing the created change
	  changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Entering Portfolio Association in the column Filter
	  changesPage.enterPortFolioAssociation(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	//Verifying Portfolio Association Column
	  changesPage.verifyTextContains("Change_PortfolioFirstCompanyName_Text", "Change_Organization", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	//Entering Change Name
	  changesPage.enterChangeName(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	//Verifying Change Name
	  changesPage.verifyTextContains("Change_ChangeNameFirstLink_Link","Change_Automation_Id", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
    //Navigating to the newly created Change
	  changesPage.click("Change_ChangeNameFirstLink_Link", "Change_Automation_Id", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	  changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
	//Getting the change ID and closing the change wondow
	  String ChangeId = changesPage.fetchChaneId(PlutoraConfiguration.changesData);
	  changesPage.click("Change_CancelIcon_image", PlutoraConfiguration.changesData);
	//Entering ID
	  changesPage.SetChangeIdToIdGrid(ChangeId, PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Verifying ID
	  changesPage.validateElementDisplayed("Change_FirstChangeID_Link", ChangeId, PlutoraConfiguration.changesData);
	//Set Priority to High
	  changesPage.SetPriorityHighInGrid(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Verifying Priority 
	  changesPage.validateElementDisplayed("Change_PrioritySet_label", "Priority_Name", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	//Entering Status
	  changesPage.SetStatusGrid(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Verifying Status
	  changesPage.validateElementDisplayed("Change_StatusSet_label","Status_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
	
	}
	
	@Test (description="Sub-area: changes window -> Clear Grid Column Filtering ")
	public void subareaChangesGrid_08() throws InterruptedException {
	//Navigating to Change Page
	  changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Clearing already existing grid filters if any

	  changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	  changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	  changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
	  changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	  changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	  changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);

	//Creating Change
	  changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	//Saving and closing the created change
	  changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Entering Portfolio Association in the column Filter
	  changesPage.enterPortFolioAssociation(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	//Entering Change Name
	  changesPage.enterChangeName(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	//Navigating to the newly created Change
	  changesPage.click("Change_ChangeNameFirstLink_Link", "Change_Automation_Id", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	  changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
	//Getting the change ID and closing the change wondow
	  String ChangeId = changesPage.fetchChaneId(PlutoraConfiguration.changesData);
	  changesPage.click("Change_CancelIcon_image", PlutoraConfiguration.changesData);
	//Entering ID
	  changesPage.SetChangeIdToIdGrid(ChangeId, PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	//Set Priority to High
	  changesPage.SetPriorityHighInGrid(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	 //Entering Status
	  changesPage.SetStatusGrid(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	 //Clearing Grid Column
      changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	 //Validating Grid Column Clearing
	  changesPage.verifyTextAttributeValue("Change_IDinput_inputbox", "",PlutoraConfiguration.changesData);
	  changesPage.verifyTextAttributeValue("Change_Name_InputBox", "",PlutoraConfiguration.changesData);
	  changesPage.verifyTextAttributeValue("Change_PortfolioAssociation_InputBox","",PlutoraConfiguration.changesData);
	  changesPage.verifyTextAttributeValue("Change_Status_InputBox","",PlutoraConfiguration.changesData );
	}	
	@Test (description="Action -> Grid Column Selector (check custom fields behavior)")
	public void subareaChangesGrid_09() throws InterruptedException {	
		
	 customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
     customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
	 changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);

	 changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
	 changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
	 changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");

	 changesPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Change_CustomField_Name","Action_Button");
	 changesPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name"));
	 Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name").toUpperCase()+" verified in change grid successfully !");
	 changesPage.clearGridColumnSelector(PlutoraConfiguration.objectData,"Action_Button");
	 changesPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name").toUpperCase());
	 Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name").toUpperCase()+" not displayed in release grid successfully !");	
	 changesPage.closeGridColumnSelectorPopup(PlutoraConfiguration.objectData,"Action_Button");

	}
	
	@Test (description="Change Sub area : metrics")
	public void subareaChangesGrid_10() throws InterruptedException  {	 
	changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	changesPage.clickOnButton(PlutoraConfiguration.objectData,"Metrics_HideIcon","Metrics_ViewIcon",PlutoraConfiguration.objectData,"xpath");
	changesPage.validateElementDisplayed("Change_ImplementOverTime_Label", PlutoraConfiguration.changesData);
	changesPage.validateElementDisplayed("Change_BacklogBySystem_Label", PlutoraConfiguration.changesData);
	changesPage.validateElementDisplayed("Change_BacklogByBusinessValue", PlutoraConfiguration.changesData);
	changesPage.validateElementDisplayed("Change_NoOfChange_Graph", PlutoraConfiguration.changesData);
	changesPage.validateElementDisplayed("Change_ChangeBackLogBySystem_PieChart", PlutoraConfiguration.changesData);
	changesPage.validateElementDisplayed("Change_ChangeBackByBusinessValue_PieChart", PlutoraConfiguration.changesData);
	changesPage.clickOnButton(PlutoraConfiguration.objectData,"Metrics_ViewIcon","Metrics_HideIcon",PlutoraConfiguration.objectData,"xpath");
   }
	
	@Test (description="Change Sub area : Filter By")
	public void subareaChangesGrid_11() throws InterruptedException, ParseException {
	    //Navigating to Change Page
	    changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	    //Clearing already existing grid filters if any
	    changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);

		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);

		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	    //Creating Change
	    changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    //Saving and closing the created change
	    changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	    //FindingChange
	    changesPage.findChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    //Click on My Portfolio Association
	    releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_MyPortfolioAssociation_Tab", PlutoraConfiguration.objectData);
		//Verifying Portfolio Association
	    changesPage.verifyTextContains("Change_PortfolioFirstCompanyName_Text", "Change_Organization", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	    Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" verified in change grid successfully !");
	    //FindingChange
	    changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    //Navigating to stakeholders
	    changesPage.click("Change_Page_Shakeholder_Tab", PlutoraConfiguration.changesData);
	    //Adding Stakeholders
	    releasePage.updateUserGroupsToStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,  "Loggedin_Username_Value", "Releases_CStakeholder_Button");
	    //Saving and closing the change
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//FindingChange
		changesPage.findChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    //Click on I'm a Stakeholder
	    releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_IamStakeholder_Tab", PlutoraConfiguration.objectData);
	    //Verifying I'm a Stakeholder
	    changesPage.verifyTextContains("Change_PortfolioFirstCompanyName_Text", "Change_Organization", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
	    Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" verified in change grid successfully !");
	    //Clicking on All
	    releasePage.clickOnButton(PlutoraConfiguration.releasesData, "Release_All_Tab", PlutoraConfiguration.objectData);
	    //Verifying All result
	    changesPage.verifyTextContains("Change_PortfolioFirstCompanyName_Text", "Change_Organization", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
	    Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" verified in change grid successfully !");
	}
	
	@Test (description="Action -> Bulk Update")
	public void subareaChangesGrid_12() throws InterruptedException, ParseException {
		/*Navigating to Customization page*/
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Creating Custom Fields*/
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		/*Navigating to change page*/
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		/*Creating Column using Grid Column Selector*/
		changesPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Change_CustomField_Name","Action_Button");	
	    /*Create Change #1*/
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change_Automation_BulkUpdate_1");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Automation_Name1", "Change_Automation_BulkUpdate_1");
		/*Saving and Closing Change #1*/
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/*Create Change #2*/
		changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Change_Automation_BulkUpdate_2");
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Automation_Name2", "Change_Automation_BulkUpdate_2");
		/*Saving and Closing Change #2*/
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/*Searching for 'Bulk Update' in live search*/
		changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"BulkUpdate");
		/*Selecting the checkboxes for Bulk Update*/
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_BulkUpdate_1", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		changesPage.clickButton("Change_Grid_Row_Checkbox", "Change_Automation_BulkUpdate_2", PlutoraConfiguration.changesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	    //navigating to Actions-> Bulk Update
		changesPage.selectUnderActionDropDown(PlutoraConfiguration.changesData, "Change_Type_Action_Button", PlutoraConfiguration.objectData, "Change_BulkUpdate_ActionDropDownItem");
		/*Updating Bulk update information*/
		changesPage.updateBulkUpdateData(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Searching for 'Bulk Update' in live search*/
	    changesPage.findAndSelectChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"BulkUpdate");
	    /*Navigating to the first Change*/
	    changesPage.clickElementUsingJavaScript("Change_ChangeNameFirstLink_Link", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Name1"), PlutoraConfiguration.changesData);
	    changesPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
	    /*Validating the updates done on first change*/
	    Listener.addLogger("Validating Upadation for first change...");
	    Listener.addLogger("Validating Portfolio Association Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_PortFolioAssoChangePopUp_InputBox", PlutoraConfiguration.changesData),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_PortfolioAssociation_ListSecondItem"));
	    Listener.addLogger("Validating Status Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Status_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateStatus_ListSecondItem"));
	    Listener.addLogger("Validating Type Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Type_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateType_ListSecondItem"));
	    Listener.addLogger("Validating Priority Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Priority_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_BulkUpdatePriority_ListSecondItem"));
	    Listener.addLogger("Validating Theme Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_Theme_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_BulkUpdateDetailsTheme_DropDownSecondItem"));
	    Listener.addLogger("Validating Delivery Risk Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_DeliveryRisk_InputField",PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateDetailsDeliverRisk_DropDownSecondItem"));
	    /*Clicking on cancel icon*/
	    changesPage.clickElementUsingJavaScript("Change_CancelIcon_image", PlutoraConfiguration.changesData);
	    /*Navigating to the Second Change*/
	    changesPage.clickElementUsingJavaScript("Change_ChangeNameFirstLink_Link", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Name2"), PlutoraConfiguration.changesData);
	    changesPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
	    /*Validating the updates done on Second change*/
	    Listener.addLogger("Validating Upadation for Second change...");
	    Listener.addLogger("Validating Portfolio Association Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_PortFolioAssoChangePopUp_InputBox", PlutoraConfiguration.changesData),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_PortfolioAssociation_ListSecondItem"));
	    Listener.addLogger("Validating Status Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Status_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateStatus_ListSecondItem"));
	    Listener.addLogger("Validating Type Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Type_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateType_ListSecondItem"));
	    Listener.addLogger("Validating Priority Input Box...");
	    Assert.assertEquals(changesPage.getTextData("Change_Priority_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_BulkUpdatePriority_ListSecondItem"));
	    Listener.addLogger("Validating Theme Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_Theme_InputField", PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData,"Change_BulkUpdateDetailsTheme_DropDownSecondItem"));
	    Listener.addLogger("Validating Delivery Risk Input Box...");
	    Assert.assertEquals(changesPage.getAttributeData("Change_DeliveryRisk_InputField",PlutoraConfiguration.changesData), PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_BulkUpdateDetailsDeliverRisk_DropDownSecondItem"));
	    /*Clicking on cancel icon*/
	    changesPage.clickElementUsingJavaScript("Change_CancelIcon_image", PlutoraConfiguration.changesData);
	
	}
	
	@Test (description="Sub-area:release grid -> Query Builder (QB) + Quick Access menu")
	public void subareaChangesGrid_13() throws InterruptedException {
		
		/*Navigating to Customization page*/
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    
		/*Creating Custom Fields*/
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Customization_ChangeCustomFields_Option","Change_CustomField_Name");
		
		/*Navigating to change page*/
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		/*Creating Column using Grid Column Selector*/
		changesPage.addGridColumnSelector(PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Change_CustomField_Name","Action_Button");
		
		/*Clearing existing query if any*/
		changesPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,10,0);
		changesPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		
		/*Creating Change*/
	    changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Saving and closing the created change*/
	    changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	    
	    /*Clearing Live Search*/
	    changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
	    changesPage.enter();
	    
	    /*Navigating to the newly created Change*/
		changesPage.click("Change_ChangeNameFirstLink_Link", "Change_Automation_Id", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.fetchChaneId(PlutoraConfiguration.changesData);
		changesPage.click("Change_CancelIcon_image", PlutoraConfiguration.changesData);
	    
		/*Adding a new Public Query*/
	    changesPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
	    changesPage.addChangeIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change ID", "equals","Change_id","1");
	    
	    /*Saving And Running The Query*/
	    changesPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Public", "Query_Public_Builder");
	    changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
	    
	    /*Verifying Search Result*/
	    changesPage.verifyText("Change_ChangeNameFirstLink_Link","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" verified public query builder successfully !"); 
	    
		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		/* Logging In with different Account */
		loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	
		/* Navigating to change page */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		/* Clearing Live Search If any */
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		
		/* Clicking Query Builder */
		changesPage.clickQueryBuilderOption(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Query_Public_Builder");
	
		/* Verifying Search Results */
		changesPage.verifyText("Change_ChangeNameFirstLink_Link","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" verified  public query builder in other account successfully !");
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username, PlutoraConfiguration.password);
		
		/* Navigation to Change Page */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
	    /* Finding and Opening Change */
		changesPage.findAndOpenChange(PlutoraConfiguration.changesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		
		/* Getting change Status */
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Change_Status",changesPage.getTextData("Change_StatusUpdated_InputBox", PlutoraConfiguration.changesData));
		changesPage.click("Change_CancelIcon_image", PlutoraConfiguration.changesData);
		
		/* Adding a New Private query */
		changesPage.clickNewQueryBuilder(PlutoraConfiguration.objectData);
		
		/* Adding the first Condition */
		changesPage.addStatusQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change Status", "equals", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Status"),"1","1");
		changesPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
		
		/* Adding the Second Condition */
		changesPage.addCondition(PlutoraConfiguration.objectData, "And",  "2");
		changesPage.addIdQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Change Name", "equals", "Change_Automation_Id","2");
		changesPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
	
		/* Adding the Third Condition */
		changesPage.addCondition(PlutoraConfiguration.objectData, "Or",  "3");
		changesPage.addCalendarQueryBuilder(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_CustomField_Name"), "on","3");
		changesPage.clickOnButton(PlutoraConfiguration.objectData,"QueryBuilder_AddQuery_Icon",PlutoraConfiguration.objectData);
	
		/* Adding the Fourth Condition */
		changesPage.addCondition(PlutoraConfiguration.objectData, "And",  "4");
        changesPage.addOrganizationQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Portfolio Association", "contains", PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Organization"),"4","4");
        
        /* Saving and Running Query */
        changesPage.saveAndRunQuery(PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Private", "Query_Private_Builder");
		
        /* Verifying Results */
        changesPage.verifyTextContains("Change_ChangeNameFirstLink_Link","Change_Automation_Id", PlutoraConfiguration.changesData, PlutoraConfiguration.testData);
        changesPage.validateElementDisplayed("Change_StatusSet_label","Status_Name",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
        changesPage.verifyTextContains("Change_PortfolioFirstCompanyName_Text", "Change_Organization", PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
	
        /* Logging Out */
        logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
        
        /* Logging In with another account */
        loginPage.newLoginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
        
        /* Navigating to change page */
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		
		/* Clicking On quick access menu */
		changesPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,10,0);
		changesPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Query_Private_Builder")+" not displayed in query builder in other account successfully !");
		
		/* Logging Out */
		logoutPage.loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		
		/* Logging In */
		loginPage.loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username, PlutoraConfiguration.password);
	
		/* Clearing existing query if */
		changesPage.clickOnPositionOfElement("QueryBuilder_Dropdown", PlutoraConfiguration.objectData,10,0);
		changesPage.clickElementUsingJavaScript("QueryBuilder_ClearQuery_Option", PlutoraConfiguration.objectData);
		changesPage.waitForLoadingIconDisappear(60,"Loading_Gif",PlutoraConfiguration.objectData);
        
	}
	
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void subareaChangesGrid_14() throws InterruptedException, AWTException, HeadlessException, UnsupportedFlavorException, IOException {	
		
		/*Navigating to change page*/
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
		
		/*Creating Change*/
	    changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Saving and closing the created change*/
	    changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	    /*Finding And Opening Change*/
	    changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Clicking on Copy to Clipboard Icon*/
		changesPage.click("Change_CopyURL_Icon", PlutoraConfiguration.changesData);
		changesPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		changesPage.sleep(4000);
		/*Getting data from clipboard*/
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		/*Clicking on save and close*/
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/*Navigating to the copied URL*/
		ChangesPage.launchUrl(dstData);
		changesPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		/*Verifying Change Name*/
		changesPage.verifyTextAttributeValue("Change_Name_Textfield","Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Change_Automation_Id")+" redirected to change details page after performing copy URL to clipboard for logged in session successfully !");
		/*Clicking on save and close*/
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/*Logging out*/
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		/*Navigating to the copied URL*/
		ChangesPage.launchUrl(dstData);
		/*Verifying elements*/
		changesPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		changesPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ChangesPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username, PlutoraConfiguration.password);
		
	}
	
	@Test (description="Sub-change window -> Details tab -> Attachments")
	public void subareaChangesGrid_15() throws InterruptedException, ParseException, IOException, AWTException {	
		/*Navigating to change page*/
		changesPage.changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		/*Creating Change*/
	    changesPage.createChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Saving and closing the created change*/
	    changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	    /*Finding And Opening Change*/
	    changesPage.clickQueryBuilderClearOption(PlutoraConfiguration.objectData);
		changesPage.clear("Change_Search_Textfield", PlutoraConfiguration.changesData);
		changesPage.clearGridColumnFiltering(PlutoraConfiguration.objectData,"Action_Button");
	    changesPage.findAndOpenChange(PlutoraConfiguration.changesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
	    /*Uploading Image*/
	    changesPage.uploadImage(PlutoraConfiguration.changesData);
	    /*Verifying File Name*/
	    changesPage.verifyTextDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" uploaded file verified successfully !");
		
		changesPage.clickOnSaveButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		//Download 
		changesPage.clickOnButton(PlutoraConfiguration.changesData, "Change_AttachmentDownloadIcon_Image", PlutoraConfiguration.objectData);
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"screenshot");
		Assert.assertTrue(!excelFile.isEmpty());
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" Downloaded file verified successfully !");
		//Delete
		changesPage.clickOnButton(PlutoraConfiguration.changesData, "Change_AttachmentDeleteIcon_Image", PlutoraConfiguration.objectData);
		changesPage.clickOnButton(PlutoraConfiguration.changesData, "Change_DeletePopUpYes_Button", PlutoraConfiguration.objectData);
		changesPage.clickOnSaveButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
		changesPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "File_Name")+" uploaded file deleted successfully !");
		changesPage.clickOnSaveAndCloseButton(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
	}
		
}
