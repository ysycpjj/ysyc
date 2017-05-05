package com.young.appiumcombat.pageshelper.android;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.young.appiumcombat.pages.android.SearchWebviewPage;
import com.young.appiumcombat.utils.AppiumUtil;

public class SearchWebviewPageHelper {
	static Logger logger = Logger.getLogger(SearchWebviewPageHelper.class);
	/**进入指定的webview内容中*/
	public static void enterWebview(AppiumUtil appiumUtil,String webview){
		appiumUtil.switchWebview(webview);
	}
	
	/**等待webview页面中的元素显示出来*/
	public static void waitForSearchResultDisplay(AppiumUtil appiumUtil,int elementTimeOut){
		logger.info("正在等待搜索结果webview页面加载出来");
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_ALLSEARCH);
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_ENGLISHSEARCH);
		appiumUtil.waitForElementToLoad(elementTimeOut, SearchWebviewPage.SWP_LINK_RESULTLIST);
		logger.info("搜索结果webview页面加载完毕");
		
	}
	
	/**验证搜索出来的结果是否含有关键字,通过By对象*/
	public static void checkResultFitKeyword(AppiumUtil appiumUtil,String keyword,By byElement){
		
		appiumUtil.isContains(appiumUtil.getText(byElement), keyword);
	}
	
	/**验证搜索出来的结果是否含有关键字,通过元素xpath*/
	public static void checkResultFitKeyword(AppiumUtil appiumUtil,String keyword,String elementXpath){
		appiumUtil.isContainsIgnoreCase(appiumUtil.getText(elementXpath), keyword);
	}
	
	/**随机获取第某条结果,并返回xpath*/
	public static String getRandomIndexResult(AppiumUtil appiumUtil,String xpath){
		Random random = new Random();
		/**搜索结果中，包含：头，相关搜索，之类的，剔除掉其他的*/
		int max  = appiumUtil.findElements(xpath+"/h2/a").size();
		/**获取2-max之间的随机数，公式如下：
		 * random.nextInt(max)%(max-min+1) + min;
		 * random.nextInt(max)表示生成[0,max]之间的随机数，然后对(max-min+1)取模。
		以生成[10,20]随机数为例，首先生成0-20的随机数，然后对(20-10+1)取模得到[0-10]之间的随机数，
		然后加上min=10，最后生成的是10-20的随机数*/
        int s = random.nextInt(max)%(max-1)+2;
        return xpath+"["+s+"]"+"/h2/a/strong";
    }
	}


