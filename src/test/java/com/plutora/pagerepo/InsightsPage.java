package com.plutora.pagerepo;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class InsightsPage extends TestGenericUtilLib  {
	
	public void gotoInsightsManagementPage(String insightsData,String objectData) throws InterruptedException {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		mouseHover("Dashboard_Menu", "Insights_Menu",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnInsightsDropdown(String insightsData,String objectData) {
		sleep(2000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Insights_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnApplyButton(String insightsData,String objectData) {
		sleep(2000);
		clickElementUsingJavaScript("Insights_Apply_Button",insightsData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void searchForRelease(String insightsData,String testData,String objectData,String releaseType) {
		
		clickElementUsingJavaScript("Insights_SearchForRelease_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_SearchForRelease_Option",releaseType,insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		
	}
	public void searchReleaseFromViewMetric(String insightsData,String testData,String objectData,String releaseFirstOption) {
		
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Insights_View_Metrics_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		PropertiesCache.setProperty(testData, "Insights_ViewMetric_FirstRelease",getTextData(releaseFirstOption, insightsData));
		sendKeys("Insights_View_Metrics_Textbox","Insights_ViewMetric_FirstRelease" ,insightsData,testData);
		sleep(1000);
		click(releaseFirstOption,insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void searchReleaseFromViewMetric(String insightsData,String testData,String objectData,String releaseFirstOption,String releaseName) {
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickOnClearInsightsButton(insightsData, objectData);
		sleep(3000);
		clickElementUsingJavaScript("Insights_View_Metrics_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		validateElementDisplayed("Insights_SearchForRelease_Options", insightsData);
		Listener.addLogger("List of Releases with not completed status are available");
		sendKeys("Insights_View_Metrics_Textbox",releaseName ,insightsData,testData);
		waitForLoadingIconDisappear(50,"Loading_Gif",objectData);
		sleep(4000);
		clickElementUsingJavaScript(releaseFirstOption,insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_View_Metrics_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnClearInsightsButton(String insightsData,String objectData) {
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		click("Insights_Clear_Button",insightsData);
		waitForLoadingIconDisappear(150,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void selectReleaseType(String insightsData,String testData,String objectData,String releaseName,int i) {
		searchForRelease(insightsData, testData, objectData, releaseName);
		Listener.addLogger("Selected " + releaseName+ " release type successfully");
		
		if(releaseName.equals("Portfolio Association")) {
			clickElementUsingJavaScript("Insights_SelectOrganizationType_Dropdown",insightsData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			clickElementUsingJavaScript("Insights_SelectOrganizationType_Option","Release_Organization",insightsData,testData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			clickElementUsingJavaScript("Insights_SelectOrganizationType_Dropdown",insightsData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
		}else {
			clickElementUsingJavaScript("Insights_SelectReleaseType_Dropdown",insightsData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(2000);
			clickElementUsingJavaScript("Insights_SelectReleaseType_Option","Release_Type",insightsData,testData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
			if(i>=1) {
				clickElementUsingJavaScript("Insights_SelectReleaseType_Option","Release_Type",insightsData,testData);
				waitForLoadingIconDisappear("Loading_Gif",objectData);
				sleep(1000);
			}
			clickElementUsingJavaScript("Insights_SelectReleaseType_Dropdown",insightsData);
			waitForLoadingIconDisappear("Loading_Gif",objectData);
			sleep(1000);
		}

	}
	public void selectImplementationDate(String insightsData,String testData,String objectData,String releaseName,int i) throws ParseException {
		searchForRelease(insightsData, testData, objectData, releaseName);
		selectReleaseType(insightsData, testData, objectData, releaseName, i);
		
		clickElementUsingJavaScript("Insights_ImplementationFromDate_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Insights_ImplementationDate_Today_Button",insightsData);
		
		clickElementUsingJavaScript("Insights_ImplementationToDate_Dropdown",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Insights_ImplementationDate_Today_Button",insightsData);
	}
	
	public void clickOnSettingIcon(String insightsData,String testData,String objectData) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		clickElementUsingJavaScript("Insights_Setting_Button",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void selectSettingOption(String insightsData,String objectData,String optionLocator) {
		sleep(1000);
		click(optionLocator,insightsData);
		waitForLoadingIconDisappear(150,"Loading_Gif",objectData);
		sleep(2000);
	}
	public void selectReleaseMatrixShowIcon(String insightsData,String objectData) {
	
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_ReleaseMatrix_Show_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    } 
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_Stakeholder_Hide_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_CompletedRelease_Hide_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }finally {  
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		    }  
	}
	public void selectStakeholderShowIcon(String insightsData,String objectData) {
		
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_ReleaseMatrix_Hide_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    } 
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_Stakeholder_Show_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_CompletedRelease_Hide_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }finally {  
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		    }  
	}
	public void selectCompletedShowIcon(String insightsData,String objectData) {
		
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		    
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_Stakeholder_Hide_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }
		    try {  
		        driver.findElement(By.xpath(PropertiesCache.getProperty(insightsData, "Insights_CompletedRelease_Show_Icon"))).click();  
		    } catch (NoSuchElementException e) {  
		        
		    }finally {  
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		    }  
	}
	public void clickOnActivity(String insightsData,String testData,String objectData,String activityName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_Progress_Activity_Name",activityName,insightsData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void clickOnCriteria(String insightsData,String testData,String objectData,String criteriaName) {
		clickElementUsingJavaScript("Insights_ActivitiesSummaryAndProgress",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
		sleep(1000);
		
		clickElementUsingJavaScript("Insights_Gate_Tab","Criteria_Gate",insightsData,testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Insights_Progress_Activity_Name",criteriaName,insightsData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnActivityDueCount(String insightsData,String objectData,String activityDue) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript(activityDue,insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnTECRDueToday(String insightsData,String testData,String objectData,String tecrName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		clickElementUsingJavaScript("Insights_TECR_Due_Today_Icon",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_TECR_Request_Number",tecrName,insightsData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnSystems(String insightsData,String testData,String objectData,String systemsName) {
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_Systems_Icon",insightsData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		click("Insights_System_Details",systemsName,insightsData, testData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
}
