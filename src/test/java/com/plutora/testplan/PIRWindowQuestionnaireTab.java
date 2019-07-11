package com.plutora.testplan;

import java.text.ParseException;
import org.testng.annotations.Test;
import com.plutora.pagerepo.PIRPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class PIRWindowQuestionnaireTab {
	PIRPage pirPage = new PIRPage();

	@Test (description="Sub-area: PIR window -> Questionnaire tab -> Add/edit/delete questionnaire")
	public void subareaPIRWindowQuestionnaireTab_01() throws InterruptedException, ParseException {	
		//Add pir questionnaire
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.getPIRCreationPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Tab");
		pirPage.createQuestionnaire(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_CreatedQuestionnaire_Link","PIR_Automation_QuestionName",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Questionnaire created successfully !");
		//Edit pir questionnaire
		pirPage.clickUpdateCreatedQuestionName(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyText("PIR_Item_CreatedQuestionnaire_Link","PIR_Automation_QuestionName",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Questionnaire edited successfully !");
		//delete pir questionnaire
		pirPage.deleteCreatedQuestionName(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Tab");
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Automation_QuestionName",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Questionnaire deleted successfully !");
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Window's PIR test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}
	
	@Test (description="Sub-area: PIR window -> Questionnaire tab -> Add/edit/delete questions/groups")
	public void subareaPIRWindowQuestionnaireTab_02() throws InterruptedException, ParseException {	
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.getPIRCreationPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName);
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Tab");
		
		//Add pir question
		pirPage.createQuestionnaire(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsDisplayedInPage("PIR_Automation_Question",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Question created successfully !");
		//Edit pir question
		pirPage.clickUpdateCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsDisplayedInPage("PIR_Automation_Question",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Question edited successfully !");
		//delete pir question
		pirPage.deleteCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Automation_Question",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Question deleted successfully !");
		//Add pir group
		pirPage.createQuestionGroup(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsDisplayedInPage("PIR_Automation_Group",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Group created successfully !");
		//Edit pir group
		pirPage.clickEditCreatedGroup(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsDisplayedInPage("PIR_Automation_Group",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Group edited successfully !");
		//delete pir group
		pirPage.deleteCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.sleep(2000);
		pirPage.verifyTextContainsNotDisplayedInPage("PIR_Automation_Group",PlutoraConfiguration.testData );
		Listener.addLogger("PIR Group deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
	
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		Listener.addLogger("PIR Window's PIR test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}
	
	@Test (description="Sub-area: PIR window -> Questionnaire tab -> Sending questionnaire (rating, comments, view the response)")
	public void subareaPIRWindowQuestionnaireTab_03() throws InterruptedException, ParseException {	
		
		pirPage.getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.getPIRCreationPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName,"PIR_Test_Automation_Id1");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id1");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Tab");
		//Send pir questionnaire
		pirPage.createQuestionnaireEmail(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.validateElementDisplayed("PIR_Item_Questionnaire_Sent_Text",PlutoraConfiguration.pirData );
		Listener.addLogger("PIR Question 'Email sent' message appear successfully !");
	}

	@Test (description="Sub-area: PIR window -> Questionnaire tab -> Questionnaire settings window (rating and comments)")
	public void subareaPIRWindowQuestionnaireTab_04() throws InterruptedException, ParseException {	
		//Settings window
		pirPage.createdQuestionSettings(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Settings_Button");
		pirPage.verifyTextAttributeValue("PIR_Item_Questionnaire_MaxRating_Textbox","QuestionMaxRating",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		pirPage.verifyTextAttributeValue("PIR_Item_Questionnaire_Coments_Textarea","QuestionComments",PlutoraConfiguration.pirData,PlutoraConfiguration.testData);
		Listener.addLogger("PIR Questionnaire settings window's given rating & comments saved successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_SettingsOk_Button");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id1");
		Listener.addLogger("PIR Window's PIR test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}
	
	@Test (description="Sub-area: PIR window -> Questionnaire tab -> Copy Questionnaire (when adding new Questionnaire, copy content from another one)")
	public void subareaPIRWindowQuestionnaireTab_05() throws InterruptedException, ParseException {	
		
		//Create pir 
		//pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_SettingsOk_Button");
		//pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Search_Close_Icon");
		pirPage.getPIRCreationPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
		pirPage.creationPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,PlutoraConfiguration.platformName,"PIR_Test_Automation_Id2");
		pirPage.enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id2");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Item_Questionnaire_Tab");
		pirPage.getCopyQuestionnairePage(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.clickVerifyCreatedQuestion(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
		pirPage.verifyTextContainsDisplayedInPage(PIRPage.questionName);
		Listener.addLogger("PIR on adding new Questionnaire, copy content from another one created successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Save&CloseButton");
		pirPage.sleep(2000);
		pirPage.waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		pirPage.deleteNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id2");
		Listener.addLogger("PIR Window's PIR test data deleted successfully !");
		pirPage.getPIRItemTabPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData,"PIR_Page_Title");
	}

}
