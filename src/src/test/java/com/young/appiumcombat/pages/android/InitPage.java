package com.young.appiumcombat.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;


import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;

public class InitPage {
	/**初始化页面图片*/
	public static final By INITPAGE_IMAGVIEW_HELLO = By.id("com.ysyc.itaxer:id/iv");
	/**初始化页面翻页图标*/
	public static final By INITPAGE_IMAGVIEW_PAGEFLIP =By.id("com.ysyc.itaxer:id/guid_ll");
	/**设置地区-全国体验版*/
	public static final By INITPAGE_RELATIVELAYOUT_NATIONALVERSION = By.id("com.ysyc.itaxer:id/rlGlobal");
	/**设置地区页面标题*/
	public static final By INITPAGE_TESTVIEW_TITLE = By.id("com.ysyc.itaxer:id/title");
	
	
	/**检查初始化页面的图片和翻页元素是否存在*/
	public static void pageViewCorrect(AppiumUtil appiumUtil,int i){
		appiumUtil.waitForElementToLoad(10, INITPAGE_IMAGVIEW_HELLO);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_IMAGVIEW_HELLO),"经检查：初始化第"+i+"页图片 不存在"); 
		appiumUtil.waitForElementToLoad(10, INITPAGE_IMAGVIEW_PAGEFLIP);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_IMAGVIEW_PAGEFLIP),"经检查：初始化第"+i+"页翻页图标 不存在");
	}
	
	/**翻页*/
	public static void pageFlip(AppiumUtil appiumUtil) {
		//向左滑动一次
		appiumUtil.pause(3);
		try{
		appiumUtil.swipByTouchAction("Left");
		}catch(WebDriverException e){
			appiumUtil.logWriter("info", "抛出了WebDriverExeption!");
//			System.out.println("抛出了WebDriverExeption!");
		}
		
	}
	
	public static void setToNationalVersion(AppiumUtil appiumUtil){
		appiumUtil.waitForElementToLoad(20, INITPAGE_RELATIVELAYOUT_NATIONALVERSION);
		appiumUtil.click(INITPAGE_RELATIVELAYOUT_NATIONALVERSION);
	}
	
	public static void verifyTheVersion(AppiumUtil appiumUtil){
		String value =HomePage.getCity(appiumUtil);
		System.out.println("value ="+value);
		Assertion.assertTrue(value.trim().equals("全国"),"期望结果是:全国，实际结果为:"+value+";");
		
	}
	
	public static void initPageAndCheckPageView(AppiumUtil appiumUtil){
		for(int i=1;i<3;i++){
			appiumUtil.pause(2);
			InitPage.pageViewCorrect(appiumUtil, i);
			InitPage.pageFlip(appiumUtil);
			appiumUtil.pause(2);
		}
		InitPage.pageViewCorrect(appiumUtil, 3);
		InitPage.pageFlip(appiumUtil);
		appiumUtil.pause(2); 
		InitPage.setToNationalVersion(appiumUtil);
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, INITPAGE_TESTVIEW_TITLE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_TESTVIEW_TITLE), "经检查：设置地区页面标题 不存在");
		
	}
	

}
