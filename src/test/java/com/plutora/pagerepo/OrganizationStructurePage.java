package com.plutora.pagerepo;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class OrganizationStructurePage extends TestGenericUtilLib  {

	public void gotoOrganizationPage(String organizationData,String objectData) throws InterruptedException {	
		waitForLoadingIconDisappear(400,"Loading_Gif",objectData);
		sleep(2000);
		//mouseHover("NewUser_SettingsDropdown", "OrganizationStructure_Dropdown_Menu",organizationData);
		clickElementUsingJavaScript("NewUser_SettingsDropdown",organizationData);
		sleep(2000);
		clickElementUsingJavaScript("OrganizationStructure_Dropdown_Menu",organizationData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
	public void addOrganizationStructure(String organizationData,String testData,String objectData,String orgName) {
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Add_Button",objectData);
		sendKeys("AddOrganizationStructure_Name_Textbox",PropertiesCache.setProperty(testData, orgName),organizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		/*clickOnButton(organizationData,"AddOrganizationStructure_Director_Dropdown_Icon",objectData);
		sendKeys("AddOrganizationStructure_Director_Textbox",PropertiesCache.getProperty(testData, "Loggedin_Username_Value"),organizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("AddOrganizationStructure_Director_Dropdown_Option","Loggedin_Username_Value",organizationData,testData);*/
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(organizationData,"Organization_Save&Close_Button",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, orgName)+" Created successfully !");
		
	}
	public void editOrganizationStructure(String organizationData,String testData,String objectData) {
		clickButton("OrganizationStructure_Name","Organization_Name",organizationData,testData,objectData);
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Edit_Button",objectData);
		sendKeys("AddOrganizationStructure_Name_Textbox",PropertiesCache.setProperty(testData, "Organization_Name"),organizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(organizationData,"Organization_Save&Close_Button",objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, "Organization_Name")+" Updated successfully !");
	}
	
	public void editOrganizationStructureCloseButton(String organizationData,String testData,String objectData) {
		clickButton("OrganizationStructure_Name","Organization_Name",organizationData,testData,objectData);
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Edit_Button",objectData);
		sendKeys("AddOrganizationStructure_Name_Textbox","Test",organizationData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(organizationData,"AddOrganizationStructure_Close_Icon",objectData);
	}
	
	public void verifyOrganizationStructureMandatoryField(String organizationData,String testData,String objectData) {
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Add_Button",objectData);
		clickOnButton(organizationData,"Organization_Save&Close_Button",objectData);
		verifyTextValue(getAttributeValue(PropertiesCache.getProperty(organizationData, "AddOrganizationStructure_Name_Textbox"), "placeholder"), PropertiesCache.getProperty(testData, "Organization_Placeholder"));
		Listener.addLogger("Validated Organization Structure mandatory fields successfully !");
		clickOnButton(organizationData,"AddOrganizationStructure_Close_Icon",objectData);
	}
	public void deleteReassignOrganizationStructure(String organizationData,String testData,String objectData,String org1,String org2) {
		clickButton("OrganizationStructure_Name",org1,organizationData,testData,objectData);
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Delete_Button",objectData);
		clickOnButton(organizationData,"Organization_Reassign_Dropdown",objectData);
		sleep(1000);
	
		List<WebElement> element=webElementsIdentifier(PropertiesCache.getProperty(organizationData,"Organization_Reassign_Dropdown_Options"));
		label:for(int i=0;i<element.size();i++) {
			scrollToElement(element.get(i));
			if(element.get(i).getText().equals(PropertiesCache.getProperty(testData, org2))){
				sleep(2000);
				scrollToElement(element.get(i));
				sleep(2000);
				element.get(i).click();
				sleep(4000);
				break;
			}else {
				continue label;
			}
		
		}
	
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnButton(organizationData,"Organization_Reassign_Button",objectData);
		clickOnButton(organizationData,"Organization_Reassign_Delete_Yes_Button",objectData);
	}
	public void deleteOrganizationStructure(String organizationData,String testData,String objectData,String org1) {
		clickButton("OrganizationStructure_Name",org1,organizationData,testData,objectData);
		clickOnButton(organizationData,"OrganizationStructure_Enabled_Delete_Button",objectData);
		clickOnButton(organizationData,"Organization_Reassign_Delete_Yes_Button",objectData);
	}
	
}