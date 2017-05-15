package com.young.appiumcombat.pageshelper.ios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.young.appiumcombat.utils.AppiumUtil;

public class HomePageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class);

	/**在首页上进行点击操作*/
	 public static void clickOnHomePage(AppiumUtil appiumUtil,By byElement){
		 appiumUtil.click(byElement);
	 }
	 /**滚动查找元素*/
	 public static WebElement scrollToFindElement(AppiumUtil appiumUtil,String findStr){
		return  appiumUtil.scrollExact(findStr);
		  
	 }
	 
	 /**滑动到指定元素并点击*/
	 public static void clickAfterScroll(AppiumUtil appiumUtil,String findStr){
		 appiumUtil.click(scrollToFindElement(appiumUtil,findStr));
		 
	 }
	 
	 
}
