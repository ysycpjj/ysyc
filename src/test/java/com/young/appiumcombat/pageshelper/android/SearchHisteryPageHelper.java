package com.young.appiumcombat.pageshelper.android;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.young.appiumcombat.pages.android.SearchWebviewPage;
import com.young.appiumcombat.utils.AppiumUtil;

public class SearchHisteryPageHelper {
	static Logger logger = Logger.getLogger(SearchHisteryPageHelper.class);
	/**进入指定的webview内容中*//*
	public static void enterWebview(AppiumUtil appiumUtil,String webview){
		appiumUtil.switchWebview(webview);
	}*/
	
	/**等待webview页面中的元素显示出来*/
	public static void waitForSearchResultDisplay(AppiumUtil appiumUtil,int elementTimeOut){
		logger.info("正在等待搜索结果webview页面加载出来");
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_ALLSEARCH);
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_ENGLISHSEARCH);
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_RESULTLIST);
		logger.info("搜索结果webview页面加载完毕");
		
	}
	
	/**验证搜索出来的结果是否含有关键字*/
	public static void checkResultFitKeyword(AppiumUtil appiumUtil,String keyword,By byElement){
		
		appiumUtil.isContains(appiumUtil.getText(byElement), keyword);
	}
	
	/**在原生页面进行点击操作*/
	public static  void clickOnSearchHistery(AppiumUtil appiumUtil ,By byElement){
		appiumUtil.click(byElement);
	}

	/**检查搜索历史中有数据*/
	public static void checkSearchHistery(AppiumUtil appiumUtil,By byElement){
		Assert.assertTrue(appiumUtil.findElements(byElement).size()>0); 
	}
	
	/**检查搜索历史是否有关键字*/
	public static void checkHisteryContainKeyWord(AppiumUtil appiumUtil,String keyword,By byElement){
		List<WebElement> list = appiumUtil.findElements(byElement);
		String content = null;
		for(int i=0;i<list.size();i++){
				content =content+list.get(i).getText()+";";
		}
		Assert.assertTrue(content.contains(keyword));; 
	}
}
