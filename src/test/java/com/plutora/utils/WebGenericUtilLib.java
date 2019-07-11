package com.plutora.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.base.Function;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.testconfig.PlutoraTestConfiguration;

public class WebGenericUtilLib  {

	public static WebDriver driver;
	public static WebDriver newDriver;
	public static WebDriver tempDriver;
	public enum locatorTypes {
		xpath, css, id, name, link, className, tagName, partialLink
	}

	public enum browsertype {
		IE, FF, CHROME, SAFARI, IOSAPP, ANDROIDAPP;
	}
	public static boolean flag=false;

	// Open browser for web application
	public static void getBrowser(String browser, String hubUrl,String chromeDriverPath,String platform)  {
		DesiredCapabilities capability = null;
		browsertype expDriver = browsertype.valueOf(browser);
		

		BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // put our custom header to each request
        proxy.addRequestFilter((request, contents, messageInfo)->{
            request.headers().add("plt-x-selenium-overrride", "A lengthy piece of text supercalifragilisticexpialidocious");
            //System.out.println(request.headers().entries().toString());
            return null;
        });
        
		try {
			switch (expDriver) {
			case FF:
				if(platform.equals("Windows")) {
					Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
				}else if(platform.equals("Mac")) {
					Runtime.getRuntime().exec("killall geckodriver");
				}
				/*profile.setPreference("browser.cache.disk.enable", false);
				profile.setPreference("browser.cache.memory.enable", false);
				profile.setPreference("browser.cache.offline.enable", false);
				profile.setPreference("network.http.use-cache", false);*/
				capability = DesiredCapabilities.firefox();
				// driver = new FirefoxDriver();
				break;

			case IE:
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\BrowserDrivers\\IEDriverServer.exe");
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("internet explorer");
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capability.setJavascriptEnabled(true);
				capability.setCapability("ie.ensureCleanSession", true);
				break;

			case CHROME:
				if(platform.equals("Windows")) {
					Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				}else if(platform.equals("Mac")) {
					Runtime.getRuntime().exec("killall chromedriver");
				}
				String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
				String downloadFilepath = PlutoraConfiguration.userDir+PlutoraConfiguration.PATH_SEPARATOR+"DownloadFiles"+PlutoraConfiguration.PATH_SEPARATOR;
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
				chromePrefs.put("profile.default_content_settings.popups", 0);  
				chromePrefs.put("download.default_directory", downloadFilepath);  
				ChromeOptions options = new ChromeOptions();  
				options.setExperimentalOption("prefs", chromePrefs);  
				options.addArguments("--disable-notifications");
				options.addArguments(proxyOption);
				capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
				capability.setCapability(ChromeOptions.CAPABILITY, options);
				capability.setCapability("applicationCacheEnabled", false);
				break;
			default:
				break;
			}
		//driver = new RemoteWebDriver(new URL(hubUrl), capability);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(capability);
			if (browser.equalsIgnoreCase("Mac")) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				int Width = (int) toolkit.getScreenSize().getWidth();
				int Height = (int) toolkit.getScreenSize().getHeight();
				driver.manage().window().setSize(new Dimension(Width, Height));
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
		} catch (Throwable exp) {
			System.out.println("Exception thrown opening browser error." + exp);
		}
	}
	
