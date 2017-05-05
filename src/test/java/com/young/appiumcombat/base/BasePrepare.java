package com.young.appiumcombat.base;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.ExcelDataProvider;
import com.young.appiumcombat.utils.LogConfiguration;
import com.young.appiumcombat.utils.SelectDriver;
import com.young.appiumcombat.utils.PropertiesDataProvider;


/**
 * @author young
 * @description 启动和结束测试，以及数据提供者，提供测试数据
 * */
public class BasePrepare {
	protected AppiumDriver<WebElement> driver;
	protected AppiumUtil appiumUtil;
	public static Logger logger = Logger.getLogger(BasePrepare.class);
	protected String platformName;
	protected int elementTimeOut;
	/* 以上几个属性为iOS和Android 共有的属性，以下两个为Android独有的 */
	protected String appFilePath;
	protected String appPackage;
	/*以下属性为ios特有属性*/
	protected String iosAppPath;
	
	
	
	@BeforeClass
	public void initTest(ITestContext context) {
		// 使log4j的配置生效，以便输出日志
		LogConfiguration.initLog(this.getClass().getSimpleName());
		// 获取platform、appFilePath、appPackage的值，这个值是从testng的配置文件获取的
		platformName = context.getCurrentXmlTest().getParameter("platformName");
		switch (platformName) {
		case "iOS":
			iosAppPath = context.getCurrentXmlTest().getParameter("iosAppPath");
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
			break;
		case "Android":
			appFilePath = context.getCurrentXmlTest().getParameter(
					"appFilePath");
			appPackage = context.getCurrentXmlTest().getParameter("appPackage");
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
			break;
		default:
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
		}

		appiumUtil = new AppiumUtil();
		// 调用SelectDriver类的selectDriver方法，生成driver对象
		driver = new SelectDriver().selectDriver(context, appiumUtil);

	}

	@AfterClass
	public void clenTest() {
		if (driver != null) {
			switch(platformName){
			case "iOS":
				String x =iosAppPath.substring(iosAppPath.lastIndexOf("/")+1, iosAppPath.lastIndexOf("."));
				System.out.println("----------"+x);
				appiumUtil.closeApp(iosAppPath.substring(iosAppPath.lastIndexOf("/")+1, iosAppPath.lastIndexOf("."))) ;
				break;
			case "Android":
				appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath,
						appPackage));// appium模式
				break;
			default:
				appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath,
						appPackage));// appium模式
				break;
			}
			driver.quit(); //selendroid 模式
		} else {
			Assert.fail("driver没有获得对象,退出操作失败");
		}
		
/*		if (driver != null) {
			appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath,
					appPackage));// appium模式
			 driver.quit(); //selendroid 模式
		} else {
			Assert.fail("driver没有获得对象,退出操作失败");

		}*/
	}
	

	
	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {
			/**这里的calssName原始值大概是这样的：com.young.appiumcombat.testcases.login.LoginPage_001_loginError_Test
			 * 那么下面这段代码className.substring(33, className.lastIndexOf("."))是什么意思？substring方法参数有两个
			 * 一个开始位置，一个结束位置，33表示这个字符串的第33个位置，这个位置当前字符是l,className.lastIndexOf(".")表示返回这字符串最后一个.所在
			 * 的位置，它是38，那么className.substring(33, className.lastIndexOf("."))可以转换成：className.substring(33, 38)，最终取得的值是login，
			 * 也就是moduleName的值
			 * 修改如下：该代码即取倒数第二个.到倒数第一个.直接的字符串，先将className截取，截取位置为：开头到倒数第一个.,不包含. ,讲截取下来的字符串找最后.的位置，
			 * 加一即为开始的位置，结束的位置机位倒数第一个点的位置
			 * 
			 * */
			
			moduleName = className.substring(className.substring(0,className.lastIndexOf(".")).lastIndexOf(".")+1, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			//这个分析方法和moduleName的分析方法一样
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum,platformName);
	}


}
