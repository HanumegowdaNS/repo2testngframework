package com.plutoratest.pagerepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class RequirementsActivityHistoryPage extends TestGenericUtilLib {
	public static String requirementGeneratedId=null;

	public void getRequirementsActivityPage(String requirementsData,String activityData,String objectData,String testData,String name) {
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		handle_toast_popup("Server_Error",testData,objectData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Bulkupload_ItemTab", activityData);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		sleep(2000);
		clickElementUsingJavaScript("Requirements_Name", name,requirementsData,testData);
		//clickElementUsingJavaScript("Req_Activity_ExistingRequirement_Link", activityData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_Activity_Timer_Icon", activityData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
	}

	public String getRequirementsActivitySearchPage(String activityData, String testData,String objectData) {
		sendKeysWithEnter("Req_Activity_History_LiveSearch_Textbox", "ActivityLiveSearchAddText",activityData,testData);
		String concatedString = concatenateString("Req_Activity_History_ResultStatus_List", activityData);
		return concatedString;
	}

	public String getActivityAddedButtonSearch(String activityData, String testData,String objectData) {
		clear("Req_Activity_History_LiveSearch_Textbox",activityData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_Added_Button", activityData);
		sleep(2000);
		String concatedString = concatenateString("Req_Activity_History_ResultStatus_List", activityData);
		return concatedString;
	}

	public String getActivityModifiedButtonSearch(String activityData, String testData,String objectData) {
		clickElementUsingJavaScript("Req_Activity_History_Added_Button",activityData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_Modified_Button", activityData);
		sleep(2000);
		String concatedString = concatenateString("Req_Activity_History_ResultStatus_List", activityData);
		return concatedString;
	}

	public void getActivityAdvFilterPage(String activityData,String objectData,String testData) {
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_Modified_Button", activityData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		clickElementUsingJavaScript("Req_Activity_History_AdvFilter_Button", activityData);
		sleep(2000);

	}

	public boolean getActivityAdvFilterDate(String activityData,String objectData,String testData) {
		sleep(2000);
		selectDDLByValue("Req_Activity_History_Date_ShowDropdown", "14", activityData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_ApplyFilter_Button", activityData);
		sleep(2000);
		waitForLoadingIconDisappear("Progress_Bar", objectData);
		String dateValue = getTextData("Req_Activity_History_Date", activityData);
		//date
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		final LocalDate firstDate = LocalDate.parse(dateValue, formatter);
		final LocalDate secondDate = LocalDate.now();
		final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
		boolean flag = false;
		if (days<=14) {
			flag = true;
		} else {
			flag = false;
		}
	 return flag;
	}

	public void getCloseButton(String bulkUploadData) {
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_AdvFilter_PopupClose_Button",bulkUploadData);
		sleep(2000);
		clickElementUsingJavaScript("Req_Activity_History_RequirementClose_Button",bulkUploadData);
	}


}
