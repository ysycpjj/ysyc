package com.young.appiumcombat.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;


//com.young.appiumcombat.testcases.android.electronicinvoice
public class ElectronicInvoice {
	/**电票开通：webView*/
	public static final By ELECTRONICINVOICE_WBNVIEW_PAGEVIEW = By.className("android.webkit.WebView");
	/**电票开通-webView:页面标题*/
	public static final By ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE  =By.className("header_title");
	/**电票开通-webView：介绍*/
	public static final By ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION = By.className("label");
	/**电票开通-webView：中心图片*/
	public static final By ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON = By.xpath("//div[@class='center_icon']/img");	
	/**电票开通-webView：电票开通按钮*/
	public static final By ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE = By.className("footer_btn_enable");
	
	/**电票开通-webview-提交表单*/
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_LIST= By.className("fbi_input");
	/**电票开通-webview-联系人姓名*//*
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_CONTACTTNAME= By.xpath("//android.widget.EditText[1]");
	*//**电票开通-联系人电话*//*
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_TELEPNONE= By.xpath("//android.widget.EditText[2]");
	*//**电票开通-企业名称*//*
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_COMPANYNAME= By.xpath("//android.widget.EditText[3]");
	*//**电票开通-企业开票主体数量（税号数量）*//*
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_TARIFFNUM= By.xpath("//android.widget.EditText[4]");
	*//**电票开通-企业年开票数量*//*
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_INVOICENUM=By.xpath("//android.widget.EditText[5]");*/
	/**电票开通-确认提交*/
	public static final String ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_LOCATION= "AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_VALUE= "确认提交";
	/**提交结果-提交结果*/
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATION  ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_VALUE  ="提交成功！";
	/**提交结果-提交结果*/
	public static final By ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT=By.className("fb_ssTitle");
	/**提交结果-返回主页*/
	public static final By ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME =By.className("header_left");
//	
	
	public static void switchWebView(AppiumUtil appiumUtil){
		appiumUtil.switchWebviewByKeyWord("WEBVIEW_com.ysyc.itaxer");
		appiumUtil.pause(2);
	}
	public static void switchNative(AppiumUtil appiumUtil){
		appiumUtil.switchWebviewByKeyWord("NATIVE_APP");
		appiumUtil.pause(2);
	}
	public static boolean isInElectronicInvoicePage(AppiumUtil appiumUtil){
		 appiumUtil.pause(2);
		 return appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEW_PAGEVIEW);
				
	}
	
	public static void introducePageUICheck(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE), "经检查：电票开通-WebView-页面标题不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION), "经检查：电票开通-WebView-公司介绍不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON), "经检查：电票开通-WebView-页面图片不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE), "经检查：电票开通-WebView-开通电票按钮不存在");
	}
	
	/*public static void submitPageUICheck(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWINPUT_CONTACTTNAME);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWINPUT_CONTACTTNAME), "经检查：提交申请-联系人姓名 不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWINPUT_TELEPNONE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWINPUT_TELEPNONE), "经检查：提交申请-联系人电话 不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWINPUT_COMPANYNAME);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWINPUT_COMPANYNAME), "经检查：提交申请-企业名称 不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWINPUT_TARIFFNUM);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWINPUT_TARIFFNUM), "经检查：提交申请-企业开票主体数量（税号数量） 不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWINPUT_INVOICENUM);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWINPUT_INVOICENUM), "经检查：提交申请-企业年开票数量 不存在");
	}*/
	
	/*public static void enableElectronicInvoice(AppiumUtil appiumUtil,String[] value){
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE);
		appiumUtil.click(ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE);
		appiumUtil.pause(3);
		submitPageUICheck(appiumUtil);
		appiumUtil.pause(2);
		switchNative(appiumUtil);
		appiumUtil.pause(2);
		List<WebElement> list = appiumUtil.findElements(ELECTRONICINVOICE_WBNVIEWINPUT_LIST);
		for(int i=0;i<list.size();i++){
			appiumUtil.pause(3);
			appiumUtil.typeContent(list.get(i),value[i] );
			appiumUtil.pause(3);
		}
		appiumUtil.driver.scrollToExact("联系人姓名");
		appiumUtil.pause(2);
		appiumUtil.typeContent(ELECTRONICINVOICE_WBNVIEWINPUT_CONTACTTNAME, value[0]);
		appiumUtil.driver.scrollToExact("电话");
		appiumUtil.pause(2);
		appiumUtil.typeContent(ELECTRONICINVOICE_WBNVIEWINPUT_TELEPNONE, value[1]);
		appiumUtil.driver.scrollToExact("企业名称");
		appiumUtil.pause(3);
		appiumUtil.typeContent(ELECTRONICINVOICE_WBNVIEWINPUT_COMPANYNAME, value[2]);
		appiumUtil.driver.scrollToExact("企业开票主体数量（税号数量）");
		appiumUtil.pause(3);
		appiumUtil.typeContent(ELECTRONICINVOICE_WBNVIEWINPUT_TARIFFNUM, value[3]);
		appiumUtil.driver.scrollToExact("企业年开票数量");
		appiumUtil.pause(3);
		appiumUtil.typeContent(ELECTRONICINVOICE_WBNVIEWINPUT_INVOICENUM, value[4]);
		appiumUtil.driver.scrollToExact("确认提交");
		appiumUtil.pause(3);
		appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_LOCATION, ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_VALUE).click();
		appiumUtil.pause(3);
	}*/
	
	public static boolean  verifySubmitResult(AppiumUtil appiumUtil){
		return appiumUtil.getText(ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT).contains("成功");
		
	}
	
	public static void   backToHomePage(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.click(ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME);
		appiumUtil.pause(2);
//		switchNative(appiumUtil);
		appiumUtil.waitForElementToLoad(10, HomePage.HOMEPAGE_TEXTVIEW_CITY);
		Assertion.assertTrue(appiumUtil.doesElementsExist(HomePage.HOMEPAGE_TEXTVIEW_CITY),"经检查：未成功返回主页");
		
	}
	
}