	public static void getNewBrowser(String browser, String hubUrl,String chromeDriverPath)  {
		DesiredCapabilities capability = null;
		browsertype expDriver = browsertype.valueOf(browser);
		
		BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // put our custom header to each request
        proxy.addRequestFilter((request, contents, messageInfo)->{
            request.headers().add("plt-x-selenium-overrride", "A lengthy piece of text supercalifragilisticexpialidocious");
            //System.out.println(request.headers().entries().toString());
            return null;
        });
		
		try {
			switch (expDriver) {
			case FF:
				capability = DesiredCapabilities.firefox();
				// driver = new FirefoxDriver();
				break;
			case IE:
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\BrowserDrivers\\IEDriverServer.exe");
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("internet explorer");
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capability.setJavascriptEnabled(true);
				break;

			case CHROME:
				String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
				String downloadFilepath = PlutoraConfiguration.userDir+PlutoraConfiguration.PATH_SEPARATOR+"DownloadFiles"+PlutoraConfiguration.PATH_SEPARATOR;
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
				chromePrefs.put("profile.default_content_settings.popups", 0);  
				chromePrefs.put("download.default_directory", downloadFilepath);  
				ChromeOptions options = new ChromeOptions();  
				options.setExperimentalOption("prefs", chromePrefs);  
				options.addArguments("--disable-notifications");
				options.addArguments(proxyOption);
				capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
				capability.setCapability(ChromeOptions.CAPABILITY, options);  

				break;
			default:
				break;
			}
		//	driver = new RemoteWebDriver(new URL(hubUrl), capability);
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			newDriver = new ChromeDriver(capability);
			if (browser.equalsIgnoreCase("Mac")) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				int Width = (int) toolkit.getScreenSize().getWidth();
				int Height = (int) toolkit.getScreenSize().getHeight();
				newDriver.manage().window().setSize(new Dimension(Width, Height));
			}
			newDriver.manage().deleteAllCookies();
			newDriver.manage().window().maximize();
		} catch (Throwable exp) {
			System.out.println("Exception thrown opening browser error." + exp);
		}
	}

	// highlight element
	public void highlightElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);

	}

	// highlight element
	public void highlightErrorElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid red'", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);

	}

	// clickButton
	public void click(String objectLocator, String text, String pageData, String testData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text = PropertiesCache.getProperty(testData, text);
		if (objectLocator.contains("TEXT")) {
			webElementIdentifier(objectLocator.replace("TEXT", text)).click();
		} else {
			webElementIdentifier(objectLocator).click();
		}
	}

	// sendkeys with given data
	public void sendkeysWithData(String objectLocator, String text, String pageData, String testData, String data) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text = PropertiesCache.getProperty(testData, text);
		WebElement ele;
		if (objectLocator.contains("TEXT")) {
			 ele = webElementIdentifier(objectLocator.replace("TEXT", text));
		} else {
			ele = webElementIdentifier(objectLocator);
		}
		ele.clear();
		ele.sendKeys(data);
	}

	public void click(String objectLocator, String text, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			webElementIdentifier(objectLocator.replace("TEXT", text)).click();
		} else {
			webElementIdentifier(objectLocator).click();
		}
	}
	public void click(String objectLocator, String pageData) {
		webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).click();
	}

	public void click(String objectLocator) {
		webElementIdentifier(objectLocator).click();
	}
	public void click(WebElement element) {
		element.click();
	}
	
	// edit input
	public void sendKeys(String element, String fTextToEnter, String pageData, String testData) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		ele.clear();
		ele.sendKeys(PropertiesCache.getProperty(testData, fTextToEnter));
	}

	public void sendKeysWithoutClear(String element, String fTextToEnter, String pageData, String testData) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		ele.sendKeys(PropertiesCache.getProperty(testData, fTextToEnter));
	}
	public void sendKeysWithDelete(String element, String fTextToEnter, String pageData, String testData,
			String platform) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		if (platform.contains("Mac")) {
			ele.sendKeys(Keys.DELETE);
		} else {
			sleep(2000);
			ele.click();
			ele.sendKeys(Keys.BACK_SPACE);
		}
		ele.sendKeys(PropertiesCache.getProperty(testData, fTextToEnter));
	}

	public void sendKeysWithDeleteCharacter(String element, String fTextToEnter, String pageData, String testData) {
        WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
        int lenText = ele.getAttribute("value").length();
        for(int i = 0; i < lenText; i++){
            ele.sendKeys("\u0008");
        }
        sleep(2000);        
        ele.sendKeys(PropertiesCache.getProperty(testData, fTextToEnter));
        sleep(1000);
        ele.sendKeys(Keys.ENTER);
	}

	public void sendKeysWithDeleteCharacter(String element, String fTextToEnter, String pageData) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		int lenText = ele.getAttribute("value").length();
		for(int i = 0; i < lenText; i++){
			ele.sendKeys("\u0008");
		}
		sleep(2000);		
		ele.sendKeys(fTextToEnter);
		ele.sendKeys(Keys.ENTER);
	}
	
	public void sendKeysWithDeleteCharacter(String element, String fTextToEnter) {
		WebElement ele = webElementIdentifier(element);
		int lenText = ele.getAttribute("value").length();
		for(int i = 0; i < lenText; i++){
			ele.sendKeys("\u0008");
		}
		sleep(2000);		
		ele.sendKeys(fTextToEnter);
		ele.sendKeys(Keys.ENTER);
	}
	public void sendKeysWithBackspace(String element, String fTextToEnter, String pageData, String testData,
			String platform) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		if (platform.contains("Mac")) {
			ele.sendKeys(Keys.DELETE);
		} else {
			sleep(2000);
			ele.sendKeys(Keys.BACK_SPACE);
		}
	//	ele.sendKeys(PropertiesCache.getProperty(testData, fTextToEnter));
	}
	public void sendKeys(String element, String fTextToEnter, String pageData) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		sleep(1000);
		ele.clear();
		ele.sendKeys(fTextToEnter);
	}
	public void sendKeysWithoutClear(String element, String fTextToEnter, String pageData) {
		WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
		sleep(1000);
		ele.sendKeys(fTextToEnter);
	}
	public void sendKeysWithoutClear(String element, String fTextToEnter) {
		WebElement ele = webElementIdentifier(element);
		sleep(1000);
		ele.sendKeys(fTextToEnter);
	}
	
	public void sendKeys(String element, String fTextToEnter) {
		WebElement ele = webElementIdentifier(element);
		ele.clear();
		ele.sendKeys(fTextToEnter);
	}
	// Get Browser Title
	public String getBrowserTitle() {
		return driver.getTitle().toString();
	}
	public void goBack() {
		driver.navigate().back();
	}

	// getText
	public String getTextData(String objectLocator, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator).getText().trim();
	}
	public String getAttributeData(String objectLocator, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator).getAttribute("value").trim();
	}
	public String getAttributeValue(String objectLocator,String pageData,String parameter) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator).getAttribute(parameter).trim();
	}
	public String getAttributeValue(String objectLocator,String text,String pageData,String testData,String parameter) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text=PropertiesCache.getProperty(testData, text);
		return webElementIdentifier(objectLocator.replace("TEXT", text)).getAttribute(parameter).trim();
	}
	public String getAttributeValue(String objectLocator,String text,String pageData,String parameter) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator.replace("TEXT", text)).getAttribute(parameter).trim();
	}
	
	public String getCSSValue(String objectLocator,String text,String pageData,String testData,String parameter) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text=PropertiesCache.getProperty(testData, text);
		return webElementIdentifier(objectLocator.replace("TEXT", text)).getCssValue(parameter).trim();
	}
	
	public String getCSSValue(String objectLocator,String pageData,String parameter) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator).getCssValue(parameter).trim();
	}
	
	public String getAttributeValue(String objectLocator,String parameter) {
		return webElementIdentifier(objectLocator).getAttribute(parameter).trim();
	}
	public String getAttributeData(String objectLocator) {
		return webElementIdentifier(objectLocator).getAttribute("value").trim();
	}

	// getText
	public String getTextData(String objectLocator, String text, String pageData, String testData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text = PropertiesCache.getProperty(testData, text);
		return webElementIdentifier(objectLocator.replace("TEXT", text)).getText().trim();
	}
	
	public String getTextData(String objectLocator, String text, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		return webElementIdentifier(objectLocator.replace("TEXT", text)).getText().trim();
	}

	// element present
	public boolean isElementPresent(String objectLocator, String pageData) {
		List<WebElement> ele = webElementsIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
		boolean isPresent = ele.size() > 0;
		System.out.println(ele.size());
		return isPresent;

	}
	// element count
	public int elementsCount(String objectLocator, String pageData) {
		List<WebElement> ele = webElementsIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
		System.out.println(ele.size());
		return ele.size();

	}

	// Select DDl by index
	public void selectDDLByIndex(String objectLocator, int index, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.selectByIndex(index);
		sleep(1000);
	}

	// Select DDl by Value
	public void selectDDLByValue(String objectLocator, String value, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.selectByValue(value);
	}

	// Select DDl by visible text
	public void selectDDLByVisibleText(String objectLocator, String text, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.selectByVisibleText(text);
	}

	// DeSelect DDl by visible text
	public void deSelectDDLByVisibleText(String objectLocator, String text, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.deselectByVisibleText(text);
	}

	// DeSelect DDl by index
	public void deSelectDDLByIndex(String objectLocator, int index, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.deselectByIndex(index);
	}

	// DeSelect DDl by Value
	public void deSelectDDLByValue(String objectLocator, String value, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.deselectByValue(value);
	}

	// DeSelect All Option
	public void deSelectAll(String objectLocator, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		sct.deselectAll();
	}

	// To verify DDl is multiple or not
	public boolean checkDDLisMultiple(String objectLocator, String pageData) {
		Select sct = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		boolean status = sct.isMultiple();
		return status;
	}

	// To click on Ok Button on Alert
	public void acceptAlert() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	// To get alert Message
	public String getAlertMsg(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		String alert_msg = alt.getText();
		return alert_msg;
	}

	// To enter text on alert Prompt
	public void enterTextOnAlert(WebDriver driver, String text) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}

	// tO PERFORM mouse over
	public void mouseOver(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	// To perform double click
	public void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void doubleClick(String objectLocator, String pageData) {
		Actions act = new Actions(driver);
		act.doubleClick(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator))).perform();
	}

	public void doubleClick(String objectLocator, String text,String pageData,String testData) {
		objectLocator=PropertiesCache.getProperty(pageData, objectLocator);
		text=PropertiesCache.getProperty(testData,text);
		Actions act = new Actions(driver);
		if(objectLocator.contains("TEXT")) {
			act.doubleClick(webElementIdentifier(objectLocator.replace("TEXT", text))).build().perform();
		}
	}
	public void doubleClick(String objectLocator, String text,String pageData) {
		objectLocator=PropertiesCache.getProperty(pageData, objectLocator);
		Actions act = new Actions(driver);
		if(objectLocator.contains("TEXT")) {
			act.doubleClick(webElementIdentifier(objectLocator.replace("TEXT", text))).build().perform();
		}
	}
	
	// To perform drag and drop
	public void dragAndDrop(WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}

	// check element loaded
	public void isElementLoaded(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
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
	
	public boolean isElement_Present(String objectLocator, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		WebElement element;
		try {
		    element = webElementIdentifier(objectLocator);
			element.isDisplayed();
			return true;
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
	
	public void uploadImage(String identifier) throws InterruptedException, IOException, AWTException {
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		WebElement uploadFile = driver.findElement(By.id(identifier));
		sleep(500);
		uploadFile.sendKeys(src.toString());
		waitForLoadingIconDisappear("Progress_Bar", PlutoraConfiguration.objectData);
		src.delete();
	}
	
	public void uploadImageByCss(String identifier) throws InterruptedException, IOException, AWTException {
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		WebElement uploadFile = driver.findElement(By.cssSelector(identifier));
		sleep(500);
		uploadFile.sendKeys(src.toString());
		waitForLoadingIconDisappear("Progress_Bar", PlutoraTestConfiguration.objectData);
		src.delete();
	}
	

	public void uploadImage(String uploadFileLocator,String pageData,String fileName)  {
		/*sleep(1000);
		File uploadedFile = new File(fileName);
		StringSelection ss = new StringSelection(uploadedFile.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		if (platform.equals("Windows")) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} else if (platform.equals("Mac")) {
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_G);
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}*/
		WebElement element = driver.findElement(By.name("uploadFile"));
		element.sendKeys(fileName);
		sleep(5000);
	}

	public void uploadFile(String uploadFileLocator,String pageData,String fileName)  {
		WebElement element = driver.findElement(webElementByIdentifier(PropertiesCache.getProperty(pageData, uploadFileLocator)));
		element.sendKeys(fileName);
		sleep(5000);
	}
	public void datePicker(String pageData,String testData,String datePicker,String dateString) throws ParseException {

		//String dateSelect[] = getCurrentDate("2").split("-");
		String dateSelect[] = dateString.split("-");
		String ED = dateSelect[0];
		String EM = dateSelect[1];
		String EY = dateSelect[2];
		System.out.println(ED + EM + EY);
		if(ED.startsWith("0")) {
			ED=ED.replace("0", "");
		}
		sleep(2000);
		WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, datePicker));
		//String elementText=getTextData(datePicker, pageData);
		//WebElement element=driver.findElement(By.cssSelector("[id*='datepicker'] [id*='splitbutton'][id*='btnInnerEl']"));
		if(!element.getText().split(" ")[1].equals(EY)){
			element.click();
			sleep(2000);
			driver.findElement(By.xpath("//a[text()='"+EY+"']")).click();
			sleep(1000);
			System.out.println(EM.substring(0, 3));
			driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
			sleep(2000);
			driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
			sleep(2000);
			driver.findElement(By.xpath("//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
			sleep(1000);
		}else if(element.getText().split(" ")[1].equals(EY)){
			if(!element.getText().split(" ")[0].equals(EM)){
				element.click();
				sleep(1000);
				driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
				sleep(2000);
				driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
				sleep(2000);
				driver.findElement(By.xpath("//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
				sleep(1000);
			}else{
				sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")));
				sleep(3000);
			}
		}
		
		Listener.addLogger(dateString+" selected from calendar successfully !");

	}


	public String randomString(String artifactCode) {
		return artifactCode  + "_" + new Random().nextInt((1000 - 1) + 1) + 1;
	}

	public String formateDate(String expectedDate, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat format1 = new SimpleDateFormat(pattern);
		Date date = format.parse(expectedDate);
		return format1.format(date);
	}

	Map<String, String> randomValueList = new HashMap<String, String>();

	public void generateUniqueValue(String artifactId) {
		if (artifactId.contains("$")) {
			String mapValue = artifactId.replaceAll("[${}]", "");
			randomValueList.put(mapValue, randomString(mapValue));
		}
	}

	public void waitForVisibilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	public void waitPolling(final String objectLocator, final String pageData) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement aboutMe = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
			}
		});
	}

	public boolean isCheckboxDisabled(WebElement element) {
		if (!element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public String waitForLoadingElement(int timeInSecs, String objectLocator, String pageData) {
		// TODO Auto-generated method stub
		try {
			(new WebDriverWait(driver, timeInSecs)).until(ExpectedConditions.visibilityOfElementLocated(
					webElementByIdentifier(PropertiesCache.getProperty(pageData, objectLocator))));
			return null;
		} catch (TimeoutException e) {
			return "Loading icon not disappered after" + timeInSecs + "seconds./n" + e;
		}
	}

	public String waitForLoadingIconDisappear(int timeInSecs, String objectLocator, String pageData) {
		// TODO Auto-generated method stub
		try {
			(new WebDriverWait(driver, timeInSecs)).until(ExpectedConditions.invisibilityOfElementLocated(
					webElementByIdentifier(PropertiesCache.getProperty(pageData, objectLocator))));
			return null;
		} catch (TimeoutException e) {
			return "Loading icon not disappered after" + timeInSecs + "seconds./n" + e;
		}
	}

	public String waitForLoadingIconDisappear(String objectLocator, String pageData) {
		// TODO Auto-generated method stub
		try {
			(new WebDriverWait(driver, 40)).until(ExpectedConditions.invisibilityOfElementLocated(
					webElementByIdentifier(PropertiesCache.getProperty(pageData, objectLocator))));
			return null;
		} catch (TimeoutException e) {
			return "Loading icon not disappered after" + 40 + "seconds./n" + e;
		}
	}

	public void switchToWindow(String objectLocator, String pageData) {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Inside window popup");
				webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).click();
				driver.switchTo().window(parentWindow);
			}
		}
	}
	
	public void switchToWindow(String testData, int timeInMiliSecs,String parentWindowName,String childWindowName) throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		PropertiesCache.setProperty(testData,parentWindowName, parentWindow);
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				PropertiesCache.setProperty(testData,childWindowName, windowHandle);
				driver.switchTo().window(windowHandle);
				//System.out.println("Inside window popup");
			}
		}
		sleep(timeInMiliSecs);
	}
	
	public void switchToWindow(int timeInMiliSecs,String parentWindowName) throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		PropertiesCache.setProperty(PlutoraConfiguration.testData,parentWindowName, parentWindow);
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Inside window popup");
			}
		}
		Thread.sleep(timeInMiliSecs);
	}
	
	public void switchToWindow(String objectLocator, String pageData,int timeInMiliSec) {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Inside window popup");
				sleep(timeInMiliSec);
				webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).click();
				driver.switchTo().window(parentWindow);
			}
		}
	}
	
	public void switchToWindowPopup() {
		Object firstHandle, lastHandle;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		firstHandle = itr.next();
		lastHandle = firstHandle;
		while (itr.hasNext()) {
			lastHandle = itr.next();
		}
		driver.switchTo().window(lastHandle.toString());
	}
	public WebDriver getDriver() {
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		//baseUrl = url;
	}

	public static void setTimeOuts(int pageLoadTimeOutInSec, int implicitWaitInSec) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOutInSec, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWaitInSec, TimeUnit.SECONDS);
	}

	public WebElement webElementIdentifier(String objectLocator) {
		locatorTypes locator = locatorTypes.valueOf(objectLocator.substring(objectLocator.lastIndexOf("$") + 1));
		String elementLocator = objectLocator.substring(0, objectLocator.lastIndexOf("$"));
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locator) {
		case link:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementLocator)));
			element = driver.findElement(By.linkText(elementLocator));
			//element=new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementLocator)));
			break;
		case xpath:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
			element = driver.findElement(By.xpath(elementLocator));
			break;
		case css:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementLocator)));
			element = driver.findElement(By.cssSelector(elementLocator));
			break;
		case id:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementLocator)));
			element = driver.findElement(By.id(elementLocator));
			break;
		case name:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementLocator)));
			element = driver.findElement(By.name(elementLocator));
			break;
		case className:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementLocator)));
			element = driver.findElement(By.className(elementLocator));
			break;
		case tagName:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(elementLocator)));
			element = driver.findElement(By.tagName(elementLocator));
			break;
		case partialLink:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(elementLocator)));
			element = driver.findElement(By.partialLinkText(elementLocator));
			break;
		}
		/* hightlight element */
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);

		return element;

	}

	public By webElementByIdentifier(String objectLocator) {
		locatorTypes locator = locatorTypes.valueOf(objectLocator.substring(objectLocator.lastIndexOf("$") + 1));
		String elementLocator = objectLocator.substring(0, objectLocator.lastIndexOf("$"));
		By element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locator) {
		case link:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementLocator)));
			element = By.linkText(elementLocator);
			break;
		case xpath:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementLocator)));
			element = By.xpath(elementLocator);
			break;
		case css:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementLocator)));
			element = By.cssSelector(elementLocator);
			break;
		case id:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementLocator)));
			element = By.id(elementLocator);
			break;
		case name:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementLocator)));
			element = By.name(elementLocator);
			break;
		case className:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementLocator)));
			element = By.className(elementLocator);
			break;
		case tagName:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(elementLocator)));
			element = By.tagName(elementLocator);
			break;
		case partialLink:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(elementLocator)));
			element = By.partialLinkText(elementLocator);
			break;
		}
		return element;

	}

	public List<WebElement> webElementsIdentifier(String objectLocator) {
		locatorTypes locator = locatorTypes.valueOf(objectLocator.substring(objectLocator.lastIndexOf("$") + 1));
		String elementLocator = objectLocator.substring(0, objectLocator.lastIndexOf("$"));
		List<WebElement> element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locator) {
		case link:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementLocator)));
			element = driver.findElements(By.linkText(elementLocator));
			break;
		case xpath:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementLocator)));
			element = driver.findElements(By.xpath(elementLocator));
			break;
		case css:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementLocator)));
			element = driver.findElements(By.cssSelector(elementLocator));
			break;
		case id:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementLocator)));
			element = driver.findElements(By.id(elementLocator));
			break;
		case name:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementLocator)));
			element = driver.findElements(By.name(elementLocator));
			break;
		case className:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementLocator)));
			element = driver.findElements(By.className(elementLocator));
			break;
		case tagName:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(elementLocator)));
			element = driver.findElements(By.tagName(elementLocator));
			break;
		case partialLink:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(elementLocator)));
			element = driver.findElements(By.partialLinkText(elementLocator));
			break;
		}
		return element;

	}

	public void switchToDefaultContent() {
		// driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
	}

	public void switchToFrame(String id, String pageData) {
		driver.switchTo().frame(PropertiesCache.getProperty(pageData, id));
	}

	public void quit() {
		driver.quit();
	}

	/*public void goToBaseUrl() {
		if (!driver.getCurrentUrl().equals(baseUrl))
			driver.get(baseUrl);
	}*/

	public void windowScrollDown(String scroll) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + scroll + ")", "");
	}
	public void scrollUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void mouseHover(String header, String selection, String pageData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		Thread.sleep(2000);
		selection = PropertiesCache.getProperty(pageData, selection);
		//webElementIdentifier(selection).click();
		//clickElementUsingJavaScript(selection);
		WebElement element=webElementIdentifier(selection);
		doubleClick(element);
		
	}
	public void mouseHover(String header, String selection,String text, String pageData,String testData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		Thread.sleep(2000);
		selection = PropertiesCache.getProperty(pageData, selection);
		text=PropertiesCache.getProperty(testData, text);
		//webElementIdentifier(selection).click();
		//clickElementUsingJavaScript(selection);
		WebElement element=webElementIdentifier(selection.replace("TEXT", text));
		doubleClick(element);
		
	}
	public void mouseHover(String header, String selection,String text1,String text2, String pageData,String testData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		text1=PropertiesCache.getProperty(testData, text1);
		builder.moveToElement(webElementIdentifier(header.replace("TEXT", text1))).perform();
		Thread.sleep(2000);
		selection = PropertiesCache.getProperty(pageData, selection);
		text2=PropertiesCache.getProperty(testData, text2);
		WebElement element=webElementIdentifier(selection.replace("TEXT", text2));
		doubleClick(element);
		
	}
	public void hoverOver(String elementLocator, String header, String pageData)  {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		sleep(2000);
		
		WebElement element = driver.findElement(webElementByIdentifier(PropertiesCache.getProperty(pageData, elementLocator)));
		click(element);
		sleep(5000);
	}
	public void mouseOver(String header, String text, String pageData, String testData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		if (header.contains("TEXT")) {
			text = PropertiesCache.getProperty(testData, text);
			builder.moveToElement(webElementIdentifier(header.replace("TEXT", text))).build().perform();
		} else {
			builder.moveToElement(webElementIdentifier(header)).build().perform();
		}
		Thread.sleep(2000);
	}

	public void mouseHover(String header, String subHeader, String selection, String pageData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		subHeader = PropertiesCache.getProperty(pageData, subHeader);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		sleep(2000);
		builder.moveToElement(webElementIdentifier(subHeader)).perform();
		sleep(2000);
		selection = PropertiesCache.getProperty(pageData, selection);
		webElementIdentifier(selection).click();
	}

	public void mouseHover(String header, String pageData) throws InterruptedException {
		header = PropertiesCache.getProperty(pageData, header);
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		Thread.sleep(4000);
	}
	public void mouseHover(String header) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(webElementIdentifier(header)).perform();
		Thread.sleep(4000);
	}

	/*public void clickElementUsingJavaScript(String objectLocator, String pageData,String browser) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (browser.equals("CHROME")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator));
		} else {
			webElementIdentifier(objectLocator).click();
		}
	}*/
	public void clickElementUsingJavaScript(String objectLocator, String text,String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if(objectLocator.contains("TEXT")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator.replace("TEXT", text)));
		
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator));
		}
	}
	public void clickElementUsingJavaScript(String objectLocator, String pageData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator));


	}
	public void clickElementUsingJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);

	}
	public void clickElementUsingJavaScript(String objectLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator));
	}

	public void clickElementUsingJavaScript(String objectLocator, String text, String pageData, String testData) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			text = PropertiesCache.getProperty(testData, text);
			js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator.replace("TEXT", text)));
		} else {
			js.executeScript("arguments[0].click();", webElementIdentifier(objectLocator));
		}
	}

	public void clear(String objectLocator, String pageData) {
		webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).clear();
	}
	
	public void clearCharacters(String objectLocator, String pageData)
	{
		 WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
	       int lenText = ele.getAttribute("value").length();
	       for(int i = 0; i < lenText; i++){
	           ele.sendKeys("\u0008");
	       }
	       sleep(2000);
	       ele.sendKeys(Keys.ENTER);
	}

	public void enter() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void escape() throws AWTException {
		/*Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();*/
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public void sendKeysWithEnter(String objectLocator, String value, String pageData, String testData) {
		WebElement element;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		value = PropertiesCache.getProperty(testData, value);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", value));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		element.clear();
		element.sendKeys(value);
		sleep(4000);
		element.sendKeys(Keys.ENTER);
	}

	public void sendKeysWithEnter(String objectLocator, String value, String pageData) {
		WebElement element;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", value));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		sleep(2000);
		element.clear();
		element.sendKeys(value);
		sleep(4000);
		element.sendKeys(Keys.ENTER);
	}
	
	public void sendKeysTAB(String objectLocator, String value, String pageData) {
		WebElement element;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", value));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		sleep(2000);
		element.sendKeys(Keys.TAB);
	}

	public void selectByVisibleText(String objectLocator, String value, String pageData) {
		Select listBox = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
		listBox.selectByVisibleText(value);
	}

	public void sleep(int millSec) {
		try {
			Thread.sleep(millSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToFrameByElement(String objectLocator, String pageData) {
		driver.switchTo().frame(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)));
	}
	public void scrollToElement(String objectLocator,String pageData){
		WebElement textElement = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", textElement);
		sleep(1000);
	}
	
	public void scrollToBottomOfPage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		sleep(1000);
	}
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		sleep(1000);
	}
	public void scrollToElement(String objectLocator,String text,String pageData,String testData){
		WebElement element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text=PropertiesCache.getProperty(testData, text);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", text));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void clickOnActivationLink(String objectLocator, String pageData) {
		Actions action = new Actions(driver);
		action.sendKeys(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)), Keys.TAB).build().perform();
	}
	public void switchToFrameByName(String name,String pageData) {
		driver.switchTo().frame(PropertiesCache.getProperty(pageData, name));
	}
	public void launchUrl(String url, String pageData) {
		url = PropertiesCache.getProperty(pageData, url);
		driver.get(url);
	}

	public String getCurrentDate(String days) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
		Date m = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(m);
		cal.add(Calendar.DATE, Integer.parseInt(days));
		m = cal.getTime();
		return sdf.format(m);
	}
	public String getDate(String date,String days) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(days));
		return sdf.format(cal.getTime());
	}
	public String getTodayDate(String days,String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date m = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(m);
		cal.add(Calendar.DATE, Integer.parseInt(days));
		m = cal.getTime();
		return sdf.format(m);
	}

	public void clickRobot(String element,String pageData) throws AWTException {
		element = PropertiesCache.getProperty(pageData, element);
		Point point = webElementIdentifier(element).getLocation();
		Robot bot = new Robot();
		bot.mouseMove(point.getX(),point.getY()+80);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		sleep(2000);
	}
	
	public void getCoordinates(String element,String pageData,String testData,String xcoordiKey,String ycoordiKey) throws AWTException {
		element = PropertiesCache.getProperty(pageData, element);
		Point point = webElementIdentifier(element).getLocation();
		int xcordi = point.getX();
		Listener.addLogger("Element's Position from left side"+xcordi +" pixels.");
		PropertiesCache.setProperty(testData,xcoordiKey, Integer.toString(xcordi));
		int ycordi = point.getY();
		Listener.addLogger("Element's Position from top"+ycordi +" pixels.");
		PropertiesCache.setProperty(testData,ycoordiKey, Integer.toString(ycordi));
	}
	
	public int getXCoordinate(String element,String pageData,String testData,String xcoordiKey) throws AWTException {
		element = PropertiesCache.getProperty(pageData, element);
		Point point = webElementIdentifier(element).getLocation();
		int xcordi = point.getX();
		Listener.addLogger("Element's Position from left side"+xcordi +" pixels.");
		PropertiesCache.setProperty(testData,xcoordiKey, Integer.toString(xcordi));
		return xcordi;
	}
	
	public int getYCoordinates(String element,String pageData,String testData,String ycoordiKey) throws AWTException {
		element = PropertiesCache.getProperty(pageData, element);
		Point point = webElementIdentifier(element).getLocation();
		int ycordi = point.getY();
		Listener.addLogger("Element's Position from top"+ycordi +" pixels.");
		PropertiesCache.setProperty(testData,ycoordiKey, Integer.toString(ycordi));
		return ycordi;
	}
	public void getCoordinates(String element,String text,String pageData,String testData,String xcoordiKey,String ycoordiKey) throws AWTException {
		element = PropertiesCache.getProperty(pageData, element);
		text=PropertiesCache.getProperty(testData, text);
		Point point = webElementIdentifier(element.replace("TEXT", text)).getLocation();
		int xcordi = point.getX();
		Listener.addLogger("Element's Position from left side"+xcordi +" pixels.");
		PropertiesCache.setProperty(testData,xcoordiKey, Integer.toString(xcordi));
		int ycordi = point.getY();
		Listener.addLogger("Element's Position from top"+ycordi +" pixels.");
		PropertiesCache.setProperty(testData,ycoordiKey, Integer.toString(ycordi));
	}
	
	public void scrollToElement(String objectLocator,String text,String pageData){
		WebElement element;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", text));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void dragAndDrop(String element1,String element2,String text,String pageData) {
		sleep(2000);
		element1 = PropertiesCache.getProperty(pageData, element1);
		element2 = PropertiesCache.getProperty(pageData, element2);
		Actions act=new Actions(driver);	
		if(element1.contains("TEXT")) {
		act.dragAndDrop(webElementIdentifier(element1.replace("TEXT", text)), webElementIdentifier(element2)).build().perform();
		}else {
		act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
		}
		sleep(2000);
	}
	
	public void moveToElementDragAndDrop(String element1,String element2,String text,String pageData,String testData) {
		sleep(2000);
		element1 = PropertiesCache.getProperty(pageData, element1);
		element2 = PropertiesCache.getProperty(pageData, element2);
		Actions act=new Actions(driver);
		act.moveToElement(webElementIdentifier(element1.replace("TEXT", text))).clickAndHold().dragAndDrop(webElementIdentifier(element1.replace("TEXT", text)), webElementIdentifier(element2)).build().perform();
		if(element1.contains("TEXT")) {
		act.dragAndDrop(webElementIdentifier(element1.replace("TEXT", text)), webElementIdentifier(element2)).build().perform();
		}else {
		act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
		}
		sleep(2000);
	}

	public void dragAndDrop(String element1,String element2,String text,String pageData,String testData) {
		sleep(2000);
		element1 = PropertiesCache.getProperty(pageData, element1);
		element2 = PropertiesCache.getProperty(pageData, element2);
		Actions act=new Actions(driver);	
		if(element1.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			act.dragAndDrop(webElementIdentifier(element1.replace("TEXT", text)), webElementIdentifier(element2)).build().perform();
		}else {
			act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
		}
		sleep(2000);
	}
	public void dragAndDrop(String element1,String element2,String text1,String text2,String pageData,String testData) {
		sleep(2000);
		element1 = PropertiesCache.getProperty(pageData, element1);
		element2 = PropertiesCache.getProperty(pageData, element2);
		text1=PropertiesCache.getProperty(testData, text1);
		text2=PropertiesCache.getProperty(testData, text2);
		Actions act=new Actions(driver);	
		if(element1.contains("TEXT")) {
			if(element2.contains("TEXT")) {
				sleep(1000);
				act.dragAndDrop(webElementIdentifier(element1.replace("TEXT", text1)), webElementIdentifier(element2.replace("TEXT", text2))).build().perform();
			}else {
				act.dragAndDrop(webElementIdentifier(element1.replace("TEXT", text1)), webElementIdentifier(element2)).build().perform();
			}
		}else {
		act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
		}
		sleep(2000);
	}
	
	public void dragAndDropToFrames(String element1,String element2,String frameElement,String pageData) {
		driver.switchTo().defaultContent();
		sleep(2000);
        Actions builder = new Actions(driver);
        WebElement element=webElementIdentifier(element1);
        builder.clickAndHold(element).perform();
        clickOnButton(pageData,"Customization_Email_Template_Wizard_Text_Icon",PlutoraConfiguration.objectData);
        sleep(2000);
        switchToFrameByElement(frameElement, pageData);
        sleep(2000);
        WebElement elements=webElementIdentifier(element2);
        builder.moveToElement(elements).pause(2000).release(elements).doubleClick(elements).build().perform();
        sleep(2000);
        doubleClick(elements);
        sleep(3000);
	}
	
	public void dragAndDropWithClickAndHold(String element1,String element2,String text,String pageData,String testData,int xOffset, int yOffset) {
        sleep(2000);
        element1 = PropertiesCache.getProperty(pageData, element1);
        element2 = PropertiesCache.getProperty(pageData, element2);
        Actions act=new Actions(driver);
        if(element1.contains("TEXT")) {
        text=PropertiesCache.getProperty(testData, text);
        act.moveToElement(webElementIdentifier(element1.replace("TEXT", text)),100,5).clickAndHold().moveToElement(webElementIdentifier(element2),200,yOffset).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
        sleep(4000);
        }else {
        	sleep(4000);
        	act.moveToElement(webElementIdentifier(element1),100,5).clickAndHold().moveToElement(webElementIdentifier(element2),0,yOffset).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
        }
        sleep(1000);
    }
	
	public void dragAndDropWithClickAndHold(String element1,String element2,String text1,String text2,String pageData,String testData,int xOffset, int yOffset) {
        sleep(2000);
        element1 = PropertiesCache.getProperty(pageData, element1);
        element2 = PropertiesCache.getProperty(pageData, element2);
        Actions act=new Actions(driver);
        if(element1.contains("TEXT")) {
        text1=PropertiesCache.getProperty(testData, text1);
        text2=PropertiesCache.getProperty(testData, text2);
        act.moveToElement(webElementIdentifier(element1.replace("TEXT", text1)),100,5).clickAndHold().moveToElement(webElementIdentifier(element2.replace("TEXT", text2)),200,yOffset).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
        sleep(4000);
        }else {
        	sleep(4000);
        	act.moveToElement(webElementIdentifier(element1),100,5).clickAndHold().moveToElement(webElementIdentifier(element2),0,yOffset).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
        }
        sleep(1000);
    }
	public void tabout(String objectLocator,String text,String pageData,String testData){
		WebElement element;
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		text=PropertiesCache.getProperty(testData, text);
		if (objectLocator.contains("TEXT")) {
			element = webElementIdentifier(objectLocator.replace("TEXT", text));
		} else {
			element = webElementIdentifier(objectLocator);
		}
		element.sendKeys(Keys.TAB);
		sleep(4000);
	}
	
	public void tabout(String element,String pageData) {
		element = PropertiesCache.getProperty(pageData, element);
		webElementIdentifier(element).sendKeys(Keys.TAB);
		sleep(2000);

	}
	
	
	public void deleteSingleCharacter(String element,String pageData) {
		webElementIdentifier(PropertiesCache.getProperty(pageData, element)).sendKeys("\u0008");
	}
	public String getDateByString(String stringDate,String format,String days) throws ParseException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		c.setTime(sdf.parse(stringDate));
		c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(days));  
		return  sdf.format(c.getTime());
	}
	public String convertDateString(String stringDate,String oldFormat, String newFormat) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat(oldFormat);
		//Calendar c = Calendar.getInstance();
		Date d = sdf.parse(stringDate);
		String sdf1 = new SimpleDateFormat(newFormat).format(d);
		//c.setTime(sdf.parse(stringDate));
		return sdf1;
	}
	public void dragAndDropByOffset(String element,String text,String pageData,String testData,String xOffset,String yOffset) {
		Actions action = new Actions(driver);
		element=PropertiesCache.getProperty(pageData, element);
		text=PropertiesCache.getProperty(testData, text);
	    action.dragAndDropBy(webElementIdentifier(element.replace("TEXT", text)), Integer.parseInt(xOffset), Integer.parseInt(yOffset)).build().perform();
	    sleep(2000);
	}
	public void dragAndDropByOffset(String element,String pageData,String xOffset,String yOffset) {
		Actions action = new Actions(driver);
		element=PropertiesCache.getProperty(pageData, element);
	    action.dragAndDropBy(webElementIdentifier(element), Integer.parseInt(xOffset), Integer.parseInt(yOffset)).build().perform();
	    sleep(2000);
	}
	
	public void moveByOffset(int xoffset,int yoffset) {
		Actions action = new Actions(driver);
		action.moveByOffset(xoffset, yoffset).release();
	    sleep(2000);
	}
	public void clickOnButton(String data,String element,String objectData) {
		clickElementUsingJavaScript(element,data);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
	}

	public void clickOnButton(String data,String element) {
        clickElementUsingJavaScript(element,data);
        sleep(1000);
    }

	public void clickWebElementButton(String data,String element,String objectData) {
		click(element,data);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(1000);
	}

	public void clickButton(String element,String text,String pageData,String testData,String objectData) {
		element=PropertiesCache.getProperty(pageData, element);
		text=PropertiesCache.getProperty(testData, text);
		clickElementUsingJavaScript(element.replace("TEXT", text));
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void sendKeys(String element,String text,String pageData,String testData,String objectData) {
		element=PropertiesCache.getProperty(pageData, element);
		if(element.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			webElementIdentifier(element.replace("TEXT", text)).clear();
			webElementIdentifier(element.replace("TEXT", text)).sendKeys(text);
		}else {
			text=PropertiesCache.getProperty(testData, text);
			webElementIdentifier(element).sendKeys(text);
		}
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
	}
	public void clickOnButton(String data,String element,String element1,String objectData,String locatorName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(PropertiesCache.getProperty(data, element)));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element)));
        		break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorName) {
        	case "xpath":
        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(PropertiesCache.getProperty(data, element1))));
        		break;
        	case "css":
        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element1))));
        		break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
        sleep(1000);
	}
	public void clickOnButton(String data,String element,String element1,String objectData) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element=PropertiesCache.getProperty(data, element);
		element1=PropertiesCache.getProperty(data, element1);
		locatorTypes locatorName = locatorTypes.valueOf(element.substring(element.lastIndexOf("$") + 1));
		element = element.substring(0, element.lastIndexOf("$"));
		locatorTypes locatorNameOne = locatorTypes.valueOf(element1.substring(element1.lastIndexOf("$") + 1));
		element1 = element1.substring(0, element1.lastIndexOf("$"));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
        try {  
        	
        	switch(locatorName) {
        	case xpath:
        		driver.findElement(By.xpath(element));
        		break;
        	case css:
        		driver.findElement(By.cssSelector(element));
        		break;
			default:
				break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorNameOne) {
        	case xpath:
        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
        		break;
        	case css:
        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
        		break;
			default:
				break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }    
        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
        sleep(1000);
	}
	public void clickWebElementButton(String data,String element,String element1,String objectData) {
		element=PropertiesCache.getProperty(data, element);
		element1=PropertiesCache.getProperty(data, element1);
		locatorTypes locatorName = locatorTypes.valueOf(element.substring(element.lastIndexOf("$") + 1));
		element = element.substring(0, element.lastIndexOf("$"));
		locatorTypes locatorNameOne = locatorTypes.valueOf(element1.substring(element1.lastIndexOf("$") + 1));
		element1 = element1.substring(0, element1.lastIndexOf("$"));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
        try {  
        	
        	switch(locatorName) {
        	case xpath:
        		driver.findElement(By.xpath(element));
        		break;
        	case css:
        		driver.findElement(By.cssSelector(element));
        		break;
			default:
				break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorNameOne) {
        	case xpath:
        		driver.findElement(By.xpath(element1)).click();
        		break;
        	case css:
        		driver.findElement(By.cssSelector(element1)).click();
        		break;
			default:
				break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
        sleep(1000);
	}
	
	
	public void clickWebelementButton(String data,String element,String elementOne,String objectData,String locatorName)  {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
        	
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(PropertiesCache.getProperty(data, element)));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element)));
        		break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorName) {
        	case "xpath":
        		 driver.findElement(By.xpath(PropertiesCache.getProperty(data, elementOne))).click();
        		 sleep(1000);
        		break;
        	case "css":
        		 driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, elementOne))).click();
        		 sleep(1000);
        		break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
        sleep(1000);
	}
	public void dragAndDrop(String element1,String element2,String pageData) {
		sleep(2000);
		element1 = PropertiesCache.getProperty(pageData, element1);
		element2 = PropertiesCache.getProperty(pageData, element2);
		Actions act=new Actions(driver);	
		act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
		sleep(2000);
	}
	public void refresh(String objectData) {
		driver.navigate().refresh();
		WebGenericUtilLib.driver.get(PlutoraConfiguration.applicationURL);
		waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
		sleep(1000);
	}
	
	public void refresh(String objectData,String url,String objectLocator ) {
		driver.navigate().refresh();
		waitForLoadingIconDisappear(500,objectLocator,objectData);
		sleep(1000);
	}
	public void refreshPage(String objectData){
		driver.navigate().refresh();
		waitForLoadingIconDisappear("Loading_Gif",objectData);
		sleep(1000);
	}
	public int selectMultipleButton(String pageData,String element1 ) {
		int count=0;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
		element1=PropertiesCache.getProperty(pageData, element1);
		List<WebElement> elements=webElementsIdentifier(element1);
		for(int i=0;i<elements.size();i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			scrollToElement(elements.get(i));
			sleep(1000);
			js.executeScript("arguments[0].click();", elements.get(i));
			sleep(1000);
		}
		 count=elements.size();
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		return count;
	}
	public int selectMultipleDoubleButton(String pageData,String element1 ) {
		element1=PropertiesCache.getProperty(pageData, element1);
		List<WebElement> elements=webElementsIdentifier(element1);
		for(int i=0;i<5;i++) {
			elements=webElementsIdentifier(element1);
			sleep(2000);
			scrollToElement(elements.get(i));
			sleep(2000);
			doubleClick(elements.get(i));
			sleep(2000);
		}
		return elements.size();
	}
	public String removeQuotes(String myString){
		return myString.substring(1, myString.length()-1);
	}
	public String toHex(int r, int g, int b) {
	    return toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
	  }
	private  String toBrowserHexValue(int number) {
	    StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
	    while (builder.length() < 2) {
	      builder.append("0");
	    }
	    return builder.toString().toUpperCase();
	  }
	public int getCountOfWeekDays(String date1,String date2,String format) throws ParseException {
		Date startDate=new SimpleDateFormat(format).parse(date1);
		Date endDate=new SimpleDateFormat(format).parse(date2);
		
		Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        
	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);
	    int workDays = 0;
	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	    	workDays=0;
	    }

	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }
	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date
	    
	   return workDays;
	
	}
	public String getSelectedOptionFromSelectDropdown(String objectLocator,String pageData) {
		Select select = new Select(webElementIdentifier(PropertiesCache.getProperty(pageData,objectLocator)));
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}
	public void clickOnButton(String element,String element1,String text,String pageData,String testData,String objectData,String locatorName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		text=PropertiesCache.getProperty(testData, text);
		element=PropertiesCache.getProperty(pageData, element).replace("TEXT", text);
		element1=PropertiesCache.getProperty(pageData, element1).replace("TEXT", text);
        try {  
        	
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element));
        		break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorName) {
        	case "xpath":
        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
        		break;
        	case "css":
        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
        		break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void clickOnButton(String element,String element1,String text,String pageData,String objectData,String locatorName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		element=PropertiesCache.getProperty(pageData, element).replace("TEXT", text);
		element1=PropertiesCache.getProperty(pageData, element1).replace("TEXT", text);
        try {  
        	
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element));
        		break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorName) {
        	case "xpath":
        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
        		break;
        	case "css":
        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
        		break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	public void clickWebelementButton(String element,String element1,String text,String pageData,String objectData,String locatorName) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		element=PropertiesCache.getProperty(pageData, element).replace("TEXT", text);
		element1=PropertiesCache.getProperty(pageData, element1).replace("TEXT", text);
        try {  
        	
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element));
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element));
        		break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorName) {
        	case "xpath":
        		driver.findElement(By.xpath(element1)).click();
        		sleep(2000);
        		break;
        	case "css":
        		driver.findElement(By.cssSelector(element1)).click();
        		sleep(2000);
        		break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear("Loading_Gif",objectData);
	}
	
	
	public void doubleClickOnHold(String objectLocator,String pageData) {
		objectLocator=PropertiesCache.getProperty(pageData, objectLocator);
		WebElement element=webElementIdentifier(objectLocator);
		int width = element.getSize().getWidth();
		 Actions act = new Actions(driver);
		act.moveToElement(element).clickAndHold(element).moveByOffset((width/2)-2, 0).doubleClick().perform();
		sleep(2000);
	}
	public void clickOnHold(String objectLocator,String pageData) {
		objectLocator=PropertiesCache.getProperty(pageData, objectLocator);
		WebElement element=webElementIdentifier(objectLocator);
		int width = element.getSize().getWidth();
		 Actions act = new Actions(driver);
		act.moveToElement(element).clickAndHold(element).moveByOffset((width/2)-2, 0).click().perform();
		sleep(2000);
	}
	
	public String getDecimalValue(String pattern,double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern,DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	    return myFormatter.format(value);
	}
	public String getLocaleValue(String pattern,double value,Locale loc) {
		NumberFormat nf = NumberFormat.getNumberInstance(loc);
	    DecimalFormat df = (DecimalFormat)nf;
	    df.applyPattern(pattern);
	    return df.format(value);
	}
	public void scrollRight(String objectLocator) {
		 /*Actions move = new Actions(driver);
         move.moveToElement(webElementIdentifier(objectLocator)).clickAndHold();
         move.moveByOffset(125,0);
         move.release();
         move.perform();*/
         JavascriptExecutor js = (JavascriptExecutor)driver; 
         js.executeScript(
             "window.scrollBy(2000,0)");
		/*WebElement element = webElementIdentifier(objectLocator);
         while (i < 50)
         {
        	 element.sendKeys(Keys.ARROW_RIGHT);
        	 System.out.println(i);
             ++i;
         }*/
         
	}
	
	  public void scrollDown(String objectLocator,String pageData) { 
		  objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
	      WebElement ele = webElementIdentifier(objectLocator);
	      ele.sendKeys(Keys.ARROW_DOWN);
	    }
	  public void scrollDown(WebElement element) { 
		  element.sendKeys(Keys.ARROW_DOWN);
	    }
	public void moveAndClickElement(String element,String text,String pageData,String testData) {
		Actions actions = new Actions(driver);
		element=PropertiesCache.getProperty(pageData, element);
		if(element.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			actions.moveToElement(webElementIdentifier(element.replace("TEXT", text))).click().perform();
		}else {
			actions.moveToElement(webElementIdentifier(element)).click().perform();
		}
		
	}
	
	public void moveToElement(String element,String text,String pageData,String testData) {
		Actions actions = new Actions(driver);
		element=PropertiesCache.getProperty(pageData, element);
		if(element.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			actions.moveToElement(webElementIdentifier(element.replace("TEXT", text))).build().perform();
		}else {
			actions.moveToElement(webElementIdentifier(element)).build().perform();
		}
		
	}
	public void clickOnPositionOfElement(String objectLocator,String pageData,int x,int y) {
		Actions builder = new Actions(driver);
		sleep(2000);
		builder.moveToElement(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator))).moveByOffset(x, y).doubleClick().build().perform();
		sleep(2000);
	}
	public boolean handlePopupErrors(String objectLocator, String testData) {
		boolean flag = false;

		flag = driver.getPageSource().contains(PropertiesCache.getProperty(testData, objectLocator));

		if (flag) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public void handle_toast_popup(String errorMsg, String testData, String objectData) {

		if (handlePopupErrors(errorMsg,testData)) {
			closeToastMessages("ToastMsg_List","ToastMsg_CloseIcon", objectData);
		}
	}
	public void closeToastMessages(String objectLocator, String objectLocator1, String pageData) {
		try {
			List<WebElement> elements;
			WebElement element;
			objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
			objectLocator1 = PropertiesCache.getProperty(pageData, objectLocator1);
			elements = webElementsIdentifier(objectLocator);
			int toaste_msg_count = elements.size();

			while (toaste_msg_count!=0) {
				element = webElementIdentifier(objectLocator1);
				element.click();
				sleep(1000);
				toaste_msg_count--;
			}

		} catch(Exception e) {
			System.err.println("Not found any toaster messages");
		}
	}
	public void clickUsingAction(String objectLocator,String pageData){
		Actions actions = new Actions(driver); 
		actions.moveToElement(webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator))).click().perform(); 
	}
	public String getAttributeDataValue(String objectLocator, String pageData) {
		String value = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).getAttribute("value");
		return value;
	}

	public void clickElementButton(String data,String element,String element1,String text,String testData,String objectData) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		text=PropertiesCache.getProperty(testData, text);
		element=PropertiesCache.getProperty(data, element).replace("TEXT",text);
		element1=PropertiesCache.getProperty(data, element1).replace("TEXT",text);
		locatorTypes locatorName = locatorTypes.valueOf(element.substring(element.lastIndexOf("$") + 1));
		element = element.substring(0, element.lastIndexOf("$"));
		locatorTypes locatorNameOne = locatorTypes.valueOf(element1.substring(element1.lastIndexOf("$") + 1));
		element1 = element1.substring(0, element1.lastIndexOf("$"));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		
        try {  
        	
        	switch(locatorName) {
        	case xpath:
        		driver.findElement(By.xpath(element));
        		break;
        	case css:
        		driver.findElement(By.cssSelector(element));
        		break;
			default:
				break;
        	}
			
        } catch (Exception e) {  
        	switch(locatorNameOne) {
        	case xpath:
        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
        		break;
        	case css:
        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
        		break;
			default:
				break;
        	}
        } 
      finally {  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
       }  
        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
        sleep(1000);
	}

	/**************************************Business Keywords************************************************************/
	public String setDuplicateName(String copyName,String actualName,String expectedName,String testData){
		String tecrCopyName=copyName+PropertiesCache.getProperty(testData, actualName);
		return PropertiesCache.setProperty(testData,expectedName, tecrCopyName);
	}

	public String setDuplicateName(String copyName,String actualName,String expectedName,String testData,String end){
		String tecrCopyName=PropertiesCache.getProperty(testData, actualName)+copyName;
		return PropertiesCache.setProperty(testData,expectedName, tecrCopyName);
	}

	public String userFullName(String firstName, String LastName, String testData) {
		firstName = PropertiesCache.getProperty(testData, firstName);
		LastName = PropertiesCache.getProperty(testData, LastName);
		return firstName+" "+LastName;
	}
	public void applicationDatePicker(String pageData,String testData,String datePicker,String dateString) throws ParseException {

		String dateSelect[] = dateString.split("-");
		String ED = dateSelect[0];
		String EM = dateSelect[1];
		String EY = dateSelect[2];
		System.out.println(ED + EM + EY);
		if(ED.startsWith("0")) {
			ED=ED.replace("0", "");
		}
		sleep(2000);
		WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, datePicker));
	    if(!element.getText().split(" ")[1].equals(EY)){
	    	//element.click();
	    	clickElementUsingJavaScript(element);
	    	sleep(2000);
	    	driver.findElement(By.xpath("//a[text()='"+EY+"']")).click();
	    	sleep(1000);
	    	System.out.println(EM.substring(0, 3));
	    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
	    	sleep(2000);
	    	driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
	    	sleep(2000);
	    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@id,'datepicker')]/div[@data-ref='innerEl']//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
	    	sleep(1000);
	    }else if(element.getText().split(" ")[1].equals(EY)){
	    	if(!element.getText().split(" ")[0].equals(EM)){
	    		sleep(2000);
	    		clickElementUsingJavaScript(element);
	    		sleep(2000);
		    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
		    	sleep(3000);
		    	driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
		    	sleep(3000);
		    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
		    	sleep(1000);
	    	}else{
	    		sleep(2000);
	    		WebElement element1=driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']"));
	    		scrollToElement(element1);
	    		sleep(1000);
	    		clickElementUsingJavaScript(element1);
	    		sleep(2000);
	    	}
	    }
	   
	}
	
	public String getAttributeBackgroundColorValue(String pageData,String elementId) throws InterruptedException{
		sleep(1000);
		String color = getCSSValue(elementId,pageData,"background-color");
		System.out.println("color: "+color);
		return color;
	}

	
	public String convertToUpperCaseAfterFirstIndex(String convertString) {
		return convertString.substring(0).toUpperCase();
	}
	public String formatDateField(String date) {
		if(date.startsWith("0")) {
			date=date.substring(1);
		}
		return date;
	}
	
	public int getWebElementCount(String objectLocator,String text,String pageData,String testData) {
		objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
		if (objectLocator.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			return webElementsIdentifier(objectLocator.replace("TEXT",text)).size();
		} else {
			return webElementsIdentifier(objectLocator).size();
		}
	}
	public String formatDateOneFormateToOtherFormate(String formate1Date,String foramate1,String formate2) throws ParseException {
		DateFormat originalFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm",Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String formattedDate = targetFormat.format( originalFormat.parse(formate1Date));
		return formattedDate;
	}
	public void clickElement(String objectLocator,String pageData) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
			element.isDisplayed();
			element.click();
			sleep(1000);
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	}
	public void clickMultipleElement(String objectLocator,String pageData,String objectData) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			sleep(1000);
			List<WebElement> elements=webElementsIdentifier(PropertiesCache.getProperty(pageData, objectLocator));
			for(WebElement element:elements) {
				element.isDisplayed();
				element.click();
				sleep(1000);
				waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
			}
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	}
	public void uploadImageByName(String identifier) throws InterruptedException, IOException {
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		WebElement uploadFile = driver.findElement(By.name(identifier));
		uploadFile.sendKeys(src.toString());
		Listener.addLogger(src.getName());
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "File_Name",src.toString());
		PropertiesCache.setProperty(PlutoraConfiguration.testData, "File_Name_Text",src.getName());
		sleep(3000);
		src.delete();
		
	}
	public void uploadImageByXpath(String objectLocator,String pagedata) throws InterruptedException, IOException {
		TakesScreenshot ts = (TakesScreenshot) WebGenericUtilLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		driver.findElement(By.xpath(PropertiesCache.getProperty(pagedata,objectLocator))).sendKeys(src.toString());
		Listener.addLogger(src.getName());
		PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "File_Name",src.toString());
		PropertiesCache.setProperty(PlutoraTestConfiguration.testData, "File_Name_Text",src.getName());
		sleep(3000);
		src.delete();
		
	}
	
	
	public void selectionQueryBuilder(String testData,String objectData,String columnId,String condition,String index) {
		sleep(3000);
		clickElementUsingJavaScript("QueryBuilder_Column_Table_Dropdown",index,objectData);
		sleep(2000);
		scrollToElement("QueryBuilder_Column_Table_Dropdown_Option",columnId,objectData);
		clickElementUsingJavaScript("QueryBuilder_Column_Table_Dropdown_Option",columnId,objectData);
		sleep(2000);
		clickElementUsingJavaScript("QueryBuilder_Condition_Table_Dropdown_Option",condition,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
	public void saveAndRunQuery(String testData,String objectData,String query,String queryName) {
		clickOnButton(objectData, "QueryBuilder_SaveQuery_Button", objectData);
		sleep(1000);
		clickOnButton(objectData, "QueryBuilder_Parent_Dropdown", objectData);
		click("QueryBuilder_Parent_Dropdown_Option",query,objectData);
		sleep(1000);
		sendKeys("QueryBuilder_Filter_Textbox",PropertiesCache.setProperty(testData, queryName),objectData);
		sleep(1000);
		clickOnButton(objectData, "QueryBuilder_Save&Close_Button", objectData);
		clickOnButton(objectData, "QueryBuilder_Run_Button", objectData);
	}
	public void saveAndRunPIRQuery(String testData,String objectData,String query,String queryName) {
		clickOnButton(objectData, "QueryBuilder_SaveQuery_Button", objectData);
		
		clickOnButton(objectData, "QueryBuilder_Parent_Dropdown", objectData);
		click("QueryBuilder_Parent_Dropdown_Option",query,objectData);
		sendKeys("QueryBuilder_Filter_Textbox",PropertiesCache.setProperty(testData, queryName),objectData);
		clickOnButton(objectData, "PIRQueryBuilder_Save&Close_Button", objectData);
		clickOnButton(objectData, "QueryBuilder_Run_Button", objectData);
	}
	
	public void clickQueryBuilderOption(String testData,String objectData,String queryName) {
		clickOnPositionOfElement("QueryBuilder_Dropdown", objectData,10,0);
		clickButton("QueryBuilder_Dropdown_Option",queryName,objectData,testData,objectData);
	}
	public void clickQueryBuilderClearOption(String objectData) {
		clickOnPositionOfElement("QueryBuilder_Dropdown", objectData,10,0);
		clickOnButton(objectData,"QueryBuilder_ClearQuery_Option",objectData);
	}
	
	public void clickNewQueryBuilder(String objectData) {
		clickOnButton(objectData, "QueryBuilder_Icon", objectData);
		clickOnButton(objectData, "QueryBuilder_New_Button", objectData);
	}
	
	public void clickReactNewQueryBuilder(String objectData) {
		clickOnButton(objectData, "React_QueryBuilder_Icon", objectData);
		clickOnButton(objectData, "QueryBuilder_New_Button", objectData);
		sleep(4000);
	}
		
	/*public void addIdQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sleep(4000);
		//Modified Send Keys method to not send null data in the query value column
		sendKeysWithoutClear("QueryBuilder_Value_Textbox", value, objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		
	}*/
	public void addIdQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sleep(4000);
		sendKeys("QueryBuilder_Value_Textbox", value,objectData,testData,objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		

	}

	public void addEmailQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sendKeys("QueryBuilder_Value_Textbox", value,objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		
	}
	
	public void addChangeIdQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sendKeys("QueryBuilder_ChangeId_Textbox", value,objectData,testData,objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		
	}
	
	public void addNameQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index ) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		sendKeys("QueryBuilder_NameValue_Textbox", value,objectData,testData,objectData);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
		
	}
	
	public void addStatusQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index,String statusIndex) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		clickElementUsingJavaScript("QueryBuilder_Condition_Table_Dropdown_Option",value,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);

		sleep(2000);
		doubleClick("BuildUpYourQuery_Text",objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);

	}
	public void addOrganizationQueryBuilder(String testData,String objectData,String columnId,String condition,String value,String index,String statusIndex) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		clickElementUsingJavaScript("QueryBuilder_Condition_Table_Dropdown_Option_One",value,objectData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
		sleep(2000);
		doubleClick("BuildUpYourQuery_Text",objectData);
		
	}
	public void addCalendarQueryBuilder(String testData,String objectData,String columnId,String condition,String index) {
		selectionQueryBuilder(testData, objectData, columnId, condition,index);
		clickElementUsingJavaScript("Additional_information_DatePicker_Today_Button",objectData);
		sleep(1000);
		doubleClick("BuildUpYourQuery_Text",objectData);
		sleep(4000);
	}
	public void addCondition(String objectData,String columnId,String index ) {
		click("QueryBuilder_Condition_Dropdown",index,objectData);
		scrollToElement("QueryBuilder_Condition_Dropdown_Option",columnId,objectData);
		clickElementUsingJavaScript("QueryBuilder_Condition_Dropdown_Option",columnId,objectData);
		sleep(2000);
	}
	
	public void addGridColumnSelector(String testData,String objectData,String customfieldName,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
		dragAndDrop("Action_GridColumnSelector_Available_CustomField_Text", "Action_GridColumnSelector_Selected_Column_Selection", customfieldName,objectData,testData);
		clickOnButton(objectData, "Action_GridColumnSelector_Save_Button", objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Save&Close_Button", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customfieldName)+" added in grid column selector successfully !");
	}

	public void clearGridColumnSelector(String objectData,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Clear_Button", objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Save&Close_Button", objectData);
		Listener.addLogger("Performed clear button action in grid column selector successfully !");
	}
	
	public void addPIRGridColumnSelector(String testData,String objectData,String customfieldName,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
		dragAndDrop("Action_GridColumnSelector_Available_CustomField_Text", "Action_GridColumnSelector_Selected_Column_Selection", customfieldName,objectData,testData);
		clickOnButton(objectData, "Action_PIRGridColumnSelector_Save_Button", objectData);
		clickOnButton(objectData, "Action_PIRGridColumnSelector_Save&Close_Button", objectData);
		Listener.addLogger(PropertiesCache.getProperty(testData, customfieldName)+" added in grid column selector successfully !");
	}

	public void clearPIRGridColumnSelector(String objectData,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Clear_Button", objectData);
		clickOnButton(objectData, "Action_PIRGridColumnSelector_Save&Close_Button", objectData);
		Listener.addLogger("Performed clear button action in grid column selector successfully !");
	}
	public void closeGridColumnSelectorPopup(String objectData,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
		clickOnButton(objectData, "Action_GridColumnSelector_Close_Button", objectData);
		Listener.addLogger("Performed close icon action in grid column selector successfully !");
	}
	public void clearGridColumnFiltering(String objectData,String actionButton) {
		clickOnButton(objectData, actionButton, objectData);
		clickOnButton(objectData, "Action_Clear_GridColumnFiltering_Option", objectData);
		Listener.addLogger("Performed clear button action in grid column filtering successfully !");
	}

	 public void addComments(String pageData,String testData,String objectData,String comments,String tab) {
		 clickOnButton(pageData,tab,objectData);
		 sendKeys("Comments_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Send_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" added successfully !");
	 }
	 public void editComments(String pageData,String testData,String objectData,String comments,String tab) {
		 clickOnButton(pageData,tab,objectData);
		 clickOnButton(objectData,"Comments_Edit_Link",objectData);
		 sendKeys("Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Update_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" updated successfully !");
	 }
	 public void replyComments(String pageData,String testData,String objectData,String comments,String tab) {
		 clickOnButton(pageData,tab,objectData);
		 clickOnButton(objectData,"Comments_Reply_Link",objectData);
		 
		 clickOnButton(objectData,"Comments_Cancel_Button",objectData);
		
		 clickOnButton(objectData,"Comments_Reply_Link",objectData);
		 sendKeys("Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"Comments_Reply_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" replyed successfully !");
	 }
	 public void deleteComments(String pageData,String testData,String objectData,String activityTab) {
		 clickOnButton(pageData,activityTab,objectData);
		 clickOnButton(objectData,"Comments_Delete_Link",objectData);
		 clickOnButton(objectData,"Comments_Yes_Button",objectData);
	 }

	 public FileInputStream loadPropertiesPath(String fileName,String application) throws FileNotFoundException {
			StringBuilder filenameElementProperties = new StringBuilder();
			filenameElementProperties.append("src").append(File.separator);
			filenameElementProperties.append("test").append(File.separator);
			filenameElementProperties.append("java").append(File.separator);
			filenameElementProperties.append("com").append(File.separator);
			filenameElementProperties.append(application).append(File.separator);
			filenameElementProperties.append("locator").append(File.separator);
			filenameElementProperties.append("properties").append(File.separator);
			filenameElementProperties.append(fileName);
			FileInputStream fileObject = new FileInputStream(
					System.getProperty("user.dir") + File.separator + filenameElementProperties.toString());
			return fileObject;
		 }

	 public void deletePublicQuery(String objectData,String testData,String text) {
		clickOnButton(objectData, "QueryBuilder_Icon", objectData);
		 clickButton("QueryBuilder_Query_Text", text, objectData, testData, objectData);
		 clickOnButton(objectData, "QueryBuilder_DeleteSavedQuery_Button", objectData);
		 clickOnButton(objectData,"QueryBuilder_Yes_Button",objectData);
	 }
	 public void deletePrivateQuery(String objectData,String testData,String text) {
		 clickButton("QueryBuilder_Query_Text", text, objectData, testData, objectData);
		 clickOnButton(objectData, "QueryBuilder_DeleteSavedQuery_Button", objectData);
	 }
	
	 public void addGridColumnSelector(String pageData,String testData,String objectData,String customfieldName,String actionButton) {
			clickOnButton(pageData, actionButton, objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
			dragAndDrop("Action_GridColumnSelector_Available_CustomField_Text", "Action_GridColumnSelector_Selected_Column_Selection", customfieldName,objectData,testData);
			clickOnButton(objectData, "Action_GridColumnSelector_Save_Button", objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Save&Close_Button", objectData);
			Listener.addLogger(PropertiesCache.getProperty(testData, customfieldName)+" added in grid column selector successfully !");
		}

		public void clearGridColumnSelector(String pageData,String objectData,String actionButton) {
			clickOnButton(pageData, actionButton, objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Clear_Button", objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Save&Close_Button", objectData);
			Listener.addLogger("Performed clear button action in grid column selector successfully !");
		}
		public void closeGridColumnSelectorPopup(String PageData,String objectData,String actionButton) {
			clickOnButton(PageData, actionButton, objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Option", objectData);
			clickOnButton(objectData, "Action_GridColumnSelector_Close_Button", objectData);
			Listener.addLogger("Performed close icon action in grid column selector successfully !");
		}
		public void clearGridColumnFiltering(String pageData,String objectData,String actionButton) {
			clickOnButton(pageData, actionButton, objectData);
			clickOnButton(objectData, "Action_Clear_GridColumnFiltering_Option", objectData);
			Listener.addLogger("Performed clear button action in grid column filtering successfully !");
		}
		public void clickQueryBuilderOption(String testData,String objectData,String queryName,String dropdown) {
			clickOnPositionOfElement(dropdown, objectData,10,0);
			clickButton("QueryBuilder_Dropdown_Option",queryName,objectData,testData,objectData);
		}
		public void clickQueryBuilderClearOption(String objectData,String dropdown) {
			clickOnPositionOfElement(dropdown, objectData,10,0);
			clickOnButton(objectData,"QueryBuilder_ClearQuery_Option",objectData);
		}
		
		public void clickNewQueryBuilder(String objectData,String icon) {
			clickOnButton(objectData, icon, objectData);
			clickOnButton(objectData, "QueryBuilder_New_Button", objectData);

		}
		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}
		
		public String getPageTitle() {
			return driver.getTitle();
		}
		
		public void closeWindowTab() {
			String strFirstWindowHandle = driver.getWindowHandle();
			Set<String> setWindowHandles = driver.getWindowHandles();
			//Iterating over all windows handles
			for(String strWindowHandle: setWindowHandles){
				//If the window handle is not same as the one stored before opening up second window, it is the new window
				if(strWindowHandle.equals(strFirstWindowHandle)){
					//Switch to the new window
					driver.switchTo().window(strWindowHandle);
			        //Close this browser window
			        driver.close();
					//Exit from loop
					break;
				}
			}
		}

	public void clearChromeBrowserCache() {
		driver.get("chrome://settings/clearBrowserData");
		sleep(5000);
		switchToWindowPopup();
		sleep(1000);
		clickElementUsingJavaScript(driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")));
		sleep(5000);
		driver.get(PlutoraConfiguration.applicationURL);
	}

	 public void addPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 sendKeys("PIR_Comments_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_Send_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" added successfully !");
	 }
	 public void editPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 clickOnButton(objectData,"PIR_Comments_Edit_Link",objectData);
		 sendKeys("PIR_Comments_Edit_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_Edit_Link",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" updated successfully !");
	 }
	 public void replyPIRItemComments(String pageData,String testData,String objectData,String comments) {
		 clickOnButton(objectData,"PIR_Comments_Reply_Link",objectData);
		 sendKeys("PIR_Comments_Reply_Textarea",PropertiesCache.setProperty(testData, comments),objectData);
		 clickOnButton(objectData,"PIR_Comments_ReplySend_Button",objectData);
		 Listener.addLogger(PropertiesCache.getProperty(testData, comments)+" replyed successfully !");
	 }

	
	 public int getElementHeight(String element,String pageData) {
		 return webElementIdentifier(element).getSize().getHeight();
		}
	 
	  
	 public int getElementHeight(String element,String pageData,String text,String testData) {
		 Dimension size;
		 element = PropertiesCache.getProperty(pageData, element);
		 if (element.contains("TEXT")) {
				text=PropertiesCache.getProperty(testData, text);
				size = webElementIdentifier(element.replace("TEXT",text)).getSize();
				return size.getHeight();			
			} else {
				return webElementIdentifier(element).getSize().getHeight();
			}
	 }
	 public void releaseDatePicker(String pageData,String testData,String datePicker,String dateString) throws ParseException {

			String dateSelect[] = dateString.split("-");
			String ED = dateSelect[0];
			String EM = dateSelect[1];
			String EY = dateSelect[2];
			System.out.println(ED + EM + EY);
			if(ED.startsWith("0")) {
				ED=ED.replace("0", "");
			}
			sleep(2000);
			WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, datePicker));
		    if(!element.getText().split(" ")[1].equals(EY)){
		    	//element.click();
		    	clickElementUsingJavaScript(element);
		    	sleep(2000);
		    	driver.findElement(By.xpath("//a[text()='"+EY+"']")).click();
		    	sleep(1000);
		    	System.out.println(EM.substring(0, 3));
		    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
		    	sleep(2000);
		    	driver.findElement(By.xpath("//div[contains(@id,'picker')]//span[text()='OK']")).click();
		    	sleep(2000);
		    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@id,'datepicker')]/div[@data-ref='innerEl']//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
		    	sleep(1000);
		    }else if(element.getText().split(" ")[1].equals(EY)){
		    	if(!element.getText().split(" ")[0].equals(EM)){
		    		clickElementUsingJavaScript(element);
		    		sleep(1000);
			    	driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//div[contains(@class,'x-monthpicker-default')]//a[text()='"+EM.substring(0, 3)+"']")).click();
			    	sleep(2000);
			    	driver.findElement(By.xpath("(//div[contains(@id,'picker')]//span[text()='OK'])[2]")).click();
			    	sleep(2000);
			    	JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")));
			    	//driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']")).click();
			    	sleep(1000);
		    	}else{
		    		sleep(2000);
		    		WebElement element1=driver.findElement(By.xpath("//div[not(contains(@style,'display'))][contains(@class,'x-border-box')]//td[contains(@class,'x-datepicker-active')]/div[text()='"+ED+"']"));
		    		scrollToElement(element1);
		    		sleep(1000);
		    		element1.click();
		    		sleep(2000);
		    	}
		    }
		   
		}
	 
	 public void copyValueUsingAction(String os) {
		 Actions actions = new Actions(driver); 
		 if(os.equals("Mac")) {
			 actions.sendKeys(Keys.COMMAND+"c").perform();
		 }else if(os.equals("Windows")) {
			 actions.sendKeys(Keys.CONTROL+"c").perform();
		 }
	 }
	 public void deleteCharacterFromTextbox(String element, String pageData) {
			WebElement ele = webElementIdentifier(PropertiesCache.getProperty(pageData, element));
			int lenText = ele.getAttribute("value").length();
			for(int i = 0; i < lenText; i++){
				ele.sendKeys("\u0008");
			}
			sleep(2000);	
	 }
	 public void dragAndDropWithClickAndHold(String element1,String element2,String text,String pageData,String testData) {
			sleep(2000);
			element1 = PropertiesCache.getProperty(pageData, element1);
			element2 = PropertiesCache.getProperty(pageData, element2);
			Actions act=new Actions(driver);	
			if(element1.contains("TEXT")) {
			text=PropertiesCache.getProperty(testData, text);
			act.moveToElement(webElementIdentifier(element1.replace("TEXT", text)),100,5).clickAndHold().moveToElement(webElementIdentifier(element2),200,5).moveByOffset(400, 5).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
			sleep(4000);
			}else {
			act.dragAndDrop(webElementIdentifier(element1), webElementIdentifier(element2)).build().perform();
			}
			sleep(2000);
		}
	 
	 public void actionClick(String pageLocator, String objectlocator, String pageData,String objectData) {
		 pageLocator = PropertiesCache.getProperty(pageData, pageLocator);
		 Actions act=new Actions(driver);	
		 act.moveToElement(webElementIdentifier(pageLocator)).click(webElementIdentifier(pageLocator)).build().perform();
		 waitForLoadingIconDisappear(40, objectlocator, objectData);
	 }
	 
	 public void downloadTableauReport(String pageData) {
		 String downloadButton = PropertiesCache.getProperty(pageData, "Tableau_Download_Button");
		 String downloadDataButton = PropertiesCache.getProperty(pageData, "Tableau_Download_Data_Button");
		 switchToFrameByElement("Tableau_Canvas_Iframe", pageData);
		 webElementIdentifier(downloadButton).click();
		 sleep(2000);
		 webElementIdentifier(downloadDataButton).click();
		 sleep(2000);
		 switchToWindowPopup();
	 }

	/*
	 * public void actionClick(String objectLocator,String text,String
	 * pageData,String testData) { objectLocator =
	 * PropertiesCache.getProperty(pageData, objectLocator);
	 * text=PropertiesCache.getProperty(testData, text); Actions act=new
	 * Actions(driver); act.click(webElementIdentifier(objectLocator.replace("TEXT",
	 * text))).release().build().perform();
	 * 
	 * }
	 */
		public void scrollToElementAndClick(String data,String element,String element1,String objectData,String locatorName) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	        try {  
	        	
	        	switch(locatorName) {
	        	case "xpath":
	        		scrollToElement(driver.findElement(By.xpath(PropertiesCache.getProperty(data, element))));
	        		driver.findElement(By.xpath(PropertiesCache.getProperty(data, element)));
	        		break;
	        	case "css":
	        		scrollToElement(driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element))));
	        		driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element)));
	        		break;
	        	}
				
	        } catch (Exception e) {  
	        	switch(locatorName) {
	        	case "xpath":
	        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(PropertiesCache.getProperty(data, element1))));
	        		break;
	        	case "css":
	        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(PropertiesCache.getProperty(data, element1))));
	        		break;
	        	}
	        } 
	      finally {  
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	       }  
	        waitForLoadingIconDisappear(500,"Loading_Gif",objectData);
	        sleep(1000);
		}
		 public void reactDatePicker(String pageData,String testData,String dateString) throws ParseException {
			 Map<String, Integer> monthList = new HashMap<String, Integer>();
			 monthList.put("January",1);
			 monthList.put("February",2);
			 monthList.put("March",3);
			 monthList.put("April",4);
			 monthList.put("May",5);
			 monthList.put("June",6);
			 monthList.put("July",7);
			 monthList.put("August",8);
			 monthList.put("September",9);
			 monthList.put("October",10);
			 monthList.put("November",11);
			 monthList.put("December",12);
			 
			String dateSelect[] = dateString.split("-");
			String ED = dateSelect[0];
			String EM = dateSelect[1];
			String EY = dateSelect[2];
			System.out.println(ED + EM + EY);
			if(ED.startsWith("0")) {
				ED=ED.replace("0", "");
			}
			sleep(2000);
			//WebElement element=webElementIdentifier(PropertiesCache.getProperty(pageData, "React_Additional_information_DatePicker_Year_Label"));
		    String year=getTextData("React_Additional_information_DatePicker_Year_Label", EY,pageData);
			if(!year.equals(EY)){
				click("React_Additional_information_DatePicker_Year_Label", EY,pageData);
		    	sleep(2000);
		    	String monthYearText=new SimpleDateFormat("MMM yyyy").format(new SimpleDateFormat("MM yyyy").parse(EM+" "+EY));
		    	 String month=getTextData("React_Additional_information_DatePicker_Month_Label", monthYearText,pageData);
		    	if(!month.split(" ")[0].equals(new SimpleDateFormat("MMM").format(new SimpleDateFormat("MM").parse(EM)))){
		    		int i=monthList.get(month.split(" ")[0]);
		    		int j=monthList.get(new SimpleDateFormat("MMM").format(new SimpleDateFormat("MM").parse(EM)));
			    	if(i > j) {
			    		for(int z=0;z<i-j;z++) {
			    			click("React_Additional_information_DatePicker_KeyboardArrowLeft_Icon",pageData);
			    			sleep(2000);
			    		}
			    	}else {
			    		for(int z=0;z<j-i;z++) {
			    		click("React_Additional_information_DatePicker_KeyboardArrowRight_Icon",pageData);
			    		sleep(2000);
			    		}
			    	}
			    	click("React_Additional_information_DatePicker_Date_Label",ED,pageData);
			    	sleep(1000);
		    	}else{
		    		sleep(2000);
		    		click("React_Additional_information_DatePicker_Date_Label",ED,pageData);
		    		sleep(2000);
		    	}
		    	
		    }else if(year.equals(EY)) {
				String monthYearText=getTodayDate("0", "MMMM yyyy");
		    	 String month=getTextData("React_Additional_information_DatePicker_Month_Label", monthYearText,pageData);
		    	if(!month.split(" ")[0].equals(new SimpleDateFormat("MMMM").format(new SimpleDateFormat("MM").parse(EM)))){
		    		int i=monthList.get(month.split(" ")[0]);
		    		int j=monthList.get(new SimpleDateFormat("MMMM").format(new SimpleDateFormat("MM").parse(EM)));
			    	if(i > j) {
			    		for(int z=0;z<i-j;z++) {
			    			click("React_Additional_information_DatePicker_KeyboardArrowLeft_Icon",pageData);
			    			sleep(2000);
			    		}
			    	}else {
			    		for(int z=0;z<j-i;z++) {
			    		click("React_Additional_information_DatePicker_KeyboardArrowRight_Icon",pageData);
			    		sleep(2000);
			    		}
			    	}
			    	click("React_Additional_information_DatePicker_Date_Label",ED,pageData);
			    	sleep(2000);
		    	}else{
		    		sleep(2000);
		    		click("React_Additional_information_DatePicker_Date_Label",ED,pageData);
		    		sleep(2000);
		    	}
		    }
		   
		}
		 public void reactTimePicker(String objectData,String hour,String time,String daylightLocator) throws ParseException {
			 sleep(2000);
			 doubleClick("React_Additional_information_TimePicker_Time",hour,objectData);
			 sleep(2000);
			 doubleClick("React_Additional_information_TimePicker_Time",time,objectData);
			 sleep(2000);
			 clickElementUsingJavaScript(daylightLocator,objectData);
			 sleep(2000);
		 }
		 public String concatenateString(String objectLocator,String pageData) {
				
				List<WebElement> elements;
				objectLocator = PropertiesCache.getProperty(pageData, objectLocator);
				elements = webElementsIdentifier(objectLocator);
				StringBuffer sb = new StringBuffer();
				
				for (WebElement element : elements) {
					
					sb = sb.append(element.getText().trim()+" ");
				}
				return sb.toString().trim();

		}
	 public String getCSSBackgroundColor(String objectLocator, String pageData) {
			String value = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).getCssValue("background-color");
			String hex = Color.fromString(value).asHex();
			return hex;
		}
	 public String getCSSColor(String objectLocator, String pageData) {
			String value = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).getCssValue("color");
			return value;
		}
		
		public String getCSSBorderColor(String objectLocator, String pageData) {
			String value = webElementIdentifier(PropertiesCache.getProperty(pageData, objectLocator)).getCssValue("border-top-color");
			String hex = Color.fromString(value).asHex();
			return hex;
		}
		public String switchToWindowReturnParent() {
			String parentWindow = driver.getWindowHandle();
		    Object firstHandle, lastHandle;
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> itr = handles.iterator();
			firstHandle = itr.next();
			lastHandle = firstHandle;
			while (itr.hasNext()) {
				lastHandle = itr.next();
			}
			driver.switchTo().window(lastHandle.toString());
			return parentWindow;
		}
		public void closeWindowPopupReturnToParent(String parentWindow) {
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		public void moveRobot(String element,String pageData) throws AWTException {
			element = PropertiesCache.getProperty(pageData, element);
			Point point = webElementIdentifier(element).getLocation();
			Listener.addLogger("X:"+point.getX() +" Y:"+point.getY());
			Robot bot = new Robot();
			bot.mouseMove(point.getX()+140,point.getY()+140);
			sleep(2000);
		}
		public void clickElement(String data,String element,String element1,String objectData,String loader) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element=PropertiesCache.getProperty(data, element);
			element1=PropertiesCache.getProperty(data, element1);
			locatorTypes locatorName = locatorTypes.valueOf(element.substring(element.lastIndexOf("$") + 1));
			element = element.substring(0, element.lastIndexOf("$"));
			locatorTypes locatorNameOne = locatorTypes.valueOf(element1.substring(element1.lastIndexOf("$") + 1));
			element1 = element1.substring(0, element1.lastIndexOf("$"));
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
	        try {  
	        	
	        	switch(locatorName) {
	        	case xpath:
	        		driver.findElement(By.xpath(element));
	        		break;
	        	case css:
	        		driver.findElement(By.cssSelector(element));
	        		break;
				default:
					break;
	        	}
				
	        } catch (Exception e) {  
	        	switch(locatorNameOne) {
	        	case xpath:
	        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
	        		break;
	        	case css:
	        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
	        		break;
				default:
					break;
	        	}
	        } 
	      finally {  
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	       }    
	        waitForLoadingIconDisappear(500,loader,objectData);
	        sleep(1000);
		}
		public void clickElement(String data,String element,String element1,String text,String testData,String objectData,String loader) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element=PropertiesCache.getProperty(data, element);
			element1=PropertiesCache.getProperty(data, element1);
			text=PropertiesCache.getProperty(testData, text);
			locatorTypes locatorName = locatorTypes.valueOf(element.substring(element.lastIndexOf("$") + 1));
			element = element.substring(0, element.lastIndexOf("$"));
			element = element.replace("TEXT", text);
			locatorTypes locatorNameOne = locatorTypes.valueOf(element1.substring(element1.lastIndexOf("$") + 1));
			element1 = element1.substring(0, element1.lastIndexOf("$"));
			element1 = element1.replace("TEXT", text);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
	        try {  
	        	
	        	switch(locatorName) {
	        	case xpath:
	        		driver.findElement(By.xpath(element));
	        		break;
	        	case css:
	        		driver.findElement(By.cssSelector(element));
	        		break;
				default:
					break;
	        	}
				
	        } catch (Exception e) {  
	        	switch(locatorNameOne) {
	        	case xpath:
	        		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(element1)));
	        		break;
	        	case css:
	        		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(element1)));
	        		break;
				default:
					break;
	        	}
	        } 
	      finally {  
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	       }    
	        waitForLoadingIconDisappear(500,loader,objectData);
	        sleep(1000);
		}
		
		public void dragAndDropWithClickAndHoldWithPosition(String element1,String element2,String text1,String text2,String pageData,String testData,int xOffset, int yOffset) {
	        sleep(2000);
	        element1 = PropertiesCache.getProperty(pageData, element1);
	        element2 = PropertiesCache.getProperty(pageData, element2);
	        Actions act=new Actions(driver);
	        if(element1.contains("TEXT")) {
	        text1=PropertiesCache.getProperty(testData, text1);
	        text2=PropertiesCache.getProperty(testData, text2);
	        //act.moveToElement(webElementIdentifier(element1.replace("TEXT", text1))).clickAndHold().moveToElement(webElementIdentifier(element2.replace("TEXT", text2)),76,147).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).release().build().perform();
	        act.moveToElement(webElementIdentifier(element1.replace("TEXT", text1))).clickAndHold(webElementIdentifier(element1.replace("TEXT", text1))).pause(java.time.Duration.ofSeconds(5)).moveByOffset(216, 267).moveToElement(webElementIdentifier(element2.replace("TEXT", text2))).release().click().build().perform();
	        sleep(4000);
	        }else {
	        	sleep(4000);
	        	 act.moveToElement(webElementIdentifier(element1)).clickAndHold(webElementIdentifier(element1)).pause(java.time.Duration.ofSeconds(5)).moveByOffset(216, 267).moveToElement(webElementIdentifier(element2)).release().click().build().perform();
	        	//act.moveToElement(webElementIdentifier(element1),-100,5).clickAndHold().moveToElement(webElementIdentifier(element2),0,yOffset).moveByOffset(xOffset, yOffset).pause(java.time.Duration.ofSeconds(5)).r elease().build().perform();
	        	// act.dragAndDropBy(webElementIdentifier(element1), 76, 147);
	        }
	        sleep(1000);
	    }
		
		public boolean isElement_Present(String objectLocator) {
			WebElement element;
			try {
			    element = webElementIdentifier(objectLocator);
				element.isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public WebElement getElement(String locator) {	
			String elementLocator = locator.substring(0, locator.lastIndexOf("$"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementLocator)));
			return driver.findElement(By.xpath(elementLocator));
			
		}
		
		public List<WebElement> getAllOptionsFromDropdown(String locator, String locatorFile){
			String element = PropertiesCache.getProperty(locatorFile, locator);
			Select select = new Select(webElementIdentifier(element));
			return select.getOptions();
			
		}
		
}
