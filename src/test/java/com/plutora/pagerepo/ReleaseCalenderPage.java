package com.plutora.pagerepo;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plutora.utils.Listener;
import com.plutora.utils.PropertiesCache;
import com.plutora.utils.TestGenericUtilLib;

public class ReleaseCalenderPage extends TestGenericUtilLib  {

	public void clickOnTodayOption(String releaseData,String objectData){
		clickElementUsingJavaScript("Release_Calender_TodayButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger("Selected Today's date successfully !");
	}
	public void clickOnDayOption(String releaseData,String objectData){
		clickElementUsingJavaScript("Release_Calender_DayButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger("Selected Day option successfully !");
	}
	public void clickOnWeekOption(String releaseData,String objectData){
		clickElementUsingJavaScript("Release_Calender_WeekButton",releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
		Listener.addLogger("Selected Week option successfully !");
	}

	public void verifyMonthRelease(String releaseData, String testData,String objectData,String releaseName) {
		clickElementUsingJavaScript("Release_Calender_MonthButton", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//	String element = PropertiesCache.getProperty(releaseData, "Release_Calender_Month_MoreButton");
		try {
			sleep(2000);
			String date=new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
			WebElement element=driver.findElement(By.xpath("//*[@id='ext-cal-ev-more-"+date+"']/a"));
			element.isDisplayed();
			sleep(1000);
			clickElementUsingJavaScript(element);
			sleep(4000);
			validateElementDisplayed("Release_Calender_Today_Month_ReleaseText", releaseName,releaseData,testData);
			sleep(4000);
			clickElementUsingJavaScript("Release_Calender_Today_Month_CloseButton",releaseData);
			sleep(1000);

		} catch (Exception e) {
			validateElementDisplayed("Release_Calender_Today_Month_ReleaseText", releaseName,releaseData,testData);
		}
	}
	
	public void verifyMonthContainsRelease(String releaseData, String testData,String objectData,String releaseName) {
		clickElementUsingJavaScript("Release_Calender_MonthButton", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		//	String element = PropertiesCache.getProperty(releaseData, "Release_Calender_Month_MoreButton");
		try {
			sleep(2000);
			String date=new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
			WebElement element=driver.findElement(By.xpath("//*[@id='ext-cal-ev-more-"+date+"']/a"));
			element.isDisplayed();
			sleep(1000);
			clickElementUsingJavaScript(element);
			sleep(4000);
			validateElementDisplayed("Release_Calender_Today_Month_ReleaseContainsText", releaseName,releaseData,testData);
			sleep(4000);
			clickElementUsingJavaScript("Release_Calender_Today_Month_CloseButton",releaseData);
			sleep(1000);

		} catch (Exception e) {
			validateElementDisplayed("Release_Calender_Today_Month_ReleaseContainsText", releaseName,releaseData,testData);
		}
	}

	public void verifyTodayMonthRelease(String releaseData, String testData,String objectData,String releaseName) {
		clickElementUsingJavaScript("Release_Calender_MonthButton", releaseData);
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		String element = PropertiesCache.getProperty(releaseData, "Release_Calender_Today_Month_MoreButton");
		try {
			if (element.contains("TEXT")) {
				element=element.replace("TEXT", PropertiesCache.getProperty(testData, releaseName));
				sleep(2000);
				webElementIdentifier(element).isDisplayed();
				sleep(1000);
				click(element);
				sleep(4000);
				validateElementDisplayed("Release_Calender_Today_Month_ReleaseText", releaseName,releaseData,testData);
				sleep(4000);
				clickElementUsingJavaScript("Release_Calender_Today_Month_CloseButton",releaseData);
				sleep(1000);
			}else{
				webElementIdentifier(element).isDisplayed();
				sleep(1000);
				click(element);
				sleep(4000);
				validateElementDisplayed("Release_Calender_Today_Month_ReleaseText", releaseName,releaseData,testData);
				sleep(4000);
				clickElementUsingJavaScript("Release_Calender_Today_Month_CloseButton",releaseData);
				sleep(1000);
			}

		} catch (Exception e) {
			validateElementDisplayed("Release_Calender_Today_Month_ReleaseText", releaseName,releaseData,testData);
		}
	}

	public void verifyReleaseWeekDate(String text,String testData) throws ParseException{
		sleep(2000);
		text=PropertiesCache.getProperty(testData,text);
		String date=new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
		assertTrue(driver.findElement(By.xpath("//td[@id='app-calendar-week-hd-day-"+date+"']/ancestor::div[@id='app-calendar-week-hd']/following-sibling::div//a[text()='"+text+"']")).isDisplayed());
		Listener.addLogger(text+" displayed successfully !");
	}
	
	public void verifyReleaseWeekContainsDate(String text,String testData) throws ParseException{
		sleep(2000);
		text=PropertiesCache.getProperty(testData,text);
		String date=new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
		assertTrue(driver.findElement(By.xpath("//td[@id='app-calendar-week-hd-day-"+date+"']/ancestor::div[@id='app-calendar-week-hd']/following-sibling::div//a[contains(text(),'"+text+"')]")).isDisplayed());
		Listener.addLogger(text+" displayed successfully !");
	}

	public void clickOnReleaseSelectAllOption(String pageData) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		try {
			
			String objectLocator=PropertiesCache.getProperty(pageData, "Release_Calender_SelectAll_Checked");
			scrollToElement("Release_Calender_Types", pageData);
			click("Release_Calender_Types", pageData);
			webElementIdentifier(objectLocator).isDisplayed();
		}catch(Exception e) {
			sleep(2000);
			String objectLocator=PropertiesCache.getProperty(pageData, "Release_Calender_SelectAll_NotChecked");
			WebElement element=webElementIdentifier(objectLocator);
			element.isDisplayed();
			webElementIdentifier(PropertiesCache.getProperty(pageData, "Release_Calender_SelectAll_Button")).click();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
	
	public void getEnvironmentLeftpanelTECRFilterPage(String releaseCalendarData,String parameter) {

		//Tecr select
		String value = getAttributeValue("Release_Calender_TECRFilter_Icon",releaseCalendarData, parameter);
		System.out.println("TECR Button: "+value);
		if (!value.contains("x-form-item-no-label x-form-cb-checked")) {
			scrollToElement("Release_Calender_TECRFilter_Button", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TECRFilter_Button", releaseCalendarData);
		} else {
			System.out.println("Environment TECR selected");
		}
		//Tecr status select
		String value1 = getAttributeValue("Release_Calender_TECRStatus_CollapsedIcon",releaseCalendarData, parameter);
		System.out.println("TECR status collapse: "+value1);
		if (value1.contains("x-fieldset x-fieldset-collapsed")) {
			scrollToElement("Release_Calender_TECRStatus_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TECRStatus_Link", releaseCalendarData);
		} else {
			System.out.println("Environment TECR status collapsed");
		}
		//Tecr type select
		String value2 = getAttributeValue("Release_Calender_TECRType_CollapsedIcon",releaseCalendarData, parameter);
		System.out.println("TECR Button: "+ value2);
		if (value2.contains("x-fieldset-default x-fieldset-collapsed")) {
			scrollToElement("Release_Calender_TECRType_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TECRType_Link", releaseCalendarData);
		} else {
			System.out.println("Environment TECR selected");
		}

	}

	public void getTECRSelectAllSelectPage(String releaseCalendarData) {

		//tecr select select all 
		String value3 = getAttributeValue("Release_Calender_TECRTypeSelectAll_Checked",releaseCalendarData,"class");
		if (!value3.contains("x-form-cb-checked")) {
			scrollToElement("Release_Calender_TECRType_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TECRTypeItem_Button","Select All" ,releaseCalendarData);
		} else {
			System.out.println("Environment TECR Select all already selected");
		}
	}

	public void getReleasesLeftpanelFilterOnOffPage(String releaseCalendarData,String iconId,String buttonId) {

		String objectLocator=PropertiesCache.getProperty(releaseCalendarData,iconId );
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath(objectLocator)).isDisplayed();
			scrollToElement(buttonId, releaseCalendarData);
			clickElementUsingJavaScript(buttonId, releaseCalendarData);
			System.out.println("Release Calendar section button clicked");
		} catch (Exception e) {
			System.out.println("Release Calendar section button already clicked");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



	public void getEnvironmentLeftpanelTECRLableCheckedPage(String releaseCalendarData,String testData,String ItemId,String itemLabelId,String clickId,String parameter) {

		//Tecr type checked
		String value = getAttributeValue(ItemId,itemLabelId,releaseCalendarData, parameter);
		System.out.println("TECR Button: "+value);
		if (!value.contains("x-form-cb-checked")) {
			sleep(2000);
			clickElementUsingJavaScript(clickId,itemLabelId,releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TECR status selected");
		}
	}

	public void getEnvironmentLeftpanelTECRLableUnCheckedPage(String releaseCalendarData,String testData,String ItemId,String itemLabelId,String clickId,String parameter) {

		//Tecr type checked
		String value = getAttributeValue(ItemId,itemLabelId,releaseCalendarData, parameter);
		System.out.println("TECR Button: "+value);
		if (value.contains("x-form-cb-checked")) {
			clickElementUsingJavaScript(clickId,itemLabelId,releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TECR status unselected");
		}
	}
	
	public void getEnvironmentLeftpanelTEBRFilterPage(String releaseCalendarData,String parameter) {

		//Tebr select
		String value = getAttributeValue("Release_Calender_TEBRFilter_Icon",releaseCalendarData, parameter);
		System.out.println("TEBR Button: "+value);
		if (!value.contains("x-form-item-no-label x-form-cb-checked")) {
			scrollToElement("Release_Calender_TEBRFilter_Button", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TEBRFilter_Button", releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TEBR selected");
		}
		//Tebr status select
		String value1 = getAttributeValue("Release_Calender_TEBRStatus_CollapsedIcon",releaseCalendarData, parameter);
		System.out.println("TEBR status collapse: "+value1);
		if (value1.contains("x-fieldset x-fieldset-collapsed")) {
			scrollToElement("Release_Calender_TEBRStatus_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TEBRStatus_Link", releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TEBR status collapsed");
		}
		//Tebr type select
		String value2 = getAttributeValue("Release_Calender_TEBRType_CollapsedIcon",releaseCalendarData, parameter);
		System.out.println("TEBR Button: "+ value2);
		if (value2.contains("x-fieldset-default x-fieldset-collapsed")) {
			scrollToElement("Release_Calender_TEBRType_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TEBRType_Link", releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TEBR selected");
		}

	}
	
	public void getTEBRSelectAllSelectPage(String releaseCalendarData) {

		//tebr select select all 
		String value3 = getAttributeValue("Release_Calender_TEBRTypeSelectAll_Checked",releaseCalendarData,"class");
		if (!value3.contains("x-form-cb-checked")) {
			scrollToElement("Release_Calender_TEBRType_Link", releaseCalendarData);
			clickElementUsingJavaScript("Release_Calender_TEBRTypeItem_Button","Select All" ,releaseCalendarData);
			sleep(2000);
		} else {
			System.out.println("Environment TEBR Select all already selected");
		}
	}
	
	public void verifyYearRelease(String releaseData, String testData,String objectData,String releaseName) {
		clickElementUsingJavaScript("Release_Calender_YearButton", releaseData);
		waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
		try {
			sleep(2000);
			String date=new SimpleDateFormat("dd MMMMM yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
			String dateString = date.substring(0, 2);
			if (dateString.substring(0,1).equals("0")) {
				dateString = dateString.replace("0", "");
			}
			WebElement element=driver.findElement(By.xpath("//span[text()='"+date.substring(3, date.length())+"']"));
			scrollToElement(element);
			
			element=driver.findElement(By.xpath("//div[@id='app-calendar-year-innerCt']//span[text()='"+date.substring(3, date.length())+"']/ancestor::div[@class='x-datepicker-header']/following-sibling::table//td[not(contains(@class,'x-datepicker-disabled'))]//div[text()='"+dateString+"']/ancestor::td"));
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement(element);
			sleep(1000);
			mouseOver(element);
			sleep(1000);
			element.click();
			waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
			sleep(2000);
			validateElementDisplayed("Release_Calender_Day_ReleaseContainsText", releaseName,releaseData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, releaseName)+" displayed in release year calendar sucessfully !");
		} catch (Exception e) {
			System.out.println("Release calendar data not displayed"+e);
			verifyTrue(false);
		}
	}
	
	public void verifyYearRelease(String releaseData, String testData,String objectData,String releaseName,String dates) {
		clickElementUsingJavaScript("Release_Calender_YearButton", releaseData);
		waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
		try {
			sleep(2000);
			String date=new SimpleDateFormat("dd MMMMM yyyy").format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate(dates)));
			String dateString = date.substring(0, 2);
			if (dateString.substring(0,1).equals("0")) {
				dateString = dateString.replace("0", "");
			}
			WebElement element=driver.findElement(By.xpath("//span[text()='"+date.substring(3, date.length())+"']"));
			scrollToElement(element);
			
			element=driver.findElement(By.xpath("//div[@id='app-calendar-year-innerCt']//span[text()='"+date.substring(3, date.length())+"']/ancestor::div[@class='x-datepicker-header']/following-sibling::table//td[not(contains(@class,'x-datepicker-disabled'))]//div[text()='"+dateString+"']/ancestor::td"));
			waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			sleep(1000);
			scrollToElement(element);
			sleep(1000);
			mouseOver(element);
			sleep(1000);
			element.click();
			waitForLoadingIconDisappear(1000,"Loading_Gif",objectData);
			sleep(2000);
			validateElementDisplayed("Release_Calender_Day_ReleaseContainsText", releaseName,releaseData,testData);
			Listener.addLogger(PropertiesCache.getProperty(testData, releaseName)+" displayed in release year calendar sucessfully !");
		} catch (Exception e) {
			System.out.println("Release calendar data not displayed");
			verifyTrue(false);
		}
	}
	
	
	
}
