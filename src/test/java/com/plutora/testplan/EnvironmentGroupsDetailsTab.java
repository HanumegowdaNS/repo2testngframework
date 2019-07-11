package com.plutora.testplan;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import org.testng.annotations.Test;

import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class EnvironmentGroupsDetailsTab {

	EnvironmentGroupsPage environmentGroupsPage = new EnvironmentGroupsPage();
	EnvironmentPage environmentpage = new EnvironmentPage();

	@Test (description="Add/edit/delete stakeholder")
	public void environmentMangeGroupsDetailsTab_01() throws InterruptedException  {
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Create
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is created successfully");
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"EnvGrp_Automation");
		//Add stakeholder
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1,"Releases_EStakeholder_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name")+" Environment stakeholder added successfully !");
		environmentGroupsPage.sleep(1000);
		//Verify stakeholder
		environmentGroupsPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		Listener.addLogger("Environment stakeholder verified successfully  !");
		new ReleasePage().updateStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("Environment stakeholder updated successfully !");
		new ReleasePage().verifyUpdatedShakeholder(PlutoraConfiguration.testData);
		Listener.addLogger("Environment stakeholder verified after updation successfully  !");
		//Remove stakeholder
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name","Releases_Stakeholder_Remove_Button");
		environmentGroupsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name"));
		Listener.addLogger("Environment stakeholder deleted successfully !");
		//Update Mulitiple stakeholder
		new ReleasePage().updateMultipleStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Releases_EStakeholder_Button");
		//Verify Mulitiple stakeholder
		environmentGroupsPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name_1",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("Releases_Shakeholder_Name_Value","Stakeholder_Name_2",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_1")+" - Stakeholder is verified successfully");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_2")+" - Stakeholder is verified successfully");
		//Remove Mulitiple stakeholder
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name_1","Releases_Stakeholder_Remove_Button");
		environmentGroupsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_1"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_1")+" - Stakeholder is removed successfully");
		
		new ReleasePage().removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name_2","Releases_Stakeholder_Remove_Button");
		environmentGroupsPage.verifyTextEqualsNotDisplayedInPage(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_2"));
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Stakeholder_Name_2")+" -  Stakeholder is removed successfully");
		
		environmentGroupsPage.clickOnEnvironmentGroupSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		//Delete Environment Group
		environmentGroupsPage.deleteEnvironmentGroups(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment Group is deleted successfully");
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveAndCloseButton(PlutoraConfiguration.environmentData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
	
	}
	

	 @Test(description = "Button 'Show Env. Map'")
	 public void environmentMangeGroupsDetailsTab_02() throws InterruptedException{
		/* Navigate to environment Page */
		environmentpage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/* Creating Environment #1 */
		environmentpage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		/* Creating Environment #2 */
		environmentpage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		/* Navigate to environmentGroup Page */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Create New Environment Group */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Read Environment Group */
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Adding Environments to Group */
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_1")
				+ " -  Environment shows successfully");
		environmentGroupsPage.addEnvironmentToGroupMember(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Environment_Automation_2");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_2")
				+ " -  Environment shows successfully");
		/* Clicking On Save Button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Creating Connectivity */
		environmentGroupsPage.addBatch(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "");
		/* Clicking On Save Button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Clicking on Show Environment Map Button */
		environmentGroupsPage.clickOnShowEnvironmentMapButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		/*Verifying Presence of Environment Names on Env Map */
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_1",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.verifyText("Environment_Map_Environment_Text", "Environment_Automation_2",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
	 }
	 
	 @Test(description = "Copy URL to clipboard (for both logged in and logged out scenarios)")
	 public void environmentMangeGroupsDetailsTab_03() throws InterruptedException{
		/* Navigate to environment Group Page */
		 environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Creating New environment Group */
		 environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Group_Automation");
		/* Reading New environment Group */
		 environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Env_Group_Automation");
		/* Clicking on Environment Group Link */
		 environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_EnvNameLink", "Env_Group_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		 environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Copy URL to Clip board */
		 environmentGroupsPage.click("Environment_CopyURL_Icon",PlutoraConfiguration.environmentData);
		 environmentGroupsPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		 environmentGroupsPage.sleep(4000);
		/*Getting data from clip board*/
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		/* Clicking on save and close */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_SaveCloseButton", PlutoraConfiguration.environmentData);
		/* Navigating to the copied URL */
		environmentGroupsPage.sleep(2000);
		EnvironmentGroupsPage.launchUrl(dstData);
		environmentGroupsPage.waitForLoadingIconDisappear(500, "Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Environment Grouop Name */
		// ep.verifyTextValue("Change_Name_Textfield","Env_Group_Automation",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentGroupsPage.verifyTextAttributeValueContains("NewEnvironment_NameTextfield", "Env_Group_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,"value");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Group_Automation")
				+ " redirected to env group details page after performing copy URL to clipboard for logged in session successfully !");
		/* Clicking on save and close */
		environmentGroupsPage.clickOnEnvironmentGroupSaveAndCloseButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Logging out */
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL, PlutoraConfiguration.objectData);
		/* Navigating to the copied URL */
		EnvironmentGroupsPage.launchUrl(dstData);
		/* Verifying elements */
		environmentGroupsPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		environmentGroupsPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger(
				"Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		ChangesPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, PlutoraConfiguration.username, PlutoraConfiguration.password);

	}

	 @Test(description = "Button 'Contact stakeholders' and email notification on it")
	 public void environmentMangeGroupsDetailsTab_04() throws InterruptedException{
		/* Navigate to Environment Group Page */ 
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Getting Current url*/
		PropertiesCache.setProperty(PlutoraConfiguration.testData,"EnvUrl", environmentGroupsPage.getCurrentUrl());
		/* Create New Env Gropu */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")
				+ " - Environment Group is created successfully");
		/* Reading Env Group */
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Add stakeholder */
		new ReleasePage().addStakeholder(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Releases_EStakeholder_Button");
		Listener.addLogger(" Environment stakeholder added successfully !");
		environmentGroupsPage.sleep(1000);
		/* Clicking On Save And Close */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_EnvSaveAndCloseButton",
				PlutoraConfiguration.environmentData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Reading Env Group */
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		environmentGroupsPage.clickOnEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Click on Contact Stakeholder */
		environmentGroupsPage.contactStakeHolder(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData);
		/* Verifying email Notification */
		environmentGroupsPage.verifyEmailNotification(PlutoraConfiguration.testData, PlutoraConfiguration.objectData,
				"Email_Subject",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "ForgotPassword_Username"));
		EnvironmentGroupsPage.launchUrl(PropertiesCache.getProperty(PlutoraConfiguration.testData,"EnvUrl"));
		
	}
	 
	 @Test(description = "Selecting the color for env. group in 'Display' column")
	 public void environmentMangeGroupsDetailsTab_05() throws InterruptedException{
		 EnvironmentGroupsPage.launchUrl(PlutoraConfiguration.applicationURL);
		/* Navigate to environmentGroup Page */
		environmentGroupsPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/* Create New Environment Group */
		environmentGroupsPage.createEnvironmentGroups(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Read Environment Group */
		environmentGroupsPage.readEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "EnvGrp_Automation");
		/* Changing display Color */
		environmentGroupsPage.doubleClick("EnvGroups_DisplayColor_label", "EnvGrp_Automation",
				PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Clicking on Color Dropdown Arrow */
		environmentGroupsPage.clickElementUsingJavaScript("EnvGroups_DisplayColor_DropDownArrow",
				PlutoraConfiguration.environmentData);
		/* Clicking on FirstColor */
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "Color_Value", environmentGroupsPage
				.getCSSValue("EnvGroups_DisplayColor_firstColorOption", PlutoraConfiguration.environmentData, "style"));
		environmentGroupsPage.doubleClick("EnvGroups_DisplayColor_firstColorOption",
				PlutoraConfiguration.environmentData);
		/* Clicking on Save Button */
		environmentGroupsPage.clickOnEnvironmentGroupsMemberSaveButton(PlutoraConfiguration.environmentData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupsPage.waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
		/* Verifying Change in Color */
		environmentGroupsPage
				.getCSSValue("EnvGroups_DisplayColor_label", "EnvGrp_Automation", PlutoraConfiguration.environmentData,
						PlutoraConfiguration.testData, "style")
				.contains(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Color_Value"));
	}
}
