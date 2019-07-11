package com.plutora.pagerepo;

import com.plutora.utils.TestGenericUtilLib;

public class EnvironmentImpactMatrixPage extends TestGenericUtilLib  {

	public void gotoEnvironmentImpactMatrix(String environmentData,String objectData) throws InterruptedException {	
		sleep(2000);
		mouseHover("Environment_Header_Dropdown", "EnvironmentImpactMatrix_Dropdown_Menu",environmentData);
		waitForLoadingIconDisappear(100,"Loading_Gif",objectData);
	}
	
}