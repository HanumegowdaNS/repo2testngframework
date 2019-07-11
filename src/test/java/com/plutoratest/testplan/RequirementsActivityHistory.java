package com.plutoratest.testplan;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.constants.CommonConstants;
import com.plutora.testconfig.PlutoraTestConfiguration;
import com.plutora.utils.Listener;
import com.plutoratest.pagerepo.RequirementsActivityHistoryPage;
import com.plutoratest.pagerepo.RequirementsPage;

public class RequirementsActivityHistory {
	RequirementsActivityHistoryPage requirementsActivityPage = new RequirementsActivityHistoryPage();
	RequirementsPage requirementsPage = new RequirementsPage();
	
	@Test(description = "Requirement Activity History")
	@Parameters({"requirementsFile","requirementsBulkUploadFile","testDataFile","objectMapFile","platform"})
	public void requirementsActivityHistory(String requirementsData,String activityData, String testData, String objectData, String platform) throws InterruptedException, IOException, AWTException {
		requirementsPage.getRequirementsDetailsPage(requirementsData,
				objectData);
		requirementsPage.createRequirements(requirementsData,
				testData, PlutoraTestConfiguration.platformName,
				CommonConstants.imageFileName, objectData, 1);
		requirementsPage.updateRequirementsName(requirementsData,
				testData, objectData,"Requirements_Automation_Name_1");
		
		requirementsPage.searchRequirements(requirementsData,
				testData, objectData, 1);
		
	
		//Activity page
		requirementsActivityPage.getRequirementsActivityPage(requirementsData,activityData,objectData,testData,"Requirements_Automation_Name_1");
		requirementsActivityPage.isElementPresent("Req_Activity_History_Header",activityData);
		Listener.addLogger("Activity history page opened.");
		/*//Activity live search page
		String statusList = requirementsActivityPage.getRequirementsActivitySearchPage(activityData,testData,objectData);
		requirementsActivityPage.verifyTextStringNotContains("ActivityLiveSearchModifyText",statusList,testData);
		Listener.addLogger("The search result matched the search criteria.");*/
		//Activity Added search
		String searchAddedList = requirementsActivityPage.getActivityAddedButtonSearch(activityData,testData,objectData);
		requirementsActivityPage.verifyTextStringNotContains("ActivityLiveSearchModifyText",searchAddedList,testData);
		requirementsActivityPage.verifyTextStringNotContains("ActivityLiveSearchDeleteText",searchAddedList,testData);
		Listener.addLogger("The +Added search result match the selected filter button option.");
		//Activity Modified search
		String searchModifiedList = requirementsActivityPage.getActivityModifiedButtonSearch(activityData,testData,objectData);
		requirementsActivityPage.verifyTextStringNotContains("ActivityLiveSearchAddText",searchModifiedList,testData);
		requirementsActivityPage.verifyTextStringNotContains("ActivityLiveSearchDeleteText",searchModifiedList,testData);
		Listener.addLogger("The +Added search result match the selected filter button option.");
		//Activity Advanced Filters
		requirementsActivityPage.getActivityAdvFilterPage(activityData,objectData,testData);
		requirementsActivityPage.isElementPresent("Req_Activity_History_AdvFilter_Popup",activityData);
		Listener.addLogger("The 'Advanced Filter' window opened.");
		//Activity Advanced Filter Date
		boolean flag = requirementsActivityPage.getActivityAdvFilterDate(activityData,objectData,testData);
		requirementsActivityPage.verifyTrue(flag);
		requirementsActivityPage.getCloseButton(activityData);
		Listener.addLogger("The search result matched the search criteria.");

	}



}