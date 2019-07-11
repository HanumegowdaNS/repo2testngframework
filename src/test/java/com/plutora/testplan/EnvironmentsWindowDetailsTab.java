package com.plutora.testplan;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.plutora.constants.CommonConstants;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.LoginPage;
import com.plutora.pagerepo.LogoutPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.WebGenericUtilLib;


public class EnvironmentsWindowDetailsTab {
	EnvironmentPage environmentPage= new EnvironmentPage();
	CustomizationPage customizationPage = new CustomizationPage();
	SystemsPage systemPage = new SystemsPage();
	ReleasePage releasePage = new ReleasePage();
	TEBRPage tebrPage = new TEBRPage();
	EnvironmentGroupsPage environmentGroupPage = new EnvironmentGroupsPage();
	
	@Test (description="My Environment Booking Approvers(approvers names listed below the 'System' combobox)")
	public void environmentsWindowDetailsTab_01() throws InterruptedException  {	
		environmentPage.getSystemsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		systemPage.enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
		systemPage.clickOnSystem(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Systems_Test_Automation_Id");
		systemPage.addApprovers(PlutoraConfiguration.systemsData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Systems_Test_Automation_Id")+" - Added Approver to System successfully!");
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		environmentPage.validateElementDisplayed("Environment_Approver_List_Text", PlutoraConfiguration.environmentData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - verified Approver in the environment details page successfully!");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}
	@Test (description="Field 'Integrated with' (to link to env.groups)")
	public void environmentsWindowDetailsTab_02() throws InterruptedException  {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		environmentPage.selectEnvironmentGroup(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "EG_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment Group integrated with environment successfully!");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.verifyText("Environment_Integrate_Value_Text","EG_Automation",PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment Group verified in the environment successfully!");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Checkbox 'This is a Shared Environment'(it will be booked without conflicts)")
	public void environmentsWindowDetailsTab_03() throws InterruptedException {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnEnvironmentDetailsCheckbox(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Shared_Environment_Checkbox","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment shared environment checkbox enabled successfully!");
		releasePage.bookEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.verifyTextEqualsNotDisplayedInPage("Available");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Environment shared environment is verified in the Project release successfully!");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Checkbox 'Any booking will be automatically approved'\n" + 
			"(booking of such env. will automatically get 'Approved' status)")
	public void environmentsWindowDetailsTab_04() throws InterruptedException {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		
		environmentPage.clickOnEnvironmentDetailsCheckbox(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Approved_Checkbox","");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment Any booking will be automatically approved checkbox enabled successfully!");
		releasePage.bookEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.verifyText("Release_Environment_Status_Text", "APPROVED",PlutoraConfiguration.releasesData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Environment Any booking will be automatically approved is verified in the project release successfully!");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
	}
	@Test (description="Checkbox 'Display booking alert'")
	public void environmentsWindowDetailsTab_05() throws InterruptedException {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironmentDetailsCheckbox(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_BookingAlert_Checkbox","message");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Environment Display booking alert checkbox enabled successfully!");
		releasePage.bookEnvironment(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		environmentPage.verifyTextContains("Release_Environment_BookingAlert_Warning_Env_Name", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.verifyText("Release_Environment_BookingAlert_Warning_Message", "Env_BookingAlert",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "PRelease_Automation_Id")+" - Environment Display booking alert is verified in the project release successfully!");
		environmentPage.click("Release_Environment_BookingAlert_Warning_Ok_Button",PlutoraConfiguration.releasesData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.clickElementUsingJavaScript("Release_Environment_Booking_Close_Icon","Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
	
		new EnvironmentPage().getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		new TEBRPage().creationTEBRWithEnvironmentBookingAlert(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" -  TEBR is created successfully!");
		environmentPage.verifyText("Release_Environment_BookingAlert_Warning_Env_Name", "Env_Test_Automation_Id",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		environmentPage.verifyText("Release_Environment_BookingAlert_Warning_Message", "Env_BookingAlert",PlutoraConfiguration.releasesData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - Environment Display booking alert is verified in the TEBR successfully!");
		environmentPage.click("Release_Environment_BookingAlert_Warning_Ok_Button",PlutoraConfiguration.releasesData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.verifyTextEqualsNotDisplayedInPage("Available");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - Environment shared environment is verified in the TEBR successfully!");
		environmentPage.click("TEBR_Save&CloseButton",PlutoraConfiguration.tebrData);
		environmentPage.waitForLoadingIconDisappear(80,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		new TEBRPage().deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "TEBR_Test_Automation_Id")+" - TEBR is deleted successfully!");
	}
	
	@Test (description="Adding Host/Layer/Component")
	public void environmentsWindowDetailsTab_06() throws InterruptedException {	
		environmentPage.goToEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentPage.addHLCToEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" - Added Host, Layer and Component successfully!");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.verifyText("Environment_Host_Text", "Environment_Host_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_Layer_Text", "Environment_Layer_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_Component_Text", "Environment_Component_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+"<br"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Name")+"<br"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name")+" - verified Host, Layer and Component successfully!");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
	}
	@Test (description="Importing Host/Layer/Component")
	public void environmentsWindowDetailsTab_07() throws InterruptedException {	
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" - Environment deleted successfully!");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		environmentPage.importHLCEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Env_Test_Automation_Id");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" - Imported Host, Layer and Component successfully!");
		environmentPage.verifyText("Environment_Host_Text", "Environment_Host_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_Layer_Text", "Environment_Layer_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.verifyText("Environment_Component_Text", "Environment_Component_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		environmentPage.sleep(2000);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+"<br"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Name")+"<br"+
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name")+" - verified Host, Layer and Component successfully!");
		environmentPage.clickElementUsingJavaScript("NewEnvironment_SaveCloseButton",PlutoraConfiguration.environmentData);
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id_1");
		environmentPage.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id_1")+" - Environment deleted successfully!");
		environmentPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
	}
	@Test (description="Copy URL to clipboard (for both logged in and logged out scenarios)")
	public void environmentsWindowDetailsTab_08() throws InterruptedException {	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Env_Test_Automation_Id");
		environmentPage.click("CopyURL_Icon",PlutoraConfiguration.objectData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		EnvironmentPage.launchUrl(dstData);
		environmentPage.waitForLoadingIconDisappear(500,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.verifyTextAttributeValue("NewEnvironment_NameTextfield", "Env_Test_Automation_Id",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Env_Test_Automation_Id")+" redirected to environment details page after performing copy URL to clipboard for logged in session successfully !");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		new LogoutPage().loginoutPage(PlutoraConfiguration.applicationURL,PlutoraConfiguration.objectData);
		EnvironmentPage.launchUrl(dstData);
		environmentPage.validateElementDisplayed("Login_Email_Textfield", PlutoraConfiguration.loginData);
		environmentPage.validateElementDisplayed("Login_Password_Textfield", PlutoraConfiguration.loginData);
		Listener.addLogger("Redirected to application login page after performing copy URL to clipboard for logged out session successfully !");
		EnvironmentPage.launchUrl(PlutoraConfiguration.applicationURL);
		new LoginPage().loginPage(PlutoraConfiguration.loginData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,PlutoraConfiguration.username,PlutoraConfiguration.password);
	}
	@Test (description="Child and Grandchild Environments to bulk book via Release or TEBR")
	public void environmentsWindowDetailsTab_09() throws InterruptedException, ParseException  {	
		
		//System Creation
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - System is created successfully !");
		//Env Group
		environmentGroupPage.gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		environmentGroupPage.createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		releasePage.clickOnButton(PlutoraConfiguration.releasesData,"AddRelease_Save&CloseButton",PlutoraConfiguration.objectData);
		//Environment Creation
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","EnvGrp_Automation","System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		
		//Release Creation & link system
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "Project_Automation_Name", "0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project is created successfully !");
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.linkSystemToRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "System_Automation","Releases_Change_Systems_CodeImplementation_Section","");
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		customizationPage.enableSubEnvironments(PlutoraConfiguration.customizationData, PlutoraConfiguration.objectData,"Customization_EnvironmentSetup_Option");
		//Create environments
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_One");
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_Two");
		//Add child and grand child
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.addParentEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_One");
		environmentPage.clickOnSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.addParentEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation_Two");
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Verify bulk booking
		environmentPage.getTEBRDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		tebrPage.creationTEBRWithRelease(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation", "System_Automation","TEBR_Automation","");
		tebrPage.updateTEBRWithReleaseEnvironment(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"TEBR_Automation","Environment_Automation");
		tebrPage.enterNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.clickOnTEBRName(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		tebrPage.verifyText("TEBR_Environment_Dropped_Env_Name","Environment_Automation",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" booked successfully !");
		tebrPage.verifyText("TEBR_Environment_Dropped_Env_Name","Environment_Automation_One",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_One")+" booked successfully !");
		tebrPage.verifyText("TEBR_Environment_Dropped_Env_Name","Environment_Automation_Two",PlutoraConfiguration.tebrData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation_Two")+" booked successfully !");
		tebrPage.clickOnSaveAndCloseButton(PlutoraConfiguration.tebrData, PlutoraConfiguration.objectData);
		tebrPage.deleteNewlyCreatedTEBR(PlutoraConfiguration.tebrData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "TEBR_Automation");
		
	}
	@Test (description="Copying Host/Layer/Component tree by 'Copy' button")
	public void environmentsWindowDetailsTab_10() throws InterruptedException  {	
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.addHLCToEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Copy_Icon", PlutoraConfiguration.objectData);
		
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.sleep(4000);
	
		Object myText =  Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		Transferable content=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(myText);
		String dstData = null;
		try {
		      dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		environmentPage.verifyTextContainsValue(dstData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Dropdown_Option")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name"));
		Listener.addLogger("Copying Host/Layer/Component tree by 'Copy' button"+dstData+" Matched "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Host_Name")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Layer_Dropdown_Option")+" "+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Component_Name"));
	}
	

	@Test (description="Environment Allocation Schedule")
	public void environmentsWindowDetailsTab_11() throws InterruptedException, ParseException  {
		new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		new EnvironmentGroupsPage().createEnvironmentGroups(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"EnvGrp_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "EnvGrp_Automation")+" - Environment group is created successfully !");
		environmentPage.click("AddRelease_Save&CloseButton",PlutoraConfiguration.releasesData);
		
		environmentPage.getSystemsDetailsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		systemPage.creationSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "System_Automation")+" - System is created successfully !");
		
		releasePage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation","EnvGrp_Automation","System_Automation");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Environment_Automation")+" - Environment is created successfully !");
		
		releasePage.releasePage(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		releasePage.newERPageBasedOnDate(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Enterprise_Automation","Enterprise_Automation_Name","0");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Enterprise_Automation")+" - Enterprise Release is created successfully !");
		
		releasePage.createProjectReleaseWithEnvironment(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Environment_Automation","Project_Automation","Project_Automation_Name","System_Automation","Enterprise_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation")+" - Project Release is created with environment successfully !");
		
		releasePage.enterNewlyCreatedRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.findAndOpenRelease(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Project_Automation");
		releasePage.clickOnReleaseTab(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData, "Project_Tab");
		releasePage.updatePhaseDate(PlutoraConfiguration.releasesData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, PropertiesCache.getProperty(PlutoraConfiguration.testData, "Release_Phase_Name"), "2", "4");
		
		releasePage.clickOnSaveAndCloseButton(PlutoraConfiguration.releasesData, PlutoraConfiguration.objectData);
		
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		String parentWindow = WebGenericUtilLib.driver.getWindowHandle();
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData,"Environment_Allocation_Schedule_Button", PlutoraConfiguration.objectData);
		environmentPage.sleep(2000);
		environmentPage.switchToWindowPopup();
		//Verify Environment Allocation Schedule Name
	//	environmentPage.verifyText("Environment_Allocation_Schedule_Release_Name", "Project_Automation_Name",PlutoraConfiguration.environmentData,PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Project_Automation_Name")+" Displayed in environment schedule successfully !");
		environmentPage.closeWindowTab();
		//Switch to parent window
		WebGenericUtilLib.driver.switchTo().window(parentWindow);
		environmentPage.clickOnSaveAndCloseButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
	}
	@Test (description="Audit")
	public void environmentsWindowDetailsTab_12() throws InterruptedException  {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.clickOnButton(PlutoraConfiguration.environmentData, "Environment_Details_Tab", PlutoraConfiguration.objectData);
		environmentPage.sendKeys("NewEnvironment_NameTextfield", PropertiesCache.setProperty(PlutoraConfiguration.testData, "Environment_Automation"),PlutoraConfiguration.environmentData);
		environmentPage.clickOnSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Modify
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		try {
		EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		}catch(Exception e) {
			EnvironmentPage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		}
		EnvironmentPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Modified_Checked_Checkbox","Audit_Modified_Checkbox", PlutoraConfiguration.objectData,"xpath");
		environmentPage.verifyListText("Environment_Audit_EnvironmentName_Text", "Environment_Automation", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		environmentPage.clickOnSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		//Added
		environmentPage.clickOnStakeholdersTab(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		releasePage.addStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,1,"Releases_EStakeholder_Button");
		Listener.addLogger("Stakeholder is added successfully to enterprise release !");
		environmentPage.clickOnSaveButton(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Added_Checked_Checkbox","Audit_Added_Checkbox", PlutoraConfiguration.objectData,"xpath");
		environmentPage.verifyListText("Environment_Audit_Stakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//Deleted
		releasePage.removeStakeholder(PlutoraConfiguration.releasesData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Stakeholder_Name","Releases_Stakeholder_Remove_Button");
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Deleted_Checked_Checkbox","Audit_Deleted_Checkbox", PlutoraConfiguration.objectData,"xpath");
		environmentPage.verifyListText("Environment_Audit_DeletedStakeholder_Text", "Stakeholder_Name", PlutoraConfiguration.environmentData, PlutoraConfiguration.testData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
		
		//All
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Icon", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_All_Checked_Checkbox","Audit_All_Checkbox", PlutoraConfiguration.objectData,"xpath");
		/*environmentPage.scrollToElement("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		environmentPage.validateElementDisplayed("Audit_Deleted_Icon",  PlutoraConfiguration.objectData);
		environmentPage.scrollToElement("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		environmentPage.validateElementDisplayed("Audit_Added_Icon",  PlutoraConfiguration.objectData);
		environmentPage.scrollToElement("Audit_Modified_Icon",  PlutoraConfiguration.objectData);
		environmentPage.validateElementDisplayed("Audit_Modified_Icon",  PlutoraConfiguration.objectData);*/
		
		//Live Search
		environmentPage.sendKeysWithEnter("Audit_Live_Search_Textbox", "Environment_Automation",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);
		environmentPage.waitForLoadingIconDisappear(100,"Loading_Gif",PlutoraConfiguration.objectData);
		environmentPage.validateElementDisplayed("Environment_Audit_EnvironmentName_Text", PlutoraConfiguration.environmentData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Live_Search_Close_Icon", PlutoraConfiguration.objectData);
		environmentPage.clickOnButton(PlutoraConfiguration.objectData, "Audit_Close_Icon", PlutoraConfiguration.objectData);
	
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.refresh(PlutoraConfiguration.objectData);
	}
	
	@Test (description="Environment Health Check")
	public void environmentsWindowDetailsTab_13() throws InterruptedException  {
		environmentPage.gotoEnvironmentPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.objectData);
		environmentPage.createEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.uploadHelathCheckScript(PlutoraConfiguration.environmentData, CommonConstants.scriptFileName, PlutoraConfiguration.testData);
		environmentPage.validateEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.clickOnEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Environment_Automation");
		environmentPage.verifyHealthCheckStatus("ONLINE", "EHC_Status_ONLINE_Label", PlutoraConfiguration.environmentData);
		environmentPage.deleteEnvironment(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Environment_Automation");
		environmentPage.verifyTextContains("Confirmation_Message","New_ENV_Delete_Success_Message",PlutoraConfiguration.objectData,PlutoraConfiguration.testData);			
	}
}
