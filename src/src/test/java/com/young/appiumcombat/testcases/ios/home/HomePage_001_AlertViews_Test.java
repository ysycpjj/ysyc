package com.young.appiumcombat.testcases.ios.home;
import java.util.Map;
import org.testng.annotations.Test;
import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.ios.AlertViewPage;
import com.young.appiumcombat.pages.ios.HomePage;
import com.young.appiumcombat.pageshelper.ios.AlertViewPageHelper;
import com.young.appiumcombat.pageshelper.ios.HomePageHelper;
/**
 * @author young
 * @description 点击Alert Views，然后在新界面上点击Okay / Cancel，弹窗上点击OK按钮。
 * */

public class HomePage_001_AlertViews_Test extends BasePrepare {
	
	@Test(dataProvider="testData")
	public void alertViews(Map<String,String> data){
		//点击Alert Views
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_LABEL_ALERTVIEWS);
		//点击Okay / Cancel
		AlertViewPageHelper.clickOnAlertViewPage(appiumUtil, AlertViewPage.AVP_LABEL_OKORCANCEL);
		//在Alert界面点击OK按钮
		AlertViewPageHelper.handleAlert(appiumUtil,data.get("ALERTOPTION"));
	}

}
