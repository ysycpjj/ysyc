package com.young.appiumcombat.testcases.android.searchhistery;

import java.util.Map;

import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.HomePage;
import com.young.appiumcombat.pages.android.InitPage;
import com.young.appiumcombat.pages.android.SearchHisteryPage;
import com.young.appiumcombat.pages.android.SearchNativePage;
import com.young.appiumcombat.pages.android.SearchWebviewPage;
import com.young.appiumcombat.pageshelper.android.HomePageHelper;
import com.young.appiumcombat.pageshelper.android.InitPageHelper;
import com.young.appiumcombat.pageshelper.android.SearchHisteryPageHelper;
import com.young.appiumcombat.pageshelper.android.SearchNativePageHelper;
import com.young.appiumcombat.pageshelper.android.SearchWebviewPageHelper;
import com.young.appiumcombat.testcases.android.search.SearchPage_001_SearchDemo_Test;

public class SearchHisteryPage_001_SearchHistery_Test extends BasePrepare {

	@Test(dataProvider = "testData")
	public void searchHistery(Map<String, String> data) {
		// 去除欢迎界面和定位弹窗
		InitPageHelper.handleInit(appiumUtil, InitPage.byElements);
		// 点击搜索按钮
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_SEARCH);
		// 在搜索界面输入框输入Java
		SearchNativePageHelper.typeInfo(appiumUtil,
				SearchNativePage.SNP_INPUT_SEARCH, data.get("KEYWORD"));
		// 点击搜索网页，进行搜索
		SearchNativePageHelper.clickOnSearchNativePage(appiumUtil,
				SearchNativePage.SNP_LINK_WEBSEARCH);
		//点击：搜索的Logo
		SearchNativePageHelper.clickOnSearchNativePage(appiumUtil,
				SearchNativePage.SNP_HEADER_LOGO);
		// 点击搜索按钮
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_SEARCH);
		// 点击：查看历史记录
		SearchHisteryPageHelper.clickOnSearchHistery(appiumUtil,
				SearchNativePage.SNP_BUTTON_SEARCHHISTERY);
		// 验证搜索历史记录是否为空
		SearchHisteryPageHelper.checkSearchHistery(appiumUtil,
				SearchHisteryPage.SNP_TEXTVIEW_SEARCHCONTENT);
		// 验证搜索历史记录是否包含关键字
		SearchHisteryPageHelper.checkHisteryContainKeyWord(appiumUtil,
				data.get("KEYWORD"),
				SearchHisteryPage.SNP_TEXTVIEW_SEARCHCONTENT);
	}

}
