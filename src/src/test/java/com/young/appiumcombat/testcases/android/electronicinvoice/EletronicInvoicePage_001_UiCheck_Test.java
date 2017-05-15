package com.young.appiumcombat.testcases.android.electronicinvoice;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.ElectronicInvoice;
import com.young.appiumcombat.pages.android.HomePage;
import com.young.appiumcombat.utils.Assertion;


public class EletronicInvoicePage_001_UiCheck_Test extends BasePrepare{
	
	@Test
	public void Case_001_intoEletronicInvoicePage(){
		HomePage.intoElectronicInvoice(appiumUtil);
//		Assertion.assertTrue(ElectronicInvoice.isInElectronicInvoicePage(appiumUtil), "经检查：未成功进入电子发票页面");
		ElectronicInvoice.switchWebView(appiumUtil);
	}
	
	@Test(dependsOnMethods ="Case_001_intoEletronicInvoicePage" ,alwaysRun = false)
	public void Case_002_EletronicInvoicePageUiCheck(){
		ElectronicInvoice.introducePageUICheck(appiumUtil);
		assert Assertion.flag;
	}
	@Test(dependsOnMethods ="Case_001_intoEletronicInvoicePage" ,alwaysRun = false)
	public void Case_003_EnableElectronicInvoice(){
		String[] value={"测试联系人", "13333333333", "测试公司", "1", "100"};
//		ElectronicInvoice.enableElectronicInvoice(appiumUtil, value);
		Assertion.assertTrue(ElectronicInvoice.verifySubmitResult(appiumUtil), "经检查：提交申请失败"); 
		assert Assertion.flag;
	}
	@Test(dependsOnMethods = "Case_003_EnableElectronicInvoice",alwaysRun = false)
	public void Case_004_BackToHomePage(){
		ElectronicInvoice.backToHomePage(appiumUtil);
		assert Assertion.flag;
	}
	
	
	
	

}
