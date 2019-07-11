package com.plutora.utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.plutora.pagerepo.ChangesPage;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.pagerepo.DeploymentPage;
import com.plutora.pagerepo.EnvironmentGroupsPage;
import com.plutora.pagerepo.EnvironmentPage;
import com.plutora.pagerepo.NewUserPage;
import com.plutora.pagerepo.PIRPage;
import com.plutora.pagerepo.ReleasePage;
import com.plutora.pagerepo.SystemsPage;
import com.plutora.pagerepo.TEBRPage;
import com.plutora.pagerepo.TECRPage;
import com.plutora.testconfig.PlutoraConfiguration;


public class TestGenericUtilLib extends WebGenericUtilLib {


	// element present
	public  boolean isElementPresent(String objectLocator,String pageData) {
		List<WebElement> ele = webElementsIdentifier(PropertiesCache.getProperty(pageData,objectLocator));
		boolean isPresent = ele.size() > 0;
		return isPresent;
	}

	// Verify list of elements
	public boolean verifyListOfOptions(List<WebElement> actual, String fvalue) {

		String actualText = "";
		String options = "";
		String[] expectedList = fvalue.split(";");
		for (WebElement item : actual) {
			actualText = actualText + item.getText().trim() + ", ";
		}
		actualText = actualText.replaceAll(", $", "");
		String[] actualList = actualText.split(",");
		for (String str : expectedList) {
			boolean found = false;

			for (String ele : actualList) {
				if (str.equalsIgnoreCase(ele.trim())) {
					found = true;
					break;
				}
			}
			if (!found) {
				options = options + str + ", ";
			}
		}
		options = options.replaceAll(", $", "");

		if (options.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// element not present
	public boolean isElementNotPresent(WebElement element) {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].style.border='5px solid green'",
		// element);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].style.border=''", element);
		try {
			element.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	public boolean isElementNotPresent(String objectLocator) {
		try {
			WebElement element = driver.findElement(By.cssSelector(objectLocator));
			return element.isDisplayed();
			//return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementNotDisplayed(String xpathExpression) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));
			return element.isDisplayed();
			//return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isMenuButtonPresent(String objectLocator,String pageData) {
		try {
			objectLocator = PropertiesCache.getProperty(pageData,objectLocator);
			WebElement element = driver.findElement(By.cssSelector(objectLocator.substring(0, objectLocator.lastIndexOf("$"))));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * verifyTextDisplayedInPage on web page
	 */
	public boolean verifyTextDisplayedInPage(String fTextToVerify) {

		boolean textExists = driver.getPageSource().contains(fTextToVerify);

		if (textExists) {
			return true;
		} else {
			return false;
		}
	}

	public void verifyTrue(boolean flag) {
		assertTrue(flag);
	}

	public boolean isCheckboxDisabled(WebElement element) {
		if (!element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void verifyTitle(String pageTitle) {
		String title = driver.getTitle().toString();
		assertEquals(title, pageTitle);
	}

	public void verifyText(String actualResults, String expectedResult, String pageData, String testData) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText(), expectedResult);
		} else {
			assertEquals(webElementIdentifier(actualResults).getText().trim(), expectedResult);
		}
	}
	
	public void verifyText(String actualResults, String expectedResult, String pageData, String testData, String expectedResult1) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText(), expectedResult1);
		} else {
			assertEquals(webElementIdentifier(actualResults).getText().trim(), expectedResult1);
		}
	}

	public void verifyText(String actualResults, String expectedResult, String pageData) {
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		if (actualResults.contains("TEXT")) {
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText(), expectedResult);
		} else {
			assertEquals(webElementIdentifier(actualResults).getText(), expectedResult);
		}
	}

	public void verifyText(String actualResults, String expectedResult) {
		assertEquals(webElementIdentifier(actualResults).getText(), expectedResult);
	}

	public void validateElementDisplayed(String element, String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		assertTrue(webElementIdentifier(element).isDisplayed());
	}
	
	public void validateElementNotDisplayed(String element, String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		try {
		webElementIdentifier(element).isDisplayed();
		assertTrue(false);
		}catch(Exception e) {
		assertTrue(true);
		}
	}
	public void verifyElementNotDisplayed(String element,String data,String objectData) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	element=PropertiesCache.getProperty(data, element);
        	String locatorName=element.substring(element.lastIndexOf("$") + 1);
        	element = element.substring(0, element.lastIndexOf("$"));
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element));
        		break;
        	case "id":
        		driver.findElement(By.id(element));
        		break;
        	}
        	assertTrue(false);
        } catch (Exception e) {  
        	assertTrue(true);
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void verifyElementNotDisplayed(String element,String text,String data,String testData) {
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	element=PropertiesCache.getProperty(data, element);
        	String locatorName=element.substring(element.lastIndexOf("$") + 1);
        	element = element.substring(0, element.lastIndexOf("$"));
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element.replace("TEXT", text)));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element.replace("TEXT", text)));
        		break;
        	case "id":
        		driver.findElement(By.id(element.replace("TEXT", text)));
        		break;
        	}
        	assertTrue(false);
        } catch (Exception e) {  
        	assertTrue(true);
        }
	}
	public void validateElementEnabled(String element, String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		assertTrue(webElementIdentifier(element).isEnabled());
	}

	public void validateElementNotEnabled(String element, String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		assertFalse(webElementIdentifier(element).isEnabled());
	}

	public void validateElementDisplayed(String element, String text, String pageData, String testData) {
		element = PropertiesCache.getProperty(pageData, element);
		text = PropertiesCache.getProperty(testData, text);
		if (element.contains("TEXT")) {
			assertTrue(webElementIdentifier(element.replace("TEXT", text)).isDisplayed());
		} else {
			assertTrue(webElementIdentifier(element).isDisplayed());
		}
	}
	public void validateElementDisplayed(String element, String text, String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		if (element.contains("TEXT")) {
			assertTrue(webElementIdentifier(element.replace("TEXT", text)).isDisplayed());
		} else {
			assertTrue(webElementIdentifier(element).isDisplayed());
		}
	}

	public void validateElementSelected(String element, String text, String pageData, String testData) {
		element = PropertiesCache.getProperty(pageData, element);
		text = PropertiesCache.getProperty(testData, text);
		if (element.contains("TEXT")) {
			assertTrue(webElementIdentifier(element.replace("TEXT", text)).isSelected());
		} else {
			assertTrue(webElementIdentifier(element).isDisplayed());
		}
	}

	public void validateElementNotSelected(String element, String text, String pageData, String testData) {
		element = PropertiesCache.getProperty(pageData, element);
		text = PropertiesCache.getProperty(testData, text);
		if (element.contains("TEXT")) {
			assertFalse(webElementIdentifier(element.replace("TEXT", text)).isSelected());
		} else {
			assertFalse(webElementIdentifier(element).isDisplayed());
		}
	}

	public void validateElementNotDisplayed(String element, String text, String pageData, String testData) {
		element = PropertiesCache.getProperty(pageData, element);
		text = PropertiesCache.getProperty(testData, text);
		if (element.contains("TEXT")) {
			assertFalse(webElementIdentifier(element.replace("TEXT", text)).isDisplayed());
		} else {
			assertFalse(webElementIdentifier(element).isDisplayed());
		}
	}

	public void verifyTextContainsDisplayedInPage(String fTextToVerify, String testData) throws InterruptedException {
		boolean textExists = driver.getPageSource().contains(PropertiesCache.getProperty(testData, fTextToVerify));
		assertTrue(textExists);
	}

	public void verifyTextContainsDisplayedInPage(String fTextToVerify) throws InterruptedException {
		boolean textExists = driver.getPageSource().contains(fTextToVerify);
		assertTrue(textExists);
	}
	public void verifyTextContainsNotDisplayedInPage(String fTextToVerify, String testData) throws InterruptedException {
		boolean textExists = driver.getPageSource().contains(PropertiesCache.getProperty(testData, fTextToVerify));
		assertFalse(textExists);
	}
	public void verifyTextEqualsNotDisplayedInPage(String fTextToVerify, String testData) throws InterruptedException {
		boolean textExists =driver.getPageSource().equals(PropertiesCache.getProperty(testData, fTextToVerify));
		assertFalse(textExists);
	}
	public void verifyTextEqualsNotDisplayedInPage(String fTextToVerify) {
		boolean textExists = driver.getPageSource().equals(fTextToVerify);
		assertFalse(textExists);
	}

	public void verifyTextContains(String actualResults, String expectedResult, String pageData, String testData) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		
		if (actualResults.contains("TEXT")) {
			actual = webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText();
		} else {
			actual = webElementIdentifier(actualResults).getText();
		}
		Listener.addLogger(actual+" "+expectedResult);

		if (actual.contains(expectedResult)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	public void verifyTextContains(String actualResults, String expectedResult) {
		String actual = null;
		actual = webElementIdentifier(actualResults).getText();
		if (actual.contains(expectedResult)) {
			Listener.addLogger(actual+" Contains "+expectedResult);
			assertTrue(true);
		} else {
			Listener.addLogger(actual+" Not Contains "+expectedResult);
			assertTrue(false);
		}
	}
	public void verifyTextContains(String actualResults, String expectedResult, String pageData) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);

		if (actualResults.contains("TEXT")) {
			actual = webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText();
		} else {
			actual = webElementIdentifier(actualResults).getText();
		}
		if (actual.contains(expectedResult)) {
			Listener.addLogger(actual+" Contains "+expectedResult);
			assertTrue(true);
		} else {
			Listener.addLogger(actual+" Not Contains "+expectedResult);
			assertTrue(false);
		}
	}
	public void verifyTextAttributeValue(String actualResults, String expectedResult, String pageData, String testData) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute("value").trim(), expectedResult);
		} else {
			assertEquals(webElementIdentifier(actualResults).getAttribute("value").trim(), expectedResult);
		}
	}
	public void verifyTextAttributeValue(String actualResults, String expectedResult, String pageData, String testData,String parameter) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute(parameter).trim(), expectedResult);
		} else {
			assertEquals(webElementIdentifier(actualResults).getAttribute(parameter).trim(), expectedResult);
		}
	}
	public void verifyTextFromTestData(String actualResults, String expectedResult, String pageData) {
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
			assertEquals(actualResults.trim(), expectedResult.trim());
	}
	
	public void verifyTextContainsNotDisplayedInPage(String fTextToVerify) throws InterruptedException {
		boolean textExists = driver.getPageSource().contains(fTextToVerify);
		assertFalse(textExists);
	}
	public void verifyTextWithAttributeValue(String actualResults, String expectedResult, String pageData, String testData,String parameter) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			if(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute(parameter).trim().contains(expectedResult)) {
				assertTrue(true);
			}else {
				assertTrue(false);
			}
		} else {
			if(webElementIdentifier(actualResults).getAttribute(parameter).trim().contains(expectedResult)) {
				assertTrue(true);
			}else {
				assertTrue(false);
			}
		}
	}

	public void verifyTextAttributeValue(String actualResults, String expectedResult, String pageData) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		if (actualResults.contains("TEXT")) {
			Listener.addLogger(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute("value")+" "+expectedResult);
			assertEquals(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute("value"), expectedResult);
		} else {
			Listener.addLogger(webElementIdentifier(actualResults).getAttribute("value")+" "+expectedResult);
			assertEquals(webElementIdentifier(actualResults).getAttribute("value"), expectedResult);
		}
	}


	public void verifyTextAttributeValue(String actualResults, String expectedResult) {
		assertEquals(webElementIdentifier(actualResults).getAttribute("value"), expectedResult);
	}

	public void verifyTextAttributeClassContains(String actualResults, String expectedResult, String pageData, String testData) {

		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		expectedResult = PropertiesCache.getProperty(testData, expectedResult);
		if (actualResults.contains("TEXT")) {
			assertTrue(webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute("class").contains(expectedResult));
		} else {
			assertTrue(webElementIdentifier(actualResults).getAttribute("class").contains(expectedResult));
		}
	}

	public void verifyAssertTrue(boolean flag) {
		assertTrue(flag);
	}

	public void verifyTextAttributeClassContains(String actualResults, String expectedResult) {
		assertTrue(webElementIdentifier(actualResults).getAttribute("class").contains(expectedResult));
	}

	public void verifyTextAttributeValueContains(String actualResults, String expectedResult, String pageData) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		if (actualResults.contains("TEXT")) {
			actual = webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute("value");
		} else {
			actual = webElementIdentifier(actualResults).getAttribute("value");
		}
		Listener.addLogger(actual+" "+expectedResult);
		if (actual.contains(expectedResult)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
	public void verifyTextAttributeValueContains(String actualResults, String expectedResult, String pageData,String testData,String parameter) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		if (actualResults.contains("TEXT")) {
			expectedResult=PropertiesCache.getProperty(testData,expectedResult);
			actual = webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getAttribute(parameter);
		} else {
			actual = webElementIdentifier(actualResults).getAttribute(parameter);
		}

		if (actual.contains(expectedResult)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
	
	public void verifyTextAttributeValueContains(String actualResults, String text, String pageData,String testData,String parameter,String expectedResult) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);
		if (actualResults.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData,text);
			actual = webElementIdentifier(actualResults.replace("TEXT", text)).getAttribute(parameter);
		} else {
			actual = webElementIdentifier(actualResults).getAttribute(parameter);
		}

		if (actual.contains(expectedResult)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
	public void verifyTextValue(String actualResults, String expectedResult,String testData) {
		actualResults = PropertiesCache.getProperty(testData, actualResults);
		assertEquals(actualResults.trim(), expectedResult);
	}
	public void verifyTextContainsValue(String actualResults, String expectedResult,String testData) {
		actualResults = PropertiesCache.getProperty(testData, actualResults);
		if(expectedResult.contains(actualResults))
			assertTrue(true);
	}
	public void verifyTextContainsValue(String actualResults, String expectedResult) {
		if(actualResults.contains(expectedResult))
			assertTrue(true);
	}
	public void verifyTextValue(String actualResults, String expectedResult) {
		assertEquals(actualResults.trim(), expectedResult.trim());
	}
	public void verifyTextValue(Integer actualResults, Integer expectedResult) {
		assertEquals(actualResults, expectedResult);
	}

	public void verifyCustomFieldValue(String data, String testData, String objectData, String customFieldList,
			String customFieldName, String moduleId, String moduleName,String saveAndCloseButton) throws ParseException, InterruptedException {
		switch (customFieldList) {
		case "Date Picker":
			waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
			sleep(2000);
			if(customFieldName.equals("TECR_CustomField_Name")|| customFieldName.equals("AC_CustomField_Name")) {
				windowScrollDown("800");
			}
			scrollToElement("Additional_Information_DatePicker_Icon", customFieldName, objectData, testData);
			clickElementUsingJavaScript("Additional_Information_DatePicker_Icon", customFieldName, objectData, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			scrollToElement("Additional_information_DatePicker_Today_Button", objectData);
			clickElementUsingJavaScript("Additional_information_DatePicker_Today_Button", objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			String date = new SimpleDateFormat("dd/MM/yyyy")
					.format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					date);
			sleep(3000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(80, "Loading_Gif", objectData);
			sleep(1000);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/

			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			sleep(1000);
			clickElementUsingJavaScript("Additional_Information_DatePicker_Icon", customFieldName, objectData,
					testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender",
					getDate(getCurrentDate("0"), "2"));
			sleep(3000);
			date = new SimpleDateFormat("dd/MM/yyyy")
					.format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					date);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			
			break;

		case "Time Picker":
			sleep(1000);
			scrollToElement("Additional_Information_TimePicker_Icon", customFieldName, objectData, testData);
			click("Additional_Information_TimePicker_Icon", customFieldName, objectData, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(2000);
			scrollToElement("Additional_information_TimePicker_Box_Textbox", objectData);
			sleep(2000);
			click("Additional_information_TimePicker_Done_Button", objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_TimePicker_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					"00:00");
			sleep(2000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/

			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
		
			scrollToElement("Additional_Information_TimePicker_Icon", customFieldName, objectData, testData);
            click("Additional_Information_TimePicker_Icon", customFieldName, objectData, testData);
            waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
            sleep(2000);
            scrollToElement("Additional_information_TimePicker_Box_Textbox", objectData);
            waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
            sleep(1000);
            click("Additional_Information_HourSlider", objectData);
            click("Additional_Information_MinuteSlider",objectData);
            PropertiesCache.setProperty(PlutoraConfiguration.testData, "TimePicker_Value",getAttributeData("Additional_information_TimePicker_Box_Textbox", objectData));
            click("Additional_information_TimePicker_Done_Button", objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			if (customFieldName.contains("AC_CustomField_Name") || customFieldName.contains("TEBR")  || customFieldName.contains("TECR")) {
			}else {
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_TimePicker_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.getProperty(testData, "TimePicker_Value"));
			sleep(1000);
			
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "Date Time Picker":
			sleep(1000);
			if(customFieldName.equals("TECR_CustomField_Name")) {
				windowScrollDown("800");
			}
			scrollToElement("Additional_Information_DateTimePicker_Icon", customFieldName, objectData, testData);
			click("Additional_Information_DateTimePicker_Icon", customFieldName, objectData, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			sendKeys("Additional_information_DateTimePicker_Box_Textbox", "00:00", objectData);
			sleep(1000);
			click("Additional_information_DateTimePicker_Done_Button", objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			date = new SimpleDateFormat("dd/MM/yyyy")
					.format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("0")));
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_DateTimePicker_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
					date + " 00:00");
			sleep(2000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				clickElementUsingJavaScript("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			scrollToElement("Additional_Information_DateTimePicker_Icon", customFieldName, objectData, testData);
			click("Additional_Information_DateTimePicker_Icon", customFieldName, objectData, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(2000);
			sendKeys("Additional_information_DateTimePicker_Box_Textbox", "23:59", objectData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(3000);
			if (customFieldName.contains("DeploymentPlan")) {
				applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender_1",
						getDate(getCurrentDate("0"), "2"));
			}else if(customFieldName.contains("EnvGrp_CustomField_Name")) {
				applicationDatePicker(objectData, testData, "Additional_Information_DateTimePicker_Calender_2",
						getDate(getCurrentDate("0"), "2"));
			}else if (customFieldName.contains("Change_CustomField_Name") || customFieldName.contains("TECR_CustomField_Name") || customFieldName.contains("TEBR_CustomField_Name") ||customFieldName.contains("Environment_CustomField_Name") ||customFieldName.contains("System_CustomField_Name") || customFieldName.contains("PIR_CustomField_Name") ||  customFieldName.contains("PIRItem_CustomField_Name") || customFieldName.contains("AC_CustomField_Name")|| customFieldName.contains("UM_CustomField_Name")){
				applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender_1",
						getDate(getCurrentDate("0"), "2"));
			}else {
				applicationDatePicker(objectData, testData, "Additional_Information_DatePicker_Calender",
						getDate(getCurrentDate("0"), "2"));
			}
			sleep(1000);
			click("Additional_information_DateTimePicker_Done_Button", objectData);
			waitForLoadingIconDisappear(80, "Loading_Gif", objectData);
			sleep(3000);
			date = new SimpleDateFormat("dd/MM/yyyy")
					.format(new SimpleDateFormat("dd-MMMM-yyyy").parse(getCurrentDate("2")));
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_DateTimePicker_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
					date + " 23:59");
			sleep(2000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "List Field":
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			CustomizationPage customizationPage = new CustomizationPage();
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
					PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			if (customFieldName.contains("TEBR")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData, objectData,"Customization_TEBRCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,
						 PlutoraConfiguration.objectData);
				new TEBRPage().enterNewlyCreatedTEBR(data, testData, objectData,"TEBR_Test_Automation_Id");
			} else if (customFieldName.contains("Environment")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,
						objectData,"Customization_EnvironmentCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new EnvironmentPage().goToEnvironmentPage(PlutoraConfiguration.environmentData,
						PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
				new EnvironmentPage().validateEnvironment(PlutoraConfiguration.environmentData,
						PlutoraConfiguration.testData, PlutoraConfiguration.objectData, moduleId);
			} else if (customFieldName.contains("TECR")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData, objectData,"Customization_TECRCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new EnvironmentPage().goToEnvironmentRequestPage(PlutoraConfiguration.environmentData,
					 PlutoraConfiguration.objectData);
				new TECRPage().enterNewlyCreatedTECR(data, testData, objectData,"TECR_Test_Automation_Id");
			} else if (customFieldName.contains("Change")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData, objectData,"Customization_ChangeCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new ChangesPage().changePage(PlutoraConfiguration.changesData, PlutoraConfiguration.objectData);
				new ChangesPage().verifyChange(data, testData, objectData);
			} else if (customFieldName.contains("DeploymentPlan_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,
						objectData,"Customization_DeploymentPlanCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new DeploymentPage().gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,
						PlutoraConfiguration.objectData);
				new DeploymentPage().readDeploymentPlan(data, testData, objectData, moduleId);
			} else if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,
						objectData,"Customization_DeploymentPlanActivityCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new DeploymentPage().gotoDeploymentPage(PlutoraConfiguration.deploymentPlanData,
						PlutoraConfiguration.objectData);
				new DeploymentPage().readDeploymentPlan(data, testData, objectData, moduleId);
			} else if (customFieldName.contains("System")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,objectData,"Customization_SystemCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,customFieldName);
				new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
				new SystemsPage().enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
			} else if (customFieldName.contains("PIRItem")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,objectData,"Customization_PIRItemCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,customFieldName);
				new PIRPage().getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
				new PIRPage().searchNewlyCreatedPIRItem(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData);
			} else if (customFieldName.contains("PIR_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,objectData,"Customization_PIRItemCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,customFieldName);
				new PIRPage().getPIRManagerPage(PlutoraConfiguration.pirData,PlutoraConfiguration.objectData);
				new PIRPage().enterNewlyCreatedPIR(PlutoraConfiguration.pirData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"PIR_Test_Automation_Id");
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}else if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,
						objectData,"Customization_EnvGrpCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new EnvironmentGroupsPage().gotoEnvironmentGroupsPage(PlutoraConfiguration.environmentData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
				new EnvironmentGroupsPage().readEnvironmentGroups(data, testData, objectData, moduleId);
			} else if(customFieldName.contains("AC_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,
						objectData,"Customization_Activity/CriteriaCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,
						customFieldName);
				new ReleasePage().releasePage(data, objectData);
				new ReleasePage().verifyRelease(data, testData, objectData, moduleId);
				new ReleasePage().findAndOpenRelease(data, testData, objectData, moduleId);
				
			}else if(customFieldName.contains("UM_CustomField_Name")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,objectData,"Customization_UserCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,customFieldName);
				new NewUserPage().gotoNewUserPage(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
				new NewUserPage().readNewUser(PlutoraConfiguration.userManagementData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData, "UserManagement_Username");
			}
			
			sleep(2000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			else if (customFieldName.contains("System")) {
				click(moduleName, moduleId, data, testData);
				waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
				sleep(2000);
				new SystemsPage().clickOnButton(PlutoraConfiguration.systemsData,"Systems_AdditionalInformation_Tab",PlutoraConfiguration.objectData);
			} else if (customFieldName.contains("PIRItem")) {
				click(moduleName,moduleId,data,testData);
				waitForLoadingIconDisappear("Loading_Gif",PlutoraConfiguration.objectData);
				sleep(2000);
				new PIRPage().getPIRItemTabPage(PlutoraConfiguration.pirData, PlutoraConfiguration.objectData, "PIR_Item_AdditionalInformation_RadioButton");
			} else {
				click(moduleName, moduleId, data, testData);
				waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
				sleep(2000);
				/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
					clickElementUsingJavaScript("EnvGroups_Details_Button", data);
					waitForLoadingIconDisappear("Loading_Gif", objectData);
					sleep(1000);
				}*/
				if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
					click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
					waitForLoadingIconDisappear("Loading_Gif", objectData);
					sleep(1000);
					click("Deployment_Activity_Additional_Information_Tab", data);
					waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				}
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			click("Additional_Information_ListField_Dropdown", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("Additional_Information_ListField_Option", "CustomList_1", objectData, testData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			
			
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") || customFieldName.contains("AC_CustomField_Name") ) {
			}else {
				verifyTextAttributeValue(
						PropertiesCache.getProperty(objectData, "Additional_Information_ListField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
						PropertiesCache.getProperty(testData, "CustomList_1"));
			}
			sleep(3000);
			click("Additional_Information_ListField_Dropdown", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("Additional_Information_ListField_Option", "CustomList_2", objectData, testData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") || customFieldName.contains("AC_CustomField_Name") ) {
			}else {
				verifyTextAttributeValue(
						PropertiesCache.getProperty(objectData, "Additional_Information_ListField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
						PropertiesCache.getProperty(testData, "CustomList_2"));
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "List Select":
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			try {
			clickButton("Additional_Information_CustomList_Close_Icon", "CustomList_2", objectData, testData, objectData);
			}catch(Exception e) {
			}
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			click("Additional_Information_ListSelect_Dropdown", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("Additional_Information_ListSelect_Option", "CustomList_1", objectData, testData);
			sleep(1000);
			click("Additional_Information_ListSelect_Dropdown", customFieldName, objectData, testData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") ||  customFieldName.contains("AC_CustomField_Name")) {
				// verifyText("Additional_information_ListSelect_Value_1","CustomList_1",objectData,
				// testData);
			} else {
				verifyText("Additional_information_ListSelect_Value", "CustomList_1", objectData, testData);
			}
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(3000);
			clickElementUsingJavaScript("Additional_Information_ListSelect_Dropdown", customFieldName, objectData,
					testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("Additional_Information_ListSelect_Option", "CustomList_1", objectData, testData);
			sleep(1000);
			click("Additional_Information_ListSelect_Option", "CustomList_2", objectData, testData);
			sleep(1000);
			click("Additional_Information_ListSelect_Dropdown", customFieldName, objectData, testData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickElementUsingJavaScript("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") || customFieldName.contains("AC_CustomField_Name") ) {
				// verifyText("Additional_information_ListSelect_Value_1","CustomList_2",objectData,
				// testData);
			} else {
				verifyText("Additional_information_ListSelect_Value", "CustomList_2", objectData, testData);
			}
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			clickElementUsingJavaScript(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear("Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "Free Text":
			sendKeys(
					PropertiesCache.getProperty(objectData, "Additional_Information_FreeText_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.setProperty(testData, "FreeText"));
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			
			if (customFieldName.contains("Change") ||customFieldName.contains("AC_CustomField_Name") ) {
			}else {
				verifyTextAttributeValue(
						PropertiesCache.getProperty(objectData, "Additional_Information_FreeText_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
						PropertiesCache.getProperty(testData, "FreeText"));
			}

			sendKeys(
					PropertiesCache.getProperty(objectData, "Additional_Information_FreeText_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.setProperty(testData, "FreeText"));
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			if (customFieldName.contains("Change") ||customFieldName.contains("AC_CustomField_Name") ) {
			}else {
				verifyTextAttributeValue(
						PropertiesCache.getProperty(objectData, "Additional_Information_FreeText_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
						PropertiesCache.getProperty(testData, "FreeText"));
			}
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "Number":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			} 
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			
			if(customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") ||customFieldName.contains("AC_CustomField_Name") ) {
			}else {
				verifyTextValue(getAttributeData(
						PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox").replace("TEXT",
								PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
						"123456789");
			}
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if(customFieldName.contains("AC_CustomField_Name")) {
				
			}else {
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"987654321");
			sleep(1000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "Decimal":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			} 
			
			if(customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") ||customFieldName.contains("AC_CustomField_Name")) {
			}else{
				verifyTextValue(getAttributeData(
						PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",",
								""),
						"123456789.00");
			}
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			
			
			if(customFieldName.contains("DeploymentPlan_Activity_CustomField_Name") ||customFieldName.contains("AC_CustomField_Name")){
				
			}else{
				scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
				verifyTextValue(getAttributeData(
						PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",",
								""),
						"987654321.00");
			}
			// verifyTextAttributeValue(PropertiesCache.getProperty(tecrData,
			// "Additional_Information_Decimal_Textbox").replace("TEXT",
			// PropertiesCache.getProperty(testData,"TECR_CustomField_Name")),"987654321");
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		case "Currency":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			clickElementUsingJavaScript(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear("Loading_Gif", objectData);
			}
			if(customFieldName.contains("AC_CustomField_Name")) {
				
			}else {
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"$123456789.00");
			}
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			sleep(1000);
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			click(moduleName, moduleId, data, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("PIR_CustomField_Name")) {
				sleep(3000);
				click("PIR_AdditionalInformation_Tab",data);
				sleep(6000);
			}
			if (customFieldName.contains("UM_CustomField_Name")) {
				sleep(3000);
				click("Usermanagement_AdditionalInformation_Tab",data);
				sleep(3000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
				new ReleasePage().clickOnActivity(data, testData, objectData, "Activity_Name");
				waitForLoadingIconDisappear(80,"Loading_Gif", objectData);
			}
			/*if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				clickElementUsingJavaScript("EnvGroups_Details_Button", data);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
			}*/
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				click("Deployment_Activity_Name_Text", "Deployment_Activity_Name", data, testData);
				waitForLoadingIconDisappear("Loading_Gif", objectData);
				sleep(1000);
				click("Deployment_Activity_Additional_Information_Tab", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(2000);
			}
			if(customFieldName.contains("AC_CustomField_Name")) {
				
			}else {
			scrollToElement("Additional_Information_LabelName", customFieldName, objectData, testData);
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"$987654321.00");
			sleep(1000);
			}
			if (customFieldName.contains("AC_CustomField_Name")) {
				clickOnButton(data,"Releases_Activity_Save&CloseButton",objectData);
			}
			if (customFieldName.contains("DeploymentPlan_Activity_CustomField_Name")) {
				clickOnButton(data,"Deployment_Activities_Activity_Close_Button",objectData);
			}
			click(saveAndCloseButton, objectData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			if (customFieldName.contains("EnvGrp_CustomField_Name")) {
				click("EnvGroupsMember_SaveAndClose_Button", data);
				waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
				sleep(1000);
			}
			break;
		default:
			break;
		}
	}
	public void verifyDate(String date1, String date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		Listener.addLogger(d1+" "+d2);
		if (d1.before(d2)) {
			Listener.addLogger(d1.getTime()+ " before "+d2.getTime());
			assertTrue(true);
			
		}else if (d1.equals(d2)) { 
			Listener.addLogger(d1.getTime()+ " equal to "+d2.getTime());
			assertTrue(true);
			
		}
		else {
			Listener.addLogger(d1.getTime()+ " not equal to "+d2.getTime());
			assertTrue(false);
			
		}
	}

	public void verifyWebElementCount(String objectLocator,String text,String count,String pageData,String testData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			if(!testData.isEmpty()) {
			text=PropertiesCache.getProperty(testData, text);
			assertEquals(webElementsIdentifier(objectLocator.replace("TEXT",text)).size(), Integer.parseInt(count));
			}
		}if (objectLocator.contains("TEXT")) {
			if(testData.isEmpty()) { 
			assertEquals(webElementsIdentifier(objectLocator.replace("TEXT",text)).size(), Integer.parseInt(count));
			}
		}else {
			assertEquals(webElementsIdentifier(objectLocator).size(), Integer.parseInt(count));
		}
	}
	public void verifyTextContainsLowerCase(String actualResults, String expectedResult, String pageData) {
		String actual = null;
		actualResults = PropertiesCache.getProperty(pageData, actualResults);

		if (actualResults.contains("TEXT")) {
			actual = webElementIdentifier(actualResults.replace("TEXT", expectedResult)).getText();
		} else {
			actual = webElementIdentifier(actualResults).getText();
		}

		if (actual.toLowerCase().contains(expectedResult.toLowerCase())) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	public void verifyEmailNotification(String testData,String objectData,String text,String emailId) {
		launchUrl("Yopmail_HomePage_URL",testData);
		sleep(1000);
		sendKeysWithEnter("Yopmail_EmailInput",emailId,objectData);
		sleep(1000);
	//	click("Registration_CheckNewMails_Button",objectData);
		sleep(3000);
		switchToFrameByName("Frame_Name",testData);
		sleep(2000);
		verifyText("Yopmail_Subject_Text",text, objectData,testData);
		Listener.addLogger(PropertiesCache.getProperty(testData, text)+" Email received in yopmail account successfully ! ");
		sleep(4000);
		
	}
	public void resetPassword(String testData,String objectData) {
		clickOnActivationLink("Yopmail_ForgotPassword_Button", objectData);
		switchToWindowPopup();
		sendKeysWithEnter("Yopmail_NewPassword_Textfield","ForgotPassword_NewPassword",objectData,testData);
		sendKeysWithEnter("Yopmail_ConfirmPassword_Textfield","ForgotPassword_NewPassword",objectData,testData);
		click("Yopmail_SendPasswordReset_Button", objectData);
		Listener.addLogger("User new password is reset successfully ! ");
	}
	public void verifyLocalizationCustomFieldValue(String data, String testData, String objectData, String customFieldList,
			String customFieldName, String format, String decimalNumber,String saveAndCloseButton) throws ParseException, InterruptedException {
		switch (customFieldList) {
		case "Date Picker":
			scrollToElement("Additional_Information_DatePicker_Icon", customFieldName, objectData, testData);
			clickElementUsingJavaScript("Additional_Information_DatePicker_Icon", customFieldName, objectData, testData);
			waitForLoadingIconDisappear(60, "Loading_Gif", objectData);
			sleep(1000);
			scrollToElement("Additional_information_DatePicker_Today_Button", objectData);
			clickOnButton(objectData,"Additional_information_DatePicker_Today_Button", objectData);
			String date = getTodayDate("0", format);
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "Additional_Information_DatePicker_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					date);
			Listener.addLogger("Localization - "+format+" - "+date+" - "+" updated successfully !");
			click(saveAndCloseButton, objectData);
			break;
		case "Number":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			sleep(2000);
			clickOnButton(objectData,"Save_Button",objectData);
			clickOnButton(data,"Deployment_Information_Tab",objectData);
			clickOnButton(data,"DeploymentPlan_Additional_Information_Tab",objectData);
			String numberFormat=PropertiesCache.getProperty(testData, "Number_Format");
			String value = null;
			if(numberFormat.contains(".")) {
				value=getLocaleValue("###,###.###", 123456789, new Locale("de", "DE"));
			}else {
				value=getDecimalValue(format, 123456789);
			}
			verifyTextValue(getAttributeData(
					PropertiesCache.getProperty(objectData, "Additional_Information_Number_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName))),value
					);
			
			Listener.addLogger("Localization - "+format+" - "+value+" - "+" updated successfully !");
			clickOnButton(objectData,saveAndCloseButton, objectData);
			break;
		case "Decimal":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			clickOnButton(objectData,"Save_Button",objectData);
			clickOnButton(data,"Deployment_Information_Tab",objectData);
			clickOnButton(data,"DeploymentPlan_Additional_Information_Tab",objectData);
			sleep(2000);
			
			String decimals="0";
	        for(int i=0;i<Integer.parseInt(decimalNumber)-1;i++) {
	        	decimals="0"+decimals;
	        }
	        value = null;
	        numberFormat=PropertiesCache.getProperty(testData, "Number_Format");
	        if(numberFormat.contains(",")) {
	        	format=numberFormat+format+decimals;
	        	value=getDecimalValue(format, 123456789);
	        }else if(numberFormat.contains(".")) {
	        	value=getLocaleValue("###,###.###", 123456789, new Locale("de", "DE"))+format+decimals;
	        }else {
	        	format=format+decimals;
	        	value=getDecimalValue(format, 123456789);
	        }
			verifyTextValue(getAttributeData(
					PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))),value);
	        
			Listener.addLogger("Localization - "+format+" - "+value+" - "+" updated successfully !");
			clickOnButton(objectData,saveAndCloseButton, objectData);
			break;
		case "Currency":
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			sleep(2000);
			clickOnButton(objectData,"Save_Button",objectData);
			clickOnButton(data,"Deployment_Information_Tab",objectData);
			clickOnButton(data,"DeploymentPlan_Additional_Information_Tab",objectData);
			value=null;
			numberFormat=PropertiesCache.getProperty(testData, "Number_Format");
			if(format.contains("â‚¬")) {
	        	value=getLocaleValue("â‚¬###,###.###", 123456789, new Locale("de", "DE"))+",00";
			}else {
				value=getDecimalValue(format, 123456789);
			}
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))),value
					);
			Listener.addLogger("Localization - "+format+" - "+value+" - "+" updated successfully !");
			
			clickOnButton(objectData,saveAndCloseButton, objectData);
			break;
		}
	
	}
	public void verifyListText(String objectLocator,String text,String pageData,String testData) {
		List<WebElement> listOfWebElement = webElementsIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
		if(!testData.isEmpty()) {
			text=PropertiesCache.getProperty(testData, text);
		}
		ArrayList<String> listOfTextElement = new ArrayList<String>();
		for(WebElement element : listOfWebElement) {
			listOfTextElement.add(element.getText().trim());
		}
		for(String listText: listOfTextElement) {
		if(listText.contains(text)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}}
	}
	public void verifyDoubleValue(String valueOne,String valueTwo) {
		 if(Double.parseDouble(valueOne) > Double.parseDouble(valueTwo)) {
			 assertTrue(true);
			 Listener.addLogger(Double.parseDouble(valueOne)+" greater than "+Double.parseDouble(valueTwo));
		 }else {
			 assertTrue(false);
			 Listener.addLogger(Double.parseDouble(valueOne)+" lesser than "+Double.parseDouble(valueTwo));
		 }
	 }
	public void verifyReactCustomFieldValue(String data, String testData, String objectData, String customFieldList,
			String customFieldName, String moduleId, String moduleName,String saveButton) throws ParseException, InterruptedException {
		switch (customFieldList) {
		case "Date Picker":
			waitForLoadingIconDisappear(100,"Loading_Gif", objectData);
			sleep(2000);
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sleep(3000);
			reactDatePicker(objectData, testData, getTodayDate("0", "dd-MM-yyyy"));
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
			//Verify current Date
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					getTodayDate("0", "dd/MM/yyyy"));
			click(saveButton, data);
			
			/*reactDatePicker(objectData, testData, getTodayDate("4", "dd-MM-yyyy"));
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
			//Verify future date
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					getTodayDate("4", "dd/MM/yyyy"));
			
			click(saveButton, data);*/
			
			break;

		case "Time Picker":
			sleep(1000);
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sleep(3000);
			reactTimePicker(objectData, "1","00", "React_Additional_information_TimePicker_AM_Text");
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
			//Verify current time
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					"01:00");
			click(saveButton, data);
			
			/*reactTimePicker(objectData, "12","55", "React_Additional_information_TimePicker_PM_Text");
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
			//Verify different time
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					"12:55");
			click(saveButton, data);*/
			break;
		case "Date Time Picker":
			sleep(1000);
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sleep(3000);
			//Select current date & time
			reactDatePicker(objectData, testData, getTodayDate("0", "dd-MM-yyyy"));
			doubleClick("React_Additional_information_DateTimePicker_Hour_Text",getTodayDate("0", "hh"),objectData);
			reactTimePicker(objectData, "1","00", "React_Additional_information_TimePicker_AM_Text");
			
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
		    //Verify  current date time picker
		    verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					getTodayDate("0", "dd/MM/yyyy")+" 01:00");
			click(saveButton, data);
			//Select future date & time
			/*reactDatePicker(objectData, testData, getTodayDate("4", "dd-MM-yyyy"));
			doubleClick("React_Additional_information_DateTimePicker_Hour_Text",getTodayDate("0", "hh"),objectData);
			reactTimePicker(objectData, "12","55", "React_Additional_information_TimePicker_PM_Text");
			
			click("React_Additional_information_OK_Button",objectData);
		    sleep(2000);
		    //Verify future date time picker
		    verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					getTodayDate("4", "dd/MM/yyyy")+" 12:55");
			click(saveButton, data);*/
			
		    break;
			
		case "List Field":
			click(saveButton, data);
			
			CustomizationPage customizationPage = new CustomizationPage();
			customizationPage.getCustomizationDetailsPage(PlutoraConfiguration.customizationData,
					PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
			
			if (customFieldName.contains("System")) {
				customizationPage.clickOnCustomListsOption(PlutoraConfiguration.customizationData,objectData,"Customization_SystemCustomLists_Option");
				customizationPage.addCustomLists(PlutoraConfiguration.customizationData, testData, objectData,customFieldName);
				new EnvironmentPage().getSystemsPage(PlutoraConfiguration.environmentData,PlutoraConfiguration.objectData);
				new SystemsPage().enterNewlyCreatedSystems(PlutoraConfiguration.systemsData,PlutoraConfiguration.testData,PlutoraConfiguration.objectData,"Systems_Test_Automation_Id");
			} 
			
			if (customFieldName.contains("System")) {
				click(moduleName, moduleId, data, testData);
				waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
				sleep(2000);
			} 
			//click custom list 1
			scrollToElement("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			click("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("React_Additional_Information_ListField_Option", "CustomList_1", objectData, testData);
			sleep(1000);
			//Verify custom list 1
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_ListField_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.getProperty(testData, "CustomList_1"));
			
			click(saveButton, data);
			waitForLoadingIconDisappear(500, "Loading_Gif", objectData);
			sleep(1000);
			//Click custom list 2
			click("React_Additional_Information_ListField_Close_Icon",customFieldName,objectData,testData);
			sleep(2000);
			click("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("React_Additional_Information_ListField_Option", "CustomList_2", objectData, testData);
			sleep(1000);
			//Verify custom list 2
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_ListField_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.getProperty(testData, "CustomList_2"));
			
			click("React_Additional_Information_ListField_Close_Icon",customFieldName,objectData,testData);
			sleep(2000);
			click(saveButton, data);
			
			break;
		case "List Select":
			scrollToElement("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			//Click custom list 1
			click("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(2000);
			clickElementUsingJavaScript("React_Additional_Information_ListField_Option", "CustomList_1", objectData, testData);
			sleep(1000);
			//Verify custom list 1
			verifyText(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_ListSelect_Textbox_Text")
					.replace("TEXT", PropertiesCache.getProperty(testData, "CustomList_1")),
					PropertiesCache.getProperty(testData, "CustomList_1"));
			
			click(saveButton, data);
			
			click("React_Additional_Information_ListField_Close_Icon",customFieldName,objectData,testData);
			sleep(2000);
			
			//Click custom list 2
			click("React_Additional_Information_ListField_Textbox", customFieldName, objectData, testData);
			waitForLoadingIconDisappear("Loading_Gif", PlutoraConfiguration.objectData);
			sleep(1000);
			click("React_Additional_Information_ListField_Option", "CustomList_2", objectData, testData);
			sleep(1000);
			//Verify custom list 2
			verifyText(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_ListSelect_Textbox_Text")
					.replace("TEXT", PropertiesCache.getProperty(testData, "CustomList_2")),
					PropertiesCache.getProperty(testData, "CustomList_2"));
			
			click("React_Additional_Information_ListField_Close_Icon",customFieldName,objectData,testData);
			sleep(2000);
			click(saveButton, data);
			
			
			break;
		case "Free Text":
			
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			//Send free text
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sendKeys(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.setProperty(testData, "FreeText"));
			//Verify free text
			verifyTextAttributeValue(
						PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
						PropertiesCache.getProperty(testData, "FreeText"));
			click(saveButton, data);
			/*//Send free text
			sendKeys(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.setProperty(testData, "FreeText"));
			sleep(1000);
			//Verify free text
			verifyTextAttributeValue(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox")
					.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName)),
					PropertiesCache.getProperty(testData, "FreeText"));
			click(saveButton, objectData);*/
			break;
		case "Number":
			
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			//Send number
			sendKeys(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			//Verify number
			verifyTextValue(getAttributeData(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"123456789");
	
			click(saveButton, data);
			
			/*click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			//Send number
			sendKeys(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			//Verify number
			verifyTextValue(getAttributeData(
					PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
							PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"987654321");
	
			click(saveButton, data);*/
		
			break;
		case "Decimal":
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			//Send decimal
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sendKeys(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			//verify decimal
			verifyTextValue(getAttributeData(
						PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",",
								""),
						"123456789");
			
			click(saveButton, data);
			
			//Send decimal
			/*click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sendKeys(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			//verify decimal
			verifyTextValue(getAttributeData(
						PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
						.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",",
								""),
						"987654321.00");
			
			click(saveButton, data);*/
			break;
		case "Currency":
			scrollToElement("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			//Send currency
			click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);

			sendKeysWithDeleteCharacter(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "123456789");
			//Verify currency
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "React_Additional_Information_CustomField_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"123456789");
			click(saveButton, data);
			
			
			//Send currency
			/*click("React_Additional_Information_CustomField_Textbox", customFieldName, objectData, testData);
			sendKeys(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox").replace("TEXT",
					PropertiesCache.getProperty(testData, customFieldName)), "987654321");
			//Verify currency
			verifyTextValue(
					getAttributeData(PropertiesCache.getProperty(objectData, "Additional_Information_Decimal_Textbox")
							.replace("TEXT", PropertiesCache.getProperty(testData, customFieldName))).replace(",", ""),
					"$987654321.00");
			click(saveButton, data);*/
			
			break;
		default:
			break;
		}
	}
	public void verifyTextStringNotContains(String expectedResults, String actualResult, String testData) {
		expectedResults = PropertiesCache.getProperty(testData,expectedResults);
		assertFalse(actualResult.contains(expectedResults));
	}
}
