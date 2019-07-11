package com.plutoratest.pagerepo;

import java.awt.AWTException;
import java.io.IOException;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class RequirementsPage extends TestGenericUtilLib {
	public static String requirementGeneratedId=null;

	public void gotoRequirementsPage(String requirementsData,String objectData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Requirements_ItemTab", requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void getRequirementsDetailsPage(String requirementsData,String objectData) {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Requirements_ItemTab", requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Requirements_NewButton", requirementsData);
	}

	public void createRequirements(String requirementsData, String testData, String platform, String fileName,String objectData,int i) throws InterruptedException, IOException, AWTException {

		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sendKeys("AddRequirements_IdTextfield", PropertiesCache.setProperty(testData, "Requirements_Automation_Id_"+i),
				requirementsData);
		sendKeys("AddRequirements_NameTextfield", PropertiesCache.setProperty(testData, "Requirements_Automation_Name_"+i),
				requirementsData);
		sleep(1000);
		click("AddRequirements_DescriptionTextfield", requirementsData);
		sendKeys("AddRequirements_DescriptionTextfield", PropertiesCache.setProperty(testData, "Requirements_Automation_Description"), requirementsData);
		click("AddRequirements_CategoriesDropdown", requirementsData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Requirement_Category",getTextData("AddRequirements_CategoriesDropdown_option", requirementsData));
		click("AddRequirements_CategoriesDropdown_option", requirementsData);
		scrollToElement("AddRequirements_TestCoverageLabel", requirementsData);
		sleep(2000);
		click("AddRequirements_Dependencies_Dropdown", requirementsData);
		sleep(1000);
		click("AddRequirements_Dependencies_DropdownOption", requirementsData);
		sleep(1000);
		click("AddRequirements_Dependencies_ListDropdown", requirementsData);
		sleep(1000);
		click("AddRequirements_Dependencies_ListDropdown_Option", requirementsData);
		
		/*clickUsingAction("AddRequirements_AttachmentsIcon",requirementsData);
		sleep(2000);
		uploadImage(platform, fileName+PropertiesCache.getProperty(testData, "ImageName"));*/
		uploadImageByCss(".upload-item #file-uploader");
		sleep(2000);
		click("AddRequirements_TestPlanAssociationsDropdown", requirementsData);
		sleep(1000);
		click("AddRequirements_TestPlanAssociationaDropdown_Option",
				requirementsData);
		
		clickElementUsingJavaScript("Requirements_StatusRequired_Option",requirementsData);
        sleep(1000);
        PropertiesCache.setProperty(testData, "Requirement_Status",getTextData("Requirements_Status_Option",requirementsData ));
        clickElementUsingJavaScript("Requirements_Status_Option",requirementsData);
        sleep(1000);

		click("AddRequirements_Save&CloseButton", requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		

	}

	public void searchRequirements(String requirementsData, String testData,String objectData, int i) {
		clickElementUsingJavaScript("Requirements_SearchIcon","Requirements_Automation_Id_"+i, requirementsData, testData);
		sendKeysWithEnter("Requirements_SearchItem", "Requirements_Automation_Name_"+i, requirementsData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(2000);
	}
	public void searchRequirements(String requirementsData, String testData,String objectData, String name) {
		clickElementUsingJavaScript("Requirements_SearchIcon",name, requirementsData, testData);
		sendKeysWithEnter("Requirements_SearchItem", name, requirementsData, testData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);	
		sleep(2000);
	}
	public void updateRequirements(String requirementsData, String testData,String objectData) {
		//searchRequirements(requirementsData, testData, objectData, 1);
     	clickElementUsingJavaScript("Requirements_Name", "Requirements_Automation_Name_"+PropertiesCache.getProperty(testData, "Requirement_Count"),requirementsData,testData);
     	waitForLoadingIconDisappear("Progress_Bar", objectData);
     	click("AddRequirements_CommentsDescriptionTextfield", requirementsData);
		sendKeys("AddRequirements_CommentsDescriptionTextfield",PropertiesCache.setProperty(testData, "Requirements_Comment"), requirementsData);
		sleep(1000);
		clickElementUsingJavaScript("Requirements_SendButton",requirementsData);
		sleep(2000);
		clickOnCloseButton(requirementsData, objectData);
     	clickElementUsingJavaScript("Requirements_Name", "Requirements_Automation_Name_"+PropertiesCache.getProperty(testData, "Requirement_Count"),requirementsData,testData);
     	waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	
	public void clickOnCloseButton(String requirementsData,String objectData){
		sleep(1000);
		clickElementUsingJavaScript("Requirements_CloseButton",requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}
	public void deleteRequirements(String requirementsData, String testData,String objectData,int i) {
	
		searchRequirements(requirementsData, testData, objectData, i);
		sleep(1000);
		clickElementUsingJavaScript("Requirements_Name",  "Requirements_Automation_Name_"+i,requirementsData,testData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		clickElementUsingJavaScript("Requirements_DeleteButton",requirementsData);
		sleep(1000);
		clickElementUsingJavaScript("Requirements_ConfirmButton",requirementsData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		sleep(4000);
	}
	public void deleteDuplicateRequirements(String requirementsData, String testData,String objectData) {
		clickElementUsingJavaScript("Requirements_DeleteButton",requirementsData);
		sleep(1000);
		clickElementUsingJavaScript("Requirements_ConfirmButton",requirementsData);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		sleep(2000);
	}
	public void createDuplicateRequirement(String requirementsData, String testData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Requirements_ItemTab", requirementsData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		searchRequirements(requirementsData, testData, objectData, 1);
		requirementGeneratedId=getTextData("GeneratedId", objectData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		mouseHover("GeneratedId", "DataGridOption", objectData);
		clickElementUsingJavaScript("Duplicate_Button", objectData);
		sleep(4000);
		waitForLoadingIconDisappear(60,"Progress_Bar", objectData);
		clickElementUsingJavaScript("Duplicate_Name", "Requirements_Automation_Name_1",objectData,testData);
		sleep(2000);
		waitForLoadingIconDisappear(80,"Progress_Bar", objectData);
		sleep(1000);
	}
	public void updateRequirementsName(String requirementsData, String testData,String objectData,String name) {
     	clickElementUsingJavaScript("Requirements_Name", name,requirementsData,testData);
     	waitForLoadingIconDisappear("Progress_Bar", objectData);
     	sendKeys("Requirements_NameTextfield", PropertiesCache.setProperty(testData, name),
				requirementsData);
		sleep(1000);
		clickOnCloseButton(requirementsData, objectData);
	}
	public String getExtIDRequirement(String requirementdData,String testData,String requirementName) {
		return getTextData("Req_ExtID",requirementName,requirementdData,testData);
	}
}
