package com.plutoraapi.defects;

import org.testng.annotations.Test;

import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.HostsPage;
import com.plutoraapi.pagerepo.LayersPage;
 
public class Layers  {
	
	LayersPage layersPage = new LayersPage();
	HostsPage hostsPage = new HostsPage(); 
	EnvironmentPage environmentPage = new EnvironmentPage();

	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 1)
	public void create4354_R8103PD4477Layers_1(){
		environmentPage.createEnvironment("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id","Environment_Id");
		APIListener.addLogger("Create Layers using POST Layers method"); 
		hostsPage.createHosts("createHosts4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		layersPage.createLayers("createLayers4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		//****************Verify Status Code******************//*
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		//****************Set Identifier******************//*
		layersPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.setDataToProperty("id;isSummaryVersion");
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.verifyResponseValue("isSummaryVersion", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using POST Layers is successful! ");
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 2)
	public void create4354_R8103PD4477Layers_2(){
		APIListener.addLogger("Get Layers using GET Layers/{id} method"); 
		layersPage.verifyLayers(PlutoraAPIConfiguration.testData);
		//****************Verify Parameter values******************//*
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"),PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseValue("isSummaryVersion", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using GET Layers/{id} is successful! ");
		
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 3)
	public void create4354_R8103PD4477Layers_3(){
		APIListener.addLogger("Get Layers using PUT Layers/{id} method"); 
		layersPage.update4345Layers("createLayers4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		//****************Verify Parameter values******************//*
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		layersPage.verifyLayers(PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.verifyResponseValue("isSummaryVersion", PlutoraAPIConfiguration.testData);
		//Delete Test Data
		layersPage.deleteLayers(PlutoraAPIConfiguration.testData);
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "id",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "hostID"));
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using PUT Layers/{id} is successful! ");
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 4)
	public void create4354_R8103PD4477Layers_4(){
		APIListener.addLogger("Create Layers using POST Layers/bulk method"); 
		hostsPage.createHosts("createHosts4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		layersPage.createLayersBulk("createLayers4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		//****************Verify Status Code******************//*
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		//Delete Test Data
		layersPage.deleteLayers(PlutoraAPIConfiguration.testData);
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "id",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "hostID"));
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using POST Layers/bulk is successful! ");
		
	}

}

