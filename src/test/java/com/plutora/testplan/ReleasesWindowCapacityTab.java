package com.plutora.testplan;


import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.FolderManagementUtilLib;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class ReleasesWindowCapacityTab {
	ReleasePage releasePage = new ReleasePage();
	SystemsPage systemsPage = new SystemsPage();
	CustomizationPage customizationPage = new CustomizationPage();
	
	@Test (description="Sub-area: release window -> Capacity tab -> Capacity values")
	public void subareaReleaseWindowCapacityTab_01() throws InterruptedException, ParseException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Create custom field
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Name");
		customizationPage.addDataTypeOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Free Text","Capacity_CustomField_Name");
		
		releasePage.refresh(PlutoraConfiguration.objectData);
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
				
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Add Capacity Values
		releasePage.addCapacityValues(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Capacity value added successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Verify capacity values
		releasePage.verifyCapacityValues(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("Capacity value verified successfully !");
		
		//delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Capacity_CustomField_Name");
	
	}
	
	
	@Test (description="Sub-area: release window -> Capacity tab -> Export to XLS")
	public void subareaReleaseWindowCapacityTab_02() throws InterruptedException {	
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyText("Releases_Page_Title","Releases_Page_Title_Value",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		Listener.addLogger("Enterprise Release is verified successfully !");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		//Export to XLS
		releasePage.clickOnCapacityExportToXLS(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		releasePage.sleep(3000);
		Listener.addLogger("Capacity export to XLS is downloaded successfully!");
		String excelFile=FolderManagementUtilLib.getFileName(CommonConstants.downloadFolderPath,"Release");
		String[] data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Table1", 3);
		//Verify excel values
		releasePage.verifyTextValue("IRelease_Automation_Update_Id",data[0].split("\\n")[0].trim(),PlutoraConfiguration.testData);
		data =FolderManagementUtilLib.getRowData(CommonConstants.downloadFolderPath+excelFile, "Table1", 4);
		releasePage.verifyTextValue("PRelease_Automation_Update_Id",data[0].split("\\n")[0].trim(),PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "IRelease_Automation_Update_Id")+"<br>"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Update_Id")+" -  Capacity export to XLS is verified successfully!");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.sleep(2000);
	}
	@Test (description="Sub-area: release window -> Capacity tab -> Custom Fields")
	public void subareaReleaseWindowCapacityTab_03() throws InterruptedException {	
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		//Create custom field
		customizationPage.createCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Name");
		//Verify custom field
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Capacity_Tab",PlutoraConfiguration.objectData);
		releasePage.scrollToElement("Additional_Information_LabelName", "Capacity_CustomField_Name",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		releasePage.verifyText("Additional_Information_LabelName", "Capacity_CustomField_Name",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" Verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//Update Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.updateCustomFieldOptionName(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option", "Capacity_CustomField_Name");
		
		//Verify Custom field 
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Capacity_Tab",PlutoraConfiguration.objectData);
		releasePage.scrollToElement("Additional_Information_LabelName", "Capacity_CustomField_Name",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		releasePage.verifyText("Additional_Information_LabelName", "Capacity_CustomField_Name",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" Verified successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		//delete Custom field
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.clickOnCustomFieldOption(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData, "Customization_CapacityCustomFields_Option");
		customizationPage.deleteCustomField(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Capacity_CustomField_Name");
	
		//Verify Custom field
		releasePage.releasePage(PlutoraConfiguration.releasesData,PlutoraConfiguration.objectData);
		releasePage.verifyRelease(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Release_Test_Automation_Id");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"Releases_Capacity_Tab",PlutoraConfiguration.objectData);
		releasePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Capacity_CustomField_Name")+" not displayed in release page successfully !");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	
	
}
