package com.plutora.testplan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.utils.Listener;

public class Changes {

  ChangesPage changesPage = new ChangesPage();
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Creating a new Change")
  public void createChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  //changesPage.verifyText("Change_Page_Title","Change_Page_Title_Value", changeData,testData);
	  changesPage.createChange(changeData,testData,objectData);
	  changesPage.clickOnSaveAndCloseButton(changeData,objectData);
	  changesPage.waitForLoadingIconDisappear("Loading_Gif",objectData);
	  Listener.test1.log(Status.INFO,"Change is created successfully !");
  }
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Verifying Change is created and found when searched", dependsOnMethods="createChange")
  public void verifyChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  //changesPage.verifyText("Change_Page_Title","Change_Page_Title_Value",changeData,testData);
	  changesPage.verifyChange(changeData,testData,objectData);
	  changesPage.verifyText("Change_Result_Gridview_Name","Change_Automation_Id",changeData,testData);
	  Listener.test1.log(Status.INFO,"Change created in the first case is found");
  }
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Updating the change", dependsOnMethods="verifyChange")
  public void updateChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  changesPage.findAndOpenChange(changeData,testData,objectData);
	  changesPage.verifyTextContains("Change_SubTitle","Change_Automation_Id",changeData,testData);
	  changesPage.updateChange(changeData,testData,objectData);
	  Listener.test1.log(Status.INFO,"Updated description field in Change created successfully !");
  }
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Updating the change", dependsOnMethods="updateChange")
  public void createDuplicateChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  changesPage.createDuplicateChange(changeData,testData,objectData);
	  changesPage.verifyTextContains("Confirmation_Message","New_Change_Create_Duplicate_Message",objectData,testData);
	  Listener.test1.log(Status.INFO,"Change duplicate record created successfully !");
  }
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Deleting a change", dependsOnMethods="createDuplicateChange")
  public void deleteDuplicateChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  changesPage.deleteDuplicateChange(changeData,objectData,testData);
	  //changesPage.verifyTextEqualsNotDisplayedInPage("New_Change_Create_Duplicate_Message",testData);
	  Listener.test1.log(Status.INFO,"Change duplicate record deleted successfully !");
  }
  
  @Parameters({"changesFile","testDataFile","objectMapFile"})
  @Test (description="Deleting a change", dependsOnMethods="deleteDuplicateChange")
  public void deleteChange(String changeData, String testData, String objectData) throws InterruptedException {
	  changesPage.changePage(changeData,objectData);
	  changesPage.findAndOpenChange(changeData,testData,objectData);
	  changesPage.verifyTextContains("Change_SubTitle","Change_Automation_Id", changeData,testData);
	  changesPage.deleteChange(changeData,objectData);
	  changesPage.verifyText( "Change_NoResult_Found","Change_not_Found_Value",changeData,testData);
	  Listener.test1.log(Status.INFO,"Change deleted successfully !");
  }
}
