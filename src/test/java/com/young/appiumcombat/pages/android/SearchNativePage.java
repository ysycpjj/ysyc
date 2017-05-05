package com.young.appiumcombat.pages.android;

import org.openqa.selenium.By;

/**@author Young
 * @description 搜索页面元素
 * */

public class SearchNativePage {
	/**搜索输入框*/
	 public static final By SNP_INPUT_SEARCH = By.id("com.microsoft.bing:id/search_text_field"); 
	 /**搜索网页*/
	 public static final By SNP_LINK_WEBSEARCH = By.id("com.microsoft.bing:id/opal_as_web");
	 /**搜索图片*/
	 public static final By SNP_LINK_IMAGESEARCH = By.id("com.microsoft.bing:id/opal_as_images");
	 /**搜索视频*/
	 public static final By SNP_LINK_VEDIOSEARCH = By.id("com.microsoft.bing:id/opal_as_videos");
	 /**搜索学术*/
	 public static final By SNP_LINK_ACADEMICSEARCH = By.id("com.microsoft.bing:id/opal_as_academic");
	 /**搜索词典*/
	 public static final By SNP_LINK_DICTSEARCH = By.id("com.microsoft.bing:id/opal_as_dict");
	 /**内容清除*/
	 public static final By SNP_TEXTVIEW_SEARCHCONTENTCLEAR = By.className("android.widget.TextView");
	 /**查看搜索历史*/
	 public static final By SNP_BUTTON_SEARCHHISTERY = By.id("com.microsoft.bing:id/opal_as_history");
	 /**搜索图标*/
	 public static final By SNP_HEADER_LOGO = By.id("com.microsoft.bing:id/opal_header_logo");
	

}
