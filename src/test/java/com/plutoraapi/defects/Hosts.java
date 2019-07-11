package com.plutoraapi.defects;

import org.testng.annotations.Test;
import com.plutoraapi.pagerepo.EnvironmentPage;
import com.plutora.testconfig.PlutoraAPIConfiguration;
import com.plutora.utils.APIListener;
import com.plutora.utils.PropertiesCache;
import com.plutoraapi.pagerepo.HostsPage;
import com.plutoraapi.pagerepo.LayersPage;

public class Hosts  {
	
	HostsPage hostsPage = new HostsPage();
	LayersPage layersPage = new LayersPage();
	EnvironmentPage environmentPage = new EnvironmentPage();
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 1)
	public void create4354_R8103PD4477Hosts_1(){
		APIListener.addLogger( "Create Hosts using POST Hosts method"); 
		environmentPage.createEnvironment("createEnvironmentJson", PlutoraAPIConfiguration.testData);
		environmentPage.setDataToProperty("id","Environment_Id");
		//create host
		hostsPage.createHosts("createHosts4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		hostsPage.setDataToProperty("id");
		hostsPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354Values"));
		//create layer
		layersPage.createLayers("createLayers4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		/****************Verify Status Code******************/
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		hostsPage.setDataToProperty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsLayerParameter4354Values"),PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsLayerArrayParameter4354Values"));
		hostsPage.setDataToProperty("isSummaryVersion","layers[0].isSummaryVersion");
		//get host
		hostsPage.verifyHosts(PlutoraAPIConfiguration.testData);
		/****************Verify Status Code******************/
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354Values"));
		/*//Delete Test Data
		layersPage.deleteLayers(PlutoraAPIConfiguration.testData);
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "id",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "hostID"));
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);*/
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using POST Hosts is successful! ");
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 2)
	public void create4354_R8103PD4477Hosts_2(){
		APIListener.addLogger( "Get Hosts using GET Hosts/{id} method"); 
		/****************Verify Parameter values******************/
		hostsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354Values"),PlutoraAPIConfiguration.testData);
		hostsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsLayerArrayParameter4354Values"),PlutoraAPIConfiguration.testData);
		hostsPage.verifyResponseValue(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354ValidateTag"),PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using GET Hosts/{id} is successful! ");
		
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 3)
	public void create4354_R8103PD4477Hosts_3(){
		APIListener.addLogger( "Get Hosts using PUT Hosts/{id} method"); 
		hostsPage.update4345Hosts(PlutoraAPIConfiguration.testData);
		/****************Verify Parameter values******************/
		layersPage.verifyStatusCode("Update_Status_Code", PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using PUT Hosts/{id} is successful! ");
	}
	
	@Test(description = "Add to API ability to set 'Summary View' checkbox for the CICD Pipeline to function", groups = { "RegressionTests" }, priority = 4)
	public void create4354_R8103PD4477Hosts_4(){
		APIListener.addLogger( "Create Hosts using POST Hosts/bulk method"); 
		hostsPage.createHosts("createHosts4354Json", PlutoraAPIConfiguration.testData,"Environment_Id");
		hostsPage.createHostsBulk(PlutoraAPIConfiguration.testData);
		/****************Set Identifier******************/
		hostsPage.verifyStatusCode("OK_Status_Code", PlutoraAPIConfiguration.testData);
		hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354Values"));
		//hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsLayerArrayParameter4354Values"));
		//hostsPage.verifyResponseNotEmpty(PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "HostsParameter4354ValidateTag"));
		//Delete Test Data
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		PropertiesCache.setProperty(PlutoraAPIConfiguration.testData, "id",PropertiesCache.getProperty(PlutoraAPIConfiguration.testData, "hostID"));
		hostsPage.deleteHosts(PlutoraAPIConfiguration.testData);
		APIListener.addLogger( " API ability to set 'Summary View' checkbox for the CICD Pipeline to function using POST Hosts/bulk is successful! ");
		
	}

}

