package com.plutora.testplan;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.OrganizationStructurePage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class OrganizationStructure {
	OrganizationStructurePage organizationStructurePage = new OrganizationStructurePage();
	ReleasePage releasePage = new ReleasePage();
	
	@Test (description=" -> Add/Edit Organization")
	public void organizationStructure_01() throws InterruptedException, ParseException, AWTException {
		
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		//Validate disabled elements
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Default_Image", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Organization default structure displayed in Organization page");
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Disabled_Add_Button", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Add button disabled in Organization page");
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Disabled_Edit_Button", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Edit button disabled in Organization page");
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Disabled_Delete_Button", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Delete button disabled in Organization page");
		//Validate enabled elements
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData, "OrganizationStructure_Company_Name", PlutoraConfiguration.objectData);
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Enabled_Add_Button", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Add button enabled in Organization page");
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Enabled_Edit_Button", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Edit button enabled in Organization page");
		//Verify 
		organizationStructurePage.verifyOrganizationStructureMandatoryField(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Add Organization
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Name");
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_Name",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name")+" -  Organization Name is displayed in Organization Structure successfully !");
		//organizationStructurePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.organizationStructureData,"OrganizationStructure_Director_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name")),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value"));
	//	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value")+" - director name is displayed in Organization Structure successfully !");
		//Edit Organization
		organizationStructurePage.editOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_Name",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name")+" -  Organization Name is displayed in Organization Structure successfully !");
		//organizationStructurePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.organizationStructureData,"OrganizationStructure_Director_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name")),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value"));
	//	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value")+" - director name is displayed in Organization Structure successfully !");
		//Edit Organization with close icon	
		organizationStructurePage.editOrganizationStructureCloseButton(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_Name",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name")+" -  Organization Name is displayed in Organization Structure successfully !");
		//organizationStructurePage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.organizationStructureData,"OrganizationStructure_Director_Name").replace("TEXT", PropertiesCache.getProperty(PlutoraConfiguration.testData,"Organization_Name")),PropertiesCache.getProperty(PlutoraConfiguration.testData,"Loggedin_Username_Value"));
	//	Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Loggedin_Username_Value")+" - director name is displayed in Organization Structure successfully !");
	}
	
	@Test (description=" -> Delete Organization(Reassigning entities while deleting the organization)")
	public void organizationStructure_02() throws InterruptedException  {
		//Create enterprise release & Update organization name
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPage(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name","");
		//Go to Organization & verify existing organization
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_Name",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name")+" -  Organization Name is displayed in Organization Structure successfully !");
		//Add Reassign organization
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData, "OrganizationStructure_Company_Name", PlutoraConfiguration.objectData);
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_Reassign_Name");
		//Delete Organization
		organizationStructurePage.deleteReassignOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name", "Organization_Reassign_Name");
		organizationStructurePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Name")+" - is not displayed in Organization Structure successfully !");
		//Verify reassign organization in release page
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Enterprise_Automation");
		releasePage.verifyTextAttributeValue("AddRelease_Organization_Textbox", "Organization_Reassign_Name", PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		releasePage.updateOrganization(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Name","AddRelease_Organistion_Option_Value");
		//releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		//Verify reassign organization & delete reassigned 
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_Reassign_Name",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Reassign_Name")+" -  Organization Name is displayed in Organization Structure successfully !");
		organizationStructurePage.deleteOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_Reassign_Name");
		organizationStructurePage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Reassign_Name"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_Reassign_Name")+" - is not displayed in Organization Structure successfully !");
	}

	@Test (description=" -> Collapse All / Expand All")
	public void organizationStructure_03() throws InterruptedException  {
		//Collapse All
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData,"OrganizationStructure_ExpandAll_Button","OrganizationStructure_CollapseAll_Button",PlutoraConfiguration.objectData);
		
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Collapsed_List", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Organization Structure collapsed successfully !");
		
		//Expand All
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData,"OrganizationStructure_CollapseAll_Button","OrganizationStructure_ExpandAll_Button",PlutoraConfiguration.objectData);
		organizationStructurePage.validateElementDisplayed("OrganizationStructure_Expanded_List", PlutoraConfiguration.organizationStructureData);
		Listener.addLogger("Organization Structure expanded successfully !");
		
	}
	@Test (description=" -> Drag and drop to re-order organizations)")
	public void organizationStructure_04() throws InterruptedException  {
		organizationStructurePage.gotoOrganizationPage(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.objectData);
		//Add Organization
		organizationStructurePage.clickOnButton(PlutoraConfiguration.organizationStructureData, "OrganizationStructure_Company_Name", PlutoraConfiguration.objectData);
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_FirstName");
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_FirstName",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		
		organizationStructurePage.addOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Organization_SecondName");
		organizationStructurePage.verifyText("OrganizationStructure_Name", "Organization_SecondName",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData);
		
		//Get Organization first record index
		String index=organizationStructurePage.getAttributeValue("OrganizationStructure_Name_Index", "Organization_FirstName",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData, "data-recordindex");
		//Drag and drop
		organizationStructurePage.dragAndDrop("OrganizationStructure_Name", "OrganizationStructure_Name", "Organization_FirstName", "Organization_SecondName", PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData);
		organizationStructurePage.sleep(2000);
		String latestIndex=organizationStructurePage.getAttributeValue("OrganizationStructure_Name_Index", "Organization_FirstName",PlutoraConfiguration.organizationStructureData,PlutoraConfiguration.testData, "data-recordindex");
		organizationStructurePage.sleep(2000);
		if(Integer.parseInt(index)<Integer.parseInt(latestIndex)) {
			assertTrue(true);
			organizationStructurePage.sleep(1000);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_FirstName")+" Index "+index+"<br>"+" re-ordered "+
					PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_FirstName")+" Index "+latestIndex);
		}else {
			assertTrue(false);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_FirstName")+" Index "+index+"<br>"+" not re-ordered "+
					PropertiesCache.getProperty(PlutoraConfiguration.testData, "Organization_FirstName")+" Index "+latestIndex);
		}
		
		organizationStructurePage.deleteOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_FirstName");
		organizationStructurePage.deleteOrganizationStructure(PlutoraConfiguration.organizationStructureData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Organization_SecondName");
		
	}
}
