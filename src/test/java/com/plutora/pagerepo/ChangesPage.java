package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import org.openqa.selenium.By;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;


public class ChangesPage extends TestGenericUtilLib{
	CustomizationPage customizationPage = new CustomizationPage();
	SystemsPage systemPage= new SystemsPage();

	public void changePage(String changeData,String objectData) throws InterruptedException{	
		sleep(2000);
		if(isMenuButtonPresent("Nav_Bar_Menu_Logo", objectData)) {
			click("Nav_Bar_Menu_Logo", objectData);
			sleep(500);
			clickElementUsingJavaScript("Releases_Header_Sidemenu", changeData);
			sleep(500);
			click("Change_Dropdown_Sidemenu", changeData);
		} else {
			mouseHover("Releases_Header_Dropdown", "Change_Dropdown_Option",changeData);
		}
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void createChange(String changeData,String testData,String objectData){	
		clickElementUsingJavaScript("Change_New_Button",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_Name_Textfield", PropertiesCache.setProperty(testData, "Change_Automation_Id"),changeData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Change_Organization",getAttributeData("Change_Organization_Textbox", changeData));
		sleep(3000);
		clickElementUsingJavaScript("Change_Type_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Type_FirstOption", changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Status_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Status_Name",getTextData("Change_Status_FirstOption", changeData));
		clickElementUsingJavaScript("Change_Status_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Priority_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		PropertiesCache.setProperty(testData, "Priority_Name",getTextData("Change_Priority_FirstOption", changeData));
		clickElementUsingJavaScript("Change_Priority_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Theme_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Theme_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_DeliveryRisk_Dropdown",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_DeliveryRisk_FirstOption",changeData);
		
		
	}
	public void createReleaseChange(String changeData,String testData,String objectData,String changeId){	
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_Name_Textfield", PropertiesCache.setProperty(testData, changeId),changeData);
		sleep(3000);
		click("Change_Release_Type_Dropdown", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Type_FirstOption", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Release_Status_Dropdown", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Status_FirstOption", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Release_Priority_Dropdown", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Priority_FirstOption", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Release_Theme_Dropdown", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Theme_FirstOption", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_Release_DeliveryRisk_Dropdown",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		click("Change_DeliveryRisk_FirstOption",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void createChangeReleateTo(String changeData,String testData,String objectData){	
		clickElementUsingJavaScript("Change_New_Button",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_Name_Textfield", PropertiesCache.setProperty(testData, "Change_Automation_ReleateTo_Id"),changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Type_Dropdown", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Type_FirstOption", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Status_Dropdown", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Status_FirstOption", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Priority_Dropdown", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Priority_FirstOption", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Theme_Dropdown", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Theme_FirstOption", changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_DeliveryRisk_Dropdown",changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_DeliveryRisk_FirstOption",changeData);

	}

	public void createChangeChildOf(String changeData,String testData,String objectData){	
		clickElementUsingJavaScript("Change_New_Button",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_Name_Textfield", PropertiesCache.setProperty(testData, "Change_Automation_ChildOf_Id"),changeData);
		sleep(3000);
		clickElementUsingJavaScript("Change_Type_Dropdown", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Type_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Status_Dropdown", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Status_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Priority_Dropdown", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Priority_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Theme_Dropdown", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Theme_FirstOption", changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_DeliveryRisk_Dropdown",changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_DeliveryRisk_FirstOption",changeData);

	}

	public void addRelatesToChange(String changeData,String testData,String objectData) {
		click("Change_AddLink_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Change_AddLink_RelatesToLabel",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		scrollToElement("Change_RelatesTo_Textbox", changeData);
		sleep(2000);
		click("Change_RelatesTo_Textbox",changeData);
		sleep(2000);
		sendKeysWithoutClear("Change_RelatesTo_Textbox","Change_Automation_ReleateTo_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(4000);
		String projectId=PropertiesCache.getProperty(testData, "Change_Automation_ReleateTo_Id");
		clickElementUsingJavaScript("Changes_Relates", "Change_Automation_ReleateTo_Id",changeData,testData);
		//driver.findElement(By.xpath("//li[text()='"+projectId+"']")).click();
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		sleep(1000);
		click("Change_AddLinkRelatesTo_AddButton",changeData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		Listener.addLogger("Relates Change is addded successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Relates to:']/following-sibling::div//div[contains(@data-qtip,'"+projectId+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Relates Chage is verified successfully !");
		System.out.println("Relates Chage is verified successfully !");

	}
	public void addParentToChange(String changeData,String testData,String objectData) {
		sleep(2000);
		click("Change_AddLink_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Change_AddLink_ParentToLabel",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		scrollToElement("Change_ParentTo_Textbox", changeData);
		sleep(2000);
		click("Change_ParentTo_Textbox",changeData);
		sleep(2000);
		sendKeys("Change_ParentTo_Textbox","Change_Automation_ReleateTo_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		String projectId=PropertiesCache.getProperty(testData, "Change_Automation_ReleateTo_Id");
		clickElementUsingJavaScript("Changes_Relates", "Change_Automation_ReleateTo_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		sleep(2000);
		click("Change_AddLinkParentTo_AddButton",changeData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		Listener.addLogger("Parent Change is added successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Parent to:']/following-sibling::div//div[contains(@data-qtip,'"+projectId+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Parent Change is verified successfully !");
		System.out.println("Parent Change is verified successfully !");
	}
	public void addChildOfChange(String changeData,String testData,String objectData) {
		sleep(2000);
		click("Change_AddLink_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		click("Change_AddLink_ChildOfLabel",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		scrollToElement("Change_ChildOf_Textbox", changeData);
		sleep(2000);
		click("Change_ChildOf_Textbox",changeData);
		sleep(2000);
		sendKeys("Change_ChildOf_Textbox","Change_Automation_ChildOf_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(2000);
		String projectId=PropertiesCache.getProperty(testData, "Change_Automation_ChildOf_Id");
		clickElementUsingJavaScript("Changes_Relates", "Change_Automation_ChildOf_Id",changeData,testData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		sleep(2000);
		click("Change_AddLinkChildOf_AddButton",changeData);
		waitForLoadingIconDisappear(500,"Loading_Gif", objectData);
		Listener.addLogger("Child Change is added successfully !");
		boolean flag = driver.findElement(By.xpath("//label[text()='Child of:']/following-sibling::div//div[contains(@data-qtip,'"+projectId+"')]")).isDisplayed();
		assertTrue(flag);
		Listener.addLogger("Child Change is verified successfully !");
		sleep(2000);
		System.out.println("Child Change is verified successfully !");
	}

	public void clickOnSaveAndCloseButton(String changeData,String objectData) {
		clickElementUsingJavaScript("Change_SaveClose_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		sleep(1000);
	}

	public void clickOnSaveButton(String changeData,String objectData) {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_Save_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void verifyChange(String changeData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeysWithEnter("Change_Search_Textfield", "Change_Automation_Id",changeData,testData);
		//enter();
	}
	
	public void uploadImage(String changeData) throws InterruptedException, IOException, AWTException {
		scrollToElement("Change_Attachment_NewButton",changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Attachment_NewButton",changeData);
		sleep(1000);
		uploadImageByName("uploadfile");
	 }
	
	

	public void updateChange(String changeData,String testData,String objectData){	
		Listener.addLogger("Change link is clicked and change page has opened");
		click("Update_Change_Type_Dropdown",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		/*click("Update_Change_Type_ThirdOption",changeData);
		click("Update_Change_Type_ThirdOption",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_Status_Dropdown",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_Status_FirstOption",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_Priority_Dropdown",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Update_Change_Priority_SecondOption",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_Theme_Dropdown", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Update_Change_Theme_SecondOPtion", changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_DeliveryRisk_Dropdown",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Update_Change_DeliveryRisk_SecondOption",changeData);
		sleep(1000);*/
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Change_SaveClose_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}


	public void createDuplicateChange(String changeData,String testData,String objectData) throws InterruptedException{	
		Listener.addLogger("User is about to duplicate a Change");
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Change_Search_Textfield", "Change_Automation_Id",changeData,testData);
		enter();
		sleep(2000);
		clickElementButton(changeData, "Change_Row_Checked_Checkbox", "Change_Row_UnChecked_Checkbox", "Change_Automation_Id",testData,objectData);
		sleep(500);
		clickElementUsingJavaScript("Change_Type_Action_Button",changeData);
		sleep(2000);
		click("Change_Type_Action_DuplicateOption",changeData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Change_Duplicate_SetName_Textbox",setDuplicateName("(Copy)", "Change_Automation_Id", "Copy_Change_Automation_Id", testData),changeData);
		sleep(3000);
		click("Change_Type_Popup_Duplicate_Button",changeData);

	}
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void lockSelectedItems(String changeData,String objectData){	

		sleep(2000);
		click("Change_Type_Action_Button",changeData);
		sleep(2000);
		click("Change_LockSelectedItem_Dropdown",changeData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
	}
	
	/**
	 * @author Abhishek Kumar
	 * Desc:
	 * Selects a particular item under the Action DropDown 
	 * Menu on change Page
	 * @param String - locator for Action drop Down Arrow
	 * @param String - change Page data
	 * @param String - object Page data
	 * @param String - locator for element to be clicked 
	 */
	public void selectUnderActionDropDown(String changeData,String locatorForAction,String objectData, String elementToBeClicked){	

		sleep(2000);
		click(locatorForAction,changeData);
		sleep(2000);
		click(elementToBeClicked,changeData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
	}

	
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void unlockSelectedItems(String changeData,String objectData){	

		sleep(2000);
		click("Change_Type_Action_Button",changeData);
		sleep(2000);
		click("Change_UnLockSelectedItem_Dropdown",changeData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
	}
	
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void deleteSelectedItems(String changeData,String objectData){	

		sleep(2000);
		click("Change_Type_Action_Button",changeData);
		sleep(2000);
		click("Change_DeleteSelectedItem_Dropdown",changeData);
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		
	}
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void enterPortFolioAssociation(String changedata,String testdata,String objectData){	
		Listener.addLogger("Cliking on Change Association Down Arrow..");
		click("Change_PortfolioAssociation_DownArrow",changedata);
		Listener.addLogger("Selecting Company Name and hitting enter..");
		click("Change_PortfolioCompanyName_Checkbox","Change_Organization",changedata,testdata);
		enter();
		sleep(2000);
		Listener.addLogger("Waiting for the loader to dissapear..");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	
	
	
	/**
	 * @author Abhishek Kumar
	 * @throws ParseException 
	 *
	 */
	public void updateBulkUpdateData(String changedata,String testData,String objectData) throws ParseException{	
		Listener.addLogger("Cliking on Portfolio Association DrpDown....");
		click("Change_PortfolioAssociation_DownArrow",changedata);
		waitForLoadingElement(10, "Change_PortfolioAssociation_ListSecondItem", changedata);
		Listener.addLogger("Selecting the First Option in the first Company...");
		PropertiesCache.setProperty(testData,"Change_PortfolioAssociation_ListSecondItem",getTextData("Change_PortfolioAssociation_ListSecondItem", changedata));
		clickElementUsingJavaScript("Change_PortfolioAssociation_ListSecondItem",changedata);
		
		Listener.addLogger("Clicking on Status dropdown...");
		clickElementUsingJavaScript("Change_BulkUpdateDetailsStatus_DownArrow",changedata);
		Listener.addLogger("Selecting Second Option in the status Dropdown...");
		waitForLoadingElement(10, "Change_BulkUpdateDetailsStatus_DropDownSecondItem", changedata);
		PropertiesCache.setProperty(testData,"Change_BulkUpdateStatus_ListSecondItem",getTextData("Change_BulkUpdateDetailsStatus_DropDownSecondItem", changedata));
		clickElementUsingJavaScript("Change_BulkUpdateDetailsStatus_DropDownSecondItem",changedata);
		
		Listener.addLogger("Clicking on Type dropdown...");
		clickElementUsingJavaScript("Change_BulkUpdateDetailsType_DownArrow",changedata);
		Listener.addLogger("Selecting Second Option in the Type Dropdown...");
		waitForLoadingElement(10, "Change_BulkUpdateDetailsType_DropDownSecondItem", changedata);
		PropertiesCache.setProperty(testData,"Change_BulkUpdateType_ListSecondItem",getTextData("Change_BulkUpdateDetailsType_DropDownSecondItem", changedata));
		clickElementUsingJavaScript("Change_BulkUpdateDetailsType_DropDownSecondItem",changedata);
		
		Listener.addLogger("Clicking on Priority dropdown...");
		clickElementUsingJavaScript("Change_BulkUpdateDetailsPriority_DownArrow",changedata);
		Listener.addLogger("Selecting Second Option in the Priority Dropdown...");
		waitForLoadingElement(10, "Change_BulkUpdateDetailsPriority_DropDownSecondItem", changedata);
		PropertiesCache.setProperty(testData,"Change_BulkUpdatePriority_ListSecondItem",getTextData("Change_BulkUpdateDetailsPriority_DropDownSecondItem", changedata));
		clickElementUsingJavaScript("Change_BulkUpdateDetailsPriority_DropDownSecondItem",changedata);
		
		Listener.addLogger("Clicking on Theme dropdown...");
		clickElementUsingJavaScript("Change_BulkUpdateDetailsTheme_DownArrow",changedata);
		Listener.addLogger("Selecting Second Option in the Theme Dropdown...");
		waitForLoadingElement(10, "Change_BulkUpdateDetailsTheme_DropDownSecondItem", changedata);
		PropertiesCache.setProperty(testData,"Change_BulkUpdateDetailsTheme_DropDownSecondItem",getTextData("Change_BulkUpdateDetailsTheme_DropDownSecondItem", changedata));
		clickElementUsingJavaScript("Change_BulkUpdateDetailsTheme_DropDownSecondItem",changedata);
		
		Listener.addLogger("Clicking on Delivery Risk dropdown...");
		clickElementUsingJavaScript("Change_BulkUpdateDetailsDeliveryRisk_DownArrow",changedata);
		Listener.addLogger("Selecting Second Option in Delivery Risk Dropdown...");
		waitForLoadingElement(10, "Change_BulkUpdateDetailsDeliveryRisk_DropDownSecondItem", changedata);
		PropertiesCache.setProperty(testData,"Change_BulkUpdateDetailsDeliverRisk_DropDownSecondItem",getTextData("Change_BulkUpdateDetailsDeliveryRisk_DropDownSecondItem", changedata));
		clickElementUsingJavaScript("Change_BulkUpdateDetailsDeliveryRisk_DropDownSecondItem",changedata);
		
		Listener.addLogger("Clicking on Custom Input Box...");
		clickElementUsingJavaScript("Change_AdditionalInfo_CustomInputBoxDatePicker","Change_CustomField_Name",changedata,testData);
		waitForLoadingElement(100,"Change_AdditionalInfo_TodayDate",changedata);
		scrollToElement("Change_AdditionalInfo_TodayDate", changedata);
		//clickElementUsingJavaScript("Change_AdditionalInfo_TodayDate", changedata);
		//releasePage.datePicker(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,"Release_Calender_AppPickerLabel",releasePage.getCurrentDate("0"));
		applicationDatePicker(changedata, testData,"Change_Calender_AppPickerLabel",getCurrentDate("0"));
		PropertiesCache.setProperty(testData,"Custom_Field_InputBoxDateValue", getAttributeValue("Change_AdditionalInfo_CustomInputBox","Change_CustomField_Name",changedata,testData,"value" ));
		Listener.addLogger("Clicking on Update...");
		clickElementUsingJavaScript("Change_BulkUpdate_UpdateButton", changedata);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void enterChangeName(String changedata,String testdata,String objectData){	
		Listener.addLogger("Entering Change Name and hitting Enter..");
		sendKeysWithEnter("Change_Name_InputBox", "Change_Automation_Id",changedata,testdata);
		sleep(2000);
		Listener.addLogger("Waiting for the loader to dissapear..");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}	
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public String fetchChaneId(String changedata){	
		Listener.addLogger("Fetching the Change id..");
		String ChangeId1[] = getTextData("Change_ChangeIdText_Label", PlutoraConfiguration.changesData).split("-");
		String ChangeId= ChangeId1[0].substring(2,ChangeId1[0].length()).trim();
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"Change_id",ChangeId);
		return ChangeId;
	}
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void SetChangeIdToIdGrid(String ChangeId,String changedata,String objectdata){	
		Listener.addLogger("Entering change id in ID Grid column..");
		sendKeys("Change_IDinput_inputbox", ChangeId, changedata);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectdata);
	}
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void SetPriorityHighInGrid(String changedata,String objectdata){	
		Listener.addLogger("Click on Priority Change Grid down Arrow..");
		click("Change_PriorityChangeGrid_DownArrow",changedata);
		click("Change_HighPriority_DropDownItem",changedata);
		Listener.addLogger("Hitting Enter..");
		sleep(2000);
		Listener.addLogger("Waiting for loader to disspear..");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectdata);
	}
	
	/**
	 * @author Abhishek Kumar
	 *
	 */
	public void SetStatusGrid(String changedata,String objectdata){	
		Listener.addLogger("Click on Status Grid down Arrow..");
		click("Change_StatusSet_DownArrow",changedata);
		click("Change_PipeLineAwaitingStatus_DropDownItem",changedata);
		Listener.addLogger("Hitting Enter..");
		enter();
		sleep(2000);
		Listener.addLogger("Waiting for loader to disspear..");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectdata);
	}
	
	
	public void deleteDuplicateChange(String changeData,String objectData,String testData){	
		Listener.addLogger("User is about to delete a duplicate Release");
		sleep(1000);
		click("Change_Result_Gridview_Name","Copy_Change_Automation_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Change_Delete_Button",changeData);
		sleep(1000);
		click("Change_Delete_Yes_Button",changeData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void deleteChange(String changeData,String objectData) {	
		Listener.addLogger("User is about to delete a Release");
		click("Change_Change_Tab",changeData);
		sleep(1000);
		click("Change_Delete_Button",changeData);
		sleep(1000);
		click("Change_Delete_Yes_Button",changeData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		Listener.addLogger("Change deleted successfully !");
	}

	public void findAndOpenChange(String changeData,String testData,String objectData) {	
		sendKeys("Change_Search_Textfield","Change_Automation_Id" , changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_Result_Gridview_Name","Change_Automation_Id",changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	
	public void findChange(String changeData,String testData,String objectData) {	
		sendKeys("Change_Search_Textfield","Change_Automation_Id" , changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		
	}
	
	public void findAndOpenChange(String changeData,String testData,String objectData,String changeId)  {	
		sendKeys("Change_Search_Textfield",changeId, changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_Result_Gridview_Name",changeId,changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getOpenChangePage(String changeData,String testData,String objectData)  {	
		click("Change_Result_Gridview_Name","Change_Automation_Id",changeData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void findAndSelectChange(String changeData,String testData,String objectData) {	
		sendKeys("Change_Search_Textfield","Change_Automation_Id" , changeData,testData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_CreatedChange_RowCheckbox",changeData);
	}

	public void getLockedChangePage(String changeData,String testData,String objectData) {	
		click("Change_Page_Unlock_Icon",changeData);
		sleep(4000);
	}

	public void getUnLockedChangePage(String changeData,String testData,String objectData) {	
		click("Change_Page_Lock_Icon",changeData);
		sleep(4000);
	}

	public void getLiveSearchClosePage(String changeData,String testData,String objectData) {	
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(4000);
		clickElementUsingJavaScript("Change_LiveSearch_Close_Button",changeData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public boolean findChangeRowDisplayed(String changeData,String testData,String objectData,int rowCount) {	
		int i = elementsCount("Change_LiveSearch_Row", changeData);
		boolean flag = false;
		if (i == rowCount) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	public boolean findChangeRowDisplayed(String changeData,String testData,String objectData,String rowCount) {	
		int i = elementsCount("Change_LiveSearch_Row", changeData);
		boolean flag = false;
		if (i > 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	public void addOrganizationQuery(String testData,String objectData,String columnId,String condition,String value,String index,String statusIndex) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		clickElementUsingJavaScript("QueryBuilder_Condition_Table_Dropdown_Option_One",value,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("BuildUpYourQuery_Text",objectData);
		
	}
	public void clickOnApplicationTab(String changeData,String objectData) {	
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_Application_Tab",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Change_New_System_Button",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void searchSystem(String changeData,String testData,String objectData,String systemName) {
		sleep(1000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sendKeysWithDeleteCharacter("Change_System_SearchResult",systemName ,changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		deleteSingleCharacter("Change_System_SearchResult", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}

	public void clickOnShakeholderTab(String changeData,String objectData) {	
		clickElementUsingJavaScript("Change_Page_Shakeholder_Tab",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickOnShakeholderNewTab(String changeData,String objectData) {	
		click("Change_Shakeholder_AddNew_Button",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void addStakeholderName(String changeData,String testData,String objectData){
		sleep(2000);
		clickElementUsingJavaScript("Change_UserGroupDropdown",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_UserGroupDropdown_Textbox", "Loggedin_Username_Value", changeData, testData);
		sleep(2000);
		clickElementUsingJavaScript("Change_UserGroupDropdown_Option","Loggedin_Username_Value",changeData,testData);
		sleep(2000);
	}

	public void addShakeholderRole(String changeData,String testData,String objectData){
		clickElementUsingJavaScript("Change_RoleDropdown", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_RoleFirst_Option", changeData);
		sleep(2000);
		click("Change_ShakeholderRACILabel",changeData);
		sleep(2000);
		click("Change_Add&CloseButton",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void addShakeholderUpdate(String changeData,String testData,String objectData){
		clickElementUsingJavaScript("Change_CreatedUserGroup_NameLink","Login_Email_Textfield_Value",changeData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_UserGroupUser_R_Checkbox", changeData);
		clickElementUsingJavaScript("Change_UserGroupUser_A_Checkbox", changeData);
		clickElementUsingJavaScript("Change_UserGroupUser_C_Checkbox", changeData);
		clickElementUsingJavaScript("Change_UserGroupUser_I_Checkbox", changeData);
		sleep(2000);
		click("Change_Update&CloseButton",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void shakeholderAccountableUpdate(String changeData,String testData,String objectData){
		clickElementUsingJavaScript("Change_TabPage", changeData);
		sleep(1000);
	}

	public void getShakeholderEditPage(String changeData,String testData,String objectData){
		clickElementUsingJavaScript("Change_Page_Shakeholder_Tab", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_CreatedUserGroup_NameLink","Login_Email_Textfield_Value",changeData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getShakeholderUpdatePage(String changeData,String testData,String objectData){
		clickElementUsingJavaScript("Change_RoleDropdown", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_RoleSecond_Option", changeData);
		sleep(2000);
		click("Change_ShakeholderRACILabel",changeData);
		sleep(2000);
		click("Change_Update&CloseButton",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getShakeholderRemovedPage(String changeData,String testData,String objectData){
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Stakeholder",changeData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Change_Shakeholder_RemoveButton", changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void clickOnChangeCloseIcon(String changeData){
		click("Change_Close_Icon", changeData);
		sleep(2000);
	}

	public void clickOnChangesExportToXLS(String changeData,String testData,String objectData) {
		waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
		sleep(2000);
		click("Change_CreatedChange_Action_Dropdown",changeData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Action_Dropdown_Option",changeData);
		sleep(6000);
	}

	public void verifyAdditionalInformationField(String changeData,String testData,String objectData,String customeFieldList) throws ParseException, InterruptedException {
		scrollToElement("Change_Additional_Information_Text", changeData);
		sleep(1000);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		verifyText("Change_Additional_Information_LabelName", "Change_CustomField_Name",changeData,testData);
		validateElementDisplayed("Change_Additional_Information_LabelTextbox", "Change_CustomField_Name",changeData,testData);
		verifyCustomFieldValue(changeData,testData,objectData,customeFieldList,"Change_CustomField_Name","Change_Automation_Id","Change_Name","Save&CloseButton");
		Listener.addLogger(PropertiesCache.getProperty(testData, "Change_CustomField_Name")+" - "+customeFieldList+" is displayed on the web page");
	}

	public void clickOnChangeCustomFieldOption(String customizationData,String objectData) {
		scrollToElement("Customization_ReleaseCustomFields_Option",customizationData);
		sleep(1000);
		click("Customization_ReleaseCustomFields_Option",customizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void getSystemPage(String changeData,String objectData) throws InterruptedException{	
		click("Change_Systems_Tab",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(1000);
	}

	public void createSystem1(String changeData,String testData,String objectData) {	
		click("Change_Systems_CreateButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_Systems_Details_Tab",changeData);
		sendKeys("Change_AddSystems_NameTextfield",PropertiesCache.setProperty(testData, "Systems_Test_Automation_Id1"),changeData);
		sendKeys("Change_AddSystems_DescriptonTextfield","New_Systems_Description_Value",changeData,testData);
		sendKeys("Change_AddSystems_VendorTextfield","New_Systems_Vendor_Value",changeData,testData);
		click("Change_AddSystems_ActiveRadio",changeData);
		click("Change_Systems_Save&CloseButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void createSystem2(String changeData,String testData,String objectData){	
		sleep(2000);
		click("Change_Systems_CreateButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_Systems_Details_Tab",changeData);
		sendKeys("Change_AddSystems_NameTextfield",PropertiesCache.setProperty(testData, "Systems_Test_Automation_Id2"),changeData);
		sendKeys("Change_AddSystems_DescriptonTextfield","New_Systems_Description_Value",changeData,testData);
		sendKeys("Change_AddSystems_VendorTextfield","New_Systems_Vendor_Value",changeData,testData);
		click("Change_AddSystems_ActiveRadio",changeData);
		click("Change_Systems_Save&CloseButton",changeData);

	}

	public void searchSystem1(String changeData,String testData,String objectData){	
		sleep(2000);
		sendKeysWithEnter("Change_Systems_Search_Textbox","Systems_Test_Automation_Id1",changeData,testData);
		deleteSingleCharacter("Change_Systems_Search_Textbox", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void searchSystem2(String changeData,String testData,String objectData){	
		sleep(2000);
		sendKeysWithEnter("Change_Systems_Search_Textbox","Systems_Test_Automation_Id2",changeData,testData);
		deleteSingleCharacter("Change_Systems_Search_Textbox", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void searchReleaseLinkSystem(String changeData,String testData,String objectData){	
		sleep(1000);
		click("Change_Systems_Tab",changeData);
		sleep(2000);
		sendKeysWithEnter("Change_Systems_Search_Textbox","Systems_Test_Automation_Id",changeData,testData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		deleteSingleCharacter("Change_Systems_Search_Textbox", changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	
	public void openChangeSystemTab(String changeData){	
		sleep(1000);
		click("Change_Systems_Tab",changeData);
		sleep(2000);
	}
	
	public void openReleaseSystemTab(String changeData){	
		sleep(1000);
		click("Change_ReleaseSystem_Tab",changeData);
		sleep(2000);

	}
	public void navigateToReleaseChange(String changeData){	
		sleep(1000);
		click("Change_Release_Change_Tab",changeData);
		sleep(2000);
	}

	public void searchReleaseLinkChange(String changeData,String testData,String objectData){	
		sleep(1000);
		click("Change_Release_Change_Tab",changeData);
		sleep(2000);
		dragAndDrop("Change_Release_Change_Link", "Change_Release_Change_Grid", "Change_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void dragSearchedSystem1(String changeData,String testData,String objectData) {	
		sleep(2000);
		dragAndDrop("Change_Systems_Searched_DataRow", "Change_Systems_ImpactedArea", "Systems_Test_Automation_Id1",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void dragSearchedSystem2(String changeData,String testData,String objectData){	
		sleep(2000);
		dragAndDrop("Change_Systems_Searched_DataRow", "Change_Systems_RiskArea", "Systems_Test_Automation_Id2",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void dragSearchedReleaseLinkSystem(String changeData,String testData,String objectData){	
		sleep(2000);
		dragAndDrop("Change_Systems_Searched_DataRow", "Change_Systems_ImpactedArea", "Systems_Test_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void clickOnSaveClose(String changeData,String objectData){	
		click("Change_Systems_Save&CloseButton",changeData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void dragBackCreatedSystems(String changeData,String testData,String objectData){	
		//system1
		sleep(2000);
		dragAndDrop("Change_Systems_ImpactedArea_SystemLink", "Change_Systems_Available_Area", "Systems_Test_Automation_Id1",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		//system2
		sleep(2000);
		dragAndDrop("Change_Systems_RiskArea_SystemLink", "Change_Systems_Available_Area", "Systems_Test_Automation_Id2",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void deleteTestChange(String changeData,String testData,String objectData){	
		click("Change_TabPage",changeData);
		deleteChange(changeData, objectData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	/*public void getSystemsDetailsPage(String changeData, String objectData) throws InterruptedException {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
		mouseHover("Change_Environment_Header_Dropdown", "Change_Environment_Systems_Option", changeData);
		waitForLoadingIconDisappear("Loading_Gif", objectData);
	}*/

	public  void deleteNewlyCreatedSystems1(String changeData,String testData,String objectData) {
		sendKeys("Change_Systems_SearchButton","Systems_Test_Automation_Id1",changeData,testData);
		enter();
		sleep(2000);
		clickElementUsingJavaScript("Change_Systems_Name","Systems_Test_Automation_Id1",changeData,testData);
		sleep(2000);
		click("Change_Systems_ActionDropDown",changeData);
		sleep(1000);
		click("Change_Systems_DeleteIcon",changeData);
		sleep(1000);
		click("Change_Systems_YesButton",changeData);
		sleep(2000);
	}

	public  void deleteNewlyCreatedSystems2(String changeData,String testData,String objectData) {
		sendKeys("Change_Systems_SearchButton","Systems_Test_Automation_Id2",changeData,testData);
		enter();
		sleep(2000);
		clickElementUsingJavaScript("Change_Systems_Name","Systems_Test_Automation_Id2",changeData,testData);
		sleep(2000);
		click("Change_Systems_ActionDropDown",changeData);
		sleep(1000);
		click("Change_Systems_DeleteIcon",changeData);
		sleep(1000);
		click("Change_Systems_YesButton",changeData);
		sleep(2000);
	}

	public void openReleasePage(String changeData,String testData,String objectData) {	
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_ReleaseProject_Link","PRelease_Automation_Id",changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	
	public void openReleasePage(String changeData,String testData,String objectData,String releaseId)  {	
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_ReleaseProject_Link",releaseId,changeData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void newProjectReleasePage(String releaseData,String testData,String objectData,String releaseId) throws InterruptedException, ParseException{	
		sleep(2000);
		scrollToElement("AddNewRelease_Button",releaseData);
		click("AddNewRelease_Button",releaseData);
		click("AddProjectRelease_Button",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/*try {
			click("Release_Hide_Button",releaseData);
			waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		}catch(Exception e) {

		}*/
		clickOnButton(PlutoraConfiguration.releasesData,"Release_Show_Button","Release_Hide_Button",PlutoraConfiguration.objectData,"xpath");
		sendKeys("AddRelease_IDTextfield", PropertiesCache.setProperty(testData, releaseId),releaseData);
		sendKeys("AddRelease_NameTextfield",  PropertiesCache.setProperty(testData, "PRelease_Automation_Name"),releaseData);
		clickElementUsingJavaScript("AddRelease_RiskLevelDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_RiskLevel_FirstOption", releaseData);
		sleep(1000);
		click("AddRelease_ReleaseTypeDropdown", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddRelease_ReleaseType_FirstOption", releaseData);
		sendKeys("Releases_Independent_Release_Dependency_Dropdown_Option","Independent",releaseData);
		waitForLoadingIconDisappear(120,"Loading_Gif",objectData);
		sleep(2000);
		scrollToElement("AddRelease_ImplementationDate", "New_ER_Implementation_Date",releaseData,testData);
		sleep(2000);
		clickElementUsingJavaScript("AddRelease_ImplementationDate",releaseData);
		sleep(1000);
		datePicker(releaseData,testData,"Release_Calender_DatePickerLabel",getCurrentDate("2"));
		click("AddRelease_Save&CloseButton",releaseData);
	}

	public  void linkSystemReleasePage(String changeData,String testData,String objectData) {

		click("Change_ReleaseSystem_Tab",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_Systems_CreateButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_Systems_Details_Tab",changeData);
		sendKeys("Change_AddSystems_NameTextfield",PropertiesCache.setProperty(testData, "Systems_Release_Automation_Id"),changeData);
		sendKeys("Change_AddSystems_DescriptonTextfield","New_Systems_Description_Value",changeData,testData);
		sendKeys("Change_AddSystems_VendorTextfield","New_Systems_Vendor_Value",changeData,testData);
		click("Change_AddSystems_ActiveRadio",changeData);
		click("Change_Systems_Save&CloseButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_ReleaseSystems_SearchButton","Systems_Release_Automation_Id",changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Change_ReleaseSystem_Link", "Change_ReleaseSystem_CodeImplArea", "Systems_Release_Automation_Id",PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		clickOnSaveAndCloseButton(changeData, objectData);
	}
	
	public  void linkSystemReleasePage(String changeData,String testData,String objectData,String systemId) {

		click("Change_ReleaseSystem_Tab",changeData);
		sleep(2000);
		click("Change_Systems_CreateButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_Systems_Details_Tab",changeData);
		sendKeys("Change_AddSystems_NameTextfield",PropertiesCache.setProperty(testData, systemId),changeData);
		sendKeys("Change_AddSystems_DescriptonTextfield","New_Systems_Description_Value",changeData,testData);
		sendKeys("Change_AddSystems_VendorTextfield","New_Systems_Vendor_Value",changeData,testData);
		click("Change_AddSystems_ActiveRadio",changeData);
		click("Change_Systems_Save&CloseButton",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_ReleaseSystems_SearchButton",systemId,changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Change_ReleaseSystem_Link", "Change_ReleaseSystem_CodeImplArea", systemId,PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public  void linkSystemToRelease2(String changeData,String testData,String objectData,String systemId) {

		click("Change_ReleaseSystem_Tab",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_ReleaseSystems_SearchButton",systemId,changeData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		dragAndDrop("Change_ReleaseSystem_Link", "Change_ReleaseSystem_CodeImplArea", systemId,PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}

	public void getDeliveryReleasePage(String changeData,String testData,String objectData) {	
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click("Change_DeliveryRelease_Tab",changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}

	public void getCheckDeliveryRelease(String changeData,String testData,String objectData,String deliveryRow){	
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click(deliveryRow,changeData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	public void getCheckDeliveryRelease(String changeData,String testData,String objectData,String deliveryRow,String projectId){	
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		click(deliveryRow, projectId, changeData, testData);
		sleep(2000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	
	public void createChange(String changeData,String testData,String objectData,String changeId){	
		clickElementUsingJavaScript("Change_New_Button",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sendKeys("Change_Name_Textfield", PropertiesCache.setProperty(testData,changeId),changeData);
		sleep(1000);
		PropertiesCache.setProperty(testData,"Change_Organization",getAttributeData("Change_Organization_Textbox", changeData));
		sleep(1000);
		clickElementUsingJavaScript("Change_Type_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		PropertiesCache.setProperty(testData, "Type_Name",getTextData("Change_Type_FirstOption", changeData));
		sleep(1000);
		clickElementUsingJavaScript("Change_Type_FirstOption", changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Status_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Status_Name",getTextData("Change_Status_FirstOption", changeData));
		clickElementUsingJavaScript("Change_Status_FirstOption", changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Priority_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Priority_Name",getTextData("Change_Priority_FirstOption", changeData));
		clickElementUsingJavaScript("Change_Priority_FirstOption", changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Theme_Dropdown", changeData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Change_Theme_FirstOption", changeData);
		sleep(1000);
		clickElementUsingJavaScript("Change_DeliveryRisk_Dropdown",changeData);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Change_DeliveryRisk_FirstOption",changeData);


	}
	
	public void unlinkSystem(String changeData,String testData,String objectData,String src,String dest,String elementId){	
		sleep(2000);
		dragAndDrop(src, dest, elementId,PlutoraConfiguration.changesData,PlutoraConfiguration.testData);
		sleep(3000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);

	}
	
	public void deleteSystem(String systemsData,String testData,String objectData,String environmentData) throws InterruptedException{
		new EnvironmentPage().getSystemsPage(environmentData,objectData);
		sleep(2000);
		clickElement("EnvironmentSystem_SystemNameFilter_xoutsign", environmentData);
		sleep(2000);
		sendKeys("EnvSystems_SystemNameFilter_Input","Systems_Test_Automation_Id",environmentData,testData);
		enter();
	    sleep(2000);
		clickElementUsingJavaScript("Systems_Name","Systems_Test_Automation_Id",systemsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Action_Button", systemsData);
		sleep(2000);
		clickElementUsingJavaScript("Systems_Delete_Button",systemsData);
		sleep(1000);
		click("Systems_Yes_Button",systemsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	public void deleteRelease(String releaseData,String testData,String objectData) {	
		Listener.addLogger("User is about to delete a Release");
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
		sleep(2000);
		clickElementUsingJavaScript("Project_Tab",releaseData);
		sleep(2000);
		clickElementUsingJavaScript("Releases_Delete_Button",releaseData);
		sleep(1000);
		clickElementUsingJavaScript("Releases_Yes_Button",releaseData);		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}

	public void verifyChangeOptions(String changesData,String testData,String objectData,String dropdown,String option,String textbox,String name) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click(dropdown,changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,changesData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change dropdown successfully");
		click(option, name,changesData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(changesData, objectData);
		findAndOpenChange(changesData, testData, objectData);
		if(name.equals("Change_Theme_Name") || name.equals("Change_DeliveryRisk_Name") ) {
		verifyTextAttributeValue(textbox,name,changesData,testData);
		}else {
		verifyText(textbox,name,changesData,testData);
		}
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed after change save and close successfully");
		clickOnSaveAndCloseButton(changesData, objectData);
		
	}
	public void verifyCustomField(String changesData,String testData,String objectData,String name) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Change_All_Tab",changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Additional_Information_LabelName", name,objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName",name,objectData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change additional information successfully");
		clickOnSaveAndCloseButton(changesData, objectData);
	}
	public void verifyFieldPermissionCustomField(String changesData,String testData,String objectData,String name,String type) {
		switch(type) {
		case "View Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Change_All_Tab",changesData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("Change_FieldPermission_ViewValue", name,changesData,testData);
			break;
		case "Edit Value":
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			click("Change_All_Tab",changesData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			scrollToElement("Additional_Information_LabelName", name,objectData,testData);
			sleep(1000);
			verifyText("Additional_Information_LabelName",name,objectData,testData);
			validateElementDisplayed("Change_FieldPermission_EditValue", name,changesData,testData);
			break;
		case "View Custom Field":
			verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(testData, name));
			break;
			
		}
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in Change additional information successfully");
		clickOnSaveAndCloseButton(changesData, objectData);
	}
	public void verifyCustomList(String changesData,String testData,String objectData,String name) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Change_All_Tab",changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		scrollToElement("Additional_Information_LabelName", name,objectData,testData);
		sleep(1000);
		verifyText("Additional_Information_LabelName",name,objectData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, name)+ " - is displayed in Change additional information successfully");
		click("Additional_Information_ListField_Dropdown", name, objectData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyText("Additional_Information_ListField_Option", "CustomList_1", objectData, testData);
		
		/*verifyTextAttributeValue(
				PropertiesCache.getProperty(objectData, "Additional_Information_ListField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, name)),
				PropertiesCache.getProperty(testData, "CustomList_1"));*/
		verifyText("Additional_Information_ListField_Option", "CustomList_2", objectData, testData);
		/*verifyTextAttributeValue(
				PropertiesCache.getProperty(objectData, "Additional_Information_ListField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, name)),
				PropertiesCache.getProperty(testData, "CustomList_2"));*/
		clickOnSaveAndCloseButton(changesData, objectData);
	}
	
	
	public void clickOnChangeType(String changesData,String testData,String objectData,String option,String name) {
		
		clickElementUsingJavaScript("Change_Type_Dropdown", changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,changesData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change dropdown successfully");
		click(option, name,changesData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void verifyWorkflowStatus(String changesData,String testData,String objectData,String option,String textbox,String name) {
		clickElementUsingJavaScript("Change_Status_Dropdown", changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		verifyText(option, name,changesData,testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, name)+ " - is displayed in Change dropdown successfully");
		click(option, name,changesData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		//verifyText(textbox,name,changesData,testData);
		clickOnSaveButton(changesData, objectData);
	}
	
	public void linkSystemToChange(String changesData,String testData,String objectData,String systemId) {
		clickElementUsingJavaScript("Change_System_Tab",changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		searchSystem(changesData,testData, objectData,systemId);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		verifyText("Change_System_Name",systemId,changesData,testData);
		Listener.addLogger("Change System is verified successfully !");
		sleep(2000);
		dragAndDrop("Change_System_Name_Section", "Change_System_Impact_Section", systemId,changesData,testData);
		Listener.addLogger("Change System is dragged and dropped successfully !");
		clickOnSaveAndCloseButton(changesData, objectData);
	}
	public String getChangeId(String changesData) {
		return getTextData("Change_SubTitle_Text", changesData);
	}
	public void findAndSelectChange(String changeData,String testData,String objectData,String changeId) {	
		sendKeys("Change_Search_Textfield",changeId ,changeData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Loading_Gif",objectData);
	}
	public void verifyChange(String changeData,String testData,String objectData,String changeName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sendKeys("Change_Search_Textfield", changeName,changeData,testData);
		enter();
		waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void clickOnChangeField(String tecrData,String testData,String objectData,String dropdown,String option) {
		clickElementUsingJavaScript(dropdown, tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click(option,tecrData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickOnSaveAndCloseButton(tecrData, objectData);
	}
	public void createSystem(String changesData,String systemData,String testData,String objectData,String systemsName) throws InterruptedException {
		clickElementUsingJavaScript("Change_Systems_Tab",changesData);
		waitForLoadingIconDisappear(80,"Loading_Gif",objectData);
		sleep(2000);
		click("Change_Systems_CreateButton",changesData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(2000);
		switchToWindow(4000, "parentWindow");
		driver.get(driver.getCurrentUrl());
		systemPage.creationSystems(systemData, testData, objectData, systemsName);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(4000);
		closeWindowTab();
		driver.switchTo().window(PropertiesCache.getProperty(testData,"parentWindow"));
	
	}
	
}
