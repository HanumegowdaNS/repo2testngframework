package com.plutora.testconfig;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.plutora.utils.PropertiesCache;

public class PlutoraAPIConfiguration {
	
	public static List<String> propertyList = new ArrayList<String>();
	public static String testData;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "apitestDataFile","domain"})
	public void preClass(String testDataFile, String domain){
		propertyList.add(testDataFile);
		testData=testDataFile;
		
		new PropertiesCache(propertyList, domain);
		
	}
	
}
