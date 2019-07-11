package com.plutoraapi.testplan;

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

	@Test(description = "Create Layers", groups = { "RegressionTests" })
	public void createLayers(){
		APIListener.addLogger( "Create Layers"); 
		environmentPage.createEnvironment("createEnvironmentDevJson", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id","Environment_Id");
		hostsPage.createHosts("createHostsJson", PlutoraAPIConfiguration.testData,"Environment_Id");
		environmentPage.setDataToProperty("id","Host_Id");
		layersPage.createLayersWithHostId("createLayersJson", PlutoraAPIConfiguration.testData,"Environment_Id","Host_Id");
		/****************Verify Status Code******************/
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		/****************Set Identifier******************/
		layersPage.setDataToProperty("id");
	}
	
	@Test(description = "Verify Layers", groups = { "RegressionTests" },dependsOnMethods="createLayers")
	public void verifyLayers() {
		APIListener.addLogger( "Verify Layers"); 
		layersPage.verifyLayers(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterValues"),PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseValue("stackLayer", PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseValue("stackLayerType", PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Update Layers", groups = { "RegressionTests" },dependsOnMethods="verifyLayers")
	public void updateLayers() {
		APIListener.addLogger( "Update Layers"); 
		layersPage.updateLayerswithHostid("createLayersJson", PlutoraAPIConfiguration.testData,"Environment_Id","Host_Id");
		/****************Verify Status Code******************/
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		
		APIListener.addLogger( "Verify Response after Updating Release"); 
		layersPage.verifyLayers(PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterNotEmpty"));
		layersPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "LayersParameterValues"),PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseValue("stackLayer", PlutoraAPIConfiguration.testData);
		layersPage.verifyResponseValue("stackLayerType", PlutoraAPIConfiguration.testData);
	}
	@Test(description = "Delete TECR", groups = { "RegressionTests" },dependsOnMethods="updateLayers")
	public void deleteLayers() {
		APIListener.addLogger( "Delete Layers"); 
		layersPage.deleteLayers(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		layersPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "id",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "hostID"));
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
	}

}

