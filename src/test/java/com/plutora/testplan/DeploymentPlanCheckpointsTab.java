package com.plutora.testplan;

import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;

public class DeploymentPlanCheckpointsTab {
	DeploymentPage deploymentPlanPage = new DeploymentPage();
	
	@Test (description="Checkpoints - general workflow")
	public void deploymentPlanCheckpointTab_01() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Automation","Systems_Test_Automation_Id","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is added successfully");
		
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation","Deployment_Automation","PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan is added successfully");
		
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.createNewCheckpointQAndA(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")+" - Master Deployment Plan checkpoint is added successfully");
		
		for(int i=0;i<deploymentPlanPage.questionStatus.length;i++) {
			deploymentPlanPage.scrollToElement("Deployment_Master_Checkpoint_Q/A_Name", "Deployment_Checkpoint_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			deploymentPlanPage.sleep(1000);
			deploymentPlanPage.verifyTextContains("Deployment_Master_Checkpoint_Q/A_Name", "Deployment_Checkpoint_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			deploymentPlanPage.sleep(1000);
			deploymentPlanPage.verifyText("Deployment_Master_Checkpoint_Q/A_Name", "Deployment_Checkpoint_Answer_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			deploymentPlanPage.sleep(1000);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Question_"+(i+1))+"<br"
			+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_"+(i+1))+"<br"+" - Master Deployment Plan checkpoint Questions & Answer is verified successfully");
			
			if(deploymentPlanPage.questionStatus[i].contains("/")) {
				deploymentPlanPage.sleep(1000);
				deploymentPlanPage.verifyText("Deployment_Master_Checkpoint_Q/A_Status",deploymentPlanPage.questionStatus[i] ,PlutoraConfiguration.deploymentPlanData);
			}else {
				deploymentPlanPage.sleep(1000);
				deploymentPlanPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.deploymentPlanData, "Deployment_Master_Checkpoint_Q/A_Status").replace("TEXT", deploymentPlanPage.questionStatus[i]),deploymentPlanPage.convertToUpperCaseAfterFirstIndex(deploymentPlanPage.questionStatus[i]));
			}
		}
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.sleep(1000);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - Master Deployment Plan is moved from draft to execution successfully");
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickElementUsingJavaScript("DeploymentPlan_All_Tab",PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.clickOnSaveButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Approve_Button");
		deploymentPlanPage.selectNewStatusDependency(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Action_Execute_Button");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is moved from draft to execution successfully");
		
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.click("Deployment_Checkpoint_Name","Deployment_Checkpoint",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		deploymentPlanPage.sleep(1000);
		for(int i=0;i<deploymentPlanPage.questionStatus.length;i++) {
			deploymentPlanPage.scrollToElement("Deployment_Checkpoint_Q/A_Name", "Deployment_Checkpoint_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			deploymentPlanPage.sleep(1000);
			deploymentPlanPage.verifyTextContains("Deployment_Checkpoint_Q/A_Name", "Deployment_Checkpoint_Question_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			deploymentPlanPage.sleep(1000);
			deploymentPlanPage.verifyText("Deployment_Checkpoint_Answer_Checkbox", "Deployment_Checkpoint_Answer_"+(i+1),PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Question_"+(i+1))+"<br"
					+PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_"+(i+1))+"<br"+" - Deployment Plan checkpoint Questions & Answer is verified successfully");
			
			deploymentPlanPage.click("Deployment_Checkpoint_Answer_Checkbox",PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_"+(i+1)),PlutoraConfiguration.deploymentPlanData);
			deploymentPlanPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
			deploymentPlanPage.sleep(2000);
			Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - Deployment Plan is answered all questions successfully");
			
			if(deploymentPlanPage.questionStatus[i].contains("/")) {
				deploymentPlanPage.sleep(1000);
				deploymentPlanPage.verifyText("Deployment_Checkpoint_Q/A_Status",deploymentPlanPage.questionStatus[i] ,PlutoraConfiguration.deploymentPlanData);
			}else {
				deploymentPlanPage.sleep(1000);
				deploymentPlanPage.verifyText(PropertiesCache.getProperty(PlutoraConfiguration.deploymentPlanData, "Deployment_Checkpoint_Q/A_Status").replace("TEXT", deploymentPlanPage.questionStatus[i]),deploymentPlanPage.convertToUpperCaseAfterFirstIndex(deploymentPlanPage.questionStatus[i]));
			}
			deploymentPlanPage.sleep(2000);
		}
		deploymentPlanPage.clickOnSaveAndCloseButton(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		
		deploymentPlanPage.gotoCommandCenterPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.selectMasterDeploymentPlanFromCommandCenter(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_DP_Name", "Deployment_Automation",PlutoraConfiguration.deploymentPlanData,PlutoraConfiguration.testData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_Chart", PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_Command_Center_HOT", PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Master Deployment Plan is validating all values from command center page");
		
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.deleteDP(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Automation");
		//deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")+" - deleted successfully");
		deploymentPlanPage.sleep(2000);
		deploymentPlanPage.deleteDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData,"Deployment_Master_Automation");
	//	deploymentPlanPage.verifyText("Deployment_Confirmation_Message", "New_DP_Delete_Success_Message", PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")+" - deleted successfully");
	}
	
	@Test (description="Add/Edit/Delete/Duplicate Checkpoints")
	public void deploymentPlanCheckpointTab_02() throws InterruptedException, ParseException  {
		
		/*Navigating to Deployment Plan Page*/
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/*Clicking on New Deployment Plan*/
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Adding new Deployment Plan*/
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/*Clicking on Master deployment plan*/
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/*Adding New Master Deployment Plan*/
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		/*Clicking on Master DP checkpoints Tab*/
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Adding a new Checkpoint */
		deploymentPlanPage.createNewCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		/* Verifying the presence of New Checkpoint */
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")
				+ "<- Verified creation of the Checkpoint");
		/* Clicking on Newly Created Checkpoint */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.updateCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint_Updated");
		/* Verifying the presence of Updated Checkpoint */
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint_Updated",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Updated")
				+ "<- Verified presence of the Checkpoint after Update");
		/* Creating a Duplicate Checkpoint */
		/* Clicking on Updated Checkpoint */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_AddedCheckpoint_Label",
				"Deployment_Checkpoint_Updated", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		deploymentPlanPage.duplicateCheckpoint(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Verifying the presence of Duplicated Checkpoint */
		deploymentPlanPage.verifyText("Deployment_DuplicateCheckpoint_Label", "Deployment_Checkpoint_Updated",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Updated")
				+ "<- Verified presence of the Checkpoint after Duplication");
		/* Clicking on Duplicated Checkpoint */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_DuplicateCheckpoint_Label",
				"Deployment_Checkpoint_Updated", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		deploymentPlanPage.deleteCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/* Verifying the absence of Deleted Checkpoint */
		deploymentPlanPage.verifyElementNotDisplayed("Deployment_DuplicateCheckpoint_Label",
				"Deployment_Checkpoint_Updated", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Updated")
				+ "<- Verified absence of the Checkpoint after Deletion");
		/* Clicking on Save And Close */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData); 
	}
	
	@Test (description="Checkpoint Time field")
	public void deploymentPlanCheckpointTab_03() throws InterruptedException, ParseException  {
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/*Clicking on New Deployment Plan*/
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Adding new Deployment Plan*/
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/*Clicking on Master deployment plan*/
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/*Adding New Master Deployment Plan*/
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		/*Clicking on Master DP checkpoints Tab*/
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Adding a new Checkpoint */
		deploymentPlanPage.createNewCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		/* Verifying the presence of New Checkpoint */
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")
				+ "<- Verified creation of the Checkpoint");
		deploymentPlanPage.verifyText("Deployment_AddedCheckpointTime_Label",
				"CheckPoint_Time",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "CheckPoint_Time")
				+ "<- Verified Checkpoint Time Field..");
		/* Clicking on Save And Close */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);	
	}
	
	@Test (description="Response Period Status element")
	public void deploymentPlanCheckpointTab_04() throws InterruptedException, ParseException  {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		/*Clicking on New Deployment Plan*/
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Adding new Deployment Plan*/
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/*Clicking on Master deployment plan*/
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/*Adding New Master Deployment Plan*/
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		/*Clicking on Master DP checkpoints Tab*/
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Adding a new Checkpoint */
		deploymentPlanPage.createNewCheckpointWithoutResponsePeriod(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		/* Verifying the presence of New Checkpoint */
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")
				+ "<- Verified creation of the Checkpoint");
		deploymentPlanPage.verifyText("Deployment_CheckpointResponsePeroid_StatusLabe", "Open",
				PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Verified Response Period to be Open");
		/* Adding a new Checkpoint with Past Dates */
		deploymentPlanPage.createNewCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint_BeforeDate", "-2", "-1");
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_BeforeDate")
				+ "<- Verified creation of the Checkpoint");
		deploymentPlanPage.verifyText("Deployment_CheckpointResponsePeroid_StatusLabe", "Closed",
				PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Verified Response Period to be Closed");
		/* Adding a new Checkpoint with Future Dates */
		deploymentPlanPage.createNewCheckpoint(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint_AfterDate", "1", "2");
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_AfterDate")
				+ "<- Verified creation of the Checkpoint");
		deploymentPlanPage.verifyText("Deployment_CheckpointResponsePeroid_StatusLabe", "Upcoming",
				PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger("Verified Response Period to be Upcoming");
		/* Clicking on Save And Close */
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}
	
	@Test (description="Response Period - From and To fields")
	public void deploymentPlanCheckpointTab_05() throws InterruptedException, ParseException  {	
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.createNewCheckpointQAndA(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_Master_CheckpointCreation_Save&CloseButton",
				PlutoraConfiguration.deploymentPlanData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")
				+ " - Master Deployment Plan checkpoint is added successfully");
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Master_Automation");
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.readDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation");
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.scrollToElement("Deployment_CheckpointAnswer_RadioButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_CheckpointAnswer_RadioButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickOnInformationDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentDraftApprove(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.deploymentApprovedExecute(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.scrollToElement("Deployment_CheckpointAnswer_RadioButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_CheckpointAnswer_RadioButton",
				PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint_Answer_1"),
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.validateElementDisplayed("Deployment_CheckpointAnswerOptionNA_label",
				PlutoraConfiguration.deploymentPlanData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);

	}
	@Test (description="Add/Edit/Duplicate/Delete Questions & Answers")
	public void deploymentPlanCheckpointTab_06() throws InterruptedException, ParseException  {
		/*Clicking on New Deployment Plan*/
		deploymentPlanPage.clickOnNewDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		/*Adding new Deployment Plan*/
		deploymentPlanPage.addDeploymentPlan(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Automation", "Systems_Test_Automation_Id",
				"PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Automation")
				+ " - Deployment Plan is added successfully");
		/*Clicking on Master deployment plan*/
		deploymentPlanPage.clickOnMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/*Adding New Master Deployment Plan*/
		deploymentPlanPage.addMasterDeploymentPlan(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Master_Automation",
				"Deployment_Automation", "PRelease_Automation_Name");
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Master_Automation")
				+ " - Master Deployment Plan is added successfully");
		/*Clicking on Master DP checkpoints Tab*/
		deploymentPlanPage.clickOnMasterCheckpointDetailsTab(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.objectData);
		/* Adding a new Checkpoint */
		deploymentPlanPage.createNewCheckpointWithoutResponsePeriod(PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "Deployment_Checkpoint");
		/* Verifying the presence of New Checkpoint */
		deploymentPlanPage.verifyText("Deployment_AddedCheckpoint_Label", "Deployment_Checkpoint",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		Listener.addLogger(PropertiesCache.getProperty(PlutoraConfiguration.testData, "Deployment_Checkpoint")
				+ "<- Verified creation of the Checkpoint");
		deploymentPlanPage.verifyText("Deployment_CheckpointResponsePeroid_StatusLabe", "Open",
				PlutoraConfiguration.deploymentPlanData);
		/* Creating New Q & A */
		deploymentPlanPage.createOrEditQAndA(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData,"Deployment_Checkpoint_Question_","Deployment_Checkpoint_Answer_","New");
		deploymentPlanPage.verifyTextContains("Deployment_CheckpointQuestion_Label", "Deployment_Checkpoint_Question_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_CheckpointAnswer_Label", "Deployment_Checkpoint_Answer_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		/* Editing Q & A */
		deploymentPlanPage.createOrEditQAndA(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData,
				PlutoraConfiguration.objectData, "Deployment_Checkpoint_Question_Edit_",
				"Deployment_Checkpoint_Answer_Edit_", "Edit");
		deploymentPlanPage.verifyTextContains("Deployment_CheckpointQuestion_Label",
				"Deployment_Checkpoint_Question_Edit_", PlutoraConfiguration.deploymentPlanData,
				PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_CheckpointAnswer_Label", "Deployment_Checkpoint_Answer_Edit_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		/* Duplicating Q & A */
		deploymentPlanPage.duplicateQAndA(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_CheckpointQuestionDuplicate_Label", "Deployment_Checkpoint_Question_Edit_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_CheckpointAnswerDuplicate_Label", "Deployment_Checkpoint_Answer_Edit_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		/* Deleting Q & A */
		deploymentPlanPage.deleteQAndA(PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.objectData);
		deploymentPlanPage.verifyTextContains("Deployment_CheckpointQuestion_Label", "Deployment_Checkpoint_Question_Edit_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.verifyText("Deployment_CheckpointAnswer_Label", "Deployment_Checkpoint_Answer_Edit_",
				PlutoraConfiguration.deploymentPlanData, PlutoraConfiguration.testData);
		deploymentPlanPage.clickElementUsingJavaScript("Deployment_SaveCloseButton",
				PlutoraConfiguration.deploymentPlanData);
	}

}
