package com.young.appiumcombat.testcases.android.search;

import java.util.Map;

import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.HomePage;
import com.young.appiumcombat.pages.android.InitPage;
import com.young.appiumcombat.pages.android.SearchNativePage;
import com.young.appiumcombat.pages.android.SearchWebviewPage;
import com.young.appiumcombat.pageshelper.android.HomePageHelper;
import com.young.appiumcombat.pageshelper.android.InitPageHelper;
import com.young.appiumcombat.pageshelper.android.SearchNativePageHelper;
import com.young.appiumcombat.pageshelper.android.SearchWebviewPageHelper;

public class SearchPage_001_SearchDemo_Test  extends BasePrepare{
	
	@Test(dataProvider="testData")
	public void searchDemo(Map<String, String> data){
		//去除欢迎界面和定位弹窗
		InitPageHelper.handleInit(appiumUtil, InitPage.byElements);
		//点击搜索按钮
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_SEARCH);
		//在搜索界面输入框输入Java
		SearchNativePageHelper.typeInfo(appiumUtil, SearchNativePage.SNP_INPUT_SEARCH, data.get("KEYWORD"));
		//点击搜索网页，进行搜索
		SearchNativePageHelper.clickOnSearchNativePage(appiumUtil, SearchNativePage.SNP_LINK_WEBSEARCH);
		//进入webview内容
		SearchWebviewPageHelper.enterWebview(appiumUtil, SearchWebviewPage.WEBVIEW_NAME);
		//等待webview内容显示出来
		SearchWebviewPageHelper.waitForSearchResultDisplay(appiumUtil, elementTimeOut);
		//验证搜索的结果是否包含Java
		SearchWebviewPageHelper.checkResultFitKeyword(appiumUtil, data.get("KEYWORD"), SearchWebviewPageHelper.getRandomIndexResult(appiumUtil, SearchWebviewPage.SWP_LINK_RESULTLIST));
	}

}
