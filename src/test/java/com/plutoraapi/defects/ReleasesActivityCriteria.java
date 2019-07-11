package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutoraapi.pagerepo.ReleasesPage;
 
public class ReleasesActivityCriteria  {

	ReleasesPage releasesPage = new ReleasesPage();

	@Test(description = "API - Cannot Add/update ID for Activities and Criterias using PUT method", groups = { "RegressionTests" })
	public void createRelease4338ActivityCriteria() throws InterruptedException{
		releasesPage.createRelease("createRelease4338Json", PlutoraAPIConfiguration.testData);
		releasesPage.setDataToProperty("id","Release_Id");
		releasesPage.createReleasePhase("createReleasePhase4338Json", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","workId");
		releasesPage.createReleaseGates("createReleaseGates4338Json", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("id","workGatesId");
		
	   releasesPage.createReleaseStakeholders("createReleaseStakeholder4338Json", PlutoraAPIConfiguration.testData,"Release_Id");
		    //Verify Get & Post Activity
		releasesPage.releasePostActivity("createRelease4338PostJson",PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("identifier");
		releasesPage.verifyResponseNotEmpty("identifier");
		APIListener.addLogger( "[API] - idetifier field displayed by using GET response for Activity.");
		APIListener.addLogger( "[API] - idetifier field displayed by using POST response for Activity.");
		   //Verify Get Activity with activity id
		releasesPage.setDataToProperty("id","activityId");
		releasesPage.verifyReleaseGetActivityWithActivityId(PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.verifyResponseNotEmpty("identifier");
		APIListener.addLogger( "[API] - idetifier field displayed by using GET response for activity id.");
		   //Verify Put Activity
		releasesPage.verifyReleasePutActivity("createRelease4338PutJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.verifyResponseNotEmpty("identifier");
		APIListener.addLogger( "[API] - idetifier field updated and displayed by using PUT response for activity id.");

		//Verify Get & Post Criteria
		releasesPage.releasePostCriteria("createRelease4338PostCriteriaJson",PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.setDataToProperty("identifier");
		releasesPage.verifyResponseValue("identifier",PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - idetifier field displayed by using GET response for Criterias.");
		APIListener.addLogger( "[API] - idetifier field displayed by using POST response for Criterias.");
		//Verify Get Criteria with criteria id
		releasesPage.setDataToProperty("id","criteriaId");
		releasesPage.verifyReleaseGetCriteriaWithCriteriaId(PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.verifyResponseNotEmpty("identifier");
		APIListener.addLogger( "[API] - idetifier field displayed by using GET response for criteria id.");
		//Verify Put Criteria
		releasesPage.verifyReleasePutCriteria("createRelease4338PutCriteriaJson", PlutoraAPIConfiguration.testData,"Release_Id");
		releasesPage.verifyResponseNotEmpty("identifier");
		APIListener.addLogger( "[API] - idetifier field updated and displayed by using PUT response for criteria id.");
		releasesPage.deleteRelease(PlutoraAPIConfiguration.testData);

		
		
	}

}

