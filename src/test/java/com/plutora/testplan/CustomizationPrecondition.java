package com.plutora.testplan;

import java.io.IOException;

import org.testng.annotations.Test;
import com.plutora.pagerepo.CustomizationPage;
import com.plutora.testconfig.PlutoraConfiguration;
import com.plutora.utils.Listener;

public class CustomizationPrecondition{	
	
	
	@Test (description = "Customization Precondition")
	public void precondition() throws InterruptedException, IOException {	
		Listener.addLogger("<---------------------------------------------Customization precondition verification started----------------------------------------->");
		new CustomizationPage().setupCustomization(PlutoraConfiguration.customizationData, PlutoraConfiguration.testData, PlutoraConfiguration.objectData);
		Listener.addLogger("<---------------------------------------------Customization precondition verification completed----------------------------------------->");
	}
	
}
