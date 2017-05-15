package com.young.appiumcombat.testcases.android.home;



import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;

import com.young.appiumcombat.pages.android.HomePage;


public class HomePage_001_UiCheck_Test extends BasePrepare{
	
	/**e税客主页页面检查*/
	@Test
	public void Case_001_HomePageUiCheck(){
//		HelloPage.intoSettingPage(appiumUtil);
//		appiumUtil.pause(3);
//		SettingPage.setToNationalVersion(appiumUtil);
		appiumUtil.pause(3);
		HomePage.pageCheck(appiumUtil);
		
	}
	
	
	

}
