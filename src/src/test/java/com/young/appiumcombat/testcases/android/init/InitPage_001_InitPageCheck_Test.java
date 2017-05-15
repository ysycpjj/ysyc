package com.young.appiumcombat.testcases.android.init;

import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.InitPage;
import com.young.appiumcombat.utils.Assertion;

public class InitPage_001_InitPageCheck_Test extends BasePrepare {

	@Test
	public void Case_001_InitPageCheck(){
//		InitPage.initPageAndCheckPageView(appiumUtil);
		/**初始化步骤已经在BeforeMethod里面实现了*/
		InitPage.verifyTheVersion(appiumUtil);
		/**此处已进行了初始化，该字段设置为false*/
		assert Assertion.flag;
	}
}
