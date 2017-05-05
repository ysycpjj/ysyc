package com.young.appiumcombat.pageshelper.ios;

import org.openqa.selenium.By;

import com.young.appiumcombat.utils.AppiumUtil;

public class AlertViewPageHelper {

	/**在AlertView页面上进行点击操作*/
	 public static void clickOnAlertViewPage(AppiumUtil appiumUtil,By byElement){
		 appiumUtil.click(byElement);
	 }
	 
	 /**处理Alert View页面上的aler*/
	 public static void handleAlert(AppiumUtil appiumUtil,String handleStrategy){
		 
		 appiumUtil.handleAlert(handleStrategy);
		 
	 }

}
