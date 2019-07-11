package com.plutoraapi.defects;

import java.text.ParseException;

import org.testng.annotations.Test;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.TEBRPage;
import com.plutoraapi.pagerepo.TECRPage;

public class TEBRTECRLastModifiedDate  {
	
	TEBRPage tebrPage = new TEBRPage();
	TECRPage tecrPage = new TECRPage();
	

	@Test(description = "API - implement LastModifiedDate and LastModifiedBy parameters for TECR and TEBR filter method", groups = { "RegressionTests" })
	public void tebrTEBR_P80904_D_0001_1() throws ParseException{
		APIListener.addLogger( "[API] - implement LastModifiedDate and LastModifiedBy parameters for TEBR filter method"); 
		tebrPage.createTEBR4269("createTEBR4265Json", PlutoraAPIConfiguration.testData);
		tebrPage.setDataToProperty("id");
		/****************Verify Status Code******************/
		tebrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tebrPage.getTEBR(PlutoraAPIConfiguration.testData);
		tebrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TEBRParametersAttributes"));
		/****************Verify Parameter values******************/
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		tebrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Equals","TEBRsFilterUrl");
		tebrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
		tebrPage.deleteTEBR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - implement LastModifiedDate and LastModifiedBy parameters for TEBR filter method is successful! ");
	}
	
	@Test(description = "API - implement LastModifiedDate and LastModifiedBy parameters for TECR and TEBR filter method", groups = { "RegressionTests" })
	public void tebrTECR_P80904_D_0001_2() throws ParseException{
		APIListener.addLogger( "[API] - implement LastModifiedDate and LastModifiedBy parameters for TECR filter method"); 
		tecrPage.createTECR("createTECRJson", PlutoraAPIConfiguration.testData);
		tecrPage.setDataToProperty("id");
		/****************Verify Status Code******************/
		tecrPage.verifyStatusCode("CREATED_Status_Code", PlutoraAPIConfiguration.testData);
		tecrPage.getTECR(PlutoraAPIConfiguration.testData);
		tecrPage.getAndSetJsonData(PlutoraAPIConfiguration.testData,PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "TECRParametersAttributes"));
		/****************Verify Parameter values******************/
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedDate","ASC","lastModifiedDate","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedDate",PlutoraAPIConfiguration.testData,"Equals");
		tecrPage.filterValueData("request4265ValueJson", PlutoraAPIConfiguration.testData,"lastModifiedBy","ASC","lastModifiedBy","Equals","TECRsFilterUrl");
		tecrPage.verifyResponseArrayValue("lastModifiedBy",PlutoraAPIConfiguration.testData,"Equals");
		tecrPage.deleteTECR(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( "[API] - implement LastModifiedDate and LastModifiedBy parameters for TECR filter method is successful! "); 
	}
	
	
}

