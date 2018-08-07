package com.zbwx.autotest.ui.homepage;

import java.util.ArrayList;

import com.zbwx.autotest.ui.base.BaseTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.HomePage1;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.remote.PageFactory;

public class HomePageTest1 extends BaseTest {
    

	
	@BeforeClass
	public void beforeclass() throws Exception{
	
		Thread.sleep(3000);
	}
	
	@Test(description = "点击我的")
	public void testHomePageService() throws Exception{
		HomePage1 mHomePage1 = new HomePage1();
		Thread.sleep(3000);
//		PageFactory.initElements(mHomePage1, driver);
		mHomePage1.my.click();
		Thread.sleep(3000);
//		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
//		HomePage mHomePage2 = new HomePage();
//		BaseAction.device.click(mHomePage2.img_homeService);
//		
//		Thread.sleep(3000);
//		
//		if (BaseAction.position.waitForElement(ElementAttribs.TEXT, "交易规则",3000)) {
//			ElementAdb mServiceBack = BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn");
//			BaseAction.device.click(mServiceBack);
//			
//		}
	
		
	}
	
	
	@AfterClass
	public void afterClassResult() {
		
	}
}
