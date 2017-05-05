package com.young.appiumcombat.testcases.android.more;
import java.util.Map;

import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.HomePage;
import com.young.appiumcombat.pages.android.InitPage;
import com.young.appiumcombat.pageshelper.android.HomePageHelper;
import com.young.appiumcombat.pageshelper.android.InitPageHelper;
import com.young.appiumcombat.pageshelper.android.MorePageHelper;

public class MorePage_001_UiCheckForMorePage_Test  extends BasePrepare{
	
	@Test(dataProvider="testData")
	public void uiCheckForMorePage(Map<String, String> data){
		//去除欢迎界面和定位弹窗
		InitPageHelper.handleInit(appiumUtil, InitPage.byElements);
		//在首页上点击更多按钮
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_MORE);
		//检查更多页面的文本
		MorePageHelper.checkMorePageUIText(appiumUtil, data.get("LOGIN"),data.get("HISTORY"),data.get("SETTINGS"),data.get("FEEDBACK"));
	}

}
