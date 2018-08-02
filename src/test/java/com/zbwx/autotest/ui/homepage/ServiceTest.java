package com.zbwx.autotest.ui.homepage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.utils.Assertion;
/**
 * 
 * @author zbwx
 * @date 2018年7月31日
 * 首页客服测试
 */
public class ServiceTest extends TestBaseCase{

	@BeforeClass
	public void beforeclass() throws Exception{
		driver.startUiAutomator();
		Thread.sleep(3000);
	}
	
	@Test(description = "客服中心贴心小助手")
	public void testServiceCentreZhuShou() throws Exception{
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("交易规则", "进入客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		mHomePageService1.mServicesBanner.click();;
		
		if (position.waitForElement(ElementAttribs.TEXT, "发送", 3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/tx_back"));
		}
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		mReturnHomePage();
	}
	
	@Test(description = "客服中心交易规则")
	public void testServiceCentreGuiZe() throws Exception{
				
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Assertion.VerityTextPresentPrecision("客服中心", "当前客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		device.click(mHomePageService1.mKeFuGuiZe);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "交易规则", 3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		mReturnHomePage();
	}
	@Test(description = "客服中心找回密码")
	public void testServiceCentreFindMiMa() throws Exception{
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Assertion.VerityTextPresentPrecision("客服中心", "当前客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		device.click(mHomePageService1.mPassWordFind);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "找回登录密码", 3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn"));
		}
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		mReturnHomePage();
	}
	@Test(description = "客服中心购物攻略")
	public void testServiceCentreGongLue() throws Exception{		
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Assertion.VerityTextPresentPrecision("客服中心", "当前客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		for (int i = 0; i < 3; i++) {
			device.click(mHomePageService1.mHelpGuide1);
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		HomePageService mHomePageService2 = new HomePageService();
		if (position.waitForElement(ElementAttribs.TEXT, "入门攻略", 3000)) {
			device.click(mHomePageService2.mHelpGuideHuangJin_1);
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "入门攻略", 3000)) {
			device.click(mHomePageService2.mKeFuBack);
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "新手常见问题", 3000)) {
			device.click(mHomePageService2.mHelpGuideHuangJin_2);			
		}
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("新手常见问题", "进入新手常见问题页面....");
		HomePageService mHomePageService6 = new HomePageService();
		device.click(mHomePageService6.mKeFuBack);
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		device.click(mHomePageService1.mHelpGuide1);
		mReturnHomePage();
	}
	
	@Test(description = "客服中心基本面分析")
	public void testServiceCentreJiBenFenXi() throws Exception{
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Assertion.VerityTextPresentPrecision("客服中心", "当前客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		for (int i = 0; i < 3; i++) {
			device.click(mHomePageService1.mHelpGuide6);
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		HomePageService homePageService2 = new HomePageService();
		homePageService2.keFuSecondaryListJB();
		device.click(homePageService2.mHelpGuideJiBen_1);
		Assertion.VerityTextPresentPrecision("基本面分析简介", "进入基本面分析简介页面");
		Thread.sleep(3000);
		mClickReturnButton();
		Thread.sleep(3000);
		homePageService2.keFuSecondaryListJB();
		device.click(homePageService2.mHelpGuideJiBen_2);
		Thread.sleep(3000);
		mClickReturnButton();
		homePageService2.keFuSecondaryListJB();
		device.click(homePageService2.mHelpGuideJiBen_3);
		Thread.sleep(3000);
		mClickReturnButton();
		homePageService2.keFuSecondaryListJB();
		device.click(homePageService2.mHelpGuideJiBen_4);
		Thread.sleep(3000);
		mClickReturnButton();
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		homePageService2.keFuSecondaryListJB();
		device.click(mHomePageService1.mHelpGuide6);
		mReturnHomePage();
	}
	@Test(description = "客服中心技术分析")
	public void testServiceCentreJiShuFenXi() throws Exception{
		HomePageService mHomePageService = new HomePageService();
		mHomePageService.kefuClick();
		Assertion.VerityTextPresentPrecision("客服中心", "当前客服中心页面");
		HomePageService mHomePageService1 = new HomePageService();
		for (int i = 0; i < 3; i++) {
			device.click(mHomePageService1.mHelpGuide7);
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		HomePageService homePageService2 = new HomePageService();
		homePageService2.keFuSecondaryListJS();
		device.click(homePageService2.mHelpGuideJiShu_1);
		Assertion.VerityTextPresentPrecision("技术分析", "进入技术分析简介页面");
		Thread.sleep(3000);
		mClickReturnButton();
		Thread.sleep(3000);
		homePageService2.keFuSecondaryListJS();
		device.click(homePageService2.mHelpGuideJiShu_2);
		Thread.sleep(3000);
		mClickReturnButton();
		Thread.sleep(3000);
		homePageService2.keFuSecondaryListJS();
		device.click(homePageService2.mHelpGuideJiShu_3);
		Thread.sleep(3000);
		mClickReturnButton();		
		Assertion.VerityTextPresentPrecision("客服中心", "返回客服中心页面");
		homePageService2.keFuSecondaryListJS();
		device.click(mHomePageService1.mHelpGuide7);
		mReturnHomePage();
	}
	@AfterClass
	public void afterClassResult() {
		
	}
}
